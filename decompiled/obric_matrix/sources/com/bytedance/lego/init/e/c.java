package com.bytedance.lego.init.e;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable, Comparable<c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.y.c("taskId")
    public String f4862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.google.gson.y.c("moduleName")
    public String f4863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient g f4864h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.google.gson.y.c("mustRunInMainThread")
    public boolean f4865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.google.gson.y.c("runInProcess")
    public List<String> f4866j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @com.google.gson.y.c("priority")
    public int f4867k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @com.google.gson.y.c("delayTime")
    public d f4868l;

    @com.google.gson.y.c("realPriority")
    public int m;

    public c() {
    }

    private String b(List<String> r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.isEmpty() == true) goto L15;
        StringBuilder r3 = new StringBuilder();
        r3.append("[");
        r3.append(r4.get(0));
        int r0 = 1;
    L8:
        if (r0 >= r4.size()) goto L10;
        r3.append("," + r4.get(r0));
        r0 = r0 + 1;
        goto L8
    L10:
        r3.append("]");
        return r3.toString();
    L15:
        return null;
    }

    public int a(c r3) {
        int r0 = this.m;
        int r1 = r3.m;
        if (r0 >= r1) goto L6;
        return -1;
    L6:
        if (r0 <= r1) goto L10;
        return 1;
    L10:
        return this.f4864h.getClass().getSimpleName().compareTo(r3.f4864h.getClass().getSimpleName());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(c r1) {
        return a(r1);
    }

    public String toString() {
        return this.m + "," + this.f4862f + "," + this.f4865i + "," + this.f4863g + "," + this.f4868l.name() + "," + this.f4867k + "," + b(this.f4866j);
    }
}
