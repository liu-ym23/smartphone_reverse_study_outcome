package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Message<a, C0286a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ProtoAdapter<a> f10175g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @com.google.gson.y.c("strParam")
    public final String f10176f;

    /* JADX INFO: renamed from: com.obric.matrix.w.a$a, reason: collision with other inner class name */
    public static final class C0286a extends Message.Builder<a, C0286a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10177a;

        public C0286a() {
            this.f10177a = "";
        }

        public a a() {
            return new a(this.f10177a, super.buildUnknownFields());
        }

        public C0286a b(String r1) {
            this.f10177a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<a> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, a.class);
        }

        public a a(ProtoReader r6) {
            C0286a r5 = new C0286a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.b(ProtoAdapter.STRING.decode(r6));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, a r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.f10176f);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(a r3) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r3.f10176f) + r3.unknownFields().size();
        }

        public a d(a r1) {
            C0286a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ a decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, a r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(a r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ a redact(a r1) {
            return d(r1);
        }
    }

    static {
        f10175g = new b();
    }

    public a(String r2, k.h r3) {
        super(f10175g, r3);
        this.f10176f = r2;
    }

    public C0286a b() {
        C0286a r0 = new C0286a();
        r0.f10177a = this.f10176f;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f10176f, r6.f10176f) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f10176f;
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
        if (this.f10176f == null) goto L5;
        r0.append(", strParam=");
        r0.append(this.f10176f);
    L5:
        StringBuilder r3 = r0.replace(0, 2, "BizExampleRequest{");
        r3.append('}');
        return r3.toString();
    }
}
