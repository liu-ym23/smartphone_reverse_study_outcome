package com.squareup.wire.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.i0.e;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ \u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\rR\u0016\u0010\u0017\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/squareup/wire/internal/MutableOnWriteList;", "T", "Lkotlin/i0/e;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Ljava/io/Serializable;", "Lcom/squareup/wire/internal/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "", "index", "get", "(I)Ljava/lang/Object;", "element", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/f0;", "add", "(ILjava/lang/Object;)V", "removeAt", "getSize", "()I", "size", "", "immutableList", "Ljava/util/List;", "mutableList", "getMutableList$wire_runtime", "()Ljava/util/List;", "setMutableList$wire_runtime", "(Ljava/util/List;)V", "<init>", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final class MutableOnWriteList<T> extends e<T> implements RandomAccess, Serializable {
    private final List<T> immutableList;
    private List<? extends T> mutableList;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableOnWriteList(List<? extends T> r2) {
        o.g(r2, "immutableList");
        this.immutableList = r2;
        this.mutableList = r2;
    }

    private final Object writeReplace() {
        return new ArrayList(this.mutableList);
    }

    @Override // kotlin.i0.e, java.util.AbstractList, java.util.List
    public void add(int r3, T r4) {
        if (this.mutableList != this.immutableList) goto L5;
        this.mutableList = new ArrayList(this.immutableList);
    L5:
        List<? extends T> r2 = this.mutableList;
        if (r2 == null) goto L10;
        ((ArrayList) r2).add(r3, r4);
        return;
    L10:
        throw new b0("null cannot be cast to non-null type java.util.ArrayList<T>");
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r1) {
        return this.mutableList.get(r1);
    }

    public final List<T> getMutableList$wire_runtime() {
        return this.mutableList;
    }

    @Override // kotlin.i0.e
    public int getSize() {
        return this.mutableList.size();
    }

    @Override // kotlin.i0.e
    public T removeAt(int r3) {
        if (this.mutableList != this.immutableList) goto L5;
        this.mutableList = new ArrayList(this.immutableList);
    L5:
        List<? extends T> r2 = this.mutableList;
        if (r2 == null) goto L10;
        return (T) ((ArrayList) r2).remove(r3);
    L10:
        throw new b0("null cannot be cast to non-null type java.util.ArrayList<T>");
    }

    @Override // kotlin.i0.e, java.util.AbstractList, java.util.List
    public T set(int r3, T r4) {
        if (this.mutableList != this.immutableList) goto L5;
        this.mutableList = new ArrayList(this.immutableList);
    L5:
        List<? extends T> r2 = this.mutableList;
        if (r2 == null) goto L10;
        return (T) ((ArrayList) r2).set(r3, r4);
    L10:
        throw new b0("null cannot be cast to non-null type java.util.ArrayList<T>");
    }

    public final void setMutableList$wire_runtime(List<? extends T> r2) {
        o.g(r2, "<set-?>");
        this.mutableList = r2;
    }
}
