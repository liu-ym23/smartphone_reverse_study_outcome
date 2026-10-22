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
public final class GetTTNetParametersResponse extends Message<GetTTNetParametersResponse, Builder> {
    public static final ProtoAdapter<GetTTNetParametersResponse> ADAPTER = null;
    public static final String DEFAULT_PARAMETERS = "";
    private static final long serialVersionUID = 0;

    @SerializedName("parameters")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String parameters;

    public static final class Builder extends Message.Builder<GetTTNetParametersResponse, Builder> {
        public String parameters;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.parameters = "";
        }

        public Builder parameters(String r1) {
            this.parameters = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public GetTTNetParametersResponse build() {
            String r0 = this.parameters;
            if (r0 == null) goto L7;
            return new GetTTNetParametersResponse(this.parameters, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "parameters"});
        }
    }

    private static final class ProtoAdapter_GetTTNetParametersResponse extends ProtoAdapter<GetTTNetParametersResponse> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersResponse decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, GetTTNetParametersResponse r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTTNetParametersResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersResponse redact(GetTTNetParametersResponse r1) {
            return redact2(r1);
        }

        public ProtoAdapter_GetTTNetParametersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersResponse.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTTNetParametersResponse r3) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r3.parameters) + r3.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, GetTTNetParametersResponse r4) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.parameters);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTTNetParametersResponse decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.parameters(ProtoAdapter.STRING.decode(r6));
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
        public GetTTNetParametersResponse redact2(GetTTNetParametersResponse r1) {
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
        ADAPTER = new ProtoAdapter_GetTTNetParametersResponse();
    }

    public GetTTNetParametersResponse(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public GetTTNetParametersResponse(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.parameters = r2;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.parameters = this.parameters;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetTTNetParametersResponse) == true) goto L8;
        return false;
    L8:
        GetTTNetParametersResponse r6 = (GetTTNetParametersResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.parameters.equals(r6.parameters) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.parameters.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(", parameters=").append(this.parameters);
        return r0.replace(0, 2, "GetTTNetParametersResponse{").append('}').toString();
    }
}
