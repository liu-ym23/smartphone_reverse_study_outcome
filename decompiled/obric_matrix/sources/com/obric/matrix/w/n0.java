package com.obric.matrix.w;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 extends Message<n0, a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ProtoAdapter<n0> f10427h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse$Phase#ADAPTER", tag = 1)
    @com.google.gson.y.c(TypedValues.CycleType.S_WAVE_PHASE)
    public final b f10428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @com.google.gson.y.c("phaseData")
    public final Map<String, String> f10429g;

    public static final class a extends Message.Builder<n0, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f10430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f10431b;

        public a() {
            this.f10430a = b.f10432g;
            this.f10431b = Internal.newMutableMap();
        }

        public n0 a() {
            return new n0(this.f10430a, this.f10431b, super.buildUnknownFields());
        }

        public a b(b r1) {
            this.f10430a = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.f10431b = r1;
            return this;
        }
    }

    public static final enum b extends Enum<b> implements WireEnum {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f10432g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f10433h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f10434i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ProtoAdapter<b> f10435j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ b[] f10436k = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f10437f;

        private static final class a extends EnumAdapter<b> {
            a() {
                super(b.class);
            }

            protected b a(int r1) {
                return b.a(r1);
            }

            @Override // com.squareup.wire.EnumAdapter
            protected /* bridge */ /* synthetic */ WireEnum fromValue(int r1) {
                return a(r1);
            }
        }

        static {
            b r0 = new b("SYNC_INVOKE", 0, 0);
            f10432g = r0;
            b r1 = new b("ASYNC_CALLBACK", 1, 1);
            f10433h = r1;
            b r3 = new b("URL_REDIRECT", 2, 2);
            f10434i = r3;
            f10436k = new b[]{r0, r1, r3};
            f10435j = new a();
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f10437f = r3;
        }

        public static b a(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return f10434i;
        L12:
            return f10433h;
        L14:
            return f10432g;
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f10436k.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.f10437f;
        }
    }

    private static final class c extends ProtoAdapter<n0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f10438a;

        public c() {
            super(FieldEncoding.LENGTH_DELIMITED, n0.class);
            ProtoAdapter<String> r0 = ProtoAdapter.STRING;
            this.f10438a = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public n0 a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.b(b.f10435j.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f10431b.putAll(this.f10438a.decode(r9));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.a();
        }

        public void b(ProtoWriter r4, n0 r5) {
            b.f10435j.encodeWithTag(r4, 1, r5.f10428f);
            this.f10438a.encodeWithTag(r4, 2, r5.f10429g);
            r4.writeBytes(r5.unknownFields());
        }

        public int c(n0 r4) {
            return (b.f10435j.encodedSizeWithTag(1, r4.f10428f) + this.f10438a.encodedSizeWithTag(2, r4.f10429g)) + r4.unknownFields().size();
        }

        public n0 d(n0 r1) {
            a r0 = r1.b();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ n0 decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, n0 r2) {
            b(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(n0 r1) {
            return c(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ n0 redact(n0 r1) {
            return d(r1);
        }
    }

    static {
        f10427h = new c();
        b r0 = b.f10432g;
    }

    public n0(b r2, Map<String, String> r3, k.h r4) {
        super(f10427h, r4);
        this.f10428f = r2;
        this.f10429g = Internal.immutableCopyOf("phaseData", r3);
    }

    public a b() {
        a r0 = new a();
        r0.f10430a = this.f10428f;
        r0.f10431b = Internal.copyOf("phaseData", this.f10429g);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r6 = (n0) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f10428f, r6.f10428f) == false) goto L16;
        if (this.f10429g.equals(r6.f10429g) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        b r2 = this.f10428f;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.f10429g.hashCode();
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
        if (this.f10428f == null) goto L5;
        r0.append(", phase=");
        r0.append(this.f10428f);
    L5:
        Map<String, String> r1 = this.f10429g;
        if (r1 != null) goto L8;
    L10:
        StringBuilder r3 = r0.replace(0, 2, "StartPicoLinksResponse{");
        r3.append('}');
        return r3.toString();
    L8:
        if (r1.isEmpty() == true) goto L10;
        r0.append(", phaseData=");
        r0.append(this.f10429g);
        goto L10
    }
}
