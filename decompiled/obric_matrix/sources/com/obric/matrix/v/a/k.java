package com.obric.matrix.v.a;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends Message<k, a> {
    public static final ProtoAdapter<k> v = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f10116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f10117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f10118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f10119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer f10120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String f10121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String f10122l;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    public final Integer m;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String n;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String o;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String p;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String q;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 13)
    public final Long r;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 14)
    public final Long s;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final String t;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String u;

    public static final class a extends Message.Builder<k, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f10126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f10127e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10128f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10129g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f10130h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f10131i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f10132j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f10133k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f10134l;
        public Long m;
        public Long n;
        public String o;
        public String p;

        public a() {
        }

        public a a(Integer r1) {
            this.f10127e = r1;
            return this;
        }

        public k b() {
            return new k(this, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(String r1) {
            this.o = r1;
            return this;
        }

        public a d(String r1) {
            this.p = r1;
            return this;
        }

        public a e(String r1) {
            this.f10125c = r1;
            return this;
        }

        public a f(String r1) {
            this.f10124b = r1;
            return this;
        }

        public a g(String r1) {
            this.f10128f = r1;
            return this;
        }

        public a h(String r1) {
            this.f10133k = r1;
            return this;
        }

        public a i(Integer r1) {
            this.f10130h = r1;
            return this;
        }

        public a j(String r1) {
            this.f10129g = r1;
            return this;
        }

        public a k(String r1) {
            this.f10131i = r1;
            return this;
        }

        public a l(String r1) {
            this.f10132j = r1;
            return this;
        }

        public a m(Long r1) {
            this.n = r1;
            return this;
        }

        public a n(Long r1) {
            this.f10126d = r1;
            return this;
        }

        public a o(String r1) {
            this.f10134l = r1;
            return this;
        }

        public a p(Long r1) {
            this.m = r1;
            return this;
        }

        public a q(Integer r1) {
            this.f10123a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<k> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, k.class);
        }

        public k a(ProtoReader r5) {
            a r4 = new a();
            long r0 = r5.beginMessage();
        L3:
            int r2 = r5.nextTag();
            if (r2 == (-1)) goto L23;
            switch(r2) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L10;
                case 14: goto L9;
                case 15: goto L8;
                case 16: goto L7;
                default: goto L6;
            };
        L7:
            r4.d(ProtoAdapter.STRING.decode(r5));
            goto L3
        L8:
            r4.c(ProtoAdapter.STRING.decode(r5));
            goto L3
        L9:
            r4.m(ProtoAdapter.INT64.decode(r5));
            goto L3
        L10:
            r4.p(ProtoAdapter.INT64.decode(r5));
            goto L3
        L11:
            r4.o(ProtoAdapter.STRING.decode(r5));
            goto L3
        L12:
            r4.h(ProtoAdapter.STRING.decode(r5));
            goto L3
        L13:
            r4.l(ProtoAdapter.STRING.decode(r5));
            goto L3
        L14:
            r4.k(ProtoAdapter.STRING.decode(r5));
            goto L3
        L15:
            r4.i(ProtoAdapter.INT32.decode(r5));
            goto L3
        L16:
            r4.j(ProtoAdapter.STRING.decode(r5));
            goto L3
        L17:
            r4.g(ProtoAdapter.STRING.decode(r5));
            goto L3
        L18:
            r4.a(ProtoAdapter.INT32.decode(r5));
            goto L3
        L19:
            r4.n(ProtoAdapter.INT64.decode(r5));
            goto L3
        L20:
            r4.e(ProtoAdapter.STRING.decode(r5));
            goto L3
        L21:
            r4.f(ProtoAdapter.STRING.decode(r5));
            goto L3
        L22:
            r4.q(ProtoAdapter.INT32.decode(r5));
            goto L3
        L6:
            r5.readUnknownField(r2);
            goto L3
        L23:
            r4.addUnknownFields(r5.endMessageAndGetUnknownFields(r0));
            return r4.b();
        }

        public void b(ProtoWriter r5, k r6) {
            ProtoAdapter<Integer> r4 = ProtoAdapter.INT32;
            r4.encodeWithTag(r5, 1, r6.f10116f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 2, r6.f10117g);
            r0.encodeWithTag(r5, 3, r6.f10118h);
            ProtoAdapter<Long> r1 = ProtoAdapter.INT64;
            r1.encodeWithTag(r5, 4, r6.f10119i);
            r4.encodeWithTag(r5, 5, r6.f10120j);
            r0.encodeWithTag(r5, 6, r6.f10121k);
            r0.encodeWithTag(r5, 7, r6.f10122l);
            r4.encodeWithTag(r5, 8, r6.m);
            r0.encodeWithTag(r5, 9, r6.n);
            r0.encodeWithTag(r5, 10, r6.o);
            r0.encodeWithTag(r5, 11, r6.p);
            r0.encodeWithTag(r5, 12, r6.q);
            r1.encodeWithTag(r5, 13, r6.r);
            r1.encodeWithTag(r5, 14, r6.s);
            r0.encodeWithTag(r5, 15, r6.t);
            r0.encodeWithTag(r5, 16, r6.u);
            r5.writeBytes(r6.unknownFields());
        }

        public int c(k r6) {
            ProtoAdapter<Integer> r5 = ProtoAdapter.INT32;
            int r0 = r5.encodedSizeWithTag(1, r6.f10116f);
            ProtoAdapter<String> r1 = ProtoAdapter.STRING;
            int r2 = (r0 + r1.encodedSizeWithTag(2, r6.f10117g)) + r1.encodedSizeWithTag(3, r6.f10118h);
            ProtoAdapter<Long> r3 = ProtoAdapter.INT64;
            return (((((((((((((r2 + r3.encodedSizeWithTag(4, r6.f10119i)) + r5.encodedSizeWithTag(5, r6.f10120j)) + r1.encodedSizeWithTag(6, r6.f10121k)) + r1.encodedSizeWithTag(7, r6.f10122l)) + r5.encodedSizeWithTag(8, r6.m)) + r1.encodedSizeWithTag(9, r6.n)) + r1.encodedSizeWithTag(10, r6.o)) + r1.encodedSizeWithTag(11, r6.p)) + r1.encodedSizeWithTag(12, r6.q)) + r3.encodedSizeWithTag(13, r6.r)) + r3.encodedSizeWithTag(14, r6.s)) + r1.encodedSizeWithTag(15, r6.t)) + r1.encodedSizeWithTag(16, r6.u)) + r6.unknownFields().size();
        }

        public k d(k r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ k decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, k r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(k r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ k redact(k r1) {
            return d(r1);
        }
    }

    static {
        v = new b();
    }

    public k(a r2, k.h r3) {
        super(v, r3);
        this.f10116f = r2.f10123a;
        this.f10117g = r2.f10124b;
        this.f10118h = r2.f10125c;
        this.f10119i = r2.f10126d;
        this.f10120j = r2.f10127e;
        this.f10121k = r2.f10128f;
        this.f10122l = r2.f10129g;
        this.m = r2.f10130h;
        this.n = r2.f10131i;
        this.o = r2.f10132j;
        this.p = r2.f10133k;
        this.q = r2.f10134l;
        this.r = r2.m;
        this.s = r2.n;
        this.t = r2.o;
        this.u = r2.p;
    }

    public a b() {
        a r0 = new a();
        r0.f10123a = this.f10116f;
        r0.f10124b = this.f10117g;
        r0.f10125c = this.f10118h;
        r0.f10126d = this.f10119i;
        r0.f10127e = this.f10120j;
        r0.f10128f = this.f10121k;
        r0.f10129g = this.f10122l;
        r0.f10130h = this.m;
        r0.f10131i = this.n;
        r0.f10132j = this.o;
        r0.f10133k = this.p;
        r0.f10134l = this.q;
        r0.m = this.r;
        r0.n = this.s;
        r0.o = this.t;
        r0.p = this.u;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L44;
        if (Internal.equals(this.f10116f, r6.f10116f) == false) goto L44;
        if (Internal.equals(this.f10117g, r6.f10117g) == false) goto L44;
        if (Internal.equals(this.f10118h, r6.f10118h) == false) goto L44;
        if (Internal.equals(this.f10119i, r6.f10119i) == false) goto L44;
        if (Internal.equals(this.f10120j, r6.f10120j) == false) goto L44;
        if (Internal.equals(this.f10121k, r6.f10121k) == false) goto L44;
        if (Internal.equals(this.f10122l, r6.f10122l) == false) goto L44;
        if (Internal.equals(this.m, r6.m) == false) goto L44;
        if (Internal.equals(this.n, r6.n) == false) goto L44;
        if (Internal.equals(this.o, r6.o) == false) goto L44;
        if (Internal.equals(this.p, r6.p) == false) goto L44;
        if (Internal.equals(this.q, r6.q) == false) goto L44;
        if (Internal.equals(this.r, r6.r) == false) goto L44;
        if (Internal.equals(this.s, r6.s) == false) goto L44;
        if (Internal.equals(this.t, r6.t) == false) goto L44;
        if (Internal.equals(this.u, r6.u) == false) goto L44;
        return true;
    L44:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L69;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10116f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10117g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10118h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.f10119i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Integer r15 = this.f10120j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f10121k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.f10122l;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        Integer r24 = this.m;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        String r27 = this.n;
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
        String r36 = this.q;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        Long r39 = this.r;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        Long r42 = this.s;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        String r45 = this.t;
        if (r45 == null) goto L63;
        int r46 = r45.hashCode();
    L64:
        int r47 = (r44 + r46) * 37;
        String r48 = this.u;
        if (r48 == null) goto L67;
        r3 = r48.hashCode();
    L67:
        int r49 = r47 + r3;
        this.hashCode = r49;
        return r49;
    L63:
        r46 = 0;
        goto L64
    L59:
        r43 = 0;
        goto L60
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
    L69:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10116f == null) goto L6;
        r0.append(", version=");
        r0.append(this.f10116f);
    L6:
        if (this.f10117g == null) goto L9;
        r0.append(", env=");
        r0.append(this.f10117g);
    L9:
        if (this.f10118h == null) goto L12;
        r0.append(", did=");
        r0.append(this.f10118h);
    L12:
        if (this.f10119i == null) goto L15;
        r0.append(", session_id=");
        r0.append(this.f10119i);
    L15:
        if (this.f10120j == null) goto L18;
        r0.append(", app_id=");
        r0.append(this.f10120j);
    L18:
        if (this.f10121k == null) goto L21;
        r0.append(", msg_id=");
        r0.append(this.f10121k);
    L21:
        if (this.f10122l == null) goto L24;
        r0.append(", receipt_id=");
        r0.append(this.f10122l);
    L24:
        if (this.m == null) goto L27;
        r0.append(", receipt_code=");
        r0.append(this.m);
    L27:
        if (this.n == null) goto L30;
        r0.append(", receipt_status=");
        r0.append(this.n);
    L30:
        if (this.o == null) goto L33;
        r0.append(", req_id=");
        r0.append(this.o);
    L33:
        if (this.p == null) goto L36;
        r0.append(", push_token=");
        r0.append(this.p);
    L36:
        if (this.q == null) goto L39;
        r0.append(", tag=");
        r0.append(this.q);
    L39:
        if (this.r == null) goto L42;
        r0.append(", timestamp=");
        r0.append(this.r);
    L42:
        if (this.s == null) goto L45;
        r0.append(", req_timestamp=");
        r0.append(this.s);
    L45:
        if (this.t == null) goto L48;
        r0.append(", client_ver=");
        r0.append(this.t);
    L48:
        if (this.u == null) goto L50;
        r0.append(", device_model=");
        r0.append(this.u);
    L50:
        StringBuilder r3 = r0.replace(0, 2, "Receipt{");
        r3.append('}');
        return r3.toString();
    }
}
