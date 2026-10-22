package androidx.core.os;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BuildCompat {

    public @interface PrereleaseSdkCheck {
    }

    @Deprecated
    public static boolean isAtLeastN() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastNMR1() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastO() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastOMR1() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastP() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastQ() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastR() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastS() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastSv2() {
        return true;
    }

    public static boolean isAtLeastT() {
        return true;
    }

    private BuildCompat() {
    }

    protected static boolean isAtLeastPreReleaseCodename(String r2, String r3) {
        if ("REL".equals(r3) == false) goto L6;
        return false;
    L6:
        if (r3.toUpperCase(Locale.ROOT).compareTo(r2.toUpperCase(Locale.ROOT)) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isAtLeastU() {
        if (isAtLeastPreReleaseCodename("UpsideDownCake", Build.VERSION.CODENAME) == false) goto L5;
        return true;
    L5:
        return false;
    }
}
