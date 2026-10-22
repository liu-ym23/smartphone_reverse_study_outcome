package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends Message<x, a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ProtoAdapter<x> f10581h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    @com.google.gson.y.c("longitude")
    public final Double f10582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    @com.google.gson.y.c("latitude")
    public final Double f10583g;

    public static final class a extends Message.Builder<x, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f10584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f10585b;

        public a() {
            Double r0 = Double.valueOf(0.0d);
            this.f10584a = r0;
            this.f10585b = r0;
        }

        public x a() {
            return new x(this.f10584a, this.f10585b, super.buildUnknownFields());
        }

        public a b(Double r1) {
            this.f10585b = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Double r1) {
            this.f10584a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<x> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, x.class);
        }

        public x a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.c(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.b(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, x r4) {
            ProtoAdapter<Double> r2 = ProtoAdapter.DOUBLE;
            r2.encodeWithTag(r3, 1, r4.f10582f);
            r2.encodeWithTag(r3, 2, r4.f10583g);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(x r4) {
            ProtoAdapter<Double> r3 = ProtoAdapter.DOUBLE;
            return (r3.encodedSizeWithTag(1, r4.f10582f) + r3.encodedSizeWithTag(2, r4.f10583g)) + r4.unknownFields().size();
        }

        public x d(x r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ x decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, x r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(x r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ x redact(x r1) {
            return d(r1);
        }
    }

    static {
        f10581h = new b();
    }

    public x(Double r2, Double r3, k.h r4) {
        super(f10581h, r4);
        this.f10582f = r2;
        this.f10583g = r3;
    }

    public a b() {
        a r0 = new a();
        r0.f10584a = this.f10582f;
        r0.f10585b = this.f10583g;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f10582f, r6.f10582f) == false) goto L16;
        if (Internal.equals(this.f10583g, r6.f10583g) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Double r2 = this.f10582f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.f10583g;
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
        if (this.f10582f == null) goto L6;
        r0.append(", longitude=");
        r0.append(this.f10582f);
    L6:
        if (this.f10583g == null) goto L8;
        r0.append(", latitude=");
        r0.append(this.f10583g);
    L8:
        StringBuilder r3 = r0.replace(0, 2, "Point{");
        r3.append('}');
        return r3.toString();
    }
}
