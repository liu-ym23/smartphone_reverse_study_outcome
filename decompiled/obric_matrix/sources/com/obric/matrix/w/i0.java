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
public final class i0 extends Message<i0, a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ProtoAdapter<i0> f10383h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @com.google.gson.y.c("appid")
    public final String f10384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("eventMap")
    public final Map<String, String> f10385g;

    public static final class a extends Message.Builder<i0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f10387b;

        public a() {
            this.f10386a = "";
            this.f10387b = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f10386a = r1;
            return this;
        }

        public i0 b() {
            return new i0(this.f10386a, this.f10387b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.f10387b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<i0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10388a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, i0.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10388a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public i0 a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.a(ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f10387b.putAll(this.f10388a.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.b();
        }

        public void b(ProtoWriter r4, i0 r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.f10384f);
            this.f10388a.encodeWithTag(r4, 2, r5.f10385g);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(i0 r4) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r4.f10384f) + this.f10388a.encodedSizeWithTag(2, r4.f10385g)) + r4.unknownFields().size();
        }

        public i0 d(i0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ i0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, i0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(i0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ i0 redact(i0 r1) {
            return d(r1);
        }
    }

    static {
        f10383h = new b();
    }

    public i0(String r2, Map<String, String> r3, k.h r4) {
        super(f10383h, r4);
        this.f10384f = r2;
        this.f10385g = Internal.immutableCopyOf("eventMap", r3);
    }

    public a b() {
        a r0 = new a();
        r0.f10386a = this.f10384f;
        r0.f10387b = Internal.copyOf("eventMap", this.f10385g);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r6 = (i0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f10384f, r6.f10384f) == false) goto L16;
        if (this.f10385g.equals(r6.f10385g) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f10384f;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.f10385g.hashCode();
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
        if (this.f10384f == null) goto L5;
        r0.append(", appid=");
        r0.append(this.f10384f);
    L5:
        Map<String, String> r1 = this.f10385g;
        if (r1 != null) goto L8;
    L10:
        StringBuilder r3 = r0.replace(0, 2, "SendApplogEventRequest{");
        r3.append('}');
        return r3.toString();
    L8:
        if (r1.isEmpty() == true) goto L10;
        r0.append(", eventMap=");
        r0.append(this.f10385g);
        goto L10
    }
}
