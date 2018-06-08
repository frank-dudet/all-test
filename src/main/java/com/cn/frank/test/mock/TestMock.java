package com.cn.frank.test.mock;

import com.cn.frank.test.bean.User;
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

        User user = new User();
        user.setUsername("User1");
        user.setPassword("test");

        expect(obj.helloUser(user)).andReturn(new User("hhh", "test")).times(2);

        replay(obj);

        String actual = obj.sayHello("z3");

        User result = obj.helloUser(user);
        User result2 = obj.helloUser(user);

        System.out.println(actual);

        System.out.println(result);
        System.out.println(result2);

        verify(obj);
    }

}
