package tmsdk.fg.creator;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public final class ManagerCreatorF {
    private static volatile ManagerCreatorF d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap f66a;
    private HashMap b;
    private Context c;

    static {
    }

    private ManagerCreatorF(Context r2) {
        this.f66a = new HashMap();
        this.b = new HashMap();
        this.c = r2.getApplicationContext();
    }

    private BaseManagerF a(Class r4) {
        if (r4 == null) goto L26;
        monitor-enter(r4);
        BaseManagerF r0 = (BaseManagerF) r4.cast(this.f66a.get(r4));     // Catch: Throwable -> L22
        if (r0 != null) goto L9;
        WeakReference r1 = (WeakReference) this.b.get(r4);     // Catch: Throwable -> L22
        if (r1 == null) goto L9;
        r0 = (BaseManagerF) r4.cast(r1.get());     // Catch: Throwable -> L22
    L9:
        if (r0 == null) goto L28;
    L20:
        monitor-exit(r4);     // Catch: Throwable -> L22
        return r0;
    L28:
        r0 = (BaseManagerF) r4.newInstance();     // Catch: Exception -> L17 Throwable -> L22
        r0.onCreate(this.c);     // Catch: Exception -> L17 Throwable -> L22
        if (r0.getSingletonType() != 1) goto L14;
        this.f66a.put(r4, r0);     // Catch: Exception -> L17 Throwable -> L22
    L27:
    L14:
        if (r0.getSingletonType() != 0) goto L27;
        this.b.put(r4, new WeakReference(r0));     // Catch: Exception -> L17 Throwable -> L22
    L17:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L26:
        throw new NullPointerException("the param of getManager can't be null.");
    }

    public static <T extends BaseManagerF> T getManager(Class<T> r1) {
        return (T) a().a(r1);
    }

    static ManagerCreatorF a() {
        if (d != null) goto L15;
        monitor-enter(ManagerCreatorF.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new ManagerCreatorF(TMSDKContext.getApplicaionContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(ManagerCreatorF.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }
}
