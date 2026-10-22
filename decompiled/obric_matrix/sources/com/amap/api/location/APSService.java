package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.loc.a4;
import com.loc.s4;

/* JADX INFO: loaded from: classes.dex */
public class APSService extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    a4 f504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f506h;

    public APSService() {
        this.f505g = 0;
        this.f506h = false;
    }

    private void a(Context r3) {
    L7:
        th = move-exception;
        s4.h(th, "APSService", "onCreate");
    L9:
        super.onCreate();
        return;
    L3:
        if (this.f504f != null) goto L5;
        this.f504f = new a4(r3);     // Catch: Throwable -> L7
    L5:
        this.f504f.b();     // Catch: Throwable -> L7
        goto L9
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        return this.f504f.a(r2);
    L4:
        th = move-exception;
        s4.h(th, "APSService", "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f504f.d();     // Catch: Throwable -> L6
        if (this.f506h == false) goto L8;
        stopForeground(true);     // Catch: Throwable -> L6
    L8:
        super.onDestroy();
        return;
    L6:
        th = move-exception;
        s4.h(th, "APSService", "onDestroy");
        goto L8
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r5, int r6, int r7) {
        if (r5 == null) goto L27;
        int r0 = r5.getIntExtra("g", 0);     // Catch: Throwable -> L25
        if (r0 != 1) goto L10;
        int r1 = r5.getIntExtra("i", 0);     // Catch: Throwable -> L25
        Notification r2 = (Notification) r5.getParcelableExtra("h");     // Catch: Throwable -> L25
        if (r1 == 0) goto L27;
        if (r2 == null) goto L27;
        startForeground(r1, r2);     // Catch: Throwable -> L25
        this.f506h = true;     // Catch: Throwable -> L25
        this.f505g++;     // Catch: Throwable -> L25
        goto L27
    L10:
        if (r0 != 2) goto L27;
        if (r5.getBooleanExtra("j", true) == false) goto L17;
        int r3 = this.f505g;     // Catch: Throwable -> L25
        if (r3 <= 0) goto L17;
        this.f505g = r3 - 1;     // Catch: Throwable -> L25
    L17:
        if (this.f505g > 0) goto L19;
        stopForeground(true);     // Catch: Throwable -> L25
        this.f506h = false;     // Catch: Throwable -> L25
        goto L27
    L19:
        stopForeground(false);     // Catch: Throwable -> L25
    L27:
        return this.f504f.c();
    L22:
        th = move-exception;
        s4.h(th, "APSService", "onStartCommand");
        return super.onStartCommand(r5, r6, r7);
    }
}
