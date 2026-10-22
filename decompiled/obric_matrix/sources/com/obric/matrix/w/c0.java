package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends Message<c0, a> {
    public static final ProtoAdapter<c0> w = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.BizExampleRequest#ADAPTER", tag = 100000)
    @com.google.gson.y.c("bizExampleRequest")
    public final com.obric.matrix.w.a f10238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageRequest#ADAPTER", tag = 101001)
    @com.google.gson.y.c("sendWsMessageRequest")
    public final k0 f10239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgRequest#ADAPTER", tag = 101002)
    @com.google.gson.y.c("subscribeWsMsgRequest")
    public final w0 f10240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusRequest#ADAPTER", tag = 101003)
    @com.google.gson.y.c("subscribeWsStatusRequest")
    public final y0 f10241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderRequest#ADAPTER", tag = 101004)
    @com.google.gson.y.c("subscribeWsMsgByProviderRequest")
    public final u0 f10242j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackRequest#ADAPTER", tag = 101005)
    @com.google.gson.y.c("subscribeWsMsgByCallBackRequest")
    public final s0 f10243k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastRequest#ADAPTER", tag = 101006)
    @com.google.gson.y.c("subscribeWsMsgByBroadCastRequest")
    public final q0 f10244l;

    @WireField(adapter = "com.obric.matrix.proto.GetLocationRequest#ADAPTER", tag = 102001)
    @com.google.gson.y.c("getLocationRequest")
    public final k m;

    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationRequest#ADAPTER", tag = 102002)
    @com.google.gson.y.c("refreshLocationRequest")
    public final z n;

    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationRequest#ADAPTER", tag = 102003)
    @com.google.gson.y.c("decodeLocationRequest")
    public final d o;

    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesRequest#ADAPTER", tag = 102004)
    @com.google.gson.y.c("getIntersectFencesRequest")
    public final i p;

    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest#ADAPTER", tag = 111001)
    @com.google.gson.y.c("startPicoLinksRequest")
    public final m0 q;

    @WireField(adapter = "com.obric.matrix.proto.PicoLinksCallback#ADAPTER", tag = 111002)
    @com.google.gson.y.c("picoLinksCallback")
    public final w r;

    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkRequest#ADAPTER", tag = 112001)
    @com.google.gson.y.c("onePartyCommonNetworkRequest")
    public final u s;

    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventRequest#ADAPTER", tag = 112002)
    @com.google.gson.y.c("sendApplogEventRequest")
    public final i0 t;

    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkRequest#ADAPTER", tag = 112003)
    @com.google.gson.y.c("genericNetworkRequest")
    public final g u;

    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersRequest#ADAPTER", tag = 112004)
    @com.google.gson.y.c("getTTNetParametersRequest")
    public final m v;

    public static final class a extends Message.Builder<c0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.obric.matrix.w.a f10245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k0 f10246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public w0 f10247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public y0 f10248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public u0 f10249e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public s0 f10250f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public q0 f10251g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public k f10252h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public z f10253i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public d f10254j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public i f10255k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public m0 f10256l;
        public w m;
        public u n;
        public i0 o;
        public g p;
        public m q;

        public a() {
        }

        public a a(com.obric.matrix.w.a r1) {
            this.f10245a = r1;
            return this;
        }

        public c0 b() {
            return new c0(this.f10245a, this.f10246b, this.f10247c, this.f10248d, this.f10249e, this.f10250f, this.f10251g, this.f10252h, this.f10253i, this.f10254j, this.f10255k, this.f10256l, this.m, this.n, this.o, this.p, this.q, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(d r1) {
            this.f10254j = r1;
            return this;
        }

        public a d(g r1) {
            this.p = r1;
            return this;
        }

        public a e(i r1) {
            this.f10255k = r1;
            return this;
        }

        public a f(k r1) {
            this.f10252h = r1;
            return this;
        }

        public a g(m r1) {
            this.q = r1;
            return this;
        }

        public a h(u r1) {
            this.n = r1;
            return this;
        }

        public a i(w r1) {
            this.m = r1;
            return this;
        }

        public a j(z r1) {
            this.f10253i = r1;
            return this;
        }

        public a k(i0 r1) {
            this.o = r1;
            return this;
        }

        public a l(k0 r1) {
            this.f10246b = r1;
            return this;
        }

        public a m(m0 r1) {
            this.f10256l = r1;
            return this;
        }

        public a n(q0 r1) {
            this.f10251g = r1;
            return this;
        }

        public a o(s0 r1) {
            this.f10250f = r1;
            return this;
        }

        public a p(u0 r1) {
            this.f10249e = r1;
            return this;
        }

        public a q(w0 r1) {
            this.f10247c = r1;
            return this;
        }

        public a r(y0 r1) {
            this.f10248d = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<c0> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, c0.class);
        }

        public c0 a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L29;
            if (r2 != 100000) goto L7;
            r5.a(com.obric.matrix.w.a.f10175g.decode(r6));
            goto L3
        L7:
            switch(r2) {
                case 101001: goto L27;
                case 101002: goto L26;
                case 101003: goto L25;
                case 101004: goto L24;
                case 101005: goto L23;
                case 101006: goto L22;
                default: goto L8;
            };
        L22:
            r5.n(q0.f10486j.decode(r6));
            goto L3
        L23:
            r5.o(s0.f10506j.decode(r6));
            goto L3
        L24:
            r5.p(u0.f10542j.decode(r6));
            goto L3
        L25:
            r5.r(y0.f10592h.decode(r6));
            goto L3
        L26:
            r5.q(w0.f10572j.decode(r6));
            goto L3
        L27:
            r5.l(k0.f10400g.decode(r6));
            goto L3
        L8:
            switch(r2) {
                case 102001: goto L21;
                case 102002: goto L20;
                case 102003: goto L19;
                case 102004: goto L18;
                default: goto L9;
            };
        L18:
            r5.e(i.o.decode(r6));
            goto L3
        L19:
            r5.c(d.f10257i.decode(r6));
            goto L3
        L20:
            r5.j(z.f10597h.decode(r6));
            goto L3
        L21:
            r5.f(k.f10397g.decode(r6));
            goto L3
        L9:
            switch(r2) {
                case 111001: goto L17;
                case 111002: goto L16;
                default: goto L10;
            };
        L16:
            r5.i(w.f10566h.decode(r6));
            goto L3
        L17:
            r5.m(m0.f10410i.decode(r6));
            goto L3
        L10:
            switch(r2) {
                case 112001: goto L15;
                case 112002: goto L14;
                case 112003: goto L13;
                case 112004: goto L12;
                default: goto L11;
            };
        L12:
            r5.g(m.f10409f.decode(r6));
            goto L3
        L13:
            r5.d(g.m.decode(r6));
            goto L3
        L14:
            r5.k(i0.f10383h.decode(r6));
            goto L3
        L15:
            r5.h(u.o.decode(r6));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L29:
            r6.endMessage(r0);
            return r5.b();
        }

        public void b(ProtoWriter r3, c0 r4) {
            com.obric.matrix.w.a.f10175g.encodeWithTag(r3, 100000, r4.f10238f);
            k0.f10400g.encodeWithTag(r3, 101001, r4.f10239g);
            w0.f10572j.encodeWithTag(r3, 101002, r4.f10240h);
            y0.f10592h.encodeWithTag(r3, 101003, r4.f10241i);
            u0.f10542j.encodeWithTag(r3, 101004, r4.f10242j);
            s0.f10506j.encodeWithTag(r3, 101005, r4.f10243k);
            q0.f10486j.encodeWithTag(r3, 101006, r4.f10244l);
            k.f10397g.encodeWithTag(r3, 102001, r4.m);
            z.f10597h.encodeWithTag(r3, 102002, r4.n);
            d.f10257i.encodeWithTag(r3, 102003, r4.o);
            i.o.encodeWithTag(r3, 102004, r4.p);
            m0.f10410i.encodeWithTag(r3, 111001, r4.q);
            w.f10566h.encodeWithTag(r3, 111002, r4.r);
            u.o.encodeWithTag(r3, 112001, r4.s);
            i0.f10383h.encodeWithTag(r3, 112002, r4.t);
            g.m.encodeWithTag(r3, 112003, r4.u);
            m.f10409f.encodeWithTag(r3, 112004, r4.v);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(c0 r4) {
            return ((((((((((((((((com.obric.matrix.w.a.f10175g.encodedSizeWithTag(100000, r4.f10238f) + k0.f10400g.encodedSizeWithTag(101001, r4.f10239g)) + w0.f10572j.encodedSizeWithTag(101002, r4.f10240h)) + y0.f10592h.encodedSizeWithTag(101003, r4.f10241i)) + u0.f10542j.encodedSizeWithTag(101004, r4.f10242j)) + s0.f10506j.encodedSizeWithTag(101005, r4.f10243k)) + q0.f10486j.encodedSizeWithTag(101006, r4.f10244l)) + k.f10397g.encodedSizeWithTag(102001, r4.m)) + z.f10597h.encodedSizeWithTag(102002, r4.n)) + d.f10257i.encodedSizeWithTag(102003, r4.o)) + i.o.encodedSizeWithTag(102004, r4.p)) + m0.f10410i.encodedSizeWithTag(111001, r4.q)) + w.f10566h.encodedSizeWithTag(111002, r4.r)) + u.o.encodedSizeWithTag(112001, r4.s)) + i0.f10383h.encodedSizeWithTag(112002, r4.t)) + g.m.encodedSizeWithTag(112003, r4.u)) + m.f10409f.encodedSizeWithTag(112004, r4.v)) + r4.unknownFields().size();
        }

        public c0 d(c0 r2) {
            a r1 = r2.b();
            com.obric.matrix.w.a r3 = r1.f10245a;
            if (r3 == null) goto L5;
            r1.f10245a = com.obric.matrix.w.a.f10175g.redact(r3);
        L5:
            k0 r4 = r1.f10246b;
            if (r4 == null) goto L8;
            r1.f10246b = k0.f10400g.redact(r4);
        L8:
            w0 r5 = r1.f10247c;
            if (r5 == null) goto L11;
            r1.f10247c = w0.f10572j.redact(r5);
        L11:
            y0 r6 = r1.f10248d;
            if (r6 == null) goto L14;
            r1.f10248d = y0.f10592h.redact(r6);
        L14:
            u0 r7 = r1.f10249e;
            if (r7 == null) goto L17;
            r1.f10249e = u0.f10542j.redact(r7);
        L17:
            s0 r8 = r1.f10250f;
            if (r8 == null) goto L20;
            r1.f10250f = s0.f10506j.redact(r8);
        L20:
            q0 r9 = r1.f10251g;
            if (r9 == null) goto L23;
            r1.f10251g = q0.f10486j.redact(r9);
        L23:
            k r10 = r1.f10252h;
            if (r10 == null) goto L26;
            r1.f10252h = k.f10397g.redact(r10);
        L26:
            z r11 = r1.f10253i;
            if (r11 == null) goto L29;
            r1.f10253i = z.f10597h.redact(r11);
        L29:
            d r12 = r1.f10254j;
            if (r12 == null) goto L32;
            r1.f10254j = d.f10257i.redact(r12);
        L32:
            i r13 = r1.f10255k;
            if (r13 == null) goto L35;
            r1.f10255k = i.o.redact(r13);
        L35:
            m0 r14 = r1.f10256l;
            if (r14 == null) goto L38;
            r1.f10256l = m0.f10410i.redact(r14);
        L38:
            w r15 = r1.m;
            if (r15 == null) goto L41;
            r1.m = w.f10566h.redact(r15);
        L41:
            u r16 = r1.n;
            if (r16 == null) goto L44;
            r1.n = u.o.redact(r16);
        L44:
            i0 r17 = r1.o;
            if (r17 == null) goto L47;
            r1.o = i0.f10383h.redact(r17);
        L47:
            g r18 = r1.p;
            if (r18 == null) goto L50;
            r1.p = g.m.redact(r18);
        L50:
            m r19 = r1.q;
            if (r19 == null) goto L53;
            r1.q = m.f10409f.redact(r19);
        L53:
            r1.clearUnknownFields();
            return r1.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ c0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, c0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(c0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ c0 redact(c0 r1) {
            return d(r1);
        }
    }

    static {
        w = new b();
    }

    public c0(com.obric.matrix.w.a r4, k0 r5, w0 r6, y0 r7, u0 r8, s0 r9, q0 r10, k r11, z r12, d r13, i r14, m0 r15, w r16, u r17, i0 r18, g r19, m r20, k.h r21) {
        super(w, r21);
        this.f10238f = r4;
        this.f10239g = r5;
        this.f10240h = r6;
        this.f10241i = r7;
        this.f10242j = r8;
        this.f10243k = r9;
        this.f10244l = r10;
        this.m = r11;
        this.n = r12;
        this.o = r13;
        this.p = r14;
        this.q = r15;
        this.r = r16;
        this.s = r17;
        this.t = r18;
        this.u = r19;
        this.v = r20;
    }

    public a b() {
        a r0 = new a();
        r0.f10245a = this.f10238f;
        r0.f10246b = this.f10239g;
        r0.f10247c = this.f10240h;
        r0.f10248d = this.f10241i;
        r0.f10249e = this.f10242j;
        r0.f10250f = this.f10243k;
        r0.f10251g = this.f10244l;
        r0.f10252h = this.m;
        r0.f10253i = this.n;
        r0.f10254j = this.o;
        r0.f10255k = this.p;
        r0.f10256l = this.q;
        r0.m = this.r;
        r0.n = this.s;
        r0.o = this.t;
        r0.p = this.u;
        r0.q = this.v;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r6 = (c0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L46;
        if (Internal.equals(this.f10238f, r6.f10238f) == false) goto L46;
        if (Internal.equals(this.f10239g, r6.f10239g) == false) goto L46;
        if (Internal.equals(this.f10240h, r6.f10240h) == false) goto L46;
        if (Internal.equals(this.f10241i, r6.f10241i) == false) goto L46;
        if (Internal.equals(this.f10242j, r6.f10242j) == false) goto L46;
        if (Internal.equals(this.f10243k, r6.f10243k) == false) goto L46;
        if (Internal.equals(this.f10244l, r6.f10244l) == false) goto L46;
        if (Internal.equals(this.m, r6.m) == false) goto L46;
        if (Internal.equals(this.n, r6.n) == false) goto L46;
        if (Internal.equals(this.o, r6.o) == false) goto L46;
        if (Internal.equals(this.p, r6.p) == false) goto L46;
        if (Internal.equals(this.q, r6.q) == false) goto L46;
        if (Internal.equals(this.r, r6.r) == false) goto L46;
        if (Internal.equals(this.s, r6.s) == false) goto L46;
        if (Internal.equals(this.t, r6.t) == false) goto L46;
        if (Internal.equals(this.u, r6.u) == false) goto L46;
        if (Internal.equals(this.v, r6.v) == false) goto L46;
        return true;
    L46:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L73;
        int r1 = unknownFields().hashCode() * 37;
        com.obric.matrix.w.a r2 = this.f10238f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        k0 r6 = this.f10239g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        w0 r9 = this.f10240h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        y0 r12 = this.f10241i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        u0 r15 = this.f10242j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        s0 r18 = this.f10243k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        q0 r21 = this.f10244l;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        k r24 = this.m;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        z r27 = this.n;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        d r30 = this.o;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        i r33 = this.p;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        m0 r36 = this.q;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        w r39 = this.r;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        u r42 = this.s;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        i0 r45 = this.t;
        if (r45 == null) goto L63;
        int r46 = r45.hashCode();
    L64:
        int r47 = (r44 + r46) * 37;
        g r48 = this.u;
        if (r48 == null) goto L67;
        int r49 = r48.hashCode();
    L68:
        int r50 = (r47 + r49) * 37;
        m r51 = this.v;
        if (r51 == null) goto L71;
        r3 = r51.hashCode();
    L71:
        int r52 = r50 + r3;
        this.hashCode = r52;
        return r52;
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
    L73:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10238f == null) goto L6;
        r0.append(", bizExampleRequest=");
        r0.append(this.f10238f);
    L6:
        if (this.f10239g == null) goto L9;
        r0.append(", sendWsMessageRequest=");
        r0.append(this.f10239g);
    L9:
        if (this.f10240h == null) goto L12;
        r0.append(", subscribeWsMsgRequest=");
        r0.append(this.f10240h);
    L12:
        if (this.f10241i == null) goto L15;
        r0.append(", subscribeWsStatusRequest=");
        r0.append(this.f10241i);
    L15:
        if (this.f10242j == null) goto L18;
        r0.append(", subscribeWsMsgByProviderRequest=");
        r0.append(this.f10242j);
    L18:
        if (this.f10243k == null) goto L21;
        r0.append(", subscribeWsMsgByCallBackRequest=");
        r0.append(this.f10243k);
    L21:
        if (this.f10244l == null) goto L24;
        r0.append(", subscribeWsMsgByBroadCastRequest=");
        r0.append(this.f10244l);
    L24:
        if (this.m == null) goto L27;
        r0.append(", getLocationRequest=");
        r0.append(this.m);
    L27:
        if (this.n == null) goto L30;
        r0.append(", refreshLocationRequest=");
        r0.append(this.n);
    L30:
        if (this.o == null) goto L33;
        r0.append(", decodeLocationRequest=");
        r0.append(this.o);
    L33:
        if (this.p == null) goto L36;
        r0.append(", getIntersectFencesRequest=");
        r0.append(this.p);
    L36:
        if (this.q == null) goto L39;
        r0.append(", startPicoLinksRequest=");
        r0.append(this.q);
    L39:
        if (this.r == null) goto L42;
        r0.append(", picoLinksCallback=");
        r0.append(this.r);
    L42:
        if (this.s == null) goto L45;
        r0.append(", onePartyCommonNetworkRequest=");
        r0.append(this.s);
    L45:
        if (this.t == null) goto L48;
        r0.append(", sendApplogEventRequest=");
        r0.append(this.t);
    L48:
        if (this.u == null) goto L51;
        r0.append(", genericNetworkRequest=");
        r0.append(this.u);
    L51:
        if (this.v == null) goto L53;
        r0.append(", getTTNetParametersRequest=");
        r0.append(this.v);
    L53:
        StringBuilder r3 = r0.replace(0, 2, "RequestBody{");
        r3.append('}');
        return r3.toString();
    }
}
