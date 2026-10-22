package com.obric.matrix.server;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.d0;
import com.obric.matrix.w.o0;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0002J.\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\n0\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH\u0002J,\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J.\u0010\u001e\u001a\u00020\u00042\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010 \u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0015J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0011H\u0002J*\u0010%\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¨\u0006)"}, d2 = {"Lcom/obric/matrix/server/MatrixIntentService;", "Landroid/app/IntentService;", "()V", "checkPermission", "", "cmd", "", "pendingIntent", "Landroid/app/PendingIntent;", "checkPermissionAndGetRequest", "Lkotlin/Pair;", "Lcom/obric/matrix/proto/Request;", "intent", "Landroid/content/Intent;", "getClassLoaderByPkg", "Ljava/lang/ClassLoader;", "pkg", "", "getExtraCallbackData", "Lorg/json/JSONObject;", "handleRequest", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "it", "handlerProcessRequestException", "exception", "", "extraCallbackData", "resultReceiver", "Landroid/os/ResultReceiver;", "handlerResponse", "result", "onHandleIntent", "reportSendResponseException", "e", "reportStartHandleIntent", "packageName", "sendResult", "response", "Lcom/obric/matrix/proto/Response;", "Companion", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixIntentService extends IntentService {
    static {
    }

    public MatrixIntentService() {
        super("cmd_process");
    }

    private final void a(int r5, PendingIntent r6) {
        String r1 = "";
        Object r4 = PendingIntent.class.getMethod("getTag", new Class[]{String.class}).invoke(r6, new Object[]{""});
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.String");
        String r7 = (String) r4;
        com.obric.matrix.r.c.c.b("MatrixIntentService", "check permission aciton = " + r7);
        if (kotlin.n0.d.o.a(r7, "com.obric.matrix.sdk.intent.service.auth.token.action") == false) goto L17;
        String r8 = r6.getCreatorPackage();
        if (r8 == null) goto L8;
        r1 = r8;
    L8:
        int r9 = r6.getCreatorUid();
        if (r5 < 300000) goto L11;
    L15:
        com.obric.matrix.r.c.c.b("MatrixIntentService", "creator package " + r1 + "  callUid=" + r9);
        return;
    L11:
        if (com.obric.matrix.q.a.a.f9829a.f(com.bytedance.mpaas.app.a.f5245g, r9, r1) == true) goto L15;
        com.obric.matrix.r.c.c.b("MatrixIntentService", "check package is not permission");
        throw new com.obric.matrix.s.a();
    L17:
        com.obric.matrix.r.c.c.b("MatrixIntentService", "pendingIntent is not from sdk");
        throw new com.obric.matrix.s.a();
    }

    private final u<Integer, b0> b(Intent r4, int r5) {
        com.obric.matrix.r.c.c.b("MatrixIntentService", "process request start thread " + Thread.currentThread().getName());     // Catch: Throwable -> L16
        PendingIntent r1 = (PendingIntent) r4.getParcelableExtra("PENDING_INTENT");     // Catch: Throwable -> L16
        if (r1 == null) goto L15;
        String r2 = r1.getCreatorPackage();     // Catch: Throwable -> L16
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        a(r5, r1);     // Catch: Throwable -> L16
        byte[] r6 = r4.getByteArrayExtra("REQUEST_BYTE_ARRAY");     // Catch: Throwable -> L16
        if (r6 == null) goto L13;
        b0.a r7 = b0.r.decode(r6).b();     // Catch: Throwable -> L16
        r7.c(r2);     // Catch: Throwable -> L16
        b0 r8 = r7.f();     // Catch: Throwable -> L16
        r(r5, r2);     // Catch: Throwable -> L16
        com.obric.matrix.r.c.e.a("MatrixIntentService", "invokeAsyn cmd is " + r5 + " request= " + r8);     // Catch: Throwable -> L16
        return new u(Integer.valueOf(r5), r8);
    L13:
        throw new IllegalArgumentException("requestBytes is null");     // Catch: Throwable -> L16
    L15:
        throw new IllegalArgumentException("pendingIntent is null");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if ((th instanceof com.obric.matrix.s.b) == false) goto L20;
        throw th;
    L20:
        com.obric.matrix.r.c.c.f("MatrixIntentService", "request data parse exception " + Log.getStackTraceString(th));
        throw new com.obric.matrix.s.f();
    }

    private final JSONObject c(Intent r5) {
        String r6 = r5.getStringExtra("start_time");
        if (r6 != null) goto L5;
        r6 = BDLocationException.ERROR_TIMEOUT;
    L5:
        long r0 = System.currentTimeMillis() - Long.parseLong(r6);
        JSONObject r2 = new JSONObject();
        r2.put("start_intent_use_time", r0);
        r2.put("start_time", r6);
        r2.put("start_process_time", System.currentTimeMillis());
        return r2;
    }

    private final f.a.a<u<b0, com.obric.matrix.u.b>> d(u<Integer, b0> r3) {
        com.obric.matrix.r.c.c.b("MatrixIntentService", "handler request start ");
        int r2 = r3.c().intValue();
        final b0 r4 = r3.d();
        f.a.a r5 = n.f9991a.a(r2, r4, null).f(new e(r4));
        kotlin.n0.d.o.e(r5, "HandlerCenter.handlerReq…sponseBody)\n            }");
        return r5;
    }

    private static final u e(b0 r1, com.obric.matrix.u.b r2) {
        kotlin.n0.d.o.f(r1, "$request");
        kotlin.n0.d.o.f(r2, "responseBody");
        return new u(r1, r2);
    }

    private final void f(Throwable r5, int r6, JSONObject r7, ResultReceiver r8) {
        com.obric.matrix.r.c.c.c("MatrixIntentService", "ProcessRequest exceotion ", r5);
        d0.a r1 = new d0.a();
        r1.d(Integer.valueOf(r6));
        if ((r5 instanceof com.obric.matrix.s.b) == false) goto L5;
        com.obric.matrix.s.b r9 = (com.obric.matrix.s.b) r5;
        r1.j(Integer.valueOf(r9.a()));
        r1.e(r9.b());
        r1.i(r9.c());
    L6:
        JSONObject r10 = new JSONObject();
        Integer r2 = r1.f10272b;
        kotlin.n0.d.o.e(r2, "responseBuild.statusCode");
        r10.put(WsConstants.ERROR_CODE, r2.intValue());
        r10.put("error_msg", r1.f10273c);
        r10.put("cmd", r6);
        com.obric.matrix.w.p r3 = com.obric.matrix.w.p.a(r6);
        if (r3 == null) goto L10;
        String r4 = r3.name();
        if (r4 == null) goto L10;
    L11:
        r10.put("cmd_name", r4);
        r10.put("log_id", "");
        r10.put("request_id", r1.f10275e);
        com.obric.matrix.ostracker_api.b.g("matrix_intent_service_handler_request_exception", r10);
        d0 r11 = r1.c();
        com.obric.matrix.r.c.c.b("MatrixIntentService", "process request exception cmd is " + r6 + " response= " + r11);
        kotlin.n0.d.o.e(r11, "response");
        s(r7, r6, r11, r8);
        return;
    L10:
        r4 = "unknow";
        goto L11
    L5:
        r1.j(Integer.valueOf(o0.f10462k.getValue()));
        r1.e(String.valueOf(r5));
        goto L6
    }

    private final void g(u<b0, com.obric.matrix.u.b> r7, JSONObject r8, ResultReceiver r9) {
        com.obric.matrix.r.c.c.b("MatrixIntentService", "process request subscribe thread " + Thread.currentThread().getName());
        b0 r0 = r7.c();
        com.obric.matrix.u.b r10 = r7.d();
        String r2 = r0.f10198i;
        d0.a r3 = r10.b().b();
        r3.d(r0.f10195f);
        r3.i(r0.f10196g);
        d0 r4 = r3.c();
        com.obric.matrix.r.c.e.a("MatrixIntentService", "handler request succ appkey is " + r2 + " cmd is " + r0.f10195f + " response= " + r4 + '}');
        Integer r1 = r0.f10195f;
        kotlin.n0.d.o.e(r1, "request.cmd");
        int r5 = r1.intValue();
        kotlin.n0.d.o.e(r4, "response");
        s(r8, r5, r4, r9);
        JSONObject r6 = new JSONObject();
        r6.put(WsConstants.ERROR_CODE, r10.a().b());
        r6.put("error_msg", r10.a().a());
        Integer r11 = r0.f10195f;
        kotlin.n0.d.o.e(r11, "request.cmd");
        r6.put("cmd", r11.intValue());
        Integer r12 = r0.f10195f;
        kotlin.n0.d.o.e(r12, "request.cmd");
        com.obric.matrix.w.p r13 = com.obric.matrix.w.p.a(r12.intValue());
        if (r13 == null) goto L6;
        String r14 = r13.name();
        if (r14 == null) goto L6;
    L7:
        r6.put("cmd_name", r14);
        r6.put("log_id", r10.a().c());
        r6.put("request_id", r0.f10196g);
        r6.put("package_name", r0.n);
        com.obric.matrix.ostracker_api.b.g("matrix_intent_service_handler_response_result", r6);
        return;
    L6:
        r14 = "unknow";
        goto L7
    }

    public static /* synthetic */ void h(MatrixIntentService r0, kotlin.n0.d.d0 r1, kotlin.n0.d.d0 r2, u r3) {
        o(r0, r1, r2, r3);
    }

    public static /* synthetic */ void i(kotlin.n0.d.d0 r0, Intent r1, MatrixIntentService r2, kotlin.n0.d.b0 r3, f.a.b r4) {
        m(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ f.a.e j(MatrixIntentService r0, u r1) {
        return n(r0, r1);
    }

    public static /* synthetic */ void k(MatrixIntentService r0, kotlin.n0.d.b0 r1, kotlin.n0.d.d0 r2, kotlin.n0.d.d0 r3, Throwable r4) {
        p(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ u l(b0 r0, com.obric.matrix.u.b r1) {
        return e(r0, r1);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, android.os.Parcelable] */
    private static final void m(kotlin.n0.d.d0 r1, Intent r2, MatrixIntentService r3, kotlin.n0.d.b0 r4, f.a.b r5) {
        kotlin.n0.d.o.f(r1, "$resultReceiver");
        kotlin.n0.d.o.f(r3, "this$0");
        kotlin.n0.d.o.f(r4, "$cmd");
        kotlin.n0.d.o.f(r5, "it");
        r1.f18431f = r2.getParcelableExtra("RESULT_RECEIVER");
        r5.b(r3.b(r2, r4.f18428f));
    }

    private static final f.a.e n(MatrixIntentService r1, u r2) {
        kotlin.n0.d.o.f(r1, "this$0");
        kotlin.n0.d.o.f(r2, "it");
        return r1.d(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void o(MatrixIntentService r1, kotlin.n0.d.d0 r2, kotlin.n0.d.d0 r3, u r4) {
        kotlin.n0.d.o.f(r1, "this$0");
        kotlin.n0.d.o.f(r2, "$extraCallbackData");
        kotlin.n0.d.o.f(r3, "$resultReceiver");
        kotlin.n0.d.o.e(r4, "it");
        r1.g(r4, (JSONObject) r2.f18431f, (ResultReceiver) r3.f18431f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void p(MatrixIntentService r1, kotlin.n0.d.b0 r2, kotlin.n0.d.d0 r3, kotlin.n0.d.d0 r4, Throwable r5) {
        kotlin.n0.d.o.f(r1, "this$0");
        kotlin.n0.d.o.f(r2, "$cmd");
        kotlin.n0.d.o.f(r3, "$extraCallbackData");
        kotlin.n0.d.o.f(r4, "$resultReceiver");
        r1.f(r5, r2.f18428f, (JSONObject) r3.f18431f, (ResultReceiver) r4.f18431f);
    }

    private final void q(Throwable r2, int r3) {
        com.obric.matrix.r.c.c.f("MatrixIntentService", "process intent service  excetion " + r2);
        JSONObject r1 = new JSONObject();
        r1.put("error_msg", r2.getMessage());
        r1.put("cmd", r3);
        com.obric.matrix.w.p r4 = com.obric.matrix.w.p.a(r3);
        if (r4 == null) goto L6;
        String r5 = r4.name();
        if (r5 == null) goto L6;
    L7:
        r1.put("cmd_name", r5);
        com.obric.matrix.ostracker_api.b.g("matrix_intent_service_send_response_exception", r1);
        return;
    L6:
        r5 = "unknow";
        goto L7
    }

    private final void r(int r2, String r3) {
        JSONObject r1 = new JSONObject();
        r1.put("cmd", r2);
        com.obric.matrix.w.p r4 = com.obric.matrix.w.p.a(r2);
        if (r4 == null) goto L6;
        String r5 = r4.name();
        if (r5 == null) goto L6;
    L7:
        r1.put("cmd_name", r5);
        r1.put("package_name", r3);
        com.obric.matrix.ostracker_api.b.g("matrix_intent_service_start_handler_request", r1);
        return;
    L6:
        r5 = "unknow";
        goto L7
    }

    private final void s(JSONObject r6, int r7, d0 r8, ResultReceiver r9) {
        Bundle r0 = new Bundle();
        r6.put("start_callback_time", System.currentTimeMillis());     // Catch: Exception -> L7
        r6.put("process_time", String.valueOf(System.currentTimeMillis() - r6.optLong("start_process_time")));     // Catch: Exception -> L7
        r0.putString("EXTRA_DATA", r6.toString());     // Catch: Exception -> L7
        r0.putByteArray("RESPONSE_BYTE_ARRAY", r8.encode());     // Catch: Exception -> L7
        if (r9 == null) goto L12;
        r9.send(0, r0);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        q(e, r7);
    }

    /* JADX WARN: Type inference failed for: r2v19, types: [T, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, org.json.JSONObject] */
    @Override // android.app.IntentService
    @SuppressLint({"CheckResult"})
    protected void onHandleIntent(final Intent r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        final kotlin.n0.d.d0 r0 = new kotlin.n0.d.d0();
        final kotlin.n0.d.b0 r1 = new kotlin.n0.d.b0();
        r1.f18428f = -1;
        final kotlin.n0.d.d0 r3 = new kotlin.n0.d.d0();
        r3.f18431f = new JSONObject();
        r1.f18428f = r8.getIntExtra("MATRIX_CMD", -1);     // Catch: Exception -> L7
        r3.f18431f = c(r8);     // Catch: Exception -> L7
    L14:
        com.obric.matrix.r.c.c.b("MatrixIntentServiceonStart", "intent pkg " + r8.getPackage() + " ,thread " + Thread.currentThread().getName() + " cmd = " + r1.f18428f);
        f.a.a.b(new b(r0, r8, this, r1)).d(new c(this)).j(f.a.l.a.a()).g(new a(this, r3, r0), new d(this, r1, r3, r0));
        return;
    L7:
        e = move-exception;
        com.obric.matrix.r.c.c.b("MatrixIntentService", "getExtraCallbackData data exception other");
        JSONObject r4 = new JSONObject();
        r4.put(WsConstants.ERROR_CODE, -100020);
        r4.put("error_msg", e.getMessage() + ",exception intent");
        r4.put("cmd", r1.f18428f);
        com.obric.matrix.w.p r2 = com.obric.matrix.w.p.a(r1.f18428f);
        if (r2 == null) goto L12;
        String r5 = r2.name();
        if (r5 == null) goto L12;
    L13:
        r4.put("cmd_name", r5);
        com.obric.matrix.ostracker_api.b.g("matrix_intent_service_handler_request_exception", r4);
    L12:
        r5 = "unknow";
        goto L13
    }
}
