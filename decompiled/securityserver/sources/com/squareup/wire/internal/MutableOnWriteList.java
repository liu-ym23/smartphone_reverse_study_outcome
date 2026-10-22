package com.squareup.wire.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class MutableOnWriteList<T> extends AbstractList<T> implements RandomAccess, Serializable {
    private final List<T> immutableList;
    List<T> mutableList;

    public MutableOnWriteList(List<T> r1) {
        this.immutableList = r1;
        this.mutableList = r1;
    }

    private Object writeReplace() {
        return new ArrayList(this.mutableList);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r3, T r4) {
        if (this.mutableList != this.immutableList) goto L5;
        this.mutableList = new ArrayList(this.immutableList);
    L5:
        this.mutableList.add(r3, r4);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r1) {
        return this.mutableList.get(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int r3) {
        if (this.mutableList != this.immutableList) goto L6;
        this.mutableList = new ArrayList(this.immutableList);
    L6:
        return this.mutableList.remove(r3);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int r3, T r4) {
        if (this.mutableList != this.immutableList) goto L6;
        this.mutableList = new ArrayList(this.immutableList);
    L6:
        return this.mutableList.set(r3, r4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mutableList.size();
    }
}
