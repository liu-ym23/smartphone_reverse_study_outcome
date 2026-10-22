package com.obric.matrix.dataanalysis;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u000b\u0013\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0006H\u0002J\"\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00062\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010$J\u0016\u0010%\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006."}, d2 = {"Lcom/obric/matrix/dataanalysis/DeviceIdManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cachedDeviceId", "", "cachedInstallId", "dataService", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/IDataService;", "deviceInfoCallback", "com/obric/matrix/dataanalysis/DeviceIdManager$deviceInfoCallback$1", "Lcom/obric/matrix/dataanalysis/DeviceIdManager$deviceInfoCallback$1;", "isBound", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/matrix/dataanalysis/DeviceIdManager$DeviceIdListener;", "serviceConnection", "com/obric/matrix/dataanalysis/DeviceIdManager$serviceConnection$1", "Lcom/obric/matrix/dataanalysis/DeviceIdManager$serviceConnection$1;", "addListener", "", "listener", "bindService", "fetchDeviceId", "fetchInstallId", "getDeviceId", "getInstallId", "notifyListenersDidLoaded", "deviceId", "notifyListenersInstallidLoaded", "installId", "onEvent", "eventName", "params", "", "onEventWithJson", "json", "Lorg/json/JSONObject;", "removeListener", "setDeviceId", "setInstallId", "unbindService", "Companion", "DeviceIdListener", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f9059i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile h f9060j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.matrix.platform.d.a.b.a f9062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f9064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f9067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c f9068h;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/matrix/dataanalysis/DeviceIdManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/obric/matrix/dataanalysis/DeviceIdManager;", "getInstance", "init", "", "application", "Landroid/app/Application;", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final h a() {
            h r1 = h.f();
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new IllegalStateException("DeviceIdManager must be initialized first");
        }

        public final void b(Application r3) {
            o.f(r3, "application");
            if (h.f() != null) goto L14;
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L6:
            if (h.f() != null) goto L8;
            a r0 = h.f9059i;     // Catch: Throwable -> L11
            h.k(new h(r3, null));     // Catch: Throwable -> L11
        L8:
            f0 r4 = f0.f18324a;     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/obric/matrix/dataanalysis/DeviceIdManager$DeviceIdListener;", "", "onDeviceIdReady", "", "deviceId", "", "onInstallIdReady", "installId", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a(String r1);

        void b(String r1);
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/dataanalysis/DeviceIdManager$deviceInfoCallback$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/IDeviceInfoCallback$Stub;", "onDeviceId", "", "deviceId", "", "onInstallId", "installId", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends com.obric.matrix.platform.d.a.b.b.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f9069f;

        c(h r1) {
            this.f9069f = r1;
        }

        @Override // com.obric.matrix.platform.d.a.b.b
        public void Q(String r3) {
            if (r3 == null) goto L5;
            h r2 = this.f9069f;
            com.obric.matrix.r.c.c.j("DeviceIdManager", "Install ID received: " + r3);
            h.j(r2, r3);
            return;
        }

        @Override // com.obric.matrix.platform.d.a.b.b
        public void l(String r3) {
            if (r3 == null) goto L5;
            h r2 = this.f9069f;
            com.obric.matrix.r.c.c.j("DeviceIdManager", "Device ID received: " + r3);
            h.i(r2, r3);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/dataanalysis/DeviceIdManager$serviceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f9070f;

        d(h r1) {
            this.f9070f = r1;
        }

        public static /* synthetic */ void a(h r0) {
            b(r0);
        }

        private static final void b(h r1) {
            o.f(r1, "this$0");
            h.a(r1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r4, IBinder r5) {
            com.obric.matrix.r.c.c.j("DeviceIdManager", "Service connected");
            h.h(this.f9070f, com.obric.matrix.platform.d.a.b.a.AbstractBinderC0258a.a(r5));
            h.g(this.f9070f, true);
            h r6 = this.f9070f;
            v.a r1 = v.f21457g;     // Catch: Throwable -> L9
            com.obric.matrix.platform.d.a.b.a r2 = h.d(r6);     // Catch: Throwable -> L9
            if (r2 == null) goto L6;
            r2.Y(h.e(r6));     // Catch: Throwable -> L9
            Object r7 = f0.f18324a;     // Catch: Throwable -> L9
        L7:
            v.b(r7);     // Catch: Throwable -> L9
        L11:
            final h r3 = this.f9070f;
            Throwable r8 = v.d(r7);
            if (r8 == null) goto L14;
            com.obric.matrix.r.c.c.g("DeviceIdManager", "Failed to register device info listener", r8);
            h.g(r3, false);
            h.h(r3, null);
            new Handler(Looper.getMainLooper()).postDelayed(new f(r3), WsConstants.EXIT_DELAY_TIME);
        L14:
            h.b(this.f9070f);
            h.c(this.f9070f);
            return;
        L6:
            r7 = null;
        L9:
            th = move-exception;
            v.a r9 = v.f21457g;
            r7 = w.a(th);
            v.b(r7);
            goto L11
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r2) {
            com.obric.matrix.r.c.c.j("DeviceIdManager", "Service disconnected");
            h.g(this.f9070f, false);
            h.h(this.f9070f, null);
        }
    }

    static {
        f9059i = new a(null);
    }

    private h(Context r2) {
        Context r3 = r2.getApplicationContext();
        o.e(r3, "context.applicationContext");
        this.f9061a = r3;
        this.f9064d = new CopyOnWriteArrayList();
        this.f9067g = new d(this);
        m();
        this.f9068h = new c(this);
    }

    public /* synthetic */ h(Context r1, kotlin.n0.d.g r2) {
        this(r1);
    }

    public static final /* synthetic */ void a(h r0) {
        r0.m();
    }

    public static final /* synthetic */ void b(h r0) {
        r0.n();
    }

    public static final /* synthetic */ void c(h r0) {
        r0.o();
    }

    public static final /* synthetic */ com.obric.matrix.platform.d.a.b.a d(h r0) {
        return r0.f9062b;
    }

    public static final /* synthetic */ c e(h r0) {
        return r0.f9068h;
    }

    public static final /* synthetic */ h f() {
        return f9060j;
    }

    public static final /* synthetic */ void g(h r0, boolean r1) {
        r0.f9063c = r1;
    }

    public static final /* synthetic */ void h(h r0, com.obric.matrix.platform.d.a.b.a r1) {
        r0.f9062b = r1;
    }

    public static final /* synthetic */ void i(h r0, String r1) {
        r0.w(r1);
    }

    public static final /* synthetic */ void j(h r0, String r1) {
        r0.x(r1);
    }

    public static final /* synthetic */ void k(h r0) {
        f9060j = r0;
    }

    private final void m() {
        Intent r0 = new Intent(this.f9061a, DataService.class);
        this.f9061a.bindService(r0, this.f9067g, 1);
    }

    private final void n() {
        com.obric.matrix.platform.d.a.b.a r0 = this.f9062b;
        if (r0 == null) goto L16;
        String r1 = r0.getDeviceId();     // Catch: RemoteException -> L9
        if (i.a(r1) == false) goto L7;
        o.e(r1, "deviceId");     // Catch: RemoteException -> L9
        w(r1);     // Catch: RemoteException -> L9
    L12:
        return;
    L7:
        r0.Y(this.f9068h);     // Catch: RemoteException -> L9
    L9:
        e = move-exception;
        com.obric.matrix.r.c.c.g("DeviceIdManager", "Failed to get device ID", e);
        return;
    }

    private final void o() {
        com.obric.matrix.platform.d.a.b.a r0 = this.f9062b;
        if (r0 == null) goto L16;
        String r1 = r0.getInstallId();     // Catch: RemoteException -> L9
        if (i.a(r1) == false) goto L7;
        o.e(r1, "installId");     // Catch: RemoteException -> L9
        x(r1);     // Catch: RemoteException -> L9
    L12:
        return;
    L7:
        r0.Y(this.f9068h);     // Catch: RemoteException -> L9
    L9:
        e = move-exception;
        com.obric.matrix.r.c.c.g("DeviceIdManager", "Failed to get installID", e);
        return;
    }

    private final void r(String r2) {
        Iterator<T> r1 = this.f9064d.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((b) r1.next()).b(r2);
        goto L4
    }

    private final void s(String r2) {
        Iterator<T> r1 = this.f9064d.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((b) r1.next()).a(r2);
        goto L4
    }

    private final void w(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        if (o.a(r2, BDLocationException.ERROR_TIMEOUT) == false) goto L13;
        return;
    L13:
        if (o.a(r2, "-1") == true) goto L18;
        this.f9065e = r2;
        r(r2);
        return;
    L18:
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    private final void x(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        if (o.a(r2, BDLocationException.ERROR_TIMEOUT) == false) goto L13;
        return;
    L13:
        if (o.a(r2, "-1") == true) goto L18;
        this.f9066f = r2;
        s(r2);
        return;
    L18:
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void l(b r2) {
        o.f(r2, "listener");
        if (this.f9064d.contains(r2) == true) goto L6;
        this.f9064d.add(r2);
    L6:
        if (i.a(this.f9065e) == false) goto L9;
        String r0 = this.f9065e;
        o.c(r0);
        r2.b(r0);
    L9:
        if (i.a(this.f9066f) == false) goto L12;
        String r1 = this.f9066f;
        o.c(r1);
        r2.a(r1);
        return;
    }

    public final String p() {
    L13:
        e = move-exception;
        com.obric.matrix.r.c.c.g("DeviceIdManager", "getDeviceId出错了", e);
    L16:
        return this.f9065e;
    L4:
        if (i.a(this.f9065e) == true) goto L11;
        com.obric.matrix.platform.d.a.b.a r1 = this.f9062b;     // Catch: Exception -> L13
        if (r1 == null) goto L8;
        String r2 = r1.getDeviceId();     // Catch: Exception -> L13
    L9:
        this.f9065e = r2;     // Catch: Exception -> L13
        String r3 = "getDeviceId时，cachedDeviceId不合法，从dataService获取，cachedDeviceId = " + this.f9065e;     // Catch: Exception -> L13
    L10:
        com.obric.matrix.r.c.c.j("DeviceIdManager", r3);     // Catch: Exception -> L13
        goto L16
    L8:
        r2 = null;
        goto L9
    L11:
        r3 = "getDeviceId时，cachedDeviceId合法，直接返回，cachedDeviceId = " + this.f9065e;     // Catch: Exception -> L13
        goto L10
    }

    public final String q() {
    L13:
        e = move-exception;
        com.obric.matrix.r.c.c.g("DeviceIdManager", "getInstallId出错了", e);
    L16:
        return this.f9066f;
    L4:
        if (i.a(this.f9066f) == true) goto L11;
        com.obric.matrix.platform.d.a.b.a r1 = this.f9062b;     // Catch: Exception -> L13
        if (r1 == null) goto L8;
        String r2 = r1.getInstallId();     // Catch: Exception -> L13
    L9:
        this.f9066f = r2;     // Catch: Exception -> L13
        String r3 = "getInstallId时，getInstallId不合法，从dataService获取，cachedInstallId = " + this.f9066f;     // Catch: Exception -> L13
    L10:
        com.obric.matrix.r.c.c.j("DeviceIdManager", r3);     // Catch: Exception -> L13
        goto L16
    L8:
        r2 = null;
        goto L9
    L11:
        r3 = "getInstallId时，getInstallId合法，直接返回，cachedInstallId = " + this.f9066f;     // Catch: Exception -> L13
        goto L10
    }

    public final void t(String r5, Map<String, ? extends Object> r6) {
        o.f(r5, "eventName");
        o.f(r6, "params");
    L17:
        e = move-exception;
        com.obric.matrix.r.c.c.g("DeviceIdManager", "onEvent出错了", e);
        return;
    L4:
        if (r5.length() <= 0) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L15;
        JSONObject r2 = new JSONObject();     // Catch: RemoteException -> L17
        Iterator<Map.Entry<String, ? extends Object>> r7 = r6.entrySet().iterator();     // Catch: RemoteException -> L17
    L10:
        if (r7.hasNext() == false) goto L12;
        Map.Entry<String, ? extends Object> r3 = r7.next();     // Catch: RemoteException -> L17
        r2.put(r3.getKey(), r3.getValue());     // Catch: RemoteException -> L17
        goto L10
    L12:
        com.obric.matrix.platform.d.a.b.a r4 = this.f9062b;     // Catch: RemoteException -> L17
        if (r4 == null) goto L22;
        r4.onEvent(r5, r2.toString());     // Catch: RemoteException -> L17
        return;
    L22:
        return;
    L15:
        com.obric.matrix.r.c.c.f("DeviceIdManager", "onEvent，eventName 为空");     // Catch: RemoteException -> L17
        return;
    L6:
        r1 = false;
        goto L7
    }

    public final void u(String r3, JSONObject r4) {
        o.f(r3, "eventName");
        o.f(r4, "json");
    L13:
        e = move-exception;
        com.obric.matrix.r.c.c.g("DeviceIdManager", "onEvent出错了", e);
        return;
    L4:
        if (r3.length() <= 0) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L11;
        com.obric.matrix.platform.d.a.b.a r2 = this.f9062b;     // Catch: RemoteException -> L13
        if (r2 == null) goto L16;
        r2.onEvent(r3, r4.toString());     // Catch: RemoteException -> L13
    L16:
        return;
    L11:
        com.obric.matrix.r.c.c.f("DeviceIdManager", "onEventWithJson，eventName 为空");     // Catch: RemoteException -> L13
        goto L16
    L6:
        r1 = false;
        goto L7
    }

    public final void v(b r2) {
        o.f(r2, "listener");
        this.f9064d.remove(r2);
    }
}
