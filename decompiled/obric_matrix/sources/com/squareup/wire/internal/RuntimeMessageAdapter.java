package com.squareup.wire.internal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.a;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.s0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -*\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001*\u0014\b\u0001\u0010\u0004*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005:\u0001-BC\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000'\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'\u0012\u001e\u0010#\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"0!¢\u0006\u0004\b+\u0010,J\r\u0010\u0006\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R1\u0010#\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"0!8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010)¨\u0006."}, d2 = {"Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "Lcom/squareup/wire/Message;", "M", "Lcom/squareup/wire/Message$Builder;", "B", "Lcom/squareup/wire/ProtoAdapter;", "newBuilder", "()Lcom/squareup/wire/Message$Builder;", "value", "", "encodedSize", "(Lcom/squareup/wire/Message;)I", "Lcom/squareup/wire/ProtoWriter;", "writer", "Lkotlin/f0;", "encode", "(Lcom/squareup/wire/ProtoWriter;Lcom/squareup/wire/Message;)V", "redact", "(Lcom/squareup/wire/Message;)Lcom/squareup/wire/Message;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "(Lcom/squareup/wire/Message;)Ljava/lang/String;", "Lcom/squareup/wire/ProtoReader;", "reader", "decode", "(Lcom/squareup/wire/ProtoReader;)Lcom/squareup/wire/Message;", "", "Lcom/squareup/wire/internal/FieldBinding;", "fieldBindings", "Ljava/util/Map;", "getFieldBindings", "()Ljava/util/Map;", "Ljava/lang/Class;", "builderType", "Ljava/lang/Class;", "messageType", "<init>", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/util/Map;)V", "Companion", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends ProtoAdapter<M> {
    public static final Companion Companion = null;
    private static final String REDACTED = "██";
    private final Class<B> builderType;
    private final Map<Integer, FieldBinding<M, B>> fieldBindings;
    private final Class<M> messageType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011JO\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00030\u0006\"\u0014\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0002\"\u0014\b\u0003\u0010\u0005*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJU\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n\"\u0014\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0002\"\u0014\b\u0003\u0010\u0005*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/squareup/wire/internal/RuntimeMessageAdapter$Companion;", "", "Lcom/squareup/wire/Message;", "M", "Lcom/squareup/wire/Message$Builder;", "B", "Ljava/lang/Class;", "messageType", "getBuilderType", "(Ljava/lang/Class;)Ljava/lang/Class;", "Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "create", "(Ljava/lang/Class;)Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "", "REDACTED", "Ljava/lang/String;", "<init>", "()V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        private final <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> r3) {
            Class<B> r2 = (Class<B>) Class.forName(r3.getName() + "$Builder");
            if (r2 == null) goto L6;
            return r2;
        L6:
            throw new b0("null cannot be cast to non-null type java.lang.Class<B>");     // Catch: ClassNotFoundException -> L7
        L8:
            throw new IllegalArgumentException("No builder class found for message type " + r3.getName());
        }

        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> r10) {
            o.g(r10, "messageType");
            Class<B> r9 = getBuilderType(r10);
            LinkedHashMap r0 = new LinkedHashMap();
            Field[] r1 = r10.getDeclaredFields();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L8;
            Field r4 = r1[r3];
            WireField r5 = (WireField) r4.getAnnotation(WireField.class);
            if (r5 == null) goto L7;
            Integer r6 = Integer.valueOf(r5.tag());
            o.b(r4, "messageField");
            r0.put(r6, new FieldBinding(r5, r4, r9));
        L7:
            r3 = r3 + 1;
            goto L3
        L8:
            Map r7 = Collections.unmodifiableMap(r0);
            o.b(r7, "Collections.unmodifiableMap(fieldBindings)");
            return new RuntimeMessageAdapter(r10, r9, r7);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RuntimeMessageAdapter(Class<M> r3, Class<B> r4, Map<Integer, FieldBinding<M, B>> r5) {
        o.g(r3, "messageType");
        o.g(r4, "builderType");
        o.g(r5, "fieldBindings");
        super(FieldEncoding.LENGTH_DELIMITED, a.e(r3));
        this.messageType = r3;
        this.builderType = r4;
        this.fieldBindings = r5;
    }

    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> r1) {
        return Companion.create(r1);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M decode(ProtoReader r9) {
        o.g(r9, "reader");
        Message.Builder r0 = newBuilder();
        long r1 = r9.beginMessage();
    L3:
        int r3 = r9.nextTag();
        if (r3 == (-1)) goto L5;
        FieldBinding<M, B> r4 = this.fieldBindings.get(Integer.valueOf(r3));
        if (r4 == null) goto L18;
    L23:
        e = move-exception;
        r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
        goto L3
    L10:
        if (r4.isMap() == false) goto L12;
        ProtoAdapter<?> r6 = r4.adapter$wire_runtime();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
    L13:
        Object r7 = r6.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        if (r7 == null) goto L16;
        r4.value$wire_runtime(r0, r7);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        goto L3
    L16:
        o.p();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        throw null;
    L12:
        r6 = r4.singleAdapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        goto L13
    L18:
        FieldEncoding r5 = r9.peekFieldEncoding();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        if (r5 == null) goto L21;
        r0.addUnknownField(r3, r5, r5.rawProtoAdapter().decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        goto L3
    L21:
        o.p();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        throw null;
    L5:
        r9.endMessageAndGetUnknownFields(r1);
        return (M) r0.build();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
        return decode(r1);
    }

    public void encode(ProtoWriter r4, M r5) {
        o.g(r4, "writer");
        o.g(r5, "value");
        Iterator<FieldBinding<M, B>> r3 = this.fieldBindings.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        FieldBinding<M, B> r0 = r3.next();
        Object r1 = r0.get(r5);
        if (r1 == null) goto L4;
        r0.adapter$wire_runtime().encodeWithTag(r4, r0.getTag(), r1);
        goto L4
    L8:
        r4.writeBytes(r5.unknownFields());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) {
        encode(r1, (Message) r2);
    }

    public int encodedSize(M r5) {
        o.g(r5, "value");
        int r0 = r5.getCachedSerializedSize$wire_runtime();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = 0;
        Iterator<FieldBinding<M, B>> r4 = this.fieldBindings.values().iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        FieldBinding<M, B> r2 = r4.next();
        Object r3 = r2.get(r5);
        if (r3 == null) goto L7;
        r1 = r1 + r2.adapter$wire_runtime().encodedSizeWithTag(r2.getTag(), r3);
        goto L7
    L11:
        int r6 = r1 + r5.unknownFields().size();
        r5.setCachedSerializedSize$wire_runtime(r6);
        return r6;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
        return encodedSize((Message) r1);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof RuntimeMessageAdapter) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(((RuntimeMessageAdapter) r2).messageType, this.messageType) == false) goto L7;
        return true;
    }

    public final Map<Integer, FieldBinding<M, B>> getFieldBindings() {
        return this.fieldBindings;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    public final B newBuilder() {
        B r1 = this.builderType.newInstance();
        o.b(r1, "builderType.newInstance()");
        return r1;
    }

    public M redact(M r6) {
        o.g(r6, "value");
        Message.Builder r7 = r6.newBuilder();
        Iterator<FieldBinding<M, B>> r0 = this.fieldBindings.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L41;
        FieldBinding<M, B> r1 = r0.next();
        Class r3 = null;
        String r4 = null;
        r4 = null;
        if (r1.getRedacted() == true) goto L8;
    L16:
        d<?> r5 = r1.singleAdapter().getType();
        if (r5 == null) goto L19;
        r3 = a.c(r5);
    L19:
        boolean r2 = Message.class.isAssignableFrom(r3);
        if (r1.getRedacted() == true) goto L37;
        if (r2 == false) goto L25;
        if (r1.getLabel().isRepeated() == false) goto L37;
    L25:
        if (r2 == false) goto L4;
        if (r1.getLabel().isRepeated() == false) goto L4;
        Object r8 = r1.getFromBuilder$wire_runtime(r7);
        if (r8 == null) goto L36;
        List r9 = (List) r8;
        ProtoAdapter<?> r10 = r1.singleAdapter();
        if (r10 == null) goto L34;
        Object r11 = Internal.m68redactElements(r9, r10);
    L40:
        r1.set(r7, r11);
        goto L4
    L34:
        throw new b0("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    L36:
        throw new b0("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
    L37:
        Object r12 = r1.getFromBuilder$wire_runtime(r7);
        if (r12 == null) goto L4;
        r11 = r1.adapter$wire_runtime().redact(r12);
        goto L40
    L8:
        if (r1.getLabel() != WireField.Label.REQUIRED) goto L16;
        StringBuilder r13 = new StringBuilder();
        r13.append("Field '");
        r13.append(r1.getName());
        r13.append("' in ");
        d<?> r14 = getType();
        if (r14 == null) goto L14;
        Class r15 = a.c(r14);
        if (r15 == null) goto L14;
        r4 = r15.getName();
    L14:
        r13.append(r4);
        r13.append(" is required and ");
        r13.append("cannot be redacted.");
        throw new UnsupportedOperationException(r13.toString());
    L41:
        r7.clearUnknownFields();
        return (M) r7.build();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object r1) {
        return redact((Message) r1);
    }

    public String toString(M r6) {
        o.g(r6, "value");
        StringBuilder r0 = new StringBuilder();
        Iterator<FieldBinding<M, B>> r1 = this.fieldBindings.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        FieldBinding<M, B> r2 = r1.next();
        Object r3 = r2.get(r6);
        if (r3 == null) goto L4;
        r0.append(", ");
        r0.append(r2.getName());
        r0.append('=');
        if (r2.getRedacted() == false) goto L10;
        r3 = REDACTED;
    L10:
        r0.append(r3);
        goto L4
    L11:
        r0.replace(0, 2, this.messageType.getSimpleName() + '{');
        String r5 = r0.toString();
        o.b(r5, "StringBuilder().apply(builderAction).toString()");
        return r5;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ String toString(Object r1) {
        return toString((Message) r1);
    }
}
