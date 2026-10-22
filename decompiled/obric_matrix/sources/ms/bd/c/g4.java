package ms.bd.c;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.PowerManager;
import android.security.keystore.KeyGenParameterSpec;
import java.lang.reflect.Method;
import java.security.KeyPairGenerator;
import java.security.spec.ECGenParameterSpec;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g4 {
    public static String a() {
        TimeZone r1 = TimeZone.getDefault();     // Catch: Throwable -> L6
        String r2 = r1.getID();     // Catch: Throwable -> L6
        int r3 = ((r1.getRawOffset() / 60) / 60) / 1000;     // Catch: Throwable -> L10
    L9:
        return r2 + ((String) m.a(16777217, 0, 0, "ddb9cf", new byte[]{57})) + r3;
    L7:
        r3 = 0;
    L6:
        r2 = null;
        goto L7
    }

    public static String b(Context r36) {
    L10:
        double r0 = 0.0d;
    L12:
        return Integer.toString((int) r0);
    L4:
        Class<?> r1 = Class.forName(new String(e0.g((String) m.a(16777217, 0, 0, "2e4437", new byte[]{117, 52, 17, 70, 90, 36, 99, 65, 51, 53, 117, 98, 17, 20, 91, 114, 103, 66, 51, 61, 117, 51, 21, 69, 90, 121, 103, 65, 50, 48, 117, 50, 16, 18, 90, 37, 103, 21, 51, 103, 113, 98, 17, 70, 91, 115, 99, 65, 48, 52, 117, 97, 16, 23, 90, 117, 102, 22, 48, 52, 116, 53, 17, 70, 90, 118, 103, 29, 51, 103, 117, 50}))));     // Catch: Throwable -> L10
        Object r2 = r1.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r36});     // Catch: Throwable -> L10
        Method r3 = r1.getDeclaredMethod(new String(e0.g((String) m.a(16777217, 0, 0, "f0c1c1", new byte[]{33, 101, 70, 16, 11, 114, 49, 64, 101, 55, 33, 103, 71, 23, 10, 119, 51, 70, 100, 52, 34, 98, 70, 67, 11, 113, 51, 68, 101, 51}))), new Class[]{String.class});     // Catch: Throwable -> L10
        r3.setAccessible(true);     // Catch: Throwable -> L10
        Object[] r4 = new Object[1];     // Catch: Throwable -> L10
        r4[0] = new String(e0.g((String) m.a(16777217, 0, 0, "2b0478", new byte[]{117, 50, 21, 17, 95, 123, 102, 23, 55, 49, 116, 50, 20, 25, 90, 42, 103, 16, 55, 53, 116, 48, 21, 17, 94, 124, 103, 26, 54, 48, 116, 57})));     // Catch: Throwable -> L10
        r0 = ((Double) r3.invoke(r2, r4)).doubleValue();     // Catch: Throwable -> L10
        goto L12
    }

    public static boolean c(String r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        if (d(r3, true) == false) goto L7;
        return true;
    L7:
        return d(r3, false);
    }

    private static boolean d(String r18, boolean r19) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L23;
        Date r2 = new Date();
        KeyGenParameterSpec.Builder r3 = new KeyGenParameterSpec.Builder(r18, 12).setAlgorithmParameterSpec(new ECGenParameterSpec((String) m.a(16777217, 0, 0, "f06a0c", new byte[]{100, 55, 70, 5, 93, 33, 51, 3, 54}))).setDigests(new String[]{(String) m.a(16777217, 0, 0, "030cd7", new byte[]{18, 25, 98, 90, 9, 117, 101}), (String) m.a(16777217, 0, 0, "75a5ac", new byte[]{21, 31, 51, 12, 13, 44, 96}), (String) m.a(16777217, 0, 0, "e7f892", new byte[]{71, 29, 52, 1, 83, 116, 52})}).setKeyValidityStart(r2);
        if (r0 < 24) goto L7;
        r3.setAttestationChallenge(r2.toString().getBytes());
    L7:
        Context r4 = a.a().c();
        if (r4 != null) goto L10;
        PackageManager r5 = null;
    L11:
        if (r19 == false) goto L25;
        if (r0 < 31) goto L25;
        if (r5 == null) goto L25;
        if (r5.hasSystemFeature((String) m.a(16777217, 0, 0, "0ac772", new byte[]{32, 109, 20, 81, 7, 44, 55, 14, 33, 104, 39, 119, 7, 66, 26, 32, 125, 68, 55, 113, 40, 96, 21, 124, 1, 33, 12, 65, 38, 115, 36, 112, 4, 66, 28, 44, 60, 78})) == false) goto L25;
        r3.setDevicePropertiesAttestationIncluded(true);
    L25:
        KeyPairGenerator r1 = KeyPairGenerator.getInstance((String) m.a(16777217, 0, 0, "93157e", new byte[]{13, 18}), (String) m.a(16777217, 0, 0, "07f443", new byte[]{0, 59, 17, 82, 4, 45, 55, 61, 50, 125, 18, 33, 26, 82, 14}));     // Catch: Exception -> L24
        r1.initialize(r3.build());     // Catch: Exception -> L24
        r1.generateKeyPair();     // Catch: Exception -> L24
        return true;
    L10:
        r5 = r4.getPackageManager();
    L23:
        return false;
    }

    public static String e() {
        String[] r1 = {(String) m.a(16777217, 0, 0, "38b27a", new byte[]{45, 42, 1, 73}), (String) m.a(16777217, 0, 0, "d98b8b", new byte[]{120, 50, 94, 31}), (String) m.a(16777217, 0, 0, "0672c2", new byte[]{55, 61, 82, 73}), (String) m.a(16777217, 0, 0, "929f6d", new byte[]{37, 53, 67, 8, 28}), (String) m.a(16777217, 0, 0, "1ab39c", new byte[]{50, 102, 21, 74, 15}), (String) m.a(16777217, 0, 0, "e3952f", new byte[]{108, 56, 75, 78, 0, 120}), (String) m.a(16777217, 0, 0, "0cb809", new byte[]{41, 116, 16, 91, 10, 39}), (String) m.a(16777217, 0, 0, "63c0ea", new byte[]{40, 63, 21, 84, 86, 99, 38}), (String) m.a(16777217, 0, 0, "aa6278", new byte[]{124, 106, 75, 67, 9, 40, 103}), (String) m.a(16777217, 0, 0, "1df0bc", new byte[]{51, 103, 24, 87, 72, 122, 53}), (String) m.a(16777217, 0, 0, "d6cac5", new byte[]{109, 36, 31, 6, 89, 38}), (String) m.a(16777217, 0, 0, "c93743", new byte[]{60, 55, 69, 86, 2, 106}), (String) m.a(16777217, 0, 0, "bfae38", new byte[]{97, 97, 19, 29, 1, 42}), (String) m.a(16777217, 0, 0, "766e91", new byte[]{39, 39, 80, 2}), (String) m.a(16777217, 0, 0, "42b956", new byte[]{39, 60, 16, 78, 1, 50, 63, 18, 33, 98}), (String) m.a(16777217, 0, 0, "b8044f", new byte[]{126, 63, 74, 84, 30}), (String) m.a(16777217, 0, 0, "5256c0", new byte[]{40, 57, 68, 81, 73}), (String) m.a(16777217, 0, 0, "4a9eb6", new byte[]{42, 115, 70, 4, 78}), (String) m.a(16777217, 0, 0, "d4ec52", new byte[]{125, 57, 24, 24, 24})};
        HashSet r10 = new HashSet();
        Method r0 = Class.forName((String) m.a(16777217, 0, 0, "b97830", new byte[]{114, 53, 64, 94, 3, 46, 101, 86, 105, 123, 61, 8, 65, 94, 26, 46, 98, 29, 75, 105, 125, 58, 67, 73, 30})).getDeclaredMethod((String) m.a(16777217, 0, 0, "cdcdb2", new byte[]{126, 111, 3, 4, 110, 32, 114, 83, 59, 55, 119, 117}), new Class[0]);     // Catch: Exception -> L18
        r0.setAccessible(true);     // Catch: Exception -> L18
        String[] r2 = (String[]) r0.invoke(null, new Object[0]);     // Catch: Exception -> L18
        if (r2 == null) goto L17;
        int r3 = r2.length;     // Catch: Exception -> L18
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L17;
        String r5 = r2[r4];     // Catch: Exception -> L18
        int r6 = 0;
    L10:
        if (r6 >= 19) goto L15;
        String r8 = r1[r6];     // Catch: Exception -> L18
        if (r5.toLowerCase().contains(r8) == false) goto L14;
        r10.add(r8);     // Catch: Exception -> L18
    L14:
        r6 = r6 + 1;
        goto L10
    L15:
        r4 = r4 + 1;
    L17:
        return r10.toString();
    }

    public static String f(Context r9) {
        Locale r10 = r9.getResources().getConfiguration().locale;     // Catch: Throwable -> L6
        String r0 = r10.getLanguage();     // Catch: Throwable -> L6
        String r11 = r10.getCountry();     // Catch: Throwable -> L6
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L6
        r1.append(r0);     // Catch: Throwable -> L6
        r1.append((String) m.a(16777217, 0, 0, "a3a521", new byte[]{79}));     // Catch: Throwable -> L6
        r1.append(r11);     // Catch: Throwable -> L6
        String r12 = r1.toString();     // Catch: Throwable -> L6
    L8:
        return r4.a(r12);
    L6:
        r12 = null;
        goto L8
    }

    private static int g(Context r8) {
        PowerManager r0 = (PowerManager) r8.getSystemService((String) m.a(16777217, 0, 0, "f771b1", new byte[]{103, 58, 83, 64, 79}));
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (Build.VERSION.SDK_INT < 20) goto L8;
        boolean r1 = r0.isInteractive();
    L9:
        if (r1 == true) goto L12;
        return 1;
    L12:
        KeyguardManager r9 = (KeyguardManager) r8.getSystemService((String) m.a(16777217, 0, 0, "4f698c", new byte[]{46, 97, 92, 74, 18, 117, 37, 67}));
        if (r9 != null) goto L16;
        return 0;
    L16:
        if (r9.inKeyguardRestrictedInputMode() == false) goto L19;
        return 2;
    L19:
        return 3;
    L8:
        r1 = r0.isScreenOn();
        goto L9
    }

    private static Map<String, String> h() {
        HashMap r0 = new HashMap();
        r0.put((String) m.a(16777217, 0, 0, "0f00a5", new byte[]{112}), Build.MODEL);
        r0.put((String) m.a(16777217, 0, 0, "2c8cef", new byte[]{113}), Build.BRAND);
        r0.put((String) m.a(16777217, 0, 0, "ca624a", new byte[]{33}), Build.BOARD);
        r0.put((String) m.a(16777217, 0, 0, "9da0d8", new byte[]{124}), Build.VERSION.RELEASE);
        r0.put((String) m.a(16777217, 0, 0, "eecebb", new byte[]{33}), Build.DISPLAY);
        r0.put((String) m.a(16777217, 0, 0, "7d16ed", new byte[]{112}), Build.HARDWARE);
        r0.put((String) m.a(16777217, 0, 0, "de74ca", new byte[]{34}), Build.FINGERPRINT);
        return r0;
    }

    public static int i(Context r0) {
        return g(r0);
    L4:
        return 0;
    }

    public static String j() {
        JSONObject r0 = new JSONObject();
        HashMap r1 = (HashMap) h();     // Catch: Throwable -> L9
        Iterator r2 = r1.keySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r2.hasNext() == false) goto L7;
        String r3 = (String) r2.next();     // Catch: Throwable -> L9
        r0.put(r3, r1.get(r3));     // Catch: Throwable -> L9
        goto L5
    L7:
        return r0.toString();
    L10:
        return (String) m.a(16777217, 0, 0, "644a97", new byte[]{60, 43});
    }
}
