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
public final class f0 extends Message<f0, a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ProtoAdapter<f0> f10318h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SdkSendCmdConfig#ADAPTER", tag = 1)
    @com.google.gson.y.c("sdkSendCmdConfig")
    public final h0 f10319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.SdkCommonConfig#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("otherConfig")
    public final Map<String, g0> f10320g;

    public static final class a extends Message.Builder<f0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h0 f10321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, g0> f10322b;

        public a() {
            this.f10322b = Internal.newMutableMap();
        }

        public f0 a() {
            return new f0(this.f10321a, this.f10322b, super.buildUnknownFields());
        }

        public a b(h0 r1) {
            this.f10321a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<f0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, g0>> f10323a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, f0.class);
            this.f10323a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, g0.f10340g);
        }

        public f0 a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.b(h0.m.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f10322b.putAll(this.f10323a.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r4, f0 r5) {
            h0.m.encodeWithTag(r4, 1, r5.f10319f);
            this.f10323a.encodeWithTag(r4, 2, r5.f10320g);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(f0 r4) {
            return (h0.m.encodedSizeWithTag(1, r4.f10319f) + this.f10323a.encodedSizeWithTag(2, r4.f10320g)) + r4.unknownFields().size();
        }

        public f0 d(f0 r2) {
            a r1 = r2.b();
            h0 r3 = r1.f10321a;
            if (r3 == null) goto L5;
            r1.f10321a = h0.m.redact(r3);
        L5:
            Internal.redactElements(r1.f10322b, g0.f10340g);
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ f0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, f0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(f0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ f0 redact(f0 r1) {
            return d(r1);
        }
    }

    static {
        f10318h = new b();
    }

    public f0(h0 r2, Map<String, g0> r3, k.h r4) {
        super(f10318h, r4);
        this.f10319f = r2;
        this.f10320g = Internal.immutableCopyOf("otherConfig", r3);
    }

    public a b() {
        a r0 = new a();
        r0.f10321a = this.f10319f;
        r0.f10322b = Internal.copyOf("otherConfig", this.f10320g);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r6 = (f0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f10319f, r6.f10319f) == false) goto L16;
        if (this.f10320g.equals(r6.f10320g) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        h0 r2 = this.f10319f;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.f10320g.hashCode();
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
        if (this.f10319f == null) goto L5;
        r0.append(", sdkSendCmdConfig=");
        r0.append(this.f10319f);
    L5:
        Map<String, g0> r1 = this.f10320g;
        if (r1 != null) goto L8;
    L10:
        StringBuilder r3 = r0.replace(0, 2, "SdkAllConfig{");
        r3.append('}');
        return r3.toString();
    L8:
        if (r1.isEmpty() == true) goto L10;
        r0.append(", otherConfig=");
        r0.append(this.f10320g);
        goto L10
    }
}
