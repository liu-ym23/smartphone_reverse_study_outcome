package d.b.w.a.b.c;

import android.os.SystemClock;
import androidx.lifecycle.CoroutineLiveDataKt;
import d.b.w.a.a.c;
import d.b.w.a.d.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f15185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f15187c;

    public a(c r2) {
        this.f15186b = false;
        this.f15185a = r2;
    }

    private void c() {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = this.f15187c;
        if (r2 != 0) goto L5;
    L6:
        this.f15187c = r0;
        float r1 = this.f15185a.a();
        int r3 = this.f15185a.d();
        int r4 = this.f15185a.c();
        boolean r5 = false;
        if (r1 <= this.f15185a.getConfig().c()) goto L9;
        boolean r6 = false;
    L11:
        if (r3 >= this.f15185a.getConfig().b()) goto L13;
        r6 = false;
    L13:
        if (r4 == 1) goto L16;
        r5 = r6;
    L16:
        b.e("updateCpuSampleEnvironment:" + r5 + ", temp:" + r1 + ", level:" + r3 + ", powerSave:" + r4);
        this.f15186b = r5;
        return;
    L9:
        r6 = true;
        goto L11
    L5:
        if ((r0 - r2) >= CoroutineLiveDataKt.DEFAULT_TIMEOUT) goto L6;
    }

    public boolean a(float r10) {
        if (b() == true) goto L6;
        b.e("isAbnormalProcess false, cpuSpeed " + r10 + ", not sample environment");
        return false;
    L6:
        d.b.w.a.a.a.C0409a r0 = this.f15185a.getConfig().a();
        if (r0 != null) goto L11;
        StringBuilder r9 = new StringBuilder();
        r9.append("isAbnormalProcess true, cpuSpeed ");
        r9.append(r10);
        r9.append(", configSpeed:null");
    L9:
        b.e(r9.toString());
        return true;
    L11:
        float r4 = r0.b();
        float r1 = r0.a();
        if (r10 >= r4) goto L14;
        return false;
    L14:
        if (r1 <= 0.0d) goto L21;
        c.b r11 = this.f15185a.b();
        if (r11 == null) goto L21;
        b.e("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:" + r4 + ", bigCorePercent:" + r11.o + ", config bigCorePercent:" + r1);
        if (r11.o > r1) goto L20;
        return false;
    L20:
        return true;
    L21:
        r9 = new StringBuilder();
        r9.append("isAbnormalProcess true, cpuSpeed ");
        r9.append(r10);
        r9.append(", configSpeed:");
        r9.append(r4);
        goto L9
    }

    public boolean b() {
        c();
        return this.f15186b;
    }
}
