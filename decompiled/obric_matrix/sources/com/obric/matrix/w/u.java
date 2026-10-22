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
public final class u extends Message<u, a> {
    public static final ProtoAdapter<u> o = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @com.google.gson.y.c("path")
    public final String f10522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("host")
    public final String f10523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    @com.google.gson.y.c("method")
    public final s f10524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @com.google.gson.y.c("headerParams")
    public final Map<String, String> f10525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @com.google.gson.y.c("queryParams")
    public final Map<String, String> f10526j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 6)
    @com.google.gson.y.c("body")
    public final k.h f10527k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @com.google.gson.y.c("fieldMap")
    public final Map<String, String> f10528l;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    @com.google.gson.y.c("addCommonParam")
    public final Boolean m;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @com.google.gson.y.c("extraMap")
    public final Map<String, String> n;

    public static final class a extends Message.Builder<u, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s f10531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f10532d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f10533e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public k.h f10534f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map<String, String> f10535g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f10536h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map<String, String> f10537i;

        public a() {
            this.f10529a = "";
            this.f10530b = "";
            this.f10531c = s.f10501g;
            this.f10534f = k.h.f18266i;
            this.f10536h = Boolean.FALSE;
            this.f10532d = Internal.newMutableMap();
            this.f10533e = Internal.newMutableMap();
            this.f10535g = Internal.newMutableMap();
            this.f10537i = Internal.newMutableMap();
        }

        public a a(Boolean r1) {
            this.f10536h = r1;
            return this;
        }

        public a b(k.h r1) {
            this.f10534f = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public u c() {
            s r0 = this.f10531c;
            if (r0 == null) goto L7;
            return new u(this.f10529a, this.f10530b, this.f10531c, this.f10532d, this.f10533e, this.f10534f, this.f10535g, this.f10536h, this.f10537i, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "method"});
        }

        public a d(String r1) {
            this.f10530b = r1;
            return this;
        }

        public a e(s r1) {
            this.f10531c = r1;
            return this;
        }

        public a f(String r1) {
            this.f10529a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10540c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10541d;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, u.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10538a = ProtoAdapter.newMapAdapter(r0, r0);
            this.f10539b = ProtoAdapter.newMapAdapter(r0, r0);
            this.f10540c = ProtoAdapter.newMapAdapter(r0, r0);
            this.f10541d = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public u a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L22;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L22:
            r0.e(s.f10503i.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            Map<String, String> r4 = r0.f10537i;
            ProtoAdapter<Map<String, String>> r5 = this.f10541d;
        L13:
            r4.putAll(r5.decode(r9));
            goto L3
        L8:
            r0.a(ProtoAdapter.BOOL.decode(r9));
            goto L3
        L9:
            r4 = r0.f10535g;
            r5 = this.f10540c;
            goto L13
        L10:
            r0.b(ProtoAdapter.BYTES.decode(r9));
            goto L3
        L11:
            r4 = r0.f10533e;
            r5 = this.f10539b;
            goto L13
        L12:
            r4 = r0.f10532d;
            r5 = this.f10538a;
            goto L13
        L18:
            r0.d(ProtoAdapter.STRING.decode(r9));
            goto L3
        L19:
            r0.f(ProtoAdapter.STRING.decode(r9));
            goto L3
        L6:
            FieldEncoding r6 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r6, r6.rawProtoAdapter().decode(r9));
            goto L3
        L20:
            r9.endMessage(r1);
            return r0.c();
        }

        public void b(ProtoWriter r4, u r5) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.f10522f);
            r0.encodeWithTag(r4, 2, r5.f10523g);
            s.f10503i.encodeWithTag(r4, 3, r5.f10524h);
            this.f10538a.encodeWithTag(r4, 4, r5.f10525i);
            this.f10539b.encodeWithTag(r4, 5, r5.f10526j);
            ProtoAdapter.BYTES.encodeWithTag(r4, 6, r5.f10527k);
            this.f10540c.encodeWithTag(r4, 7, r5.f10528l);
            ProtoAdapter.BOOL.encodeWithTag(r4, 8, r5.m);
            this.f10541d.encodeWithTag(r4, 9, r5.n);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(u r5) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            return ((((((((r0.encodedSizeWithTag(1, r5.f10522f) + r0.encodedSizeWithTag(2, r5.f10523g)) + s.f10503i.encodedSizeWithTag(3, r5.f10524h)) + this.f10538a.encodedSizeWithTag(4, r5.f10525i)) + this.f10539b.encodedSizeWithTag(5, r5.f10526j)) + ProtoAdapter.BYTES.encodedSizeWithTag(6, r5.f10527k)) + this.f10540c.encodedSizeWithTag(7, r5.f10528l)) + ProtoAdapter.BOOL.encodedSizeWithTag(8, r5.m)) + this.f10541d.encodedSizeWithTag(9, r5.n)) + r5.unknownFields().size();
        }

        public u d(u r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.c();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ u decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, u r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(u r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ u redact(u r1) {
            return d(r1);
        }
    }

    static {
        o = new b();
        s r0 = s.f10501g;
        k.h r1 = k.h.f18266i;
    }

    public u(String r2, String r3, s r4, Map<String, String> r5, Map<String, String> r6, k.h r7, Map<String, String> r8, Boolean r9, Map<String, String> r10, k.h r11) {
        super(o, r11);
        this.f10522f = r2;
        this.f10523g = r3;
        this.f10524h = r4;
        this.f10525i = Internal.immutableCopyOf("headerParams", r5);
        this.f10526j = Internal.immutableCopyOf("queryParams", r6);
        this.f10527k = r7;
        this.f10528l = Internal.immutableCopyOf("fieldMap", r8);
        this.m = r9;
        this.n = Internal.immutableCopyOf("extraMap", r10);
    }

    public a b() {
        a r0 = new a();
        r0.f10529a = this.f10522f;
        r0.f10530b = this.f10523g;
        r0.f10531c = this.f10524h;
        r0.f10532d = Internal.copyOf("headerParams", this.f10525i);
        r0.f10533e = Internal.copyOf("queryParams", this.f10526j);
        r0.f10534f = this.f10527k;
        r0.f10535g = Internal.copyOf("fieldMap", this.f10528l);
        r0.f10536h = this.m;
        r0.f10537i = Internal.copyOf("extraMap", this.n);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.f10522f, r6.f10522f) == false) goto L30;
        if (Internal.equals(this.f10523g, r6.f10523g) == false) goto L30;
        if (this.f10524h.equals(r6.f10524h) == false) goto L30;
        if (this.f10525i.equals(r6.f10525i) == false) goto L30;
        if (this.f10526j.equals(r6.f10526j) == false) goto L30;
        if (Internal.equals(this.f10527k, r6.f10527k) == false) goto L30;
        if (this.f10528l.equals(r6.f10528l) == false) goto L30;
        if (Internal.equals(this.m, r6.m) == false) goto L30;
        if (this.n.equals(r6.n) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f10522f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10523g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (((((((r5 + r7) * 37) + this.f10524h.hashCode()) * 37) + this.f10525i.hashCode()) * 37) + this.f10526j.hashCode()) * 37;
        k.h r9 = this.f10527k;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (((r8 + r10) * 37) + this.f10528l.hashCode()) * 37;
        Boolean r12 = this.m;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = ((r11 + r3) * 37) + this.n.hashCode();
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
        if (this.f10522f == null) goto L6;
        r0.append(", path=");
        r0.append(this.f10522f);
    L6:
        if (this.f10523g == null) goto L8;
        r0.append(", host=");
        r0.append(this.f10523g);
    L8:
        r0.append(", method=");
        r0.append(this.f10524h);
        Map<String, String> r1 = this.f10525i;
        if (r1 != null) goto L11;
    L13:
        Map<String, String> r2 = this.f10526j;
        if (r2 == null) goto L19;
        if (r2.isEmpty() == true) goto L19;
        r0.append(", queryParams=");
        r0.append(this.f10526j);
    L19:
        if (this.f10527k == null) goto L21;
        r0.append(", body=");
        r0.append(this.f10527k);
    L21:
        Map<String, String> r3 = this.f10528l;
        if (r3 == null) goto L27;
        if (r3.isEmpty() == true) goto L27;
        r0.append(", fieldMap=");
        r0.append(this.f10528l);
    L27:
        if (this.m == null) goto L29;
        r0.append(", addCommonParam=");
        r0.append(this.m);
    L29:
        Map<String, String> r4 = this.n;
        if (r4 != null) goto L32;
    L34:
        StringBuilder r5 = r0.replace(0, 2, "OnePartyCommonNetworkRequest{");
        r5.append('}');
        return r5.toString();
    L32:
        if (r4.isEmpty() == true) goto L34;
        r0.append(", extraMap=");
        r0.append(this.n);
        goto L34
    L11:
        if (r1.isEmpty() == true) goto L13;
        r0.append(", headerParams=");
        r0.append(this.f10525i);
        goto L13
    }
}
