package androidx.core.view.inputmethod;

import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String[] EMPTY_STRING_ARRAY = null;
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    @Deprecated
    public EditorInfoCompat() {
    }

    @NonNull
    public static String[] getContentMimeTypes(EditorInfo r0) {
        String[] r1 = r0.contentMimeTypes;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return EMPTY_STRING_ARRAY;
    }

    public static int getProtocol(EditorInfo r0) {
        return 1;
    }

    public static void setContentMimeTypes(@NonNull EditorInfo r0, @Nullable String[] r1) {
        r0.contentMimeTypes = r1;
    }
}
