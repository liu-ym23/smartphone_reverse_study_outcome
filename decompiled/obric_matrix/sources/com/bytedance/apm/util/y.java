package com.bytedance.apm.util;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public class y<E extends Comparable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PriorityQueue<E> f2080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2081b;

    class a implements Comparator<E> {
        a(y r1) {
        }

        public int a(E r1, E r2) {
            return r1.compareTo(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return a((Comparable) r1, (Comparable) r2);
        }
    }

    public y(int r3) {
        if (r3 <= 0) goto L7;
        this.f2081b = r3;
        this.f2080a = new PriorityQueue(r3, new a(this));
        return;
    L7:
        throw new IllegalStateException();
    }

    public void a(E r3) {
        if (this.f2080a.size() >= this.f2081b) goto L6;
    L4:
        this.f2080a.add(r3);
        return;
    L6:
        if (r3.compareTo(this.f2080a.peek()) <= 0) goto L9;
        this.f2080a.poll();
        goto L4
    }

    public void b() {
        this.f2080a.clear();
    }

    public int c() {
        return this.f2080a.size();
    }

    public List<E> d() {
        ArrayList r0 = new ArrayList(this.f2080a);
        Collections.sort(r0);
        return r0;
    }
}
