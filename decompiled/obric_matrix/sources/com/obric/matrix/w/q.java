package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends Message<q, a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ProtoAdapter<q> f10475k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    @com.google.gson.y.c("thirdStartTime")
    public final Long f10476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    @com.google.gson.y.c("thirdJavaJniCallTime")
    public final Long f10477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    @com.google.gson.y.c("matrixBindRevTime")
    public final Long f10478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @com.google.gson.y.c("matrixBindProcessEndTime")
    public final Long f10479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    @com.google.gson.y.c("thirdJavaRevResResult")
    public final Long f10480j;

    public static final class a extends Message.Builder<q, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f10481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f10482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f10483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f10484d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f10485e;

        public a() {
            this.f10481a = 0L;
            this.f10482b = 0L;
            this.f10483c = 0L;
            this.f10484d = 0L;
            this.f10485e = 0L;
        }

        public q a() {
            return new q(this.f10481a, this.f10482b, this.f10483c, this.f10484d, this.f10485e, super.buildUnknownFields());
        }

        public a b(Long r1) {
            this.f10484d = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Long r1) {
            this.f10483c = r1;
            return this;
        }

        public a d(Long r1) {
            this.f10482b = r1;
            return this;
        }

        public a e(Long r1) {
            this.f10485e = r1;
            return this;
        }

        public a f(Long r1) {
            this.f10481a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<q> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, q.class);
        }

        public q a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L21;
            if (r2 != 1) goto L8;
            r5.f(ProtoAdapter.INT64.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.d(ProtoAdapter.INT64.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.c(ProtoAdapter.INT64.decode(r6));
            goto L3
        L12:
            if (r2 != 4) goto L14;
            r5.b(ProtoAdapter.INT64.decode(r6));
            goto L3
        L14:
            if (r2 != 5) goto L15;
            r5.e(ProtoAdapter.INT64.decode(r6));
            goto L3
        L15:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L21:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, q r4) {
            ProtoAdapter<Long> r2 = ProtoAdapter.INT64;
            r2.encodeWithTag(r3, 1, r4.f10476f);
            r2.encodeWithTag(r3, 2, r4.f10477g);
            r2.encodeWithTag(r3, 3, r4.f10478h);
            r2.encodeWithTag(r3, 4, r4.f10479i);
            r2.encodeWithTag(r3, 5, r4.f10480j);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(q r4) {
            ProtoAdapter<Long> r3 = ProtoAdapter.INT64;
            return ((((r3.encodedSizeWithTag(1, r4.f10476f) + r3.encodedSizeWithTag(2, r4.f10477g)) + r3.encodedSizeWithTag(3, r4.f10478h)) + r3.encodedSizeWithTag(4, r4.f10479i)) + r3.encodedSizeWithTag(5, r4.f10480j)) + r4.unknownFields().size();
        }

        public q d(q r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ q decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, q r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(q r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ q redact(q r1) {
            return d(r1);
        }
    }

    static {
        f10475k = new b();
    }

    public q(Long r2, Long r3, Long r4, Long r5, Long r6, k.h r7) {
        super(f10475k, r7);
        this.f10476f = r2;
        this.f10477g = r3;
        this.f10478h = r4;
        this.f10479i = r5;
        this.f10480j = r6;
    }

    public a b() {
        a r0 = new a();
        r0.f10481a = this.f10476f;
        r0.f10482b = this.f10477g;
        r0.f10483c = this.f10478h;
        r0.f10484d = this.f10479i;
        r0.f10485e = this.f10480j;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L22;
        if (Internal.equals(this.f10476f, r6.f10476f) == false) goto L22;
        if (Internal.equals(this.f10477g, r6.f10477g) == false) goto L22;
        if (Internal.equals(this.f10478h, r6.f10478h) == false) goto L22;
        if (Internal.equals(this.f10479i, r6.f10479i) == false) goto L22;
        if (Internal.equals(this.f10480j, r6.f10480j) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.f10476f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.f10477g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.f10478h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.f10479i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Long r15 = this.f10480j;
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
        if (this.f10476f == null) goto L6;
        r0.append(", thirdStartTime=");
        r0.append(this.f10476f);
    L6:
        if (this.f10477g == null) goto L9;
        r0.append(", thirdJavaJniCallTime=");
        r0.append(this.f10477g);
    L9:
        if (this.f10478h == null) goto L12;
        r0.append(", matrixBindRevTime=");
        r0.append(this.f10478h);
    L12:
        if (this.f10479i == null) goto L15;
        r0.append(", matrixBindProcessEndTime=");
        r0.append(this.f10479i);
    L15:
        if (this.f10480j == null) goto L17;
        r0.append(", thirdJavaRevResResult=");
        r0.append(this.f10480j);
    L17:
        StringBuilder r3 = r0.replace(0, 2, "MonitorInfo{");
        r3.append('}');
        return r3.toString();
    }
}
