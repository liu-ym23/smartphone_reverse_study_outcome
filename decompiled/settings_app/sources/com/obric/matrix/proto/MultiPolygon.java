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

/* JADX INFO: loaded from: classes4.dex */
public final class MultiPolygon extends Message<MultiPolygon, Builder> {
    public static final ProtoAdapter<MultiPolygon> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("polygons")
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Polygon> polygons;

    public static final class Builder extends Message.Builder<MultiPolygon, Builder> {
        public List<Polygon> polygons;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.polygons = Internal.newMutableList();
        }

        public Builder polygons(List<Polygon> r1) {
            Internal.checkElementsNotNull(r1);
            this.polygons = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public MultiPolygon build() {
            return new MultiPolygon(this.polygons, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_MultiPolygon extends ProtoAdapter<MultiPolygon> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MultiPolygon decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, MultiPolygon r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MultiPolygon r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MultiPolygon redact(MultiPolygon r1) {
            return redact2(r1);
        }

        public ProtoAdapter_MultiPolygon() {
            super(FieldEncoding.LENGTH_DELIMITED, MultiPolygon.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MultiPolygon r3) {
            return Polygon.ADAPTER.asRepeated().encodedSizeWithTag(1, r3.polygons) + r3.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, MultiPolygon r4) throws IOException {
            Polygon.ADAPTER.asRepeated().encodeWithTag(r3, 1, r4.polygons);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MultiPolygon decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.polygons.add(Polygon.ADAPTER.decode(r6));
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
        public MultiPolygon redact2(MultiPolygon r2) {
            Builder r1 = r2.newBuilder();
            Internal.redactElements(r1.polygons, Polygon.ADAPTER);
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_MultiPolygon();
    }

    public MultiPolygon(List<Polygon> r2) {
        this(r2, ByteString.EMPTY);
    }

    public MultiPolygon(List<Polygon> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.polygons = Internal.immutableCopyOf("polygons", r2);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.polygons = Internal.copyOf("polygons", this.polygons);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof MultiPolygon) == true) goto L8;
        return false;
    L8:
        MultiPolygon r6 = (MultiPolygon) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.polygons.equals(r6.polygons) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.polygons.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<Polygon> r1 = this.polygons;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", polygons=").append(this.polygons);
    L8:
        return r0.replace(0, 2, "MultiPolygon{").append('}').toString();
    }
}
