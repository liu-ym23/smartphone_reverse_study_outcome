package obric.tablet.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class BytedanceJustifyTextView extends TextView {
    public static final int FIRST_LINE_POS = 3;
    public static final String TWO_BLANK = "  ";
    private float mCurBaseLineLocation;
    private int mViewWidth;

    public BytedanceJustifyTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r9) {
        Layout r0 = getLayout();
        if (r0 != null) goto L5;
        return;
    L5:
        TextPaint r1 = getPaint();
        r1.setColor(getCurrentTextColor());
        r1.drawableState = getDrawableState();
        this.mViewWidth = getMeasuredWidth();
        String r2 = getText().toString();
        this.mCurBaseLineLocation = getTextSize();
        int r3 = 0;
    L7:
        if (r3 >= r0.getLineCount()) goto L15;
        int r4 = r0.getLineStart(r3);
        int r5 = r0.getLineEnd(r3);
        String r6 = r2.substring(r4, r5);
        float r7 = StaticLayout.getDesiredWidth(r2, r4, r5, getPaint());
        if (needScale(r6) == true) goto L11;
    L13:
        r9.drawText(r6, 0.0f, this.mCurBaseLineLocation, r1);
    L14:
        this.mCurBaseLineLocation += getLineHeight();
        r3 = r3 + 1;
        goto L7
    L11:
        if (r3 >= (r0.getLineCount() - 1)) goto L13;
        drawTextAdjustCharacterSpace(r9, r6, r7);
        goto L14
    }

    private void drawTextAdjustCharacterSpace(Canvas r7, String r8, float r9) {
        float r1 = 0.0f;
        if (isFirstLineOfParagraph(r8) == false) goto L5;
        r7.drawText(TWO_BLANK, 0.0f, this.mCurBaseLineLocation, getPaint());
        r1 = 0.0f + StaticLayout.getDesiredWidth(TWO_BLANK, getPaint());
        r8 = r8.substring(3);
    L5:
        float r0 = (this.mViewWidth - r9) / (r8.length() - 1);
        int r10 = 0;
    L7:
        if (r10 >= r8.length()) goto L9;
        String r2 = String.valueOf(r8.charAt(r10));
        float r3 = StaticLayout.getDesiredWidth(r2, getPaint());
        r7.drawText(r2, r1, this.mCurBaseLineLocation, getPaint());
        r1 = r1 + (r3 + r0);
        r10 = r10 + 1;
        goto L7
    }

    private boolean isFirstLineOfParagraph(String r3) {
        if (r3.length() > 3) goto L5;
        return false;
    L5:
        if (r3.charAt(0) == ' ') goto L7;
        return false;
    L7:
        if (r3.charAt(1) == ' ') goto L9;
        return false;
    L9:
        return true;
    }

    private boolean needScale(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.length() != 0) goto L8;
        return false;
    L8:
        if (r3.charAt(r3.length() - 1) != '\n') goto L10;
        return false;
    L10:
        return true;
    }
}
