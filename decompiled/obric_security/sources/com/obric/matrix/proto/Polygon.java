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
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class Polygon extends Message<Polygon, Builder> {
    public static final ProtoAdapter<Polygon> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("vertices")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Point> vertices;

    public static final class Builder extends Message.Builder<Polygon, Builder> {
        public List<Point> vertices;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.vertices = Internal.newMutableList();
        }

        public Builder vertices(List<Point> r1) {
            Internal.checkElementsNotNull(r1);
            this.vertices = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Polygon build() {
            return new Polygon(this.vertices, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_Polygon extends ProtoAdapter<Polygon> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Polygon decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Polygon r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Polygon r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Polygon redact(Polygon r1) {
            return redact2(r1);
        }

        public ProtoAdapter_Polygon() {
            super(FieldEncoding.LENGTH_DELIMITED, Polygon.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Polygon r3) {
            return Point.ADAPTER.asRepeated().encodedSizeWithTag(1, r3.vertices) + r3.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, Polygon r4) throws IOException {
            Point.ADAPTER.asRepeated().encodeWithTag(r3, 1, r4.vertices);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Polygon decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.vertices.add(Point.ADAPTER.decode(r6));
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
        public Polygon redact2(Polygon r2) {
            Builder r1 = r2.newBuilder();
            Internal.redactElements(r1.vertices, Point.ADAPTER);
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_Polygon();
    }

    public Polygon(List<Point> r2) {
        this(r2, ByteString.EMPTY);
    }

    public Polygon(List<Point> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.vertices = Internal.immutableCopyOf("vertices", r2);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.vertices = Internal.copyOf("vertices", this.vertices);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Polygon) == true) goto L8;
        return false;
    L8:
        Polygon r6 = (Polygon) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.vertices.equals(r6.vertices) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.vertices.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<Point> r1 = this.vertices;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", vertices=").append(this.vertices);
    L8:
        return r0.replace(0, 2, "Polygon{").append('}').toString();
    }
}
