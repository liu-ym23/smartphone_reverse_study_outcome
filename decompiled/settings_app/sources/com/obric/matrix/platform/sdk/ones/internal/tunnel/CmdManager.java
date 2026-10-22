package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.ResultReceiver;
import android.util.Log;
import com.android.vcard.VCardConfig;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.obric.capabilitykit.common.Ext;
import com.obric.matrix.platform.sdk.ones.IMatrixBridge;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.SendCMDResultCallback;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.matrix.platform.sdk.ones.internal.config.SdkConfigManager;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.obric.matrix.platform.sdk.ones.internal.monitor.ReportMonitorHelper;
import com.obric.matrix.platform.sdk.ones.internal.monitor.SdkErrorCode;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.server.IServerBroker;
import com.obric.matrix.platform.server.IServerCallback;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Request;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.SdkAllConfig;
import com.obric.matrix.proto.SdkSendCmdConfig;
import cz.msebera.android.httpclient.message.TokenParser;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.schedulers.Schedulers;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CmdManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JL\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u001a\u0010\u001b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\r\u0010&\u001a\u00020\u0019H\u0000¢\u0006\u0002\b'J@\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u001a\u0010\u001b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J2\u0010+\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u001d0\u001cH\u0002J \u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\"\u0010-\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010.\u001a\u00020*2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0018\u0010/\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J*\u00100\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010.\u001a\u00020*2\u0006\u00101\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\"\u00102\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0015\u00103\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0007H\u0000¢\u0006\u0002\b4J\r\u00105\u001a\u00020\u0019H\u0000¢\u0006\u0002\b6Jf\u00107\u001a\u00020\u0019*\u0004\u0018\u0001082\u0006\u0010\u001a\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<2:\b\u0002\u0010=\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0019\u0018\u00010>H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0011j\b\u0012\u0004\u0012\u00020\u0007`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0011j\b\u0012\u0004\u0012\u00020\u0007`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/CmdManager;", "", "()V", "ACTION_BY_SDK", "", "AUTHORITY", "DEFAULT_CALLBACK_TIMEOUT", "", "KEY_MATRIX_CMD", "KEY_PENDING_INTENT", "KEY_REQUEST_BYTE_ARRAY", "KEY_RESPONSE_BYTE_ARRAY", "KEY_RESULT_RECEIVER", CmdManager.SEND_CMD_BY_PROVIDER, "SEND_CMD_BY_PROVIDER_URI", "TAG", "forceUseOldBindSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mCustomTimeout", "notTimeoutCmdSet", "sendCmdTimeout", "useBinderCMDList", "", "handleSendCMDByBinderFail", "", EventConstants.EVENT_KEY_CMD, "emitter", "Lio/reactivex/MaybeEmitter;", "Lkotlin/Pair;", "Lcom/obric/matrix/proto/Response;", "sendCMDResultCallback", "Lcom/obric/matrix/platform/sdk/ones/SendCMDResultCallback;", AccountConst.KEY_ERROR_CODE, AccountConst.KEY_ERROR_MSG, "handlerSendCmdException", "it", "", "init", "init$sdk_platform_ones_release", "sendCMDByBind", Ext.KEY_REQUEST, "Lcom/obric/matrix/proto/Request;", "sendCMDByIntentService", "sendCmd", "sendCmdForceUseBinder", "newRequest", "sendCmdSync", "sendCmdWithTimeout", "timeout", "sendCmdWithoutTimeout", "setCustomTimeout", "setCustomTimeout$sdk_platform_ones_release", "updateConfig", "updateConfig$sdk_platform_ones_release", "invokeAsyncSafely", "Lcom/obric/matrix/platform/server/IServerBroker;", "bytes", "", "callback", "Lcom/obric/matrix/platform/server/IServerCallback;", "onError", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CmdManager {
    private static final String ACTION_BY_SDK = "com.obric.matrix.sdk.intent.service.auth.token.action";
    private static final String AUTHORITY = "com.obric.matrix.sdk.cmd.handler.provider";
    private static final int DEFAULT_CALLBACK_TIMEOUT = 35;
    public static final CmdManager INSTANCE = null;
    private static final String KEY_MATRIX_CMD = "MATRIX_CMD";
    private static final String KEY_PENDING_INTENT = "PENDING_INTENT";
    private static final String KEY_REQUEST_BYTE_ARRAY = "REQUEST_BYTE_ARRAY";
    private static final String KEY_RESPONSE_BYTE_ARRAY = "RESPONSE_BYTE_ARRAY";
    private static final String KEY_RESULT_RECEIVER = "RESULT_RECEIVER";
    private static final String SEND_CMD_BY_PROVIDER = "SEND_CMD_BY_PROVIDER";
    private static final String SEND_CMD_BY_PROVIDER_URI = "content://com.obric.matrix.sdk.cmd.handler.provider/SEND_CMD_BY_PROVIDER";
    private static final String TAG = "CmdManager";
    private static final HashSet<Integer> forceUseOldBindSet = null;
    private static int mCustomTimeout;
    private static HashSet<Integer> notTimeoutCmdSet;
    private static int sendCmdTimeout;
    private static List<Integer> useBinderCMDList;

    /* JADX INFO: renamed from: $r8$lambda$-SHjzwV1HWj4gGfICpQqQQRWFiM, reason: not valid java name */
    public static /* synthetic */ void m1025$r8$lambda$SHjzwV1HWj4gGfICpQqQQRWFiM(int r0, Request r1, MaybeEmitter r2) {
        m1030sendCmdWithTimeout$lambda3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$3Jb4fkbofxZ7vKmOwc-qjB2zMtY, reason: not valid java name */
    public static /* synthetic */ void m1026$r8$lambda$3Jb4fkbofxZ7vKmOwcqjB2zMtY(SendCMDResultCallback r0, int r1, Throwable r2) {
        m1032sendCmdWithTimeout$lambda5(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$DlbvBcJmTVOwMCYsri8RZ59x1lo(SendCMDResultCallback r0, int r1, Throwable r2) {
        m1035sendCmdWithoutTimeout$lambda8(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$EEUtfn8pO12ofyyCk1-Y3ucRrGY, reason: not valid java name */
    public static /* synthetic */ void m1027$r8$lambda$EEUtfn8pO12ofyyCk1Y3ucRrGY(SendCMDResultCallback r0, Pair r1) {
        m1031sendCmdWithTimeout$lambda4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$mE2W8nIuidLRIV1SSlE6vxLSICU(SendCMDResultCallback r0, Pair r1) {
        m1034sendCmdWithoutTimeout$lambda7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$sF7TVIoT8txJXAyPt3NAlBPC7Us() {
        m1029init$lambda0();
    }

    /* JADX INFO: renamed from: $r8$lambda$wbgfK9MV7wCTEp9EATB6mwy-1Og, reason: not valid java name */
    public static /* synthetic */ void m1028$r8$lambda$wbgfK9MV7wCTEp9EATB6mwy1Og(int r0, Request r1, MaybeEmitter r2) {
        m1033sendCmdWithoutTimeout$lambda6(r0, r1, r2);
    }

    private CmdManager() {
    }

    public static final /* synthetic */ void access$handleSendCMDByBinderFail(CmdManager r0, int r1, MaybeEmitter r2, SendCMDResultCallback r3, int r4, String r5) {
        r0.handleSendCMDByBinderFail(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void access$invokeAsyncSafely(CmdManager r0, IServerBroker r1, int r2, byte[] r3, IServerCallback r4, Function2 r5) {
        r0.invokeAsyncSafely(r1, r2, r3, r4, r5);
    }

    static {
        INSTANCE = new CmdManager();
        sendCmdTimeout = 35;
        forceUseOldBindSet = SetsKt.hashSetOf(new Integer[]{Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK.getValue()), Integer.valueOf(MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS.getValue())});
        useBinderCMDList = CollectionsKt.listOf(Integer.valueOf(MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue()));
        notTimeoutCmdSet = new HashSet();
    }

    public final void setCustomTimeout$sdk_platform_ones_release(int r1) {
        mCustomTimeout = r1;
    }

    public final void init$sdk_platform_ones_release() {
        ThreadPlus.submitRunnable(new CmdManager$$ExternalSyntheticLambda6());
    }

    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    private static final void m1029init$lambda0() {
        INSTANCE.updateConfig$sdk_platform_ones_release();
        DefaultServerBrokerImpl r0 = new DefaultServerBrokerImpl();
        MLog.d$default(TAG, "call on bind default  " + MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release() + " onbinder " + r0 + TokenParser.SP, null, 4, null);
        MatrixBinderManager.INSTANCE.callOnBind(r0);
    }

    public final void updateConfig$sdk_platform_ones_release() {
        if (MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release() != null) goto L6;
        MLog.d$default(TAG, "updateConfig, context is null", null, 4, null);
        return;
    L6:
        MLog.d$default(TAG, "start update cmd config", null, 4, null);
        SdkAllConfig r5 = SdkConfigManager.INSTANCE.getSdkAllConfig();
        if (r5 == null) goto L9;
        SdkSendCmdConfig r6 = r5.sdkSendCmdConfig;
    L10:
        if (r6 == null) goto L27;
        Integer r3 = r6.sendCmdTimeout;
        Intrinsics.checkNotNullExpressionValue(r3, "it.sendCmdTimeout");
        if (r3.intValue() <= 0) goto L14;
        Integer r4 = r6.sendCmdTimeout;
        Intrinsics.checkNotNullExpressionValue(r4, "it.sendCmdTimeout");
        sendCmdTimeout = r4.intValue();
        MLog.d$default(TAG, "update config sendCmdTimeout = " + sendCmdTimeout, null, 4, null);
    L14:
        List<Integer> r7 = r6.useBindCmd;
        if (r7 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == true) goto L23;
        List<Integer> r9 = r6.useBindCmd;
        Intrinsics.checkNotNullExpressionValue(r9, "it.useBindCmd");
        useBinderCMDList = r9;
    L23:
        List<Integer> r10 = r6.forceUseOldBindCmd;
        if (r10 == null) goto L28;
        Intrinsics.checkNotNullExpressionValue(r10, "forceUseOldBindCmd");
        HashSet<Integer> r11 = forceUseOldBindSet;
        r11.addAll(r10);
        MLog.d$default(TAG, "update forceUseOldBindCmd " + r11, null, 4, null);
        return;
    L28:
        return;
    L17:
        if (r7.isEmpty() == true) goto L20;
        r8 = false;
        goto L21
    L27:
        return;
    L9:
        r6 = null;
        goto L10
    }

    public final void sendCmd(int r5, Request r6, SendCMDResultCallback r7) {
        Intrinsics.checkNotNullParameter(r6, Ext.KEY_REQUEST);
        MatrixOnesSdk.INSTANCE.checkInit$sdk_platform_ones_release();
        int r0 = mCustomTimeout;
        if (r0 > 0) goto L9;
        r0 = sendCmdTimeout;
        if (r0 > 0) goto L9;
        r0 = 35;
    L9:
        String r1 = r6.appKey;
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L23;
        Request.Builder r8 = r6.newBuilder();
        IMatrixBridge r3 = MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release();
        if (r3 == null) goto L20;
        String r4 = r3.appId();
    L21:
        r6 = r8.appKey(r4).build();
        goto L23
    L20:
        r4 = null;
    L23:
        if (forceUseOldBindSet.contains(Integer.valueOf(r5)) == false) goto L26;
        Intrinsics.checkNotNullExpressionValue(r6, "newRequest");
        sendCmdForceUseBinder(r5, r6, r7);
        return;
    L26:
        if (notTimeoutCmdSet.contains(Integer.valueOf(r5)) == false) goto L28;
        Intrinsics.checkNotNullExpressionValue(r6, "newRequest");
        sendCmdWithoutTimeout(r5, r6, r7);
        return;
    L28:
        Intrinsics.checkNotNullExpressionValue(r6, "newRequest");
        sendCmdWithTimeout(r5, r6, r0, r7);
        return;
    L12:
        if (r1.length() == 0) goto L15;
        r2 = false;
        goto L16
    }

    private final void sendCmdWithTimeout(final int r2, final Request r3, int r4, final SendCMDResultCallback r5) {
        Maybe.create(new CmdManager$$ExternalSyntheticLambda3(r2, r3)).subscribeOn(Schedulers.computation()).timeout(r4, TimeUnit.SECONDS).subscribe(new CmdManager$$ExternalSyntheticLambda4(r5), new CmdManager$$ExternalSyntheticLambda5(r5, r2));
    }

    /* JADX INFO: renamed from: sendCmdWithTimeout$lambda-3, reason: not valid java name */
    private static final void m1030sendCmdWithTimeout$lambda3(int r8, Request r9, MaybeEmitter r10) {
        Intrinsics.checkNotNullParameter(r9, "$newRequest");
        Intrinsics.checkNotNullParameter(r10, "it");
        if (useBinderCMDList.contains(Integer.valueOf(r8)) == false) goto L5;
        sendCMDByBind$default(INSTANCE, r8, r9, r10, null, 8, null);
        return;
    L5:
        INSTANCE.sendCMDByIntentService(r8, r9, r10);
    }

    /* JADX INFO: renamed from: sendCmdWithTimeout$lambda-4, reason: not valid java name */
    private static final void m1031sendCmdWithTimeout$lambda4(SendCMDResultCallback r4, Pair r5) {
        MLog.d$default(TAG, "send cmd on result response " + r5.getSecond() + ", thread " + Thread.currentThread().getName(), null, 4, null);
        if (r4 == null) goto L6;
        r4.onResult(((Number) r5.getFirst()).intValue(), (Response) r5.getSecond());
        return;
    }

    /* JADX INFO: renamed from: sendCmdWithTimeout$lambda-5, reason: not valid java name */
    private static final void m1032sendCmdWithTimeout$lambda5(SendCMDResultCallback r2, int r3, Throwable r4) {
        CmdManager r0 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r4, "it");
        r0.handlerSendCmdException(r4, r2, r3);
    }

    private final void sendCmdForceUseBinder(int r3, Request r4, SendCMDResultCallback r5) {
        sendCMDByBind(r3, r4, null, r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Response r6 = new Response.Builder().statusCode(Integer.valueOf(SdkErrorCode.ERROR_RECEIVER_RESULT_EXCEPTION)).errorMsg(SdkErrorCode.ERROR_REASON_RECEIVE_RESULT_EXCEPTION).build();
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullExpressionValue(r6, ApmTrafficStats.TTNET_RESPONSE);
        r5.onResult(r3, r6);
    L9:
        MLog.d$default(TAG, "exception " + e, null, 4, null);
    }

    private final void sendCmdWithoutTimeout(final int r2, final Request r3, final SendCMDResultCallback r4) {
        Maybe.create(new CmdManager$$ExternalSyntheticLambda0(r2, r3)).subscribeOn(Schedulers.computation()).subscribe(new CmdManager$$ExternalSyntheticLambda1(r4), new CmdManager$$ExternalSyntheticLambda2(r4, r2));
    }

    /* JADX INFO: renamed from: sendCmdWithoutTimeout$lambda-6, reason: not valid java name */
    private static final void m1033sendCmdWithoutTimeout$lambda6(int r8, Request r9, MaybeEmitter r10) {
        Intrinsics.checkNotNullParameter(r9, "$request");
        Intrinsics.checkNotNullParameter(r10, "it");
        if (useBinderCMDList.contains(Integer.valueOf(r8)) == false) goto L5;
        sendCMDByBind$default(INSTANCE, r8, r9, r10, null, 8, null);
        return;
    L5:
        INSTANCE.sendCMDByIntentService(r8, r9, r10);
    }

    /* JADX INFO: renamed from: sendCmdWithoutTimeout$lambda-7, reason: not valid java name */
    private static final void m1034sendCmdWithoutTimeout$lambda7(SendCMDResultCallback r4, Pair r5) {
        MLog.d$default(TAG, "send cmd on result response " + r5.getSecond() + ", thread " + Thread.currentThread().getName() + " callback " + r4, null, 4, null);
        if (r4 == null) goto L6;
        r4.onResult(((Number) r5.getFirst()).intValue(), (Response) r5.getSecond());
        return;
    }

    /* JADX INFO: renamed from: sendCmdWithoutTimeout$lambda-8, reason: not valid java name */
    private static final void m1035sendCmdWithoutTimeout$lambda8(SendCMDResultCallback r2, int r3, Throwable r4) {
        CmdManager r0 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r4, "it");
        r0.handlerSendCmdException(r4, r2, r3);
    }

    private final void handlerSendCmdException(Throwable r4, SendCMDResultCallback r5, int r6) {
        MLog.d$default(TAG, "send cmd exception " + Log.getStackTraceString(r4), null, 4, null);
        if ((r4 instanceof TimeoutException) == false) goto L5;
        int r3 = SdkErrorCode.ERROR_SEND_CMD_TIMEOUT;
        String r0 = SdkErrorCode.ERROR_REASON_SEND_CMD_TIMEOUT;
    L6:
        Response r1 = new Response.Builder().statusCode(Integer.valueOf(r3)).cmd(Integer.valueOf(r6)).errorMsg(r0).build();
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullExpressionValue(r1, ApmTrafficStats.TTNET_RESPONSE);
        r5.onResult(r6, r1);
    L9:
        ReportMonitorHelper.INSTANCE.monitorSendCmdException(r6, r3, r4.toString());
        return;
    L5:
        r3 = SdkErrorCode.ERROR_SEND_CMD_ERROR;
        r0 = "send cmd internal error";
        goto L6
    }

    static /* synthetic */ void sendCMDByBind$default(CmdManager r0, int r1, Request r2, MaybeEmitter r3, SendCMDResultCallback r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.sendCMDByBind(r1, r2, r3, r4);
    }

    private final void sendCMDByBind(final int r9, final Request r10, final MaybeEmitter<Pair<Integer, Response>> r11, final SendCMDResultCallback r12) {
        final long r4 = System.currentTimeMillis();
        ReportMonitorHelper r8 = ReportMonitorHelper.INSTANCE;
        Context r0 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();
        if (r0 == null) goto L5;
        String r1 = r0.getPackageName();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r8.monitorStartSendCmd(r9, 1, r1);
        MatrixBinderManager.INSTANCE.waitConnectResult(new AnonymousClass1(r10, r9, r12, r4, r11));
        return;
    L5:
        r1 = null;
        goto L6
    }

    static /* synthetic */ void handleSendCMDByBinderFail$default(CmdManager r6, int r7, MaybeEmitter r8, SendCMDResultCallback r9, int r10, String r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = SdkErrorCode.ERROR_BINDER_CONNECT_EXCEPTION;
    L5:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = SdkErrorCode.ERROR_REASON_BINDER_CONNECT_ERROR;
    L8:
        r6.handleSendCMDByBinderFail(r7, r8, r9, r4, r11);
    }

    private final void handleSendCMDByBinderFail(int r10, MaybeEmitter<Pair<Integer, Response>> r11, SendCMDResultCallback r12, int r13, String r14) {
        String r2 = null;
        MLog.d$default(TAG, "handleBinderCallFail, errorCode: " + r13 + ", errorMsg: " + r14, null, 4, null);
        Response r9 = new Response.Builder().statusCode(Integer.valueOf(r13)).errorMsg(r14).build();
        ReportMonitorHelper r3 = ReportMonitorHelper.INSTANCE;
        Context r15 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();
        if (r15 == null) goto L5;
        r2 = r15.getPackageName();
    L5:
        if (r2 != null) goto L7;
        String r6 = "";
    L8:
        Intrinsics.checkNotNullExpressionValue(r9, ApmTrafficStats.TTNET_RESPONSE);
        r3.monitorSendCmdResult(r10, 1, r6, r9, null);
        if (r11 == null) goto L11;
        r11.onSuccess(new Pair(Integer.valueOf(r10), r9));
    L11:
        if (r12 == null) goto L14;
        r12.onResult(r10, r9);
        return;
    L14:
        return;
    L7:
        r6 = r2;
        goto L8
    }

    private final void sendCMDByIntentService(final int r18, Request r19, final MaybeEmitter<Pair<Integer, Response>> r20) {
        final long r7 = System.currentTimeMillis();
        MatrixOnesSdk.INSTANCE.checkInit$sdk_platform_ones_release();
        MLog.d$default(TAG, "send cmd by intent service cmd=" + r18, null, 4, null);
        Context r0 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();
        Intrinsics.checkNotNull(r0);
        String r12 = r0.getPackageName();
        long r13 = System.currentTimeMillis();
        final PendingIntent r15 = PendingIntent.getService(MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release(), 0, new Intent(ACTION_BY_SDK), VCardConfig.FLAG_APPEND_TYPE_PARAM);
        ResultReceiver r1 = MatrixServiceResultReceiver.Companion.creator(null, new CmdManager$sendCMDByIntentService$resultReceiver$1(r7, r18, r15, r20));
        Intent r2 = new Intent();
        r2.setPackage(r12);
        r2.setClassName("com.obric.matrix", "com.obric.matrix.server.MatrixIntentService");
        r2.putExtra(KEY_MATRIX_CMD, r18);
        r2.putExtra(KEY_REQUEST_BYTE_ARRAY, r19.encode());
        r2.putExtra("start_time", String.valueOf(r13));
        r2.putExtra(KEY_PENDING_INTENT, r15);
        Context r3 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();
        Intrinsics.checkNotNull(r3);
        r2.setExtrasClassLoader(r3.getClassLoader());
        ReportMonitorHelper r4 = ReportMonitorHelper.INSTANCE;
        if (r15 == null) goto L6;
        String r5 = r15.getCreatorPackage();
        if (r5 == null) goto L6;
    L7:
        r4.monitorStartSendCmd(r18, 2, r5);
        r2.putExtra(KEY_RESULT_RECEIVER, r1);
        Context r6 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();
        Intrinsics.checkNotNull(r6);
        r6.startService(r2);
        MLog.v$default(TAG, "start service complete 1 cost " + (System.currentTimeMillis() - r7), null, 4, null);
        return;
    L6:
        r5 = "";
        goto L7
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x018d: MOVE (r9 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:68:0x018d */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Response sendCmdSync(int r16, Request r17) {
        Intrinsics.checkNotNullParameter(r17, Ext.KEY_REQUEST);
        ReportMonitorHelper r0 = ReportMonitorHelper.INSTANCE;
        Context r2 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();
        Cursor r9 = null;
        String r10 = null;
        if (r2 == null) goto L5;
        String r3 = r2.getPackageName();
    L7:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0.monitorStartSendCmd(r16, 3, r3);
        Context r1 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Throwable -> L52 Exception -> L54
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L52 Exception -> L54
        ContentResolver r4 = r1.getContentResolver();     // Catch: Throwable -> L52 Exception -> L54
        Bundle r5 = new Bundle();     // Catch: Throwable -> L52 Exception -> L54
        r5.putInt(KEY_MATRIX_CMD, r16);     // Catch: Throwable -> L52 Exception -> L54
        r5.putByteArray(KEY_REQUEST_BYTE_ARRAY, r17.encode());     // Catch: Throwable -> L52 Exception -> L54
        Cursor r13 = r4.query(Uri.parse(SEND_CMD_BY_PROVIDER_URI), null, r5, null);     // Catch: Throwable -> L52 Exception -> L54
        if (r13 == null) goto L75;
        Response r6 = null;
    L72:
    L50:
        e = e;
        Response r14 = r6;
    L56:
        MLog.e$default(TAG, "sendCmdSync " + Log.getStackTraceString(e), null, 4, null);     // Catch: Throwable -> L67
        ReportMonitorHelper r7 = ReportMonitorHelper.INSTANCE;     // Catch: Throwable -> L67
        Context r8 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Throwable -> L67
        if (r8 == null) goto L59;
        r10 = r8.getPackageName();     // Catch: Throwable -> L67
    L59:
        if (r10 != null) goto L61;
        String r11 = "";
    L62:
        Response r12 = new Response.Builder().statusCode(Integer.valueOf(SdkErrorCode.ERROR_SEND_CMD_ASYNC_ERROR)).errorMsg(e.getMessage()).build();     // Catch: Throwable -> L67
        Intrinsics.checkNotNullExpressionValue(r12, "Builder().statusCode(Sdk…rorMsg(e.message).build()");     // Catch: Throwable -> L67
        r7.monitorSendCmdResult(r16, 3, r11, r12, null);     // Catch: Throwable -> L67
        if (r13 == null) goto L66;
        r13.close();
    L66:
        return r14;
    L61:
        r11 = r10;
        goto L62
    L18:
        if (r13.moveToNext() == false) goto L49;
        int r15 = r13.getColumnIndex(KEY_RESPONSE_BYTE_ARRAY);     // Catch: Exception -> L50 Throwable -> L67
        MLog.d$default(TAG, "sendCmdSync index " + r15 + TokenParser.SP, null, 4, null);     // Catch: Exception -> L50 Throwable -> L67
        if (r15 < 0) goto L28;
        byte[] r18 = r13.getBlob(r15);     // Catch: Exception -> L50 Throwable -> L67
        if (r18 == null) goto L28;
        MLog.d$default(TAG, "sendCmdSync response != null ", null, 4, null);     // Catch: Exception -> L50 Throwable -> L67
        Response r19 = Response.ADAPTER.decode(r18);     // Catch: Exception -> L50 Throwable -> L67
        MLog.d$default(TAG, "sendCmdSync response " + r19 + TokenParser.SP, null, 4, null);     // Catch: Exception -> L26 Throwable -> L67
        r14 = r19;
    L29:
        if (r14 != null) goto L77;
        ReportMonitorHelper r20 = ReportMonitorHelper.INSTANCE;     // Catch: Exception -> L47 Throwable -> L67
        Context r21 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Exception -> L47 Throwable -> L67
        if (r21 == null) goto L41;
        String r22 = r21.getPackageName();     // Catch: Exception -> L47 Throwable -> L67
    L42:
        if (r22 != null) goto L44;
        String r23 = "";
    L45:
        Response r24 = new Response.Builder().statusCode(Integer.valueOf(SdkErrorCode.ERROR_SEND_CMD_ASYNC_ERROR)).errorMsg("send cmd internal error").build();     // Catch: Exception -> L47 Throwable -> L67
        Intrinsics.checkNotNullExpressionValue(r24, "Builder().statusCode(Sdk…_CMD_ASYNC_ERROR).build()");     // Catch: Exception -> L47 Throwable -> L67
        r20.monitorSendCmdResult(r16, 3, r23, r24, null);     // Catch: Exception -> L47 Throwable -> L67
    L46:
        r6 = r14;
        goto L72
    L44:
        r23 = r22;
        goto L45
    L41:
        r22 = null;
        goto L42
    L77:
        ReportMonitorHelper r25 = ReportMonitorHelper.INSTANCE;     // Catch: Exception -> L47 Throwable -> L67
        Context r26 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Exception -> L47 Throwable -> L67
        if (r26 == null) goto L33;
        String r27 = r26.getPackageName();     // Catch: Exception -> L47 Throwable -> L67
    L34:
        if (r27 != null) goto L36;
        String r28 = "";
    L37:
        r25.monitorSendCmdResult(r16, 3, r28, r14, null);     // Catch: Exception -> L47 Throwable -> L67
        goto L46
    L36:
        r28 = r27;
        goto L37
    L33:
        r27 = null;
    L47:
        e = e;
    L26:
        e = e;
        r14 = r19;
    L28:
        r14 = r6;
        goto L29
    L49:
        r13.close();
        return r6;
    L75:
        MLog.d$default(TAG, "sendCmdSync cursor is null", null, 4, null);     // Catch: Exception -> L14 Throwable -> L67
        return new Response.Builder().build();
    L14:
        e = e;
        r14 = null;
        goto L56
    L67:
        th = th;
        r9 = r13;
    L69:
        if (r9 == null) goto L71;
        r9.close();
    L71:
        throw th;
    L54:
        e = e;
        r13 = null;
        r14 = null;
    L52:
        th = th;
        goto L69
    L5:
        r3 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void invokeAsyncSafely$default(CmdManager r6, IServerBroker r7, int r8, byte[] r9, IServerCallback r10, Function2 r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        r6.invokeAsyncSafely(r7, r8, r9, r10, r11);
    }

    private final void invokeAsyncSafely(IServerBroker r1, int r2, byte[] r3, IServerCallback r4, Function2<? super Integer, ? super String, Unit> r5) {
        if (r1 == null) goto L17;
        r1.invokeAsyn(r2, r3, r4);     // Catch: Exception -> L6 DeadObjectException -> L10
    L21:
        return;
    L10:
        e = move-exception;
        MLog.e(TAG, "invokeAsync, matrix dead", e);
        if (r5 == null) goto L20;
        r5.invoke(Integer.valueOf(SdkErrorCode.ERROR_BINDER_DEAD_EXCEPTION), "matrix is dead");
        return;
    L20:
        return;
    L6:
        e = move-exception;
        MLog.e(TAG, "invokeAsync, unknown error", e);
        if (r5 == null) goto L18;
        r5.invoke(Integer.valueOf(SdkErrorCode.ERROR_BINDER_INVOKE_EXCEPTION), "unknown reason: " + e);
        return;
    L18:
        return;
    }
}
