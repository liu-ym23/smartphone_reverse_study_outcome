package com.bytedance.android.sdk.bdticketguard.o1.j;

import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.android.sdk.bdticketguard.i0;
import com.bytedance.android.sdk.bdticketguard.s0;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.interfaces.ECPublicKey;
import kotlin.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    static {
    }

    public g() {
    }

    public i0 a(com.bytedance.android.sdk.bdticketguard.i r1, f r2) {
        o.g(r1, "snapshot");
        o.g(r2, "attestationInfo");
        return null;
    }

    public abstract KeyStore b();

    protected final KeyStore c() {
        return b();
    L4:
        th = move-exception;
        s0.f1065a.c("BaseAttestationAdapter", "getKeyStoreOrNull error", th);
        return null;
    }

    public final String d() {
        KeyStore r4 = c();
        if (r4 != null) goto L13;
    L12:
        return "";
    L13:
        Certificate r5 = r4.getCertificate("bd_ticket_guard_key_attestation");     // Catch: Throwable -> L10
        o.b(r5, "it.getCertificate(KEY_ALIAS_FOR_ATTESTATION)");     // Catch: Throwable -> L10
        PublicKey r6 = r5.getPublicKey();     // Catch: Throwable -> L10
        com.bytedance.android.sdk.bdticketguard.o1.i.a r1 = com.bytedance.android.sdk.bdticketguard.o1.i.f965e;     // Catch: Throwable -> L10
        if (r6 == null) goto L9;
        return r1.b((ECPublicKey) r6, 2);
    L9:
        throw new b0("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        s0.f1065a.c("BaseAttestationAdapter", "getAttestationPubKey error", th);
        goto L12
    }

    public abstract KeyPairGenerator e(KeyGenParameterSpec r1);

    public abstract String f();

    public boolean g() {
        return true;
    }

    public boolean h() {
        return false;
    }

    public byte[] i(byte[] r5) {
        o.g(r5, "data");
        KeyStore r4 = c();
        byte[] r0 = null;
        Throwable r1 = null;
        r0 = null;
        if (r4 != null) goto L22;
    L21:
        return r0;
    L22:
        Key r6 = r4.getKey("bd_ticket_guard_key_attestation", null);     // Catch: Exception -> L19
        if (r6 == null) goto L18;
        PrivateKey r7 = (PrivateKey) r6;     // Catch: Exception -> L19
        int r2 = 0;
        Exception e2 = null;
    L8:
        if (r2 >= 3) goto L13;
        Signature r3 = Signature.getInstance("SHA256withECDSA");     // Catch: Exception -> L11
        r3.initSign(r7);     // Catch: Exception -> L11
        r3.update(r5);     // Catch: Exception -> L11
        r0 = r3.sign();     // Catch: Exception -> L11
    L11:
        e2 = e;
        r2 = r2 + 1;
        goto L8
    L13:
        if (e2 != null) goto L16;
        o.p();     // Catch: Exception -> L19
        throw r1;
    L16:
        throw e2;     // Catch: Exception -> L19
    L18:
        throw new b0("null cannot be cast to non-null type java.security.PrivateKey");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        s0.f1065a.c("BaseAttestationAdapter", "signWithAttestKey error after max retries", e);
        goto L21
    }
}
