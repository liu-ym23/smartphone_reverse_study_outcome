package com.squareup.wire;

import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    public EnumAdapter(Class<E> r2) {
        super(FieldEncoding.VARINT, r2);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
        return decode(r1);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) {
        encode(r1, (WireEnum) r2);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
        return encodedSize((WireEnum) r1);
    }

    public abstract E fromValue(int r1);

    @Override // com.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader r2) {
        int r3 = r2.readVarint32();
        E r0 = (E) fromValue(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r3, this.javaType);
    }

    public final void encode(ProtoWriter r1, E r2) {
        r1.writeVarint32(r2.getValue());
    }

    public final int encodedSize(E r1) {
        return ProtoWriter.varint32Size(r1.getValue());
    }
}
