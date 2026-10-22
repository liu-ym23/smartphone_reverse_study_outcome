package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class DrawableKt {
    @NotNull
    public static final Bitmap toBitmap(@NotNull Drawable r6, @Px int r7, @Px int r8, @Nullable Bitmap.Config r9) {
        Intrinsics.g(r6, "$this$toBitmap");
        if ((r6 instanceof BitmapDrawable) == false) goto L15;
        if (r9 == null) goto L7;
        Bitmap r0 = ((BitmapDrawable) r6).getBitmap();
        Intrinsics.b(r0, "bitmap");
        if (r0.getConfig() != r9) goto L15;
    L7:
        BitmapDrawable r10 = (BitmapDrawable) r6;
        if (r7 == r10.getIntrinsicWidth()) goto L10;
    L13:
        Bitmap r11 = Bitmap.createScaledBitmap(r10.getBitmap(), r7, r8, true);
        Intrinsics.b(r11, "Bitmap.createScaledBitma…map, width, height, true)");
        return r11;
    L10:
        if (r8 != r10.getIntrinsicHeight()) goto L13;
        Bitmap r12 = r10.getBitmap();
        Intrinsics.b(r12, "bitmap");
        return r12;
    L15:
        Rect r1 = r6.getBounds();
        int r2 = r1.left;
        int r3 = r1.top;
        int r4 = r1.right;
        int r5 = r1.bottom;
        if (r9 != null) goto L19;
        r9 = Bitmap.Config.ARGB_8888;
    L19:
        Bitmap r13 = Bitmap.createBitmap(r7, r8, r9);
        r6.setBounds(0, 0, r7, r8);
        r6.draw(new Canvas(r13));
        r6.setBounds(r2, r3, r4, r5);
        Intrinsics.b(r13, "bitmap");
        return r13;
    }

    @NotNull
    public static /* synthetic */ Bitmap toBitmap$default(Drawable r0, int r1, int r2, Bitmap.Config r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getIntrinsicWidth();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getIntrinsicHeight();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = null;
    L12:
        return toBitmap(r0, r1, r2, r3);
    }

    public static final void updateBounds(@NotNull Drawable r1, @Px int r2, @Px int r3, @Px int r4, @Px int r5) {
        Intrinsics.g(r1, "$this$updateBounds");
        r1.setBounds(r2, r3, r4, r5);
    }

    public static /* synthetic */ void updateBounds$default(Drawable r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.getBounds().left;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.getBounds().top;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.getBounds().right;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = r0.getBounds().bottom;
    L14:
        updateBounds(r0, r1, r2, r3, r4);
    }
}
