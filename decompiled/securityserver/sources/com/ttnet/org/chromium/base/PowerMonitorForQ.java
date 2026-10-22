package com.ttnet.org.chromium.base;

import android.os.PowerManager;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(29)
public final class PowerMonitorForQ {
    private PowerMonitorForQ() {
    }

    public static void addThermalStatusListener(PowerManager r1) {
        r1.addThermalStatusListener(new AnonymousClass1());
    }
}
