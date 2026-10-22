package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends Message<l, a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ProtoAdapter<l> f10403g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.LocationInfo#ADAPTER", tag = 1)
    @com.google.gson.y.c("locationInfo")
    public final o f10404f;

    public static final class a extends Message.Builder<l, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o f10405a;

        public a() {
        }

        public l a() {
            return new l(this.f10405a, super.buildUnknownFields());
        }

        public a b(o r1) {
            this.f10405a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<l> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, l.class);
        }

        public l a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.b(o.u.decode(r6));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, l r4) {
            o.u.encodeWithTag(r3, 1, r4.f10404f);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(l r3) {
            return o.u.encodedSizeWithTag(1, r3.f10404f) + r3.unknownFields().size();
        }

        public l d(l r2) {
            a r1 = r2.b();
            o r3 = r1.f10405a;
            if (r3 == null) goto L5;
            r1.f10405a = o.u.redact(r3);
        L5:
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ l decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, l r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(l r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ l redact(l r1) {
            return d(r1);
        }
    }

    static {
        f10403g = new b();
    }

    public l(o r2, k.h r3) {
        super(f10403g, r3);
        this.f10404f = r2;
    }

    public a b() {
        a r0 = new a();
        r0.f10405a = this.f10404f;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f10404f, r6.f10404f) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        o r2 = this.f10404f;
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
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10404f == null) goto L5;
        r0.append(", locationInfo=");
        r0.append(this.f10404f);
    L5:
        StringBuilder r3 = r0.replace(0, 2, "GetLocationResponse{");
        r3.append('}');
        return r3.toString();
    }
}
