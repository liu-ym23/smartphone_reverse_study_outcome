package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscribeWsStatusResponse extends Message<SubscribeWsStatusResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsStatusResponse> ADAPTER = null;
    public static final Integer DEFAULT_CHANNELID = null;
    public static final Integer DEFAULT_CHANNELTYPE = null;
    public static final Integer DEFAULT_CONNECTIONSTATE = null;
    public static final Boolean DEFAULT_ISCONNECTED = null;
    private static final long serialVersionUID = 0;

    @SerializedName("channelId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer channelId;

    @SerializedName("channelType")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer channelType;

    @SerializedName("connectionState")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer connectionState;

    @SerializedName("isConnected")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean isConnected;

    public static final class Builder extends Message.Builder<SubscribeWsStatusResponse, Builder> {
        public Integer channelId;
        public Integer channelType;
        public Integer connectionState;
        public Boolean isConnected;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.channelType = 0;
            this.connectionState = 0;
            this.channelId = 0;
            this.isConnected = false;
        }

        public Builder channelType(Integer r1) {
            this.channelType = r1;
            return this;
        }

        public Builder connectionState(Integer r1) {
            this.connectionState = r1;
            return this;
        }

        public Builder channelId(Integer r1) {
            this.channelId = r1;
            return this;
        }

        public Builder isConnected(Boolean r1) {
            this.isConnected = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsStatusResponse build() {
            return new SubscribeWsStatusResponse(this.channelType, this.connectionState, this.channelId, this.isConnected, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SubscribeWsStatusResponse extends ProtoAdapter<SubscribeWsStatusResponse> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusResponse decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SubscribeWsStatusResponse r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsStatusResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusResponse redact(SubscribeWsStatusResponse r1) {
            return redact2(r1);
        }

        public ProtoAdapter_SubscribeWsStatusResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusResponse.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsStatusResponse r4) {
            return (((ProtoAdapter.INT32.encodedSizeWithTag(1, r4.channelType) + ProtoAdapter.INT32.encodedSizeWithTag(2, r4.connectionState)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r4.channelId)) + ProtoAdapter.BOOL.encodedSizeWithTag(4, r4.isConnected)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, SubscribeWsStatusResponse r4) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.channelType);
            ProtoAdapter.INT32.encodeWithTag(r3, 2, r4.connectionState);
            ProtoAdapter.INT32.encodeWithTag(r3, 3, r4.channelId);
            ProtoAdapter.BOOL.encodeWithTag(r3, 4, r4.isConnected);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsStatusResponse decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.channelType(ProtoAdapter.INT32.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.connectionState(ProtoAdapter.INT32.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.channelId(ProtoAdapter.INT32.decode(r6));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.isConnected(ProtoAdapter.BOOL.decode(r6));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsStatusResponse redact2(SubscribeWsStatusResponse r1) {
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
        ADAPTER = new ProtoAdapter_SubscribeWsStatusResponse();
        DEFAULT_CHANNELTYPE = 0;
        DEFAULT_CONNECTIONSTATE = 0;
        DEFAULT_CHANNELID = 0;
        DEFAULT_ISCONNECTED = false;
    }

    public SubscribeWsStatusResponse(Integer r7, Integer r8, Integer r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public SubscribeWsStatusResponse(Integer r2, Integer r3, Integer r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.channelType = r2;
        this.connectionState = r3;
        this.channelId = r4;
        this.isConnected = r5;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.channelType = this.channelType;
        r0.connectionState = this.connectionState;
        r0.channelId = this.channelId;
        r0.isConnected = this.isConnected;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsStatusResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusResponse r6 = (SubscribeWsStatusResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.channelType, r6.channelType) == false) goto L20;
        if (Internal.equals(this.connectionState, r6.connectionState) == false) goto L20;
        if (Internal.equals(this.channelId, r6.channelId) == false) goto L20;
        if (Internal.equals(this.isConnected, r6.isConnected) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.channelType;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.connectionState;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.channelId;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Boolean r12 = this.isConnected;
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
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.channelType == null) goto L6;
        r0.append(", channelType=").append(this.channelType);
    L6:
        if (this.connectionState == null) goto L9;
        r0.append(", connectionState=").append(this.connectionState);
    L9:
        if (this.channelId == null) goto L12;
        r0.append(", channelId=").append(this.channelId);
    L12:
        if (this.isConnected == null) goto L15;
        r0.append(", isConnected=").append(this.isConnected);
    L15:
        return r0.replace(0, 2, "SubscribeWsStatusResponse{").append('}').toString();
    }
}
