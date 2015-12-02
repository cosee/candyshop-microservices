package biz.cosee.talks.service;

import biz.cosee.talks.entity.Candy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class OrderService {

    @Value("${candyshop.orderserviceurl}")
    private String orderserviceurl;

    public class Event {
        long id;
        long candy_id;
        String type;
    }

    interface OrderServiceClient {
        @GET("/events/candychangeevents")
        List<Event> getEvents(@Query("version") long version);

        @GET("/candies/{candyId}")
        Candy getCandy(@Path("candyId") long candyId);
    }

    protected OrderServiceClient client;

    @PostConstruct
    protected void initOrderServiceClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(orderserviceurl)
                .setRequestInterceptor(requestFacade -> requestFacade.addHeader("Authorization", "Basic YWRtaW46YWRtaW4="))
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .build();

        client = restAdapter.create(OrderServiceClient.class);
    }


}
