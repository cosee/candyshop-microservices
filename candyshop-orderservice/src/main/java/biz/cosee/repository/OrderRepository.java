package biz.cosee.repository;

import biz.cosee.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kroehan on 26.11.15.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
