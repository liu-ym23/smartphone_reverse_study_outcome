package com.bytedance.bdinstall;

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
import androidx.core.os.EnvironmentCompat;
import com.android.settings.MultiSimAdapter;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SstInfoCompat {
    private static ISstInfoProvider sProvider;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.SstInfoCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class DefaultProvider implements ISstInfoProvider {
        private static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
        private TelephonyManager tm;

        private DefaultProvider() {
        }

        /* synthetic */ DefaultProvider(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getDefaultImeiOrMeid(Context r1) {
            TelephonyManager r0 = getTelephonyManager(r1);     // Catch: Exception -> L6
            if (r0 == null) goto L11;
            return r0.getDeviceId();
        L11:
            return null;
        L6:
            DrLog.v("no get_phone_state permission,getDeviceId return null");
            return null;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getMac(Context r8) {
            WifiInfo r7 = SstInfoCompat.access$100(r8);
            if (r7 == null) goto L5;
            String r9 = r7.getMacAddress();
        L7:
            if (DEFAULT_MAC_ADDRESS.equals(r9) == false) goto L9;
        L33:
            Enumeration<NetworkInterface> r10 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L30
            String r0 = getNetworkInterfaceName();     // Catch: Exception -> L30
        L12:
            if (r10.hasMoreElements() == false) goto L47;
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
        L47:
            return r9;
        L30:
            e = move-exception;
            e.printStackTrace();
            return r9;
        L9:
            if (TextUtils.isEmpty(r9) == true) goto L33;
            return r9;
        L5:
            r9 = null;
            goto L7
        }

        private TelephonyManager getTelephonyManager(Context r2) {
            if (this.tm != null) goto L6;
            this.tm = (TelephonyManager) r2.getSystemService(MultiSimAdapter.PHONE_KEY);
        L6:
            return this.tm;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getMeid(Context r1, int r2) {
            return getTelephonyManager(r1).getMeid(r2);
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getImei(Context r1, int r2) {
            return getTelephonyManager(r1).getImei(r2);
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String reflectGetDeviceIdWithSlotIndex(Context r1, int r2) {
            String r0 = (String) getPhoneInfo(r2, "getDeviceId", r1);
            DrLog.d("getDeviceId  deviceId=" + r0);
            return r0;
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getSerial(Context r2) {
            if (r2.getApplicationInfo().targetSdkVersion >= 26) goto L21;
        L6:
            String r1 = null;
        L8:
            if (TextUtils.isEmpty(r1) == false) goto L10;
        L11:
            r1 = Build.SERIAL;
        L13:
            if (TextUtils.isEmpty(r1) == false) goto L15;
            return "";
        L15:
            if (TextUtils.equals(r1, EnvironmentCompat.MEDIA_UNKNOWN) == true) goto L23;
            return r1;
        L23:
            return "";
        L10:
            if (TextUtils.equals(r1, EnvironmentCompat.MEDIA_UNKNOWN) == false) goto L13;
        L21:
            r1 = Build.getSerial();     // Catch: Throwable -> L20
            goto L8
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String[] getSimSerialNumbers(Context r3) {
            String[] r2 = null;
        L17:
            th = move-exception;
            th.printStackTrace();
        L19:
            return r2;
        L20:
            List<SubscriptionInfo> r4 = SubscriptionManager.from(r3).getActiveSubscriptionInfoList();     // Catch: SecurityException -> L15 Throwable -> L17
            int r0 = 0;
            if (r4 == null) goto L14;
            if (r4.isEmpty() == true) goto L14;
            r2 = new String[r4.size()];     // Catch: SecurityException -> L15 Throwable -> L17
        L11:
            if (r0 >= r4.size()) goto L19;
            r2[r0] = r4.get(r0).getIccId();     // Catch: SecurityException -> L15 Throwable -> L17
            r0 = r0 + 1;     // Catch: SecurityException -> L15 Throwable -> L17
        L14:
            return new String[0];
        L15:
            DrLog.d("getSSN , no permission, ignore");     // Catch: Throwable -> L17
            goto L19
        }

        private static Object getPhoneInfo(int r3, String r4, Context r5) {
            TelephonyManager r6 = (TelephonyManager) r5.getSystemService(MultiSimAdapter.PHONE_KEY);     // Catch: Exception -> L7
            Method r7 = r6.getClass().getMethod(r4, getMethodParamTypes(r4));     // Catch: Exception -> L7
            if (r3 < 0) goto L12;
            return r7.invoke(r6, new Object[]{Integer.valueOf(r3)});
        L12:
            return null;
        L7:
            e = move-exception;
            e.printStackTrace();
            DrLog.e(e.getMessage(), e);
            return null;
        }

        private static Class<?>[] getMethodParamTypes(String r6) {
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
            DrLog.d("length:" + r0.length);     // Catch: Exception -> L12
        L11:
            r3 = r3 + 1;
        L14:
            return r0;
        L12:
            e = move-exception;
            e.printStackTrace();
            DrLog.e(e.getMessage(), e);
            goto L14
        }

        private static String getNetworkInterfaceName() {
            String r1 = (String) SystemPropertiesWithCache.get("wifi.interface");     // Catch: Exception -> L8
            if (TextUtils.isEmpty(r1) == false) goto L7;
            return "wlan0";
        L7:
            return r1;
        L8:
            e = move-exception;
            e.printStackTrace();
            return "wlan0";
        }
    }

    public SstInfoCompat() {
    }

    static /* synthetic */ WifiInfo access$100(Context r0) {
        return getWifiInfo(r0);
    }

    static {
        sProvider = new DefaultProvider(null);
    }

    public static ISstInfoProvider getProvider() {
        return sProvider;
    }

    static void setSstInfoProvider(ISstInfoProvider r0) {
        sProvider = r0;
    }

    private static WifiInfo getWifiInfo(Context r3) {
        if (r3 != null) goto L13;
        return null;
    L13:
        WifiInfo r1 = ((WifiManager) r3.getApplicationContext().getSystemService("wifi")).getConnectionInfo();     // Catch: Exception -> L10
        if (((ConnectivityManager) r3.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L12;
        if (r1.getSSID() == null) goto L12;
        return r1;
    L12:
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }
}
