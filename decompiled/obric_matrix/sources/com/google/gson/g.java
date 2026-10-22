package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends j implements Iterable<j> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList<j> f6903f;

    public g() {
        this.f6903f = new ArrayList();
    }

    private j s() {
        int r0 = this.f6903f.size();
        if (r0 != 1) goto L7;
        return this.f6903f.get(0);
    L7:
        throw new IllegalStateException("Array must have size 1, but has size " + r0);
    }

    @Override // com.google.gson.j
    public int a() {
        return s().a();
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof g) == true) goto L6;
    L8:
        return false;
    L6:
        if (((g) r2).f6903f.equals(this.f6903f) == false) goto L8;
        goto L8
    }

    @Override // com.google.gson.j
    public long g() {
        return s().g();
    }

    public int hashCode() {
        return this.f6903f.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        return this.f6903f.iterator();
    }

    @Override // com.google.gson.j
    public String l() {
        return s().l();
    }

    public void q(j r1) {
        if (r1 != null) goto L4;
        r1 = l.f7093a;
    L4:
        this.f6903f.add(r1);
    }

    public j r(int r1) {
        return this.f6903f.get(r1);
    }

    public int size() {
        return this.f6903f.size();
    }
}
