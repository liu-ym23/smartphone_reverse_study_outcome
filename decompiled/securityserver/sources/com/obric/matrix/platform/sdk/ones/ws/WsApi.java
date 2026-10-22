package com.obric.matrix.platform.sdk.ones.ws;

import android.content.Context;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.WsMessageInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WsApi {

    @NotNull
    public static final WsApi INSTANCE = null;

    static {
        INSTANCE = new WsApi();
    }

    private WsApi() {
    }

    @JvmStatic
    public static final void addWsStatusListener(@NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r1) {
        Intrinsics.f(r1, "listener");
        MatrixWsHelper.INSTANCE.addWsStatusListener(r1);
    }

    @JvmStatic
    public static final void init(@Nullable IWsBridge r1) {
        MatrixWsHelper.INSTANCE.init(r1);
    }

    @JvmStatic
    public static final boolean isWsConnected() {
        return MatrixWsHelper.INSTANCE.isWsConnected();
    }

    @JvmStatic
    public static final void removeSubscribeWsStatus(@NotNull Context r1, @NotNull Function2<? super Boolean, ? super Response, Unit> r2) {
        Intrinsics.f(r1, "context");
        Intrinsics.f(r2, "subscribeResultCallBack");
        MatrixWsHelper.INSTANCE.removeSubscribeWsStatus(r1, r2);
    }

    @JvmStatic
    public static final void removeWsStatusListener(@NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r1) {
        Intrinsics.f(r1, "listener");
        MatrixWsHelper.INSTANCE.removeWsStatusListener(r1);
    }

    @JvmStatic
    public static final void sendWsMsg(@NotNull WsMessageInfo r1, @NotNull Function2<? super Integer, ? super Response, Unit> r2) {
        Intrinsics.f(r1, "wsMessageInfo");
        Intrinsics.f(r2, "listener");
        MatrixWsHelper.INSTANCE.sendWsMsg(r1, r2);
    }

    @JvmStatic
    public static final void subscribeWsMsgByBroadCast(int r7, int r8, @NotNull String r9, int r10, @NotNull Function2<? super Boolean, ? super Response, Unit> r11) {
        Intrinsics.f(r9, "packageName");
        Intrinsics.f(r11, "subscribeResultCallBack");
        MatrixWsHelper.INSTANCE.subscribeWsMsgByBroadCast(r7, r8, r9, r10, r11);
    }

    @JvmStatic
    public static final void subscribeWsMsgByCallBack(int r7, int r8, int r9, @Nullable Function9<? super Integer, ? super Long, ? super Long, ? super Integer, ? super Integer, ? super String, ? super String, ? super byte[], ? super Map<String, String>, Unit> r10, @NotNull Function2<? super Boolean, ? super Response, Unit> r11) {
        Intrinsics.f(r11, "subscribeResultCallBack");
        MatrixWsHelper.INSTANCE.subscribeWsMsgByCallBack(r7, r8, r9, r10, r11);
    }

    @JvmStatic
    public static final void subscribeWsMsgByProvider(int r7, int r8, @NotNull String r9, int r10, @NotNull Function2<? super Boolean, ? super Response, Unit> r11) {
        Intrinsics.f(r9, "packageName");
        Intrinsics.f(r11, "subscribeResultCallBack");
        MatrixWsHelper.INSTANCE.subscribeWsMsgByProvider(r7, r8, r9, r10, r11);
    }

    @JvmStatic
    public static final void subscribeWsStatus(@Nullable Context r1, @NotNull Function2<? super Boolean, ? super Response, Unit> r2) {
        Intrinsics.f(r2, "subscribeResultCallBack");
        MatrixWsHelper.INSTANCE.subscribeWsStatus(r1, r2);
    }

    public static /* synthetic */ void subscribeWsStatus$default(Context r0, Function2 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r0 = null;
    L5:
        subscribeWsStatus(r0, r1);
    }
}
