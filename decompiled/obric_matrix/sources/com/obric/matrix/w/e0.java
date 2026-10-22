package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends Message<e0, a> {
    public static final ProtoAdapter<e0> v = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.BizExampleResponse#ADAPTER", tag = 100000)
    @com.google.gson.y.c("bizExampleResponse")
    public final com.obric.matrix.w.b f10284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageResponse#ADAPTER", tag = 101001)
    @com.google.gson.y.c("sendWsMessageResponse")
    public final l0 f10285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgResponse#ADAPTER", tag = 101002)
    @com.google.gson.y.c("subscribeWsMsgResponse")
    public final x0 f10286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusResponse#ADAPTER", tag = 101003)
    @com.google.gson.y.c("subscribeWsStatusResponse")
    public final z0 f10287i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderResponse#ADAPTER", tag = 101004)
    @com.google.gson.y.c("subscribeWsMsgByProviderResponse")
    public final v0 f10288j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackResponse#ADAPTER", tag = 101005)
    @com.google.gson.y.c("subscribeWsMsgByCallBackResponse")
    public final t0 f10289k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastResponse#ADAPTER", tag = 101006)
    @com.google.gson.y.c("subscribeWsMsgByBroadCastResponse")
    public final r0 f10290l;

    @WireField(adapter = "com.obric.matrix.proto.GetLocationResponse#ADAPTER", tag = 102001)
    @com.google.gson.y.c("getLocationResponse")
    public final l m;

    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationResponse#ADAPTER", tag = 102002)
    @com.google.gson.y.c("refreshLocationResponse")
    public final a0 n;

    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationResponse#ADAPTER", tag = 102003)
    @com.google.gson.y.c("decodeLocationResponse")
    public final e o;

    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesResponse#ADAPTER", tag = 102004)
    @com.google.gson.y.c("getIntersectFencesResponse")
    public final j p;

    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse#ADAPTER", tag = 111001)
    @com.google.gson.y.c("startPicoLinksResponse")
    public final n0 q;

    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkResponse#ADAPTER", tag = 112001)
    @com.google.gson.y.c("onePartyCommonNetworkResponse")
    public final v r;

    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventResponse#ADAPTER", tag = 112002)
    @com.google.gson.y.c("sendApplogEventResponse")
    public final j0 s;

    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkResponse#ADAPTER", tag = 112003)
    @com.google.gson.y.c("genericNetworkResponse")
    public final h t;

    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersResponse#ADAPTER", tag = 112004)
    @com.google.gson.y.c("getTTNetParametersResponse")
    public final n u;

    public static final class a extends Message.Builder<e0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.obric.matrix.w.b f10291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l0 f10292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public x0 f10293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public z0 f10294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public v0 f10295e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public t0 f10296f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public r0 f10297g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public l f10298h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public a0 f10299i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public e f10300j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public j f10301k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public n0 f10302l;
        public v m;
        public j0 n;
        public h o;
        public n p;

        public a() {
        }

        public a a(com.obric.matrix.w.b r1) {
            this.f10291a = r1;
            return this;
        }

        public e0 b() {
            return new e0(this.f10291a, this.f10292b, this.f10293c, this.f10294d, this.f10295e, this.f10296f, this.f10297g, this.f10298h, this.f10299i, this.f10300j, this.f10301k, this.f10302l, this.m, this.n, this.o, this.p, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(e r1) {
            this.f10300j = r1;
            return this;
        }

        public a d(h r1) {
            this.o = r1;
            return this;
        }

        public a e(j r1) {
            this.f10301k = r1;
            return this;
        }

        public a f(l r1) {
            this.f10298h = r1;
            return this;
        }

        public a g(n r1) {
            this.p = r1;
            return this;
        }

        public a h(v r1) {
            this.m = r1;
            return this;
        }

        public a i(a0 r1) {
            this.f10299i = r1;
            return this;
        }

        public a j(j0 r1) {
            this.n = r1;
            return this;
        }

        public a k(l0 r1) {
            this.f10292b = r1;
            return this;
        }

        public a l(n0 r1) {
            this.f10302l = r1;
            return this;
        }

        public a m(r0 r1) {
            this.f10297g = r1;
            return this;
        }

        public a n(t0 r1) {
            this.f10296f = r1;
            return this;
        }

        public a o(v0 r1) {
            this.f10295e = r1;
            return this;
        }

        public a p(x0 r1) {
            this.f10293c = r1;
            return this;
        }

        public a q(z0 r1) {
            this.f10294d = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<e0> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, e0.class);
        }

        public e0 a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L29;
            if (r2 != 100000) goto L8;
            r5.a(com.obric.matrix.w.b.f10192g.decode(r6));
            goto L3
        L8:
            if (r2 != 111001) goto L9;
            r5.l(n0.f10427h.decode(r6));
            goto L3
        L9:
            switch(r2) {
                case 101001: goto L26;
                case 101002: goto L25;
                case 101003: goto L24;
                case 101004: goto L23;
                case 101005: goto L22;
                case 101006: goto L21;
                default: goto L10;
            };
        L21:
            r5.m(r0.f10498g.decode(r6));
            goto L3
        L22:
            r5.n(t0.f10519g.decode(r6));
            goto L3
        L23:
            r5.o(v0.f10561h.decode(r6));
            goto L3
        L24:
            r5.q(z0.f10602j.decode(r6));
            goto L3
        L25:
            r5.p(x0.f10586g.decode(r6));
            goto L3
        L26:
            r5.k(l0.f10406g.decode(r6));
            goto L3
        L10:
            switch(r2) {
                case 102001: goto L20;
                case 102002: goto L19;
                case 102003: goto L18;
                case 102004: goto L17;
                default: goto L11;
            };
        L17:
            r5.e(j.f10389i.decode(r6));
            goto L3
        L18:
            r5.c(e.f10281g.decode(r6));
            goto L3
        L19:
            r5.i(a0.f10178h.decode(r6));
            goto L3
        L20:
            r5.f(l.f10403g.decode(r6));
            goto L3
        L11:
            switch(r2) {
                case 112001: goto L16;
                case 112002: goto L15;
                case 112003: goto L14;
                case 112004: goto L13;
                default: goto L12;
            };
        L13:
            r5.g(n.f10424g.decode(r6));
            goto L3
        L14:
            r5.d(h.f10344i.decode(r6));
            goto L3
        L15:
            r5.j(j0.f10396f.decode(r6));
            goto L3
        L16:
            r5.h(v.f10551j.decode(r6));
            goto L3
        L12:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L29:
            r6.endMessage(r0);
            return r5.b();
        }

        public void b(ProtoWriter r3, e0 r4) {
            com.obric.matrix.w.b.f10192g.encodeWithTag(r3, 100000, r4.f10284f);
            l0.f10406g.encodeWithTag(r3, 101001, r4.f10285g);
            x0.f10586g.encodeWithTag(r3, 101002, r4.f10286h);
            z0.f10602j.encodeWithTag(r3, 101003, r4.f10287i);
            v0.f10561h.encodeWithTag(r3, 101004, r4.f10288j);
            t0.f10519g.encodeWithTag(r3, 101005, r4.f10289k);
            r0.f10498g.encodeWithTag(r3, 101006, r4.f10290l);
            l.f10403g.encodeWithTag(r3, 102001, r4.m);
            a0.f10178h.encodeWithTag(r3, 102002, r4.n);
            e.f10281g.encodeWithTag(r3, 102003, r4.o);
            j.f10389i.encodeWithTag(r3, 102004, r4.p);
            n0.f10427h.encodeWithTag(r3, 111001, r4.q);
            v.f10551j.encodeWithTag(r3, 112001, r4.r);
            j0.f10396f.encodeWithTag(r3, 112002, r4.s);
            h.f10344i.encodeWithTag(r3, 112003, r4.t);
            n.f10424g.encodeWithTag(r3, 112004, r4.u);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(e0 r4) {
            return (((((((((((((((com.obric.matrix.w.b.f10192g.encodedSizeWithTag(100000, r4.f10284f) + l0.f10406g.encodedSizeWithTag(101001, r4.f10285g)) + x0.f10586g.encodedSizeWithTag(101002, r4.f10286h)) + z0.f10602j.encodedSizeWithTag(101003, r4.f10287i)) + v0.f10561h.encodedSizeWithTag(101004, r4.f10288j)) + t0.f10519g.encodedSizeWithTag(101005, r4.f10289k)) + r0.f10498g.encodedSizeWithTag(101006, r4.f10290l)) + l.f10403g.encodedSizeWithTag(102001, r4.m)) + a0.f10178h.encodedSizeWithTag(102002, r4.n)) + e.f10281g.encodedSizeWithTag(102003, r4.o)) + j.f10389i.encodedSizeWithTag(102004, r4.p)) + n0.f10427h.encodedSizeWithTag(111001, r4.q)) + v.f10551j.encodedSizeWithTag(112001, r4.r)) + j0.f10396f.encodedSizeWithTag(112002, r4.s)) + h.f10344i.encodedSizeWithTag(112003, r4.t)) + n.f10424g.encodedSizeWithTag(112004, r4.u)) + r4.unknownFields().size();
        }

        public e0 d(e0 r2) {
            a r1 = r2.b();
            com.obric.matrix.w.b r3 = r1.f10291a;
            if (r3 == null) goto L5;
            r1.f10291a = com.obric.matrix.w.b.f10192g.redact(r3);
        L5:
            l0 r4 = r1.f10292b;
            if (r4 == null) goto L8;
            r1.f10292b = l0.f10406g.redact(r4);
        L8:
            x0 r5 = r1.f10293c;
            if (r5 == null) goto L11;
            r1.f10293c = x0.f10586g.redact(r5);
        L11:
            z0 r6 = r1.f10294d;
            if (r6 == null) goto L14;
            r1.f10294d = z0.f10602j.redact(r6);
        L14:
            v0 r7 = r1.f10295e;
            if (r7 == null) goto L17;
            r1.f10295e = v0.f10561h.redact(r7);
        L17:
            t0 r8 = r1.f10296f;
            if (r8 == null) goto L20;
            r1.f10296f = t0.f10519g.redact(r8);
        L20:
            r0 r9 = r1.f10297g;
            if (r9 == null) goto L23;
            r1.f10297g = r0.f10498g.redact(r9);
        L23:
            l r10 = r1.f10298h;
            if (r10 == null) goto L26;
            r1.f10298h = l.f10403g.redact(r10);
        L26:
            a0 r11 = r1.f10299i;
            if (r11 == null) goto L29;
            r1.f10299i = a0.f10178h.redact(r11);
        L29:
            e r12 = r1.f10300j;
            if (r12 == null) goto L32;
            r1.f10300j = e.f10281g.redact(r12);
        L32:
            j r13 = r1.f10301k;
            if (r13 == null) goto L35;
            r1.f10301k = j.f10389i.redact(r13);
        L35:
            n0 r14 = r1.f10302l;
            if (r14 == null) goto L38;
            r1.f10302l = n0.f10427h.redact(r14);
        L38:
            v r15 = r1.m;
            if (r15 == null) goto L41;
            r1.m = v.f10551j.redact(r15);
        L41:
            j0 r16 = r1.n;
            if (r16 == null) goto L44;
            r1.n = j0.f10396f.redact(r16);
        L44:
            h r17 = r1.o;
            if (r17 == null) goto L47;
            r1.o = h.f10344i.redact(r17);
        L47:
            n r18 = r1.p;
            if (r18 == null) goto L50;
            r1.p = n.f10424g.redact(r18);
        L50:
            r1.clearUnknownFields();
            return r1.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ e0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, e0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(e0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ e0 redact(e0 r1) {
            return d(r1);
        }
    }

    static {
        v = new b();
    }

    public e0(com.obric.matrix.w.b r4, l0 r5, x0 r6, z0 r7, v0 r8, t0 r9, r0 r10, l r11, a0 r12, e r13, j r14, n0 r15, v r16, j0 r17, h r18, n r19, k.h r20) {
        super(v, r20);
        this.f10284f = r4;
        this.f10285g = r5;
        this.f10286h = r6;
        this.f10287i = r7;
        this.f10288j = r8;
        this.f10289k = r9;
        this.f10290l = r10;
        this.m = r11;
        this.n = r12;
        this.o = r13;
        this.p = r14;
        this.q = r15;
        this.r = r16;
        this.s = r17;
        this.t = r18;
        this.u = r19;
    }

    public a b() {
        a r0 = new a();
        r0.f10291a = this.f10284f;
        r0.f10292b = this.f10285g;
        r0.f10293c = this.f10286h;
        r0.f10294d = this.f10287i;
        r0.f10295e = this.f10288j;
        r0.f10296f = this.f10289k;
        r0.f10297g = this.f10290l;
        r0.f10298h = this.m;
        r0.f10299i = this.n;
        r0.f10300j = this.o;
        r0.f10301k = this.p;
        r0.f10302l = this.q;
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
        if ((r5 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r6 = (e0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L44;
        if (Internal.equals(this.f10284f, r6.f10284f) == false) goto L44;
        if (Internal.equals(this.f10285g, r6.f10285g) == false) goto L44;
        if (Internal.equals(this.f10286h, r6.f10286h) == false) goto L44;
        if (Internal.equals(this.f10287i, r6.f10287i) == false) goto L44;
        if (Internal.equals(this.f10288j, r6.f10288j) == false) goto L44;
        if (Internal.equals(this.f10289k, r6.f10289k) == false) goto L44;
        if (Internal.equals(this.f10290l, r6.f10290l) == false) goto L44;
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
        com.obric.matrix.w.b r2 = this.f10284f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        l0 r6 = this.f10285g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        x0 r9 = this.f10286h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        z0 r12 = this.f10287i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        v0 r15 = this.f10288j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        t0 r18 = this.f10289k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        r0 r21 = this.f10290l;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        l r24 = this.m;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        a0 r27 = this.n;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        e r30 = this.o;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        j r33 = this.p;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        n0 r36 = this.q;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        v r39 = this.r;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        j0 r42 = this.s;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        h r45 = this.t;
        if (r45 == null) goto L63;
        int r46 = r45.hashCode();
    L64:
        int r47 = (r44 + r46) * 37;
        n r48 = this.u;
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
        if (this.f10284f == null) goto L6;
        r0.append(", bizExampleResponse=");
        r0.append(this.f10284f);
    L6:
        if (this.f10285g == null) goto L9;
        r0.append(", sendWsMessageResponse=");
        r0.append(this.f10285g);
    L9:
        if (this.f10286h == null) goto L12;
        r0.append(", subscribeWsMsgResponse=");
        r0.append(this.f10286h);
    L12:
        if (this.f10287i == null) goto L15;
        r0.append(", subscribeWsStatusResponse=");
        r0.append(this.f10287i);
    L15:
        if (this.f10288j == null) goto L18;
        r0.append(", subscribeWsMsgByProviderResponse=");
        r0.append(this.f10288j);
    L18:
        if (this.f10289k == null) goto L21;
        r0.append(", subscribeWsMsgByCallBackResponse=");
        r0.append(this.f10289k);
    L21:
        if (this.f10290l == null) goto L24;
        r0.append(", subscribeWsMsgByBroadCastResponse=");
        r0.append(this.f10290l);
    L24:
        if (this.m == null) goto L27;
        r0.append(", getLocationResponse=");
        r0.append(this.m);
    L27:
        if (this.n == null) goto L30;
        r0.append(", refreshLocationResponse=");
        r0.append(this.n);
    L30:
        if (this.o == null) goto L33;
        r0.append(", decodeLocationResponse=");
        r0.append(this.o);
    L33:
        if (this.p == null) goto L36;
        r0.append(", getIntersectFencesResponse=");
        r0.append(this.p);
    L36:
        if (this.q == null) goto L39;
        r0.append(", startPicoLinksResponse=");
        r0.append(this.q);
    L39:
        if (this.r == null) goto L42;
        r0.append(", onePartyCommonNetworkResponse=");
        r0.append(this.r);
    L42:
        if (this.s == null) goto L45;
        r0.append(", sendApplogEventResponse=");
        r0.append(this.s);
    L45:
        if (this.t == null) goto L48;
        r0.append(", genericNetworkResponse=");
        r0.append(this.t);
    L48:
        if (this.u == null) goto L50;
        r0.append(", getTTNetParametersResponse=");
        r0.append(this.u);
    L50:
        StringBuilder r3 = r0.replace(0, 2, "ResponseBody{");
        r3.append('}');
        return r3.toString();
    }
}
