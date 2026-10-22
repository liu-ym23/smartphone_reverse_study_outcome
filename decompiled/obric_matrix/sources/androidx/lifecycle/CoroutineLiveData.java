package androidx.lifecycle;

import h.a.b1;
import h.a.d1;
import h.a.n0;
import h.a.s2;
import h.a.w;
import h.a.x1;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.g;
import kotlin.k0.h;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BH\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012(\u0010\u001e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J!\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", "T", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/LiveData;", "source", "Lh/a/d1;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/k0/d;)Ljava/lang/Object;", "emitSource", "Lkotlin/f0;", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/k0/d;)Ljava/lang/Object;", "clearSource", "onActive", "()V", "onInactive", "Landroidx/lifecycle/EmittedSource;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "Landroidx/lifecycle/BlockRunner;", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "Lkotlin/k0/g;", "context", "", "timeoutInMs", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/k0/d;", "", "block", "<init>", "(Lkotlin/k0/g;JLkotlin/n0/c/p;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 1, 15})
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveData$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "Lkotlin/f0;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class AnonymousClass1 extends q implements kotlin.n0.c.a<f0> {
        final /* synthetic */ CoroutineLiveData this$0;

        AnonymousClass1(CoroutineLiveData r1) {
            this.this$0 = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CoroutineLiveData.access$setBlockRunner$p(this.this$0, null);
        }
    }

    public CoroutineLiveData(g r8, long r9, p<? super LiveDataScope<T>, ? super d<? super f0>, ? extends Object> r11) {
        o.g(r8, "context");
        o.g(r11, "block");
        w r0 = s2.a((x1) r8.get(x1.f17584d));
        this.blockRunner = new BlockRunner(this, r11, r9, n0.a(b1.c().h0().plus(r8).plus(r0)), new AnonymousClass1(this));
    }

    public /* synthetic */ CoroutineLiveData(g r1, long r2, p r4, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = h.f18399f;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r2 = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    L8:
        this(r1, r2, r4);
    }

    public static final /* synthetic */ BlockRunner access$getBlockRunner$p(CoroutineLiveData r0) {
        return r0.blockRunner;
    }

    public static final /* synthetic */ void access$setBlockRunner$p(CoroutineLiveData r0, BlockRunner r1) {
        r0.blockRunner = r1;
    }

    public final Object clearSource$lifecycle_livedata_ktx_release(d<? super f0> r5) {
        if ((r5 instanceof CoroutineLiveData$clearSource$1) == false) goto L7;
        CoroutineLiveData$clearSource$1 r0 = (CoroutineLiveData$clearSource$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        CoroutineLiveData<T> this = (CoroutineLiveData) r0.L$0;
        kotlin.w.b(r6);
    L19:
        f0 r7 = (f0) r6;
    L20:
        this.emittedSource = null;
        return f0.f18324a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.w.b(r6);
        EmittedSource r8 = this.emittedSource;
        if (r8 == null) goto L20;
        r0.L$0 = this;
        r0.label = 1;
        r6 = r8.disposeNow(r0);
        if (r6 != r2) goto L19;
        return r2;
    L7:
        r0 = new CoroutineLiveData$clearSource$1(this, r5);
        goto L8
    }

    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> r6, d<? super d1> r7) {
        if ((r7 instanceof CoroutineLiveData$emitSource$1) == false) goto L7;
        CoroutineLiveData$emitSource$1 r0 = (CoroutineLiveData$emitSource$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        LiveData r5 = (LiveData) r0.L$1;
        CoroutineLiveData<T> this = (CoroutineLiveData) r0.L$0;
        kotlin.w.b(r8);
    L22:
        EmittedSource r9 = (EmittedSource) r8;
        this.emittedSource = r9;
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (LiveData) r0.L$1;
        this = (CoroutineLiveData) r0.L$0;
        kotlin.w.b(r8);
    L19:
        r0.L$0 = this;
        r0.L$1 = r6;
        r0.label = 2;
        r8 = CoroutineLiveDataKt.addDisposableSource(this, r6, r0);
        if (r8 != r2) goto L22;
        return r2;
    L16:
        kotlin.w.b(r8);
        r0.L$0 = this;
        r0.L$1 = r6;
        r0.label = 1;
        if (clearSource$lifecycle_livedata_ktx_release(r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new CoroutineLiveData$emitSource$1(this, r7);
        goto L8
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        BlockRunner<T> r0 = this.blockRunner;
        if (r0 == null) goto L6;
        r0.maybeRun();
        return;
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        BlockRunner<T> r0 = this.blockRunner;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }
}
