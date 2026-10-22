package com.obric.matrix.v.a;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends Message<m, a> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ProtoAdapter<m> f10149l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f10150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f10151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f10152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f10153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String f10154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.o.push.Receipt#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<k> f10155k;

    public static final class a extends Message.Builder<m, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f10159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<k> f10161f;

        public a() {
            this.f10161f = Internal.newMutableList();
        }

        public m a() {
            return new m(this.f10156a, this.f10157b, this.f10158c, this.f10159d, this.f10160e, this.f10161f, super.buildUnknownFields());
        }

        public a b(String r1) {
            this.f10158c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.f10157b = r1;
            return this;
        }

        public a d(List<k> r1) {
            Internal.checkElementsNotNull(r1);
            this.f10161f = r1;
            return this;
        }

        public a e(String r1) {
            this.f10160e = r1;
            return this;
        }

        public a f(Long r1) {
            this.f10159d = r1;
            return this;
        }

        public a g(Integer r1) {
            this.f10156a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<m> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, m.class);
        }

        public m a(ProtoReader r5) {
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
            r4.f10161f.add(k.v.decode(r5));
            goto L3
        L8:
            r4.e(ProtoAdapter.STRING.decode(r5));
            goto L3
        L9:
            r4.f(ProtoAdapter.INT64.decode(r5));
            goto L3
        L10:
            r4.b(ProtoAdapter.STRING.decode(r5));
            goto L3
        L11:
            r4.c(ProtoAdapter.STRING.decode(r5));
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

        public void b(ProtoWriter r4, m r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.f10150f);
            ProtoAdapter<String> r3 = ProtoAdapter.STRING;
            r3.encodeWithTag(r4, 2, r5.f10151g);
            r3.encodeWithTag(r4, 3, r5.f10152h);
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r5.f10153i);
            r3.encodeWithTag(r4, 5, r5.f10154j);
            k.v.asRepeated().encodeWithTag(r4, 6, r5.f10155k);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(m r5) {
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(1, r5.f10150f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            return (((((r4 + r0.encodedSizeWithTag(2, r5.f10151g)) + r0.encodedSizeWithTag(3, r5.f10152h)) + ProtoAdapter.INT64.encodedSizeWithTag(4, r5.f10153i)) + r0.encodedSizeWithTag(5, r5.f10154j)) + k.v.asRepeated().encodedSizeWithTag(6, r5.f10155k)) + r5.unknownFields().size();
        }

        public m d(m r2) {
            a r1 = r2.b();
            Internal.redactElements(r1.f10161f, k.v);
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ m decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, m r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(m r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ m redact(m r1) {
            return d(r1);
        }
    }

    static {
        f10149l = new b();
    }

    public m(Integer r2, String r3, String r4, Long r5, String r6, List<k> r7, k.h r8) {
        super(f10149l, r8);
        this.f10150f = r2;
        this.f10151g = r3;
        this.f10152h = r4;
        this.f10153i = r5;
        this.f10154j = r6;
        this.f10155k = Internal.immutableCopyOf("receipt_list", r7);
    }

    public a b() {
        a r0 = new a();
        r0.f10156a = this.f10150f;
        r0.f10157b = this.f10151g;
        r0.f10158c = this.f10152h;
        r0.f10159d = this.f10153i;
        r0.f10160e = this.f10154j;
        r0.f10161f = Internal.copyOf(this.f10155k);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L24;
        if (Internal.equals(this.f10150f, r6.f10150f) == false) goto L24;
        if (Internal.equals(this.f10151g, r6.f10151g) == false) goto L24;
        if (Internal.equals(this.f10152h, r6.f10152h) == false) goto L24;
        if (Internal.equals(this.f10153i, r6.f10153i) == false) goto L24;
        if (Internal.equals(this.f10154j, r6.f10154j) == false) goto L24;
        if (this.f10155k.equals(r6.f10155k) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10150f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10151g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10152h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.f10153i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.f10154j;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = ((r14 + r3) * 37) + this.f10155k.hashCode();
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
        if (this.f10150f == null) goto L6;
        r0.append(", version=");
        r0.append(this.f10150f);
    L6:
        if (this.f10151g == null) goto L9;
        r0.append(", env=");
        r0.append(this.f10151g);
    L9:
        if (this.f10152h == null) goto L12;
        r0.append(", did=");
        r0.append(this.f10152h);
    L12:
        if (this.f10153i == null) goto L15;
        r0.append(", session_id=");
        r0.append(this.f10153i);
    L15:
        if (this.f10154j == null) goto L18;
        r0.append(", receipt_list_id=");
        r0.append(this.f10154j);
    L18:
        if (this.f10155k.isEmpty() == true) goto L20;
        r0.append(", receipt_list=");
        r0.append(this.f10155k);
    L20:
        StringBuilder r3 = r0.replace(0, 2, "ReceiptList{");
        r3.append('}');
        return r3.toString();
    }
}
