package p000j.k0.g;

import com.obric.matrix.common_api.INetworkApi;
import java.util.List;
import k.n;
import k.q;
import p000j.d0;
import p000j.e0;
import p000j.f0;
import p000j.k0.c;
import p000j.k0.d;
import p000j.m;
import p000j.o;
import p000j.v;
import p000j.x;
import p000j.y;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f17871a;

    public a(o r1) {
        this.f17871a = r1;
    }

    private String b(List<m> r5) {
        StringBuilder r4 = new StringBuilder();
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r1 <= 0) goto L6;
        r4.append("; ");
    L6:
        m r2 = r5.get(r1);
        r4.append(r2.c());
        r4.append('=');
        r4.append(r2.k());
        r1 = r1 + 1;
        goto L3
    L8:
        return r4.toString();
    }

    @Override // p000j.x
    public f0 a(x.a r11) {
        d0 r0 = r11.b();
        d0.a r1 = r0.g();
        e0 r2 = r0.a();
        if (r2 == null) goto L11;
        y r7 = r2.b();
        if (r7 == null) goto L7;
        r1.d(INetworkApi.CONTENT_TYPE, r7.toString());
    L7:
        long r8 = r2.a();
        if (r8 == (-1)) goto L10;
        r1.d("Content-Length", Long.toString(r8));
        r1.h("Transfer-Encoding");
        goto L11
    L10:
        r1.d("Transfer-Encoding", "chunked");
        r1.h("Content-Length");
    L11:
        boolean r9 = false;
        if (r0.c("Host") != null) goto L15;
        r1.d("Host", c.s(r0.k(), false));
    L15:
        if (r0.c("Connection") != null) goto L18;
        r1.d("Connection", "Keep-Alive");
    L18:
        if (r0.c("Accept-Encoding") == null) goto L20;
    L22:
        List<m> r3 = this.f17871a.b(r0.k());
        if (r3.isEmpty() == true) goto L26;
        r1.d("Cookie", b(r3));
    L26:
        if (r0.c("User-Agent") != null) goto L28;
        r1.d("User-Agent", d.a());
    L28:
        f0 r12 = r11.d(r1.b());
        e.i(this.f17871a, r0.k(), r12.F());
        f0.a r10 = r12.Q();
        r10.p(r0);
        if (r9 == false) goto L36;
        if ("gzip".equalsIgnoreCase(r12.A("Content-Encoding")) == false) goto L36;
        if (e.c(r12) == false) goto L36;
        n r4 = new n(r12.a().A());
        v.a r5 = r12.F().h();
        r5.e("Content-Encoding");
        r5.e("Content-Length");
        r10.j(r5.d());
        r10.b(new h(r12.A(INetworkApi.CONTENT_TYPE), -1, q.b(r4)));
    L36:
        return r10.c();
    L20:
        if (r0.c("Range") != null) goto L22;
        r9 = true;
        r1.d("Accept-Encoding", "gzip");
        goto L22
    }
}
