package com.obric.matrix.v.a;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Message<g, a> {
    public static final ProtoAdapter<g> t = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f10088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f10089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f10090h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f10091i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer f10092j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String f10093k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String f10094l;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String m;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer n;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String o;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String p;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 12)
    public final Integer q;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 13)
    public final k.h r;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 14)
    public final Long s;

    public static final class a extends Message.Builder<g, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10097c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f10098d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f10099e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10100f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10101g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f10102h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f10103i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f10104j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f10105k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Integer f10106l;
        public k.h m;
        public Long n;

        public a() {
        }

        public a a(Integer r1) {
            this.f10099e = r1;
            return this;
        }

        public g b() {
            return new g(this.f10095a, this.f10096b, this.f10097c, this.f10098d, this.f10099e, this.f10100f, this.f10101g, this.f10102h, this.f10103i, this.f10104j, this.f10105k, this.f10106l, this.m, this.n, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(String r1) {
            this.f10105k = r1;
            return this;
        }

        public a d(String r1) {
            this.f10097c = r1;
            return this;
        }

        public a e(String r1) {
            this.f10096b = r1;
            return this;
        }

        public a f(k.h r1) {
            this.m = r1;
            return this;
        }

        public a g(String r1) {
            this.f10102h = r1;
            return this;
        }

        public a h(Integer r1) {
            this.f10106l = r1;
            return this;
        }

        public a i(String r1) {
            this.f10104j = r1;
            return this;
        }

        public a j(String r1) {
            this.f10100f = r1;
            return this;
        }

        public a k(String r1) {
            this.f10101g = r1;
            return this;
        }

        public a l(Long r1) {
            this.n = r1;
            return this;
        }

        public a m(Long r1) {
            this.f10098d = r1;
            return this;
        }

        public a n(Integer r1) {
            this.f10103i = r1;
            return this;
        }

        public a o(Integer r1) {
            this.f10095a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<g> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, g.class);
        }

        public g a(ProtoReader r5) {
            a r4 = new a();
            long r0 = r5.beginMessage();
        L3:
            int r2 = r5.nextTag();
            if (r2 == (-1)) goto L21;
            switch(r2) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L7:
            r4.l(ProtoAdapter.INT64.decode(r5));
            goto L3
        L8:
            r4.f(ProtoAdapter.BYTES.decode(r5));
            goto L3
        L9:
            r4.h(ProtoAdapter.INT32.decode(r5));
            goto L3
        L10:
            r4.c(ProtoAdapter.STRING.decode(r5));
            goto L3
        L11:
            r4.i(ProtoAdapter.STRING.decode(r5));
            goto L3
        L12:
            r4.n(ProtoAdapter.INT32.decode(r5));
            goto L3
        L13:
            r4.g(ProtoAdapter.STRING.decode(r5));
            goto L3
        L14:
            r4.k(ProtoAdapter.STRING.decode(r5));
            goto L3
        L15:
            r4.j(ProtoAdapter.STRING.decode(r5));
            goto L3
        L16:
            r4.a(ProtoAdapter.INT32.decode(r5));
            goto L3
        L17:
            r4.m(ProtoAdapter.INT64.decode(r5));
            goto L3
        L18:
            r4.d(ProtoAdapter.STRING.decode(r5));
            goto L3
        L19:
            r4.e(ProtoAdapter.STRING.decode(r5));
            goto L3
        L20:
            r4.o(ProtoAdapter.INT32.decode(r5));
            goto L3
        L6:
            r5.readUnknownField(r2);
            goto L3
        L21:
            r4.addUnknownFields(r5.endMessageAndGetUnknownFields(r0));
            return r4.b();
        }

        public void b(ProtoWriter r5, g r6) {
            ProtoAdapter<Integer> r4 = ProtoAdapter.INT32;
            r4.encodeWithTag(r5, 1, r6.f10088f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 2, r6.f10089g);
            r0.encodeWithTag(r5, 3, r6.f10090h);
            ProtoAdapter<Long> r1 = ProtoAdapter.INT64;
            r1.encodeWithTag(r5, 4, r6.f10091i);
            r4.encodeWithTag(r5, 5, r6.f10092j);
            r0.encodeWithTag(r5, 6, r6.f10093k);
            r0.encodeWithTag(r5, 7, r6.f10094l);
            r0.encodeWithTag(r5, 8, r6.m);
            r4.encodeWithTag(r5, 9, r6.n);
            r0.encodeWithTag(r5, 10, r6.o);
            r0.encodeWithTag(r5, 11, r6.p);
            r4.encodeWithTag(r5, 12, r6.q);
            ProtoAdapter.BYTES.encodeWithTag(r5, 13, r6.r);
            r1.encodeWithTag(r5, 14, r6.s);
            r5.writeBytes(r6.unknownFields());
        }

        public int c(g r6) {
            ProtoAdapter<Integer> r5 = ProtoAdapter.INT32;
            int r0 = r5.encodedSizeWithTag(1, r6.f10088f);
            ProtoAdapter<String> r1 = ProtoAdapter.STRING;
            int r2 = (r0 + r1.encodedSizeWithTag(2, r6.f10089g)) + r1.encodedSizeWithTag(3, r6.f10090h);
            ProtoAdapter<Long> r3 = ProtoAdapter.INT64;
            return (((((((((((r2 + r3.encodedSizeWithTag(4, r6.f10091i)) + r5.encodedSizeWithTag(5, r6.f10092j)) + r1.encodedSizeWithTag(6, r6.f10093k)) + r1.encodedSizeWithTag(7, r6.f10094l)) + r1.encodedSizeWithTag(8, r6.m)) + r5.encodedSizeWithTag(9, r6.n)) + r1.encodedSizeWithTag(10, r6.o)) + r1.encodedSizeWithTag(11, r6.p)) + r5.encodedSizeWithTag(12, r6.q)) + ProtoAdapter.BYTES.encodedSizeWithTag(13, r6.r)) + r3.encodedSizeWithTag(14, r6.s)) + r6.unknownFields().size();
        }

        public g d(g r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ g decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, g r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(g r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ g redact(g r1) {
            return d(r1);
        }
    }

    static {
        t = new b();
        k.h r0 = k.h.f18266i;
    }

    public g(Integer r4, String r5, String r6, Long r7, Integer r8, String r9, String r10, String r11, Integer r12, String r13, String r14, Integer r15, k.h r16, Long r17, k.h r18) {
        super(t, r18);
        this.f10088f = r4;
        this.f10089g = r5;
        this.f10090h = r6;
        this.f10091i = r7;
        this.f10092j = r8;
        this.f10093k = r9;
        this.f10094l = r10;
        this.m = r11;
        this.n = r12;
        this.o = r13;
        this.p = r14;
        this.q = r15;
        this.r = r16;
        this.s = r17;
    }

    public a b() {
        a r0 = new a();
        r0.f10095a = this.f10088f;
        r0.f10096b = this.f10089g;
        r0.f10097c = this.f10090h;
        r0.f10098d = this.f10091i;
        r0.f10099e = this.f10092j;
        r0.f10100f = this.f10093k;
        r0.f10101g = this.f10094l;
        r0.f10102h = this.m;
        r0.f10103i = this.n;
        r0.f10104j = this.o;
        r0.f10105k = this.p;
        r0.f10106l = this.q;
        r0.m = this.r;
        r0.n = this.s;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L40;
        if (Internal.equals(this.f10088f, r6.f10088f) == false) goto L40;
        if (Internal.equals(this.f10089g, r6.f10089g) == false) goto L40;
        if (Internal.equals(this.f10090h, r6.f10090h) == false) goto L40;
        if (Internal.equals(this.f10091i, r6.f10091i) == false) goto L40;
        if (Internal.equals(this.f10092j, r6.f10092j) == false) goto L40;
        if (Internal.equals(this.f10093k, r6.f10093k) == false) goto L40;
        if (Internal.equals(this.f10094l, r6.f10094l) == false) goto L40;
        if (Internal.equals(this.m, r6.m) == false) goto L40;
        if (Internal.equals(this.n, r6.n) == false) goto L40;
        if (Internal.equals(this.o, r6.o) == false) goto L40;
        if (Internal.equals(this.p, r6.p) == false) goto L40;
        if (Internal.equals(this.q, r6.q) == false) goto L40;
        if (Internal.equals(this.r, r6.r) == false) goto L40;
        if (Internal.equals(this.s, r6.s) == false) goto L40;
        return true;
    L40:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L61;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10088f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10089g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10090h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.f10091i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Integer r15 = this.f10092j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f10093k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.f10094l;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        String r24 = this.m;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        Integer r27 = this.n;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.o;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        String r33 = this.p;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        Integer r36 = this.q;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        k.h r39 = this.r;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        Long r42 = this.s;
        if (r42 == null) goto L59;
        r3 = r42.hashCode();
    L59:
        int r43 = r41 + r3;
        this.hashCode = r43;
        return r43;
    L55:
        r40 = 0;
        goto L56
    L51:
        r37 = 0;
        goto L52
    L47:
        r34 = 0;
        goto L48
    L43:
        r31 = 0;
        goto L44
    L39:
        r28 = 0;
        goto L40
    L35:
        r25 = 0;
        goto L36
    L31:
        r22 = 0;
        goto L32
    L27:
        r19 = 0;
        goto L28
    L23:
        r16 = 0;
        goto L24
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
    L61:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10088f == null) goto L6;
        r0.append(", version=");
        r0.append(this.f10088f);
    L6:
        if (this.f10089g == null) goto L9;
        r0.append(", env=");
        r0.append(this.f10089g);
    L9:
        if (this.f10090h == null) goto L12;
        r0.append(", did=");
        r0.append(this.f10090h);
    L12:
        if (this.f10091i == null) goto L15;
        r0.append(", session_id=");
        r0.append(this.f10091i);
    L15:
        if (this.f10092j == null) goto L18;
        r0.append(", app_id=");
        r0.append(this.f10092j);
    L18:
        if (this.f10093k == null) goto L21;
        r0.append(", push_token=");
        r0.append(this.f10093k);
    L21:
        if (this.f10094l == null) goto L24;
        r0.append(", req_id=");
        r0.append(this.f10094l);
    L24:
        if (this.m == null) goto L27;
        r0.append(", msg_id=");
        r0.append(this.m);
    L27:
        if (this.n == null) goto L30;
        r0.append(", user_id=");
        r0.append(this.n);
    L30:
        if (this.o == null) goto L33;
        r0.append(", pkg_name=");
        r0.append(this.o);
    L33:
        if (this.p == null) goto L36;
        r0.append(", cert_fingerprint=");
        r0.append(this.p);
    L36:
        if (this.q == null) goto L39;
        r0.append(", msg_type=");
        r0.append(this.q);
    L39:
        if (this.r == null) goto L42;
        r0.append(", msg_body=");
        r0.append(this.r);
    L42:
        if (this.s == null) goto L44;
        r0.append(", req_timestamp=");
        r0.append(this.s);
    L44:
        StringBuilder r3 = r0.replace(0, 2, "Message{");
        r3.append('}');
        return r3.toString();
    }
}
