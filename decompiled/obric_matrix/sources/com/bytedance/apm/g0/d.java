package com.bytedance.apm.g0;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class d implements IActivityLifeObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f1552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f1553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f1554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f1555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1556g;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference f1557f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Integer f1558g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f1559h;

        a(d r1, WeakReference r2, Integer r3) {
            this.f1559h = r1;
            this.f1557f = r2;
            this.f1558g = r3;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f1557f.get() != null) goto L5;
            return;
        L5:
            View r0 = ((View) this.f1557f.get()).findViewById(this.f1558g.intValue());
            if (r0 != null) goto L8;
            return;
        L8:
            if (r0.getVisibility() == 0) goto L10;
            return;
        L10:
            if (r0.getWidth() <= 0) goto L29;
            ViewTreeObserver r1 = ((View) this.f1557f.get()).getViewTreeObserver();
            if (r1.isAlive() == false) goto L17;
            if (d.a(this.f1559h) == null) goto L17;
            r1.removeOnGlobalLayoutListener(d.a(this.f1559h));
        L17:
            if (d.c(this.f1559h) == null) goto L19;
            d.e(this.f1559h).removeCallbacks(d.c(this.f1559h));
            d.d(this.f1559h, null);
        L19:
            d.b(this.f1559h, null);
            if (d.f(this.f1559h) <= 0) goto L30;
            long r2 = System.currentTimeMillis();
            long r4 = r2 - d.f(this.f1559h);
            d.g(this.f1559h, 0);
            if (r4 < d.h(this.f1559h)) goto L24;
            return;
        L24:
            if (r4 <= 0) goto L32;
            AutoPageTraceHelper.c(r2, d.i(this.f1559h));
            com.bytedance.apm.o.b.a.d(d.i(this.f1559h), "activityOnCreateToViewShow", r4);
            return;
        L32:
            return;
        L30:
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference f1560f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f1561g;

        b(d r1, WeakReference r2) {
            this.f1561g = r1;
            this.f1560f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a(this.f1561g) != null) goto L5;
            return;
        L5:
            if (this.f1560f.get() == null) goto L9;
            ((View) this.f1560f.get()).getViewTreeObserver().removeOnGlobalLayoutListener(d.a(this.f1561g));
            return;
        }
    }

    public d() {
        this.f1550a = -1;
        this.f1554e = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a(d r0) {
        return r0.f1552c;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener b(d r0, ViewTreeObserver.OnGlobalLayoutListener r1) {
        r0.f1552c = r1;
        return r1;
    }

    static /* synthetic */ Runnable c(d r0) {
        return r0.f1553d;
    }

    static /* synthetic */ Runnable d(d r0, Runnable r1) {
        r0.f1553d = r1;
        return r1;
    }

    static /* synthetic */ Handler e(d r0) {
        return r0.f1554e;
    }

    static /* synthetic */ long f(d r2) {
        return r2.f1550a;
    }

    static /* synthetic */ long g(d r0, long r1) {
        r0.f1550a = r1;
        return r1;
    }

    static /* synthetic */ long h(d r2) {
        return r2.f1555f;
    }

    static /* synthetic */ String i(d r0) {
        return r0.f1551b;
    }

    @TargetApi(16)
    private void j(Activity r4) {
        this.f1550a = System.currentTimeMillis();
        String r0 = r4.getClass().getCanonicalName();
        this.f1551b = r0;
        Integer r1 = com.bytedance.apm.g0.i.a.c(r0);
        if (r1 != null) goto L5;
        return;
    L5:
        WeakReference r2 = new WeakReference(r4.getWindow().getDecorView());
        this.f1552c = new a(this, r2, r1);
        ((View) r2.get()).getViewTreeObserver().addOnGlobalLayoutListener(this.f1552c);
        b r5 = new b(this, r2);
        this.f1553d = r5;
        this.f1554e.postDelayed(r5, this.f1555f);
    }

    public void k(long r1, boolean r3) {
        this.f1555f = r1;
        this.f1556g = r3;
        ActivityLifeObserver.getInstance().register(this);
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityCreated(Activity r2, Bundle r3) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return;
    L5:
        if (this.f1556g == false) goto L13;
        j(r2);     // Catch: Exception -> L9
        return;
    L14:
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    @TargetApi(16)
    public void onActivityPause(Activity r3) {
        this.f1550a = 0;
        if (this.f1552c == null) goto L6;
        r3.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f1552c);     // Catch: Exception -> L10
        this.f1552c = null;     // Catch: Exception -> L10
    L6:
        Runnable r4 = this.f1553d;     // Catch: Exception -> L10
        if (r4 == null) goto L13;
        this.f1554e.removeCallbacks(r4);     // Catch: Exception -> L10
        this.f1553d = null;     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityStarted(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r1, Fragment r2) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
    }
}
