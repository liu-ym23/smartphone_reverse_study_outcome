package com.bytedance.apm.e0;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<T> f1501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1502b;

    public a(int r2) {
        this.f1501a = new LinkedList();
        this.f1502b = r2;
    }

    public void a(T r3) {
        if (this.f1501a.size() <= this.f1502b) goto L5;
        this.f1501a.removeFirst();
    L5:
        this.f1501a.addLast(r3);
    }

    public LinkedList<T> b() {
        return this.f1501a;
    }
}
