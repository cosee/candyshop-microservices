package biz.cosee.api;

import biz.cosee.entity.UserChangeEvent;
import biz.cosee.repository.UserChangeEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("events/userchangeevents")
public class UserChangeEventController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserChangeEventController.class);

    private UserChangeEventRepository candyUserEventRepository;

    @Autowired
    public UserChangeEventController(UserChangeEventRepository candyUserEventRepository) {
        this.candyUserEventRepository = candyUserEventRepository;

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserChangeEvent> get(@RequestParam(name = "version", defaultValue = "0") long version) {
        return candyUserEventRepository.findByIdGreaterThan(version);
    }

}
