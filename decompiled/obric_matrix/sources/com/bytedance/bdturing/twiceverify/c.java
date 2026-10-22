package com.bytedance.bdturing.twiceverify;

import android.app.Activity;
import android.content.Intent;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile c f3154f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.bdturing.twiceverify.b f3155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f3156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.bdturing.twiceverify.a f3157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.bdturing.verify.b.a f3158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.bdturing.twiceverify.b.a f3159e;

    class a implements com.bytedance.bdturing.twiceverify.b.a {
        a(c r1) {
        }
    }

    public interface b {
        void a(int r1, String r2);

        void onSuccess();
    }

    static {
    }

    public c() {
        this.f3159e = new a(this);
    }

    public static c d() {
        if (f3154f != null) goto L13;
        monitor-enter(c.class);
        f3154f = new c();     // Catch: Throwable -> L9
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f3154f;
    }

    public boolean a() {
        if (this.f3155a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public com.bytedance.bdturing.twiceverify.a b() {
        return this.f3157c;
    }

    public com.bytedance.bdturing.twiceverify.b c() {
        return this.f3155a;
    }

    public com.bytedance.bdturing.verify.b.a e() {
        return this.f3158d;
    }

    public b f() {
        return this.f3156b;
    }

    public void g(com.bytedance.bdturing.twiceverify.b r1) {
        this.f3155a = r1;
    }

    public void h() {
        this.f3156b = null;
        this.f3158d = null;
    }

    public void i(com.bytedance.bdturing.verify.b.a r1, HashMap<String, String> r2, b r3) {
        this.f3156b = r3;
        this.f3158d = r1;
        Activity r4 = r1.b();
        if (r4 == null) goto L5;
        Intent r0 = new Intent();
        r0.setClass(r4, TwiceVerifyWebActivity.class);
        r4.startActivity(r0);
        return;
    L5:
        b r5 = this.f3156b;
        if (r5 == null) goto L10;
        r5.a(-1, "start verify error activity is null");
        return;
    }
}
