package com.bytedance.privacy.c;

/* JADX INFO: loaded from: classes.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5361f;

    public a(String r1) {
        super(r1);
    }

    public a(String r1, int r2) {
        super(r1);
        this.f5361f = r2;
    }

    public a(String r1, int r2, Throwable r3) {
        super(r1, r3);
        this.f5361f = r2;
    }

    public int a() {
        return this.f5361f;
    }
}
