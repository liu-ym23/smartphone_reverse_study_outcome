package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends Message<t, a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ProtoAdapter<t> f10515g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @com.google.gson.y.c("_value")
    public final Map<String, String> f10516f;

    public static final class a extends Message.Builder<t, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f10517a;

        public a() {
            this.f10517a = Internal.newMutableMap();
        }

        public t a() {
            return new t(this.f10517a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10518a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, t.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10518a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public t a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.f10517a.putAll(this.f10518a.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r3, t r4) {
            this.f10518a.encodeWithTag(r3, 1, r4.f10516f);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(t r3) {
            return this.f10518a.encodedSizeWithTag(1, r3.f10516f) + r3.unknownFields().size();
        }

        public t d(t r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ t decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, t r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(t r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ t redact(t r1) {
            return d(r1);
        }
    }

    static {
        f10515g = new b();
    }

    public t(Map<String, String> r2, k.h r3) {
        super(f10515g, r3);
        this.f10516f = Internal.immutableCopyOf("_value", r2);
    }

    public a b() {
        a r0 = new a();
        r0.f10517a = Internal.copyOf("_value", this.f10516f);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f10516f.equals(r6.f10516f) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f10516f.hashCode();
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
        Map<String, String> r1 = this.f10516f;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r3 = r0.replace(0, 2, "NullableMap{");
        r3.append('}');
        return r3.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", _value=");
        r0.append(this.f10516f);
        goto L7
    }
}
