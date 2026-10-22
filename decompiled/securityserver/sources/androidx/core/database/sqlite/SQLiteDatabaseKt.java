package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(@NotNull SQLiteDatabase r1, boolean r2, @NotNull Function1<? super SQLiteDatabase, ? extends T> r3) {
        Intrinsics.g(r1, "$this$transaction");
        Intrinsics.g(r3, "body");
        if (r2 == false) goto L5;
        r1.beginTransaction();
    L12:
        T r4 = (T) r3.invoke(r1);
        r1.setTransactionSuccessful();     // Catch: Throwable -> L9
        r1.endTransaction();
        return r4;
    L9:
        th = move-exception;
        r1.endTransaction();
        throw th;
    L5:
        r1.beginTransactionNonExclusive();
        goto L12
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase r0, boolean r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = true;
    L5:
        Intrinsics.g(r0, "$this$transaction");
        Intrinsics.g(r2, "body");
        if (r1 == false) goto L8;
        r0.beginTransaction();
    L15:
        Object r5 = r2.invoke(r0);     // Catch: Throwable -> L12
        r0.setTransactionSuccessful();     // Catch: Throwable -> L12
        r0.endTransaction();
        return r5;
    L12:
        th = move-exception;
        r0.endTransaction();
        throw th;
    L8:
        r0.beginTransactionNonExclusive();
        goto L15
    }
}
