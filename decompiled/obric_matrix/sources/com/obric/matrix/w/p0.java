package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 extends Message<p0, a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ProtoAdapter<p0> f10472g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    @com.google.gson.y.c("_value")
    public final List<String> f10473f;

    public static final class a extends Message.Builder<p0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f10474a;

        public a() {
            this.f10474a = Internal.newMutableList();
        }

        public p0 a() {
            return new p0(this.f10474a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<p0> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, p0.class);
        }

        public p0 a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.f10474a.add(ProtoAdapter.STRING.decode(r6));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, p0 r4) {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r3, 1, r4.f10473f);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(p0 r3) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r3.f10473f) + r3.unknownFields().size();
        }

        public p0 d(p0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ p0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, p0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(p0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ p0 redact(p0 r1) {
            return d(r1);
        }
    }

    static {
        f10472g = new b();
    }

    public p0(List<String> r2, k.h r3) {
        super(f10472g, r3);
        this.f10473f = Internal.immutableCopyOf("_value", r2);
    }

    public a b() {
        a r0 = new a();
        r0.f10474a = Internal.copyOf("_value", this.f10473f);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r6 = (p0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f10473f.equals(r6.f10473f) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f10473f.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<String> r1 = this.f10473f;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r3 = r0.replace(0, 2, "StringArray{");
        r3.append('}');
        return r3.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", _value=");
        r0.append(this.f10473f);
        goto L7
    }
}
