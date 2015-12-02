package biz.cosee.api;

import biz.cosee.entity.Candy;
import biz.cosee.service.CandyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by kroehan on 26.11.15.
 */
@RestController
@RequestMapping("/candies")
public class CandyController {

    private static Logger LOGGER = LoggerFactory.getLogger(CandyController.class);

    private CandyService candyService;

    @Autowired
    public CandyController(CandyService candyService) {
        this.candyService = candyService;

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Candy> get() {
        return candyService.getAllCandy();
    }

    @RequestMapping(value = "/{candyId}", method = RequestMethod.GET)
    public Candy get(@PathVariable("candyId") long candyId) {
        return candyService.getCandyById(candyId);
    }

    @RequestMapping(value = "/{candyId}", method = RequestMethod.PUT)
    public void get(@PathVariable("candyId") long candyId, @PathParam("stockAmount") long stockAmount) {
        candyService.updateCandyStockAmount(candyId, stockAmount);
    }




}
