package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f22428a = null;

    static {
        f22428a = (String) m.a(16777217, 0, 0, "a11776", new byte[]{92, 0, 114, 76, 27, 36, 102});
    }

    public static boolean a(Context r27) {
        PackageManager r0 = r27.getPackageManager();
        if (r0 == null) goto L17;
        Iterator<ResolveInfo> r1 = r0.queryIntentActivities(new Intent((String) m.a(16777217, 0, 0, "d5d17c", new byte[]{116, 57, 19, 87, 7, 125, 99, 90, 60, 111, 97, 50, 25, 81, 70, 117, 100, 0, 60, 110, 123, 121, 58, 100, 33, 90}), null), 128).iterator();
    L7:
        if (r1.hasNext() == false) goto L17;
        ActivityInfo r6 = r1.next().activityInfo;
        if (r6 == null) goto L7;
        Bundle r7 = r6.applicationInfo.metaData;
        if (r7 == null) goto L7;
        if (r7.get((String) m.a(16777217, 0, 0, "d81d25", new byte[]{109, 42, 77, 3, 8, 38, 106, 16, 110, 34, 112, 40, 81, 25, 2, 44})) == null) goto L7;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L58;
        String r8 = r27.getPackageName();
        if ((com.bytedance.mobsec.metasec.ml.a.a() & 1) != 1) goto L22;
        boolean r3 = true;
    L23:
        if (r3 == true) goto L42;
        String r9 = (String) m.a(16777217, 0, 0, "622176", new byte[]{38, 51, 85, 76, 30, 40, 33, 10});
        byte[] r13 = new byte[25];     // Catch: Exception -> L38
        r13[0] = 33;     // Catch: Exception -> L38
        r13[1] = 57;     // Catch: Exception -> L38
        r13[2] = 69;     // Catch: Exception -> L38
        r13[3] = 85;     // Catch: Exception -> L38
        r13[4] = 1;     // Catch: Exception -> L38
        r13[5] = 47;     // Catch: Exception -> L38
        r13[6] = 54;     // Catch: Exception -> L38
        r13[7] = 90;     // Catch: Exception -> L38
        r13[8] = 108;     // Catch: Exception -> L38
        r13[9] = 112;     // Catch: Exception -> L38
        r13[10] = 110;     // Catch: Exception -> L36
        r13[11] = 4;     // Catch: Exception -> L36
        r13[12] = 68;     // Catch: Exception -> L36
        r13[13] = 85;     // Catch: Exception -> L36
        r13[14] = 24;     // Catch: Exception -> L36
        r13[15] = 47;     // Catch: Exception -> L36
        r13[16] = 49;     // Catch: Exception -> L36
        r13[17] = 17;     // Catch: Exception -> L36
        r13[18] = 78;     // Catch: Exception -> L36
        r13[19] = 98;     // Catch: Exception -> L36
        r13[20] = 46;     // Catch: Exception -> L36
        r13[21] = 54;     // Catch: Exception -> L36
        r13[22] = 70;     // Catch: Exception -> L36
        r13[23] = 66;     // Catch: Exception -> L36
        r13[24] = 28;     // Catch: Exception -> L36
        Method r4 = Class.forName((String) m.a(16777217, 0, 0, "152311", r13)).getDeclaredMethod((String) m.a(16777217, 0, 0, "825619", new byte[]{46, 53, 82, 113, 11, 60, 45, 26, 103, 99}), new Class[]{String.class});     // Catch: Exception -> L36
        r4.setAccessible(true);     // Catch: Exception -> L36
        IBinder r5 = null;
        IBinder r10 = (IBinder) r4.invoke(null, new Object[]{r9});     // Catch: Exception -> L34
    L41:
        if (r10 == null) goto L42;
        Parcel r11 = Parcel.obtain();
        Parcel r12 = Parcel.obtain();
        r11.writeInterfaceToken(f22428a);     // Catch: Throwable -> L49
        r11.writeInt(2);     // Catch: Throwable -> L49
        r11.writeString(r8);     // Catch: Throwable -> L49
        r11.writeStrongBinder(new Binder());     // Catch: Throwable -> L49
        if (r10.transact(1598837584, r11, r12, 0) == false) goto L51;
        r12.readException();     // Catch: Throwable -> L49
        r11.recycle();
        r12.recycle();
        boolean r14 = true;
    L52:
        if (r14 == false) goto L77;
        return true;
    L77:
        return false;
    L51:
        r11.recycle();
        r12.recycle();
    L49:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        r11.recycle();
        r12.recycle();
        throw th;
    L34:
        e = e;
    L40:
        e.printStackTrace();
        r10 = r5;
    L36:
        e = e;
        r5 = null;
    L38:
        e = e;
        r5 = null;
    L42:
        r14 = false;
        goto L52
    L22:
        r3 = false;
        goto L23
    L58:
        return true;
    L17:
        r2 = false;
        goto L18
    }
}
