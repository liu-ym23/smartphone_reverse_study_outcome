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
public final class c extends Message<c, a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ProtoAdapter<c> f9522i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f9523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long f9524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 255)
    public final Map<String, String> f9525h;

    public static final class a extends Message.Builder<c, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f9527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f9528c;

        public a() {
            this.f9528c = Internal.newMutableMap();
        }

        public c a() {
            return new c(this.f9526a, this.f9527b, this.f9528c, super.buildUnknownFields());
        }

        public a b(String r1) {
            this.f9526a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Long r1) {
            this.f9527b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f9529a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, c.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f9529a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public c a(ProtoReader r6) {
            a r0 = new a();
            long r1 = r6.beginMessage();
        L3:
            int r3 = r6.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.b(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.c(ProtoAdapter.INT64.decode(r6));
            goto L3
        L10:
            if (r3 != 255) goto L11;
            r0.f9528c.putAll(this.f9529a.decode(r6));
            goto L3
        L11:
            r6.readUnknownField(r3);
            goto L3
        L15:
            r0.addUnknownFields(r6.endMessageAndGetUnknownFields(r1));
            return r0.a();
        }

        public void b(ProtoWriter r4, c r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.f9523f);
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r5.f9524g);
            this.f9529a.encodeWithTag(r4, 255, r5.f9525h);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(c r5) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.f9523f) + ProtoAdapter.INT64.encodedSizeWithTag(2, r5.f9524g)) + this.f9529a.encodedSizeWithTag(255, r5.f9525h)) + r5.unknownFields().size();
        }

        public c d(c r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ c decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, c r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(c r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ c redact(c r1) {
            return d(r1);
        }
    }

    static {
        f9522i = new b();
    }

    public c(String r2, Long r3, Map<String, String> r4, k.h r5) {
        super(f9522i, r5);
        this.f9523f = r2;
        this.f9524g = r3;
        this.f9525h = Internal.immutableCopyOf(WsConstants.KEY_EXTRA, r4);
    }

    public a b() {
        a r0 = new a();
        r0.f9526a = this.f9523f;
        r0.f9527b = this.f9524g;
        r0.f9528c = Internal.copyOf(this.f9525h);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (Internal.equals(this.f9523f, r6.f9523f) == false) goto L18;
        if (Internal.equals(this.f9524g, r6.f9524g) == false) goto L18;
        if (this.f9525h.equals(r6.f9525h) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f9523f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.f9524g;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = ((r5 + r3) * 37) + this.f9525h.hashCode();
        this.hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f9523f == null) goto L6;
        r0.append(", recv_id=");
        r0.append(this.f9523f);
    L6:
        if (this.f9524g == null) goto L9;
        r0.append(", time_stamp=");
        r0.append(this.f9524g);
    L9:
        if (this.f9525h.isEmpty() == true) goto L11;
        r0.append(", extra=");
        r0.append(this.f9525h);
    L11:
        StringBuilder r3 = r0.replace(0, 2, "Fin{");
        r3.append('}');
        return r3.toString();
    }
}
