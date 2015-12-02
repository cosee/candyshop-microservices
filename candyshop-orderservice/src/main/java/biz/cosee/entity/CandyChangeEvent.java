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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candy_change_event")
public class CandyChangeEvent {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "candy_id")
    private Long candy_id;
    @Column(name = "type")
    private String type;

}
