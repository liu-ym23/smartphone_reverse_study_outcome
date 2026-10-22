package com.bytedance.feedbackerlib.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.m.l;
import com.bytedance.feedbackerlib.service.FloatWindowService;

/* JADX INFO: loaded from: classes.dex */
public class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f4257a;

    static {
    }

    private b() {
    }

    public static b a() {
        if (f4257a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4257a != null) goto L9;
        f4257a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f4257a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r3, Intent r4) {
        Context r2 = Feedbacker.getApplicationContext();
        if (l.c(r2) == false) goto L6;
        return;
    L6:
        if (Feedbacker.isFeedbackCommonInfoSetted() == true) goto L8;
        return;
    L8:
        if (Feedbacker.getApplicationContext() == null) goto L13;
        FloatWindowService.l(r2, false, false, "on_receive->" + System.currentTimeMillis());
        return;
    }
}
