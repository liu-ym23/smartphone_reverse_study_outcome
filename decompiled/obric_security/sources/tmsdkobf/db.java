package tmsdkobf;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
public class db extends oa {
    private static final boolean n = false;
    public static final oa.c o = null;

    class a implements oa.c {
        a() {
        }

        @Override // tmsdkobf.oa.c
        public void a(SQLiteDatabase r1) {
            r1.execSQL("CREATE TABLE IF NOT EXISTS team_tables(team_name TEXT primary key, team_version int not null)");
            db.m2376$$Nest$sma(r1);
        }

        @Override // tmsdkobf.oa.c
        public void b(SQLiteDatabase r1, int r2, int r3) {
            r1.execSQL("CREATE TABLE IF NOT EXISTS team_tables(team_name TEXT primary key, team_version int not null)");
            if (r3 >= r2) goto L5;
            db.m2377$$Nest$sma(r1, r2, r3);
            return;
        L5:
            db.m2378$$Nest$smb(r1, r2, r3);
        }

        @Override // tmsdkobf.oa.c
        public void a(SQLiteDatabase r1, int r2, int r3) {
            r1.execSQL("CREATE TABLE IF NOT EXISTS team_tables(team_name TEXT primary key, team_version int not null)");
            db.m2377$$Nest$sma(r1, r2, r3);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2376$$Nest$sma(SQLiteDatabase r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$sma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2377$$Nest$sma(SQLiteDatabase r0, int r1, int r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2378$$Nest$smb(SQLiteDatabase r0, int r1, int r2) {
        b(r0, r1, r2);
    }

    static {
        n = q8.a();
        o = new a();
    }

    public db() {
        super("qqsecure.db", 20, o);
    }

    private static void a(SQLiteDatabase r2) {
        if (n == false) goto L5;
        q8.a("QQSecureProvider", "invoke createPhoneSqliteData");
    L5:
        y3.a(r2);
        h.a(r2);
        qa.a(r2);
        c8.a(r2);
        de.a(r2);
        tmsdk.common.module.qscanner.impl.a.f45a.a(r2);
    }

    private static void b(SQLiteDatabase r2, int r3, int r4) {
        if (n == false) goto L5;
        q8.a("QQSecureProvider", "invoke upgradePhoneSqliteData");
    L5:
        y3.b(r2, r3, r4);
        h.b(r2, r3, r4);
        qa.b(r2, r3, r4);
        c8.b(r2, r3, r4);
        de.b(r2, r3, r4);
        tmsdk.common.module.qscanner.impl.a.f45a.c(r2);
    }

    private static void a(SQLiteDatabase r2, int r3, int r4) {
        if (n == false) goto L5;
        q8.a("QQSecureProvider", "invoke downgradePhoneSqliteData");
    L5:
        y3.a(r2, r3, r4);
        h.a(r2, r3, r4);
        qa.a(r2, r3, r4);
        c8.a(r2, r3, r4);
        de.a(r2, r3, r4);
        tmsdk.common.module.qscanner.impl.a.f45a.b(r2);
    }
}
