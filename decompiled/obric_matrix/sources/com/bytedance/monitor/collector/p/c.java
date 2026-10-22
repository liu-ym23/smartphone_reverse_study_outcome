package com.bytedance.monitor.collector.p;

import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Field f5226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Field f5227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Field f5228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Field f5229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Field f5230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Field f5231k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5236e;

    public c(String r1, int r2, long r3, String r5) {
        this.f5232a = r1;
        this.f5233b = r2;
        this.f5234c = r3;
        this.f5235d = r5;
        this.f5236e = Thread.currentThread().getName();
    }

    public static c a(Message r14) {
        switch(r14.what) {
            case 114: goto L37;
            case 115: goto L30;
            case 116: goto L28;
            case 117: goto L48;
            case 118: goto L48;
            case 119: goto L48;
            case 120: goto L48;
            case 121: goto L21;
            case 122: goto L14;
            case 123: goto L7;
            default: goto L48;
        };
    L48:
        throw new IllegalArgumentException("message.what = " + r14.what + " is not excepted!");     // Catch: Throwable -> L51
    L7:
        if (f5231k != null) goto L9;
        f5231k = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L9:
        IBinder r0 = (IBinder) f5231k.get(r14.obj);     // Catch: Throwable -> L51
        if (r0 == null) goto L50;
        return new c(d.c().d(r0), r14.what, System.currentTimeMillis(), r0.toString());
    L14:
        if (f5230j != null) goto L16;
        f5230j = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L16:
        IBinder r1 = (IBinder) f5230j.get(r14.obj);     // Catch: Throwable -> L51
        if (r1 == null) goto L50;
        return new c(d.c().d(r1), r14.what, System.currentTimeMillis(), r1.toString());
    L21:
        if (f5229i != null) goto L23;
        f5229i = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L23:
        IBinder r2 = (IBinder) f5229i.get(r14.obj);     // Catch: Throwable -> L51
        if (r2 == null) goto L50;
        return new c(d.c().d(r2), r14.what, System.currentTimeMillis(), r2.toString());
    L28:
        return new c(d.c().d((IBinder) r14.obj), r14.what, System.currentTimeMillis(), r14.obj.toString());
    L30:
        if (f5228h != null) goto L32;
        f5228h = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L32:
        IBinder r3 = (IBinder) f5228h.get(r14.obj);     // Catch: Throwable -> L51
        if (r3 == null) goto L50;
        return new c(d.c().d(r3), r14.what, System.currentTimeMillis(), r3.toString());
    L37:
        if (f5226f != null) goto L40;
        f5226f = a.a(r14.obj.getClass(), LocationMonitorConst.INFO);     // Catch: Throwable -> L51
    L40:
        if (f5227g != null) goto L42;
        f5227g = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L42:
        ServiceInfo r4 = (ServiceInfo) f5226f.get(r14.obj);     // Catch: Throwable -> L51
        String r5 = null;
        if (r4 == null) goto L46;
        r5 = r4.name;     // Catch: Throwable -> L51
    L46:
        return new c(r5, r14.what, System.currentTimeMillis(), f5227g.get(r14.obj).toString());
    L50:
        return new c("unknow", r14.what, System.currentTimeMillis(), "unknow");
    }

    public String toString() {
        return "ServiceFollowBean{mServiceName='" + this.f5232a + "', mWhat=" + this.f5233b + ", mTimeStamp=" + this.f5234c + ", mToken='" + this.f5235d + "', mThreadName='" + this.f5236e + "'}";
    }
}
