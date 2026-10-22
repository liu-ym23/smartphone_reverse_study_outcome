package com.bytedance.bdinstall;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.os.EnvironmentCompat;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f0 f2878a;

    static /* synthetic */ class a {
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private static final class b implements f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TelephonyManager f2879a;

        private b() {
        }

        /* synthetic */ b(a r1) {
            this();
        }

        private static Class<?>[] h(String r6) {
            Class<?>[] r0 = null;
            Method[] r1 = TelephonyManager.class.getDeclaredMethods();     // Catch: Exception -> L12
            int r2 = r1.length;     // Catch: Exception -> L12
            int r3 = 0;
        L4:
            if (r3 >= r2) goto L14;
            Method r4 = r1[r3];     // Catch: Exception -> L12
            if (r6.equals(r4.getName()) == false) goto L11;
            r0 = r4.getParameterTypes();     // Catch: Exception -> L12
            if (r0.length < 1) goto L11;
            q.a("length:" + r0.length);     // Catch: Exception -> L12
        L11:
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            e = move-exception;
            q.d(e.getMessage(), e);
            goto L14
        }

        private static String i() {
            String r1 = (String) com.bytedance.bdinstall.d1.q.a("wifi.interface");     // Catch: Exception -> L8
            if (TextUtils.isEmpty(r1) == false) goto L7;
            return "wlan0";
        L7:
            return r1;
        L12:
            return "wlan0";
        }

        @Nullable
        private static Object j(int r3, String r4, Context r5) {
            TelephonyManager r6 = (TelephonyManager) r5.getSystemService("phone");     // Catch: Exception -> L9
            if (Build.VERSION.SDK_INT < 21) goto L14;
            Method r7 = r6.getClass().getMethod(r4, h(r4));     // Catch: Exception -> L9
            if (r3 < 0) goto L15;
            return r7.invoke(r6, new Object[]{Integer.valueOf(r3)});
        L15:
            return null;
        L14:
            return null;
        L9:
            e = move-exception;
            q.d(e.getMessage(), e);
            return null;
        }

        private TelephonyManager k(Context r2) {
            if (this.f2879a != null) goto L6;
            this.f2879a = (TelephonyManager) r2.getSystemService("phone");
        L6:
            return this.f2879a;
        }

        @Override // com.bytedance.bdinstall.f0
        @RequiresApi(api = 26)
        public String a(Context r1, int r2) {
            return "";
        }

        @Override // com.bytedance.bdinstall.f0
        @RequiresApi(api = 26)
        public String b(Context r1, int r2) {
            return k(r1).getMeid(r2);
        }

        @Override // com.bytedance.bdinstall.f0
        public String c(Context r8) {
            WifiInfo r7 = t0.a(r8);
            if (r7 == null) goto L5;
            String r9 = r7.getMacAddress();
        L7:
            if ("02:00:00:00:00:00".equals(r9) == false) goto L9;
        L31:
            Enumeration<NetworkInterface> r10 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L30
            String r0 = i();     // Catch: Exception -> L30
        L12:
            if (r10.hasMoreElements() == false) goto L45;
            NetworkInterface r1 = r10.nextElement();     // Catch: Exception -> L30
            if (r1.getName().equals(r0) == false) goto L12;
            byte[] r2 = r1.getHardwareAddress();     // Catch: Exception -> L30
            if (r2 == null) goto L12;
            if (r2.length == 0) goto L12;
            StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L30
            int r3 = r2.length;     // Catch: Exception -> L30
            int r4 = 0;
        L23:
            if (r4 >= r3) goto L26;
            r11.append(String.format("%02X:", new Object[]{Byte.valueOf(r2[r4])}));     // Catch: Exception -> L30
            r4 = r4 + 1;     // Catch: Exception -> L30
            goto L23
        L26:
            if (r11.length() <= 0) goto L28;
            r11.deleteCharAt(r11.length() - 1);     // Catch: Exception -> L30
        L28:
            return r11.toString();
        L45:
            return r9;
        L44:
            return r9;
        L9:
            if (TextUtils.isEmpty(r9) == true) goto L31;
            return r9;
        L5:
            r9 = null;
            goto L7
        }

        @Override // com.bytedance.bdinstall.f0
        public String[] d(Context r5) {
            String[] r4 = null;
            int r3 = 0;
            if (Build.VERSION.SDK_INT >= 22) goto L7;
            r4 = new String[1];     // Catch: Throwable -> L22
            r4[0] = ((TelephonyManager) r5.getSystemService("phone")).getSimSerialNumber();     // Catch: SecurityException -> L18 Throwable -> L22
            goto L21
        L7:
            List<SubscriptionInfo> r6 = SubscriptionManager.from(r5).getActiveSubscriptionInfoList();     // Catch: SecurityException -> L18 Throwable -> L22
            if (r6 == null) goto L17;
            if (r6.isEmpty() == true) goto L17;
            r4 = new String[r6.size()];     // Catch: SecurityException -> L18 Throwable -> L22
        L14:
            if (r3 >= r6.size()) goto L21;
            r4[r3] = r6.get(r3).getIccId();     // Catch: SecurityException -> L18 Throwable -> L22
            r3 = r3 + 1;     // Catch: SecurityException -> L18 Throwable -> L22
        L17:
            return new String[0];
        L18:
            q.a("getSSN , no permission, ignore");     // Catch: Throwable -> L22
        L21:
            return r4;
        }

        @Override // com.bytedance.bdinstall.f0
        public String e(Context r1, int r2) {
            String r0 = (String) j(r2, "getDeviceId", r1);
            q.a("getDeviceId  deviceId=" + r0);
            return r0;
        }

        @Override // com.bytedance.bdinstall.f0
        public String f(Context r1) {
            return null;
        }

        @Override // com.bytedance.bdinstall.f0
        public String g(Context r2) {
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L8:
            String r1 = null;
        L10:
            if (TextUtils.isEmpty(r1) == false) goto L12;
        L13:
            r1 = Build.SERIAL;
        L15:
            if (TextUtils.isEmpty(r1) == false) goto L17;
            return "";
        L17:
            if (TextUtils.equals(r1, EnvironmentCompat.MEDIA_UNKNOWN) == true) goto L25;
            return r1;
        L25:
            return "";
        L12:
            if (TextUtils.equals(r1, EnvironmentCompat.MEDIA_UNKNOWN) == false) goto L15;
        L5:
            if (r2.getApplicationInfo().targetSdkVersion < 26) goto L8;
            r1 = Build.getSerial();     // Catch: Throwable -> L22
            goto L10
        }
    }

    static {
        f2878a = new b(null);
    }

    static /* synthetic */ WifiInfo a(Context r0) {
        return c(r0);
    }

    public static f0 b() {
        return f2878a;
    }

    private static WifiInfo c(Context r3) {
        if (r3 != null) goto L12;
        return null;
    L12:
        WifiInfo r1 = ((WifiManager) r3.getApplicationContext().getSystemService("wifi")).getConnectionInfo();     // Catch: Exception -> L11
        if (((ConnectivityManager) r3.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L10;
        if (r1.getSSID() == null) goto L10;
        return r1;
    L10:
        return null;
    }

    static void d(f0 r0) {
        f2878a = r0;
    }
}
