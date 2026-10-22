package androidx.lifecycle;

import androidx.annotation.MainThread;
import h.a.b1;
import h.a.d1;
import h.a.h;
import h.a.m0;
import h.a.n0;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/EmittedSource;", "Lh/a/d1;", "Lkotlin/f0;", "removeSource", "()V", "disposeNow", "(Lkotlin/k0/d;)Ljava/lang/Object;", "dispose", "", "disposed", "Z", "Landroidx/lifecycle/MediatorLiveData;", "mediator", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/LiveData;", "source", "Landroidx/lifecycle/LiveData;", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/MediatorLiveData;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 1, 15})
public final class EmittedSource implements d1 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$dispose$1, reason: invalid class name */
    @f(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lh/a/m0;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class AnonymousClass1 extends l implements p<m0, d<? super f0>, Object> {
        int label;
        private m0 p$;
        final /* synthetic */ EmittedSource this$0;

        AnonymousClass1(EmittedSource r1, d r2) {
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
        public final Object invokeSuspend(Object r2) {
            kotlin.k0.i.b.c();
            if (this.label != 0) goto L7;
            w.b(r2);
            EmittedSource.access$removeSource(this.this$0);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$disposeNow$2, reason: invalid class name */
    @f(c = "androidx.lifecycle.EmittedSource$disposeNow$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lh/a/m0;", "Lkotlin/f0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class AnonymousClass2 extends l implements p<m0, d<? super f0>, Object> {
        int label;
        private m0 p$;
        final /* synthetic */ EmittedSource this$0;

        AnonymousClass2(EmittedSource r1, d r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r2, d<?> r3) {
            o.g(r3, "completion");
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r3);
            r0.p$ = (m0) r2;
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
            EmittedSource.access$removeSource(this.this$0);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public EmittedSource(LiveData<?> r2, MediatorLiveData<?> r3) {
        o.g(r2, "source");
        o.g(r3, "mediator");
        this.source = r2;
        this.mediator = r3;
    }

    public static final /* synthetic */ void access$removeSource(EmittedSource r0) {
        r0.removeSource();
    }

    @MainThread
    private final void removeSource() {
        if (this.disposed == true) goto L6;
        this.mediator.removeSource(this.source);
        this.disposed = true;
        return;
    }

    @Override // h.a.d1
    public void dispose() {
        h.b(n0.a(b1.c().h0()), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final Object disposeNow(d<? super f0> r4) {
        return h.e(b1.c().h0(), new AnonymousClass2(this, null), r4);
    }
}
