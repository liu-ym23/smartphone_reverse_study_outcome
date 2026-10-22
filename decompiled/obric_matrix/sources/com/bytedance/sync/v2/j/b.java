package com.bytedance.sync.v2.j;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Message<b, a> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ProtoAdapter<b> f6034l = null;
    public static final Long m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.Version#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final q f6035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f6036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f6037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f6038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.Ctrl#ADAPTER", tag = 5)
    public final i f6039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", keyAdapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 255)
    public final Map<Integer, k.h> f6040k;

    public static final class a extends Message.Builder<b, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q f6041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f6044d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public i f6045e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<Integer, k.h> f6046f;

        public a() {
            this.f6046f = Internal.newMutableMap();
        }

        public b a() {
            q r0 = this.f6041a;
            if (r0 == null) goto L7;
            return new b(this.f6041a, this.f6042b, this.f6043c, this.f6044d, this.f6045e, this.f6046f, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "version"});
        }

        public a b(i r1) {
            this.f6045e = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.f6043c = r1;
            return this;
        }

        public a d(Map<Integer, k.h> r1) {
            Internal.checkElementsNotNull(r1);
            this.f6046f = r1;
            return this;
        }

        public a e(Long r1) {
            this.f6044d = r1;
            return this;
        }

        public a f(String r1) {
            this.f6042b = r1;
            return this;
        }

        public a g(q r1) {
            this.f6041a = r1;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sync.v2.j.b$b, reason: collision with other inner class name */
    private static final class C0194b extends ProtoAdapter<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<Integer, k.h>> f6047a;

        public C0194b() {
            super(FieldEncoding.LENGTH_DELIMITED, b.class);
            this.f6047a = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, ProtoAdapter.BYTES);
        }

        public b a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L28;
            if (r3 != 1) goto L8;
            r0.g(q.f6143j.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.f(ProtoAdapter.STRING.decode(r9));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.c(ProtoAdapter.STRING.decode(r9));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.e(ProtoAdapter.INT64.decode(r9));
            goto L3
        L14:
            if (r3 != 5) goto L16;
            r0.b(i.f6104j.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L16:
            if (r3 != 255) goto L17;
            r0.f6046f.putAll(this.f6047a.decode(r9));
            goto L3
        L17:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L28:
            r9.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r4, b r5) {
            q.f6143j.encodeWithTag(r4, 1, r5.f6035f);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 2, r5.f6036g);
            r0.encodeWithTag(r4, 3, r5.f6037h);
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r5.f6038i);
            i.f6104j.encodeWithTag(r4, 5, r5.f6039j);
            this.f6047a.encodeWithTag(r4, 255, r5.f6040k);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(b r5) {
            int r0 = q.f6143j.encodedSizeWithTag(1, r5.f6035f);
            ProtoAdapter<String> r1 = ProtoAdapter.STRING;
            return (((((r0 + r1.encodedSizeWithTag(2, r5.f6036g)) + r1.encodedSizeWithTag(3, r5.f6037h)) + ProtoAdapter.INT64.encodedSizeWithTag(4, r5.f6038i)) + i.f6104j.encodedSizeWithTag(5, r5.f6039j)) + this.f6047a.encodedSizeWithTag(255, r5.f6040k)) + r5.unknownFields().size();
        }

        public b d(b r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ b decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, b r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(b r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ b redact(b r1) {
            return d(r1);
        }
    }

    static {
        f6034l = new C0194b();
        q r0 = q.f6140g;
        m = 0L;
        i r1 = i.f6101g;
    }

    public b(q r2, String r3, String r4, Long r5, i r6, Map<Integer, k.h> r7, k.h r8) {
        super(f6034l, r8);
        this.f6035f = r2;
        this.f6036g = r3;
        this.f6037h = r4;
        this.f6038i = r5;
        this.f6039j = r6;
        this.f6040k = Internal.immutableCopyOf("infos", r7);
    }

    public a b() {
        a r0 = new a();
        r0.f6041a = this.f6035f;
        r0.f6042b = this.f6036g;
        r0.f6043c = this.f6037h;
        r0.f6044d = this.f6038i;
        r0.f6045e = this.f6039j;
        r0.f6046f = Internal.copyOf("infos", this.f6040k);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L24;
        if (this.f6035f.equals(r6.f6035f) == false) goto L24;
        if (Internal.equals(this.f6036g, r6.f6036g) == false) goto L24;
        if (Internal.equals(this.f6037h, r6.f6037h) == false) goto L24;
        if (Internal.equals(this.f6038i, r6.f6038i) == false) goto L24;
        if (Internal.equals(this.f6039j, r6.f6039j) == false) goto L24;
        if (this.f6040k.equals(r6.f6040k) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = ((unknownFields().hashCode() * 37) + this.f6035f.hashCode()) * 37;
        String r2 = this.f6036g;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f6037h;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.f6038i;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        i r12 = this.f6039j;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = ((r11 + r3) * 37) + this.f6040k.hashCode();
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
        r0.append(", version=");
        r0.append(this.f6035f);
        if (this.f6036g == null) goto L6;
        r0.append(", uid=");
        r0.append(this.f6036g);
    L6:
        if (this.f6037h == null) goto L9;
        r0.append(", did=");
        r0.append(this.f6037h);
    L9:
        if (this.f6038i == null) goto L12;
        r0.append(", ts=");
        r0.append(this.f6038i);
    L12:
        if (this.f6039j == null) goto L15;
        r0.append(", ctrl=");
        r0.append(this.f6039j);
    L15:
        if (this.f6040k.isEmpty() == true) goto L17;
        r0.append(", infos=");
        r0.append(this.f6040k);
    L17:
        StringBuilder r3 = r0.replace(0, 2, "BsyncHeader{");
        r3.append('}');
        return r3.toString();
    }
}
