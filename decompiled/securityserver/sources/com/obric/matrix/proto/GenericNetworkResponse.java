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
public final class GenericNetworkResponse extends Message<GenericNetworkResponse, Builder> {
    public static final ProtoAdapter<GenericNetworkResponse> ADAPTER = null;
    public static final String DEFAULT_BODY = "";
    public static final Boolean DEFAULT_ISSUCCEED = null;
    public static final String DEFAULT_SERVERLOGID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String body;

    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 1)
    public final Boolean isSucceed;

    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String serverLogId;

    public static final class Builder extends Message.Builder<GenericNetworkResponse, Builder> {
        public String body;
        public Boolean isSucceed;
        public String serverLogId;

        public Builder() {
            this.isSucceed = Boolean.FALSE;
            this.body = "";
            this.serverLogId = "";
        }

        public Builder body(String r1) {
            this.body = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder isSucceed(Boolean r1) {
            this.isSucceed = r1;
            return this;
        }

        public Builder serverLogId(String r1) {
            this.serverLogId = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public GenericNetworkResponse build() {
            Boolean r0 = this.isSucceed;
            if (r0 == null) goto L11;
            if (this.body == null) goto L11;
            if (this.serverLogId == null) goto L11;
            return new GenericNetworkResponse(this.isSucceed, this.body, this.serverLogId, buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "isSucceed", this.body, "body", this.serverLogId, "serverLogId"});
        }
    }

    public static final class ProtoAdapter_GenericNetworkResponse extends ProtoAdapter<GenericNetworkResponse> {
        public ProtoAdapter_GenericNetworkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkResponse decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, GenericNetworkResponse r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GenericNetworkResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkResponse redact(GenericNetworkResponse r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GenericNetworkResponse decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            r5.isSucceed(ProtoAdapter.BOOL.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.body(ProtoAdapter.STRING.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r5.serverLogId(ProtoAdapter.STRING.decode(r6));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L15:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, GenericNetworkResponse r4) {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.isSucceed);
            ProtoAdapter<String> r2 = ProtoAdapter.STRING;
            r2.encodeWithTag(r3, 2, r4.body);
            r2.encodeWithTag(r3, 3, r4.serverLogId);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GenericNetworkResponse r4) {
            int r3 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r4.isSucceed);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(2, r4.body) + r3;
            int r5 = r0.encodedSizeWithTag(3, r4.serverLogId) + r1;
            return r4.unknownFields().size() + r5;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GenericNetworkResponse redact2(GenericNetworkResponse r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenericNetworkResponse();
        DEFAULT_ISSUCCEED = Boolean.FALSE;
    }

    public GenericNetworkResponse(Boolean r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GenericNetworkResponse) == true) goto L8;
        return false;
    L8:
        GenericNetworkResponse r6 = (GenericNetworkResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (this.isSucceed.equals(r6.isSucceed) == false) goto L18;
        if (this.body.equals(r6.body) == false) goto L18;
        if (this.serverLogId.equals(r6.serverLogId) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = unknownFields().hashCode() * 37;
        int r2 = (this.isSucceed.hashCode() + r1) * 37;
        int r3 = ((this.body.hashCode() + r2) * 37) + this.serverLogId.hashCode();
        this.hashCode = r3;
        return r3;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = a.q(", isSucceed=");
        r0.append(this.isSucceed);
        r0.append(", body=");
        r0.append(this.body);
        r0.append(", serverLogId=");
        r0.append(this.serverLogId);
        return a.m(r0, 0, 2, "GenericNetworkResponse{", '}');
    }

    public GenericNetworkResponse(Boolean r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.isSucceed = r2;
        this.body = r3;
        this.serverLogId = r4;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.isSucceed = this.isSucceed;
        r0.body = this.body;
        r0.serverLogId = this.serverLogId;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
