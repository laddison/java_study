package cn.emam.unifyexception.controller;

import cn.emam.unifyexception.common.handle.ExceptionHandle;
import cn.emam.unifyexception.entity.People;
import cn.emam.unifyexception.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * people控制器
 * @author LiQiuShui
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    PeopleRepository peopleRepository;

    @PostMapping("/add")
    public People addPeople(@ModelAttribute People people) {
        if (StringUtils.isEmpty(people.getName())) {
            throw new ExceptionHandle("-1", "姓名不能为空");
        }
        return people;
    }

    @GetMapping("/people/{id}")
    public People getPeople(@PathVariable("id") Integer id) {
        //空指针异常
        String str = null;
        str.equals(id);
        return null;
    }

    @GetMapping("/info")
    public People updatePeople(@ModelAttribute People people) {
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return null;
    }

    @GetMapping("/getInfo")
    public People getPeopleInfo() {
        People one = peopleRepository.getOne(1);
        return one;
    }
}
