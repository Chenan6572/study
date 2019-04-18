package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.guns.modular.system.transfer.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/test")
    @ResponseBody
    public void test(Person person){
        System.out.println(person.toString());
    }
}
