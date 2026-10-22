package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class MutableKeyDerivationRegistry {
    private static final MutableKeyDerivationRegistry globalInstance = null;
    private final Map<Class<? extends Parameters>, InsecureKeyCreator<? extends Parameters>> creators;

    public interface InsecureKeyCreator<ParametersT extends Parameters> {
        Key createKeyFromRandomness(ParametersT parameters, InputStream inputStream, @Nullable Integer idRequirement, SecretKeyAccess access) throws GeneralSecurityException;
    }

    public MutableKeyDerivationRegistry() {
        this.creators = new HashMap();
    }

    static {
        globalInstance = new MutableKeyDerivationRegistry();
    }

    public static MutableKeyDerivationRegistry globalInstance() {
        return globalInstance;
    }

    public synchronized <ParametersT extends Parameters> void add(InsecureKeyCreator<ParametersT> creator, Class<ParametersT> parametersClass) throws GeneralSecurityException {
        monitor-enter(this);
        InsecureKeyCreator<? extends Parameters> r0 = this.creators.get(parametersClass);     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L10:
        this.creators.put(parametersClass, creator);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        if (r0.equals(creator) == true) goto L10;
        throw new GeneralSecurityException("Different key creator for parameters class already inserted");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public Key createKeyFromRandomness(Parameters parameters, InputStream inputStream, @Nullable Integer idRequirement, SecretKeyAccess access) throws GeneralSecurityException {
        return createKeyFromRandomnessTyped(parameters, inputStream, idRequirement, access);
    }

    private synchronized <ParametersT extends Parameters> Key createKeyFromRandomnessTyped(ParametersT parameters, InputStream inputStream, @Nullable Integer idRequirement, SecretKeyAccess access) throws GeneralSecurityException {
        monitor-enter(this);
        InsecureKeyCreator<? extends Parameters> r1 = this.creators.get(parameters.getClass());     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        Key r4 = r1.createKeyFromRandomness(parameters, inputStream, idRequirement, access);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    L10:
        throw new GeneralSecurityException("Cannot use key derivation to derive key for parameters " + parameters + ": no key creator for this class was registered.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
