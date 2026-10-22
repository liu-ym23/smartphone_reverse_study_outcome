package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends Message<j0, a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ProtoAdapter<j0> f10396f = null;

    public static final class a extends Message.Builder<j0, a> {
        public a() {
        }

        public j0 a() {
            return new j0(super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<j0> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, j0.class);
        }

        public j0 a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L6;
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L6:
            r6.endMessage(r0);
            return r5.a();
        }

        public void b(ProtoWriter r1, j0 r2) {
            r1.writeBytes(r2.unknownFields());
        }

        public int c(j0 r1) {
            return r1.unknownFields().size();
        }

        public j0 d(j0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ j0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, j0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(j0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ j0 redact(j0 r1) {
            return d(r1);
        }
    }

    static {
        f10396f = new b();
    }

    public j0() {
        this(k.h.f18266i);
    }

    public j0(k.h r2) {
        super(f10396f, r2);
    }

    public a b() {
        a r0 = new a();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r1) {
        return r1 instanceof j0;
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return b();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r3 = new StringBuilder().replace(0, 2, "SendApplogEventResponse{");
        r3.append('}');
        return r3.toString();
    }
}
