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
public final class Circle extends Message<Circle, Builder> {
    public static final ProtoAdapter<Circle> ADAPTER = null;
    public static final Double DEFAULT_RADIUS = null;
    private static final long serialVersionUID = 0;

    @SerializedName("center")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", tag = 1)
    public final Point center;

    @SerializedName("radius")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double radius;

    public static final class Builder extends Message.Builder<Circle, Builder> {
        public Point center;
        public Double radius;

        public Builder() {
            this.radius = Double.valueOf(0.0d);
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder center(Point r1) {
            this.center = r1;
            return this;
        }

        public Builder radius(Double r1) {
            this.radius = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Circle build() {
            return new Circle(this.center, this.radius, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Circle extends ProtoAdapter<Circle> {
        public ProtoAdapter_Circle() {
            super(FieldEncoding.LENGTH_DELIMITED, Circle.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Circle decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Circle r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Circle r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Circle redact(Circle r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Circle decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.center(Point.ADAPTER.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.radius(ProtoAdapter.DOUBLE.decode(r6));
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
        public void encode2(ProtoWriter r3, Circle r4) {
            Point.ADAPTER.encodeWithTag(r3, 1, r4.center);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.radius);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Circle r4) {
            int r3 = Point.ADAPTER.encodedSizeWithTag(1, r4.center);
            int r0 = ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.radius) + r3;
            return r4.unknownFields().size() + r0;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Circle redact2(Circle r2) {
            Builder r1 = r2.newBuilder();
            Point r3 = r1.center;
            if (r3 == null) goto L5;
            r1.center = Point.ADAPTER.redact(r3);
        L5:
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Circle();
        DEFAULT_RADIUS = Double.valueOf(0.0d);
    }

    public Circle(Point r2, Double r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Circle) == true) goto L8;
        return false;
    L8:
        Circle r6 = (Circle) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.center, r6.center) == false) goto L16;
        if (Internal.equals(this.radius, r6.radius) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Point r2 = this.center;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.radius;
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
        if (this.center == null) goto L6;
        r0.append(", center=");
        r0.append(this.center);
    L6:
        if (this.radius == null) goto L9;
        r0.append(", radius=");
        r0.append(this.radius);
    L9:
        return a.m(r0, 0, 2, "Circle{", '}');
    }

    public Circle(Point r2, Double r3, ByteString r4) {
        super(ADAPTER, r4);
        this.center = r2;
        this.radius = r3;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.center = this.center;
        r0.radius = this.radius;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
