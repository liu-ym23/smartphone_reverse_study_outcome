package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends Message<w, a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ProtoAdapter<w> f10566h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @com.google.gson.y.c("callbackId")
    public final Integer f10567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("callbackData")
    public final Map<String, String> f10568g;

    public static final class a extends Message.Builder<w, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f10569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f10570b;

        public a() {
            this.f10569a = 0;
            this.f10570b = Internal.newMutableMap();
        }

        public w a() {
            return new w(this.f10569a, this.f10570b, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.f10569a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<w> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10571a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, w.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10571a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public w a(ProtoReader r7) {
            a r0 = new a();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.b(ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f10570b.putAll(this.f10571a.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r4, w r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.f10567f);
            this.f10571a.encodeWithTag(r4, 2, r5.f10568g);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(w r4) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r4.f10567f) + this.f10571a.encodedSizeWithTag(2, r4.f10568g)) + r4.unknownFields().size();
        }

        public w d(w r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ w decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, w r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(w r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ w redact(w r1) {
            return d(r1);
        }
    }

    static {
        f10566h = new b();
    }

    public w(Integer r2, Map<String, String> r3, k.h r4) {
        super(f10566h, r4);
        this.f10567f = r2;
        this.f10568g = Internal.immutableCopyOf("callbackData", r3);
    }

    public a b() {
        a r0 = new a();
        r0.f10569a = this.f10567f;
        r0.f10570b = Internal.copyOf("callbackData", this.f10568g);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f10567f, r6.f10567f) == false) goto L16;
        if (this.f10568g.equals(r6.f10568g) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f10567f;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.f10568g.hashCode();
        this.hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f10567f == null) goto L5;
        r0.append(", callbackId=");
        r0.append(this.f10567f);
    L5:
        Map<String, String> r1 = this.f10568g;
        if (r1 != null) goto L8;
    L10:
        StringBuilder r3 = r0.replace(0, 2, "PicoLinksCallback{");
        r3.append('}');
        return r3.toString();
    L8:
        if (r1.isEmpty() == true) goto L10;
        r0.append(", callbackData=");
        r0.append(this.f10568g);
        goto L10
    }
}
