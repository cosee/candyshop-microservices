package biz.cosee.service;

import biz.cosee.entity.UserReplica;
import biz.cosee.repository.UserReplicaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by kroehan on 26.11.15.
 */
@Service
public class UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

        @Value("${candyshop.userserviceurl}")
        private String userserviceurl;

        private long version = 0;

    private UserReplicaRepository userReplicaRepository;

    @Autowired
    public UserService(UserReplicaRepository userReplicaRepository) {
        this.userReplicaRepository = userReplicaRepository;
    }

    public class Event {
            long id;
            long userId;
            String type;
        }

        interface OrderServiceClient {
            @GET("/events/userchangeevents")
            List<Event> getUserChangeEvents(@Query("version") String version);

            @GET("/users/{userId}")
            UserReplica getUser(@Path("userId") long userId);
        }

        protected OrderServiceClient client;

        @PostConstruct
        protected void initOrderServiceClient() {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(userserviceurl)
                    .setRequestInterceptor(requestFacade -> requestFacade.addHeader("Authorization", "Basic YWRtaW46YWRtaW4="))
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setLog(new RestAdapter.Log() {
                        @Override
                        public void log(String message) {
                            LOGGER.info(message);
                        }
                    })
                    .build();

            client = restAdapter.create(OrderServiceClient.class);
        }


    public void collectUserChangeEvents() {
        List<Event> userChangeEvents = client.getUserChangeEvents(String.valueOf(version));
        for (Event userChangeEvent : userChangeEvents) {
            UserReplica user = client.getUser(userChangeEvent.userId);
            userReplicaRepository.save(user);
            version = userChangeEvent.id;
        }
    }

}
