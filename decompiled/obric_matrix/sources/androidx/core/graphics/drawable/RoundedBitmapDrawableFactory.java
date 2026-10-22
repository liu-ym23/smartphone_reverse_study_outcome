package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.GravityCompat;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFa";

    private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources r1, Bitmap r2) {
            super(r1, r2);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        void gravityCompatApply(int r7, int r8, int r9, Rect r10, Rect r11) {
            GravityCompat.apply(r7, r8, r9, r10, r11, 0);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public boolean hasMipMap() {
            Bitmap r0 = this.mBitmap;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (BitmapCompat.hasMipMap(r0) == false) goto L7;
            return true;
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public void setMipMap(boolean r2) {
            Bitmap r0 = this.mBitmap;
            if (r0 == null) goto L6;
            BitmapCompat.setHasMipMap(r0, r2);
            invalidateSelf();
            return;
        }
    }

    private RoundedBitmapDrawableFactory() {
    }

    @NonNull
    public static RoundedBitmapDrawable create(@NonNull Resources r2, @Nullable Bitmap r3) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new RoundedBitmapDrawable21(r2, r3);
    L7:
        return new DefaultRoundedBitmapDrawable(r2, r3);
    }

    @NonNull
    public static RoundedBitmapDrawable create(@NonNull Resources r2, @NonNull InputStream r3) {
        RoundedBitmapDrawable r4 = create(r2, BitmapFactory.decodeStream(r3));
        if (r4.getBitmap() != null) goto L5;
        Log.w(TAG, "RoundedBitmapDrawable cannot decode " + r3);
    L5:
        return r4;
    }

    @NonNull
    public static RoundedBitmapDrawable create(@NonNull Resources r2, @NonNull String r3) {
        RoundedBitmapDrawable r4 = create(r2, BitmapFactory.decodeFile(r3));
        if (r4.getBitmap() != null) goto L5;
        Log.w(TAG, "RoundedBitmapDrawable cannot decode " + r3);
    L5:
        return r4;
    }
}
