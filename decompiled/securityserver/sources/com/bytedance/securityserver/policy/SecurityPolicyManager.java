package com.bytedance.securityserver.policy;

import a.a;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.securityserver.adapter.SecurityLibFactory;
import com.bytedance.securityserver.adapter.api.ISecurityGuard;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyUtils;
import com.bytedance.securityserver.securitylog.SecurityLogConfigUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SecurityPolicyManager {
    private static final String PATH = "/data/misc/security/guard/";
    private static final String ROBOTS_POLICY_FILE = "robots_policy.json";
    public static final String SECURITY_LOG_CONFIG_FILE = "security_log_config.json";
    private static final String SENS_VIEW_FILE = "sen_data.json";
    private static final String SENS_WORDS_2_FILE = "sens_words_2.json";
    private static final String SENS_WORDS_FILE = "sens_words.json";
    public static final String SETTING_KEY_ROBOTS_POLICY = "settings_robots_policy";
    public static final String SETTING_KEY_SECURITY_LOG = "settings_security_log";
    public static final String SETTING_KEY_SENS_VIEWS = "settings_sens_views";
    public static final String SETTING_KEY_SENS_WORDS = "settings_sens_words";
    private static final String TAG = "SecurityPolicyManager";
    private final Context mContext;

    public SecurityPolicyManager(Context r1) {
        this.mContext = r1;
        initSecurityPolicy(r1);
    }

    public static String getPolicyFromAssets(Context r7, String r8) {
        StringBuilder r2 = new StringBuilder();
        BufferedReader r3 = null;
        InputStream r9 = r7.getAssets().open(r8);     // Catch: Throwable -> L27 Exception -> L29
    L72:
        BufferedReader r10 = new BufferedReader(new InputStreamReader(r9, StandardCharsets.UTF_8));     // Catch: Throwable -> L23 Exception -> L25
    L55:
        String r4 = r10.readLine();     // Catch: Throwable -> L9 Exception -> L11
        if (r4 == null) goto L66;
        r2.append(r4);     // Catch: Throwable -> L9 Exception -> L11
        goto L55
    L66:
        r10.close();     // Catch: Exception -> L15
    L17:
        if (r9 == null) goto L43;
        r9.close();     // Catch: Exception -> L20
    L20:
        e = e;
        StringBuilder r11 = new StringBuilder("getPolicyFromAssets occur exception, ");
    L22:
        a.C(e, r11, TAG);
    L43:
        return r2.toString();
    L15:
        e = move-exception;
        a.C(e, new StringBuilder("getPolicyFromAssets occur exception, "), TAG);
    L11:
        Exception e = e;
    L31:
        Log.e(TAG, "getPolicyFromAssets occur exception, " + e.getMessage());     // Catch: Throwable -> L9
        if (r10 != null) goto L60;
    L37:
        if (r9 == null) goto L43;
        r9.close();     // Catch: Exception -> L40
    L40:
        e = e;
        r11 = new StringBuilder("getPolicyFromAssets occur exception, ");
        goto L22
    L60:
        r10.close();     // Catch: Exception -> L35
    L35:
        e = move-exception;
        a.C(e, new StringBuilder("getPolicyFromAssets occur exception, "), TAG);
    L9:
        th = th;
        r3 = r10;
    L44:
        if (r3 != null) goto L58;
    L49:
        if (r9 == null) goto L75;
        r9.close();     // Catch: Exception -> L52
        throw th;
    L52:
        e = move-exception;
        a.C(e, new StringBuilder("getPolicyFromAssets occur exception, "), TAG);
        throw th;
    L75:
        throw th;
    L58:
        r3.close();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        a.C(e, new StringBuilder("getPolicyFromAssets occur exception, "), TAG);
        goto L49
    L25:
        e = move-exception;
        e = e;
        r10 = null;
    L23:
        th = th;
    L29:
        e = move-exception;
        r10 = null;
        e = e;
        r9 = null;
    L27:
        th = th;
        r9 = null;
        goto L44
    }

    public static void initSecurityPolicy(Context r8) {
        String r6 = getPolicyFromAssets(r8, SENS_WORDS_FILE);     // Catch: Exception -> L6
        updatePolicyFile(new JSONObject(r6).getString(RobotsPolicyContract.COL_VERSION), r6, SENS_WORDS_FILE);     // Catch: Exception -> L6
        String r3 = getPolicyFromAssets(r8, SENS_WORDS_2_FILE);     // Catch: Exception -> L6
        updatePolicyFile(new JSONObject(r3).getString(RobotsPolicyContract.COL_VERSION), r3, SENS_WORDS_2_FILE);     // Catch: Exception -> L6
        String r2 = getPolicyFromAssets(r8, SENS_VIEW_FILE);     // Catch: Exception -> L6
        updatePolicyFile(new JSONObject(r2).getString(RobotsPolicyContract.COL_VERSION), r2, SENS_VIEW_FILE);     // Catch: Exception -> L6
        String r1 = getPolicyFromAssets(r8, ROBOTS_POLICY_FILE);     // Catch: Exception -> L6
        updatePolicyFile(new JSONObject(r1).getString(RobotsPolicyContract.COL_VERSION), r1, ROBOTS_POLICY_FILE);     // Catch: Exception -> L6
        RobotsPolicyUtils.updateRobotsPolicyConfig(r1);     // Catch: Exception -> L6
        String r9 = getPolicyFromAssets(r8, SECURITY_LOG_CONFIG_FILE);     // Catch: Exception -> L6
        updatePolicyFile(new JSONObject(r9).getString(RobotsPolicyContract.COL_VERSION), r9, SECURITY_LOG_CONFIG_FILE);     // Catch: Exception -> L6
        ISecurityGuard r0 = SecurityLibFactory.c();     // Catch: Exception -> L6
        if (r0 == null) goto L8;
        String r4 = r0.b(SECURITY_LOG_CONFIG_FILE);     // Catch: Exception -> L6
    L10:
        if (TextUtils.isEmpty(r4) == true) goto L13;
        r9 = r4;
    L13:
        SecurityLogConfigUtils.d(SecurityLogConfigUtils.b(r9));     // Catch: Exception -> L6
        return;
    L8:
        r4 = null;
    L6:
        e = move-exception;
        a.C(e, new StringBuilder("initSecurityPolicy occur exception, "), TAG);
    }

    private static int isFileExist(String r2) {
        ISecurityGuard r1 = SecurityLibFactory.c();     // Catch: Exception -> L11
        if (r1 != null) goto L6;
        return -1;
    L6:
        String r3 = r1.b(r2);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r3) == false) goto L9;
        return -1;
    L9:
        return new JSONObject(r3).getInt(RobotsPolicyContract.COL_VERSION);
    L11:
        return -1;
    }

    public static boolean updatePolicyFile(String r5, String r6, String r7) {
    L9:
        e = move-exception;
        a.C(e, new StringBuilder("updatePolicyFile occur exception, "), TAG);
    L16:
        return false;
    L4:
        if (Integer.parseInt(r5) <= isFileExist(r7)) goto L13;
        ISecurityGuard r8 = SecurityLibFactory.c();     // Catch: Exception -> L9
        if (r8 != null) goto L11;
        Log.w(TAG, "SecurityGuard unavailable, skip updatePolicyFile: " + r7);     // Catch: Exception -> L9
        return false;
    L11:
        r8.a(r7, r6);     // Catch: Exception -> L9
        return true;
    L13:
        Log.i(TAG, r7 + " version not update, version: " + r5);     // Catch: Exception -> L9
        goto L16
    }
}
