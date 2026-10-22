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
public final class h0 extends Message<h0, a> {
    public static final ProtoAdapter<h0> m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    @com.google.gson.y.c("isAllUseBind")
    public final Boolean f10351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @com.google.gson.y.c("minSupportIntentServiceVersion")
    public final Integer f10352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 3)
    @com.google.gson.y.c("useBindCmd")
    public final List<Integer> f10353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @com.google.gson.y.c("sendCmdTimeout")
    public final Integer f10354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @com.google.gson.y.c("pollingInterval")
    public final Integer f10355j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @com.google.gson.y.c("extraConfigs")
    public final Map<String, String> f10356k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 7)
    @com.google.gson.y.c("forceUseOldBindCmd")
    public final List<Integer> f10357l;

    public static final class a extends Message.Builder<h0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f10358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f10359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Integer> f10360c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f10361d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f10362e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<String, String> f10363f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<Integer> f10364g;

        public a() {
            this.f10358a = Boolean.FALSE;
            this.f10359b = 0;
            this.f10361d = 0;
            this.f10362e = 0;
            this.f10360c = Internal.newMutableList();
            this.f10363f = Internal.newMutableMap();
            this.f10364g = Internal.newMutableList();
        }

        public h0 a() {
            return new h0(this.f10358a, this.f10359b, this.f10360c, this.f10361d, this.f10362e, this.f10363f, this.f10364g, super.buildUnknownFields());
        }

        public a b(Boolean r1) {
            this.f10358a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r1) {
            this.f10359b = r1;
            return this;
        }

        public a d(Integer r1) {
            this.f10362e = r1;
            return this;
        }

        public a e(Integer r1) {
            this.f10361d = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<h0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10365a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, h0.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10365a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public h0 a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            switch(r3) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            List<Integer> r4 = r0.f10364g;
        L12:
            r4.add(ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            r0.f10363f.putAll(this.f10365a.decode(r7));
            goto L3
        L9:
            r0.d(ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            r0.e(ProtoAdapter.INT32.decode(r7));
            goto L3
        L11:
            r4 = r0.f10360c;
            goto L12
        L13:
            r0.c(ProtoAdapter.INT32.decode(r7));
            goto L3
        L14:
            r0.b(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L6:
            FieldEncoding r5 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r5, r5.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r5, h0 r6) {
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r6.f10351f);
            ProtoAdapter<Integer> r0 = ProtoAdapter.INT32;
            r0.encodeWithTag(r5, 2, r6.f10352g);
            r0.asRepeated().encodeWithTag(r5, 3, r6.f10353h);
            r0.encodeWithTag(r5, 4, r6.f10354i);
            r0.encodeWithTag(r5, 5, r6.f10355j);
            this.f10365a.encodeWithTag(r5, 6, r6.f10356k);
            r0.asRepeated().encodeWithTag(r5, 7, r6.f10357l);
            r5.writeBytes(r6.unknownFields());
        }

        public int c(h0 r6) {
            int r0 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r6.f10351f);
            ProtoAdapter<Integer> r1 = ProtoAdapter.INT32;
            return ((((((r0 + r1.encodedSizeWithTag(2, r6.f10352g)) + r1.asRepeated().encodedSizeWithTag(3, r6.f10353h)) + r1.encodedSizeWithTag(4, r6.f10354i)) + r1.encodedSizeWithTag(5, r6.f10355j)) + this.f10365a.encodedSizeWithTag(6, r6.f10356k)) + r1.asRepeated().encodedSizeWithTag(7, r6.f10357l)) + r6.unknownFields().size();
        }

        public h0 d(h0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ h0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, h0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(h0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ h0 redact(h0 r1) {
            return d(r1);
        }
    }

    static {
        m = new b();
    }

    public h0(Boolean r2, Integer r3, List<Integer> r4, Integer r5, Integer r6, Map<String, String> r7, List<Integer> r8, k.h r9) {
        super(m, r9);
        this.f10351f = r2;
        this.f10352g = r3;
        this.f10353h = Internal.immutableCopyOf("useBindCmd", r4);
        this.f10354i = r5;
        this.f10355j = r6;
        this.f10356k = Internal.immutableCopyOf("extraConfigs", r7);
        this.f10357l = Internal.immutableCopyOf("forceUseOldBindCmd", r8);
    }

    public a b() {
        a r0 = new a();
        r0.f10358a = this.f10351f;
        r0.f10359b = this.f10352g;
        r0.f10360c = Internal.copyOf("useBindCmd", this.f10353h);
        r0.f10361d = this.f10354i;
        r0.f10362e = this.f10355j;
        r0.f10363f = Internal.copyOf("extraConfigs", this.f10356k);
        r0.f10364g = Internal.copyOf("forceUseOldBindCmd", this.f10357l);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r6 = (h0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (Internal.equals(this.f10351f, r6.f10351f) == false) goto L26;
        if (Internal.equals(this.f10352g, r6.f10352g) == false) goto L26;
        if (this.f10353h.equals(r6.f10353h) == false) goto L26;
        if (Internal.equals(this.f10354i, r6.f10354i) == false) goto L26;
        if (Internal.equals(this.f10355j, r6.f10355j) == false) goto L26;
        if (this.f10356k.equals(r6.f10356k) == false) goto L26;
        if (this.f10357l.equals(r6.f10357l) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.f10351f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f10352g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (((r5 + r7) * 37) + this.f10353h.hashCode()) * 37;
        Integer r9 = this.f10354i;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.f10355j;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = ((((r11 + r3) * 37) + this.f10356k.hashCode()) * 37) + this.f10357l.hashCode();
        this.hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10351f == null) goto L6;
        r0.append(", isAllUseBind=");
        r0.append(this.f10351f);
    L6:
        if (this.f10352g == null) goto L8;
        r0.append(", minSupportIntentServiceVersion=");
        r0.append(this.f10352g);
    L8:
        List<Integer> r1 = this.f10353h;
        if (r1 == null) goto L14;
        if (r1.isEmpty() == true) goto L14;
        r0.append(", useBindCmd=");
        r0.append(this.f10353h);
    L14:
        if (this.f10354i == null) goto L17;
        r0.append(", sendCmdTimeout=");
        r0.append(this.f10354i);
    L17:
        if (this.f10355j == null) goto L19;
        r0.append(", pollingInterval=");
        r0.append(this.f10355j);
    L19:
        Map<String, String> r2 = this.f10356k;
        if (r2 != null) goto L22;
    L24:
        List<Integer> r3 = this.f10357l;
        if (r3 != null) goto L27;
    L29:
        StringBuilder r4 = r0.replace(0, 2, "SdkSendCmdConfig{");
        r4.append('}');
        return r4.toString();
    L27:
        if (r3.isEmpty() == true) goto L29;
        r0.append(", forceUseOldBindCmd=");
        r0.append(this.f10357l);
        goto L29
    L22:
        if (r2.isEmpty() == true) goto L24;
        r0.append(", extraConfigs=");
        r0.append(this.f10356k);
        goto L24
    }
}
