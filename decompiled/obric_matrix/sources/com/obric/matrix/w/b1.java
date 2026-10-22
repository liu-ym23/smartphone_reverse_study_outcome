package com.obric.matrix.w;

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
public final class b1 extends Message<b1, a> {
    public static final ProtoAdapter<b1> p = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    @com.google.gson.y.c("seqId")
    public final Long f10215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    @com.google.gson.y.c("logId")
    public final Long f10216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @com.google.gson.y.c("service")
    public final Integer f10217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @com.google.gson.y.c("method")
    public final Integer f10218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @com.google.gson.y.c("payloadType")
    public final String f10219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @com.google.gson.y.c("payloadEncoding")
    public final String f10220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    @com.google.gson.y.c(WsConstants.KEY_PAYLOAD)
    public final k.h f10221l;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @com.google.gson.y.c("cmd")
    public final Integer m;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    @com.google.gson.y.c("channelId")
    public final Integer n;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    @com.google.gson.y.c("headers")
    public final Map<String, String> o;

    public static final class a extends Message.Builder<b1, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f10222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f10223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f10224c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f10225d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10226e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10227f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public k.h f10228g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f10229h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f10230i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Map<String, String> f10231j;

        public a() {
            this.f10222a = 0L;
            this.f10223b = 0L;
            this.f10224c = 0;
            this.f10225d = 0;
            this.f10226e = "";
            this.f10227f = "";
            this.f10228g = k.h.f18266i;
            this.f10229h = 0;
            this.f10230i = 0;
            this.f10231j = Internal.newMutableMap();
        }

        public b1 a() {
            return new b1(this.f10222a, this.f10223b, this.f10224c, this.f10225d, this.f10226e, this.f10227f, this.f10228g, this.f10229h, this.f10230i, this.f10231j, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.f10230i = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r1) {
            this.f10229h = r1;
            return this;
        }

        public a d(Long r1) {
            this.f10223b = r1;
            return this;
        }

        public a e(Integer r1) {
            this.f10225d = r1;
            return this;
        }

        public a f(k.h r1) {
            this.f10228g = r1;
            return this;
        }

        public a g(String r1) {
            this.f10227f = r1;
            return this;
        }

        public a h(String r1) {
            this.f10226e = r1;
            return this;
        }

        public a i(Long r1) {
            this.f10222a = r1;
            return this;
        }

        public a j(Integer r1) {
            this.f10224c = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<b1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10232a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, b1.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10232a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public b1 a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L6;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r0.f10231j.putAll(this.f10232a.decode(r7));
            goto L3
        L8:
            r0.b(ProtoAdapter.INT32.decode(r7));
            goto L3
        L9:
            r0.c(ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            r0.f(ProtoAdapter.BYTES.decode(r7));
            goto L3
        L11:
            r0.g(ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.h(ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            r0.e(ProtoAdapter.INT32.decode(r7));
            goto L3
        L14:
            r0.j(ProtoAdapter.INT32.decode(r7));
            goto L3
        L15:
            r0.d(ProtoAdapter.INT64.decode(r7));
            goto L3
        L16:
            r0.i(ProtoAdapter.INT64.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L17:
            r7.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r5, b1 r6) {
            ProtoAdapter<Long> r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r5, 1, r6.f10215f);
            r0.encodeWithTag(r5, 2, r6.f10216g);
            ProtoAdapter<Integer> r1 = ProtoAdapter.INT32;
            r1.encodeWithTag(r5, 3, r6.f10217h);
            r1.encodeWithTag(r5, 4, r6.f10218i);
            ProtoAdapter<String> r2 = ProtoAdapter.STRING;
            r2.encodeWithTag(r5, 6, r6.f10219j);
            r2.encodeWithTag(r5, 7, r6.f10220k);
            ProtoAdapter.BYTES.encodeWithTag(r5, 8, r6.f10221l);
            r1.encodeWithTag(r5, 9, r6.m);
            r1.encodeWithTag(r5, 10, r6.n);
            this.f10232a.encodeWithTag(r5, 11, r6.o);
            r5.writeBytes(r6.unknownFields());
        }

        public int c(b1 r6) {
            ProtoAdapter<Long> r0 = ProtoAdapter.INT64;
            int r1 = r0.encodedSizeWithTag(1, r6.f10215f) + r0.encodedSizeWithTag(2, r6.f10216g);
            ProtoAdapter<Integer> r2 = ProtoAdapter.INT32;
            int r3 = (r1 + r2.encodedSizeWithTag(3, r6.f10217h)) + r2.encodedSizeWithTag(4, r6.f10218i);
            ProtoAdapter<String> r4 = ProtoAdapter.STRING;
            return ((((((r3 + r4.encodedSizeWithTag(6, r6.f10219j)) + r4.encodedSizeWithTag(7, r6.f10220k)) + ProtoAdapter.BYTES.encodedSizeWithTag(8, r6.f10221l)) + r2.encodedSizeWithTag(9, r6.m)) + r2.encodedSizeWithTag(10, r6.n)) + this.f10232a.encodedSizeWithTag(11, r6.o)) + r6.unknownFields().size();
        }

        public b1 d(b1 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ b1 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, b1 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(b1 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ b1 redact(b1 r1) {
            return d(r1);
        }
    }

    static {
        p = new b();
        k.h r0 = k.h.f18266i;
    }

    public b1(Long r13, Long r14, Integer r15, Integer r16, String r17, String r18, k.h r19, Integer r20, Integer r21, Map<String, String> r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, k.h.f18266i);
    }

    public b1(Long r2, Long r3, Integer r4, Integer r5, String r6, String r7, k.h r8, Integer r9, Integer r10, Map<String, String> r11, k.h r12) {
        super(p, r12);
        this.f10215f = r2;
        this.f10216g = r3;
        this.f10217h = r4;
        this.f10218i = r5;
        this.f10219j = r6;
        this.f10220k = r7;
        this.f10221l = r8;
        this.m = r9;
        this.n = r10;
        this.o = Internal.immutableCopyOf("headers", r11);
    }

    public a b() {
        a r0 = new a();
        r0.f10222a = this.f10215f;
        r0.f10223b = this.f10216g;
        r0.f10224c = this.f10217h;
        r0.f10225d = this.f10218i;
        r0.f10226e = this.f10219j;
        r0.f10227f = this.f10220k;
        r0.f10228g = this.f10221l;
        r0.f10229h = this.m;
        r0.f10230i = this.n;
        r0.f10231j = Internal.copyOf("headers", this.o);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r6 = (b1) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L32;
        if (Internal.equals(this.f10215f, r6.f10215f) == false) goto L32;
        if (Internal.equals(this.f10216g, r6.f10216g) == false) goto L32;
        if (Internal.equals(this.f10217h, r6.f10217h) == false) goto L32;
        if (Internal.equals(this.f10218i, r6.f10218i) == false) goto L32;
        if (Internal.equals(this.f10219j, r6.f10219j) == false) goto L32;
        if (Internal.equals(this.f10220k, r6.f10220k) == false) goto L32;
        if (Internal.equals(this.f10221l, r6.f10221l) == false) goto L32;
        if (Internal.equals(this.m, r6.m) == false) goto L32;
        if (Internal.equals(this.n, r6.n) == false) goto L32;
        if (this.o.equals(r6.o) == false) goto L32;
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L41;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.f10215f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.f10216g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.f10217h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.f10218i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.f10219j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f10220k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        k.h r21 = this.f10221l;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        Integer r24 = this.m;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        Integer r27 = this.n;
        if (r27 == null) goto L39;
        r3 = r27.hashCode();
    L39:
        int r28 = ((r26 + r3) * 37) + this.o.hashCode();
        this.hashCode = r28;
        return r28;
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
    L41:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10215f == null) goto L6;
        r0.append(", seqId=");
        r0.append(this.f10215f);
    L6:
        if (this.f10216g == null) goto L9;
        r0.append(", logId=");
        r0.append(this.f10216g);
    L9:
        if (this.f10217h == null) goto L12;
        r0.append(", service=");
        r0.append(this.f10217h);
    L12:
        if (this.f10218i == null) goto L15;
        r0.append(", method=");
        r0.append(this.f10218i);
    L15:
        if (this.f10219j == null) goto L18;
        r0.append(", payloadType=");
        r0.append(this.f10219j);
    L18:
        if (this.f10220k == null) goto L21;
        r0.append(", payloadEncoding=");
        r0.append(this.f10220k);
    L21:
        if (this.f10221l == null) goto L24;
        r0.append(", payload=");
        r0.append(this.f10221l);
    L24:
        if (this.m == null) goto L27;
        r0.append(", cmd=");
        r0.append(this.m);
    L27:
        if (this.n == null) goto L29;
        r0.append(", channelId=");
        r0.append(this.n);
    L29:
        Map<String, String> r1 = this.o;
        if (r1 != null) goto L32;
    L34:
        StringBuilder r3 = r0.replace(0, 2, "WsMessageInfo{");
        r3.append('}');
        return r3.toString();
    L32:
        if (r1.isEmpty() == true) goto L34;
        r0.append(", headers=");
        r0.append(this.o);
        goto L34
    }
}
