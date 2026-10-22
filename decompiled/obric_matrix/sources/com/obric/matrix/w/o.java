package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends Message<o, a> {
    public static final ProtoAdapter<o> u = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    @com.google.gson.y.c("longitude")
    public final Double f10439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    @com.google.gson.y.c("latitude")
    public final Double f10440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @com.google.gson.y.c("country")
    public final String f10441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @com.google.gson.y.c("countryCode")
    public final String f10442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @com.google.gson.y.c("administrativeArea")
    public final String f10443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @com.google.gson.y.c("city")
    public final String f10444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @com.google.gson.y.c("district")
    public final String f10445l;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @com.google.gson.y.c("town")
    public final String m;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @com.google.gson.y.c("street")
    public final String n;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    @com.google.gson.y.c("subAdministrativeArea")
    public final String o;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    @com.google.gson.y.c("locality")
    public final String p;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    @com.google.gson.y.c("subLocality")
    public final String q;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    @com.google.gson.y.c("addressLine")
    public final String r;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    @com.google.gson.y.c("cityCode")
    public final String s;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    @com.google.gson.y.c("districtCode")
    public final String t;

    public static final class a extends Message.Builder<o, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f10446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f10447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f10449d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10450e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10451f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10452g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f10453h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f10454i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f10455j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f10456k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f10457l;
        public String m;
        public String n;
        public String o;

        public a() {
            Double r0 = Double.valueOf(0.0d);
            this.f10446a = r0;
            this.f10447b = r0;
            this.f10448c = "";
            this.f10449d = "";
            this.f10450e = "";
            this.f10451f = "";
            this.f10452g = "";
            this.f10453h = "";
            this.f10454i = "";
            this.f10455j = "";
            this.f10456k = "";
            this.f10457l = "";
            this.m = "";
            this.n = "";
            this.o = "";
        }

        public a a(String r1) {
            this.m = r1;
            return this;
        }

        public a b(String r1) {
            this.f10450e = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public o c() {
            return new o(this.f10446a, this.f10447b, this.f10448c, this.f10449d, this.f10450e, this.f10451f, this.f10452g, this.f10453h, this.f10454i, this.f10455j, this.f10456k, this.f10457l, this.m, this.n, this.o, super.buildUnknownFields());
        }

        public a d(String r1) {
            this.f10451f = r1;
            return this;
        }

        public a e(String r1) {
            this.n = r1;
            return this;
        }

        public a f(String r1) {
            this.f10448c = r1;
            return this;
        }

        public a g(String r1) {
            this.f10449d = r1;
            return this;
        }

        public a h(String r1) {
            this.f10452g = r1;
            return this;
        }

        public a i(String r1) {
            this.o = r1;
            return this;
        }

        public a j(Double r1) {
            this.f10447b = r1;
            return this;
        }

        public a k(String r1) {
            this.f10456k = r1;
            return this;
        }

        public a l(Double r1) {
            this.f10446a = r1;
            return this;
        }

        public a m(String r1) {
            this.f10454i = r1;
            return this;
        }

        public a n(String r1) {
            this.f10455j = r1;
            return this;
        }

        public a o(String r1) {
            this.f10457l = r1;
            return this;
        }

        public a p(String r1) {
            this.f10453h = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<o> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, o.class);
        }

        public o a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L22;
            switch(r2) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L7:
            r5.i(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            r5.e(ProtoAdapter.STRING.decode(r6));
            goto L3
        L9:
            r5.a(ProtoAdapter.STRING.decode(r6));
            goto L3
        L10:
            r5.o(ProtoAdapter.STRING.decode(r6));
            goto L3
        L11:
            r5.k(ProtoAdapter.STRING.decode(r6));
            goto L3
        L12:
            r5.n(ProtoAdapter.STRING.decode(r6));
            goto L3
        L13:
            r5.m(ProtoAdapter.STRING.decode(r6));
            goto L3
        L14:
            r5.p(ProtoAdapter.STRING.decode(r6));
            goto L3
        L15:
            r5.h(ProtoAdapter.STRING.decode(r6));
            goto L3
        L16:
            r5.d(ProtoAdapter.STRING.decode(r6));
            goto L3
        L17:
            r5.b(ProtoAdapter.STRING.decode(r6));
            goto L3
        L18:
            r5.g(ProtoAdapter.STRING.decode(r6));
            goto L3
        L19:
            r5.f(ProtoAdapter.STRING.decode(r6));
            goto L3
        L20:
            r5.j(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L21:
            r5.l(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L6:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L22:
            r6.endMessage(r0);
            return r5.c();
        }

        public void b(ProtoWriter r3, o r4) {
            ProtoAdapter<Double> r2 = ProtoAdapter.DOUBLE;
            r2.encodeWithTag(r3, 1, r4.f10439f);
            r2.encodeWithTag(r3, 2, r4.f10440g);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            r5.encodeWithTag(r3, 3, r4.f10441h);
            r5.encodeWithTag(r3, 4, r4.f10442i);
            r5.encodeWithTag(r3, 5, r4.f10443j);
            r5.encodeWithTag(r3, 6, r4.f10444k);
            r5.encodeWithTag(r3, 7, r4.f10445l);
            r5.encodeWithTag(r3, 8, r4.m);
            r5.encodeWithTag(r3, 9, r4.n);
            r5.encodeWithTag(r3, 10, r4.o);
            r5.encodeWithTag(r3, 11, r4.p);
            r5.encodeWithTag(r3, 12, r4.q);
            r5.encodeWithTag(r3, 13, r4.r);
            r5.encodeWithTag(r3, 14, r4.s);
            r5.encodeWithTag(r3, 15, r4.t);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(o r4) {
            ProtoAdapter<Double> r3 = ProtoAdapter.DOUBLE;
            int r0 = r3.encodedSizeWithTag(1, r4.f10439f) + r3.encodedSizeWithTag(2, r4.f10440g);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            return (((((((((((((r0 + r5.encodedSizeWithTag(3, r4.f10441h)) + r5.encodedSizeWithTag(4, r4.f10442i)) + r5.encodedSizeWithTag(5, r4.f10443j)) + r5.encodedSizeWithTag(6, r4.f10444k)) + r5.encodedSizeWithTag(7, r4.f10445l)) + r5.encodedSizeWithTag(8, r4.m)) + r5.encodedSizeWithTag(9, r4.n)) + r5.encodedSizeWithTag(10, r4.o)) + r5.encodedSizeWithTag(11, r4.p)) + r5.encodedSizeWithTag(12, r4.q)) + r5.encodedSizeWithTag(13, r4.r)) + r5.encodedSizeWithTag(14, r4.s)) + r5.encodedSizeWithTag(15, r4.t)) + r4.unknownFields().size();
        }

        public o d(o r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.c();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ o decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, o r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(o r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ o redact(o r1) {
            return d(r1);
        }
    }

    static {
        u = new b();
    }

    public o(Double r4, Double r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, k.h r19) {
        super(u, r19);
        this.f10439f = r4;
        this.f10440g = r5;
        this.f10441h = r6;
        this.f10442i = r7;
        this.f10443j = r8;
        this.f10444k = r9;
        this.f10445l = r10;
        this.m = r11;
        this.n = r12;
        this.o = r13;
        this.p = r14;
        this.q = r15;
        this.r = r16;
        this.s = r17;
        this.t = r18;
    }

    public a b() {
        a r0 = new a();
        r0.f10446a = this.f10439f;
        r0.f10447b = this.f10440g;
        r0.f10448c = this.f10441h;
        r0.f10449d = this.f10442i;
        r0.f10450e = this.f10443j;
        r0.f10451f = this.f10444k;
        r0.f10452g = this.f10445l;
        r0.f10453h = this.m;
        r0.f10454i = this.n;
        r0.f10455j = this.o;
        r0.f10456k = this.p;
        r0.f10457l = this.q;
        r0.m = this.r;
        r0.n = this.s;
        r0.o = this.t;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L42;
        if (Internal.equals(this.f10439f, r6.f10439f) == false) goto L42;
        if (Internal.equals(this.f10440g, r6.f10440g) == false) goto L42;
        if (Internal.equals(this.f10441h, r6.f10441h) == false) goto L42;
        if (Internal.equals(this.f10442i, r6.f10442i) == false) goto L42;
        if (Internal.equals(this.f10443j, r6.f10443j) == false) goto L42;
        if (Internal.equals(this.f10444k, r6.f10444k) == false) goto L42;
        if (Internal.equals(this.f10445l, r6.f10445l) == false) goto L42;
        if (Internal.equals(this.m, r6.m) == false) goto L42;
        if (Internal.equals(this.n, r6.n) == false) goto L42;
        if (Internal.equals(this.o, r6.o) == false) goto L42;
        if (Internal.equals(this.p, r6.p) == false) goto L42;
        if (Internal.equals(this.q, r6.q) == false) goto L42;
        if (Internal.equals(this.r, r6.r) == false) goto L42;
        if (Internal.equals(this.s, r6.s) == false) goto L42;
        if (Internal.equals(this.t, r6.t) == false) goto L42;
        return true;
    L42:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L65;
        int r1 = unknownFields().hashCode() * 37;
        Double r2 = this.f10439f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.f10440g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10441h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.f10442i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.f10443j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f10444k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.f10445l;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        String r24 = this.m;
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
        String r39 = this.r;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        String r42 = this.s;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        String r45 = this.t;
        if (r45 == null) goto L63;
        r3 = r45.hashCode();
    L63:
        int r46 = r44 + r3;
        this.hashCode = r46;
        return r46;
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
    L65:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10439f == null) goto L6;
        r0.append(", longitude=");
        r0.append(this.f10439f);
    L6:
        if (this.f10440g == null) goto L9;
        r0.append(", latitude=");
        r0.append(this.f10440g);
    L9:
        if (this.f10441h == null) goto L12;
        r0.append(", country=");
        r0.append(this.f10441h);
    L12:
        if (this.f10442i == null) goto L15;
        r0.append(", countryCode=");
        r0.append(this.f10442i);
    L15:
        if (this.f10443j == null) goto L18;
        r0.append(", administrativeArea=");
        r0.append(this.f10443j);
    L18:
        if (this.f10444k == null) goto L21;
        r0.append(", city=");
        r0.append(this.f10444k);
    L21:
        if (this.f10445l == null) goto L24;
        r0.append(", district=");
        r0.append(this.f10445l);
    L24:
        if (this.m == null) goto L27;
        r0.append(", town=");
        r0.append(this.m);
    L27:
        if (this.n == null) goto L30;
        r0.append(", street=");
        r0.append(this.n);
    L30:
        if (this.o == null) goto L33;
        r0.append(", subAdministrativeArea=");
        r0.append(this.o);
    L33:
        if (this.p == null) goto L36;
        r0.append(", locality=");
        r0.append(this.p);
    L36:
        if (this.q == null) goto L39;
        r0.append(", subLocality=");
        r0.append(this.q);
    L39:
        if (this.r == null) goto L42;
        r0.append(", addressLine=");
        r0.append(this.r);
    L42:
        if (this.s == null) goto L45;
        r0.append(", cityCode=");
        r0.append(this.s);
    L45:
        if (this.t == null) goto L47;
        r0.append(", districtCode=");
        r0.append(this.t);
    L47:
        StringBuilder r3 = r0.replace(0, 2, "LocationInfo{");
        r3.append('}');
        return r3.toString();
    }
}
