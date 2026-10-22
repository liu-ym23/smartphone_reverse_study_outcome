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
public final class DecodeLocationRequest extends Message<DecodeLocationRequest, Builder> {
    public static final ProtoAdapter<DecodeLocationRequest> ADAPTER = null;
    public static final Double DEFAULT_LATITUDE = null;
    public static final Double DEFAULT_LONGITUDE = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 3)
    public final Double latitude;

    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double longitude;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String packageName;

    public static final class Builder extends Message.Builder<DecodeLocationRequest, Builder> {
        public Double latitude;
        public Double longitude;
        public String packageName;

        public Builder() {
            this.packageName = "";
            Double r0 = Double.valueOf(0.0d);
            this.longitude = r0;
            this.latitude = r0;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder latitude(Double r1) {
            this.latitude = r1;
            return this;
        }

        public Builder longitude(Double r1) {
            this.longitude = r1;
            return this;
        }

        public Builder packageName(String r1) {
            this.packageName = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public DecodeLocationRequest build() {
            return new DecodeLocationRequest(this.packageName, this.longitude, this.latitude, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_DecodeLocationRequest extends ProtoAdapter<DecodeLocationRequest> {
        public ProtoAdapter_DecodeLocationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DecodeLocationRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DecodeLocationRequest decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, DecodeLocationRequest r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DecodeLocationRequest r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DecodeLocationRequest redact(DecodeLocationRequest r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DecodeLocationRequest decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            r5.packageName(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.longitude(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r5.latitude(ProtoAdapter.DOUBLE.decode(r6));
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
        public void encode2(ProtoWriter r3, DecodeLocationRequest r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.packageName);
            ProtoAdapter<Double> r2 = ProtoAdapter.DOUBLE;
            r2.encodeWithTag(r3, 2, r4.longitude);
            r2.encodeWithTag(r3, 3, r4.latitude);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DecodeLocationRequest r4) {
            int r3 = ProtoAdapter.STRING.encodedSizeWithTag(1, r4.packageName);
            ProtoAdapter<Double> r0 = ProtoAdapter.DOUBLE;
            int r1 = r0.encodedSizeWithTag(2, r4.longitude) + r3;
            int r5 = r0.encodedSizeWithTag(3, r4.latitude) + r1;
            return r4.unknownFields().size() + r5;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public DecodeLocationRequest redact2(DecodeLocationRequest r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DecodeLocationRequest();
        Double r0 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r0;
        DEFAULT_LATITUDE = r0;
    }

    public DecodeLocationRequest(String r2, Double r3, Double r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof DecodeLocationRequest) == true) goto L8;
        return false;
    L8:
        DecodeLocationRequest r6 = (DecodeLocationRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L18;
        if (Internal.equals(this.longitude, r6.longitude) == false) goto L18;
        if (Internal.equals(this.latitude, r6.latitude) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.packageName;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.longitude;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Double r9 = this.latitude;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.packageName == null) goto L6;
        r0.append(", packageName=");
        r0.append(this.packageName);
    L6:
        if (this.longitude == null) goto L9;
        r0.append(", longitude=");
        r0.append(this.longitude);
    L9:
        if (this.latitude == null) goto L12;
        r0.append(", latitude=");
        r0.append(this.latitude);
    L12:
        return a.m(r0, 0, 2, "DecodeLocationRequest{", '}');
    }

    public DecodeLocationRequest(String r2, Double r3, Double r4, ByteString r5) {
        super(ADAPTER, r5);
        this.packageName = r2;
        this.longitude = r3;
        this.latitude = r4;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.packageName = this.packageName;
        r0.longitude = this.longitude;
        r0.latitude = this.latitude;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
