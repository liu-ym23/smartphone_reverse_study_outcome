package com.obric.olog;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;
import com.obric.matrix.r.c.c;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigService extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Messenger f10695f;

    public ConfigService() {
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context a(ConfigService r2) {
        return r2.getApplicationContext();
    L4:
        e = move-exception;
        c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        a(this);
        Log.d("ConfigService", "onBind");
        return this.f10695f.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("olog ConfigService", "onCreate");
        this.f10695f = new Messenger(new a(a(this)));
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("olog ConfigService", "onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r3) {
        Log.d("olog ConfigService", "onUnbind");
        return super.onUnbind(r3);
    }
}
