package com.bytedance.mpaas.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.bytedance.boost_multidex.BoostMultiDex;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.e.k;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.ss.ttuploader.TTUploadResolver;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends Application {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Application f5245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f5246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f5247i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Context f5248j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TaskConfig f5249f;

    public a() {
    }

    public static Context a() {
        return f5248j;
    }

    public static Application b() {
        return f5245g;
    }

    public static String c(Context r3) {
        int r0 = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses();
        if (r4 != null) goto L6;
        return null;
    L6:
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        ActivityManager.RunningAppProcessInfo r1 = r5.next();
        if (r1.pid != r0) goto L8;
        return r1.processName;
    L13:
        return "";
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context r4) {
        d.b.j.a.a(r4, AppInfo.getInstatnce().getVersionName(r4), null);
        InitMonitor.INSTANCE.onAttachBase();
        f5248j = r4;
        f5245g = this;
        f5246h = c(r4);
        boolean r0 = r4.getPackageName().equals(f5246h);
        f5247i = r0;
        if (this.f5249f != null) goto L5;
        this.f5249f = new TaskConfig.Builder(r4, r0, f5246h).isDebug(d.b.m.e.a.b(f5248j)).setTimeOut(TTUploadResolver.HOST_MAX_CACHE_TIME).agreePrivacyPopupWindow(true).build();
    L5:
        InitScheduler.config(this.f5249f);
        super.attachBaseContext(r4);
        BoostMultiDex.install(r4);
        b r3 = b.f5252c;
        r3.d(k.f4892g);
        r3.d(k.f4893h);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    @Override // android.app.Application
    public void onCreate() {
        com.bytedance.mpaas.activity.a.b(this);
        b r0 = b.f5252c;
        r0.d(k.f4894i);
        super.onCreate();
        r0.d(k.f4895j);
    }
}
