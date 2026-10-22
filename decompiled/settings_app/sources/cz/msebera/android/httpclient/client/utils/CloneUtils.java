package cz.msebera.android.httpclient.client.utils;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public class CloneUtils {
    public static <T> T cloneObject(T r4) throws CloneNotSupportedException {
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof Cloneable) == false) goto L25;
        Class[] r3 = (Class[]) null;     // Catch: NoSuchMethodException -> L21
        Object[] r2 = (Object[]) null;     // Catch: IllegalAccessException -> L11 InvocationTargetException -> L14
        return (T) r4.getClass().getMethod("clone", null).invoke(r4, null);
    L11:
        e = move-exception;
        throw new IllegalAccessError(e.getMessage());
    L14:
        e = move-exception;
        Throwable r5 = e.getCause();
        if ((r5 instanceof CloneNotSupportedException) == false) goto L20;
        throw ((CloneNotSupportedException) r5);
    L20:
        throw new Error("Unexpected exception", r5);
    L21:
        e = move-exception;
        throw new NoSuchMethodError(e.getMessage());
    L25:
        throw new CloneNotSupportedException();
    }

    public static Object clone(Object r0) throws CloneNotSupportedException {
        return cloneObject(r0);
    }

    private CloneUtils() {
    }
}
