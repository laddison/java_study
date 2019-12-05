package cn.emam.study.repository;

import cn.emam.study.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 人类Repository
 * @author LiQiuShui
 */
@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
}
