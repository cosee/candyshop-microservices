package biz.cosee.service;

import biz.cosee.entity.User;
import biz.cosee.entity.UserChangeEvent;
import biz.cosee.repository.UserChangeEventRepository;
import biz.cosee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kroehan on 27.11.15.
 */
@Service
public class UserService {

    private UserRepository candyUserRepository;
    private UserChangeEventRepository userChangeEventRepository;

    @Autowired
    public UserService(UserRepository candyUserRepository, UserChangeEventRepository userChangeEventRepository) {
        this.candyUserRepository = candyUserRepository;
        this.userChangeEventRepository = userChangeEventRepository;
    }

    public List<User> getAllUsers() {
        return candyUserRepository.findAll();
    }

    public User getUserById(long userId) {
        return candyUserRepository.findOne(userId);
    }

    public User createNewUser(String username) {
        User savedUser = candyUserRepository.save(new User(username));
        userChangeEventRepository.save(new UserChangeEvent(null, savedUser.getId(), "CREATED"));
        return savedUser;
    }
}
