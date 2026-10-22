package com.obric.capabilitykit.k;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/logger/DefaultLogger;", "Lcom/obric/capabilitykit/logger/ILogger;", "()V", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "i", "isDebug", "", BaseSwitches.V, "w", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8154a = null;

    static {
        f8154a = new a();
    }

    private a() {
    }

    @Override // com.obric.capabilitykit.k.b
    public void a(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        Log.d(r1, String.valueOf(r2));
    }

    @Override // com.obric.capabilitykit.k.b
    public void b(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        Log.i(r1, String.valueOf(r2));
    }

    @Override // com.obric.capabilitykit.k.b
    public void c(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        Log.e(r1, String.valueOf(r2));
    }

    @Override // com.obric.capabilitykit.k.b
    public void d(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        Log.w(r1, String.valueOf(r2));
    }

    @Override // com.obric.capabilitykit.k.b
    public void e(String r1, String r2, Throwable r3) {
        o.f(r1, LocationMonitorConst.TAG);
        Log.e(r1, String.valueOf(r2), r3);
    }

    @Override // com.obric.capabilitykit.k.b
    public boolean isDebug() {
        return false;
    }
}
