package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.Looper;
import android.util.Printer;
import com.bytedance.platform.godzilla.common.DoubleReflectHelper;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
final class BridgeIdleTaskToLooperPrinter {
    private static Field sLoggingField;

    private BridgeIdleTaskToLooperPrinter() {
    }

    private static Printer getLooperPrinter() {
        if (sLoggingField == null) goto L12;
    L10:
        return (Printer) sLoggingField.get(Looper.getMainLooper());
    L7:
        return null;
    L12:
        sLoggingField = DoubleReflectHelper.getField(Looper.class, "mLogging");     // Catch: Throwable -> L9
        goto L10
    }

    static void println(String r1) {
        Printer r0 = getLooperPrinter();
        if (r0 == null) goto L6;
        r0.println(r1);
        return;
    }
}
