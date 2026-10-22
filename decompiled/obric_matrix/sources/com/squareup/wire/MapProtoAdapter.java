package com.squareup.wire;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003B%\b\u0000\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/squareup/wire/MapProtoAdapter;", "K", "V", "Lcom/squareup/wire/ProtoAdapter;", "", "value", "", "encodedSize", "(Ljava/util/Map;)I", LocationMonitorConst.TAG, "encodedSizeWithTag", "(ILjava/util/Map;)I", "Lcom/squareup/wire/ProtoWriter;", "writer", "Lkotlin/f0;", "encode", "(Lcom/squareup/wire/ProtoWriter;Ljava/util/Map;)V", "encodeWithTag", "(Lcom/squareup/wire/ProtoWriter;ILjava/util/Map;)V", "Lcom/squareup/wire/ProtoReader;", "reader", "decode", "(Lcom/squareup/wire/ProtoReader;)Ljava/util/Map;", "redact", "(Ljava/util/Map;)Ljava/util/Map;", "Lcom/squareup/wire/MapEntryProtoAdapter;", "entryAdapter", "Lcom/squareup/wire/MapEntryProtoAdapter;", "keyAdapter", "valueAdapter", "<init>", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, ? extends V>> {
    private final MapEntryProtoAdapter<K, V> entryAdapter;

    public MapProtoAdapter(ProtoAdapter<K> r3, ProtoAdapter<V> r4) {
        o.g(r3, "keyAdapter");
        o.g(r4, "valueAdapter");
        super(FieldEncoding.LENGTH_DELIMITED, e0.b(Map.class));
        this.entryAdapter = new MapEntryProtoAdapter(r3, r4);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
        return decode(r1);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map<K, V> decode(ProtoReader r8) {
        o.g(r8, "reader");
        long r0 = r8.beginMessage();
        K r2 = null;
        V r3 = null;
    L3:
        int r4 = r8.nextTag();
        boolean r6 = true;
        if (r4 == (-1)) goto L5;
        if (r4 != 1) goto L22;
        r2 = this.entryAdapter.getKeyAdapter$wire_runtime().decode(r8);
        goto L3
    L22:
        if (r4 != 2) goto L3;
        r3 = this.entryAdapter.getValueAdapter$wire_runtime().decode(r8);
        goto L3
    L5:
        r8.endMessageAndGetUnknownFields(r0);
        if (r2 == null) goto L8;
        boolean r9 = true;
    L9:
        if (r9 == false) goto L19;
        if (r3 != null) goto L13;
        r6 = false;
    L13:
        if (r6 == false) goto L17;
        return m0.e(a0.a(r2, r3));
    L17:
        throw new IllegalStateException("Map entry with null value".toString());
    L19:
        throw new IllegalStateException("Map entry with null key".toString());
    L8:
        r9 = false;
        goto L9
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) {
        encode(r1, (Map) r2);
    }

    public void encode(ProtoWriter r1, Map<K, ? extends V> r2) {
        o.g(r1, "writer");
        o.g(r2, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter r1, int r2, Object r3) {
        encodeWithTag(r1, r2, (Map) r3);
    }

    public void encodeWithTag(ProtoWriter r3, int r4, Map<K, ? extends V> r5) {
        o.g(r3, "writer");
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<K, ? extends V>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<K, ? extends V> r0 = r6.next();
        this.entryAdapter.encodeWithTag(r3, r4, r0);
        goto L7
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
        return encodedSize((Map) r1);
    }

    public int encodedSize(Map<K, ? extends V> r1) {
        o.g(r1, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSizeWithTag(int r1, Object r2) {
        return encodedSizeWithTag(r1, (Map) r2);
    }

    public int encodedSizeWithTag(int r4, Map<K, ? extends V> r5) {
        int r0 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<K, ? extends V>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<K, ? extends V> r1 = r6.next();
        r0 = r0 + this.entryAdapter.encodedSizeWithTag(r4, r1);
        goto L7
    L9:
        return r0;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object r1) {
        return redact((Map) r1);
    }

    public Map<K, V> redact(Map<K, ? extends V> r1) {
        o.g(r1, "value");
        return m0.h();
    }
}
