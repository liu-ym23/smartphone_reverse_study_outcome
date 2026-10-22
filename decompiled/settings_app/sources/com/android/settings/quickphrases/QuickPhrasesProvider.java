package com.android.settings.quickphrases;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.QuickPhrases;
import android.text.TextUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class QuickPhrasesProvider extends ContentProvider {
    private static final boolean LOCAL_LOGV = false;
    private static final int MATCH_CODE_DIR = 1;
    private static final int MATCH_CODE_ENCRYPT = 3;
    private static final int MATCH_CODE_ITEM = 2;
    private static final String TAG = "QuickPhrase";
    private static final UriMatcher mUriMatcher = null;
    private QuickPhrasesHelper mHelper;

    public void com_android_settings_quickphrases_QuickPhrasesProvider__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_android_settings_quickphrases_QuickPhrasesProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    public QuickPhrasesProvider() {
    }

    static {
        UriMatcher r0 = new UriMatcher(-1);
        mUriMatcher = r0;
        r0.addURI("com.bytedanceos.quickphrases", QuickPhrasesHelper.TABLE_NAME, 1);
        r0.addURI("com.bytedanceos.quickphrases", "quickphrases/#", 2);
        r0.addURI("com.bytedanceos.quickphrases", QuickPhrasesHelper.TABLE_NAME_ENCRYPT, 3);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mHelper = new QuickPhrasesHelper(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r9, String[] r10, String r11, String[] r12, String r13) {
        SQLiteDatabase r0 = this.mHelper.getReadableDatabase();
        int r8 = mUriMatcher.match(r9);
        if (r8 == 1) goto L11;
        if (r8 == 2) goto L11;
        if (r8 == 3) goto L13;
        return null;
    L13:
        return r0.query(QuickPhrasesHelper.TABLE_NAME_ENCRYPT, r10, r11, r12, null, null, r13);
    L11:
        return r0.query(QuickPhrasesHelper.TABLE_NAME, r10, r11, r12, null, null, r13);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r3) {
        int r2 = mUriMatcher.match(r3);
        if (r2 != 1) goto L5;
        return "vnd.android.cursor.dir/vnd.bytedanceos.quickphrases";
    L5:
        if (r2 != 2) goto L7;
        return "vnd.android.cursor.item/vnd.bytedanceos.quickphrases";
    L7:
        if (r2 != 3) goto L10;
        return "vnd.android.cursor.item/vnd.bytedanceos.quickphrases";
    L10:
        throw new IllegalArgumentException("unknown uri:" + r3);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r7, ContentValues r8) {
        SQLiteDatabase r1 = this.mHelper.getWritableDatabase();
        int r9 = mUriMatcher.match(r7);
        Cursor r3 = null;
        if (r9 != 1) goto L5;
    L34:
    L30:
        th = th;
    L31:
        if (r3 == null) goto L33;
        r3.close();
    L33:
        throw th;
    L12:
        if (r8.containsKey("pos") == false) goto L14;
        r8.remove("pos");     // Catch: Throwable -> L30
    L14:
        Cursor r10 = r1.rawQuery("SELECT  max(pos) FROM quickphrases", null);     // Catch: Throwable -> L30
        int r4 = 0;
        if (r10 != null) goto L36;
    L22:
        r8.put("pos", Integer.valueOf(r4));     // Catch: Throwable -> L20
        long r0 = r1.insert(QuickPhrasesHelper.TABLE_NAME, null, r8);     // Catch: Throwable -> L20
        if (r0 == (-1)) goto L29;
        Uri r11 = ContentUris.withAppendedId(QuickPhrases.CONTENT_URI, r0);     // Catch: Throwable -> L20
        notifyChange(r11);     // Catch: Throwable -> L20
        if (r10 == null) goto L27;
        r10.close();
    L27:
        return r11;
    L29:
        throw new SQLException();     // Catch: Throwable -> L20
    L36:
    L20:
        th = th;
        r3 = r10;
        goto L31
    L18:
        if (r10.moveToFirst() == false) goto L22;
        r4 = r10.getInt(0) + 1;     // Catch: Throwable -> L20
        goto L22
    L5:
        if (r9 == 2) goto L34;
        if (r9 == 3) goto L9;
        return null;
    L9:
        long r12 = r1.insert(QuickPhrasesHelper.TABLE_NAME_ENCRYPT, null, r8);
        Uri r13 = ContentUris.withAppendedId(QuickPhrases.CONTENT_URI_ENCRYPT, r12);
        notifyChange(r13);
        return r13;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r6, String r7, String[] r8) {
        SQLiteDatabase r0 = this.mHelper.getWritableDatabase();
        int r1 = mUriMatcher.match(r6);
        if (r1 != 1) goto L5;
        int r9 = r0.delete(QuickPhrasesHelper.TABLE_NAME, r7, r8);
    L17:
        if (r9 <= 0) goto L19;
        getContext().getContentResolver().notifyChange(r6, null);
    L19:
        return r9;
    L5:
        if (r1 != 2) goto L7;
        StringBuilder r2 = new StringBuilder("_id=").append(r6.getPathSegments().get(1));
        if (TextUtils.isEmpty(r7) == false) goto L14;
        String r10 = "";
    L15:
        r9 = r0.delete(QuickPhrasesHelper.TABLE_NAME, r2.append(r10).toString(), r8);
        goto L17
    L14:
        r10 = " AND " + r7;
        goto L15
    L7:
        if (r1 != 3) goto L10;
        r9 = r0.delete(QuickPhrasesHelper.TABLE_NAME_ENCRYPT, r7, r8);
        goto L17
    L10:
        throw new IllegalArgumentException("unknown uri:" + r6);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r6, ContentValues r7, String r8, String[] r9) {
        SQLiteDatabase r0 = this.mHelper.getWritableDatabase();
        int r1 = mUriMatcher.match(r6);
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L7;
        StringBuilder r2 = new StringBuilder("_id=").append(r6.getPathSegments().get(1));
        if (TextUtils.isEmpty(r8) == false) goto L14;
        String r10 = "";
    L15:
        int r11 = r0.update(QuickPhrasesHelper.TABLE_NAME, r7, r2.append(r10).toString(), r9);
    L20:
        if (r11 <= 0) goto L22;
        getContext().getContentResolver().notifyChange(r6, null);
    L22:
        return r11;
    L14:
        r10 = " AND " + r8;
        goto L15
    L7:
        if (r1 != 3) goto L10;
        r11 = r0.update(QuickPhrasesHelper.TABLE_NAME_ENCRYPT, r7, r8, r9);
        goto L20
    L10:
        throw new IllegalArgumentException("unknown uri:" + r6);
    L17:
        if ("move".equals(r6.getQueryParameter("action")) == false) goto L19;
        r11 = movePhrases(r0, r6);
        goto L20
    L19:
        r11 = r0.update(QuickPhrasesHelper.TABLE_NAME, r7, r8, r9);
        goto L20
    }

    private boolean movePhrases(SQLiteDatabase r14, Uri r15) {
        String r6 = r15.getQueryParameter("fromId");
        int r7 = Integer.parseInt(r15.getQueryParameter("from"));
        int r16 = Integer.parseInt(r15.getQueryParameter("to"));
        r14.beginTransaction();
        if (r7 >= r16) goto L5;
        r14.execSQL("UPDATE quickphrases set pos=pos-1,dirty=1 where " + ("pos>" + r7 + " and pos<=" + r16));     // Catch: Throwable -> L8 Exception -> L10
        r14.execSQL("UPDATE quickphrases set " + ("pos=" + r16 + ",dirty=1") + " where " + ("_id=" + r6));     // Catch: Throwable -> L8 Exception -> L10
    L6:
        r14.setTransactionSuccessful();     // Catch: Throwable -> L8 Exception -> L10
        r14.endTransaction();
        return true;
    L5:
        r14.execSQL("UPDATE quickphrases set pos=pos+1,dirty=1 where " + ("pos>=" + r16 + " and pos<" + r7));     // Catch: Throwable -> L8 Exception -> L10
        r14.execSQL("UPDATE quickphrases set " + ("pos=" + r16 + ",dirty=1") + " where " + ("_id=" + r6));     // Catch: Throwable -> L8 Exception -> L10
    L10:
        e = move-exception;
        OLog.e(TAG, "move phrase fails!!! from=" + r7 + ", to=" + r16 + " exception=" + e);     // Catch: Throwable -> L8
        r14.endTransaction();
        return false;
    L8:
        th = move-exception;
        r14.endTransaction();
        throw th;
    }

    private void notifyChange(Uri r3) {
        ContentResolver r2 = getContext().getContentResolver();
        r2.notifyChange(r3, null);
        if (QuickPhrases.CONTENT_URI.equals(r3) == true) goto L6;
        r2.notifyChange(QuickPhrases.CONTENT_URI, null);
    L6:
        if (QuickPhrases.CONTENT_URI_ENCRYPT.equals(r3) == true) goto L9;
        r2.notifyChange(QuickPhrases.CONTENT_URI_ENCRYPT, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_quickphrases_QuickPhrasesProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(QuickPhrasesProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_quickphrases_QuickPhrasesProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
