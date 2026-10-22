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
public final class SendWsMessageResponse extends Message<SendWsMessageResponse, Builder> {
    public static final ProtoAdapter<SendWsMessageResponse> ADAPTER = null;
    public static final Boolean DEFAULT_RESULT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("result")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean result;

    public static final class Builder extends Message.Builder<SendWsMessageResponse, Builder> {
        public Boolean result;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.result = false;
        }

        public Builder result(Boolean r1) {
            this.result = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SendWsMessageResponse build() {
            return new SendWsMessageResponse(this.result, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SendWsMessageResponse extends ProtoAdapter<SendWsMessageResponse> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendWsMessageResponse decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SendWsMessageResponse r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendWsMessageResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendWsMessageResponse redact(SendWsMessageResponse r1) {
            return redact2(r1);
        }

        public ProtoAdapter_SendWsMessageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendWsMessageResponse.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendWsMessageResponse r3) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r3.result) + r3.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, SendWsMessageResponse r4) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.result);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendWsMessageResponse decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.result(ProtoAdapter.BOOL.decode(r6));
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
        public SendWsMessageResponse redact2(SendWsMessageResponse r1) {
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
        ADAPTER = new ProtoAdapter_SendWsMessageResponse();
        DEFAULT_RESULT = false;
    }

    public SendWsMessageResponse(Boolean r2) {
        this(r2, ByteString.EMPTY);
    }

    public SendWsMessageResponse(Boolean r2, ByteString r3) {
        super(ADAPTER, r3);
        this.result = r2;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.result = this.result;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendWsMessageResponse) == true) goto L8;
        return false;
    L8:
        SendWsMessageResponse r6 = (SendWsMessageResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.result, r6.result) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.result;
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
        if (this.result == null) goto L6;
        r0.append(", result=").append(this.result);
    L6:
        return r0.replace(0, 2, "SendWsMessageResponse{").append('}').toString();
    }
}
