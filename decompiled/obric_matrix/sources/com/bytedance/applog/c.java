package com.bytedance.applog;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f2210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f2212c;

    public c() {
        this.f2211b = -1;
    }

    public byte[] a() {
        return this.f2210a;
    }

    public int b() {
        return this.f2211b;
    }

    public Map<String, String> c() {
        return this.f2212c;
    }

    public void d(byte[] r1) {
        this.f2210a = r1;
    }

    public void e(int r1) {
        this.f2211b = r1;
    }

    public void f(Map<String, String> r1) {
        this.f2212c = r1;
    }
}
