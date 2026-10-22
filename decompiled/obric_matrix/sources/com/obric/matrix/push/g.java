package com.obric.matrix.push;

import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Message<g, a> {
    public static final ProtoAdapter<g> I = null;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 22)
    public final Integer A;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 23)
    public final Map<String, String> B;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 24)
    public final Map<String, String> C;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 25)
    public final String D;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 26)
    public final Integer E;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 27)
    public final String F;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 28)
    public final Integer G;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 255)
    public final Map<String, String> H;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f9564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f9565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f9566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String f9567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer f9568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String f9569k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String f9570l;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String m;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String n;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String o;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 11)
    public final Integer p;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String q;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 13)
    public final Integer r;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 14)
    public final Boolean s;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 15)
    public final Boolean t;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String u;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean v;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 18)
    public final String w;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 19)
    public final Long x;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    public final Integer y;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 21)
    public final Boolean z;

    public static final class a extends Message.Builder<g, a> {
        public String A;
        public Integer B;
        public Map<String, String> C;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9573c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f9574d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f9575e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f9576f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f9577g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f9578h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f9579i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f9580j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f9581k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f9582l;
        public Integer m;
        public Boolean n;
        public Boolean o;
        public String p;
        public Boolean q;
        public String r;
        public Long s;
        public Integer t;
        public Boolean u;
        public Integer v;
        public Map<String, String> w;
        public Map<String, String> x;
        public String y;
        public Integer z;

        public a() {
            this.w = Internal.newMutableMap();
            this.x = Internal.newMutableMap();
            this.C = Internal.newMutableMap();
        }

        public a A(Boolean r1) {
            this.q = r1;
            return this;
        }

        public a a(String r1) {
            this.y = r1;
            return this;
        }

        public a b(Long r1) {
            this.s = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public g c() {
            return new g(this, super.buildUnknownFields());
        }

        public a d(String r1) {
            this.f9578h = r1;
            return this;
        }

        public a e(Integer r1) {
            this.f9581k = r1;
            return this;
        }

        public a f(Boolean r1) {
            this.u = r1;
            return this;
        }

        public a g(String r1) {
            this.f9577g = r1;
            return this;
        }

        public a h(String r1) {
            this.A = r1;
            return this;
        }

        public a i(String r1) {
            this.f9571a = r1;
            return this;
        }

        public a j(Integer r1) {
            this.v = r1;
            return this;
        }

        public a k(String r1) {
            this.f9582l = r1;
            return this;
        }

        public a l(Integer r1) {
            this.z = r1;
            return this;
        }

        public a m(String r1) {
            this.f9572b = r1;
            return this;
        }

        public a n(Integer r1) {
            this.f9575e = r1;
            return this;
        }

        public a o(String r1) {
            this.f9576f = r1;
            return this;
        }

        public a p(Integer r1) {
            this.B = r1;
            return this;
        }

        public a q(Integer r1) {
            this.t = r1;
            return this;
        }

        public a r(String r1) {
            this.r = r1;
            return this;
        }

        public a s(String r1) {
            this.f9579i = r1;
            return this;
        }

        public a t(Integer r1) {
            this.m = r1;
            return this;
        }

        public a u(String r1) {
            this.f9573c = r1;
            return this;
        }

        public a v(String r1) {
            this.f9574d = r1;
            return this;
        }

        public a w(String r1) {
            this.f9580j = r1;
            return this;
        }

        public a x(Boolean r1) {
            this.n = r1;
            return this;
        }

        public a y(Boolean r1) {
            this.o = r1;
            return this;
        }

        public a z(String r1) {
            this.p = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f9583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f9584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f9585c;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, g.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f9583a = ProtoAdapter.newMapAdapter(r0, r0);
            this.f9584b = ProtoAdapter.newMapAdapter(r0, r0);
            this.f9585c = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public g a(ProtoReader r6) {
            a r0 = new a();
            long r1 = r6.beginMessage();
        L3:
            int r3 = r6.nextTag();
            if (r3 == (-1)) goto L39;
            if (r3 == 255) goto L38;
            switch(r3) {
                case 1: goto L37;
                case 2: goto L36;
                case 3: goto L35;
                case 4: goto L34;
                case 5: goto L33;
                case 6: goto L32;
                case 7: goto L31;
                case 8: goto L30;
                case 9: goto L29;
                case 10: goto L28;
                case 11: goto L27;
                case 12: goto L26;
                case 13: goto L25;
                case 14: goto L24;
                case 15: goto L23;
                case 16: goto L22;
                case 17: goto L21;
                case 18: goto L20;
                case 19: goto L19;
                case 20: goto L18;
                case 21: goto L17;
                case 22: goto L16;
                case 23: goto L14;
                case 24: goto L13;
                case 25: goto L12;
                case 26: goto L11;
                case 27: goto L10;
                case 28: goto L9;
                default: goto L8;
            };
        L9:
            r0.p(ProtoAdapter.INT32.decode(r6));
            goto L3
        L10:
            r0.h(ProtoAdapter.STRING.decode(r6));
            goto L3
        L11:
            r0.l(ProtoAdapter.INT32.decode(r6));
            goto L3
        L12:
            r0.a(ProtoAdapter.STRING.decode(r6));
            goto L3
        L13:
            Map<String, String> r4 = r0.x;
            ProtoAdapter<Map<String, String>> r5 = this.f9584b;
        L15:
            r4.putAll(r5.decode(r6));
            goto L3
        L14:
            r4 = r0.w;
            r5 = this.f9583a;
            goto L15
        L16:
            r0.j(ProtoAdapter.INT32.decode(r6));
            goto L3
        L17:
            r0.f(ProtoAdapter.BOOL.decode(r6));
            goto L3
        L18:
            r0.q(ProtoAdapter.INT32.decode(r6));
            goto L3
        L19:
            r0.b(ProtoAdapter.INT64.decode(r6));
            goto L3
        L20:
            r0.r(ProtoAdapter.STRING.decode(r6));
            goto L3
        L21:
            r0.A(ProtoAdapter.BOOL.decode(r6));
            goto L3
        L22:
            r0.z(ProtoAdapter.STRING.decode(r6));
            goto L3
        L23:
            r0.y(ProtoAdapter.BOOL.decode(r6));
            goto L3
        L24:
            r0.x(ProtoAdapter.BOOL.decode(r6));
            goto L3
        L25:
            r0.t(ProtoAdapter.INT32.decode(r6));
            goto L3
        L26:
            r0.k(ProtoAdapter.STRING.decode(r6));
            goto L3
        L27:
            r0.e(ProtoAdapter.INT32.decode(r6));
            goto L3
        L28:
            r0.w(ProtoAdapter.STRING.decode(r6));
            goto L3
        L29:
            r0.s(ProtoAdapter.STRING.decode(r6));
            goto L3
        L30:
            r0.d(ProtoAdapter.STRING.decode(r6));
            goto L3
        L31:
            r0.g(ProtoAdapter.STRING.decode(r6));
            goto L3
        L32:
            r0.o(ProtoAdapter.STRING.decode(r6));
            goto L3
        L33:
            r0.n(ProtoAdapter.INT32.decode(r6));
            goto L3
        L34:
            r0.v(ProtoAdapter.STRING.decode(r6));
            goto L3
        L35:
            r0.u(ProtoAdapter.STRING.decode(r6));
            goto L3
        L36:
            r0.m(ProtoAdapter.STRING.decode(r6));
            goto L3
        L37:
            r0.i(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            r6.readUnknownField(r3);
            goto L3
        L38:
            r4 = r0.C;
            r5 = this.f9585c;
            goto L15
        L39:
            r0.addUnknownFields(r6.endMessageAndGetUnknownFields(r1));
            return r0.c();
        }

        public void b(ProtoWriter r7, g r8) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r7, 1, r8.f9564f);
            r0.encodeWithTag(r7, 2, r8.f9565g);
            r0.encodeWithTag(r7, 3, r8.f9566h);
            r0.encodeWithTag(r7, 4, r8.f9567i);
            ProtoAdapter<Integer> r1 = ProtoAdapter.INT32;
            r1.encodeWithTag(r7, 5, r8.f9568j);
            r0.encodeWithTag(r7, 6, r8.f9569k);
            r0.encodeWithTag(r7, 7, r8.f9570l);
            r0.encodeWithTag(r7, 8, r8.m);
            r0.encodeWithTag(r7, 9, r8.n);
            r0.encodeWithTag(r7, 10, r8.o);
            r1.encodeWithTag(r7, 11, r8.p);
            r0.encodeWithTag(r7, 12, r8.q);
            r1.encodeWithTag(r7, 13, r8.r);
            ProtoAdapter<Boolean> r2 = ProtoAdapter.BOOL;
            r2.encodeWithTag(r7, 14, r8.s);
            r2.encodeWithTag(r7, 15, r8.t);
            r0.encodeWithTag(r7, 16, r8.u);
            r2.encodeWithTag(r7, 17, r8.v);
            r0.encodeWithTag(r7, 18, r8.w);
            ProtoAdapter.INT64.encodeWithTag(r7, 19, r8.x);
            r1.encodeWithTag(r7, 20, r8.y);
            r2.encodeWithTag(r7, 21, r8.z);
            r1.encodeWithTag(r7, 22, r8.A);
            this.f9583a.encodeWithTag(r7, 23, r8.B);
            this.f9584b.encodeWithTag(r7, 24, r8.C);
            r0.encodeWithTag(r7, 25, r8.D);
            r1.encodeWithTag(r7, 26, r8.E);
            r0.encodeWithTag(r7, 27, r8.F);
            r1.encodeWithTag(r7, 28, r8.G);
            this.f9585c.encodeWithTag(r7, 255, r8.H);
            r7.writeBytes(r8.unknownFields());
        }

        public int c(g r8) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            int r1 = ((r0.encodedSizeWithTag(1, r8.f9564f) + r0.encodedSizeWithTag(2, r8.f9565g)) + r0.encodedSizeWithTag(3, r8.f9566h)) + r0.encodedSizeWithTag(4, r8.f9567i);
            ProtoAdapter<Integer> r2 = ProtoAdapter.INT32;
            int r3 = ((((((((r1 + r2.encodedSizeWithTag(5, r8.f9568j)) + r0.encodedSizeWithTag(6, r8.f9569k)) + r0.encodedSizeWithTag(7, r8.f9570l)) + r0.encodedSizeWithTag(8, r8.m)) + r0.encodedSizeWithTag(9, r8.n)) + r0.encodedSizeWithTag(10, r8.o)) + r2.encodedSizeWithTag(11, r8.p)) + r0.encodedSizeWithTag(12, r8.q)) + r2.encodedSizeWithTag(13, r8.r);
            ProtoAdapter<Boolean> r4 = ProtoAdapter.BOOL;
            return ((((((((((((((((r3 + r4.encodedSizeWithTag(14, r8.s)) + r4.encodedSizeWithTag(15, r8.t)) + r0.encodedSizeWithTag(16, r8.u)) + r4.encodedSizeWithTag(17, r8.v)) + r0.encodedSizeWithTag(18, r8.w)) + ProtoAdapter.INT64.encodedSizeWithTag(19, r8.x)) + r2.encodedSizeWithTag(20, r8.y)) + r4.encodedSizeWithTag(21, r8.z)) + r2.encodedSizeWithTag(22, r8.A)) + this.f9583a.encodedSizeWithTag(23, r8.B)) + this.f9584b.encodedSizeWithTag(24, r8.C)) + r0.encodedSizeWithTag(25, r8.D)) + r2.encodedSizeWithTag(26, r8.E)) + r0.encodedSizeWithTag(27, r8.F)) + r2.encodedSizeWithTag(28, r8.G)) + this.f9585c.encodedSizeWithTag(255, r8.H)) + r8.unknownFields().size();
        }

        public g d(g r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.c();
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
        I = new b();
    }

    public g(a r2, k.h r3) {
        super(I, r3);
        this.f9564f = r2.f9571a;
        this.f9565g = r2.f9572b;
        this.f9566h = r2.f9573c;
        this.f9567i = r2.f9574d;
        this.f9568j = r2.f9575e;
        this.f9569k = r2.f9576f;
        this.f9570l = r2.f9577g;
        this.m = r2.f9578h;
        this.n = r2.f9579i;
        this.o = r2.f9580j;
        this.p = r2.f9581k;
        this.q = r2.f9582l;
        this.r = r2.m;
        this.s = r2.n;
        this.t = r2.o;
        this.u = r2.p;
        this.v = r2.q;
        this.w = r2.r;
        this.x = r2.s;
        this.y = r2.t;
        this.z = r2.u;
        this.A = r2.v;
        this.B = Internal.immutableCopyOf("notification_extra", r2.w);
        this.C = Internal.immutableCopyOf("filter_rules", r2.x);
        this.D = r2.y;
        this.E = r2.z;
        this.F = r2.A;
        this.G = r2.B;
        this.H = Internal.immutableCopyOf(WsConstants.KEY_EXTRA, r2.C);
    }

    public a b() {
        a r0 = new a();
        r0.f9571a = this.f9564f;
        r0.f9572b = this.f9565g;
        r0.f9573c = this.f9566h;
        r0.f9574d = this.f9567i;
        r0.f9575e = this.f9568j;
        r0.f9576f = this.f9569k;
        r0.f9577g = this.f9570l;
        r0.f9578h = this.m;
        r0.f9579i = this.n;
        r0.f9580j = this.o;
        r0.f9581k = this.p;
        r0.f9582l = this.q;
        r0.m = this.r;
        r0.n = this.s;
        r0.o = this.t;
        r0.p = this.u;
        r0.q = this.v;
        r0.r = this.w;
        r0.s = this.x;
        r0.t = this.y;
        r0.u = this.z;
        r0.v = this.A;
        r0.w = Internal.copyOf(this.B);
        r0.x = Internal.copyOf(this.C);
        r0.y = this.D;
        r0.z = this.E;
        r0.A = this.F;
        r0.B = this.G;
        r0.C = Internal.copyOf(this.H);
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
        if (unknownFields().equals(r6.unknownFields()) == false) goto L70;
        if (Internal.equals(this.f9564f, r6.f9564f) == false) goto L70;
        if (Internal.equals(this.f9565g, r6.f9565g) == false) goto L70;
        if (Internal.equals(this.f9566h, r6.f9566h) == false) goto L70;
        if (Internal.equals(this.f9567i, r6.f9567i) == false) goto L70;
        if (Internal.equals(this.f9568j, r6.f9568j) == false) goto L70;
        if (Internal.equals(this.f9569k, r6.f9569k) == false) goto L70;
        if (Internal.equals(this.f9570l, r6.f9570l) == false) goto L70;
        if (Internal.equals(this.m, r6.m) == false) goto L70;
        if (Internal.equals(this.n, r6.n) == false) goto L70;
        if (Internal.equals(this.o, r6.o) == false) goto L70;
        if (Internal.equals(this.p, r6.p) == false) goto L70;
        if (Internal.equals(this.q, r6.q) == false) goto L70;
        if (Internal.equals(this.r, r6.r) == false) goto L70;
        if (Internal.equals(this.s, r6.s) == false) goto L70;
        if (Internal.equals(this.t, r6.t) == false) goto L70;
        if (Internal.equals(this.u, r6.u) == false) goto L70;
        if (Internal.equals(this.v, r6.v) == false) goto L70;
        if (Internal.equals(this.w, r6.w) == false) goto L70;
        if (Internal.equals(this.x, r6.x) == false) goto L70;
        if (Internal.equals(this.y, r6.y) == false) goto L70;
        if (Internal.equals(this.z, r6.z) == false) goto L70;
        if (Internal.equals(this.A, r6.A) == false) goto L70;
        if (this.B.equals(r6.B) == false) goto L70;
        if (this.C.equals(r6.C) == false) goto L70;
        if (Internal.equals(this.D, r6.D) == false) goto L70;
        if (Internal.equals(this.E, r6.E) == false) goto L70;
        if (Internal.equals(this.F, r6.F) == false) goto L70;
        if (Internal.equals(this.G, r6.G) == false) goto L70;
        if (this.H.equals(r6.H) == false) goto L70;
        return true;
    L70:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L109;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f9564f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f9565g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f9566h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.f9567i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Integer r15 = this.f9568j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f9569k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.f9570l;
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
        Integer r33 = this.p;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        String r36 = this.q;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        Integer r39 = this.r;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        Boolean r42 = this.s;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        Boolean r45 = this.t;
        if (r45 == null) goto L63;
        int r46 = r45.hashCode();
    L64:
        int r47 = (r44 + r46) * 37;
        String r48 = this.u;
        if (r48 == null) goto L67;
        int r49 = r48.hashCode();
    L68:
        int r50 = (r47 + r49) * 37;
        Boolean r51 = this.v;
        if (r51 == null) goto L71;
        int r52 = r51.hashCode();
    L72:
        int r53 = (r50 + r52) * 37;
        String r54 = this.w;
        if (r54 == null) goto L75;
        int r55 = r54.hashCode();
    L76:
        int r56 = (r53 + r55) * 37;
        Long r57 = this.x;
        if (r57 == null) goto L79;
        int r58 = r57.hashCode();
    L80:
        int r59 = (r56 + r58) * 37;
        Integer r60 = this.y;
        if (r60 == null) goto L83;
        int r61 = r60.hashCode();
    L84:
        int r62 = (r59 + r61) * 37;
        Boolean r63 = this.z;
        if (r63 == null) goto L87;
        int r64 = r63.hashCode();
    L88:
        int r65 = (r62 + r64) * 37;
        Integer r66 = this.A;
        if (r66 == null) goto L91;
        int r67 = r66.hashCode();
    L92:
        int r68 = (((((r65 + r67) * 37) + this.B.hashCode()) * 37) + this.C.hashCode()) * 37;
        String r69 = this.D;
        if (r69 == null) goto L95;
        int r70 = r69.hashCode();
    L96:
        int r71 = (r68 + r70) * 37;
        Integer r72 = this.E;
        if (r72 == null) goto L99;
        int r73 = r72.hashCode();
    L100:
        int r74 = (r71 + r73) * 37;
        String r75 = this.F;
        if (r75 == null) goto L103;
        int r76 = r75.hashCode();
    L104:
        int r77 = (r74 + r76) * 37;
        Integer r78 = this.G;
        if (r78 == null) goto L107;
        r3 = r78.hashCode();
    L107:
        int r79 = ((r77 + r3) * 37) + this.H.hashCode();
        this.hashCode = r79;
        return r79;
    L103:
        r76 = 0;
        goto L104
    L99:
        r73 = 0;
        goto L100
    L95:
        r70 = 0;
        goto L96
    L91:
        r67 = 0;
        goto L92
    L87:
        r64 = 0;
        goto L88
    L83:
        r61 = 0;
        goto L84
    L79:
        r58 = 0;
        goto L80
    L75:
        r55 = 0;
        goto L76
    L71:
        r52 = 0;
        goto L72
    L67:
        r49 = 0;
        goto L68
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
    L109:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f9564f == null) goto L6;
        r0.append(", id=");
        r0.append(this.f9564f);
    L6:
        if (this.f9565g == null) goto L9;
        r0.append(", package_name=");
        r0.append(this.f9565g);
    L9:
        if (this.f9566h == null) goto L12;
        r0.append(", text=");
        r0.append(this.f9566h);
    L12:
        if (this.f9567i == null) goto L15;
        r0.append(", title=");
        r0.append(this.f9567i);
    L15:
        if (this.f9568j == null) goto L18;
        r0.append(", pass_though=");
        r0.append(this.f9568j);
    L18:
        if (this.f9569k == null) goto L21;
        r0.append(", pass_though_data=");
        r0.append(this.f9569k);
    L21:
        if (this.f9570l == null) goto L24;
        r0.append(", group_id=");
        r0.append(this.f9570l);
    L24:
        if (this.m == null) goto L27;
        r0.append(", channel_id=");
        r0.append(this.m);
    L27:
        if (this.n == null) goto L30;
        r0.append(", sign=");
        r0.append(this.n);
    L30:
        if (this.o == null) goto L33;
        r0.append(", url=");
        r0.append(this.o);
    L33:
        if (this.p == null) goto L36;
        r0.append(", click_type=");
        r0.append(this.p);
    L36:
        if (this.q == null) goto L39;
        r0.append(", open_url=");
        r0.append(this.q);
    L39:
        if (this.r == null) goto L42;
        r0.append(", style_type=");
        r0.append(this.r);
    L42:
        if (this.s == null) goto L45;
        r0.append(", use_led=");
        r0.append(this.s);
    L45:
        if (this.t == null) goto L48;
        r0.append(", use_sound=");
        r0.append(this.t);
    L48:
        if (this.u == null) goto L51;
        r0.append(", use_sound_url=");
        r0.append(this.u);
    L51:
        if (this.v == null) goto L54;
        r0.append(", use_vibrator=");
        r0.append(this.v);
    L54:
        if (this.w == null) goto L57;
        r0.append(", revoke_id=");
        r0.append(this.w);
    L57:
        if (this.x == null) goto L60;
        r0.append(", badge_num=");
        r0.append(this.x);
    L60:
        if (this.y == null) goto L63;
        r0.append(", priority=");
        r0.append(this.y);
    L63:
        if (this.z == null) goto L66;
        r0.append(", force_show=");
        r0.append(this.z);
    L66:
        if (this.A == null) goto L69;
        r0.append(", notification_type=");
        r0.append(this.A);
    L69:
        if (this.B.isEmpty() == true) goto L72;
        r0.append(", notification_extra=");
        r0.append(this.B);
    L72:
        if (this.C.isEmpty() == true) goto L75;
        r0.append(", filter_rules=");
        r0.append(this.C);
    L75:
        if (this.D == null) goto L78;
        r0.append(", additional_data=");
        r0.append(this.D);
    L78:
        if (this.E == null) goto L81;
        r0.append(", open_url_type=");
        r0.append(this.E);
    L81:
        if (this.F == null) goto L84;
        r0.append(", icon_url=");
        r0.append(this.F);
    L84:
        if (this.G == null) goto L87;
        r0.append(", pass_though_type=");
        r0.append(this.G);
    L87:
        if (this.H.isEmpty() == true) goto L89;
        r0.append(", extra=");
        r0.append(this.H);
    L89:
        StringBuilder r3 = r0.replace(0, 2, "Push{");
        r3.append('}');
        return r3.toString();
    }
}
