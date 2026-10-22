package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a8\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0003H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003H\u0007\u001a\u0013\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u00020\u001dH\u0080\u0010\u001a(\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006 "}, d2 = {"DEBUG_THREAD_NAME_SEPARATOR", "", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "foldCopies", "originalContext", "appendContext", "isNewCoroutine", "", "withContinuationContext", "T", "continuation", "Lkotlin/coroutines/Continuation;", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withCoroutineContext", "context", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasCopyableElements", "newCoroutineContext", "addedContext", "Lkotlinx/coroutines/CoroutineScope;", "undispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateUndispatchedCompletion", "oldValue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class f0 {

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "result", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.p<kotlin.k0.g, kotlin.k0.g.b, kotlin.k0.g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f17344f = null;

        static {
            f17344f = new a();
        }

        a() {
            super(2);
        }

        public final kotlin.k0.g a(kotlin.k0.g r1, kotlin.k0.g.b r2) {
            if ((r2 instanceof d0) == false) goto L7;
            return r1.plus(((d0) r2).N());
        L7:
            return r1.plus(r2);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.k0.g invoke(kotlin.k0.g r1, kotlin.k0.g.b r2) {
            return a(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "result", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<kotlin.k0.g, kotlin.k0.g.b, kotlin.k0.g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.d.d0<kotlin.k0.g> f17345f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f17346g;

        b(kotlin.n0.d.d0<kotlin.k0.g> r1, boolean r2) {
            this.f17345f = r1;
            this.f17346g = r2;
            super(2);
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [T, kotlin.k0.g] */
        public final kotlin.k0.g a(kotlin.k0.g r4, kotlin.k0.g.b r5) {
            if ((r5 instanceof d0) == false) goto L5;
            kotlin.k0.g.b r0 = this.f17345f.f18431f.get(r5.getKey());
            if (r0 == null) goto L9;
            kotlin.n0.d.d0<kotlin.k0.g> r3 = this.f17345f;
            r3.f18431f = r3.f18431f.minusKey(r5.getKey());
            return r4.plus(((d0) r5).g(r0));
        L9:
            if (this.f17346g == false) goto L11;
            d0 r6 = ((d0) r5).N();
        L13:
            return r4.plus(r6);
        L11:
            r6 = (d0) r5;
            goto L13
        L5:
            return r4.plus(r5);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.k0.g invoke(kotlin.k0.g r1, kotlin.k0.g.b r2) {
            return a(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "result", "it", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(ZLkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.p<Boolean, kotlin.k0.g.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f17347f = null;

        static {
            f17347f = new c();
        }

        c() {
            super(2);
        }

        public final Boolean a(boolean r1, kotlin.k0.g.b r2) {
            if (r1 == false) goto L4;
        L7:
            boolean r0 = true;
        L9:
            return Boolean.valueOf(r0);
        L4:
            if ((r2 instanceof d0) == true) goto L7;
            r0 = false;
            goto L9
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean r1, kotlin.k0.g.b r2) {
            return a(r1.booleanValue(), r2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final kotlin.k0.g a(kotlin.k0.g r3, kotlin.k0.g r4, boolean r5) {
        boolean r0 = c(r3);
        boolean r1 = c(r4);
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        return r3.plus(r4);
    L7:
        kotlin.n0.d.d0 r2 = new kotlin.n0.d.d0();
        r2.f18431f = r4;
        kotlin.k0.h r6 = kotlin.k0.h.f18399f;
        kotlin.k0.g r7 = (kotlin.k0.g) r3.fold(r6, new b(r2, r5));
        if (r1 == false) goto L11;
        r2.f18431f = ((kotlin.k0.g) r2.f18431f).fold(r6, a.f17344f);
    L11:
        return r7.plus((kotlin.k0.g) r2.f18431f);
    }

    public static final String b(kotlin.k0.g r2) {
        if (q0.c() == true) goto L5;
        return null;
    L5:
        k0 r0 = (k0) r2.get(k0.f17532g);
        if (r0 != null) goto L8;
        return null;
    L8:
        l0 r3 = (l0) r2.get(l0.f17535g);
        String r1 = "coroutine";
        if (r3 == null) goto L16;
        String r4 = r3.h0();
        if (r4 == null) goto L16;
        r1 = r4;
    L16:
        return r1 + '#' + r0.h0();
    }

    private static final boolean c(kotlin.k0.g r2) {
        return ((Boolean) r2.fold(Boolean.FALSE, c.f17347f)).booleanValue();
    }

    public static final kotlin.k0.g d(kotlin.k0.g r1, kotlin.k0.g r2) {
        if (c(r2) == true) goto L7;
        return r1.plus(r2);
    L7:
        return a(r1, r2, false);
    }

    public static final kotlin.k0.g e(m0 r2, kotlin.k0.g r3) {
        kotlin.k0.g r4 = a(r2.getCoroutineContext(), r3, true);
        if (q0.c() == false) goto L5;
        kotlin.k0.g r5 = r4.plus(new k0(q0.b().incrementAndGet()));
    L7:
        if (r4 != b1.a()) goto L9;
        return r5;
    L9:
        if (r4.get(kotlin.k0.e.f18396a) == null) goto L11;
        return r5;
    L11:
        return r5.plus(b1.a());
    L5:
        r5 = r4;
        goto L7
    }

    public static final a3<?> f(kotlin.k0.j.a.e r2) {
    L3:
        if ((r2 instanceof x0) == true) goto L4;
        r2 = r2.getCallerFrame();
        if (r2 == null) goto L7;
        if ((r2 instanceof a3) == false) goto L3;
        return (a3) r2;
    L7:
        return null;
    L4:
        return null;
    }

    public static final a3<?> g(kotlin.k0.d<?> r2, kotlin.k0.g r3, Object r4) {
        if ((r2 instanceof kotlin.k0.j.a.e) == true) goto L6;
        return null;
    L6:
        if (r3.get(b3.f17183f) == null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return null;
    L11:
        a3<?> r5 = f((kotlin.k0.j.a.e) r2);
        if (r5 == null) goto L15;
        r5.R0(r3, r4);
    L15:
        return r5;
    L8:
        r0 = false;
        goto L9
    }
}
