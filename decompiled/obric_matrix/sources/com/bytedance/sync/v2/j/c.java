package com.bytedance.sync.v2.j;

import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c extends Message<c, a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ProtoAdapter<c> f6048k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.BsyncCursor#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final com.bytedance.sync.v2.j.a f6049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.BsyncPayload#ADAPTER", tag = 2)
    public final d f6050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.PacketStatus#ADAPTER", tag = 3)
    public final n f6051h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 255)
    public final Long f6052i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 256)
    public final Map<String, String> f6053j;

    public static final class a extends Message.Builder<c, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.bytedance.sync.v2.j.a f6054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f6055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public n f6056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f6057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f6058e;

        public a() {
            this.f6058e = Internal.newMutableMap();
        }

        public c a() {
            com.bytedance.sync.v2.j.a r0 = this.f6054a;
            if (r0 == null) goto L7;
            return new c(this.f6054a, this.f6055b, this.f6056c, this.f6057d, this.f6058e, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "cursor"});
        }

        public a b(com.bytedance.sync.v2.j.a r1) {
            this.f6054a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.f6058e = r1;
            return this;
        }

        public a d(d r1) {
            this.f6055b = r1;
            return this;
        }

        public a e(n r1) {
            this.f6056c = r1;
            return this;
        }

        public a f(Long r1) {
            this.f6057d = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f6059a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, c.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f6059a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public c a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.b(com.bytedance.sync.v2.j.a.f6031g.decode(r9));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.d(d.f6060j.decode(r9));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.e(n.f6125i.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 255) goto L14;
            r0.f(ProtoAdapter.INT64.decode(r9));
            goto L3
        L14:
            if (r3 != 256) goto L15;
            r0.f6058e.putAll(this.f6059a.decode(r9));
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r4, c r5) {
            com.bytedance.sync.v2.j.a.f6031g.encodeWithTag(r4, 1, r5.f6049f);
            d.f6060j.encodeWithTag(r4, 2, r5.f6050g);
            n.f6125i.encodeWithTag(r4, 3, r5.f6051h);
            ProtoAdapter.INT64.encodeWithTag(r4, 255, r5.f6052i);
            this.f6059a.encodeWithTag(r4, 256, r5.f6053j);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(c r5) {
            return ((((com.bytedance.sync.v2.j.a.f6031g.encodedSizeWithTag(1, r5.f6049f) + d.f6060j.encodedSizeWithTag(2, r5.f6050g)) + n.f6125i.encodedSizeWithTag(3, r5.f6051h)) + ProtoAdapter.INT64.encodedSizeWithTag(255, r5.f6052i)) + this.f6059a.encodedSizeWithTag(256, r5.f6053j)) + r5.unknownFields().size();
        }

        public c d(c r2) {
            a r1 = r2.b();
            r1.f6054a = com.bytedance.sync.v2.j.a.f6031g.redact(r1.f6054a);
            d r3 = r1.f6055b;
            if (r3 == null) goto L5;
            r1.f6055b = d.f6060j.redact(r3);
        L5:
            r1.clearUnknownFields();
            return r1.a();
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
        f6048k = new b();
        n r0 = n.f6123g;
    }

    public c(com.bytedance.sync.v2.j.a r2, d r3, n r4, Long r5, Map<String, String> r6, k.h r7) {
        super(f6048k, r7);
        this.f6049f = r2;
        this.f6050g = r3;
        this.f6051h = r4;
        this.f6052i = r5;
        this.f6053j = Internal.immutableCopyOf(WsConstants.KEY_EXTRA, r6);
    }

    public a b() {
        a r0 = new a();
        r0.f6054a = this.f6049f;
        r0.f6055b = this.f6050g;
        r0.f6056c = this.f6051h;
        r0.f6057d = this.f6052i;
        r0.f6058e = Internal.copyOf(WsConstants.KEY_EXTRA, this.f6053j);
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
        if (unknownFields().equals(r6.unknownFields()) == false) goto L22;
        if (this.f6049f.equals(r6.f6049f) == false) goto L22;
        if (Internal.equals(this.f6050g, r6.f6050g) == false) goto L22;
        if (Internal.equals(this.f6051h, r6.f6051h) == false) goto L22;
        if (Internal.equals(this.f6052i, r6.f6052i) == false) goto L22;
        if (this.f6053j.equals(r6.f6053j) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = ((unknownFields().hashCode() * 37) + this.f6049f.hashCode()) * 37;
        d r2 = this.f6050g;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        n r6 = this.f6051h;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.f6052i;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((r8 + r3) * 37) + this.f6053j.hashCode();
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
        r0.append(", cursor=");
        r0.append(this.f6049f);
        if (this.f6050g == null) goto L6;
        r0.append(", payload=");
        r0.append(this.f6050g);
    L6:
        if (this.f6051h == null) goto L9;
        r0.append(", status=");
        r0.append(this.f6051h);
    L9:
        if (this.f6052i == null) goto L12;
        r0.append(", ts=");
        r0.append(this.f6052i);
    L12:
        if (this.f6053j.isEmpty() == true) goto L14;
        r0.append(", extra=");
        r0.append(this.f6053j);
    L14:
        StringBuilder r3 = r0.replace(0, 2, "BsyncPacket{");
        r3.append('}');
        return r3.toString();
    }
}
