package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Message<d, a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ProtoAdapter<d> f10257i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @com.google.gson.y.c("packageName")
    public final String f10258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    @com.google.gson.y.c("longitude")
    public final Double f10259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 3)
    @com.google.gson.y.c("latitude")
    public final Double f10260h;

    public static final class a extends Message.Builder<d, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f10262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Double f10263c;

        public a() {
            this.f10261a = "";
            Double r0 = Double.valueOf(0.0d);
            this.f10262b = r0;
            this.f10263c = r0;
        }

        public d a() {
            return new d(this.f10261a, this.f10262b, this.f10263c, super.buildUnknownFields());
        }

        public a b(Double r1) {
            this.f10263c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Double r1) {
            this.f10262b = r1;
            return this;
        }

        public a d(String r1) {
            this.f10261a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<d> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, d.class);
        }

        public d a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            r5.d(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.c(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r5.b(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L15:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, d r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.f10258f);
            ProtoAdapter<Double> r2 = ProtoAdapter.DOUBLE;
            r2.encodeWithTag(r3, 2, r4.f10259g);
            r2.encodeWithTag(r3, 3, r4.f10260h);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(d r4) {
            int r3 = ProtoAdapter.STRING.encodedSizeWithTag(1, r4.f10258f);
            ProtoAdapter<Double> r0 = ProtoAdapter.DOUBLE;
            return ((r3 + r0.encodedSizeWithTag(2, r4.f10259g)) + r0.encodedSizeWithTag(3, r4.f10260h)) + r4.unknownFields().size();
        }

        public d d(d r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ d decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, d r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(d r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ d redact(d r1) {
            return d(r1);
        }
    }

    static {
        f10257i = new b();
    }

    public d(String r2, Double r3, Double r4, k.h r5) {
        super(f10257i, r5);
        this.f10258f = r2;
        this.f10259g = r3;
        this.f10260h = r4;
    }

    public a b() {
        a r0 = new a();
        r0.f10261a = this.f10258f;
        r0.f10262b = this.f10259g;
        r0.f10263c = this.f10260h;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (Internal.equals(this.f10258f, r6.f10258f) == false) goto L18;
        if (Internal.equals(this.f10259g, r6.f10259g) == false) goto L18;
        if (Internal.equals(this.f10260h, r6.f10260h) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f10258f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.f10259g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Double r9 = this.f10260h;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10258f == null) goto L6;
        r0.append(", packageName=");
        r0.append(this.f10258f);
    L6:
        if (this.f10259g == null) goto L9;
        r0.append(", longitude=");
        r0.append(this.f10259g);
    L9:
        if (this.f10260h == null) goto L11;
        r0.append(", latitude=");
        r0.append(this.f10260h);
    L11:
        StringBuilder r3 = r0.replace(0, 2, "DecodeLocationRequest{");
        r3.append('}');
        return r3.toString();
    }
}
