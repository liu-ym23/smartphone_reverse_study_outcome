package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a\u0019\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a'\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001e"}, d2 = {"MODE_ATOMIC", "", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "", "(I)Z", "isReusableMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class z0 {
    public static final <T> void a(y0<? super T> r4, int r5) {
        boolean r1 = true;
        if (q0.a() == true) goto L5;
    L12:
        kotlin.k0.d<? super T> r0 = r4.b();
        if (r5 == 4) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L18;
    L25:
        d(r4, r0, r1);
        return;
    L18:
        if ((r0 instanceof h.a.f3.i) == false) goto L25;
        if (b(r5) != b(r4.f17589h)) goto L25;
        g0 r6 = ((h.a.f3.i) r0).f17371i;
        kotlin.k0.g r2 = r0.getContext();
        if (r6.isDispatchNeeded(r2) == false) goto L24;
        r6.dispatch(r2, r4);
        return;
    L24:
        e(r4);
        return;
    L5:
        if (r5 == (-1)) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L12;
        throw new AssertionError();
    L7:
        r3 = false;
        goto L8
    }

    public static final boolean b(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static final boolean c(int r1) {
        if (r1 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> void d(y0<? super T> r3, kotlin.k0.d<? super T> r4, boolean r5) {
        Object r0 = r3.g();
        Throwable r1 = r3.d(r0);
        if (r1 == null) goto L5;
        kotlin.v.a r6 = kotlin.v.f21457g;
        Object r7 = kotlin.w.a(r1);
    L6:
        kotlin.v.b(r7);
        if (r5 == false) goto L23;
        h.a.f3.i r8 = (h.a.f3.i) r4;
        kotlin.k0.d<T> r9 = r8.f17372j;
        Object r2 = r8.f17374l;
        kotlin.k0.g r10 = r9.getContext();
        Object r11 = h.a.f3.j0.c(r10, r2);
        if (r11 == h.a.f3.j0.f17377a) goto L11;
        a3<?> r12 = f0.g(r9, r10, r11);
    L25:
        r8.f17372j.resumeWith(r7);     // Catch: Throwable -> L17
        kotlin.f0 r13 = kotlin.f0.f18324a;     // Catch: Throwable -> L17
        if (r12 != null) goto L15;
    L16:
        h.a.f3.j0.a(r10, r11);
        return;
    L15:
        if (r12.Q0() == true) goto L16;
        return;
    L17:
        th = move-exception;
        if (r12 != null) goto L20;
    L21:
        h.a.f3.j0.a(r10, r11);
    L22:
        throw th;
    L20:
        if (r12.Q0() == false) goto L22;
    L11:
        r12 = null;
        goto L25
    L23:
        r4.resumeWith(r7);
        return;
    L5:
        kotlin.v.a r14 = kotlin.v.f21457g;
        r7 = r3.e(r0);
        goto L6
    }

    private static final void e(y0<?> r4) {
        h1 r0 = v2.f17573a.b();
        if (r0.o0() == false) goto L5;
        r0.k0(r4);
        return;
    L5:
        r0.m0(true);
        d(r4, r4.b(), true);     // Catch: Throwable -> L10
    L7:
        if (r0.r0() == true) goto L7;
    L13:
        r0.h0(true);
        return;
    L10:
        th = move-exception;
        r4.f(th, null);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0.h0(true);
        throw th;
    }
}
