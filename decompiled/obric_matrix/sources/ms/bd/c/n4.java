package ms.bd.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.keva.KevaImpl;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class n4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static n4 f22435c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f22436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Integer> f22437b;

    private n4(Context r2) {
        this.f22436a = null;
        this.f22437b = new ArrayList();
        this.f22436a = r2;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    public static n4 b(Context r2) {
        if (f22435c != null) goto L15;
        monitor-enter(n4.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22435c != null) goto L9;
        f22435c = new n4(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(n4.class);     // Catch: Throwable -> L11
    L15:
        return f22435c;
    }

    public void c() {
        monitor-enter(this);     // Catch: Throwable -> L9 Exception -> L11
        int r0 = g();     // Catch: Throwable -> L6
        int r1 = f();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        int r2 = (r0 * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) + r1;     // Catch: Throwable -> L6
    L12:
        Integer r3 = Integer.valueOf(r2);
        if (r3 != null) goto L15;
        return;
    L15:
        this.f22437b.add(r3);
        int r4 = this.f22437b.size();     // Catch: Throwable -> L20
        if (r4 <= 20) goto L27;
        ArrayList r5 = new ArrayList(this.f22437b.subList(r4 - 10, r4));     // Catch: Throwable -> L20
        this.f22437b.clear();     // Catch: Throwable -> L20
        this.f22437b = r5;     // Catch: Throwable -> L20
        return;
    L27:
        return;
    L28:
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L11:
        r2 = -10001;
    L9:
        th = move-exception;
        throw th;
    }

    public int d() {
        Intent r8 = a(this.f22436a, null, new IntentFilter((String) m.a(16777217, 0, 0, "134a3a", new byte[]{33, 63, 67, 7, 3, 127, 54, 92, 108, 63, 52, 52, 73, 1, 66, 119, 49, 6, 108, 62, 46, 127, 101, 52, 56, 66, 23, 32, 92, 14, 3, 25, 102, 59, 43, 83, 22})));
        if (r8 != null) goto L5;
        return -1;
    L5:
        int r9 = r8.getIntExtra((String) m.a(16777217, 0, 0, "7559d1", new byte[]{53, 35, 71, 89, 78, 53}), -1);
        if (r9 != 2) goto L8;
    L11:
        return 1;
    L8:
        if (r9 == 5) goto L11;
        return 0;
    }

    public int e() {
        Intent r8 = a(this.f22436a, null, new IntentFilter((String) m.a(16777217, 0, 0, "890f89", new byte[]{40, 53, 71, 0, 8, 39, 63, 86, 104, 56, 61, 62, 77, 6, 73, 47, 56, 12, 104, 57, 39, 117, 97, 51, 51, 26, 30, 42, 88, 9, 10, 19, 98, 60, 32, 11, 31})));
        if (r8 != null) goto L6;
        return -1;
    L6:
        return r8.getIntExtra((String) m.a(16777217, 0, 0, "a6951c", new byte[]{120, 49, 75, 77, 26, 124}), -1);
    }

    public int f() {
        Intent r9 = a(this.f22436a, null, new IntentFilter((String) m.a(16777217, 0, 0, "ff1c57", new byte[]{118, 106, 70, 5, 5, 41, 97, 9, 105, 61, 99, 97, 76, 3, 68, 33, 102, 83, 105, 60, 121, 42, 96, 54, 62, 20, 64, 117, 89, 12, 84, 76, 99, 57, 45, 5, 65})));
        if (r9 != null) goto L6;
        return -1;
    L6:
        return Math.round(((r9.getIntExtra((String) m.a(16777217, 0, 0, "8a89cd", new byte[]{37, 102, 93, 72, 80}), -1) / r9.getIntExtra((String) m.a(16777217, 0, 0, "df1b1a", new byte[]{102, 103, 67, 26, 11}), -1)) * 100.0f) * 10.0f) / 10;
    }

    public int g() {
        Intent r8 = a(this.f22436a, null, new IntentFilter((String) m.a(16777217, 0, 0, "6e0e5f", new byte[]{38, 105, 71, 3, 5, 120, 49, 10, 104, 59, 51, 98, 77, 5, 68, 112, 54, 80, 104, 58, 41, 41, 97, 48, 62, 69, 16, 118, 88, 10, 4, 79, 98, 63, 45, 84, 17})));
        if (r8 != null) goto L6;
        return -1;
    L6:
        return r8.getIntExtra((String) m.a(16777217, 0, 0, "d284ce", new byte[]{101, 60, 94, 71, 91, 119, 99}), -1);
    }

    public synchronized int[] h() {
        monitor-enter(this);
        int r0 = this.f22437b.size();     // Catch: Throwable -> L27
        if (r0 > 0) goto L9;
        int[] r1 = new int[0];     // Catch: Throwable -> L27
        monitor-exit(this);
        return r1;
    L9:
        if (r0 != 1) goto L31;
        int[] r2 = {this.f22437b.get(0).intValue()};     // Catch: Throwable -> L27
        monitor-exit(this);
        return r2;
    L31:
        List<Integer> r3 = this.f22437b;     // Catch: Throwable -> L24
        int r4 = r0 - 10;     // Catch: Throwable -> L24
        if (r4 > 0) goto L17;
        r4 = 0;
    L17:
        List<Integer> r5 = r3.subList(r4, r0);     // Catch: Throwable -> L24
        int[] r6 = new int[r5.size()];     // Catch: Throwable -> L24
        int r7 = 0;
    L19:
        if (r7 >= r5.size()) goto L22;
        r6[r7] = r5.get(r7).intValue();     // Catch: Throwable -> L24
        r7 = r7 + 1;
        goto L19
        goto L26
    L22:
        monitor-exit(this);
        return r6;
    L26:
        return new int[0];
    L27:
        th = move-exception;
        throw th;
    }

    public String i() {
        monitor-enter(this);     // Catch: Throwable -> L9 Exception -> L11
        int r0 = f();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
    L13:
        return "" + r0;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L11:
        r0 = -1;
    L9:
        th = move-exception;
        throw th;
    }
}
