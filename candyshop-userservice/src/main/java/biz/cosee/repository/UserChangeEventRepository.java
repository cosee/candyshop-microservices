package biz.cosee.repository;

import biz.cosee.entity.UserChangeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kroehan on 26.11.15.
 */
@Repository
public interface UserChangeEventRepository extends JpaRepository<UserChangeEvent, Long> {

    public List<UserChangeEvent> findByIdGreaterThan(long id);
}
