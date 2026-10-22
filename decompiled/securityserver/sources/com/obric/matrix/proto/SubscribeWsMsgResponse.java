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
public final class SubscribeWsMsgResponse extends Message<SubscribeWsMsgResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("wsMessageInfo")
    @WireField(adapter = "com.obric.matrix.proto.WsMessageInfo#ADAPTER", tag = 1)
    public final WsMessageInfo wsMessageInfo;

    public static final class Builder extends Message.Builder<SubscribeWsMsgResponse, Builder> {
        public WsMessageInfo wsMessageInfo;

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder wsMessageInfo(WsMessageInfo r1) {
            this.wsMessageInfo = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsMsgResponse build() {
            return new SubscribeWsMsgResponse(this.wsMessageInfo, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgResponse extends ProtoAdapter<SubscribeWsMsgResponse> {
        public ProtoAdapter_SubscribeWsMsgResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgResponse decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SubscribeWsMsgResponse r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgResponse redact(SubscribeWsMsgResponse r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsMsgResponse decode(ProtoReader r6) {
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

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, SubscribeWsMsgResponse r4) {
            WsMessageInfo.ADAPTER.encodeWithTag(r3, 1, r4.wsMessageInfo);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsMsgResponse r3) {
            int r2 = WsMessageInfo.ADAPTER.encodedSizeWithTag(1, r3.wsMessageInfo);
            return r3.unknownFields().size() + r2;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsMsgResponse redact2(SubscribeWsMsgResponse r2) {
            Builder r1 = r2.newBuilder();
            WsMessageInfo r3 = r1.wsMessageInfo;
            if (r3 == null) goto L5;
            r1.wsMessageInfo = WsMessageInfo.ADAPTER.redact(r3);
        L5:
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgResponse();
    }

    public SubscribeWsMsgResponse(WsMessageInfo r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsMsgResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgResponse r6 = (SubscribeWsMsgResponse) r5;
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
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.wsMessageInfo == null) goto L6;
        r0.append(", wsMessageInfo=");
        r0.append(this.wsMessageInfo);
    L6:
        return a.m(r0, 0, 2, "SubscribeWsMsgResponse{", '}');
    }

    public SubscribeWsMsgResponse(WsMessageInfo r2, ByteString r3) {
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
}
