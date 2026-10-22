package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 extends Message<w0, a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ProtoAdapter<w0> f10572j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @com.google.gson.y.c("service")
    public final Integer f10573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @com.google.gson.y.c("method")
    public final Integer f10574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @com.google.gson.y.c("packageName")
    public final String f10575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @com.google.gson.y.c("opt")
    public final Integer f10576i;

    public static final class a extends Message.Builder<w0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f10578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f10580d;

        public a() {
            this.f10577a = 0;
            this.f10578b = 0;
            this.f10579c = "";
            this.f10580d = 0;
        }

        public w0 a() {
            return new w0(this.f10577a, this.f10578b, this.f10579c, this.f10580d, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.f10578b = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r1) {
            this.f10580d = r1;
            return this;
        }

        public a d(String r1) {
            this.f10579c = r1;
            return this;
        }

        public a e(Integer r1) {
            this.f10577a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<w0> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, w0.class);
        }

        public w0 a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.e(ProtoAdapter.INT32.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.b(ProtoAdapter.INT32.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.d(ProtoAdapter.STRING.decode(r6));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.c(ProtoAdapter.INT32.decode(r6));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r4, w0 r5) {
            ProtoAdapter<Integer> r3 = ProtoAdapter.INT32;
            r3.encodeWithTag(r4, 1, r5.f10573f);
            r3.encodeWithTag(r4, 2, r5.f10574g);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.f10575h);
            r3.encodeWithTag(r4, 4, r5.f10576i);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(w0 r5) {
            ProtoAdapter<Integer> r4 = ProtoAdapter.INT32;
            return (((r4.encodedSizeWithTag(1, r5.f10573f) + r4.encodedSizeWithTag(2, r5.f10574g)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.f10575h)) + r4.encodedSizeWithTag(4, r5.f10576i)) + r5.unknownFields().size();
        }

        public w0 d(w0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ w0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, w0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(w0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ w0 redact(w0 r1) {
            return d(r1);
        }
    }

    static {
        f10572j = new b();
    }

    public w0(Integer r2, Integer r3, String r4, Integer r5, k.h r6) {
        super(f10572j, r6);
        this.f10573f = r2;
        this.f10574g = r3;
        this.f10575h = r4;
        this.f10576i = r5;
    }

    public a b() {
        a r0 = new a();
        r0.f10577a = this.f10573f;
        r0.f10578b = this.f10574g;
        r0.f10579c = this.f10575h;
        r0.f10580d = this.f10576i;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r6 = (w0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f10573f, r6.f10573f) == false) goto L20;
        if (Internal.equals(this.f10574g, r6.f10574g) == false) goto L20;
        if (Internal.equals(this.f10575h, r6.f10575h) == false) goto L20;
        if (Internal.equals(this.f10576i, r6.f10576i) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10573f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f10574g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10575h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.f10576i;
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
        if (this.f10573f == null) goto L6;
        r0.append(", service=");
        r0.append(this.f10573f);
    L6:
        if (this.f10574g == null) goto L9;
        r0.append(", method=");
        r0.append(this.f10574g);
    L9:
        if (this.f10575h == null) goto L12;
        r0.append(", packageName=");
        r0.append(this.f10575h);
    L12:
        if (this.f10576i == null) goto L14;
        r0.append(", opt=");
        r0.append(this.f10576i);
    L14:
        StringBuilder r3 = r0.replace(0, 2, "SubscribeWsMsgRequest{");
        r3.append('}');
        return r3.toString();
    }
}
