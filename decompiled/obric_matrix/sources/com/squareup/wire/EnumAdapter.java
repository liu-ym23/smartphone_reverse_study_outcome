package com.squareup.wire;

import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.n0.a;
import kotlin.n0.d.o;
import kotlin.s0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\b\u0004\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0004\b\u0017\u0010\u0018B\u0017\b\u0016\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b\u0017\u0010\u001aJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0005H$¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/squareup/wire/EnumAdapter;", "Lcom/squareup/wire/WireEnum;", "E", "Lcom/squareup/wire/ProtoAdapter;", "value", "", "encodedSize", "(Lcom/squareup/wire/WireEnum;)I", "Lcom/squareup/wire/ProtoWriter;", "writer", "Lkotlin/f0;", "encode", "(Lcom/squareup/wire/ProtoWriter;Lcom/squareup/wire/WireEnum;)V", "Lcom/squareup/wire/ProtoReader;", "reader", "decode", "(Lcom/squareup/wire/ProtoReader;)Lcom/squareup/wire/WireEnum;", "redact", "(Lcom/squareup/wire/WireEnum;)Lcom/squareup/wire/WireEnum;", "fromValue", "(I)Lcom/squareup/wire/WireEnum;", "Lkotlin/s0/d;", WsConstants.KEY_CONNECTION_TYPE, "<init>", "(Lkotlin/s0/d;)V", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    public EnumAdapter(Class<E> r2) {
        o.g(r2, WsConstants.KEY_CONNECTION_TYPE);
        this(a.e(r2));
    }

    protected EnumAdapter(d<E> r2) {
        o.g(r2, WsConstants.KEY_CONNECTION_TYPE);
        super(FieldEncoding.VARINT, r2);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public E decode(ProtoReader r2) {
        o.g(r2, "reader");
        int r3 = r2.readVarint32();
        E r0 = (E) fromValue(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r3, getType());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
        return decode(r1);
    }

    public void encode(ProtoWriter r1, E r2) {
        o.g(r1, "writer");
        o.g(r2, "value");
        r1.writeVarint32(r2.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) {
        encode(r1, (WireEnum) r2);
    }

    public int encodedSize(E r1) {
        o.g(r1, "value");
        return ProtoWriter.Companion.varint32Size$wire_runtime(r1.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
        return encodedSize((WireEnum) r1);
    }

    protected abstract E fromValue(int r1);

    public E redact(E r1) {
        o.g(r1, "value");
        throw new UnsupportedOperationException();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object r1) {
        return redact((WireEnum) r1);
    }
}
