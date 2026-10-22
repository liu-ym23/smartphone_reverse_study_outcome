package com.bytedance.securityserver.observer;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.motion.widget.a;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.securityserver.policy.EncryptedPolicy;
import com.bytedance.securityserver.policy.RobotsPolicy;
import com.bytedance.securityserver.policy.SecurityPolicyManager;
import com.bytedance.securityserver.policy.SensitiveViewPolicy;
import com.bytedance.securityserver.policy.SensitiveWordPolicy;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyManager;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyUtils;
import com.bytedance.securityserver.securitylog.SecurityLogConfig;
import com.bytedance.securityserver.securitylog.SecurityLogConfigUtils;
import com.bytedance.securityserver.utils.EventUploadUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.matrix.platform.sdk.ones.settings.SettingsUpdateListener;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SettingsViaMatrixListener implements SettingsUpdateListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile SettingsViaMatrixListener f57d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f58a;
    public final Context b;
    public Handler c;

    public SettingsViaMatrixListener(Context r2) {
        this.f58a = new GsonBuilder().create();
        this.b = r2;
    }

    public static synchronized SettingsViaMatrixListener e(Context r2) {
        monitor-enter(SettingsViaMatrixListener.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f57d != null) goto L9;
        f57d = new SettingsViaMatrixListener(r2);     // Catch: Throwable -> L7
    L9:
        SettingsViaMatrixListener r3 = f57d;     // Catch: Throwable -> L7
        monitor-exit(SettingsViaMatrixListener.class);
        return r3;
    }

    public final boolean a(String r5) {
        if (r5 != null) goto L5;
    L26:
        return false;
    L5:
        if (r5.trim().isEmpty() == true) goto L26;
        RobotsPolicy r1 = (RobotsPolicy) this.f58a.fromJson(r5, RobotsPolicy.class);
        if (r1 == null) goto L25;
        String r3 = r1.version;
        if (r3 == null) goto L25;
        if (r3.trim().isEmpty() == true) goto L25;
        SecurityPolicyManager.updatePolicyFile(r1.version, r5, "robots_policy.json");
        Context r4 = this.b;
        boolean r0 = RobotsPolicyUtils.isRobotsEnbled(r4);
        boolean r6 = RobotsPolicyUtils.updateRobotsPolicyConfig(r5);
        if (r6 == false) goto L24;
        boolean r7 = RobotsPolicyUtils.isRobotsEnbled(r4);
        if (r0 == true) goto L20;
        if (r7 == false) goto L20;
        Log.i("SettingsViaMatrixListener", "robots_protocol_enabled: disabled -> enabled, calling setup");
        RobotsPolicyManager.getInstance().setup(r4);
    L23:
        Settings.Global.putString(r4.getContentResolver(), SecurityPolicyManager.SETTING_KEY_ROBOTS_POLICY, r1.version);
    L20:
        if (r0 == false) goto L23;
        if (r7 == true) goto L23;
        Log.i("SettingsViaMatrixListener", "robots_protocol_enabled: enabled -> disabled, calling teardown");
        RobotsPolicyManager.getInstance().teardown();
    L24:
        return r6;
    L25:
        Log.w("SettingsViaMatrixListener", "Failed to parse robots_policy policy");
        goto L26
    }

    public final boolean b(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        SecurityLogConfig r7 = SecurityLogConfigUtils.b(r6);
        if (r7 != null) goto L8;
    L45:
        Log.w("SettingsViaMatrixListener", "Failed to parse security_log_config");
        return false;
    L8:
        if (TextUtils.isEmpty(r7.f64a) == true) goto L45;
        if (TextUtils.isEmpty(r7.f64a) == false) goto L53;
    L12:
        String r0 = null;
    L18:
        if (TextUtils.isEmpty(r0) == false) goto L20;
        return false;
    L20:
        SecurityPolicyManager.updatePolicyFile(r7.f64a, r0, SecurityPolicyManager.SECURITY_LOG_CONFIG_FILE);
        boolean r1 = SecurityLogConfigUtils.d(r7);
        if (r1 == false) goto L44;
        boolean r2 = SecurityLogConfigUtils.a(this.b);
        monitor-enter(EventUploadUtils.class);
        if (r2 == false) goto L29;
        EventUploadUtils.c();     // Catch: Throwable -> L26
    L38:
        monitor-exit(EventUploadUtils.class);
        Settings.Global.putString(this.b.getContentResolver(), SecurityPolicyManager.SETTING_KEY_SECURITY_LOG, r7.f64a);
        goto L44
    L29:
        monitor-enter(EventUploadUtils.class);     // Catch: Throwable -> L26
        ScheduledExecutorService r4 = EventUploadUtils.f81a;     // Catch: Throwable -> L35
        if (r4 != null) goto L48;
    L37:
        monitor-exit(EventUploadUtils.class);     // Catch: Throwable -> L26
        goto L38
    L48:
        r4.shutdownNow();     // Catch: Throwable -> L47
    L33:
        EventUploadUtils.f81a = null;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L44:
        return r1;
    L53:
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L15
        r3.put(RobotsPolicyContract.COL_VERSION, r7.f64a);     // Catch: JSONException -> L15
        r3.put("security_log_enabled", r7.b);     // Catch: JSONException -> L15
        r0 = r3.toString();     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        Log.e("SecurityLogConfigUtils", "normalize failed", e);
        goto L12
    }

    public final boolean c(String r4) {
        if (r4 != null) goto L5;
    L19:
        return false;
    L5:
        if (r4.trim().isEmpty() == true) goto L19;
        SensitiveViewPolicy r1 = (SensitiveViewPolicy) this.f58a.fromJson(r4, SensitiveViewPolicy.class);
        if (r1 == null) goto L18;
        String r2 = r1.version;
        if (r2 == null) goto L18;
        if (r2.trim().isEmpty() == true) goto L18;
        boolean r5 = SecurityPolicyManager.updatePolicyFile(r1.version, r4, "sen_data.json");
        if (r5 == false) goto L17;
        Settings.Global.putString(this.b.getContentResolver(), SecurityPolicyManager.SETTING_KEY_SENS_VIEWS, r1.version);
    L17:
        return r5;
    L18:
        Log.e("SettingsViaMatrixListener", "Failed to parse sensitive_views policy");
        goto L19
    }

    public final boolean d(String r12) {
        if (r12 != null) goto L5;
    L38:
        return false;
    L5:
        if (r12.trim().isEmpty() == true) goto L38;
        SensitiveWordPolicy r13 = (SensitiveWordPolicy) this.f58a.fromJson(r12, SensitiveWordPolicy.class);
        if (r13 == null) goto L37;
        String r2 = r13.version;
        if (r2 == null) goto L37;
        if (r2.trim().isEmpty() == true) goto L37;
        EncryptedPolicy[] r3 = r13.policies;
        if (r3 == null) goto L37;
        if (r3.length == 0) goto L37;
        String r4 = Build.SOC_MODEL;
        int r5 = r3.length;
        int r6 = 0;
        boolean r7 = false;
    L19:
        if (r6 >= r5) goto L34;
        EncryptedPolicy r8 = r3[r6];
        if (r8.encrypt_type.equalsIgnoreCase(WsConstants.KEY_PLATFORM) == true) goto L23;
        Log.e("SettingsViaMatrixListener", "encrypt type is not supported: " + r8.encrypt_type);
    L33:
        r6 = r6 + 1;
        goto L19
    L23:
        if (r4.equalsIgnoreCase(r8.platform) == false) goto L33;
        String r9 = r13.version;
        r8.version = r9;
        String r10 = r8.name;
        r10.getClass();
        if (r10.equals("base_policy") == false) goto L27;
        boolean r11 = SecurityPolicyManager.updatePolicyFile(r9, r8.toString(), "sens_words.json");
    L31:
        r7 = r7 | r11;
        goto L33
    L27:
        if (r10.equals("customer_policy") == true) goto L29;
        Log.e("SettingsViaMatrixListener", "policy name is not supported: " + r8.name);
        r11 = false;
        goto L31
    L29:
        r11 = SecurityPolicyManager.updatePolicyFile(r9, r8.toString(), "sens_words_2.json");
        goto L31
    L34:
        if (r7 == false) goto L36;
        Settings.Global.putString(this.b.getContentResolver(), SecurityPolicyManager.SETTING_KEY_SENS_WORDS, r13.version);
    L36:
        return r7;
    L37:
        Log.e("SettingsViaMatrixListener", "Failed to parse sensitive_words policy");
        goto L38
    }

    @Override // com.obric.matrix.platform.sdk.ones.settings.SettingsUpdateListener
    public final void onSettingsUpdate(String r4) {
        if (r4 != null) goto L4;
    L10:
        Log.i("SettingsViaMatrixListener", "onSettingsUpdate null");
        return;
    L4:
        if (r4.isEmpty() == true) goto L10;
        if ("null".equals(r4) == true) goto L10;
        this.c.post(new a(1, this, r4));
    }
}
