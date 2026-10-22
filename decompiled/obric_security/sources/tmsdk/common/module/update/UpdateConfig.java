package tmsdk.common.module.update;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.utils.Constants;
import com.obric.security.battertpower.healthandcharge.SmartChargeReceiver;
import com.obric.security.trafficHigh.TrafficHighWarningReceiver;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdateConfig {
    public static final String ADBLOCKING_REPORT_WHITE_NAME = null;
    public static final String ADB_DES_LIST_NAME = null;
    public static final String AMS_DATA = null;
    public static final String AMS_DATA_LANGUAGE = null;
    public static final String ANTITHEFT_WEB_SERVER_NUM = null;
    public static final String APP_USAGE_PRE_NAME = null;
    public static final String ARP_WHITELIST_NAME = null;
    public static final String BLACKLIST_KILL_PROCESS_NAME = null;
    public static final String CAMERA_SOFTWARE_NEW_LIST_PATH_NAME = null;
    public static final String CERTMD5_WHITELIST = null;
    public static final String DEEPCLEAN_SDCARD_SCAN_RULE_NAME = null;
    public static final String DEEPCLEAN_SDCARD_SCAN_RULE_NAME_V2_SDK = null;
    public static final String DEEPCLEAN_SOFTWARE_LIST_NAME = null;
    public static final String DEEPCLEAN_SOFT_PATH_LIST_NAME = null;
    public static final String DEEPCLEAN_SOFT_SCAN_RULE_NAME = null;
    public static final String DEEP_CLEAN_APPGROUP_DESC = null;
    public static final String DEEP_CLEAN_MEDIA_SRC_PATH_NAME = null;
    public static final String DEEP_CLEAN_WHITE_LIST_PATH_NAME = null;
    public static final String DeepCleanSdcardScanRuleWord = null;
    public static final String DeepCleanSoftScanRuleWord = null;
    public static final String[] FACTORY_FILE_NAMES = null;
    public static final int[] FILE_IDS = null;
    public static final String[] FILE_NAMES = null;
    public static final String GAME_SPEED_UP_LIST_NAME = null;
    public static final String H_LIST_NAME = null;
    public static final String KingUserPermision = null;
    public static final String LOCATION_NAME = null;
    public static final String MULTI_LANGUAGE_APPGROUP_DESC = null;
    public static final String NOTKILLLIST_KILL_PROCESSES_NAME = null;
    public static final String NUM_MARK_NAME = null;
    public static final String PATCH_SUFIX = ".patch";
    public static final String PAYLOAD_NAME = null;
    public static final String PCLinkedSoftCommunicateFlow = null;
    public static final String PERMIS_MONITOR_LIST_NAME = null;
    public static final String POSEIDON = null;
    public static final String POSEIDONV2 = null;
    public static final String PRIVACYLOCKLIST_USUAL_NAME = null;
    public static final String PROCESSMANAGER_WHITE_LIST_NAME = null;
    public static final String Payload_WHITELIST = null;
    public static final String QUICKPANEL_WIFIMANAGE = null;
    public static final String QUICK_PANEL_SUP = null;
    public static final String ROOT_PHONE_WHITE_LIST_PATH_NAME = null;
    public static final String RUBBISH_ENGLISH_TABLE_NAME = null;
    public static final String SDK_CONFIG_SETTING = null;
    public static final String SMS_CHECKER_NAME = null;
    public static final String SMS_CUSTOM_BLOCK_DIC = null;
    public static final String SMS_CUSTOM_BLOCK_MODEL = null;
    public static final String SMS_CUSTOM_BLOCK_MODEL_V4 = null;
    public static final String SMS_CUSTOM_BLOCK_MODEL_V5 = null;
    public static final String SMS_CUSTOM_BLOCK_RULE = null;
    public static final String SMS_CUSTOM_BLOCK_RULE_V4 = null;
    public static final String SMS_LABLE_NAME = null;
    public static final String SMS_NORMAL_KEY_WORD = null;
    public static final String SMS_REPLENISH_RULE_NAME = null;
    public static final String SkinConfig = null;
    public static final String SoftLock_LockFunc = null;
    public static final String SpaceMangerList = null;
    public static final String TMSLITE_COMMISION_LIST_NAME = null;
    public static final String TRAFFIC_MONITOR_CONFIG_NAME = null;
    public static final String TRP_NAME = null;
    public static final String TRP_NAME_V2 = null;
    public static final long UPDATA_FLAG_NUM_MARK = 536870912;
    public static final long UPDATE_ADBLOCKING_REPORT_WHITE_LIST = 134217728;
    public static final long[] UPDATE_FLAGS = null;
    public static final long UPDATE_FLAG_ADB_DES_LIST = 274877906944L;
    public static final long UPDATE_FLAG_ALL = 33554432;
    public static final long UPDATE_FLAG_AMS_DATA = 35184372088832L;
    public static final long UPDATE_FLAG_ANTITHEFT_WEB_SERVER_NUM = 17592186044416L;
    public static final long UPDATE_FLAG_APP_LIST = 67108864;
    public static final long UPDATE_FLAG_APP_USAGE_PRE = Long.MIN_VALUE;
    public static final long UPDATE_FLAG_ARP_WHITELIST = 8;
    public static final long UPDATE_FLAG_CAMERA_SOFTWARE_NEW_LIST = 34359738368L;
    public static final long UPDATE_FLAG_DEEPCLEAN_SDCARD_SCAN_RULE = 1099511627776L;
    public static final long UPDATE_FLAG_DEEPCLEAN_SOFTWARE_LIST = 262144;
    public static final long UPDATE_FLAG_DEEPCLEAN_SOFT_PATH_LIST = 524288;
    public static final long UPDATE_FLAG_DEEP_CLEAN_APPGROUP_DESC = 576460752303423488L;
    public static final long UPDATE_FLAG_DEEP_CLEAN_MEDIA_SRC_PATH = 268435456;
    public static final long UPDATE_FLAG_DEEP_CLEAN_WHITE_LIST = 17179869184L;
    public static final long UPDATE_FLAG_DeepCleanSdcardScanRuleWord = 1125899906842624L;
    public static final long UPDATE_FLAG_EFN_DeepCleanSoftScanRuleWord = 562949953421312L;
    public static final long UPDATE_FLAG_ENGLISH_TABLE = 4611686018427387904L;
    public static final long UPDATE_FLAG_GAME_SPEED_UP = 36028797018963968L;
    public static final long UPDATE_FLAG_H_LIST = 137438953472L;
    public static final long UPDATE_FLAG_KingUserPermision = 2251799813685248L;
    public static final long UPDATE_FLAG_LOCATION = 2;
    public static final long UPDATE_FLAG_MULTI_LANGUAGE_APPGROUP_DESC = 549755813888L;
    public static final long UPDATE_FLAG_NOTKILLLIST_KILL_PROCESSES = 2097152;
    public static final long UPDATE_FLAG_PCLinkedSoftCommunicateFlow = 140737488355328L;
    public static final long UPDATE_FLAG_PERMIS_MONITOR_LIST = 1048576;
    public static final long UPDATE_FLAG_POSEIDON = 18014398509481984L;
    public static final long UPDATE_FLAG_POSEIDONV2 = 144115188075855872L;
    public static final long UPDATE_FLAG_PROCESSMANAGER_WHITE_LIST = 4398046511104L;
    public static final long UPDATE_FLAG_QUICKPANEL_WIFIMANAGE = 72057594037927936L;
    public static final long UPDATE_FLAG_QUICK_PANEL_SUP = 70368744177664L;
    public static final long UPDATE_FLAG_ROOT_PHONE_WHITE_LIST = 68719476736L;
    public static final long UPDATE_FLAG_SDK_CONFIG_SETTING1L = 32;
    public static final long UPDATE_FLAG_SMS_CHECKER = 4;
    public static final long UPDATE_FLAG_SMS_CUSTOM_BLOCK_DIC = 16384;
    public static final long UPDATE_FLAG_SMS_CUSTOM_BLOCK_MODEL = 8192;
    public static final long UPDATE_FLAG_SMS_CUSTOM_BLOCK_MODEL_V4 = 256;
    public static final long UPDATE_FLAG_SMS_CUSTOM_BLOCK_MODEL_V5 = 8388608;
    public static final long UPDATE_FLAG_SMS_CUSTOM_BLOCK_RULE = 4096;
    public static final long UPDATE_FLAG_SMS_CUSTOM_BLOCK_RULE_V4 = 128;
    public static final long UPDATE_FLAG_SMS_LABLE = 16;
    public static final long UPDATE_FLAG_SMS_NORMAL_KEY_WORD = 4194304;
    public static final long UPDATE_FLAG_SMS_REPLENISH_RULE = 2048;
    public static final long UPDATE_FLAG_SkinConfig = 4503599627370496L;
    public static final long UPDATE_FLAG_SoftLock_LockFunc = 9007199254740992L;
    public static final long UPDATE_FLAG_TMSLITE_COMMISION_LIST = 8796093022208L;
    public static final long UPDATE_FLAG_TRAFFIC_MONITOR_CONFIG = 32;
    public static final long UPDATE_FLAG_TRP = 4294967296L;
    public static final long UPDATE_FLAG_TRP_V2 = 64;
    public static final long UPDATE_FLAG_VIRUS_BASE = 1073741824;
    public static final long UPDATE_FLAG_VIRUS_BASE_ENG = 2305843009213693952L;
    public static final long UPDATE_FLAG_VIRUS_LANGUAGE_FILE = 2199023255552L;
    public static final long UPDATE_FLAG_VIRUS_WHITELIST = 8589934592L;
    public static final long UPDATE_FLAG_WHITELIST_AUTO_BOOT = 32768;
    public static final long UPDATE_FLAG_WHITELIST_COMMON = 512;
    public static final long UPDATE_FLAG_WHITELIST_PERMISSION_CONTROL = 65536;
    public static final long UPDATE_FLAG_WHITELIST_UNUSUAL = 1024;
    public static final long UPDATE_FLAG_WeixinTrashClean = 281474976710656L;
    public static final long UPDATE_FLAG_YELLOW_PAGEV2_Large = 1152921504606846976L;
    public static final long UPDATE_FLAG_YELLOW_PAGE_OFFLINE_DATABASE = 288230376151711744L;
    public static final long UPDATE_FLAG_YELLOW_PAGE_OFFLINE_KEYWORDS = 16777216;
    public static final int UPDATE_TYPE_ENGINE_UPDATE = 1;
    public static final int UPDATE_TYPE_NORMAL_UPDATE = 0;
    public static final String VIRUS_BASE_EN_NAME = null;
    public static final String VIRUS_BASE_NAME = null;
    public static final String WHITELIST_AUTO_BOOT_NAME = null;
    public static final String WHITELIST_COMMON_NAME = null;
    public static final String WHITELIST_KILL_PROCESS_NAME = null;
    public static final String WHITELIST_PERMISSION_CONTROL_NAME = null;
    public static final String WHITELIST_Payload = null;
    public static final String WHITELIST_UNUSUAL_NAME = null;
    public static final String WeixinTrashClean = null;
    public static final String WeixinTrashCleanNew = null;
    public static final String YELLOW_PAGE = null;
    public static final String YELLOW_PAGEV2_LARGE = null;
    public static final String YELLOW_PAGE_OFFLINE_DATABASE = null;
    public static final String YELLOW_PAGE_OFFLINE_KEYWORDS = null;
    public static final String YELLOW_PAGE_VIVO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f58a = null;
    private static final String b = null;
    public static final Map<String, String> sDeprecatedNameMap = null;

    static {
        f58a = intToString(40459) + ".sdb";
        String r0 = intToString(40458) + ".sdb";
        NUM_MARK_NAME = r0;
        b = intToString(40606) + ".sdb";
        String r3 = intToString(50001) + ".sdb";
        LOCATION_NAME = r3;
        String r5 = intToString(60001) + ".sys";
        SMS_CHECKER_NAME = r5;
        String r6 = intToString(40673) + ".dat";
        ARP_WHITELIST_NAME = r6;
        String r8 = intToString(40674) + ".dat";
        SMS_LABLE_NAME = r8;
        String r9 = intToString(20001) + ".dat";
        TRAFFIC_MONITOR_CONFIG_NAME = r9;
        String r10 = intToString(10001) + ".dat";
        WHITELIST_COMMON_NAME = r10;
        String r11 = intToString(10002) + ".dat";
        WHITELIST_UNUSUAL_NAME = r11;
        String r12 = intToString(10007) + ".dat";
        PRIVACYLOCKLIST_USUAL_NAME = r12;
        String r13 = intToString(10008) + ".dat";
        BLACKLIST_KILL_PROCESS_NAME = r13;
        String r14 = intToString(10011) + ".dat";
        WHITELIST_KILL_PROCESS_NAME = r14;
        String r4 = intToString(10009) + ".dat";
        WHITELIST_AUTO_BOOT_NAME = r4;
        String r1 = intToString(10010) + ".dat";
        WHITELIST_PERMISSION_CONTROL_NAME = r1;
        String r15 = intToString(40634) + ".dat";
        WHITELIST_Payload = r15;
        String r16 = intToString(10013) + ".dat";
        DEEPCLEAN_SOFTWARE_LIST_NAME = r16;
        String r7 = intToString(10014) + ".dat";
        DEEPCLEAN_SOFT_PATH_LIST_NAME = r7;
        String r2 = intToString(10018) + ".dat";
        PERMIS_MONITOR_LIST_NAME = r2;
        String r17 = intToString(10015) + ".dat";
        NOTKILLLIST_KILL_PROCESSES_NAME = r17;
        String r18 = intToString(10017) + ".dat";
        ADBLOCKING_REPORT_WHITE_NAME = r18;
        String r19 = intToString(10016) + ".dat";
        DEEP_CLEAN_MEDIA_SRC_PATH_NAME = r19;
        String r20 = intToString(10019) + ".dat";
        DEEP_CLEAN_WHITE_LIST_PATH_NAME = r20;
        String r21 = intToString(10020) + ".dat";
        CAMERA_SOFTWARE_NEW_LIST_PATH_NAME = r21;
        String r22 = intToString(10021) + ".dat";
        ROOT_PHONE_WHITE_LIST_PATH_NAME = r22;
        String r23 = intToString(70003) + ".amf";
        VIRUS_BASE_NAME = r23;
        String r24 = intToString(70002) + ".amf";
        VIRUS_BASE_EN_NAME = r24;
        String r25 = intToString(70701) + ".amf";
        PAYLOAD_NAME = r25;
        String r26 = intToString(40685) + ".dat";
        TRP_NAME = r26;
        String r27 = intToString(40822) + ".dat";
        TRP_NAME_V2 = r27;
        String r28 = intToString(40706) + ".dat";
        CERTMD5_WHITELIST = r28;
        Payload_WHITELIST = intToString(40634) + ".dat";
        String r29 = intToString(40001) + ".dat";
        H_LIST_NAME = r29;
        String r30 = intToString(40002) + ".dat";
        ADB_DES_LIST_NAME = r30;
        String r31 = intToString(40003) + ".dat";
        DEEPCLEAN_SOFT_SCAN_RULE_NAME = r31;
        String r32 = intToString(40248) + ".dat";
        DEEPCLEAN_SDCARD_SCAN_RULE_NAME = r32;
        String r33 = intToString(40415) + ".dat";
        DEEPCLEAN_SDCARD_SCAN_RULE_NAME_V2_SDK = r33;
        String r34 = intToString(40066) + ".dat";
        PROCESSMANAGER_WHITE_LIST_NAME = r34;
        String r35 = intToString(40007) + ".dat";
        TMSLITE_COMMISION_LIST_NAME = r35;
        String r36 = intToString(40008) + ".dat";
        ANTITHEFT_WEB_SERVER_NUM = r36;
        String r37 = intToString(40205) + ".dat";
        GAME_SPEED_UP_LIST_NAME = r37;
        String r38 = intToString(TrafficHighWarningReceiver.NOTIFICATION_ID) + ".dat";
        AMS_DATA = r38;
        String r39 = intToString(40011) + ".dat";
        QUICK_PANEL_SUP = r39;
        String r40 = intToString(40012) + ".dat";
        PCLinkedSoftCommunicateFlow = r40;
        String r41 = intToString(40013) + ".dat";
        WeixinTrashClean = r41;
        WeixinTrashCleanNew = intToString(40233) + ".dat";
        String r42 = intToString(40101) + ".dat";
        DeepCleanSoftScanRuleWord = r42;
        String r43 = intToString(40102) + ".dat";
        DeepCleanSdcardScanRuleWord = r43;
        String r44 = intToString(40201) + ".dat";
        KingUserPermision = r44;
        String r45 = intToString(SmartChargeReceiver.NOTIFICATION_ID) + ".dat";
        SkinConfig = r45;
        String r46 = intToString(40015) + ".dat";
        SoftLock_LockFunc = r46;
        String r47 = intToString(60002) + ".dat";
        POSEIDON = r47;
        String r48 = intToString(60003) + ".dat";
        POSEIDONV2 = r48;
        String r49 = intToString(40203) + ".dat";
        QUICKPANEL_WIFIMANAGE = r49;
        SpaceMangerList = intToString(40066) + ".dat";
        String r50 = intToString(80100) + ".dat";
        AMS_DATA_LANGUAGE = r50;
        YELLOW_PAGE = intToString(100009) + ".sdb";
        YELLOW_PAGE_VIVO = intToString(40801) + ".sdb";
        String r51 = intToString(40461) + ".sdb";
        YELLOW_PAGEV2_LARGE = r51;
        String r52 = intToString(40291) + ".dat";
        RUBBISH_ENGLISH_TABLE_NAME = r52;
        String r53 = intToString(40350) + ".dat";
        DEEP_CLEAN_APPGROUP_DESC = r53;
        String r54 = intToString(42610) + ".dat";
        MULTI_LANGUAGE_APPGROUP_DESC = r54;
        String r55 = intToString(40545) + ".dat";
        APP_USAGE_PRE_NAME = r55;
        String r56 = intToString(40638) + ".dat";
        SMS_CUSTOM_BLOCK_RULE = r56;
        String r57 = intToString(40641) + ".dat";
        SMS_CUSTOM_BLOCK_MODEL = r57;
        String r58 = intToString(40642) + ".dat";
        SMS_CUSTOM_BLOCK_DIC = r58;
        String r59 = intToString(40644) + ".dat";
        SMS_NORMAL_KEY_WORD = r59;
        String r60 = intToString(40815) + ".dat";
        SMS_CUSTOM_BLOCK_RULE_V4 = r60;
        String r61 = intToString(40808) + ".dat";
        SMS_CUSTOM_BLOCK_MODEL_V4 = r61;
        String r62 = intToString(58100) + ".dat";
        SMS_CUSTOM_BLOCK_MODEL_V5 = r62;
        String r63 = intToString(42600) + ".dat";
        SDK_CONFIG_SETTING = r63;
        String r64 = intToString(40714) + ".sdb";
        YELLOW_PAGE_OFFLINE_DATABASE = r64;
        String r65 = intToString(40726) + ".dat";
        YELLOW_PAGE_OFFLINE_KEYWORDS = r65;
        String r66 = intToString(41004) + ".dat";
        SMS_REPLENISH_RULE_NAME = r66;
        HashMap r67 = new HashMap();
        sDeprecatedNameMap = r67;
        r67.put(r3, "nldb.sdb");
        r67.put(r5, "rule_store.sys");
        r67.put(r9, "net_interface_type_traffic_stat.dat");
        r67.put(r10, "whitelist_common.dat");
        r67.put(r11, "whitelist_unusual.dat");
        r67.put(r12, "privacylocklist_usual.dat");
        r67.put(r13, "blacklist_kill_processes.dat");
        r67.put(r14, "whitelist_kill_process.dat");
        r67.put(r4, "whitelist_auto_root.dat");
        r67.put(r1, "whitelist_permission_control.dat");
        r67.put(r16, "deepclean_software_list.dat");
        r67.put(r7, "deepclean_soft_path_list.dat");
        r67.put(r2, "permis_monitor_list.dat");
        r67.put(r17, "notkilllist_kill_processes.dat");
        r67.put(r18, "adblocking_report_white.dat");
        r67.put(r19, "deep_clean_media_src_path.dat");
        r67.put(r0, "mark_v1.sdb");
        r67.put(r23, "qv_base.amf");
        r67.put(r20, "deep_clean_white_list.dat");
        r67.put(r21, "camera_software_new_list.dat");
        r67.put(r22, "root_phone_white_list.dat");
        r67.put(r29, "h_list.dat");
        r67.put(r30, "adb_des_list.dat");
        r67.put(r31, "deepclean_soft_scan_rule.dat");
        r67.put(r33, "deepclean_sdcard_scan_rule.dat");
        r67.put(r34, "processmanager_white_list.dat");
        r67.put(r35, "tmslite_commision_list.dat");
        FILE_IDS = new int[]{50001, 60001, 40673, 40674, 10001, 10002, 10009, 10010, 40634, 10013, 10014, 10018, 10015, 10017, 10016, 40458, 70003, 70701, 40685, 40822, 40706, 10019, 10020, 10021, 40001, 40002, 40248, 40066, 40007, 40008, TrafficHighWarningReceiver.NOTIFICATION_ID, 40011, 40012, 40013, 40101, 40102, 40201, SmartChargeReceiver.NOTIFICATION_ID, 40015, 60002, 40205, 40203, 60003, 40461, 70002, 40291, 40350, 40545, 40638, 40641, 40642, 40644, 40714, 40726, 40815, 40808, 41004, 80100, 58100, 42600, 42610};
        FILE_NAMES = new String[]{r3, r5, r6, r8, r10, r11, r4, r1, r15, r16, r7, r2, r17, r18, r19, r0, r23, r25, r26, r27, r28, r20, r21, r22, r29, r30, r32, r34, r35, r36, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r37, r49, r48, r51, r24, r52, r53, r55, r56, r57, r58, r59, r64, r65, r60, r61, r66, r50, r62, r63, r54};
        UPDATE_FLAGS = new long[]{2, 4, 8, 16, 512, 1024, 32768, 65536, PlaybackStateCompat.ACTION_PREPARE_FROM_URI, 262144, 524288, 1048576, 2097152, UPDATE_ADBLOCKING_REPORT_WHITE_LIST, UPDATE_FLAG_DEEP_CLEAN_MEDIA_SRC_PATH, UPDATA_FLAG_NUM_MARK, 1073741824, Constants.SWAP_FEATURE_PROPERTY_SIZE_2G, 4294967296L, 64, UPDATE_FLAG_VIRUS_WHITELIST, UPDATE_FLAG_DEEP_CLEAN_WHITE_LIST, UPDATE_FLAG_CAMERA_SOFTWARE_NEW_LIST, UPDATE_FLAG_ROOT_PHONE_WHITE_LIST, UPDATE_FLAG_H_LIST, UPDATE_FLAG_ADB_DES_LIST, UPDATE_FLAG_DEEPCLEAN_SDCARD_SCAN_RULE, UPDATE_FLAG_PROCESSMANAGER_WHITE_LIST, UPDATE_FLAG_TMSLITE_COMMISION_LIST, UPDATE_FLAG_ANTITHEFT_WEB_SERVER_NUM, UPDATE_FLAG_AMS_DATA, UPDATE_FLAG_QUICK_PANEL_SUP, UPDATE_FLAG_PCLinkedSoftCommunicateFlow, UPDATE_FLAG_WeixinTrashClean, UPDATE_FLAG_EFN_DeepCleanSoftScanRuleWord, UPDATE_FLAG_DeepCleanSdcardScanRuleWord, UPDATE_FLAG_KingUserPermision, UPDATE_FLAG_SkinConfig, UPDATE_FLAG_SoftLock_LockFunc, UPDATE_FLAG_POSEIDON, UPDATE_FLAG_GAME_SPEED_UP, UPDATE_FLAG_QUICKPANEL_WIFIMANAGE, UPDATE_FLAG_POSEIDONV2, 1152921504606846976L, 2305843009213693952L, UPDATE_FLAG_ENGLISH_TABLE, UPDATE_FLAG_DEEP_CLEAN_APPGROUP_DESC, Long.MIN_VALUE, 4096, 8192, 16384, UPDATE_FLAG_SMS_NORMAL_KEY_WORD, UPDATE_FLAG_YELLOW_PAGE_OFFLINE_DATABASE, UPDATE_FLAG_YELLOW_PAGE_OFFLINE_KEYWORDS, 128, 256, 2048, UPDATE_FLAG_VIRUS_LANGUAGE_FILE, UPDATE_FLAG_SMS_CUSTOM_BLOCK_MODEL_V5, 32, UPDATE_FLAG_MULTI_LANGUAGE_APPGROUP_DESC};
        FACTORY_FILE_NAMES = new String[]{intToString(40800) + ".sdb", intToString(40459) + ".sdb", intToString(40606) + ".sdb", intToString(100009) + ".sdb", intToString(40801) + ".sdb", intToString(40461) + ".sdb"};
    }

    private static String a(long r2) {
        if (2 != r2) goto L5;
        return ".sdb";
    L5:
        if (UPDATA_FLAG_NUM_MARK != r2) goto L7;
        return ".sdb";
    L7:
        if (1152921504606846976L != r2) goto L9;
        return ".sdb";
    L9:
        if (UPDATE_FLAG_YELLOW_PAGE_OFFLINE_DATABASE != r2) goto L12;
        return ".sdb";
    L12:
        if (4 != r2) goto L16;
        return ".sys";
    L16:
        if (1073741824 != r2) goto L18;
        return ".amf";
    L18:
        if (2305843009213693952L != r2) goto L20;
        return ".amf";
    L20:
        if (Constants.SWAP_FEATURE_PROPERTY_SIZE_2G == r2) goto L29;
        return ".dat";
    L29:
        return ".amf";
    }

    public static int getFileIdByFileName(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return 0;
    L5:
        int r0 = r2.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 > 0) goto L12;
        return 0;
    L12:
        return Integer.parseInt(r2.substring(0, r0));
    L11:
        return 0;
    }

    public static int getFileIdByFlag(long r4) {
        int r1 = 0;
    L3:
        long[] r2 = UPDATE_FLAGS;
        if (r1 >= r2.length) goto L10;
        if (r4 == r2[r1]) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        return FILE_IDS[r1];
    L10:
        return 0;
    }

    public static String getFileNameByFileId(int r3) {
        int r0 = 0;
    L3:
        int[] r1 = FILE_IDS;
        if (r0 >= r1.length) goto L10;
        if (r3 == r1[r0]) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return FILE_NAMES[r0];
    L10:
        return null;
    }

    public static String getFileNameByFlag(long r3) {
        int r0 = 0;
    L3:
        long[] r1 = UPDATE_FLAGS;
        if (r0 >= r1.length) goto L10;
        if (r3 == r1[r0]) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return FILE_NAMES[r0];
    L10:
        return null;
    }

    public static String getFileNameIdByFlag(long r3) {
        int r0 = 0;
    L3:
        long[] r1 = UPDATE_FLAGS;
        if (r0 >= r1.length) goto L10;
        if (r3 == r1[r0]) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return Integer.toString(FILE_IDS[r0]) + a(r3);
    L10:
        return null;
    }

    public static long getFlagByFileId(int r3) {
        int r0 = 0;
    L3:
        int[] r1 = FILE_IDS;
        if (r0 >= r1.length) goto L10;
        if (r3 == r1[r0]) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return UPDATE_FLAGS[r0];
    L10:
        return 0;
    }

    public static long getFlagByFileName(String r3) {
        int r0 = 0;
    L3:
        String[] r1 = FILE_NAMES;
        if (r0 >= r1.length) goto L10;
        if (r3.equals(r1[r0]) == true) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return UPDATE_FLAGS[r0];
    L10:
        return -1;
    }

    public static int getLargeMarkFileId() {
        return 40459;
    }

    public static String getLargeMarkFileName() {
        return f58a;
    }

    public static String intToString(int r0) {
        return Integer.toString(r0);
    L4:
        return "";
    }

    public static boolean isFactoryUpdatableAssetFile(String r4) {
        if (r4 != null) goto L5;
    L14:
        return false;
    L5:
        if (r4.length() == 0) goto L14;
        int r1 = FACTORY_FILE_NAMES.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        if (r4.equals(FACTORY_FILE_NAMES[r2]) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return true;
    }

    public static boolean isUpdatableAssetFile(String r4) {
        if (r4 != null) goto L5;
    L14:
        return false;
    L5:
        if (r4.length() == 0) goto L14;
        int r1 = FILE_NAMES.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        if (r4.equals(FILE_NAMES[r2]) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return true;
    }

    public static long prepareCheckFlag(long r6) {
        long r2 = 0;
        if ((33554432 & r6) == 0) goto L9;
        long[] r7 = UPDATE_FLAGS;
        int r8 = r7.length;
        int r0 = 0;
    L5:
        if (r0 >= r8) goto L23;
        r2 = r2 | r7[r0];
        r0 = r0 + 1;
        goto L5
    L23:
        return r2;
    L9:
        if ((UPDATE_FLAG_APP_LIST & r6) == 0) goto L13;
        long r1 = -2845134641676028000L;
    L25:
        return r6 | r1;
    L13:
        if ((UPDATE_FLAG_POSEIDONV2 & r6) == 0) goto L15;
    L22:
        r1 = 16;
        goto L25
    L15:
        if ((4096 & r6) != 0) goto L22;
        if ((128 & r6) != 0) goto L22;
        if ((1073741824 & r6) == 0) goto L26;
        r1 = UPDATE_FLAG_VIRUS_WHITELIST;
        goto L25
    L26:
        return r6;
    }
}
