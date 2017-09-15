package exception.controller;

import exception.exceptions.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    @RequestMapping("/hello1")
    public String hello() {

        return "hello1";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        int a = 1 / 0;

        return "hello2";
    }

    @RequestMapping("/hello3")
    public String hello3() throws SystemException {

        throw new ApplicationException("aaaa");
    }

    @RequestMapping("/hello4")
    public String hello4() throws BusinessException {

        throw new PaymentException("bbbbb");
    }

    @RequestMapping("/hello5")
    public String hello5() throws SystemException {

        throw new InessentialException("bbbb");
    }
}
