package biz.cosee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kroehan on 26.11.15.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candy_order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "candy_name")
    private String candyName;
    @Column(name = "price")
    private long price;
    @Column(name = "amount")
    private long amount;

}
