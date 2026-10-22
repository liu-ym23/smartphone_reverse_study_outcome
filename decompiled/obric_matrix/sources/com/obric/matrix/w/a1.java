package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 extends Message<a1, a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ProtoAdapter<a1> f10183j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @com.google.gson.y.c("name")
    public final String f10184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("appid")
    public final String f10185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @com.google.gson.y.c("appkey")
    public final String f10186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.NullableMap#ADAPTER", tag = 4)
    @com.google.gson.y.c("properties")
    public final t f10187i;

    public static final class a extends Message.Builder<a1, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10190c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public t f10191d;

        public a() {
            this.f10188a = "";
            this.f10189b = "";
            this.f10190c = "";
        }

        public a a(String r1) {
            this.f10189b = r1;
            return this;
        }

        public a b(String r1) {
            this.f10190c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public a1 c() {
            return new a1(this.f10188a, this.f10189b, this.f10190c, this.f10191d, super.buildUnknownFields());
        }

        public a d(String r1) {
            this.f10188a = r1;
            return this;
        }

        public a e(t r1) {
            this.f10191d = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<a1> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, a1.class);
        }

        public a1 a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.d(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.a(ProtoAdapter.STRING.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.b(ProtoAdapter.STRING.decode(r6));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.e(t.f10515g.decode(r6));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.c();
        }

        public void b(ProtoWriter r3, a1 r4) {
            ProtoAdapter<String> r2 = ProtoAdapter.STRING;
            r2.encodeWithTag(r3, 1, r4.f10184f);
            r2.encodeWithTag(r3, 2, r4.f10185g);
            r2.encodeWithTag(r3, 3, r4.f10186h);
            t.f10515g.encodeWithTag(r3, 4, r4.f10187i);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(a1 r4) {
            ProtoAdapter<String> r3 = ProtoAdapter.STRING;
            return (((r3.encodedSizeWithTag(1, r4.f10184f) + r3.encodedSizeWithTag(2, r4.f10185g)) + r3.encodedSizeWithTag(3, r4.f10186h)) + t.f10515g.encodedSizeWithTag(4, r4.f10187i)) + r4.unknownFields().size();
        }

        public a1 d(a1 r2) {
            a r1 = r2.b();
            t r3 = r1.f10191d;
            if (r3 == null) goto L5;
            r1.f10191d = t.f10515g.redact(r3);
        L5:
            r1.clearUnknownFields();
            return r1.c();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ a1 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, a1 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(a1 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ a1 redact(a1 r1) {
            return d(r1);
        }
    }

    static {
        f10183j = new b();
    }

    public a1(String r2, String r3, String r4, t r5, k.h r6) {
        super(f10183j, r6);
        this.f10184f = r2;
        this.f10185g = r3;
        this.f10186h = r4;
        this.f10187i = r5;
    }

    public a b() {
        a r0 = new a();
        r0.f10188a = this.f10184f;
        r0.f10189b = this.f10185g;
        r0.f10190c = this.f10186h;
        r0.f10191d = this.f10187i;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof a1) == true) goto L8;
        return false;
    L8:
        a1 r6 = (a1) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f10184f, r6.f10184f) == false) goto L20;
        if (Internal.equals(this.f10185g, r6.f10185g) == false) goto L20;
        if (Internal.equals(this.f10186h, r6.f10186h) == false) goto L20;
        if (Internal.equals(this.f10187i, r6.f10187i) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f10184f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10185g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10186h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        t r12 = this.f10187i;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        this.hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10184f == null) goto L6;
        r0.append(", name=");
        r0.append(this.f10184f);
    L6:
        if (this.f10185g == null) goto L9;
        r0.append(", appid=");
        r0.append(this.f10185g);
    L9:
        if (this.f10186h == null) goto L12;
        r0.append(", appkey=");
        r0.append(this.f10186h);
    L12:
        if (this.f10187i == null) goto L14;
        r0.append(", properties=");
        r0.append(this.f10187i);
    L14:
        StringBuilder r3 = r0.replace(0, 2, "TargetDataset{");
        r3.append('}');
        return r3.toString();
    }
}
