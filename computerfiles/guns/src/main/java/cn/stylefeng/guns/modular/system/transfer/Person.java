package cn.stylefeng.guns.modular.system.transfer;

import java.util.List;

public class Person {
    private String name;
    private  int age;
    private  String sex;
    private Phone phone;



    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
//    private List<Phone> phone;
//    public List<Phone> getPhone() {
//        return phone;
//    }
//    public void setPhone(List<Phone> phone) {
//        this.phone = phone;
//    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone=" + phone +
                '}';
    }

}
