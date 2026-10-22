package com.obric.security.battertpower;

import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.IPowerAdvisor;
import android.os.ServiceManager;
import com.obric.olog.OLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Pair;

/* JADX INFO: loaded from: classes4.dex */
public class PowerAdvisorService {
    public PowerAdvisorService() {
    }

    public static ArrayList<AppPowerProfileData> getAllAppPowerList() {
        ArrayList<AppPowerProfileData> r1 = new ArrayList();
        IPowerAdvisor r2 = IPowerAdvisor.Stub.asInterface(ServiceManager.getService("poweradvisor"));     // Catch: Exception -> L18
        if (r2 != null) goto L7;
        return null;
    L7:
        int r5 = 0;
        Object r3 = r2.getClass().getMethod("getAllAppPowerList", new Class[0]).invoke(r2, new Object[0]);     // Catch: Exception -> L18
        if ((r3 instanceof String[]) == false) goto L16;
        String[] r4 = (String[]) r3;     // Catch: Exception -> L18
        int r6 = r4.length;     // Catch: Exception -> L18
    L10:
        if (r5 >= r6) goto L15;
        AppPowerProfileData r7 = AppPowerProfileDataKt.toAppPowerProfileData(r4[r5]);     // Catch: Exception -> L18
        Pair<String, Drawable> r8 = BatteryPowerActivityViewModel.Companion.getAppInfo(r7.getPkg());     // Catch: Exception -> L18
        if (r8 == null) goto L14;
        r7.setAppName(r8.getFirst());     // Catch: Exception -> L18
        r7.setAppIcon(r8.getSecond());     // Catch: Exception -> L18
        r1.add(r7);     // Catch: Exception -> L18
    L14:
        r5 = r5 + 1;     // Catch: Exception -> L18
        goto L10
    L15:
        OLog.d("AppPowerProfileData", "get app power list :" + Arrays.toString(r4));     // Catch: Exception -> L18
    L20:
        return r1;
    L16:
        OLog.e("PowerAdvisorService", "get app power list error");     // Catch: Exception -> L18
    L18:
        e = move-exception;
        OLog.e("PowerAdvisorService", "get app power list error e: " + e.getMessage());
        goto L20
    }

    public static long computePowerSavingModeBatteryTimeRemaining() {
        long r2 = 0;
        IPowerAdvisor r4 = IPowerAdvisor.Stub.asInterface(ServiceManager.getService("poweradvisor"));     // Catch: Exception -> L8
        if (r4 != null) goto L6;
        return 0;
    L6:
        Object r5 = r4.getClass().getMethod("computePowerSavingModeBatteryTimeRemaining", new Class[0]).invoke(r4, new Object[0]);     // Catch: Exception -> L8
        r2 = ((Long) r5).longValue();     // Catch: Exception -> L8
        OLog.d("PowerAdvisorService", "computePowerSavingModeBatteryTimeRemaining value:" + r5);     // Catch: Exception -> L8
        return r2;
    L8:
        e = move-exception;
        OLog.e("PowerAdvisorService", "computePowerSavingModeBatteryTimeRemaining e: " + e.getMessage());
        return r2;
    }

    public static long computeBatteryTimeRemaining() {
        long r2 = 0;
        IPowerAdvisor r4 = IPowerAdvisor.Stub.asInterface(ServiceManager.getService("poweradvisor"));     // Catch: Exception -> L8
        if (r4 != null) goto L6;
        return 0;
    L6:
        Object r5 = r4.getClass().getMethod("computeBatteryTimeRemaining", new Class[0]).invoke(r4, new Object[0]);     // Catch: Exception -> L8
        r2 = ((Long) r5).longValue();     // Catch: Exception -> L8
        OLog.d("PowerAdvisorService", "computeBatteryTimeRemaining value:" + r5);     // Catch: Exception -> L8
        return r2;
    L8:
        e = move-exception;
        OLog.e("PowerAdvisorService", "computeBatteryTimeRemaining e: " + e.getMessage());
        return r2;
    }

    public static Object getIPowerAdvisor() {
        Method r1 = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class});     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        Object r2 = r1.invoke(null, new Object[]{"poweradvisor"});     // Catch: Exception -> L5
        return Class.forName("android.os.IPowerAdvisor$Stub").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r2});
    L8:
        return null;
    }
}
