package com.rephilo.luandun.aspect;

import com.google.common.base.Stopwatch;
import com.rephilo.luandun.model.vo.BaseTimeVO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 记录时间拦截器实现
 *
 * @author rephilo
 */
@Aspect
@Component
public class CountDownAspect implements Ordered {

    /**
     * 拦截器执行顺序
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }

    @Pointcut("@annotation(com.rephilo.luandun.annotation.CountDown)")
    private void countDown() {
    }

    @Around("countDown()")
    public Object countUseTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //记录开始时间
        Stopwatch stopwatch = Stopwatch.createStarted();
        //执行操作
        Object obj = proceedingJoinPoint.proceed();

        stopwatch.stop();
        //设置消耗时间
        if (obj instanceof BaseTimeVO) {
            ((BaseTimeVO) obj).setTime(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }

        return obj;
    }
}
