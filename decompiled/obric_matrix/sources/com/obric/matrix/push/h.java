package com.obric.matrix.push;

import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends Message<h, a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ProtoAdapter<h> f9586k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f9587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f9588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> f9589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String f9590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 255)
    public final Map<String, String> f9591j;

    public static final class a extends Message.Builder<h, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f9594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f9595d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f9596e;

        public a() {
            this.f9594c = Internal.newMutableMap();
            this.f9596e = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f9595d = r1;
            return this;
        }

        public h b() {
            return new h(this.f9592a, this.f9593b, this.f9594c, this.f9595d, this.f9596e, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(String r1) {
            this.f9592a = r1;
            return this;
        }

        public a d(String r1) {
            this.f9593b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f9597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f9598b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, h.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f9597a = ProtoAdapter.newMapAdapter(r0, r0);
            this.f9598b = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public h a(ProtoReader r6) {
            a r0 = new a();
            long r1 = r6.beginMessage();
        L3:
            int r3 = r6.nextTag();
            if (r3 == (-1)) goto L22;
            if (r3 != 1) goto L8;
            r0.c(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.d(ProtoAdapter.STRING.decode(r6));
            goto L3
        L10:
            if (r3 == 3) goto L18;
            if (r3 != 4) goto L14;
            r0.a(ProtoAdapter.STRING.decode(r6));
            goto L3
        L14:
            if (r3 != 255) goto L15;
            Map<String, String> r4 = r0.f9596e;
            ProtoAdapter<Map<String, String>> r5 = this.f9598b;
        L19:
            r4.putAll(r5.decode(r6));
            goto L3
        L15:
            r6.readUnknownField(r3);
            goto L3
        L18:
            r4 = r0.f9594c;
            r5 = this.f9597a;
            goto L19
        L22:
            r0.addUnknownFields(r6.endMessageAndGetUnknownFields(r1));
            return r0.b();
        }

        public void b(ProtoWriter r5, h r6) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.f9587f);
            r0.encodeWithTag(r5, 2, r6.f9588g);
            this.f9597a.encodeWithTag(r5, 3, r6.f9589h);
            r0.encodeWithTag(r5, 4, r6.f9590i);
            this.f9598b.encodeWithTag(r5, 255, r6.f9591j);
            r5.writeBytes(r6.unknownFields());
        }

        public int c(h r6) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            return ((((r0.encodedSizeWithTag(1, r6.f9587f) + r0.encodedSizeWithTag(2, r6.f9588g)) + this.f9597a.encodedSizeWithTag(3, r6.f9589h)) + r0.encodedSizeWithTag(4, r6.f9590i)) + this.f9598b.encodedSizeWithTag(255, r6.f9591j)) + r6.unknownFields().size();
        }

        public h d(h r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ h decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, h r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(h r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ h redact(h r1) {
            return d(r1);
        }
    }

    static {
        f9586k = new b();
    }

    public h(String r2, String r3, Map<String, String> r4, String r5, Map<String, String> r6, k.h r7) {
        super(f9586k, r7);
        this.f9587f = r2;
        this.f9588g = r3;
        this.f9589h = Internal.immutableCopyOf("header", r4);
        this.f9590i = r5;
        this.f9591j = Internal.immutableCopyOf(WsConstants.KEY_EXTRA, r6);
    }

    public a b() {
        a r0 = new a();
        r0.f9592a = this.f9587f;
        r0.f9593b = this.f9588g;
        r0.f9594c = Internal.copyOf(this.f9589h);
        r0.f9595d = this.f9590i;
        r0.f9596e = Internal.copyOf(this.f9591j);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L22;
        if (Internal.equals(this.f9587f, r6.f9587f) == false) goto L22;
        if (Internal.equals(this.f9588g, r6.f9588g) == false) goto L22;
        if (this.f9589h.equals(r6.f9589h) == false) goto L22;
        if (Internal.equals(this.f9590i, r6.f9590i) == false) goto L22;
        if (this.f9591j.equals(r6.f9591j) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f9587f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f9588g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (((r5 + r7) * 37) + this.f9589h.hashCode()) * 37;
        String r9 = this.f9590i;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((r8 + r3) * 37) + this.f9591j.hashCode();
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
        if (this.f9587f == null) goto L6;
        r0.append(", req_id=");
        r0.append(this.f9587f);
    L6:
        if (this.f9588g == null) goto L9;
        r0.append(", url=");
        r0.append(this.f9588g);
    L9:
        if (this.f9589h.isEmpty() == true) goto L12;
        r0.append(", header=");
        r0.append(this.f9589h);
    L12:
        if (this.f9590i == null) goto L15;
        r0.append(", body=");
        r0.append(this.f9590i);
    L15:
        if (this.f9591j.isEmpty() == true) goto L17;
        r0.append(", extra=");
        r0.append(this.f9591j);
    L17:
        StringBuilder r3 = r0.replace(0, 2, "Request{");
        r3.append('}');
        return r3.toString();
    }
}
