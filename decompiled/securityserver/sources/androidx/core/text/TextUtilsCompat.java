package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TextUtilsCompat {
    private static final String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final Locale ROOT = null;

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

    public static int getLayoutDirectionFromLocale(@Nullable Locale r0) {
        return TextUtils.getLayoutDirectionFromLocale(r0);
    }

    @NonNull
    public static String htmlEncode(@NonNull String r0) {
        return TextUtils.htmlEncode(r0);
    }
}
