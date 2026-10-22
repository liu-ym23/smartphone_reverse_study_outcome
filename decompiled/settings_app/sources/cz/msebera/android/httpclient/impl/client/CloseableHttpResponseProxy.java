package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
class CloseableHttpResponseProxy implements InvocationHandler {
    private static final Constructor<?> CONSTRUCTOR = null;
    private final HttpResponse original;

    static {
        CONSTRUCTOR = Proxy.getProxyClass(CloseableHttpResponseProxy.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}).getConstructor(new Class[]{InvocationHandler.class});     // Catch: NoSuchMethodException -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    CloseableHttpResponseProxy(HttpResponse r1) {
        this.original = r1;
    }

    public void close() throws IOException {
        EntityUtils.consume(this.original.getEntity());
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r2, Method r3, Object[] r4) throws Throwable {
        if (r3.getName().equals("close") == false) goto L13;
        close();
        return null;
    L13:
        return r3.invoke(this.original, r4);
    L8:
        e = move-exception;
        Throwable r5 = e.getCause();
        if (r5 == null) goto L12;
        throw r5;
    L12:
        throw e;
    }

    public static CloseableHttpResponse newProxy(HttpResponse r3) {
        return (CloseableHttpResponse) CONSTRUCTOR.newInstance(new Object[]{new CloseableHttpResponseProxy(r3)});
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    L10:
        e = move-exception;
        throw new IllegalStateException(e);
    L7:
        e = move-exception;
        throw new IllegalStateException(e);
    }
}
