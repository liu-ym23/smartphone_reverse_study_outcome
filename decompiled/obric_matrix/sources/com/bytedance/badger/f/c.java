package com.bytedance.badger.f;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
final class c implements ServiceConnection {
    c() {
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r1) {
        com.bytedance.badger.d.b("DeviceFp1", "service# Sorter onNullBinding");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r1, IBinder r2) {
        e.f2555c = i.a(r2);
        new Thread(new b(this)).start();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
        e.f2555c = null;
        e.c(false);
        com.bytedance.badger.d.b("DeviceFp1", "service# disconnect");
    }
}
