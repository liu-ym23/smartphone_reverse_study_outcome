package com.bytedance.common.wschannel.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;
import k.h;

/* JADX INFO: loaded from: classes.dex */
public final class Frame extends Message<Frame, a> {
    public static final ProtoAdapter<Frame> ADAPTER = null;
    public static final Long DEFAULT_LOGID = null;
    public static final String DEFAULT_LOGIDNEW = "";
    public static final Integer DEFAULT_METHOD = null;
    public static final String DEFAULT_MSGID = "";
    public static final h DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOAD_ENCODING = "";
    public static final String DEFAULT_PAYLOAD_TYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final String DEFAULT_SERVERTIMING = "";
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.article.wschannel.model.Frame$ExtendedEntry#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<b> headers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 2)
    public final Long logid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String logidnew;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 4)
    public final Integer method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String msgId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final h payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payload_encoding;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payload_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long seqid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String serverTiming;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
    public final Integer service;

    public static final class a extends Message.Builder<Frame, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f3555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f3556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f3557c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f3558d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<b> f3559e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f3560f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f3561g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public h f3562h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f3563i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f3564j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f3565k;

        public a() {
            this.f3559e = Internal.newMutableList();
        }

        public Frame a() {
            Long r0 = this.f3555a;
            if (r0 == null) goto L13;
            if (this.f3556b == null) goto L13;
            if (this.f3557c == null) goto L13;
            if (this.f3558d == null) goto L13;
            return new Frame(this.f3555a, this.f3556b, this.f3557c, this.f3558d, this.f3559e, this.f3560f, this.f3561g, this.f3562h, this.f3563i, this.f3564j, this.f3565k, buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r0, "seqid", this.f3556b, "logid", this.f3557c, "service", this.f3558d, "method"});
        }

        public a b(List<b> r1) {
            Internal.checkElementsNotNull(r1);
            this.f3559e = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Long r1) {
            this.f3556b = r1;
            return this;
        }

        public a d(String r1) {
            this.f3563i = r1;
            return this;
        }

        public a e(Integer r1) {
            this.f3558d = r1;
            return this;
        }

        public a f(String r1) {
            this.f3565k = r1;
            return this;
        }

        public a g(h r1) {
            this.f3562h = r1;
            return this;
        }

        public a h(String r1) {
            this.f3560f = r1;
            return this;
        }

        public a i(String r1) {
            this.f3561g = r1;
            return this;
        }

        public a j(Long r1) {
            this.f3555a = r1;
            return this;
        }

        public a k(String r1) {
            this.f3564j = r1;
            return this;
        }

        public a l(Integer r1) {
            this.f3557c = r1;
            return this;
        }
    }

    public static final class b extends Message<b, a> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final ProtoAdapter<b> f3566h = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
        public final String f3567f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
        public final String f3568g;

        public static final class a extends Message.Builder<b, a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f3569a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f3570b;

            public a() {
            }

            public b a() {
                String r0 = this.f3569a;
                if (r0 == null) goto L9;
                if (this.f3570b == null) goto L9;
                return new b(this.f3569a, this.f3570b, buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "key", this.f3570b, "value"});
            }

            public a b(String r1) {
                this.f3569a = r1;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return a();
            }

            public a c(String r1) {
                this.f3570b = r1;
                return this;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.common.wschannel.model.Frame$b$b, reason: collision with other inner class name */
        private static final class C0100b extends ProtoAdapter<b> {
            C0100b() {
                super(FieldEncoding.LENGTH_DELIMITED, b.class);
            }

            public b a(ProtoReader r6) {
                a r5 = new a();
                long r0 = r6.beginMessage();
            L3:
                int r2 = r6.nextTag();
                if (r2 == (-1)) goto L12;
                if (r2 != 1) goto L8;
                r5.b(ProtoAdapter.STRING.decode(r6));
                goto L3
            L8:
                if (r2 != 2) goto L9;
                r5.c(ProtoAdapter.STRING.decode(r6));
                goto L3
            L9:
                FieldEncoding r3 = r6.peekFieldEncoding();
                r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
                goto L3
            L12:
                r6.endMessage(r0);
                return r5.a();
            }

            public void b(ProtoWriter r3, b r4) {
                ProtoAdapter<String> r2 = ProtoAdapter.STRING;
                r2.encodeWithTag(r3, 1, r4.f3567f);
                r2.encodeWithTag(r3, 2, r4.f3568g);
                r3.writeBytes(r4.unknownFields());
            }

            public int c(b r4) {
                ProtoAdapter<String> r3 = ProtoAdapter.STRING;
                return (r3.encodedSizeWithTag(1, r4.f3567f) + r3.encodedSizeWithTag(2, r4.f3568g)) + r4.unknownFields().size();
            }

            public b d(b r1) {
                a r0 = r1.b();
                r0.clearUnknownFields();
                return r0.a();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ b decode(ProtoReader r1) {
                return a(r1);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, b r2) {
                b(r1, r2);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(b r1) {
                return c(r1);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ b redact(b r1) {
                return d(r1);
            }
        }

        static {
            f3566h = new C0100b();
        }

        public b(String r2, String r3, h r4) {
            super(f3566h, r4);
            this.f3567f = r2;
            this.f3568g = r3;
        }

        public a b() {
            a r0 = new a();
            r0.f3569a = this.f3567f;
            r0.f3570b = this.f3568g;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Internal.equals(unknownFields(), r6.unknownFields()) == false) goto L16;
            if (Internal.equals(this.f3567f, r6.f3567f) == false) goto L16;
            if (Internal.equals(this.f3568g, r6.f3568g) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            int r0 = this.hashCode;
            if (r0 != 0) goto L13;
            int r1 = unknownFields().hashCode() * 37;
            String r2 = this.f3567f;
            int r3 = 0;
            if (r2 == null) goto L7;
            int r4 = r2.hashCode();
        L8:
            int r5 = (r1 + r4) * 37;
            String r6 = this.f3568g;
            if (r6 == null) goto L11;
            r3 = r6.hashCode();
        L11:
            int r7 = r5 + r3;
            this.hashCode = r7;
            return r7;
        L7:
            r4 = 0;
            goto L8
        L13:
            return r0;
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return b();
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (this.f3567f == null) goto L6;
            r0.append(", key=");
            r0.append(this.f3567f);
        L6:
            if (this.f3568g == null) goto L8;
            r0.append(", value=");
            r0.append(this.f3568g);
        L8:
            StringBuilder r3 = r0.replace(0, 2, "ExtendedEntry{");
            r3.append('}');
            return r3.toString();
        }
    }

    private static final class c extends ProtoAdapter<Frame> {
        c() {
            super(FieldEncoding.LENGTH_DELIMITED, Frame.class);
        }

        public Frame a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            switch(r2) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r5.f(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            r5.k(ProtoAdapter.STRING.decode(r6));
            goto L3
        L9:
            r5.d(ProtoAdapter.STRING.decode(r6));
            goto L3
        L10:
            r5.g(ProtoAdapter.BYTES.decode(r6));
            goto L3
        L11:
            r5.i(ProtoAdapter.STRING.decode(r6));
            goto L3
        L12:
            r5.h(ProtoAdapter.STRING.decode(r6));
            goto L3
        L13:
            r5.f3559e.add(b.f3566h.decode(r6));
            goto L3
        L14:
            r5.e(ProtoAdapter.INT32.decode(r6));
            goto L3
        L15:
            r5.l(ProtoAdapter.INT32.decode(r6));
            goto L3
        L16:
            r5.c(ProtoAdapter.UINT64.decode(r6));
            goto L3
        L17:
            r5.j(ProtoAdapter.UINT64.decode(r6));
            goto L3
        L6:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, Frame r4) {
            ProtoAdapter<Long> r2 = ProtoAdapter.UINT64;
            r2.encodeWithTag(r3, 1, r4.seqid);
            r2.encodeWithTag(r3, 2, r4.logid);
            ProtoAdapter<Integer> r5 = ProtoAdapter.INT32;
            r5.encodeWithTag(r3, 3, r4.service);
            r5.encodeWithTag(r3, 4, r4.method);
            if (r4.headers == null) goto L5;
            b.f3566h.asRepeated().encodeWithTag(r3, 5, r4.headers);
        L5:
            String r6 = r4.payload_encoding;
            if (r6 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r3, 6, r6);
        L8:
            String r7 = r4.payload_type;
            if (r7 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r3, 7, r7);
        L11:
            h r8 = r4.payload;
            if (r8 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r3, 8, r8);
        L14:
            String r9 = r4.logidnew;
            if (r9 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r3, 9, r9);
        L17:
            String r10 = r4.serverTiming;
            if (r10 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r3, 10, r10);
        L20:
            String r11 = r4.msgId;
            if (r11 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r3, 11, r11);
        L23:
            r3.writeBytes(r4.unknownFields());
        }

        public int c(Frame r5) {
            ProtoAdapter<Long> r4 = ProtoAdapter.UINT64;
            int r0 = r4.encodedSizeWithTag(1, r5.seqid) + r4.encodedSizeWithTag(2, r5.logid);
            ProtoAdapter<Integer> r6 = ProtoAdapter.INT32;
            int r1 = ((r0 + r6.encodedSizeWithTag(3, r5.service)) + r6.encodedSizeWithTag(4, r5.method)) + b.f3566h.asRepeated().encodedSizeWithTag(5, r5.headers);
            String r7 = r5.payload_encoding;
            int r2 = 0;
            if (r7 == null) goto L5;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(6, r7);
        L6:
            int r3 = r1 + r8;
            String r9 = r5.payload_type;
            if (r9 == null) goto L9;
            int r10 = ProtoAdapter.STRING.encodedSizeWithTag(7, r9);
        L10:
            int r11 = r3 + r10;
            h r12 = r5.payload;
            if (r12 == null) goto L13;
            int r13 = ProtoAdapter.BYTES.encodedSizeWithTag(8, r12);
        L14:
            int r14 = r11 + r13;
            String r15 = r5.logidnew;
            if (r15 == null) goto L17;
            int r16 = ProtoAdapter.STRING.encodedSizeWithTag(9, r15);
        L18:
            int r17 = r14 + r16;
            String r18 = r5.serverTiming;
            if (r18 == null) goto L21;
            int r19 = ProtoAdapter.STRING.encodedSizeWithTag(10, r18);
        L22:
            int r20 = r17 + r19;
            String r21 = r5.msgId;
            if (r21 == null) goto L26;
            r2 = ProtoAdapter.STRING.encodedSizeWithTag(11, r21);
        L26:
            return (r20 + r2) + r5.unknownFields().size();
        L21:
            r19 = 0;
            goto L22
        L17:
            r16 = 0;
            goto L18
        L13:
            r13 = 0;
            goto L14
        L9:
            r10 = 0;
            goto L10
        L5:
            r8 = 0;
            goto L6
        }

        public Frame d(Frame r2) {
            a r1 = r2.newBuilder();
            Internal.redactElements(r1.f3559e, b.f3566h);
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Frame decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Frame r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Frame r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Frame redact(Frame r1) {
            return d(r1);
        }
    }

    static {
        ADAPTER = new c();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = h.f18266i;
    }

    public Frame(Long r14, Long r15, Integer r16, Integer r17, List<b> r18, String r19, String r20, h r21, String r22, String r23, String r24) {
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, h.f18266i);
    }

    public Frame(Long r2, Long r3, Integer r4, Integer r5, List<b> r6, String r7, String r8, h r9, String r10, String r11, String r12, h r13) {
        super(ADAPTER, r13);
        this.seqid = r2;
        this.logid = r3;
        this.service = r4;
        this.method = r5;
        this.headers = Internal.immutableCopyOf("headers", r6);
        this.payload_encoding = r7;
        this.payload_type = r8;
        this.payload = r9;
        this.logidnew = r10;
        this.serverTiming = r11;
        this.msgId = r12;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Frame) == true) goto L8;
        return false;
    L8:
        Frame r6 = (Frame) r5;
        if (Internal.equals(unknownFields(), r6.unknownFields()) == false) goto L34;
        if (Internal.equals(this.seqid, r6.seqid) == false) goto L34;
        if (Internal.equals(this.logid, r6.logid) == false) goto L34;
        if (Internal.equals(this.service, r6.service) == false) goto L34;
        if (Internal.equals(this.method, r6.method) == false) goto L34;
        if (Internal.equals(this.headers, r6.headers) == false) goto L34;
        if (Internal.equals(this.payload_encoding, r6.payload_encoding) == false) goto L34;
        if (Internal.equals(this.payload_type, r6.payload_type) == false) goto L34;
        if (Internal.equals(this.payload, r6.payload) == false) goto L34;
        if (Internal.equals(this.logidnew, r6.logidnew) == false) goto L34;
        if (Internal.equals(this.serverTiming, r6.serverTiming) == false) goto L34;
        if (Internal.equals(this.msgId, r6.msgId) == false) goto L34;
        return true;
    L34:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L49;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.seqid;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.logid;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.service;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.method;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        List<b> r15 = this.headers;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.payload_encoding;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.payload_type;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        h r24 = this.payload;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        String r27 = this.logidnew;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.serverTiming;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        String r33 = this.msgId;
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
        r16 = 1;
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
    public a newBuilder() {
        a r0 = new a();
        r0.f3555a = this.seqid;
        r0.f3556b = this.logid;
        r0.f3557c = this.service;
        r0.f3558d = this.method;
        r0.f3559e = Internal.copyOf("headers", this.headers);
        r0.f3560f = this.payload_encoding;
        r0.f3561g = this.payload_type;
        r0.f3562h = this.payload;
        r0.f3563i = this.logidnew;
        r0.f3564j = this.serverTiming;
        r0.f3565k = this.msgId;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.seqid == null) goto L6;
        r0.append(", seqid=");
        r0.append(this.seqid);
    L6:
        if (this.logid == null) goto L9;
        r0.append(", logid=");
        r0.append(this.logid);
    L9:
        if (this.service == null) goto L12;
        r0.append(", service=");
        r0.append(this.service);
    L12:
        if (this.method == null) goto L15;
        r0.append(", method=");
        r0.append(this.method);
    L15:
        if (this.headers == null) goto L18;
        r0.append(", headers=");
        r0.append(this.headers);
    L18:
        if (this.payload_encoding == null) goto L21;
        r0.append(", payload_encoding=");
        r0.append(this.payload_encoding);
    L21:
        if (this.payload_type == null) goto L24;
        r0.append(", payload_type=");
        r0.append(this.payload_type);
    L24:
        if (this.payload == null) goto L27;
        r0.append(", payload=");
        r0.append(this.payload);
    L27:
        if (this.logidnew == null) goto L30;
        r0.append(", logidnew=");
        r0.append(this.logidnew);
    L30:
        if (this.serverTiming == null) goto L33;
        r0.append(", serverTiming=");
        r0.append(this.serverTiming);
    L33:
        if (this.msgId == null) goto L35;
        r0.append(", msgId=");
        r0.append(this.msgId);
    L35:
        StringBuilder r3 = r0.replace(0, 2, "Frame{");
        r3.append('}');
        return r3.toString();
    }
}
