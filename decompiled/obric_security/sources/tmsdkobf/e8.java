package tmsdkobf;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public class e8 implements LocationListener {
    public static final s0 c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b[] f173a;
    public volatile int b;

    public class a extends s0 {
        public a() {
        }

        @Override // tmsdkobf.s0
        public Object a() {
            return new e8();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f174a;
        public String b;

        public b() {
        }
    }

    static {
        c = new a();
    }

    public e8() {
        this.f173a = new b[3];
        this.b = 0;
    }

    public String a() {
        StringBuilder r0 = new StringBuilder();
        b[] r1 = this.f173a;
        monitor-enter(r1);
        int r2 = this.b;     // Catch: Throwable -> L19
    L5:
        b r3 = this.f173a[this.b];     // Catch: Throwable -> L19
        if (r3 == null) goto L13;
        if (r0.length() <= 0) goto L11;
        r0.append(",");     // Catch: Throwable -> L19
    L11:
        r0.append(r3.f174a).append(":").append(r3.b);     // Catch: Throwable -> L19
        r2 = (r2 + 1) % this.f173a.length;     // Catch: Throwable -> L19
        if (r2 != this.b) goto L5;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L19
        if (r0.length() > 0) goto L27;
        return null;
    L27:
        return r0.toString();
    L19:
        th = move-exception;
        throw th;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String r1) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String r1) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String r1, int r2, Bundle r3) {
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isFromMockProvider() == true) goto L7;
        return;
    L7:
        b[] r0 = this.f173a;
        monitor-enter(r0);
        b r1 = this.f173a[this.b];     // Catch: Throwable -> L15
        if (r1 != null) goto L12;
        r1 = new b();     // Catch: Throwable -> L15
        this.f173a[this.b] = r1;     // Catch: Throwable -> L15
    L12:
        this.b = (this.b + 1) % this.f173a.length;     // Catch: Throwable -> L15
        r1.f174a = System.currentTimeMillis();     // Catch: Throwable -> L15
        r1.b = r5.getProvider();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
