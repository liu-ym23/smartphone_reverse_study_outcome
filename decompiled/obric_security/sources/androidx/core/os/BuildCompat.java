package androidx.core.os;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
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

    @Deprecated
    public static boolean isAtLeastS() {
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L8:
        return true;
    L5:
        if (isAtLeastPreReleaseCodename(ExifInterface.LATITUDE_SOUTH, Build.VERSION.CODENAME) == true) goto L8;
        return false;
    }

    @Deprecated
    public static boolean isAtLeastSv2() {
        if (Build.VERSION.SDK_INT < 32) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 31) goto L7;
    L9:
        return false;
    L7:
        if (isAtLeastPreReleaseCodename("Sv2", Build.VERSION.CODENAME) == false) goto L9;
        goto L9
    }

    public static boolean isAtLeastT() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 32) goto L7;
    L9:
        return false;
    L7:
        if (isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME) == false) goto L9;
        goto L9
    }

    public static boolean isAtLeastU() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
    L7:
        return false;
    L5:
        if (isAtLeastPreReleaseCodename("UpsideDownCake", Build.VERSION.CODENAME) == false) goto L7;
        return true;
    }
}
