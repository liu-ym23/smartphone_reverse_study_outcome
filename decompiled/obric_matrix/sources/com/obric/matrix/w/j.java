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
public final class j extends Message<j, a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ProtoAdapter<j> f10389i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    @com.google.gson.y.c("fences")
    public final List<f> f10390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 2)
    @com.google.gson.y.c("overlap_froms")
    public final List<Double> f10391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 3)
    @com.google.gson.y.c("overlap_targets")
    public final List<Double> f10392h;

    public static final class a extends Message.Builder<j, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<f> f10393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Double> f10394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Double> f10395c;

        public a() {
            this.f10393a = Internal.newMutableList();
            this.f10394b = Internal.newMutableList();
            this.f10395c = Internal.newMutableList();
        }

        public j a() {
            return new j(this.f10393a, this.f10394b, this.f10395c, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<j> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, j.class);
        }

        public j a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L17;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L13;
            if (r2 != 3) goto L11;
            List r3 = r5.f10395c;
        L14:
            Object r4 = (Double) ProtoAdapter.DOUBLE.decode(r6);
        L16:
            r3.add(r4);
            goto L3
        L11:
            FieldEncoding r7 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r7, r7.rawProtoAdapter().decode(r6));
            goto L3
        L13:
            r3 = r5.f10394b;
            goto L14
        L15:
            r3 = r5.f10393a;
            r4 = (f) f.m.decode(r6);
            goto L16
        L17:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r4, j r5) {
            f.m.asRepeated().encodeWithTag(r4, 1, r5.f10390f);
            ProtoAdapter<Double> r3 = ProtoAdapter.DOUBLE;
            r3.asRepeated().encodeWithTag(r4, 2, r5.f10391g);
            r3.asRepeated().encodeWithTag(r4, 3, r5.f10392h);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(j r5) {
            int r4 = f.m.asRepeated().encodedSizeWithTag(1, r5.f10390f);
            ProtoAdapter<Double> r0 = ProtoAdapter.DOUBLE;
            return ((r4 + r0.asRepeated().encodedSizeWithTag(2, r5.f10391g)) + r0.asRepeated().encodedSizeWithTag(3, r5.f10392h)) + r5.unknownFields().size();
        }

        public j d(j r2) {
            a r1 = r2.b();
            Internal.redactElements(r1.f10393a, f.m);
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ j decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, j r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(j r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ j redact(j r1) {
            return d(r1);
        }
    }

    static {
        f10389i = new b();
    }

    public j(List<f> r2, List<Double> r3, List<Double> r4, k.h r5) {
        super(f10389i, r5);
        this.f10390f = Internal.immutableCopyOf("fences", r2);
        this.f10391g = Internal.immutableCopyOf("overlap_froms", r3);
        this.f10392h = Internal.immutableCopyOf("overlap_targets", r4);
    }

    public a b() {
        a r0 = new a();
        r0.f10393a = Internal.copyOf("fences", this.f10390f);
        r0.f10394b = Internal.copyOf("overlap_froms", this.f10391g);
        r0.f10395c = Internal.copyOf("overlap_targets", this.f10392h);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (this.f10390f.equals(r6.f10390f) == false) goto L18;
        if (this.f10391g.equals(r6.f10391g) == false) goto L18;
        if (this.f10392h.equals(r6.f10392h) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((((unknownFields().hashCode() * 37) + this.f10390f.hashCode()) * 37) + this.f10391g.hashCode()) * 37) + this.f10392h.hashCode();
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
        List<f> r1 = this.f10390f;
        if (r1 != null) goto L5;
    L7:
        List<Double> r2 = this.f10391g;
        if (r2 != null) goto L10;
    L12:
        List<Double> r3 = this.f10392h;
        if (r3 != null) goto L15;
    L17:
        StringBuilder r4 = r0.replace(0, 2, "GetIntersectFencesResponse{");
        r4.append('}');
        return r4.toString();
    L15:
        if (r3.isEmpty() == true) goto L17;
        r0.append(", overlap_targets=");
        r0.append(this.f10392h);
        goto L17
    L10:
        if (r2.isEmpty() == true) goto L12;
        r0.append(", overlap_froms=");
        r0.append(this.f10391g);
        goto L12
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", fences=");
        r0.append(this.f10390f);
        goto L7
    }
}
