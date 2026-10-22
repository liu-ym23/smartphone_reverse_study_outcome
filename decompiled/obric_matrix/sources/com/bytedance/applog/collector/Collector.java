package com.bytedance.applog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.applog.o.e;
import com.bytedance.applog.util.n;

/* JADX INFO: loaded from: classes.dex */
public class Collector extends BroadcastReceiver {
    public Collector() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        String[] r0 = r2.getStringArrayExtra("K_DATA");
        if (r0 != null) goto L5;
    L7:
        n.i(null);
        return;
    L5:
        if (r0.length <= 0) goto L7;
        e.G(r0);
    }
}
