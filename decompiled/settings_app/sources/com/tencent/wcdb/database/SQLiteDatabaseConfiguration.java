package com.tencent.wcdb.database;

import com.tencent.wcdb.extension.SQLiteExtension;
import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteDatabaseConfiguration {
    public static final String MEMORY_DB_PATH = ":memory:";
    public boolean customWALHookEnabled;
    public final LinkedHashSet<SQLiteExtension> extensions;
    public boolean foreignKeyConstraintsEnabled;
    public final String label;
    public Locale locale;
    public int maxSqlCacheSize;
    public int openFlags;
    public final String path;
    public int synchronousMode;
    public boolean updateNotificationEnabled;
    public boolean updateNotificationRowID;
    public String vfsName;

    public SQLiteDatabaseConfiguration(String r2, int r3) {
        this.extensions = new LinkedHashSet();
        if (r2 == null) goto L11;
        this.path = r2;
        this.label = r2;
        this.openFlags = r3;
        this.synchronousMode = 2;
        this.maxSqlCacheSize = 25;
        this.locale = Locale.getDefault();
        if ((r3 & 256) == 0) goto L7;
        String r4 = "vfslog";
    L8:
        this.vfsName = r4;
        return;
    L7:
        r4 = null;
        goto L8
    L11:
        throw new IllegalArgumentException("path must not be null.");
    }

    public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration r2) {
        this.extensions = new LinkedHashSet();
        if (r2 == null) goto L7;
        this.path = r2.path;
        this.label = r2.label;
        updateParametersFrom(r2);
        return;
    L7:
        throw new IllegalArgumentException("other must not be null.");
    }

    public void updateParametersFrom(SQLiteDatabaseConfiguration r3) {
        if (r3 == null) goto L10;
        if (this.path.equals(r3.path) == false) goto L8;
        this.openFlags = r3.openFlags;
        this.maxSqlCacheSize = r3.maxSqlCacheSize;
        this.locale = r3.locale;
        this.foreignKeyConstraintsEnabled = r3.foreignKeyConstraintsEnabled;
        this.customWALHookEnabled = r3.customWALHookEnabled;
        this.updateNotificationEnabled = r3.updateNotificationEnabled;
        this.updateNotificationRowID = r3.updateNotificationRowID;
        this.synchronousMode = r3.synchronousMode;
        this.vfsName = r3.vfsName;
        this.extensions.clear();
        this.extensions.addAll(r3.extensions);
        return;
    L8:
        throw new IllegalArgumentException("other configuration must refer to the same database.");
    L10:
        throw new IllegalArgumentException("other must not be null.");
    }

    public boolean isInMemoryDb() {
        return this.path.equalsIgnoreCase(MEMORY_DB_PATH);
    }
}
