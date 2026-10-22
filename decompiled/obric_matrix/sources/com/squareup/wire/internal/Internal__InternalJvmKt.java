package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a3\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"T", "Ljava/util/List;", "list", "Lcom/squareup/wire/ProtoAdapter;", "adapter", "Lkotlin/f0;", "redactElements", "(Ljava/util/List;Lcom/squareup/wire/ProtoAdapter;)V", "Ljava/util/Map;", "map", "(Ljava/util/Map;Lcom/squareup/wire/ProtoAdapter;)V", "wire-runtime"}, k = 5, mv = {1, 1, 15}, xs = "com/squareup/wire/internal/Internal")
final /* synthetic */ class Internal__InternalJvmKt {
    public static final <T> void redactElements(List<T> r3, ProtoAdapter<T> r4) {
        o.g(r3, "list");
        o.g(r4, "adapter");
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3.set(r1, r4.redact(r3.get(r1)));
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void redactElements(Map<?, T> r2, ProtoAdapter<T> r3) {
        o.g(r2, "map");
        o.g(r3, "adapter");
        Iterator<Map.Entry<?, T>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r0 = r4.next();
        r0.setValue(r3.redact(r0.getValue()));
        goto L4
    }
}
