package com.bytedance.badger;

import com.bytedance.badger.data.BadgerNativeUpdateCallback;
import com.bytedance.badger.data.BadgerUpdateInfo;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class g implements BadgerNativeUpdateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f2569a;

    g(BadgerCore r1, int r2, l r3) {
        this.f2569a = r3;
    }

    @Override // com.bytedance.badger.data.BadgerNativeUpdateCallback
    public void onUpdate(BadgerUpdateInfo r9) {
        o.g(r9, LocationMonitorConst.INFO);
        this.f2569a.invoke(BadgerUpdateInfo.copy$default(r9, 0, 0, 3, null));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.e("BadgerCore", "Failed to call fullCallback: " + th.getMessage());
    }
}
