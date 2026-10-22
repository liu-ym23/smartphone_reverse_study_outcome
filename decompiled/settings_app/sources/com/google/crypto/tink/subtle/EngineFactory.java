package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.EngineWrapper;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes4.dex */
public final class EngineFactory<T_WRAPPER extends EngineWrapper<JcePrimitiveT>, JcePrimitiveT> {
    public static final EngineFactory<EngineWrapper.TCipher, Cipher> CIPHER = null;
    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> KEY_AGREEMENT = null;
    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> KEY_FACTORY = null;
    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> KEY_PAIR_GENERATOR = null;
    public static final EngineFactory<EngineWrapper.TMac, Mac> MAC = null;
    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> MESSAGE_DIGEST = null;
    public static final EngineFactory<EngineWrapper.TSignature, Signature> SIGNATURE = null;
    private final Policy<JcePrimitiveT> policy;

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.EngineFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AndroidPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        /* synthetic */ AndroidPolicy(EngineWrapper r1, AnonymousClass1 r2) {
            this(r1);
        }

        private AndroidPolicy(EngineWrapper<JcePrimitiveT> jceFactory) {
            this.jceFactory = jceFactory;
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String algorithm) throws GeneralSecurityException {
            Iterator<Provider> r0 = EngineFactory.toProviderList(new String[]{"GmsCore_OpenSSL", "AndroidOpenSSL"}).iterator();
            Exception r2 = null;
        L4:
            if (r0.hasNext() == false) goto L12;
            return this.jceFactory.getInstance(algorithm, r0.next());
        L8:
            e = move-exception;
            if (r2 != null) goto L4;
            r2 = e;
            goto L4
        L12:
            return this.jceFactory.getInstance(algorithm, null);
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String algorithm, List<Provider> preferredProviders) throws GeneralSecurityException {
            return getInstance(algorithm);
        }
    }

    private static class DefaultPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        /* synthetic */ DefaultPolicy(EngineWrapper r1, AnonymousClass1 r2) {
            this(r1);
        }

        private DefaultPolicy(EngineWrapper<JcePrimitiveT> jceFactory) {
            this.jceFactory = jceFactory;
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String algorithm) throws GeneralSecurityException {
            return this.jceFactory.getInstance(algorithm, null);
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String algorithm, List<Provider> preferredProviders) throws GeneralSecurityException {
            Iterator<Provider> r4 = preferredProviders.iterator();
        L4:
            if (r4.hasNext() == false) goto L9;
            Provider r0 = r4.next();
            return this.jceFactory.getInstance(algorithm, r0);
        L9:
            return this.getInstance(algorithm);
        }
    }

    private static class FipsPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        /* synthetic */ FipsPolicy(EngineWrapper r1, AnonymousClass1 r2) {
            this(r1);
        }

        private FipsPolicy(EngineWrapper<JcePrimitiveT> jceFactory) {
            this.jceFactory = jceFactory;
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String algorithm) throws GeneralSecurityException {
            Iterator<Provider> r0 = EngineFactory.toProviderList(new String[]{"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"}).iterator();
            Exception r1 = null;
        L4:
            if (r0.hasNext() == false) goto L12;
            Provider r2 = r0.next();
            return this.jceFactory.getInstance(algorithm, r2);
        L8:
            e = move-exception;
            if (r1 != null) goto L4;
            r1 = e;
            goto L4
        L12:
            throw new GeneralSecurityException("No good Provider found.", r1);
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String algorithm, List<Provider> preferredProviders) throws GeneralSecurityException {
            return getInstance(algorithm);
        }
    }

    private interface Policy<JcePrimitiveT> {
        JcePrimitiveT getInstance(String algorithm) throws GeneralSecurityException;

        JcePrimitiveT getInstance(String algorithm, List<Provider> preferredProviders) throws GeneralSecurityException;
    }

    static {
        CIPHER = new EngineFactory(new EngineWrapper.TCipher());
        MAC = new EngineFactory(new EngineWrapper.TMac());
        SIGNATURE = new EngineFactory(new EngineWrapper.TSignature());
        MESSAGE_DIGEST = new EngineFactory(new EngineWrapper.TMessageDigest());
        KEY_AGREEMENT = new EngineFactory(new EngineWrapper.TKeyAgreement());
        KEY_PAIR_GENERATOR = new EngineFactory(new EngineWrapper.TKeyPairGenerator());
        KEY_FACTORY = new EngineFactory(new EngineWrapper.TKeyFactory());
    }

    public static List<Provider> toProviderList(String... providerNames) {
        ArrayList r0 = new ArrayList();
        int r1 = providerNames.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Provider r3 = Security.getProvider(providerNames[r2]);
        if (r3 == null) goto L7;
        r0.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    public EngineFactory(T_WRAPPER instanceBuilder) {
        AnonymousClass1 r1 = null;
        if (TinkFipsUtil.useOnlyFips() == false) goto L6;
        this.policy = new FipsPolicy(instanceBuilder, r1);
        return;
    L6:
        if (SubtleUtil.isAndroid() == false) goto L8;
        this.policy = new AndroidPolicy(instanceBuilder, r1);
        return;
    L8:
        this.policy = new DefaultPolicy(instanceBuilder, r1);
    }

    public JcePrimitiveT getInstance(String algorithm) throws GeneralSecurityException {
        return this.policy.getInstance(algorithm);
    }

    JcePrimitiveT getInstance(String algorithm, List<Provider> preferredProviders) throws GeneralSecurityException {
        return this.policy.getInstance(algorithm, preferredProviders);
    }
}
