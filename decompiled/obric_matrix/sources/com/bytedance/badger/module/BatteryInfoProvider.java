package com.bytedance.badger.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.u;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryInfoProvider extends BadgerModuleBase {
    public BatteryInfoProvider() {
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_badger_module_BatteryInfoProvider_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    protected BadgerResult a(Context r11) {
        o.g(r11, "context");
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 23) goto L5;
        Object r1 = r11.getSystemService("batterymanager");
        if ((r1 instanceof BatteryManager) == true) goto L9;
        r1 = null;
    L9:
        BatteryManager r2 = (BatteryManager) r1;
        if (r2 == null) goto L12;
        int r0 = 1;
        int r3 = r2.getIntProperty(1);
        int r5 = r2.getIntProperty(4);
        if (r3 < 0) goto L18;
        if (r5 < 0) goto L18;
        int r4 = (int) (r3 / (r5 / 100.0f));
    L19:
        u[] r7 = new u[4];
        r7[0] = a0.a("battery_capacity", Integer.valueOf(r4));
        r7[1] = a0.a("battery_remaining", Integer.valueOf(r5));
        if (r10 >= 26) goto L22;
        String r12 = "unsupported";
    L33:
        r7[2] = a0.a("battery_charge_status", r12);
        Intent r13 = INVOKEVIRTUAL_com_bytedance_badger_module_BatteryInfoProvider_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r11, null, new IntentFilter("android.hardware.usb.action.USB_STATE"));
        if (r13 == null) goto L40;
        Bundle r14 = r13.getExtras();
        if (r14 == null) goto L40;
        if (r14.getBoolean("connected") != true) goto L40;
    L41:
        r7[3] = a0.a("usb_status", Integer.valueOf(r0));
        return new BadgerResult.Success(m0.k(r7));
    L40:
        r0 = 0;
        goto L41
    L22:
        int r15 = r2.getIntProperty(6);
        if (r15 == 2) goto L32;
        if (r15 == 3) goto L31;
        if (r15 != 4) goto L27;
        r12 = "not_charging";
        goto L33
    L27:
        if (r15 == 5) goto L29;
        r12 = EnvironmentCompat.MEDIA_UNKNOWN;
        goto L33
    L29:
        r12 = "full";
        goto L33
    L31:
        r12 = "discharging";
        goto L33
    L32:
        r12 = "charging";
    L18:
        r4 = Integer.MIN_VALUE;
        goto L19
    L12:
        return new BadgerResult.Failure(-1, "Get service failed");
    L5:
        return new BadgerResult.Failure(-1, "Not supported");
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public String getName() {
        return "battery";
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public int getPriority() {
        return 2;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public int getRefreshIntervalSeconds() {
        return 60;
    }
}
