package com.obric.matrix.w;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends Message<m, a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ProtoAdapter<m> f10409f = null;

    public static final class a extends Message.Builder<m, a> {
        public a() {
        }

        public m a() {
            return new m(super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<m> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, m.class);
        }

        public m a(ProtoReader r6) {
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

        public void b(ProtoWriter r1, m r2) {
            r1.writeBytes(r2.unknownFields());
        }

        public int c(m r1) {
            return r1.unknownFields().size();
        }

        public m d(m r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ m decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, m r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(m r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ m redact(m r1) {
            return d(r1);
        }
    }

    static {
        f10409f = new b();
    }

    public m() {
        this(k.h.f18266i);
    }

    public m(k.h r2) {
        super(f10409f, r2);
    }

    public a b() {
        a r0 = new a();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r1) {
        return r1 instanceof m;
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
        StringBuilder r3 = new StringBuilder().replace(0, 2, "GetTTNetParametersRequest{");
        r3.append('}');
        return r3.toString();
    }
}
