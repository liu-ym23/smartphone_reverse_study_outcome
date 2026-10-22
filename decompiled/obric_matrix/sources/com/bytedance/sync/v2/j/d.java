package com.bytedance.sync.v2.j;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Message<d, a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ProtoAdapter<d> f6060j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 1)
    public final Integer f6061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.ConsumeType#ADAPTER", tag = 2)
    public final h f6062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f6063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 4)
    public final k.h f6064i;

    public static final class a extends Message.Builder<d, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f6065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f6066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public k.h f6068d;

        public a() {
        }

        public d a() {
            Integer r0 = this.f6065a;
            if (r0 == null) goto L7;
            return new d(this.f6065a, this.f6066b, this.f6067c, this.f6068d, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "business"});
        }

        public a b(Integer r1) {
            this.f6065a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(h r1) {
            this.f6066b = r1;
            return this;
        }

        public a d(k.h r1) {
            this.f6068d = r1;
            return this;
        }

        public a e(String r1) {
            this.f6067c = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<d> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, d.class);
        }

        public d a(ProtoReader r8) {
            a r7 = new a();
            long r0 = r8.beginMessage();
        L3:
            int r2 = r8.nextTag();
            if (r2 == (-1)) goto L21;
            if (r2 != 1) goto L8;
            r7.b(ProtoAdapter.INT32.decode(r8));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r7.c(h.f6098i.decode(r8));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r7.addUnknownField(r2, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r7.e(ProtoAdapter.STRING.decode(r8));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r7.d(ProtoAdapter.BYTES.decode(r8));
            goto L3
        L13:
            FieldEncoding r3 = r8.peekFieldEncoding();
            r7.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r8));
            goto L3
        L21:
            r8.endMessage(r0);
            return r7.a();
        }

        public void b(ProtoWriter r3, d r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.f6061f);
            h.f6098i.encodeWithTag(r3, 2, r4.f6062g);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.f6063h);
            ProtoAdapter.BYTES.encodeWithTag(r3, 4, r4.f6064i);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(d r4) {
            return (((ProtoAdapter.INT32.encodedSizeWithTag(1, r4.f6061f) + h.f6098i.encodedSizeWithTag(2, r4.f6062g)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.f6063h)) + ProtoAdapter.BYTES.encodedSizeWithTag(4, r4.f6064i)) + r4.unknownFields().size();
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
        f6060j = new b();
        h r0 = h.f6096g;
        k.h r1 = k.h.f18266i;
    }

    public d(Integer r2, h r3, String r4, k.h r5, k.h r6) {
        super(f6060j, r6);
        this.f6061f = r2;
        this.f6062g = r3;
        this.f6063h = r4;
        this.f6064i = r5;
    }

    public a b() {
        a r0 = new a();
        r0.f6065a = this.f6061f;
        r0.f6066b = this.f6062g;
        r0.f6067c = this.f6063h;
        r0.f6068d = this.f6064i;
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
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (this.f6061f.equals(r6.f6061f) == false) goto L20;
        if (Internal.equals(this.f6062g, r6.f6062g) == false) goto L20;
        if (Internal.equals(this.f6063h, r6.f6063h) == false) goto L20;
        if (Internal.equals(this.f6064i, r6.f6064i) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = ((unknownFields().hashCode() * 37) + this.f6061f.hashCode()) * 37;
        h r2 = this.f6062g;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f6063h;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        k.h r9 = this.f6064i;
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
        r0.append(", business=");
        r0.append(this.f6061f);
        if (this.f6062g == null) goto L6;
        r0.append(", consume_type=");
        r0.append(this.f6062g);
    L6:
        if (this.f6063h == null) goto L9;
        r0.append(", md5=");
        r0.append(this.f6063h);
    L9:
        if (this.f6064i == null) goto L11;
        r0.append(", data=");
        r0.append(this.f6064i);
    L11:
        StringBuilder r3 = r0.replace(0, 2, "BsyncPayload{");
        r3.append('}');
        return r3.toString();
    }
}
