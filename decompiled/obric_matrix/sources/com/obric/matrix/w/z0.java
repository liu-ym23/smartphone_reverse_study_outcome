package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 extends Message<z0, a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ProtoAdapter<z0> f10602j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @com.google.gson.y.c("channelType")
    public final Integer f10603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @com.google.gson.y.c("connectionState")
    public final Integer f10604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @com.google.gson.y.c("channelId")
    public final Integer f10605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    @com.google.gson.y.c("isConnected")
    public final Boolean f10606i;

    public static final class a extends Message.Builder<z0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f10608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f10609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f10610d;

        public a() {
            this.f10607a = 0;
            this.f10608b = 0;
            this.f10609c = 0;
            this.f10610d = Boolean.FALSE;
        }

        public z0 a() {
            return new z0(this.f10607a, this.f10608b, this.f10609c, this.f10610d, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.f10609c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r1) {
            this.f10607a = r1;
            return this;
        }

        public a d(Integer r1) {
            this.f10608b = r1;
            return this;
        }

        public a e(Boolean r1) {
            this.f10610d = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<z0> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, z0.class);
        }

        public z0 a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.c(ProtoAdapter.INT32.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.d(ProtoAdapter.INT32.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.b(ProtoAdapter.INT32.decode(r6));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.e(ProtoAdapter.BOOL.decode(r6));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, z0 r4) {
            ProtoAdapter<Integer> r2 = ProtoAdapter.INT32;
            r2.encodeWithTag(r3, 1, r4.f10603f);
            r2.encodeWithTag(r3, 2, r4.f10604g);
            r2.encodeWithTag(r3, 3, r4.f10605h);
            ProtoAdapter.BOOL.encodeWithTag(r3, 4, r4.f10606i);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(z0 r4) {
            ProtoAdapter<Integer> r3 = ProtoAdapter.INT32;
            return (((r3.encodedSizeWithTag(1, r4.f10603f) + r3.encodedSizeWithTag(2, r4.f10604g)) + r3.encodedSizeWithTag(3, r4.f10605h)) + ProtoAdapter.BOOL.encodedSizeWithTag(4, r4.f10606i)) + r4.unknownFields().size();
        }

        public z0 d(z0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ z0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, z0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(z0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ z0 redact(z0 r1) {
            return d(r1);
        }
    }

    static {
        f10602j = new b();
    }

    public z0(Integer r2, Integer r3, Integer r4, Boolean r5, k.h r6) {
        super(f10602j, r6);
        this.f10603f = r2;
        this.f10604g = r3;
        this.f10605h = r4;
        this.f10606i = r5;
    }

    public a b() {
        a r0 = new a();
        r0.f10607a = this.f10603f;
        r0.f10608b = this.f10604g;
        r0.f10609c = this.f10605h;
        r0.f10610d = this.f10606i;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r6 = (z0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f10603f, r6.f10603f) == false) goto L20;
        if (Internal.equals(this.f10604g, r6.f10604g) == false) goto L20;
        if (Internal.equals(this.f10605h, r6.f10605h) == false) goto L20;
        if (Internal.equals(this.f10606i, r6.f10606i) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10603f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f10604g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.f10605h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Boolean r12 = this.f10606i;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        this.hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10603f == null) goto L6;
        r0.append(", channelType=");
        r0.append(this.f10603f);
    L6:
        if (this.f10604g == null) goto L9;
        r0.append(", connectionState=");
        r0.append(this.f10604g);
    L9:
        if (this.f10605h == null) goto L12;
        r0.append(", channelId=");
        r0.append(this.f10605h);
    L12:
        if (this.f10606i == null) goto L14;
        r0.append(", isConnected=");
        r0.append(this.f10606i);
    L14:
        StringBuilder r3 = r0.replace(0, 2, "SubscribeWsStatusResponse{");
        r3.append('}');
        return r3.toString();
    }
}
