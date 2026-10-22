package androidx.lifecycle;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: LifecycleController.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0007J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "parentJob", "Lkotlinx/coroutines/Job;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", SafeCushionConstant.FINISH_STATE, "", "handleDestroy", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public static /* synthetic */ void $r8$lambda$7XqClT_TFDHmqX3ARP07WvbP2Qg(LifecycleController r0, Job r1, LifecycleOwner r2, Lifecycle.Event r3) {
        m48observer$lambda0(r0, r1, r2, r3);
    }

    public LifecycleController(Lifecycle r2, Lifecycle.State r3, DispatchQueue r4, final Job r5) {
        Intrinsics.checkNotNullParameter(r2, "lifecycle");
        Intrinsics.checkNotNullParameter(r3, "minState");
        Intrinsics.checkNotNullParameter(r4, "dispatchQueue");
        Intrinsics.checkNotNullParameter(r5, "parentJob");
        this.lifecycle = r2;
        this.minState = r3;
        this.dispatchQueue = r4;
        LifecycleEventObserver r6 = new LifecycleController$$ExternalSyntheticLambda0(this, r5);
        this.observer = r6;
        if (r2.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
        finish();
        return;
    L5:
        r2.addObserver(r6);
    }

    /* JADX INFO: renamed from: observer$lambda-0, reason: not valid java name */
    private static final void m48observer$lambda0(LifecycleController r1, Job r2, LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$parentJob");
        Intrinsics.checkNotNullParameter(r3, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkNotNullParameter(r4, "<anonymous parameter 1>");
        if (r3.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        r1.finish();
        return;
    L6:
        if (r3.getLifecycle().getCurrentState().compareTo(r1.minState) >= 0) goto L8;
        r1.dispatchQueue.pause();
        return;
    L8:
        r1.dispatchQueue.resume();
    }

    private final void handleDestroy(Job r3) {
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
        finish();
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
