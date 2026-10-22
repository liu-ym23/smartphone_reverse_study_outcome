package ms.bd.c;

import android.hardware.Sensor;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes2.dex */
public class p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f22457b;

    static {
        f22457b = (String) m.a(16777217, 0, 0, "17f6d3", new byte[]{97, 48, 24, 82, 79, 61, 115});
    }

    public static String a() {
        String r0 = f22456a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        SensorManager r1 = (SensorManager) a.a().c().getSystemService((String) m.a(16777217, 0, 0, "b3868b", new byte[]{96, 52, 69, 81, 8, 103}));
        if (r1 == null) goto L18;
        StringBuilder r2 = new StringBuilder();
        Sensor r3 = r1.getDefaultSensor(1);
        if (r3 == null) goto L10;
        r2.append(1);
        r2.append((String) m.a(16777217, 0, 0, "3ae363", new byte[]{29}));
        r2.append(r3.getName());
        r2.append((String) m.a(16777217, 0, 0, "731155", new byte[]{25}));
        r2.append(r3.getVendor());
        r2.append((String) m.a(16777217, 0, 0, "ac7d03", new byte[]{108}));
    L10:
        Sensor r5 = r1.getDefaultSensor(5);
        if (r5 == null) goto L13;
        r2.append(5);
        r2.append((String) m.a(16777217, 0, 0, "8ff9cb", new byte[]{22}));
        r2.append(r5.getName());
        r2.append((String) m.a(16777217, 0, 0, "e80000", new byte[]{75}));
        r2.append(r5.getVendor());
        r2.append((String) m.a(16777217, 0, 0, "6cbf6b", new byte[]{59}));
    L13:
        Sensor r4 = r1.getDefaultSensor(9);
        if (r4 == null) goto L16;
        r2.append(9);
        r2.append((String) m.a(16777217, 0, 0, "bad19a", new byte[]{76}));
        r2.append(r4.getName());
        r2.append((String) m.a(16777217, 0, 0, "9937fd", new byte[]{23}));
        r2.append(r4.getVendor());
    L16:
        f22456a = r2.toString();
    L18:
        if (f22456a != null) goto L21;
        f22456a = f22457b;
    L21:
        return f22456a;
    }
}
