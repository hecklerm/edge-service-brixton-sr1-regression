# edge-service-brixton-sr1-regression

## To get stack trace

* Config server using https://github.com/hecklerm/LOTE_ConfigService and pointing to https://github.com/hecklerm/bootiful-microservices-config
* Eureka server using https://github.com/hecklerm/LOTE_EurekaService
* Backing service (quote-service) using https://github.com/hecklerm/quote-service-brixton-sr1-regression
* Accessing the edge-service in your browser at http://localhost:8086/quote (which uses the defined Zuul route in the properties file for the edge-service to route to a local forward, to the /quotorama endpoint) produces the following stack trace (plus a bit for context):

~~~~

2016-06-14 22:11:12.737  INFO [edge-service,54489d0bc1f1cbd0,54489d0bc1f1cbd0,true] 2080 --- [nio-8086-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/user/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
2016-06-14 22:11:12.737  INFO [edge-service,54489d0bc1f1cbd0,54489d0bc1f1cbd0,true] 2080 --- [nio-8086-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/quote/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
2016-06-14 22:11:12.737  INFO [edge-service,54489d0bc1f1cbd0,54489d0bc1f1cbd0,true] 2080 --- [nio-8086-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/qs/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
2016-06-14 22:11:12.737  INFO [edge-service,54489d0bc1f1cbd0,54489d0bc1f1cbd0,true] 2080 --- [nio-8086-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/quote-service/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
2016-06-14 22:11:12.761 ERROR [edge-service,54489d0bc1f1cbd0,54489d0bc1f1cbd0,true] 2080 --- [nio-8086-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet dispatcherServlet threw exception

java.lang.IllegalArgumentException: No matching constant for [0]
	at org.springframework.http.HttpStatus.valueOf(HttpStatus.java:488) ~[spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.cloud.sleuth.instrument.web.TraceFilter.httpStatusSuccessful(TraceFilter.java:219) [spring-cloud-sleuth-core-1.0.1.RELEASE.jar:1.0.1.RELEASE]
	at org.springframework.cloud.sleuth.instrument.web.TraceFilter.doFilter(TraceFilter.java:140) [spring-cloud-sleuth-core-1.0.1.RELEASE.jar:1.0.1.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationDispatcher.invoke(ApplicationDispatcher.java:720) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationDispatcher.processRequest(ApplicationDispatcher.java:466) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationDispatcher.doForward(ApplicationDispatcher.java:391) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationDispatcher.forward(ApplicationDispatcher.java:318) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.cloud.netflix.zuul.filters.route.SendForwardFilter.run(SendForwardFilter.java:59) [spring-cloud-netflix-core-1.1.2.RELEASE.jar:1.1.2.RELEASE]
	at com.netflix.zuul.ZuulFilter.runFilter(ZuulFilter.java:112) [zuul-core-1.1.0.jar:1.1.0]
	at com.netflix.zuul.FilterProcessor.processZuulFilter(FilterProcessor.java:197) [zuul-core-1.1.0.jar:1.1.0]
	at com.netflix.zuul.FilterProcessor.runFilters(FilterProcessor.java:161) [zuul-core-1.1.0.jar:1.1.0]
	at com.netflix.zuul.FilterProcessor.route(FilterProcessor.java:120) [zuul-core-1.1.0.jar:1.1.0]
	at com.netflix.zuul.ZuulRunner.route(ZuulRunner.java:96) [zuul-core-1.1.0.jar:1.1.0]
	at com.netflix.zuul.http.ZuulServlet.route(ZuulServlet.java:116) [zuul-core-1.1.0.jar:1.1.0]
	at com.netflix.zuul.http.ZuulServlet.service(ZuulServlet.java:81) [zuul-core-1.1.0.jar:1.1.0]
	at org.springframework.web.servlet.mvc.ServletWrappingController.handleRequestInternal(ServletWrappingController.java:158) [spring-webmvc-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.cloud.netflix.zuul.web.ZuulController.handleRequestInternal(ZuulController.java:43) [spring-cloud-netflix-core-1.1.2.RELEASE.jar:1.1.2.RELEASE]
	at org.springframework.web.servlet.mvc.AbstractController.handleRequest(AbstractController.java:147) [spring-webmvc-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter.handle(SimpleControllerHandlerAdapter.java:50) [spring-webmvc-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:961) [spring-webmvc-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:895) [spring-webmvc-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:967) [spring-webmvc-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:858) [spring-webmvc-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:622) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:843) [spring-webmvc-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:729) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:292) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52) [tomcat-embed-websocket-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.boot.actuate.autoconfigure.EndpointWebMvcAutoConfiguration$ApplicationContextHeaderFilter.doFilterInternal(EndpointWebMvcAutoConfiguration.java:261) [spring-boot-actuator-1.3.5.RELEASE.jar:1.3.5.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.cloud.sleuth.instrument.web.TraceFilter.doFilter(TraceFilter.java:161) [spring-cloud-sleuth-core-1.0.1.RELEASE.jar:1.0.1.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.boot.actuate.trace.WebRequestTraceFilter.doFilterInternal(WebRequestTraceFilter.java:115) [spring-boot-actuator-1.3.5.RELEASE.jar:1.3.5.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:87) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:77) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:121) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.springframework.boot.actuate.autoconfigure.MetricsFilter.doFilterInternal(MetricsFilter.java:103) [spring-boot-actuator-1.3.5.RELEASE.jar:1.3.5.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.2.6.RELEASE.jar:4.2.6.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:212) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:106) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:502) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:141) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:79) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:88) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:522) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1095) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:672) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1502) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.run(NioEndpoint.java:1458) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_77]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_77]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-8.0.33.jar:8.0.33]
	at java.lang.Thread.run(Thread.java:745) [na:1.8.0_77]

2016-06-14 22:11:12.766  WARN [edge-service,,88e0c8f719f13b2b,true] 2080 --- [nio-8086-exec-1] o.s.cloud.sleuth.util.ExceptionUtils     : Tried to close span but it is not the current span: [Trace: 54489d0bc1f1cbd0, Span: 54489d0bc1f1cbd0, Parent: null, exportable:true].  You may have forgotten to close or detach [Trace: 54489d0bc1f1cbd0, Span: 88e0c8f719f13b2b, Parent: 54489d0bc1f1cbd0, exportable:true]

~~~~

## To eliminate stack trace

* Change Brixton.SR1 in pom spring-cloud-dependencies to Brixton.RELEASE & rebuild
