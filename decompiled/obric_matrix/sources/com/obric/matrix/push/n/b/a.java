package com.obric.matrix.push.n.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J>\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J>\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00062\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J4\u0010 \u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/matrix/push/common/cross_process/CrossProcessService;", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessService;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "mBinderMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessInterface;", "mMethodMap", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessMethod;", "mServiceConnectionMap", "Landroid/content/ServiceConnection;", "bindTarget", "", "targetPkg", "isFromOnBind", "", "serviceConnection", "disConnectWithTargetPkg", "pkgName", "invoke", "method", "args", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "callback", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessCallback;", "invokeInternal", "crossProcess", "onMethodInvoke", "originPkgName", "", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface;", "registerCrossProcessMethod", "unRegisterCrossProcessMethod", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements com.obric.matrix.push.n.b.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f9745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, ServiceConnection> f9746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.obric.matrix.push.n.b.d.b> f9747e;

    /* JADX INFO: renamed from: com.obric.matrix.push.n.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/push/common/cross_process/CrossProcessService$invoke$2$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ServiceConnectionC0275a implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f9748f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9749g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList<Object> f9750h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.push.n.b.d.a f9751i;

        ServiceConnectionC0275a(a r1, String r2, ArrayList<Object> r3, com.obric.matrix.push.n.b.d.a r4) {
            this.f9748f = r1;
            this.f9749g = r2;
            this.f9750h = r3;
            this.f9751i = r4;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r8, IBinder r9) {
            if (r8 == null) goto L7;
            a r0 = this.f9748f;
            String r1 = this.f9749g;
            ArrayList<Object> r2 = this.f9750h;
            com.obric.matrix.push.n.b.d.a r3 = this.f9751i;
            if (r9 == null) goto L8;
            com.obric.matrix.push.n.c.c.b(a.f(r0), "success bind  " + r8.getPackageName() + "'s CrossProcessService, invoke " + r1 + " method internal");
            c r10 = c.a.a(r9);
            ConcurrentHashMap r4 = a.e(r0);
            String r5 = r8.getPackageName();
            o.e(r5, "itOfComponent.packageName");
            r4.put(r5, this);
            ConcurrentHashMap r7 = a.d(r0);
            String r11 = r8.getPackageName();
            o.e(r11, "itOfComponent.packageName");
            o.e(r10, "crossProcess");
            r7.put(r11, r10);
            a.g(r0, r10, r1, r2, r3);
            return;
        L8:
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r4) {
            if (r4 == null) goto L5;
            a r3 = this.f9748f;
            com.obric.matrix.push.n.c.c.b(a.f(r3), "on bind  " + r4.getPackageName() + "'s CrossProcessService disconnected");
            a.e(r3).remove(r4.getPackageName());
            c r5 = (c) a.d(r3).remove(r4.getPackageName());
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/push/common/cross_process/CrossProcessService$invokeInternal$1", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface$Stub;", "onCallBack", "", "params", "", "", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends com.obric.matrix.push.n.b.b.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f9752f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9753g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.push.n.b.d.a f9754h;

        b(a r1, String r2, com.obric.matrix.push.n.b.d.a r3) {
            this.f9752f = r1;
            this.f9753g = r2;
            this.f9754h = r3;
        }

        @Override // com.obric.matrix.push.n.b.b
        public void F(List<Object> r5) {
            com.obric.matrix.push.n.c.c.b(a.f(this.f9752f), "on " + this.f9753g + " callback");
            com.obric.matrix.push.n.b.d.a r0 = this.f9754h;     // Catch: Exception -> L7
            if (r0 == null) goto L12;
            r0.a(r5);     // Catch: Exception -> L7
            return;
        L12:
            return;
        L7:
            e = move-exception;
            com.obric.matrix.push.n.c.c.d(a.f(this.f9752f), "on " + this.f9753g + " onCallback error", e);
        }
    }

    public a(Context r2) {
        o.f(r2, "mContext");
        this.f9743a = r2;
        this.f9744b = "CrossProcessService";
        this.f9745c = new ConcurrentHashMap();
        this.f9746d = new ConcurrentHashMap();
        this.f9747e = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ConcurrentHashMap d(a r0) {
        return r0.f9745c;
    }

    public static final /* synthetic */ ConcurrentHashMap e(a r0) {
        return r0.f9746d;
    }

    public static final /* synthetic */ String f(a r0) {
        return r0.f9744b;
    }

    public static final /* synthetic */ void g(a r0, c r1, String r2, ArrayList r3, com.obric.matrix.push.n.b.d.a r4) {
        r0.i(r1, r2, r3, r4);
    }

    private final void h(String r4, boolean r5, ServiceConnection r6) {
        Intent r0 = new Intent();
        r0.setPackage(r4);
        r0.setAction(r4 + ".action.CROSS_PROCESS");
        r0.putExtra("origin_package_name", this.f9743a.getPackageName());
        r0.putExtra("is_from_on_bind", r5);
        com.obric.matrix.push.n.c.c.b(this.f9744b, "bind " + r4 + "'s CrossProcessService");
        this.f9743a.bindService(r0, r6, 49);
    }

    private final void i(c r5, String r6, ArrayList<Object> r7, com.obric.matrix.push.n.b.d.a r8) {
        com.obric.matrix.push.n.c.c.b(this.f9744b, "invoke " + r6 + " method internal");
        r5.d0(r6, this.f9743a.getPackageName(), r7, new b(this, r6, r8));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.matrix.push.n.c.c.d(this.f9744b, "invoke " + r6 + " method internal error", e);
        if (r8 != null) goto L14;
        return;
    L14:
        r8.a(null);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.obric.matrix.push.n.c.c.d(this.f9744b, "on " + r6 + " onCallback error", e);
    }

    @Override // com.obric.matrix.push.n.b.d.c
    public void a(com.obric.matrix.push.n.b.d.b r4) {
        o.f(r4, "method");
        com.obric.matrix.push.n.c.c.b(this.f9744b, "register cross process method: " + r4);
        this.f9747e.put(r4.a(), r4);
    }

    @Override // com.obric.matrix.push.n.b.d.c
    public void b(String r6, String r7, ArrayList<Object> r8, com.obric.matrix.push.n.b.d.a r9) {
        o.f(r6, "targetPkg");
        o.f(r7, "method");
        com.obric.matrix.push.n.c.c.b(this.f9744b, "try invoke " + r7 + " method");
        c r0 = this.f9745c.get(r6);
        if (r0 == null) goto L5;
        com.obric.matrix.push.n.c.c.b(this.f9744b, "binder of  " + r6 + " is not null , invoke internal");
        i(r0, r7, r8, r9);
        f0 r1 = f0.f18324a;
    L6:
        if (r1 != null) goto L9;
        com.obric.matrix.push.n.c.c.b(this.f9744b, "binder of  " + r6 + " is null , bind target service");
        h(r6, false, new ServiceConnectionC0275a(this, r7, r8, r9));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.matrix.push.n.b.d.c
    public void c(String r4, String r5, List<Object> r6, com.obric.matrix.push.n.b.b r7) {
        o.f(r4, "method");
        o.f(r5, "originPkgName");
        com.obric.matrix.push.n.c.c.b(this.f9744b, r4 + " be invoked");
        com.obric.matrix.push.n.b.d.b r3 = this.f9747e.get(r4);
        if (r3 == null) goto L6;
        r3.b(r5, r6, r7);
        return;
    }
}
