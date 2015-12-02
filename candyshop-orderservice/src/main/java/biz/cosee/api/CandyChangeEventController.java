package biz.cosee.api;

import biz.cosee.entity.CandyChangeEvent;
import biz.cosee.repository.CandyChangeEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kroehan on 26.11.15.
 */
@RestController
@RequestMapping("/events/candychangeevents")
public class CandyChangeEventController {

    private CandyChangeEventRepository candyChangeEventRepository;

    @Autowired
    public CandyChangeEventController(CandyChangeEventRepository candyChangeEventRepository) {
        this.candyChangeEventRepository = candyChangeEventRepository;

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CandyChangeEvent> get(@RequestParam(name = "version", defaultValue = "0") long version) {
        return candyChangeEventRepository.findByIdGreaterThan(version);
    }

}
