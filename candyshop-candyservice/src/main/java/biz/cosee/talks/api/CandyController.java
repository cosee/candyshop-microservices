package biz.cosee.talks.api;

import biz.cosee.talks.entity.Candy;
import biz.cosee.talks.service.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandyController {

    private final CandyService candyService;

    @Autowired
    public CandyController(CandyService candyService) {
        this.candyService = candyService;
    }

    @RequestMapping(value = "/candies")
    public Iterable<Candy> getCandies() {
        return candyService.getAllCandies();
    }
}
