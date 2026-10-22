package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryNotLowTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\b\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;", "Landroidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker;", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "initialState", "getInitialState", "()Ljava/lang/Boolean;", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "onBroadcastReceive", "", "intent", "Landroid/content/Intent;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ Object getInitialState() {
        return getInitialState();
    }

    public BatteryNotLowTracker(Context r2, TaskExecutor r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskExecutor");
        super(r2, r3);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Boolean getInitialState() {
        Intent r5 = getAppContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean r0 = false;
        if (r5 != null) goto L6;
        Logger.get().error(BatteryNotLowTrackerKt.access$getTAG$p(), "getInitialState - null intent received");
        return false;
    L6:
        int r1 = r5.getIntExtra("status", -1);
        float r2 = r5.getIntExtra("level", -1) / r5.getIntExtra("scale", -1);
        if (r1 != 1) goto L9;
    L10:
        r0 = true;
    L12:
        return Boolean.valueOf(r0);
    L9:
        if (r2 <= 0.15f) goto L12;
        goto L10
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.BATTERY_OKAY");
        r1.addAction("android.intent.action.BATTERY_LOW");
        return r1;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Intent r5) {
        Intrinsics.checkNotNullParameter(r5, "intent");
        if (r5.getAction() != null) goto L5;
        return;
    L5:
        Logger.get().debug(BatteryNotLowTrackerKt.access$getTAG$p(), "Received " + r5.getAction());
        String r6 = r5.getAction();
        if (r6 == null) goto L21;
        int r0 = r6.hashCode();
        if (r0 == (-1980154005)) goto L17;
        if (r0 == 490310653) goto L13;
        return;
    L13:
        if (r6.equals("android.intent.action.BATTERY_LOW") == false) goto L24;
        setState(false);
        return;
    L24:
        return;
    L17:
        if (r6.equals("android.intent.action.BATTERY_OKAY") == false) goto L25;
        setState(true);
        return;
    L25:
        return;
    }
}
