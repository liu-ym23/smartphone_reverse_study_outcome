package ms.bd.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class f0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f22352a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f22353b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f0 f22354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f22355d;

    static {
        String r0 = (String) m.a(16777217, 0, 0, "313a5c", new byte[]{44, 60, 84, 28, 12, 125, 51, 17, 118, 56, 45, 61});
        f22352a = (String) m.a(16777217, 0, 0, "353d1d", new byte[]{33, 56, 77, 94, 12, 106, 36, 17, 102, 53, 44, 52, 69, 94, 3, 118, 36, 21, 113, 49, 33, 121, 78, 31, 26, 122, 54, 29, 97, 53, 54, 62, 79, 30, 64, 127, 57, 2, 103, 122, 45, 57});
        f22353b = (String) m.a(16777217, 0, 0, "503006", new byte[]{39, 61, 77, 10, 13, 56, 34, 20, 102, 97, 42, 49, 69, 10, 2, 36, 34, 16, 113, 101, 39, 124, 78, 75, 27, 40, 48, 24, 97, 97, 48, 59, 79, 74, 65, 45, 63, 7, 103, 46, 43, 52, 70});
        f22355d = false;
    }

    public f0() {
    }

    public static void a(Context r13) {
        if (f22355d == true) goto L17;
        String r0 = null;
        boolean r1 = false;
        Locale r3 = Locale.US;     // Catch: Exception -> L14
        BufferedReader r4 = new BufferedReader(new FileReader(String.format(r3, (String) m.a(16777217, 0, 0, "06e909", new byte[]{110, 36, 4, 66, 12, 97, 118, 19, 123, 106, 44, 48, 26, 68, 1, 43}), new Object[]{Integer.valueOf(Process.myPid())})));     // Catch: Exception -> L14
        r0 = r4.readLine().trim();     // Catch: Exception -> L14
        r4.close();     // Catch: Exception -> L14
    L8:
        if (r0 == null) goto L11;
        r1 = r0.equals(r13.getPackageName());
    L11:
        if (r1 == false) goto L18;
        String r2 = (String) m.a(16777217, 0, 0, "7ca053", new byte[]{20, 100, 21, 77, 25, 48, 49, 80, 112, 110, 41, 117, 27, 66, 3, 39, 53, 86, 57, 111, 40, 114, 92});
        f22354c = new f0();
        IntentFilter r5 = new IntentFilter();
        r5.addAction(f22352a);
        r5.addAction(f22353b);
        LocalBroadcastManager.getInstance(r13).registerReceiver(f22354c, r5);
        f22355d = true;
        return;
    L18:
        return;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r8, Intent r9) {
        String r7 = r9.getAction();
        String r0 = (String) m.a(16777217, 0, 0, "c1bf1a", new byte[]{92, 60, 5, 27, 8, 127, 99, 17, 39, 63, 125, 61, 81, 0, 11, 117, 101, 25, 37, 51, 118, 105, 81, 19, 13, 98, 105, 31, 61, 118, 47, 115, 84, 1, 64});
        if (r7 != null) goto L5;
        return;
    L5:
        byte r1 = -1;
        int r2 = r7.hashCode();
        if (r2 == (-1125048048)) goto L14;
        if (r2 == (-516751266)) goto L11;
    L16:
        if (r1 == 0) goto L20;
        if (r1 == 1) goto L19;
        String r10 = (String) m.a(16777217, 0, 0, "dad771", new byte[]{64, 109, 28, 77, 7, 49, 105, 0, 59, 104, 97, 106, 17, 74, 11, 39, 115, 73, 58, 105, 53, 113, 18, 64, 13, 47, 113, 69, 49, 41});
        return;
    L19:
        v2.c();
        return;
    L20:
        v2.d(r8.getApplicationContext(), r9);
        return;
    L11:
        if (r7.equals(f22353b) == false) goto L16;
        r1 = 1;
        goto L16
    L14:
        if (r7.equals(f22352a) == false) goto L16;
        r1 = 0;
        goto L16
    }
}
