package androidx.core.text;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TextUtilsCompat {
    private static final String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final Locale ROOT = null;

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static int getLayoutDirectionFromLocale(Locale r0) {
            return TextUtils.getLayoutDirectionFromLocale(r0);
        }
    }

    static {
        ROOT = new Locale("", "");
    }

    private TextUtilsCompat() {
    }

    private static int getLayoutDirectionFromFirstChar(@NonNull Locale r3) {
        byte r4 = Character.getDirectionality(r3.getDisplayName(r3).charAt(0));
        if (r4 != 1) goto L5;
    L7:
        return 1;
    L5:
        if (r4 == 2) goto L7;
        return 0;
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        if (r2 != null) goto L8;
        return 0;
    L8:
        if (r2.equals(ROOT) == true) goto L22;
        String r0 = ICUCompat.maximizeAndGetScript(r2);
        if (r0 != null) goto L14;
        return getLayoutDirectionFromFirstChar(r2);
    L14:
        if (r0.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) == false) goto L16;
        return 1;
    L16:
        if (r0.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG) == false) goto L23;
        return 1;
    L23:
        return 0;
    L22:
        return 0;
    L5:
        return Api17Impl.getLayoutDirectionFromLocale(r2);
    }

    @NonNull
    public static String htmlEncode(@NonNull String r4) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L8:
        if (r1 >= r4.length()) goto L28;
        char r2 = r4.charAt(r1);
        if (r2 != '\"') goto L12;
        String r3 = "&quot;";
    L25:
        r0.append(r3);
    L26:
        r1 = r1 + 1;
        goto L8
    L12:
        if (r2 != '<') goto L14;
        r3 = "&lt;";
        goto L25
    L14:
        if (r2 != '>') goto L16;
        r3 = "&gt;";
        goto L25
    L16:
        if (r2 != '&') goto L18;
        r3 = "&amp;";
        goto L25
    L18:
        if (r2 == '\'') goto L20;
        r0.append(r2);
        goto L26
    L20:
        r3 = "&#39;";
        goto L25
    L28:
        return r0.toString();
    L5:
        return TextUtils.htmlEncode(r4);
    }
}
