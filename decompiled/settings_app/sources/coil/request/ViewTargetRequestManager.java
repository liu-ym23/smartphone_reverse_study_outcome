package coil.request;

import android.view.View;
import coil.util.Utils;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ViewTargetRequestManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0017J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0017J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcoil/request/ViewTargetRequestManager;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "currentDisposable", "Lcoil/request/ViewTargetDisposable;", "currentRequest", "Lcoil/request/ViewTargetRequestDelegate;", "isRestart", "", "pendingClear", "Lkotlinx/coroutines/Job;", "dispose", "", "getDisposable", "job", "Lkotlinx/coroutines/Deferred;", "Lcoil/request/ImageResult;", "getResult", "isDisposed", "disposable", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "setRequest", Ext.KEY_REQUEST, "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewTargetRequestManager implements View.OnAttachStateChangeListener {
    private ViewTargetDisposable currentDisposable;
    private ViewTargetRequestDelegate currentRequest;
    private boolean isRestart;
    private Job pendingClear;
    private final View view;

    /* JADX INFO: renamed from: coil.request.ViewTargetRequestManager$dispose$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewTargetRequestManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.request.ViewTargetRequestManager$dispose$1", f = "ViewTargetRequestManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ViewTargetRequestManager this$0;

        AnonymousClass1(ViewTargetRequestManager r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.this$0.setRequest(null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ViewTargetRequestManager(View r1) {
        this.view = r1;
    }

    public final synchronized boolean isDisposed(ViewTargetDisposable r2) {
        monitor-enter(this);
        if (r2 == this.currentDisposable) goto L6;
        boolean r3 = true;
    L7:
        monitor-exit(this);
        return r3;
    L6:
        r3 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized ViewTargetDisposable getDisposable(Deferred<? extends ImageResult> r4) {
        monitor-enter(this);
        ViewTargetDisposable r0 = this.currentDisposable;     // Catch: Throwable -> L18
        if (r0 != null) goto L6;
    L12:
        Job r1 = this.pendingClear;     // Catch: Throwable -> L18
        if (r1 == null) goto L15;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);     // Catch: Throwable -> L18
    L15:
        this.pendingClear = null;     // Catch: Throwable -> L18
        ViewTargetDisposable r2 = new ViewTargetDisposable(this.view, r4);     // Catch: Throwable -> L18
        this.currentDisposable = r2;     // Catch: Throwable -> L18
        monitor-exit(this);
        return r2;
    L6:
        if (Utils.isMainThread() == false) goto L12;
        if (this.isRestart == false) goto L12;
        this.isRestart = false;     // Catch: Throwable -> L18
        r0.setJob(r4);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r0;
    L18:
        th = move-exception;
        throw th;
    }

    public final synchronized void dispose() {
        monitor-enter(this);
        Job r0 = this.pendingClear;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L9
    L6:
        this.pendingClear = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, null), 2, null);     // Catch: Throwable -> L9
        this.currentDisposable = null;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized ImageResult getResult() {
        monitor-enter(this);
        ViewTargetDisposable r0 = this.currentDisposable;     // Catch: Throwable -> L12
        if (r0 == null) goto L9;
        Deferred<ImageResult> r1 = r0.getJob();     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        ImageResult r2 = (ImageResult) Utils.getCompletedOrNull(r1);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r2;
    L9:
        r2 = null;
    L12:
        th = move-exception;
        throw th;
    }

    public final void setRequest(ViewTargetRequestDelegate r2) {
        ViewTargetRequestDelegate r0 = this.currentRequest;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.currentRequest = r2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r2) {
        ViewTargetRequestDelegate r3 = this.currentRequest;
        if (r3 != null) goto L5;
        return;
    L5:
        this.isRestart = true;
        r3.restart();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r1) {
        ViewTargetRequestDelegate r0 = this.currentRequest;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }
}
