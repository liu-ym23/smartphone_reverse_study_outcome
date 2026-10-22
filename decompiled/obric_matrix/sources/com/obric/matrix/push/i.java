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
public final class i extends Message<i, a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ProtoAdapter<i> f9599j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f9600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f9601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f9602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 255)
    public final Map<String, String> f9603i;

    public static final class a extends Message.Builder<i, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f9607d;

        public a() {
            this.f9607d = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f9606c = r1;
            return this;
        }

        public i b() {
            return new i(this.f9604a, this.f9605b, this.f9606c, this.f9607d, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(String r1) {
            this.f9604a = r1;
            return this;
        }

        public a d(String r1) {
            this.f9605b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f9608a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, i.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f9608a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public i a(ProtoReader r6) {
            a r0 = new a();
            long r1 = r6.beginMessage();
        L3:
            int r3 = r6.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.c(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.d(ProtoAdapter.STRING.decode(r6));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.a(ProtoAdapter.STRING.decode(r6));
            goto L3
        L12:
            if (r3 != 255) goto L13;
            r0.f9607d.putAll(this.f9608a.decode(r6));
            goto L3
        L13:
            r6.readUnknownField(r3);
            goto L3
        L18:
            r0.addUnknownFields(r6.endMessageAndGetUnknownFields(r1));
            return r0.b();
        }

        public void b(ProtoWriter r4, i r5) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.f9600f);
            r0.encodeWithTag(r4, 2, r5.f9601g);
            r0.encodeWithTag(r4, 3, r5.f9602h);
            this.f9608a.encodeWithTag(r4, 255, r5.f9603i);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(i r5) {
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            return (((r0.encodedSizeWithTag(1, r5.f9600f) + r0.encodedSizeWithTag(2, r5.f9601g)) + r0.encodedSizeWithTag(3, r5.f9602h)) + this.f9608a.encodedSizeWithTag(255, r5.f9603i)) + r5.unknownFields().size();
        }

        public i d(i r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.b();
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
        f9599j = new b();
    }

    public i(String r2, String r3, String r4, Map<String, String> r5, k.h r6) {
        super(f9599j, r6);
        this.f9600f = r2;
        this.f9601g = r3;
        this.f9602h = r4;
        this.f9603i = Internal.immutableCopyOf(WsConstants.KEY_EXTRA, r5);
    }

    public a b() {
        a r0 = new a();
        r0.f9604a = this.f9600f;
        r0.f9605b = this.f9601g;
        r0.f9606c = this.f9602h;
        r0.f9607d = Internal.copyOf(this.f9603i);
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
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f9600f, r6.f9600f) == false) goto L20;
        if (Internal.equals(this.f9601g, r6.f9601g) == false) goto L20;
        if (Internal.equals(this.f9602h, r6.f9602h) == false) goto L20;
        if (this.f9603i.equals(r6.f9603i) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f9600f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f9601g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f9602h;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((r8 + r3) * 37) + this.f9603i.hashCode();
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
        if (this.f9600f == null) goto L6;
        r0.append(", req_id=");
        r0.append(this.f9600f);
    L6:
        if (this.f9601g == null) goto L9;
        r0.append(", url=");
        r0.append(this.f9601g);
    L9:
        if (this.f9602h == null) goto L12;
        r0.append(", body=");
        r0.append(this.f9602h);
    L12:
        if (this.f9603i.isEmpty() == true) goto L14;
        r0.append(", extra=");
        r0.append(this.f9603i);
    L14:
        StringBuilder r3 = r0.replace(0, 2, "Response{");
        r3.append('}');
        return r3.toString();
    }
}
