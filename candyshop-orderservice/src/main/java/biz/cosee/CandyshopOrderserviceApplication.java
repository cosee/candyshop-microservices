package biz.cosee;

import biz.cosee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class CandyshopOrderserviceApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(CandyshopOrderserviceApplication.class, args);
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 1000)
    public void getUserUpdates() {
        userService.collectUserChangeEvents();
    }
}
