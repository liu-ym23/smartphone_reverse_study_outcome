package com.obric.securitycenter.nodisturb.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.bytedanceos.utils.Constants;
import com.obric.olog.OLog;
import com.obric.securitycenter.nodisturb.manager.NumberCheckManager;
import com.obric.securitycenter.nodisturb.manager.SmsBodyCheckManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SettingsUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aJ\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\"\u0010$\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/SettingsUtils;", "", "()V", "KEY_CALL_FLAGS_0", "", "KEY_CALL_FLAGS_1", "KEY_INTERCEPT_OPEN_0", "KEY_INTERCEPT_OPEN_1", "KEY_IS_MUTI_CARD", "KEY_MARK_CALL_FLAGS_0", "KEY_MARK_CALL_FLAGS_1", "KEY_MARK_CALL_NUMBERS_09", "KEY_MARK_CALL_NUMBERS_19", "KEY_SHOW_IN_NOTIFY_0", "KEY_SHOW_IN_NOTIFY_1", "KEY_SMS_FLAGS_0", "KEY_SMS_FLAGS_1", "SETTINGS_FILE_NAME", "TAG", "backup", "", "context", "Landroid/content/Context;", "skipExist", "", "eventMap", "", "handleCallFlags", "callFlags", "", "contentResolver", "Landroid/content/ContentResolver;", "handleCallMarkFlags", "callMarkFlags", "handleSmsFlags", "smsFlags", "restore", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SettingsUtils {
    public static final SettingsUtils INSTANCE = null;
    private static final String KEY_CALL_FLAGS_0 = "preference_intercept_call_mode_flags0";
    private static final String KEY_CALL_FLAGS_1 = "preference_intercept_call_mode_flags1";
    private static final String KEY_INTERCEPT_OPEN_0 = "intercept_open0";
    private static final String KEY_INTERCEPT_OPEN_1 = "intercept_open1";
    private static final String KEY_IS_MUTI_CARD = "preference_intercept_setting_is_muti_card";
    private static final String KEY_MARK_CALL_FLAGS_0 = "preference_mark_call_mode_flags0";
    private static final String KEY_MARK_CALL_FLAGS_1 = "preference_mark_call_mode_flags1";
    private static final String KEY_MARK_CALL_NUMBERS_09 = "preference_mark_call_mode_numbers09";
    private static final String KEY_MARK_CALL_NUMBERS_19 = "preference_mark_call_mode_numbers19";
    private static final String KEY_SHOW_IN_NOTIFY_0 = "show_in_notify0";
    private static final String KEY_SHOW_IN_NOTIFY_1 = "show_in_notify1";
    private static final String KEY_SMS_FLAGS_0 = "preference_intercept_sms_mode_flags0";
    private static final String KEY_SMS_FLAGS_1 = "preference_intercept_sms_mode_flags1";
    private static final String SETTINGS_FILE_NAME = "intercept_settings.xml";
    private static final String TAG = "SettingsUtils";

    /* JADX INFO: compiled from: SettingsUtils.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[ZTESMSInterceptFlags.values().length];
            r0[ZTESMSInterceptFlags.INTELLI_MODE_ADS_FINANCIAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L31:
            r0[ZTESMSInterceptFlags.INTELLI_MODE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L43:
            r0[ZTESMSInterceptFlags.INTELLI_MODE_ADS_OPERATOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L33:
            r0[ZTESMSInterceptFlags.INTELLI_MODE_ADS_PROMOTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L35:
            r0[ZTESMSInterceptFlags.INTELLI_MODE_ADS_OTHER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L11:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[ZTECallMarkInterceptFlags.values().length];
            r1[ZTECallMarkInterceptFlags.MARK_TYPE_CRANK_CALL_FLAG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L29:
            r1[ZTECallMarkInterceptFlags.MARK_TYPE_SUSPECTED_FRAUD_FLAG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L37:
            r1[ZTECallMarkInterceptFlags.MARK_TYPE_PROMOTE_FLAG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L27:
            r1[ZTECallMarkInterceptFlags.MARK_TYPE_INTERMEDIARY_FLAG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L16:
            $EnumSwitchMapping$1 = r1;
        }
    }

    static {
        INSTANCE = new SettingsUtils();
    }

    private SettingsUtils() {
    }

    public static /* synthetic */ void backup$default(SettingsUtils r0, Context r1, boolean r2, Map r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.backup(r1, r2, r3);
    }

    public final void backup(Context r13, boolean r14, Map<String, String> r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r15, "eventMap");
        String r4 = "";
        if (r14 == true) goto L73;
    L8:
        DesUtils.INSTANCE.initKey(r13, r15);     // Catch: Exception -> L66
        String r16 = DesUtils.encrypt(Constants.IS_SET, r15);     // Catch: Exception -> L66
        if (r16 != null) goto L11;
        r16 = "";
    L11:
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Exception -> L66
        r6.put(KEY_IS_MUTI_CARD, r16);     // Catch: Exception -> L66
        r6.put(KEY_INTERCEPT_OPEN_0, r16);     // Catch: Exception -> L66
        r6.put(KEY_INTERCEPT_OPEN_1, r16);     // Catch: Exception -> L66
        r6.put(KEY_SHOW_IN_NOTIFY_0, r16);     // Catch: Exception -> L66
        r6.put(KEY_SHOW_IN_NOTIFY_1, r16);     // Catch: Exception -> L66
        String r8 = DesUtils.encrypt$default("50", null, 2, null);     // Catch: Exception -> L66
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        r6.put(KEY_MARK_CALL_NUMBERS_09, r8);     // Catch: Exception -> L66
        String r12 = DesUtils.encrypt$default("50", null, 2, null);     // Catch: Exception -> L66
        if (r12 != null) goto L17;
        r12 = "";
    L17:
        r6.put(KEY_MARK_CALL_NUMBERS_19, r12);     // Catch: Exception -> L66
        int r17 = ZTESMSInterceptFlags.INTERCEPT_BLACK_LIST_MODE.getMask() | ZTESMSInterceptFlags.INTERCEPT_KEY_WORD_MODE.getMask();     // Catch: Exception -> L66
        int r9 = 0;
        int r18 = Settings.System.getInt(r13.getContentResolver(), SmsBodyCheckManager.SMS_INTERCEPT_YULORE_TYPE, 0);     // Catch: Exception -> L66
        int r10 = Settings.System.getInt(r13.getContentResolver(), "pref_key_sms_yulore_intercept_use_cloud");     // Catch: Exception -> L66
        String r11 = DesUtils.encrypt(String.valueOf(r18), r15);     // Catch: Exception -> L66
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        r6.put("bd_preference_sms_intercept_yulore_type", r11);     // Catch: Exception -> L66
        String r19 = DesUtils.encrypt(String.valueOf(r10), r15);     // Catch: Exception -> L66
        if (r19 != null) goto L23;
        r19 = "";
    L23:
        r6.put("bd_preference_sms_yulore_intercept_use_cloud", r19);     // Catch: Exception -> L66
        if ((r18 & 4) == 0) goto L27;
        r17 = (((r17 | ZTESMSInterceptFlags.INTELLI_MODE.getMask()) | ZTESMSInterceptFlags.INTELLI_MODE_ADS_OPERATOR.getMask()) | ZTESMSInterceptFlags.INTELLI_MODE_ADS_PROMOTION.getMask()) | ZTESMSInterceptFlags.INTELLI_MODE_ADS_OTHER.getMask();     // Catch: Exception -> L66
    L27:
        if ((r18 & 2) == 0) goto L29;
        r17 = r17 | ZTESMSInterceptFlags.INTELLI_MODE_ADS_FINANCIAL.getMask();     // Catch: Exception -> L66
    L29:
        String r20 = DesUtils.encrypt$default(String.valueOf(r17), null, 2, null);     // Catch: Exception -> L66
        if (r20 != null) goto L32;
        r20 = "";
    L32:
        r6.put(KEY_SMS_FLAGS_0, r20);     // Catch: Exception -> L66
        String r110 = DesUtils.encrypt$default(String.valueOf(r17), null, 2, null);     // Catch: Exception -> L66
        if (r110 != null) goto L35;
        r110 = "";
    L35:
        r6.put(KEY_SMS_FLAGS_1, r110);     // Catch: Exception -> L66
        int r111 = ZTECallInterceptFlags.INTERCEPT_BLACK_LIST_MODE.getMask();     // Catch: Exception -> L66
        String r21 = DesUtils.encrypt$default(String.valueOf(r111), null, 2, null);     // Catch: Exception -> L66
        if (r21 != null) goto L38;
        r21 = "";
    L38:
        r6.put(KEY_CALL_FLAGS_0, r21);     // Catch: Exception -> L66
        String r112 = DesUtils.encrypt$default(String.valueOf(r111), null, 2, null);     // Catch: Exception -> L66
        if (r112 != null) goto L41;
        r112 = "";
    L41:
        r6.put(KEY_CALL_FLAGS_1, r112);     // Catch: Exception -> L66
        int r113 = Settings.Global.getInt(r13.getContentResolver(), NumberCheckManager.SETTINGS_KEY, 0);     // Catch: Exception -> L66
        String r114 = DesUtils.encrypt(String.valueOf(r113), r15);     // Catch: Exception -> L66
        if (r114 != null) goto L44;
        r114 = "";
    L44:
        r6.put("bd_preference_call_intercept_type", r114);     // Catch: Exception -> L66
        if ((r113 & 1) == 0) goto L48;
        r9 = 0 | ZTECallMarkInterceptFlags.MARK_TYPE_CRANK_CALL_FLAG.getMask();     // Catch: Exception -> L66
    L48:
        if ((r113 & 16) == 0) goto L51;
        r9 = r9 | ZTECallMarkInterceptFlags.MARK_TYPE_SUSPECTED_FRAUD_FLAG.getMask();     // Catch: Exception -> L66
    L51:
        if ((r113 & 4) == 0) goto L54;
        r9 = r9 | ZTECallMarkInterceptFlags.MARK_TYPE_INTERMEDIARY_FLAG.getMask();     // Catch: Exception -> L66
    L54:
        if ((r113 & 770) == 0) goto L56;
        r9 = r9 | ZTECallMarkInterceptFlags.MARK_TYPE_PROMOTE_FLAG.getMask();     // Catch: Exception -> L66
    L56:
        String r115 = DesUtils.encrypt$default(String.valueOf(r9), null, 2, null);     // Catch: Exception -> L66
        if (r115 != null) goto L59;
        r115 = "";
    L59:
        r6.put(KEY_MARK_CALL_FLAGS_0, r115);     // Catch: Exception -> L66
        String r116 = DesUtils.encrypt$default(String.valueOf(r9), null, 2, null);     // Catch: Exception -> L66
        if (r116 != null) goto L62;
        r116 = "";
    L62:
        r6.put(KEY_MARK_CALL_FLAGS_1, r116);     // Catch: Exception -> L66
        if (XmlUniversalUtilsKt.saveToFixedPath$default(r6, SETTINGS_FILE_NAME, "backup/com.zte.heartyservice", null, 4, null) == true) goto L74;
        r15.put("settings_backup_failed", "save settings file failed");     // Catch: Exception -> L66
        r15.put("success", "0");     // Catch: Exception -> L66
        return;
    L74:
        return;
    L73:
    L66:
        e = move-exception;
        OLog.e(TAG, "backup settings failed", e);
        String r117 = e.getMessage();
        if (r117 == null) goto L71;
        r4 = r117;
    L71:
        r15.put("settings_backup_failed", r4);
        r15.put("success", "0");
        return;
    L5:
        if (FixedPathXmlUtils.Companion.fileExists("backup/com.zte.heartyservice", SETTINGS_FILE_NAME) == false) goto L8;
        OLog.i(TAG, "skip backup keywords because file exists");     // Catch: Exception -> L66
    }

    public final void restore(Context r22, Map<String, String> r23) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "eventMap");
        DesUtils.INSTANCE.initKey(r22, r23);     // Catch: Exception -> L146
        FixedPathXmlUtils.Companion r0 = FixedPathXmlUtils.Companion;     // Catch: Exception -> L146
        String r10 = r0.readXmlFromFixedPath(SETTINGS_FILE_NAME, "restore/com.zte.heartyservice");     // Catch: Exception -> L9
        if (Map.class.isAssignableFrom(Map.class) == false) goto L7;
        Object r1 = r0.getInstance().parseMap(r10);     // Catch: Exception -> L9
    L155:
    L11:
        Map r11 = (Map) r1;     // Catch: Exception -> L146
        if (r11 != null) goto L15;
        SettingsUtils r2 = this;     // Catch: Exception -> L146
        r23.put("settings_restore_failed", "read settings file failed");     // Catch: Exception -> L146
        r23.put("success", "0");     // Catch: Exception -> L146
        return;
    L15:
        Iterator r12 = r11.entrySet().iterator();     // Catch: Exception -> L146
        boolean r13 = true;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
    L17:
        if (r12.hasNext() == false) goto L111;
        Map.Entry r3 = (Map.Entry) r12.next();     // Catch: Exception -> L146
        String r9 = (String) r3.getKey();     // Catch: Exception -> L146
        String r4 = (String) r3.getValue();     // Catch: Exception -> L146
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L21
        Object r5 = Result.m774constructorimpl(DesUtils.decrypt$default(r4, null, 2, null));     // Catch: Throwable -> L21
    L20:
        Object r6 = r5;
        if (Result.m780isFailureimpl(r6) == false) goto L26;
        r6 = null;
    L26:
        String r7 = (String) r6;     // Catch: Exception -> L146
        if (r7 == null) goto L17;
        switch(r9.hashCode()) {
            case -1130128622: goto L105;
            case -1130128621: goto L99;
            case -576341846: goto L93;
            case -576341815: goto L87;
            case 636697605: goto L81;
            case 636697606: goto L75;
            case 1141412574: goto L69;
            case 1141412575: goto L63;
            case 1374600047: goto L57;
            case 1374600048: goto L51;
            case 1564609897: goto L45;
            case 1564609898: goto L39;
            case 1960117229: goto L33;
            default: goto L17;
        };     // Catch: Exception -> L146
    L33:
        if (r9.equals(KEY_IS_MUTI_CARD) == false) goto L17;
        Boolean r8 = StringsKt.toBooleanStrictOrNull(r7);     // Catch: Exception -> L146
        if (r8 == null) goto L17;
        r13 = r8.booleanValue();     // Catch: Exception -> L146
        goto L17
    L39:
        if (r9.equals(KEY_INTERCEPT_OPEN_1) == false) goto L17;
        Boolean r21 = StringsKt.toBooleanStrictOrNull(r7);     // Catch: Exception -> L146
        if (r21 == null) goto L17;
        r21.booleanValue();     // Catch: Exception -> L146
        goto L17
    L45:
        if (r9.equals(KEY_INTERCEPT_OPEN_0) == false) goto L17;
        Boolean r24 = StringsKt.toBooleanStrictOrNull(r7);     // Catch: Exception -> L146
        if (r24 == null) goto L17;
        r24.booleanValue();     // Catch: Exception -> L146
        goto L17
    L51:
        if (r9.equals(KEY_SHOW_IN_NOTIFY_1) == false) goto L17;
        Boolean r25 = StringsKt.toBooleanStrictOrNull(r7);     // Catch: Exception -> L146
        if (r25 == null) goto L17;
        r25.booleanValue();     // Catch: Exception -> L146
        goto L17
    L57:
        if (r9.equals(KEY_SHOW_IN_NOTIFY_0) == false) goto L17;
        Boolean r26 = StringsKt.toBooleanStrictOrNull(r7);     // Catch: Exception -> L146
        if (r26 == null) goto L17;
        r26.booleanValue();     // Catch: Exception -> L146
        goto L17
    L63:
        if (r9.equals(KEY_SMS_FLAGS_1) == false) goto L17;
        Integer r27 = StringsKt.toIntOrNull(r7);     // Catch: Exception -> L146
        if (r27 == null) goto L17;
        r15 = r27.intValue();     // Catch: Exception -> L146
        goto L17
    L69:
        if (r9.equals(KEY_SMS_FLAGS_0) == false) goto L17;
        Integer r28 = StringsKt.toIntOrNull(r7);     // Catch: Exception -> L146
        if (r28 == null) goto L17;
        r14 = r28.intValue();     // Catch: Exception -> L146
        goto L17
    L75:
        if (r9.equals(KEY_CALL_FLAGS_1) == false) goto L17;
        Integer r29 = StringsKt.toIntOrNull(r7);     // Catch: Exception -> L146
        if (r29 == null) goto L17;
        r17 = r29.intValue();     // Catch: Exception -> L146
        goto L17
    L81:
        if (r9.equals(KEY_CALL_FLAGS_0) == false) goto L17;
        Integer r30 = StringsKt.toIntOrNull(r7);     // Catch: Exception -> L146
        if (r30 == null) goto L17;
        r16 = r30.intValue();     // Catch: Exception -> L146
        goto L17
    L87:
        if (r9.equals(KEY_MARK_CALL_NUMBERS_19) == false) goto L17;
        Integer r31 = StringsKt.toIntOrNull(r7);     // Catch: Exception -> L146
        if (r31 == null) goto L17;
        r31.intValue();     // Catch: Exception -> L146
        goto L17
    L93:
        if (r9.equals(KEY_MARK_CALL_NUMBERS_09) == false) goto L17;
        Integer r32 = StringsKt.toIntOrNull(r7);     // Catch: Exception -> L146
        if (r32 == null) goto L17;
        r32.intValue();     // Catch: Exception -> L146
        goto L17
    L99:
        if (r9.equals(KEY_MARK_CALL_FLAGS_1) == false) goto L17;
        Integer r33 = StringsKt.toIntOrNull(r7);     // Catch: Exception -> L146
        if (r33 == null) goto L17;
        r19 = r33.intValue();     // Catch: Exception -> L146
        goto L17
    L105:
        if (r9.equals(KEY_MARK_CALL_FLAGS_0) == false) goto L17;
        Integer r34 = StringsKt.toIntOrNull(r7);     // Catch: Exception -> L146
        if (r34 == null) goto L17;
        r18 = r34.intValue();     // Catch: Exception -> L146
        goto L17
    L21:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Exception -> L146
        r5 = Result.m774constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L146
        goto L20
    L111:
        String r36 = (String) r11.get("bd_preference_sms_intercept_yulore_type");     // Catch: Exception -> L146
        if (r36 == null) goto L119;
        ContentResolver r37 = r22.getContentResolver();     // Catch: Exception -> L146
        String r38 = DesUtils.decrypt(r36, r23);     // Catch: Exception -> L146
        if (r38 == null) goto L117;
        int r39 = Integer.parseInt(r38);     // Catch: Exception -> L146
    L118:
        Settings.System.putInt(r37, SmsBodyCheckManager.SMS_INTERCEPT_YULORE_TYPE, r39);     // Catch: Exception -> L146
    L123:
        String r40 = (String) r11.get("bd_preference_sms_yulore_intercept_use_cloud");     // Catch: Exception -> L146
        if (r40 == null) goto L130;
        ContentResolver r41 = r22.getContentResolver();     // Catch: Exception -> L146
        String r42 = DesUtils.decrypt(r40, r23);     // Catch: Exception -> L146
        if (r42 == null) goto L128;
        int r43 = Integer.parseInt(r42);     // Catch: Exception -> L146
    L129:
        Settings.System.putInt(r41, "pref_key_sms_yulore_intercept_use_cloud", r43);     // Catch: Exception -> L146
        goto L130
    L128:
        r43 = 0;
    L130:
        String r44 = (String) r11.get("bd_preference_call_intercept_type");     // Catch: Exception -> L146
        if (r44 == null) goto L137;
        ContentResolver r45 = r22.getContentResolver();     // Catch: Exception -> L146
        String r46 = DesUtils.decrypt$default(r44, null, 2, null);     // Catch: Exception -> L146
        if (r46 == null) goto L135;
        int r110 = Integer.parseInt(r46);     // Catch: Exception -> L146
    L136:
        Settings.Global.putInt(r45, NumberCheckManager.SETTINGS_KEY, r110);     // Catch: Exception -> L146
    L144:
        FixedPathXmlUtils.Companion.deleteFixedPathFile(SETTINGS_FILE_NAME, "restore/com.zte.heartyservice");     // Catch: Exception -> L146
        return;
    L135:
        r110 = 0;
        goto L136
    L137:
        SettingsUtils r47 = this;     // Catch: Exception -> L146
        if (r13 == true) goto L140;
        r16 = r16 | r17;     // Catch: Exception -> L146
    L140:
        ContentResolver r48 = r22.getContentResolver();     // Catch: Exception -> L146
        Intrinsics.checkNotNullExpressionValue(r48, "context.contentResolver");     // Catch: Exception -> L146
        handleCallFlags(r16, r48);     // Catch: Exception -> L146
        if (r13 == true) goto L143;
        r18 = r18 | r19;     // Catch: Exception -> L146
    L143:
        ContentResolver r49 = r22.getContentResolver();     // Catch: Exception -> L146
        Intrinsics.checkNotNullExpressionValue(r49, "context.contentResolver");     // Catch: Exception -> L146
        handleCallMarkFlags(r18, r49);     // Catch: Exception -> L146
        goto L144
    L117:
        r39 = 0;
        goto L118
    L119:
        SettingsUtils r50 = this;     // Catch: Exception -> L146
        if (r13 == true) goto L122;
        r14 = r14 | r15;     // Catch: Exception -> L146
    L122:
        ContentResolver r51 = r22.getContentResolver();     // Catch: Exception -> L146
        Intrinsics.checkNotNullExpressionValue(r51, "context.contentResolver");     // Catch: Exception -> L146
        handleSmsFlags(r14, r51);     // Catch: Exception -> L146
        goto L123
    L7:
        r1 = r0.getInstance().parseObject(r10, Map.class);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        OLog.e("FixedPathXmlUtils", "从固定路径读取对象失败", e);     // Catch: Exception -> L146
        r1 = null;
    L146:
        e = move-exception;
        OLog.e(TAG, "restore settings failed", e);
        String r52 = e.getMessage();
        if (r52 != null) goto L150;
        r52 = "";
    L150:
        r23.put("settings_restore_failed", r52);
        r23.put("success", "0");
    }

    private final void handleSmsFlags(int r10, ContentResolver r11) {
        ZTESMSInterceptFlags[] r9 = ZTESMSInterceptFlags.values();
        int r0 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L24;
        ZTESMSInterceptFlags r4 = r9[r2];
        if ((r4.getMask() & r10) == 0) goto L7;
        boolean r5 = true;
    L8:
        int r7 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r7 != 1) goto L11;
        if (r5 == false) goto L23;
        r3 = r3 | 2;
    L23:
        r2 = r2 + 1;
        goto L3
    L11:
        if (r7 != 2) goto L13;
    L19:
        if (r5 == false) goto L23;
        r3 = r3 | 4;
        goto L23
    L13:
        if (r7 == 3) goto L19;
        if (r7 == 4) goto L19;
        if (r7 == 5) goto L19;
        OLog.i(TAG, "未处理的短信拦截规则 " + r4.name());
        goto L23
    L7:
        r5 = false;
        goto L8
    L24:
        Settings.System.putInt(r11, SmsBodyCheckManager.SMS_INTERCEPT_YULORE_TYPE, r3);
    }

    private final void handleCallFlags(int r4, ContentResolver r5) {
        ZTECallInterceptFlags[] r3 = ZTECallInterceptFlags.values();
        int r6 = r3.length;
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L5;
        ZTECallInterceptFlags r0 = r3[r7];
        r0.getMask();
        OLog.i(TAG, "未处理的电话拦截规则 " + r0.name());
        r7 = r7 + 1;
        goto L3
    }

    private final void handleCallMarkFlags(int r10, ContentResolver r11) {
        ZTECallMarkInterceptFlags[] r9 = ZTECallMarkInterceptFlags.values();
        int r0 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L26;
        ZTECallMarkInterceptFlags r4 = r9[r2];
        if ((r4.getMask() & r10) == 0) goto L7;
        boolean r5 = true;
    L8:
        int r7 = WhenMappings.$EnumSwitchMapping$1[r4.ordinal()];
        if (r7 != 1) goto L11;
        if (r5 == false) goto L25;
        r3 = r3 | 1;
    L25:
        r2 = r2 + 1;
        goto L3
    L11:
        if (r7 != 2) goto L13;
        if (r5 == false) goto L25;
        r3 = r3 | 16;
        goto L25
    L13:
        if (r7 != 3) goto L15;
        if (r5 == false) goto L25;
        r3 = ((r3 | 2) | 256) | 512;
        goto L25
    L15:
        if (r7 == 4) goto L17;
        OLog.i(TAG, "未处理的电话标记规则 " + r4.name());
        goto L25
    L17:
        if (r5 == false) goto L25;
        r3 = r3 | 4;
        goto L25
    L7:
        r5 = false;
        goto L8
    L26:
        Settings.Global.putInt(r11, NumberCheckManager.SETTINGS_KEY, r3);
    }
}
