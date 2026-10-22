package com.google.crypto.tink.internal;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyManagerRegistry {
    private static final KeyManagerRegistry GLOBAL_INSTANCE = null;
    private static final Logger logger = null;
    private ConcurrentMap<String, KeyManager<?>> keyManagerMap;
    private ConcurrentMap<String, Boolean> newKeyAllowedMap;

    static {
        logger = Logger.getLogger(KeyManagerRegistry.class.getName());
        GLOBAL_INSTANCE = new KeyManagerRegistry();
    }

    public static KeyManagerRegistry globalInstance() {
        return GLOBAL_INSTANCE;
    }

    public static void resetGlobalInstanceTestOnly() {
        KeyManagerRegistry r0 = GLOBAL_INSTANCE;
        r0.keyManagerMap = new ConcurrentHashMap();
        r0.newKeyAllowedMap = new ConcurrentHashMap();
    }

    public KeyManagerRegistry(KeyManagerRegistry original) {
        this.keyManagerMap = new ConcurrentHashMap(original.keyManagerMap);
        this.newKeyAllowedMap = new ConcurrentHashMap(original.newKeyAllowedMap);
    }

    public KeyManagerRegistry() {
        this.keyManagerMap = new ConcurrentHashMap();
        this.newKeyAllowedMap = new ConcurrentHashMap();
    }

    private synchronized KeyManager<?> getKeyManagerOrThrow(String typeUrl) throws GeneralSecurityException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.keyManagerMap.containsKey(typeUrl) == false) goto L10;
        KeyManager<?> r4 = this.keyManagerMap.get(typeUrl);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    L10:
        throw new GeneralSecurityException("No key manager found for key type " + typeUrl);     // Catch: Throwable -> L11
    }

    private synchronized void insertKeyManager(final KeyManager<?> manager, boolean forceOverwrite, boolean newKeyAllowed) throws GeneralSecurityException {
        monitor-enter(this);
        String r2 = manager.getKeyType();     // Catch: Throwable -> L26
        if (newKeyAllowed == true) goto L7;
    L13:
        KeyManager<?> r0 = this.keyManagerMap.get(r2);     // Catch: Throwable -> L26
        if (r0 != null) goto L16;
    L20:
        if (forceOverwrite == true) goto L22;
        this.keyManagerMap.putIfAbsent(r2, manager);     // Catch: Throwable -> L26
    L23:
        this.newKeyAllowedMap.put(r2, Boolean.valueOf(newKeyAllowed));     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L22:
        this.keyManagerMap.put(r2, manager);     // Catch: Throwable -> L26
        goto L23
    L16:
        if (r0.getClass().equals(manager.getClass()) == true) goto L20;
        logger.warning("Attempted overwrite of a registered key manager for key type " + r2);     // Catch: Throwable -> L26
        throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{r2, r0.getClass().getName(), manager.getClass().getName()}));     // Catch: Throwable -> L26
    L7:
        if (this.newKeyAllowedMap.containsKey(r2) == false) goto L13;
        if (this.newKeyAllowedMap.get(r2).booleanValue() == true) goto L13;
        throw new GeneralSecurityException("New keys are already disallowed for key type " + r2);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized <P> void registerKeyManager(final KeyManager<P> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        monitor-enter(this);
        registerKeyManagerWithFipsCompatibility(manager, TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS, newKeyAllowed);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <P> void registerKeyManagerWithFipsCompatibility(final KeyManager<P> manager, TinkFipsUtil.AlgorithmFipsCompatibility compatibility, boolean newKeyAllowed) throws GeneralSecurityException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (compatibility.isCompatible() == false) goto L9;
        insertKeyManager(manager, false, newKeyAllowed);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");     // Catch: Throwable -> L10
    }

    public boolean typeUrlExists(String typeUrl) {
        return this.keyManagerMap.containsKey(typeUrl);
    }

    public <P> KeyManager<P> getKeyManager(String r3, Class<P> r4) throws GeneralSecurityException {
        KeyManager<P> r2 = (KeyManager<P>) getKeyManagerOrThrow(r3);
        if (r2.getPrimitiveClass().equals(r4) == false) goto L6;
        return r2;
    L6:
        throw new GeneralSecurityException("Primitive type " + r4.getName() + " not supported by key manager of type " + r2.getClass() + ", which only supports: " + r2.getPrimitiveClass());
    }

    public KeyManager<?> getUntypedKeyManager(String typeUrl) throws GeneralSecurityException {
        return getKeyManagerOrThrow(typeUrl);
    }

    public boolean isNewKeyAllowed(String typeUrl) {
        return this.newKeyAllowedMap.get(typeUrl).booleanValue();
    }

    public boolean isEmpty() {
        return this.keyManagerMap.isEmpty();
    }

    public synchronized void restrictToFipsIfEmptyAndGlobalInstance() throws GeneralSecurityException {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this != globalInstance()) goto L17;
        if (TinkFipsUtil.useOnlyFips() == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (isEmpty() == false) goto L15;
        TinkFipsUtil.setFipsRestricted();     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L15:
        throw new GeneralSecurityException("Could not enable FIPS mode as Registry is not empty.");     // Catch: Throwable -> L18
    L17:
        throw new GeneralSecurityException("Only the global instance can be restricted to FIPS.");     // Catch: Throwable -> L18
    }
}
