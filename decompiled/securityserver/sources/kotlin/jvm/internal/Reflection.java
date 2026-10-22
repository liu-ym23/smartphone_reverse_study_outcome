package kotlin.jvm.internal;

import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public class Reflection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReflectionFactory f343a = null;
    public static final KClass[] b = null;

    static {
        ReflectionFactory r0 = null;
        r0 = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();     // Catch: Throwable -> L10
    L5:
        if (r0 != null) goto L8;
        r0 = new ReflectionFactory();
    L8:
        f343a = r0;
        b = new KClass[0];
    }

    public static ClassReference a(Class r1) {
        f343a.getClass();
        return new ClassReference(r1);
    }
}
