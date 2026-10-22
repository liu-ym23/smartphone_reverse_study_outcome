package com.android.settings.fuelgauge;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class PowerUsageDataHelper extends SQLiteOpenHelper {
    private static final String DB_CREATE = "create table powerusage (_id integer primary key autoincrement,time long,elapsedrealtime long,drainType text,value double,cpuTimeMs long,gpsTimeMs long,wifiRunningTimeMs long,cpuFgTimeMs long,wakeLockTimeMs long,cameraTimeMs long,flashlightTimeMs long,bluetoothRunningTimeMs long,uid int,name text,package_name text);";
    public static final String DB_NAME = "powerusage.db";
    private static final int DB_VERSION = 2;
    public static final String TABLE_NAME = "powerusage";
    private static volatile PowerUsageDataHelper mInstances;

    public static class BatterySipperColumns implements BaseColumns {
        public static final String BLUETOOTH_TIME = "bluetoothRunningTimeMs";
        public static final String CAMERA_TIME = "cameraTimeMs";
        public static final String CPU_FG_TIME = "cpuFgTimeMs";
        public static final String CPU_TIME = "cpuTimeMs";
        public static final String DRAINTYPE = "drainType";
        public static final String ELAPSEDREALTIME = "elapsedrealtime";
        public static final String FLASHLIGHT_TIME = "flashlightTimeMs";
        public static final String GPS_TIME = "gpsTimeMs";
        public static final String NAME = "name";
        public static final String PACKAGE_NAME = "package_name";
        public static final String TIME = "time";
        public static final String UID = "uid";
        public static final String VALUE = "value";
        public static final String WAKELOCK_TIME = "wakeLockTimeMs";
        public static final String WIFI_TIME = "wifiRunningTimeMs";

        public BatterySipperColumns() {
        }
    }

    private PowerUsageDataHelper(Context r4) {
        super(r4, DB_NAME, null, 2);
    }

    public static PowerUsageDataHelper getInstance(Context r2) {
        if (mInstances != null) goto L15;
        monitor-enter(DatabaseHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstances != null) goto L9;
        mInstances = new PowerUsageDataHelper(r2.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(DatabaseHelper.class);     // Catch: Throwable -> L11
    L15:
        return mInstances;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        r1.execSQL(DB_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        r1.execSQL("drop table if exists powerusage");
        r1.execSQL(DB_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
        r1.execSQL("drop table if exists powerusage");
        r1.execSQL(DB_CREATE);
    }

    public Cursor getBSInDB(long r3, long r5) {
        String r4 = "select sum(value),sum(cpuTimeMs),sum(gpsTimeMs),sum(wifiRunningTimeMs),sum(cpuFgTimeMs),sum(wakeLockTimeMs),sum(cameraTimeMs),sum(flashlightTimeMs),sum(bluetoothRunningTimeMs),drainType,uid,name,package_name from powerusage where time>" + r3 + " and time<" + r5 + " group by package_name,uid,drainType;";
        OLog.i("PowerUsage", "sql " + r4);
        SQLiteDatabase r2 = getReadableDatabase();     // Catch: Exception -> L7
        if (r2 == null) goto L9;
        return r2.rawQuery(r4, null);
    L9:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}
