package com.obric.matrix.push.common.cross_process;

import a.a.a.a.a.b.c.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J>\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J>\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00062\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J4\u0010 \u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/matrix/push/common/cross_process/CrossProcessService;", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessService;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "mBinderMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessInterface;", "mMethodMap", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessMethod;", "mServiceConnectionMap", "Landroid/content/ServiceConnection;", "bindTarget", "", "targetPkg", "isFromOnBind", "", "serviceConnection", "disConnectWithTargetPkg", "pkgName", "invoke", "method", "args", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "callback", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessCallback;", "invokeInternal", "crossProcess", "onMethodInvoke", "originPkgName", "", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface;", "registerCrossProcessMethod", "unRegisterCrossProcessMethod", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CrossProcessService implements c {
    private final String TAG;
    private final ConcurrentHashMap<String, a.a.a.a.a.b.b> mBinderMap;
    private final Context mContext;
    private final ConcurrentHashMap<String, a.a.a.a.a.b.c.b> mMethodMap;
    private final ConcurrentHashMap<String, ServiceConnection> mServiceConnectionMap;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/push/common/cross_process/CrossProcessService$invoke$2$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CrossProcessService f13a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ArrayList<Object> c;
        public final /* synthetic */ a.a.a.a.a.b.c.a d;

        public a(CrossProcessService r1, String r2, ArrayList<Object> r3, a.a.a.a.a.b.c.a r4) {
            this.f13a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r8, IBinder r9) {
            if (r8 == null) goto L13;
            CrossProcessService r0 = this.f13a;
            String r1 = this.b;
            ArrayList<Object> r2 = this.c;
            a.a.a.a.a.b.c.a r3 = this.d;
            if (r9 == null) goto L14;
            a.a.a.a.a.c.c.a(CrossProcessService.access$getTAG$p(r0), "success bind  " + r8.getPackageName() + "'s CrossProcessService, invoke " + r1 + " method internal");
            int r4 = a.a.a.a.a.b.b.a.f7a;
            IInterface r5 = r9.queryLocalInterface("com.obric.matrix.push.common.cross_process.ICrossProcessInterface");
            if (r5 != null) goto L8;
        L10:
            a.a.a.a.a.b.b r6 = new a.a.a.a.a.b.b.a.C0002a(r9);
        L11:
            ConcurrentHashMap r10 = CrossProcessService.access$getMServiceConnectionMap$p(r0);
            String r7 = r8.getPackageName();
            Intrinsics.checkNotNullExpressionValue(r7, "itOfComponent.packageName");
            r10.put(r7, this);
            ConcurrentHashMap r11 = CrossProcessService.access$getMBinderMap$p(r0);
            String r12 = r8.getPackageName();
            Intrinsics.checkNotNullExpressionValue(r12, "itOfComponent.packageName");
            Intrinsics.checkNotNullExpressionValue(r6, "crossProcess");
            r11.put(r12, r6);
            CrossProcessService.access$invokeInternal(r0, r6, r1, r2, r3);
            return;
        L8:
            if ((r5 instanceof a.a.a.a.a.b.b) == false) goto L10;
            r6 = (a.a.a.a.a.b.b) r5;
            goto L11
        L14:
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r4) {
            if (r4 == null) goto L5;
            CrossProcessService r3 = this.f13a;
            a.a.a.a.a.c.c.a(CrossProcessService.access$getTAG$p(r3), "on bind  " + r4.getPackageName() + "'s CrossProcessService disconnected");
            CrossProcessService.access$getMServiceConnectionMap$p(r3).remove(r4.getPackageName());
            a.a.a.a.a.b.b r5 = (a.a.a.a.a.b.b) CrossProcessService.access$getMBinderMap$p(r3).remove(r4.getPackageName());
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/push/common/cross_process/CrossProcessService$invokeInternal$1", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface$Stub;", "onCallBack", "", "params", "", "", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends a.a.a.a.a.b.a.AbstractBinderC0000a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CrossProcessService f14a;
        public final /* synthetic */ String b;
        public final /* synthetic */ a.a.a.a.a.b.c.a c;

        public b(CrossProcessService r1, String r2, a.a.a.a.a.b.c.a r3) {
            this.f14a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public CrossProcessService(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        this.mContext = r2;
        this.TAG = "CrossProcessService";
        this.mBinderMap = new ConcurrentHashMap();
        this.mServiceConnectionMap = new ConcurrentHashMap();
        this.mMethodMap = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMBinderMap$p(CrossProcessService r0) {
        return r0.mBinderMap;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMServiceConnectionMap$p(CrossProcessService r0) {
        return r0.mServiceConnectionMap;
    }

    public static final /* synthetic */ String access$getTAG$p(CrossProcessService r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ void access$invokeInternal(CrossProcessService r0, a.a.a.a.a.b.b r1, String r2, ArrayList r3, a.a.a.a.a.b.c.a r4) {
        r0.invokeInternal(r1, r2, r3, r4);
    }

    private final void bindTarget(String r4, boolean r5, ServiceConnection r6) {
        Intent r0 = new Intent();
        r0.setPackage(r4);
        r0.setAction(r4 + ".action.CROSS_PROCESS");
        r0.putExtra("origin_package_name", this.mContext.getPackageName());
        r0.putExtra("is_from_on_bind", r5);
        a.a.a.a.a.c.c.a(this.TAG, "bind " + r4 + "'s CrossProcessService");
        this.mContext.bindService(r0, r6, 49);
    }

    private final void invokeInternal(a.a.a.a.a.b.b r5, String r6, ArrayList<Object> r7, a.a.a.a.a.b.c.a r8) {
        a.a.a.a.a.c.c.a(this.TAG, "invoke " + r6 + " method internal");
        r5.a(r6, this.mContext.getPackageName(), r7, new b(this, r6, r8));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a.a.a.a.a.c.c.a(this.TAG, "invoke " + r6 + " method internal error", e);
        if (r8 != null) goto L14;
        return;
    L14:
        r8.a(null);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        a.a.a.a.a.c.c.a(this.TAG, "on " + r6 + " onCallback error", e);
    }

    public void disConnectWithTargetPkg(String r4) {
        Intrinsics.checkNotNullParameter(r4, "pkgName");
        a.a.a.a.a.c.c.a(this.TAG, "disConnectWithTargetPkg: " + r4 + ' ');
        ServiceConnection r0 = this.mServiceConnectionMap.get(r4);
        if (r0 == null) goto L5;
        this.mContext.unbindService(r0);
    L5:
        this.mBinderMap.remove(r4);
        this.mServiceConnectionMap.remove(r4);
    }

    @Override // a.a.a.a.a.b.c.c
    public void invoke(String r6, String r7, ArrayList<Object> r8, a.a.a.a.a.b.c.a r9) {
        Intrinsics.checkNotNullParameter(r6, "targetPkg");
        Intrinsics.checkNotNullParameter(r7, "method");
        a.a.a.a.a.c.c.a(this.TAG, "try invoke " + r7 + " method");
        a.a.a.a.a.b.b r0 = this.mBinderMap.get(r6);
        if (r0 == null) goto L5;
        a.a.a.a.a.c.c.a(this.TAG, "binder of  " + r6 + " is not null , invoke internal");
        invokeInternal(r0, r7, r8, r9);
        Unit r1 = Unit.INSTANCE;
    L6:
        if (r1 != null) goto L9;
        a.a.a.a.a.c.c.a(this.TAG, "binder of  " + r6 + " is null , bind target service");
        bindTarget(r6, false, new a(this, r7, r8, r9));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // a.a.a.a.a.b.c.c
    public void onMethodInvoke(String r4, String r5, List<Object> r6, a.a.a.a.a.b.a r7) {
        Intrinsics.checkNotNullParameter(r4, "method");
        Intrinsics.checkNotNullParameter(r5, "originPkgName");
        a.a.a.a.a.c.c.a(this.TAG, r4 + " be invoked");
        a.a.a.a.a.b.c.b r3 = this.mMethodMap.get(r4);
        if (r3 == null) goto L6;
        r3.a(r5, r6, r7);
        return;
    }

    @Override // a.a.a.a.a.b.c.c
    public void registerCrossProcessMethod(a.a.a.a.a.b.c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "method");
        a.a.a.a.a.c.c.a(this.TAG, "register cross process method: " + r4);
        this.mMethodMap.put(r4.a(), r4);
    }

    public void unRegisterCrossProcessMethod(a.a.a.a.a.b.c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "method");
        a.a.a.a.a.c.c.a(this.TAG, "unRegister cross process method: " + r4);
        this.mMethodMap.remove(r4.a());
    }
}
