package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends Message<h, a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ProtoAdapter<h> f10344i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 1)
    @com.google.gson.y.c("isSucceed")
    public final Boolean f10345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    @com.google.gson.y.c("body")
    public final String f10346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    @com.google.gson.y.c("serverLogId")
    public final String f10347h;

    public static final class a extends Message.Builder<h, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f10348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10350c;

        public a() {
            this.f10348a = Boolean.FALSE;
            this.f10349b = "";
            this.f10350c = "";
        }

        public a a(String r1) {
            this.f10349b = r1;
            return this;
        }

        public h b() {
            Boolean r0 = this.f10348a;
            if (r0 == null) goto L11;
            if (this.f10349b == null) goto L11;
            if (this.f10350c == null) goto L11;
            return new h(this.f10348a, this.f10349b, this.f10350c, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "isSucceed", this.f10349b, "body", this.f10350c, "serverLogId"});
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(Boolean r1) {
            this.f10348a = r1;
            return this;
        }

        public a d(String r1) {
            this.f10350c = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<h> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, h.class);
        }

        public h a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            r5.c(ProtoAdapter.BOOL.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.a(ProtoAdapter.STRING.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r5.d(ProtoAdapter.STRING.decode(r6));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L15:
            r6.endMessage(r0);
            return r5.b();
        }

        public void b(ProtoWriter r3, h r4) {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.f10345f);
            ProtoAdapter<String> r2 = ProtoAdapter.STRING;
            r2.encodeWithTag(r3, 2, r4.f10346g);
            r2.encodeWithTag(r3, 3, r4.f10347h);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(h r4) {
            int r3 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r4.f10345f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            return ((r3 + r0.encodedSizeWithTag(2, r4.f10346g)) + r0.encodedSizeWithTag(3, r4.f10347h)) + r4.unknownFields().size();
        }

        public h d(h r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ h decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, h r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(h r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ h redact(h r1) {
            return d(r1);
        }
    }

    static {
        f10344i = new b();
    }

    public h(Boolean r2, String r3, String r4, k.h r5) {
        super(f10344i, r5);
        this.f10345f = r2;
        this.f10346g = r3;
        this.f10347h = r4;
    }

    public a b() {
        a r0 = new a();
        r0.f10348a = this.f10345f;
        r0.f10349b = this.f10346g;
        r0.f10350c = this.f10347h;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (this.f10345f.equals(r6.f10345f) == false) goto L18;
        if (this.f10346g.equals(r6.f10346g) == false) goto L18;
        if (this.f10347h.equals(r6.f10347h) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((((unknownFields().hashCode() * 37) + this.f10345f.hashCode()) * 37) + this.f10346g.hashCode()) * 37) + this.f10347h.hashCode();
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
        r0.append(", isSucceed=");
        r0.append(this.f10345f);
        r0.append(", body=");
        r0.append(this.f10346g);
        r0.append(", serverLogId=");
        r0.append(this.f10347h);
        StringBuilder r3 = r0.replace(0, 2, "GenericNetworkResponse{");
        r3.append('}');
        return r3.toString();
    }
}
