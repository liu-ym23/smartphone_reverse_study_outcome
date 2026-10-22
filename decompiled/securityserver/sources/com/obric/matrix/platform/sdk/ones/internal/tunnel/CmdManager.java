package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.annotation.SuppressLint;
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
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.obric.matrix.platform.sdk.ones.IMatrixBridge;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.SendCMDResultCallback;
import com.obric.matrix.platform.sdk.ones.internal.config.SdkConfigManager;
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
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"CheckResult"})
public final class CmdManager {

    @NotNull
    private static final String ACTION_BY_SDK = "com.obric.matrix.sdk.intent.service.auth.token.action";

    @NotNull
    private static final String AUTHORITY = "com.obric.matrix.sdk.cmd.handler.provider";
    private static final int DEFAULT_CALLBACK_TIMEOUT = 35;

    @NotNull
    public static final CmdManager INSTANCE = null;

    @NotNull
    private static final String KEY_MATRIX_CMD = "MATRIX_CMD";

    @NotNull
    private static final String KEY_PENDING_INTENT = "PENDING_INTENT";

    @NotNull
    private static final String KEY_REQUEST_BYTE_ARRAY = "REQUEST_BYTE_ARRAY";

    @NotNull
    private static final String KEY_RESPONSE_BYTE_ARRAY = "RESPONSE_BYTE_ARRAY";

    @NotNull
    private static final String KEY_RESULT_RECEIVER = "RESULT_RECEIVER";

    @NotNull
    private static final String SEND_CMD_BY_PROVIDER = "SEND_CMD_BY_PROVIDER";

    @NotNull
    private static final String SEND_CMD_BY_PROVIDER_URI = "content://com.obric.matrix.sdk.cmd.handler.provider/SEND_CMD_BY_PROVIDER";

    @NotNull
    private static final String TAG = "CmdManager";

    @NotNull
    private static final HashSet<Integer> forceUseOldBindSet = null;
    private static int mCustomTimeout;

    @NotNull
    private static HashSet<Integer> notTimeoutCmdSet;
    private static int sendCmdTimeout;

    @NotNull
    private static List<Integer> useBinderCMDList;

    static {
        INSTANCE = new CmdManager();
        sendCmdTimeout = 35;
        Integer[] r0 = {Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK.getValue()), Integer.valueOf(MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS.getValue())};
        HashSet<Integer> r1 = new HashSet(MapsKt.c(r0.length));
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1.add(r0[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        forceUseOldBindSet = r1;
        useBinderCMDList = CollectionsKt.j(Integer.valueOf(MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue()));
        notTimeoutCmdSet = new HashSet();
    }

    private CmdManager() {
    }

    public static /* synthetic */ void a(SendCMDResultCallback r0, Pair r1) {
        m31sendCmdWithoutTimeout$lambda7(r0, r1);
    }

    public static final /* synthetic */ void access$handleSendCMDByBinderFail(CmdManager r0, int r1, MaybeEmitter r2, SendCMDResultCallback r3, int r4, String r5) {
        r0.handleSendCMDByBinderFail(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void access$invokeAsyncSafely(CmdManager r0, IServerBroker r1, int r2, byte[] r3, IServerCallback r4, Function2 r5) {
        r0.invokeAsyncSafely(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void b(int r0, Request r1, MaybeEmitter r2) {
        m27sendCmdWithTimeout$lambda3(r0, r1, r2);
    }

    public static /* synthetic */ void c() {
        m26init$lambda0();
    }

    public static /* synthetic */ void d(int r0, Request r1, MaybeEmitter r2) {
        m30sendCmdWithoutTimeout$lambda6(r0, r1, r2);
    }

    public static /* synthetic */ void e(SendCMDResultCallback r0, int r1, Throwable r2) {
        m32sendCmdWithoutTimeout$lambda8(r0, r1, r2);
    }

    public static /* synthetic */ void f(SendCMDResultCallback r0, int r1, Throwable r2) {
        m29sendCmdWithTimeout$lambda5(r0, r1, r2);
    }

    public static /* synthetic */ void g(SendCMDResultCallback r0, Pair r1) {
        m28sendCmdWithTimeout$lambda4(r0, r1);
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
        Intrinsics.e(r9, ApmTrafficStats.TTNET_RESPONSE);
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

    public static /* synthetic */ void handleSendCMDByBinderFail$default(CmdManager r6, int r7, MaybeEmitter r8, SendCMDResultCallback r9, int r10, String r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = SdkErrorCode.ERROR_BINDER_CONNECT_EXCEPTION;
    L5:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = SdkErrorCode.ERROR_REASON_BINDER_CONNECT_ERROR;
    L8:
        r6.handleSendCMDByBinderFail(r7, r8, r9, r4, r11);
    }

    private final void handlerSendCmdException(Throwable r4, SendCMDResultCallback r5, int r6) {
        MLog.d$default(TAG, "send cmd exception " + Log.getStackTraceString(r4), null, 4, null);
        if ((r4 instanceof TimeoutException) == false) goto L5;
        int r3 = SdkErrorCode.ERROR_SEND_CMD_TIMEOUT;
        String r0 = SdkErrorCode.ERROR_REASON_SEND_CMD_TIMEOUT;
    L6:
        Response r1 = new Response.Builder().statusCode(Integer.valueOf(r3)).cmd(Integer.valueOf(r6)).errorMsg(r0).build();
        if (r5 == null) goto L9;
        Intrinsics.e(r1, ApmTrafficStats.TTNET_RESPONSE);
        r5.onResult(r6, r1);
    L9:
        ReportMonitorHelper.INSTANCE.monitorSendCmdException(r6, r3, r4.toString());
        return;
    L5:
        r3 = SdkErrorCode.ERROR_SEND_CMD_ERROR;
        r0 = "send cmd internal error";
        goto L6
    }

    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    private static final void m26init$lambda0() {
        INSTANCE.updateConfig$sdk_platform_ones_release();
        DefaultServerBrokerImpl r0 = new DefaultServerBrokerImpl();
        MLog.d$default(TAG, "call on bind default  " + MatrixOnesSdk.INSTANCE.getBridge$sdk_platform_ones_release() + " onbinder " + r0 + ' ', null, 4, null);
        MatrixBinderManager.INSTANCE.callOnBind(r0);
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
        r5.mo7invoke(Integer.valueOf(SdkErrorCode.ERROR_BINDER_DEAD_EXCEPTION), "matrix is dead");
        return;
    L20:
        return;
    L6:
        e = move-exception;
        MLog.e(TAG, "invokeAsync, unknown error", e);
        if (r5 == null) goto L18;
        r5.mo7invoke(Integer.valueOf(SdkErrorCode.ERROR_BINDER_INVOKE_EXCEPTION), "unknown reason: " + e);
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void invokeAsyncSafely$default(CmdManager r6, IServerBroker r7, int r8, byte[] r9, IServerCallback r10, Function2 r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        r6.invokeAsyncSafely(r7, r8, r9, r10, r11);
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

    public static /* synthetic */ void sendCMDByBind$default(CmdManager r0, int r1, Request r2, MaybeEmitter r3, SendCMDResultCallback r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.sendCMDByBind(r1, r2, r3, r4);
    }

    private final void sendCMDByIntentService(final int r19, Request r20, final MaybeEmitter<Pair<Integer, Response>> r21) {
        final long r7 = System.currentTimeMillis();
        MatrixOnesSdk r9 = MatrixOnesSdk.INSTANCE;
        r9.checkInit$sdk_platform_ones_release();
        MLog.d$default(TAG, "send cmd by intent service cmd=" + r19, null, 4, null);
        Context r0 = r9.getContext$sdk_platform_ones_release();
        Intrinsics.c(r0);
        String r13 = r0.getPackageName();
        long r14 = System.currentTimeMillis();
        final PendingIntent r5 = PendingIntent.getService(r9.getContext$sdk_platform_ones_release(), 0, new Intent(ACTION_BY_SDK), 67108864);
        ResultReceiver r1 = MatrixServiceResultReceiver.Companion.creator(null, new CmdManager$sendCMDByIntentService$resultReceiver$1(r7, r19, r5, r21));
        Intent r2 = new Intent();
        r2.setPackage(r13);
        r2.setClassName("com.obric.matrix", "com.obric.matrix.server.MatrixIntentService");
        r2.putExtra(KEY_MATRIX_CMD, r19);
        r2.putExtra(KEY_REQUEST_BYTE_ARRAY, r20.encode());
        r2.putExtra("start_time", String.valueOf(r14));
        r2.putExtra(KEY_PENDING_INTENT, r5);
        Context r3 = r9.getContext$sdk_platform_ones_release();
        Intrinsics.c(r3);
        r2.setExtrasClassLoader(r3.getClassLoader());
        ReportMonitorHelper r4 = ReportMonitorHelper.INSTANCE;
        if (r5 == null) goto L6;
        String r6 = r5.getCreatorPackage();
        if (r6 == null) goto L6;
    L7:
        r4.monitorStartSendCmd(r19, 2, r6);
        r2.putExtra(KEY_RESULT_RECEIVER, r1);
        Context r8 = r9.getContext$sdk_platform_ones_release();
        Intrinsics.c(r8);
        r8.startService(r2);
        MLog.v$default(TAG, "start service complete 1 cost " + (System.currentTimeMillis() - r7), null, 4, null);
        return;
    L6:
        r6 = "";
        goto L7
    }

    private final void sendCmdForceUseBinder(int r3, Request r4, SendCMDResultCallback r5) {
        sendCMDByBind(r3, r4, null, r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Response r6 = new Response.Builder().statusCode(Integer.valueOf(SdkErrorCode.ERROR_RECEIVER_RESULT_EXCEPTION)).errorMsg(SdkErrorCode.ERROR_REASON_RECEIVE_RESULT_EXCEPTION).build();
        if (r5 == null) goto L9;
        Intrinsics.e(r6, ApmTrafficStats.TTNET_RESPONSE);
        r5.onResult(r3, r6);
    L9:
        MLog.d$default(TAG, "exception " + e, null, 4, null);
    }

    private final void sendCmdWithTimeout(int r2, Request r3, int r4, SendCMDResultCallback r5) {
        Maybe.create(new a(r2, r3, 1)).subscribeOn(Schedulers.computation()).timeout(r4, TimeUnit.SECONDS).subscribe(new b(r5, 1), new c(r5, r2, 1));
    }

    /* JADX INFO: renamed from: sendCmdWithTimeout$lambda-3, reason: not valid java name */
    private static final void m27sendCmdWithTimeout$lambda3(int r8, Request r9, MaybeEmitter r10) {
        Intrinsics.f(r9, "$newRequest");
        Intrinsics.f(r10, "it");
        if (useBinderCMDList.contains(Integer.valueOf(r8)) == false) goto L5;
        sendCMDByBind$default(INSTANCE, r8, r9, r10, null, 8, null);
        return;
    L5:
        INSTANCE.sendCMDByIntentService(r8, r9, r10);
    }

    /* JADX INFO: renamed from: sendCmdWithTimeout$lambda-4, reason: not valid java name */
    private static final void m28sendCmdWithTimeout$lambda4(SendCMDResultCallback r4, Pair r5) {
        MLog.d$default(TAG, "send cmd on result response " + r5.c + ", thread " + Thread.currentThread().getName(), null, 4, null);
        if (r4 == null) goto L6;
        r4.onResult(((Number) r5.b).intValue(), (Response) r5.c);
        return;
    }

    /* JADX INFO: renamed from: sendCmdWithTimeout$lambda-5, reason: not valid java name */
    private static final void m29sendCmdWithTimeout$lambda5(SendCMDResultCallback r2, int r3, Throwable r4) {
        CmdManager r0 = INSTANCE;
        Intrinsics.e(r4, "it");
        r0.handlerSendCmdException(r4, r2, r3);
    }

    private final void sendCmdWithoutTimeout(int r3, Request r4, SendCMDResultCallback r5) {
        int r0 = 0;
        Maybe.create(new a(r3, r4, r0)).subscribeOn(Schedulers.computation()).subscribe(new b(r5, r0), new c(r5, r3, 0));
    }

    /* JADX INFO: renamed from: sendCmdWithoutTimeout$lambda-6, reason: not valid java name */
    private static final void m30sendCmdWithoutTimeout$lambda6(int r8, Request r9, MaybeEmitter r10) {
        Intrinsics.f(r9, "$request");
        Intrinsics.f(r10, "it");
        if (useBinderCMDList.contains(Integer.valueOf(r8)) == false) goto L5;
        sendCMDByBind$default(INSTANCE, r8, r9, r10, null, 8, null);
        return;
    L5:
        INSTANCE.sendCMDByIntentService(r8, r9, r10);
    }

    /* JADX INFO: renamed from: sendCmdWithoutTimeout$lambda-7, reason: not valid java name */
    private static final void m31sendCmdWithoutTimeout$lambda7(SendCMDResultCallback r4, Pair r5) {
        MLog.d$default(TAG, "send cmd on result response " + r5.c + ", thread " + Thread.currentThread().getName() + " callback " + r4, null, 4, null);
        if (r4 == null) goto L6;
        r4.onResult(((Number) r5.b).intValue(), (Response) r5.c);
        return;
    }

    /* JADX INFO: renamed from: sendCmdWithoutTimeout$lambda-8, reason: not valid java name */
    private static final void m32sendCmdWithoutTimeout$lambda8(SendCMDResultCallback r2, int r3, Throwable r4) {
        CmdManager r0 = INSTANCE;
        Intrinsics.e(r4, "it");
        r0.handlerSendCmdException(r4, r2, r3);
    }

    public final void init$sdk_platform_ones_release() {
        ThreadPlus.submitRunnable(new com.bytedance.securityserver.b(2));
    }

    public final void sendCmd(int r5, @NotNull Request r6, @Nullable SendCMDResultCallback r7) {
        Intrinsics.f(r6, "request");
        MatrixOnesSdk r0 = MatrixOnesSdk.INSTANCE;
        r0.checkInit$sdk_platform_ones_release();
        int r1 = mCustomTimeout;
        if (r1 > 0) goto L9;
        r1 = sendCmdTimeout;
        if (r1 > 0) goto L9;
        r1 = 35;
    L9:
        String r2 = r6.appKey;
        if (r2 != null) goto L12;
    L13:
        Request.Builder r8 = r6.newBuilder();
        IMatrixBridge r3 = r0.getBridge$sdk_platform_ones_release();
        if (r3 == null) goto L16;
        String r4 = r3.appId();
    L17:
        r6 = r8.appKey(r4).build();
    L19:
        if (forceUseOldBindSet.contains(Integer.valueOf(r5)) == false) goto L22;
        Intrinsics.e(r6, "newRequest");
        sendCmdForceUseBinder(r5, r6, r7);
        return;
    L22:
        if (notTimeoutCmdSet.contains(Integer.valueOf(r5)) == false) goto L24;
        Intrinsics.e(r6, "newRequest");
        sendCmdWithoutTimeout(r5, r6, r7);
        return;
    L24:
        Intrinsics.e(r6, "newRequest");
        sendCmdWithTimeout(r5, r6, r1, r7);
        return;
    L16:
        r4 = null;
        goto L17
    L12:
        if (r2.length() != 0) goto L19;
        goto L13
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0062: MOVE (r9 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:15:0x0062 */
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
    @Nullable
    public final Response sendCmdSync(int r16, @NotNull Request r17) {
        Intrinsics.f(r17, "request");
        ReportMonitorHelper r0 = ReportMonitorHelper.INSTANCE;
        MatrixOnesSdk r2 = MatrixOnesSdk.INSTANCE;
        Context r3 = r2.getContext$sdk_platform_ones_release();
        Cursor r9 = null;
        String r10 = null;
        if (r3 == null) goto L5;
        String r4 = r3.getPackageName();
    L7:
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r0.monitorStartSendCmd(r16, 3, r4);
        Context r1 = r2.getContext$sdk_platform_ones_release();     // Catch: Throwable -> L54 Exception -> L56
        Intrinsics.c(r1);     // Catch: Throwable -> L54 Exception -> L56
        ContentResolver r5 = r1.getContentResolver();     // Catch: Throwable -> L54 Exception -> L56
        Bundle r6 = new Bundle();     // Catch: Throwable -> L54 Exception -> L56
        r6.putInt(KEY_MATRIX_CMD, r16);     // Catch: Throwable -> L54 Exception -> L56
        r6.putByteArray(KEY_REQUEST_BYTE_ARRAY, r17.encode());     // Catch: Throwable -> L54 Exception -> L56
        Cursor r13 = r5.query(Uri.parse(SEND_CMD_BY_PROVIDER_URI), null, r6, null);     // Catch: Throwable -> L54 Exception -> L56
        if (r13 == null) goto L77;
        Response r7 = null;
    L79:
    L30:
        e = e;
        Response r14 = r7;
    L58:
        MLog.e$default(TAG, "sendCmdSync " + Log.getStackTraceString(e), null, 4, null);     // Catch: Throwable -> L14
        ReportMonitorHelper r8 = ReportMonitorHelper.INSTANCE;     // Catch: Throwable -> L14
        Context r11 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Throwable -> L14
        if (r11 == null) goto L61;
        r10 = r11.getPackageName();     // Catch: Throwable -> L14
    L61:
        if (r10 != null) goto L63;
        String r12 = "";
    L64:
        Response r15 = new Response.Builder().statusCode(Integer.valueOf(SdkErrorCode.ERROR_SEND_CMD_ASYNC_ERROR)).errorMsg(e.getMessage()).build();     // Catch: Throwable -> L14
        Intrinsics.e(r15, "Builder().statusCode(Sdk…rorMsg(e.message).build()");     // Catch: Throwable -> L14
        r8.monitorSendCmdResult(r16, 3, r12, r15, null);     // Catch: Throwable -> L14
        if (r13 == null) goto L68;
        r13.close();
    L68:
        return r14;
    L63:
        r12 = r10;
        goto L64
    L20:
        if (r13.moveToNext() == false) goto L53;
        int r18 = r13.getColumnIndex(KEY_RESPONSE_BYTE_ARRAY);     // Catch: Throwable -> L14 Exception -> L30
        MLog.d$default(TAG, "sendCmdSync index " + r18 + ' ', null, 4, null);     // Catch: Throwable -> L14 Exception -> L30
        if (r18 < 0) goto L32;
        byte[] r19 = r13.getBlob(r18);     // Catch: Throwable -> L14 Exception -> L30
        if (r19 == null) goto L32;
        MLog.d$default(TAG, "sendCmdSync response != null ", null, 4, null);     // Catch: Throwable -> L14 Exception -> L30
        Response r20 = Response.ADAPTER.decode(r19);     // Catch: Throwable -> L14 Exception -> L30
        MLog.d$default(TAG, "sendCmdSync response " + r20 + ' ', null, 4, null);     // Catch: Throwable -> L14 Exception -> L28
        r14 = r20;
    L33:
        if (r14 != null) goto L75;
        ReportMonitorHelper r21 = ReportMonitorHelper.INSTANCE;     // Catch: Throwable -> L14 Exception -> L37
        Context r22 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Throwable -> L14 Exception -> L37
        if (r22 == null) goto L47;
        String r23 = r22.getPackageName();     // Catch: Throwable -> L14 Exception -> L37
    L48:
        if (r23 != null) goto L50;
        String r24 = "";
    L51:
        Response r25 = new Response.Builder().statusCode(Integer.valueOf(SdkErrorCode.ERROR_SEND_CMD_ASYNC_ERROR)).errorMsg("send cmd internal error").build();     // Catch: Throwable -> L14 Exception -> L37
        Intrinsics.e(r25, "Builder().statusCode(Sdk…_CMD_ASYNC_ERROR).build()");     // Catch: Throwable -> L14 Exception -> L37
        r21.monitorSendCmdResult(r16, 3, r24, r25, null);     // Catch: Throwable -> L14 Exception -> L37
    L52:
        r7 = r14;
        goto L79
    L50:
        r24 = r23;
        goto L51
    L47:
        r23 = null;
        goto L48
    L75:
        ReportMonitorHelper r26 = ReportMonitorHelper.INSTANCE;     // Catch: Throwable -> L14 Exception -> L37
        Context r27 = MatrixOnesSdk.INSTANCE.getContext$sdk_platform_ones_release();     // Catch: Throwable -> L14 Exception -> L37
        if (r27 == null) goto L39;
        String r28 = r27.getPackageName();     // Catch: Throwable -> L14 Exception -> L37
    L40:
        if (r28 != null) goto L42;
        String r29 = "";
    L43:
        r26.monitorSendCmdResult(r16, 3, r29, r14, null);     // Catch: Throwable -> L14 Exception -> L37
        goto L52
    L42:
        r29 = r28;
        goto L43
    L39:
        r28 = null;
    L37:
        e = e;
    L28:
        e = e;
        r14 = r20;
    L32:
        r14 = r7;
        goto L33
    L53:
        r13.close();
        return r7;
    L77:
        MLog.d$default(TAG, "sendCmdSync cursor is null", null, 4, null);     // Catch: Throwable -> L14 Exception -> L16
        return new Response.Builder().build();
    L16:
        e = e;
        r14 = null;
        goto L58
    L14:
        th = th;
        r9 = r13;
    L69:
        if (r9 == null) goto L71;
        r9.close();
    L71:
        throw th;
    L56:
        e = e;
        r13 = null;
        r14 = null;
    L54:
        th = th;
        goto L69
    L5:
        r4 = null;
        goto L7
    }

    public final void setCustomTimeout$sdk_platform_ones_release(int r1) {
        mCustomTimeout = r1;
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
        if (r6 == null) goto L24;
        Integer r3 = r6.sendCmdTimeout;
        Intrinsics.e(r3, "it.sendCmdTimeout");
        if (r3.intValue() <= 0) goto L14;
        Integer r4 = r6.sendCmdTimeout;
        Intrinsics.e(r4, "it.sendCmdTimeout");
        sendCmdTimeout = r4.intValue();
        MLog.d$default(TAG, "update config sendCmdTimeout = " + sendCmdTimeout, null, 4, null);
    L14:
        List<Integer> r7 = r6.useBindCmd;
        if (r7 != null) goto L17;
    L20:
        List<Integer> r8 = r6.forceUseOldBindCmd;
        if (r8 == null) goto L25;
        HashSet<Integer> r9 = forceUseOldBindSet;
        r9.addAll(r8);
        MLog.d$default(TAG, "update forceUseOldBindCmd " + r9, null, 4, null);
        return;
    L25:
        return;
    L17:
        if (r7.isEmpty() == true) goto L20;
        List<Integer> r10 = r6.useBindCmd;
        Intrinsics.e(r10, "it.useBindCmd");
        useBinderCMDList = r10;
        goto L20
    L24:
        return;
    L9:
        r6 = null;
        goto L10
    }
}
