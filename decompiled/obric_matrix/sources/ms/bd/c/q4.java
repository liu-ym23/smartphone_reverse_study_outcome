package ms.bd.c;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class q4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile q4 f22468c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Throwable f22470b;

    private q4() {
        this.f22469a = 0;
        this.f22470b = null;
    }

    public static q4 b() {
        if (f22468c != null) goto L15;
        monitor-enter(q4.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22468c != null) goto L9;
        f22468c = new q4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(q4.class);     // Catch: Throwable -> L11
    L15:
        return f22468c;
    }

    public List<Method> a(Class r5, String r6) {
        ArrayList r4 = new ArrayList();
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return r4;
    L5:
        Method[] r7 = r5.getDeclaredMethods();
        int r0 = r7.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L14;
        Method r2 = r7[r1];
        if (r2 == null) goto L13;
        if (r2.getName().equals(r6) == false) goto L13;
        r4.add(r2);
    L13:
        r1 = r1 + 1;
        goto L6
    L14:
        return r4;
    }

    public synchronized Throwable c() {
        monitor-enter(this);
        Throwable r0 = this.f22470b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void d() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f22470b != null) goto L11;
        int r0 = this.f22469a;     // Catch: Throwable -> L13
        this.f22469a = r0 + 1;     // Catch: Throwable -> L13
        if (r0 < 30) goto L11;
        this.f22469a = 0;     // Catch: Throwable -> L13
        this.f22470b = new Throwable();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
    }
}
