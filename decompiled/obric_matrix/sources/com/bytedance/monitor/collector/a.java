package com.bytedance.monitor.collector;

import android.os.Message;
import androidx.annotation.CallSuper;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f5105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f5106c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f5107a;

    static {
    }

    public a() {
        this.f5107a = false;
    }

    @CallSuper
    public void a(String r1) {
    }

    @CallSuper
    public void b(String r1, Message r2) {
        this.f5107a = false;
        a(r1);
    }

    @CallSuper
    public void c(String r1) {
        this.f5107a = true;
    }

    public boolean d() {
        return false;
    }
}
