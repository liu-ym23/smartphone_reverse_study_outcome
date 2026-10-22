package t8;

import android.os.SystemProperties;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f22109a;

    public final String a() {
        return SystemProperties.get("ro.miui.ui.version.name");
    L5:
        th = move-exception;
        th.printStackTrace();
        Object r5 = b();     // Catch: IllegalArgumentException -> L9 Throwable -> L11
    L18:
        return (String) r5.getClass().getMethod("get", new Class[]{String.class}).invoke(r5, new Object[]{"ro.miui.ui.version.name"});
    L9:
        e = move-exception;
        throw e;
    L11:
        return "";
    }

    public final Object b() {
        if (this.f22109a != null) goto L19;
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f22109a == null) goto L20;
    L14:
        monitor-exit(b.class);     // Catch: Throwable -> L12
        goto L19
    L20:
        this.f22109a = Class.forName("android.os.SystemProperties").newInstance();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12
    L19:
        return this.f22109a;
    }
}
