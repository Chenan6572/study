package cn.stylefeng.guns.modular.system.transfer;

public class A {
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    private  String name;
    private  int age;
    private  String sex;
    private  String tel;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getTel() {
        return tel;
    }
}
