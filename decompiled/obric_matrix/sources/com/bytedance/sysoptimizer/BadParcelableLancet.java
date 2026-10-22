package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Bundle;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class BadParcelableLancet {
    public BadParcelableLancet() {
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public Bundle getBundleExtra(String r1) {
        Bundle r0 = (Bundle) Origin.call();
        Context r2 = BadParcelableCrashOptimizer.getContext();
        if (r0 == null) goto L6;
        if (r2 == null) goto L6;
        r0.setClassLoader(r2.getClassLoader());
    L6:
        return r0;
    }
}
