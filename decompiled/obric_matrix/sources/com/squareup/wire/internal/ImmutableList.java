package com.squareup.wire.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.i0.c;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R6\u0010\u0014\u001a\"\u0012\f\u0012\n \u0012*\u0004\u0018\u00018\u00008\u00000\u0011j\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00018\u00008\u0000`\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/squareup/wire/internal/ImmutableList;", "T", "Lkotlin/i0/c;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Ljava/io/Serializable;", "Lcom/squareup/wire/internal/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "", "index", "get", "(I)Ljava/lang/Object;", "", "toArray", "()[Ljava/lang/Object;", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "Lkotlin/collections/ArrayList;", "list", "Ljava/util/ArrayList;", "getSize", "()I", "size", "", "<init>", "(Ljava/util/List;)V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final class ImmutableList<T> extends c<T> implements RandomAccess, Serializable {
    private final ArrayList<T> list;

    public ImmutableList(List<? extends T> r2) {
        o.g(r2, "list");
        this.list = new ArrayList(r2);
    }

    private final Object writeReplace() {
        List r1 = Collections.unmodifiableList(this.list);
        o.b(r1, "Collections.unmodifiableList(this)");
        return r1;
    }

    @Override // kotlin.i0.c, java.util.List
    public T get(int r1) {
        return this.list.get(r1);
    }

    @Override // kotlin.i0.c, kotlin.i0.a
    public int getSize() {
        return this.list.size();
    }

    @Override // kotlin.i0.a, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] r1 = this.list.toArray(new Object[0]);
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new b0("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
