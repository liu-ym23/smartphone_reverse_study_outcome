package com.obric.securitycenter.nodisturb.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.olog.OLog;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: BlackAndWhiteUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fJ\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/BlackAndWhiteUtils;", "", "()V", "INTERCEPT_BLACK_WITE_LIST", "", "TAG", "scope", "Lkotlinx/coroutines/CoroutineScope;", "backup", "", "context", "Landroid/content/Context;", "skipExist", "", "eventMap", "", "insertBlacklistFromOtherApp", "phone", "insertWhitelistFromOtherApp", "queryAndPrintAllUndeleteWhiteList", "", "", "contentResolver", "Landroid/content/ContentResolver;", "queryBlackListTotalCount", "restore", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlackAndWhiteUtils {
    public static final BlackAndWhiteUtils INSTANCE = null;
    private static final String INTERCEPT_BLACK_WITE_LIST = "intercept_black_white_list.xml";
    private static final String TAG = "BlackAndWhiteUtils";
    private static final CoroutineScope scope = null;

    private BlackAndWhiteUtils() {
    }

    static {
        INSTANCE = new BlackAndWhiteUtils();
        scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static /* synthetic */ void backup$default(BlackAndWhiteUtils r0, Context r1, boolean r2, Map r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.backup(r1, r2, r3);
    }

    public final void backup(Context r11, boolean r12, final Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "eventMap");
        if (r12 == true) goto L33;
    L10:
        OLog.d(TAG, "开始备份黑白名单数据...");     // Catch: Exception -> L8
        DesUtils.INSTANCE.initKey(r11, r13);     // Catch: Exception -> L8
        ContentResolver r14 = r11.getContentResolver();     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r14, "context.contentResolver");     // Catch: Exception -> L8
        Map<Long, String> r15 = queryBlackListTotalCount(r14);     // Catch: Exception -> L8
        ContentResolver r16 = r11.getContentResolver();     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r16, "context.contentResolver");     // Catch: Exception -> L8
        Map<Long, String> r10 = queryAndPrintAllUndeleteWhiteList(r16);     // Catch: Exception -> L8
        OLog.d(TAG, "查询到黑名单数量: " + r15.size() + ", 白名单数量: " + r10.size());     // Catch: Exception -> L8
        LinkedHashMap r17 = new LinkedHashMap();     // Catch: Exception -> L8
        Iterator r18 = SequencesKt.mapNotNull(SequencesKt.map(CollectionsKt.asSequence(r15.values()), AnonymousClass1.INSTANCE), AnonymousClass2.INSTANCE).iterator();     // Catch: Exception -> L8
        int r1 = 0;
    L13:
        if (r18.hasNext() == false) goto L15;
        r17.put("black_white_key_list_" + r1, (String) r18.next());     // Catch: Exception -> L8
        r1 = r1 + 1;     // Catch: Exception -> L8
        goto L13
    L15:
        Iterator r19 = SequencesKt.mapNotNull(SequencesKt.map(CollectionsKt.asSequence(r10.values()), AnonymousClass4.INSTANCE), new AnonymousClass5(r13)).iterator();     // Catch: Exception -> L8
    L17:
        if (r19.hasNext() == false) goto L19;
        r17.put("black_white_key_list_" + r1, (String) r19.next());     // Catch: Exception -> L8
        r1 = r1 + 1;     // Catch: Exception -> L8
        goto L17
    L19:
        String r110 = DesUtils.encrypt$default(String.valueOf(r1), null, 2, null);     // Catch: Exception -> L8
        if (r110 != null) goto L22;
        r110 = "0";
    L22:
        Map r111 = MapsKt.mapOf(TuplesKt.to("black_white_key_list_count", r110));     // Catch: Exception -> L8
        boolean r112 = FixedPathXmlUtils.Companion.saveToFixedPath(r17, INTERCEPT_BLACK_WITE_LIST, "backup/com.zte.heartyservice", "Backup");     // Catch: Exception -> L8
        boolean r113 = FixedPathXmlUtils.Companion.saveToFixedPath(r111, "intercept_black_white_list_count.xml", "backup/com.zte.heartyservice", "Backup");     // Catch: Exception -> L8
        if (r112 == false) goto L26;
        if (r113 == false) goto L26;
        OLog.d(TAG, "备份成功，共备份 " + r1 + " 条数据");     // Catch: Exception -> L8
        return;
    L26:
        OLog.e(TAG, "备份文件写入失败");     // Catch: Exception -> L8
        r13.put("black_white_backup_failed", "save black and white file failed");     // Catch: Exception -> L8
        return;
    L33:
    L8:
        e = move-exception;
        OLog.e(TAG, "backup black and white list failed", e);
        String r114 = e.getMessage();
        if (r114 != null) goto L31;
        r114 = "";
    L31:
        r13.put("black_white_backup_failed", r114);
        r13.put("success", "0");
        return;
    L5:
        if (FixedPathXmlUtils.Companion.fileExists("backup/com.zte.heartyservice", INTERCEPT_BLACK_WITE_LIST) == false) goto L10;
        OLog.i(TAG, "skip backup black and white list because file exists");     // Catch: Exception -> L8
    }

    public final void restore(Context r14, final Map<String, String> r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "eventMap");
        OLog.d(TAG, "开始恢复黑白名单数据...");     // Catch: Exception -> L48
        FixedPathXmlUtils.Companion r8 = FixedPathXmlUtils.Companion;     // Catch: Exception -> L48
        Object r9 = null;
        String r10 = r8.readXmlFromFixedPath(INTERCEPT_BLACK_WITE_LIST, "restore/com.zte.heartyservice");     // Catch: Exception -> L10
        if (Map.class.isAssignableFrom(Map.class) == false) goto L8;
        Object r11 = r8.getInstance().parseMap(r10);     // Catch: Exception -> L10
    L57:
    L12:
        Map r12 = (Map) r11;     // Catch: Exception -> L48
        if (r12 != null) goto L15;
    L18:
        boolean r13 = true;
    L19:
        if (r13 == true) goto L21;
        r9 = r11;
    L21:
        Map r16 = (Map) r9;     // Catch: Exception -> L48
        if (r16 != null) goto L25;
        BlackAndWhiteUtils r17 = this;     // Catch: Exception -> L48
        OLog.d(TAG, "没有找到恢复文件或文件为空");     // Catch: Exception -> L48
        r15.put("black_white_restore_failed", "read black and white file failed");     // Catch: Exception -> L48
        r15.put("success", "0");     // Catch: Exception -> L48
        return;
    L25:
        OLog.d(TAG, "读取到待恢复数据条数: " + r16.size());     // Catch: Exception -> L48
        DesUtils.INSTANCE.initKey(r14, r15);     // Catch: Exception -> L48
        ContentResolver r7 = r14.getContentResolver();     // Catch: Exception -> L48
        Intrinsics.checkNotNullExpressionValue(r7, "context.contentResolver");     // Catch: Exception -> L48
        Map<Long, String> r18 = queryBlackListTotalCount(r7);     // Catch: Exception -> L48
        ContentResolver r19 = r14.getContentResolver();     // Catch: Exception -> L48
        Intrinsics.checkNotNullExpressionValue(r19, "context.contentResolver");     // Catch: Exception -> L48
        Map<Long, String> r110 = queryAndPrintAllUndeleteWhiteList(r19);     // Catch: Exception -> L48
        Iterator r0 = SequencesKt.filter(SequencesKt.map(SequencesKt.mapNotNull(CollectionsKt.asSequence(r16.values()), new C03941(r15)), C03952.INSTANCE), AnonymousClass3.INSTANCE).iterator();     // Catch: Exception -> L48
    L27:
        if (r0.hasNext() == false) goto L46;
        List r20 = (List) r0.next();     // Catch: Exception -> L48
        String r21 = (String) r20.get(1);     // Catch: Exception -> L48
        String r22 = (String) r20.get(2);     // Catch: Exception -> L48
        BlackAndWhiteUtils r111 = INSTANCE;     // Catch: Exception -> L48
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L41
        if (Intrinsics.areEqual(r22, "1") == false) goto L36;
        if (r110.values().contains(r21) == true) goto L34;
        r111.insertWhitelistFromOtherApp(r14, r21);     // Catch: Throwable -> L41
    L39:
        Object r23 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        Throwable r24 = Result.m777exceptionOrNullimpl(r23);     // Catch: Exception -> L48
        if (r24 == null) goto L27;
        OLog.e(TAG, "恢复单条数据失败: " + EncryptToMd5Kt.calculateMD5(r21), r24);     // Catch: Exception -> L48
        goto L27
    L34:
        OLog.d(TAG, "白名单已存在，跳过: " + EncryptToMd5Kt.calculateMD5(r21));     // Catch: Throwable -> L41
        goto L39
    L36:
        if (r18.values().contains(r21) == true) goto L38;
        r111.insertBlacklistFromOtherApp(r14, r21);     // Catch: Throwable -> L41
        goto L39
    L38:
        OLog.d(TAG, "黑名单已存在，跳过: " + EncryptToMd5Kt.calculateMD5(r21));     // Catch: Throwable -> L41
        goto L39
    L41:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Exception -> L48
        r23 = Result.m774constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L48
        goto L43
    L46:
        OLog.d(TAG, "黑白名单数据恢复完成");     // Catch: Exception -> L48
        FixedPathXmlUtils.Companion.deleteFixedPathFile(INTERCEPT_BLACK_WITE_LIST, "restore/com.zte.heartyservice");     // Catch: Exception -> L48
        FixedPathXmlUtils.Companion.deleteFixedPathFile("intercept_black_white_list_count.xml", "restore/com.zte.heartyservice");     // Catch: Exception -> L48
        return;
    L15:
        if (r12.isEmpty() == true) goto L18;
        r13 = false;
        goto L19
    L8:
        r11 = r8.getInstance().parseObject(r10, Map.class);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        OLog.e("FixedPathXmlUtils", "从固定路径读取对象失败", e);     // Catch: Exception -> L48
        r11 = null;
    L48:
        e = move-exception;
        OLog.e(TAG, "restore black and white list failed", e);
        String r114 = e.getMessage();
        if (r114 != null) goto L52;
        r114 = "";
    L52:
        r15.put("black_white_restore_failed", r114);
        r15.put("success", "0");
    }

    private final Map<Long, String> queryBlackListTotalCount(ContentResolver r9) {
        LinkedHashMap r8 = new LinkedHashMap();
        Cursor r10 = r9.query(Uri.parse("content://com.obric.nodisturb.provider/blacklist"), null, null, null, null);     // Catch: Exception -> L29
        if (r10 == null) goto L31;
        Cursor r11 = r10;     // Catch: Exception -> L29
        Cursor r0 = r11;     // Catch: Throwable -> L24
        int r1 = r0.getColumnIndex("_id");     // Catch: Throwable -> L24
        int r2 = r0.getColumnIndex("bl_phone_number");     // Catch: Throwable -> L24
        if (r0.moveToFirst() == true) goto L9;
    L20:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        CloseableKt.closeFinally(r11, null);     // Catch: Exception -> L29
    L9:
        if (r1 == (-1)) goto L11;
        long r6 = r0.getLong(r1);     // Catch: Throwable -> L24
    L12:
        if (r2 == (-1)) goto L14;
        String r5 = r0.getString(r2);     // Catch: Throwable -> L24
    L16:
        if (r6 == (-1)) goto L19;
        Long r4 = Long.valueOf(r6);     // Catch: Throwable -> L24
        Intrinsics.checkNotNullExpressionValue(r5, AccountConst.KEY_PHONE_NUMBER);     // Catch: Throwable -> L24
        r8.put(r4, r5);     // Catch: Throwable -> L24
    L19:
        if (r0.moveToNext() == true) goto L9;
    L14:
        r5 = "未知手机号";
        goto L16
    L11:
        r6 = -1;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Exception -> L29
        throw th;     // Catch: Exception -> L29
    L31:
        return r8;
    L29:
        e = move-exception;
        OLog.e(TAG, "查询黑名单失败", e);
        goto L31
    }

    private final Map<Long, String> queryAndPrintAllUndeleteWhiteList(ContentResolver r11) {
        LinkedHashMap r0 = new LinkedHashMap();
        Cursor r12 = r11.query(Uri.parse("content://com.obric.nodisturb.provider/whitelist"), new String[]{"_id", ProviderConstants.WhiteList.WL_PHONE_NUMBER}, null, null, "_id ASC");
        Unit r2 = null;
        if (r12 == null) goto L25;
        Cursor r13 = r12;
        Cursor r3 = r13;     // Catch: Throwable -> L20
        int r1 = r3.getColumnIndex("_id");     // Catch: Throwable -> L20
        int r4 = r3.getColumnIndex(ProviderConstants.WhiteList.WL_PHONE_NUMBER);     // Catch: Throwable -> L20
    L7:
        if (r3.moveToNext() == false) goto L18;
        if (r1 == (-1)) goto L11;
        long r8 = r3.getLong(r1);     // Catch: Throwable -> L20
    L12:
        if (r4 == (-1)) goto L14;
        String r7 = r3.getString(r4);     // Catch: Throwable -> L20
    L16:
        if (r8 == (-1)) goto L7;
        Long r5 = Long.valueOf(r8);     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r7, AccountConst.KEY_PHONE_NUMBER);     // Catch: Throwable -> L20
        r0.put(r5, r7);     // Catch: Throwable -> L20
        goto L7
    L14:
        r7 = "未知手机号";
        goto L16
    L11:
        r8 = -1;
        goto L12
    L18:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r13, null);
        r2 = Unit.INSTANCE;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L25:
        if (r2 != null) goto L27;
        OLog.d(TAG, "白名单为空或查询失败");
    L27:
        return r0;
    }

    private final void insertWhitelistFromOtherApp(Context r5, String r6) {
        ContentResolver r7 = r5.getContentResolver();
        ContentValues r2 = new ContentValues();
        r2.put(ProviderConstants.WhiteList.WL_PHONE_NUMBER, r6);
    L8:
        e = move-exception;
        OLog.e(TAG, "插入白名单异常: " + EncryptToMd5Kt.calculateMD5(r6), e);
        return;
    L4:
        if (r7.insert(Uri.parse("content://com.obric.nodisturb.provider/whitelist"), r2) == null) goto L6;
        OLog.d(TAG, "插入白名单成功: " + EncryptToMd5Kt.calculateMD5(r6));     // Catch: Exception -> L8
    L11:
        return;
    L6:
        OLog.w(TAG, "插入白名单失败: " + EncryptToMd5Kt.calculateMD5(r6));     // Catch: Exception -> L8
        goto L11
    }

    private final void insertBlacklistFromOtherApp(Context r5, String r6) {
        ContentResolver r7 = r5.getContentResolver();
        ContentValues r2 = new ContentValues();
        r2.put("bl_phone_number", r6);
        Intrinsics.checkNotNullExpressionValue(r7, "resolver");
        if (queryBlackListTotalCount(r7).containsValue(r6) == false) goto L15;
        OLog.d(TAG, "黑名单已存在: " + EncryptToMd5Kt.calculateMD5(r6));
        return;
    L15:
    L11:
        e = move-exception;
        OLog.e(TAG, "插入黑名单异常: " + EncryptToMd5Kt.calculateMD5(r6), e);
        return;
    L7:
        if (r7.insert(Uri.parse("content://com.obric.nodisturb.provider/blacklist"), r2) == null) goto L9;
        OLog.d(TAG, "插入黑名单成功: " + EncryptToMd5Kt.calculateMD5(r6));     // Catch: Exception -> L11
    L14:
        return;
    L9:
        OLog.w(TAG, "插入黑名单失败: " + EncryptToMd5Kt.calculateMD5(r6));     // Catch: Exception -> L11
        goto L14
    }
}
