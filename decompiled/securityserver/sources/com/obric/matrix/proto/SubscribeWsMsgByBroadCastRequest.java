package com.obric.matrix.proto;

import a.a;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class SubscribeWsMsgByBroadCastRequest extends Message<SubscribeWsMsgByBroadCastRequest, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgByBroadCastRequest> ADAPTER = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final Integer DEFAULT_OPT = null;
    public static final String DEFAULT_PACKAGENAME = "";
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("method")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer method;

    @SerializedName("opt")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer opt;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String packageName;

    @SerializedName("service")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer service;

    public static final class Builder extends Message.Builder<SubscribeWsMsgByBroadCastRequest, Builder> {
        public Integer method;
        public Integer opt;
        public String packageName;
        public Integer service;

        public Builder() {
            this.service = 0;
            this.method = 0;
            this.packageName = "";
            this.opt = 0;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder method(Integer r1) {
            this.method = r1;
            return this;
        }

        public Builder opt(Integer r1) {
            this.opt = r1;
            return this;
        }

        public Builder packageName(String r1) {
            this.packageName = r1;
            return this;
        }

        public Builder service(Integer r1) {
            this.service = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsMsgByBroadCastRequest build() {
            return new SubscribeWsMsgByBroadCastRequest(this.service, this.method, this.packageName, this.opt, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgByBroadCastRequest extends ProtoAdapter<SubscribeWsMsgByBroadCastRequest> {
        public ProtoAdapter_SubscribeWsMsgByBroadCastRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByBroadCastRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByBroadCastRequest decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SubscribeWsMsgByBroadCastRequest r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgByBroadCastRequest r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByBroadCastRequest redact(SubscribeWsMsgByBroadCastRequest r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsMsgByBroadCastRequest decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.service(ProtoAdapter.INT32.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.method(ProtoAdapter.INT32.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.packageName(ProtoAdapter.STRING.decode(r6));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.opt(ProtoAdapter.INT32.decode(r6));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, SubscribeWsMsgByBroadCastRequest r5) {
            ProtoAdapter<Integer> r3 = ProtoAdapter.INT32;
            r3.encodeWithTag(r4, 1, r5.service);
            r3.encodeWithTag(r4, 2, r5.method);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.packageName);
            r3.encodeWithTag(r4, 4, r5.opt);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsMsgByBroadCastRequest r5) {
            ProtoAdapter<Integer> r4 = ProtoAdapter.INT32;
            int r0 = r4.encodedSizeWithTag(1, r5.service);
            int r1 = r4.encodedSizeWithTag(2, r5.method) + r0;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(3, r5.packageName) + r1;
            int r6 = r4.encodedSizeWithTag(4, r5.opt) + r2;
            return r5.unknownFields().size() + r6;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsMsgByBroadCastRequest redact2(SubscribeWsMsgByBroadCastRequest r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgByBroadCastRequest();
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_OPT = 0;
    }

    public SubscribeWsMsgByBroadCastRequest(Integer r7, Integer r8, String r9, Integer r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsMsgByBroadCastRequest) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByBroadCastRequest r6 = (SubscribeWsMsgByBroadCastRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.service, r6.service) == false) goto L20;
        if (Internal.equals(this.method, r6.method) == false) goto L20;
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L20;
        if (Internal.equals(this.opt, r6.opt) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.service;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.method;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.packageName;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.opt;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        this.hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.service == null) goto L6;
        r0.append(", service=");
        r0.append(this.service);
    L6:
        if (this.method == null) goto L9;
        r0.append(", method=");
        r0.append(this.method);
    L9:
        if (this.packageName == null) goto L12;
        r0.append(", packageName=");
        r0.append(this.packageName);
    L12:
        if (this.opt == null) goto L15;
        r0.append(", opt=");
        r0.append(this.opt);
    L15:
        return a.m(r0, 0, 2, "SubscribeWsMsgByBroadCastRequest{", '}');
    }

    public SubscribeWsMsgByBroadCastRequest(Integer r2, Integer r3, String r4, Integer r5, ByteString r6) {
        super(ADAPTER, r6);
        this.service = r2;
        this.method = r3;
        this.packageName = r4;
        this.opt = r5;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.service = this.service;
        r0.method = this.method;
        r0.packageName = this.packageName;
        r0.opt = this.opt;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
