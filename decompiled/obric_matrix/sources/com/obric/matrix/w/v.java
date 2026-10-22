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
public final class v extends Message<v, a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ProtoAdapter<v> f10551j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    @com.google.gson.y.c("isSucceed")
    public final Boolean f10552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("body")
    public final String f10553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @com.google.gson.y.c("serverLogId")
    public final String f10554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @com.google.gson.y.c("extraMap")
    public final Map<String, String> f10555i;

    public static final class a extends Message.Builder<v, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f10556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f10559d;

        public a() {
            this.f10556a = Boolean.FALSE;
            this.f10557b = "";
            this.f10558c = "";
            this.f10559d = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f10557b = r1;
            return this;
        }

        public v b() {
            return new v(this.f10556a, this.f10557b, this.f10558c, this.f10559d, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(Boolean r1) {
            this.f10556a = r1;
            return this;
        }

        public a d(String r1) {
            this.f10558c = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<v> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10560a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, v.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10560a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public v a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.c(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.a(ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.d(ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.f10559d.putAll(this.f10560a.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.b();
        }

        public void b(ProtoWriter r4, v r5) {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.f10552f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 2, r5.f10553g);
            r0.encodeWithTag(r4, 3, r5.f10554h);
            this.f10560a.encodeWithTag(r4, 4, r5.f10555i);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(v r5) {
            int r0 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.f10552f);
            ProtoAdapter<String> r1 = ProtoAdapter.STRING;
            return (((r0 + r1.encodedSizeWithTag(2, r5.f10553g)) + r1.encodedSizeWithTag(3, r5.f10554h)) + this.f10560a.encodedSizeWithTag(4, r5.f10555i)) + r5.unknownFields().size();
        }

        public v d(v r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ v decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, v r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(v r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ v redact(v r1) {
            return d(r1);
        }
    }

    static {
        f10551j = new b();
    }

    public v(Boolean r2, String r3, String r4, Map<String, String> r5, k.h r6) {
        super(f10551j, r6);
        this.f10552f = r2;
        this.f10553g = r3;
        this.f10554h = r4;
        this.f10555i = Internal.immutableCopyOf("extraMap", r5);
    }

    public a b() {
        a r0 = new a();
        r0.f10556a = this.f10552f;
        r0.f10557b = this.f10553g;
        r0.f10558c = this.f10554h;
        r0.f10559d = Internal.copyOf("extraMap", this.f10555i);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f10552f, r6.f10552f) == false) goto L20;
        if (Internal.equals(this.f10553g, r6.f10553g) == false) goto L20;
        if (Internal.equals(this.f10554h, r6.f10554h) == false) goto L20;
        if (this.f10555i.equals(r6.f10555i) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.f10552f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10553g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10554h;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((r8 + r3) * 37) + this.f10555i.hashCode();
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
        if (this.f10552f == null) goto L6;
        r0.append(", isSucceed=");
        r0.append(this.f10552f);
    L6:
        if (this.f10553g == null) goto L9;
        r0.append(", body=");
        r0.append(this.f10553g);
    L9:
        if (this.f10554h == null) goto L11;
        r0.append(", serverLogId=");
        r0.append(this.f10554h);
    L11:
        Map<String, String> r1 = this.f10555i;
        if (r1 != null) goto L14;
    L16:
        StringBuilder r3 = r0.replace(0, 2, "OnePartyCommonNetworkResponse{");
        r3.append('}');
        return r3.toString();
    L14:
        if (r1.isEmpty() == true) goto L16;
        r0.append(", extraMap=");
        r0.append(this.f10555i);
        goto L16
    }
}
