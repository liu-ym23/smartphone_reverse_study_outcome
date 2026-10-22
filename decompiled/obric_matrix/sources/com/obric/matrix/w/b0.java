package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends Message<b0, a> {
    public static final ProtoAdapter<b0> r = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @com.google.gson.y.c("cmd")
    public final Integer f10195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("sequenceId")
    public final String f10196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @com.google.gson.y.c("sdkVersion")
    public final String f10197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @com.google.gson.y.c("appKey")
    public final String f10198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @com.google.gson.y.c("deviceId")
    public final String f10199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @com.google.gson.y.c("channel")
    public final String f10200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @com.google.gson.y.c("appVersionCode")
    public final String f10201l;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @com.google.gson.y.c("extraParams")
    public final Map<String, String> m;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    @com.google.gson.y.c("appPkg")
    public final String n;

    @WireField(adapter = "com.obric.matrix.proto.RequestBody#ADAPTER", tag = 11)
    @com.google.gson.y.c("body")
    public final c0 o;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    @com.google.gson.y.c("accessToken")
    public final String p;

    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 13)
    @com.google.gson.y.c("monitorInfo")
    public final q q;

    public static final class a extends Message.Builder<b0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10204c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f10205d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10206e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10207f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10208g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Map<String, String> f10209h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f10210i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public c0 f10211j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f10212k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public q f10213l;

        public a() {
            this.f10202a = 0;
            this.f10203b = "";
            this.f10204c = "";
            this.f10205d = "";
            this.f10206e = "";
            this.f10207f = "";
            this.f10208g = "";
            this.f10210i = "";
            this.f10212k = "";
            this.f10209h = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f10212k = r1;
            return this;
        }

        public a b(String r1) {
            this.f10205d = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return f();
        }

        public a c(String r1) {
            this.f10210i = r1;
            return this;
        }

        public a d(String r1) {
            this.f10208g = r1;
            return this;
        }

        public a e(c0 r1) {
            this.f10211j = r1;
            return this;
        }

        public b0 f() {
            return new b0(this.f10202a, this.f10203b, this.f10204c, this.f10205d, this.f10206e, this.f10207f, this.f10208g, this.f10209h, this.f10210i, this.f10211j, this.f10212k, this.f10213l, super.buildUnknownFields());
        }

        public a g(String r1) {
            this.f10207f = r1;
            return this;
        }

        public a h(Integer r1) {
            this.f10202a = r1;
            return this;
        }

        public a i(String r1) {
            this.f10206e = r1;
            return this;
        }

        public a j(q r1) {
            this.f10213l = r1;
            return this;
        }

        public a k(String r1) {
            this.f10204c = r1;
            return this;
        }

        public a l(String r1) {
            this.f10203b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<b0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10214a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, b0.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10214a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public b0 a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L6;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r0.j(q.f10475k.decode(r7));
            goto L3
        L8:
            r0.a(ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            r0.e(c0.w.decode(r7));
            goto L3
        L10:
            r0.c(ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            r0.f10209h.putAll(this.f10214a.decode(r7));
            goto L3
        L12:
            r0.d(ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            r0.g(ProtoAdapter.STRING.decode(r7));
            goto L3
        L14:
            r0.i(ProtoAdapter.STRING.decode(r7));
            goto L3
        L15:
            r0.b(ProtoAdapter.STRING.decode(r7));
            goto L3
        L16:
            r0.k(ProtoAdapter.STRING.decode(r7));
            goto L3
        L17:
            r0.l(ProtoAdapter.STRING.decode(r7));
            goto L3
        L18:
            r0.h(ProtoAdapter.INT32.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L19:
            r7.endMessage(r1);
            return r0.f();
        }

        public void b(ProtoWriter r4, b0 r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.f10195f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 2, r5.f10196g);
            r0.encodeWithTag(r4, 3, r5.f10197h);
            r0.encodeWithTag(r4, 4, r5.f10198i);
            r0.encodeWithTag(r4, 5, r5.f10199j);
            r0.encodeWithTag(r4, 6, r5.f10200k);
            r0.encodeWithTag(r4, 7, r5.f10201l);
            this.f10214a.encodeWithTag(r4, 9, r5.m);
            r0.encodeWithTag(r4, 10, r5.n);
            c0.w.encodeWithTag(r4, 11, r5.o);
            r0.encodeWithTag(r4, 12, r5.p);
            q.f10475k.encodeWithTag(r4, 13, r5.q);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(b0 r5) {
            int r0 = ProtoAdapter.INT32.encodedSizeWithTag(1, r5.f10195f);
            ProtoAdapter<String> r1 = ProtoAdapter.STRING;
            return (((((((((((r0 + r1.encodedSizeWithTag(2, r5.f10196g)) + r1.encodedSizeWithTag(3, r5.f10197h)) + r1.encodedSizeWithTag(4, r5.f10198i)) + r1.encodedSizeWithTag(5, r5.f10199j)) + r1.encodedSizeWithTag(6, r5.f10200k)) + r1.encodedSizeWithTag(7, r5.f10201l)) + this.f10214a.encodedSizeWithTag(9, r5.m)) + r1.encodedSizeWithTag(10, r5.n)) + c0.w.encodedSizeWithTag(11, r5.o)) + r1.encodedSizeWithTag(12, r5.p)) + q.f10475k.encodedSizeWithTag(13, r5.q)) + r5.unknownFields().size();
        }

        public b0 d(b0 r2) {
            a r1 = r2.b();
            c0 r3 = r1.f10211j;
            if (r3 == null) goto L5;
            r1.f10211j = c0.w.redact(r3);
        L5:
            q r4 = r1.f10213l;
            if (r4 == null) goto L8;
            r1.f10213l = q.f10475k.redact(r4);
        L8:
            r1.clearUnknownFields();
            return r1.f();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ b0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, b0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(b0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ b0 redact(b0 r1) {
            return d(r1);
        }
    }

    static {
        r = new b();
    }

    public b0(Integer r2, String r3, String r4, String r5, String r6, String r7, String r8, Map<String, String> r9, String r10, c0 r11, String r12, q r13, k.h r14) {
        super(r, r14);
        this.f10195f = r2;
        this.f10196g = r3;
        this.f10197h = r4;
        this.f10198i = r5;
        this.f10199j = r6;
        this.f10200k = r7;
        this.f10201l = r8;
        this.m = Internal.immutableCopyOf("extraParams", r9);
        this.n = r10;
        this.o = r11;
        this.p = r12;
        this.q = r13;
    }

    public a b() {
        a r0 = new a();
        r0.f10202a = this.f10195f;
        r0.f10203b = this.f10196g;
        r0.f10204c = this.f10197h;
        r0.f10205d = this.f10198i;
        r0.f10206e = this.f10199j;
        r0.f10207f = this.f10200k;
        r0.f10208g = this.f10201l;
        r0.f10209h = Internal.copyOf("extraParams", this.m);
        r0.f10210i = this.n;
        r0.f10211j = this.o;
        r0.f10212k = this.p;
        r0.f10213l = this.q;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r6 = (b0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L36;
        if (Internal.equals(this.f10195f, r6.f10195f) == false) goto L36;
        if (Internal.equals(this.f10196g, r6.f10196g) == false) goto L36;
        if (Internal.equals(this.f10197h, r6.f10197h) == false) goto L36;
        if (Internal.equals(this.f10198i, r6.f10198i) == false) goto L36;
        if (Internal.equals(this.f10199j, r6.f10199j) == false) goto L36;
        if (Internal.equals(this.f10200k, r6.f10200k) == false) goto L36;
        if (Internal.equals(this.f10201l, r6.f10201l) == false) goto L36;
        if (this.m.equals(r6.m) == false) goto L36;
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
        Integer r2 = this.f10195f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10196g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10197h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.f10198i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.f10199j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f10200k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.f10201l;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (((r20 + r22) * 37) + this.m.hashCode()) * 37;
        String r24 = this.n;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        c0 r27 = this.o;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.p;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        q r33 = this.q;
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
        if (this.f10195f == null) goto L6;
        r0.append(", cmd=");
        r0.append(this.f10195f);
    L6:
        if (this.f10196g == null) goto L9;
        r0.append(", sequenceId=");
        r0.append(this.f10196g);
    L9:
        if (this.f10197h == null) goto L12;
        r0.append(", sdkVersion=");
        r0.append(this.f10197h);
    L12:
        if (this.f10198i == null) goto L15;
        r0.append(", appKey=");
        r0.append(this.f10198i);
    L15:
        if (this.f10199j == null) goto L18;
        r0.append(", deviceId=");
        r0.append(this.f10199j);
    L18:
        if (this.f10200k == null) goto L21;
        r0.append(", channel=");
        r0.append(this.f10200k);
    L21:
        if (this.f10201l == null) goto L23;
        r0.append(", appVersionCode=");
        r0.append(this.f10201l);
    L23:
        Map<String, String> r1 = this.m;
        if (r1 == null) goto L29;
        if (r1.isEmpty() == true) goto L29;
        r0.append(", extraParams=");
        r0.append(this.m);
    L29:
        if (this.n == null) goto L32;
        r0.append(", appPkg=");
        r0.append(this.n);
    L32:
        if (this.o == null) goto L35;
        r0.append(", body=");
        r0.append(this.o);
    L35:
        if (this.p == null) goto L38;
        r0.append(", accessToken=");
        r0.append(this.p);
    L38:
        if (this.q == null) goto L40;
        r0.append(", monitorInfo=");
        r0.append(this.q);
    L40:
        StringBuilder r3 = r0.replace(0, 2, "Request{");
        r3.append('}');
        return r3.toString();
    }
}
