package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import h.a.b1;
import h.a.d3.h;
import h.a.d3.i;
import h.a.e3.e;
import h.a.e3.g;
import h.a.i2;
import h.a.m0;
import h.a.q1;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {"T", "Lh/a/e3/e;", "Lkotlin/k0/g;", "context", "", "timeoutInMs", "Landroidx/lifecycle/LiveData;", "asLiveData", "(Lh/a/e3/e;Lkotlin/k0/g;J)Landroidx/lifecycle/LiveData;", "asFlow", "(Landroidx/lifecycle/LiveData;)Lh/a/e3/e;", "Ljava/time/Duration;", LocationMonitorConst.TIMEOUT, "(Lh/a/e3/e;Lkotlin/k0/g;Ljava/time/Duration;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class FlowLiveDataConversions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    @f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {91, 95, 96}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lh/a/e3/f;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class AnonymousClass1<T> extends l implements p<h.a.e3.f<? super T>, d<? super f0>, Object> {
        final /* synthetic */ LiveData $this_asFlow;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        private h.a.e3.f p$;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        @f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lh/a/m0;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
        static final class C00191 extends l implements p<m0, d<? super f0>, Object> {
            final /* synthetic */ Observer $observer;
            int label;
            private m0 p$;
            final /* synthetic */ AnonymousClass1 this$0;

            C00191(AnonymousClass1 r1, Observer r2, d r3) {
                this.this$0 = r1;
                this.$observer = r2;
                super(2, r3);
            }

            @Override // kotlin.k0.j.a.a
            public final d<f0> create(Object r3, d<?> r4) {
                o.g(r4, "completion");
                C00191 r0 = new C00191(this.this$0, this.$observer, r4);
                r0.p$ = (m0) r3;
                return r0;
            }

            @Override // kotlin.n0.c.p
            public final Object invoke(m0 r1, d<? super f0> r2) {
                return ((C00191) create(r1, r2)).invokeSuspend(f0.f18324a);
            }

            @Override // kotlin.k0.j.a.a
            public final Object invokeSuspend(Object r2) {
                kotlin.k0.i.b.c();
                if (this.label != 0) goto L7;
                w.b(r2);
                this.this$0.$this_asFlow.observeForever(this.$observer);
                return f0.f18324a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        @f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lh/a/m0;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
        static final class AnonymousClass2 extends l implements p<m0, d<? super f0>, Object> {
            final /* synthetic */ Observer $observer;
            int label;
            private m0 p$;
            final /* synthetic */ AnonymousClass1 this$0;

            AnonymousClass2(AnonymousClass1 r1, Observer r2, d r3) {
                this.this$0 = r1;
                this.$observer = r2;
                super(2, r3);
            }

            @Override // kotlin.k0.j.a.a
            public final d<f0> create(Object r3, d<?> r4) {
                o.g(r4, "completion");
                AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$observer, r4);
                r0.p$ = (m0) r3;
                return r0;
            }

            @Override // kotlin.n0.c.p
            public final Object invoke(m0 r1, d<? super f0> r2) {
                return ((AnonymousClass2) create(r1, r2)).invokeSuspend(f0.f18324a);
            }

            @Override // kotlin.k0.j.a.a
            public final Object invokeSuspend(Object r2) {
                kotlin.k0.i.b.c();
                if (this.label != 0) goto L7;
                w.b(r2);
                this.this$0.$this_asFlow.removeObserver(this.$observer);
                return f0.f18324a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(LiveData r1, d r2) {
            this.$this_asFlow = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r2, d<?> r3) {
            o.g(r3, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.$this_asFlow, r3);
            r0.p$ = (h.a.e3.f) r2;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public final Object invoke(Object r1, d<? super f0> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v18 */
        /* JADX WARN: Type inference failed for: r4v19 */
        /* JADX WARN: Type inference failed for: r4v2, types: [androidx.lifecycle.Observer] */
        /* JADX WARN: Type inference failed for: r4v20 */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7, types: [androidx.lifecycle.Observer, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r7v12 */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v3, types: [h.a.e3.f, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00bc -> B:9:0x0025). Please report as a decompilation issue!!! */
        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.label;
            ?? r4 = 1;
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L17;
            if (r1 == 2) goto L12;
            if (r1 != 3) goto L11;
            h r2 = (h) this.L$4;
            Observer r5 = (Observer) this.L$2;
            h.a.d3.f r6 = (h.a.d3.f) this.L$1;
            h.a.e3.f r7 = (h.a.e3.f) this.L$0;
            w.b(r14);     // Catch: Throwable -> L15
            ?? r8 = r5;
            ?? r9 = r7;
        L9:
            h r15 = r2;
            ?? r3 = r8;
            h.a.d3.f r10 = r6;
            ?? r11 = r9;
        L23:
            this.L$0 = r11;     // Catch: Throwable -> L34
            this.L$1 = r10;     // Catch: Throwable -> L34
            this.L$2 = r3;     // Catch: Throwable -> L34
            this.L$3 = r15;     // Catch: Throwable -> L34
            this.label = 2;     // Catch: Throwable -> L34
            Object r12 = r15.a(this);     // Catch: Throwable -> L34
            if (r12 != r0) goto L26;
            return r0;
        L26:
            ?? r13 = r3;
            r2 = r15;
            r14 = r12;
            ?? r16 = r11;
            r6 = r10;
            r4 = r13;
        L27:
            if (((Boolean) r14).booleanValue() == false) goto L32;
            Object r17 = r2.next();     // Catch: Throwable -> L15
            this.L$0 = r16;     // Catch: Throwable -> L15
            this.L$1 = r6;     // Catch: Throwable -> L15
            this.L$2 = r4;     // Catch: Throwable -> L15
            this.L$3 = r17;     // Catch: Throwable -> L15
            this.L$4 = r2;     // Catch: Throwable -> L15
            this.label = 3;     // Catch: Throwable -> L15
            Object r18 = r16.emit(r17, this);     // Catch: Throwable -> L15
            r8 = r4;
            r9 = r16;
            if (r18 != r0) goto L9;
            return r0;
        L32:
            h.a.h.b(q1.f17560f, b1.c().h0(), null, new AnonymousClass2(this, r4, null), 2, null);
            return f0.f18324a;
        L34:
            th = th;
            r4 = r3;
        L36:
            h.a.h.b(q1.f17560f, b1.c().h0(), null, new AnonymousClass2(this, r4, null), 2, null);
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r2 = (h) this.L$3;
            Observer r19 = (Observer) this.L$2;
            r6 = (h.a.d3.f) this.L$1;
            h.a.e3.f r20 = (h.a.e3.f) this.L$0;
            w.b(r14);     // Catch: Throwable -> L15
            r4 = r19;
            r16 = r20;
            goto L27
        L17:
            boolean r21 = (Observer<T>) ((Observer) this.L$2);
            r10 = (h.a.d3.f) this.L$1;
            h.a.e3.f r22 = (h.a.e3.f) this.L$0;
            w.b(r14);
            r3 = r21;
            h.a.e3.f r23 = r22;
        L40:
            r15 = r10.iterator();     // Catch: Throwable -> L34
            r3 = r3;
            r11 = r23;
            goto L23
        L18:
            w.b(r14);
            h.a.e3.f r24 = this.p$;
            final h.a.d3.f r110 = i.a(-1);
            Observer<T> r25 = new FlowLiveDataConversions$asFlow$1$observer$1(r110);
            i2 r26 = b1.c().h0();
            C00191 r27 = new C00191(this, r25, null);
            this.L$0 = r24;
            this.L$1 = r110;
            this.L$2 = r25;
            this.label = 1;
            if (h.a.h.e(r26, r27, this) != r0) goto L21;
            return r0;
        L21:
            r10 = r110;
            r3 = r25;
            r23 = r24;
        L15:
            th = th;
            goto L36
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {139}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class C06261<T> extends l implements p<LiveDataScope<T>, d<? super f0>, Object> {
        final /* synthetic */ e $this_asLiveData;
        Object L$0;
        Object L$1;
        int label;
        private LiveDataScope p$;

        C06261(e r1, d r2) {
            this.$this_asLiveData = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r2, d<?> r3) {
            o.g(r3, "completion");
            C06261 r0 = new C06261(this.$this_asLiveData, r3);
            r0.p$ = (LiveDataScope) r2;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public final Object invoke(Object r1, d<? super f0> r2) {
            return ((C06261) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            e r2 = (e) this.L$1;
            LiveDataScope r4 = (LiveDataScope) this.L$0;
            w.b(r5);
        L12:
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r5);
            LiveDataScope r6 = this.p$;
            e r3 = this.$this_asLiveData;
            FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1 r7 = new FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1(r6);
            this.L$0 = r6;
            this.L$1 = r3;
            this.label = 1;
            if (r3.collect(r7, this) != r0) goto L12;
            return r0;
        }
    }

    public static final <T> e<T> asFlow(LiveData<T> r2) {
        o.g(r2, "$this$asFlow");
        return g.g(new AnonymousClass1(r2, null));
    }

    public static final <T> LiveData<T> asLiveData(e<? extends T> r6) {
        return asLiveData$default(r6, null, 0, 3, null);
    }

    public static final <T> LiveData<T> asLiveData(e<? extends T> r6, kotlin.k0.g r7) {
        return asLiveData$default(r6, r7, 0, 2, null);
    }

    public static final <T> LiveData<T> asLiveData(e<? extends T> r2, kotlin.k0.g r3, long r4) {
        o.g(r2, "$this$asLiveData");
        o.g(r3, "context");
        return CoroutineLiveDataKt.liveData(r3, r4, new C06261(r2, null));
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(e<? extends T> r2, kotlin.k0.g r3, Duration r4) {
        o.g(r2, "$this$asLiveData");
        o.g(r3, "context");
        o.g(r4, LocationMonitorConst.TIMEOUT);
        return asLiveData(r2, r3, r4.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(e r0, kotlin.k0.g r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = kotlin.k0.h.f18399f;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    L9:
        return asLiveData(r0, r1, r2);
    }

    public static /* synthetic */ LiveData asLiveData$default(e r0, kotlin.k0.g r1, Duration r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = kotlin.k0.h.f18399f;
    L6:
        return asLiveData(r0, r1, r2);
    }
}
