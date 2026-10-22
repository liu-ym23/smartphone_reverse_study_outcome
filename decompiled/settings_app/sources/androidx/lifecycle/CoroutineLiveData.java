package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0013\u001a\u00020\u000bH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0014R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "clearSource", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActive", "onInactive", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    public static final /* synthetic */ void access$setBlockRunner$p(CoroutineLiveData r0, BlockRunner r1) {
        r0.blockRunner = r1;
    }

    public /* synthetic */ CoroutineLiveData(EmptyCoroutineContext r1, long r2, Function2 r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r2 = 5000;
    L8:
        this(r1, r2, r4);
    }

    public CoroutineLiveData(CoroutineContext r8, long r9, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "block");
        CompletableJob r0 = SupervisorKt.SupervisorJob((Job) r8.get(Job.Key));
        this.blockRunner = new BlockRunner(this, r11, r9, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(r8).plus(r0)), new AnonymousClass1(this));
    }

    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> r6, Continuation<? super DisposableHandle> r7) {
        if ((r7 instanceof CoroutineLiveData$emitSource$1) == false) goto L7;
        CoroutineLiveData$emitSource$1 r0 = (CoroutineLiveData$emitSource$1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        CoroutineLiveData<T> this = (CoroutineLiveData) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L22:
        EmittedSource r9 = (EmittedSource) r8;
        this.emittedSource = r9;
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (LiveData) r0.L$1;
        this = (CoroutineLiveData) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        r0.L$0 = this;
        r0.L$1 = null;
        r0.label = 2;
        r8 = CoroutineLiveDataKt.addDisposableSource(this, r6, r0);
        if (r8 != r1) goto L22;
        return r1;
    L16:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = this;
        r0.L$1 = r6;
        r0.label = 1;
        if (clearSource$lifecycle_livedata_ktx_release(r0) != r1) goto L19;
        return r1;
    L7:
        r0 = new CoroutineLiveData$emitSource$1(this, r7);
        goto L8
    }

    public final Object clearSource$lifecycle_livedata_ktx_release(Continuation<? super Unit> r5) {
        if ((r5 instanceof CoroutineLiveData$clearSource$1) == false) goto L7;
        CoroutineLiveData$clearSource$1 r0 = (CoroutineLiveData$clearSource$1) r5;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        CoroutineLiveData<T> this = (CoroutineLiveData) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L19:
        this.emittedSource = null;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        EmittedSource r7 = this.emittedSource;
        if (r7 == null) goto L19;
        r0.L$0 = this;
        r0.label = 1;
        if (r7.disposeNow(r0) != r1) goto L19;
        return r1;
    L7:
        r0 = new CoroutineLiveData$clearSource$1(this, r5);
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
