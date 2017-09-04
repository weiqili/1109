package exception.controller;

import exception.exceptions.BusinessException;
import exception.exceptions.SystemException;
import exception.handler.BusinessExceptionHandler;
import exception.handler.IExceptionHandler;
import exception.handler.SystemExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandleController {
    private static final IExceptionHandler businessExceptionHandler = new BusinessExceptionHandler();
    private static final IExceptionHandler systemExceptionHandler = new SystemExceptionHandler();

    /**
     * 处理系统级异常，返回页面
     * @param e
     * @return
     */
    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public String catchSystemException(SystemException e) {
        String exceptionMessage = "";
        Annotation anno = null;
        String annoName = "";

        try {
            anno = e.getClass().getAnnotations()[0];
            annoName = anno.toString();
        } catch (Exception e1) {
            // 没有配置紧急程度等异常
            // 执行默认操作
            Runnable runnable = () -> {

            };
        }
        // TODO: to be optmized
        if (annoName.contains("ExceptionLevel1")) {
            exceptionMessage += systemExceptionHandler.handleLevel1(e);
        } else if (annoName.contains("ExceptionLevel2")) {
            exceptionMessage += systemExceptionHandler.handleLevel2(e);
        } else if (annoName.contains("ExceptionLevel3")) {
            exceptionMessage += systemExceptionHandler.handleLevel3(e);
        }

        exceptionMessage += e.toString();

        return exceptionMessage;
    }

    /**
     * 处理业务及异常，返回 json
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Map<String, Object> catchBusinessException(BusinessException e) {
        Map<String, Object> exceptionMessage = new HashMap<>(1);
        String ret_code = "0";
        String message = "";

        Annotation anno = null;
        String annoName = "";

        try {
            anno = e.getClass().getAnnotations()[0];
            annoName = anno.toString();
        } catch (Exception e1) {
            // 没有配置紧急程度等异常
            // 执行默认操作
        }
        // TODO: to be optmized
        if (annoName.contains("ExceptionLevel1")) {
            ret_code = "40001";
            message += businessExceptionHandler.handleLevel1(e);
        } else if (annoName.contains("ExceptionLevel2")) {
            ret_code = "40002";
            message += businessExceptionHandler.handleLevel2(e);
        } else if (annoName.contains("ExceptionLevel3")) {
            ret_code = "40003";
            message += businessExceptionHandler.handleLevel3(e);
        }

        message += e.toString();

        exceptionMessage.put("ret_code", ret_code);
        exceptionMessage.put("message", message);

        return exceptionMessage;
    }
}
