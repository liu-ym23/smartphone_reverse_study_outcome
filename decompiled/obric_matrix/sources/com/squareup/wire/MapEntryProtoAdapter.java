package com.squareup.wire;

import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003B%\b\u0000\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/squareup/wire/MapEntryProtoAdapter;", "K", "V", "Lcom/squareup/wire/ProtoAdapter;", "", "value", "", "encodedSize", "(Ljava/util/Map$Entry;)I", "Lcom/squareup/wire/ProtoWriter;", "writer", "Lkotlin/f0;", "encode", "(Lcom/squareup/wire/ProtoWriter;Ljava/util/Map$Entry;)V", "Lcom/squareup/wire/ProtoReader;", "reader", "decode", "(Lcom/squareup/wire/ProtoReader;)Ljava/util/Map$Entry;", "redact", "(Ljava/util/Map$Entry;)Ljava/util/Map$Entry;", "valueAdapter", "Lcom/squareup/wire/ProtoAdapter;", "getValueAdapter$wire_runtime", "()Lcom/squareup/wire/ProtoAdapter;", "keyAdapter", "getKeyAdapter$wire_runtime", "<init>", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<? extends K, ? extends V>> {
    private final ProtoAdapter<K> keyAdapter;
    private final ProtoAdapter<V> valueAdapter;

    public MapEntryProtoAdapter(ProtoAdapter<K> r3, ProtoAdapter<V> r4) {
        o.g(r3, "keyAdapter");
        o.g(r4, "valueAdapter");
        super(FieldEncoding.LENGTH_DELIMITED, e0.b(Map.Entry.class));
        this.keyAdapter = r3;
        this.valueAdapter = r4;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
        return decode(r1);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map.Entry<K, V> decode(ProtoReader r1) {
        o.g(r1, "reader");
        throw new UnsupportedOperationException();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) {
        encode(r1, (Map.Entry) r2);
    }

    public void encode(ProtoWriter r4, Map.Entry<? extends K, ? extends V> r5) {
        o.g(r4, "writer");
        o.g(r5, "value");
        this.keyAdapter.encodeWithTag(r4, 1, r5.getKey());
        this.valueAdapter.encodeWithTag(r4, 2, r5.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
        return encodedSize((Map.Entry) r1);
    }

    public int encodedSize(Map.Entry<? extends K, ? extends V> r4) {
        o.g(r4, "value");
        return this.keyAdapter.encodedSizeWithTag(1, r4.getKey()) + this.valueAdapter.encodedSizeWithTag(2, r4.getValue());
    }

    public final ProtoAdapter<K> getKeyAdapter$wire_runtime() {
        return this.keyAdapter;
    }

    public final ProtoAdapter<V> getValueAdapter$wire_runtime() {
        return this.valueAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object r1) {
        return redact((Map.Entry) r1);
    }

    public Map.Entry<K, V> redact(Map.Entry<? extends K, ? extends V> r1) {
        o.g(r1, "value");
        throw new UnsupportedOperationException();
    }
}
