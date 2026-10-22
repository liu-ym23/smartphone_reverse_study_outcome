package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer mContainer;

    public ActionBarBackgroundDrawable(ActionBarContainer r1) {
        this.mContainer = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r3) {
        ActionBarContainer r0 = this.mContainer;
        if (r0.mIsSplit == false) goto L7;
        Drawable r2 = r0.mSplitBackground;
        if (r2 == null) goto L16;
        r2.draw(r3);
        return;
    L16:
        return;
    L7:
        Drawable r1 = r0.mBackground;
        if (r1 == null) goto L10;
        r1.draw(r3);
    L10:
        ActionBarContainer r4 = this.mContainer;
        Drawable r5 = r4.mStackedBackground;
        if (r5 != null) goto L13;
        return;
    L13:
        if (r4.mIsStacked == false) goto L19;
        r5.draw(r3);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline r2) {
        ActionBarContainer r1 = this.mContainer;
        if (r1.mIsSplit == false) goto L7;
        Drawable r3 = r1.mSplitBackground;
        if (r3 == null) goto L11;
        r3.getOutline(r2);
        return;
    L11:
        return;
    L7:
        Drawable r4 = r1.mBackground;
        if (r4 == null) goto L13;
        r4.getOutline(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }
}
