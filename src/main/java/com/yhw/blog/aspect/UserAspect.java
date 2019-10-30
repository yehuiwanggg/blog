package com.yhw.blog.aspect;

import com.yhw.blog.entity.ActionLog;
import com.yhw.blog.service.ActionLogService;
import com.yhw.blog.service.UserService;
import com.yhw.blog.util.ActionMethod;
import com.yhw.blog.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Author yhw
 */
@Aspect
@Component
@Slf4j
public class UserAspect {
    @Autowired
    ActionLogService actionLogService;
    @Autowired
    UserService userService;

    @Pointcut("execution(public * com.yhw.blog.controller.*.*(..)))")
    public void action(){}
    @Pointcut("execution(public * com.yhw.blog.controller.UserController.login(..)))")
    public void login(){}
    @Pointcut("execution(public * com.yhw.blog.controller.UserController.loginout(..)))")
    public void loginOut(){}
    @Pointcut("execution(public * com.yhw.blog.controller.UserController.register(..)))")
    public void register(){}
    @Pointcut("execution(public * com.yhw.blog.controller.BlogController.getBlog(..)))")
    public void getBlog(){}
    @Pointcut("action()&&!register()&&!login()&&!getBlog()")
    public void checklogin(){}
    @Around("checklogin()")
    public Object actionBefore(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("测试control前");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        HttpSession session=request.getSession(true);
        System.out.println(session.getAttribute("user"));
        if (session.getAttribute("user") == null) {
            return new ResponseData(2003,"当前未登录");
        }
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        return joinPoint.proceed();
    }
    @AfterReturning(returning = "result",pointcut = "action()")
    public void doAfterReturn(JoinPoint joinPoint,Object result){
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getName());
        log.info("AfterReturning"+result.toString());


        ActionLog actionLog=new ActionLog();
        if (result!=null){
            ResponseData responseData=(ResponseData) result;
            if (responseData.getUserid()==null){
                return;
            }
            actionLog.setUserid(responseData.getUserid());
            if (joinPoint.getSignature().getName().equals(ActionMethod.LOGIN)){
                actionLog.setAction("用户登录");
                actionLogService.insertLog(actionLog);
//                userService.loginlog(responseData.getUserid());
            }
            if (joinPoint.getSignature().getName().equals(ActionMethod.REGISTER)){
                actionLog.setAction("用户注册");
                actionLogService.insertLog(actionLog);
            }
            if (joinPoint.getSignature().getName().equals(ActionMethod.LOGINOUT)){
                actionLog.setAction("用户登出");
                actionLogService.insertLog(actionLog);
            }
        }

    }
    @After("action()")
    public void actionAfter(){
        log.info("测试control后");
    }
}
