package com.obric.matrix.common.cmd;

import com.bytedance.news.common.service.manager.d;
import com.obric.matrix.picolinks_api.IPicoLinks;
import com.obric.matrix.u.b;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.e0;
import com.obric.matrix.w.m0;
import com.obric.matrix.w.n0;
import com.obric.matrix.w.p;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.d0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/matrix/common/cmd/CmdProcess;", "", "()V", "handleRequestSync", "Lcom/obric/matrix/model/BaseResponseBody;", "cmd", "", "request", "Lcom/obric/matrix/proto/Request;", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8910a = null;

    /* JADX INFO: renamed from: com.obric.matrix.common.cmd.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/proto/StartPicoLinksResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0240a extends q implements l<n0, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0<n0> f8911f;

        C0240a(d0<n0> r1) {
            this.f8911f = r1;
            super(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(n0 r2) {
            o.f(r2, "it");
            this.f8911f.f18431f = r2;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(n0 r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    static {
        f8910a = new a();
    }

    private a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b a(int r7, b0 r8) {
        o.f(r8, "request");
        if (r7 != p.s.getValue()) goto L6;
        d0 r6 = new d0();
        IPicoLinks r9 = (IPicoLinks) d.a(IPicoLinks.class);
        m0 r10 = r8.o.q;
        o.e(r10, "request.body.startPicoLinksRequest");
        r9.doStartPicoLinks(r10, new C0240a(r6));
        b.a r11 = new b.a();
        r11.c(new com.obric.matrix.u.a("", 0, ""));
        e0.a r12 = new e0.a();
        r12.l((n0) r6.f18431f);
        e0 r13 = r12.b();
        o.e(r13, "Builder().startPicoLinks…icoLinksResponse).build()");
        r11.d(r13);
        return r11.a();
    L6:
        if (r7 != p.f10466h.getValue()) goto L8;
        b.a r14 = new b.a();
        r14.c(new com.obric.matrix.u.a("", 0, ""));
        e0.a r15 = new e0.a();
        com.obric.matrix.w.b.a r16 = new com.obric.matrix.w.b.a();
        r16.b("123");
        r15.a(r16.a());
        e0 r17 = r15.b();
        String r18 = "Builder()\n              …                 .build()";
    L9:
        o.e(r17, r18);
        r14.d(r17);
        return r14.a();
    L8:
        r14 = new b.a();
        r14.c(new com.obric.matrix.u.a(null, -100021, "cmd not support send sync", 1, null));
        r17 = new e0.a().b();
        r18 = "Builder().build()";
        goto L9
    }
}
