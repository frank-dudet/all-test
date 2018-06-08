package com.cn.frank.test.mock;

import org.junit.Test;

import static org.easymock.EasyMock.*;

/**
 * Author: frank_du
 * Time : 2018/6/8 下午4:05
 */
public class TestMock {

    @Test
    public void testMockHelloService() {
        HelloService obj = createMock(HelloService.class);

        expect(obj.sayHello("z3")).andReturn("hello l4");

        replay(obj);

        String actual = obj.sayHello("z3");

        System.out.println(actual);

        verify(obj);
    }

}
