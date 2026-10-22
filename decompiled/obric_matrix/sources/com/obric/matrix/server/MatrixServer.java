package com.obric.matrix.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/server/MatrixServer;", "Landroid/app/Service;", "()V", "binder", "Lcom/obric/matrix/server/ServerBrokerBinder;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "Companion", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixServer extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private p f9955f;

    static {
    }

    public MatrixServer() {
        this.f9955f = new p();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return this.f9955f;
    }

    @Override // android.app.Service
    public void onCreate() {
        com.obric.matrix.r.c.c.j("MatrixServer", "onCreate");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.obric.matrix.r.c.c.j("MatrixServer", "onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        return 1;
    }
}
