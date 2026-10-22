package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.WrappedDrawable;

/* JADX INFO: loaded from: classes.dex */
class AppCompatProgressBarHelper {
    private static final int[] TINT_ATTRS = null;
    private Bitmap mSampleTile;
    private final ProgressBar mView;

    private static class Api23Impl {
        private Api23Impl() {
        }

        public static void transferLayerProperties(LayerDrawable r1, LayerDrawable r2, int r3) {
            r2.setLayerGravity(r3, r1.getLayerGravity(r3));
            r2.setLayerWidth(r3, r1.getLayerWidth(r3));
            r2.setLayerHeight(r3, r1.getLayerHeight(r3));
            r2.setLayerInsetLeft(r3, r1.getLayerInsetLeft(r3));
            r2.setLayerInsetRight(r3, r1.getLayerInsetRight(r3));
            r2.setLayerInsetTop(r3, r1.getLayerInsetTop(r3));
            r2.setLayerInsetBottom(r3, r1.getLayerInsetBottom(r3));
            r2.setLayerInsetStart(r3, r1.getLayerInsetStart(r3));
            r2.setLayerInsetEnd(r3, r1.getLayerInsetEnd(r3));
        }
    }

    static {
        TINT_ATTRS = new int[]{R.attr.indeterminateDrawable, R.attr.progressDrawable};
    }

    AppCompatProgressBarHelper(ProgressBar r1) {
        this.mView = r1;
    }

    void loadFromAttributes(AttributeSet r4, int r5) {
        TintTypedArray r6 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r4, TINT_ATTRS, r5, 0);
        Drawable r7 = r6.getDrawableIfKnown(0);
        if (r7 == null) goto L5;
        this.mView.setIndeterminateDrawable(tileifyIndeterminate(r7));
    L5:
        Drawable r8 = r6.getDrawableIfKnown(1);
        if (r8 == null) goto L8;
        this.mView.setProgressDrawable(tileify(r8, false));
    L8:
        r6.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    Drawable tileify(Drawable r8, boolean r9) {
        if ((r8 instanceof WrappedDrawable) == false) goto L8;
        WrappedDrawable r0 = (WrappedDrawable) r8;
        Drawable r1 = r0.getWrappedDrawable();
        if (r1 == null) goto L32;
        r0.setWrappedDrawable(tileify(r1, r9));
    L32:
        return r8;
    L8:
        if ((r8 instanceof LayerDrawable) == false) goto L24;
        LayerDrawable r10 = (LayerDrawable) r8;
        int r11 = r10.getNumberOfLayers();
        Drawable[] r2 = new Drawable[r11];
        int r3 = 0;
        int r4 = 0;
    L10:
        if (r4 >= r11) goto L19;
        int r5 = r10.getId(r4);
        Drawable r6 = r10.getDrawable(r4);
        if (r5 != 16908301) goto L14;
    L17:
        boolean r7 = true;
    L18:
        r2[r4] = tileify(r6, r7);
        r4 = r4 + 1;
        goto L10
    L14:
        if (r5 == 16908303) goto L17;
        r7 = false;
        goto L18
    L19:
        LayerDrawable r12 = new LayerDrawable(r2);
    L20:
        if (r3 >= r11) goto L22;
        r12.setId(r3, r10.getId(r3));
        Api23Impl.transferLayerProperties(r10, r12, r3);
        r3 = r3 + 1;
        goto L20
    L22:
        return r12;
    L24:
        if ((r8 instanceof BitmapDrawable) == false) goto L32;
        BitmapDrawable r13 = (BitmapDrawable) r8;
        Bitmap r14 = r13.getBitmap();
        if (this.mSampleTile != null) goto L28;
        this.mSampleTile = r14;
    L28:
        ShapeDrawable r15 = new ShapeDrawable(getDrawableShape());
        r15.getPaint().setShader(new BitmapShader(r14, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
        r15.getPaint().setColorFilter(r13.getPaint().getColorFilter());
        if (r9 == true) goto L31;
        return r15;
    L31:
        return new ClipDrawable(r15, 3, 1);
    }

    private Drawable tileifyIndeterminate(Drawable r7) {
        if ((r7 instanceof AnimationDrawable) == false) goto L11;
        AnimationDrawable r8 = (AnimationDrawable) r7;
        int r0 = r8.getNumberOfFrames();
        AnimationDrawable r1 = new AnimationDrawable();
        r1.setOneShot(r8.isOneShot());
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        Drawable r4 = tileify(r8.getFrame(r2), true);
        r4.setLevel(10000);
        r1.addFrame(r4, r8.getDuration(r2));
        r2 = r2 + 1;
        goto L6
    L8:
        r1.setLevel(10000);
        return r1;
    L11:
        return r7;
    }

    private Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    Bitmap getSampleTile() {
        return this.mSampleTile;
    }
}
