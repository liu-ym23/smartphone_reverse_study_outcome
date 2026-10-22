package com.google.crypto.tink;

import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
@CheckReturnValue
public final class SecretKeyAccess {
    private static final SecretKeyAccess INSTANCE = null;

    private SecretKeyAccess() {
    }

    static {
        INSTANCE = new SecretKeyAccess();
    }

    static SecretKeyAccess instance() {
        return INSTANCE;
    }

    public static SecretKeyAccess requireAccess(@Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (access == null) goto L5;
        return access;
    L5:
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }
}
