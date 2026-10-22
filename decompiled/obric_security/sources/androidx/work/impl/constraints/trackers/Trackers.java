package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Trackers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Landroidx/work/impl/constraints/trackers/Trackers;", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "batteryChargingTracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "", "batteryNotLowTracker", "Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;", "networkStateTracker", "Landroidx/work/impl/constraints/NetworkState;", "storageNotLowTracker", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/constraints/trackers/ConstraintTracker;Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;Landroidx/work/impl/constraints/trackers/ConstraintTracker;Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "getBatteryChargingTracker", "()Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "getBatteryNotLowTracker", "()Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;", "getNetworkStateTracker", "getStorageNotLowTracker", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Trackers {
    private final ConstraintTracker<Boolean> batteryChargingTracker;
    private final BatteryNotLowTracker batteryNotLowTracker;
    private final ConstraintTracker<NetworkState> networkStateTracker;
    private final ConstraintTracker<Boolean> storageNotLowTracker;

    public Trackers(Context r11, TaskExecutor r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "taskExecutor");
        this(r11, r12, null, null, null, null, 60, null);
    }

    public Trackers(Context r11, TaskExecutor r12, ConstraintTracker<Boolean> r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "taskExecutor");
        Intrinsics.checkNotNullParameter(r13, "batteryChargingTracker");
        this(r11, r12, r13, null, null, null, 56, null);
    }

    public Trackers(Context r11, TaskExecutor r12, ConstraintTracker<Boolean> r13, BatteryNotLowTracker r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "taskExecutor");
        Intrinsics.checkNotNullParameter(r13, "batteryChargingTracker");
        Intrinsics.checkNotNullParameter(r14, "batteryNotLowTracker");
        this(r11, r12, r13, r14, null, null, 48, null);
    }

    public Trackers(Context r11, TaskExecutor r12, ConstraintTracker<Boolean> r13, BatteryNotLowTracker r14, ConstraintTracker<NetworkState> r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "taskExecutor");
        Intrinsics.checkNotNullParameter(r13, "batteryChargingTracker");
        Intrinsics.checkNotNullParameter(r14, "batteryNotLowTracker");
        Intrinsics.checkNotNullParameter(r15, "networkStateTracker");
        this(r11, r12, r13, r14, r15, null, 32, null);
    }

    public Trackers(Context r2, TaskExecutor r3, ConstraintTracker<Boolean> r4, BatteryNotLowTracker r5, ConstraintTracker<NetworkState> r6, ConstraintTracker<Boolean> r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskExecutor");
        Intrinsics.checkNotNullParameter(r4, "batteryChargingTracker");
        Intrinsics.checkNotNullParameter(r5, "batteryNotLowTracker");
        Intrinsics.checkNotNullParameter(r6, "networkStateTracker");
        Intrinsics.checkNotNullParameter(r7, "storageNotLowTracker");
        this.batteryChargingTracker = r4;
        this.batteryNotLowTracker = r5;
        this.networkStateTracker = r6;
        this.storageNotLowTracker = r7;
    }

    public final ConstraintTracker<Boolean> getBatteryChargingTracker() {
        return this.batteryChargingTracker;
    }

    public /* synthetic */ Trackers(Context r8, TaskExecutor r9, ConstraintTracker r10, BatteryNotLowTracker r11, ConstraintTracker r12, ConstraintTracker r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L5;
        Context r3 = r8.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context.applicationContext");
        ConstraintTracker r4 = new BatteryChargingTracker(r3, r9);
    L7:
        if ((r14 & 8) == 0) goto L9;
        Context r5 = r8.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context.applicationContext");
        BatteryNotLowTracker r6 = new BatteryNotLowTracker(r5, r9);
    L11:
        if ((r14 & 16) == 0) goto L13;
        Context r0 = r8.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context.applicationContext");
        ConstraintTracker r7 = NetworkStateTrackerKt.NetworkStateTracker(r0, r9);
    L15:
        if ((r14 & 32) == 0) goto L17;
        Context r16 = r8.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r16, "context.applicationContext");
        ConstraintTracker r17 = new StorageNotLowTracker(r16, r9);
    L18:
        this(r8, r9, r4, r6, r7, r17);
        return;
    L17:
        r17 = r13;
        goto L18
    L13:
        r7 = r12;
        goto L15
    L9:
        r6 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public final BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.batteryNotLowTracker;
    }

    public final ConstraintTracker<NetworkState> getNetworkStateTracker() {
        return this.networkStateTracker;
    }

    public final ConstraintTracker<Boolean> getStorageNotLowTracker() {
        return this.storageNotLowTracker;
    }
}
