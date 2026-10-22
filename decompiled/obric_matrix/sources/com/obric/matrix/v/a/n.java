package com.obric.matrix.v.a;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends Message<n, a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ProtoAdapter<n> f10162k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f10163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f10164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f10165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f10166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String f10167j;

    public static final class a extends Message.Builder<n, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f10171d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10172e;

        public a() {
        }

        public n a() {
            return new n(this.f10168a, this.f10169b, this.f10170c, this.f10171d, this.f10172e, super.buildUnknownFields());
        }

        public a b(String r1) {
            this.f10170c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.f10169b = r1;
            return this;
        }

        public a d(String r1) {
            this.f10172e = r1;
            return this;
        }

        public a e(Long r1) {
            this.f10171d = r1;
            return this;
        }

        public a f(Integer r1) {
            this.f10168a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<n> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, n.class);
        }

        public n a(ProtoReader r5) {
            a r4 = new a();
            long r0 = r5.beginMessage();
        L3:
            int r2 = r5.nextTag();
            if (r2 == (-1)) goto L21;
            if (r2 != 1) goto L8;
            r4.f(ProtoAdapter.INT32.decode(r5));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r4.c(ProtoAdapter.STRING.decode(r5));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r4.b(ProtoAdapter.STRING.decode(r5));
            goto L3
        L12:
            if (r2 != 4) goto L14;
            r4.e(ProtoAdapter.INT64.decode(r5));
            goto L3
        L14:
            if (r2 != 5) goto L15;
            r4.d(ProtoAdapter.STRING.decode(r5));
            goto L3
        L15:
            r5.readUnknownField(r2);
            goto L3
        L21:
            r4.addUnknownFields(r5.endMessageAndGetUnknownFields(r0));
            return r4.a();
        }

        public void b(ProtoWriter r4, n r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.f10163f);
            ProtoAdapter<String> r3 = ProtoAdapter.STRING;
            r3.encodeWithTag(r4, 2, r5.f10164g);
            r3.encodeWithTag(r4, 3, r5.f10165h);
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r5.f10166i);
            r3.encodeWithTag(r4, 5, r5.f10167j);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(n r5) {
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(1, r5.f10163f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            return ((((r4 + r0.encodedSizeWithTag(2, r5.f10164g)) + r0.encodedSizeWithTag(3, r5.f10165h)) + ProtoAdapter.INT64.encodedSizeWithTag(4, r5.f10166i)) + r0.encodedSizeWithTag(5, r5.f10167j)) + r5.unknownFields().size();
        }

        public n d(n r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ n decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, n r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(n r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ n redact(n r1) {
            return d(r1);
        }
    }

    static {
        f10162k = new b();
    }

    public n(Integer r2, String r3, String r4, Long r5, String r6, k.h r7) {
        super(f10162k, r7);
        this.f10163f = r2;
        this.f10164g = r3;
        this.f10165h = r4;
        this.f10166i = r5;
        this.f10167j = r6;
    }

    public a b() {
        a r0 = new a();
        r0.f10168a = this.f10163f;
        r0.f10169b = this.f10164g;
        r0.f10170c = this.f10165h;
        r0.f10171d = this.f10166i;
        r0.f10172e = this.f10167j;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L22;
        if (Internal.equals(this.f10163f, r6.f10163f) == false) goto L22;
        if (Internal.equals(this.f10164g, r6.f10164g) == false) goto L22;
        if (Internal.equals(this.f10165h, r6.f10165h) == false) goto L22;
        if (Internal.equals(this.f10166i, r6.f10166i) == false) goto L22;
        if (Internal.equals(this.f10167j, r6.f10167j) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10163f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10164g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10165h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.f10166i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.f10167j;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = r14 + r3;
        this.hashCode = r16;
        return r16;
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L25:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10163f == null) goto L6;
        r0.append(", version=");
        r0.append(this.f10163f);
    L6:
        if (this.f10164g == null) goto L9;
        r0.append(", env=");
        r0.append(this.f10164g);
    L9:
        if (this.f10165h == null) goto L12;
        r0.append(", did=");
        r0.append(this.f10165h);
    L12:
        if (this.f10166i == null) goto L15;
        r0.append(", session_id=");
        r0.append(this.f10166i);
    L15:
        if (this.f10167j == null) goto L17;
        r0.append(", receipt_list_id=");
        r0.append(this.f10167j);
    L17:
        StringBuilder r3 = r0.replace(0, 2, "ReceiptListAck{");
        r3.append('}');
        return r3.toString();
    }
}
