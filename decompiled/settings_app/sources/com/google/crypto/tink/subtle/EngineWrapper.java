package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes4.dex */
public interface EngineWrapper<T> {

    public static class TCipher implements EngineWrapper<Cipher> {
        public TCipher() {
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public /* bridge */ /* synthetic */ Cipher getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            return getInstance2(algorithm, provider);
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* JADX INFO: renamed from: getInstance, reason: avoid collision after fix types in other method */
        public Cipher getInstance2(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider != null) goto L6;
            return Cipher.getInstance(algorithm);
        L6:
            return Cipher.getInstance(algorithm, provider);
        }
    }

    public static class TKeyAgreement implements EngineWrapper<KeyAgreement> {
        public TKeyAgreement() {
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public /* bridge */ /* synthetic */ KeyAgreement getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            return getInstance2(algorithm, provider);
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* JADX INFO: renamed from: getInstance, reason: avoid collision after fix types in other method */
        public KeyAgreement getInstance2(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider != null) goto L6;
            return KeyAgreement.getInstance(algorithm);
        L6:
            return KeyAgreement.getInstance(algorithm, provider);
        }
    }

    public static class TKeyFactory implements EngineWrapper<KeyFactory> {
        public TKeyFactory() {
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public /* bridge */ /* synthetic */ KeyFactory getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            return getInstance2(algorithm, provider);
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* JADX INFO: renamed from: getInstance, reason: avoid collision after fix types in other method */
        public KeyFactory getInstance2(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider != null) goto L6;
            return KeyFactory.getInstance(algorithm);
        L6:
            return KeyFactory.getInstance(algorithm, provider);
        }
    }

    public static class TKeyPairGenerator implements EngineWrapper<KeyPairGenerator> {
        public TKeyPairGenerator() {
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public /* bridge */ /* synthetic */ KeyPairGenerator getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            return getInstance2(algorithm, provider);
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* JADX INFO: renamed from: getInstance, reason: avoid collision after fix types in other method */
        public KeyPairGenerator getInstance2(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider != null) goto L6;
            return KeyPairGenerator.getInstance(algorithm);
        L6:
            return KeyPairGenerator.getInstance(algorithm, provider);
        }
    }

    public static class TMac implements EngineWrapper<Mac> {
        public TMac() {
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public /* bridge */ /* synthetic */ Mac getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            return getInstance2(algorithm, provider);
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* JADX INFO: renamed from: getInstance, reason: avoid collision after fix types in other method */
        public Mac getInstance2(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider != null) goto L6;
            return Mac.getInstance(algorithm);
        L6:
            return Mac.getInstance(algorithm, provider);
        }
    }

    public static class TMessageDigest implements EngineWrapper<MessageDigest> {
        public TMessageDigest() {
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public /* bridge */ /* synthetic */ MessageDigest getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            return getInstance2(algorithm, provider);
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* JADX INFO: renamed from: getInstance, reason: avoid collision after fix types in other method */
        public MessageDigest getInstance2(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider != null) goto L6;
            return MessageDigest.getInstance(algorithm);
        L6:
            return MessageDigest.getInstance(algorithm, provider);
        }
    }

    public static class TSignature implements EngineWrapper<Signature> {
        public TSignature() {
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public /* bridge */ /* synthetic */ Signature getInstance(String algorithm, Provider provider) throws GeneralSecurityException {
            return getInstance2(algorithm, provider);
        }

        @Override // com.google.crypto.tink.subtle.EngineWrapper
        /* JADX INFO: renamed from: getInstance, reason: avoid collision after fix types in other method */
        public Signature getInstance2(String algorithm, Provider provider) throws GeneralSecurityException {
            if (provider != null) goto L6;
            return Signature.getInstance(algorithm);
        L6:
            return Signature.getInstance(algorithm, provider);
        }
    }

    T getInstance(String algorithm, Provider provider) throws GeneralSecurityException;
}
