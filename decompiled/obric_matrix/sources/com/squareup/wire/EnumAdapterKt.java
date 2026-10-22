package com.squareup.wire;

import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\t\u0010\n\u001aB\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\r\u001a\u00020\f2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000eH\u0080\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\"\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/squareup/wire/WireEnum;", "E", "value", "", "commonEncodedSize", "(Lcom/squareup/wire/WireEnum;)I", "Lcom/squareup/wire/ProtoWriter;", "writer", "Lkotlin/f0;", "commonEncode", "(Lcom/squareup/wire/ProtoWriter;Lcom/squareup/wire/WireEnum;)V", "Lcom/squareup/wire/EnumAdapter;", "Lcom/squareup/wire/ProtoReader;", "reader", "Lkotlin/Function1;", "fromValue", "commonDecode", "(Lcom/squareup/wire/EnumAdapter;Lcom/squareup/wire/ProtoReader;Lkotlin/n0/c/l;)Lcom/squareup/wire/WireEnum;", "commonRedact", "(Lcom/squareup/wire/WireEnum;)Lcom/squareup/wire/WireEnum;", "wire-runtime"}, k = 2, mv = {1, 1, 15})
public final class EnumAdapterKt {
    public static final <E extends WireEnum> E commonDecode(EnumAdapter<E> r1, ProtoReader r2, l<? super Integer, ? extends E> r3) {
        o.g(r1, "$this$commonDecode");
        o.g(r2, "reader");
        o.g(r3, "fromValue");
        int r4 = r2.readVarint32();
        E r5 = r3.invoke(Integer.valueOf(r4));
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r4, r1.getType());
    }

    public static final <E extends WireEnum> void commonEncode(ProtoWriter r1, E r2) {
        o.g(r1, "writer");
        o.g(r2, "value");
        r1.writeVarint32(r2.getValue());
    }

    public static final <E extends WireEnum> int commonEncodedSize(E r1) {
        o.g(r1, "value");
        return ProtoWriter.Companion.varint32Size$wire_runtime(r1.getValue());
    }

    public static final <E extends WireEnum> E commonRedact(E r1) {
        o.g(r1, "value");
        throw new UnsupportedOperationException();
    }
}
