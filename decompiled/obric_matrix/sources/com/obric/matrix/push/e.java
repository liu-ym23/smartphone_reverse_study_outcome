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
public final class e extends Message<e, a> {
    public static final ProtoAdapter<e> r = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f9537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.push.Flag#ADAPTER", tag = 2)
    public final d f9538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.push.Version#ADAPTER", tag = 3)
    public final l f9539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer f9540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long f9541j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.push.Payload_Type#ADAPTER", tag = 6)
    public final f f9542k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 255)
    public final Map<String, String> f9543l;

    @WireField(adapter = "com.obric.matrix.push.Push#ADAPTER", tag = 51)
    public final g m;

    @WireField(adapter = "com.obric.matrix.push.Fin#ADAPTER", tag = 52)
    public final c n;

    @WireField(adapter = "com.obric.matrix.push.Request#ADAPTER", tag = 53)
    public final h o;

    @WireField(adapter = "com.obric.matrix.push.Response#ADAPTER", tag = 54)
    public final i p;

    @WireField(adapter = "com.obric.matrix.push.Revoke#ADAPTER", tag = 55)
    public final k q;

    public static final class a extends Message.Builder<e, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f9545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public l f9546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f9547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f9548e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public f f9549f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map<String, String> f9550g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public g f9551h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public c f9552i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public h f9553j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public i f9554k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public k f9555l;

        public a() {
            this.f9550g = Internal.newMutableMap();
        }

        public e a() {
            return new e(this.f9544a, this.f9545b, this.f9546c, this.f9547d, this.f9548e, this.f9549f, this.f9550g, this.f9551h, this.f9552i, this.f9553j, this.f9554k, this.f9555l, super.buildUnknownFields());
        }

        public a b(c r1) {
            this.f9552i = r1;
            this.f9551h = null;
            this.f9553j = null;
            this.f9554k = null;
            this.f9555l = null;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(d r1) {
            this.f9545b = r1;
            return this;
        }

        public a d(String r1) {
            this.f9544a = r1;
            return this;
        }

        public a e(Integer r1) {
            this.f9547d = r1;
            return this;
        }

        public a f(f r1) {
            this.f9549f = r1;
            return this;
        }

        public a g(g r1) {
            this.f9551h = r1;
            this.f9552i = null;
            this.f9553j = null;
            this.f9554k = null;
            this.f9555l = null;
            return this;
        }

        public a h(h r1) {
            this.f9553j = r1;
            this.f9551h = null;
            this.f9552i = null;
            this.f9554k = null;
            this.f9555l = null;
            return this;
        }

        public a i(i r1) {
            this.f9554k = r1;
            this.f9551h = null;
            this.f9552i = null;
            this.f9553j = null;
            this.f9555l = null;
            return this;
        }

        public a j(k r1) {
            this.f9555l = r1;
            this.f9551h = null;
            this.f9552i = null;
            this.f9553j = null;
            this.f9554k = null;
            return this;
        }

        public a k(Long r1) {
            this.f9548e = r1;
            return this;
        }

        public a l(l r1) {
            this.f9546c = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f9556a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, e.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f9556a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public e a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L26;
            if (r3 != 255) goto L7;
            r0.f9550g.putAll(this.f9556a.decode(r9));
            goto L3
        L7:
            switch(r3) {
                case 1: goto L24;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L28;
                default: goto L8;
            };
        L28:
            r0.f(f.n.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L17:
            r0.k(ProtoAdapter.INT64.decode(r9));
            goto L3
        L18:
            r0.e(ProtoAdapter.INT32.decode(r9));
            goto L3
        L19:
            r0.l(l.f9627i.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            goto L3
        L20:
            r0.c(d.f9534k.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            goto L3
        L24:
            r0.d(ProtoAdapter.STRING.decode(r9));
            goto L3
        L8:
            switch(r3) {
                case 51: goto L14;
                case 52: goto L13;
                case 53: goto L12;
                case 54: goto L11;
                case 55: goto L10;
                default: goto L9;
            };
        L10:
            r0.j(k.f9611l.decode(r9));
            goto L3
        L11:
            r0.i(i.f9599j.decode(r9));
            goto L3
        L12:
            r0.h(h.f9586k.decode(r9));
            goto L3
        L13:
            r0.b(c.f9522i.decode(r9));
            goto L3
        L14:
            r0.g(g.I.decode(r9));
            goto L3
        L9:
            r9.readUnknownField(r3);
            goto L3
        L26:
            r0.addUnknownFields(r9.endMessageAndGetUnknownFields(r1));
            return r0.a();
        }

        public void b(ProtoWriter r4, e r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.f9537f);
            d.f9534k.encodeWithTag(r4, 2, r5.f9538g);
            l.f9627i.encodeWithTag(r4, 3, r5.f9539h);
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r5.f9540i);
            ProtoAdapter.INT64.encodeWithTag(r4, 5, r5.f9541j);
            f.n.encodeWithTag(r4, 6, r5.f9542k);
            this.f9556a.encodeWithTag(r4, 255, r5.f9543l);
            g.I.encodeWithTag(r4, 51, r5.m);
            c.f9522i.encodeWithTag(r4, 52, r5.n);
            h.f9586k.encodeWithTag(r4, 53, r5.o);
            i.f9599j.encodeWithTag(r4, 54, r5.p);
            k.f9611l.encodeWithTag(r4, 55, r5.q);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(e r5) {
            return (((((((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.f9537f) + d.f9534k.encodedSizeWithTag(2, r5.f9538g)) + l.f9627i.encodedSizeWithTag(3, r5.f9539h)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r5.f9540i)) + ProtoAdapter.INT64.encodedSizeWithTag(5, r5.f9541j)) + f.n.encodedSizeWithTag(6, r5.f9542k)) + this.f9556a.encodedSizeWithTag(255, r5.f9543l)) + g.I.encodedSizeWithTag(51, r5.m)) + c.f9522i.encodedSizeWithTag(52, r5.n)) + h.f9586k.encodedSizeWithTag(53, r5.o)) + i.f9599j.encodedSizeWithTag(54, r5.p)) + k.f9611l.encodedSizeWithTag(55, r5.q)) + r5.unknownFields().size();
        }

        public e d(e r2) {
            a r1 = r2.b();
            g r3 = r1.f9551h;
            if (r3 == null) goto L5;
            r1.f9551h = g.I.redact(r3);
        L5:
            c r4 = r1.f9552i;
            if (r4 == null) goto L8;
            r1.f9552i = c.f9522i.redact(r4);
        L8:
            h r5 = r1.f9553j;
            if (r5 == null) goto L11;
            r1.f9553j = h.f9586k.redact(r5);
        L11:
            i r6 = r1.f9554k;
            if (r6 == null) goto L14;
            r1.f9554k = i.f9599j.redact(r6);
        L14:
            k r7 = r1.f9555l;
            if (r7 == null) goto L17;
            r1.f9555l = k.f9611l.redact(r7);
        L17:
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ e decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, e r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(e r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ e redact(e r1) {
            return d(r1);
        }
    }

    static {
        r = new b();
        d r0 = d.f9530g;
        l r1 = l.f9625g;
        f r2 = f.f9557g;
    }

    public e(String r3, d r4, l r5, Integer r6, Long r7, f r8, Map<String, String> r9, g r10, c r11, h r12, i r13, k r14, k.h r15) {
        super(r, r15);
        if (Internal.countNonNull(r10, r11, r12, r13, new Object[]{r14}) > 1) goto L7;
        this.f9537f = r3;
        this.f9538g = r4;
        this.f9539h = r5;
        this.f9540i = r6;
        this.f9541j = r7;
        this.f9542k = r8;
        this.f9543l = Internal.immutableCopyOf(WsConstants.KEY_EXTRA, r9);
        this.m = r10;
        this.n = r11;
        this.o = r12;
        this.p = r13;
        this.q = r14;
        return;
    L7:
        throw new IllegalArgumentException("at most one of push, fin, request, response, revoke may be non-null");
    }

    public a b() {
        a r0 = new a();
        r0.f9544a = this.f9537f;
        r0.f9545b = this.f9538g;
        r0.f9546c = this.f9539h;
        r0.f9547d = this.f9540i;
        r0.f9548e = this.f9541j;
        r0.f9549f = this.f9542k;
        r0.f9550g = Internal.copyOf(this.f9543l);
        r0.f9551h = this.m;
        r0.f9552i = this.n;
        r0.f9553j = this.o;
        r0.f9554k = this.p;
        r0.f9555l = this.q;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L36;
        if (Internal.equals(this.f9537f, r6.f9537f) == false) goto L36;
        if (Internal.equals(this.f9538g, r6.f9538g) == false) goto L36;
        if (Internal.equals(this.f9539h, r6.f9539h) == false) goto L36;
        if (Internal.equals(this.f9540i, r6.f9540i) == false) goto L36;
        if (Internal.equals(this.f9541j, r6.f9541j) == false) goto L36;
        if (Internal.equals(this.f9542k, r6.f9542k) == false) goto L36;
        if (this.f9543l.equals(r6.f9543l) == false) goto L36;
        if (Internal.equals(this.m, r6.m) == false) goto L36;
        if (Internal.equals(this.n, r6.n) == false) goto L36;
        if (Internal.equals(this.o, r6.o) == false) goto L36;
        if (Internal.equals(this.p, r6.p) == false) goto L36;
        if (Internal.equals(this.q, r6.q) == false) goto L36;
        return true;
    L36:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L49;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f9537f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        d r6 = this.f9538g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        l r9 = this.f9539h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.f9540i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Long r15 = this.f9541j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        f r18 = this.f9542k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (((r17 + r19) * 37) + this.f9543l.hashCode()) * 37;
        g r21 = this.m;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        c r24 = this.n;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        h r27 = this.o;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        i r30 = this.p;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        k r33 = this.q;
        if (r33 == null) goto L47;
        r3 = r33.hashCode();
    L47:
        int r34 = r32 + r3;
        this.hashCode = r34;
        return r34;
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
    L49:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f9537f == null) goto L6;
        r0.append(", id=");
        r0.append(this.f9537f);
    L6:
        if (this.f9538g == null) goto L9;
        r0.append(", flag=");
        r0.append(this.f9538g);
    L9:
        if (this.f9539h == null) goto L12;
        r0.append(", version=");
        r0.append(this.f9539h);
    L12:
        if (this.f9540i == null) goto L15;
        r0.append(", need_fin=");
        r0.append(this.f9540i);
    L15:
        if (this.f9541j == null) goto L18;
        r0.append(", time_stamp=");
        r0.append(this.f9541j);
    L18:
        if (this.f9542k == null) goto L21;
        r0.append(", payload_type=");
        r0.append(this.f9542k);
    L21:
        if (this.f9543l.isEmpty() == true) goto L24;
        r0.append(", extra=");
        r0.append(this.f9543l);
    L24:
        if (this.m == null) goto L27;
        r0.append(", push=");
        r0.append(this.m);
    L27:
        if (this.n == null) goto L30;
        r0.append(", fin=");
        r0.append(this.n);
    L30:
        if (this.o == null) goto L33;
        r0.append(", request=");
        r0.append(this.o);
    L33:
        if (this.p == null) goto L36;
        r0.append(", response=");
        r0.append(this.p);
    L36:
        if (this.q == null) goto L38;
        r0.append(", revoke=");
        r0.append(this.q);
    L38:
        StringBuilder r3 = r0.replace(0, 2, "Packet{");
        r3.append('}');
        return r3.toString();
    }
}
