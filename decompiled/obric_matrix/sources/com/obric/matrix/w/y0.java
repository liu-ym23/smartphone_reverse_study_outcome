package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 extends Message<y0, a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ProtoAdapter<y0> f10592h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @com.google.gson.y.c("opt")
    public final Integer f10593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("packageName")
    public final String f10594g;

    public static final class a extends Message.Builder<y0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10596b;

        public a() {
            this.f10595a = 0;
            this.f10596b = "";
        }

        public y0 a() {
            return new y0(this.f10595a, this.f10596b, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.f10595a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.f10596b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<y0> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, y0.class);
        }

        public y0 a(ProtoReader r6) {
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
            r5.c(ProtoAdapter.STRING.decode(r6));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, y0 r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.f10593f);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.f10594g);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(y0 r4) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r4.f10593f) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.f10594g)) + r4.unknownFields().size();
        }

        public y0 d(y0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ y0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, y0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(y0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ y0 redact(y0 r1) {
            return d(r1);
        }
    }

    static {
        f10592h = new b();
    }

    public y0(Integer r2, String r3, k.h r4) {
        super(f10592h, r4);
        this.f10593f = r2;
        this.f10594g = r3;
    }

    public a b() {
        a r0 = new a();
        r0.f10595a = this.f10593f;
        r0.f10596b = this.f10594g;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r6 = (y0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f10593f, r6.f10593f) == false) goto L16;
        if (Internal.equals(this.f10594g, r6.f10594g) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10593f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10594g;
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
        if (this.f10593f == null) goto L6;
        r0.append(", opt=");
        r0.append(this.f10593f);
    L6:
        if (this.f10594g == null) goto L8;
        r0.append(", packageName=");
        r0.append(this.f10594g);
    L8:
        StringBuilder r3 = r0.replace(0, 2, "SubscribeWsStatusRequest{");
        r3.append('}');
        return r3.toString();
    }
}
