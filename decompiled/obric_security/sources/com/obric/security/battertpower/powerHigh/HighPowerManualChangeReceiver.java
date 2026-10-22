package com.obric.security.battertpower.powerHigh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HighPowerManualChangeReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/HighPowerManualChangeReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HighPowerManualChangeReceiver extends BroadcastReceiver {
    public HighPowerManualChangeReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r2, Intent r3) {
        if (r3 == null) goto L4;
        String r1 = r3.getAction();
    L5:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.hashCode() == (-828426373)) goto L11;
        return;
    L11:
        if (r1.equals(HighPowerManualChangeReceiverKt.HIGH_POWER_MANUAL_CHANGE_ACTION) == false) goto L18;
        if (r3 == null) goto L19;
        String r4 = r3.getStringExtra("packageName");
        if (r4 == null) goto L22;
        Intrinsics.checkNotNullExpressionValue(r4, "intent?.getStringExtra(\"packageName\") ?: return");
        HashSet<String> r5 = HighPowerAppManager.Companion.getManualPackageSet();
        r5.add(r4);
        HighPowerAppManager.Companion.updateManualPackageSet(r5);
        return;
    L22:
        return;
    L19:
        return;
    L18:
        return;
    L4:
        r1 = null;
        goto L5
    }
}
