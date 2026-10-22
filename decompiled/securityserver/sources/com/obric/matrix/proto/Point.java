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
public final class Point extends Message<Point, Builder> {
    public static final ProtoAdapter<Point> ADAPTER = null;
    public static final Double DEFAULT_LATITUDE = null;
    public static final Double DEFAULT_LONGITUDE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double latitude;

    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double longitude;

    public static final class Builder extends Message.Builder<Point, Builder> {
        public Double latitude;
        public Double longitude;

        public Builder() {
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

        @Override // com.squareup.wire.Message.Builder
        public Point build() {
            return new Point(this.longitude, this.latitude, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Point extends ProtoAdapter<Point> {
        public ProtoAdapter_Point() {
            super(FieldEncoding.LENGTH_DELIMITED, Point.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Point decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Point r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Point r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Point redact(Point r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Point decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.longitude(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.latitude(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, Point r4) {
            ProtoAdapter<Double> r2 = ProtoAdapter.DOUBLE;
            r2.encodeWithTag(r3, 1, r4.longitude);
            r2.encodeWithTag(r3, 2, r4.latitude);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Point r4) {
            ProtoAdapter<Double> r3 = ProtoAdapter.DOUBLE;
            int r0 = r3.encodedSizeWithTag(1, r4.longitude);
            int r5 = r3.encodedSizeWithTag(2, r4.latitude) + r0;
            return r4.unknownFields().size() + r5;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Point redact2(Point r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Point();
        Double r0 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r0;
        DEFAULT_LATITUDE = r0;
    }

    public Point(Double r2, Double r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Point) == true) goto L8;
        return false;
    L8:
        Point r6 = (Point) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.longitude, r6.longitude) == false) goto L16;
        if (Internal.equals(this.latitude, r6.latitude) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Double r2 = this.longitude;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.latitude;
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
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.longitude == null) goto L6;
        r0.append(", longitude=");
        r0.append(this.longitude);
    L6:
        if (this.latitude == null) goto L9;
        r0.append(", latitude=");
        r0.append(this.latitude);
    L9:
        return a.m(r0, 0, 2, "Point{", '}');
    }

    public Point(Double r2, Double r3, ByteString r4) {
        super(ADAPTER, r4);
        this.longitude = r2;
        this.latitude = r3;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.longitude = this.longitude;
        r0.latitude = this.latitude;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
