package d.b.w.a.b.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import d.b.w.a.a.c;
import d.b.w.a.b.b;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PowerManager f15188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BatteryManager f15189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f15190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f15193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f15194i;

    public a(Context r1, c r2) {
        super(r1, r2);
        this.f15190e = false;
        this.f15191f = -1;
        this.f15192g = 0;
        this.f15193h = 0.0f;
        this.f15194i = 0;
        this.f15188c = (PowerManager) this.f15183a.getSystemService("power");
        this.f15189d = (BatteryManager) this.f15183a.getSystemService("batterymanager");
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent b(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    private int e() {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        PowerManager r2 = this.f15188c;
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.isPowerSaveMode() ? 1 : 0;
    L8:
        return -1;
    }

    private boolean g() {
        if (Build.VERSION.SDK_INT < 23) goto L8;
        BatteryManager r2 = this.f15189d;
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isCharging();
    L8:
        return false;
    }

    private synchronized void i() {
        monitor-enter(this);
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L23
        long r2 = this.f15194i;     // Catch: Throwable -> L23
        if (r2 != 0) goto L6;
    L7:
        this.f15194i = r0;     // Catch: Throwable -> L23
        Intent r1 = b(this.f15183a, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L23
        if (r1 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        int r3 = r1.getIntExtra("status", -1);     // Catch: Throwable -> L23
        this.f15191f = r3;     // Catch: Throwable -> L23
        if (r3 != 2) goto L14;
    L19:
        boolean r4 = true;
    L20:
        this.f15190e = r4;     // Catch: Throwable -> L23
        this.f15192g = r1.getIntExtra("level", 0);     // Catch: Throwable -> L23
        this.f15193h = r1.getIntExtra("temperature", 0) / 10.0f;     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L14:
        if (r3 == 5) goto L16;
    L18:
        r4 = false;
        goto L20
    L16:
        if (g() == false) goto L18;
    L6:
        if ((r0 - r2) < CoroutineLiveDataKt.DEFAULT_TIMEOUT) goto L21;
    L23:
        th = move-exception;
        throw th;
    }

    public int c() {
        i();
        return this.f15192g;
    }

    public float d() {
        i();
        return this.f15193h;
    }

    public boolean f() {
        i();
        return this.f15190e;
    }

    public int h() {
        return e();
    }
}
