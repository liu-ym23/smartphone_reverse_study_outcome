package com.squareup.wire;

import com.squareup.wire.WireEnum;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    protected abstract E fromValue(int r1);

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) throws IOException {
        return decode(r1);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
        encode(r1, (WireEnum) r2);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
        return encodedSize((WireEnum) r1);
    }

    protected EnumAdapter(Class<E> r2) {
        super(FieldEncoding.VARINT, r2);
    }

    public final int encodedSize(E r1) {
        return ProtoWriter.varint32Size(r1.getValue());
    }

    public final void encode(ProtoWriter r1, E r2) throws IOException {
        r1.writeVarint32(r2.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader r2) throws IOException {
        int r3 = r2.readVarint32();
        E r0 = (E) fromValue(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r3, this.javaType);
    }
}
