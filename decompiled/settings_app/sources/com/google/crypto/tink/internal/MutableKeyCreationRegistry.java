package com.google.crypto.tink.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class MutableKeyCreationRegistry {
    private static final KeyCreator<LegacyProtoParameters> LEGACY_PROTO_KEY_CREATOR = null;
    private static final MutableKeyCreationRegistry globalInstance = null;
    private final Map<Class<? extends Parameters>, KeyCreator<? extends Parameters>> creators;

    public interface KeyCreator<ParametersT extends Parameters> {
        Key createKey(ParametersT parameters, @Nullable Integer idRequirement) throws GeneralSecurityException;
    }

    public static /* synthetic */ LegacyProtoKey $r8$lambda$lEksxhw_sF8gpId1LU0Uu8vS08I(LegacyProtoParameters r0, Integer r1) {
        return createProtoKeyFromProtoParmaeters(r0, r1);
    }

    public MutableKeyCreationRegistry() {
        this.creators = new HashMap();
    }

    private static LegacyProtoKey createProtoKeyFromProtoParmaeters(LegacyProtoParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        KeyTemplate r3 = parameters.getSerialization().getKeyTemplate();
        KeyManager<?> r0 = KeyManagerRegistry.globalInstance().getUntypedKeyManager(r3.getTypeUrl());
        if (KeyManagerRegistry.globalInstance().isNewKeyAllowed(r3.getTypeUrl()) == false) goto L7;
        KeyData r1 = r0.newKeyData(r3.getValue());
        return new LegacyProtoKey(ProtoKeySerialization.create(r1.getTypeUrl(), r1.getValue(), r1.getKeyMaterialType(), r3.getOutputPrefixType(), idRequirement), InsecureSecretKeyAccess.get());
    L7:
        throw new GeneralSecurityException("Creating new keys is not allowed.");
    }

    static {
        LEGACY_PROTO_KEY_CREATOR = new MutableKeyCreationRegistry$$ExternalSyntheticLambda0();
        globalInstance = newRegistryWithLegacyFallback();
    }

    private static MutableKeyCreationRegistry newRegistryWithLegacyFallback() {
        MutableKeyCreationRegistry r0 = new MutableKeyCreationRegistry();
        r0.add(LEGACY_PROTO_KEY_CREATOR, LegacyProtoParameters.class);     // Catch: GeneralSecurityException -> L5
        return r0;
    L5:
        e = move-exception;
        throw new IllegalStateException("unexpected error.", e);
    }

    public static MutableKeyCreationRegistry globalInstance() {
        return globalInstance;
    }

    public synchronized <ParametersT extends Parameters> void add(KeyCreator<ParametersT> creator, Class<ParametersT> parametersClass) throws GeneralSecurityException {
        monitor-enter(this);
        KeyCreator<? extends Parameters> r1 = this.creators.get(parametersClass);     // Catch: Throwable -> L14
        if (r1 != null) goto L7;
    L11:
        this.creators.put(parametersClass, creator);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L7:
        if (r1.equals(creator) == true) goto L11;
        throw new GeneralSecurityException("Different key creator for parameters class " + parametersClass + " already inserted");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public Key createKey(Parameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        return createKeyTyped(parameters, idRequirement);
    }

    private synchronized <ParametersT extends Parameters> Key createKeyTyped(ParametersT parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        monitor-enter(this);
        KeyCreator<? extends Parameters> r1 = this.creators.get(parameters.getClass());     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        Key r4 = r1.createKey(parameters, idRequirement);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    L10:
        throw new GeneralSecurityException("Cannot create a new key for parameters " + parameters + ": no key creator for this class was registered.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
