package com.obric.matrix.q.b;

import com.obric.matrix.w.b0;
import h.a.b1;
import h.a.h;
import h.a.m0;
import h.a.q1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/base/cmd/CmdHandlerManager;", "Lcom/obric/matrix/base/cmd/ICmdHandlerManager;", "()V", "cmdHandlerListener", "", "Lcom/obric/matrix/base/cmd/CmdHandlerListener;", "iCmdHandlers", "", "Lcom/obric/matrix/base/cmd/ICmdHandler;", "handleRequest", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "cmd", "", "request", "Lcom/obric/matrix/proto/Request;", "callback", "Lcom/obric/matrix/platform/server/IServerCallback;", "notifyCmdHandlerListener", "", "registerToList", "iCmdHandler", "setCmdHandlerListener", "listener", "unregisterFromList", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9840a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Collection<d> f9841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<b> f9842c = null;

    @f(c = "com.obric.matrix.base.cmd.CmdHandlerManager$notifyCmdHandlerListener$1", f = "CmdHandlerManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9843f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b0 f9844g;

        a(b0 r1, kotlin.k0.d<? super a> r2) {
            this.f9844g = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
            return new a(this.f9844g, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((a) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            kotlin.k0.i.b.c();
            if (this.f9843f != 0) goto L13;
            w.b(r2);
            List r3 = c.a();     // Catch: Exception -> L14
            b0 r1 = this.f9844g;     // Catch: Exception -> L14
            Iterator r4 = r3.iterator();     // Catch: Exception -> L14
        L7:
            if (r4.hasNext() == false) goto L11;
            ((b) r4.next()).a(r1);     // Catch: Exception -> L14
        L11:
            return f0.f18324a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f9840a = new c();
        Collection<d> r0 = Collections.synchronizedCollection(new ArrayList());
        o.e(r0, "synchronizedCollection(m…bleListOf<ICmdHandler>())");
        f9841b = r0;
        f9842c = new ArrayList();
    }

    private c() {
    }

    public static final /* synthetic */ List a() {
        return f9842c;
    }

    private final void c(b0 r7) {
        h.b(q1.f17560f, b1.b(), null, new a(r7, null), 2, null);
    }

    public f.a.a<com.obric.matrix.u.b> b(int r4, b0 r5, com.obric.matrix.platform.e.b r6) {
        o.f(r5, "request");
        d r0 = com.obric.matrix.q.b.a.a(r4);
        if (r0 == null) goto L5;
        f.a.a<com.obric.matrix.u.b> r2 = r0.a(r4, r5, r6);
    L6:
        if (r2 == null) goto L9;
        c(r5);
        return r2;
    L9:
        com.obric.matrix.r.c.c.b("CmdHandlerManager", "handleRequest() handle result is null, by ICmdHandler " + r0);
        Iterator<T> r3 = f9841b.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        f.a.a<com.obric.matrix.u.b> r7 = ((d) r3.next()).a(r4, r5, r6);
        if (r7 == null) goto L11;
        f9840a.c(r5);
        return r7;
    L16:
        com.obric.matrix.r.c.c.b("CmdHandlerManager", "handleRequest() no cmdHandler handle this request, cmd = " + r4 + ", request = " + r5);
        return null;
    L5:
        r2 = null;
        goto L6
    }
}
