package com.squareup.wire;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/squareup/wire/RepeatedProtoAdapter;", "E", "Lcom/squareup/wire/ProtoAdapter;", "", "value", "", "encodedSize", "(Ljava/util/List;)I", LocationMonitorConst.TAG, "encodedSizeWithTag", "(ILjava/util/List;)I", "Lcom/squareup/wire/ProtoWriter;", "writer", "Lkotlin/f0;", "encode", "(Lcom/squareup/wire/ProtoWriter;Ljava/util/List;)V", "encodeWithTag", "(Lcom/squareup/wire/ProtoWriter;ILjava/util/List;)V", "Lcom/squareup/wire/ProtoReader;", "reader", "decode", "(Lcom/squareup/wire/ProtoReader;)Ljava/util/List;", "redact", "(Ljava/util/List;)Ljava/util/List;", "originalAdapter", "Lcom/squareup/wire/ProtoAdapter;", "<init>", "(Lcom/squareup/wire/ProtoAdapter;)V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final class RepeatedProtoAdapter<E> extends ProtoAdapter<List<? extends E>> {
    private final ProtoAdapter<E> originalAdapter;

    public RepeatedProtoAdapter(ProtoAdapter<E> r3) {
        o.g(r3, "originalAdapter");
        super(r3.getFieldEncoding$wire_runtime(), e0.b(List.class));
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

    public void encode(ProtoWriter r1, List<? extends E> r2) {
        o.g(r1, "writer");
        o.g(r2, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter r1, int r2, Object r3) {
        encodeWithTag(r1, r2, (List) r3);
    }

    public void encodeWithTag(ProtoWriter r5, int r6, List<? extends E> r7) {
        o.g(r5, "writer");
        if (r7 != null) goto L5;
        return;
    L5:
        int r0 = 0;
        int r1 = r7.size();
    L6:
        if (r0 >= r1) goto L8;
        this.originalAdapter.encodeWithTag(r5, r6, r7.get(r0));
        r0 = r0 + 1;
        goto L6
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
        return encodedSize((List) r1);
    }

    public int encodedSize(List<? extends E> r1) {
        o.g(r1, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSizeWithTag(int r1, Object r2) {
        return encodedSizeWithTag(r1, (List) r2);
    }

    public int encodedSizeWithTag(int r6, List<? extends E> r7) {
        int r0 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        int r1 = r7.size();
        int r2 = 0;
    L6:
        if (r0 >= r1) goto L8;
        r2 = r2 + this.originalAdapter.encodedSizeWithTag(r6, r7.get(r0));
        r0 = r0 + 1;
        goto L6
    L8:
        return r2;
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
