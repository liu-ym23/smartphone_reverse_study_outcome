package com.android.settings.textboom.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.slardaros.client.SlardarHandler;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class OcrAppInfoProvider extends ContentProvider {
    private static final int MATCH_CODE_DIR = 1;
    private static final int MATCH_CODE_ITEM = 2;
    private static final String TAG = "OcrAppInfoProvider";
    private static final UriMatcher mUriMatcher = null;
    private OcrAppInfoHelper mHelper;

    public void com_android_settings_textboom_db_OcrAppInfoProvider__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_android_settings_textboom_db_OcrAppInfoProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    public OcrAppInfoProvider() {
    }

    static {
        UriMatcher r0 = new UriMatcher(-1);
        mUriMatcher = r0;
        r0.addURI(OcrAppInfoColumn.AUTHORITY, SlardarHandler.APPINFO, 1);
        r0.addURI(OcrAppInfoColumn.AUTHORITY, "appinfo/*", 2);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mHelper = new OcrAppInfoHelper(getContext());
        OLog.d(TAG, "OcrAppInfoProvider created!");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r9, String[] r10, String r11, String[] r12, String r13) {
        SQLiteDatabase r0 = this.mHelper.getReadableDatabase();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isOpen() == false) goto L19;
        int r8 = mUriMatcher.match(r9);
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L13;
        return r0.query(OcrAppInfoColumn.TABLE_NAME, r10, appendWhere("package_name='" + r9.getPathSegments().get(1) + "'", r11), r12, null, null, r13);
    L13:
        throw new IllegalArgumentException("Unknown URI " + r9);
    L15:
        return r0.query(OcrAppInfoColumn.TABLE_NAME, r10, r11, r12, null, null, r13);
    L19:
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r7, ContentValues r8) {
        SQLiteDatabase r0 = this.mHelper.getWritableDatabase();
        if (r0 != null) goto L5;
    L13:
        return null;
    L5:
        if (r0.isOpen() == false) goto L13;
        long r2 = r0.insert(OcrAppInfoColumn.TABLE_NAME, null, r8);
        if (r2 > 0) goto L11;
        OLog.w(TAG, "unable to insert " + r8 + " for " + r7);
        return null;
    L11:
        Uri r9 = ContentUris.withAppendedId(r7, r2);
        notifyChange(r9);
        return r9;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r6, String r7, String[] r8) {
        SQLiteDatabase r0 = this.mHelper.getWritableDatabase();
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r0.isOpen() == false) goto L20;
        int r1 = mUriMatcher.match(r6);
        if (r1 != 1) goto L10;
        int r9 = r0.delete(OcrAppInfoColumn.TABLE_NAME, r7, r8);
    L15:
        if (r9 <= 0) goto L17;
        notifyChange(r6);
    L17:
        return r9;
    L10:
        if (r1 != 2) goto L13;
        r9 = r0.delete(OcrAppInfoColumn.TABLE_NAME, appendWhere("package_name='" + r6.getPathSegments().get(1) + "'", r7), r8);
        goto L15
    L13:
        throw new IllegalArgumentException("unknown uri:" + r6);
    L20:
        return -1;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r6, ContentValues r7, String r8, String[] r9) {
        SQLiteDatabase r0 = this.mHelper.getWritableDatabase();
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r0.isOpen() == false) goto L20;
        int r1 = mUriMatcher.match(r6);
        if (r1 != 1) goto L10;
        int r10 = r0.update(OcrAppInfoColumn.TABLE_NAME, r7, r8, r9);
    L15:
        if (r10 <= 0) goto L17;
        notifyChange(r6);
    L17:
        return r10;
    L10:
        if (r1 != 2) goto L13;
        r10 = r0.update(OcrAppInfoColumn.TABLE_NAME, r7, appendWhere("package_name='" + r6.getPathSegments().get(1) + "'", r8), r9);
        goto L15
    L13:
        throw new IllegalArgumentException("unknown uri:" + r6);
    L20:
        return -1;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri r11, ContentValues[] r12) {
        SQLiteDatabase r0 = this.mHelper.getWritableDatabase();
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r0.isOpen() == false) goto L39;
        int r1 = mUriMatcher.match(r11);
        r0.beginTransaction();
        if (r1 == 1) goto L33;
        long r5 = 0;
    L14:
        r0.setTransactionSuccessful();     // Catch: Throwable -> L16 Exception -> L18
    L15:
        r0.endTransaction();
        if (r5 <= 0) goto L28;
        notifyChange(r11);
    L28:
        return (int) r5;
    L18:
        e = e;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r0.endTransaction();
        throw th;
    L33:
        int r2 = r12.length;     // Catch: Throwable -> L16 Exception -> L20
        int r3 = 0;
        r5 = 0;
    L12:
        if (r3 >= r2) goto L14;
        r5 = r5 + r0.insert(OcrAppInfoColumn.TABLE_NAME, null, r12[r3]);     // Catch: Throwable -> L16 Exception -> L18
        r3 = r3 + 1;     // Catch: Throwable -> L16 Exception -> L18
    L20:
        e = e;
        r5 = 0;
        goto L22
    L39:
        return -1;
    }

    private void notifyChange(Uri r2) {
        getContext().getContentResolver().notifyChange(OcrAppInfoColumn.CONTENT_URI, null);
    }

    private static String appendWhere(String r1, String r2) {
        if (r2 != null) goto L5;
        return r1;
    L5:
        return r1 + " AND (" + r2 + ")";
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_textboom_db_OcrAppInfoProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(OcrAppInfoProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_db_OcrAppInfoProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
