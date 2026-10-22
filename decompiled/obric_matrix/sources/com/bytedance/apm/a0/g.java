package com.bytedance.apm.a0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1171c;

    class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f1172a;

        a(g r1) {
            this.f1172a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r3, Intent r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            g.a(this.f1172a, r4.getIntExtra("temperature", 0) / 10.0f);
            g.b(this.f1172a, r4.getIntExtra("status", 1));
            g.c(this.f1172a, r4.getIntExtra("plugged", -1));
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f1173a = null;

        static {
            f1173a = new g(null);
        }

        static /* synthetic */ g a() {
            return f1173a;
        }
    }

    private g() {
        g();
    }

    /* synthetic */ g(a r1) {
        this();
    }

    static /* synthetic */ float a(g r0, float r1) {
        r0.f1169a = r1;
        return r1;
    }

    static /* synthetic */ int b(g r0, int r1) {
        r0.f1170b = r1;
        return r1;
    }

    static /* synthetic */ int c(g r0, int r1) {
        r0.f1171c = r1;
        return r1;
    }

    public static g d() {
        return b.a();
    }

    private void g() {
        new a(this);
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public int e() {
        return this.f1170b;
    }

    public float f() {
        return this.f1169a;
    }
}
