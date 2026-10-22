package com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class MethodDelegate {
    public Object afterInvoke(Object r1, Method r2, Object[] r3, Object r4) {
        return r4;
    }

    public Object beforeInvoke(Object r1, Method r2, Object[] r3) {
        return null;
    }

    public MethodDelegate() {
    }
}
