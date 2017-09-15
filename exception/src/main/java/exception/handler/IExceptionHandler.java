package exception.handler;

import exception.exceptions.BaseException;

public interface IExceptionHandler {
    /**
     * 处理一级异常
     * @param be 异常
     * @return 异常处理返回信息
     */
    String handleLevel1(BaseException be);

    /**
     * 处理二级异常
     * @param be 异常
     * @return 异常处理返回信息
     */
    String handleLevel2(BaseException be);

    /**
     * 处理三级异常
     * @param be 异常
     * @return 异常处理返回信息
     */
    String handleLevel3(BaseException be);
}
