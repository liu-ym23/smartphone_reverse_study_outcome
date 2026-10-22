package com.obric.safecheck.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.obric.safecheck.database.dao.VirusApkDao;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirusDatabase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/obric/safecheck/database/VirusDatabase;", "Landroidx/room/RoomDatabase;", "()V", "virusApkDao", "Lcom/obric/safecheck/database/dao/VirusApkDao;", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public abstract class VirusDatabase extends RoomDatabase {
    public static final Companion Companion = null;
    private static volatile VirusDatabase INSTANCE;
    public static final Migration MIGRATION_1_2 = null;

    /* JADX INFO: compiled from: VirusDatabase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/safecheck/database/VirusDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/obric/safecheck/database/VirusDatabase;", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getDatabase", "context", "Landroid/content/Context;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final VirusDatabase getDatabase(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            VirusDatabase r0 = VirusDatabase.access$getINSTANCE$cp();
            if (r0 != null) goto L14;
            monitor-enter(this);
            r0 = VirusDatabase.access$getINSTANCE$cp();     // Catch: Throwable -> L11
            if (r0 != null) goto L9;
            Context r5 = r4.getApplicationContext();     // Catch: Throwable -> L11
            Intrinsics.checkNotNullExpressionValue(r5, "context.applicationContext");     // Catch: Throwable -> L11
            RoomDatabase r6 = Room.databaseBuilder(r5, VirusDatabase.class, "virus_apk.db").addMigrations(new Migration[]{VirusDatabase.MIGRATION_1_2}).build();     // Catch: Throwable -> L11
            VirusDatabase.access$setINSTANCE$cp((VirusDatabase) r6);     // Catch: Throwable -> L11
            r0 = (VirusDatabase) r6;     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);
        L11:
            th = move-exception;
            throw th;
        L14:
            return r0;
        }
    }

    @JvmStatic
    public static final VirusDatabase getDatabase(Context r1) {
        return Companion.getDatabase(r1);
    }

    public abstract VirusApkDao virusApkDao();

    public VirusDatabase() {
    }

    public static final /* synthetic */ VirusDatabase access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(VirusDatabase r0) {
        INSTANCE = r0;
    }

    static {
        Companion = new Companion(null);
        final int r1 = 1;
        final int r2 = 2;
        MIGRATION_1_2 = new VirusDatabase$Companion$MIGRATION_1_2$1(r1, r2);
    }
}
