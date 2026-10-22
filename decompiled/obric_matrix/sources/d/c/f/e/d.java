package d.c.f.e;

import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(Drawable r2, Drawable r3) {
        if (r3 == null) goto L8;
        if (r2 == null) goto L9;
        if (r2 == r3) goto L10;
        r2.setBounds(r3.getBounds());
        r2.setChangingConfigurations(r3.getChangingConfigurations());
        r2.setLevel(r3.getLevel());
        r2.setVisible(r3.isVisible(), false);
        r2.setState(r3.getState());
        return;
    L10:
        return;
    L9:
        return;
    }

    public static int b(int r1) {
        int r2 = r1 >>> 24;
        if (r2 != 255) goto L6;
        return -1;
    L6:
        if (r2 != 0) goto L9;
        return -2;
    L9:
        return -3;
    }

    public static int c(int r2, int r3) {
        if (r3 != 255) goto L6;
        return r2;
    L6:
        if (r3 == 0) goto L8;
        int r4 = r3 + (r3 >> 7);
        int r5 = (((r2 >>> 24) * r4) >> 8) << 24;
        return (r2 & ViewCompat.MEASURED_SIZE_MASK) | r5;
    L8:
        return r2 & ViewCompat.MEASURED_SIZE_MASK;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(Drawable r0, Drawable.Callback r1, r r2) {
        if (r0 == 0) goto L7;
        r0.setCallback(r1);
        if ((r0 instanceof q) == false) goto L8;
        ((q) r0).b(r2);
        return;
    L8:
        return;
    }

    public static void e(Drawable r0, c r1) {
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r1.a(r0);
        return;
    L8:
        return;
    }
}
