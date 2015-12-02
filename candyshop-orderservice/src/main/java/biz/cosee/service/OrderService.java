package biz.cosee.service;

import biz.cosee.api.model.SubmittedOrder;
import biz.cosee.entity.Candy;
import biz.cosee.entity.Order;
import biz.cosee.entity.UserReplica;
import biz.cosee.exception.CandyNotFoundException;
import biz.cosee.exception.NotEnoughStockException;
import biz.cosee.exception.UserNotFoundException;
import biz.cosee.repository.CandyRepository;
import biz.cosee.repository.OrderRepository;
import biz.cosee.repository.UserReplicaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kroehan on 26.11.15.
 */
@Service
public class OrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    private CandyRepository candyRepository;
    private OrderRepository orderRepository;
    private UserReplicaRepository userReplicaRepository;
    private CandyService candyService;

    @Autowired
    public OrderService(CandyRepository candyRepository, OrderRepository orderRepository, UserReplicaRepository userReplicaRepository, CandyService candyService) {
        this.candyRepository = candyRepository;
        this.orderRepository = orderRepository;
        this.userReplicaRepository = userReplicaRepository;
        this.candyService = candyService;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void processOrder(SubmittedOrder submittedSubmittedOrder) {
        String username = submittedSubmittedOrder.getUsername();
        long candyId = submittedSubmittedOrder.getCandyId();
        long amount = submittedSubmittedOrder.getAmount();

        UserReplica user = loadUser(username);
        Candy candy = loadCandy(candyId);
        checkStockAmount(amount, candy);

        Order order = new Order(null, user.getUsername(), candy.getName(), candy.getPrice() * amount, amount);
        orderRepository.save(order);

        candyService.updateCandyStockAmount(candyId, candy.getStockAmount() - amount);
    }

    private void checkStockAmount(long amount, Candy candy) {
        if (candy.getStockAmount() < amount) {
            throw new NotEnoughStockException("Requested " + amount + " but only " + candy.getStockAmount() + " available.");
        }
    }

    private Candy loadCandy(long candyId) {
        Candy candy = candyRepository.findOne(candyId);
        if (candy == null) {
            throw new CandyNotFoundException("Could not find candy with ID " + candyId);
        }
        return candy;
    }

    private UserReplica loadUser(String username) {
        UserReplica user = userReplicaRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("Could not find user with username " + username);
        }
        return user;
    }
}
