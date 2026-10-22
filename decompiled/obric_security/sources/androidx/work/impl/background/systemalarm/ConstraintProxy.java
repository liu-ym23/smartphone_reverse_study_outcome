package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class ConstraintProxy extends BroadcastReceiver {
    private static final String TAG = null;

    public static class BatteryChargingProxy extends ConstraintProxy {
        public BatteryChargingProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public BatteryNotLowProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public NetworkStateProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public StorageNotLowProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    ConstraintProxy() {
    }

    static {
        TAG = Logger.tagWithPrefix("ConstraintProxy");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, "onReceive : " + intent);
        context.startService(CommandHandler.createConstraintsChangedIntent(context));
    }

    static void updateAll(Context context, List<WorkSpec> workSpecs) {
        Iterator<WorkSpec> r8 = workSpecs.iterator();
        boolean r1 = false;
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
    L4:
        if (r8.hasNext() == false) goto L14;
        Constraints r5 = r8.next().constraints;
        r1 = r1 | r5.requiresBatteryNotLow();
        r2 = r2 | r5.requiresCharging();
        r3 = r3 | r5.requiresStorageNotLow();
        if (r5.getRequiredNetworkType() == NetworkType.NOT_REQUIRED) goto L8;
        boolean r6 = true;
    L9:
        r4 = r4 | r6;
        if (r1 == false) goto L4;
        if (r2 == false) goto L4;
        if (r3 == false) goto L4;
        if (r4 == false) goto L4;
    L8:
        r6 = false;
    L14:
        context.sendBroadcast(ConstraintProxyUpdateReceiver.newConstraintProxyUpdateIntent(context, r1, r2, r3, r4));
    }
}
