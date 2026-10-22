package com.bytedance.bdinstall;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class p extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2854a;

    public p(Context r1, r r2) {
        this.f2854a = r1;
    }

    @Override // com.bytedance.bdinstall.o
    public void a(String r2, r r3) {
        r3.c(this.f2854a).edit().putString("device_token", r2).apply();
        u0.d(this.f2854a).i("device_token", r2);
    }
}
