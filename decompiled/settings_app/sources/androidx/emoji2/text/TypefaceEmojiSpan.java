package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {
    private static Paint sDebugPaint;

    public TypefaceEmojiSpan(EmojiMetadata r1) {
        super(r1);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r7, CharSequence r8, int r9, int r10, float r11, int r12, int r13, int r14, Paint r15) {
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled() == false) goto L5;
        r7.drawRect(r11, r12, r11 + getWidth(), r14, getDebugPaint());
    L5:
        getMetadata().draw(r7, r11, r13, r15);
    }

    private static Paint getDebugPaint() {
        if (sDebugPaint != null) goto L6;
        TextPaint r0 = new TextPaint();
        sDebugPaint = r0;
        r0.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
        sDebugPaint.setStyle(Paint.Style.FILL);
    L6:
        return sDebugPaint;
    }
}
