package cz.msebera.android.httpclient.impl.bootstrap;

import cz.msebera.android.httpclient.ExceptionLogger;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpCoreContext;
import cz.msebera.android.httpclient.protocol.HttpService;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
class Worker implements Runnable {
    private final HttpServerConnection conn;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpservice;

    Worker(HttpService r1, HttpServerConnection r2, ExceptionLogger r3) {
        this.httpservice = r1;
        this.conn = r2;
        this.exceptionLogger = r3;
    }

    public HttpServerConnection getConnection() {
        return this.conn;
    }

    @Override // java.lang.Runnable
    public void run() {
        BasicHttpContext r0 = new BasicHttpContext();     // Catch: Throwable -> L11 Exception -> L13
        HttpCoreContext r1 = HttpCoreContext.adapt(r0);     // Catch: Throwable -> L11 Exception -> L13
    L4:
        if (Thread.interrupted() == true) goto L8;
        if (this.conn.isOpen() == false) goto L8;
        this.httpservice.handleRequest(this.conn, r1);     // Catch: Throwable -> L11 Exception -> L13
        r0.clear();     // Catch: Throwable -> L11 Exception -> L13
    L8:
        this.conn.close();     // Catch: Throwable -> L11 Exception -> L13
        this.conn.shutdown();     // Catch: IOException -> L17
    L30:
        return;
    L13:
        e = move-exception;
        this.exceptionLogger.log(e);     // Catch: Throwable -> L11
        this.conn.shutdown();     // Catch: IOException -> L17
    L11:
        th = move-exception;
        this.conn.shutdown();     // Catch: IOException -> L22
    L24:
        throw th;
    L22:
        e = move-exception;
        this.exceptionLogger.log(e);
    L17:
        e = move-exception;
        this.exceptionLogger.log(e);
    }
}
