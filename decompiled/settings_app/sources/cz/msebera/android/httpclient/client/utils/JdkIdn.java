package cz.msebera.android.httpclient.client.utils;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class JdkIdn implements Idn {
    private final Method toUnicode;

    public JdkIdn() throws ClassNotFoundException {
        this.toUnicode = Class.forName("java.net.IDN").getMethod("toUnicode", new Class[]{String.class});     // Catch: NoSuchMethodException -> L5 SecurityException -> L8
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e.getMessage(), e);
    L8:
        e = move-exception;
        throw new IllegalStateException(e.getMessage(), e);
    }

    @Override // cz.msebera.android.httpclient.client.utils.Idn
    public String toUnicode(String r3) {
        return (String) this.toUnicode.invoke(null, new Object[]{r3});
    L7:
        e = move-exception;
        throw new IllegalStateException(e.getMessage(), e);
    L4:
        e = move-exception;
        Throwable r2 = e.getCause();
        throw new RuntimeException(r2.getMessage(), r2);
    }
}
