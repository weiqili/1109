                                                        @ExceptionAnno
                                ------------------------BaseException---------------------------
                                |                            |                                 |
                系统异常，返回错误页面                       业务异常，返回 json                 其他顶级异常
                  SystemException                          BusinessException                
                  |             |                           |
@ExceptionLevel1               未配置，默认处理              @ExceptionLevel1
ApplicationException           InessentialException         PaymentException

@ExceptionLevel1, @ExceptionLevel2, @ExceptionLevel3 为配置异常紧急程度