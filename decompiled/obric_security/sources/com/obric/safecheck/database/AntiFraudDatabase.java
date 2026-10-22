package com.obric.safecheck.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.obric.safecheck.database.dao.EndDataDao;
import com.obric.safecheck.database.dao.GxbAntiFraudRuleDao;
import com.obric.safecheck.database.dao.PhoneDao;
import com.obric.safecheck.database.dao.PkgSignDao;
import com.obric.safecheck.database.dao.UrlDomainDao;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AntiFraudDatabase extends RoomDatabase {
    private static volatile AntiFraudDatabase INSTANCE;
    static final Migration MIGRATION_2_3 = null;
    static final Migration MIGRATION_3_4 = null;

    public abstract EndDataDao endDataDao();

    public abstract GxbAntiFraudRuleDao gxbAntiFraudRuleDao();

    public abstract PhoneDao phoneDao();

    public abstract PkgSignDao pkgSignDao();

    public abstract UrlDomainDao urlDomainDao();

    public AntiFraudDatabase() {
    }

    public static AntiFraudDatabase getDatabase(final Context context) {
        if (INSTANCE != null) goto L15;
        monitor-enter(AntiFraudDatabase.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = (AntiFraudDatabase) Room.databaseBuilder(context.getApplicationContext(), AntiFraudDatabase.class, "anti_fraud.dp").allowMainThreadQueries().addMigrations(new Migration[]{MIGRATION_2_3, MIGRATION_3_4}).build();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AntiFraudDatabase.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    static {
        final int r1 = 2;
        final int r2 = 3;
        MIGRATION_2_3 = new AnonymousClass1(r1, r2);
        final int r3 = 4;
        MIGRATION_3_4 = new AnonymousClass2(r2, r3);
    }
}
