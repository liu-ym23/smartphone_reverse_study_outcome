package com.bytedance.bdinstall;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<Boolean> f2841a = null;

    static {
        f2841a = new ThreadLocal();
    }

    l0() {
        new AtomicBoolean(false);
    }

    static void a(boolean r1) {
        if (r1 == false) goto L4;
        f2841a.set(Boolean.valueOf(r1));
        return;
    L4:
        f2841a.remove();
    }

    static void b(boolean r1) {
        if (r1 == false) goto L4;
        f2841a.set(Boolean.valueOf(r1));
        return;
    L4:
        f2841a.remove();
        q.a("tryWaitingForInstallFinishWithOldWay finish because request finished");
    }
}
