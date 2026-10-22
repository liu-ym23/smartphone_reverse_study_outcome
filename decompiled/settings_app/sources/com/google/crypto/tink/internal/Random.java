package com.google.crypto.tink.internal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes4.dex */
public final class Random {
    private static final ThreadLocal<SecureRandom> localRandom = null;

    static /* synthetic */ SecureRandom access$000() {
        return newDefaultSecureRandom();
    }

    static {
        localRandom = new AnonymousClass1();
    }

    private static Provider getConscryptProviderWithReflection() throws GeneralSecurityException {
        return (Provider) Class.forName("org.conscrypt.Conscrypt").getMethod("newProvider", new Class[0]).invoke(null, new Object[0]);
    L4:
        e = move-exception;
        throw new GeneralSecurityException("Failed to get Conscrypt provider", e);
    }

    private static SecureRandom create() {
        return SecureRandom.getInstance("SHA1PRNG", "GmsCore_OpenSSL");
    L5:
        return SecureRandom.getInstance("SHA1PRNG", "AndroidOpenSSL");
    L7:
        return SecureRandom.getInstance("SHA1PRNG", "Conscrypt");
    L9:
        return SecureRandom.getInstance("SHA1PRNG", getConscryptProviderWithReflection());
    L12:
        return new SecureRandom();
    }

    private static SecureRandom newDefaultSecureRandom() {
        SecureRandom r0 = create();
        r0.nextLong();
        return r0;
    }

    public static byte[] randBytes(int size) {
        byte[] r1 = new byte[size];
        localRandom.get().nextBytes(r1);
        return r1;
    }

    public static final int randInt(int max) {
        return localRandom.get().nextInt(max);
    }

    public static final int randInt() {
        return localRandom.get().nextInt();
    }

    public static final void validateUsesConscrypt() throws GeneralSecurityException {
        String r0 = localRandom.get().getProvider().getName();
        if (r0.equals("GmsCore_OpenSSL") == false) goto L5;
        return;
    L5:
        if (r0.equals("AndroidOpenSSL") == false) goto L7;
        return;
    L7:
        if (r0.equals("Conscrypt") == false) goto L10;
        return;
    L10:
        throw new GeneralSecurityException("Requires GmsCore_OpenSSL, AndroidOpenSSL or Conscrypt to generate randomness, but got " + r0);
    }

    private Random() {
    }
}
