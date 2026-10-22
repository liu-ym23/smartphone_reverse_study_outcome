package y3;

import android.util.LruCache;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import xc.d;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache f23236b = null;

    static {
        f23235a = new a();
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r10 = (e) yc.a.a(e.class, "default_bid");
        if (r10 == null) goto L9;
        d r11 = (d) r10.a(d.class);
        if (r11 == null) goto L9;
        Integer r12 = r11.Y();
        if (r12 == null) goto L9;
        int r13 = r12.intValue();
    L10:
        f23236b = new LruCache(r13);
        return;
    L9:
        r13 = 5;
        goto L10
    }

    public final synchronized void a(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "sessionId");     // Catch: Throwable -> L9
        if (f23236b.get(r5) != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        throw new ClassCastException();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
