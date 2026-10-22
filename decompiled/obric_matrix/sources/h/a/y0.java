package h.a;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", WsConstants.KEY_CONNECTION_STATE, "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class y0<T> extends h.a.i3.h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17589h;

    public y0(int r1) {
        this.f17589h = r1;
    }

    public void a(Object r1, Throwable r2) {
    }

    public abstract kotlin.k0.d<T> b();

    public Throwable d(Object r2) {
        if ((r2 instanceof y) == false) goto L5;
        y r3 = (y) r2;
    L6:
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.f17588a;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T e(Object r1) {
        return r1;
    }

    public final void f(Throwable r3, Throwable r4) {
        if (r3 != null) goto L5;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        kotlin.a.a(r3, r4);
    L8:
        if (r3 != null) goto L10;
        r3 = r4;
    L10:
        kotlin.n0.d.o.c(r3);
        j0.a(b().getContext(), new p0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", r3));
    }

    public abstract Object g();

    @Override // java.lang.Runnable
    public final void run() {
        if (q0.a() == true) goto L5;
    L12:
        h.a.i3.i r0 = this.f17498g;
        h.a.f3.i r1 = (h.a.f3.i) b();     // Catch: Throwable -> L54
        kotlin.k0.d<T> r2 = r1.f17372j;     // Catch: Throwable -> L54
        Object r3 = r1.f17374l;     // Catch: Throwable -> L54
        kotlin.k0.g r4 = r2.getContext();     // Catch: Throwable -> L54
        Object r5 = h.a.f3.j0.c(r4, r3);     // Catch: Throwable -> L54
        if (r5 == h.a.f3.j0.f17377a) goto L17;
        a3<?> r6 = f0.g(r2, r4, r5);     // Catch: Throwable -> L54
    L63:
        kotlin.k0.g r7 = r2.getContext();     // Catch: Throwable -> L48
        Object r8 = g();     // Catch: Throwable -> L48
        Throwable r9 = d(r8);     // Catch: Throwable -> L48
        if (r9 == null) goto L21;
    L23:
        x1 r10 = null;
    L24:
        if (r10 != null) goto L26;
    L35:
        if (r9 == null) goto L37;
        kotlin.v.a r11 = kotlin.v.f21457g;     // Catch: Throwable -> L48
        Object r12 = kotlin.w.a(r9);     // Catch: Throwable -> L48
        kotlin.v.b(r12);     // Catch: Throwable -> L48
    L34:
        r2.resumeWith(r12);     // Catch: Throwable -> L48
        Object r13 = kotlin.f0.f18324a;     // Catch: Throwable -> L48
        if (r6 != null) goto L41;
    L42:
        h.a.f3.j0.a(r4, r5);     // Catch: Throwable -> L54
    L61:
        kotlin.v.a r14 = kotlin.v.f21457g;     // Catch: Throwable -> L45
        r0.a();     // Catch: Throwable -> L45
        kotlin.v.b(r13);     // Catch: Throwable -> L45
    L47:
        f(null, kotlin.v.d(r13));
        return;
    L45:
        th = move-exception;
        kotlin.v.a r15 = kotlin.v.f21457g;
        r13 = kotlin.w.a(th);
        kotlin.v.b(r13);
        goto L47
    L41:
        if (r6.Q0() == false) goto L61;
    L37:
        r12 = e(r8);     // Catch: Throwable -> L48
        kotlin.v.a r16 = kotlin.v.f21457g;     // Catch: Throwable -> L48
        kotlin.v.b(r12);     // Catch: Throwable -> L48
        goto L34
    L26:
        if (r10.b() == true) goto L35;
        Throwable r17 = r10.A();     // Catch: Throwable -> L48
        a(r8, r17);     // Catch: Throwable -> L48
        kotlin.v.a r18 = kotlin.v.f21457g;     // Catch: Throwable -> L48
        if (q0.d() == true) goto L30;
    L33:
        r12 = kotlin.w.a(r17);     // Catch: Throwable -> L48
        kotlin.v.b(r12);     // Catch: Throwable -> L48
        goto L34
    L30:
        if ((r2 instanceof kotlin.k0.j.a.e) == false) goto L33;
        r17 = h.a.f3.e0.a(r17, (kotlin.k0.j.a.e) r2);     // Catch: Throwable -> L48
        goto L33
    L21:
        if (z0.b(this.f17589h) == false) goto L23;
        r10 = (x1) r7.get(x1.f17584d);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        if (r6 != null) goto L51;
    L52:
        h.a.f3.j0.a(r4, r5);     // Catch: Throwable -> L54
    L53:
        throw th;     // Catch: Throwable -> L54
    L51:
        if (r6.Q0() == false) goto L53;
    L17:
        r6 = null;
    L54:
        th = move-exception;
        kotlin.v.a r19 = kotlin.v.f21457g;     // Catch: Throwable -> L57
        r0.a();     // Catch: Throwable -> L57
        Object r20 = kotlin.f0.f18324a;     // Catch: Throwable -> L57
        kotlin.v.b(r20);     // Catch: Throwable -> L57
    L59:
        f(th, kotlin.v.d(r20));
        return;
    L57:
        th = move-exception;
        kotlin.v.a r21 = kotlin.v.f21457g;
        r20 = kotlin.w.a(th);
        kotlin.v.b(r20);
        goto L59
    L5:
        if (this.f17589h == (-1)) goto L7;
        boolean r22 = true;
    L8:
        if (r22 == true) goto L12;
        throw new AssertionError();
    L7:
        r22 = false;
        goto L8
    }
}
