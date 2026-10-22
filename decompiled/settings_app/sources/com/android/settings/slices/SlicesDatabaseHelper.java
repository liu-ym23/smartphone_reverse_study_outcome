package com.android.settings.slices;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.obric.olog.OLog;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class SlicesDatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_SLICES_TABLE = "CREATE VIRTUAL TABLE slices_index USING fts4(key, slice_uri, title, summary, screentitle, keywords, icon, fragment, controller, slice_type, unavailable_slice_subtitle, public_slice, highlight_menu, user_restriction INTEGER DEFAULT 0 );";
    private static final String DATABASE_NAME = "slices_index.db";
    private static final int DATABASE_VERSION = 10;
    private static final String SHARED_PREFS_TAG = "slices_shared_prefs";
    private static final String TAG = "SlicesDatabaseHelper";
    private static SlicesDatabaseHelper sSingleton;
    private final Context mContext;

    public interface IndexColumns {
        public static final String CONTROLLER = "controller";
        public static final String FRAGMENT = "fragment";
        public static final String HIGHLIGHT_MENU_RESOURCE = "highlight_menu";
        public static final String ICON_RESOURCE = "icon";
        public static final String KEY = "key";
        public static final String KEYWORDS = "keywords";
        public static final String PUBLIC_SLICE = "public_slice";
        public static final String SCREENTITLE = "screentitle";
        public static final String SLICE_TYPE = "slice_type";
        public static final String SLICE_URI = "slice_uri";
        public static final String SUMMARY = "summary";
        public static final String TITLE = "title";
        public static final String UNAVAILABLE_SLICE_SUBTITLE = "unavailable_slice_subtitle";
        public static final String USER_RESTRICTION = "user_restriction";
    }

    public interface Tables {
        public static final String TABLE_SLICES_INDEX = "slices_index";
    }

    public static synchronized SlicesDatabaseHelper getInstance(Context r2) {
        monitor-enter(SlicesDatabaseHelper.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSingleton != null) goto L7;
        sSingleton = new SlicesDatabaseHelper(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        SlicesDatabaseHelper r3 = sSingleton;     // Catch: Throwable -> L10
        monitor-exit(SlicesDatabaseHelper.class);
        return r3;
    }

    private SlicesDatabaseHelper(Context r4) {
        super(r4, DATABASE_NAME, null, 10);
        this.mContext = r4;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        createDatabases(r1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r3, int r4, int r5) {
        if (r4 >= 10) goto L6;
        OLog.d(TAG, "Reconstructing DB from " + r4 + " to " + r5);
        reconstruct(r3);
        return;
    }

    void reconstruct(SQLiteDatabase r4) {
        this.mContext.getSharedPreferences(SHARED_PREFS_TAG, 0).edit().clear().apply();
        dropTables(r4);
        createDatabases(r4);
    }

    public void setIndexedState() {
        setBuildIndexed();
        setLocaleIndexed();
    }

    public boolean isSliceDataIndexed() {
        if (isBuildIndexed() == true) goto L5;
    L7:
        return false;
    L5:
        if (isLocaleIndexed() == false) goto L7;
        return true;
    }

    private void createDatabases(SQLiteDatabase r1) {
        r1.execSQL(CREATE_SLICES_TABLE);
        OLog.d(TAG, "Created databases");
    }

    private void dropTables(SQLiteDatabase r1) {
        r1.execSQL("DROP TABLE IF EXISTS slices_index");
    }

    private void setBuildIndexed() {
        this.mContext.getSharedPreferences(SHARED_PREFS_TAG, 0).edit().putBoolean(getBuildTag(), true).apply();
    }

    private void setLocaleIndexed() {
        this.mContext.getSharedPreferences(SHARED_PREFS_TAG, 0).edit().putBoolean(Locale.getDefault().toString(), true).apply();
    }

    private boolean isBuildIndexed() {
        return this.mContext.getSharedPreferences(SHARED_PREFS_TAG, 0).getBoolean(getBuildTag(), false);
    }

    private boolean isLocaleIndexed() {
        return this.mContext.getSharedPreferences(SHARED_PREFS_TAG, 0).getBoolean(Locale.getDefault().toString(), false);
    }

    String getBuildTag() {
        return Build.FINGERPRINT;
    }
}
