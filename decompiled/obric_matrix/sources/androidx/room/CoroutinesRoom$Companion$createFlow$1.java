package androidx.room;

import h.a.d3.h;
import h.a.d3.i;
import h.a.g0;
import h.a.m0;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.g;
import kotlin.k0.i.b;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", l = {75}, m = "invokeSuspend")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Lh/a/e3/f;", "kotlin.jvm.PlatformType", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
final class CoroutinesRoom$Companion$createFlow$1<R> extends l implements p<h.a.e3.f<? super R>, d<? super f0>, Object> {
    final /* synthetic */ Callable $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private h.a.e3.f p$;

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    @f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", l = {80, 82}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lh/a/m0;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class AnonymousClass1 extends l implements p<m0, d<? super f0>, Object> {
        final /* synthetic */ g $flowContext;
        final /* synthetic */ CoroutinesRoom$Companion$createFlow$1$observer$1 $observer;
        final /* synthetic */ h.a.d3.f $observerChannel;
        final /* synthetic */ h.a.e3.f $this_flow;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        private m0 p$;
        final /* synthetic */ CoroutinesRoom$Companion$createFlow$1 this$0;

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        @f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", l = {82}, m = "invokeSuspend")
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lh/a/m0;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
        static final class C00241 extends l implements p<m0, d<? super f0>, Object> {
            final /* synthetic */ Object $result;
            Object L$0;
            int label;
            private m0 p$;
            final /* synthetic */ AnonymousClass1 this$0;

            C00241(AnonymousClass1 r1, Object r2, d r3) {
                this.this$0 = r1;
                this.$result = r2;
                super(2, r3);
            }

            @Override // kotlin.k0.j.a.a
            public final d<f0> create(Object r3, d<?> r4) {
                o.g(r4, "completion");
                C00241 r0 = new C00241(this.this$0, this.$result, r4);
                r0.p$ = (m0) r3;
                return r0;
            }

            @Override // kotlin.n0.c.p
            public final Object invoke(m0 r1, d<? super f0> r2) {
                return ((C00241) create(r1, r2)).invokeSuspend(f0.f18324a);
            }

            @Override // kotlin.k0.j.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = b.c();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                m0 r4 = (m0) this.L$0;
                w.b(r5);
            L12:
                return f0.f18324a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                w.b(r5);
                m0 r6 = this.p$;
                h.a.e3.f r2 = this.this$0.$this_flow;
                Object r3 = this.$result;
                this.L$0 = r6;
                this.label = 1;
                if (r2.emit(r3, this) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass1(CoroutinesRoom$Companion$createFlow$1 r1, h.a.e3.f r2, CoroutinesRoom$Companion$createFlow$1$observer$1 r3, h.a.d3.f r4, g r5, d r6) {
            this.this$0 = r1;
            this.$this_flow = r2;
            this.$observer = r3;
            this.$observerChannel = r4;
            this.$flowContext = r5;
            super(2, r6);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r9, d<?> r10) {
            o.g(r10, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$this_flow, this.$observer, this.$observerChannel, this.$flowContext, r10);
            r0.p$ = (m0) r9;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public final Object invoke(m0 r1, d<? super f0> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0087 -> B:8:0x001d). Please report as a decompilation issue!!! */
        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = b.c();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L11;
            if (r1 != 2) goto L10;
            h r2 = (h) this.L$2;
            f0 r4 = (f0) this.L$1;
            m0 r5 = (m0) this.L$0;
            w.b(r11);     // Catch: Throwable -> L27
        L8:
            m0 r12 = r5;
        L16:
            this.L$0 = r12;     // Catch: Throwable -> L27
            this.L$1 = r2;     // Catch: Throwable -> L27
            this.label = 1;     // Catch: Throwable -> L27
            Object r6 = r2.a(this);     // Catch: Throwable -> L27
            if (r6 != r0) goto L19;
            return r0;
        L19:
            r5 = r12;
            r11 = r6;
        L21:
            if (((Boolean) r11).booleanValue() == false) goto L25;
            f0 r13 = (f0) r2.next();     // Catch: Throwable -> L27
            Object r7 = this.this$0.$callable.call();     // Catch: Throwable -> L27
            g r8 = this.$flowContext;     // Catch: Throwable -> L27
            C00241 r9 = new C00241(this, r7, null);     // Catch: Throwable -> L27
            this.L$0 = r5;     // Catch: Throwable -> L27
            this.L$1 = r13;     // Catch: Throwable -> L27
            this.L$2 = r2;     // Catch: Throwable -> L27
            this.L$3 = r7;     // Catch: Throwable -> L27
            this.label = 2;     // Catch: Throwable -> L27
            if (h.a.h.e(r8, r9, this) != r0) goto L8;
            return r0;
        L25:
            this.this$0.$db.getInvalidationTracker().removeObserver(this.$observer);
            return f0.f18324a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            r2 = (h) this.L$1;
            r5 = (m0) this.L$0;
            w.b(r11);     // Catch: Throwable -> L27
            goto L21
        L14:
            w.b(r11);
            r12 = this.p$;
            this.this$0.$db.getInvalidationTracker().addObserver(this.$observer);
            r2 = this.$observerChannel.iterator();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            this.this$0.$db.getInvalidationTracker().removeObserver(this.$observer);
            throw th;
        }
    }

    CoroutinesRoom$Companion$createFlow$1(String[] r1, boolean r2, RoomDatabase r3, Callable r4, d r5) {
        this.$tableNames = r1;
        this.$inTransaction = r2;
        this.$db = r3;
        this.$callable = r4;
        super(2, r5);
    }

    @Override // kotlin.k0.j.a.a
    public final d<f0> create(Object r8, d<?> r9) {
        o.g(r9, "completion");
        CoroutinesRoom$Companion$createFlow$1 r0 = new CoroutinesRoom$Companion$createFlow$1(this.$tableNames, this.$inTransaction, this.$db, this.$callable, r9);
        r0.p$ = (h.a.e3.f) r8;
        return r0;
    }

    @Override // kotlin.n0.c.p
    public final Object invoke(Object r1, d<? super f0> r2) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(r1, r2)).invokeSuspend(f0.f18324a);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1, java.lang.Object] */
    @Override // kotlin.k0.j.a.a
    public final Object invokeSuspend(Object r15) {
        Object r0 = b.c();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        g0 r2 = (g0) this.L$4;
        g r3 = (g) this.L$3;
        CoroutinesRoom$Companion$createFlow$1$observer$1 r4 = (CoroutinesRoom$Companion$createFlow$1$observer$1) this.L$2;
        h.a.d3.f r5 = (h.a.d3.f) this.L$1;
        h.a.e3.f r14 = (h.a.e3.f) this.L$0;
        w.b(r15);
    L16:
        return f0.f18324a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        w.b(r15);
        h.a.e3.f r16 = this.p$;
        final h.a.d3.f r6 = i.a(-1);
        final String[] r7 = this.$tableNames;
        ?? r10 = new CoroutinesRoom$Companion$createFlow$1$observer$1(this, r6, r7);
        r6.offer(f0.f18324a);
        g r11 = getContext();
        if (this.$inTransaction == false) goto L11;
        g0 r8 = CoroutinesRoomKt.getTransactionDispatcher(this.$db);
    L12:
        g0 r12 = r8;
        AnonymousClass1 r13 = new AnonymousClass1(this, r16, r10, r6, r11, null);
        this.L$0 = r16;
        this.L$1 = r6;
        this.L$2 = r10;
        this.L$3 = r11;
        this.L$4 = r12;
        this.label = 1;
        if (h.a.h.e(r12, r13, this) != r0) goto L16;
        return r0;
    L11:
        r8 = CoroutinesRoomKt.getQueryDispatcher(this.$db);
        goto L12
    }
}
