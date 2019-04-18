package cn.stylefeng.guns.modular.api;

import cn.stylefeng.guns.modular.system.transfer.A;
import cn.stylefeng.guns.modular.system.transfer.B;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import static org.junit.Assert.*;

public class ApiAgritainmentControllerTest {

    @Test
    public void update() {

            A a = new A();
            B b = new B();
            b.setAge(12);
            b.setName("朱民全");
            b.setSex("女");
            BeanUtils.copyProperties(b, a);
            System.out.print(a.toString());

    }
}