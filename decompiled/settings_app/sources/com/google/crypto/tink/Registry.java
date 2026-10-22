package com.google.crypto.tink;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class Registry {
    private static final Set<Class<?>> ALLOWED_PRIMITIVES = null;
    private static final ConcurrentMap<String, Catalogue<?>> catalogueMap = null;
    private static final Logger logger = null;

    static {
        logger = Logger.getLogger(Registry.class.getName());
        catalogueMap = new ConcurrentHashMap();
        ALLOWED_PRIMITIVES = Collections.unmodifiableSet(createAllowedPrimitives());
    }

    static synchronized void reset() {
        monitor-enter(Registry.class);
        KeyManagerRegistry.resetGlobalInstanceTestOnly();     // Catch: Throwable -> L7
        MutablePrimitiveRegistry.resetGlobalInstanceTestOnly();     // Catch: Throwable -> L7
        catalogueMap.clear();     // Catch: Throwable -> L7
        monitor-exit(Registry.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static synchronized void addCatalogue(String catalogueName, Catalogue<?> catalogue) throws GeneralSecurityException {
        monitor-enter(Registry.class);
        if (catalogueName == null) goto L19;
        if (catalogue == null) goto L17;
        ConcurrentMap<String, Catalogue<?>> r3 = catalogueMap;     // Catch: Throwable -> L20
        if (r3.containsKey(catalogueName.toLowerCase(Locale.US)) == true) goto L9;
    L13:
        r3.put(catalogueName.toLowerCase(Locale.US), catalogue);     // Catch: Throwable -> L20
        monitor-exit(Registry.class);
        return;
    L9:
        if (catalogue.getClass().getName().equals(r3.get(catalogueName.toLowerCase(Locale.US)).getClass().getName()) == true) goto L13;
        logger.warning("Attempted overwrite of a catalogueName catalogue for name " + catalogueName);     // Catch: Throwable -> L20
        throw new GeneralSecurityException("catalogue for name " + catalogueName + " has been already registered");     // Catch: Throwable -> L20
    L17:
        throw new IllegalArgumentException("catalogue must be non-null.");     // Catch: Throwable -> L20
    L19:
        throw new IllegalArgumentException("catalogueName must be non-null.");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static Catalogue<?> getCatalogue(String catalogueName) throws GeneralSecurityException {
        if (catalogueName == null) goto L34;
        Catalogue<?> r0 = catalogueMap.get(catalogueName.toLowerCase(Locale.US));
        if (r0 != null) goto L32;
        String r1 = String.format("no catalogue found for %s. ", new Object[]{catalogueName});
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkaead") == false) goto L9;
        r1 = r1 + "Maybe call AeadConfig.register().";
    L9:
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkdeterministicaead") == false) goto L11;
        r1 = r1 + "Maybe call DeterministicAeadConfig.register().";
    L31:
        throw new GeneralSecurityException(r1);
    L11:
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkstreamingaead") == false) goto L13;
        r1 = r1 + "Maybe call StreamingAeadConfig.register().";
        goto L31
    L13:
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") == false) goto L15;
    L27:
        r1 = r1 + "Maybe call HybridConfig.register().";
        goto L31
    L15:
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkhybridencrypt") == true) goto L27;
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkmac") == false) goto L19;
        r1 = r1 + "Maybe call MacConfig.register().";
        goto L31
    L19:
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkpublickeysign") == false) goto L21;
    L25:
        r1 = r1 + "Maybe call SignatureConfig.register().";
        goto L31
    L21:
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkpublickeyverify") == true) goto L25;
        if (catalogueName.toLowerCase(Locale.US).startsWith("tink") == false) goto L31;
        r1 = r1 + "Maybe call TinkConfig.register().";
        goto L31
    L32:
        return r0;
    L34:
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    public static synchronized <P> void registerKeyManager(final KeyManager<P> manager) throws GeneralSecurityException {
        monitor-enter(Registry.class);
        registerKeyManager(manager, true);     // Catch: Throwable -> L8
        monitor-exit(Registry.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static Set<Class<?>> createAllowedPrimitives() {
        HashSet r0 = new HashSet();
        r0.add(Aead.class);
        r0.add(DeterministicAead.class);
        r0.add(StreamingAead.class);
        r0.add(HybridEncrypt.class);
        r0.add(HybridDecrypt.class);
        r0.add(Mac.class);
        r0.add(Prf.class);
        r0.add(PublicKeySign.class);
        r0.add(PublicKeyVerify.class);
        return r0;
    }

    public static synchronized <P> void registerKeyManager(final KeyManager<P> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        monitor-enter(Registry.class);
        if (manager == null) goto L19;
        if (ALLOWED_PRIMITIVES.contains(manager.getPrimitiveClass()) == false) goto L15;
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L13;
        KeyManagerRegistry.globalInstance().registerKeyManager(manager, newKeyAllowed);     // Catch: Throwable -> L16
        monitor-exit(Registry.class);
        return;
    L13:
        throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");     // Catch: Throwable -> L16
    L15:
        throw new GeneralSecurityException("Registration of key managers for class " + manager.getPrimitiveClass() + " has been disabled. Please file an issue on https://github.com/tink-crypto/tink-java");     // Catch: Throwable -> L16
    L19:
        throw new IllegalArgumentException("key manager must be non-null.");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String typeUrl, final KeyManager<P> manager) throws GeneralSecurityException {
        monitor-enter(Registry.class);
        registerKeyManager(typeUrl, manager, true);     // Catch: Throwable -> L8
        monitor-exit(Registry.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String typeUrl, final KeyManager<P> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        monitor-enter(Registry.class);
        if (manager == null) goto L15;
        if (typeUrl.equals(manager.getKeyType()) == false) goto L11;
        registerKeyManager(manager, newKeyAllowed);     // Catch: Throwable -> L12
        monitor-exit(Registry.class);
        return;
    L11:
        throw new GeneralSecurityException("Manager does not support key type " + typeUrl + ".");     // Catch: Throwable -> L12
    L15:
        throw new IllegalArgumentException("key manager must be non-null.");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static <P> KeyManager<P> getKeyManager(String typeUrl, Class<P> primitiveClass) throws GeneralSecurityException {
        return KeyManagerRegistry.globalInstance().getKeyManager(typeUrl, primitiveClass);
    }

    @Deprecated
    public static KeyManager<?> getUntypedKeyManager(String typeUrl) throws GeneralSecurityException {
        return KeyManagerRegistry.globalInstance().getUntypedKeyManager(typeUrl);
    }

    @Deprecated
    public static synchronized KeyData newKeyData(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        monitor-enter(Registry.class);
        KeyManager<?> r2 = KeyManagerRegistry.globalInstance().getUntypedKeyManager(keyTemplate.getTypeUrl());     // Catch: Throwable -> L11
        if (KeyManagerRegistry.globalInstance().isNewKeyAllowed(keyTemplate.getTypeUrl()) == false) goto L10;
        KeyData r5 = r2.newKeyData(keyTemplate.getValue());     // Catch: Throwable -> L11
        monitor-exit(Registry.class);
        return r5;
    L10:
        throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static synchronized KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        monitor-enter(Registry.class);
        byte[] r3 = TinkProtoParametersFormat.serialize(keyTemplate.toParameters());     // Catch: Throwable -> L11
        KeyData r4 = newKeyData(com.google.crypto.tink.proto.KeyTemplate.parseFrom(r3, ExtensionRegistryLite.getEmptyRegistry()));     // Catch: InvalidProtocolBufferException -> L8 Throwable -> L11
        monitor-exit(Registry.class);
        return r4;
    L8:
        e = move-exception;
        throw new GeneralSecurityException("Failed to parse serialized parameters", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static synchronized MessageLite newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        monitor-enter(Registry.class);
        KeyManager<?> r2 = getUntypedKeyManager(keyTemplate.getTypeUrl());     // Catch: Throwable -> L11
        if (KeyManagerRegistry.globalInstance().isNewKeyAllowed(keyTemplate.getTypeUrl()) == false) goto L10;
        MessageLite r5 = r2.newKey(keyTemplate.getValue());     // Catch: Throwable -> L11
        monitor-exit(Registry.class);
        return r5;
    L10:
        throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static synchronized MessageLite newKey(String typeUrl, MessageLite format) throws GeneralSecurityException {
        monitor-enter(Registry.class);
        KeyManager<?> r2 = getUntypedKeyManager(typeUrl);     // Catch: Throwable -> L11
        if (KeyManagerRegistry.globalInstance().isNewKeyAllowed(typeUrl) == false) goto L10;
        MessageLite r4 = r2.newKey(format);     // Catch: Throwable -> L11
        monitor-exit(Registry.class);
        return r4;
    L10:
        throw new GeneralSecurityException("newKey-operation not permitted for key type " + typeUrl);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static KeyData getPublicKeyData(String typeUrl, ByteString serializedPrivateKey) throws GeneralSecurityException {
        KeyManager<?> r0 = getUntypedKeyManager(typeUrl);
        if ((r0 instanceof PrivateKeyManager) == false) goto L7;
        return ((PrivateKeyManager) r0).getPublicKeyData(serializedPrivateKey);
    L7:
        throw new GeneralSecurityException("manager for key type " + typeUrl + " is not a PrivateKeyManager");
    }

    @Deprecated
    public static <P> P getPrimitive(String typeUrl, MessageLite key, Class<P> primitiveClass) throws GeneralSecurityException {
        return KeyManagerRegistry.globalInstance().getKeyManager(typeUrl, primitiveClass).getPrimitive(key.toByteString());
    }

    public static <P> P getPrimitive(String typeUrl, ByteString serializedKey, Class<P> primitiveClass) throws GeneralSecurityException {
        return KeyManagerRegistry.globalInstance().getKeyManager(typeUrl, primitiveClass).getPrimitive(serializedKey);
    }

    public static <P> P getPrimitive(String r0, byte[] r1, Class<P> r2) throws GeneralSecurityException {
        return (P) getPrimitive(r0, ByteString.copyFrom(r1), r2);
    }

    public static <P> P getPrimitive(KeyData r1, Class<P> r2) throws GeneralSecurityException {
        return (P) getPrimitive(r1.getTypeUrl(), r1.getValue(), r2);
    }

    static <KeyT extends Key, P> P getFullPrimitive(KeyT r1, Class<P> r2) throws GeneralSecurityException {
        return (P) MutablePrimitiveRegistry.globalInstance().getPrimitive(r1, r2);
    }

    public static <B, P> P wrap(PrimitiveSet<B> r1, Class<P> r2) throws GeneralSecurityException {
        return (P) MutablePrimitiveRegistry.globalInstance().wrap(r1, r2);
    }

    public static <P> P wrap(PrimitiveSet<P> r1) throws GeneralSecurityException {
        return (P) wrap(r1, r1.getPrimitiveClass());
    }

    public static synchronized List<String> keyTemplates() {
        monitor-enter(Registry.class);
        List<String> r1 = MutableParametersRegistry.globalInstance().getNames();     // Catch: Throwable -> L7
        monitor-exit(Registry.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Nullable
    public static Class<?> getInputPrimitive(Class<?> wrappedPrimitive) {
        return MutablePrimitiveRegistry.globalInstance().getInputPrimitiveClass(wrappedPrimitive);
    L4:
        return null;
    }

    public static synchronized void restrictToFipsIfEmpty() throws GeneralSecurityException {
        monitor-enter(Registry.class);
        KeyManagerRegistry.globalInstance().restrictToFipsIfEmptyAndGlobalInstance();     // Catch: Throwable -> L7
        monitor-exit(Registry.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Registry() {
    }
}
