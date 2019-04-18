package cn.stylefeng.guns.modular.system.transfer;

public class B {
    private  String name;
    private  int age;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
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

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    private  String sex;

}
