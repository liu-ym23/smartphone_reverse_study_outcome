package com.bytedance.apm.y;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f2133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f2134b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2135c = false;

    /* JADX INFO: renamed from: com.bytedance.apm.y.a$a, reason: collision with other inner class name */
    public interface InterfaceC0065a {
    }

    public interface b {
        void a();
    }

    public interface c {
        void a(InterfaceC0065a r1);
    }

    static {
    }

    public static void a(InterfaceC0065a r1) {
        c r0 = f2133a;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public static void b() {
        if (f2135c == false) goto L5;
        return;
    L5:
        b r0 = f2134b;
        if (r0 == null) goto L9;
        r0.a();
        f2135c = true;
        return;
    }
}
