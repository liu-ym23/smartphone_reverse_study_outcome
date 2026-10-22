package com.squareup.wire;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/squareup/wire/PackedProtoAdapter;", "E", "Lcom/squareup/wire/ProtoAdapter;", "", "Lcom/squareup/wire/ProtoWriter;", "writer", "", LocationMonitorConst.TAG, "value", "Lkotlin/f0;", "encodeWithTag", "(Lcom/squareup/wire/ProtoWriter;ILjava/util/List;)V", "encodedSize", "(Ljava/util/List;)I", "encodedSizeWithTag", "(ILjava/util/List;)I", "encode", "(Lcom/squareup/wire/ProtoWriter;Ljava/util/List;)V", "Lcom/squareup/wire/ProtoReader;", "reader", "decode", "(Lcom/squareup/wire/ProtoReader;)Ljava/util/List;", "redact", "(Ljava/util/List;)Ljava/util/List;", "originalAdapter", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "(Lcom/squareup/wire/ProtoAdapter;)V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final class PackedProtoAdapter<E> extends ProtoAdapter<List<? extends E>> {
    private final ProtoAdapter<E> originalAdapter;

    public PackedProtoAdapter(ProtoAdapter<E> r3) {
        o.g(r3, "originalAdapter");
        super(FieldEncoding.LENGTH_DELIMITED, e0.b(List.class));
        this.originalAdapter = r3;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
        return decode(r1);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public List<E> decode(ProtoReader r2) {
        o.g(r2, "reader");
        return r.d(this.originalAdapter.decode(r2));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) {
        encode(r1, (List) r2);
    }

    public void encode(ProtoWriter r5, List<? extends E> r6) {
        o.g(r5, "writer");
        o.g(r6, "value");
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.originalAdapter.encode(r5, r6.get(r1));
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter r1, int r2, Object r3) {
        encodeWithTag(r1, r2, (List) r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void encodeWithTag(ProtoWriter r2, int r3, List<? extends E> r4) {
        o.g(r2, "writer");
        if (r4 != 0) goto L5;
        return;
    L5:
        if ((!r4.isEmpty()) == false) goto L9;
        super.encodeWithTag(r2, r3, r4);
        return;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
        return encodedSize((List) r1);
    }

    public int encodedSize(List<? extends E> r6) {
        o.g(r6, "value");
        int r0 = r6.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 + this.originalAdapter.encodedSize(r6.get(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSizeWithTag(int r1, Object r2) {
        return encodedSizeWithTag(r1, (List) r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int encodedSizeWithTag(int r2, List<? extends E> r3) {
        if (r3 != 0) goto L4;
    L7:
        return 0;
    L4:
        if (r3.isEmpty() == true) goto L7;
        return super.encodedSizeWithTag(r2, r3);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object r1) {
        return redact((List) r1);
    }

    public List<E> redact(List<? extends E> r1) {
        o.g(r1, "value");
        return r.g();
    }
}
