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
public final class GetLocationResponse extends Message<GetLocationResponse, Builder> {
    public static final ProtoAdapter<GetLocationResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("locationInfo")
    @WireField(adapter = "com.obric.matrix.proto.LocationInfo#ADAPTER", tag = 1)
    public final LocationInfo locationInfo;

    public static final class Builder extends Message.Builder<GetLocationResponse, Builder> {
        public LocationInfo locationInfo;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
        }

        public Builder locationInfo(LocationInfo r1) {
            this.locationInfo = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public GetLocationResponse build() {
            return new GetLocationResponse(this.locationInfo, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_GetLocationResponse extends ProtoAdapter<GetLocationResponse> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLocationResponse decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, GetLocationResponse r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetLocationResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLocationResponse redact(GetLocationResponse r1) {
            return redact2(r1);
        }

        public ProtoAdapter_GetLocationResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLocationResponse.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetLocationResponse r3) {
            return LocationInfo.ADAPTER.encodedSizeWithTag(1, r3.locationInfo) + r3.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, GetLocationResponse r4) throws IOException {
            LocationInfo.ADAPTER.encodeWithTag(r3, 1, r4.locationInfo);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetLocationResponse decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.locationInfo(LocationInfo.ADAPTER.decode(r6));
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
        public GetLocationResponse redact2(GetLocationResponse r2) {
            Builder r1 = r2.newBuilder();
            if (r1.locationInfo == null) goto L5;
            r1.locationInfo = LocationInfo.ADAPTER.redact(r1.locationInfo);
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
        ADAPTER = new ProtoAdapter_GetLocationResponse();
    }

    public GetLocationResponse(LocationInfo r2) {
        this(r2, ByteString.EMPTY);
    }

    public GetLocationResponse(LocationInfo r2, ByteString r3) {
        super(ADAPTER, r3);
        this.locationInfo = r2;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.locationInfo = this.locationInfo;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetLocationResponse) == true) goto L8;
        return false;
    L8:
        GetLocationResponse r6 = (GetLocationResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.locationInfo, r6.locationInfo) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        LocationInfo r2 = this.locationInfo;
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
        if (this.locationInfo == null) goto L6;
        r0.append(", locationInfo=").append(this.locationInfo);
    L6:
        return r0.replace(0, 2, "GetLocationResponse{").append('}').toString();
    }
}
