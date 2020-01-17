package cn.emam.unifyexception.repository;

import cn.emam.unifyexception.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 人类Repository
 * @author LiQiuShui
 */
@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
}
