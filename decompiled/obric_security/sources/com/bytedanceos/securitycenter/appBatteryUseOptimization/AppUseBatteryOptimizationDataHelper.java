package com.bytedanceos.securitycenter.appBatteryUseOptimization;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.UserHandle;
import android.provider.BaseColumns;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.security.reflect.PackageManagerHelper;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import com.obric.security.R;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppUseBatteryOptimizationDataHelper extends SQLiteOpenHelper {
    static final String AUTHORITY = "com.bytedanceos.security.appUseBatteryOptimization";
    static final Uri CONTENT_ID_URI_BASE = null;
    static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.com.bytedanceos.security.appUseBatteryOptimization";
    static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.com.bytedanceos.security.appUseBatteryOptimization";
    public static final Uri CONTENT_URI = null;
    private static final String DB_CREATE = "create table appUseBatteryOptimization (_id integer primary key autoincrement,packageName text not null,uid integer,defaultValue integer,userid text,installed integer,version text,param integer,enable integer);";
    private static final String DB_NAME = "app_use_battery_optimization.db";
    private static final int DB_VERSION = 4;
    public static final String TABLE_NAME = "appUseBatteryOptimization";
    private Context mContext;

    public static class ItemColumns implements BaseColumns {
        static final String DEFAULT_VALUE = "defaultValue";
        public static final String ENABLE = "enable";
        public static final String INSTALL = "installed";
        static final int INSTALLED = 1;
        public static final int NOT_OPTIMIZATION = 0;
        public static final int OPTIMIZATION = 1;
        public static final String PACKAGE_NAME = "packageName";
        static final String PARAM = "param";
        public static final String UID = "uid";
        static final int UNINSTALLED = 0;
        static final String USERID = "userid";
        public static final String VERSION = "version";

        public ItemColumns() {
        }
    }

    static {
        CONTENT_URI = Uri.parse("content://com.bytedanceos.security.appUseBatteryOptimization/appUseBatteryOptimization");
        CONTENT_ID_URI_BASE = Uri.parse("content://com.bytedanceos.security.appUseBatteryOptimization/appUseBatteryOptimization/");
    }

    public AppUseBatteryOptimizationDataHelper(Context context) {
        super(context, DB_NAME, null, 4);
        this.mContext = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
        initData(db);
    }

    private void initData(SQLiteDatabase db) {
        PackageManager r2 = this.mContext.getPackageManager();
        if (r2 == null) goto L66;
        if (db == null) goto L81;
        List<PackageInfo> r4 = r2.getInstalledPackages(0);
        if (r4 != null) goto L9;
        return;
    L9:
        String[] r5 = this.mContext.getResources().getStringArray(R.array.app_opimization_config);
        HashSet r6 = new HashSet(r5.length);
        Collections.addAll(r6, r5);
        HashSet r7 = new HashSet();
        Iterator<PackageInfo> r8 = r4.iterator();
    L10:
        boolean r9 = r8.hasNext();
        String r10 = LibrarianImpl.Constants.DOT;
        if (r9 == false) goto L31;
        ApplicationInfo r11 = r8.next().applicationInfo;
        Iterator<PackageInfo> r17 = r8;
        PackageManager r18 = r2;
        if (r11.uid < 10000) goto L30;
        if ((r11.flags & 1) != 0) goto L30;
        boolean r3 = r6.contains(r11.packageName);
        if (r3 == true) goto L21;
        int r12 = r11.packageName.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r12 <= 0) goto L21;
        r3 = r6.contains(r11.packageName.substring(0, r12));
    L21:
        ContentValues r13 = new ContentValues();
        r13.put("packageName", r11.packageName);
        r13.put("installed", 1);
        r13.put("enable", 1);
        r13.put("uid", Integer.valueOf(r11.uid));
        r13.put(AppBgBatteryControlDataHelper.ItemColumns.USERID, Integer.valueOf(UserHandle.getUserId(r11.uid)));
        if (r3 == true) goto L24;
        r13.put("defaultValue", 0);
    L29:
        db.insert(TABLE_NAME, null, r13);
        r7.add(r11.packageName);
        goto L30
    L24:
        if (r11.packageName.equals("com.tencent.mm") == false) goto L27;
        r13.put("enable", 0);
    L27:
        r13.put("defaultValue", 1);
    L30:
        r8 = r17;
        r2 = r18;
        goto L10
    L31:
        PackageManager r19 = r2;
        if (this.mContext.getUserId() != 0) goto L80;
        List<PackageInfo> r0 = new PackageManagerHelper(r19).getInstalledPackages(0, 10);
        if (r0.size() <= 0) goto L59;
        Iterator<PackageInfo> r1 = r0.iterator();
    L37:
        if (r1.hasNext() == false) goto L59;
        ApplicationInfo r14 = r1.next().applicationInfo;
        if (r14.uid >= 10000) goto L41;
    L57:
        r1 = r1;
    L58:
        r1 = r1;
        r10 = r10;
        goto L37
    L41:
        if ((r14.flags & 1) != 0) goto L57;
        boolean r15 = r6.contains(r14.packageName);
        if (r15 == true) goto L48;
        int r16 = r14.packageName.lastIndexOf(r10);
        if (r16 <= 0) goto L48;
        r15 = r6.contains(r14.packageName.substring(0, r16));
    L48:
        ContentValues r20 = new ContentValues();
        r20.put("packageName", r14.packageName);
        r20.put("installed", 1);
        r20.put("enable", 1);
        r20.put("uid", Integer.valueOf(r14.uid));
        r20.put(AppBgBatteryControlDataHelper.ItemColumns.USERID, 10);
        if (r15 == true) goto L51;
        r20.put("defaultValue", 0);
    L56:
        db.insert(TABLE_NAME, null, r20);
        goto L58
    L51:
        if (r14.packageName.equals("com.tencent.mm") == false) goto L54;
        r20.put("enable", 0);
    L54:
        r20.put("defaultValue", 1);
    L59:
        Iterator r21 = r6.iterator();
    L61:
        if (r21.hasNext() == false) goto L82;
        String r22 = (String) r21.next();
        ContentValues r23 = new ContentValues();
        if (r7.contains(r22) == true) goto L61;
        r23.put("packageName", r22);
        r23.put("installed", 0);
        r23.put(AppBgBatteryControlDataHelper.ItemColumns.USERID, Integer.valueOf(UserHandle.getCallingUserId()));
        r23.put("defaultValue", 1);
        db.insert(TABLE_NAME, null, r23);
        goto L61
    L82:
        return;
    L80:
        return;
    L81:
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS appUseBatteryOptimization");
        onCreate(db);
    }
}
