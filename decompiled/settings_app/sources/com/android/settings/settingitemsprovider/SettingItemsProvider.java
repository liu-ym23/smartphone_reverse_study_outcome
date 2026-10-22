package com.android.settings.settingitemsprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.textservice.TextServicesManager;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SettingItemsProvider extends ContentProvider {
    public static final String AUTHORITY = "com.android.settings.settingitemsprovider";
    private static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.settings.settingitemsprovider";
    private static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.settings.settingitemsprovider";
    public static Uri CONTENT_URI = null;
    private static final boolean LOCAL_LOGV = false;
    private static final int MATCH_CODE_DIR = 1;
    private static final int MATCH_CODE_ITEM = 2;
    private static final String TAG = "SettingItems";
    private static final UriMatcher mUriMatcher = null;
    private DatabaseHelper mHelper;

    public void com_android_settings_settingitemsprovider_SettingItemsProvider__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_android_settings_settingitemsprovider_SettingItemsProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    public SettingItemsProvider() {
    }

    static {
        CONTENT_URI = Uri.parse("content://com.android.settings.settingitemsprovider/settingitems");
        UriMatcher r0 = new UriMatcher(-1);
        mUriMatcher = r0;
        r0.addURI(AUTHORITY, "settingitems", 1);
        r0.addURI(AUTHORITY, "settingitems/#", 2);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mHelper = DatabaseHelper.getInstance(getContext());
        new SettingsObserver(new Handler()).setup(getContext(), this.mHelper);
        OLog.d(TAG, "SettingItemsProvider created!");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r9, String[] r10, String r11, String[] r12, String r13) {
        Cursor r14 = this.mHelper.getReadableDatabase().query("settingitems", r10, r11, r12, null, null, r13);     // Catch: SQLiteException -> L11
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return r14;
    L7:
        if (isNeedFilter(getQueryKey(r11), false) == false) goto L10;
        MatrixCursor r8 = createFilterCursor(r14);
        r14.close();
        return r8;
    L10:
        return r14;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private MatrixCursor createFilterCursor(Cursor r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        MatrixCursor r0 = new MatrixCursor(r5.getColumnNames());
    L7:
        if (r5.moveToNext() == false) goto L15;
        String r1 = r5.getString(r5.getColumnIndex("name"));
        if (isNeedFilter(r1, true) == true) goto L10;
        MatrixCursor.RowBuilder r2 = r0.newRow();
        int r3 = 0;
    L13:
        if (r3 >= r5.getColumnCount()) goto L7;
        r2.add(r5.getString(r3));
        r3 = r3 + 1;
        goto L13
    L10:
        OLog.d(TAG, "filter name: " + r1);
        goto L7
    L15:
        return r0;
    }

    private boolean isNeedFilter(String r2, boolean r3) {
        if (isQueryHiFi(r2, r3) == true) goto L14;
        if (isQueryHeadsetCalibration(r2, r3) == true) goto L14;
        if (isQuerySpellCheckSettings(r2, r3) == true) goto L10;
        return false;
    L10:
        return !((TextServicesManager) getContext().getSystemService("textservices")).isSpellCheckerEnabled();
    L14:
        return !isWiredHeadsetOn();
    }

    private boolean isWiredHeadsetOn() {
        return ((AudioManager) NullSafe.nonNull(getContext().getSystemService("audio"))).isWiredHeadsetOn();
    }

    private boolean isQueryHiFi(String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == true) goto L8;
        String r1 = getContext().getResources().getString(R.string.hifi_enable_title);
        if (r3 == false) goto L11;
        return r1.equals(r2);
    L11:
        return r1.toLowerCase().contains(r2.toLowerCase());
    L8:
        return false;
    }

    private boolean isQueryHeadsetCalibration(String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == true) goto L8;
        String r1 = getContext().getResources().getString(R.string.headset_calibration_title);
        if (r3 == false) goto L11;
        return r1.equals(r2);
    L11:
        return r1.toLowerCase().contains(r2.toLowerCase());
    L8:
        return false;
    }

    private boolean isQuerySpellCheckSettings(String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == true) goto L8;
        String r1 = getContext().getResources().getString(R.string.language_item_title_spellling_check_settings);
        if (r3 == false) goto L11;
        return r1.equals(r2);
    L11:
        return r1.toLowerCase().contains(r2.toLowerCase());
    L8:
        return false;
    }

    private String getQueryKey(String r2) {
        int r0 = r2.indexOf("%") + 1;
        int r1 = r2.indexOf("%", r0);
        if (r0 <= 0) goto L6;
        if (r1 <= 0) goto L6;
        return r2.substring(r0, r1);
    L6:
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r3) {
        int r2 = mUriMatcher.match(r3);
        if (r2 != 1) goto L5;
        return CONTENT_TYPE;
    L5:
        if (r2 != 2) goto L9;
        return CONTENT_ITEM_TYPE;
    L9:
        throw new IllegalArgumentException("unknown uri:" + r3);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r6, ContentValues r7) {
        long r0 = this.mHelper.getWritableDatabase().insert("settingitems", null, r7);
        if (r0 > 0) goto L6;
        OLog.w("", "unable to insert " + r7 + " for " + r6);
        return null;
    L6:
        Uri r8 = ContentUris.withAppendedId(r6, r0);
        getContext().getContentResolver().notifyChange(r8, null);
        return r8;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r6, String r7, String[] r8) {
        SQLiteDatabase r0 = this.mHelper.getWritableDatabase();
        int r1 = mUriMatcher.match(r6);
        if (r1 != 1) goto L5;
        int r9 = r0.delete("settingitems", r7, r8);
    L14:
        if (r9 <= 0) goto L16;
        getContext().getContentResolver().notifyChange(r6, null);
    L16:
        return r9;
    L5:
        if (r1 != 2) goto L12;
        StringBuilder r2 = new StringBuilder("_id=").append(r6.getPathSegments().get(1));
        if (TextUtils.isEmpty(r7) == false) goto L9;
        String r10 = "";
    L10:
        r9 = r0.delete("settingitems", r2.append(r10).toString(), r8);
        goto L14
    L9:
        r10 = " AND " + r7;
        goto L10
    L12:
        throw new IllegalArgumentException("unknown uri:" + r6);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r6, ContentValues r7, String r8, String[] r9) {
        SQLiteDatabase r0 = this.mHelper.getWritableDatabase();
        r0.update("settingitems", r7, r8, r9);
        int r2 = mUriMatcher.match(r6);
        if (r2 != 1) goto L5;
        int r10 = r0.update("settingitems", r7, r8, r9);
    L14:
        if (r10 <= 0) goto L16;
        getContext().getContentResolver().notifyChange(r6, null);
    L16:
        return r10;
    L5:
        if (r2 != 2) goto L12;
        StringBuilder r3 = new StringBuilder("_id=").append(r6.getPathSegments().get(1));
        if (TextUtils.isEmpty(r8) == false) goto L9;
        String r11 = "";
    L10:
        r10 = r0.update("settingitems", r7, r3.append(r11).toString(), r9);
        goto L14
    L9:
        r11 = " AND " + r8;
        goto L10
    L12:
        throw new IllegalArgumentException("unknown uri:" + r6);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_settingitemsprovider_SettingItemsProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(SettingItemsProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_settingitemsprovider_SettingItemsProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
