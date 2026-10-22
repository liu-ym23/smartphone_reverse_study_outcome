package os.teatracker;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class TeaUtil {
    public static final String TEATRACKER_APP_ID = "teatracker_app_id";

    static boolean isTrackerGranted(Context context) {
        return true;
    }

    public TeaUtil() {
    }

    public static String getProperty(String name) {
        Method r1 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});     // Catch: Throwable -> L5
        r1.setAccessible(true);     // Catch: Throwable -> L5
        return (String) r1.invoke(null, new Object[]{name});
    L5:
        e = move-exception;
        Log.e(TeaConfig.TAG, "getProperty failed!", e);
        return null;
    }

    public static int getPropertyInt(String name, int defaultValue) {
        Method r0 = Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return ((Integer) r0.invoke(null, new Object[]{name, Integer.valueOf(defaultValue)})).intValue();
    L4:
        e = move-exception;
        Log.e(TeaConfig.TAG, "getPropertyInt failed!", e);
        return defaultValue;
    }

    public static boolean isSystemDebuggable() {
        if ("userdebug".equals(getProperty("ro.build.type")) == false) goto L5;
        return true;
    L5:
        return "1".equals(getProperty("persist.sys.tealog.enable"));
    }

    static JSONObject copy(JSONObject jsonObject) {
        if (jsonObject == null) goto L14;
        return new JSONObject(jsonObject.toString());
    L5:
        String r0 = TeaConfig.TAG;
        StringBuilder r1 = new StringBuilder("Failed to copy Tea json obj");
        if (TeaConfig.DEBUG == false) goto L8;
        String r4 = " from " + jsonObject;
    L9:
        Log.e(r0, r1.append(r4).toString());
        return null;
    L8:
        r4 = ".";
        goto L9
    L14:
        return null;
    }

    public static String getAppId(Context context) {
        PackageInfo r4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L15
        if (r4.applicationInfo.metaData != null) goto L6;
    L17:
        return null;
    L6:
        if (r4.applicationInfo.metaData.containsKey(TEATRACKER_APP_ID) == false) goto L17;
        String r2 = r4.applicationInfo.metaData.getString(TEATRACKER_APP_ID, null);     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L15
        if (TextUtils.isEmpty(r2) == false) goto L20;
        int r5 = r4.applicationInfo.metaData.getInt(TEATRACKER_APP_ID, 0);     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L15
        if (r5 == 0) goto L21;
        return String.valueOf(r5);
    L21:
        return r2;
    L20:
        return r2;
    L15:
        e = move-exception;
        Log.e(TeaConfig.TAG, "get package info error!", e);
    L13:
        e = move-exception;
        Log.e(TeaConfig.TAG, e.toString());
        goto L17
    }
}
