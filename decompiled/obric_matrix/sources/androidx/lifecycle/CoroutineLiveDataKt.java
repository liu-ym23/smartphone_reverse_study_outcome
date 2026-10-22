package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import h.a.b1;
import h.a.h;
import h.a.m0;
import java.time.Duration;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\\\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2*\b\u0001\u0010\u0010\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\\\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132*\b\u0001\u0010\u0010\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017*V\b\u0000\u0010\u0018\u001a\u0004\b\u0000\u0010\u0000\"$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b2$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"T", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/LiveData;", "source", "Landroidx/lifecycle/EmittedSource;", "addDisposableSource", "(Landroidx/lifecycle/MediatorLiveData;Landroidx/lifecycle/LiveData;Lkotlin/k0/d;)Ljava/lang/Object;", "Lkotlin/k0/g;", "context", "", "timeoutInMs", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/k0/d;", "Lkotlin/f0;", "", "block", "liveData", "(Lkotlin/k0/g;JLkotlin/n0/c/p;)Landroidx/lifecycle/LiveData;", "Ljava/time/Duration;", LocationMonitorConst.TIMEOUT, "(Lkotlin/k0/g;Ljava/time/Duration;Lkotlin/n0/c/p;)Landroidx/lifecycle/LiveData;", "DEFAULT_TIMEOUT", "J", "Block", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2, reason: invalid class name */
    @f(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lh/a/m0;", "Landroidx/lifecycle/EmittedSource;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class AnonymousClass2 extends l implements p<m0, d<? super EmittedSource>, Object> {
        final /* synthetic */ LiveData $source;
        final /* synthetic */ MediatorLiveData $this_addDisposableSource;
        int label;
        private m0 p$;

        AnonymousClass2(MediatorLiveData r1, LiveData r2, d r3) {
            this.$this_addDisposableSource = r1;
            this.$source = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r3, d<?> r4) {
            o.g(r4, "completion");
            AnonymousClass2 r0 = new AnonymousClass2(this.$this_addDisposableSource, this.$source, r4);
            r0.p$ = (m0) r3;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public final Object invoke(m0 r1, d<? super EmittedSource> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r3) {
            kotlin.k0.i.b.c();
            if (this.label != 0) goto L7;
            w.b(r3);
            this.$this_addDisposableSource.addSource(this.$source, new AnonymousClass1(this));
            return new EmittedSource(this.$source, this.$this_addDisposableSource);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final <T> Object addDisposableSource(MediatorLiveData<T> r3, LiveData<T> r4, d<? super EmittedSource> r5) {
        return h.e(b1.c().h0(), new AnonymousClass2(r3, r4, null), r5);
    }

    public static final <T> LiveData<T> liveData(g r1, long r2, p<? super LiveDataScope<T>, ? super d<? super f0>, ? extends Object> r4) {
        o.g(r1, "context");
        o.g(r4, "block");
        return new CoroutineLiveData(r1, r2, r4);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(g r3, Duration r4, p<? super LiveDataScope<T>, ? super d<? super f0>, ? extends Object> r5) {
        o.g(r3, "context");
        o.g(r4, LocationMonitorConst.TIMEOUT);
        o.g(r5, "block");
        return new CoroutineLiveData(r3, r4.toMillis(), r5);
    }

    public static /* synthetic */ LiveData liveData$default(g r0, long r1, p r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r0 = kotlin.k0.h.f18399f;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r1 = DEFAULT_TIMEOUT;
    L9:
        return liveData(r0, r1, r3);
    }

    public static /* synthetic */ LiveData liveData$default(g r0, Duration r1, p r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0 = kotlin.k0.h.f18399f;
    L6:
        return liveData(r0, r1, r2);
    }
}
