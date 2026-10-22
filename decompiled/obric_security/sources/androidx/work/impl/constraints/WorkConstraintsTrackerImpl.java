package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkConstraintsTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0016\u0010\u0018\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0016\u0010\u0019\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/work/impl/constraints/WorkConstraintsTrackerImpl;", "Landroidx/work/impl/constraints/WorkConstraintsTracker;", "Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "trackers", "Landroidx/work/impl/constraints/trackers/Trackers;", "callback", "Landroidx/work/impl/constraints/WorkConstraintsCallback;", "(Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/constraints/WorkConstraintsCallback;)V", "constraintControllers", "", "Landroidx/work/impl/constraints/controllers/ConstraintController;", "(Landroidx/work/impl/constraints/WorkConstraintsCallback;[Landroidx/work/impl/constraints/controllers/ConstraintController;)V", "[Landroidx/work/impl/constraints/controllers/ConstraintController;", "lock", "", "areAllConstraintsMet", "", "workSpecId", "", "onConstraintMet", "", "workSpecs", "", "Landroidx/work/impl/model/WorkSpec;", "onConstraintNotMet", "replace", "", "reset", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WorkConstraintsTrackerImpl implements WorkConstraintsTracker, ConstraintController.OnConstraintUpdatedCallback {
    private final WorkConstraintsCallback callback;
    private final ConstraintController<?>[] constraintControllers;
    private final Object lock;

    public WorkConstraintsTrackerImpl(WorkConstraintsCallback r2, ConstraintController<?>[] r3) {
        Intrinsics.checkNotNullParameter(r3, "constraintControllers");
        this.callback = r2;
        this.constraintControllers = r3;
        this.lock = new Object();
    }

    public WorkConstraintsTrackerImpl(Trackers r4, WorkConstraintsCallback r5) {
        Intrinsics.checkNotNullParameter(r4, "trackers");
        this(r5, new ConstraintController[]{new BatteryChargingController(r4.getBatteryChargingTracker()), new BatteryNotLowController(r4.getBatteryNotLowTracker()), new StorageNotLowController(r4.getStorageNotLowTracker()), new NetworkConnectedController(r4.getNetworkStateTracker()), new NetworkUnmeteredController(r4.getNetworkStateTracker()), new NetworkNotRoamingController(r4.getNetworkStateTracker()), new NetworkMeteredController(r4.getNetworkStateTracker())});
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsTracker
    public void replace(Iterable<WorkSpec> r8) {
        Intrinsics.checkNotNullParameter(r8, "workSpecs");
        Object r0 = this.lock;
        monitor-enter(r0);
        ConstraintController<?>[] r1 = this.constraintControllers;     // Catch: Throwable -> L16
        int r2 = r1.length;     // Catch: Throwable -> L16
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L7;
        r1[r4].setCallback(null);     // Catch: Throwable -> L16
        r4 = r4 + 1;     // Catch: Throwable -> L16
        goto L5
    L7:
        ConstraintController<?>[] r5 = this.constraintControllers;     // Catch: Throwable -> L16
        int r6 = r5.length;     // Catch: Throwable -> L16
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L10;
        r5[r7].replace(r8);     // Catch: Throwable -> L16
        r7 = r7 + 1;     // Catch: Throwable -> L16
        goto L8
    L10:
        ConstraintController<?>[] r9 = this.constraintControllers;     // Catch: Throwable -> L16
        int r10 = r9.length;     // Catch: Throwable -> L16
    L11:
        if (r3 >= r10) goto L13;
        r9[r3].setCallback(this);     // Catch: Throwable -> L16
        r3 = r3 + 1;     // Catch: Throwable -> L16
        goto L11
    L13:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsTracker
    public void reset() {
        Object r0 = this.lock;
        monitor-enter(r0);
        ConstraintController<?>[] r4 = this.constraintControllers;     // Catch: Throwable -> L10
        int r1 = r4.length;     // Catch: Throwable -> L10
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r4[r2].reset();     // Catch: Throwable -> L10
        r2 = r2 + 1;     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean areAllConstraintsMet(String r7) {
        Intrinsics.checkNotNullParameter(r7, "workSpecId");
        Object r0 = this.lock;
        monitor-enter(r0);
        ConstraintController<?>[] r6 = this.constraintControllers;     // Catch: Throwable -> L17
        int r1 = r6.length;     // Catch: Throwable -> L17
        boolean r2 = false;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L10;
        ConstraintController<?> r4 = r6[r3];     // Catch: Throwable -> L17
        if (r4.isWorkSpecConstrained(r7) == true) goto L11;
        r3 = r3 + 1;     // Catch: Throwable -> L17
    L11:
        if (r4 == null) goto L13;
        Logger.get().debug(WorkConstraintsTrackerKt.access$getTAG$p(), "Work " + r7 + " constrained by " + r4.getClass().getSimpleName());     // Catch: Throwable -> L17
    L13:
        if (r4 != null) goto L15;
        r2 = true;
    L15:
        monitor-exit(r0);
        return r2;
    L10:
        r4 = null;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void onConstraintMet(List<WorkSpec> r8) {
        Intrinsics.checkNotNullParameter(r8, "workSpecs");
        Object r0 = this.lock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L19
        Iterator<T> r9 = r8.iterator();     // Catch: Throwable -> L19
    L6:
        if (r9.hasNext() == false) goto L10;
        Object r2 = r9.next();     // Catch: Throwable -> L19
        if (areAllConstraintsMet(((WorkSpec) r2).id) == false) goto L6;
        r1.add(r2);     // Catch: Throwable -> L19
        goto L6
    L10:
        ArrayList r3 = r1;     // Catch: Throwable -> L19
        Iterator r10 = r3.iterator();     // Catch: Throwable -> L19
    L12:
        if (r10.hasNext() == false) goto L14;
        Logger.get().debug(WorkConstraintsTrackerKt.access$getTAG$p(), "Constraints met for " + ((WorkSpec) r10.next()));     // Catch: Throwable -> L19
        goto L12
    L14:
        WorkConstraintsCallback r7 = this.callback;     // Catch: Throwable -> L19
        if (r7 == null) goto L17;
        r7.onAllConstraintsMet(r3);     // Catch: Throwable -> L19
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void onConstraintNotMet(List<WorkSpec> r2) {
        Intrinsics.checkNotNullParameter(r2, "workSpecs");
        Object r0 = this.lock;
        monitor-enter(r0);
        WorkConstraintsCallback r1 = this.callback;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onAllConstraintsNotMet(r2);     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
