package cz.msebera.android.httpclient.conn.ssl;

import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SSLContextBuilder {
    static final String SSL = "SSL";
    static final String TLS = "TLS";
    private final Set<KeyManager> keymanagers;
    private String protocol;
    private SecureRandom secureRandom;
    private final Set<TrustManager> trustmanagers;

    static class KeyManagerDelegate implements X509KeyManager {
        private final PrivateKeyStrategy aliasStrategy;
        private final X509KeyManager keyManager;

        KeyManagerDelegate(X509KeyManager r1, PrivateKeyStrategy r2) {
            this.keyManager = r1;
            this.aliasStrategy = r2;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getClientAliases(String r1, Principal[] r2) {
            return this.keyManager.getClientAliases(r1, r2);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseClientAlias(String[] r12, Principal[] r13, Socket r14) {
            HashMap r0 = new HashMap();
            int r1 = r12.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
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
        L11:
            return this.aliasStrategy.chooseAlias(r0, r14);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getServerAliases(String r1, Principal[] r2) {
            return this.keyManager.getServerAliases(r1, r2);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseServerAlias(String r7, Principal[] r8, Socket r9) {
            HashMap r0 = new HashMap();
            String[] r10 = this.keyManager.getServerAliases(r7, r8);
            if (r10 == null) goto L8;
            int r1 = r10.length;
            int r2 = 0;
        L5:
            if (r2 >= r1) goto L8;
            String r3 = r10[r2];
            r0.put(r3, new PrivateKeyDetails(r7, this.keyManager.getCertificateChain(r3)));
            r2 = r2 + 1;
        L8:
            return this.aliasStrategy.chooseAlias(r0, r9);
        }

        @Override // javax.net.ssl.X509KeyManager
        public X509Certificate[] getCertificateChain(String r1) {
            return this.keyManager.getCertificateChain(r1);
        }

        @Override // javax.net.ssl.X509KeyManager
        public PrivateKey getPrivateKey(String r1) {
            return this.keyManager.getPrivateKey(r1);
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

    public SSLContextBuilder() {
        this.keymanagers = new LinkedHashSet();
        this.trustmanagers = new LinkedHashSet();
    }

    public SSLContextBuilder useTLS() {
        this.protocol = "TLS";
        return this;
    }

    public SSLContextBuilder useSSL() {
        this.protocol = "SSL";
        return this;
    }

    public SSLContextBuilder useProtocol(String r1) {
        this.protocol = r1;
        return this;
    }

    public SSLContextBuilder setSecureRandom(SecureRandom r1) {
        this.secureRandom = r1;
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore r5, TrustStrategy r6) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r0.init(r5);
        TrustManager[] r7 = r0.getTrustManagers();
        if (r7 == null) goto L16;
        int r1 = 0;
        if (r6 == null) goto L13;
        int r2 = 0;
    L8:
        if (r2 >= r7.length) goto L13;
        TrustManager r3 = r7[r2];
        if ((r3 instanceof X509TrustManager) == false) goto L12;
        r7[r2] = new TrustManagerDelegate((X509TrustManager) r3, r6);
    L12:
        r2 = r2 + 1;
    L13:
        int r8 = r7.length;
    L14:
        if (r1 >= r8) goto L16;
        this.trustmanagers.add(r7[r1]);
        r1 = r1 + 1;
    L16:
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore r2) throws NoSuchAlgorithmException, KeyStoreException {
        return loadTrustMaterial(r2, null);
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore r2, char[] r3) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        loadKeyMaterial(r2, r3, null);
        return this;
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore r4, char[] r5, PrivateKeyStrategy r6) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        KeyManagerFactory r0 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        r0.init(r4, r5);
        KeyManager[] r7 = r0.getKeyManagers();
        if (r7 == null) goto L16;
        int r8 = 0;
        if (r6 == null) goto L13;
        int r1 = 0;
    L8:
        if (r1 >= r7.length) goto L13;
        KeyManager r2 = r7[r1];
        if ((r2 instanceof X509KeyManager) == false) goto L12;
        r7[r1] = new KeyManagerDelegate((X509KeyManager) r2, r6);
    L12:
        r1 = r1 + 1;
    L13:
        int r9 = r7.length;
    L14:
        if (r8 >= r9) goto L16;
        this.keymanagers.add(r7[r8]);
        r8 = r8 + 1;
    L16:
        return this;
    }

    public SSLContext build() throws NoSuchAlgorithmException, KeyManagementException {
        String r0 = this.protocol;
        if (r0 != null) goto L6;
        r0 = "TLS";
    L6:
        SSLContext r1 = SSLContext.getInstance(r0);
        TrustManager[] r2 = null;
        if (this.keymanagers.isEmpty() == true) goto L9;
        Set<KeyManager> r3 = this.keymanagers;
        KeyManager[] r4 = (KeyManager[]) r3.toArray(new KeyManager[r3.size()]);
    L11:
        if (this.trustmanagers.isEmpty() == true) goto L13;
        Set<TrustManager> r5 = this.trustmanagers;
        r2 = (TrustManager[]) r5.toArray(new TrustManager[r5.size()]);
    L13:
        r1.init(r4, r2, this.secureRandom);
        return r1;
    L9:
        r4 = null;
        goto L11
    }
}
