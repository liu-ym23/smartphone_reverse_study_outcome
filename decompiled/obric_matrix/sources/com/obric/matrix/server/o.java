package com.obric.matrix.server;

import com.obric.matrix.w.b0;
import com.obric.matrix.w.d0;
import java.util.Set;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.t0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/server/MonitorHelper;", "", "()V", "BLACK_CMD_SET", "", "", "getSafeRequest", "Lcom/obric/matrix/proto/Request;", "bytes", "", "getSafeResponse", "Lcom/obric/matrix/proto/Response;", "onMatrixBindProcessOver", "Lcom/obric/matrix/proto/MonitorInfo;", "requestMonitorInfo", "onMatrixBindRevData", "request", "onThirdCppProcessOver", "", "response", "onThirdJniInvokeAsyn", "onThirdRevResult", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f9992a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<Integer> f9993b = null;

    static {
        f9992a = new o();
        f9993b = t0.a(112002);
    }

    private o() {
    }

    public final b0 a(byte[] r2) {
        kotlin.n0.d.o.f(r2, "bytes");
        b0 r1 = new b0.a().f();
        kotlin.n0.d.o.e(r1, "Builder().build()");
        b0 r3 = b0.r.decode(r2);     // Catch: Exception -> L6
        kotlin.n0.d.o.e(r3, "ADAPTER.decode(bytes)");     // Catch: Exception -> L6
        return r3;
    L9:
        return r1;
    }

    public final d0 b(byte[] r2) {
        kotlin.n0.d.o.f(r2, "bytes");
        d0 r1 = new d0.a().c();
        kotlin.n0.d.o.e(r1, "Builder().build()");
        d0 r3 = d0.o.decode(r2);     // Catch: Exception -> L6
        kotlin.n0.d.o.e(r3, "ADAPTER.decode(bytes)");     // Catch: Exception -> L6
        return r3;
    L9:
        return r1;
    }

    public final com.obric.matrix.w.q c(com.obric.matrix.w.q r3) {
        kotlin.n0.d.o.f(r3, "requestMonitorInfo");
        com.obric.matrix.w.q.a r2 = r3.b();
        r2.b(Long.valueOf(System.currentTimeMillis()));
        com.obric.matrix.w.q r4 = r2.a();
        kotlin.n0.d.o.e(r4, "requestMonitorInfo.newBu…rentTimeMillis()).build()");
        return r4;
    }

    public final com.obric.matrix.w.q d(b0 r3) {
        kotlin.n0.d.o.f(r3, "request");
        com.obric.matrix.w.q r2 = r3.q;
        if (r2 != null) goto L5;
        r2 = new com.obric.matrix.w.q.a().a();
    L5:
        com.obric.matrix.w.q.a r4 = r2.b();
        r4.c(Long.valueOf(System.currentTimeMillis()));
        com.obric.matrix.w.q r5 = r4.a();
        kotlin.n0.d.o.e(r5, "monitorInfo.newBuilder()…rentTimeMillis()).build()");
        return r5;
    }

    public final void e(d0 r11) {
        kotlin.n0.d.o.f(r11, "response");
        if (f9993b.contains(r11.f10264f) == false) goto L5;
        return;
    L5:
        com.obric.matrix.w.q r10 = r11.m;
        if (r10 != null) goto L8;
        r10 = new com.obric.matrix.w.q.a().a();
    L8:
        long r0 = System.currentTimeMillis();
        com.obric.matrix.server.t.a.c r2 = com.obric.matrix.server.t.a.c.f10010a;
        JSONObject r3 = new JSONObject();
        long r4 = r10.f10477g.longValue();
        Long r6 = r10.f10476f;
        kotlin.n0.d.o.e(r6, "monitorInfo.thirdStartTime");
        r3.put("start_to_jni_during", r4 - r6.longValue());
        long r5 = r10.f10478h.longValue();
        Long r7 = r10.f10477g;
        kotlin.n0.d.o.e(r7, "monitorInfo.thirdJavaJniCallTime");
        r3.put("jni_to_bind_rev_during", r5 - r7.longValue());
        long r8 = r10.f10479i.longValue();
        Long r9 = r10.f10478h;
        kotlin.n0.d.o.e(r9, "monitorInfo.matrixBindRevTime");
        r3.put("bind_process_during", r8 - r9.longValue());
        long r12 = r10.f10480j.longValue();
        Long r13 = r10.f10479i;
        kotlin.n0.d.o.e(r13, "monitorInfo.matrixBindProcessEndTime");
        r3.put("bind_to_third_rev_during", r12 - r13.longValue());
        Long r14 = r10.f10480j;
        kotlin.n0.d.o.e(r14, "monitorInfo.thirdJavaRevResResult");
        r3.put("third_process_res_during", r0 - r14.longValue());
        Long r15 = r10.f10476f;
        kotlin.n0.d.o.e(r15, "monitorInfo.thirdStartTime");
        r3.put("all_during", r0 - r15.longValue());
        Integer r16 = r11.f10264f;
        kotlin.n0.d.o.e(r16, "response.cmd");
        r3.put("cmd", r16.intValue());
        f0 r17 = f0.f18324a;
        r2.m("matrix_request_time", r3);
    }

    public final b0 f(b0 r6) {
        kotlin.n0.d.o.f(r6, "request");
        com.obric.matrix.w.q r5 = r6.q;
        if (r5 != null) goto L5;
        r5 = new com.obric.matrix.w.q.a().a();
    L5:
        Long r0 = r5.f10476f;
        kotlin.n0.d.o.e(r0, "startTime");
        if (r0.longValue() > 0) goto L8;
        r0 = Long.valueOf(System.currentTimeMillis());
    L8:
        b0.a r7 = r6.b();
        com.obric.matrix.w.q.a r8 = r5.b();
        r8.f(r0);
        r8.d(Long.valueOf(System.currentTimeMillis()));
        r7.j(r8.a());
        b0 r9 = r7.f();
        kotlin.n0.d.o.e(r9, "newRequest");
        return r9;
    }

    public final d0 g(d0 r3) {
        kotlin.n0.d.o.f(r3, "response");
        com.obric.matrix.w.q r2 = r3.m;
        if (r2 != null) goto L5;
        r2 = new com.obric.matrix.w.q.a().a();
    L5:
        com.obric.matrix.w.q.a r4 = r2.b();
        r4.e(Long.valueOf(System.currentTimeMillis()));
        com.obric.matrix.w.q r5 = r4.a();
        d0.a r6 = r3.b();
        r6.h(r5);
        d0 r7 = r6.c();
        kotlin.n0.d.o.e(r7, "response.newBuilder()\n  …nfo)\n            .build()");
        return r7;
    }
}
