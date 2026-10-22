package androidx.lifecycle;

import androidx.annotation.MainThread;
import h.a.b1;
import h.a.h;
import h.a.m0;
import h.a.v0;
import h.a.x1;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B`\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012(\u0010\u001a\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R;\u0010\u001a\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00178\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/BlockRunner;", "T", "", "Lkotlin/f0;", "maybeRun", "()V", "cancel", "", "timeoutInMs", "J", "Landroidx/lifecycle/CoroutineLiveData;", "liveData", "Landroidx/lifecycle/CoroutineLiveData;", "Lkotlin/Function0;", "onDone", "Lkotlin/n0/c/a;", "Lh/a/x1;", "runningJob", "Lh/a/x1;", "cancellationJob", "Lh/a/m0;", "scope", "Lh/a/m0;", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/k0/d;", "block", "Lkotlin/n0/c/p;", "<init>", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/n0/c/p;JLh/a/m0;Lkotlin/n0/c/a;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 1, 15})
public final class BlockRunner<T> {
    private final p<LiveDataScope<T>, d<? super f0>, Object> block;
    private x1 cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final kotlin.n0.c.a<f0> onDone;
    private x1 runningJob;
    private final m0 scope;
    private final long timeoutInMs;

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$cancel$1, reason: invalid class name */
    @f(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {187}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lh/a/m0;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class AnonymousClass1 extends l implements p<m0, d<? super f0>, Object> {
        Object L$0;
        int label;
        private m0 p$;
        final /* synthetic */ BlockRunner this$0;

        AnonymousClass1(BlockRunner r1, d r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r2, d<?> r3) {
            o.g(r3, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r3);
            r0.p$ = (m0) r2;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public final Object invoke(m0 r1, d<? super f0> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            m0 r2 = (m0) this.L$0;
            w.b(r6);
        L12:
            if (BlockRunner.access$getLiveData$p(this.this$0).hasActiveObservers() == true) goto L18;
            x1 r7 = BlockRunner.access$getRunningJob$p(this.this$0);
            if (r7 == null) goto L16;
            x1.a.a(r7, null, 1, null);
        L16:
            BlockRunner.access$setRunningJob$p(this.this$0, null);
        L18:
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r6);
            m0 r8 = this.p$;
            long r3 = BlockRunner.access$getTimeoutInMs$p(this.this$0);
            this.L$0 = r8;
            this.label = 1;
            if (v0.a(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$maybeRun$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {176}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lh/a/m0;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class C06251 extends l implements p<m0, d<? super f0>, Object> {
        Object L$0;
        Object L$1;
        int label;
        private m0 p$;
        final /* synthetic */ BlockRunner this$0;

        C06251(BlockRunner r1, d r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r2, d<?> r3) {
            o.g(r3, "completion");
            C06251 r0 = new C06251(this.this$0, r3);
            r0.p$ = (m0) r2;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public final Object invoke(m0 r1, d<? super f0> r2) {
            return ((C06251) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            LiveDataScopeImpl r2 = (LiveDataScopeImpl) this.L$1;
            m0 r3 = (m0) this.L$0;
            w.b(r6);
        L11:
            BlockRunner.access$getOnDone$p(this.this$0).invoke();
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r6);
            m0 r7 = this.p$;
            LiveDataScopeImpl r4 = new LiveDataScopeImpl(BlockRunner.access$getLiveData$p(this.this$0), r7.getCoroutineContext());
            p r5 = BlockRunner.access$getBlock$p(this.this$0);
            this.L$0 = r7;
            this.L$1 = r4;
            this.label = 1;
            if (r5.invoke(r4, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(CoroutineLiveData<T> r2, p<? super LiveDataScope<T>, ? super d<? super f0>, ? extends Object> r3, long r4, m0 r6, kotlin.n0.c.a<f0> r7) {
        o.g(r2, "liveData");
        o.g(r3, "block");
        o.g(r6, "scope");
        o.g(r7, "onDone");
        this.liveData = r2;
        this.block = r3;
        this.timeoutInMs = r4;
        this.scope = r6;
        this.onDone = r7;
    }

    public static final /* synthetic */ p access$getBlock$p(BlockRunner r0) {
        return r0.block;
    }

    public static final /* synthetic */ CoroutineLiveData access$getLiveData$p(BlockRunner r0) {
        return r0.liveData;
    }

    public static final /* synthetic */ kotlin.n0.c.a access$getOnDone$p(BlockRunner r0) {
        return r0.onDone;
    }

    public static final /* synthetic */ x1 access$getRunningJob$p(BlockRunner r0) {
        return r0.runningJob;
    }

    public static final /* synthetic */ long access$getTimeoutInMs$p(BlockRunner r2) {
        return r2.timeoutInMs;
    }

    public static final /* synthetic */ void access$setRunningJob$p(BlockRunner r0, x1 r1) {
        r0.runningJob = r1;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) goto L7;
        this.cancellationJob = h.b(this.scope, b1.c().h0(), null, new AnonymousClass1(this, null), 2, null);
        return;
    L7:
        throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
    }

    @MainThread
    public final void maybeRun() {
        x1 r0 = this.cancellationJob;
        if (r0 == null) goto L5;
        x1.a.a(r0, null, 1, null);
    L5:
        this.cancellationJob = null;
        if (this.runningJob == null) goto L8;
        return;
    L8:
        this.runningJob = h.b(this.scope, null, null, new C06251(this, null), 3, null);
    }
}
