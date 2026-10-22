package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends Message<r, a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ProtoAdapter<r> f10495g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    @com.google.gson.y.c("polygons")
    public final List<y> f10496f;

    public static final class a extends Message.Builder<r, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<y> f10497a;

        public a() {
            this.f10497a = Internal.newMutableList();
        }

        public r a() {
            return new r(this.f10497a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<r> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, r.class);
        }

        public r a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.f10497a.add(y.f10589g.decode(r6));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, r r4) {
            y.f10589g.asRepeated().encodeWithTag(r3, 1, r4.f10496f);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(r r3) {
            return y.f10589g.asRepeated().encodedSizeWithTag(1, r3.f10496f) + r3.unknownFields().size();
        }

        public r d(r r2) {
            a r1 = r2.b();
            Internal.redactElements(r1.f10497a, y.f10589g);
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ r decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, r r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(r r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ r redact(r r1) {
            return d(r1);
        }
    }

    static {
        f10495g = new b();
    }

    public r(List<y> r2, k.h r3) {
        super(f10495g, r3);
        this.f10496f = Internal.immutableCopyOf("polygons", r2);
    }

    public a b() {
        a r0 = new a();
        r0.f10497a = Internal.copyOf("polygons", this.f10496f);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f10496f.equals(r6.f10496f) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f10496f.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<y> r1 = this.f10496f;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r3 = r0.replace(0, 2, "MultiPolygon{");
        r3.append('}');
        return r3.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", polygons=");
        r0.append(this.f10496f);
        goto L7
    }
}
