package com.obric.matrix.w;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 extends Message<m0, a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ProtoAdapter<m0> f10410i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest$SCENE#ADAPTER", tag = 1)
    @com.google.gson.y.c("scene")
    public final c f10411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("referrer")
    public final String f10412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @com.google.gson.y.c("targetUrl")
    public final String f10413h;

    public static final class a extends Message.Builder<m0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f10414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10416c;

        public a() {
            this.f10414a = c.f10417g;
            this.f10415b = "";
            this.f10416c = "";
        }

        public m0 a() {
            return new m0(this.f10414a, this.f10415b, this.f10416c, super.buildUnknownFields());
        }

        public a b(String r1) {
            this.f10415b = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(c r1) {
            this.f10414a = r1;
            return this;
        }

        public a d(String r1) {
            this.f10416c = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<m0> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, m0.class);
        }

        public m0 a(ProtoReader r8) {
            a r7 = new a();
            long r0 = r8.beginMessage();
        L3:
            int r2 = r8.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r7.c(c.f10421k.decode(r8));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r7.addUnknownField(r2, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r7.b(ProtoAdapter.STRING.decode(r8));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r7.d(ProtoAdapter.STRING.decode(r8));
            goto L3
        L11:
            FieldEncoding r3 = r8.peekFieldEncoding();
            r7.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r8));
            goto L3
        L18:
            r8.endMessage(r0);
            return r7.a();
        }

        public void b(ProtoWriter r3, m0 r4) {
            c.f10421k.encodeWithTag(r3, 1, r4.f10411f);
            ProtoAdapter<String> r2 = ProtoAdapter.STRING;
            r2.encodeWithTag(r3, 2, r4.f10412g);
            r2.encodeWithTag(r3, 3, r4.f10413h);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(m0 r4) {
            int r3 = c.f10421k.encodedSizeWithTag(1, r4.f10411f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            return ((r3 + r0.encodedSizeWithTag(2, r4.f10412g)) + r0.encodedSizeWithTag(3, r4.f10413h)) + r4.unknownFields().size();
        }

        public m0 d(m0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ m0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, m0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(m0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ m0 redact(m0 r1) {
            return d(r1);
        }
    }

    public static final enum c extends Enum<c> implements WireEnum {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f10417g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f10418h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f10419i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final c f10420j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final ProtoAdapter<c> f10421k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final /* synthetic */ c[] f10422l = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f10423f;

        private static final class a extends EnumAdapter<c> {
            a() {
                super(c.class);
            }

            protected c a(int r1) {
                return c.a(r1);
            }

            @Override // com.squareup.wire.EnumAdapter
            protected /* bridge */ /* synthetic */ WireEnum fromValue(int r1) {
                return a(r1);
            }
        }

        static {
            c r0 = new c("BROWSER", 0, 0);
            f10417g = r0;
            c r1 = new c("WEB_VIEW", 1, 1);
            f10418h = r1;
            c r3 = new c("NATIVE_APP", 2, 2);
            f10419i = r3;
            c r5 = new c("SYSTEM", 3, 3);
            f10420j = r5;
            f10422l = new c[]{r0, r1, r3, r5};
            f10421k = new a();
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.f10423f = r3;
        }

        public static c a(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return f10420j;
        L14:
            return f10419i;
        L16:
            return f10418h;
        L18:
            return f10417g;
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f10422l.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.f10423f;
        }
    }

    static {
        f10410i = new b();
        c r0 = c.f10417g;
    }

    public m0(c r2, String r3, String r4, k.h r5) {
        super(f10410i, r5);
        this.f10411f = r2;
        this.f10412g = r3;
        this.f10413h = r4;
    }

    public a b() {
        a r0 = new a();
        r0.f10414a = this.f10411f;
        r0.f10415b = this.f10412g;
        r0.f10416c = this.f10413h;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r6 = (m0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (Internal.equals(this.f10411f, r6.f10411f) == false) goto L18;
        if (Internal.equals(this.f10412g, r6.f10412g) == false) goto L18;
        if (Internal.equals(this.f10413h, r6.f10413h) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        c r2 = this.f10411f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10412g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10413h;
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
        if (this.f10411f == null) goto L6;
        r0.append(", scene=");
        r0.append(this.f10411f);
    L6:
        if (this.f10412g == null) goto L9;
        r0.append(", referrer=");
        r0.append(this.f10412g);
    L9:
        if (this.f10413h == null) goto L11;
        r0.append(", targetUrl=");
        r0.append(this.f10413h);
    L11:
        StringBuilder r3 = r0.replace(0, 2, "StartPicoLinksRequest{");
        r3.append('}');
        return r3.toString();
    }
}
