package com.squareup.wire;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
import java.util.Map;
import k.e;
import k.f;
import k.g;
import k.h;
import kotlin.Metadata;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.s0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\u001a2\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a:\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0080\b¢\u0006\u0004\b\n\u0010\u000b\u001a0\u0010\u000e\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a(\u0010\u000e\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u000e\u0010\u0011\u001a(\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0012\u001a\u00020\u0010H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a(\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0012\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0016\u001a(\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0019\u001a\u001e\u0010\u001b\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0004\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a,\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a,\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b\"\u0010#\u001a,\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b$\u0010#\u001aJ\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)0\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0080\b¢\u0006\u0004\b*\u0010+\u001a\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0001H\u0000¢\u0006\u0004\b-\u0010.\u001a\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b/\u0010.\u001a\u0015\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b0\u0010.\u001a\u0015\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b1\u0010.\u001a\u0015\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b2\u0010.\u001a\u0015\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b3\u0010.\u001a\u0015\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0001H\u0000¢\u0006\u0004\b5\u0010.\u001a\u0015\u00106\u001a\b\u0012\u0004\u0012\u0002040\u0001H\u0000¢\u0006\u0004\b6\u0010.\u001a\u0015\u00107\u001a\b\u0012\u0004\u0012\u0002040\u0001H\u0000¢\u0006\u0004\b7\u0010.\u001a\u0015\u00108\u001a\b\u0012\u0004\u0012\u0002040\u0001H\u0000¢\u0006\u0004\b8\u0010.\u001a\u0015\u00109\u001a\b\u0012\u0004\u0012\u0002040\u0001H\u0000¢\u0006\u0004\b9\u0010.\u001a\u0015\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u0001H\u0000¢\u0006\u0004\b;\u0010.\u001a\u0015\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u0001H\u0000¢\u0006\u0004\b=\u0010.\u001a\u0015\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0001H\u0000¢\u0006\u0004\b>\u0010.\u001a\u0015\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001H\u0000¢\u0006\u0004\b?\u0010.\"\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010A\"\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010A\"\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010A¨\u0006D"}, d2 = {"E", "Lcom/squareup/wire/ProtoAdapter;", "", LocationMonitorConst.TAG, "value", "commonEncodedSizeWithTag", "(Lcom/squareup/wire/ProtoAdapter;ILjava/lang/Object;)I", "Lcom/squareup/wire/ProtoWriter;", "writer", "Lkotlin/f0;", "commonEncodeWithTag", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoWriter;ILjava/lang/Object;)V", "Lk/f;", "sink", "commonEncode", "(Lcom/squareup/wire/ProtoAdapter;Lk/f;Ljava/lang/Object;)V", "", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)[B", "bytes", "commonDecode", "(Lcom/squareup/wire/ProtoAdapter;[B)Ljava/lang/Object;", "Lk/h;", "(Lcom/squareup/wire/ProtoAdapter;Lk/h;)Ljava/lang/Object;", "Lk/g;", "source", "(Lcom/squareup/wire/ProtoAdapter;Lk/g;)Ljava/lang/Object;", "", "commonToString", "(Ljava/lang/Object;)Ljava/lang/String;", "Lcom/squareup/wire/WireField$Label;", "label", "commonWithLabel", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/WireField$Label;)Lcom/squareup/wire/ProtoAdapter;", "", "commonCreatePacked", "(Lcom/squareup/wire/ProtoAdapter;)Lcom/squareup/wire/ProtoAdapter;", "commonCreateRepeated", "K", "V", "keyAdapter", "valueAdapter", "", "commonNewMapAdapter", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)Lcom/squareup/wire/ProtoAdapter;", "", "commonBool", "()Lcom/squareup/wire/ProtoAdapter;", "commonInt32", "commonUint32", "commonSint32", "commonFixed32", "commonSfixed32", "", "commonInt64", "commonUint64", "commonSint64", "commonFixed64", "commonSfixed64", "", "commonFloat", "", "commonDouble", "commonString", "commonBytes", "FIXED_32_SIZE", "I", "FIXED_64_SIZE", "FIXED_BOOL_SIZE", "wire-runtime"}, k = 2, mv = {1, 1, 15})
public final class ProtoAdapterKt {
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;

    public static final ProtoAdapter<Boolean> commonBool() {
        final FieldEncoding r1 = FieldEncoding.VARINT;
        final d r2 = e0.b(Boolean.TYPE);
        return new AnonymousClass1(r1, r2);
    }

    public static final ProtoAdapter<h> commonBytes() {
        final FieldEncoding r1 = FieldEncoding.LENGTH_DELIMITED;
        final d r2 = e0.b(h.class);
        return new C06421(r1, r2);
    }

    public static final <E> ProtoAdapter<List<E>> commonCreatePacked(ProtoAdapter<E> r2) {
        o.g(r2, "$this$commonCreatePacked");
        if (r2.getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return new PackedProtoAdapter(r2);
    L10:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final <E> ProtoAdapter<List<E>> commonCreateRepeated(ProtoAdapter<E> r1) {
        o.g(r1, "$this$commonCreateRepeated");
        return new RepeatedProtoAdapter(r1);
    }

    public static final <E> E commonDecode(ProtoAdapter<E> r1, g r2) {
        o.g(r1, "$this$commonDecode");
        o.g(r2, "source");
        return r1.decode(new ProtoReader(r2));
    }

    public static final <E> E commonDecode(ProtoAdapter<E> r1, h r2) {
        o.g(r1, "$this$commonDecode");
        o.g(r2, "bytes");
        e r0 = new e();
        r0.o0(r2);
        return r1.decode(r0);
    }

    public static final <E> E commonDecode(ProtoAdapter<E> r1, byte[] r2) {
        o.g(r1, "$this$commonDecode");
        o.g(r2, "bytes");
        e r0 = new e();
        r0.p0(r2);
        return r1.decode(r0);
    }

    public static final ProtoAdapter<Double> commonDouble() {
        final FieldEncoding r1 = FieldEncoding.FIXED64;
        final d r2 = e0.b(Double.TYPE);
        return new C06431(r1, r2);
    }

    public static final <E> void commonEncode(ProtoAdapter<E> r1, f r2, E r3) {
        o.g(r1, "$this$commonEncode");
        o.g(r2, "sink");
        r1.encode(new ProtoWriter(r2), r3);
    }

    public static final <E> byte[] commonEncode(ProtoAdapter<E> r1, E r2) {
        o.g(r1, "$this$commonEncode");
        e r0 = new e();
        r1.encode(r0, r2);
        return r0.t();
    }

    public static final <E> void commonEncodeWithTag(ProtoAdapter<E> r1, ProtoWriter r2, int r3, E r4) {
        o.g(r1, "$this$commonEncodeWithTag");
        o.g(r2, "writer");
        if (r4 != null) goto L5;
        return;
    L5:
        r2.writeTag(r3, r1.getFieldEncoding$wire_runtime());
        if (r1.getFieldEncoding$wire_runtime() != FieldEncoding.LENGTH_DELIMITED) goto L8;
        r2.writeVarint32(r1.encodedSize(r4));
    L8:
        r1.encode(r2, r4);
    }

    public static final <E> int commonEncodedSizeWithTag(ProtoAdapter<E> r1, int r2, E r3) {
        o.g(r1, "$this$commonEncodedSizeWithTag");
        if (r3 != null) goto L6;
        return 0;
    L6:
        int r4 = r1.encodedSize(r3);
        if (r1.getFieldEncoding$wire_runtime() != FieldEncoding.LENGTH_DELIMITED) goto L10;
        r4 = r4 + ProtoWriter.Companion.varint32Size$wire_runtime(r4);
    L10:
        return r4 + ProtoWriter.Companion.tagSize$wire_runtime(r2);
    }

    public static final ProtoAdapter<Integer> commonFixed32() {
        final FieldEncoding r1 = FieldEncoding.FIXED32;
        final d r2 = e0.b(Integer.TYPE);
        return new C06441(r1, r2);
    }

    public static final ProtoAdapter<Long> commonFixed64() {
        final FieldEncoding r1 = FieldEncoding.FIXED64;
        final d r2 = e0.b(Long.TYPE);
        return new C06451(r1, r2);
    }

    public static final ProtoAdapter<Float> commonFloat() {
        final FieldEncoding r1 = FieldEncoding.FIXED32;
        final d r2 = e0.b(Float.TYPE);
        return new C06461(r1, r2);
    }

    public static final ProtoAdapter<Integer> commonInt32() {
        final FieldEncoding r1 = FieldEncoding.VARINT;
        final d r2 = e0.b(Integer.TYPE);
        return new C06471(r1, r2);
    }

    public static final ProtoAdapter<Long> commonInt64() {
        final FieldEncoding r1 = FieldEncoding.VARINT;
        final d r2 = e0.b(Long.TYPE);
        return new C06481(r1, r2);
    }

    public static final <K, V> ProtoAdapter<Map<K, V>> commonNewMapAdapter(ProtoAdapter<K> r1, ProtoAdapter<V> r2) {
        o.g(r1, "keyAdapter");
        o.g(r2, "valueAdapter");
        return new MapProtoAdapter(r1, r2);
    }

    public static final ProtoAdapter<Integer> commonSfixed32() {
        return commonFixed32();
    }

    public static final ProtoAdapter<Long> commonSfixed64() {
        return commonFixed64();
    }

    public static final ProtoAdapter<Integer> commonSint32() {
        final FieldEncoding r1 = FieldEncoding.VARINT;
        final d r2 = e0.b(Integer.TYPE);
        return new C06491(r1, r2);
    }

    public static final ProtoAdapter<Long> commonSint64() {
        final FieldEncoding r1 = FieldEncoding.VARINT;
        final d r2 = e0.b(Long.TYPE);
        return new C06501(r1, r2);
    }

    public static final ProtoAdapter<String> commonString() {
        final FieldEncoding r1 = FieldEncoding.LENGTH_DELIMITED;
        final d r2 = e0.b(String.class);
        return new C06511(r1, r2);
    }

    public static final <E> String commonToString(E r0) {
        return String.valueOf(r0);
    }

    public static final ProtoAdapter<Integer> commonUint32() {
        final FieldEncoding r1 = FieldEncoding.VARINT;
        final d r2 = e0.b(Integer.TYPE);
        return new C06521(r1, r2);
    }

    public static final ProtoAdapter<Long> commonUint64() {
        final FieldEncoding r1 = FieldEncoding.VARINT;
        final d r2 = e0.b(Long.TYPE);
        return new C06531(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> ProtoAdapter<?> commonWithLabel(ProtoAdapter<E> r1, WireField.Label r2) {
        o.g(r1, "$this$commonWithLabel");
        o.g(r2, "label");
        if (r2.isRepeated() == true) goto L5;
        return r1;
    L5:
        if (r2.isPacked() == false) goto L8;
        return r1.asPacked();
    L8:
        return r1.asRepeated();
    }
}
