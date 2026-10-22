package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    public RoundedBitmapDrawable21(Resources r1, Bitmap r2) {
        super(r1, r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline r2) {
        updateDstRect();
        r2.setRoundRect(this.mDstRect, getCornerRadius());
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void gravityCompatApply(int r7, int r8, int r9, Rect r10, Rect r11) {
        Gravity.apply(r7, r8, r9, r10, r11, 0);
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public boolean hasMipMap() {
        Bitmap r0 = this.mBitmap;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasMipMap() == false) goto L7;
        return true;
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void setMipMap(boolean r2) {
        Bitmap r0 = this.mBitmap;
        if (r0 == null) goto L6;
        r0.setHasMipMap(r2);
        invalidateSelf();
        return;
    }
}
