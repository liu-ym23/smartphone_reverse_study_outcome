package androidx.lifecycle;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import h.a.b1;
import h.a.d1;
import h.a.h;
import h.a.m0;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.g;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00018\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Landroidx/lifecycle/LiveDataScopeImpl;", "T", "Landroidx/lifecycle/LiveDataScope;", "Landroidx/lifecycle/LiveData;", "source", "Lh/a/d1;", "emitSource", "(Landroidx/lifecycle/LiveData;Lkotlin/k0/d;)Ljava/lang/Object;", "value", "Lkotlin/f0;", "emit", "(Ljava/lang/Object;Lkotlin/k0/d;)Ljava/lang/Object;", "getLatestValue", "()Ljava/lang/Object;", "latestValue", "Landroidx/lifecycle/CoroutineLiveData;", TypedValues.AttributesType.S_TARGET, "Landroidx/lifecycle/CoroutineLiveData;", "getTarget$lifecycle_livedata_ktx_release", "()Landroidx/lifecycle/CoroutineLiveData;", "setTarget$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/CoroutineLiveData;)V", "Lkotlin/k0/g;", "coroutineContext", "Lkotlin/k0/g;", "context", "<init>", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/k0/g;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 1, 15})
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final g coroutineContext;
    private CoroutineLiveData<T> target;

    /* JADX INFO: renamed from: androidx.lifecycle.LiveDataScopeImpl$emit$2, reason: invalid class name */
    @f(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", l = {98}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lh/a/m0;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class AnonymousClass2 extends l implements p<m0, d<? super f0>, Object> {
        final /* synthetic */ Object $value;
        Object L$0;
        int label;
        private m0 p$;
        final /* synthetic */ LiveDataScopeImpl this$0;

        AnonymousClass2(LiveDataScopeImpl r1, Object r2, d r3) {
            this.this$0 = r1;
            this.$value = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r3, d<?> r4) {
            o.g(r4, "completion");
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$value, r4);
            r0.p$ = (m0) r3;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public final Object invoke(m0 r1, d<? super f0> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            m0 r2 = (m0) this.L$0;
            w.b(r4);
        L11:
            this.this$0.getTarget$lifecycle_livedata_ktx_release().setValue(this.$value);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r4);
            m0 r5 = this.p$;
            CoroutineLiveData<T> r3 = this.this$0.getTarget$lifecycle_livedata_ktx_release();
            this.L$0 = r5;
            this.label = 1;
            if (r3.clearSource$lifecycle_livedata_ktx_release(this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LiveDataScopeImpl$emitSource$2, reason: invalid class name and case insensitive filesystem */
    @f(c = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2", f = "CoroutineLiveData.kt", l = {94}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lh/a/m0;", "Lh/a/d1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class C06292 extends l implements p<m0, d<? super d1>, Object> {
        final /* synthetic */ LiveData $source;
        Object L$0;
        int label;
        private m0 p$;
        final /* synthetic */ LiveDataScopeImpl this$0;

        C06292(LiveDataScopeImpl r1, LiveData r2, d r3) {
            this.this$0 = r1;
            this.$source = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r3, d<?> r4) {
            o.g(r4, "completion");
            C06292 r0 = new C06292(this.this$0, this.$source, r4);
            r0.p$ = (m0) r3;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public final Object invoke(m0 r1, d<? super d1> r2) {
            return ((C06292) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            m0 r4 = (m0) this.L$0;
            w.b(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r5);
            m0 r6 = this.p$;
            CoroutineLiveData<T> r2 = this.this$0.getTarget$lifecycle_livedata_ktx_release();
            LiveData<T> r3 = this.$source;
            this.L$0 = r6;
            this.label = 1;
            r5 = r2.emitSource$lifecycle_livedata_ktx_release(r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public LiveDataScopeImpl(CoroutineLiveData<T> r2, g r3) {
        o.g(r2, TypedValues.AttributesType.S_TARGET);
        o.g(r3, "context");
        this.target = r2;
        this.coroutineContext = r3.plus(b1.c().h0());
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emit(T r4, d<? super f0> r5) {
        return h.e(this.coroutineContext, new AnonymousClass2(this, r4, null), r5);
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emitSource(LiveData<T> r4, d<? super d1> r5) {
        return h.e(this.coroutineContext, new C06292(this, r4, null), r5);
    }

    @Override // androidx.lifecycle.LiveDataScope
    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_ktx_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_ktx_release(CoroutineLiveData<T> r2) {
        o.g(r2, "<set-?>");
        this.target = r2;
    }
}
