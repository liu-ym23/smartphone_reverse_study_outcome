package com.ttnet.org.chromium.base;

import android.os.PowerManager;

/* JADX INFO: loaded from: classes5.dex */
public final class PowerMonitorForQ {
    private PowerMonitorForQ() {
    }

    public static void addThermalStatusListener(PowerManager r1) {
        r1.addThermalStatusListener(new AnonymousClass1());
    }
}
