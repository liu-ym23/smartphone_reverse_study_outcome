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
public final class SubscribeWsMsgByProviderResponse extends Message<SubscribeWsMsgByProviderResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgByProviderResponse> ADAPTER = null;
    public static final String DEFAULT_EXT = "";
    public static final Boolean DEFAULT_SUBSCRIBERESULT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("ext")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String ext;

    @SerializedName("subscribeResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean subscribeResult;

    public static final class Builder extends Message.Builder<SubscribeWsMsgByProviderResponse, Builder> {
        public String ext;
        public Boolean subscribeResult;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.subscribeResult = false;
            this.ext = "";
        }

        public Builder subscribeResult(Boolean r1) {
            this.subscribeResult = r1;
            return this;
        }

        public Builder ext(String r1) {
            this.ext = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsMsgByProviderResponse build() {
            return new SubscribeWsMsgByProviderResponse(this.subscribeResult, this.ext, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SubscribeWsMsgByProviderResponse extends ProtoAdapter<SubscribeWsMsgByProviderResponse> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByProviderResponse decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SubscribeWsMsgByProviderResponse r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgByProviderResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByProviderResponse redact(SubscribeWsMsgByProviderResponse r1) {
            return redact2(r1);
        }

        public ProtoAdapter_SubscribeWsMsgByProviderResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByProviderResponse.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsMsgByProviderResponse r4) {
            return (ProtoAdapter.BOOL.encodedSizeWithTag(1, r4.subscribeResult) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.ext)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, SubscribeWsMsgByProviderResponse r4) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.subscribeResult);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.ext);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsMsgByProviderResponse decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.subscribeResult(ProtoAdapter.BOOL.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.ext(ProtoAdapter.STRING.decode(r6));
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
        public SubscribeWsMsgByProviderResponse redact2(SubscribeWsMsgByProviderResponse r1) {
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
        ADAPTER = new ProtoAdapter_SubscribeWsMsgByProviderResponse();
        DEFAULT_SUBSCRIBERESULT = false;
    }

    public SubscribeWsMsgByProviderResponse(Boolean r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SubscribeWsMsgByProviderResponse(Boolean r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.subscribeResult = r2;
        this.ext = r3;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.subscribeResult = this.subscribeResult;
        r0.ext = this.ext;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsMsgByProviderResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByProviderResponse r6 = (SubscribeWsMsgByProviderResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.subscribeResult, r6.subscribeResult) == false) goto L16;
        if (Internal.equals(this.ext, r6.ext) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.subscribeResult;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.ext;
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
        if (this.subscribeResult == null) goto L6;
        r0.append(", subscribeResult=").append(this.subscribeResult);
    L6:
        if (this.ext == null) goto L9;
        r0.append(", ext=").append(this.ext);
    L9:
        return r0.replace(0, 2, "SubscribeWsMsgByProviderResponse{").append('}').toString();
    }
}
