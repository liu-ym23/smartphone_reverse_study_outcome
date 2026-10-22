package com.obric.matrix.platform.sdk.ones.ws;

import android.content.Context;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
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

/* JADX INFO: compiled from: WsApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0012\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jj\u0010\u0003\u001a\u00020\u00042`\u0010\u0005\u001a\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u0006H\u0007J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\b\u0010\u0012\u001a\u00020\rH\u0007JJ\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u001528\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0017H\u0007Jj\u0010\u001b\u001a\u00020\u00042`\u0010\u0005\u001a\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u0006H\u0007JH\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e26\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u0017H\u0007Jb\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000728\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u0017H\u0007Jº\u0001\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072^\u0010'\u001aZ\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0018\u00010+\u0012\u0004\u0012\u00020\u0004\u0018\u00010(j\u0004\u0018\u0001`,28\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u0017H\u0007Jb\u0010-\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000728\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u0017H\u0007JN\u0010.\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u001528\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0017H\u0007¨\u0006/"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsApi;", "", "()V", "addWsStatusListener", "", "listener", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "channelType", "connectionState", "channelId", "", "isConnected", "init", "iWsBridge", "Lcom/obric/matrix/platform/sdk/ones/ws/IWsBridge;", "isWsConnected", "removeSubscribeWsStatus", "context", "Landroid/content/Context;", "subscribeResultCallBack", "Lkotlin/Function2;", "success", "Lcom/obric/matrix/proto/Response;", ApmTrafficStats.TTNET_RESPONSE, "removeWsStatusListener", "sendWsMsg", "wsMessageInfo", "Lcom/obric/matrix/proto/WsMessageInfo;", EventConstants.EVENT_KEY_CMD, "subscribeWsMsgByBroadCast", "service", "method", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "", "opt", "subscribeWsMsgByCallBack", "wsMsgCallBack", "Lkotlin/Function9;", "", "", "", "Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgCallBack;", "subscribeWsMsgByProvider", "subscribeWsStatus", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WsApi {
    public static final WsApi INSTANCE = null;

    static {
        INSTANCE = new WsApi();
    }

    private WsApi() {
    }

    @JvmStatic
    public static final void init(IWsBridge r1) {
        MatrixWsHelper.INSTANCE.init(r1);
    }

    @JvmStatic
    public static final void sendWsMsg(WsMessageInfo r1, Function2<? super Integer, ? super Response, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "wsMessageInfo");
        Intrinsics.checkNotNullParameter(r2, "listener");
        MatrixWsHelper.INSTANCE.sendWsMsg(r1, r2);
    }

    @JvmStatic
    public static final boolean isWsConnected() {
        return MatrixWsHelper.INSTANCE.isWsConnected();
    }

    public static /* synthetic */ void subscribeWsStatus$default(Context r0, Function2 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r0 = null;
    L5:
        subscribeWsStatus(r0, r1);
    }

    @JvmStatic
    public static final void subscribeWsStatus(Context r1, Function2<? super Boolean, ? super Response, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "subscribeResultCallBack");
        MatrixWsHelper.INSTANCE.subscribeWsStatus(r1, r2);
    }

    @JvmStatic
    public static final void removeSubscribeWsStatus(Context r1, Function2<? super Boolean, ? super Response, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "subscribeResultCallBack");
        MatrixWsHelper.INSTANCE.removeSubscribeWsStatus(r1, r2);
    }

    @JvmStatic
    public static final void subscribeWsMsgByProvider(int r7, int r8, String r9, int r10, Function2<? super Boolean, ? super Response, Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r11, "subscribeResultCallBack");
        MatrixWsHelper.INSTANCE.subscribeWsMsgByProvider(r7, r8, r9, r10, r11);
    }

    @JvmStatic
    public static final void subscribeWsMsgByCallBack(int r7, int r8, int r9, Function9<? super Integer, ? super Long, ? super Long, ? super Integer, ? super Integer, ? super String, ? super String, ? super byte[], ? super Map<String, String>, Unit> r10, Function2<? super Boolean, ? super Response, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "subscribeResultCallBack");
        MatrixWsHelper.INSTANCE.subscribeWsMsgByCallBack(r7, r8, r9, r10, r11);
    }

    @JvmStatic
    public static final void subscribeWsMsgByBroadCast(int r7, int r8, String r9, int r10, Function2<? super Boolean, ? super Response, Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r11, "subscribeResultCallBack");
        MatrixWsHelper.INSTANCE.subscribeWsMsgByBroadCast(r7, r8, r9, r10, r11);
    }

    @JvmStatic
    public static final void addWsStatusListener(Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        MatrixWsHelper.INSTANCE.addWsStatusListener(r1);
    }

    @JvmStatic
    public static final void removeWsStatusListener(Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        MatrixWsHelper.INSTANCE.removeWsStatusListener(r1);
    }
}
