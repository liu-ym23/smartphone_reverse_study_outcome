package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class GetTTNetParametersRequest extends Message<GetTTNetParametersRequest, Builder> {
    public static final ProtoAdapter<GetTTNetParametersRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<GetTTNetParametersRequest, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public GetTTNetParametersRequest build() {
            return new GetTTNetParametersRequest(super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_GetTTNetParametersRequest extends ProtoAdapter<GetTTNetParametersRequest> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersRequest decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, GetTTNetParametersRequest r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTTNetParametersRequest r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersRequest redact(GetTTNetParametersRequest r1) {
            return redact2(r1);
        }

        public ProtoAdapter_GetTTNetParametersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersRequest.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTTNetParametersRequest r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r1, GetTTNetParametersRequest r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTTNetParametersRequest decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L6;
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L6:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetTTNetParametersRequest redact2(GetTTNetParametersRequest r1) {
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
        ADAPTER = new ProtoAdapter_GetTTNetParametersRequest();
    }

    public GetTTNetParametersRequest() {
        this(ByteString.EMPTY);
    }

    public GetTTNetParametersRequest(ByteString r2) {
        super(ADAPTER, r2);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r1) {
        return r1 instanceof GetTTNetParametersRequest;
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return new StringBuilder().replace(0, 2, "GetTTNetParametersRequest{").append('}').toString();
    }
}
