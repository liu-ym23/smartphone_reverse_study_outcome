package com.google.crypto.tink.integration.android;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidKeystoreKmsClient implements KmsClient {
    private static final int MAX_WAIT_TIME_MILLISECONDS_BEFORE_RETRY = 40;
    public static final String PREFIX = "android-keystore://";
    private static final String TAG = "AndroidKeystoreKmsClient";
    private static final Object keystoreLock = null;
    private final String keyUri;

    /* JADX INFO: renamed from: com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        String keyUri;

        public Builder() {
            this.keyUri = null;
            if (AndroidKeystoreKmsClient.access$000() == false) goto L6;
            return;
        L6:
            throw new IllegalStateException("need Android Keystore on Android M or newer");
        }

        public Builder setKeyUri(String val) {
            if (val == null) goto L8;
            if (val.toLowerCase(Locale.US).startsWith(AndroidKeystoreKmsClient.PREFIX) == false) goto L8;
            this.keyUri = val;
            return this;
        L8:
            throw new IllegalArgumentException("val must start with android-keystore://");
        }

        public AndroidKeystoreKmsClient build() {
            return new AndroidKeystoreKmsClient(this, null);
        }
    }

    private static boolean isAtLeastM() {
        return true;
    }

    /* synthetic */ AndroidKeystoreKmsClient(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ boolean access$000() {
        return isAtLeastM();
    }

    static {
        keystoreLock = new Object();
    }

    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        this(new Builder());
    }

    @Deprecated
    public AndroidKeystoreKmsClient(String uri) {
        this(new Builder().setKeyUri(uri));
    }

    private AndroidKeystoreKmsClient(Builder builder) {
        this.keyUri = builder.keyUri;
    }

    @Override // com.google.crypto.tink.KmsClient
    public boolean doesSupport(String uri) {
        String r0 = this.keyUri;
        if (r0 == null) goto L8;
        if (r0.equals(uri) == false) goto L8;
        return true;
    L8:
        if (this.keyUri == null) goto L10;
    L12:
        return false;
    L10:
        if (uri.toLowerCase(Locale.US).startsWith(PREFIX) == false) goto L12;
        return true;
    }

    @Override // com.google.crypto.tink.KmsClient
    public KmsClient withCredentials(String unused) throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    @Override // com.google.crypto.tink.KmsClient
    public KmsClient withDefaultCredentials() throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    @Override // com.google.crypto.tink.KmsClient
    public Aead getAead(String uri) throws GeneralSecurityException {
        String r0 = this.keyUri;
        if (r0 != null) goto L5;
    L20:
        Object r4 = keystoreLock;     // Catch: IOException -> L17
        monitor-enter(r4);     // Catch: IOException -> L17
        Aead r5 = validateAead(new AndroidKeystoreAesGcm(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, uri)));     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
        return r5;
    L14:
        th = move-exception;
        throw th;     // Catch: IOException -> L17
    L17:
        e = move-exception;
        throw new GeneralSecurityException(e);
    L5:
        if (r0.equals(uri) == true) goto L20;
        throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", new Object[]{this.keyUri, uri}));
    }

    private static KeyStore getAndroidKeyStore() throws GeneralSecurityException {
        KeyStore r0 = KeyStore.getInstance("AndroidKeyStore");     // Catch: IOException -> L4
        r0.load(null);     // Catch: IOException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new GeneralSecurityException(e);
    }

    public void deleteKey(String keyUri) throws GeneralSecurityException {
        String r1 = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, keyUri);
        Object r2 = keystoreLock;
        monitor-enter(r2);
        getAndroidKeyStore().deleteEntry(r1);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean hasKey(String keyUri) throws GeneralSecurityException {
        String r1 = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, keyUri);
        Object r2 = keystoreLock;     // Catch: NullPointerException -> L11
        monitor-enter(r2);     // Catch: NullPointerException -> L11
        boolean r0 = getAndroidKeyStore().containsAlias(r1);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        return r0;
    L8:
        th = move-exception;
        throw th;     // Catch: NullPointerException -> L11
    L11:
        Log.w(TAG, "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
        sleepRandomAmount();
        monitor-enter(keystoreLock);
    L16:
        th = move-exception;
        throw th;
    L14:
        return getAndroidKeyStore().containsAlias(r1);
    }

    private static void sleepRandomAmount() {
        Thread.sleep((int) (Math.random() * 40.0d));     // Catch: InterruptedException -> L5
        return;
    }

    public static Aead getOrGenerateNewAeadKey(String keyUri) throws GeneralSecurityException, IOException {
        AndroidKeystoreKmsClient r0 = new AndroidKeystoreKmsClient();
        Object r1 = keystoreLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.hasKey(keyUri) == true) goto L7;
        generateNewAesGcmKeyWithoutExistenceCheck(keyUri);     // Catch: Throwable -> L10
    L7:
        Aead r3 = r0.getAead(keyUri);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r3;
    }

    public static void generateNewAeadKey(String keyUri) throws GeneralSecurityException {
        AndroidKeystoreKmsClient r0 = new AndroidKeystoreKmsClient();
        Object r1 = keystoreLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r0.hasKey(keyUri) == true) goto L10;
        generateNewAesGcmKeyWithoutExistenceCheck(keyUri);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", new Object[]{keyUri}));     // Catch: Throwable -> L11
    }

    private static void generateNewAesGcmKeyWithoutExistenceCheck(String keyUri) throws GeneralSecurityException {
        String r3 = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, keyUri);
        KeyGenerator r0 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        r0.init(new KeyGenParameterSpec.Builder(r3, 3).setKeySize(256).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build());
        r0.generateKey();
    }

    static boolean generateKeyIfNotExist(String keyUri) throws GeneralSecurityException {
        AndroidKeystoreKmsClient r0 = new AndroidKeystoreKmsClient();
        Object r1 = keystoreLock;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r0.hasKey(keyUri) == true) goto L10;
        generateNewAesGcmKeyWithoutExistenceCheck(keyUri);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return true;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return false;
    }

    private static Aead validateAead(Aead aead) throws GeneralSecurityException {
        byte[] r0 = Random.randBytes(10);
        byte[] r1 = new byte[0];
        if (Arrays.equals(r0, aead.decrypt(aead.encrypt(r0, r1), r1)) == false) goto L6;
        return aead;
    L6:
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }
}
