package com.obric.capabilitykit.k;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0001H\u0002J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0001J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/logger/Logger;", "Lcom/obric/capabilitykit/logger/ILogger;", "()V", "impl", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "getImpl", "i", "isDebug", "", "normalizeTag", "setLogger", "logger", BaseSwitches.V, "w", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f8156b;

    static {
        f8155a = new c();
    }

    private c() {
    }

    private final b f() {
        b r0 = f8156b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return a.f8154a;
    }

    private final String g(String r2) {
        return "ac_" + r2;
    }

    @Override // com.obric.capabilitykit.k.b
    public void a(String r2, String r3) {
        o.f(r2, LocationMonitorConst.TAG);
        if (isDebug() == true) goto L5;
        return;
    L5:
        f().a(g(r2), r3);
    }

    @Override // com.obric.capabilitykit.k.b
    public void b(String r2, String r3) {
        o.f(r2, LocationMonitorConst.TAG);
        f().b(g(r2), r3);
    }

    @Override // com.obric.capabilitykit.k.b
    public void c(String r2, String r3) {
        o.f(r2, LocationMonitorConst.TAG);
        f().c(g(r2), r3);
    }

    @Override // com.obric.capabilitykit.k.b
    public void d(String r2, String r3) {
        o.f(r2, LocationMonitorConst.TAG);
        f().d(g(r2), r3);
    }

    @Override // com.obric.capabilitykit.k.b
    public void e(String r2, String r3, Throwable r4) {
        o.f(r2, LocationMonitorConst.TAG);
        f().e(g(r2), r3, r4);
    }

    @Override // com.obric.capabilitykit.k.b
    public boolean isDebug() {
        return f().isDebug();
    }
}
