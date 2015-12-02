package biz.cosee.talks.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candy")
@Data
public class Candy {

    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "stockAmount")
    private int stockAmount;
    @Column(name = "version")
    private long version;

}
