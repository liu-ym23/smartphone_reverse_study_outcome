package tmsdk.bg.creator;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import tmsdk.common.TMSDKContext;
import tmsdkobf.r8;

/* JADX INFO: loaded from: classes5.dex */
public final class ManagerCreatorB {
    private static volatile ManagerCreatorB d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap f36a;
    private HashMap b;
    private Context c;

    static {
    }

    private ManagerCreatorB(Context r2) {
        this.f36a = new HashMap();
        this.b = new HashMap();
        this.c = r2.getApplicationContext();
    }

    private BaseManagerB a(Class r4) {
        if (r4 == null) goto L38;
        monitor-enter(r4);
        BaseManagerB r0 = null;
        BaseManagerB r1 = (BaseManagerB) r4.cast(this.f36a.get(r4));     // Catch: Throwable -> L30
        if (r1 == null) goto L39;
    L13:
        r0 = r1;
    L14:
        if (r0 != null) goto L32;
        r1 = (BaseManagerB) r4.newInstance();     // Catch: Throwable -> L30
        r1.onCreate(this.c);     // Catch: Throwable -> L11
        if (r1.getSingletonType() != 1) goto L27;
        monitor-enter(ManagerCreatorB.class);     // Catch: Throwable -> L11
        this.f36a.put(r4, r1);     // Catch: Throwable -> L23
        monitor-exit(ManagerCreatorB.class);     // Catch: Throwable -> L23
    L29:
        r0 = r1;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = th;
        r0 = r1;
    L40:
        r8.a("ManagerCreatorB", "_getManager (Throwable)", th);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    L27:
        if (r1.getSingletonType() != 0) goto L29;
        this.b.put(r4, new WeakReference(r1));     // Catch: Throwable -> L11
    L32:
        monitor-exit(r4);     // Catch: Throwable -> L34
        return r0;
    L39:
        WeakReference r2 = (WeakReference) this.b.get(r4);     // Catch: Throwable -> L11
        if (r2 == null) goto L13;
        r0 = (BaseManagerB) r4.cast(r2.get());     // Catch: Throwable -> L11
    L30:
        th = th;
        goto L40
    L38:
        throw new NullPointerException("the param of getManager can't be null.");
    }

    private void b(Class r2) {
        monitor-enter(ManagerCreatorB.class);
        this.f36a.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(ManagerCreatorB.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void destroyManager(BaseManagerB r1) {
        if (r1 == null) goto L5;
        a().b(r1.getClass());
        return;
    }

    public static <T extends BaseManagerB> T getManager(Class<T> r1) {
        return (T) a().a(r1);
    }

    static ManagerCreatorB a() {
        if (d != null) goto L15;
        monitor-enter(ManagerCreatorB.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new ManagerCreatorB(TMSDKContext.getApplicaionContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(ManagerCreatorB.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }
}
