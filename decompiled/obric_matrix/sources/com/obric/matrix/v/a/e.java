package com.obric.matrix.v.a;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Message<e, a> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ProtoAdapter<e> f10062l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f10063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f10064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f10065h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f10066i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long f10067j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String f10068k;

    public static final class a extends Message.Builder<e, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10071c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f10072d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f10073e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10074f;

        public a() {
        }

        public e a() {
            return new e(this.f10069a, this.f10070b, this.f10071c, this.f10072d, this.f10073e, this.f10074f, super.buildUnknownFields());
        }

        public a b(String r1) {
            this.f10074f = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.f10071c = r1;
            return this;
        }

        public a d(String r1) {
            this.f10070b = r1;
            return this;
        }

        public a e(Long r1) {
            this.f10073e = r1;
            return this;
        }

        public a f(Long r1) {
            this.f10072d = r1;
            return this;
        }

        public a g(Integer r1) {
            this.f10069a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<e> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, e.class);
        }

        public e a(ProtoReader r5) {
            a r4 = new a();
            long r0 = r5.beginMessage();
        L3:
            int r2 = r5.nextTag();
            if (r2 == (-1)) goto L13;
            switch(r2) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r4.b(ProtoAdapter.STRING.decode(r5));
            goto L3
        L8:
            r4.e(ProtoAdapter.INT64.decode(r5));
            goto L3
        L9:
            r4.f(ProtoAdapter.INT64.decode(r5));
            goto L3
        L10:
            r4.c(ProtoAdapter.STRING.decode(r5));
            goto L3
        L11:
            r4.d(ProtoAdapter.STRING.decode(r5));
            goto L3
        L12:
            r4.g(ProtoAdapter.INT32.decode(r5));
            goto L3
        L6:
            r5.readUnknownField(r2);
            goto L3
        L13:
            r4.addUnknownFields(r5.endMessageAndGetUnknownFields(r0));
            return r4.a();
        }

        public void b(ProtoWriter r4, e r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.f10063f);
            ProtoAdapter<String> r3 = ProtoAdapter.STRING;
            r3.encodeWithTag(r4, 2, r5.f10064g);
            r3.encodeWithTag(r4, 3, r5.f10065h);
            ProtoAdapter<Long> r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r4, 4, r5.f10066i);
            r0.encodeWithTag(r4, 5, r5.f10067j);
            r3.encodeWithTag(r4, 6, r5.f10068k);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(e r5) {
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(1, r5.f10063f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            int r6 = (r4 + r0.encodedSizeWithTag(2, r5.f10064g)) + r0.encodedSizeWithTag(3, r5.f10065h);
            ProtoAdapter<Long> r1 = ProtoAdapter.INT64;
            return (((r6 + r1.encodedSizeWithTag(4, r5.f10066i)) + r1.encodedSizeWithTag(5, r5.f10067j)) + r0.encodedSizeWithTag(6, r5.f10068k)) + r5.unknownFields().size();
        }

        public e d(e r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ e decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, e r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(e r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ e redact(e r1) {
            return d(r1);
        }
    }

    static {
        f10062l = new b();
    }

    public e(Integer r2, String r3, String r4, Long r5, Long r6, String r7, k.h r8) {
        super(f10062l, r8);
        this.f10063f = r2;
        this.f10064g = r3;
        this.f10065h = r4;
        this.f10066i = r5;
        this.f10067j = r6;
        this.f10068k = r7;
    }

    public a b() {
        a r0 = new a();
        r0.f10069a = this.f10063f;
        r0.f10070b = this.f10064g;
        r0.f10071c = this.f10065h;
        r0.f10072d = this.f10066i;
        r0.f10073e = this.f10067j;
        r0.f10074f = this.f10068k;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L24;
        if (Internal.equals(this.f10063f, r6.f10063f) == false) goto L24;
        if (Internal.equals(this.f10064g, r6.f10064g) == false) goto L24;
        if (Internal.equals(this.f10065h, r6.f10065h) == false) goto L24;
        if (Internal.equals(this.f10066i, r6.f10066i) == false) goto L24;
        if (Internal.equals(this.f10067j, r6.f10067j) == false) goto L24;
        if (Internal.equals(this.f10068k, r6.f10068k) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L29;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10063f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10064g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10065h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.f10066i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Long r15 = this.f10067j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f10068k;
        if (r18 == null) goto L27;
        r3 = r18.hashCode();
    L27:
        int r19 = r17 + r3;
        this.hashCode = r19;
        return r19;
    L23:
        r16 = 0;
        goto L24
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
    L29:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10063f == null) goto L6;
        r0.append(", version=");
        r0.append(this.f10063f);
    L6:
        if (this.f10064g == null) goto L9;
        r0.append(", env=");
        r0.append(this.f10064g);
    L9:
        if (this.f10065h == null) goto L12;
        r0.append(", did=");
        r0.append(this.f10065h);
    L12:
        if (this.f10066i == null) goto L15;
        r0.append(", session_id=");
        r0.append(this.f10066i);
    L15:
        if (this.f10067j == null) goto L18;
        r0.append(", heartbeat_count=");
        r0.append(this.f10067j);
    L18:
        if (this.f10068k == null) goto L20;
        r0.append(", client_version=");
        r0.append(this.f10068k);
    L20:
        StringBuilder r3 = r0.replace(0, 2, "HeartbeatPing{");
        r3.append('}');
        return r3.toString();
    }
}
