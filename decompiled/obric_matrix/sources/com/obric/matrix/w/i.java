package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends Message<i, a> {
    public static final ProtoAdapter<i> o = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 1)
    @com.google.gson.y.c("target_dataset")
    public final a1 f10366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.StringArray#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("properties_filter")
    public final Map<String, p0> f10367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", tag = 3)
    @com.google.gson.y.c("fence_to_cal")
    public final f f10368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 4)
    @com.google.gson.y.c("from_dataset")
    public final a1 f10369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 5)
    @com.google.gson.y.c("from_fence_id_list")
    public final List<String> f10370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    @com.google.gson.y.c("with_border_info")
    public final Boolean f10371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    @com.google.gson.y.c("filter_adjacency")
    public final Boolean f10372l;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    @com.google.gson.y.c("with_overlap_from")
    public final Boolean m;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    @com.google.gson.y.c("with_overlap_target")
    public final Boolean n;

    public static final class a extends Message.Builder<i, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a1 f10373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, p0> f10374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f f10375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a1 f10376d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<String> f10377e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f10378f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Boolean f10379g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f10380h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Boolean f10381i;

        public a() {
            Boolean r0 = Boolean.FALSE;
            this.f10378f = r0;
            this.f10379g = r0;
            this.f10380h = r0;
            this.f10381i = r0;
            this.f10374b = Internal.newMutableMap();
            this.f10377e = Internal.newMutableList();
        }

        public i a() {
            return new i(this.f10373a, this.f10374b, this.f10375c, this.f10376d, this.f10377e, this.f10378f, this.f10379g, this.f10380h, this.f10381i, super.buildUnknownFields());
        }

        public a b(f r1) {
            this.f10375c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Boolean r1) {
            this.f10379g = r1;
            return this;
        }

        public a d(a1 r1) {
            this.f10376d = r1;
            return this;
        }

        public a e(a1 r1) {
            this.f10373a = r1;
            return this;
        }

        public a f(Boolean r1) {
            this.f10378f = r1;
            return this;
        }

        public a g(Boolean r1) {
            this.f10380h = r1;
            return this;
        }

        public a h(Boolean r1) {
            this.f10381i = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, p0>> f10382a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, i.class);
            this.f10382a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, p0.f10472g);
        }

        public i a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r0.h(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L8:
            r0.g(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L9:
            r0.c(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L10:
            r0.f(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L11:
            r0.f10377e.add(ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.d(a1.f10183j.decode(r7));
            goto L3
        L13:
            r0.b(f.m.decode(r7));
            goto L3
        L14:
            r0.f10374b.putAll(this.f10382a.decode(r7));
            goto L3
        L15:
            r0.e(a1.f10183j.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L16:
            r7.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r4, i r5) {
            ProtoAdapter<a1> r0 = a1.f10183j;
            r0.encodeWithTag(r4, 1, r5.f10366f);
            this.f10382a.encodeWithTag(r4, 2, r5.f10367g);
            f.m.encodeWithTag(r4, 3, r5.f10368h);
            r0.encodeWithTag(r4, 4, r5.f10369i);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 5, r5.f10370j);
            ProtoAdapter<Boolean> r3 = ProtoAdapter.BOOL;
            r3.encodeWithTag(r4, 6, r5.f10371k);
            r3.encodeWithTag(r4, 7, r5.f10372l);
            r3.encodeWithTag(r4, 8, r5.m);
            r3.encodeWithTag(r4, 9, r5.n);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(i r5) {
            ProtoAdapter<a1> r0 = a1.f10183j;
            int r1 = (((r0.encodedSizeWithTag(1, r5.f10366f) + this.f10382a.encodedSizeWithTag(2, r5.f10367g)) + f.m.encodedSizeWithTag(3, r5.f10368h)) + r0.encodedSizeWithTag(4, r5.f10369i)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r5.f10370j);
            ProtoAdapter<Boolean> r4 = ProtoAdapter.BOOL;
            return ((((r1 + r4.encodedSizeWithTag(6, r5.f10371k)) + r4.encodedSizeWithTag(7, r5.f10372l)) + r4.encodedSizeWithTag(8, r5.m)) + r4.encodedSizeWithTag(9, r5.n)) + r5.unknownFields().size();
        }

        public i d(i r2) {
            a r1 = r2.b();
            a1 r3 = r1.f10373a;
            if (r3 == null) goto L5;
            r1.f10373a = a1.f10183j.redact(r3);
        L5:
            Internal.redactElements(r1.f10374b, p0.f10472g);
            f r4 = r1.f10375c;
            if (r4 == null) goto L8;
            r1.f10375c = f.m.redact(r4);
        L8:
            a1 r5 = r1.f10376d;
            if (r5 == null) goto L11;
            r1.f10376d = a1.f10183j.redact(r5);
        L11:
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ i decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, i r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(i r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ i redact(i r1) {
            return d(r1);
        }
    }

    static {
        o = new b();
    }

    public i(a1 r2, Map<String, p0> r3, f r4, a1 r5, List<String> r6, Boolean r7, Boolean r8, Boolean r9, Boolean r10, k.h r11) {
        super(o, r11);
        this.f10366f = r2;
        this.f10367g = Internal.immutableCopyOf("properties_filter", r3);
        this.f10368h = r4;
        this.f10369i = r5;
        this.f10370j = Internal.immutableCopyOf("from_fence_id_list", r6);
        this.f10371k = r7;
        this.f10372l = r8;
        this.m = r9;
        this.n = r10;
    }

    public a b() {
        a r0 = new a();
        r0.f10373a = this.f10366f;
        r0.f10374b = Internal.copyOf("properties_filter", this.f10367g);
        r0.f10375c = this.f10368h;
        r0.f10376d = this.f10369i;
        r0.f10377e = Internal.copyOf("from_fence_id_list", this.f10370j);
        r0.f10378f = this.f10371k;
        r0.f10379g = this.f10372l;
        r0.f10380h = this.m;
        r0.f10381i = this.n;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.f10366f, r6.f10366f) == false) goto L30;
        if (this.f10367g.equals(r6.f10367g) == false) goto L30;
        if (Internal.equals(this.f10368h, r6.f10368h) == false) goto L30;
        if (Internal.equals(this.f10369i, r6.f10369i) == false) goto L30;
        if (this.f10370j.equals(r6.f10370j) == false) goto L30;
        if (Internal.equals(this.f10371k, r6.f10371k) == false) goto L30;
        if (Internal.equals(this.f10372l, r6.f10372l) == false) goto L30;
        if (Internal.equals(this.m, r6.m) == false) goto L30;
        if (Internal.equals(this.n, r6.n) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L33;
        int r1 = unknownFields().hashCode() * 37;
        a1 r2 = this.f10366f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (((r1 + r4) * 37) + this.f10367g.hashCode()) * 37;
        f r6 = this.f10368h;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        a1 r9 = this.f10369i;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (((r8 + r10) * 37) + this.f10370j.hashCode()) * 37;
        Boolean r12 = this.f10371k;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Boolean r15 = this.f10372l;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        Boolean r18 = this.m;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        Boolean r21 = this.n;
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
        if (this.f10366f == null) goto L5;
        r0.append(", target_dataset=");
        r0.append(this.f10366f);
    L5:
        Map<String, p0> r1 = this.f10367g;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", properties_filter=");
        r0.append(this.f10367g);
    L11:
        if (this.f10368h == null) goto L14;
        r0.append(", fence_to_cal=");
        r0.append(this.f10368h);
    L14:
        if (this.f10369i == null) goto L16;
        r0.append(", from_dataset=");
        r0.append(this.f10369i);
    L16:
        List<String> r2 = this.f10370j;
        if (r2 == null) goto L22;
        if (r2.isEmpty() == true) goto L22;
        r0.append(", from_fence_id_list=");
        r0.append(this.f10370j);
    L22:
        if (this.f10371k == null) goto L25;
        r0.append(", with_border_info=");
        r0.append(this.f10371k);
    L25:
        if (this.f10372l == null) goto L28;
        r0.append(", filter_adjacency=");
        r0.append(this.f10372l);
    L28:
        if (this.m == null) goto L31;
        r0.append(", with_overlap_from=");
        r0.append(this.m);
    L31:
        if (this.n == null) goto L33;
        r0.append(", with_overlap_target=");
        r0.append(this.n);
    L33:
        StringBuilder r3 = r0.replace(0, 2, "GetIntersectFencesRequest{");
        r3.append('}');
        return r3.toString();
    }
}
