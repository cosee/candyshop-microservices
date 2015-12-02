package biz.cosee.api;

import biz.cosee.entity.User;
import biz.cosee.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> get() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User get(@PathVariable("userId") long userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User get(@PathParam("username") String username) {
        return userService.createNewUser(username);
    }

}
