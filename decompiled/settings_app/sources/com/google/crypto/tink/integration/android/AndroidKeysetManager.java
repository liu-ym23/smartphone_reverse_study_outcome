package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.BinaryKeysetReader;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.TinkProtoParametersFormat;
import com.google.crypto.tink.subtle.Hex;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidKeysetManager {
    private static final String TAG = "AndroidKeysetManager";
    private static final Object lock = null;
    private KeysetManager keysetManager;
    private final Aead masterAead;
    private final KeysetWriter writer;

    /* JADX INFO: renamed from: com.google.crypto.tink.integration.android.AndroidKeysetManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private Context context;
        private KeyTemplate keyTemplate;
        private com.google.crypto.tink.proto.KeyTemplate keyTemplateProto;
        private KeysetManager keysetManager;
        private String keysetName;
        private Aead masterAead;
        private String masterKeyUri;
        private String prefFileName;
        private boolean useKeystore;

        static /* synthetic */ Context access$000(Builder r0) {
            return r0.context;
        }

        static /* synthetic */ String access$100(Builder r0) {
            return r0.keysetName;
        }

        static /* synthetic */ String access$200(Builder r0) {
            return r0.prefFileName;
        }

        static /* synthetic */ Aead access$300(Builder r0) {
            return r0.masterAead;
        }

        static /* synthetic */ KeysetManager access$400(Builder r0) {
            return r0.keysetManager;
        }

        public Builder() {
            this.context = null;
            this.keysetName = null;
            this.prefFileName = null;
            this.masterKeyUri = null;
            this.masterAead = null;
            this.useKeystore = true;
            this.keyTemplate = null;
            this.keyTemplateProto = null;
        }

        public Builder withSharedPref(Context context, String keysetName, String prefFileName) throws IOException {
            if (context == null) goto L9;
            if (keysetName == null) goto L7;
            this.context = context;
            this.keysetName = keysetName;
            this.prefFileName = prefFileName;
            return this;
        L7:
            throw new IllegalArgumentException("need a keyset name");
        L9:
            throw new IllegalArgumentException("need an Android context");
        }

        public Builder withMasterKeyUri(String val) {
            if (val.startsWith(AndroidKeystoreKmsClient.PREFIX) == false) goto L11;
            if (this.useKeystore == false) goto L9;
            this.masterKeyUri = val;
            return this;
        L9:
            throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
        L11:
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }

        public Builder withKeyTemplate(com.google.crypto.tink.proto.KeyTemplate val) {
            this.keyTemplateProto = val;
            return this;
        }

        public Builder withKeyTemplate(KeyTemplate val) {
            this.keyTemplate = val;
            return this;
        }

        @Deprecated
        public Builder doNotUseKeystore() {
            this.masterKeyUri = null;
            this.useKeystore = false;
            return this;
        }

        private static byte[] readKeysetFromPrefs(Context context, String keysetName, String prefFileName) throws IOException {
            if (keysetName == null) goto L16;
            Context r1 = context.getApplicationContext();
            if (prefFileName != null) goto L6;
            SharedPreferences r2 = PreferenceManager.getDefaultSharedPreferences(r1);
        L17:
            String r3 = r2.getString(keysetName, null);     // Catch: Throwable -> L13
            if (r3 != null) goto L11;
            return null;
        L11:
            return Hex.decode(r3);
        L14:
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", new Object[]{keysetName}));
        L6:
            r2 = r1.getSharedPreferences(prefFileName, 0);
            goto L17
        L16:
            throw new IllegalArgumentException("keysetName cannot be null");
        }

        private KeysetManager readKeysetInCleartext(byte[] serializedKeyset) throws GeneralSecurityException, IOException {
            return KeysetManager.withKeysetHandle(CleartextKeysetHandle.read(BinaryKeysetReader.withBytes(serializedKeyset)));
        }

        public synchronized AndroidKeysetManager build() throws GeneralSecurityException, IOException {
            monitor-enter(this);
        L34:
            th = move-exception;
            throw th;
        L4:
            if (this.keysetName == null) goto L33;
            com.google.crypto.tink.proto.KeyTemplate r0 = this.keyTemplateProto;     // Catch: Throwable -> L34
            if (r0 != null) goto L8;
        L10:
            Object r1 = AndroidKeysetManager.access$500();     // Catch: Throwable -> L34
            monitor-enter(r1);     // Catch: Throwable -> L34
            byte[] r2 = readKeysetFromPrefs(this.context, this.keysetName, this.prefFileName);     // Catch: Throwable -> L29
            if (r2 != null) goto L19;
            if (this.masterKeyUri == null) goto L17;
            this.masterAead = readOrGenerateNewMasterKey();     // Catch: Throwable -> L29
        L17:
            this.keysetManager = generateKeysetAndWriteToPrefs();     // Catch: Throwable -> L29
        L25:
            AndroidKeysetManager r3 = new AndroidKeysetManager(this, null);     // Catch: Throwable -> L29
            monitor-exit(r1);     // Catch: Throwable -> L29
            monitor-exit(this);
            return r3;
        L19:
            if (this.masterKeyUri != null) goto L21;
        L24:
            this.keysetManager = readKeysetInCleartext(r2);     // Catch: Throwable -> L29
            goto L25
        L21:
            if (AndroidKeysetManager.access$600() == false) goto L24;
            this.keysetManager = readMasterkeyDecryptAndParseKeyset(r2);     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            throw th;     // Catch: Throwable -> L34
        L8:
            if (this.keyTemplate != null) goto L10;
            this.keyTemplate = KeyTemplate.createFrom(TinkProtoParametersFormat.parse(r0.toByteArray()));     // Catch: Throwable -> L34
            goto L10
        L33:
            throw new IllegalArgumentException("keysetName cannot be null");     // Catch: Throwable -> L34
        }

        private Aead readOrGenerateNewMasterKey() throws GeneralSecurityException {
            if (AndroidKeysetManager.access$600() == true) goto L6;
            Log.w(AndroidKeysetManager.access$800(), "Android Keystore requires at least Android M");
            return null;
        L6:
            AndroidKeystoreKmsClient r1 = new AndroidKeystoreKmsClient();
            boolean r3 = AndroidKeystoreKmsClient.generateKeyIfNotExist(this.masterKeyUri);     // Catch: Throwable -> L16
            return r1.getAead(this.masterKeyUri);
        L10:
            e = move-exception;
            if (r3 == false) goto L15;
            Log.w(AndroidKeysetManager.access$800(), "cannot use Android Keystore, it'll be disabled", e);
            return null;
        L15:
            throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.masterKeyUri}), e);
        L16:
            e = move-exception;
            Log.w(AndroidKeysetManager.access$800(), "cannot use Android Keystore, it'll be disabled", e);
            return null;
        }

        private KeysetManager generateKeysetAndWriteToPrefs() throws GeneralSecurityException, IOException {
            if (this.keyTemplate == null) goto L7;
            KeysetManager r0 = KeysetManager.withEmptyKeyset().add(this.keyTemplate);
            KeysetManager r1 = r0.setPrimary(r0.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
            SharedPrefKeysetWriter r2 = new SharedPrefKeysetWriter(this.context, this.keysetName, this.prefFileName);
            AndroidKeysetManager.access$900(r1.getKeysetHandle(), r2, this.masterAead);
            return r1;
        L7:
            throw new GeneralSecurityException("cannot read or generate keyset");
        }

        private KeysetManager readMasterkeyDecryptAndParseKeyset(byte[] serializedKeyset) throws GeneralSecurityException, IOException {
            this.masterAead = new AndroidKeystoreKmsClient().getAead(this.masterKeyUri);     // Catch: Throwable -> L9
            return KeysetManager.withKeysetHandle(KeysetHandle.read(BinaryKeysetReader.withBytes(serializedKeyset), this.masterAead));
        L5:
            e = move-exception;
            return readKeysetInCleartext(serializedKeyset);
        L8:
            throw e;
        L9:
            e = move-exception;
            KeysetManager r2 = readKeysetInCleartext(serializedKeyset);     // Catch: IOException -> L12
            Log.w(AndroidKeysetManager.access$800(), "cannot use Android Keystore, it'll be disabled", e);     // Catch: IOException -> L12
            return r2;
        L12:
            throw e;
        }
    }

    private static boolean isAtLeastM() {
        return true;
    }

    /* synthetic */ AndroidKeysetManager(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Object access$500() {
        return lock;
    }

    static /* synthetic */ boolean access$600() {
        return isAtLeastM();
    }

    static /* synthetic */ String access$800() {
        return TAG;
    }

    static /* synthetic */ void access$900(KeysetHandle r0, KeysetWriter r1, Aead r2) throws GeneralSecurityException {
        write(r0, r1, r2);
    }

    static {
        lock = new Object();
    }

    private AndroidKeysetManager(Builder builder) {
        this.writer = new SharedPrefKeysetWriter(Builder.access$000(builder), Builder.access$100(builder), Builder.access$200(builder));
        this.masterAead = Builder.access$300(builder);
        this.keysetManager = Builder.access$400(builder);
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        monitor-enter(this);
        KeysetHandle r0 = this.keysetManager.getKeysetHandle();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized AndroidKeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        monitor-enter(this);
        KeysetManager r3 = this.keysetManager.rotate(keyTemplate);     // Catch: Throwable -> L6
        this.keysetManager = r3;     // Catch: Throwable -> L6
        write(r3.getKeysetHandle(), this.writer, this.masterAead);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized AndroidKeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        monitor-enter(this);
        KeysetManager r3 = this.keysetManager.add(keyTemplate);     // Catch: Throwable -> L6
        this.keysetManager = r3;     // Catch: Throwable -> L6
        write(r3.getKeysetHandle(), this.writer, this.masterAead);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized AndroidKeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        monitor-enter(this);
        KeysetManager r3 = this.keysetManager.add(keyTemplate);     // Catch: Throwable -> L6
        this.keysetManager = r3;     // Catch: Throwable -> L6
        write(r3.getKeysetHandle(), this.writer, this.masterAead);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized AndroidKeysetManager setPrimary(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
        KeysetManager r3 = this.keysetManager.setPrimary(keyId);     // Catch: Throwable -> L6
        this.keysetManager = r3;     // Catch: Throwable -> L6
        write(r3.getKeysetHandle(), this.writer, this.masterAead);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized AndroidKeysetManager promote(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
        AndroidKeysetManager r1 = setPrimary(keyId);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized AndroidKeysetManager enable(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
        KeysetManager r3 = this.keysetManager.enable(keyId);     // Catch: Throwable -> L6
        this.keysetManager = r3;     // Catch: Throwable -> L6
        write(r3.getKeysetHandle(), this.writer, this.masterAead);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized AndroidKeysetManager disable(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
        KeysetManager r3 = this.keysetManager.disable(keyId);     // Catch: Throwable -> L6
        this.keysetManager = r3;     // Catch: Throwable -> L6
        write(r3.getKeysetHandle(), this.writer, this.masterAead);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized AndroidKeysetManager delete(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
        KeysetManager r3 = this.keysetManager.delete(keyId);     // Catch: Throwable -> L6
        this.keysetManager = r3;     // Catch: Throwable -> L6
        write(r3.getKeysetHandle(), this.writer, this.masterAead);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized AndroidKeysetManager destroy(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
        KeysetManager r3 = this.keysetManager.destroy(keyId);     // Catch: Throwable -> L6
        this.keysetManager = r3;     // Catch: Throwable -> L6
        write(r3.getKeysetHandle(), this.writer, this.masterAead);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isUsingKeystore() {
        monitor-enter(this);
        if (this.masterAead == null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    private static void write(KeysetHandle handle, KeysetWriter writer, Aead masterAead) throws GeneralSecurityException {
        if (masterAead == null) goto L4;
        handle.write(writer, masterAead);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        CleartextKeysetHandle.write(handle, writer);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new GeneralSecurityException(e);
    }
}
