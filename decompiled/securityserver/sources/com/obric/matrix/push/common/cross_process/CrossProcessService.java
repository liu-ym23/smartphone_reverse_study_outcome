package com.obric.matrix.push.common.cross_process;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.obric.matrix.push.common.CommonConstants;
import com.obric.matrix.push.common.cross_process.interfaze.ICrossProcessCallback;
import com.obric.matrix.push.common.cross_process.interfaze.ICrossProcessMethod;
import com.obric.matrix.push.common.cross_process.interfaze.ICrossProcessService;
import com.obric.matrix.push.common.log.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CrossProcessService implements ICrossProcessService {

    @NotNull
    private final String TAG;

    @NotNull
    private final ConcurrentHashMap<String, ICrossProcessInterface> mBinderMap;

    @NotNull
    private final Context mContext;

    @NotNull
    private final ConcurrentHashMap<String, ICrossProcessMethod> mMethodMap;

    @NotNull
    private final ConcurrentHashMap<String, ServiceConnection> mServiceConnectionMap;

    public CrossProcessService(@NotNull Context r2) {
        Intrinsics.f(r2, "mContext");
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

    public static final /* synthetic */ void access$invokeInternal(CrossProcessService r0, ICrossProcessInterface r1, String r2, ArrayList r3, ICrossProcessCallback r4) {
        r0.invokeInternal(r1, r2, r3, r4);
    }

    private final void bindTarget(String r4, boolean r5, ServiceConnection r6) {
        Intent r0 = new Intent();
        r0.setPackage(r4);
        r0.setAction(r4 + CommonConstants.CROSS_PROCESS_ACTION);
        r0.putExtra(CommonConstants.CROSS_PROCESS_ORIGIN_PACKAGE_NAME, this.mContext.getPackageName());
        r0.putExtra(CommonConstants.CROSS_PROCESS_IS_FROM_ON_BIND, r5);
        Logger.d(this.TAG, "bind " + r4 + "'s CrossProcessService");
        this.mContext.bindService(r0, r6, 1);
    }

    private final void invokeInternal(ICrossProcessInterface r5, final String r6, ArrayList<Object> r7, final ICrossProcessCallback r8) {
        Logger.d(this.TAG, "invoke " + r6 + " method internal");
        r5.invoke(r6, this.mContext.getPackageName(), r7, new AnonymousClass1(this, r6, r8));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.e(this.TAG, "invoke " + r6 + " method internal error", e);
        if (r8 == null) goto L12;
        r8.onCallback(null);
        return;
    }

    @Override // com.obric.matrix.push.common.cross_process.interfaze.ICrossProcessService
    public void disConnectWithTargetPkg(@NotNull String r4) {
        Intrinsics.f(r4, "pkgName");
        Logger.d(this.TAG, "disConnectWithTargetPkg: " + r4 + ' ');
        ServiceConnection r0 = this.mServiceConnectionMap.get(r4);
        if (r0 == null) goto L5;
        this.mContext.unbindService(r0);
    L5:
        this.mBinderMap.remove(r4);
        this.mServiceConnectionMap.remove(r4);
    }

    @Override // com.obric.matrix.push.common.cross_process.interfaze.ICrossProcessService
    public void invoke(@NotNull String r6, @NotNull final String r7, @Nullable final ArrayList<Object> r8, @Nullable final ICrossProcessCallback r9) {
        Intrinsics.f(r6, "targetPkg");
        Intrinsics.f(r7, "method");
        Logger.d(this.TAG, "try invoke " + r7 + " method");
        ICrossProcessInterface r0 = this.mBinderMap.get(r6);
        if (r0 == null) goto L5;
        Logger.d(this.TAG, "binder of  " + r6 + " is not null , invoke internal");
        invokeInternal(r0, r7, r8, r9);
        Unit r1 = Unit.f330a;
    L6:
        if (r1 != null) goto L9;
        Logger.d(this.TAG, "binder of  " + r6 + " is null , bind target service");
        bindTarget(r6, false, new CrossProcessService$invoke$2$1(this, r7, r8, r9));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.matrix.push.common.cross_process.interfaze.ICrossProcessService
    public void onMethodInvoke(@NotNull String r3, @NotNull String r4, @Nullable List<Object> r5, @Nullable ICrossProcessCallbackInterface r6) {
        Intrinsics.f(r3, "method");
        Intrinsics.f(r4, "originPkgName");
        Logger.d(this.TAG, r3.concat(" be invoked"));
        ICrossProcessMethod r2 = this.mMethodMap.get(r3);
        if (r2 == null) goto L6;
        r2.onMethodInvoke(r4, r5, r6);
        return;
    }

    @Override // com.obric.matrix.push.common.cross_process.interfaze.ICrossProcessService
    public void registerCrossProcessMethod(@NotNull ICrossProcessMethod r4) {
        Intrinsics.f(r4, "method");
        Logger.d(this.TAG, "register cross process method: " + r4);
        this.mMethodMap.put(r4.getMethodName(), r4);
    }

    @Override // com.obric.matrix.push.common.cross_process.interfaze.ICrossProcessService
    public void unRegisterCrossProcessMethod(@NotNull ICrossProcessMethod r4) {
        Intrinsics.f(r4, "method");
        Logger.d(this.TAG, "unRegister cross process method: " + r4);
        this.mMethodMap.remove(r4.getMethodName());
    }
}
