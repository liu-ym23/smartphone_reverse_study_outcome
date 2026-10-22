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
public final class f extends Message<f, a> {
    public static final ProtoAdapter<f> m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @com.google.gson.y.c("fenceid")
    public final String f10303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @com.google.gson.y.c("shape")
    public final Integer f10304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Circle#ADAPTER", tag = 3)
    @com.google.gson.y.c("circular")
    public final c f10305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    @com.google.gson.y.c("vertices")
    public final List<x> f10306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @com.google.gson.y.c("properties")
    public final Map<String, String> f10307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    @com.google.gson.y.c("polygons")
    public final List<y> f10308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.MultiPolygon#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    @com.google.gson.y.c("multi_polygon")
    public final List<r> f10309l;

    public static final class a extends Message.Builder<f, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f10311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f10312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<x> f10313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f10314e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<y> f10315f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<r> f10316g;

        public a() {
            this.f10310a = "";
            this.f10311b = 0;
            this.f10313d = Internal.newMutableList();
            this.f10314e = Internal.newMutableMap();
            this.f10315f = Internal.newMutableList();
            this.f10316g = Internal.newMutableList();
        }

        public f a() {
            return new f(this.f10310a, this.f10311b, this.f10312c, this.f10313d, this.f10314e, this.f10315f, this.f10316g, super.buildUnknownFields());
        }

        public a b(c r1) {
            this.f10312c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.f10310a = r1;
            return this;
        }

        public a d(Integer r1) {
            this.f10311b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10317a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, f.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10317a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public f a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            switch(r3) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            List r4 = r0.f10316g;
            Message r5 = (r) r.f10495g.decode(r7);
        L11:
            r4.add(r5);
            goto L3
        L8:
            r4 = r0.f10315f;
            r5 = (y) y.f10589g.decode(r7);
            goto L11
        L9:
            r0.f10314e.putAll(this.f10317a.decode(r7));
            goto L3
        L10:
            r4 = r0.f10313d;
            r5 = (x) x.f10581h.decode(r7);
            goto L11
        L12:
            r0.b(c.f10233h.decode(r7));
            goto L3
        L13:
            r0.d(ProtoAdapter.INT32.decode(r7));
            goto L3
        L14:
            r0.c(ProtoAdapter.STRING.decode(r7));
            goto L3
        L6:
            FieldEncoding r6 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r6, r6.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r4, f r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.f10303f);
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r5.f10304g);
            c.f10233h.encodeWithTag(r4, 3, r5.f10305h);
            x.f10581h.asRepeated().encodeWithTag(r4, 4, r5.f10306i);
            this.f10317a.encodeWithTag(r4, 5, r5.f10307j);
            y.f10589g.asRepeated().encodeWithTag(r4, 6, r5.f10308k);
            r.f10495g.asRepeated().encodeWithTag(r4, 7, r5.f10309l);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(f r5) {
            return ((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.f10303f) + ProtoAdapter.INT32.encodedSizeWithTag(2, r5.f10304g)) + c.f10233h.encodedSizeWithTag(3, r5.f10305h)) + x.f10581h.asRepeated().encodedSizeWithTag(4, r5.f10306i)) + this.f10317a.encodedSizeWithTag(5, r5.f10307j)) + y.f10589g.asRepeated().encodedSizeWithTag(6, r5.f10308k)) + r.f10495g.asRepeated().encodedSizeWithTag(7, r5.f10309l)) + r5.unknownFields().size();
        }

        public f d(f r2) {
            a r1 = r2.b();
            c r3 = r1.f10312c;
            if (r3 == null) goto L5;
            r1.f10312c = c.f10233h.redact(r3);
        L5:
            Internal.redactElements(r1.f10313d, x.f10581h);
            Internal.redactElements(r1.f10315f, y.f10589g);
            Internal.redactElements(r1.f10316g, r.f10495g);
            r1.clearUnknownFields();
            return r1.a();
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
        m = new b();
    }

    public f(String r2, Integer r3, c r4, List<x> r5, Map<String, String> r6, List<y> r7, List<r> r8, k.h r9) {
        super(m, r9);
        this.f10303f = r2;
        this.f10304g = r3;
        this.f10305h = r4;
        this.f10306i = Internal.immutableCopyOf("vertices", r5);
        this.f10307j = Internal.immutableCopyOf("properties", r6);
        this.f10308k = Internal.immutableCopyOf("polygons", r7);
        this.f10309l = Internal.immutableCopyOf("multi_polygon", r8);
    }

    public a b() {
        a r0 = new a();
        r0.f10310a = this.f10303f;
        r0.f10311b = this.f10304g;
        r0.f10312c = this.f10305h;
        r0.f10313d = Internal.copyOf("vertices", this.f10306i);
        r0.f10314e = Internal.copyOf("properties", this.f10307j);
        r0.f10315f = Internal.copyOf("polygons", this.f10308k);
        r0.f10316g = Internal.copyOf("multi_polygon", this.f10309l);
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
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (Internal.equals(this.f10303f, r6.f10303f) == false) goto L26;
        if (Internal.equals(this.f10304g, r6.f10304g) == false) goto L26;
        if (Internal.equals(this.f10305h, r6.f10305h) == false) goto L26;
        if (this.f10306i.equals(r6.f10306i) == false) goto L26;
        if (this.f10307j.equals(r6.f10307j) == false) goto L26;
        if (this.f10308k.equals(r6.f10308k) == false) goto L26;
        if (this.f10309l.equals(r6.f10309l) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f10303f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f10304g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        c r9 = this.f10305h;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((((((((r8 + r3) * 37) + this.f10306i.hashCode()) * 37) + this.f10307j.hashCode()) * 37) + this.f10308k.hashCode()) * 37) + this.f10309l.hashCode();
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
        if (this.f10303f == null) goto L6;
        r0.append(", fenceid=");
        r0.append(this.f10303f);
    L6:
        if (this.f10304g == null) goto L9;
        r0.append(", shape=");
        r0.append(this.f10304g);
    L9:
        if (this.f10305h == null) goto L11;
        r0.append(", circular=");
        r0.append(this.f10305h);
    L11:
        List<x> r1 = this.f10306i;
        if (r1 != null) goto L14;
    L16:
        Map<String, String> r2 = this.f10307j;
        if (r2 != null) goto L19;
    L21:
        List<y> r3 = this.f10308k;
        if (r3 != null) goto L24;
    L26:
        List<r> r4 = this.f10309l;
        if (r4 != null) goto L29;
    L31:
        StringBuilder r5 = r0.replace(0, 2, "Fence{");
        r5.append('}');
        return r5.toString();
    L29:
        if (r4.isEmpty() == true) goto L31;
        r0.append(", multi_polygon=");
        r0.append(this.f10309l);
        goto L31
    L24:
        if (r3.isEmpty() == true) goto L26;
        r0.append(", polygons=");
        r0.append(this.f10308k);
        goto L26
    L19:
        if (r2.isEmpty() == true) goto L21;
        r0.append(", properties=");
        r0.append(this.f10307j);
        goto L21
    L14:
        if (r1.isEmpty() == true) goto L16;
        r0.append(", vertices=");
        r0.append(this.f10306i);
        goto L16
    }
}
