package com.obric.matrix.push;

import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends Message<k, a> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ProtoAdapter<k> f9611l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f9612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer f9613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f9614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String f9615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String f9616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 255)
    public final Map<String, String> f9617k;

    public static final class a extends Message.Builder<k, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f9619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f9621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f9622e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<String, String> f9623f;

        public a() {
            this.f9623f = Internal.newMutableMap();
        }

        public k a() {
            return new k(this.f9618a, this.f9619b, this.f9620c, this.f9621d, this.f9622e, this.f9623f, super.buildUnknownFields());
        }

        public a b(String r1) {
            this.f9618a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.f9620c = r1;
            return this;
        }

        public a d(String r1) {
            this.f9622e = r1;
            return this;
        }

        public a e(String r1) {
            this.f9621d = r1;
            return this;
        }

        public a f(Integer r1) {
            this.f9619b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f9624a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, k.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f9624a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public k a(ProtoReader r6) {
            a r0 = new a();
            long r1 = r6.beginMessage();
        L3:
            int r3 = r6.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.b(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.f(ProtoAdapter.INT32.decode(r6));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.c(ProtoAdapter.STRING.decode(r6));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.e(ProtoAdapter.STRING.decode(r6));
            goto L3
        L14:
            if (r3 != 5) goto L16;
            r0.d(ProtoAdapter.STRING.decode(r6));
            goto L3
        L16:
            if (r3 != 255) goto L17;
            r0.f9623f.putAll(this.f9624a.decode(r6));
            goto L3
        L17:
            r6.readUnknownField(r3);
            goto L3
        L24:
            r0.addUnknownFields(r6.endMessageAndGetUnknownFields(r1));
            return r0.a();
        }

        public void b(ProtoWriter r5, k r6) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.f9612f);
            ProtoAdapter.INT32.encodeWithTag(r5, 2, r6.f9613g);
            r0.encodeWithTag(r5, 3, r6.f9614h);
            r0.encodeWithTag(r5, 4, r6.f9615i);
            r0.encodeWithTag(r5, 5, r6.f9616j);
            this.f9624a.encodeWithTag(r5, 255, r6.f9617k);
            r5.writeBytes(r6.unknownFields());
        }

        public int c(k r6) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            return (((((r0.encodedSizeWithTag(1, r6.f9612f) + ProtoAdapter.INT32.encodedSizeWithTag(2, r6.f9613g)) + r0.encodedSizeWithTag(3, r6.f9614h)) + r0.encodedSizeWithTag(4, r6.f9615i)) + r0.encodedSizeWithTag(5, r6.f9616j)) + this.f9624a.encodedSizeWithTag(255, r6.f9617k)) + r6.unknownFields().size();
        }

        public k d(k r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ k decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, k r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(k r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ k redact(k r1) {
            return d(r1);
        }
    }

    static {
        f9611l = new b();
    }

    public k(String r2, Integer r3, String r4, String r5, String r6, Map<String, String> r7, k.h r8) {
        super(f9611l, r8);
        this.f9612f = r2;
        this.f9613g = r3;
        this.f9614h = r4;
        this.f9615i = r5;
        this.f9616j = r6;
        this.f9617k = Internal.immutableCopyOf(WsConstants.KEY_EXTRA, r7);
    }

    public a b() {
        a r0 = new a();
        r0.f9618a = this.f9612f;
        r0.f9619b = this.f9613g;
        r0.f9620c = this.f9614h;
        r0.f9621d = this.f9615i;
        r0.f9622e = this.f9616j;
        r0.f9623f = Internal.copyOf(this.f9617k);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L24;
        if (Internal.equals(this.f9612f, r6.f9612f) == false) goto L24;
        if (Internal.equals(this.f9613g, r6.f9613g) == false) goto L24;
        if (Internal.equals(this.f9614h, r6.f9614h) == false) goto L24;
        if (Internal.equals(this.f9615i, r6.f9615i) == false) goto L24;
        if (Internal.equals(this.f9616j, r6.f9616j) == false) goto L24;
        if (this.f9617k.equals(r6.f9617k) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f9612f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f9613g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f9614h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.f9615i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.f9616j;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = ((r14 + r3) * 37) + this.f9617k.hashCode();
        this.hashCode = r16;
        return r16;
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L25:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f9612f == null) goto L6;
        r0.append(", id=");
        r0.append(this.f9612f);
    L6:
        if (this.f9613g == null) goto L9;
        r0.append(", type=");
        r0.append(this.f9613g);
    L9:
        if (this.f9614h == null) goto L12;
        r0.append(", package_name=");
        r0.append(this.f9614h);
    L12:
        if (this.f9615i == null) goto L15;
        r0.append(", revoke_id=");
        r0.append(this.f9615i);
    L15:
        if (this.f9616j == null) goto L18;
        r0.append(", revoke_data=");
        r0.append(this.f9616j);
    L18:
        if (this.f9617k.isEmpty() == true) goto L20;
        r0.append(", extra=");
        r0.append(this.f9617k);
    L20:
        StringBuilder r3 = r0.replace(0, 2, "Revoke{");
        r3.append('}');
        return r3.toString();
    }
}
