package com.obric.matrix.picolinks;

import android.net.Uri;
import android.util.Log;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.obric.matrix.picolinks_api.IPicoLinks;
import com.obric.matrix.s.e;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.c0;
import com.obric.matrix.w.d0;
import com.obric.matrix.w.e0;
import com.obric.matrix.w.m0;
import com.obric.matrix.w.n0;
import com.obric.matrix.w.o0;
import com.obric.matrix.w.p;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0017J$\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001aH\u0017R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/matrix/picolinks/PicoLinksImpl;", "Lcom/obric/matrix/picolinks_api/IPicoLinks;", "()V", "callbacks", "", "", "Lkotlin/Function1;", "Lcom/obric/matrix/proto/StartPicoLinksResponse;", "", "callbackPicoLink", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "request", "Lcom/obric/matrix/proto/Request;", "doStartPicoLinks", "Lcom/obric/matrix/proto/StartPicoLinksRequest;", "callback", "isSafePicoLinksRequest", "", "scene", "Lcom/obric/matrix/proto/StartPicoLinksRequest$SCENE;", "targetUrl", "Landroid/net/Uri;", "referrer", "", "startPicoLinks", "Lcom/obric/matrix/platform/server/IServerCallback;", "picolinks_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PicoLinksImpl implements IPicoLinks {
    private final Map<Integer, l<n0, f0>> callbacks;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/proto/StartPicoLinksResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements l<n0, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.platform.e.b f9476f;

        a(com.obric.matrix.platform.e.b r1) {
            this.f9476f = r1;
            super(1);
        }

        public final void a(n0 r5) {
            o.f(r5, "it");
            com.obric.matrix.u.b.a r0 = new com.obric.matrix.u.b.a();
            r0.c(new com.obric.matrix.u.a("", 0, ""));
            e0.a r1 = new e0.a();
            r1.l(r5);
            e0 r6 = r1.b();
            o.e(r6, "Builder().startPicoLinksResponse(it).build()");
            r0.d(r6);
            com.obric.matrix.u.b r7 = r0.a();
            d0.a r2 = new d0.a();
            p r3 = p.s;
            r2.d(Integer.valueOf(r3.getValue()));
            r2.j(Integer.valueOf(o0.f10458g.getValue()));
            r2.i(BDLocationException.ERROR_TIMEOUT);
            r2.b(r7.c());
            d0 r8 = r2.c();
            com.obric.matrix.platform.e.b r4 = this.f9476f;
            if (r4 == null) goto L6;
            r4.A(r3.getValue(), r8.encode());
            return;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(n0 r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    public PicoLinksImpl() {
        this.callbacks = new LinkedHashMap();
    }

    public static /* synthetic */ void a(b0 r0, PicoLinksImpl r1, com.obric.matrix.platform.e.b r2, f.a.b r3) {
        m66startPicoLinks$lambda0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void b(b0 r0, PicoLinksImpl r1, f.a.b r2) {
        m65callbackPicoLink$lambda1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: callbackPicoLink$lambda-1, reason: not valid java name */
    private static final void m65callbackPicoLink$lambda1(b0 r2, PicoLinksImpl r3, f.a.b r4) {
        o.f(r2, "$request");
        o.f(r3, "this$0");
        o.f(r4, "it");
        c0 r0 = r2.o;
        if (r0 == null) goto L12;
        if (r0.r == null) goto L12;
        Log.d("PicoLinks", "callbackPicoLink:" + r2.o.r);
        n0.a r1 = new n0.a();
        r1.b(n0.b.f10433h);
        r1.c(r2.o.r.f10568g);
        n0 r5 = r1.a();
        l<n0, f0> r6 = r3.callbacks.remove(r2.o.r.f10567f);
        if (r6 == null) goto L9;
        o.e(r5, "startPicoLinksResponse");
        r6.invoke(r5);
    L9:
        r4.a();
        return;
    L12:
        throw new e(r2);
    }

    private final boolean isSafePicoLinksRequest(m0.c r5, Uri r6, String r7) {
        if (r5 == m0.c.f10417g) goto L7;
        if (r5 == m0.c.f10418h) goto L7;
        return true;
    L7:
        if (r7 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == true) goto L53;
        Uri r9 = Uri.parse(r7);
        String r10 = r9.getHost();
        if (r10 != null) goto L17;
    L19:
        boolean r11 = false;
    L20:
        if (r11 == true) goto L54;
        String r12 = r9.getHost();
        if (r12 != null) goto L24;
    L26:
        boolean r13 = false;
    L27:
        if (r13 == true) goto L55;
        String r14 = r9.getHost();
        if (r14 != null) goto L31;
    L33:
        boolean r15 = false;
    L34:
        if (r15 == true) goto L56;
        String r16 = r9.getHost();
        if (r16 != null) goto L38;
    L40:
        boolean r17 = false;
    L41:
        if (r17 == false) goto L44;
        return true;
    L44:
        if (o.a(r6.getHost(), r9.getHost()) == false) goto L51;
        if (r6.getPort() != r9.getPort()) goto L51;
        if (o.a(r6.getScheme(), r9.getScheme()) == false) goto L51;
        return true;
    L51:
        return false;
    L38:
        if (k.n(r16, "bytedance.com", false, 2, null) != true) goto L40;
        r17 = true;
        goto L41
    L56:
        return true;
    L31:
        if (k.n(r14, "bytedance.net", false, 2, null) != true) goto L33;
        r15 = true;
        goto L34
    L55:
        return true;
    L24:
        if (k.n(r12, "picoxr.com", false, 2, null) != true) goto L26;
        r13 = true;
        goto L27
    L54:
        return true;
    L17:
        if (k.n(r10, "picovr.com", false, 2, null) != true) goto L19;
        r11 = true;
        goto L20
    L53:
        return true;
    L9:
        if (r7.length() == 0) goto L12;
        r8 = false;
        goto L13
    }

    /* JADX INFO: renamed from: startPicoLinks$lambda-0, reason: not valid java name */
    private static final void m66startPicoLinks$lambda0(b0 r1, PicoLinksImpl r2, com.obric.matrix.platform.e.b r3, f.a.b r4) {
        o.f(r1, "$request");
        o.f(r2, "this$0");
        o.f(r4, "it");
        c0 r0 = r1.o;
        if (r0 == null) goto L12;
        m0 r5 = r0.q;
        if (r5 == null) goto L12;
        o.e(r5, "request.body.startPicoLinksRequest");     // Catch: Throwable -> L8
        r2.doStartPicoLinks(r5, new a(r3));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Log.w("PicoLinks", th);
        r4.onError(th);
        return;
    L12:
        throw new e(r1);
    }

    @Override // com.obric.matrix.picolinks_api.IPicoLinks
    public f.a.a<com.obric.matrix.u.b> callbackPicoLink(final b0 r2) {
        o.f(r2, "request");
        f.a.a<com.obric.matrix.u.b> r1 = f.a.a.b(new b(r2, this));
        o.e(r1, "create {\n            if …it.onComplete()\n        }");
        return r1;
    }

    @Override // com.obric.matrix.picolinks_api.IPicoLinks
    public void doStartPicoLinks(m0 r9, l<? super n0, f0> r10) {
        o.f(r9, "request");
        o.f(r10, "callback");
        Log.d("PicoLinks", "doStartPicoLinks:" + r9);
        Uri r1 = Uri.parse(r9.f10413h);
        List<String> r3 = r1.getPathSegments();
        o.e(r3, "uri.pathSegments");
        boolean r4 = true;
        String r5 = (String) r.S(r3, 1);
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L46;
        m0.c r7 = r9.f10411f;
        o.e(r7, "request.scene");
        o.e(r1, "uri");
        if (isSafePicoLinksRequest(r7, r1, r9.f10412g) == false) goto L44;
        String r11 = r1.getQueryParameter("method");
        if (r11 == null) goto L26;
        int r8 = r11.hashCode();
        if (r8 == (-1618876223)) goto L23;
        if (r8 != 1984153269) goto L26;
        if (r11.equals("service") == false) goto L26;
    L25:
        r4 = false;
    L30:
        if (r4 == true) goto L34;
        String r12 = r1.getQueryParameter("fallback");
        if (r12 == null) goto L34;
        c r13 = c.f9482a;
        Uri r14 = Uri.parse(r12);
        o.e(r14, "parse(it)");
        r4 = r13.b(r5, r14);
    L34:
        if (r4 == true) goto L36;
        r4 = c.f9482a.d(r5, r1);
    L36:
        if (r4 == false) goto L42;
        n0.a r15 = new n0.a();
        r15.b(n0.b.f10432g);
        n0 r16 = r15.a();
        o.e(r16, "Builder().phase(StartPic…hase.SYNC_INVOKE).build()");
        r10.invoke(r16);
        String r17 = r1.getQueryParameter("callback");
        if (r17 == null) goto L47;
        Log.d("PicoLinks", "callback: " + r17);
        n0.a r18 = new n0.a();
        r18.b(n0.b.f10434i);
        r18.c(kotlin.i0.m0.e(a0.a("redirectUrl", r17)));
        n0 r19 = r18.a();
        o.e(r19, "Builder()\n              …IRECT_URL to it)).build()");
        r10.invoke(r19);
        return;
    L47:
        return;
    L42:
        throw new IllegalStateException("PicoLinks Fail: " + r1);
    L23:
        if (r11.equals("broadcast") == true) goto L25;
    L26:
        int r20 = r10.hashCode();
        c r21 = c.f9482a;
        if (r21.c(r5, r1, r20) == false) goto L29;
        this.callbacks.put(Integer.valueOf(r20), r10);
        goto L30
    L29:
        r4 = r21.a(r5, r1);
        goto L30
    L44:
        throw new IllegalAccessException("Unsafe Access");
    L46:
        throw new IllegalArgumentException("Pkg Not Found");
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L9
    }

    @Override // com.obric.matrix.picolinks_api.IPicoLinks
    public f.a.a<com.obric.matrix.u.b> startPicoLinks(final b0 r2, final com.obric.matrix.platform.e.b r3) {
        o.f(r2, "request");
        f.a.a<com.obric.matrix.u.b> r1 = f.a.a.b(new com.obric.matrix.picolinks.a(r2, this, r3));
        o.e(r1, "create {\n            if …)\n            }\n        }");
        return r1;
    }
}
