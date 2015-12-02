package biz.cosee.repository;

import biz.cosee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kroehan on 26.11.15.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
