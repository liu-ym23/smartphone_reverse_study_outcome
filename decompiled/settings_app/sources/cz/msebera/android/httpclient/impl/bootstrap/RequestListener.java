package cz.msebera.android.httpclient.impl.bootstrap;

import cz.msebera.android.httpclient.ExceptionLogger;
import cz.msebera.android.httpclient.HttpConnectionFactory;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.protocol.HttpService;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
class RequestListener implements Runnable {
    private final HttpConnectionFactory<? extends HttpServerConnection> connectionFactory;
    private final ExceptionLogger exceptionLogger;
    private final ExecutorService executorService;
    private final HttpService httpService;
    private final ServerSocket serversocket;
    private final SocketConfig socketConfig;
    private final AtomicBoolean terminated;

    public RequestListener(SocketConfig r1, ServerSocket r2, HttpService r3, HttpConnectionFactory<? extends HttpServerConnection> r4, ExceptionLogger r5, ExecutorService r6) {
        this.socketConfig = r1;
        this.serversocket = r2;
        this.connectionFactory = r4;
        this.httpService = r3;
        this.exceptionLogger = r5;
        this.executorService = r6;
        this.terminated = new AtomicBoolean(false);
    }

    @Override // java.lang.Runnable
    public void run() {
    L20:
        if (isTerminated() == true) goto L26;
        if (Thread.interrupted() == true) goto L27;
        Socket r0 = this.serversocket.accept();     // Catch: Exception -> L17
        r0.setSoTimeout(this.socketConfig.getSoTimeout());     // Catch: Exception -> L17
        r0.setKeepAlive(this.socketConfig.isSoKeepAlive());     // Catch: Exception -> L17
        r0.setTcpNoDelay(this.socketConfig.isTcpNoDelay());     // Catch: Exception -> L17
        if (this.socketConfig.getRcvBufSize() <= 0) goto L10;
        r0.setReceiveBufferSize(this.socketConfig.getRcvBufSize());     // Catch: Exception -> L17
    L10:
        if (this.socketConfig.getSndBufSize() <= 0) goto L13;
        r0.setSendBufferSize(this.socketConfig.getSndBufSize());     // Catch: Exception -> L17
    L13:
        if (this.socketConfig.getSoLinger() < 0) goto L15;
        r0.setSoLinger(true, this.socketConfig.getSoLinger());     // Catch: Exception -> L17
    L15:
        HttpServerConnection r1 = (HttpServerConnection) this.connectionFactory.createConnection(r0);     // Catch: Exception -> L17
        Worker r2 = new Worker(this.httpService, r1, this.exceptionLogger);     // Catch: Exception -> L17
        this.executorService.execute(r2);     // Catch: Exception -> L17
        goto L20
    L27:
        return;
    L26:
        return;
    L17:
        e = move-exception;
        this.exceptionLogger.log(e);
    }

    public boolean isTerminated() {
        return this.terminated.get();
    }

    public void terminate() throws IOException {
        if (this.terminated.compareAndSet(false, true) == false) goto L6;
        this.serversocket.close();
        return;
    }
}
