package com.bytedanceos.securitycenter.networkControl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.NetworkPolicyManager;
import android.os.AsyncTask;
import android.util.Pair;
import com.bytedanceos.security.AppExitTrace;
import com.bytedanceos.securitycenter.SharedPreferUtil;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkRejectHelper {
    private static final boolean DEBUG = false;
    public static final String NETWORKPOLICY_CHANGE_APP = "networkPolicy_change_app";
    public static final String NETWORKPOLICY_DOZE_INIT = "doze_init";
    public static final String NETWORKPOLICY_INIT = "init";
    public static final String NETWORK_CONTROL = "network_control";
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_ALL_BACKGROUND = 16;
    public static final int POLICY_REJECT_ALL_BACKGROUND_SCREEN_OFF = 8;
    private static final String PREFERENCES_DOZE_SYSTEM_WHITE_KEY = "doze_system_white_key";
    private static final String PREFERENCES_DOZE_WHITE_KEY = "doze_white_list";
    private static final String TAG = "NetworkRejectHelper";

    public NetworkRejectHelper() {
    }

    static /* synthetic */ void access$000(Context r0, int r1) {
        removeChangeAppSp(r0, r1);
    }

    public static Set<String> getWhiteList(Context context) {
        Set<String> r0 = context.getSharedPreferences(NETWORK_CONTROL, 0).getStringSet(PREFERENCES_DOZE_WHITE_KEY, null);
        if (r0 != null) goto L5;
    L7:
        HashSet r1 = new HashSet();
        Collections.addAll(r1, context.getResources().getStringArray(R.array.doze_white_list));
        return r1;
    L5:
        if (r0.size() <= 0) goto L7;
        return r0;
    }

    public static Set<String> getSystemWhiteList(Context context) {
        Set<String> r0 = context.getSharedPreferences(NETWORK_CONTROL, 0).getStringSet(PREFERENCES_DOZE_SYSTEM_WHITE_KEY, null);
        if (r0 != null) goto L5;
    L7:
        HashSet r1 = new HashSet();
        Collections.addAll(r1, context.getResources().getStringArray(R.array.doze_system_white_list));
        return r1;
    L5:
        if (r0.size() <= 0) goto L7;
        return r0;
    }

    public static Set<String> getNetSystemWhiteList(Context context) {
        return context.getSharedPreferences(NETWORK_CONTROL, 0).getStringSet(PREFERENCES_DOZE_SYSTEM_WHITE_KEY, null);
    }

    public static Set<String> getLocalSystemWhiteList(Context context) {
        if (context != null) goto L5;
        return null;
    L5:
        HashSet r0 = new HashSet();
        Collections.addAll(r0, context.getResources().getStringArray(R.array.doze_system_white_list));
        return r0;
    }

    public static Pair<Set<String>, Set<String>> parseJson(String json) {
        HashSet r0 = new HashSet();
        HashSet r1 = new HashSet();
        JSONObject r2 = new JSONObject(json);     // Catch: JSONException -> L10
        JSONArray r7 = r2.getJSONArray("doze_white_app");     // Catch: JSONException -> L10
        int r3 = r7.length();     // Catch: JSONException -> L10
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L6;
        r0.add((String) r7.get(r5));     // Catch: JSONException -> L10
        r5 = r5 + 1;     // Catch: JSONException -> L10
        goto L4
    L6:
        JSONArray r8 = r2.getJSONArray("doze_system_white_app");     // Catch: JSONException -> L10
        int r6 = r8.length();     // Catch: JSONException -> L10
    L7:
        if (r4 >= r6) goto L13;
        r1.add((String) r8.get(r4));     // Catch: JSONException -> L10
        r4 = r4 + 1;
    L13:
        return new Pair(r0, r1);
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static void saveToPreferences(Context context, String json) {
        SharedPreferences r0 = context.getSharedPreferences(NETWORK_CONTROL, 0);
        Pair<Set<String>, Set<String>> r9 = parseJson(json);
        Set<String> r2 = (Set) r9.first;
        Set<String> r10 = (Set) r9.second;
        Set<String> r3 = r0.getStringSet(PREFERENCES_DOZE_WHITE_KEY, Collections.emptySet());
        Set<String> r5 = r0.getStringSet(PREFERENCES_DOZE_SYSTEM_WHITE_KEY, Collections.emptySet());
        r2.remove("com.bullet.messenger");
        SharedPreferUtil.commitAsynchronously(r0.edit().putStringSet(PREFERENCES_DOZE_WHITE_KEY, r2).putStringSet(PREFERENCES_DOZE_SYSTEM_WHITE_KEY, r10));
        HashSet r1 = new HashSet();
        HashSet r4 = new HashSet();
        if (r3 == null) goto L10;
        Iterator<String> r6 = r3.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        String r7 = r6.next();
        if (r2.remove(r7) == true) goto L6;
        r4.add(r7);
    L10:
        r1.addAll(r2);
        updatePolicyForApp(context, r1, r4, false);
        r1.clear();
        r4.clear();
        if (r5 == null) goto L18;
        Iterator<String> r8 = r5.iterator();
    L14:
        if (r8.hasNext() == false) goto L18;
        String r11 = r8.next();
        if (r10.remove(r11) == true) goto L14;
        r4.add(r11);
    L18:
        r1.addAll(r10);
        updatePolicyForApp(context, r1, r4, true);
    }

    public static void updatePackageInstall(final Context context, final String packageName, final int userId) {
        AsyncTask.execute(new AnonymousClass1(packageName, userId, context));
    }

    public static int setDefaultPolicyForPackage(ApplicationInfo applicationInfo, Context context) {
        int r1 = 0;
        if ((applicationInfo.flags & 1) == 0) goto L6;
        return 0;
    L6:
        if (applicationInfo.uid != 1000) goto L8;
    L17:
        return r1;
    L8:
        if (applicationInfo.uid < 10000) goto L17;
        if (getWhiteList(context).contains(applicationInfo.packageName) == true) goto L14;
        r1 = 8;
    L14:
        NetworkPolicyManager.from(context);
        if (r1 != 0) goto L17;
        DeviceIdleControllerHelper.addApp(applicationInfo.packageName);
        goto L17
    }

    public static void setRealPolicy(NetworkPolicyManager networkPolicyManager, int uid, int mode) {
        if (networkPolicyManager != null) goto L5;
        return;
    L5:
        if (mode != 8) goto L8;
        networkPolicyManager.setUidPolicy(uid, 0);
        return;
    L8:
        networkPolicyManager.setUidPolicy(uid, mode);
    }

    public static void checkInit(final Context context) {
        SharedPreferences r0 = context.getSharedPreferences(NETWORK_CONTROL, 0);
        boolean r2 = r0.getBoolean("init", false);
        OLog.i(TAG, "checkInit#init:" + r2);
        if (r2 == true) goto L5;
        AppExitTrace.getInstance().addTask(AppExitTrace.TASK_NRDS_INIT_DATA);
        Intent r1 = new Intent(context, NetworkRejectDataService.class);
        r1.setAction(NetworkRejectDataService.ACTION_INIT_DATA);
        context.startService(r1);
        return;
    L5:
        boolean r3 = r0.getBoolean(NETWORKPOLICY_DOZE_INIT, false);
        OLog.i(TAG, "checkInit#dozeInit:" + r3);
        if (r3 == true) goto L8;
        AppExitTrace.getInstance().addTask(AppExitTrace.TASK_NRDS_INIT_DOZE_DATA);
        Intent r4 = new Intent(context, NetworkRejectDataService.class);
        r4.setAction(NetworkRejectDataService.ACTION_INIT_DOZE_DATA);
        context.startService(r4);
        return;
    L8:
        AppExitTrace.getInstance().addTask(AppExitTrace.TASK_NRDS_UPDATE_DOZE_DATA);
        Intent r5 = new Intent(context, NetworkRejectDataService.class);
        r5.setAction(NetworkRejectDataService.ACTION_UPDATE_DOZE_DATA);
        context.startService(r5);
    }

    public static void onPackageRemove(final Context context, String packageName, final int uid) {
        AsyncTask.execute(new AnonymousClass2(context, uid));
    }

    private static void removeChangeAppSp(Context context, final int uid) {
        SharedPreferences r3 = context.getSharedPreferences(NETWORK_CONTROL, 0);
        Set<String> r0 = r3.getStringSet(NETWORKPOLICY_CHANGE_APP, Collections.emptySet());
        if (r0 != null) goto L5;
    L7:
        SharedPreferUtil.commitAsynchronously(r3.edit().putStringSet(NETWORKPOLICY_CHANGE_APP, r0));
        return;
    L5:
        if (r0.size() <= 0) goto L7;
        r0.remove(String.valueOf(uid));
        goto L7
    }

    private static void updatePolicyForApp(Context context, Set<String> addSet, Set<String> removeSet, boolean system) {
        PackageManager r0 = context.getPackageManager();
        if (r0 != null) goto L5;
        return;
    L5:
        List<PackageInfo> r1 = r0.getInstalledPackages(0);
        if (r1 != null) goto L8;
        return;
    L8:
        NetworkPolicyManager r2 = NetworkPolicyManager.from(context);
        Set<String> r8 = context.getSharedPreferences(NETWORK_CONTROL, 0).getStringSet(NETWORKPOLICY_CHANGE_APP, Collections.emptySet());
        HashSet r3 = new HashSet();
        HashSet r4 = new HashSet();
        Iterator<PackageInfo> r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L31;
        PackageInfo r6 = r5.next();
        if (system == false) goto L16;
        if ((r6.applicationInfo.flags & 1) == 0) goto L10;
    L16:
        if (r8 == null) goto L10;
        if (r8.contains(String.valueOf(r6.applicationInfo.uid)) == true) goto L10;
        if (addSet.contains(r6.applicationInfo.packageName) == true) goto L22;
        if (removeSet.contains(r6.applicationInfo.packageName) == false) goto L10;
        if (r6.applicationInfo.uid < 10000) goto L30;
        setRealPolicy(r2, r6.applicationInfo.uid, 8);
    L30:
        r4.add(r6.applicationInfo.packageName);
        goto L10
    L22:
        if (r6.applicationInfo.uid < 10000) goto L24;
        r2.setUidPolicy(r6.applicationInfo.uid, 0);     // Catch: Exception -> L33
    L24:
        r3.add(r6.applicationInfo.packageName);
        goto L10
    L31:
        DeviceIdleControllerHelper.addApps(r3);
        DeviceIdleControllerHelper.removeApps(r4);
    }
}
