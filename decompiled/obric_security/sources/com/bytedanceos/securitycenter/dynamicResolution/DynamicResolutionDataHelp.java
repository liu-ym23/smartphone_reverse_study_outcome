package com.bytedanceos.securitycenter.dynamicResolution;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.provider.BaseColumns;
import android.provider.Settings;
import android.text.TextUtils;
import bytedanceos.api.ApplicationInfoSmt;
import bytedanceos.api.PackageManagerSmt;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.powerusage.DynamicResolutionConfig;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class DynamicResolutionDataHelp extends SQLiteOpenHelper {
    static final String AUTHORITY = "com.bytedanceos.security.dynamicResolution";
    static final Uri CONTENT_ID_URI_BASE = null;
    static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.com.bytedanceos.security.dynamicResolution";
    static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.com.bytedanceos.security.dynamicResolution";
    public static final Uri CONTENT_URI = null;
    private static final String DB_CREATE = "create table dynamicResolution (_id integer primary key autoincrement,packageName text unique not null,installed integer,version text,param integer,smversion text,support_product text,enable integer);";
    private static final String DB_NAME = "dynamic_resolution.db";
    private static final int DB_VERSION = 3;
    private static final String SUPPROT_ALL = "all";
    public static final String TABLE_NAME = "dynamicResolution";
    private Context mContext;

    public static class ItemColumns implements BaseColumns {
        static final int DISABLED = 0;
        static final String ENABLE = "enable";
        static final int ENABLED = 1;
        static final String INSTALL = "installed";
        static final int INSTALLED = 1;
        static final String PACKAGE_NAME = "packageName";
        static final String PARAM = "param";
        static final String SM_VERSION = "smversion";
        static final String SUPPORT_PRODUCT = "support_product";
        static final int UNINSTALLED = 0;
        static final String VERSION = "version";

        public ItemColumns() {
        }
    }

    static {
        CONTENT_URI = Uri.parse("content://com.bytedanceos.security.dynamicResolution/dynamicResolution");
        CONTENT_ID_URI_BASE = Uri.parse("content://com.bytedanceos.security.dynamicResolution/dynamicResolution/");
    }

    DynamicResolutionDataHelp(Context context) {
        super(context, DB_NAME, null, 3);
        this.mContext = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
        init(db);
    }

    private void init(SQLiteDatabase db) {
        XmlResourceParser r0 = this.mContext.getResources().getXml(R.xml.dynamic_resolution_config);
        if (r0 != null) goto L5;
        return;
    L5:
        initData(DynamicResolutionParser.parser(r0), this.mContext, db, null);
        r0.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS dynamicResolution");
        onCreate(db);
    }

    static void initData(List<ApplicationConfig> result, Context context, SQLiteDatabase db, Set<String> lastDisable) {
        HashMap r2 = new HashMap(result.size());
        Iterator<ApplicationConfig> r3 = result.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ApplicationConfig r4 = r3.next();
        r2.put(r4.packageName, r4);
        goto L4
    L6:
        PackageManager r5 = context.getPackageManager();
        if (r5 != null) goto L9;
        return;
    L9:
        ArrayList r6 = new ArrayList();
        List<PackageInfo> r7 = r5.getInstalledPackages(0);
        if (r7 != null) goto L12;
        return;
    L12:
        HashSet r8 = new HashSet();
        Iterator<PackageInfo> r9 = r7.iterator();
    L14:
        if (r9.hasNext() == false) goto L40;
        ApplicationInfo r10 = r9.next().applicationInfo;
        if (r10.uid < 10000) goto L14;
        if ((r10.flags & 1) != 0) goto L14;
        if (ApplicationInfoSmt.getInstance().isGameApp(r10) == false) goto L14;
        ApplicationConfig r12 = (ApplicationConfig) r2.get(r10.packageName);
        if (r12 != null) goto L27;
        int r14 = r10.packageName.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r14 <= 0) goto L27;
        r12 = (ApplicationConfig) r2.get(r10.packageName.substring(0, r14));
    L27:
        ContentValues r15 = new ContentValues();
        r15.put("packageName", r10.packageName);
        r15.put("installed", 1);
        r15.put("enable", 0);
        if (r12 == null) goto L39;
        if (supportGame(r12) == false) goto L39;
        if (lastDisable != null) goto L33;
    L35:
        r15.put("enable", 1);
        if (Settings.Global.getInt(context.getContentResolver(), DynamicResolutionConfig.DYNAMIC_RES_STATE, -1) < 0) goto L38;
        PackageManagerSmt.getInstance().setOverrideResolution(r10.packageName, 1);
    L38:
        r15.put("smversion", r12.supportVersion);
        r15.put("support_product", r12.supportDevices);
        r8.add(r10.packageName);
        r6.add(r15);
        goto L14
    L33:
        if (lastDisable.contains(r10.packageName) == false) goto L35;
        r15.put("enable", 0);
    L39:
        r8.add(r10.packageName);
        r6.add(r15);
        goto L14
    L40:
        Iterator r1 = r2.entrySet().iterator();
    L42:
        if (r1.hasNext() == false) goto L46;
        Map.Entry r11 = (Map.Entry) r1.next();
        String r13 = (String) r11.getKey();
        if (r8.contains(r13) == true) goto L42;
        ContentValues r16 = new ContentValues();
        ApplicationConfig r17 = (ApplicationConfig) r11.getValue();
        r16.put("packageName", r13);
        r16.put("installed", 0);
        r16.put("smversion", r17.supportVersion);
        r16.put("support_product", r17.supportDevices);
        r6.add(r16);
        goto L42
    L46:
        if (db != null) goto L48;
        ContentValues[] r0 = new ContentValues[r6.size()];
        r6.toArray(r0);
        context.getContentResolver().bulkInsert(CONTENT_URI, r0);
        return;
    L48:
        Iterator r18 = r6.iterator();
    L50:
        if (r18.hasNext() == false) goto L73;
        db.insert(TABLE_NAME, null, (ContentValues) r18.next());
        goto L50
    }

    static boolean supportGame(ApplicationConfig config) {
        if (TextUtils.isEmpty(config.supportVersion) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(config.supportDevices) == true) goto L26;
        String r0 = Build.VERSION.RELEASE;
        int r2 = r0.indexOf(LibrarianImpl.Constants.DOT);
        if (r2 <= 0) goto L12;
        int r3 = r2 + 2;
        if (r3 >= r0.length()) goto L12;
        r0 = r0.substring(0, r3);
    L12:
        float r1 = Float.parseFloat(r0);
        String r4 = Build.PRODUCT;
        if (Float.parseFloat(config.supportVersion) > r1) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        return false;
    L18:
        if ("all".equals(config.supportDevices) == true) goto L22;
        if (config.supportDevices.contains(r4) == true) goto L22;
        return false;
    L22:
        return true;
    L15:
        r5 = false;
        goto L16
    L26:
        return false;
    }
}
