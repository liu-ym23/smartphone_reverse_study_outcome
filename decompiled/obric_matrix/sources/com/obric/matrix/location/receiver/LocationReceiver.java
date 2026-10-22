package com.obric.matrix.location.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.obric.matrix.location.f;
import com.obric.matrix.location.h;
import com.obric.matrix.r.c.c;
import java.util.Locale;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LocationReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LocationReceiver f9218a;

    public LocationReceiver() {
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    public static void b(Context r2) {
        if (f9218a == null) goto L6;
        c.j("LocationReceiver", "registerReceiver: already registered");
        return;
    L6:
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.SCREEN_ON");
        r0.addAction("android.intent.action.SCREEN_OFF");
        r0.addAction("android.location.MODE_CHANGED");
        r0.setPriority(1000);
        LocationReceiver r1 = new LocationReceiver();
        f9218a = r1;
        a(r2, r1, r0);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r4, Intent r5) {
        String r3 = r5.getAction();
        c.j("LocationReceiver", "onReceive: action=" + r3);
        if ("android.intent.action.SCREEN_ON".equals(r3) == false) goto L6;
        c.b("LocationReceiver", "screen on");
        f.o().B(true, r4);
        return;
    L6:
        if ("android.intent.action.SCREEN_OFF".equals(r3) == false) goto L9;
        c.b("LocationReceiver", "screen off");
        f.o().B(false, r4);
        return;
    L9:
        if ("android.location.MODE_CHANGED".equals(r3) == false) goto L14;
        boolean r6 = h.c();
        c.j("LocationReceiver", "onReceive: isLocationEnabled=" + r6);
        if (r6 == false) goto L19;
        f.o().z(true, false, "sys_location_enable");
        return;
    L19:
        return;
    L14:
        if ("android.intent.action.LOCALE_CHANGED".equals(r3) == false) goto L21;
        c.j("LocationReceiver", "onReceive: locale changed");
        BDLocationConfig.setLocale(Locale.getDefault());
        f.o().A(true, false, true, "sys_locale_change");
        return;
    }
}
