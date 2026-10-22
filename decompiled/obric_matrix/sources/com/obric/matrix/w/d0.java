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
public final class d0 extends Message<d0, a> {
    public static final ProtoAdapter<d0> o = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @com.google.gson.y.c("cmd")
    public final Integer f10264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @com.google.gson.y.c("statusCode")
    public final Integer f10265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @com.google.gson.y.c("errorMsg")
    public final String f10266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @com.google.gson.y.c("logId")
    public final String f10267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @com.google.gson.y.c("sequenceId")
    public final String f10268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.ResponseBody#ADAPTER", tag = 7)
    @com.google.gson.y.c("body")
    public final e0 f10269k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @com.google.gson.y.c("accessToken")
    public final String f10270l;

    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 9)
    @com.google.gson.y.c("monitorInfo")
    public final q m;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    @com.google.gson.y.c("extraParams")
    public final Map<String, String> n;

    public static final class a extends Message.Builder<d0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f10272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f10274d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10275e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e0 f10276f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10277g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public q f10278h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map<String, String> f10279i;

        public a() {
            this.f10271a = 0;
            this.f10272b = 0;
            this.f10273c = "";
            this.f10274d = "";
            this.f10275e = "";
            this.f10277g = "";
            this.f10279i = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f10277g = r1;
            return this;
        }

        public a b(e0 r1) {
            this.f10276f = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public d0 c() {
            return new d0(this.f10271a, this.f10272b, this.f10273c, this.f10274d, this.f10275e, this.f10276f, this.f10277g, this.f10278h, this.f10279i, super.buildUnknownFields());
        }

        public a d(Integer r1) {
            this.f10271a = r1;
            return this;
        }

        public a e(String r1) {
            this.f10273c = r1;
            return this;
        }

        public a f(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.f10279i = r1;
            return this;
        }

        public a g(String r1) {
            this.f10274d = r1;
            return this;
        }

        public a h(q r1) {
            this.f10278h = r1;
            return this;
        }

        public a i(String r1) {
            this.f10275e = r1;
            return this;
        }

        public a j(Integer r1) {
            this.f10272b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<d0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10280a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, d0.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10280a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public d0 a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L6;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r0.f10279i.putAll(this.f10280a.decode(r7));
            goto L3
        L8:
            r0.h(q.f10475k.decode(r7));
            goto L3
        L9:
            r0.a(ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            r0.b(e0.v.decode(r7));
            goto L3
        L11:
            r0.i(ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.g(ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            r0.e(ProtoAdapter.STRING.decode(r7));
            goto L3
        L14:
            r0.j(ProtoAdapter.INT32.decode(r7));
            goto L3
        L15:
            r0.d(ProtoAdapter.INT32.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L16:
            r7.endMessage(r1);
            return r0.c();
        }

        public void b(ProtoWriter r5, d0 r6) {
            ProtoAdapter<Integer> r0 = ProtoAdapter.INT32;
            r0.encodeWithTag(r5, 1, r6.f10264f);
            r0.encodeWithTag(r5, 2, r6.f10265g);
            ProtoAdapter<String> r1 = ProtoAdapter.STRING;
            r1.encodeWithTag(r5, 3, r6.f10266h);
            r1.encodeWithTag(r5, 4, r6.f10267i);
            r1.encodeWithTag(r5, 6, r6.f10268j);
            e0.v.encodeWithTag(r5, 7, r6.f10269k);
            r1.encodeWithTag(r5, 8, r6.f10270l);
            q.f10475k.encodeWithTag(r5, 9, r6.m);
            this.f10280a.encodeWithTag(r5, 10, r6.n);
            r5.writeBytes(r6.unknownFields());
        }

        public int c(d0 r6) {
            ProtoAdapter<Integer> r0 = ProtoAdapter.INT32;
            int r1 = r0.encodedSizeWithTag(1, r6.f10264f) + r0.encodedSizeWithTag(2, r6.f10265g);
            ProtoAdapter<String> r2 = ProtoAdapter.STRING;
            return (((((((r1 + r2.encodedSizeWithTag(3, r6.f10266h)) + r2.encodedSizeWithTag(4, r6.f10267i)) + r2.encodedSizeWithTag(6, r6.f10268j)) + e0.v.encodedSizeWithTag(7, r6.f10269k)) + r2.encodedSizeWithTag(8, r6.f10270l)) + q.f10475k.encodedSizeWithTag(9, r6.m)) + this.f10280a.encodedSizeWithTag(10, r6.n)) + r6.unknownFields().size();
        }

        public d0 d(d0 r2) {
            a r1 = r2.b();
            e0 r3 = r1.f10276f;
            if (r3 == null) goto L5;
            r1.f10276f = e0.v.redact(r3);
        L5:
            q r4 = r1.f10278h;
            if (r4 == null) goto L8;
            r1.f10278h = q.f10475k.redact(r4);
        L8:
            r1.clearUnknownFields();
            return r1.c();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ d0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, d0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(d0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ d0 redact(d0 r1) {
            return d(r1);
        }
    }

    static {
        o = new b();
    }

    public d0(Integer r2, Integer r3, String r4, String r5, String r6, e0 r7, String r8, q r9, Map<String, String> r10, k.h r11) {
        super(o, r11);
        this.f10264f = r2;
        this.f10265g = r3;
        this.f10266h = r4;
        this.f10267i = r5;
        this.f10268j = r6;
        this.f10269k = r7;
        this.f10270l = r8;
        this.m = r9;
        this.n = Internal.immutableCopyOf("extraParams", r10);
    }

    public a b() {
        a r0 = new a();
        r0.f10271a = this.f10264f;
        r0.f10272b = this.f10265g;
        r0.f10273c = this.f10266h;
        r0.f10274d = this.f10267i;
        r0.f10275e = this.f10268j;
        r0.f10276f = this.f10269k;
        r0.f10277g = this.f10270l;
        r0.f10278h = this.m;
        r0.f10279i = Internal.copyOf("extraParams", this.n);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r6 = (d0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.f10264f, r6.f10264f) == false) goto L30;
        if (Internal.equals(this.f10265g, r6.f10265g) == false) goto L30;
        if (Internal.equals(this.f10266h, r6.f10266h) == false) goto L30;
        if (Internal.equals(this.f10267i, r6.f10267i) == false) goto L30;
        if (Internal.equals(this.f10268j, r6.f10268j) == false) goto L30;
        if (Internal.equals(this.f10269k, r6.f10269k) == false) goto L30;
        if (Internal.equals(this.f10270l, r6.f10270l) == false) goto L30;
        if (Internal.equals(this.m, r6.m) == false) goto L30;
        if (this.n.equals(r6.n) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L37;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10264f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f10265g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10266h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.f10267i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.f10268j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        e0 r18 = this.f10269k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.f10270l;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        q r24 = this.m;
        if (r24 == null) goto L35;
        r3 = r24.hashCode();
    L35:
        int r25 = ((r23 + r3) * 37) + this.n.hashCode();
        this.hashCode = r25;
        return r25;
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
    L37:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10264f == null) goto L6;
        r0.append(", cmd=");
        r0.append(this.f10264f);
    L6:
        if (this.f10265g == null) goto L9;
        r0.append(", statusCode=");
        r0.append(this.f10265g);
    L9:
        if (this.f10266h == null) goto L12;
        r0.append(", errorMsg=");
        r0.append(this.f10266h);
    L12:
        if (this.f10267i == null) goto L15;
        r0.append(", logId=");
        r0.append(this.f10267i);
    L15:
        if (this.f10268j == null) goto L18;
        r0.append(", sequenceId=");
        r0.append(this.f10268j);
    L18:
        if (this.f10269k == null) goto L21;
        r0.append(", body=");
        r0.append(this.f10269k);
    L21:
        if (this.f10270l == null) goto L24;
        r0.append(", accessToken=");
        r0.append(this.f10270l);
    L24:
        if (this.m == null) goto L26;
        r0.append(", monitorInfo=");
        r0.append(this.m);
    L26:
        Map<String, String> r1 = this.n;
        if (r1 != null) goto L29;
    L31:
        StringBuilder r3 = r0.replace(0, 2, "Response{");
        r3.append('}');
        return r3.toString();
    L29:
        if (r1.isEmpty() == true) goto L31;
        r0.append(", extraParams=");
        r0.append(this.n);
        goto L31
    }
}
