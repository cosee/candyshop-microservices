package biz.cosee.entity;

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
@Table(name="user")
public class User {


    public User(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "username", unique = true)
    private String username;

}
