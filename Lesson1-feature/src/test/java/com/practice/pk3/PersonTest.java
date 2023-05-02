package com.practice.pk3;

import org.junit.Test;

public class PersonTest {

    @Test
    public void test01() {
        Person person = new Person("Lisa", 20);
        SomeService someService = new SomeService();
        boolean flag = someService.isEligible(person);
        System.out.println("flag = " + flag);
    }

    @Test
    public void test() {
        int age = 50;
        String age1;
        switch(age / 10) {
            case 0:
            case 1:
                age1 = "青壯年";
                break;
            case 2:
                age1 = "壯年";
                break;
            case 3:
            case 4:
                age1 = "中年";
                break;
            default:
                age1 = "老年";
        }
        System.out.println("使用 switch case 判斷式：" + age1);
    }
}