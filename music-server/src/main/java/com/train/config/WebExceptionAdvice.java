package com.train.config;

import cn.hutool.core.util.StrUtil;
import com.train.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器 会把返回结果返回给前端
@Slf4j
@RestControllerAdvice
public class WebExceptionAdvice {

    @ExceptionHandler(RuntimeException.class)
    public R handleRuntimeException(RuntimeException e) {
        log.error(e.toString(), e);
        String errMsg = StrUtil.isNotBlank(e.getMessage()) ? e.getMessage() : "服务器异常";
        return R.fatal(errMsg);
    }
}
