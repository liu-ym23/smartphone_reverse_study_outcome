package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends Message<a0, a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ProtoAdapter<a0> f10178h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @com.google.gson.y.c("resultCode")
    public final Integer f10179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @com.google.gson.y.c("resultMsg")
    public final Integer f10180g;

    public static final class a extends Message.Builder<a0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f10182b;

        public a() {
            this.f10181a = 0;
            this.f10182b = 0;
        }

        public a0 a() {
            return new a0(this.f10181a, this.f10182b, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.f10181a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r1) {
            this.f10182b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<a0> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, a0.class);
        }

        public a0 a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.b(ProtoAdapter.INT32.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.c(ProtoAdapter.INT32.decode(r6));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, a0 r4) {
            ProtoAdapter<Integer> r2 = ProtoAdapter.INT32;
            r2.encodeWithTag(r3, 1, r4.f10179f);
            r2.encodeWithTag(r3, 2, r4.f10180g);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(a0 r4) {
            ProtoAdapter<Integer> r3 = ProtoAdapter.INT32;
            return (r3.encodedSizeWithTag(1, r4.f10179f) + r3.encodedSizeWithTag(2, r4.f10180g)) + r4.unknownFields().size();
        }

        public a0 d(a0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ a0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, a0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(a0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ a0 redact(a0 r1) {
            return d(r1);
        }
    }

    static {
        f10178h = new b();
    }

    public a0(Integer r2, Integer r3, k.h r4) {
        super(f10178h, r4);
        this.f10179f = r2;
        this.f10180g = r3;
    }

    public a b() {
        a r0 = new a();
        r0.f10181a = this.f10179f;
        r0.f10182b = this.f10180g;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f10179f, r6.f10179f) == false) goto L16;
        if (Internal.equals(this.f10180g, r6.f10180g) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10179f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f10180g;
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
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10179f == null) goto L6;
        r0.append(", resultCode=");
        r0.append(this.f10179f);
    L6:
        if (this.f10180g == null) goto L8;
        r0.append(", resultMsg=");
        r0.append(this.f10180g);
    L8:
        StringBuilder r3 = r0.replace(0, 2, "RefreshLocationResponse{");
        r3.append('}');
        return r3.toString();
    }
}
