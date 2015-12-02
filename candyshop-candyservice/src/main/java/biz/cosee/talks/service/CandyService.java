package biz.cosee.talks.service;

import biz.cosee.talks.entity.Candy;
import biz.cosee.talks.repository.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandyService {

    private final CandyRepository candyRepository;

    private OrderService orderService;

    @Autowired
    public CandyService(CandyRepository candyRepository,
                        OrderService orderService) {
        this.candyRepository = candyRepository;
        this.orderService = orderService;
    }

    private long version = 0;

    @Scheduled(initialDelay = 1000, fixedDelay = 10000)
    @Transactional
    public void updateCandies() {
        List<OrderService.Event> events = orderService.client.getEvents(version);

        events.stream().forEach(event -> {
            if (event.type.equals("CREATED")) {
                Candy candy = orderService.client.getCandy(event.candy_id);
                candyRepository.save(candy);
            } else if (event.type.equals("UPDATED")) {
                Candy candy = orderService.client.getCandy(event.candy_id);

                candyRepository.delete(event.candy_id);

                candyRepository.save(candy);
            }
            version = event.id;
        });
    }

    public Iterable<Candy> getAllCandies() {
        return candyRepository.findAll();
    }
}
