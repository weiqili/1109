package exception.handler;

import exception.exceptions.BaseException;

public class SystemExceptionHandler implements IExceptionHandler {

    @Override
    public String handleLevel1(BaseException be) {
        return "hello moto";
    }

    @Override
    public String handleLevel2(BaseException be) {
        return "";
    }

    @Override
    public String handleLevel3(BaseException be) {
        return "";
    }
}
