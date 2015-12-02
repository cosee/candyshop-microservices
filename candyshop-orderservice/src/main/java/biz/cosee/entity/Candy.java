package biz.cosee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by kroehan on 26.11.15.
 */
@Entity
@Getter
@Setter
@Table(name="candy")
public class Candy {

    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description",length = 1000)
    private String description;
    @Column(name = "price")
    private long price;
    @Column(name = "stock_amount")
    private long stockAmount;
    @Column(name = "version")
    @Version
    private long version;


}
