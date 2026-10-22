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
public final class f extends Message<f, a> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ProtoAdapter<f> f10075l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f10076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f10077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f10078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f10079i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final k.h f10080j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.o.push.Message#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<g> f10081k;

    public static final class a extends Message.Builder<f, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10084c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f10085d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public k.h f10086e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<g> f10087f;

        public a() {
            this.f10087f = Internal.newMutableList();
        }

        public a a(k.h r1) {
            this.f10086e = r1;
            return this;
        }

        public f b() {
            return new f(this.f10082a, this.f10083b, this.f10084c, this.f10085d, this.f10086e, this.f10087f, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(String r1) {
            this.f10084c = r1;
            return this;
        }

        public a d(String r1) {
            this.f10083b = r1;
            return this;
        }

        public a e(Long r1) {
            this.f10085d = r1;
            return this;
        }

        public a f(Integer r1) {
            this.f10082a = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<f> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, f.class);
        }

        public f a(ProtoReader r5) {
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
            r4.f10087f.add(g.t.decode(r5));
            goto L3
        L8:
            r4.a(ProtoAdapter.BYTES.decode(r5));
            goto L3
        L9:
            r4.e(ProtoAdapter.INT64.decode(r5));
            goto L3
        L10:
            r4.c(ProtoAdapter.STRING.decode(r5));
            goto L3
        L11:
            r4.d(ProtoAdapter.STRING.decode(r5));
            goto L3
        L12:
            r4.f(ProtoAdapter.INT32.decode(r5));
            goto L3
        L6:
            r5.readUnknownField(r2);
            goto L3
        L13:
            r4.addUnknownFields(r5.endMessageAndGetUnknownFields(r0));
            return r4.b();
        }

        public void b(ProtoWriter r3, f r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.f10076f);
            ProtoAdapter<String> r2 = ProtoAdapter.STRING;
            r2.encodeWithTag(r3, 2, r4.f10077g);
            r2.encodeWithTag(r3, 3, r4.f10078h);
            ProtoAdapter.INT64.encodeWithTag(r3, 4, r4.f10079i);
            ProtoAdapter.BYTES.encodeWithTag(r3, 5, r4.f10080j);
            g.t.asRepeated().encodeWithTag(r3, 6, r4.f10081k);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(f r4) {
            int r3 = ProtoAdapter.INT32.encodedSizeWithTag(1, r4.f10076f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            return (((((r3 + r0.encodedSizeWithTag(2, r4.f10077g)) + r0.encodedSizeWithTag(3, r4.f10078h)) + ProtoAdapter.INT64.encodedSizeWithTag(4, r4.f10079i)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r4.f10080j)) + g.t.asRepeated().encodedSizeWithTag(6, r4.f10081k)) + r4.unknownFields().size();
        }

        public f d(f r2) {
            a r1 = r2.b();
            Internal.redactElements(r1.f10087f, g.t);
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
        f10075l = new b();
        k.h r0 = k.h.f18266i;
    }

    public f(Integer r2, String r3, String r4, Long r5, k.h r6, List<g> r7, k.h r8) {
        super(f10075l, r8);
        this.f10076f = r2;
        this.f10077g = r3;
        this.f10078h = r4;
        this.f10079i = r5;
        this.f10080j = r6;
        this.f10081k = Internal.immutableCopyOf("msg_list", r7);
    }

    public a b() {
        a r0 = new a();
        r0.f10082a = this.f10076f;
        r0.f10083b = this.f10077g;
        r0.f10084c = this.f10078h;
        r0.f10085d = this.f10079i;
        r0.f10086e = this.f10080j;
        r0.f10087f = Internal.copyOf(this.f10081k);
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
        if (unknownFields().equals(r6.unknownFields()) == false) goto L24;
        if (Internal.equals(this.f10076f, r6.f10076f) == false) goto L24;
        if (Internal.equals(this.f10077g, r6.f10077g) == false) goto L24;
        if (Internal.equals(this.f10078h, r6.f10078h) == false) goto L24;
        if (Internal.equals(this.f10079i, r6.f10079i) == false) goto L24;
        if (Internal.equals(this.f10080j, r6.f10080j) == false) goto L24;
        if (this.f10081k.equals(r6.f10081k) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10076f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f10077g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f10078h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.f10079i;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        k.h r15 = this.f10080j;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = ((r14 + r3) * 37) + this.f10081k.hashCode();
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
        if (this.f10076f == null) goto L6;
        r0.append(", version=");
        r0.append(this.f10076f);
    L6:
        if (this.f10077g == null) goto L9;
        r0.append(", env=");
        r0.append(this.f10077g);
    L9:
        if (this.f10078h == null) goto L12;
        r0.append(", did=");
        r0.append(this.f10078h);
    L12:
        if (this.f10079i == null) goto L15;
        r0.append(", session_id=");
        r0.append(this.f10079i);
    L15:
        if (this.f10080j == null) goto L18;
        r0.append(", body=");
        r0.append(this.f10080j);
    L18:
        if (this.f10081k.isEmpty() == true) goto L20;
        r0.append(", msg_list=");
        r0.append(this.f10081k);
    L20:
        StringBuilder r3 = r0.replace(0, 2, "HeartbeatPong{");
        r3.append('}');
        return r3.toString();
    }
}
