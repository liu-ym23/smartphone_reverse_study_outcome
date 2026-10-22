package com.obric.matrix.platform.sdk.ones.ws;

import android.content.Context;
import android.content.IntentFilter;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.CmdManager;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Request;
import com.obric.matrix.proto.RequestBody;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.SendWsMessageRequest;
import com.obric.matrix.proto.SubscribeWsMsgByBroadCastRequest;
import com.obric.matrix.proto.SubscribeWsMsgByCallBackRequest;
import com.obric.matrix.proto.SubscribeWsMsgByProviderRequest;
import com.obric.matrix.proto.SubscribeWsMsgRequest;
import com.obric.matrix.proto.SubscribeWsStatusRequest;
import com.obric.matrix.proto.WsMessageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatrixWsHelper {

    @NotNull
    public static final MatrixWsHelper INSTANCE = null;

    @NotNull
    private static final String TAG = "MatrixWsHelper";

    @NotNull
    private static final ConcurrentHashMap<String, Function9<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, Unit>> iWsMsgListeners = null;

    @NotNull
    private static final List<Function4<Integer, Integer, Integer, Boolean, Unit>> iWsStatusListeners = null;
    private static boolean isWsConnected;

    @Nullable
    private static IWsBridge wsBridge;

    @NotNull
    private static final MatrixWsHelper$wsMsgCallbackFromMatrix$1 wsMsgCallbackFromMatrix = null;

    @NotNull
    private static final MatrixWsHelper$wsStatusCallbackFromMatrix$1 wsStatusCallbackFromMatrix = null;

    @NotNull
    private static final WsStatusReceiver wsStatusReceiverFromMatrix = null;

    @Nullable
    private static Function2<? super Boolean, ? super Response, Unit> wsStatusSubscribeResultCallBack;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.matrix.platform.sdk.ones.ws.MatrixWsHelper$wsMsgCallbackFromMatrix$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.matrix.platform.sdk.ones.ws.MatrixWsHelper$wsStatusCallbackFromMatrix$1] */
    static {
        INSTANCE = new MatrixWsHelper();
        iWsStatusListeners = new ArrayList();
        iWsMsgListeners = new ConcurrentHashMap();
        wsMsgCallbackFromMatrix = new MatrixWsHelper$wsMsgCallbackFromMatrix$1();
        wsStatusCallbackFromMatrix = new MatrixWsHelper$wsStatusCallbackFromMatrix$1();
        wsStatusReceiverFromMatrix = new WsStatusReceiver(MatrixWsHelper$wsStatusReceiverFromMatrix$1.INSTANCE);
    }

    private MatrixWsHelper() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getIWsMsgListeners$p() {
        return iWsMsgListeners;
    }

    public static final /* synthetic */ List access$getIWsStatusListeners$p() {
        return iWsStatusListeners;
    }

    public static final /* synthetic */ Function2 access$getWsStatusSubscribeResultCallBack$p() {
        return wsStatusSubscribeResultCallBack;
    }

    public static final /* synthetic */ void access$setWsConnected$p(boolean r0) {
        isWsConnected = r0;
    }

    public static final /* synthetic */ void access$setWsStatusSubscribeResultCallBack$p(Function2 r0) {
        wsStatusSubscribeResultCallBack = r0;
    }

    public static /* synthetic */ void subscribeWsStatus$default(MatrixWsHelper r0, Context r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.subscribeWsStatus(r1);
    }

    public final void addWsStatusListener(@NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r2) {
        Intrinsics.f(r2, "listener");
        List<Function4<Integer, Integer, Integer, Boolean, Unit>> r1 = iWsStatusListeners;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (r1.contains(r2) == true) goto L10;
        r1.add(r2);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r1);
    }

    public final void init(@Nullable IWsBridge r4) {
        MLog.d$default(TAG, "init() called", null, 4, null);
        wsBridge = r4;
    }

    @Deprecated
    public final void isSupportMatrixWs(@NotNull final Function1<? super Boolean, Unit> r5) {
        Intrinsics.f(r5, "listener");
        SendWsMessageRequest r0 = new SendWsMessageRequest.Builder().wsMessageInfo(null).build();     // Catch: Exception -> L5
        Request.Builder r1 = new Request.Builder();     // Catch: Exception -> L5
        MATRIX_CMD r2 = MATRIX_CMD.CMD_SEND_WS_MESSAGE;     // Catch: Exception -> L5
        Request r3 = r1.cmd(Integer.valueOf(r2.getValue())).body(new RequestBody.Builder().sendWsMessageRequest(r0).build()).build();     // Catch: Exception -> L5
        CmdManager r4 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r6 = r2.getValue();     // Catch: Exception -> L5
        Intrinsics.e(r3, "request");     // Catch: Exception -> L5
        r4.sendCmd(r6, r3, new MatrixWsHelper$isSupportMatrixWs$1$1$1(r5));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "isSupportMatrixWs() with Exception: " + e, null, 4, null);
        r5.invoke(Boolean.FALSE);
    }

    public final boolean isWsConnected() {
        return isWsConnected;
    }

    public final void onWsMsgReceivedByProvider$sdk_platform_ones_release(int r16, long r17, long r19, int r21, int r22, @Nullable String r23, @Nullable String r24, @Nullable byte[] r25, @Nullable HashMap<String, String> r26) {
        MLog.d$default(TAG, "onWsMsgReceivedByProvider() called with: channelId = " + r16 + ", seqId = " + r17 + ", logId = " + r19 + ", service = " + r21 + ", method = " + r22 + ", encoding = " + r23 + ", type = " + r24 + ", payload = " + r25 + ", headers = " + r26 + ", wsBridge is " + wsBridge, null, 4, null);
        IWsBridge r2 = wsBridge;
        if (r2 == null) goto L6;
        r2.onWsMsgReceived(r16, r17, r19, r21, r22, r23, r24, r25, r26);
        return;
    }

    public final void removeSubscribeWsStatus(@NotNull Context r4) {
        Intrinsics.f(r4, "context");
        SubscribeWsStatusRequest r3 = new SubscribeWsStatusRequest.Builder().opt(0).packageName(r4.getPackageName()).build();     // Catch: Exception -> L5
        Request.Builder r0 = new Request.Builder();     // Catch: Exception -> L5
        MATRIX_CMD r1 = MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS;     // Catch: Exception -> L5
        Request r5 = r0.cmd(Integer.valueOf(r1.getValue())).body(new RequestBody.Builder().subscribeWsStatusRequest(r3).build()).build();     // Catch: Exception -> L5
        CmdManager r2 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r6 = r1.getValue();     // Catch: Exception -> L5
        Intrinsics.e(r5, "request");     // Catch: Exception -> L5
        r2.sendCmd(r6, r5, wsStatusCallbackFromMatrix);     // Catch: Exception -> L5
        r4.unregisterReceiver(wsStatusReceiverFromMatrix);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "removeSubscribeWsStatus() with Exception: " + e, null, 4, null);
    }

    public final void removeWsStatusListener(@NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r1) {
        Intrinsics.f(r1, "listener");
        List<Function4<Integer, Integer, Integer, Boolean, Unit>> r0 = iWsStatusListeners;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void sendWsMsg(@NotNull WsMessageInfo r3, @NotNull final Function2<? super Integer, ? super Response, Unit> r4) {
        Intrinsics.f(r3, "wsMessageInfo");
        Intrinsics.f(r4, "listener");
        SendWsMessageRequest r2 = new SendWsMessageRequest.Builder().wsMessageInfo(r3).build();     // Catch: Exception -> L5
        Request.Builder r5 = new Request.Builder();     // Catch: Exception -> L5
        MATRIX_CMD r0 = MATRIX_CMD.CMD_SEND_WS_MESSAGE;     // Catch: Exception -> L5
        Request r6 = r5.cmd(Integer.valueOf(r0.getValue())).body(new RequestBody.Builder().sendWsMessageRequest(r2).build()).build();     // Catch: Exception -> L5
        CmdManager r7 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r1 = r0.getValue();     // Catch: Exception -> L5
        Intrinsics.e(r6, "request");     // Catch: Exception -> L5
        r7.sendCmd(r1, r6, new MatrixWsHelper$sendWsMsg$1$1$1(r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "sendWsMsg() with Exception: " + e, null, 4, null);
    }

    public final void subscribeWsMsg(int r2, int r3, @NotNull String r4, int r5) {
        Intrinsics.f(r4, "packageName");
        SubscribeWsMsgRequest r6 = new SubscribeWsMsgRequest.Builder().service(Integer.valueOf(r2)).method(Integer.valueOf(r3)).packageName(r4).opt(Integer.valueOf(r5)).build();     // Catch: Exception -> L5
        Request.Builder r7 = new Request.Builder();     // Catch: Exception -> L5
        MATRIX_CMD r8 = MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG;     // Catch: Exception -> L5
        Request r9 = r7.cmd(Integer.valueOf(r8.getValue())).body(new RequestBody.Builder().subscribeWsMsgRequest(r6).build()).build();     // Catch: Exception -> L5
        CmdManager r10 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r11 = r8.getValue();     // Catch: Exception -> L5
        Intrinsics.e(r9, "request");     // Catch: Exception -> L5
        r10.sendCmd(r11, r9, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsMsg() with Exception: " + e, null, 4, null);
    }

    public final void subscribeWsMsgByBroadCast(final int r10, final int r11, @NotNull final String r12, final int r13, @NotNull final Function2<? super Boolean, ? super Response, Unit> r14) {
        Intrinsics.f(r12, "packageName");
        Intrinsics.f(r14, "subscribeResultCallBack");
        SubscribeWsMsgByBroadCastRequest r9 = new SubscribeWsMsgByBroadCastRequest.Builder().service(Integer.valueOf(r10)).method(Integer.valueOf(r11)).packageName(r12).opt(Integer.valueOf(r13)).build();     // Catch: Exception -> L5
        Request.Builder r0 = new Request.Builder();     // Catch: Exception -> L5
        MATRIX_CMD r1 = MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_BROADCAST;     // Catch: Exception -> L5
        Request r15 = r0.cmd(Integer.valueOf(r1.getValue())).body(new RequestBody.Builder().subscribeWsMsgByBroadCastRequest(r9).build()).build();     // Catch: Exception -> L5
        CmdManager r2 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r3 = r1.getValue();     // Catch: Exception -> L5
        Intrinsics.e(r15, "request");     // Catch: Exception -> L5
        r2.sendCmd(r3, r15, new AnonymousClass1(r14, r10, r11, r12, r13));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsMsgByBroadCast() with Exception: " + e, null, 4, null);
        r14.mo7invoke(Boolean.FALSE, null);
    }

    public final void subscribeWsMsgByCallBack(final int r10, final int r11, final int r12, @Nullable final Function9<? super Integer, ? super Long, ? super Long, ? super Integer, ? super Integer, ? super String, ? super String, ? super byte[], ? super Map<String, String>, Unit> r13, @NotNull final Function2<? super Boolean, ? super Response, Unit> r14) {
        Intrinsics.f(r14, "subscribeResultCallBack");
        SubscribeWsMsgByCallBackRequest r9 = new SubscribeWsMsgByCallBackRequest.Builder().service(Integer.valueOf(r10)).method(Integer.valueOf(r11)).packageName("").opt(Integer.valueOf(r12)).build();     // Catch: Exception -> L5
        Request.Builder r0 = new Request.Builder();     // Catch: Exception -> L5
        MATRIX_CMD r1 = MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK;     // Catch: Exception -> L5
        Request r15 = r0.cmd(Integer.valueOf(r1.getValue())).body(new RequestBody.Builder().subscribeWsMsgByCallBackRequest(r9).build()).build();     // Catch: Exception -> L5
        CmdManager r2 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r3 = r1.getValue();     // Catch: Exception -> L5
        Intrinsics.e(r15, "request");     // Catch: Exception -> L5
        r2.sendCmd(r3, r15, new C00351(r14, r10, r11, r12, r13));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsMsgByCallBack() with Exception: " + e, null, 4, null);
        r14.mo7invoke(Boolean.FALSE, null);
    }

    public final void subscribeWsMsgByProvider(int r1, int r2, @NotNull String r3, int r4, @NotNull final Function2<? super Boolean, ? super Response, Unit> r5) {
        Intrinsics.f(r3, "packageName");
        Intrinsics.f(r5, "subscribeResultCallBack");
        SubscribeWsMsgByProviderRequest r0 = new SubscribeWsMsgByProviderRequest.Builder().service(Integer.valueOf(r1)).method(Integer.valueOf(r2)).packageName(r3).opt(Integer.valueOf(r4)).build();     // Catch: Exception -> L5
        Request.Builder r6 = new Request.Builder();     // Catch: Exception -> L5
        MATRIX_CMD r7 = MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_PROVIDER;     // Catch: Exception -> L5
        Request r8 = r6.cmd(Integer.valueOf(r7.getValue())).body(new RequestBody.Builder().subscribeWsMsgByProviderRequest(r0).build()).build();     // Catch: Exception -> L5
        r8.encode();     // Catch: Exception -> L5
        CmdManager.INSTANCE.sendCmd(r7.getValue(), r8, new C00361(r5));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsMsgByProvider() with Exception: " + e, null, 4, null);
        r5.mo7invoke(Boolean.FALSE, null);
    }

    public final void subscribeWsMsgWithCallback(int r2, int r3, int r4, @Nullable Function9<? super Integer, ? super Long, ? super Long, ? super Integer, ? super Integer, ? super String, ? super String, ? super byte[], ? super Map<String, String>, Unit> r5) {
        ConcurrentHashMap<String, Function9<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, Unit>> r1 = iWsMsgListeners;
        monitor-enter(r1);
        if (r4 != 1) goto L10;
        if (r5 == null) goto L10;
        Function9<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, Unit> r6 = r1.put(MatrixWsHelperKt.access$getKey(r2, r3), r5);     // Catch: Throwable -> L8
    L12:
        monitor-exit(r1);
        SubscribeWsMsgRequest r7 = new SubscribeWsMsgRequest.Builder().service(Integer.valueOf(r2)).method(Integer.valueOf(r3)).packageName("").opt(Integer.valueOf(r4)).build();     // Catch: Exception -> L15
        Request.Builder r8 = new Request.Builder();     // Catch: Exception -> L15
        MATRIX_CMD r9 = MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG;     // Catch: Exception -> L15
        Request r10 = r8.cmd(Integer.valueOf(r9.getValue())).body(new RequestBody.Builder().subscribeWsMsgRequest(r7).build()).build();     // Catch: Exception -> L15
        r10.encode();     // Catch: Exception -> L15
        CmdManager.INSTANCE.sendCmd(r9.getValue(), r10, wsMsgCallbackFromMatrix);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsMsgWithCallback() with Exception: " + e, null, 4, null);
        iWsMsgListeners.remove(MatrixWsHelperKt.access$getKey(r2, r3));
        return;
    L10:
        if (r4 != 0) goto L20;
        Function9<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, Unit> r11 = r1.remove(MatrixWsHelperKt.access$getKey(r2, r3));     // Catch: Throwable -> L8
        goto L12
    L20:
        monitor-exit(r1);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void subscribeWsStatus(@Nullable Context r4) {
        SubscribeWsStatusRequest.Builder r3 = new SubscribeWsStatusRequest.Builder().opt(1);     // Catch: Exception -> L5
        if (r4 != null) goto L7;
        String r0 = "";
    L8:
        SubscribeWsStatusRequest r5 = r3.packageName(r0).build();     // Catch: Exception -> L5
        Request.Builder r1 = new Request.Builder();     // Catch: Exception -> L5
        MATRIX_CMD r2 = MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS;     // Catch: Exception -> L5
        Request r6 = r1.cmd(Integer.valueOf(r2.getValue())).body(new RequestBody.Builder().subscribeWsStatusRequest(r5).build()).build();     // Catch: Exception -> L5
        CmdManager r7 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r8 = r2.getValue();     // Catch: Exception -> L5
        Intrinsics.e(r6, "request");     // Catch: Exception -> L5
        r7.sendCmd(r8, r6, wsStatusCallbackFromMatrix);     // Catch: Exception -> L5
        if (r4 == null) goto L16;
        WsStatusReceiver r9 = wsStatusReceiverFromMatrix;     // Catch: Exception -> L5
        IntentFilter r10 = new IntentFilter();     // Catch: Exception -> L5
        r10.addAction(WsStatusReceiver.WS_STATUS_BROADCAST_ACTION);     // Catch: Exception -> L5
        r4.registerReceiver(r9, r10);     // Catch: Exception -> L5
        return;
    L16:
        return;
    L7:
        r0 = r4.getPackageName();     // Catch: Exception -> L5
    L5:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsStatus() with Exception: " + e, null, 4, null);
    }

    public static /* synthetic */ void subscribeWsStatus$default(MatrixWsHelper r0, Context r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.subscribeWsStatus(r1, r2);
    }

    public final void removeSubscribeWsStatus(@NotNull Context r2, @NotNull Function2<? super Boolean, ? super Response, Unit> r3) {
        Intrinsics.f(r2, "context");
        Intrinsics.f(r3, "subscribeResultCallBack");
        removeSubscribeWsStatus(r2);
        wsStatusSubscribeResultCallBack = r3;
    }

    public final void subscribeWsStatus(@Nullable Context r2, @NotNull Function2<? super Boolean, ? super Response, Unit> r3) {
        Intrinsics.f(r3, "subscribeResultCallBack");
        subscribeWsStatus(r2);
        wsStatusSubscribeResultCallBack = r3;
    }
}
