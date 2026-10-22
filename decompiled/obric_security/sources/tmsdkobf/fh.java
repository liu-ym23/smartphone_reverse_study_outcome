package tmsdkobf;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public abstract class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f204a;
    public static Method b;

    public static boolean a() {
        String[] r0 = {"L"};
        Object r1 = f204a;
        if (r1 == null) goto L14;
        Method r3 = b;
        if (r3 != null) goto L12;
        return false;
    L12:
        r3.invoke(r1, new Object[]{r0});     // Catch: Throwable -> L11
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    static {
        Method r0 = Class.class.getDeclaredMethod("forName", new Class[]{String.class});     // Catch: Throwable -> L4
        Method r1 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Throwable -> L4
        Class r2 = (Class) r0.invoke(null, new Object[]{"dalvik.system.VMRuntime"});     // Catch: Throwable -> L4
        Method r3 = (Method) r1.invoke(r2, new Object[]{"getRuntime", null});     // Catch: Throwable -> L4
        b = (Method) r1.invoke(r2, new Object[]{"setHiddenApiExemptions", new Class[]{String[].class}});     // Catch: Throwable -> L4
        f204a = r3.invoke(null, new Object[0]);     // Catch: Throwable -> L4
        return;
    }
}
