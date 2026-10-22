package cz.msebera.android.httpclient.ssl;

import cz.msebera.android.httpclient.util.Args;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes5.dex */
public class SSLContextBuilder {
    static final String TLS = "TLS";
    private String keyManagerFactoryAlgorithm;
    private final Set<KeyManager> keyManagers;
    private String keyStoreType;
    private String protocol;
    private Provider provider;
    private SecureRandom secureRandom;
    private String trustManagerFactoryAlgorithm;
    private final Set<TrustManager> trustManagers;

    static class KeyManagerDelegate extends X509ExtendedKeyManager {
        private final PrivateKeyStrategy aliasStrategy;
        private final X509ExtendedKeyManager keyManager;

        KeyManagerDelegate(X509ExtendedKeyManager r1, PrivateKeyStrategy r2) {
            this.keyManager = r1;
            this.aliasStrategy = r2;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getClientAliases(String r1, Principal[] r2) {
            return this.keyManager.getClientAliases(r1, r2);
        }

        public Map<String, PrivateKeyDetails> getClientAliasMap(String[] r12, Principal[] r13) {
            HashMap r0 = new HashMap();
            int r1 = r12.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L10;
            String r4 = r12[r3];
            String[] r5 = this.keyManager.getClientAliases(r4, r13);
            if (r5 == null) goto L9;
            int r6 = r5.length;
            int r7 = 0;
        L7:
            if (r7 >= r6) goto L9;
            String r8 = r5[r7];
            r0.put(r8, new PrivateKeyDetails(r4, this.keyManager.getCertificateChain(r8)));
            r7 = r7 + 1;
        L9:
            r3 = r3 + 1;
            goto L3
        L10:
            return r0;
        }

        public Map<String, PrivateKeyDetails> getServerAliasMap(String r7, Principal[] r8) {
            HashMap r0 = new HashMap();
            String[] r9 = this.keyManager.getServerAliases(r7, r8);
            if (r9 == null) goto L7;
            int r1 = r9.length;
            int r2 = 0;
        L5:
            if (r2 >= r1) goto L7;
            String r3 = r9[r2];
            r0.put(r3, new PrivateKeyDetails(r7, this.keyManager.getCertificateChain(r3)));
            r2 = r2 + 1;
        L7:
            return r0;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseClientAlias(String[] r1, Principal[] r2, Socket r3) {
            Map<String, PrivateKeyDetails> r4 = getClientAliasMap(r1, r2);
            return this.aliasStrategy.chooseAlias(r4, r3);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getServerAliases(String r1, Principal[] r2) {
            return this.keyManager.getServerAliases(r1, r2);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseServerAlias(String r1, Principal[] r2, Socket r3) {
            Map<String, PrivateKeyDetails> r4 = getServerAliasMap(r1, r2);
            return this.aliasStrategy.chooseAlias(r4, r3);
        }

        @Override // javax.net.ssl.X509KeyManager
        public X509Certificate[] getCertificateChain(String r1) {
            return this.keyManager.getCertificateChain(r1);
        }

        @Override // javax.net.ssl.X509KeyManager
        public PrivateKey getPrivateKey(String r1) {
            return this.keyManager.getPrivateKey(r1);
        }

        @Override // javax.net.ssl.X509ExtendedKeyManager
        public String chooseEngineClientAlias(String[] r1, Principal[] r2, SSLEngine r3) {
            Map<String, PrivateKeyDetails> r4 = getClientAliasMap(r1, r2);
            return this.aliasStrategy.chooseAlias(r4, null);
        }

        @Override // javax.net.ssl.X509ExtendedKeyManager
        public String chooseEngineServerAlias(String r1, Principal[] r2, SSLEngine r3) {
            Map<String, PrivateKeyDetails> r4 = getServerAliasMap(r1, r2);
            return this.aliasStrategy.chooseAlias(r4, null);
        }
    }

    static class TrustManagerDelegate implements X509TrustManager {
        private final X509TrustManager trustManager;
        private final TrustStrategy trustStrategy;

        TrustManagerDelegate(X509TrustManager r1, TrustStrategy r2) {
            this.trustManager = r1;
            this.trustStrategy = r2;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] r1, String r2) throws CertificateException {
            this.trustManager.checkClientTrusted(r1, r2);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] r2, String r3) throws CertificateException {
            if (this.trustStrategy.isTrusted(r2, r3) == true) goto L6;
            this.trustManager.checkServerTrusted(r2, r3);
            return;
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.trustManager.getAcceptedIssuers();
        }
    }

    public static SSLContextBuilder create() {
        return new SSLContextBuilder();
    }

    public SSLContextBuilder() {
        this.keyManagerFactoryAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        this.keyStoreType = KeyStore.getDefaultType();
        this.trustManagerFactoryAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        this.keyManagers = new LinkedHashSet();
        this.trustManagers = new LinkedHashSet();
    }

    @Deprecated
    public SSLContextBuilder useProtocol(String r1) {
        this.protocol = r1;
        return this;
    }

    public SSLContextBuilder setProtocol(String r1) {
        this.protocol = r1;
        return this;
    }

    public SSLContextBuilder setSecureRandom(SecureRandom r1) {
        this.secureRandom = r1;
        return this;
    }

    public SSLContextBuilder setProvider(Provider r1) {
        this.provider = r1;
        return this;
    }

    public SSLContextBuilder setProvider(String r1) {
        this.provider = Security.getProvider(r1);
        return this;
    }

    public SSLContextBuilder setKeyStoreType(String r1) {
        this.keyStoreType = r1;
        return this;
    }

    public SSLContextBuilder setKeyManagerFactoryAlgorithm(String r1) {
        this.keyManagerFactoryAlgorithm = r1;
        return this;
    }

    public SSLContextBuilder setTrustManagerFactoryAlgorithm(String r1) {
        this.trustManagerFactoryAlgorithm = r1;
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore r5, TrustStrategy r6) throws NoSuchAlgorithmException, KeyStoreException {
        String r0 = this.trustManagerFactoryAlgorithm;
        if (r0 != null) goto L5;
        r0 = TrustManagerFactory.getDefaultAlgorithm();
    L5:
        TrustManagerFactory r1 = TrustManagerFactory.getInstance(r0);
        r1.init(r5);
        TrustManager[] r7 = r1.getTrustManagers();
        if (r7 == null) goto L19;
        int r2 = 0;
        if (r6 == null) goto L16;
        int r3 = 0;
    L11:
        if (r3 >= r7.length) goto L16;
        TrustManager r4 = r7[r3];
        if ((r4 instanceof X509TrustManager) == false) goto L15;
        r7[r3] = new TrustManagerDelegate((X509TrustManager) r4, r6);
    L15:
        r3 = r3 + 1;
    L16:
        int r8 = r7.length;
    L17:
        if (r2 >= r8) goto L19;
        this.trustManagers.add(r7[r2]);
        r2 = r2 + 1;
    L19:
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(TrustStrategy r2) throws NoSuchAlgorithmException, KeyStoreException {
        return loadTrustMaterial(null, r2);
    }

    public SSLContextBuilder loadTrustMaterial(File r3, char[] r4, TrustStrategy r5) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        Args.notNull(r3, "Truststore file");
        KeyStore r0 = KeyStore.getInstance(this.keyStoreType);
        FileInputStream r1 = new FileInputStream(r3);
        r0.load(r1, r4);     // Catch: Throwable -> L6
        r1.close();
        return loadTrustMaterial(r0, r5);
    L6:
        th = move-exception;
        r1.close();
        throw th;
    }

    public SSLContextBuilder loadTrustMaterial(File r2, char[] r3) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        return loadTrustMaterial(r2, r3, null);
    }

    public SSLContextBuilder loadTrustMaterial(File r2) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        return loadTrustMaterial(r2, null);
    }

    public SSLContextBuilder loadTrustMaterial(URL r2, char[] r3, TrustStrategy r4) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        Args.notNull(r2, "Truststore URL");
        KeyStore r0 = KeyStore.getInstance(this.keyStoreType);
        InputStream r5 = r2.openStream();
        r0.load(r5, r3);     // Catch: Throwable -> L6
        r5.close();
        return loadTrustMaterial(r0, r4);
    L6:
        th = move-exception;
        r5.close();
        throw th;
    }

    public SSLContextBuilder loadTrustMaterial(URL r2, char[] r3) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        return loadTrustMaterial(r2, r3, null);
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore r4, char[] r5, PrivateKeyStrategy r6) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        String r0 = this.keyManagerFactoryAlgorithm;
        if (r0 != null) goto L5;
        r0 = KeyManagerFactory.getDefaultAlgorithm();
    L5:
        KeyManagerFactory r1 = KeyManagerFactory.getInstance(r0);
        r1.init(r4, r5);
        KeyManager[] r7 = r1.getKeyManagers();
        if (r7 == null) goto L19;
        int r8 = 0;
        if (r6 == null) goto L16;
        int r2 = 0;
    L11:
        if (r2 >= r7.length) goto L16;
        KeyManager r3 = r7[r2];
        if ((r3 instanceof X509ExtendedKeyManager) == false) goto L15;
        r7[r2] = new KeyManagerDelegate((X509ExtendedKeyManager) r3, r6);
    L15:
        r2 = r2 + 1;
    L16:
        int r9 = r7.length;
    L17:
        if (r8 >= r9) goto L19;
        this.keyManagers.add(r7[r8]);
        r8 = r8 + 1;
    L19:
        return this;
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore r2, char[] r3) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        return loadKeyMaterial(r2, r3, null);
    }

    public SSLContextBuilder loadKeyMaterial(File r3, char[] r4, char[] r5, PrivateKeyStrategy r6) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        Args.notNull(r3, "Keystore file");
        KeyStore r0 = KeyStore.getInstance(this.keyStoreType);
        FileInputStream r1 = new FileInputStream(r3);
        r0.load(r1, r4);     // Catch: Throwable -> L6
        r1.close();
        return loadKeyMaterial(r0, r5, r6);
    L6:
        th = move-exception;
        r1.close();
        throw th;
    }

    public SSLContextBuilder loadKeyMaterial(File r2, char[] r3, char[] r4) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        return loadKeyMaterial(r2, r3, r4, null);
    }

    public SSLContextBuilder loadKeyMaterial(URL r2, char[] r3, char[] r4, PrivateKeyStrategy r5) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        Args.notNull(r2, "Keystore URL");
        KeyStore r0 = KeyStore.getInstance(this.keyStoreType);
        InputStream r6 = r2.openStream();
        r0.load(r6, r3);     // Catch: Throwable -> L6
        r6.close();
        return loadKeyMaterial(r0, r4, r5);
    L6:
        th = move-exception;
        r6.close();
        throw th;
    }

    public SSLContextBuilder loadKeyMaterial(URL r2, char[] r3, char[] r4) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        return loadKeyMaterial(r2, r3, r4, null);
    }

    protected void initSSLContext(SSLContext r2, Collection<KeyManager> r3, Collection<TrustManager> r4, SecureRandom r5) throws KeyManagementException {
        TrustManager[] r0 = null;
        if (r3.isEmpty() == true) goto L5;
        KeyManager[] r1 = (KeyManager[]) r3.toArray(new KeyManager[r3.size()]);
    L7:
        if (r4.isEmpty() == true) goto L9;
        r0 = (TrustManager[]) r4.toArray(new TrustManager[r4.size()]);
    L9:
        r2.init(r1, r0, r5);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public SSLContext build() throws NoSuchAlgorithmException, KeyManagementException {
        String r0 = this.protocol;
        if (r0 != null) goto L6;
        r0 = "TLS";
    L6:
        Provider r1 = this.provider;
        if (r1 == null) goto L9;
        SSLContext r2 = SSLContext.getInstance(r0, r1);
    L10:
        initSSLContext(r2, this.keyManagers, this.trustManagers, this.secureRandom);
        return r2;
    L9:
        r2 = SSLContext.getInstance(r0);
        goto L10
    }

    public String toString() {
        return "[provider=" + this.provider + ", protocol=" + this.protocol + ", keyStoreType=" + this.keyStoreType + ", keyManagerFactoryAlgorithm=" + this.keyManagerFactoryAlgorithm + ", keyManagers=" + this.keyManagers + ", trustManagerFactoryAlgorithm=" + this.trustManagerFactoryAlgorithm + ", trustManagers=" + this.trustManagers + ", secureRandom=" + this.secureRandom + "]";
    }
}
