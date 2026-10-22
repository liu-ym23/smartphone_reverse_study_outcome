package com.obric.dejavu.library.cipher;

import android.content.Context;
import com.obric.dejavu.library.DbInstance;
import com.obric.dejavu.library.DbKvResult;
import com.obric.dejavu.library.DbLogWriter;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbOptions;
import com.obric.dejavu.library.DbStatus;
import com.obric.dejavu.library.LogLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DbCipherInstance.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherInstance;", "Lcom/obric/dejavu/library/DbInstance;", "()V", "searchAndDecrypt", "Lcom/obric/dejavu/library/DbKvResult;", "key", "", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class DbCipherInstance extends DbInstance {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: DbCipherInstance.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ0\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¨\u0006\u0019"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherInstance$Companion;", "", "()V", "openDb", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/cipher/DbCipherInstance;", "Lcom/obric/dejavu/library/cipher/DbCipherOpenResult;", "context", "Landroid/content/Context;", "dirPrefix", "", "opt", "Lcom/obric/dejavu/library/DbOptions;", "cryptoOpt", "Lcom/obric/dejavu/library/cipher/CryptoOptions;", "dbName", "removeDb", "Lcom/obric/dejavu/library/DbStatus;", "setLogLevel", "", "level", "Lcom/obric/dejavu/library/LogLevel;", "setLogWriter", "writer", "Lcom/obric/dejavu/library/DbLogWriter;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final DbObjResult<DbCipherInstance> openDb(Context r1, String r2, DbOptions r3, CryptoOptions r4) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "dirPrefix");
            Intrinsics.checkNotNullParameter(r3, "opt");
            Intrinsics.checkNotNullParameter(r4, "cryptoOpt");
            return DbCipherInstanceImpl.Companion.openDb(r1, r2, r3, r4);
        }

        public final DbObjResult<DbCipherInstance> openDb(Context r1, String r2, String r3, CryptoOptions r4) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "dirPrefix");
            Intrinsics.checkNotNullParameter(r3, "dbName");
            Intrinsics.checkNotNullParameter(r4, "cryptoOpt");
            return DbCipherInstanceImpl.Companion.openDb(r1, r2, r3, r4);
        }

        public final DbStatus removeDb(Context r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "dirPrefix");
            Intrinsics.checkNotNullParameter(r3, "dbName");
            return DbInstance.Companion.removeDb(r2, r3);
        }

        public final void setLogLevel(LogLevel r1) {
            Intrinsics.checkNotNullParameter(r1, "level");
            DbInstance.Companion.setLogLevel(r1);
        }

        public final void setLogWriter(DbLogWriter r1) {
            DbInstance.Companion.setLogWriter(r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract DbKvResult searchAndDecrypt(String r1);

    public DbCipherInstance() {
    }
}
