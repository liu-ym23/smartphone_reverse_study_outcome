package com.obric.dejavu.library.cipher;

import com.obric.dejavu.library.DbStatus;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DbCipherUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherUtils;", "", "()V", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbCipherUtils {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: DbCipherUtils.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherUtils$Companion;", "", "()V", "checkCryptoOptions", "Lcom/obric/dejavu/library/DbStatus;", "cryptoOpt", "Lcom/obric/dejavu/library/cipher/CryptoOptions;", "generateRandomSeed", "", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final String generateRandomSeed() {
            byte[] r1 = new byte[32];
            new SecureRandom().nextBytes(r1);
            return ArraysKt.joinToString$default(r1, "", null, null, 0, null, DbCipherUtils$Companion$generateRandomSeed$1.INSTANCE, 30, null);
        }

        public final DbStatus checkCryptoOptions(CryptoOptions r2) {
            Intrinsics.checkNotNullParameter(r2, "cryptoOpt");
            if (r2.getSeed().length() >= 64) goto L6;
            return DbCipherErrors.INSTANCE.getERR_SEED_TOO_SHORT();
        L6:
            if (r2.getSeed().length() <= 128) goto L9;
            return DbCipherErrors.INSTANCE.getERR_SEED_TOO_LARGE();
        L9:
            return DbStatus.Companion.getSuccess();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DbCipherUtils() {
    }
}
