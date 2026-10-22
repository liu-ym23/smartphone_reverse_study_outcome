package com.squareup.wire;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.internal.RuntimeMessageAdapter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import k.e;
import k.f;
import k.h;
import k.q;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.a;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.s0.d;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 G*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002GHB\u001d\u0012\u0006\u00108\u001a\u000207\u0012\f\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010>¢\u0006\u0004\bC\u0010DB\u001d\b\u0016\u0012\u0006\u00108\u001a\u000207\u0012\n\u0010?\u001a\u0006\u0012\u0002\b\u00030E¢\u0006\u0004\bC\u0010FJ\u0017\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0015J\u0015\u0010\u000f\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0017J\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u001aJ\u0017\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010 J\u0015\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020!¢\u0006\u0004\b\u001d\u0010\"J\u0015\u0010\u001d\u001a\u00028\u00002\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b\u001d\u0010%J\u0015\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020&¢\u0006\u0004\b\u001d\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010*J\u001b\u0010/\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0004\b-\u0010.J\u0019\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000\u0000¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000\u0000¢\u0006\u0004\b3\u00102R*\u00104\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000000\u0018\u00010\u00008\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00102R\u001c\u00108\u001a\u0002078\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R*\u0010<\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000000\u0018\u00010\u00008\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u00105\u001a\u0004\b=\u00102R\u001f\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006I"}, d2 = {"Lcom/squareup/wire/ProtoAdapter;", "E", "", "value", "redact", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "encodedSize", "(Ljava/lang/Object;)I", LocationMonitorConst.TAG, "encodedSizeWithTag", "(ILjava/lang/Object;)I", "Lcom/squareup/wire/ProtoWriter;", "writer", "Lkotlin/f0;", "encode", "(Lcom/squareup/wire/ProtoWriter;Ljava/lang/Object;)V", "encodeWithTag", "(Lcom/squareup/wire/ProtoWriter;ILjava/lang/Object;)V", "Lk/f;", "sink", "(Lk/f;Ljava/lang/Object;)V", "", "(Ljava/lang/Object;)[B", "Ljava/io/OutputStream;", "stream", "(Ljava/io/OutputStream;Ljava/lang/Object;)V", "Lcom/squareup/wire/ProtoReader;", "reader", "decode", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Object;", "bytes", "([B)Ljava/lang/Object;", "Lk/h;", "(Lk/h;)Ljava/lang/Object;", "Lk/g;", "source", "(Lk/g;)Ljava/lang/Object;", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)Ljava/lang/Object;", "", "toString", "(Ljava/lang/Object;)Ljava/lang/String;", "Lcom/squareup/wire/WireField$Label;", "label", "withLabel$wire_runtime", "(Lcom/squareup/wire/WireField$Label;)Lcom/squareup/wire/ProtoAdapter;", "withLabel", "", "asPacked", "()Lcom/squareup/wire/ProtoAdapter;", "asRepeated", "packedAdapter", "Lcom/squareup/wire/ProtoAdapter;", "getPackedAdapter$wire_runtime", "Lcom/squareup/wire/FieldEncoding;", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "getFieldEncoding$wire_runtime", "()Lcom/squareup/wire/FieldEncoding;", "repeatedAdapter", "getRepeatedAdapter$wire_runtime", "Lkotlin/s0/d;", WsConstants.KEY_CONNECTION_TYPE, "Lkotlin/s0/d;", "getType", "()Lkotlin/s0/d;", "<init>", "(Lcom/squareup/wire/FieldEncoding;Lkotlin/s0/d;)V", "Ljava/lang/Class;", "(Lcom/squareup/wire/FieldEncoding;Ljava/lang/Class;)V", "Companion", "EnumConstantNotFoundException", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL = null;
    public static final ProtoAdapter<h> BYTES = null;
    public static final Companion Companion = null;
    public static final ProtoAdapter<Double> DOUBLE = null;
    public static final ProtoAdapter<Integer> FIXED32 = null;
    public static final ProtoAdapter<Long> FIXED64 = null;
    public static final ProtoAdapter<Float> FLOAT = null;
    public static final ProtoAdapter<Integer> INT32 = null;
    public static final ProtoAdapter<Long> INT64 = null;
    public static final ProtoAdapter<Integer> SFIXED32 = null;
    public static final ProtoAdapter<Long> SFIXED64 = null;
    public static final ProtoAdapter<Integer> SINT32 = null;
    public static final ProtoAdapter<Long> SINT64 = null;
    public static final ProtoAdapter<String> STRING = null;
    public static final ProtoAdapter<Integer> UINT32 = null;
    public static final ProtoAdapter<Long> UINT64 = null;
    private final FieldEncoding fieldEncoding;
    private final ProtoAdapter<List<E>> packedAdapter;
    private final ProtoAdapter<List<E>> repeatedAdapter;
    private final d<?> type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b3\u00104JI\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00070\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJO\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0014\b\u0001\u0010\u000b*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n\"\u0014\b\u0002\u0010\r*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014\"\b\b\u0001\u0010\u0013*\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0010\b\u0001\u0010\u000b*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n2\u0006\u0010\u0017\u001a\u00028\u0001H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0011J\u001b\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u0018\u0010\u001cR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001fR\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020$0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b*\u0010\u001fR\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020&0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001fR\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020$0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001fR\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020$0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b.\u0010\u001fR\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020&0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b/\u0010\u001fR\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u0010\u001fR\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020$0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b1\u0010\u001fR\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020&0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u0010\u001f¨\u00065"}, d2 = {"Lcom/squareup/wire/ProtoAdapter$Companion;", "", "K", "V", "Lcom/squareup/wire/ProtoAdapter;", "keyAdapter", "valueAdapter", "", "newMapAdapter", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)Lcom/squareup/wire/ProtoAdapter;", "Lcom/squareup/wire/Message;", "M", "Lcom/squareup/wire/Message$Builder;", "B", "Ljava/lang/Class;", WsConstants.KEY_CONNECTION_TYPE, "newMessageAdapter", "(Ljava/lang/Class;)Lcom/squareup/wire/ProtoAdapter;", "Lcom/squareup/wire/WireEnum;", "E", "Lcom/squareup/wire/EnumAdapter;", "newEnumAdapter", "(Ljava/lang/Class;)Lcom/squareup/wire/EnumAdapter;", "message", "get", "(Lcom/squareup/wire/Message;)Lcom/squareup/wire/ProtoAdapter;", "", "adapterString", "(Ljava/lang/String;)Lcom/squareup/wire/ProtoAdapter;", "", "BOOL", "Lcom/squareup/wire/ProtoAdapter;", "Lk/h;", "BYTES", "", "DOUBLE", "", "FIXED32", "", "FIXED64", "", "FLOAT", "INT32", "INT64", "SFIXED32", "SFIXED64", "SINT32", "SINT64", "STRING", "UINT32", "UINT64", "<init>", "()V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final <M extends Message<?, ?>> ProtoAdapter<M> get(M r2) {
            o.g(r2, "message");
            return get(r2.getClass());
        }

        public final <M> ProtoAdapter<M> get(Class<M> r5) {
            o.g(r5, WsConstants.KEY_CONNECTION_TYPE);
            Object r1 = r5.getField("ADAPTER").get(null);     // Catch: NoSuchFieldException -> L9 IllegalAccessException -> L12
            if (r1 == null) goto L8;
            return (ProtoAdapter) r1;
        L8:
            throw new b0("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<M>");     // Catch: NoSuchFieldException -> L9 IllegalAccessException -> L12
        L12:
            e = move-exception;
            throw new IllegalArgumentException("failed to access " + r5.getName() + "#ADAPTER", e);
        L9:
            e = move-exception;
            throw new IllegalArgumentException("failed to access " + r5.getName() + "#ADAPTER", e);
        }

        public final ProtoAdapter<?> get(String r8) {
            o.g(r8, "adapterString");
            int r0 = k.P(r8, '#', 0, false, 6, null);     // Catch: ClassNotFoundException -> L9 NoSuchFieldException -> L12 IllegalAccessException -> L15
            String r1 = r8.substring(0, r0);     // Catch: ClassNotFoundException -> L9 NoSuchFieldException -> L12 IllegalAccessException -> L15
            o.b(r1, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: ClassNotFoundException -> L9 NoSuchFieldException -> L12 IllegalAccessException -> L15
            String r2 = r8.substring(r0 + 1);     // Catch: ClassNotFoundException -> L9 NoSuchFieldException -> L12 IllegalAccessException -> L15
            o.b(r2, "(this as java.lang.String).substring(startIndex)");     // Catch: ClassNotFoundException -> L9 NoSuchFieldException -> L12 IllegalAccessException -> L15
            Object r3 = Class.forName(r1).getField(r2).get(null);     // Catch: ClassNotFoundException -> L9 NoSuchFieldException -> L12 IllegalAccessException -> L15
            if (r3 == null) goto L8;
            return (ProtoAdapter) r3;
        L8:
            throw new b0("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");     // Catch: ClassNotFoundException -> L9 NoSuchFieldException -> L12 IllegalAccessException -> L15
        L9:
            e = move-exception;
            throw new IllegalArgumentException("failed to access " + r8, e);
        L15:
            e = move-exception;
            throw new IllegalArgumentException("failed to access " + r8, e);
        L12:
            e = move-exception;
            throw new IllegalArgumentException("failed to access " + r8, e);
        }

        public final <E extends WireEnum> EnumAdapter<E> newEnumAdapter(Class<E> r1) {
            o.g(r1, WsConstants.KEY_CONNECTION_TYPE);
            return new RuntimeEnumAdapter(r1);
        }

        public final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> r1, ProtoAdapter<V> r2) {
            o.g(r1, "keyAdapter");
            o.g(r2, "valueAdapter");
            return new MapProtoAdapter(r1, r2);
        }

        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> r1) {
            o.g(r1, WsConstants.KEY_CONNECTION_TYPE);
            return RuntimeMessageAdapter.Companion.create(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\b\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/squareup/wire/ProtoAdapter$EnumConstantNotFoundException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "", "value", "I", "Lkotlin/s0/d;", WsConstants.KEY_CONNECTION_TYPE, "<init>", "(ILkotlin/s0/d;)V", "Ljava/lang/Class;", "(ILjava/lang/Class;)V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        public EnumConstantNotFoundException(int r2, Class<?> r3) {
            o.g(r3, WsConstants.KEY_CONNECTION_TYPE);
            this(r2, a.e(r3));
        }

        public EnumConstantNotFoundException(int r3, d<?> r4) {
            StringBuilder r0 = new StringBuilder();
            r0.append("Unknown enum tag ");
            r0.append(r3);
            r0.append(" for ");
            if (r4 == null) goto L7;
            Class r5 = a.b(r4);
            if (r5 == null) goto L7;
            String r6 = r5.getName();
        L8:
            r0.append(r6);
            super(r0.toString());
            this.value = r3;
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    static {
        Companion = new Companion(null);
        BOOL = ProtoAdapterKt.commonBool();
        INT32 = ProtoAdapterKt.commonInt32();
        UINT32 = ProtoAdapterKt.commonUint32();
        SINT32 = ProtoAdapterKt.commonSint32();
        FIXED32 = ProtoAdapterKt.commonFixed32();
        SFIXED32 = ProtoAdapterKt.commonSfixed32();
        INT64 = ProtoAdapterKt.commonInt64();
        UINT64 = ProtoAdapterKt.commonUint64();
        SINT64 = ProtoAdapterKt.commonSint64();
        FIXED64 = ProtoAdapterKt.commonFixed64();
        SFIXED64 = ProtoAdapterKt.commonSfixed64();
        FLOAT = ProtoAdapterKt.commonFloat();
        DOUBLE = ProtoAdapterKt.commonDouble();
        BYTES = ProtoAdapterKt.commonBytes();
        STRING = ProtoAdapterKt.commonString();
    }

    public ProtoAdapter(FieldEncoding r2, Class<?> r3) {
        o.g(r2, "fieldEncoding");
        o.g(r3, WsConstants.KEY_CONNECTION_TYPE);
        this(r2, a.e(r3));
    }

    public ProtoAdapter(FieldEncoding r3, d<?> r4) {
        o.g(r3, "fieldEncoding");
        this.fieldEncoding = r3;
        this.type = r4;
        boolean r5 = this instanceof PackedProtoAdapter;
        RepeatedProtoAdapter r0 = null;
        if (r5 == false) goto L5;
    L18:
        PackedProtoAdapter r6 = null;
    L19:
        this.packedAdapter = r6;
        if ((this instanceof RepeatedProtoAdapter) == true) goto L24;
        if (r5 == true) goto L24;
        r0 = new RepeatedProtoAdapter(this);
    L24:
        this.repeatedAdapter = r0;
        return;
    L5:
        if ((this instanceof RepeatedProtoAdapter) == true) goto L18;
        FieldEncoding r1 = FieldEncoding.LENGTH_DELIMITED;
        if (r3 == r1) goto L18;
        if (getFieldEncoding$wire_runtime() == r1) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L17;
        r6 = new PackedProtoAdapter(this);
        goto L19
    L17:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    L13:
        r7 = false;
        goto L14
    }

    public static final <M extends Message<?, ?>> ProtoAdapter<M> get(M r1) {
        return Companion.get(r1);
    }

    public static final <M> ProtoAdapter<M> get(Class<M> r1) {
        return Companion.get(r1);
    }

    public static final ProtoAdapter<?> get(String r1) {
        return Companion.get(r1);
    }

    public static final <E extends WireEnum> EnumAdapter<E> newEnumAdapter(Class<E> r1) {
        return Companion.newEnumAdapter(r1);
    }

    public static final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> r1, ProtoAdapter<V> r2) {
        return Companion.newMapAdapter(r1, r2);
    }

    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> r1) {
        return Companion.newMessageAdapter(r1);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        ProtoAdapter<List<E>> r2 = this.packedAdapter;
        if (r2 == null) goto L11;
        return r2;
    L11:
        throw new UnsupportedOperationException("Can't create a packed adapter from a packed or repeated adapter.");
    L13:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> r1 = this.repeatedAdapter;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new UnsupportedOperationException("Can't create a repeated adapter from a repeated or packed adapter.");
    }

    public abstract E decode(ProtoReader r1);

    public final E decode(InputStream r2) {
        o.g(r2, "stream");
        return decode(q.b(q.j(r2)));
    }

    public final E decode(k.g r2) {
        o.g(r2, "source");
        return decode(new ProtoReader(r2));
    }

    public final E decode(h r2) {
        o.g(r2, "bytes");
        e r0 = new e();
        r0.o0(r2);
        return decode(r0);
    }

    public final E decode(byte[] r2) {
        o.g(r2, "bytes");
        e r0 = new e();
        r0.p0(r2);
        return decode(r0);
    }

    public abstract void encode(ProtoWriter r1, E r2);

    public final void encode(OutputStream r2, E r3) {
        o.g(r2, "stream");
        f r4 = q.a(q.f(r2));
        encode(r4, r3);
        r4.o();
    }

    public final void encode(f r2, E r3) {
        o.g(r2, "sink");
        encode(new ProtoWriter(r2), r3);
    }

    public final byte[] encode(E r2) {
        e r0 = new e();
        encode(r0, r2);
        return r0.t();
    }

    public void encodeWithTag(ProtoWriter r2, int r3, E r4) {
        o.g(r2, "writer");
        if (r4 == null) goto L10;
        r2.writeTag(r3, getFieldEncoding$wire_runtime());
        if (getFieldEncoding$wire_runtime() != FieldEncoding.LENGTH_DELIMITED) goto L8;
        r2.writeVarint32(encodedSize(r4));
    L8:
        encode(r2, r4);
        return;
    }

    public abstract int encodedSize(E r1);

    public int encodedSizeWithTag(int r2, E r3) {
        if (r3 != null) goto L4;
        return 0;
    L4:
        int r4 = encodedSize(r3);
        if (getFieldEncoding$wire_runtime() != FieldEncoding.LENGTH_DELIMITED) goto L8;
        r4 = r4 + ProtoWriter.Companion.varint32Size$wire_runtime(r4);
    L8:
        return ProtoWriter.Companion.tagSize$wire_runtime(r2) + r4;
    }

    public final FieldEncoding getFieldEncoding$wire_runtime() {
        return this.fieldEncoding;
    }

    public final ProtoAdapter<List<E>> getPackedAdapter$wire_runtime() {
        return this.packedAdapter;
    }

    public final ProtoAdapter<List<E>> getRepeatedAdapter$wire_runtime() {
        return this.repeatedAdapter;
    }

    public final d<?> getType() {
        return this.type;
    }

    public abstract E redact(E r1);

    public String toString(E r1) {
        return String.valueOf(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ProtoAdapter<?> withLabel$wire_runtime(WireField.Label r2) {
        o.g(r2, "label");
        if (r2.isRepeated() == true) goto L5;
        return this;
    L5:
        if (r2.isPacked() == false) goto L8;
        return asPacked();
    L8:
        return asRepeated();
    }
}
