package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends Message<n, a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ProtoAdapter<n> f10424g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    @com.google.gson.y.c("parameters")
    public final String f10425f;

    public static final class a extends Message.Builder<n, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10426a;

        public a() {
            this.f10426a = "";
        }

        public n a() {
            String r0 = this.f10426a;
            if (r0 == null) goto L7;
            return new n(this.f10426a, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "parameters"});
        }

        public a b(String r1) {
            this.f10426a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<n> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, n.class);
        }

        public n a(ProtoReader r6) {
            a r5 = new a();
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

        public void b(ProtoWriter r3, n r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.f10425f);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(n r3) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r3.f10425f) + r3.unknownFields().size();
        }

        public n d(n r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ n decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, n r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(n r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ n redact(n r1) {
            return d(r1);
        }
    }

    static {
        f10424g = new b();
    }

    public n(String r2, k.h r3) {
        super(f10424g, r3);
        this.f10425f = r2;
    }

    public a b() {
        a r0 = new a();
        r0.f10426a = this.f10425f;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f10425f.equals(r6.f10425f) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f10425f.hashCode();
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
        r0.append(", parameters=");
        r0.append(this.f10425f);
        StringBuilder r3 = r0.replace(0, 2, "GetTTNetParametersResponse{");
        r3.append('}');
        return r3.toString();
    }
}
