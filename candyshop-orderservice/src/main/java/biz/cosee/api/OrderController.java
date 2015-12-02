package biz.cosee.api;

import biz.cosee.api.model.SubmittedOrder;
import biz.cosee.entity.Order;
import biz.cosee.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kroehan on 26.11.15.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void orderCandy(@RequestBody SubmittedOrder submittedSubmittedOrder) {
        orderService.processOrder(submittedSubmittedOrder);
    }

    @RequestMapping(value = "", method =  RequestMethod.GET)
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

}
