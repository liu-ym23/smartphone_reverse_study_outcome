package cz.msebera.android.httpclient.impl.bootstrap;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.ExceptionLogger;
import cz.msebera.android.httpclient.HttpConnectionFactory;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.impl.DefaultBHttpServerConnection;
import cz.msebera.android.httpclient.impl.DefaultBHttpServerConnectionFactory;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
import cz.msebera.android.httpclient.protocol.HttpExpectationVerifier;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpProcessorBuilder;
import cz.msebera.android.httpclient.protocol.HttpRequestHandler;
import cz.msebera.android.httpclient.protocol.HttpRequestHandlerMapper;
import cz.msebera.android.httpclient.protocol.HttpService;
import cz.msebera.android.httpclient.protocol.ResponseConnControl;
import cz.msebera.android.httpclient.protocol.ResponseContent;
import cz.msebera.android.httpclient.protocol.ResponseDate;
import cz.msebera.android.httpclient.protocol.ResponseServer;
import cz.msebera.android.httpclient.protocol.UriHttpRequestHandlerMapper;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes5.dex */
public class ServerBootstrap {
    private ConnectionReuseStrategy connStrategy;
    private ConnectionConfig connectionConfig;
    private HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
    private ExceptionLogger exceptionLogger;
    private HttpExpectationVerifier expectationVerifier;
    private Map<String, HttpRequestHandler> handlerMap;
    private HttpRequestHandlerMapper handlerMapper;
    private HttpProcessor httpProcessor;
    private int listenerPort;
    private InetAddress localAddress;
    private LinkedList<HttpRequestInterceptor> requestFirst;
    private LinkedList<HttpRequestInterceptor> requestLast;
    private HttpResponseFactory responseFactory;
    private LinkedList<HttpResponseInterceptor> responseFirst;
    private LinkedList<HttpResponseInterceptor> responseLast;
    private String serverInfo;
    private ServerSocketFactory serverSocketFactory;
    private SocketConfig socketConfig;
    private SSLContext sslContext;
    private SSLServerSetupHandler sslSetupHandler;

    private ServerBootstrap() {
    }

    public static ServerBootstrap bootstrap() {
        return new ServerBootstrap();
    }

    public final ServerBootstrap setListenerPort(int r1) {
        this.listenerPort = r1;
        return this;
    }

    public final ServerBootstrap setLocalAddress(InetAddress r1) {
        this.localAddress = r1;
        return this;
    }

    public final ServerBootstrap setSocketConfig(SocketConfig r1) {
        this.socketConfig = r1;
        return this;
    }

    public final ServerBootstrap setConnectionConfig(ConnectionConfig r1) {
        this.connectionConfig = r1;
        return this;
    }

    public final ServerBootstrap setHttpProcessor(HttpProcessor r1) {
        this.httpProcessor = r1;
        return this;
    }

    public final ServerBootstrap addInterceptorFirst(HttpResponseInterceptor r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.responseFirst != null) goto L7;
        this.responseFirst = new LinkedList();
    L7:
        this.responseFirst.addFirst(r2);
        return this;
    }

    public final ServerBootstrap addInterceptorLast(HttpResponseInterceptor r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.responseLast != null) goto L7;
        this.responseLast = new LinkedList();
    L7:
        this.responseLast.addLast(r2);
        return this;
    }

    public final ServerBootstrap addInterceptorFirst(HttpRequestInterceptor r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.requestFirst != null) goto L7;
        this.requestFirst = new LinkedList();
    L7:
        this.requestFirst.addFirst(r2);
        return this;
    }

    public final ServerBootstrap addInterceptorLast(HttpRequestInterceptor r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.requestLast != null) goto L7;
        this.requestLast = new LinkedList();
    L7:
        this.requestLast.addLast(r2);
        return this;
    }

    public final ServerBootstrap setServerInfo(String r1) {
        this.serverInfo = r1;
        return this;
    }

    public final ServerBootstrap setConnectionReuseStrategy(ConnectionReuseStrategy r1) {
        this.connStrategy = r1;
        return this;
    }

    public final ServerBootstrap setResponseFactory(HttpResponseFactory r1) {
        this.responseFactory = r1;
        return this;
    }

    public final ServerBootstrap setHandlerMapper(HttpRequestHandlerMapper r1) {
        this.handlerMapper = r1;
        return this;
    }

    public final ServerBootstrap registerHandler(String r2, HttpRequestHandler r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L9;
        if (this.handlerMap != null) goto L8;
        this.handlerMap = new HashMap();
    L8:
        this.handlerMap.put(r2, r3);
    L9:
        return this;
    }

    public final ServerBootstrap setExpectationVerifier(HttpExpectationVerifier r1) {
        this.expectationVerifier = r1;
        return this;
    }

    public final ServerBootstrap setConnectionFactory(HttpConnectionFactory<? extends DefaultBHttpServerConnection> r1) {
        this.connectionFactory = r1;
        return this;
    }

    public final ServerBootstrap setSslSetupHandler(SSLServerSetupHandler r1) {
        this.sslSetupHandler = r1;
        return this;
    }

    public final ServerBootstrap setServerSocketFactory(ServerSocketFactory r1) {
        this.serverSocketFactory = r1;
        return this;
    }

    public final ServerBootstrap setSslContext(SSLContext r1) {
        this.sslContext = r1;
        return this;
    }

    public final ServerBootstrap setExceptionLogger(ExceptionLogger r1) {
        this.exceptionLogger = r1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [cz.msebera.android.httpclient.protocol.HttpRequestHandlerMapper] */
    /* JADX WARN: Type inference failed for: r1v24, types: [cz.msebera.android.httpclient.protocol.UriHttpRequestHandlerMapper] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r7v0, types: [cz.msebera.android.httpclient.protocol.HttpRequestHandlerMapper] */
    public HttpServer create() {
        HttpProcessor r1 = this.httpProcessor;
        if (r1 != null) goto L32;
        HttpProcessorBuilder r2 = HttpProcessorBuilder.create();
        LinkedList<HttpRequestInterceptor> r3 = this.requestFirst;
        if (r3 == null) goto L10;
        Iterator<HttpRequestInterceptor> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r2.addFirst(r4.next());
    L10:
        LinkedList<HttpResponseInterceptor> r5 = this.responseFirst;
        if (r5 == null) goto L16;
        Iterator<HttpResponseInterceptor> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        r2.addFirst(r6.next());
    L16:
        String r7 = this.serverInfo;
        if (r7 != null) goto L19;
        r7 = "Apache-HttpCore/1.1";
    L19:
        r2.addAll(new HttpResponseInterceptor[]{new ResponseDate(), new ResponseServer(r7), new ResponseContent(), new ResponseConnControl()});
        LinkedList<HttpRequestInterceptor> r8 = this.requestLast;
        if (r8 == null) goto L25;
        Iterator<HttpRequestInterceptor> r9 = r8.iterator();
    L23:
        if (r9.hasNext() == false) goto L25;
        r2.addLast(r9.next());
    L25:
        LinkedList<HttpResponseInterceptor> r10 = this.responseLast;
        if (r10 == null) goto L31;
        Iterator<HttpResponseInterceptor> r11 = r10.iterator();
    L29:
        if (r11.hasNext() == false) goto L31;
        r2.addLast(r11.next());
    L31:
        r1 = r2.build();
    L32:
        HttpProcessor r12 = r1;
        ?? r13 = this.handlerMapper;
        if (r13 != 0) goto L40;
        r13 = new UriHttpRequestHandlerMapper();
        Map<String, HttpRequestHandler> r14 = this.handlerMap;
        if (r14 == null) goto L40;
        Iterator<Map.Entry<String, HttpRequestHandler>> r15 = r14.entrySet().iterator();
    L38:
        if (r15.hasNext() == false) goto L40;
        Map.Entry<String, HttpRequestHandler> r16 = r15.next();
        r13.register(r16.getKey(), r16.getValue());
    L40:
        ?? r17 = r13;
        ConnectionReuseStrategy r18 = this.connStrategy;
        if (r18 != null) goto L43;
        r18 = DefaultConnectionReuseStrategy.INSTANCE;
    L43:
        ConnectionReuseStrategy r19 = r18;
        HttpResponseFactory r20 = this.responseFactory;
        if (r20 != null) goto L46;
        r20 = DefaultHttpResponseFactory.INSTANCE;
    L46:
        HttpService r110 = new HttpService(r12, r19, r20, r17, this.expectationVerifier);
        ServerSocketFactory r21 = this.serverSocketFactory;
        if (r21 != null) goto L52;
        SSLContext r22 = this.sslContext;
        if (r22 == null) goto L51;
        r21 = r22.getServerSocketFactory();
        goto L52
    L51:
        r21 = ServerSocketFactory.getDefault();
    L52:
        ServerSocketFactory r111 = r21;
        HttpConnectionFactory r23 = this.connectionFactory;
        if (r23 == null) goto L55;
    L58:
        HttpConnectionFactory r112 = r23;
        ExceptionLogger r24 = this.exceptionLogger;
        if (r24 != null) goto L61;
        r24 = ExceptionLogger.NO_OP;
    L61:
        ExceptionLogger r113 = r24;
        int r25 = this.listenerPort;
        if (r25 <= 0) goto L64;
        int r26 = r25;
    L65:
        InetAddress r114 = this.localAddress;
        SocketConfig r27 = this.socketConfig;
        if (r27 != null) goto L70;
        r27 = SocketConfig.DEFAULT;
    L70:
        return new HttpServer(r26, r114, r27, r111, r110, r112, this.sslSetupHandler, r113);
    L64:
        r26 = 0;
        goto L65
    L55:
        if (this.connectionConfig == null) goto L57;
        r23 = new DefaultBHttpServerConnectionFactory(this.connectionConfig);
        goto L58
    L57:
        r23 = DefaultBHttpServerConnectionFactory.INSTANCE;
        goto L58
    }
}
