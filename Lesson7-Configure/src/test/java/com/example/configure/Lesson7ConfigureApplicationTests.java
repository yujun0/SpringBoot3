package com.example.configure;

import com.example.configure.pk1.SomeService;
import com.example.configure.pk2.ReadConfig;
import com.example.configure.pk3.MultiConfigService;
import com.example.configure.pk4.AppBean;
import com.example.configure.pk6.NestAppBean;
import com.example.configure.pk6.Security;
import com.example.configure.pk8.CollectionConfig;
import com.example.configure.pk9.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson7ConfigureApplicationTests {

    @Autowired
    private SomeService someService;

    @Test
    void test() {
        someService.printValue();
    }

    @Autowired
    private ReadConfig readConfig;

    @Test
    void test1() {
        readConfig.print();
    }

    @Autowired
    private MultiConfigService multiConfigService;

    @Test
    void test2() {
        multiConfigService.print();
    }

    @Autowired
    private AppBean appBean;

    @Test
    void test5() {
        System.out.println("appBean: " + appBean.toString());
        System.out.println("appBean.class: " + appBean.getClass());
    }

    @Autowired
    private NestAppBean nestAppBean;

    @Test
    void test6() {
        System.out.println("nestAppBean: " + nestAppBean.toString());
        System.out.println("appBean.class: " + nestAppBean.getClass());
    }

    @Autowired
    private Security security;

    @Test
    void test7() {
        System.out.println("security: " + security);
    }

    @Autowired
    private CollectionConfig collectionConfig;

    @Test
    void test8() {
        System.out.println("CollectionConfig: " + collectionConfig);
    }

    @Autowired
    private Group group;

    @Test
    void test9() {
        System.out.println("group: " + group);
    }
}
