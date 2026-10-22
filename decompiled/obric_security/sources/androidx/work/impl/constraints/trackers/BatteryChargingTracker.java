package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryChargingTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\b\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Landroidx/work/impl/constraints/trackers/BatteryChargingTracker;", "Landroidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker;", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "initialState", "getInitialState", "()Ljava/lang/Boolean;", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "isBatteryChangedIntentCharging", "intent", "Landroid/content/Intent;", "onBroadcastReceive", "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BatteryChargingTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ Object getInitialState() {
        return getInitialState();
    }

    public BatteryChargingTracker(Context r2, TaskExecutor r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskExecutor");
        super(r2, r3);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Boolean getInitialState() {
        IntentFilter r0 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent r1 = getAppContext().registerReceiver(null, r0);
        if (r1 != null) goto L7;
        Logger.get().error(BatteryChargingTrackerKt.access$getTAG$p(), "getInitialState - null intent received");
        return false;
    L7:
        return Boolean.valueOf(isBatteryChangedIntentCharging(r1));
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.os.action.CHARGING");
        r1.addAction("android.os.action.DISCHARGING");
        return r1;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Intent r5) {
        Intrinsics.checkNotNullParameter(r5, "intent");
        String r6 = r5.getAction();
        if (r6 != null) goto L5;
        return;
    L5:
        Logger.get().debug(BatteryChargingTrackerKt.access$getTAG$p(), "Received " + r6);
        switch(r6.hashCode()) {
            case -1886648615: goto L21;
            case -54942926: goto L17;
            case 948344062: goto L13;
            case 1019184907: goto L9;
            default: goto L28;
        };
    L28:
        return;
    L9:
        if (r6.equals("android.intent.action.ACTION_POWER_CONNECTED") == false) goto L29;
        setState(true);
        return;
    L29:
        return;
    L13:
        if (r6.equals("android.os.action.CHARGING") == false) goto L30;
        setState(true);
        return;
    L30:
        return;
    L17:
        if (r6.equals("android.os.action.DISCHARGING") == false) goto L31;
        setState(false);
        return;
    L31:
        return;
    L21:
        if (r6.equals("android.intent.action.ACTION_POWER_DISCONNECTED") == false) goto L32;
        setState(false);
        return;
    }

    private final boolean isBatteryChangedIntentCharging(Intent r2) {
        int r1 = r2.getIntExtra("status", -1);
        if (r1 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 5) goto L8;
        return false;
    }
}
