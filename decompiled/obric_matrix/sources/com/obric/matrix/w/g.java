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
public final class g extends Message<g, a> {
    public static final ProtoAdapter<g> m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    @com.google.gson.y.c("path")
    public final String f10324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 2)
    @com.google.gson.y.c("method")
    public final s f10325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @com.google.gson.y.c("headerParams")
    public final Map<String, String> f10326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @com.google.gson.y.c("queryParams")
    public final Map<String, String> f10327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    @com.google.gson.y.c("body")
    public final k.h f10328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    @com.google.gson.y.c("needAccessToken")
    public final Boolean f10329k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @com.google.gson.y.c("accessToken")
    public final String f10330l;

    public static final class a extends Message.Builder<g, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s f10332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f10333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f10334d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public k.h f10335e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f10336f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10337g;

        public a() {
            this.f10331a = "";
            this.f10332b = s.f10501g;
            this.f10335e = k.h.f18266i;
            this.f10336f = Boolean.FALSE;
            this.f10337g = "";
            this.f10333c = Internal.newMutableMap();
            this.f10334d = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f10337g = r1;
            return this;
        }

        public a b(k.h r1) {
            this.f10335e = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public g c() {
            String r0 = this.f10331a;
            if (r0 == null) goto L9;
            if (this.f10332b == null) goto L9;
            return new g(this.f10331a, this.f10332b, this.f10333c, this.f10334d, this.f10335e, this.f10336f, this.f10337g, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "path", this.f10332b, "method"});
        }

        public a d(s r1) {
            this.f10332b = r1;
            return this;
        }

        public a e(Boolean r1) {
            this.f10336f = r1;
            return this;
        }

        public a f(String r1) {
            this.f10331a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10339b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, g.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10338a = ProtoAdapter.newMapAdapter(r0, r0);
            this.f10339b = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public g a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            switch(r3) {
                case 1: goto L17;
                case 2: goto L20;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L20:
            r0.d(s.f10503i.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.a(ProtoAdapter.STRING.decode(r9));
            goto L3
        L8:
            r0.e(ProtoAdapter.BOOL.decode(r9));
            goto L3
        L9:
            r0.b(ProtoAdapter.BYTES.decode(r9));
            goto L3
        L10:
            Map<String, String> r4 = r0.f10334d;
            ProtoAdapter<Map<String, String>> r5 = this.f10339b;
        L12:
            r4.putAll(r5.decode(r9));
            goto L3
        L11:
            r4 = r0.f10333c;
            r5 = this.f10338a;
            goto L12
        L17:
            r0.f(ProtoAdapter.STRING.decode(r9));
            goto L3
        L6:
            FieldEncoding r6 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r6, r6.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.c();
        }

        public void b(ProtoWriter r5, g r6) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.f10324f);
            s.f10503i.encodeWithTag(r5, 2, r6.f10325g);
            this.f10338a.encodeWithTag(r5, 3, r6.f10326h);
            this.f10339b.encodeWithTag(r5, 4, r6.f10327i);
            ProtoAdapter.BYTES.encodeWithTag(r5, 5, r6.f10328j);
            ProtoAdapter.BOOL.encodeWithTag(r5, 6, r6.f10329k);
            r0.encodeWithTag(r5, 7, r6.f10330l);
            r5.writeBytes(r6.unknownFields());
        }

        public int c(g r6) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            return ((((((r0.encodedSizeWithTag(1, r6.f10324f) + s.f10503i.encodedSizeWithTag(2, r6.f10325g)) + this.f10338a.encodedSizeWithTag(3, r6.f10326h)) + this.f10339b.encodedSizeWithTag(4, r6.f10327i)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r6.f10328j)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r6.f10329k)) + r0.encodedSizeWithTag(7, r6.f10330l)) + r6.unknownFields().size();
        }

        public g d(g r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.c();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ g decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, g r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(g r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ g redact(g r1) {
            return d(r1);
        }
    }

    static {
        m = new b();
        s r0 = s.f10501g;
        k.h r1 = k.h.f18266i;
    }

    public g(String r2, s r3, Map<String, String> r4, Map<String, String> r5, k.h r6, Boolean r7, String r8, k.h r9) {
        super(m, r9);
        this.f10324f = r2;
        this.f10325g = r3;
        this.f10326h = Internal.immutableCopyOf("headerParams", r4);
        this.f10327i = Internal.immutableCopyOf("queryParams", r5);
        this.f10328j = r6;
        this.f10329k = r7;
        this.f10330l = r8;
    }

    public a b() {
        a r0 = new a();
        r0.f10331a = this.f10324f;
        r0.f10332b = this.f10325g;
        r0.f10333c = Internal.copyOf("headerParams", this.f10326h);
        r0.f10334d = Internal.copyOf("queryParams", this.f10327i);
        r0.f10335e = this.f10328j;
        r0.f10336f = this.f10329k;
        r0.f10337g = this.f10330l;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (this.f10324f.equals(r6.f10324f) == false) goto L26;
        if (this.f10325g.equals(r6.f10325g) == false) goto L26;
        if (this.f10326h.equals(r6.f10326h) == false) goto L26;
        if (this.f10327i.equals(r6.f10327i) == false) goto L26;
        if (Internal.equals(this.f10328j, r6.f10328j) == false) goto L26;
        if (Internal.equals(this.f10329k, r6.f10329k) == false) goto L26;
        if (Internal.equals(this.f10330l, r6.f10330l) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = ((((((((unknownFields().hashCode() * 37) + this.f10324f.hashCode()) * 37) + this.f10325g.hashCode()) * 37) + this.f10326h.hashCode()) * 37) + this.f10327i.hashCode()) * 37;
        k.h r2 = this.f10328j;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Boolean r6 = this.f10329k;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10330l;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(", path=");
        r0.append(this.f10324f);
        r0.append(", method=");
        r0.append(this.f10325g);
        Map<String, String> r1 = this.f10326h;
        if (r1 != null) goto L5;
    L7:
        Map<String, String> r2 = this.f10327i;
        if (r2 == null) goto L13;
        if (r2.isEmpty() == true) goto L13;
        r0.append(", queryParams=");
        r0.append(this.f10327i);
    L13:
        if (this.f10328j == null) goto L16;
        r0.append(", body=");
        r0.append(this.f10328j);
    L16:
        if (this.f10329k == null) goto L19;
        r0.append(", needAccessToken=");
        r0.append(this.f10329k);
    L19:
        if (this.f10330l == null) goto L21;
        r0.append(", accessToken=");
        r0.append(this.f10330l);
    L21:
        StringBuilder r3 = r0.replace(0, 2, "GenericNetworkRequest{");
        r3.append('}');
        return r3.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", headerParams=");
        r0.append(this.f10326h);
        goto L7
    }
}
