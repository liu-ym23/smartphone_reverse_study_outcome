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
public final class SubscribeWsStatusRequest extends Message<SubscribeWsStatusRequest, Builder> {
    public static final ProtoAdapter<SubscribeWsStatusRequest> ADAPTER = null;
    public static final Integer DEFAULT_OPT = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("opt")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer opt;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String packageName;

    public static final class Builder extends Message.Builder<SubscribeWsStatusRequest, Builder> {
        public Integer opt;
        public String packageName;

        public Builder() {
            this.opt = 0;
            this.packageName = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder opt(Integer r1) {
            this.opt = r1;
            return this;
        }

        public Builder packageName(String r1) {
            this.packageName = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsStatusRequest build() {
            return new SubscribeWsStatusRequest(this.opt, this.packageName, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SubscribeWsStatusRequest extends ProtoAdapter<SubscribeWsStatusRequest> {
        public ProtoAdapter_SubscribeWsStatusRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusRequest decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SubscribeWsStatusRequest r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsStatusRequest r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusRequest redact(SubscribeWsStatusRequest r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsStatusRequest decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.opt(ProtoAdapter.INT32.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.packageName(ProtoAdapter.STRING.decode(r6));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, SubscribeWsStatusRequest r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.opt);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.packageName);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsStatusRequest r4) {
            int r3 = ProtoAdapter.INT32.encodedSizeWithTag(1, r4.opt);
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(2, r4.packageName) + r3;
            return r4.unknownFields().size() + r0;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsStatusRequest redact2(SubscribeWsStatusRequest r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsStatusRequest();
        DEFAULT_OPT = 0;
    }

    public SubscribeWsStatusRequest(Integer r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsStatusRequest) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusRequest r6 = (SubscribeWsStatusRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.opt, r6.opt) == false) goto L16;
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.opt;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.packageName;
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
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.opt == null) goto L6;
        r0.append(", opt=");
        r0.append(this.opt);
    L6:
        if (this.packageName == null) goto L9;
        r0.append(", packageName=");
        r0.append(this.packageName);
    L9:
        return a.m(r0, 0, 2, "SubscribeWsStatusRequest{", '}');
    }

    public SubscribeWsStatusRequest(Integer r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.opt = r2;
        this.packageName = r3;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.opt = this.opt;
        r0.packageName = this.packageName;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
