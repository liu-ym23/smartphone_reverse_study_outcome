package d.b.p.a.h;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharSequence f14313a = null;

    static {
        f14313a = "amigo";
    }

    public static boolean a() {
        String r0 = Build.DISPLAY;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.toLowerCase(Locale.getDefault()).contains(f14313a) == false) goto L7;
        return true;
    }

    public static boolean b() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        return r0.toLowerCase(Locale.getDefault()).contains("oppo");
    }
}
