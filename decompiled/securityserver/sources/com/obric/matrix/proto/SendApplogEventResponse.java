package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class SendApplogEventResponse extends Message<SendApplogEventResponse, Builder> {
    public static final ProtoAdapter<SendApplogEventResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<SendApplogEventResponse, Builder> {
        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.squareup.wire.Message.Builder
        public SendApplogEventResponse build() {
            return new SendApplogEventResponse(buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SendApplogEventResponse extends ProtoAdapter<SendApplogEventResponse> {
        public ProtoAdapter_SendApplogEventResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendApplogEventResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendApplogEventResponse decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SendApplogEventResponse r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendApplogEventResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendApplogEventResponse redact(SendApplogEventResponse r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendApplogEventResponse decode(ProtoReader r6) {
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

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r1, SendApplogEventResponse r2) {
            r1.writeBytes(r2.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendApplogEventResponse r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SendApplogEventResponse redact2(SendApplogEventResponse r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SendApplogEventResponse();
    }

    public SendApplogEventResponse() {
        this(ByteString.EMPTY);
    }

    public boolean equals(Object r1) {
        return r1 instanceof SendApplogEventResponse;
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r3 = new StringBuilder().replace(0, 2, "SendApplogEventResponse{");
        r3.append('}');
        return r3.toString();
    }

    public SendApplogEventResponse(ByteString r2) {
        super(ADAPTER, r2);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
