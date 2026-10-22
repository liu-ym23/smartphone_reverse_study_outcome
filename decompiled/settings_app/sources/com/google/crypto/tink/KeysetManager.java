package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyStatusTypeProtoConverter;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class KeysetManager {
    private final Keyset.Builder keysetBuilder;

    private KeysetManager(Keyset.Builder val) {
        this.keysetBuilder = val;
    }

    public static KeysetManager withKeysetHandle(KeysetHandle val) {
        return new KeysetManager((Keyset.Builder) val.getKeyset().toBuilder());
    }

    public static KeysetManager withEmptyKeyset() {
        return new KeysetManager(Keyset.newBuilder());
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        monitor-enter(this);
        KeysetHandle r0 = KeysetHandle.fromKeyset((Keyset) this.keysetBuilder.build());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized KeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        monitor-enter(this);
        addNewKey(keyTemplate, true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return this;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized KeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        monitor-enter(this);
        addNewKey(keyTemplate, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return this;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized KeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        monitor-enter(this);
        addNewKey(keyTemplate.getProtoMaybeThrow(), false);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized KeysetManager add(KeyHandle keyHandle) throws GeneralSecurityException {
        monitor-enter(this);
        ProtoKey r0 = (ProtoKey) keyHandle.getKey(com.google.crypto.tink.tinkkey.SecretKeyAccess.insecureSecretAccess());     // Catch: Throwable -> L11 ClassCastException -> L13
    L5:
        if (keyIdExists(keyHandle.getId()) == true) goto L10;
        this.keysetBuilder.addKey((Keyset.Key) Keyset.Key.newBuilder().setKeyData(r0.getProtoKey()).setKeyId(keyHandle.getId()).setStatus(KeyStatusTypeProtoConverter.toProto(keyHandle.getStatus())).setOutputPrefixType(KeyTemplate.toProto(r0.getOutputPrefixType())).build());     // Catch: Throwable -> L11
        monitor-exit(this);
        return this;
    L10:
        throw new GeneralSecurityException("Trying to add a key with an ID already contained in the keyset.");     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        throw new UnsupportedOperationException("KeyHandles which contain TinkKeys that are not ProtoKeys are not yet supported.", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized KeysetManager add(KeyHandle keyHandle, KeyAccess access) throws GeneralSecurityException {
        monitor-enter(this);
        KeysetManager r1 = add(keyHandle);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int addNewKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, boolean asPrimary) throws GeneralSecurityException {
        monitor-enter(this);
        Keyset.Key r2 = newKey(keyTemplate);     // Catch: Throwable -> L9
        this.keysetBuilder.addKey(r2);     // Catch: Throwable -> L9
        if (asPrimary == false) goto L6;
        this.keysetBuilder.setPrimaryKeyId(r2.getKeyId());     // Catch: Throwable -> L9
    L6:
        int r3 = r2.getKeyId();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized KeysetManager setPrimary(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
        int r0 = 0;
    L21:
    L18:
        th = move-exception;
        throw th;
    L5:
        if (r0 >= this.keysetBuilder.getKeyCount()) goto L17;
        Keyset.Key r1 = this.keysetBuilder.getKey(r0);     // Catch: Throwable -> L18
        if (r1.getKeyId() == keyId) goto L9;
        r0 = r0 + 1;     // Catch: Throwable -> L18
        goto L21
    L9:
        if (r1.getStatus().equals(KeyStatusType.ENABLED) == false) goto L14;
        this.keysetBuilder.setPrimaryKeyId(keyId);     // Catch: Throwable -> L18
        monitor-exit(this);
        return this;
    L14:
        throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + keyId);     // Catch: Throwable -> L18
    L17:
        throw new GeneralSecurityException("key not found: " + keyId);     // Catch: Throwable -> L18
    }

    public synchronized KeysetManager promote(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
        KeysetManager r1 = setPrimary(keyId);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized KeysetManager enable(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
        int r0 = 0;
    L24:
    L21:
        th = move-exception;
        throw th;
    L5:
        if (r0 >= this.keysetBuilder.getKeyCount()) goto L20;
        Keyset.Key r1 = this.keysetBuilder.getKey(r0);     // Catch: Throwable -> L21
        if (r1.getKeyId() == keyId) goto L9;
        r0 = r0 + 1;
        goto L24
    L9:
        if (r1.getStatus() != KeyStatusType.ENABLED) goto L11;
    L15:
        this.keysetBuilder.setKey(r0, (Keyset.Key) ((Keyset.Key.Builder) r1.toBuilder()).setStatus(KeyStatusType.ENABLED).build());     // Catch: Throwable -> L21
        monitor-exit(this);
        return this;
    L11:
        if (r1.getStatus() == KeyStatusType.DISABLED) goto L15;
        throw new GeneralSecurityException("cannot enable key with id " + keyId);     // Catch: Throwable -> L21
    L20:
        throw new GeneralSecurityException("key not found: " + keyId);     // Catch: Throwable -> L21
    }

    public synchronized KeysetManager disable(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (keyId == this.keysetBuilder.getPrimaryKeyId()) goto L24;
        int r0 = 0;
    L7:
        if (r0 >= this.keysetBuilder.getKeyCount()) goto L22;
        Keyset.Key r1 = this.keysetBuilder.getKey(r0);     // Catch: Throwable -> L25
        if (r1.getKeyId() == keyId) goto L11;
        r0 = r0 + 1;
        goto L7
    L11:
        if (r1.getStatus() != KeyStatusType.ENABLED) goto L13;
    L17:
        this.keysetBuilder.setKey(r0, (Keyset.Key) ((Keyset.Key.Builder) r1.toBuilder()).setStatus(KeyStatusType.DISABLED).build());     // Catch: Throwable -> L25
        monitor-exit(this);
        return this;
    L13:
        if (r1.getStatus() == KeyStatusType.DISABLED) goto L17;
        throw new GeneralSecurityException("cannot disable key with id " + keyId);     // Catch: Throwable -> L25
    L22:
        throw new GeneralSecurityException("key not found: " + keyId);     // Catch: Throwable -> L25
    L24:
        throw new GeneralSecurityException("cannot disable the primary key");     // Catch: Throwable -> L25
    }

    public synchronized KeysetManager delete(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (keyId == this.keysetBuilder.getPrimaryKeyId()) goto L17;
        int r0 = 0;
    L7:
        if (r0 >= this.keysetBuilder.getKeyCount()) goto L15;
        if (this.keysetBuilder.getKey(r0).getKeyId() == keyId) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        this.keysetBuilder.removeKey(r0);     // Catch: Throwable -> L18
        monitor-exit(this);
        return this;
    L15:
        throw new GeneralSecurityException("key not found: " + keyId);     // Catch: Throwable -> L18
    L17:
        throw new GeneralSecurityException("cannot delete the primary key");     // Catch: Throwable -> L18
    }

    public synchronized KeysetManager destroy(int keyId) throws GeneralSecurityException {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (keyId == this.keysetBuilder.getPrimaryKeyId()) goto L26;
        int r0 = 0;
    L7:
        if (r0 >= this.keysetBuilder.getKeyCount()) goto L24;
        Keyset.Key r1 = this.keysetBuilder.getKey(r0);     // Catch: Throwable -> L27
        if (r1.getKeyId() == keyId) goto L11;
        r0 = r0 + 1;
        goto L7
    L11:
        if (r1.getStatus() != KeyStatusType.ENABLED) goto L13;
    L19:
        this.keysetBuilder.setKey(r0, (Keyset.Key) ((Keyset.Key.Builder) r1.toBuilder()).setStatus(KeyStatusType.DESTROYED).clearKeyData().build());     // Catch: Throwable -> L27
        monitor-exit(this);
        return this;
    L13:
        if (r1.getStatus() == KeyStatusType.DISABLED) goto L19;
        if (r1.getStatus() == KeyStatusType.DESTROYED) goto L19;
        throw new GeneralSecurityException("cannot destroy key with id " + keyId);     // Catch: Throwable -> L27
    L24:
        throw new GeneralSecurityException("key not found: " + keyId);     // Catch: Throwable -> L27
    L26:
        throw new GeneralSecurityException("cannot destroy the primary key");     // Catch: Throwable -> L27
    }

    private synchronized Keyset.Key newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        monitor-enter(this);
        Keyset.Key r2 = createKeysetKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized Keyset.Key createKeysetKey(KeyData keyData, OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        monitor-enter(this);
        int r0 = newKeyId();     // Catch: Throwable -> L10
        if (outputPrefixType == OutputPrefixType.UNKNOWN_PREFIX) goto L9;
        Keyset.Key r3 = (Keyset.Key) Keyset.Key.newBuilder().setKeyData(keyData).setKeyId(r0).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(outputPrefixType).build();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L9:
        throw new GeneralSecurityException("unknown output prefix type");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized boolean keyIdExists(int keyId) {
        monitor-enter(this);
        Iterator<Keyset.Key> r0 = this.keysetBuilder.getKeyList().iterator();     // Catch: Throwable -> L14
    L5:
        if (r0.hasNext() == false) goto L11;
        if (r0.next().getKeyId() != keyId) goto L5;
        monitor-exit(this);
        return true;
    L11:
        monitor-exit(this);
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    private synchronized int newKeyId() {
        monitor-enter(this);
        int r0 = com.google.crypto.tink.internal.Util.randKeyId();     // Catch: Throwable -> L10
    L5:
        if (keyIdExists(r0) == false) goto L8;
        r0 = com.google.crypto.tink.internal.Util.randKeyId();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }
}
