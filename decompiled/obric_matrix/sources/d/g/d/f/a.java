package d.g.d.f;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegate;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    static {
    }

    @RequiresApi(30)
    public static final void a(Activity r2) {
        o.f(r2, "$this$adaptLightDarkStatusBar");
        Window r3 = r2.getWindow();
        if (r3 == null) goto L5;
        WindowInsetsController r4 = r3.getInsetsController();
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        if (c() == false) goto L10;
    L13:
        r4.setSystemBarsAppearance(0, 8);
        return;
    L10:
        if (b() == true) goto L13;
        r4.setSystemBarsAppearance(8, 8);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final boolean b() {
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L5;
        boolean r0 = true;
    L6:
        d.g.d.f.f.b.a("ActivityUtils", "isAppInDarkTheme: " + r0);
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    public static final boolean c() {
        Resources r0 = Resources.getSystem();
        o.e(r0, "Resources.getSystem()");
        int r1 = r0.getConfiguration().uiMode & 48;
        if (r1 != 32) goto L5;
        boolean r2 = true;
    L6:
        d.g.d.f.f.b.a("ActivityUtils", "isSystemInDarkTheme: " + r2 + ", currentNightMode" + r1);
        return r2;
    L5:
        r2 = false;
        goto L6
    }
}
