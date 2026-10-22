package tmsdk.common.creator;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public final class ManagerCreatorC {
    private static volatile ManagerCreatorC e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap f42a;
    private HashMap b;
    private Context c;
    private final Object d;

    static {
    }

    private ManagerCreatorC(Context r2) {
        this.f42a = new HashMap();
        this.b = new HashMap();
        this.d = new Object();
        this.c = r2.getApplicationContext();
    }

    private BaseManagerC a(Class r5) {
        if (r5 == null) goto L27;
        Object r0 = this.d;
        monitor-enter(r0);
        BaseManagerC r1 = (BaseManagerC) r5.cast(this.f42a.get(r5));     // Catch: Throwable -> L23
        if (r1 != null) goto L10;
        WeakReference r2 = (WeakReference) this.b.get(r5);     // Catch: Throwable -> L23
        if (r2 == null) goto L10;
        r1 = (BaseManagerC) r5.cast(r2.get());     // Catch: Throwable -> L23
    L10:
        if (r1 == null) goto L30;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r1;
    L30:
        r1 = (BaseManagerC) r5.newInstance();     // Catch: Exception -> L18 Throwable -> L23
        r1.onCreate(this.c);     // Catch: Exception -> L18 Throwable -> L23
        if (r1.getSingletonType() != 1) goto L15;
        this.f42a.put(r5, r1);     // Catch: Exception -> L18 Throwable -> L23
    L29:
    L15:
        if (r1.getSingletonType() != 0) goto L29;
        this.b.put(r5, new WeakReference(r1));     // Catch: Exception -> L18 Throwable -> L23
    L18:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L27:
        throw new NullPointerException("the param of getManager can't be null.");
    }

    public static <T extends BaseManagerC> T getManager(Class<T> r1) {
        return (T) a().a(r1);
    }

    static ManagerCreatorC a() {
        if (e != null) goto L15;
        monitor-enter(ManagerCreatorC.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new ManagerCreatorC(TMSDKContext.getApplicaionContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(ManagerCreatorC.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }
}
