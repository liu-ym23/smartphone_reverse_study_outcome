package com.android.settings.fuelgauge.appBatteryUseOptimization.apppoweruse;

import android.os.IBinder;
import android.os.IPowerAdvisor;
import android.os.ServiceManager;
import com.obric.olog.OLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class PowerAdvisorService {
    public PowerAdvisorService() {
    }

    public static ArrayList<AppPowerProfileData> getAllAppPowerList() {
        ArrayList<AppPowerProfileData> r1 = new ArrayList();
        IPowerAdvisor r2 = IPowerAdvisor.Stub.asInterface(ServiceManager.getService("poweradvisor"));     // Catch: Exception -> L15
        if (r2 != null) goto L7;
        return null;
    L7:
        int r5 = 0;
        Object r3 = r2.getClass().getMethod("getAllAppPowerList", new Class[0]).invoke(r2, new Object[0]);     // Catch: Exception -> L15
        if ((r3 instanceof String[]) == false) goto L13;
        String[] r4 = (String[]) r3;     // Catch: Exception -> L15
        int r6 = r4.length;     // Catch: Exception -> L15
    L10:
        if (r5 >= r6) goto L12;
        r1.add(AppPowerProfileDataKt.toAppPowerProfileData(r4[r5]));     // Catch: Exception -> L15
        r5 = r5 + 1;     // Catch: Exception -> L15
        goto L10
    L12:
        OLog.d("AppPowerProfileData", "get app power list :" + Arrays.toString(r4));     // Catch: Exception -> L15
    L17:
        return r1;
    L13:
        OLog.e("AppPowerProfileData", "get app power list error");     // Catch: Exception -> L15
    L15:
        e = move-exception;
        OLog.e("AppPowerProfileData", "get app power list error e: " + e.getMessage());
        goto L17
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
