package com.bytedance.bdinstall.z0;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f2913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f2914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f2915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f2916d;

    d(boolean r1, boolean r2) {
        this.f2914b = r1;
        this.f2915c = r2;
        this.f2916d = false;
    }

    d(boolean r1, boolean r2, boolean r3) {
        this.f2914b = r1;
        this.f2915c = r2;
        this.f2916d = r3;
    }

    protected abstract boolean a(JSONObject r1);

    public void b(JSONObject r1) {
    }
}
