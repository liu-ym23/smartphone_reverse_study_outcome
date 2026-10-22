package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TypefaceEmojiSpan extends EmojiSpan {

    @Nullable
    private static Paint sDebugPaint;

    public TypefaceEmojiSpan(@NonNull EmojiMetadata r1) {
        super(r1);
    }

    @NonNull
    private static Paint getDebugPaint() {
        if (sDebugPaint != null) goto L6;
        TextPaint r0 = new TextPaint();
        sDebugPaint = r0;
        r0.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
        sDebugPaint.setStyle(Paint.Style.FILL);
    L6:
        return sDebugPaint;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas r7, @SuppressLint({"UnknownNullness"}) CharSequence r8, @IntRange(from = 0) int r9, @IntRange(from = 0) int r10, float r11, int r12, int r13, int r14, @NonNull Paint r15) {
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled() == false) goto L5;
        r7.drawRect(r11, r12, r11 + getWidth(), r14, getDebugPaint());
    L5:
        getMetadata().draw(r7, r11, r13, r15);
    }
}
