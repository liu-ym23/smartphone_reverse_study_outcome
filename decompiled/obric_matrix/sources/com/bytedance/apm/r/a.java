package com.bytedance.apm.r;

import android.view.FrameMetrics;
import androidx.annotation.CallSuper;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1816a;

    public a() {
        this.f1816a = false;
    }

    @CallSuper
    public void c(String r1) {
        this.f1816a = true;
    }

    @CallSuper
    public void d(long r1, long r3, long r5, long r7, boolean r9) {
        this.f1816a = false;
    }

    public void e(String r1, long r2, long r4) {
    }

    public boolean f() {
        return this.f1816a;
    }

    public void g(String r1, long r2, int r4) {
    }

    public void h(String r1, FrameMetrics r2, int r3) {
    }
}
