package com.obric.matrix.u;

import com.obric.matrix.w.d0;
import com.obric.matrix.w.e0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.i0.m0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/model/BaseResponseBody;", "", "()V", "monitorData", "Lcom/obric/matrix/model/BaseMonitorData;", "getMonitorData", "()Lcom/obric/matrix/model/BaseMonitorData;", "setMonitorData", "(Lcom/obric/matrix/model/BaseMonitorData;)V", "response", "Lcom/obric/matrix/proto/Response;", "getResponse", "()Lcom/obric/matrix/proto/Response;", "setResponse", "(Lcom/obric/matrix/proto/Response;)V", "responseBody", "Lcom/obric/matrix/proto/ResponseBody;", "getResponseBody", "()Lcom/obric/matrix/proto/ResponseBody;", "setResponseBody", "(Lcom/obric/matrix/proto/ResponseBody;)V", "Builder", "sdk_platform_server_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f10039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f10040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.matrix.u.a f10041c;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u0003\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/model/BaseResponseBody$Builder;", "", "()V", "extraParams", "", "", "isNeedChangeStatusCode", "", "monitorData", "Lcom/obric/matrix/model/BaseMonitorData;", "responseBody", "Lcom/obric/matrix/proto/ResponseBody;", "build", "Lcom/obric/matrix/model/BaseResponseBody;", "generateResponse", "Lcom/obric/matrix/proto/Response;", "baseMonitorData", "isNeed", "sdk_platform_server_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private e0 f10042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.obric.matrix.u.a f10043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f10044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Map<String, String> f10045d;

        public a() {
            this.f10044c = true;
            this.f10045d = m0.h();
        }

        private final d0 b(e0 r3, com.obric.matrix.u.a r4) {
            if (this.f10044c == false) goto L5;
            int r0 = r4.b();
        L6:
            d0.a r1 = new d0.a();
            r1.j(r0);
            r1.e(r4.a());
            r1.g(r4.c());
            r1.b(r3);
            r1.f(this.f10045d);
            d0 r2 = r1.c();
            o.e(r2, "Builder()\n              …\n                .build()");
            return r2;
        L5:
            r0 = 0;
            goto L6
        }

        public final b a() {
            b r0 = new b();
            e0 r1 = this.f10042a;
            if (r1 == null) goto L18;
            com.obric.matrix.u.a r4 = this.f10043b;
            if (r4 == null) goto L16;
            r0.e(b(r1, r4));
            e0 r2 = this.f10042a;
            if (r2 == null) goto L14;
            r0.f(r2);
            com.obric.matrix.u.a r6 = this.f10043b;
            if (r6 == null) goto L12;
            r0.d(r6);
            return r0;
        L12:
            o.v("monitorData");
            throw null;
        L14:
            o.v("responseBody");
            throw null;
        L16:
            o.v("monitorData");
            throw null;
        L18:
            o.v("responseBody");
            throw null;
        }

        public final a c(com.obric.matrix.u.a r2) {
            o.f(r2, "monitorData");
            this.f10043b = r2;
            return this;
        }

        public final a d(e0 r2) {
            o.f(r2, "responseBody");
            this.f10042a = r2;
            return this;
        }
    }

    public b() {
    }

    public final com.obric.matrix.u.a a() {
        com.obric.matrix.u.a r0 = this.f10041c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.v("monitorData");
        throw null;
    }

    public final d0 b() {
        d0 r0 = this.f10039a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.v("response");
        throw null;
    }

    public final e0 c() {
        e0 r0 = this.f10040b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.v("responseBody");
        throw null;
    }

    public final void d(com.obric.matrix.u.a r2) {
        o.f(r2, "<set-?>");
        this.f10041c = r2;
    }

    public final void e(d0 r2) {
        o.f(r2, "<set-?>");
        this.f10039a = r2;
    }

    public final void f(e0 r2) {
        o.f(r2, "<set-?>");
        this.f10040b = r2;
    }
}
