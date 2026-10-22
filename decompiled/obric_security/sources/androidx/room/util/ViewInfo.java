package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/util/ViewInfo;", "", "name", "", "sql", "(Ljava/lang/String;Ljava/lang/String;)V", "equals", "", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewInfo {
    public static final Companion Companion = null;
    public final String name;
    public final String sql;

    /* JADX INFO: compiled from: ViewInfo.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/room/util/ViewInfo$Companion;", "", "()V", ProviderConstants.Sms.READ, "Landroidx/room/util/ViewInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "viewName", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ViewInfo read(SupportSQLiteDatabase r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "database");
            Intrinsics.checkNotNullParameter(r5, "viewName");
            Cursor r3 = r4.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + r5 + '\'');
            Cursor r6 = r3;     // Catch: Throwable -> L10
            if (r6.moveToFirst() == false) goto L7;
            String r0 = r6.getString(0);     // Catch: Throwable -> L10
            Intrinsics.checkNotNullExpressionValue(r0, "cursor.getString(0)");     // Catch: Throwable -> L10
            ViewInfo r7 = new ViewInfo(r0, r6.getString(1));     // Catch: Throwable -> L10
        L8:
            CloseableKt.closeFinally(r3, null);
            return r7;
        L7:
            r7 = new ViewInfo(r5, null);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            CloseableKt.closeFinally(r3, th);
            throw th;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final ViewInfo read(SupportSQLiteDatabase r1, String r2) {
        return Companion.read(r1, r2);
    }

    public ViewInfo(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.name = r2;
        this.sql = r3;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ViewInfo) == true) goto L8;
        return false;
    L8:
        ViewInfo r6 = (ViewInfo) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == false) goto L20;
        String r4 = this.sql;
        if (r4 == null) goto L14;
        boolean r7 = Intrinsics.areEqual(r4, r6.sql);
    L17:
        if (r7 == false) goto L20;
        return true;
    L14:
        if (r6.sql != null) goto L16;
        r7 = true;
        goto L17
    L16:
        r7 = false;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.name.hashCode() * 31;
        String r1 = this.sql;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }
}
