package biz.cosee.talks.repository;

import biz.cosee.talks.entity.Candy;
import org.springframework.data.repository.CrudRepository;

public interface CandyRepository extends CrudRepository<Candy, Long>{
}
