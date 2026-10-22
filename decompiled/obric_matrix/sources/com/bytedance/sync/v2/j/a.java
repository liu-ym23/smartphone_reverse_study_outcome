package com.bytedance.sync.v2.j;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Message<a, C0193a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ProtoAdapter<a> f6031g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long f6032f;

    /* JADX INFO: renamed from: com.bytedance.sync.v2.j.a$a, reason: collision with other inner class name */
    public static final class C0193a extends Message.Builder<a, C0193a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f6033a;

        public C0193a() {
        }

        public a a() {
            Long r0 = this.f6033a;
            if (r0 == null) goto L7;
            return new a(this.f6033a, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "cursor"});
        }

        public C0193a b(Long r1) {
            this.f6033a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<a> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, a.class);
        }

        public a a(ProtoReader r6) {
            C0193a r5 = new C0193a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.b(ProtoAdapter.INT64.decode(r6));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, a r4) {
            ProtoAdapter.INT64.encodeWithTag(r3, 1, r4.f6032f);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(a r3) {
            return ProtoAdapter.INT64.encodedSizeWithTag(1, r3.f6032f) + r3.unknownFields().size();
        }

        public a d(a r1) {
            C0193a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ a decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, a r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(a r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ a redact(a r1) {
            return d(r1);
        }
    }

    static {
        f6031g = new b();
    }

    public a(Long r2, k.h r3) {
        super(f6031g, r3);
        this.f6032f = r2;
    }

    public C0193a b() {
        C0193a r0 = new C0193a();
        r0.f6033a = this.f6032f;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f6032f.equals(r6.f6032f) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f6032f.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
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
        r0.append(this.f6032f);
        StringBuilder r3 = r0.replace(0, 2, "BsyncCursor{");
        r3.append('}');
        return r3.toString();
    }
}
