package com.bytedance.android.sdk.bdticketguard.o1.j;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.i0;
import com.bytedance.android.sdk.bdticketguard.p1.k;
import com.bytedance.android.sdk.bdticketguard.s0;
import java.nio.charset.Charset;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import kotlin.a0;
import kotlin.b0;
import kotlin.i0.m0;
import kotlin.m;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class h extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f1002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f1003b = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.o1.j.h$a$a, reason: collision with other inner class name */
        public static final class C0034a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f1004a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f1005b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Throwable f1006c;

            public C0034a(int r2, String r3, Throwable r4) {
                o.g(r3, "errorMsg");
                super(null);
                this.f1004a = r2;
                this.f1005b = r3;
                this.f1006c = r4;
            }

            public /* synthetic */ C0034a(int r1, String r2, Throwable r3, int r4, kotlin.n0.d.g r5) {
                if ((r4 & 4) == 0) goto L5;
                r3 = null;
            L5:
                this(r1, r2, r3);
            }

            public final int a() {
                return this.f1004a;
            }

            public final String b() {
                return this.f1005b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L5;
            L17:
                return true;
            L5:
                if ((r5 instanceof C0034a) == false) goto L16;
                C0034a r6 = (C0034a) r5;
                if (this.f1004a != r6.f1004a) goto L9;
                boolean r1 = true;
            L10:
                if (r1 == false) goto L16;
                if (o.a(this.f1005b, r6.f1005b) == false) goto L16;
                if (o.a(this.f1006c, r6.f1006c) == false) goto L16;
            L9:
                r1 = false;
            L16:
                return false;
            }

            public int hashCode() {
                int r0 = Integer.hashCode(this.f1004a) * 31;
                String r1 = this.f1005b;
                int r2 = 0;
                if (r1 == null) goto L5;
                int r3 = r1.hashCode();
            L6:
                int r4 = (r0 + r3) * 31;
                Throwable r5 = this.f1006c;
                if (r5 == null) goto L10;
                r2 = r5.hashCode();
            L10:
                return r4 + r2;
            L5:
                r3 = 0;
                goto L6
            }

            public String toString() {
                return "Error(errorCode=" + this.f1004a + ", errorMsg=" + this.f1005b + ", exception=" + this.f1006c + ")";
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f1007a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f1008b;

            public final String a() {
                return this.f1008b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L5;
            L15:
                return true;
            L5:
                if ((r5 instanceof b) == false) goto L14;
                b r6 = (b) r5;
                if (this.f1007a != r6.f1007a) goto L9;
                boolean r1 = true;
            L10:
                if (r1 == false) goto L14;
                if (o.a(this.f1008b, r6.f1008b) == false) goto L14;
            L9:
                r1 = false;
            L14:
                return false;
            }

            public int hashCode() {
                int r0 = Integer.hashCode(this.f1007a) * 31;
                String r1 = this.f1008b;
                if (r1 == null) goto L5;
                int r2 = r1.hashCode();
            L7:
                return r0 + r2;
            L5:
                r2 = 0;
                goto L7
            }

            public String toString() {
                return "Success(code=" + this.f1007a + ", result=" + this.f1008b + ")";
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }
    }

    static {
        f1003b = new h();
    }

    private h() {
    }

    private final String k() {
        return k.f1023J.E().b();
    }

    private final boolean n() {
        if (m() == false) goto L16;
        if (Build.VERSION.SDK_INT < 31) goto L16;
        int r3 = d.f.a.b.a.f16653a;     // Catch: Exception -> L17
        if (k.f1023J.B().b().booleanValue() == false) goto L9;
        int r2 = 35;
    L10:
        if (r3 < r2) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L16;
        return true;
    L9:
        r2 = 38;
    L12:
        r4 = false;
    L16:
        return false;
    }

    private final d.f.a.c.a.b o(String r3, String r4) {
        monitor-enter(this);
        new d.f.a.c.a.a();     // Catch: Throwable -> L6 Exception -> L8
    L5:
        throw null;
    L8:
        e = move-exception;
        s0.f1065a.c("HonorAttestationAdapter", "Failed to initialize RiskDetect", e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public i0 a(com.bytedance.android.sdk.bdticketguard.i r10, f r11) {
        o.g(r10, "snapshot");
        o.g(r11, "attestationInfo");
        String r0 = k();
        r10.o(r0);
        String r1 = f1002a;
        if (r1 != null) goto L5;
        String r12 = r11.e() + '#' + r11.c();
        MessageDigest r2 = MessageDigest.getInstance("SHA-256");
        Charset r3 = kotlin.u0.d.f21429a;
        if (r12 == null) goto L19;
        byte[] r13 = r12.getBytes(r3);
        o.b(r13, "(this as java.lang.String).getBytes(charset)");
        String r14 = Base64.encodeToString(r2.digest(r13), 2);
        o.b(r14, "nonceStr");
        a r9 = j(r14, r0);
        if ((r9 instanceof a.b) == false) goto L13;
        a.b r15 = (a.b) r9;
        f1002a = r15.a();
        return new i0("honor", null, m0.e(a0.a("bd-ticket-guard-attest-jws", r15.a())), 2, null);
    L13:
        if ((r9 instanceof a.C0034a) == false) goto L17;
        s0.f1065a.b("HonorAttestationAdapter", "Honor attestation failed");
        a.C0034a r16 = (a.C0034a) r9;
        throw new com.bytedance.android.sdk.bdticketguard.c(r10, r16.a(), r16.b(), null, 8, null);
    L17:
        throw new m();
    L19:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    L5:
        return new i0("honor", null, m0.e(a0.a("bd-ticket-guard-attest-jws", r1)), 2, null);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public KeyStore b() {
        return com.bytedance.android.sdk.bdticketguard.o1.j.a.f969a.b();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public KeyPairGenerator e(KeyGenParameterSpec r1) {
        o.g(r1, "keyGenSpec");
        return com.bytedance.android.sdk.bdticketguard.o1.j.a.f969a.e(r1);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public String f() {
        return "Honor";
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public boolean h() {
        return k.f1023J.t().b().booleanValue();
    }

    public final a j(String r8, String r9) {
        o.g(r8, "nonce");
        o.g(r9, "appId");
        s0.f1065a.e("HonorAttestationAdapter", "Honor attestation start");
        if (n() == true) goto L12;
        String r3 = "Honor risk detect not supported";
        return new a.C0034a(-2201, r3, null, 4, null);
    L12:
        o(r8, r9);     // Catch: Throwable -> L9
        throw null;
    L9:
        th = move-exception;
        return new a.C0034a(-2202, "Init error", th);
    }

    public final boolean l() {
        return n();
    }

    public final boolean m() {
        return kotlin.u0.k.o(Build.MANUFACTURER, "HONOR", true);
    }
}
