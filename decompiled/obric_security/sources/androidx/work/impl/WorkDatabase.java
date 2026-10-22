package androidx.work.impl;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkDatabase.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0014"}, d2 = {"Landroidx/work/impl/WorkDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dependencyDao", "Landroidx/work/impl/model/DependencyDao;", "preferenceDao", "Landroidx/work/impl/model/PreferenceDao;", "rawWorkInfoDao", "Landroidx/work/impl/model/RawWorkInfoDao;", "systemIdInfoDao", "Landroidx/work/impl/model/SystemIdInfoDao;", "workNameDao", "Landroidx/work/impl/model/WorkNameDao;", "workProgressDao", "Landroidx/work/impl/model/WorkProgressDao;", "workSpecDao", "Landroidx/work/impl/model/WorkSpecDao;", "workTagDao", "Landroidx/work/impl/model/WorkTagDao;", "Companion", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class WorkDatabase extends RoomDatabase {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: WorkDatabase.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/work/impl/WorkDatabase$Companion;", "", "()V", "create", "Landroidx/work/impl/WorkDatabase;", "context", "Landroid/content/Context;", "queryExecutor", "Ljava/util/concurrent/Executor;", "useTestDatabase", "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public static /* synthetic */ SupportSQLiteOpenHelper $r8$lambda$ZkS5S0p_73DOI66Tm39UHOpqbt0(Context r0, SupportSQLiteOpenHelper.Configuration r1) {
            return create$lambda$0(r0, r1);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final WorkDatabase create(final Context r5, Executor r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "queryExecutor");
            if (r7 == false) goto L5;
            RoomDatabase.Builder r4 = Room.inMemoryDatabaseBuilder(r5, WorkDatabase.class).allowMainThreadQueries();
        L7:
            return (WorkDatabase) r4.setQueryExecutor(r6).addCallback(CleanupCallback.INSTANCE).addMigrations(new Migration[]{Migration_1_2.INSTANCE}).addMigrations(new Migration[]{new RescheduleMigration(r5, 2, 3)}).addMigrations(new Migration[]{Migration_3_4.INSTANCE}).addMigrations(new Migration[]{Migration_4_5.INSTANCE}).addMigrations(new Migration[]{new RescheduleMigration(r5, 5, 6)}).addMigrations(new Migration[]{Migration_6_7.INSTANCE}).addMigrations(new Migration[]{Migration_7_8.INSTANCE}).addMigrations(new Migration[]{Migration_8_9.INSTANCE}).addMigrations(new Migration[]{new WorkMigration9To10(r5)}).addMigrations(new Migration[]{new RescheduleMigration(r5, 10, 11)}).addMigrations(new Migration[]{Migration_11_12.INSTANCE}).addMigrations(new Migration[]{Migration_12_13.INSTANCE}).addMigrations(new Migration[]{Migration_15_16.INSTANCE}).fallbackToDestructiveMigration().build();
        L5:
            r4 = Room.databaseBuilder(r5, WorkDatabase.class, WorkDatabasePathHelperKt.WORK_DATABASE_NAME).openHelperFactory(new WorkDatabase$Companion$$ExternalSyntheticLambda0(r5));
            goto L7
        }

        private static final SupportSQLiteOpenHelper create$lambda$0(Context r1, SupportSQLiteOpenHelper.Configuration r2) {
            Intrinsics.checkNotNullParameter(r1, "$context");
            Intrinsics.checkNotNullParameter(r2, "configuration");
            SupportSQLiteOpenHelper.Configuration.Builder r3 = SupportSQLiteOpenHelper.Configuration.Companion.builder(r1);
            r3.name(r2.name).callback(r2.callback).noBackupDirectory(true).allowDataLossOnRecovery(true);
            return new FrameworkSQLiteOpenHelperFactory().create(r3.build());
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final WorkDatabase create(Context r1, Executor r2, boolean r3) {
        return Companion.create(r1, r2, r3);
    }

    public abstract DependencyDao dependencyDao();

    public abstract PreferenceDao preferenceDao();

    public abstract RawWorkInfoDao rawWorkInfoDao();

    public abstract SystemIdInfoDao systemIdInfoDao();

    public abstract WorkNameDao workNameDao();

    public abstract WorkProgressDao workProgressDao();

    public abstract WorkSpecDao workSpecDao();

    public abstract WorkTagDao workTagDao();

    public WorkDatabase() {
    }
}
