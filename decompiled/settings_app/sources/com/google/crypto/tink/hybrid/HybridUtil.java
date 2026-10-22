package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.proto.HashType;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes4.dex */
final class HybridUtil {

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.HybridUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType = null;

        static {
            int[] r0 = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = r0;
            r0[HashType.SHA1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA224.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static String toHmacAlgo(HashType hash) throws NoSuchAlgorithmException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
        if (r0 != 1) goto L5;
        return "HmacSha1";
    L5:
        if (r0 != 2) goto L7;
        return "HmacSha224";
    L7:
        if (r0 != 3) goto L9;
        return "HmacSha256";
    L9:
        if (r0 != 4) goto L11;
        return "HmacSha384";
    L11:
        if (r0 != 5) goto L15;
        return "HmacSha512";
    L15:
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: " + hash);
    }

    private HybridUtil() {
    }
}
