package com.android.settings.utils;

import android.security.keystore2.AndroidKeyStoreLoadStoreParameter;
import com.obric.olog.OLog;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidKeystoreAliasLoader {
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String TAG = "SettingsKeystoreUtils";
    private final Collection<String> mCaCertAliases;
    private final Collection<String> mKeyCertAliases;

    public AndroidKeystoreAliasLoader(Integer r8) {
        this.mKeyCertAliases = new ArrayList();
        this.mCaCertAliases = new ArrayList();
        KeyStore r1 = KeyStore.getInstance(KEYSTORE_PROVIDER);     // Catch: Exception -> L29
        if (r8 != null) goto L6;
    L8:
        r1.load(null);     // Catch: Exception -> L29
    L9:
        Enumeration<String> r9 = r1.aliases();     // Catch: Exception -> L29
    L11:
        if (r9.hasMoreElements() == false) goto L28;
        String r3 = r9.nextElement();
        Key r4 = r1.getKey(r3, null);     // Catch: Throwable -> L26
        if (r4 != null) goto L16;
        if (r1.getCertificate(r3) == null) goto L11;
        this.mCaCertAliases.add(r3);     // Catch: Throwable -> L26
        goto L11
    L16:
        if ((r4 instanceof PrivateKey) == false) goto L11;
        this.mKeyCertAliases.add(r3);     // Catch: Throwable -> L26
        Certificate[] r5 = r1.getCertificateChain(r3);     // Catch: Throwable -> L26
        if (r5 == null) goto L11;
        if (r5.length < 2) goto L11;
        this.mCaCertAliases.add(r3);     // Catch: Throwable -> L26
    L26:
        e = move-exception;
        OLog.e(TAG, "Failed to load alias: " + r3 + " from Android Keystore. Ignoring.", e);
        goto L11
    L28:
        return;
    L6:
        if (r8.intValue() == (-1)) goto L8;
        r1.load(new AndroidKeyStoreLoadStoreParameter(r8.intValue()));     // Catch: Exception -> L29
    L29:
        e = move-exception;
        OLog.e(TAG, "Failed to open Android Keystore.", e);
    }

    public Collection<String> getKeyCertAliases() {
        return this.mKeyCertAliases;
    }

    public Collection<String> getCaCertAliases() {
        return this.mCaCertAliases;
    }
}
