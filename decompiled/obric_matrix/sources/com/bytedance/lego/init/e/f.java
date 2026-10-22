package com.bytedance.lego.init.e;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class f implements Serializable, Comparable<f> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.y.c("taskId")
    public String f4883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.google.gson.y.c("moduleName")
    public String f4884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient a f4885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.google.gson.y.c("mustRunInMainThread")
    public boolean f4886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.google.gson.y.c("priority")
    public int f4887j;

    public f() {
    }

    public int a(f r3) {
        int r0 = this.f4887j;
        int r1 = r3.f4887j;
        if (r0 >= r1) goto L6;
        return 1;
    L6:
        if (r0 <= r1) goto L10;
        return -1;
    L10:
        return this.f4885h.getClass().getSimpleName().compareTo(r3.f4885h.getClass().getSimpleName());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(f r1) {
        return a(r1);
    }

    public String toString() {
        return this.f4887j + "," + this.f4883f + "," + this.f4886i + "," + this.f4884g;
    }
}
