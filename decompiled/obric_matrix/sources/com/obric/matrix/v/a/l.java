package com.obric.matrix.v.a;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends Message<l, a> {
    public static final ProtoAdapter<l> m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f10135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f10136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f10137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f10138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer f10139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String f10140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String f10141l;

    public static final class a extends Message.Builder<l, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f10145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f10146e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10148g;

        public a() {
        }

        public a a(Integer r1) {
            this.f10146e = r1;
            return this;
        }

        public l b() {
            return new l(this.f10142a, this.f10143b, this.f10144c, this.f10145d, this.f10146e, this.f10147f, this.f10148g, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(String r1) {
            this.f10144c = r1;
            return this;
        }

        public a d(String r1) {
            this.f10143b = r1;
            return this;
        }

        public a e(String r1) {
            this.f10147f = r1;
            return this;
        }

        public a f(String r1) {
            this.f10148g = r1;
            return this;
        }

        public a g(Long r1) {
            this.f10145d = r1;
            return this;
        }

        public a h(Integer r1) {
            this.f10142a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<l> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, l.class);
        }

        public l a(ProtoReader r5) {
            a r4 = new a();
            long r0 = r5.beginMessage();
        L3:
            int r2 = r5.nextTag();
            if (r2 == (-1)) goto L14;
            switch(r2) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r4.f(ProtoAdapter.STRING.decode(r5));
            goto L3
        L8:
            r4.e(ProtoAdapter.STRING.decode(r5));
            goto L3
        L9:
            r4.a(ProtoAdapter.INT32.decode(r5));
            goto L3
        L10:
            r4.g(ProtoAdapter.INT64.decode(r5));
            goto L3
        L11:
            r4.c(ProtoAdapter.STRING.decode(r5));
            goto L3
        L12:
            r4.d(ProtoAdapter.STRING.decode(r5));
            goto L3
        L13:
            r4.h(ProtoAdapter.INT32.decode(r5));
            goto L3
        L6:
            r5.readUnknownField(r2);
            goto L3
        L14:
            r4.addUnknownFields(r5.endMessageAndGetUnknownFields(r0));
            return r4.b();
        }

        public void b(ProtoWriter r5, l r6) {
            ProtoAdapter<Integer> r4 = ProtoAdapter.INT32;
            r4.encodeWithTag(r5, 1, r6.f10135f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 2, r6.f10136g);
            r0.encodeWithTag(r5, 3, r6.f10137h);
            ProtoAdapter.INT64.encodeWithTag(r5, 4, r6.f10138i);
            r4.encodeWithTag(r5, 5, r6.f10139j);
            r0.encodeWithTag(r5, 6, r6.f10140k);
            r0.encodeWithTag(r5, 7, r6.f10141l);
            r5.writeBytes(r6.unknownFields());
        }

        public int c(l r6) {
            ProtoAdapter<Integer> r5 = ProtoAdapter.INT32;
            int r0 = r5.encodedSizeWithTag(1, r6.f10135f);
            ProtoAdapter<String> r1 = ProtoAdapter.STRING;
            return ((((((r0 + r1.encodedSizeWithTag(2, r6.f10136g)) + r1.encodedSizeWithTag(3, r6.f10137h)) + ProtoAdapter.INT64.encodedSizeWithTag(4, r6.f10138i)) + r5.encodedSizeWithTag(5, r6.f10139j)) + r1.encodedSizeWithTag(6, r6.f10140k)) + r1.encodedSizeWithTag(7, r6.f10141l)) + r6.unknownFields().size();
        }

        public l d(l r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ l decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, l r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(l r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ l redact(l r1) {
            return d(r1);
        }
    }

    static {
        m = new b();
    }

    public l(Integer r2, String r3, String r4, Long r5, Integer r6, String r7, String r8, k.h r9) {
        super(m, r9);
        this.f10135f = r2;
        this.f10136g = r3;
        this.f10137h = r4;
        this.f10138i = r5;
        this.f10139j = r6;
        this.f10140k = r7;
        this.f10141l = r8;
    }

    public a b() {
        a r0 = new a();
        r0.f10142a = this.f10135f;
        r0.f10143b = this.f10136g;
        r0.f10144c = this.f10137h;
        r0.f10145d = this.f10138i;
        r0.f10146e = this.f10139j;
        r0.f10147f = this.f10140k;
        r0.f10148g = this.f10141l;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (Internal.equals(this.f10135f, r6.f10135f) == false) goto L26;
        if (Internal.equals(this.f10136g, r6.f10136g) == false) goto L26;
        if (Internal.equals(this.f10137h, r6.f10137h) == false) goto L26;
        if (Internal.equals(this.f10138i, r6.f10138i) == false) goto L26;
        if (Internal.equals(this.f10139j, r6.f10139j) == false) goto L26;
        if (Internal.equals(this.f10140k, r6.f10140k) == false) goto L26;
        if (Internal.equals(this.f10141l, r6.f10141l) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L33;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10135f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10136g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10137h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.f10138i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Integer r15 = this.f10139j;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.f10140k;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.f10141l;
        if (r21 == null) goto L31;
        r3 = r21.hashCode();
    L31:
        int r22 = r20 + r3;
        this.hashCode = r22;
        return r22;
    L27:
        r19 = 0;
        goto L28
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
    L33:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10135f == null) goto L6;
        r0.append(", version=");
        r0.append(this.f10135f);
    L6:
        if (this.f10136g == null) goto L9;
        r0.append(", env=");
        r0.append(this.f10136g);
    L9:
        if (this.f10137h == null) goto L12;
        r0.append(", did=");
        r0.append(this.f10137h);
    L12:
        if (this.f10138i == null) goto L15;
        r0.append(", session_id=");
        r0.append(this.f10138i);
    L15:
        if (this.f10139j == null) goto L18;
        r0.append(", app_id=");
        r0.append(this.f10139j);
    L18:
        if (this.f10140k == null) goto L21;
        r0.append(", msg_id=");
        r0.append(this.f10140k);
    L21:
        if (this.f10141l == null) goto L23;
        r0.append(", receipt_id=");
        r0.append(this.f10141l);
    L23:
        StringBuilder r3 = r0.replace(0, 2, "ReceiptAck{");
        r3.append('}');
        return r3.toString();
    }
}
