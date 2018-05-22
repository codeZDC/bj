package com.tuzhi.bj.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author codeZ
 * @date 2018年4月16日 下午3:26:55
 * 
 */
/**
 * 全局异常处理器
 * 
 * @author CatalpaFlat
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
	/** 日志log */
	private static Logger log = LoggerFactory.getLogger(GlobalExceptionResolver.class);

	// 系统抛出的异常
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// handler就是处理器适配器要执行的Handler对象(只有method)
		// 解析出异常类型。
		/* 使用response返回 */
		response.setStatus(HttpStatus.OK.value()); // 设置状态码
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 设置ContentType
		response.setCharacterEncoding("UTF-8"); // 避免乱码
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		// 如果该 异常类型是系统 自定义的异常，直接取出异常信息。
		log.error("与客户端通讯异常"+(handler)+":" + ex.getMessage(), ex);
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
}