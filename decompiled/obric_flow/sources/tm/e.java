package tm;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f22153a = null;

    static {
        c r5 = new c();
        r5.put(0, new LinearInterpolator());
        r5.put(1, new AccelerateInterpolator());
        r5.put(2, new DecelerateInterpolator());
        r5.put(3, new AccelerateDecelerateInterpolator());
        f22153a = r5;
    }

    public static Interpolator a(b r5) {
        int r10 = r5.e;
        c r11 = f22153a;
        switch(r10) {
            case 0: goto L13;
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L4;
        };
    L4:
        new RuntimeException(com.lynx.jsbridge.a.d(r10, "layout animation don't support interpolator:"));
        return (Interpolator) r11.get(0);
    L7:
        return new d((int) r5.f, r5.f22145j);
    L9:
        return PathInterpolatorCompat.create(r5.f, r5.g, r5.f22143h, r5.f22144i);
    L11:
        return PathInterpolatorCompat.create(r5.f, r5.g);
    L13:
        return (Interpolator) r11.get(r10);
    }
}
