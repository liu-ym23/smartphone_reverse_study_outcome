package com.android.settings.settingitemsprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemProperties;
import android.provider.BaseColumns;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.settings.MultiSimAdapter;
import com.android.settings.PreferenceMgr;
import com.android.settings.ScreenRefreshRateFragment;
import com.android.settings.SoundSettingsFragment;
import com.android.settings.Utils;
import com.android.settings.keva.AppSettingsKevaSp;
import com.android.settings.settingitemsprovider.Items.AboutSettingItems;
import com.android.settings.settingitemsprovider.Items.AccountSettingItems;
import com.android.settings.settingitemsprovider.Items.AirPlaneSettingsItems;
import com.android.settings.settingitemsprovider.Items.AppManagerSettingItems;
import com.android.settings.settingitemsprovider.Items.BluetoothSettingItems;
import com.android.settings.settingitemsprovider.Items.BrightnessSettingItems;
import com.android.settings.settingitemsprovider.Items.CellularDataSettingItems;
import com.android.settings.settingitemsprovider.Items.DesktopSettingItems;
import com.android.settings.settingitemsprovider.Items.EmergencyItems;
import com.android.settings.settingitemsprovider.Items.IntelligentSettingItems;
import com.android.settings.settingitemsprovider.Items.LockNotificationSettingsItems;
import com.android.settings.settingitemsprovider.Items.MoreNetworkSettingItems;
import com.android.settings.settingitemsprovider.Items.MultiSimSettingItems;
import com.android.settings.settingitemsprovider.Items.NotificationSettingItems;
import com.android.settings.settingitemsprovider.Items.OtherAppSettingItems;
import com.android.settings.settingitemsprovider.Items.PasswordSecureSettingItems;
import com.android.settings.settingitemsprovider.Items.PermissionSettingItems;
import com.android.settings.settingitemsprovider.Items.SoundSettingItems;
import com.android.settings.settingitemsprovider.Items.SystemAdvancedSettingItems;
import com.android.settings.settingitemsprovider.Items.SystemUpdateSettingItems;
import com.android.settings.settingitemsprovider.Items.WlanSettingItems;
import com.android.settings.utils.HanziToPinyin;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final boolean DBG = false;
    private static final String DB_CREATE = "create table settingitems (_id integer primary key autoincrement,name text not null,alias text,intent text,extra text,is_switch integer,switch_table text,switch_key text,special_key text,def_value integer,is_searchable integer,icon_id integer,item_path_1 text,item_path_2 text,revone_search_type text,description text);";
    public static final String DB_NAME = "settingitems.db";
    private static final int DB_VERSION = 117;
    public static final int IS_SWITCH_FALSE = 0;
    public static final int IS_SWITCH_TRUE = 1;
    private static final int MSG_UPDATE_DELAY_TIME_OUT = 1;
    private static final String SEARCH_HISTORY_DB_NAME = "search-history.db";
    private static final String SEARCH_HISTORY_ID = "id";
    private static final String SEARCH_HISTORY_PATH1 = "path1";
    private static final String SEARCH_HISTORY_PATH2 = "path2";
    private static final String SEARCH_HISTORY_ROW_ID = "history_row_id";
    private static final String SEARCH_HISTORY_SHORTCUT_ID = "shortcut_id";
    private static final String SEARCH_HISTORY_TABLE = "search_history";
    private static final String SEARCH_HISTORY_TEXT = "text";
    public static final String TABLE_NAME = "settingitems";
    private static final String TAG = "SettingItems";
    private static final int UPDATE_DELAY_TIME = 500;
    private static volatile DatabaseHelper mHelper;
    private boolean mAirPlaneModeOn;
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private int mDefaultDataSlot;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private volatile boolean mIsBuildingIndex;
    private boolean mIsSearchIndexCreated;
    private boolean mMobileDataEnabled;
    private boolean mMultiSimEnabled;
    private int mPhoneCount;
    private int mSearchDataSyncDepth;
    private final Object mSearchDataSyncLock;
    private SearchEngine mSearchEngine;
    private int[] mServiceState;
    private int[] mSimState;
    private boolean[] mStkReady;
    private boolean mVeryFirstUpdate;

    public static class ItemsRecord implements BaseColumns {
        public static final String ALIAS = "alias";
        public static final String DEFAULT_VALUE = "def_value";
        public static final String DESCRIPTION = "description";
        public static final String ICON_ID = "icon_id";
        public static final String INTENT_COMPONENT = "intent";
        public static final String INTENT_EXTRA = "extra";
        public static final String IS_SEARCHABLE = "is_searchable";
        public static final String IS_SWITCH = "is_switch";
        public static final String ITEM_PATH_1 = "item_path_1";
        public static final String ITEM_PATH_2 = "item_path_2";
        public static final String NAME = "name";
        public static final String REVONE_SEARCH_TYPE = "revone_search_type";
        public static final String SPECIAL_KEY = "special_key";
        public static final String SWITCH_KEY = "switch_key";
        public static final String SWITCH_TABLE = "switch_table";

        public ItemsRecord() {
        }
    }

    private static final class RemapSnapshotIndex {
        final Set<String> ambiguousNamePathKeys;
        final Set<String> ambiguousStableFieldKeys;
        final Map<String, ContentValues> namePathItems;
        final Map<String, ContentValues> stableFieldItems;

        private RemapSnapshotIndex() {
            this.namePathItems = new HashMap();
            this.ambiguousNamePathKeys = new HashSet();
            this.stableFieldItems = new HashMap();
            this.ambiguousStableFieldKeys = new HashSet();
        }

        /* synthetic */ RemapSnapshotIndex(AnonymousClass1 r1) {
            this();
        }
    }

    private String buildSearchHistoryRowSelection() {
        return "rowid=?";
    }

    private boolean isInService(int r1) {
        if (r1 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    private boolean isSimExist(int r1) {
        if (r1 != 5) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isSimReady(int r1) {
        if (r1 != 5) goto L5;
        return true;
    L5:
        return false;
    }

    private String normalizeDbText(String r1) {
        if (r1 != null) goto L5;
        return "";
    L5:
        return r1;
    }

    static /* synthetic */ void access$100(DatabaseHelper r0, boolean r1) {
        r0.setBuildSearchIndex(r1);
    }

    static /* synthetic */ boolean access$200(DatabaseHelper r0) {
        return r0.mIsSearchIndexCreated;
    }

    static /* synthetic */ boolean access$202(DatabaseHelper r0, boolean r1) {
        r0.mIsSearchIndexCreated = r1;
        return r1;
    }

    static /* synthetic */ SearchEngine access$300(DatabaseHelper r0) {
        return r0.mSearchEngine;
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
        r1 = true;
    L5:
        DBG = r1;
    }

    private DatabaseHelper(Context r4) {
        super(r4, DB_NAME, null, 117);
        this.mSearchDataSyncLock = new Object();
        this.mSearchDataSyncDepth = 0;
        this.mIsSearchIndexCreated = false;
        this.mIsBuildingIndex = false;
        this.mVeryFirstUpdate = true;
        if (r4.getApplicationContext() == null) goto L5;
        this.mContext = r4.getApplicationContext();
    L6:
        initGlobals();
        HandlerThread r5 = new HandlerThread("SettingsSearchDBHandler");
        this.mHandlerThread = r5;
        r5.start();
        final Looper r0 = this.mHandlerThread.getLooper();
        this.mHandler = new AnonymousClass1(this, r0);
        OLog.d(TAG, "databasehelper construct");
        return;
    L5:
        this.mContext = r4;
        goto L6
    }

    public static DatabaseHelper getInstance(Context r2) {
        if (mHelper != null) goto L15;
        monitor-enter(DatabaseHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mHelper != null) goto L9;
        mHelper = new DatabaseHelper(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DatabaseHelper.class);     // Catch: Throwable -> L11
    L15:
        return mHelper;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r4) {
        OLog.d(TAG, "databasehelper onCreate");
        r4.beginTransaction();
        AppSettingsKevaSp.setKevaFirstSearch(true);     // Catch: Throwable -> L5 Exception -> L7
        r4.execSQL(DB_CREATE);     // Catch: Throwable -> L5 Exception -> L7
        loadSettings(r4);     // Catch: Throwable -> L5 Exception -> L7
        onDatabaseCreated();     // Catch: Throwable -> L5 Exception -> L7
        setBuildSearchIndex(false);     // Catch: Throwable -> L5 Exception -> L7
        r4.setTransactionSuccessful();     // Catch: Throwable -> L5 Exception -> L7
    L4:
        r4.endTransaction();
        return;
    L5:
        th = move-exception;
        r4.endTransaction();
        throw th;
    L7:
        e = move-exception;
        OLog.e(TAG, "Error in onCreate: " + e.getMessage());     // Catch: Throwable -> L5
        goto L4
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r4, int r5, int r6) {
        beginSearchDataSync("onDowngrade");
        r4.beginTransaction();
        List<ContentValues> r1 = dumpOldSettingItems(r4);     // Catch: Throwable -> L5 Exception -> L7
        r4.execSQL("drop table if exists settingitems");     // Catch: Throwable -> L5 Exception -> L7
        AppSettingsKevaSp.setKevaFirstSearch(true);     // Catch: Throwable -> L5 Exception -> L7
        r4.execSQL(DB_CREATE);     // Catch: Throwable -> L5 Exception -> L7
        loadSettings(r4);     // Catch: Throwable -> L5 Exception -> L7
        RemapSnapshotIndex r2 = buildRemapSnapshotIndex(r4);     // Catch: Throwable -> L5 Exception -> L7
        onDatabaseCreated();     // Catch: Throwable -> L5 Exception -> L7
        remapSearchHistoryIds(r2, r1);     // Catch: Throwable -> L5 Exception -> L7
        setBuildSearchIndex(false);     // Catch: Throwable -> L5 Exception -> L7
        r4.setTransactionSuccessful();     // Catch: Throwable -> L5 Exception -> L7
        OLog.d(TAG, "databasehelper onDowngrade");     // Catch: Throwable -> L5 Exception -> L7
    L9:
        r4.endTransaction();
        endSearchDataSync("onDowngrade");
        return;
    L7:
        e = move-exception;
        OLog.e(TAG, "Error in onDowngrade: " + e.getMessage());     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r4.endTransaction();
        endSearchDataSync("onDowngrade");
        throw th;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r4, int r5, int r6) {
        beginSearchDataSync("onUpgrade");
        r4.beginTransaction();
        List<ContentValues> r1 = dumpOldSettingItems(r4);     // Catch: Throwable -> L5 Exception -> L7
        r4.execSQL("drop table if exists settingitems");     // Catch: Throwable -> L5 Exception -> L7
        AppSettingsKevaSp.setKevaFirstSearch(true);     // Catch: Throwable -> L5 Exception -> L7
        r4.execSQL(DB_CREATE);     // Catch: Throwable -> L5 Exception -> L7
        loadSettings(r4);     // Catch: Throwable -> L5 Exception -> L7
        RemapSnapshotIndex r2 = buildRemapSnapshotIndex(r4);     // Catch: Throwable -> L5 Exception -> L7
        onDatabaseCreated();     // Catch: Throwable -> L5 Exception -> L7
        remapSearchHistoryIds(r2, r1);     // Catch: Throwable -> L5 Exception -> L7
        setBuildSearchIndex(false);     // Catch: Throwable -> L5 Exception -> L7
        r4.setTransactionSuccessful();     // Catch: Throwable -> L5 Exception -> L7
        OLog.d(TAG, "databasehelper onUpgrade");     // Catch: Throwable -> L5 Exception -> L7
    L9:
        r4.endTransaction();
        endSearchDataSync("onUpgrade");
        return;
    L7:
        e = move-exception;
        OLog.e(TAG, "Error in onUpgrade: " + e.getMessage());     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r4.endTransaction();
        endSearchDataSync("onUpgrade");
        throw th;
    }

    private List<ContentValues> dumpOldSettingItems(SQLiteDatabase r3) {
        ArrayList r2 = new ArrayList();
        Cursor r4 = r3.rawQuery("SELECT * FROM settingitems", null);     // Catch: Exception -> L20
        if (r4 != null) goto L23;
    L17:
        if (r4 == null) goto L22;
        r4.close();     // Catch: Exception -> L20
    L22:
        return r2;
    L23:
    L10:
        th = move-exception;
        if (r4 != null) goto L26;
    L16:
        throw th;     // Catch: Exception -> L20
    L26:
        r4.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L20
        goto L16
    L6:
        if (r4.moveToFirst() == false) goto L17;
    L7:
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L10
        DatabaseUtils.cursorRowToContentValues(r4, r0);     // Catch: Throwable -> L10
        r2.add(r0);     // Catch: Throwable -> L10
        if (r4.moveToNext() == true) goto L7;
    L20:
        e = move-exception;
        OLog.w(TAG, "Failed to load old settingitems: " + e.getMessage());
        goto L22
    }

    private void remapSearchHistoryIds(RemapSnapshotIndex r23, List<ContentValues> r24) {
        DatabaseHelper r1 = this;
        String r3 = SEARCH_HISTORY_PATH2;
        String r4 = SEARCH_HISTORY_PATH1;
        if (r24.isEmpty() == true) goto L190;
        if (r23 == null) goto L191;
        HashMap r8 = new HashMap();
        Set<String> r9 = new HashSet();
        Iterator<ContentValues> r0 = r24.iterator();
    L8:
        if (r0.hasNext() == false) goto L161;
        ContentValues r10 = r0.next();
        r1.registerSnapshotItem(r8, r9, r1.buildNamePathKey(r10), r10);
        goto L8
    L161:
        SQLiteDatabase r11 = SQLiteDatabase.openDatabase(r1.mContext.getDatabasePath(SEARCH_HISTORY_DB_NAME).getPath(), null, 0);     // Catch: Exception -> L129
        r11.beginTransaction();     // Catch: Throwable -> L118
        String[] r14 = {"rowid AS history_row_id", "id", SEARCH_HISTORY_TEXT, SEARCH_HISTORY_PATH1, SEARCH_HISTORY_PATH2};     // Catch: Throwable -> L111
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L111
        SQLiteDatabase r16 = null;
        Cursor r12 = r11.query(SEARCH_HISTORY_TABLE, r14, null, null, null, null, null);     // Catch: Throwable -> L111
        if (r12 != null) goto L159;
    L37:
        r16 = r11;
    L38:
        if (r12 == null) goto L165;
        r12.close();     // Catch: Throwable -> L41
    L165:
        Iterator r5 = r2.iterator();     // Catch: Throwable -> L109
        int r13 = 0;
        int r15 = 0;
    L158:
    L106:
        th = th;
        SQLiteDatabase r6 = r16;
    L108:
        int r17 = r13;
    L140:
        r6.endTransaction();     // Catch: Throwable -> L116
        throw th;     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        Throwable r7 = th;
    L163:
        if (r6 == null) goto L188;
        r6.close();     // Catch: Throwable -> L123
    L189:
        throw r7;     // Catch: Exception -> L127
    L123:
        th = move-exception;
        r7.addSuppressed(th);     // Catch: Exception -> L127
        throw r7;     // Catch: Exception -> L127
    L188:
        throw r7;     // Catch: Exception -> L127
    L127:
        e = e;
    L131:
        OLog.e(TAG, "Failed to open or update search-history.db: " + e.getMessage());
        r13 = r17;
    L132:
        OLog.d(TAG, "databasehelper remapSearchHistoryIds, updateCount: " + r13 + ", deleteCount: " + r15);
        return;
    L46:
        if (r5.hasNext() == false) goto L95;
        ContentValues r18 = (ContentValues) r5.next();     // Catch: Throwable -> L106
        long r19 = r18.getAsLong(SEARCH_HISTORY_ROW_ID).longValue();     // Catch: Throwable -> L106
        String r110 = r18.getAsString("id");     // Catch: Throwable -> L106
        r5 = r5;
        String r20 = r1.buildNamePathKey(r18.getAsString(SEARCH_HISTORY_TEXT), r18.getAsString(r4), r18.getAsString(r3));     // Catch: Exception -> L88 Throwable -> L106
        if (TextUtils.isEmpty(r20) == true) goto L50;
        if (r9.contains(r20) == true) goto L142;
        HashMap r21 = r8;
        ContentValues r22 = (ContentValues) r21.get(r20);     // Catch: Exception -> L85 Throwable -> L106
        if (r22 == null) goto L60;
        ContentValues r25 = r1.findRemappedSettingItem(r23, r22);     // Catch: Exception -> L83 Throwable -> L106
        r8 = r21;
        if (r25 == null) goto L136;
        String r26 = r3;
        String r27 = r4;
        r6 = r16;
        ContentValues r28 = r1.buildSearchHistoryUpdateValues(r25);     // Catch: Exception -> L81 Throwable -> L104
        String r29 = buildSearchHistoryRowSelection();     // Catch: Exception -> L81 Throwable -> L104
        String[] r30 = new String[1];     // Catch: Exception -> L81 Throwable -> L104
        r30[0] = String.valueOf(r19);     // Catch: Exception -> L79 Throwable -> L104
        r13 = r13 + r6.update(SEARCH_HISTORY_TABLE, r28, r29, r30);
    L94:
        r1 = this;
    L70:
        r16 = r6;
        r3 = r26;
        r4 = r27;
    L79:
        e = e;
    L93:
        OLog.e(TAG, "Error remapping search history for historyId=" + r110 + ", rowId=" + r19 + ": " + e.getMessage());     // Catch: Throwable -> L104
        goto L94
    L136:
        r26 = r3;
        r27 = r4;
        r6 = r16;
        r15 = r15 + r6.delete(SEARCH_HISTORY_TABLE, buildSearchHistoryRowSelection(), new String[]{String.valueOf(r19)});     // Catch: Exception -> L81 Throwable -> L104
    L104:
        th = th;
    L81:
        e = e;
        goto L93
    L71:
        e = e;
    L91:
        r27 = r4;
        r6 = r16;
    L73:
        e = e;
    L90:
        r26 = r3;
    L83:
        e = e;
    L87:
        r8 = r21;
    L60:
        r8 = r21;
    L85:
        e = e;
        goto L87
    L142:
        OLog.w(TAG, "Skip remap because multiple old rows matched history name/path, historyId=" + r110);     // Catch: Throwable -> L55 Exception -> L88
    L55:
        th = th;
        r17 = r13;
        r6 = r16;
    L50:
        r21 = r8;
    L88:
        e = e;
        goto L90
    L95:
        r6 = r16;
        r6.setTransactionSuccessful();     // Catch: Throwable -> L104
        r6.endTransaction();     // Catch: Throwable -> L102
        if (r6 == null) goto L132;
        r6.close();     // Catch: Exception -> L100
    L100:
        e = e;
        r17 = r13;
    L102:
        th = move-exception;
        r7 = th;
        r17 = r13;
    L109:
        th = th;
        r6 = r16;
        int r111 = 0;
    L113:
        r15 = r111;
        r17 = r15;
        goto L140
    L159:
    L27:
        th = th;
        r16 = r11;
    L29:
        Throwable r31 = th;
        if (r12 == null) goto L186;
        r12.close();     // Catch: Throwable -> L33
    L187:
        throw r31;     // Catch: Throwable -> L41
    L33:
        th = move-exception;
        r31.addSuppressed(th);     // Catch: Throwable -> L41
        throw r31;     // Catch: Throwable -> L41
    L186:
        throw r31;     // Catch: Throwable -> L41
    L17:
        if (r12.moveToFirst() == false) goto L37;
        int r112 = r12.getColumnIndexOrThrow(SEARCH_HISTORY_ROW_ID);     // Catch: Throwable -> L27
        int r113 = r12.getColumnIndexOrThrow("id");     // Catch: Throwable -> L27
        int r114 = r12.getColumnIndexOrThrow(SEARCH_HISTORY_TEXT);     // Catch: Throwable -> L27
        r16 = r11;
        int r115 = r12.getColumnIndexOrThrow(SEARCH_HISTORY_PATH1);     // Catch: Throwable -> L25
        int r32 = r12.getColumnIndexOrThrow(SEARCH_HISTORY_PATH2);     // Catch: Throwable -> L25
    L21:
        ContentValues r33 = new ContentValues();     // Catch: Throwable -> L25
        int r210 = r112;
        r33.put(SEARCH_HISTORY_ROW_ID, Long.valueOf(r12.getLong(r112)));     // Catch: Throwable -> L25
        r33.put("id", r12.getString(r113));     // Catch: Throwable -> L25
        r33.put(SEARCH_HISTORY_TEXT, r12.getString(r114));     // Catch: Throwable -> L25
        r33.put(SEARCH_HISTORY_PATH1, r12.getString(r115));     // Catch: Throwable -> L25
        r33.put(SEARCH_HISTORY_PATH2, r12.getString(r32));     // Catch: Throwable -> L25
        r2.add(r33);     // Catch: Throwable -> L25
        if (r12.moveToNext() == false) goto L38;
        r112 = r210;
    L25:
        th = th;
    L41:
        th = th;
        r6 = r16;
        r15 = 0;
        r17 = 0;
    L111:
        th = th;
        r6 = r11;
        r111 = 0;
    L118:
        th = move-exception;
        r6 = r11;
        r7 = th;
        r15 = 0;
        r17 = 0;
    L129:
        e = e;
        r15 = 0;
        r17 = 0;
        goto L131
    L191:
        return;
    }

    private ContentValues buildSearchHistoryUpdateValues(ContentValues r3) {
        ContentValues r2 = new ContentValues();
        Long r4 = r3.getAsLong("_id");
        if (r4 == null) goto L5;
        r2.put(SEARCH_HISTORY_SHORTCUT_ID, String.valueOf(r4));
        r2.put("id", r4);
    L5:
        return r2;
    }

    private ContentValues findRemappedSettingItem(RemapSnapshotIndex r5, ContentValues r6) {
        String r0 = buildNamePathKey(r6);
        if (TextUtils.isEmpty(r0) == true) goto L12;
        ContentValues r1 = r5.namePathItems.get(r0);
        if (r1 == null) goto L9;
        return new ContentValues(r1);
    L9:
        if (r5.ambiguousNamePathKeys.contains(r0) == false) goto L12;
        OLog.w(TAG, "Skip remap because multiple rows matched by name/path");
        return null;
    L12:
        String r4 = buildStableFieldsKey(r6);
        if (TextUtils.isEmpty(r4) == false) goto L15;
        return null;
    L15:
        ContentValues r7 = r5.stableFieldItems.get(r4);
        if (r7 == null) goto L20;
        return new ContentValues(r7);
    L20:
        if (r5.ambiguousStableFieldKeys.contains(r4) == false) goto L22;
        OLog.w(TAG, "Skip remap because multiple rows matched by stable fields");
    L22:
        return null;
    }

    private RemapSnapshotIndex buildRemapSnapshotIndex(SQLiteDatabase r24) {
        RemapSnapshotIndex r1 = new RemapSnapshotIndex(null);
        Cursor r2 = r24.query("settingitems", new String[]{"_id", "name", ItemsRecord.ITEM_PATH_1, ItemsRecord.ITEM_PATH_2, "intent", "extra", "is_switch", "switch_table", "switch_key", "special_key", "def_value", ItemsRecord.REVONE_SEARCH_TYPE}, null, null, null, null, null);
        if (r2 != null) goto L25;
    L20:
        if (r2 == null) goto L22;
        r2.close();
    L22:
        return r1;
    L25:
    L12:
        th = move-exception;
        if (r2 == null) goto L29;
        r2.close();     // Catch: Throwable -> L17
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L29:
        throw th;
    L5:
        if (r2.moveToFirst() == false) goto L20;
    L7:
        ContentValues r3 = new ContentValues();     // Catch: Throwable -> L12
        DatabaseUtils.cursorRowToContentValues(r2, r3);     // Catch: Throwable -> L12
        registerSnapshotItem(r1.namePathItems, r1.ambiguousNamePathKeys, buildNamePathKey(r3), r3);     // Catch: Throwable -> L12
        registerSnapshotItem(r1.stableFieldItems, r1.ambiguousStableFieldKeys, buildStableFieldsKey(r3), r3);     // Catch: Throwable -> L12
        if (r2.moveToNext() == true) goto L7;
        if (r2 == null) goto L11;
        r2.close();
    L11:
        return r1;
    }

    private void registerSnapshotItem(Map<String, ContentValues> r1, Set<String> r2, String r3, ContentValues r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (r2.contains(r3) == false) goto L8;
        return;
    L8:
        if (r1.containsKey(r3) == false) goto L11;
        r1.remove(r3);
        r2.add(r3);
        return;
    L11:
        r1.put(r3, new ContentValues(r4));
    }

    private String buildNamePathKey(ContentValues r4) {
        return buildNamePathKey(r4.getAsString("name"), r4.getAsString(ItemsRecord.ITEM_PATH_1), r4.getAsString(ItemsRecord.ITEM_PATH_2));
    }

    private String buildNamePathKey(String r3, String r4, String r5) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return null;
    L7:
        return joinKeyParts(new String[]{r3, normalizeDbText(r4), normalizeDbText(r5)});
    }

    private String buildStableFieldsKey(ContentValues r10) {
        String r0 = normalizeDbText(r10.getAsString("intent"));
        String r1 = normalizeDbText(r10.getAsString("extra"));
        String r2 = normalizeDbText(r10.getAsString("is_switch"));
        String r3 = normalizeDbText(r10.getAsString("switch_table"));
        String r4 = normalizeDbText(r10.getAsString("switch_key"));
        String r5 = normalizeDbText(r10.getAsString("special_key"));
        String r6 = normalizeDbText(r10.getAsString("def_value"));
        String r11 = normalizeDbText(r10.getAsString(ItemsRecord.REVONE_SEARCH_TYPE));
        if (TextUtils.isEmpty(r0) == false) goto L21;
        if (TextUtils.isEmpty(r1) == false) goto L21;
        if (TextUtils.isEmpty(r2) == false) goto L21;
        if (TextUtils.isEmpty(r3) == false) goto L21;
        if (TextUtils.isEmpty(r4) == false) goto L21;
        if (TextUtils.isEmpty(r5) == false) goto L21;
        if (TextUtils.isEmpty(r6) == false) goto L21;
        if (TextUtils.isEmpty(r11) == false) goto L21;
        return null;
    L21:
        return joinKeyParts(new String[]{r0, r1, r2, r3, r4, r5, r6, r11});
    }

    private String joinKeyParts(String... r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        String r3 = r6[r2];
        if (r0.length() <= 0) goto L7;
        r0.append(1);
    L7:
        r0.append(normalizeDbText(r3));
        r2 = r2 + 1;
        goto L3
    L9:
        return r0.toString();
    }

    private void beginSearchDataSync(String r5) {
        Object r1 = this.mSearchDataSyncLock;
        monitor-enter(r1);
        this.mSearchDataSyncDepth++;     // Catch: Throwable -> L7
        OLog.d(TAG, "beginSearchDataSync " + r5 + ", depth=" + this.mSearchDataSyncDepth);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void endSearchDataSync(String r5) {
        Object r1 = this.mSearchDataSyncLock;
        monitor-enter(r1);
        int r2 = this.mSearchDataSyncDepth;     // Catch: Throwable -> L12
        if (r2 <= 0) goto L7;
        this.mSearchDataSyncDepth = r2 - 1;     // Catch: Throwable -> L12
    L7:
        OLog.d(TAG, "endSearchDataSync " + r5 + ", depth=" + this.mSearchDataSyncDepth);     // Catch: Throwable -> L12
        if (this.mSearchDataSyncDepth != 0) goto L10;
        this.mSearchDataSyncLock.notifyAll();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void ensureSearchDataReadyForQuery() {
        Object r0 = this.mSearchDataSyncLock;
        monitor-enter(r0);
    L30:
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.mSearchDataSyncDepth <= 0) goto L12;
        OLog.d(TAG, "ensureSearchDataReadyForQuery wait, depth=" + this.mSearchDataSyncDepth);     // Catch: InterruptedException -> L8 Throwable -> L25
        this.mSearchDataSyncLock.wait();     // Catch: InterruptedException -> L8 Throwable -> L25
    L8:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L25
        OLog.w(TAG, "ensureSearchDataReadyForQuery interrupted");     // Catch: Throwable -> L25
        return;
    L12:
        if (AppSettingsKevaSp.getKevaFirstSearch().booleanValue() == false) goto L14;
        boolean r3 = true;
        this.mSearchDataSyncDepth++;     // Catch: Throwable -> L25
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L25
        if (r3 == true) goto L18;
        return;
    L18:
        OLog.d(TAG, "ensureSearchDataReadyForQuery trigger first search init");
        onUpdateDelayTimeOut();     // Catch: Throwable -> L22
        handleWifiStateChanged();     // Catch: Throwable -> L22
        AppSettingsKevaSp.setKevaFirstSearch(false);     // Catch: Throwable -> L22
        endSearchDataSync("ensureSearchDataReadyForQuery");
        return;
    L22:
        th = move-exception;
        endSearchDataSync("ensureSearchDataReadyForQuery");
        throw th;
    L14:
        r3 = false;
        goto L15
    }

    public void createSearchIndexWaitInitFinish() {
        SearchEngine r0 = SearchEngine.getInstance(this.mContext);
        this.mSearchEngine = r0;
        r0.setSearchEngineCallback(new AnonymousClass2(this));
        this.mSearchEngine.initSearchEngine(this.mContext);
    }

    public void createSearchIndex() {
        this.mSearchEngine = SearchEngine.getInstance(this.mContext);
        setBuildSearchIndex(false);
        setBuildingIndexState(true);
        this.mIsSearchIndexCreated = this.mSearchEngine.buildIndex(getReadableDatabase());
        if (isBuildingIndex() == false) goto L6;
        setBuildSearchIndex(this.mIsSearchIndexCreated);
        return;
    }

    public boolean isSearchIndexCreated() {
        return hasBuildIndex();
    }

    public void recreate() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.post(new DatabaseHelper$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$recreate$0$com-android-settings-settingitemsprovider-DatabaseHelper, reason: not valid java name */
    /* synthetic */ void m594xa659c641() {
        OLog.d(TAG, "databasehelper recreate");
        SQLiteDatabase r1 = getWritableDatabase();
        r1.beginTransaction();
        r1.execSQL("drop table if exists settingitems");     // Catch: Throwable -> L5 Exception -> L7
        AppSettingsKevaSp.setKevaFirstSearch(true);     // Catch: Throwable -> L5 Exception -> L7
        r1.execSQL(DB_CREATE);     // Catch: Throwable -> L5 Exception -> L7
        loadSettings(r1);     // Catch: Throwable -> L5 Exception -> L7
        onDatabaseCreated();     // Catch: Throwable -> L5 Exception -> L7
        setBuildSearchIndex(false);     // Catch: Throwable -> L5 Exception -> L7
        setBuildingIndexState(false);     // Catch: Throwable -> L5 Exception -> L7
        r1.setTransactionSuccessful();     // Catch: Throwable -> L5 Exception -> L7
    L4:
        r1.endTransaction();
        return;
    L5:
        th = move-exception;
        r1.endTransaction();
        throw th;
    L7:
        e = move-exception;
        OLog.e(TAG, "Error in onUpgrade: " + e.getMessage());     // Catch: Throwable -> L5
        goto L4
    }

    private void loadSettings(SQLiteDatabase r3) {
        SQLiteStatement r0 = null;
        r0 = r3.compileStatement("INSERT OR IGNORE INTO settingitems(name,alias,intent,extra,is_switch,switch_table,switch_key,special_key,def_value,is_searchable,icon_id,item_path_1,item_path_2,revone_search_type,description) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");     // Catch: Throwable -> L7
        new AccountSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new IntelligentSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new AirPlaneSettingsItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new WlanSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new CellularDataSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new BluetoothSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new MultiSimSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new MoreNetworkSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new DesktopSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new BrightnessSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new SoundSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new NotificationSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new LockNotificationSettingsItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new PasswordSecureSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new PermissionSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new AppManagerSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new SystemAdvancedSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new SystemUpdateSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new AboutSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new EmergencyItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        new OtherAppSettingItems(this.mContext).loadItems(r0);     // Catch: Throwable -> L7
        if (r0 == null) goto L13;
        r0.close();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r0 == null) goto L10;
        r0.close();
    L10:
        throw th;
    }

    private boolean hasBuildIndex() {
        return PreferenceMgr.getInstance(this.mContext).getBoolean(PreferenceMgr.KEY_BUILD_SEARCH_INDEX, false);
    }

    private void setBuildSearchIndex(boolean r2) {
        PreferenceMgr.getInstance(this.mContext).putBoolean(PreferenceMgr.KEY_BUILD_SEARCH_INDEX, r2);
    }

    public String getRomVersion() {
        return PreferenceMgr.getInstance(this.mContext).getString("rom_version", "");
    }

    public void setRomVersion(String r2) {
        PreferenceMgr.getInstance(this.mContext).putString("rom_version", r2);
    }

    private ContentResolver getContentResolver() {
        return this.mContext.getContentResolver();
    }

    public boolean isBuildingIndex() {
        return this.mIsBuildingIndex;
    }

    public void setBuildingIndexState(boolean r1) {
        this.mIsBuildingIndex = r1;
    }

    public void notifyChanged(Uri r6) {
        SQLiteDatabase r0 = getWritableDatabase();
        if (r6.equals(Settings.Global.getUriFor("mobile_data")) == false) goto L6;
        onMobileDataStateChanged();
        return;
    L6:
        if (r6.equals(Settings.Global.getUriFor("radio_stk_ready")) == false) goto L12;
        if (DBG == false) goto L10;
        OLog.d(TAG, "on radio_stk_ready changed");
    L10:
        networkStateChanged();
        return;
    L12:
        if (r6.equals(Settings.Secure.getUriFor("accessibility_display_daltonizer_enabled")) == false) goto L15;
        SystemAdvancedSettingItems.updateItems(this.mHandler, this.mContext, r0);
        return;
    L15:
        if (r6.equals(Settings.Global.getUriFor("smt_5g_status")) == false) goto L17;
        updateMobileDataSetting();
        return;
    L17:
        boolean r3 = false;
        if (r6.equals(Settings.Global.getUriFor(ScreenRefreshRateFragment.SCREEN_REFRESH_RATE)) == false) goto L21;
        BrightnessSettingItems.updateItems(this.mHandler, this.mContext, r0, Settings.Global.getInt(getContentResolver(), ScreenRefreshRateFragment.SCREEN_REFRESH_RATE, 0));
        return;
    L21:
        if (r6.equals(Settings.Global.getUriFor(SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED)) == false) goto L27;
        int r7 = Settings.Global.getInt(getContentResolver(), SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, 1);
        Handler r1 = this.mHandler;
        Context r5 = this.mContext;
        if (r7 == 0) goto L25;
        r3 = true;
    L25:
        SoundSettingItems.updateVibrationItems(r1, r5, r0, r3);
        return;
    L27:
        if (r6.equals(Settings.Global.getUriFor("auto_time")) == false) goto L33;
        int r8 = Settings.Global.getInt(getContentResolver(), "auto_time", 1);
        Handler r2 = this.mHandler;
        Context r9 = this.mContext;
        if (r8 != 1) goto L31;
        r3 = true;
    L31:
        SystemAdvancedSettingItems.updateTimeItems(r2, r9, r0, r3);
        return;
    L33:
        if (r6.equals(Settings.Global.getUriFor(IntelligentSettingItems.IS_AUTO_RECORD_ENABLED)) == false) goto L36;
        updateCallRecordStatus();
        return;
    L36:
        if (r6.equals(Settings.Secure.getUriFor("night_display_activated")) == false) goto L42;
        if (Settings.Secure.getInt(getContentResolver(), "night_display_activated", 0) == 0) goto L40;
        r3 = true;
    L40:
        updateRhythmicEyeProtection(r3);
        return;
    L42:
        if (r6.equals(Settings.Global.getUriFor("navigationbar_trigger_mode")) == false) goto L54;
        updateHideNavigationHandleSearchable();
        return;
    }

    private void initGlobals() {
        this.mVeryFirstUpdate = true;
        this.mMultiSimEnabled = MultiSimAdapter.isMultiSimEnabled();
        this.mPhoneCount = MultiSimAdapter.getPhoneCount();
        int r3 = 0;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) != 1) goto L5;
        boolean r1 = true;
    L6:
        this.mAirPlaneModeOn = r1;
        this.mSimState = new int[this.mPhoneCount];
        int r2 = 0;
    L7:
        int r4 = this.mPhoneCount;
        if (r2 >= r4) goto L10;
        this.mSimState[r2] = MultiSimAdapter.getSimState(r2);
        r2 = r2 + 1;
        goto L7
    L10:
        this.mServiceState = new int[r4];
        int r5 = 0;
    L12:
        if (r5 >= this.mPhoneCount) goto L14;
        r5 = r5 + 1;
        goto L12
    L14:
        ConnectivityManager r6 = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        this.mConnectivityManager = r6;
        if (r6 != null) goto L42;
    L20:
        this.mDefaultDataSlot = MultiSimAdapter.getDefaultDataSlot();
        this.mStkReady = new boolean[this.mPhoneCount];
        int r7 = 0;
    L22:
        if (r7 >= this.mPhoneCount) goto L30;
        boolean[] r8 = this.mStkReady;     // Catch: Exception -> L41
        if (TelephonyManager.getIntAtIndex(this.mContext.getContentResolver(), "radio_stk_ready", r7) != 1) goto L26;
        boolean r9 = true;
    L27:
        r8[r7] = r9;     // Catch: Exception -> L41
        goto L28
    L26:
        r9 = false;
    L28:
        r7 = r7 + 1;
        goto L22
    L30:
        if (DBG == false) goto L52;
        String r0 = (("initGlobals(), , mMultiSimEnabled=" + this.mMultiSimEnabled) + ", mAirPlaneModeOn=" + this.mAirPlaneModeOn) + ", mSimState=";
        int r10 = 0;
    L33:
        if (r10 >= this.mPhoneCount) goto L35;
        r0 = r0 + this.mSimState[r10] + HanziToPinyin.Token.SEPARATOR;
        r10 = r10 + 1;
        goto L33
    L35:
        String r11 = r0 + ", mServiceState=";
    L37:
        if (r3 >= this.mPhoneCount) goto L39;
        r11 = r11 + this.mServiceState[r3] + HanziToPinyin.Token.SEPARATOR;
        r3 = r3 + 1;
        goto L37
    L39:
        OLog.d(TAG, (r11 + ", mMobileDataEnabled=" + this.mMobileDataEnabled) + ", mDefaultDataSlot=" + this.mDefaultDataSlot);
        return;
    L52:
        return;
    L42:
        this.mMobileDataEnabled = r6.getMobileDataEnabled();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L5:
        r1 = false;
        goto L6
    }

    public void onDatabaseCreated() {
        if (DBG == false) goto L5;
        OLog.d(TAG, "onDatabaseCreated()");
    L5:
        this.mVeryFirstUpdate = true;
        networkStateChanged();
    }

    public void onAirPlaneModeChanged() {
        if (DBG == false) goto L5;
        OLog.d(TAG, "onAirPlaneModeChanged()");
    L5:
        networkStateChanged();
    }

    public void onSimStateChanged() {
        if (DBG == false) goto L5;
        OLog.d(TAG, "onSimStateChanged()");
    L5:
        networkStateChanged();
    }

    public void onServiceStateChanged() {
        if (DBG == false) goto L5;
        OLog.d(TAG, "onServiceStateChanged()");
    L5:
        networkStateChanged();
    }

    public void onDefaultDataSlotChanged() {
        if (DBG == false) goto L5;
        OLog.d(TAG, "onDefaultDataSlotChanged()");
    L5:
        networkStateChanged();
    }

    public void onMobileDataStateChanged() {
        if (DBG == false) goto L5;
        OLog.d(TAG, "onMobileDataStateChanged()");
    L5:
        networkStateChanged();
    }

    private void networkStateChanged() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 500);
    }

    public void onUpdateDelayTimeOut() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) != 1) goto L5;
        boolean r4 = true;
    L6:
        int[] r5 = new int[this.mPhoneCount];
        int r0 = 0;
    L7:
        int r6 = this.mPhoneCount;
        if (r0 >= r6) goto L10;
        r5[r0] = MultiSimAdapter.getSimState(r0);
        r0 = r0 + 1;
        goto L7
    L10:
        int[] r7 = new int[r6];
        int r1 = 0;
    L12:
        if (r1 >= this.mPhoneCount) goto L15;
        r1 = r1 + 1;
        goto L12
    L15:
        if (this.mConnectivityManager != null) goto L17;
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
    L17:
        ConnectivityManager r2 = this.mConnectivityManager;
        if (r2 != null) goto L107;
    L23:
        boolean r3 = false;
    L24:
        int r8 = MultiSimAdapter.getDefaultDataSlot();
        boolean[] r9 = new boolean[this.mPhoneCount];
        int r10 = 0;
    L26:
        if (r10 >= this.mPhoneCount) goto L34;
        if (TelephonyManager.getIntAtIndex(this.mContext.getContentResolver(), "radio_stk_ready", r10) != 1) goto L30;
        boolean r11 = true;
    L31:
        r9[r10] = r11;     // Catch: Exception -> L106
        goto L32
    L30:
        r11 = false;
    L32:
        r10 = r10 + 1;
        goto L26
    L34:
        if (this.mAirPlaneModeOn == r4) goto L36;
        boolean r12 = true;
    L37:
        int r13 = 0;
    L39:
        if (r13 >= this.mPhoneCount) goto L44;
        if (isSimExist(this.mSimState[r13]) != isSimExist(r5[r13])) goto L42;
        r13 = r13 + 1;
        goto L39
    L42:
        boolean r14 = true;
    L45:
        if (r14 == true) goto L53;
        int r15 = 0;
    L48:
        if (r15 >= this.mPhoneCount) goto L53;
        if (this.mSimState[r15] != r5[r15]) goto L51;
        r15 = r15 + 1;
        goto L48
    L51:
        r14 = true;
    L53:
        int r16 = 0;
    L55:
        if (r16 >= this.mPhoneCount) goto L60;
        if (isInService(this.mServiceState[r16]) == true) goto L58;
        r16 = r16 + 1;
        goto L55
    L58:
        boolean r17 = true;
    L61:
        int r18 = 0;
    L63:
        if (r18 >= this.mPhoneCount) goto L68;
        if (isInService(r7[r18]) == true) goto L66;
        r18 = r18 + 1;
        goto L63
    L66:
        boolean r19 = true;
    L69:
        if (r17 == r19) goto L71;
        boolean r110 = true;
    L73:
        if (this.mMobileDataEnabled == r3) goto L75;
        boolean r111 = true;
    L77:
        if (this.mDefaultDataSlot == r8) goto L79;
        boolean r112 = true;
    L80:
        int r113 = 0;
    L82:
        if (r113 >= this.mPhoneCount) goto L87;
        if (this.mStkReady[r113] != r9[r113]) goto L85;
        r113 = r113 + 1;
        goto L82
    L85:
        boolean r20 = true;
    L88:
        OLog.d(TAG, (((((("onUpdateDelayTimeOut(), , mVeryFirstUpdate=" + this.mVeryFirstUpdate) + ", airPlaneChanged=" + r12) + ", simStateChanged=" + r14) + ", serviceStateChanged=" + r110) + ", mobileDataChanged=" + r111) + ", defaultDataSlotChanged=" + r112) + ", stkReadyChanged=" + r20);
        this.mAirPlaneModeOn = r4;
        this.mSimState = r5;
        this.mServiceState = r7;
        this.mMobileDataEnabled = r3;
        this.mDefaultDataSlot = r8;
        this.mStkReady = r9;
        if (this.mVeryFirstUpdate == true) goto L109;
        if (r12 == true) goto L109;
        if (r14 == true) goto L109;
        if (r110 == true) goto L109;
        if (r111 == true) goto L109;
        if (r112 == true) goto L109;
        if (r20 == true) goto L109;
        return;
    L109:
        this.mVeryFirstUpdate = false;     // Catch: SQLiteException -> L100
        updateMobileDataSetting();     // Catch: SQLiteException -> L100
        updatePersonalApSettings();     // Catch: SQLiteException -> L100
        if (Utils.isMultiSimSupport() == false) goto L128;
        updateRingtoneSetting(getWritableDatabase());     // Catch: SQLiteException -> L100
        updateMultiSimSetting();     // Catch: SQLiteException -> L100
        return;
    L128:
        return;
    L100:
        e = move-exception;
        e.printStackTrace();
        this.mVeryFirstUpdate = true;
        OLog.w(TAG, "SQLiteException is catched" + e.getMessage());
        if (e.getMessage().contains("no such table") == false) goto L104;
        recreate();
        return;
    L104:
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 500);
        return;
    L87:
        r20 = false;
        goto L88
    L79:
        r112 = false;
        goto L80
    L75:
        r111 = false;
        goto L77
    L71:
        r110 = false;
        goto L73
    L68:
        r19 = false;
        goto L69
    L60:
        r17 = false;
        goto L61
    L44:
        r14 = false;
        goto L45
    L36:
        r12 = false;
        goto L37
    L107:
        r3 = r2.getMobileDataEnabled();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L5:
        r4 = false;
        goto L6
    }

    private void updateMobileDataSetting() {
        boolean r0 = false;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.mPhoneCount) goto L9;
        if (isSimReady(this.mSimState[r1]) == false) goto L8;
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        SQLiteDatabase r5 = getWritableDatabase();
        Handler r3 = this.mHandler;
        Context r4 = this.mContext;
        boolean r6 = this.mAirPlaneModeOn;
        boolean r7 = this.mMobileDataEnabled;
        if (r2 <= 0) goto L12;
        r0 = true;
    L12:
        CellularDataSettingItems.updateItems(r3, r4, r5, r6, r7, r0);
    }

    public void handleNfcStateChanged(int r4) {
        SQLiteDatabase r0 = getWritableDatabase();
        Handler r1 = this.mHandler;
        Context r3 = this.mContext;
        if (r4 != 3) goto L5;
        boolean r5 = true;
    L6:
        MoreNetworkSettingItems.updateNFCItems(r1, r3, r0, r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public void handleBluetoothStateChanged(int r3) {
        SQLiteDatabase r0 = getWritableDatabase();
        BluetoothSettingItems.updateItems(this.mHandler, this.mContext, r0, r3);
    }

    public void handleWifiStateChanged() {
        SQLiteDatabase r0 = getWritableDatabase();
        WlanSettingItems.updateItems(this.mHandler, this.mContext, r0);
    }

    public void handleWifiApStateChanged() {
        SQLiteDatabase r0 = getWritableDatabase();
        MoreNetworkSettingItems.updateItems(this.mHandler, this.mContext, r0);
    }

    private void updateRingtoneSetting(SQLiteDatabase r3) {
        boolean r0 = Utils.hasMultiSimInDevice();
        SoundSettingItems.updateItems(this.mHandler, this.mContext, r3, r0);
    }

    public void updateMultiSimSetting() {
        SQLiteDatabase r0 = getWritableDatabase();
        boolean r1 = Utils.hasMultiSimInDevice();
        MultiSimSettingItems.updateItems(this.mHandler, this.mContext, r0, r1);
    }

    public void updateFingerprintItems(boolean r3) {
        SQLiteDatabase r0 = getWritableDatabase();
        PasswordSecureSettingItems.updateFingerprintItems(this.mHandler, this.mContext, r0, r3);
    }

    public void updateFaceRecognitionItems() {
        SQLiteDatabase r0 = getWritableDatabase();
        PasswordSecureSettingItems.updateFaceItems(this.mHandler, this.mContext, r0);
    }

    public void handleAccountLoginStateChanged() {
        beginSearchDataSync("handleAccountLoginStateChanged");
        SQLiteDatabase r1 = getWritableDatabase();     // Catch: Throwable -> L6
        IntelligentSettingItems.updateItems(this.mHandler, this.mContext, r1);     // Catch: Throwable -> L6
        new OtherAppSettingItems(this.mContext).updateAccountItems(this.mHandler, r1);     // Catch: Throwable -> L6
        endSearchDataSync("handleAccountLoginStateChanged");
        return;
    L6:
        th = move-exception;
        endSearchDataSync("handleAccountLoginStateChanged");
        throw th;
    }

    public void handleDashBoardStateChanged() {
        beginSearchDataSync("handleDashBoardStateChanged");
        SQLiteDatabase r1 = getWritableDatabase();     // Catch: Throwable -> L6
        IntelligentSettingItems.updateItems(this.mHandler, this.mContext, r1);     // Catch: Throwable -> L6
        new OtherAppSettingItems(this.mContext).updateDashboardItems(this.mHandler, r1);     // Catch: Throwable -> L6
        endSearchDataSync("handleDashBoardStateChanged");
        return;
    L6:
        th = move-exception;
        endSearchDataSync("handleDashBoardStateChanged");
        throw th;
    }

    public void handleAILabChangeStateChanged(boolean r3) {
        SQLiteDatabase r0 = getWritableDatabase();
        IntelligentSettingItems.updateAILabItems(this.mHandler, this.mContext, r0, r3);
    }

    public void handleAssistantChangeStateChanged(boolean r3) {
        SQLiteDatabase r0 = getWritableDatabase();
        IntelligentSettingItems.updateAssistantItems(this.mHandler, this.mContext, r0, r3);
    }

    public void updateGoogleServiceSettingItemSearchable() {
        SQLiteDatabase r0 = getWritableDatabase();
        SystemAdvancedSettingItems.updateGoogleServiceItems(this.mHandler, this.mContext, r0);
    }

    public void updateDevelopmentSettingsSearchable(boolean r3) {
        SQLiteDatabase r0 = getWritableDatabase();
        SystemAdvancedSettingItems.updateDevelopmentItems(this.mHandler, this.mContext, r0, r3);
    }

    public void updateRhythmicEyeProtection(boolean r3) {
        SQLiteDatabase r0 = getWritableDatabase();
        BrightnessSettingItems.updateRhythmicEyeProtection(this.mHandler, this.mContext, r0, r3);
    }

    public void updateHideNavigationHandleSearchable() {
        SQLiteDatabase r0 = getWritableDatabase();
        SystemAdvancedSettingItems.updateHideNavigationHandleItems(this.mHandler, this.mContext, r0);
    }

    private void updatePersonalApSettings() {
        SQLiteDatabase r0 = getWritableDatabase();
        MoreNetworkSettingItems.updateItems(this.mHandler, this.mContext, r0);
    }

    public void ensureDbUpgradedBeforeLocaleSwitch() {
        getWritableDatabase();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "ensureDbUpgradedBeforeLocaleSwitch failed: " + e.getMessage());
    }

    public void updateForFirstSearch() {
        beginSearchDataSync("updateForFirstSearch");
        onUpdateDelayTimeOut();     // Catch: Throwable -> L6
        handleWifiStateChanged();     // Catch: Throwable -> L6
        endSearchDataSync("updateForFirstSearch");
        return;
    L6:
        th = move-exception;
        endSearchDataSync("updateForFirstSearch");
        throw th;
    }

    public void updateCallRecordStatus() {
        SQLiteDatabase r0 = getWritableDatabase();
        IntelligentSettingItems.updateItems(this.mHandler, this.mContext, r0);
    }
}
