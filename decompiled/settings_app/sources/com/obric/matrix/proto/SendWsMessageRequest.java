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

/* JADX INFO: loaded from: classes4.dex */
public final class SendWsMessageRequest extends Message<SendWsMessageRequest, Builder> {
    public static final ProtoAdapter<SendWsMessageRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("wsMessageInfo")
    @WireField(adapter = "com.obric.matrix.proto.WsMessageInfo#ADAPTER", tag = 1)
    public final WsMessageInfo wsMessageInfo;

    public static final class Builder extends Message.Builder<SendWsMessageRequest, Builder> {
        public WsMessageInfo wsMessageInfo;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
        }

        public Builder wsMessageInfo(WsMessageInfo r1) {
            this.wsMessageInfo = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SendWsMessageRequest build() {
            return new SendWsMessageRequest(this.wsMessageInfo, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SendWsMessageRequest extends ProtoAdapter<SendWsMessageRequest> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendWsMessageRequest decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SendWsMessageRequest r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendWsMessageRequest r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendWsMessageRequest redact(SendWsMessageRequest r1) {
            return redact2(r1);
        }

        public ProtoAdapter_SendWsMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendWsMessageRequest.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendWsMessageRequest r3) {
            return WsMessageInfo.ADAPTER.encodedSizeWithTag(1, r3.wsMessageInfo) + r3.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, SendWsMessageRequest r4) throws IOException {
            WsMessageInfo.ADAPTER.encodeWithTag(r3, 1, r4.wsMessageInfo);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendWsMessageRequest decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.wsMessageInfo(WsMessageInfo.ADAPTER.decode(r6));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SendWsMessageRequest redact2(SendWsMessageRequest r2) {
            Builder r1 = r2.newBuilder();
            if (r1.wsMessageInfo == null) goto L5;
            r1.wsMessageInfo = WsMessageInfo.ADAPTER.redact(r1.wsMessageInfo);
        L5:
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_SendWsMessageRequest();
    }

    public SendWsMessageRequest(WsMessageInfo r2) {
        this(r2, ByteString.EMPTY);
    }

    public SendWsMessageRequest(WsMessageInfo r2, ByteString r3) {
        super(ADAPTER, r3);
        this.wsMessageInfo = r2;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.wsMessageInfo = this.wsMessageInfo;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendWsMessageRequest) == true) goto L8;
        return false;
    L8:
        SendWsMessageRequest r6 = (SendWsMessageRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.wsMessageInfo, r6.wsMessageInfo) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        WsMessageInfo r2 = this.wsMessageInfo;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = r1 + r3;
        this.hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.wsMessageInfo == null) goto L6;
        r0.append(", wsMessageInfo=").append(this.wsMessageInfo);
    L6:
        return r0.replace(0, 2, "SendWsMessageRequest{").append('}').toString();
    }
}
