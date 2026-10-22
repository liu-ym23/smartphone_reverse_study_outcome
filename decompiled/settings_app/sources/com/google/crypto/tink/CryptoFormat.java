package com.google.crypto.tink;

import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class CryptoFormat {
    public static final int LEGACY_PREFIX_SIZE = 5;
    public static final byte LEGACY_START_BYTE = 0;
    public static final int NON_RAW_PREFIX_SIZE = 5;
    public static final byte[] RAW_PREFIX = null;
    public static final int RAW_PREFIX_SIZE = 0;
    public static final int TINK_PREFIX_SIZE = 5;
    public static final byte TINK_START_BYTE = 1;

    /* JADX INFO: renamed from: com.google.crypto.tink.CryptoFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = null;

        static {
            int[] r0 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r0;
            r0[OutputPrefixType.LEGACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.TINK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        RAW_PREFIX = new byte[0];
    }

    public static byte[] getOutputPrefix(Keyset.Key key) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[key.getOutputPrefixType().ordinal()];
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return RAW_PREFIX;
    L13:
        throw new GeneralSecurityException("unknown output prefix type");
    L15:
        return OutputPrefixUtil.getTinkOutputPrefix(key.getKeyId()).toByteArray();
    L17:
        return OutputPrefixUtil.getLegacyOutputPrefix(key.getKeyId()).toByteArray();
    }

    private CryptoFormat() {
    }
}
