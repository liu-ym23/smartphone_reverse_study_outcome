package com.google.crypto.tink.config.internal;

import com.google.crypto.tink.internal.Random;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class TinkFipsUtil {
    private static final AtomicBoolean isRestrictedToFips = null;
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.config.internal.TinkFipsUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract enum AlgorithmFipsCompatibility extends Enum<AlgorithmFipsCompatibility> {
        private static final /* synthetic */ AlgorithmFipsCompatibility[] $VALUES = null;
        public static final AlgorithmFipsCompatibility ALGORITHM_NOT_FIPS = null;
        public static final AlgorithmFipsCompatibility ALGORITHM_REQUIRES_BORINGCRYPTO = null;

        public abstract boolean isCompatible();

        private AlgorithmFipsCompatibility(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        /* synthetic */ AlgorithmFipsCompatibility(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static AlgorithmFipsCompatibility valueOf(String name) {
            return (AlgorithmFipsCompatibility) Enum.valueOf(AlgorithmFipsCompatibility.class, name);
        }

        public static AlgorithmFipsCompatibility[] values() {
            return (AlgorithmFipsCompatibility[]) $VALUES.clone();
        }

        static {
            final String r1 = "ALGORITHM_NOT_FIPS";
            final int r2 = 0;
            AlgorithmFipsCompatibility r0 = new AnonymousClass1(r1, r2);
            ALGORITHM_NOT_FIPS = r0;
            final String r3 = "ALGORITHM_REQUIRES_BORINGCRYPTO";
            final int r4 = 1;
            AlgorithmFipsCompatibility r5 = new AnonymousClass2(r3, r4);
            ALGORITHM_REQUIRES_BORINGCRYPTO = r5;
            $VALUES = new AlgorithmFipsCompatibility[]{r0, r5};
        }
    }

    static {
        logger = Logger.getLogger(TinkFipsUtil.class.getName());
        isRestrictedToFips = new AtomicBoolean(false);
    }

    public static void setFipsRestricted() throws GeneralSecurityException {
        if (checkConscryptIsAvailableAndUsesFipsBoringSsl().booleanValue() == false) goto L7;
        Random.validateUsesConscrypt();
        isRestrictedToFips.set(true);
        return;
    L7:
        throw new GeneralSecurityException("Conscrypt is not available or does not support checking for FIPS build.");
    }

    public static void unsetFipsRestricted() {
        isRestrictedToFips.set(false);
    }

    public static boolean useOnlyFips() {
        if (TinkFipsStatus.useOnlyFips() == false) goto L5;
    L8:
        return true;
    L5:
        if (isRestrictedToFips.get() == true) goto L8;
        return false;
    }

    public static boolean fipsModuleAvailable() {
        return checkConscryptIsAvailableAndUsesFipsBoringSsl().booleanValue();
    }

    static Boolean checkConscryptIsAvailableAndUsesFipsBoringSsl() {
        return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", new Class[0]).invoke(null, new Object[0]);
    L5:
        logger.info("Conscrypt is not available or does not support checking for FIPS build.");
        return false;
    }

    private TinkFipsUtil() {
    }
}
