package com.obric.matrix.platform.sdk.ones.ws;

import android.content.Context;
import android.content.IntentFilter;
import com.GlobalProxyLancet;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.capabilitykit.common.Ext;
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

/* JADX INFO: compiled from: MatrixWsHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0012\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u001b\u001e\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jh\u0010%\u001a\u00020\f2`\u0010&\u001a\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u000fJ\u0010\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010\u0019J\u001c\u0010)\u001a\u00020\f2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0*H\u0007J\u0006\u0010\u0017\u001a\u00020\u0015J{\u0010+\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\n2&\u00103\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000104j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`5H\u0000¢\u0006\u0002\b6J\u000e\u00107\u001a\u00020\f2\u0006\u00108\u001a\u000209J*\u00107\u001a\u00020\f2\u0006\u00108\u001a\u0002092\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\f0#Jh\u0010;\u001a\u00020\f2`\u0010&\u001a\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u000fJ(\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020>2\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\f0#J&\u0010?\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\bJd\u0010B\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\b2<\u0010:\u001a8\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(C\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\f0#j\u0002`EJ¼\u0001\u0010F\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2^\u0010G\u001aZ\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`H2<\u0010:\u001a8\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(C\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\f0#j\u0002`EJd\u0010I\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\b2<\u0010:\u001a8\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(C\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\f0#j\u0002`EJ~\u0010J\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2^\u0010&\u001aZ\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`HJ\u0012\u0010K\u001a\u00020\f2\n\b\u0002\u00108\u001a\u0004\u0018\u000109J.\u0010K\u001a\u00020\f2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\f0#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000Rj\u0010\u0005\u001a^\u0012\u0004\u0012\u00020\u0004\u0012T\u0012R\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000Rn\u0010\r\u001ab\u0012^\u0012\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper;", "", "()V", "TAG", "", "iWsMsgListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function9;", "", "", "", "", "", "iWsStatusListeners", "", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "channelType", "connectionState", "channelId", "", "isConnected", "isWsConnected", "wsBridge", "Lcom/obric/matrix/platform/sdk/ones/ws/IWsBridge;", "wsMsgCallbackFromMatrix", "com/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper$wsMsgCallbackFromMatrix$1", "Lcom/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper$wsMsgCallbackFromMatrix$1;", "wsStatusCallbackFromMatrix", "com/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper$wsStatusCallbackFromMatrix$1", "Lcom/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper$wsStatusCallbackFromMatrix$1;", "wsStatusReceiverFromMatrix", "Lcom/obric/matrix/platform/sdk/ones/ws/WsStatusReceiver;", "wsStatusSubscribeResultCallBack", "Lkotlin/Function2;", "Lcom/obric/matrix/proto/Response;", "addWsStatusListener", "listener", "init", "iWsBridge", "isSupportMatrixWs", "Lkotlin/Function1;", "onWsMsgReceivedByProvider", "seqId", "logId", "service", "method", "encoding", "type", "payload", "headers", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onWsMsgReceivedByProvider$sdk_platform_ones_release", "removeSubscribeWsStatus", "context", "Landroid/content/Context;", "subscribeResultCallBack", "removeWsStatusListener", "sendWsMsg", "wsMessageInfo", "Lcom/obric/matrix/proto/WsMessageInfo;", "subscribeWsMsg", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "opt", "subscribeWsMsgByBroadCast", "success", ApmTrafficStats.TTNET_RESPONSE, "Lcom/obric/matrix/platform/sdk/ones/ws/SubscribeResultCallBack;", "subscribeWsMsgByCallBack", "wsMsgCallBack", "Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgCallBack;", "subscribeWsMsgByProvider", "subscribeWsMsgWithCallback", "subscribeWsStatus", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixWsHelper {
    public static final MatrixWsHelper INSTANCE = null;
    private static final String TAG = "MatrixWsHelper";
    private static final ConcurrentHashMap<String, Function9<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, Unit>> iWsMsgListeners = null;
    private static final List<Function4<Integer, Integer, Integer, Boolean, Unit>> iWsStatusListeners = null;
    private static boolean isWsConnected;
    private static IWsBridge wsBridge;
    private static final MatrixWsHelper$wsMsgCallbackFromMatrix$1 wsMsgCallbackFromMatrix = null;
    private static final MatrixWsHelper$wsStatusCallbackFromMatrix$1 wsStatusCallbackFromMatrix = null;
    private static final WsStatusReceiver wsStatusReceiverFromMatrix = null;
    private static Function2<? super Boolean, ? super Response, Unit> wsStatusSubscribeResultCallBack;

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

    public final void init(IWsBridge r4) {
        MLog.d$default(TAG, "init() called", null, 4, null);
        wsBridge = r4;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.matrix.platform.sdk.ones.ws.MatrixWsHelper$wsMsgCallbackFromMatrix$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.matrix.platform.sdk.ones.ws.MatrixWsHelper$wsStatusCallbackFromMatrix$1] */
    static {
        INSTANCE = new MatrixWsHelper();
        iWsStatusListeners = new ArrayList();
        iWsMsgListeners = new ConcurrentHashMap();
        wsMsgCallbackFromMatrix = new MatrixWsHelper$wsMsgCallbackFromMatrix$1();
        wsStatusCallbackFromMatrix = new MatrixWsHelper$wsStatusCallbackFromMatrix$1();
        wsStatusReceiverFromMatrix = new WsStatusReceiver(MatrixWsHelper$wsStatusReceiverFromMatrix$1.INSTANCE);
    }

    @Deprecated(message = "待移除")
    public final void isSupportMatrixWs(final Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        Request r0 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue())).body(new RequestBody.Builder().sendWsMessageRequest(new SendWsMessageRequest.Builder().wsMessageInfo(null).build()).build()).build();     // Catch: Exception -> L5
        CmdManager r1 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r2 = MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r0, Ext.KEY_REQUEST);     // Catch: Exception -> L5
        r1.sendCmd(r2, r0, new MatrixWsHelper$isSupportMatrixWs$1$1$1(r5));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "isSupportMatrixWs() with Exception: " + e, null, 4, null);
        r5.invoke(false);
    }

    public final void sendWsMsg(WsMessageInfo r3, final Function2<? super Integer, ? super Response, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "wsMessageInfo");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Request r2 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue())).body(new RequestBody.Builder().sendWsMessageRequest(new SendWsMessageRequest.Builder().wsMessageInfo(r3).build()).build()).build();     // Catch: Exception -> L5
        CmdManager r5 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r0 = MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r2, Ext.KEY_REQUEST);     // Catch: Exception -> L5
        r5.sendCmd(r0, r2, new MatrixWsHelper$sendWsMsg$1$1$1(r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "sendWsMsg() with Exception: " + e, null, 4, null);
    }

    public final void subscribeWsMsgWithCallback(int r2, int r3, int r4, Function9<? super Integer, ? super Long, ? super Long, ? super Integer, ? super Integer, ? super String, ? super String, ? super byte[], ? super Map<String, String>, Unit> r5) {
        ConcurrentHashMap<String, Function9<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, Unit>> r1 = iWsMsgListeners;
        monitor-enter(r1);
        if (r4 != 1) goto L8;
        if (r5 == null) goto L8;
        Function9<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, Unit> r6 = r1.put(MatrixWsHelperKt.access$getKey(r2, r3), r5);     // Catch: Throwable -> L16
    L10:
        monitor-exit(r1);
        Request r7 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue())).body(new RequestBody.Builder().subscribeWsMsgRequest(new SubscribeWsMsgRequest.Builder().service(Integer.valueOf(r2)).method(Integer.valueOf(r3)).packageName("").opt(Integer.valueOf(r4)).build()).build()).build();     // Catch: Exception -> L13
        r7.encode();     // Catch: Exception -> L13
        CmdManager r8 = CmdManager.INSTANCE;     // Catch: Exception -> L13
        int r9 = MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue();     // Catch: Exception -> L13
        Intrinsics.checkNotNullExpressionValue(r7, Ext.KEY_REQUEST);     // Catch: Exception -> L13
        r8.sendCmd(r9, r7, wsMsgCallbackFromMatrix);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsMsgWithCallback() with Exception: " + e, null, 4, null);
        iWsMsgListeners.remove(MatrixWsHelperKt.access$getKey(r2, r3));
        return;
    L8:
        if (r4 != 0) goto L19;
        Function9<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, Unit> r10 = r1.remove(MatrixWsHelperKt.access$getKey(r2, r3));     // Catch: Throwable -> L16
        goto L10
    L19:
        monitor-exit(r1);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void subscribeWsMsg(int r2, int r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Request r6 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue())).body(new RequestBody.Builder().subscribeWsMsgRequest(new SubscribeWsMsgRequest.Builder().service(Integer.valueOf(r2)).method(Integer.valueOf(r3)).packageName(r4).opt(Integer.valueOf(r5)).build()).build()).build();     // Catch: Exception -> L5
        CmdManager r7 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r8 = MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r6, Ext.KEY_REQUEST);     // Catch: Exception -> L5
        r7.sendCmd(r8, r6, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsMsg() with Exception: " + e, null, 4, null);
    }

    public final boolean isWsConnected() {
        return isWsConnected;
    }

    public static /* synthetic */ void subscribeWsStatus$default(MatrixWsHelper r0, Context r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.subscribeWsStatus(r1);
    }

    public final void subscribeWsStatus(Context r4) {
        SubscribeWsStatusRequest.Builder r3 = new SubscribeWsStatusRequest.Builder().opt(1);     // Catch: Exception -> L10
        if (r4 != null) goto L5;
        String r0 = "";
    L6:
        Request r5 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue())).body(new RequestBody.Builder().subscribeWsStatusRequest(r3.packageName(r0).build()).build()).build();     // Catch: Exception -> L10
        CmdManager r1 = CmdManager.INSTANCE;     // Catch: Exception -> L10
        int r2 = MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue();     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r5, Ext.KEY_REQUEST);     // Catch: Exception -> L10
        r1.sendCmd(r2, r5, wsStatusCallbackFromMatrix);     // Catch: Exception -> L10
        if (r4 == null) goto L15;
        WsStatusReceiver r6 = wsStatusReceiverFromMatrix;     // Catch: Exception -> L10
        IntentFilter r7 = new IntentFilter();     // Catch: Exception -> L10
        r7.addAction(WsStatusReceiver.WS_STATUS_BROADCAST_ACTION);     // Catch: Exception -> L10
        Unit r8 = Unit.INSTANCE;     // Catch: Exception -> L10
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r4, r6, r7);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L5:
        r0 = r4.getPackageName();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsStatus() with Exception: " + e, null, 4, null);
    }

    public final void removeSubscribeWsStatus(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Request r3 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue())).body(new RequestBody.Builder().subscribeWsStatusRequest(new SubscribeWsStatusRequest.Builder().opt(0).packageName(r4.getPackageName()).build()).build()).build();     // Catch: Exception -> L5
        CmdManager r0 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r1 = MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r3, Ext.KEY_REQUEST);     // Catch: Exception -> L5
        r0.sendCmd(r1, r3, wsStatusCallbackFromMatrix);     // Catch: Exception -> L5
        r4.unregisterReceiver(wsStatusReceiverFromMatrix);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "removeSubscribeWsStatus() with Exception: " + e, null, 4, null);
    }

    public final void addWsStatusListener(Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        List<Function4<Integer, Integer, Integer, Boolean, Unit>> r1 = iWsStatusListeners;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r1.contains(r2) == true) goto L7;
        r1.add(r2);     // Catch: Throwable -> L10
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r1);
    }

    public final void removeWsStatusListener(Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        List<Function4<Integer, Integer, Integer, Boolean, Unit>> r0 = iWsStatusListeners;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void onWsMsgReceivedByProvider$sdk_platform_ones_release(int r16, long r17, long r19, int r21, int r22, String r23, String r24, byte[] r25, HashMap<String, String> r26) {
        MLog.d$default(TAG, "onWsMsgReceivedByProvider() called with: channelId = " + r16 + ", seqId = " + r17 + ", logId = " + r19 + ", service = " + r21 + ", method = " + r22 + ", encoding = " + r23 + ", type = " + r24 + ", payload = " + r25 + ", headers = " + r26 + ", wsBridge is " + wsBridge, null, 4, null);
        IWsBridge r3 = wsBridge;
        if (r3 == null) goto L6;
        r3.onWsMsgReceived(r16, r17, r19, r21, r22, r23, r24, r25, r26);
        return;
    }

    public static /* synthetic */ void subscribeWsStatus$default(MatrixWsHelper r0, Context r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.subscribeWsStatus(r1, r2);
    }

    public final void subscribeWsStatus(Context r2, Function2<? super Boolean, ? super Response, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "subscribeResultCallBack");
        subscribeWsStatus(r2);
        wsStatusSubscribeResultCallBack = r3;
    }

    public final void removeSubscribeWsStatus(Context r2, Function2<? super Boolean, ? super Response, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "subscribeResultCallBack");
        removeSubscribeWsStatus(r2);
        wsStatusSubscribeResultCallBack = r3;
    }

    public final void subscribeWsMsgByProvider(int r1, int r2, String r3, int r4, final Function2<? super Boolean, ? super Response, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r5, "subscribeResultCallBack");
        Request r0 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_PROVIDER.getValue())).body(new RequestBody.Builder().subscribeWsMsgByProviderRequest(new SubscribeWsMsgByProviderRequest.Builder().service(Integer.valueOf(r1)).method(Integer.valueOf(r2)).packageName(r3).opt(Integer.valueOf(r4)).build()).build()).build();     // Catch: Exception -> L5
        r0.encode();     // Catch: Exception -> L5
        CmdManager r6 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r7 = MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_PROVIDER.getValue();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r0, Ext.KEY_REQUEST);     // Catch: Exception -> L5
        r6.sendCmd(r7, r0, new C02361(r5));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsMsgByProvider() with Exception: " + e, null, 4, null);
        r5.invoke(false, null);
    }

    public final void subscribeWsMsgByCallBack(final int r10, final int r11, final int r12, final Function9<? super Integer, ? super Long, ? super Long, ? super Integer, ? super Integer, ? super String, ? super String, ? super byte[], ? super Map<String, String>, Unit> r13, final Function2<? super Boolean, ? super Response, Unit> r14) {
        Intrinsics.checkNotNullParameter(r14, "subscribeResultCallBack");
        Request r9 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK.getValue())).body(new RequestBody.Builder().subscribeWsMsgByCallBackRequest(new SubscribeWsMsgByCallBackRequest.Builder().service(Integer.valueOf(r10)).method(Integer.valueOf(r11)).packageName("").opt(Integer.valueOf(r12)).build()).build()).build();     // Catch: Exception -> L5
        CmdManager r0 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r1 = MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK.getValue();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r9, Ext.KEY_REQUEST);     // Catch: Exception -> L5
        r0.sendCmd(r1, r9, new C02351(r14, r10, r11, r12, r13));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsMsgByCallBack() with Exception: " + e, null, 4, null);
        r14.invoke(false, null);
    }

    public final void subscribeWsMsgByBroadCast(final int r10, final int r11, final String r12, final int r13, final Function2<? super Boolean, ? super Response, Unit> r14) {
        Intrinsics.checkNotNullParameter(r12, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r14, "subscribeResultCallBack");
        Request r9 = new Request.Builder().cmd(Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_BROADCAST.getValue())).body(new RequestBody.Builder().subscribeWsMsgByBroadCastRequest(new SubscribeWsMsgByBroadCastRequest.Builder().service(Integer.valueOf(r10)).method(Integer.valueOf(r11)).packageName(r12).opt(Integer.valueOf(r13)).build()).build()).build();     // Catch: Exception -> L5
        CmdManager r0 = CmdManager.INSTANCE;     // Catch: Exception -> L5
        int r1 = MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_BROADCAST.getValue();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r9, Ext.KEY_REQUEST);     // Catch: Exception -> L5
        r0.sendCmd(r1, r9, new AnonymousClass1(r14, r10, r11, r12, r13));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e$default(TAG, "subscribeWsMsgByBroadCast() with Exception: " + e, null, 4, null);
        r14.invoke(false, null);
    }
}
