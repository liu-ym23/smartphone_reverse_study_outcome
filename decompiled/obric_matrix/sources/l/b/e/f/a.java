package l.b.e.f;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.List;
import l.b.a.c1;
import l.b.a.f;
import l.b.a.p0;
import l.b.a.u;
import l.b.e.c;
import l.b.e.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l.b.e.f.b f21888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SecureRandom f21889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l.b.a.v2.a f21890c;

    /* JADX INFO: renamed from: l.b.e.f.a$a, reason: collision with other inner class name */
    class C0595a implements l.b.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private OutputStream f21891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Signature f21892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l.b.a.v2.a f21893c;

        C0595a(a r1, Signature r2, l.b.a.v2.a r3) {
            this.f21892b = r2;
            this.f21893c = r3;
            this.f21891a = l.b.c.b.a.a(r2);
        }

        @Override // l.b.e.a
        public byte[] a() {
            return this.f21892b.sign();
        L4:
            e = move-exception;
            throw new e("exception obtaining signature: " + e.getMessage(), e);
        }

        @Override // l.b.e.a
        public OutputStream b() {
            return this.f21891a;
        }

        @Override // l.b.e.a
        public l.b.a.v2.a c() {
            return this.f21893c;
        }
    }

    class b implements l.b.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        OutputStream f21894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OutputStream f21895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Signature[] f21896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f21897d;

        b(a r1, OutputStream r2, Signature[] r3) {
            this.f21897d = r1;
            this.f21895b = r2;
            this.f21896c = r3;
            this.f21894a = r2;
        }

        @Override // l.b.e.a
        public byte[] a() {
            f r0 = new f();     // Catch: SignatureException -> L8 IOException -> L11
            int r1 = 0;
        L4:
            if (r1 == this.f21896c.length) goto L6;
            r0.a(new p0(this.f21896c[r1].sign()));     // Catch: SignatureException -> L8 IOException -> L11
            r1 = r1 + 1;     // Catch: SignatureException -> L8 IOException -> L11
            goto L4
        L6:
            return new c1(r0).m("DER");
        L11:
            e = move-exception;
            throw new e("exception encoding signature: " + e.getMessage(), e);
        L8:
            e = move-exception;
            throw new e("exception obtaining signature: " + e.getMessage(), e);
        }

        @Override // l.b.e.a
        public OutputStream b() {
            return this.f21894a;
        }

        @Override // l.b.e.a
        public l.b.a.v2.a c() {
            return a.a(this.f21897d);
        }
    }

    public a(String r3) {
        this.f21888a = new l.b.e.f.b(new l.b.c.d.a());
        this.f21890c = new l.b.e.b().b(r3);
    }

    static /* synthetic */ l.b.a.v2.a a(a r0) {
        return r0.f21890c;
    }

    private l.b.e.a c(l.b.c.a r9) {
        List<PrivateKey> r10 = r9.a();     // Catch: GeneralSecurityException -> L15
        u r0 = u.w(this.f21890c.q());     // Catch: GeneralSecurityException -> L15
        int r1 = r0.size();     // Catch: GeneralSecurityException -> L15
        Signature[] r2 = new Signature[r1];     // Catch: GeneralSecurityException -> L15
        int r4 = 0;
    L4:
        if (r4 == r0.size()) goto L10;
        r2[r4] = this.f21888a.b(l.b.a.v2.a.o(r0.y(r4)));     // Catch: GeneralSecurityException -> L15
        if (this.f21889b == null) goto L8;
        r2[r4].initSign(r10.get(r4), this.f21889b);     // Catch: GeneralSecurityException -> L15
    L9:
        r4 = r4 + 1;     // Catch: GeneralSecurityException -> L15
        goto L4
    L8:
        r2[r4].initSign(r10.get(r4));     // Catch: GeneralSecurityException -> L15
        goto L9
    L10:
        OutputStream r11 = l.b.c.b.a.a(r2[0]);     // Catch: GeneralSecurityException -> L15
        int r3 = 1;
    L11:
        if (r3 == r1) goto L13;
        l.b.h.i.b r5 = new l.b.h.i.b(r11, l.b.c.b.a.a(r2[r3]));     // Catch: GeneralSecurityException -> L15
        r3 = r3 + 1;     // Catch: GeneralSecurityException -> L15
        r11 = r5;
        goto L11
    L13:
        return new b(this, r11, r2);
    L15:
        e = move-exception;
        throw new c("cannot create signer: " + e.getMessage(), e);
    }

    public l.b.e.a b(PrivateKey r4) {
        if ((r4 instanceof l.b.c.a) == true) goto L5;
        Signature r0 = this.f21888a.b(this.f21890c);     // Catch: GeneralSecurityException -> L12
        l.b.a.v2.a r1 = this.f21890c;     // Catch: GeneralSecurityException -> L12
        SecureRandom r2 = this.f21889b;     // Catch: GeneralSecurityException -> L12
        if (r2 == null) goto L9;
        r0.initSign(r4, r2);     // Catch: GeneralSecurityException -> L12
    L10:
        return new C0595a(this, r0, r1);
    L9:
        r0.initSign(r4);     // Catch: GeneralSecurityException -> L12
    L12:
        e = move-exception;
        throw new c("cannot create signer: " + e.getMessage(), e);
    L5:
        return c((l.b.c.a) r4);
    }
}
