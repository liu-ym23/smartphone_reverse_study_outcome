package com.bytedance.sync.v2.j;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e extends Message<e, a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ProtoAdapter<e> f6069h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.BsyncHeader#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final com.bytedance.sync.v2.j.b f6070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.bytedance.sync.v2.protocal.BsyncTopic#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<f> f6071g;

    public static final class a extends Message.Builder<e, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.bytedance.sync.v2.j.b f6072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<f> f6073b;

        public a() {
            this.f6073b = Internal.newMutableList();
        }

        public e a() {
            com.bytedance.sync.v2.j.b r0 = this.f6072a;
            if (r0 == null) goto L7;
            return new e(this.f6072a, this.f6073b, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "header"});
        }

        public a b(com.bytedance.sync.v2.j.b r1) {
            this.f6072a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(List<f> r1) {
            Internal.checkElementsNotNull(r1);
            this.f6073b = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<e> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, e.class);
        }

        public e a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.b(com.bytedance.sync.v2.j.b.f6034l.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.f6073b.add(f.p.decode(r6));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r3, e r4) {
            com.bytedance.sync.v2.j.b.f6034l.encodeWithTag(r3, 1, r4.f6070f);
            f.p.asRepeated().encodeWithTag(r3, 2, r4.f6071g);
            r3.writeBytes(r4.unknownFields());
        }

        public int c(e r4) {
            return (com.bytedance.sync.v2.j.b.f6034l.encodedSizeWithTag(1, r4.f6070f) + f.p.asRepeated().encodedSizeWithTag(2, r4.f6071g)) + r4.unknownFields().size();
        }

        public e d(e r2) {
            a r1 = r2.b();
            r1.f6072a = com.bytedance.sync.v2.j.b.f6034l.redact(r1.f6072a);
            Internal.redactElements(r1.f6073b, f.p);
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ e decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, e r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(e r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ e redact(e r1) {
            return d(r1);
        }
    }

    static {
        f6069h = new b();
    }

    public e(com.bytedance.sync.v2.j.b r2, List<f> r3, k.h r4) {
        super(f6069h, r4);
        this.f6070f = r2;
        this.f6071g = Internal.immutableCopyOf("topics", r3);
    }

    public a b() {
        a r0 = new a();
        r0.f6072a = this.f6070f;
        r0.f6073b = Internal.copyOf("topics", this.f6071g);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (this.f6070f.equals(r6.f6070f) == false) goto L16;
        if (this.f6071g.equals(r6.f6071g) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((unknownFields().hashCode() * 37) + this.f6070f.hashCode()) * 37) + this.f6071g.hashCode();
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
        r0.append(", header=");
        r0.append(this.f6070f);
        if (this.f6071g.isEmpty() == true) goto L5;
        r0.append(", topics=");
        r0.append(this.f6071g);
    L5:
        StringBuilder r3 = r0.replace(0, 2, "BsyncProtocol{");
        r3.append('}');
        return r3.toString();
    }
}
