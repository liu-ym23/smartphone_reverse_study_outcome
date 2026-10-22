package com.bytedance.mpaas.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.e.k;
import d.b.m.e.f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ArrayList<k> f5251b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f5252c = null;

    public static final class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r2, Intent r3) {
            o.g(r2, "context");
            o.g(r3, "intent");
            if (o.a("privacy_agreed", r3.getAction()) == false) goto L6;
            d.b.m.d.a.b("mPaaSInit", new Object[]{"received user agreed action then call execute"});
            LocalBroadcastManager.getInstance(com.bytedance.mpaas.app.a.f5245g).unregisterReceiver(this);
            InitScheduler.initTasks();
            b.a(b.f5252c);
            return;
        }
    }

    static {
        f5252c = new b();
        f5251b = new ArrayList();
    }

    private b() {
    }

    public static final /* synthetic */ void a(b r0) {
        r0.e();
    }

    private final boolean b() {
        if (com.bytedance.mpaas.app.a.f5247i == true) goto L5;
    L9:
        return false;
    L5:
        if (f.a() == false) goto L9;
        if (f.b() == true) goto L9;
        return true;
    }

    private final void c() {
        if (b() == true) goto L5;
        InitScheduler.initTasks();
        return;
    L5:
        if (f.b() == true) goto L9;
        IntentFilter r2 = new IntentFilter();
        r2.addAction("privacy_agreed");
        LocalBroadcastManager.getInstance(com.bytedance.mpaas.app.a.f5245g).registerReceiver(new a(), r2);
        return;
    }

    private final void e() {
        Iterator<T> r2 = f5251b.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        k r0 = (k) r2.next();
        f5252c.d(r0);
        goto L4
    L6:
        f5251b.clear();
    }

    @MainThread
    public final void d(k r2) {
        o.g(r2, "initPeriod");
        if (f5250a == true) goto L6;
        f5250a = true;
        c();
    L6:
        if (b() == false) goto L8;
        f5251b.add(r2);
        return;
    L8:
        InitScheduler.onPeriodStart(r2);
        InitScheduler.onPeriodEnd(r2);
    }
}
