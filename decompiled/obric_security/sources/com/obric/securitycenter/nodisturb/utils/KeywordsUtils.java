package com.obric.securitycenter.nodisturb.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.room.RoomDatabase;
import com.obric.olog.OLog;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.obric.securitycenter.nodisturb.sms.keyword.KeywordItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KeywordsUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0002J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/KeywordsUtils;", "", "()V", "KEYWORDS_FILE_NAME", "", "TAG", "XML_LIST_KEY", "addKeywords", "", "input", "", "resolver", "Landroid/content/ContentResolver;", "maxLen", "maxCount", "backup", "", "context", "Landroid/content/Context;", "skipExist", "", "eventMap", "", "loadKeywords", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordItem;", "restore", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeywordsUtils {
    public static final KeywordsUtils INSTANCE = null;
    private static final String KEYWORDS_FILE_NAME = "intercept_key_word_list.xml";
    private static final String TAG = "KeywordsUtils";
    private static final String XML_LIST_KEY = "key_word_key_list";

    static {
        INSTANCE = new KeywordsUtils();
    }

    private KeywordsUtils() {
    }

    public static /* synthetic */ void backup$default(KeywordsUtils r0, Context r1, boolean r2, Map r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.backup(r1, r2, r3);
    }

    public final void backup(Context r17, boolean r18, Map<String, String> r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r19, "eventMap");
        if (r18 == true) goto L20;
    L8:
        ContentResolver r6 = r17.getContentResolver();     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r6, "context.contentResolver");     // Catch: Exception -> L14
        String r7 = CollectionsKt.joinToString$default(loadKeywords(r6), ":", null, null, 0, null, KeywordsUtils$backup$keywordsStr$1.INSTANCE, 30, null);     // Catch: Exception -> L14
        DesUtils.INSTANCE.initKey(r17, r19);     // Catch: Exception -> L14
        String r0 = DesUtils.encrypt(r7, r19);     // Catch: Exception -> L14
        if (r0 != null) goto L11;
        return;
    L11:
        if (XmlUniversalUtilsKt.saveToFixedPath$default(MapsKt.mapOf(TuplesKt.to(XML_LIST_KEY, r0)), KEYWORDS_FILE_NAME, "backup/com.zte.heartyservice", null, 4, null) == true) goto L22;
        r19.put("keywords_backup_failed", "save keywords file failed");     // Catch: Exception -> L14
        r19.put("success", "0");     // Catch: Exception -> L14
        return;
    L22:
        return;
    L20:
    L14:
        e = move-exception;
        OLog.e(TAG, "backup keywords failed", e);
        String r1 = e.getMessage();
        if (r1 != null) goto L18;
        r1 = "";
    L18:
        r19.put("keywords_backup_failed", r1);
        r19.put("success", "0");
        return;
    L5:
        if (FixedPathXmlUtils.Companion.fileExists("backup/com.zte.heartyservice", KEYWORDS_FILE_NAME) == false) goto L8;
        OLog.i(TAG, "skip backup keywords because file exists");     // Catch: Exception -> L14
    }

    public final void restore(Context r22, Map<String, String> r23) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "eventMap");
        DesUtils.initKey$default(DesUtils.INSTANCE, r22, null, 2, null);     // Catch: Exception -> L50
        FixedPathXmlUtils.Companion r0 = FixedPathXmlUtils.Companion;     // Catch: Exception -> L50
        String r6 = r0.readXmlFromFixedPath(KEYWORDS_FILE_NAME, "restore/com.zte.heartyservice");     // Catch: Exception -> L9
        if (Map.class.isAssignableFrom(Map.class) == false) goto L7;
        Object r1 = r0.getInstance().parseMap(r6);     // Catch: Exception -> L9
    L57:
    L11:
        Map r2 = (Map) r1;     // Catch: Exception -> L50
        if (r2 != null) goto L15;
        KeywordsUtils r3 = this;     // Catch: Exception -> L50
        r23.put("keywords_restore_failed", "read keywords file failed");     // Catch: Exception -> L50
        r23.put("success", "0");     // Catch: Exception -> L50
        return;
    L15:
        String r4 = (String) r2.get(XML_LIST_KEY);     // Catch: Exception -> L50
        if (r4 != null) goto L18;
        return;
    L18:
        String r5 = DesUtils.decrypt$default(r4, null, 2, null);     // Catch: Exception -> L50
        if (r5 != null) goto L21;
        return;
    L21:
        List r7 = StringsKt.split$default(r5, new String[]{":"}, false, 0, 6, null);     // Catch: Exception -> L50
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L50
        Iterator r9 = r7.iterator();     // Catch: Exception -> L50
    L23:
        if (r9.hasNext() == false) goto L30;
        Object r10 = r9.next();     // Catch: Exception -> L50
        if (((String) r10).length() <= 0) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == false) goto L23;
        r8.add(r10);     // Catch: Exception -> L50
        goto L23
    L27:
        r11 = false;
        goto L28
    L30:
        ContentResolver r12 = r22.getContentResolver();     // Catch: Exception -> L50
        Intrinsics.checkNotNullExpressionValue(r12, "context.contentResolver");     // Catch: Exception -> L50
        List<KeywordItem> r13 = loadKeywords(r12);     // Catch: Exception -> L50
        ArrayList r14 = new ArrayList();     // Catch: Exception -> L50
        Iterator r15 = r8.iterator();     // Catch: Exception -> L50
    L32:
        if (r15.hasNext() == false) goto L48;
        Object r16 = r15.next();     // Catch: Exception -> L50
        String r17 = (String) r16;     // Catch: Exception -> L50
        List<KeywordItem> r18 = r13;     // Catch: Exception -> L50
        List<KeywordItem> r19 = r13;
        if ((r18 instanceof Collection) == true) goto L36;
    L38:
        Iterator<T> r20 = r18.iterator();     // Catch: Exception -> L50
    L40:
        if (r20.hasNext() == false) goto L37;
        if (Intrinsics.areEqual(((KeywordItem) r20.next()).getText(), r17) == false) goto L40;
        boolean r21 = true;
    L45:
        if ((!r21) == false) goto L47;
        r14.add(r16);     // Catch: Exception -> L50
    L47:
        r13 = r19;
    L37:
        r21 = false;
        goto L45
    L36:
        if (r18.isEmpty() == false) goto L38;
    L48:
        ContentResolver r24 = r22.getContentResolver();     // Catch: Exception -> L50
        Intrinsics.checkNotNullExpressionValue(r24, "context.contentResolver");     // Catch: Exception -> L50
        OLog.i(TAG, "restore keywords " + addKeywords$default(this, r14, r24, 0, 0, 12, null));     // Catch: Exception -> L50
        FixedPathXmlUtils.Companion.deleteFixedPathFile(KEYWORDS_FILE_NAME, "restore/com.zte.heartyservice");     // Catch: Exception -> L50
        return;
    L7:
        r1 = r0.getInstance().parseObject(r6, Map.class);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        OLog.e("FixedPathXmlUtils", "从固定路径读取对象失败", e);     // Catch: Exception -> L50
        r1 = null;
    L50:
        e = move-exception;
        OLog.e(TAG, "restore keywords failed", e);
        String r25 = e.getMessage();
        if (r25 != null) goto L54;
        r25 = "";
    L54:
        r23.put("keywords_restore_failed", r25);
        r23.put("success", "0");
    }

    private final List<KeywordItem> loadKeywords(ContentResolver r9) {
        ArrayList r8 = new ArrayList();
        String[] r4 = {"_id", ProviderConstants.KeyWord.KEYWORD};
        Cursor r10 = r9.query(ProviderConstants.INSTANCE.getKEYWORD_URI(), r4, null, null, "_id ASC");
        if (r10 == null) goto L20;
        Cursor r11 = r10;
        Cursor r2 = r11;     // Catch: Throwable -> L15
        int r0 = r2.getColumnIndex("_id");     // Catch: Throwable -> L15
        int r1 = r2.getColumnIndex(ProviderConstants.KeyWord.KEYWORD);     // Catch: Throwable -> L15
    L7:
        if (r2.moveToNext() == false) goto L13;
        int r3 = r2.getInt(r0);     // Catch: Throwable -> L15
        String r5 = r2.getString(r1);     // Catch: Throwable -> L15
        if (r5 != null) goto L11;
        r5 = "";
    L12:
        r8.add(new KeywordItem(r3, r5));     // Catch: Throwable -> L15
        goto L7
    L11:
        Intrinsics.checkNotNullExpressionValue(r5, "c.getString(kwIdx) ?: \"\"");     // Catch: Throwable -> L15
        goto L12
    L13:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r11, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L20:
        return r8;
    }

    static /* synthetic */ int addKeywords$default(KeywordsUtils r0, List r1, ContentResolver r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 15;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = RoomDatabase.MAX_BIND_PARAMETER_CNT;
    L9:
        return r0.addKeywords(r1, r2, r3, r4);
    }

    private final int addKeywords(List<String> r4, ContentResolver r5, int r6, int r7) {
        Iterator<String> r3 = r4.iterator();
        int r8 = 0;
    L4:
        if (r3.hasNext() == false) goto L13;
        String r0 = r3.next();
        if (r8 >= r7) goto L13;
        if (r0.length() > r6) goto L4;
        ContentValues r1 = new ContentValues();
        r1.put(ProviderConstants.KeyWord.KEYWORD, r0);
        if (r5.insert(ProviderConstants.INSTANCE.getKEYWORD_URI(), r1) == null) goto L4;
        r8 = r8 + 1;
    L13:
        return r8;
    }
}
