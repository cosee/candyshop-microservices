package biz.cosee.repository;

import biz.cosee.entity.CandyChangeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kroehan on 26.11.15.
 */
@Repository
public interface CandyChangeEventRepository extends JpaRepository<CandyChangeEvent, Long> {

    public List<CandyChangeEvent> findByIdGreaterThan(long id);
}
