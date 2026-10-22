package com.obric.matrix;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/matrix/MainService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onStartCommand", "", "flags", "startId", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MainService extends Service {
    public MainService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        com.obric.matrix.r.c.c.b("MainService", "onBind() called with: intent = " + r2);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        com.obric.matrix.r.c.c.b("MainService", "onCreate() called");
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r3, int r4, int r5) {
        com.obric.matrix.r.c.c.b("MainService", "onStartCommand() called with: intent = " + r3 + ", flags = " + r4 + ", startId = " + r5);
        return super.onStartCommand(r3, r4, r5);
    }
}
