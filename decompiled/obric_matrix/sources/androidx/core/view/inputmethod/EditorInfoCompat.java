package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = null;
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;

    @VisibleForTesting
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;

    @VisibleForTesting
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        static CharSequence getInitialSelectedText(@NonNull EditorInfo r0, int r1) {
            return r0.getInitialSelectedText(r1);
        }

        static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo r0, int r1, int r2) {
            return r0.getInitialTextAfterCursor(r1, r2);
        }

        static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo r0, int r1, int r2) {
            return r0.getInitialTextBeforeCursor(r1, r2);
        }

        static void setInitialSurroundingSubText(@NonNull EditorInfo r0, CharSequence r1, int r2) {
            r0.setInitialSurroundingSubText(r1, r2);
        }
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    @Deprecated
    public EditorInfoCompat() {
    }

    @NonNull
    public static String[] getContentMimeTypes(@NonNull EditorInfo r2) {
        if (Build.VERSION.SDK_INT < 25) goto L9;
        String[] r3 = r2.contentMimeTypes;
        if (r3 == null) goto L8;
        return r3;
    L8:
        return EMPTY_STRING_ARRAY;
    L9:
        Bundle r0 = r2.extras;
        if (r0 == null) goto L12;
        String[] r1 = r0.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (r1 != null) goto L16;
        r1 = r2.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
    L16:
        if (r1 == null) goto L19;
        return r1;
    L19:
        return EMPTY_STRING_ARRAY;
    L12:
        return EMPTY_STRING_ARRAY;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo r6, int r7) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getInitialSelectedText(r6, r7);
    L7:
        if (r6.extras != null) goto L9;
        return null;
    L9:
        int r0 = Math.min(r6.initialSelStart, r6.initialSelEnd);
        int r2 = Math.max(r6.initialSelStart, r6.initialSelEnd);
        int r3 = r6.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int r4 = r6.extras.getInt(CONTENT_SELECTION_END_KEY);
        int r5 = r2 - r0;
        if (r6.initialSelStart >= 0) goto L12;
    L24:
        return null;
    L12:
        if (r6.initialSelEnd < 0) goto L24;
        if ((r4 - r3) != r5) goto L24;
        CharSequence r8 = r6.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r8 != null) goto L20;
        return null;
    L20:
        if ((r7 & 1) == 0) goto L23;
        return r8.subSequence(r3, r4);
    L23:
        return TextUtils.substring(r8, r3, r4);
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo r3, int r4, int r5) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Bundle r0 = r3.extras;
        if (r0 != null) goto L9;
        return null;
    L9:
        CharSequence r1 = r0.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r1 != null) goto L12;
        return null;
    L12:
        int r6 = r3.extras.getInt(CONTENT_SELECTION_END_KEY);
        int r7 = r5 & 1;
        int r8 = Math.min(r4, r1.length() - r6) + r6;
        if (r7 == 0) goto L16;
        return r1.subSequence(r6, r8);
    L16:
        return TextUtils.substring(r1, r6, r8);
    L5:
        return Api30Impl.getInitialTextAfterCursor(r3, r4, r5);
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo r3, int r4, int r5) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Bundle r0 = r3.extras;
        if (r0 != null) goto L9;
        return null;
    L9:
        CharSequence r1 = r0.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (r1 != null) goto L12;
        return null;
    L12:
        int r6 = r3.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int r7 = r5 & 1;
        int r8 = r6 - Math.min(r4, r6);
        if (r7 == 0) goto L16;
        return r1.subSequence(r8, r6);
    L16:
        return TextUtils.substring(r1, r8, r6);
    L5:
        return Api30Impl.getInitialTextBeforeCursor(r3, r4, r5);
    }

    static int getProtocol(EditorInfo r3) {
        if (Build.VERSION.SDK_INT < 25) goto L6;
        return 1;
    L6:
        Bundle r0 = r3.extras;
        if (r0 != null) goto L9;
        return 0;
    L9:
        boolean r1 = r0.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean r4 = r3.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (r1 == false) goto L14;
        if (r4 == false) goto L14;
        return 4;
    L14:
        if (r1 == false) goto L17;
        return 3;
    L17:
        if (r4 == false) goto L20;
        return 2;
    L20:
        return 0;
    }

    private static boolean isCutOnSurrogate(CharSequence r1, int r2, int r3) {
        if (r3 == 0) goto L10;
        if (r3 == 1) goto L8;
        return false;
    L8:
        return Character.isHighSurrogate(r1.charAt(r2));
    L10:
        return Character.isLowSurrogate(r1.charAt(r2));
    }

    private static boolean isPasswordInputType(int r1) {
        int r2 = r1 & 4095;
        if (r2 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 225) goto L10;
        if (r2 == 18) goto L10;
        return false;
    }

    public static void setContentMimeTypes(@NonNull EditorInfo r2, @Nullable String[] r3) {
        if (Build.VERSION.SDK_INT < 25) goto L6;
        r2.contentMimeTypes = r3;
        return;
    L6:
        if (r2.extras != null) goto L8;
        r2.extras = new Bundle();
    L8:
        r2.extras.putStringArray(CONTENT_MIME_TYPES_KEY, r3);
        r2.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, r3);
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo r5, @NonNull CharSequence r6, int r7) {
        Preconditions.checkNotNull(r6);
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setInitialSurroundingSubText(r5, r6, r7);
        return;
    L6:
        int r0 = r5.initialSelStart;
        int r1 = r5.initialSelEnd;
        if (r0 <= r1) goto L9;
        int r2 = r1 - r7;
    L10:
        if (r0 <= r1) goto L12;
        int r3 = r0 - r7;
    L13:
        int r4 = r6.length();
        if (r7 < 0) goto L28;
        if (r2 < 0) goto L28;
        if (r3 > r4) goto L28;
        if (isPasswordInputType(r5.inputType) == false) goto L23;
        setSurroundingText(r5, null, 0, 0);
        return;
    L23:
        if (r4 > 2048) goto L26;
        setSurroundingText(r5, r6, r2, r3);
        return;
    L26:
        trimLongSurroundingText(r5, r6, r2, r3);
        return;
    L28:
        setSurroundingText(r5, null, 0, 0);
        return;
    L12:
        r3 = r1 - r7;
        goto L13
    L9:
        r2 = r0 - r7;
        goto L10
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo r3, @NonNull CharSequence r4) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Api30Impl.setInitialSurroundingSubText(r3, r4, 0);
        return;
    L5:
        setInitialSurroundingSubText(r3, r4, 0);
    }

    private static void setSurroundingText(EditorInfo r2, CharSequence r3, int r4, int r5) {
        if (r2.extras != null) goto L5;
        r2.extras = new Bundle();
    L5:
        if (r3 == null) goto L7;
        SpannableStringBuilder r0 = new SpannableStringBuilder(r3);
    L8:
        r2.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, r0);
        r2.extras.putInt(CONTENT_SELECTION_HEAD_KEY, r4);
        r2.extras.putInt(CONTENT_SELECTION_END_KEY, r5);
        return;
    L7:
        r0 = null;
        goto L8
    }

    private static void trimLongSurroundingText(EditorInfo r9, CharSequence r10, int r11, int r12) {
        int r0 = r12 - r11;
        if (r0 <= 1024) goto L5;
        int r2 = 0;
    L6:
        int r4 = 2048 - r2;
        int r3 = Math.min(r10.length() - r12, r4 - Math.min(r11, (int) (((double) r4) * 0.8d)));
        int r5 = Math.min(r11, r4 - r3);
        int r13 = r11 - r5;
        if (isCutOnSurrogate(r10, r13, 0) == false) goto L10;
        r13 = r13 + 1;
        r5 = r5 - 1;
    L10:
        if (isCutOnSurrogate(r10, (r12 + r3) - 1, 1) == false) goto L12;
        r3 = r3 - 1;
    L12:
        int r6 = (r5 + r2) + r3;
        if (r2 == r0) goto L15;
        CharSequence r14 = TextUtils.concat(new CharSequence[]{r10.subSequence(r13, r13 + r5), r10.subSequence(r12, r3 + r12)});
    L16:
        int r7 = r5 + 0;
        setSurroundingText(r9, r14, r7, r2 + r7);
        return;
    L15:
        r14 = r10.subSequence(r13, r6 + r13);
        goto L16
    L5:
        r2 = r0;
        goto L6
    }
}
