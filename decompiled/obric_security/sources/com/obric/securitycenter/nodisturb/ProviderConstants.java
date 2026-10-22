package com.obric.securitycenter.nodisturb;

import android.net.Uri;
import android.provider.BaseColumns;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProviderConstants.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b \bÆ\u0002\u0018\u00002\u00020\u0001:\u0006 !\"#$%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR\u0011\u0010\u001e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\b¨\u0006&"}, d2 = {"Lcom/obric/securitycenter/nodisturb/ProviderConstants;", "", "()V", "AUTHORITY", "", "AUTHORITY_URI", "Landroid/net/Uri;", "getAUTHORITY_URI", "()Landroid/net/Uri;", "BLACK_LIST_SUMMARY_URI", "getBLACK_LIST_SUMMARY_URI", "BLACK_LIST_URI", "getBLACK_LIST_URI", "BLOCKED_CALL_LOG_URI", "getBLOCKED_CALL_LOG_URI", "CALL_INTERCEPT_COUNT_ADD_URI", "getCALL_INTERCEPT_COUNT_ADD_URI", "CALL_INTERCEPT_COUNT_URI", "getCALL_INTERCEPT_COUNT_URI", "IN_BLACK_LIST_URI", "getIN_BLACK_LIST_URI", "IN_WHITE_LIST_URI", "getIN_WHITE_LIST_URI", "KEYWORD_URI", "getKEYWORD_URI", "SMS_INTERCEPT_COUNT_URI", "getSMS_INTERCEPT_COUNT_URI", "TABLE_BLACK_LIST", "WHITE_LIST_COUNT_URI", "getWHITE_LIST_COUNT_URI", "WHITE_LIST_URI", "getWHITE_LIST_URI", "BlackList", "BlockedCallLog", "CallSummary", "KeyWord", "Sms", "WhiteList", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ProviderConstants {
    public static final String AUTHORITY = "com.obric.nodisturb.provider";
    private static final Uri AUTHORITY_URI = null;
    private static final Uri BLACK_LIST_SUMMARY_URI = null;
    private static final Uri BLACK_LIST_URI = null;
    private static final Uri BLOCKED_CALL_LOG_URI = null;
    private static final Uri CALL_INTERCEPT_COUNT_ADD_URI = null;
    private static final Uri CALL_INTERCEPT_COUNT_URI = null;
    public static final ProviderConstants INSTANCE = null;
    private static final Uri IN_BLACK_LIST_URI = null;
    private static final Uri IN_WHITE_LIST_URI = null;
    private static final Uri KEYWORD_URI = null;
    private static final Uri SMS_INTERCEPT_COUNT_URI = null;
    public static final String TABLE_BLACK_LIST = "blacklist";
    private static final Uri WHITE_LIST_COUNT_URI = null;
    private static final Uri WHITE_LIST_URI = null;

    /* JADX INFO: compiled from: ProviderConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/securitycenter/nodisturb/ProviderConstants$BlackList;", "Landroid/provider/BaseColumns;", "()V", "BLS_SUM", "", "BL_CALL_SUM", "BL_DELETED", "BL_NOTE", "BL_PHONE_NUMBER", "BL_PHOTO", "BL_SMS_SUM", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BlackList implements BaseColumns {
        public static final String BLS_SUM = "bls_sum";
        public static final String BL_CALL_SUM = "bl_call_sum";
        public static final String BL_DELETED = "deleted";
        public static final String BL_NOTE = "bl_note";
        public static final String BL_PHONE_NUMBER = "bl_phone_number";
        public static final String BL_PHOTO = "bl_photo";
        public static final String BL_SMS_SUM = "bl_sms_sum";
        public static final BlackList INSTANCE = null;

        static {
            INSTANCE = new BlackList();
        }

        private BlackList() {
        }
    }

    /* JADX INFO: compiled from: ProviderConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/securitycenter/nodisturb/ProviderConstants$BlockedCallLog;", "Landroid/provider/BaseColumns;", "()V", "BCL_BLACK_LIST_ID", "", "BCL_DATETIME", "BCL_PHONE_NUMBER", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BlockedCallLog implements BaseColumns {
        public static final String BCL_BLACK_LIST_ID = "bcl_bl_id";
        public static final String BCL_DATETIME = "bcl_datetime";
        public static final String BCL_PHONE_NUMBER = "bcl_phone_number";
        public static final BlockedCallLog INSTANCE = null;

        static {
            INSTANCE = new BlockedCallLog();
        }

        private BlockedCallLog() {
        }
    }

    /* JADX INFO: compiled from: ProviderConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/securitycenter/nodisturb/ProviderConstants$CallSummary;", "Landroid/provider/BaseColumns;", "()V", "CS_PHONE_NUMBER", "", "CS_SUM", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CallSummary implements BaseColumns {
        public static final String CS_PHONE_NUMBER = "bl_phone_number";
        public static final String CS_SUM = "bls_sum";
        public static final CallSummary INSTANCE = null;

        static {
            INSTANCE = new CallSummary();
        }

        private CallSummary() {
        }
    }

    /* JADX INFO: compiled from: ProviderConstants.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/securitycenter/nodisturb/ProviderConstants$KeyWord;", "Landroid/provider/BaseColumns;", "()V", "KEYWORD", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KeyWord implements BaseColumns {
        public static final KeyWord INSTANCE = null;
        public static final String KEYWORD = "kw_keyword";

        static {
            INSTANCE = new KeyWord();
        }

        private KeyWord() {
        }
    }

    /* JADX INFO: compiled from: ProviderConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/securitycenter/nodisturb/ProviderConstants$Sms;", "Landroid/provider/BaseColumns;", "()V", "ADDRESS", "", "BODY", "DATE", "DATE_SENT", "PROTOCOL", "READ", "REPLY_PATH_PRESENT", "SEEN", "SERVICE_CENTER", "SUBJECT", "SUBSCRIPTION_ID", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Sms implements BaseColumns {
        public static final String ADDRESS = "address";
        public static final String BODY = "body";
        public static final String DATE = "date";
        public static final String DATE_SENT = "date_sent";
        public static final Sms INSTANCE = null;
        public static final String PROTOCOL = "protocol";
        public static final String READ = "read";
        public static final String REPLY_PATH_PRESENT = "reply_path_present";
        public static final String SEEN = "seen";
        public static final String SERVICE_CENTER = "service_center";
        public static final String SUBJECT = "subject";
        public static final String SUBSCRIPTION_ID = "sub_id";

        static {
            INSTANCE = new Sms();
        }

        private Sms() {
        }
    }

    /* JADX INFO: compiled from: ProviderConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/securitycenter/nodisturb/ProviderConstants$WhiteList;", "Landroid/provider/BaseColumns;", "()V", "WL_CONTACT_ID", "", "WL_NOTE", "WL_PHONE_NUMBER", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class WhiteList implements BaseColumns {
        public static final WhiteList INSTANCE = null;
        public static final String WL_CONTACT_ID = "wl_contact_id";
        public static final String WL_NOTE = "wl_note";
        public static final String WL_PHONE_NUMBER = "wl_phone_number";

        static {
            INSTANCE = new WhiteList();
        }

        private WhiteList() {
        }
    }

    private ProviderConstants() {
    }

    static {
        INSTANCE = new ProviderConstants();
        Uri r0 = Uri.parse("content://com.obric.nodisturb.provider");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(\"content://$AUTHORITY\")");
        AUTHORITY_URI = r0;
        Uri r1 = Uri.withAppendedPath(r0, "keyword");
        Intrinsics.checkNotNullExpressionValue(r1, "withAppendedPath(AUTHORITY_URI, \"keyword\")");
        KEYWORD_URI = r1;
        Uri r2 = Uri.withAppendedPath(r0, TABLE_BLACK_LIST);
        Intrinsics.checkNotNullExpressionValue(r2, "withAppendedPath(AUTHORITY_URI, \"blacklist\")");
        BLACK_LIST_URI = r2;
        Uri r3 = Uri.withAppendedPath(r0, "callinterceptcount");
        Intrinsics.checkNotNullExpressionValue(r3, "withAppendedPath(AUTHORI…RI, \"callinterceptcount\")");
        CALL_INTERCEPT_COUNT_URI = r3;
        Uri r4 = Uri.withAppendedPath(r0, "blockedcalllog");
        Intrinsics.checkNotNullExpressionValue(r4, "withAppendedPath(AUTHORITY_URI, \"blockedcalllog\")");
        BLOCKED_CALL_LOG_URI = r4;
        Uri r5 = Uri.withAppendedPath(r0, "blacklistsummary");
        Intrinsics.checkNotNullExpressionValue(r5, "withAppendedPath(AUTHORI…_URI, \"blacklistsummary\")");
        BLACK_LIST_SUMMARY_URI = r5;
        Uri r6 = Uri.withAppendedPath(r0, "smsinterceptcount");
        Intrinsics.checkNotNullExpressionValue(r6, "withAppendedPath(AUTHORI…URI, \"smsinterceptcount\")");
        SMS_INTERCEPT_COUNT_URI = r6;
        Uri r7 = Uri.withAppendedPath(r0, "inblacklist");
        Intrinsics.checkNotNullExpressionValue(r7, "withAppendedPath(AUTHORITY_URI, \"inblacklist\")");
        IN_BLACK_LIST_URI = r7;
        Uri r8 = Uri.withAppendedPath(r0, "inwhitelist");
        Intrinsics.checkNotNullExpressionValue(r8, "withAppendedPath(AUTHORITY_URI, \"inwhitelist\")");
        IN_WHITE_LIST_URI = r8;
        Uri r9 = Uri.withAppendedPath(r0, "callinterceptcountadd");
        Intrinsics.checkNotNullExpressionValue(r9, "withAppendedPath(AUTHORI… \"callinterceptcountadd\")");
        CALL_INTERCEPT_COUNT_ADD_URI = r9;
        Uri r10 = Uri.withAppendedPath(r0, "whitelist");
        Intrinsics.checkNotNullExpressionValue(r10, "withAppendedPath(AUTHORITY_URI, \"whitelist\")");
        WHITE_LIST_URI = r10;
        Uri r11 = Uri.withAppendedPath(r0, "whitelistcount");
        Intrinsics.checkNotNullExpressionValue(r11, "withAppendedPath(AUTHORITY_URI, \"whitelistcount\")");
        WHITE_LIST_COUNT_URI = r11;
    }

    public final Uri getAUTHORITY_URI() {
        return AUTHORITY_URI;
    }

    public final Uri getKEYWORD_URI() {
        return KEYWORD_URI;
    }

    public final Uri getBLACK_LIST_URI() {
        return BLACK_LIST_URI;
    }

    public final Uri getCALL_INTERCEPT_COUNT_URI() {
        return CALL_INTERCEPT_COUNT_URI;
    }

    public final Uri getBLOCKED_CALL_LOG_URI() {
        return BLOCKED_CALL_LOG_URI;
    }

    public final Uri getBLACK_LIST_SUMMARY_URI() {
        return BLACK_LIST_SUMMARY_URI;
    }

    public final Uri getSMS_INTERCEPT_COUNT_URI() {
        return SMS_INTERCEPT_COUNT_URI;
    }

    public final Uri getIN_BLACK_LIST_URI() {
        return IN_BLACK_LIST_URI;
    }

    public final Uri getIN_WHITE_LIST_URI() {
        return IN_WHITE_LIST_URI;
    }

    public final Uri getCALL_INTERCEPT_COUNT_ADD_URI() {
        return CALL_INTERCEPT_COUNT_ADD_URI;
    }

    public final Uri getWHITE_LIST_URI() {
        return WHITE_LIST_URI;
    }

    public final Uri getWHITE_LIST_COUNT_URI() {
        return WHITE_LIST_COUNT_URI;
    }
}
