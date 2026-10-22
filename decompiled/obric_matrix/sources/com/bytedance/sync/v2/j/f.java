package com.bytedance.sync.v2.j;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f extends Message<f, a> {
    public static final ProtoAdapter<f> p = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.Flag#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final j f6074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.Bucket#ADAPTER", tag = 2)
    public final g f6075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.TopicType#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    public final p f6076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f6077i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long f6078j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 6)
    public final Long f6079k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.BsyncPacket#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<c> f6080l;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.TopicStatus#ADAPTER", tag = 8)
    public final o m;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 9)
    public final Long n;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 255)
    public final String o;

    public static final class a extends Message.Builder<f, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f6081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f6082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f6083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f6084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f6085e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f6086f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<c> f6087g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public o f6088h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Long f6089i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f6090j;

        public a() {
            this.f6087g = Internal.newMutableList();
        }

        public a a(g r1) {
            this.f6082b = r1;
            return this;
        }

        public f b() {
            j r0 = this.f6081a;
            if (r0 == null) goto L9;
            if (this.f6083c == null) goto L9;
            return new f(this.f6081a, this.f6082b, this.f6083c, this.f6084d, this.f6085e, this.f6086f, this.f6087g, this.f6088h, this.f6089i, this.f6090j, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "flag", this.f6083c, "topic_type"});
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(Long r1) {
            this.f6089i = r1;
            return this;
        }

        public a d(j r1) {
            this.f6081a = r1;
            return this;
        }

        public a e(Long r1) {
            this.f6086f = r1;
            return this;
        }

        public a f(List<c> r1) {
            Internal.checkElementsNotNull(r1);
            this.f6087g = r1;
            return this;
        }

        public a g(Long r1) {
            this.f6085e = r1;
            return this;
        }

        public a h(String r1) {
            this.f6090j = r1;
            return this;
        }

        public a i(Long r1) {
            this.f6084d = r1;
            return this;
        }

        public a j(o r1) {
            this.f6088h = r1;
            return this;
        }

        public a k(p r1) {
            this.f6083c = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<f> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, f.class);
        }

        public f a(ProtoReader r8) {
            a r7 = new a();
            long r0 = r8.beginMessage();
        L3:
            int r2 = r8.nextTag();
            if (r2 == (-1)) goto L23;
            if (r2 != 255) goto L7;
            r7.h(ProtoAdapter.STRING.decode(r8));
            goto L3
        L7:
            switch(r2) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L25;
                case 9: goto L9;
                default: goto L8;
            };
        L25:
            r7.j(o.f6131j.decode(r8));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r7.addUnknownField(r2, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            r7.c(ProtoAdapter.INT64.decode(r8));
            goto L3
        L12:
            r7.f6087g.add(c.f6048k.decode(r8));
            goto L3
        L13:
            r7.e(ProtoAdapter.INT64.decode(r8));
            goto L3
        L14:
            r7.g(ProtoAdapter.INT64.decode(r8));
            goto L3
        L15:
            r7.i(ProtoAdapter.INT64.decode(r8));
            goto L3
        L16:
            r7.k(p.f6137j.decode(r8));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            goto L3
        L17:
            r7.a(g.f6093i.decode(r8));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            goto L3
        L18:
            r7.d(j.m.decode(r8));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            goto L3
        L8:
            FieldEncoding r3 = r8.peekFieldEncoding();
            r7.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r8));
            goto L3
        L23:
            r8.endMessage(r0);
            return r7.b();
        }

        public void b(ProtoWriter r4, f r5) {
            j.m.encodeWithTag(r4, 1, r5.f6074f);
            g.f6093i.encodeWithTag(r4, 2, r5.f6075g);
            p.f6137j.encodeWithTag(r4, 3, r5.f6076h);
            ProtoAdapter<Long> r3 = ProtoAdapter.INT64;
            r3.encodeWithTag(r4, 4, r5.f6077i);
            r3.encodeWithTag(r4, 5, r5.f6078j);
            r3.encodeWithTag(r4, 6, r5.f6079k);
            c.f6048k.asRepeated().encodeWithTag(r4, 7, r5.f6080l);
            o.f6131j.encodeWithTag(r4, 8, r5.m);
            r3.encodeWithTag(r4, 9, r5.n);
            ProtoAdapter.STRING.encodeWithTag(r4, 255, r5.o);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(f r5) {
            int r4 = (j.m.encodedSizeWithTag(1, r5.f6074f) + g.f6093i.encodedSizeWithTag(2, r5.f6075g)) + p.f6137j.encodedSizeWithTag(3, r5.f6076h);
            ProtoAdapter<Long> r0 = ProtoAdapter.INT64;
            return (((((((r4 + r0.encodedSizeWithTag(4, r5.f6077i)) + r0.encodedSizeWithTag(5, r5.f6078j)) + r0.encodedSizeWithTag(6, r5.f6079k)) + c.f6048k.asRepeated().encodedSizeWithTag(7, r5.f6080l)) + o.f6131j.encodedSizeWithTag(8, r5.m)) + r0.encodedSizeWithTag(9, r5.n)) + ProtoAdapter.STRING.encodedSizeWithTag(255, r5.o)) + r5.unknownFields().size();
        }

        public f d(f r2) {
            a r1 = r2.b();
            Internal.redactElements(r1.f6087g, c.f6048k);
            r1.clearUnknownFields();
            return r1.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ f decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, f r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(f r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ f redact(f r1) {
            return d(r1);
        }
    }

    static {
        p = new b();
        j r0 = j.f6107g;
        g r1 = g.f6091g;
        p r2 = p.f6134g;
        o r3 = o.f6128g;
    }

    public f(j r2, g r3, p r4, Long r5, Long r6, Long r7, List<c> r8, o r9, Long r10, String r11, k.h r12) {
        super(p, r12);
        this.f6074f = r2;
        this.f6075g = r3;
        this.f6076h = r4;
        this.f6077i = r5;
        this.f6078j = r6;
        this.f6079k = r7;
        this.f6080l = Internal.immutableCopyOf("packets", r8);
        this.m = r9;
        this.n = r10;
        this.o = r11;
    }

    public a b() {
        a r0 = new a();
        r0.f6081a = this.f6074f;
        r0.f6082b = this.f6075g;
        r0.f6083c = this.f6076h;
        r0.f6084d = this.f6077i;
        r0.f6085e = this.f6078j;
        r0.f6086f = this.f6079k;
        r0.f6087g = Internal.copyOf("packets", this.f6080l);
        r0.f6088h = this.m;
        r0.f6089i = this.n;
        r0.f6090j = this.o;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L32;
        if (this.f6074f.equals(r6.f6074f) == false) goto L32;
        if (Internal.equals(this.f6075g, r6.f6075g) == false) goto L32;
        if (this.f6076h.equals(r6.f6076h) == false) goto L32;
        if (Internal.equals(this.f6077i, r6.f6077i) == false) goto L32;
        if (Internal.equals(this.f6078j, r6.f6078j) == false) goto L32;
        if (Internal.equals(this.f6079k, r6.f6079k) == false) goto L32;
        if (this.f6080l.equals(r6.f6080l) == false) goto L32;
        if (Internal.equals(this.m, r6.m) == false) goto L32;
        if (Internal.equals(this.n, r6.n) == false) goto L32;
        if (Internal.equals(this.o, r6.o) == false) goto L32;
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L33;
        int r1 = ((unknownFields().hashCode() * 37) + this.f6074f.hashCode()) * 37;
        g r2 = this.f6075g;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (((r1 + r4) * 37) + this.f6076h.hashCode()) * 37;
        Long r6 = this.f6077i;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.f6078j;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.f6079k;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (((r11 + r13) * 37) + this.f6080l.hashCode()) * 37;
        o r15 = this.m;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        Long r18 = this.n;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.o;
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
        r0.append(", flag=");
        r0.append(this.f6074f);
        if (this.f6075g == null) goto L5;
        r0.append(", bucket=");
        r0.append(this.f6075g);
    L5:
        r0.append(", topic_type=");
        r0.append(this.f6076h);
        if (this.f6077i == null) goto L9;
        r0.append(", sync_id=");
        r0.append(this.f6077i);
    L9:
        if (this.f6078j == null) goto L12;
        r0.append(", ref_cursor=");
        r0.append(this.f6078j);
    L12:
        if (this.f6079k == null) goto L15;
        r0.append(", new_cursor=");
        r0.append(this.f6079k);
    L15:
        if (this.f6080l.isEmpty() == true) goto L18;
        r0.append(", packets=");
        r0.append(this.f6080l);
    L18:
        if (this.m == null) goto L21;
        r0.append(", topic_status=");
        r0.append(this.m);
    L21:
        if (this.n == null) goto L24;
        r0.append(", expire_time=");
        r0.append(this.n);
    L24:
        if (this.o == null) goto L26;
        r0.append(", req_id=");
        r0.append(this.o);
    L26:
        StringBuilder r3 = r0.replace(0, 2, "BsyncTopic{");
        r3.append('}');
        return r3.toString();
    }
}
