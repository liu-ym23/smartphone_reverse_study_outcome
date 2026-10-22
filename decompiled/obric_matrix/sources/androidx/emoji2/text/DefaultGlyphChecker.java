package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PaintCompat;

/* JADX INFO: loaded from: classes.dex */
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY})
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private static final ThreadLocal<StringBuilder> sStringBuilder = null;
    private final TextPaint mTextPaint;

    static {
        sStringBuilder = new ThreadLocal();
    }

    DefaultGlyphChecker() {
        TextPaint r0 = new TextPaint();
        this.mTextPaint = r0;
        r0.setTextSize(10.0f);
    }

    private static StringBuilder getStringBuilder() {
        ThreadLocal<StringBuilder> r0 = sStringBuilder;
        if (r0.get() != null) goto L6;
        r0.set(new StringBuilder());
    L6:
        return r0.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(@NonNull CharSequence r4, int r5, int r6, int r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 23) goto L6;
        if (r7 <= r0) goto L6;
        return false;
    L6:
        StringBuilder r8 = getStringBuilder();
        r8.setLength(0);
    L7:
        if (r5 >= r6) goto L10;
        r8.append(r4.charAt(r5));
        r5 = r5 + 1;
        goto L7
    L10:
        return PaintCompat.hasGlyph(this.mTextPaint, r8.toString());
    }
}
