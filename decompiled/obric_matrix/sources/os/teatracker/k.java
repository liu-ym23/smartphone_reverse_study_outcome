package os.teatracker;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    static JSONObject a(JSONObject r4) {
        if (r4 == null) goto L14;
        return new JSONObject(r4.toString());
    L5:
        String r0 = f.f22710g;
        StringBuilder r1 = new StringBuilder();
        r1.append("Failed to copy Tea json obj");
        if (f.f22709f == false) goto L8;
        String r5 = " from " + r4;
    L9:
        r1.append(r5);
        Log.e(r0, r1.toString());
        return null;
    L8:
        r5 = ".";
        goto L9
    L14:
        return null;
    }

    public static String b(Context r4) {
        PackageInfo r5 = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 128);     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L15
        Bundle r2 = r5.applicationInfo.metaData;     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L15
        if (r2 != null) goto L6;
    L17:
        return null;
    L6:
        if (r2.containsKey("teatracker_app_id") == false) goto L17;
        String r3 = r5.applicationInfo.metaData.getString("teatracker_app_id", null);     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L15
        if (TextUtils.isEmpty(r3) == false) goto L20;
        int r6 = r5.applicationInfo.metaData.getInt("teatracker_app_id", 0);     // Catch: Exception -> L13 PackageManager.NameNotFoundException -> L15
        if (r6 == 0) goto L21;
        return String.valueOf(r6);
    L21:
        return r3;
    L20:
        return r3;
    L15:
        e = move-exception;
        Log.e(f.f22710g, "get package info error!", e);
    L13:
        e = move-exception;
        Log.e(f.f22710g, e.toString());
        goto L17
    }

    public static String c(String r7) {
        Method r1 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});     // Catch: Throwable -> L5
        r1.setAccessible(true);     // Catch: Throwable -> L5
        return (String) r1.invoke(null, new Object[]{r7});
    L5:
        e = move-exception;
        Log.e(f.f22710g, "getProperty failed!", e);
        return null;
    }

    public static boolean d() {
        if ("userdebug".equals(c("ro.build.type")) == false) goto L5;
        return true;
    L5:
        return LocationInfoConst.ALLOW_USE_LOCATION.equals(c("persist.sys.tealog.enable"));
    }

    static boolean e(Context r0) {
        return true;
    }
}
