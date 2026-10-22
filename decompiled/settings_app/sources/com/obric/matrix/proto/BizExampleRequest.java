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
public final class BizExampleRequest extends Message<BizExampleRequest, Builder> {
    public static final ProtoAdapter<BizExampleRequest> ADAPTER = null;
    public static final String DEFAULT_STRPARAM = "";
    private static final long serialVersionUID = 0;

    @SerializedName("strParam")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String strParam;

    public static final class Builder extends Message.Builder<BizExampleRequest, Builder> {
        public String strParam;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.strParam = "";
        }

        public Builder strParam(String r1) {
            this.strParam = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public BizExampleRequest build() {
            return new BizExampleRequest(this.strParam, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_BizExampleRequest extends ProtoAdapter<BizExampleRequest> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BizExampleRequest decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, BizExampleRequest r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BizExampleRequest r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BizExampleRequest redact(BizExampleRequest r1) {
            return redact2(r1);
        }

        public ProtoAdapter_BizExampleRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BizExampleRequest.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BizExampleRequest r3) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r3.strParam) + r3.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, BizExampleRequest r4) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.strParam);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BizExampleRequest decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.strParam(ProtoAdapter.STRING.decode(r6));
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
        public BizExampleRequest redact2(BizExampleRequest r1) {
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
        ADAPTER = new ProtoAdapter_BizExampleRequest();
    }

    public BizExampleRequest(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public BizExampleRequest(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.strParam = r2;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.strParam = this.strParam;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof BizExampleRequest) == true) goto L8;
        return false;
    L8:
        BizExampleRequest r6 = (BizExampleRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.strParam, r6.strParam) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.strParam;
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
        if (this.strParam == null) goto L6;
        r0.append(", strParam=").append(this.strParam);
    L6:
        return r0.replace(0, 2, "BizExampleRequest{").append('}').toString();
    }
}
