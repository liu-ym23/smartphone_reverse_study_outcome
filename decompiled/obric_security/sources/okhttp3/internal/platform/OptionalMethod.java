package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
class OptionalMethod<T> {
    private final String methodName;
    private final Class[] methodParams;
    private final Class<?> returnType;

    OptionalMethod(Class<?> r1, String r2, Class... r3) {
        this.returnType = r1;
        this.methodName = r2;
        this.methodParams = r3;
    }

    public boolean isSupported(T r1) {
        if (getMethod(r1.getClass()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Object invokeOptional(T r2, Object... r3) throws InvocationTargetException {
        Method r1 = getMethod(r2.getClass());
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.invoke(r2, r3);
    L7:
        return null;
    }

    public Object invokeOptionalWithoutCheckedException(T r1, Object... r2) {
        return invokeOptional(r1, r2);
    L4:
        e = move-exception;
        Throwable r0 = e.getTargetException();
        if ((r0 instanceof RuntimeException) == true) goto L8;
        AssertionError r3 = new AssertionError("Unexpected exception");
        r3.initCause(r0);
        throw r3;
    L8:
        throw ((RuntimeException) r0);
    }

    public Object invoke(T r3, Object... r4) throws InvocationTargetException {
        Method r0 = getMethod(r3.getClass());
        if (r0 == null) goto L10;
        return r0.invoke(r3, r4);
    L6:
        e = move-exception;
        AssertionError r5 = new AssertionError("Unexpectedly could not call: " + r0);
        r5.initCause(e);
        throw r5;
    L10:
        throw new AssertionError("Method " + this.methodName + " not supported for object " + r3);
    }

    public Object invokeWithoutCheckedException(T r1, Object... r2) {
        return invoke(r1, r2);
    L4:
        e = move-exception;
        Throwable r0 = e.getTargetException();
        if ((r0 instanceof RuntimeException) == true) goto L8;
        AssertionError r3 = new AssertionError("Unexpected exception");
        r3.initCause(r0);
        throw r3;
    L8:
        throw ((RuntimeException) r0);
    }

    private Method getMethod(Class<?> r4) {
        String r0 = this.methodName;
        if (r0 == null) goto L13;
        Method r5 = getPublicMethod(r4, r0, this.methodParams);
        if (r5 == null) goto L12;
        Class<?> r3 = this.returnType;
        if (r3 == null) goto L12;
        if (r3.isAssignableFrom(r5.getReturnType()) == true) goto L12;
        return null;
    L12:
        return r5;
    L13:
        return null;
    }

    private static Method getPublicMethod(Class<?> r1, String r2, Class[] r3) {
        Method r4 = r1.getMethod(r2, r3);     // Catch: NoSuchMethodException -> L11
        if ((r4.getModifiers() & 1) != 0) goto L9;
        return null;
    L9:
        return r4;
    L17:
        return null;
    }
}
