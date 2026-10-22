package com.bytedance.badger.f;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends Binder implements j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f2567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f2568g = 0;

    static {
        f2567f = com.bytedance.badger.j.h.a("G3trcaMrcxsrc6Nxm3ujK5Nxm3ujK5ObK5OzK5NxSpp7oyuTmiuTs0sbKw==");
    }

    public static j a(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r2.queryLocalInterface(f2567f);
        if (r0 == null) goto L12;
        if ((r0 instanceof j) == false) goto L12;
        return (j) r0;
    L12:
        return new h(r2);
    }

    static /* synthetic */ String c() {
        return f2567f;
    }
}
