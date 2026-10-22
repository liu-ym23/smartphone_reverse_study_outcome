package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.exifinterface.media.ExifInterface;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SQLiteDatabase.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"transaction", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", ProviderConstants.Sms.BODY, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SQLiteDatabaseKt {
    public static /* synthetic */ Object transaction$default(SQLiteDatabase r0, boolean r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = true;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r2, ProviderConstants.Sms.BODY);
        if (r1 == false) goto L8;
        r0.beginTransaction();
    L15:
        Object r5 = r2.invoke(r0);     // Catch: Throwable -> L12
        r0.setTransactionSuccessful();     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        r0.endTransaction();
        InlineMarker.finallyEnd(1);
        return r5;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.endTransaction();
        InlineMarker.finallyEnd(1);
        throw th;
    L8:
        r0.beginTransactionNonExclusive();
        goto L15
    }

    public static final <T> T transaction(SQLiteDatabase r1, boolean r2, Function1<? super SQLiteDatabase, ? extends T> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, ProviderConstants.Sms.BODY);
        if (r2 == false) goto L5;
        r1.beginTransaction();
    L13:
        T r4 = r3.invoke(r1);     // Catch: Throwable -> L10
        r1.setTransactionSuccessful();     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        r1.endTransaction();
        InlineMarker.finallyEnd(1);
        return r4;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.endTransaction();
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r1.beginTransactionNonExclusive();
        goto L13
    }
}
