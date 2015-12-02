package biz.cosee.api.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by kroehan on 26.11.15.
 */
@Getter
@Setter
public class SubmittedOrder {

    private String username;
    private long candyId;
    private long amount;
}
