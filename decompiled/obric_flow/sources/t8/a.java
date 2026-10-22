package t8;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f22108b;

    static {
        f22107a = new b();
    }

    public static String a(Context r10) {
        String r5 = f22108b;
        if (com.bytedance.common.utility.b.b(r5) == true) goto L36;
        return r5;
    L36:
        int r11 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L7:
        if (r12.hasNext() == false) goto L18;
        ActivityManager.RunningAppProcessInfo r13 = r12.next();     // Catch: Exception -> L13
        if (r13.pid != r11) goto L7;
        if (Logger.debug() == false) goto L15;
        Logger.d("Process", "processName = " + r13.processName);     // Catch: Exception -> L13
    L15:
        String r14 = r13.processName;     // Catch: Exception -> L13
        f22108b = r14;     // Catch: Exception -> L13
        return r14;
    L18:
        String r15 = null;
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L29
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L35
    L21:
        int r18 = r16.read();     // Catch: Throwable -> L35
        if (r18 <= 0) goto L25;
        r17.append((char) r18);     // Catch: Throwable -> L35
        goto L21
    L25:
        if (Logger.debug() == false) goto L27;
        Logger.d("Process", "get processName = " + r17.toString());     // Catch: Throwable -> L35
    L27:
        r15 = r17.toString();     // Catch: Throwable -> L35
        r16.close();     // Catch: Exception -> L34
    L38:
    L30:
        if (r16 == null) goto L32;
        r16.close();     // Catch: Exception -> L34
    L29:
        r16 = null;
    L32:
        f22108b = r15;
        return r15;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static String b(byte[] r5) {
        StringBuilder r10 = new StringBuilder("");
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L10;
        String r12 = Integer.toHexString(r5[r11] & UByte.MAX_VALUE);
        if (r12.length() != 1) goto L8;
        r12 = "0".concat(r12);
    L8:
        r10.append(r12);
        r10.append(" ");
        r11 = r11 + 1;
        goto L4
    L10:
        return r10.toString().toUpperCase().trim();
    }
}
