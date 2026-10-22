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
public final class g0 extends Message<g0, a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ProtoAdapter<g0> f10340g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @com.google.gson.y.c("configs")
    public final Map<String, String> f10341f;

    public static final class a extends Message.Builder<g0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f10342a;

        public a() {
            this.f10342a = Internal.newMutableMap();
        }

        public g0 a() {
            return new g0(this.f10342a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<g0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10343a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, g0.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10343a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public g0 a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.f10342a.putAll(this.f10343a.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r3, g0 r4) {
            this.f10343a.encodeWithTag(r3, 1, r4.f10341f);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(g0 r3) {
            return this.f10343a.encodedSizeWithTag(1, r3.f10341f) + r3.unknownFields().size();
        }

        public g0 d(g0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ g0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, g0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(g0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ g0 redact(g0 r1) {
            return d(r1);
        }
    }

    static {
        f10340g = new b();
    }

    public g0(Map<String, String> r2, k.h r3) {
        super(f10340g, r3);
        this.f10341f = Internal.immutableCopyOf("configs", r2);
    }

    public a b() {
        a r0 = new a();
        r0.f10342a = Internal.copyOf("configs", this.f10341f);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r6 = (g0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f10341f.equals(r6.f10341f) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f10341f.hashCode();
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
        Map<String, String> r1 = this.f10341f;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r3 = r0.replace(0, 2, "SdkCommonConfig{");
        r3.append('}');
        return r3.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", configs=");
        r0.append(this.f10341f);
        goto L7
    }
}
