package com.obric.matrix.sdk.network;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NetworkSDKInit {

    @NotNull
    public static final NetworkSDKInit INSTANCE = null;

    @NotNull
    public static final String TAG = "NetworkSDKInit";
    public static NetworkConfig config;

    static {
        INSTANCE = new NetworkSDKInit();
    }

    private NetworkSDKInit() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(NetworkSDKInit r7, Context r8, Application r9, String r10, NetworkConfig r11, List r12, InterfaceRequestListener r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = null;
    L5:
        r7.init(r8, r9, r10, r11, r12, r13);
    }

    @NotNull
    public final NetworkConfig getConfig() {
        NetworkConfig r0 = config;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("config");
        throw null;
    }

    public final void init(@NotNull Context r7, @NotNull Application r8, @NotNull String r9, @NotNull NetworkConfig r10, @Nullable List<? extends Interceptor> r11, @Nullable InterfaceRequestListener r12) {
        Intrinsics.f(r7, "context");
        Intrinsics.f(r8, "application");
        Intrinsics.f(r9, "host");
        Intrinsics.f(r10, "config");
        long r1 = System.currentTimeMillis();
        Log.i(TAG, "init start, startTime: " + r1);
        INSTANCE.setConfig(r10);     // Catch: Throwable -> L5
        TTNetHelper r3 = TTNetHelper.INSTANCE;     // Catch: Throwable -> L5
        r3.initTTNet(r7, r8, r10.getNeedSetCookieHandler(), r10.getApiProcessHook());     // Catch: Throwable -> L5
        r3.setRequestListener(r12);     // Catch: Throwable -> L5
        OceanHttpUtil.INSTANCE.setParam$sdk_network_release(r9, r11);     // Catch: Throwable -> L5
        Log.i(TAG, "init success, 初始化耗时: " + (System.currentTimeMillis() - r1) + " ms");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e(TAG, "init failed, 初始化耗时: " + (System.currentTimeMillis() - r1) + " ms", th);
    }

    public final void setConfig(@NotNull NetworkConfig r1) {
        Intrinsics.f(r1, "<set-?>");
        config = r1;
    }
}
