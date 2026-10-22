package com.obric.matrix.server;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Binder;
import android.os.DeadObjectException;
import android.os.IBinder;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.d0;
import com.obric.matrix.w.o0;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\rH\u0096\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J.\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0013\u001a\u00020\t2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\u0005J\u001c\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0016J0\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ4\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006!"}, d2 = {"Lcom/obric/matrix/server/ServerBrokerBinder;", "Lcom/obric/matrix/platform/server/IServerBroker$Stub;", "()V", "flatMapHandleRequest", "Lio/reactivex/Maybe;", "Lkotlin/Pair;", "Lcom/obric/matrix/proto/Request;", "Lcom/obric/matrix/model/BaseResponseBody;", "it", "", "callback", "Lcom/obric/matrix/platform/server/IServerCallback;", "invoke", "", "cmd", "bytes", "invokeAsyn", "", "mapToRequestAndCheckPremission", "callUid", "data", "registerServerCallback", "packageName", "", "serverCallback", "rxOnError", "request", "monitorInfo", "Lcom/obric/matrix/proto/MonitorInfo;", WsConstants.KEY_CONNECTION_ERROR, "", "rxOnSuccess", "result", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class p extends com.obric.matrix.platform.e.a.AbstractBinderC0261a {
    public p() {
    }

    public static /* synthetic */ void I(p r0, b0 r1, com.obric.matrix.w.q r2, int r3, com.obric.matrix.platform.e.b r4, Throwable r5) {
        t(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ f.a.e J(p r0, com.obric.matrix.platform.e.b r1, u r2) {
        return o(r0, r1, r2);
    }

    public static /* synthetic */ void b0(p r0, int r1, com.obric.matrix.w.q r2, com.obric.matrix.platform.e.b r3, u r4) {
        r(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ u f0(b0 r0, com.obric.matrix.u.b r1) {
        return m(r0, r1);
    }

    private static final u m(b0 r1, com.obric.matrix.u.b r2) {
        kotlin.n0.d.o.f(r1, "$request");
        kotlin.n0.d.o.f(r2, "responseBody");
        return new u(r1, r2);
    }

    private static final u n(p r1, int r2, u r3) {
        kotlin.n0.d.o.f(r1, "this$0");
        kotlin.n0.d.o.f(r3, "it");
        return r1.j0(r2, r3);
    }

    private static final f.a.e o(p r1, com.obric.matrix.platform.e.b r2, u r3) {
        kotlin.n0.d.o.f(r1, "this$0");
        kotlin.n0.d.o.f(r3, "it");
        return r1.k(r3, r2);
    }

    private static final void r(p r1, int r2, com.obric.matrix.w.q r3, com.obric.matrix.platform.e.b r4, u r5) {
        kotlin.n0.d.o.f(r1, "this$0");
        kotlin.n0.d.o.f(r3, "$monitorInfo");
        kotlin.n0.d.o.e(r5, "it");
        r1.l0(r2, r5, r3, r4);
    }

    private static final void t(p r6, b0 r7, com.obric.matrix.w.q r8, int r9, com.obric.matrix.platform.e.b r10, Throwable r11) {
        kotlin.n0.d.o.f(r6, "this$0");
        kotlin.n0.d.o.f(r7, "$request");
        kotlin.n0.d.o.f(r8, "$monitorInfo");
        kotlin.n0.d.o.e(r11, "it");
        r6.k0(r7, r8, r9, r11, r10);
    }

    public static /* synthetic */ u u(p r0, int r1, u r2) {
        return n(r0, r1, r2);
    }

    @Override // com.obric.matrix.platform.e.a
    public byte[] D(int r1, byte[] r2) {
        kotlin.n0.d.o.f(r2, "bytes");
        byte[] r0 = new d0.a().c().encode();
        kotlin.n0.d.o.e(r0, "Builder().build().encode()");
        return r0;
    }

    public final u<Integer, b0> j0(int r6, u<Integer, byte[]> r7) {
        kotlin.n0.d.o.f(r7, "data");
        int r5 = r7.c().intValue();     // Catch: Throwable -> L22
        b0.a r8 = b0.r.decode(r7.d()).b();     // Catch: Throwable -> L22
        com.obric.matrix.q.a.a r0 = com.obric.matrix.q.a.a.f9829a;     // Catch: Throwable -> L22
        Application r1 = com.bytedance.mpaas.app.a.f5245g;     // Catch: Throwable -> L22
        kotlin.n0.d.o.e(r1, "sApplication");     // Catch: Throwable -> L22
        r8.c(r0.h(r1, r6));     // Catch: Throwable -> L22
        b0 r9 = r8.f();     // Catch: Throwable -> L22
        com.obric.matrix.r.c.e.a("ServerBrokerBinder", "invokeAsyn cmd is " + r5 + " request= " + r9);     // Catch: Throwable -> L22
        boolean r2 = true;
        if (r5 < 300000) goto L6;
        if (300000 > r5) goto L21;
        if (r5 < 100000000) goto L21;
    L21:
        return new u(Integer.valueOf(r5), r9);
    L6:
        if (r0.f(com.bytedance.mpaas.app.a.f5245g, r6, r9.n) == true) goto L8;
    L10:
        r2 = false;
    L11:
        if (r2 == true) goto L21;
        throw new com.obric.matrix.s.a();     // Catch: Throwable -> L22
    L8:
        if (r0.a(r5, r9.n) == false) goto L10;
    L22:
        th = move-exception;
        if ((th instanceof com.obric.matrix.s.b) == false) goto L27;
        throw th;
    L27:
        throw new com.obric.matrix.s.f();
    }

    public final f.a.a<u<b0, com.obric.matrix.u.b>> k(u<Integer, b0> r2, com.obric.matrix.platform.e.b r3) {
        kotlin.n0.d.o.f(r2, "it");
        int r1 = r2.c().intValue();
        final b0 r4 = r2.d();
        com.obric.matrix.q.g.k.f9865a.a(r4);
        f.a.a r5 = n.f9991a.a(r1, r4, r3).f(new j(r4));
        kotlin.n0.d.o.e(r5, "HandlerCenter.handlerReq…sponseBody)\n            }");
        return r5;
    }

    public final void k0(b0 r20, com.obric.matrix.w.q r21, int r22, Throwable r23, com.obric.matrix.platform.e.b r24) {
        kotlin.n0.d.o.f(r20, "request");
        kotlin.n0.d.o.f(r21, "monitorInfo");
        kotlin.n0.d.o.f(r23, WsConstants.KEY_CONNECTION_ERROR);
        com.obric.matrix.r.c.c.g("ServerBrokerBinder", "invokeAsyn error exceotion ", r23);     // Catch: Throwable -> L34
        d0.a r14 = new d0.a();     // Catch: Throwable -> L34
        r14.h(o.f9992a.c(r21));     // Catch: Throwable -> L34
        r14.d(Integer.valueOf(r22));     // Catch: Throwable -> L34
        if ((r23 instanceof com.obric.matrix.s.b) == false) goto L6;
        r14.j(Integer.valueOf(((com.obric.matrix.s.b) r23).a()));     // Catch: Throwable -> L34
        r14.e(((com.obric.matrix.s.b) r23).b());     // Catch: Throwable -> L34
        r14.i(((com.obric.matrix.s.b) r23).c());     // Catch: Throwable -> L34
    L7:
        s r0 = s.f10007a;     // Catch: Throwable -> L34
        Integer r15 = r14.f10272b;     // Catch: Throwable -> L34
        kotlin.n0.d.o.e(r15, "responseBuild.statusCode");     // Catch: Throwable -> L34
        r0.b(r22, r15.intValue(), r23.getMessage(), 2);     // Catch: Throwable -> L34
        com.obric.matrix.q.g.k r1 = com.obric.matrix.q.g.k.f9865a;     // Catch: Throwable -> L34
        String r3 = r20.f10198i;     // Catch: Throwable -> L34
        kotlin.n0.d.o.e(r3, "request.appKey");     // Catch: Throwable -> L34
        com.obric.matrix.q.g.f r2 = r1.b(r3);     // Catch: Throwable -> L34
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L34
        r16.put("result", 0);     // Catch: Throwable -> L34
        String r17 = "unknow";
        Integer r6 = r14.f10272b;     // Catch: Throwable -> L32
        kotlin.n0.d.o.e(r6, "responseBuild.statusCode");     // Catch: Throwable -> L32
        r16.put(WsConstants.ERROR_CODE, r6.intValue());     // Catch: Throwable -> L32
        r16.put("error_msg", r14.f10273c);     // Catch: Throwable -> L32
        if (r2 == null) goto L13;
        long r18 = r2.d();     // Catch: Throwable -> L32
    L50:
        r16.put("third_app_version", r18);     // Catch: Throwable -> L30
        if (r2 == null) goto L20;
        String r4 = r2.c();     // Catch: Throwable -> L30
        if (r4 == null) goto L20;
    L21:
        r16.put("platform_sdk_version", r4);     // Catch: Throwable -> L30
        r16.put("cmd", r22);     // Catch: Throwable -> L30
        r16.put("third_app_id", r20.f10198i);     // Catch: Throwable -> L30
        com.obric.matrix.w.p r5 = com.obric.matrix.w.p.a(r22);     // Catch: Throwable -> L30
        if (r5 == null) goto L25;
        String r7 = r5.name();     // Catch: Throwable -> L30
        if (r7 == null) goto L25;
    L26:
        r16.put("cmd_name", r7);     // Catch: Throwable -> L30
        r16.put("log_id", "");     // Catch: Throwable -> L30
        r16.put("request_id", r14.f10275e);     // Catch: Throwable -> L30
        com.obric.matrix.ostracker_api.b.g("matrix_request_result", r16);     // Catch: Throwable -> L30
        d0 r8 = r14.c();     // Catch: Throwable -> L30
        com.obric.matrix.r.c.c.b("ServerBrokerBinder", "invokeAsyn error cmd is " + r22 + " response= " + r8);     // Catch: Throwable -> L30
        if (r24 == null) goto L56;
        r24.A(r22, r8.encode());     // Catch: Throwable -> L30
        return;
    L56:
        return;
    L25:
        r7 = r17;
    L20:
        r4 = "";
    L30:
        th = th;
    L37:
        com.obric.matrix.r.c.c.g("ServerBrokerBinder", "invokeAsyn error and callback exception ", th);
        s.f10007a.b(r22, o0.f10462k.getValue(), th.getMessage(), 1);
        JSONObject r9 = new JSONObject();
        r9.put("result", 2);
        if ((th instanceof DeadObjectException) == false) goto L40;
        String r10 = "DeadObjectException";
    L41:
        r9.put("error_msg", r10);
        r9.put("cmd", r22);
        r9.put("third_app_id", r20.f10198i);
        com.obric.matrix.w.p r11 = com.obric.matrix.w.p.a(r22);
        if (r11 == null) goto L47;
        String r12 = r11.name();
        if (r12 == null) goto L47;
        String r13 = r12;
    L48:
        r9.put("cmd_name", r13);
        com.obric.matrix.ostracker_api.b.g("matrix_request_result_callback_third_error", r9);
        return;
    L47:
        r13 = r17;
        goto L48
    L40:
        r10 = th.toString();
        goto L41
    L13:
        r18 = 0;
    L32:
        th = th;
        goto L37
    L6:
        r14.j(Integer.valueOf(o0.f10462k.getValue()));     // Catch: Throwable -> L34
        r14.e(r23.toString());     // Catch: Throwable -> L34
    L34:
        th = th;
        r17 = "unknow";
        goto L37
    }

    public final void l0(int r20, u<b0, com.obric.matrix.u.b> r21, com.obric.matrix.w.q r22, com.obric.matrix.platform.e.b r23) {
        String r3 = "unknow";
        kotlin.n0.d.o.f(r21, "result");
        kotlin.n0.d.o.f(r22, "monitorInfo");
        b0 r11 = r21.c();
        com.obric.matrix.u.b r12 = r21.d();
        String r10 = r21.c().f10198i;     // Catch: Exception -> L26
        HashMap r14 = new HashMap(r12.b().n);     // Catch: Exception -> L26
        d0.a r15 = new d0.a();     // Catch: Exception -> L26
        r15.d(r11.f10195f);     // Catch: Exception -> L26
        r15.j(r12.b().f10265g);     // Catch: Exception -> L26
        r15.e(r12.b().f10266h);     // Catch: Exception -> L26
        r15.g(r12.b().f10267i);     // Catch: Exception -> L26
        r15.i(r11.f10196g);     // Catch: Exception -> L26
        r15.b(r12.c());     // Catch: Exception -> L26
        r15.h(o.f9992a.c(r22));     // Catch: Exception -> L26
        r15.f(r14);     // Catch: Exception -> L26
        d0 r0 = r15.c();     // Catch: Exception -> L26
        com.obric.matrix.r.c.c.b("ServerBrokerBinder", "invokeAsyn succ appkey=" + r10 + ", cmd=" + r20 + " response=" + r0 + ", currentThread=" + Thread.currentThread().getName());     // Catch: Exception -> L26
        s.f10007a.c(r20, r12.a());     // Catch: Exception -> L26
        if (r23 == null) goto L6;
        r23.A(r20, r0.encode());     // Catch: Exception -> L26
    L6:
        com.obric.matrix.q.g.k r1 = com.obric.matrix.q.g.k.f9865a;     // Catch: Exception -> L26
        String r2 = r11.f10198i;     // Catch: Exception -> L26
        kotlin.n0.d.o.e(r2, "request.appKey");     // Catch: Exception -> L26
        com.obric.matrix.q.g.f r4 = r1.b(r2);     // Catch: Exception -> L26
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L26
        r13.put("result", 1);     // Catch: Exception -> L26
        r13.put(WsConstants.ERROR_CODE, r12.a().b());     // Catch: Exception -> L26
        r13.put("error_msg", r12.a().a());     // Catch: Exception -> L26
        if (r4 == null) goto L10;
        long r16 = r4.d();     // Catch: Exception -> L26
    L38:
        r13.put("third_app_version", r16);     // Catch: Exception -> L24
        if (r4 == null) goto L16;
        String r5 = r4.c();     // Catch: Exception -> L24
        if (r5 == null) goto L16;
    L17:
        r13.put("platform_sdk_version", r5);     // Catch: Exception -> L24
        r13.put("cmd", r20);     // Catch: Exception -> L24
        r13.put("third_app_id", r10);     // Catch: Exception -> L24
        com.obric.matrix.w.p r6 = com.obric.matrix.w.p.a(r20);     // Catch: Exception -> L24
        if (r6 == null) goto L21;
        String r7 = r6.name();     // Catch: Exception -> L24
        if (r7 == null) goto L21;
    L22:
        r13.put("cmd_name", r7);     // Catch: Exception -> L24
        r13.put("log_id", r12.a().c());     // Catch: Exception -> L24
        r13.put("request_id", r11.f10196g);     // Catch: Exception -> L24
        com.obric.matrix.ostracker_api.b.g("matrix_request_result", r13);     // Catch: Exception -> L24
        return;
    L21:
        r7 = "unknow";
    L16:
        r5 = "";
    L24:
        e = e;
    L28:
        com.obric.matrix.r.c.c.g("ServerBrokerBinder", "invokeAsyn succ  but exceotion e.message =" + e.getMessage() + "  -", e);
        JSONObject r8 = new JSONObject();
        r8.put("result", 1);
        r8.put("error_msg", e.getMessage());
        r8.put("cmd", r20);
        r8.put("third_app_id", r11.f10198i);
        com.obric.matrix.w.p r9 = com.obric.matrix.w.p.a(r20);
        if (r9 == null) goto L34;
        String r17 = r9.name();
        if (r17 == null) goto L34;
        r3 = r17;
    L34:
        r8.put("cmd_name", r3);
        com.obric.matrix.ostracker_api.b.g("matrix_request_result_callback_third_error", r8);
        return;
    L10:
        r16 = 0;
    L26:
        e = e;
        goto L28
    }

    @Override // com.obric.matrix.platform.e.a
    public void s(String r5, com.obric.matrix.platform.e.b r6) {
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L18;
        if (r6 == null) goto L18;
        IBinder r3 = r6.asBinder();
        r3.linkToDeath(new com.obric.matrix.q.i.b(r5), 0);     // Catch: Exception -> L15
        com.obric.matrix.q.i.a.f9901a.e(r5, r6);
        com.obric.matrix.r.c.c.b("ServerBrokerBinder", "linkToDeath is invoked for " + r5 + " and binder is " + r3);
        return;
    L15:
        com.obric.matrix.r.c.c.f("ServerBrokerBinder", "linkToDeath occurs exception for " + r5 + " and binder is " + r3);
        return;
    L18:
        throw new IllegalArgumentException("the packageName(" + r5 + ") or serverCallback(" + r6 + ") must not be null or empty.");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.obric.matrix.platform.e.a
    @SuppressLint({"CheckResult"})
    public void z(final int r9, byte[] r10, final com.obric.matrix.platform.e.b r11) {
        kotlin.n0.d.o.f(r10, "bytes");
        final int r0 = Binder.getCallingUid();
        o r1 = o.f9992a;
        final b0 r4 = r1.a(r10);
        final com.obric.matrix.w.q r5 = r1.d(r4);
        f.a.a.e(new u(Integer.valueOf(r9), r10)).j(f.a.l.a.a()).f(new f(this, r0)).d(new h(this, r11)).g(new i(this, r9, r5, r11), new g(this, r4, r5, r9, r11));
    }
}
