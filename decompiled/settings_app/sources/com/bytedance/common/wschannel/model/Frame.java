package com.bytedance.common.wschannel.model;

import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class Frame extends Message<Frame, Builder> {
    public static final ProtoAdapter<Frame> ADAPTER = null;
    public static final Long DEFAULT_LOGID = null;
    public static final String DEFAULT_LOGIDNEW = "";
    public static final Integer DEFAULT_METHOD = null;
    public static final String DEFAULT_MSGID = "";
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOAD_ENCODING = "";
    public static final String DEFAULT_PAYLOAD_TYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final String DEFAULT_SERVERTIMING = "";
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.article.wschannel.model.Frame$ExtendedEntry#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ExtendedEntry> headers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 2)
    public final Long logid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String logidnew;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 4)
    public final Integer method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String msgId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final ByteString payload;

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

    public static final class Builder extends Message.Builder<Frame, Builder> {
        public List<ExtendedEntry> headers;
        public Long logid;
        public String logidnew;
        public Integer method;
        public String msgId;
        public ByteString payload;
        public String payload_encoding;
        public String payload_type;
        public Long seqid;
        public String serverTiming;
        public Integer service;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.headers = Internal.newMutableList();
        }

        public Builder seqid(Long r1) {
            this.seqid = r1;
            return this;
        }

        public Builder logid(Long r1) {
            this.logid = r1;
            return this;
        }

        public Builder service(Integer r1) {
            this.service = r1;
            return this;
        }

        public Builder method(Integer r1) {
            this.method = r1;
            return this;
        }

        public Builder headers(List<ExtendedEntry> r1) {
            Internal.checkElementsNotNull(r1);
            this.headers = r1;
            return this;
        }

        public Builder payload_encoding(String r1) {
            this.payload_encoding = r1;
            return this;
        }

        public Builder payload_type(String r1) {
            this.payload_type = r1;
            return this;
        }

        public Builder payload(ByteString r1) {
            this.payload = r1;
            return this;
        }

        public Builder logidnew(String r1) {
            this.logidnew = r1;
            return this;
        }

        public Builder serverTiming(String r1) {
            this.serverTiming = r1;
            return this;
        }

        public Builder msgId(String r1) {
            this.msgId = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Frame build() {
            Long r0 = this.seqid;
            if (r0 == null) goto L13;
            if (this.logid == null) goto L13;
            if (this.service == null) goto L13;
            if (this.method == null) goto L13;
            return new Frame(this.seqid, this.logid, this.service, this.method, this.headers, this.payload_encoding, this.payload_type, this.payload, this.logidnew, this.serverTiming, this.msgId, buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r0, "seqid", this.logid, CronetDataStorageAccess.LOGID, this.service, "service", this.method, "method"});
        }
    }

    public static final class ExtendedEntry extends Message<ExtendedEntry, Builder> {
        public static final ProtoAdapter<ExtendedEntry> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
        public final String key;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
        public final String value;

        public static final class Builder extends Message.Builder<ExtendedEntry, Builder> {
            public String key;
            public String value;

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder() {
            }

            public Builder key(String r1) {
                this.key = r1;
                return this;
            }

            public Builder value(String r1) {
                this.value = r1;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            public ExtendedEntry build() {
                String r0 = this.key;
                if (r0 == null) goto L9;
                if (this.value == null) goto L9;
                return new ExtendedEntry(this.key, this.value, buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "key", this.value, "value"});
            }
        }

        private static final class ProtoAdapter_ExtendedEntry extends ProtoAdapter<ExtendedEntry> {
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ExtendedEntry decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, ExtendedEntry r2) throws IOException {
                encode2(r1, r2);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtendedEntry r1) {
                return encodedSize2(r1);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ExtendedEntry redact(ExtendedEntry r1) {
                return redact2(r1);
            }

            ProtoAdapter_ExtendedEntry() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtendedEntry.class);
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ExtendedEntry r4) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r4.key) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.value)) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r3, ExtendedEntry r4) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.key);
                ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.value);
                r3.writeBytes(r4.unknownFields());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ExtendedEntry decode(ProtoReader r6) throws IOException {
                Builder r5 = new Builder();
                long r0 = r6.beginMessage();
            L3:
                int r2 = r6.nextTag();
                if (r2 == (-1)) goto L12;
                if (r2 != 1) goto L8;
                r5.key(ProtoAdapter.STRING.decode(r6));
                goto L3
            L8:
                if (r2 != 2) goto L9;
                r5.value(ProtoAdapter.STRING.decode(r6));
                goto L3
            L9:
                FieldEncoding r3 = r6.peekFieldEncoding();
                r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
                goto L3
            L12:
                r6.endMessage(r0);
                return r5.build();
            }

            /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
            public ExtendedEntry redact2(ExtendedEntry r1) {
                Builder r0 = r1.newBuilder();
                r0.clearUnknownFields();
                return r0.build();
            }
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        static {
            ADAPTER = new ProtoAdapter_ExtendedEntry();
        }

        public ExtendedEntry(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public ExtendedEntry(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.key = r2;
            this.value = r3;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r0 = new Builder();
            r0.key = this.key;
            r0.value = this.value;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof ExtendedEntry) == true) goto L8;
            return false;
        L8:
            ExtendedEntry r6 = (ExtendedEntry) r5;
            if (Internal.equals(unknownFields(), r6.unknownFields()) == false) goto L16;
            if (Internal.equals(this.key, r6.key) == false) goto L16;
            if (Internal.equals(this.value, r6.value) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            int r0 = this.hashCode;
            if (r0 != 0) goto L13;
            int r1 = unknownFields().hashCode() * 37;
            String r2 = this.key;
            int r3 = 0;
            if (r2 == null) goto L7;
            int r4 = r2.hashCode();
        L8:
            int r5 = (r1 + r4) * 37;
            String r6 = this.value;
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
        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (this.key == null) goto L6;
            r0.append(", key=").append(this.key);
        L6:
            if (this.value == null) goto L9;
            r0.append(", value=").append(this.value);
        L9:
            return r0.replace(0, 2, "ExtendedEntry{").append('}').toString();
        }
    }

    private static final class ProtoAdapter_Frame extends ProtoAdapter<Frame> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Frame decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Frame r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Frame r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Frame redact(Frame r1) {
            return redact2(r1);
        }

        ProtoAdapter_Frame() {
            super(FieldEncoding.LENGTH_DELIMITED, Frame.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Frame r5) {
            int r4 = (((ProtoAdapter.UINT64.encodedSizeWithTag(1, r5.seqid) + ProtoAdapter.UINT64.encodedSizeWithTag(2, r5.logid)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r5.service)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r5.method)) + ExtendedEntry.ADAPTER.asRepeated().encodedSizeWithTag(5, r5.headers);
            int r1 = 0;
            if (r5.payload_encoding == null) goto L5;
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(6, r5.payload_encoding);
        L6:
            int r6 = r4 + r0;
            if (r5.payload_type == null) goto L9;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(7, r5.payload_type);
        L10:
            int r7 = r6 + r2;
            if (r5.payload == null) goto L13;
            int r3 = ProtoAdapter.BYTES.encodedSizeWithTag(8, r5.payload);
        L14:
            int r8 = r7 + r3;
            if (r5.logidnew == null) goto L17;
            int r9 = ProtoAdapter.STRING.encodedSizeWithTag(9, r5.logidnew);
        L18:
            int r10 = r8 + r9;
            if (r5.serverTiming == null) goto L21;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(10, r5.serverTiming);
        L22:
            int r12 = r10 + r11;
            if (r5.msgId == null) goto L26;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(11, r5.msgId);
        L26:
            return (r12 + r1) + r5.unknownFields().size();
        L21:
            r11 = 0;
            goto L22
        L17:
            r9 = 0;
            goto L18
        L13:
            r3 = 0;
            goto L14
        L9:
            r2 = 0;
            goto L10
        L5:
            r0 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, Frame r4) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r3, 1, r4.seqid);
            ProtoAdapter.UINT64.encodeWithTag(r3, 2, r4.logid);
            ProtoAdapter.INT32.encodeWithTag(r3, 3, r4.service);
            ProtoAdapter.INT32.encodeWithTag(r3, 4, r4.method);
            if (r4.headers == null) goto L6;
            ExtendedEntry.ADAPTER.asRepeated().encodeWithTag(r3, 5, r4.headers);
        L6:
            if (r4.payload_encoding == null) goto L9;
            ProtoAdapter.STRING.encodeWithTag(r3, 6, r4.payload_encoding);
        L9:
            if (r4.payload_type == null) goto L12;
            ProtoAdapter.STRING.encodeWithTag(r3, 7, r4.payload_type);
        L12:
            if (r4.payload == null) goto L15;
            ProtoAdapter.BYTES.encodeWithTag(r3, 8, r4.payload);
        L15:
            if (r4.logidnew == null) goto L18;
            ProtoAdapter.STRING.encodeWithTag(r3, 9, r4.logidnew);
        L18:
            if (r4.serverTiming == null) goto L21;
            ProtoAdapter.STRING.encodeWithTag(r3, 10, r4.serverTiming);
        L21:
            if (r4.msgId == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r3, 11, r4.msgId);
        L23:
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Frame decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
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
            r5.msgId(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            r5.serverTiming(ProtoAdapter.STRING.decode(r6));
            goto L3
        L9:
            r5.logidnew(ProtoAdapter.STRING.decode(r6));
            goto L3
        L10:
            r5.payload(ProtoAdapter.BYTES.decode(r6));
            goto L3
        L11:
            r5.payload_type(ProtoAdapter.STRING.decode(r6));
            goto L3
        L12:
            r5.payload_encoding(ProtoAdapter.STRING.decode(r6));
            goto L3
        L13:
            r5.headers.add(ExtendedEntry.ADAPTER.decode(r6));
            goto L3
        L14:
            r5.method(ProtoAdapter.INT32.decode(r6));
            goto L3
        L15:
            r5.service(ProtoAdapter.INT32.decode(r6));
            goto L3
        L16:
            r5.logid(ProtoAdapter.UINT64.decode(r6));
            goto L3
        L17:
            r5.seqid(ProtoAdapter.UINT64.decode(r6));
            goto L3
        L6:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Frame redact2(Frame r2) {
            Builder r1 = r2.newBuilder();
            Internal.redactElements(r1.headers, ExtendedEntry.ADAPTER);
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_Frame();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    public Frame(Long r14, Long r15, Integer r16, Integer r17, List<ExtendedEntry> r18, String r19, String r20, ByteString r21, String r22, String r23, String r24) {
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, ByteString.EMPTY);
    }

    public Frame(Long r2, Long r3, Integer r4, Integer r5, List<ExtendedEntry> r6, String r7, String r8, ByteString r9, String r10, String r11, String r12, ByteString r13) {
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

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.seqid = this.seqid;
        r0.logid = this.logid;
        r0.service = this.service;
        r0.method = this.method;
        r0.headers = Internal.copyOf("headers", this.headers);
        r0.payload_encoding = this.payload_encoding;
        r0.payload_type = this.payload_type;
        r0.payload = this.payload;
        r0.logidnew = this.logidnew;
        r0.serverTiming = this.serverTiming;
        r0.msgId = this.msgId;
        r0.addUnknownFields(unknownFields());
        return r0;
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
        List<ExtendedEntry> r15 = this.headers;
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
        ByteString r24 = this.payload;
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
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.seqid == null) goto L6;
        r0.append(", seqid=").append(this.seqid);
    L6:
        if (this.logid == null) goto L9;
        r0.append(", logid=").append(this.logid);
    L9:
        if (this.service == null) goto L12;
        r0.append(", service=").append(this.service);
    L12:
        if (this.method == null) goto L15;
        r0.append(", method=").append(this.method);
    L15:
        if (this.headers == null) goto L18;
        r0.append(", headers=").append(this.headers);
    L18:
        if (this.payload_encoding == null) goto L21;
        r0.append(", payload_encoding=").append(this.payload_encoding);
    L21:
        if (this.payload_type == null) goto L24;
        r0.append(", payload_type=").append(this.payload_type);
    L24:
        if (this.payload == null) goto L27;
        r0.append(", payload=").append(this.payload);
    L27:
        if (this.logidnew == null) goto L30;
        r0.append(", logidnew=").append(this.logidnew);
    L30:
        if (this.serverTiming == null) goto L33;
        r0.append(", serverTiming=").append(this.serverTiming);
    L33:
        if (this.msgId == null) goto L36;
        r0.append(", msgId=").append(this.msgId);
    L36:
        return r0.replace(0, 2, "Frame{").append('}').toString();
    }
}
