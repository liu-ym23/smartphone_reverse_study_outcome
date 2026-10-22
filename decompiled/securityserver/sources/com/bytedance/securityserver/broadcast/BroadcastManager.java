package com.bytedance.securityserver.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f54a = null;
    public static BroadcastManager b;

    public static class Recevier extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r1, Intent r2) {
            Set r0 = (Set) BroadcastManager.f54a.get(r2.getAction());
            if (r0 != null) goto L5;
            return;
        L5:
            Iterator r3 = r0.iterator();
        L7:
            if (r3.hasNext() == false) goto L9;
            ((IReceiverCall) r3.next()).a(r2);
            goto L7
        }
    }

    static {
        f54a = new HashMap();
    }

    public BroadcastManager(Context r4) {
        IntentFilter r3 = new IntentFilter();     // Catch: Exception -> L5
        r3.addAction("android.intent.action.PACKAGE_ADDED");     // Catch: Exception -> L5
        r3.addAction("android.intent.action.PACKAGE_REMOVED");     // Catch: Exception -> L5
        r3.addAction("android.intent.action.PACKAGE_REPLACED");     // Catch: Exception -> L5
        r3.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");     // Catch: Exception -> L5
        r3.addAction("android.intent.action.PACKAGE_DATA_CLEARED");     // Catch: Exception -> L5
        r3.addDataScheme("package");     // Catch: Exception -> L5
        IntentFilter r0 = new IntentFilter();     // Catch: Exception -> L5
        r0.addAction("android.intent.action.ACTION_SHUTDOWN");     // Catch: Exception -> L5
        Recevier r1 = new Recevier();     // Catch: Exception -> L5
        r4.registerReceiver(r1, r3, 4);     // Catch: Exception -> L5
        r4.registerReceiver(r1, r0, 4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a.a.C(e, new StringBuilder("registerBroadcast occur exception, "), "BroadcastManager");
    }

    public static BroadcastManager a(Context r2) {
        if (b != null) goto L16;
        monitor-enter(BroadcastManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L11;
        b = new BroadcastManager(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(BroadcastManager.class);     // Catch: Throwable -> L9
    L16:
        return b;
    }
}
