package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Message<c, a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ProtoAdapter<c> f10233h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", tag = 1)
    @com.google.gson.y.c("center")
    public final x f10234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    @com.google.gson.y.c("radius")
    public final Double f10235g;

    public static final class a extends Message.Builder<c, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x f10236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f10237b;

        public a() {
            this.f10237b = Double.valueOf(0.0d);
        }

        public c a() {
            return new c(this.f10236a, this.f10237b, super.buildUnknownFields());
        }

        public a b(x r1) {
            this.f10236a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Double r1) {
            this.f10237b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<c> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, c.class);
        }

        public c a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.b(x.f10581h.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.c(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, c r4) {
            x.f10581h.encodeWithTag(r3, 1, r4.f10234f);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.f10235g);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(c r4) {
            return (x.f10581h.encodedSizeWithTag(1, r4.f10234f) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.f10235g)) + r4.unknownFields().size();
        }

        public c d(c r2) {
            a r1 = r2.b();
            x r3 = r1.f10236a;
            if (r3 == null) goto L5;
            r1.f10236a = x.f10581h.redact(r3);
        L5:
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ c decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, c r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(c r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ c redact(c r1) {
            return d(r1);
        }
    }

    static {
        f10233h = new b();
    }

    public c(x r2, Double r3, k.h r4) {
        super(f10233h, r4);
        this.f10234f = r2;
        this.f10235g = r3;
    }

    public a b() {
        a r0 = new a();
        r0.f10236a = this.f10234f;
        r0.f10237b = this.f10235g;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f10234f, r6.f10234f) == false) goto L16;
        if (Internal.equals(this.f10235g, r6.f10235g) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        x r2 = this.f10234f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.f10235g;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        this.hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10234f == null) goto L6;
        r0.append(", center=");
        r0.append(this.f10234f);
    L6:
        if (this.f10235g == null) goto L8;
        r0.append(", radius=");
        r0.append(this.f10235g);
    L8:
        StringBuilder r3 = r0.replace(0, 2, "Circle{");
        r3.append('}');
        return r3.toString();
    }
}
