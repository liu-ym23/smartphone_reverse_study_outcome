package com.google.crypto.tink;

import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.proto.KeyTypeEntry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class Config {
    public static KeyTypeEntry getTinkKeyTypeEntry(String catalogueName, String primitiveName, String keyProtoName, int keyManagerVersion, boolean newKeyAllowed) {
        return (KeyTypeEntry) KeyTypeEntry.newBuilder().setPrimitiveName(primitiveName).setTypeUrl("type.googleapis.com/google.crypto.tink." + keyProtoName).setKeyManagerVersion(keyManagerVersion).setNewKeyAllowed(newKeyAllowed).setCatalogueName(catalogueName).build();
    }

    public static void register(RegistryConfig config) throws GeneralSecurityException {
        Iterator<KeyTypeEntry> r1 = config.getEntryList().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        registerKeyType(r1.next());
        goto L4
    }

    public static void registerKeyType(KeyTypeEntry entry) throws GeneralSecurityException {
        validate(entry);
        if (entry.getCatalogueName().equals("TinkAead") == false) goto L5;
        return;
    L5:
        if (entry.getCatalogueName().equals("TinkMac") == false) goto L7;
        return;
    L7:
        if (entry.getCatalogueName().equals("TinkHybridDecrypt") == false) goto L9;
        return;
    L9:
        if (entry.getCatalogueName().equals("TinkHybridEncrypt") == false) goto L11;
        return;
    L11:
        if (entry.getCatalogueName().equals("TinkPublicKeySign") == false) goto L13;
        return;
    L13:
        if (entry.getCatalogueName().equals("TinkPublicKeyVerify") == false) goto L15;
        return;
    L15:
        if (entry.getCatalogueName().equals("TinkStreamingAead") == false) goto L17;
        return;
    L17:
        if (entry.getCatalogueName().equals("TinkDeterministicAead") == true) goto L28;
        Catalogue<?> r0 = Registry.getCatalogue(entry.getCatalogueName());
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(r0.getPrimitiveWrapper());
        Registry.registerKeyManager(r0.getKeyManager(entry.getTypeUrl(), entry.getPrimitiveName(), entry.getKeyManagerVersion()), entry.getNewKeyAllowed());
        return;
    }

    private static void validate(KeyTypeEntry entry) throws GeneralSecurityException {
        if (entry.getTypeUrl().isEmpty() == true) goto L14;
        if (entry.getPrimitiveName().isEmpty() == true) goto L12;
        if (entry.getCatalogueName().isEmpty() == true) goto L10;
        return;
    L10:
        throw new GeneralSecurityException("Missing catalogue_name.");
    L12:
        throw new GeneralSecurityException("Missing primitive_name.");
    L14:
        throw new GeneralSecurityException("Missing type_url.");
    }

    private Config() {
    }
}
