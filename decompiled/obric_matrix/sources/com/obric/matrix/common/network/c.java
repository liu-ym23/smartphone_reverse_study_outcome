package com.obric.matrix.common.network;

import d.b.r.d0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u0.k;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a1\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010\t\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a1\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010\t\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a1\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\r\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010\t\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a1\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\r\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010\t\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"TAG", "", "isXTtLogId", "", "headerName", "safeSuspendEnqueue", "Lcom/obric/matrix/common/network/CmdResult;", "T", "Lcom/bytedance/retrofit2/Call;", "needLog", "(Lcom/bytedance/retrofit2/Call;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeSuspendExecute", "suspendEnqueue", "Lcom/bytedance/retrofit2/SsResponse;", "suspendExecute", "common_cnRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class c {

    @kotlin.k0.j.a.f(c = "com.obric.matrix.common.network.CallExtensionKt", f = "CallExtension.kt", l = {22}, m = "safeSuspendExecute")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a<T> extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f8924f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f8925g;

        a(kotlin.k0.d<? super a> r1) {
            super(r1);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f8924f = r2;
            this.f8925g |= Integer.MIN_VALUE;
            return c.b(null, false, this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements l<Throwable, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.b.r.b<T> f8926f;

        b(d.b.r.b<T> r1) {
            this.f8926f = r1;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Throwable r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r1) {
            this.f8926f.cancel();
        }
    }

    public static final boolean a(String r2) {
        o.f(r2, "headerName");
        return k.o("X-Tt-Logid", r2, true);
    }

    public static final <T> Object b(d.b.r.b<T> r5, boolean r6, kotlin.k0.d<? super d<? extends T>> r7) {
        if ((r7 instanceof a) == false) goto L7;
        a r0 = (a) r7;
        int r1 = r0.f8925g;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f8925g = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f8924f;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.f8925g;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        w.b(r8);     // Catch: Throwable -> L13
    L24:
        d0 r9 = (d0) r8;     // Catch: Throwable -> L13
        List<d.b.r.h0.b> r10 = r9.d();     // Catch: Throwable -> L13
        o.e(r10, "result.headers()");     // Catch: Throwable -> L13
        Iterator<T> r11 = r10.iterator();     // Catch: Throwable -> L13
        String r12 = "";
    L26:
        if (r11.hasNext() == false) goto L30;
        d.b.r.h0.b r4 = (d.b.r.h0.b) r11.next();     // Catch: Throwable -> L13
        String r13 = r4.a();     // Catch: Throwable -> L13
        o.e(r13, "it.name");     // Catch: Throwable -> L13
        if (a(r13) == false) goto L26;
        r12 = r4.b();     // Catch: Throwable -> L13
        o.e(r12, "it.value");     // Catch: Throwable -> L13
        goto L26
    L30:
        d.a r14 = d.f8927c;     // Catch: Throwable -> L13
        return new d(r9.a(), r12);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        w.b(r8);
        if (r6 == false) goto L20;
        boolean r15 = true;
    L21:
        r0.f8925g = 1;     // Catch: Throwable -> L13
        r8 = c(r5, r15, r0);     // Catch: Throwable -> L13
        if (r8 != r2) goto L24;
        return r2;
    L20:
        r15 = false;
    L13:
        th = move-exception;
        d.a r16 = d.f8927c;
        return new d(e.a(th), "");
    L7:
        r0 = new a(r7);
        goto L8
    }

    public static final <T> Object c(d.b.r.b<T> r8, boolean r9, kotlin.k0.d<? super d0<T>> r10) {
        h.a.o r0 = new h.a.o(kotlin.k0.i.b.b(r10), 1);
        r0.A();
        d0<T> r1 = r8.execute();
        o.e(r1, "call.execute()");
        if (r9 == false) goto L18;
        String r3 = "";
        List<d.b.r.h0.b> r4 = r1.d();
        if (r4 == null) goto L12;
        o.e(r4, "headers()");
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        d.b.r.h0.b r6 = (d.b.r.h0.b) r5.next();
        com.obric.matrix.r.c.c.d("CallExtension", String.valueOf(r6));
        String r7 = r6.a();
        o.e(r7, "header.name");
        if (a(r7) == false) goto L8;
        r3 = r6.b();
        o.e(r3, "header.value");
    L12:
        StringBuilder r11 = new StringBuilder();
        r11.append("suspendExecute path:");
        d.b.r.h0.c r12 = r8.b();
        if (r12 == null) goto L15;
        String r13 = r12.A();
    L16:
        r11.append(r13);
        r11.append(", code:");
        r11.append(r1.b());
        r11.append(", logId:");
        r11.append(r3);
        com.obric.matrix.r.c.c.b("CallExtension", r11.toString());
        goto L18
    L15:
        r13 = null;
    L18:
        if (r1.e() == true) goto L20;
        v.a r14 = v.f21457g;
        Exception r15 = new Exception("error http code:" + r1.b());
    L26:
        Object r16 = w.a(r15);
        v.b(r16);
        r0.resumeWith(r16);
    L27:
        r0.h(new b(r8));
        Object r17 = r0.x();
        if (r17 != kotlin.k0.i.b.c()) goto L30;
        kotlin.k0.j.a.h.c(r10);
    L30:
        return r17;
    L20:
        if (r1.a() == null) goto L24;
        if (r9 == false) goto L23;
        com.obric.matrix.r.c.c.d("CallExtension", "suspendExecute is successful and body:" + r1.a());
    L23:
        v.a r18 = v.f21457g;
        v.b(r1);
        r0.resumeWith(r1);
        goto L27
    L24:
        v.a r19 = v.f21457g;
        r15 = new Exception("body is null.");
        goto L26
    }
}
