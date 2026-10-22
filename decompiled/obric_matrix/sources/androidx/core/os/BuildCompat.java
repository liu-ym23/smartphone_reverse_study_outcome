package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresOptIn;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BuildCompat {

    @RequiresOptIn
    public @interface PrereleaseSdkCheck {
    }

    private BuildCompat() {
    }

    @ChecksSdkIntAtLeast(api = 24)
    @Deprecated
    public static boolean isAtLeastN() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 25)
    @Deprecated
    public static boolean isAtLeastNMR1() {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 26)
    @Deprecated
    public static boolean isAtLeastO() {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 27)
    @Deprecated
    public static boolean isAtLeastOMR1() {
        if (Build.VERSION.SDK_INT < 27) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 28)
    @Deprecated
    public static boolean isAtLeastP() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        return true;
    L5:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    protected static boolean isAtLeastPreReleaseCodename(@NonNull String r2, @NonNull String r3) {
        if ("REL".equals(r3) == false) goto L5;
        return false;
    L5:
        Locale r0 = Locale.ROOT;
        if (r3.toUpperCase(r0).compareTo(r2.toUpperCase(r0)) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 29)
    @Deprecated
    public static boolean isAtLeastQ() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 30)
    @Deprecated
    public static boolean isAtLeastR() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 31, codename = "S")
    @SuppressLint({"RestrictedApi"})
    @Deprecated
    public static boolean isAtLeastS() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L5;
    L10:
        return true;
    L5:
        if (r0 >= 30) goto L7;
    L9:
        return false;
    L7:
        if (isAtLeastPreReleaseCodename("S", Build.VERSION.CODENAME) == false) goto L9;
        goto L9
    }

    @ChecksSdkIntAtLeast(api = 32, codename = "Sv2")
    @PrereleaseSdkCheck
    @Deprecated
    public static boolean isAtLeastSv2() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 32) goto L5;
    L10:
        return true;
    L5:
        if (r0 >= 31) goto L7;
    L9:
        return false;
    L7:
        if (isAtLeastPreReleaseCodename("Sv2", Build.VERSION.CODENAME) == false) goto L9;
        goto L9
    }

    @ChecksSdkIntAtLeast(api = 33, codename = "Tiramisu")
    @PrereleaseSdkCheck
    public static boolean isAtLeastT() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 33) goto L5;
    L10:
        return true;
    L5:
        if (r0 >= 32) goto L7;
    L9:
        return false;
    L7:
        if (isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME) == false) goto L9;
        goto L9
    }

    @ChecksSdkIntAtLeast(codename = "UpsideDownCake")
    @PrereleaseSdkCheck
    public static boolean isAtLeastU() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
    L7:
        return false;
    L5:
        if (isAtLeastPreReleaseCodename("UpsideDownCake", Build.VERSION.CODENAME) == false) goto L7;
        return true;
    }
}
