package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpResponse;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
class ResponseProxyHandler implements InvocationHandler {
    private static final Method CLOSE_METHOD = null;
    private final HttpResponse original;

    static {
        CLOSE_METHOD = Closeable.class.getMethod("close", new Class[0]);     // Catch: NoSuchMethodException -> L4
        return;
    L4:
        e = move-exception;
        throw new Error(e);
    }

    ResponseProxyHandler(HttpResponse r1) {
        this.original = r1;
    }

    public void close() throws IOException {
        IOUtils.consume(this.original.getEntity());
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r1, Method r2, Object[] r3) throws Throwable {
        if (r2.equals(CLOSE_METHOD) == false) goto L13;
        close();
        return null;
    L13:
        return r2.invoke(this.original, r3);
    L8:
        e = move-exception;
        Throwable r4 = e.getCause();
        if (r4 == null) goto L12;
        throw r4;
    L12:
        throw e;
    }
}
