package d.b.w.a.b.f;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import d.b.w.a.a.c;
import d.b.w.a.b.b;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PowerManager f15231c;

    public a(Context r1, c r2) {
        super(r1, r2);
        this.f15231c = (PowerManager) this.f15183a.getSystemService("power");
    }

    public int b() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        PowerManager r2 = this.f15231c;
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.getCurrentThermalStatus();
    L8:
        return -1;
    }
}
