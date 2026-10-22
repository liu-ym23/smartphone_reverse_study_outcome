package androidx.work.impl;

import android.content.Context;
import androidx.work.Logger;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WorkDatabasePathHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Landroidx/work/impl/WorkDatabasePathHelper;", "", "()V", "getDatabasePath", "Ljava/io/File;", "context", "Landroid/content/Context;", "getDefaultDatabasePath", "getNoBackupPath", "migrateDatabase", "", "migrationPaths", "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WorkDatabasePathHelper {
    public static final WorkDatabasePathHelper INSTANCE = null;

    static {
        INSTANCE = new WorkDatabasePathHelper();
    }

    private WorkDatabasePathHelper() {
    }

    @JvmStatic
    public static final void migrateDatabase(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        WorkDatabasePathHelper r0 = INSTANCE;
        if (r0.getDefaultDatabasePath(r6).exists() == false) goto L17;
        Logger.get().debug(WorkDatabasePathHelperKt.access$getTAG$p(), "Migrating WorkDatabase to the no-backup directory");
        Iterator<Map.Entry<File, File>> r7 = r0.migrationPaths(r6).entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L23;
        Map.Entry<File, File> r1 = r7.next();
        File r2 = r1.getKey();
        File r3 = r1.getValue();
        if (r2.exists() == false) goto L6;
        if (r3.exists() == false) goto L13;
        Logger.get().warning(WorkDatabasePathHelperKt.access$getTAG$p(), "Over-writing contents of " + r3);
    L13:
        if (r2.renameTo(r3) == false) goto L15;
        String r4 = "Migrated " + r2 + "to " + r3;
    L16:
        Logger.get().debug(WorkDatabasePathHelperKt.access$getTAG$p(), r4);
        goto L6
    L15:
        r4 = "Renaming " + r2 + " to " + r3 + " failed";
        goto L16
    L23:
        return;
    }

    public final Map<File, File> migrationPaths(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        File r0 = getDefaultDatabasePath(r10);
        File r9 = getDatabasePath(r10);
        String[] r11 = WorkDatabasePathHelperKt.access$getDATABASE_EXTRA_FILES$p();
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r11.length), 16));
        int r1 = r11.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        String r4 = r11[r3];
        Pair r5 = TuplesKt.to(new File(r0.getPath() + r4), new File(r9.getPath() + r4));
        r2.put(r5.getFirst(), r5.getSecond());
        r3 = r3 + 1;
        goto L3
    L6:
        return MapsKt.plus(r2, TuplesKt.to(r0, r9));
    }

    public final File getDefaultDatabasePath(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        File r0 = r1.getDatabasePath(WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
        Intrinsics.checkNotNullExpressionValue(r0, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return r0;
    }

    public final File getDatabasePath(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return getNoBackupPath(r2);
    }

    private final File getNoBackupPath(Context r2) {
        return new File(Api21Impl.INSTANCE.getNoBackupFilesDir(r2), WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
    }
}
