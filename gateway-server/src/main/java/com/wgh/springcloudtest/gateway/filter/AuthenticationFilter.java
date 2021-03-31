package com.wgh.springcloudtest.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 身份检验过滤器
 *
 * Zuul 的核心技术就是过滤器，该框架提供了 ZuulFilter 接口让开发者可以自定义过滤规则。
 *
 * Created by wgh on 2021/3/30.
 */

@Component
public class AuthenticationFilter extends ZuulFilter {

    /**
     * 是否开启过滤
     */
    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        boolean flag = request.getRequestURI().contains("/login");
        // 如果是登录请求不进行过滤
        if (flag) {
            System.out.println("========不执行 zuul 过滤方法=======");
        } else {
            System.out.println("========执行 zuul 过滤方法=======");
        }
        return !flag;
    }

    /**
     * 过滤器执行内容
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        // 此处模拟获取数据库或缓存中的 token
        String dbToken = "123456";
        // 此处简单检验 token
        if (token == null || "".equals(token) || !dbToken.equals(token)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }

        return null;
    }

    /**
     * 过滤器类型
     *
     * filterType 有 4 种类型
     *
     * pre： 这种过滤器在请求被路由之前调用。
     *      我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
     * routing：这种过滤器将请求路由到微服务。
     *          这种过滤器用于构建发送给微服务的请求，并使用 Apache HttpClient 或 Netfilx Ribbon 请求微服务。
     * post：这种过滤器在路由到微服务以后执行。
     *       这种过滤器可用来为响应添加标准的 HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
     * error：在其他阶段发生错误时执行该过滤器。
     *
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }
}
