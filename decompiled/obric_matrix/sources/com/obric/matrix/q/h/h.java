package com.obric.matrix.q.h;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/base/system/PackageChangeManager;", "", "()V", "packageChangeListenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/matrix/base/system/PackageChangeListener;", "addPackageChangeListener", "", LocationMonitorConst.TAG, "packageChangeListener", "notifyPackageChangeEvent", "packageAction", "Lcom/obric/matrix/base/system/PackageAction;", "packageName", "removePackageChangeListener", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f9880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, g> f9881b = null;

    static {
        f9880a = new h();
        f9881b = new ConcurrentHashMap();
    }

    private h() {
    }

    public final void a(String r1, g r2) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, "packageChangeListener");
        f9881b.put(r1, r2);
    }

    public final void b(e r2, String r3) {
        o.f(r2, "packageAction");
        o.f(r3, "packageName");
        Iterator<Map.Entry<String, g>> r1 = f9881b.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getValue().a(r2, r3);
        goto L4
    }
}
