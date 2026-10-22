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
public final class y extends Message<y, a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ProtoAdapter<y> f10589g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    @com.google.gson.y.c("vertices")
    public final List<x> f10590f;

    public static final class a extends Message.Builder<y, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<x> f10591a;

        public a() {
            this.f10591a = Internal.newMutableList();
        }

        public y a() {
            return new y(this.f10591a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<y> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, y.class);
        }

        public y a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.f10591a.add(x.f10581h.decode(r6));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, y r4) {
            x.f10581h.asRepeated().encodeWithTag(r3, 1, r4.f10590f);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(y r3) {
            return x.f10581h.asRepeated().encodedSizeWithTag(1, r3.f10590f) + r3.unknownFields().size();
        }

        public y d(y r2) {
            a r1 = r2.b();
            Internal.redactElements(r1.f10591a, x.f10581h);
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ y decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, y r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(y r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ y redact(y r1) {
            return d(r1);
        }
    }

    static {
        f10589g = new b();
    }

    public y(List<x> r2, k.h r3) {
        super(f10589g, r3);
        this.f10590f = Internal.immutableCopyOf("vertices", r2);
    }

    public a b() {
        a r0 = new a();
        r0.f10591a = Internal.copyOf("vertices", this.f10590f);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f10590f.equals(r6.f10590f) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f10590f.hashCode();
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
        List<x> r1 = this.f10590f;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r3 = r0.replace(0, 2, "Polygon{");
        r3.append('}');
        return r3.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", vertices=");
        r0.append(this.f10590f);
        goto L7
    }
}
