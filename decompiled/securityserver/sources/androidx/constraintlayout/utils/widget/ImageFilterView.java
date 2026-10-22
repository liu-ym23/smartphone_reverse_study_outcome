package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {
    private Drawable mAltDrawable;
    private float mCrossfade;
    private Drawable mDrawable;
    private ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    float mPanX;
    float mPanY;
    private Path mPath;
    RectF mRect;
    float mRotate;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom;

    public static class ImageMatrix {
        float[] m;
        float mBrightness;
        ColorMatrix mColorMatrix;
        float mContrast;
        float mSaturation;
        ColorMatrix mTmpColorMatrix;
        float mWarmth;

        public ImageMatrix() {
            this.m = new float[20];
            this.mColorMatrix = new ColorMatrix();
            this.mTmpColorMatrix = new ColorMatrix();
            this.mBrightness = 1.0f;
            this.mSaturation = 1.0f;
            this.mContrast = 1.0f;
            this.mWarmth = 1.0f;
        }

        private void brightness(float r3) {
            float[] r2 = this.m;
            r2[0] = r3;
            r2[1] = 0.0f;
            r2[2] = 0.0f;
            r2[3] = 0.0f;
            r2[4] = 0.0f;
            r2[5] = 0.0f;
            r2[6] = r3;
            r2[7] = 0.0f;
            r2[8] = 0.0f;
            r2[9] = 0.0f;
            r2[10] = 0.0f;
            r2[11] = 0.0f;
            r2[12] = r3;
            r2[13] = 0.0f;
            r2[14] = 0.0f;
            r2[15] = 0.0f;
            r2[16] = 0.0f;
            r2[17] = 0.0f;
            r2[18] = 1.0f;
            r2[19] = 0.0f;
        }

        private void saturation(float r8) {
            float r1 = 1.0f - r8;
            float r2 = 0.2999f * r1;
            float r3 = 0.587f * r1;
            float r4 = r1 * 0.114f;
            float[] r7 = this.m;
            r7[0] = r2 + r8;
            r7[1] = r3;
            r7[2] = r4;
            r7[3] = 0.0f;
            r7[4] = 0.0f;
            r7[5] = r2;
            r7[6] = r3 + r8;
            r7[7] = r4;
            r7[8] = 0.0f;
            r7[9] = 0.0f;
            r7[10] = r2;
            r7[11] = r3;
            r7[12] = r4 + r8;
            r7[13] = 0.0f;
            r7[14] = 0.0f;
            r7[15] = 0.0f;
            r7[16] = 0.0f;
            r7[17] = 0.0f;
            r7[18] = 1.0f;
            r7[19] = 0.0f;
        }

        private void warmth(float r12) {
            if (r12 > 0.0f) goto L5;
            r12 = 0.01f;
        L5:
            float r1 = (5000.0f / r12) / 100.0f;
            if (r1 <= 66.0f) goto L8;
            double r6 = r1 - 60.0f;
            float r2 = ((float) Math.pow(r6, -0.13320475816726685d)) * 329.69873f;
            float r7 = ((float) Math.pow(r6, 0.07551484555006027d)) * 288.12216f;
        L10:
            if (r1 < 66.0f) goto L12;
            float r13 = 255.0f;
        L16:
            float r3 = Math.min(255.0f, Math.max(r2, 0.0f));
            float r4 = Math.min(255.0f, Math.max(r7, 0.0f));
            float r14 = Math.min(255.0f, Math.max(r13, 0.0f));
            float r8 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float r5 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float r9 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float r10 = Math.min(255.0f, Math.max(r8, 0.0f));
            float r15 = r14 / Math.min(255.0f, Math.max(r5, 0.0f));
            float[] r11 = this.m;
            r11[0] = r3 / r9;
            r11[1] = 0.0f;
            r11[2] = 0.0f;
            r11[3] = 0.0f;
            r11[4] = 0.0f;
            r11[5] = 0.0f;
            r11[6] = r4 / r10;
            r11[7] = 0.0f;
            r11[8] = 0.0f;
            r11[9] = 0.0f;
            r11[10] = 0.0f;
            r11[11] = 0.0f;
            r11[12] = r15;
            r11[13] = 0.0f;
            r11[14] = 0.0f;
            r11[15] = 0.0f;
            r11[16] = 0.0f;
            r11[17] = 0.0f;
            r11[18] = 1.0f;
            r11[19] = 0.0f;
            return;
        L12:
            if (r1 <= 19.0f) goto L14;
            r13 = (((float) Math.log(r1 - 10.0f)) * 138.51773f) - 305.0448f;
            goto L16
        L14:
            r13 = 0.0f;
            goto L16
        L8:
            r7 = (((float) Math.log(r1)) * 99.4708f) - 161.11957f;
            r2 = 255.0f;
            goto L10
        }

        public void updateMatrix(ImageView r6) {
            this.mColorMatrix.reset();
            float r0 = this.mSaturation;
            boolean r3 = true;
            if (r0 == 1.0f) goto L5;
            saturation(r0);
            this.mColorMatrix.set(this.m);
            boolean r1 = true;
        L6:
            float r2 = this.mContrast;
            if (r2 == 1.0f) goto L9;
            this.mTmpColorMatrix.setScale(r2, r2, r2, 1.0f);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            r1 = true;
        L9:
            float r4 = this.mWarmth;
            if (r4 == 1.0f) goto L12;
            warmth(r4);
            this.mTmpColorMatrix.set(this.m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            r1 = true;
        L12:
            float r5 = this.mBrightness;
            if (r5 == 1.0f) goto L15;
            brightness(r5);
            this.mTmpColorMatrix.set(this.m);
            this.mColorMatrix.postConcat(this.mTmpColorMatrix);
        L16:
            if (r3 == false) goto L18;
            r6.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
            return;
        L18:
            r6.clearColorFilter();
            return;
        L15:
            r3 = r1;
            goto L16
        L5:
            r1 = false;
            goto L6
        }
    }

    public ImageFilterView(Context r4) {
        super(r4);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r4, null);
    }

    public static /* synthetic */ float access$000(ImageFilterView r0) {
        return r0.mRoundPercent;
    }

    public static /* synthetic */ float access$100(ImageFilterView r0) {
        return r0.mRound;
    }

    private void init(Context r6, AttributeSet r7) {
        if (r7 == null) goto L67;
        TypedArray r8 = getContext().obtainStyledAttributes(r7, R.styleable.ImageFilterView);
        int r9 = r8.getIndexCount();
        this.mAltDrawable = r8.getDrawable(R.styleable.ImageFilterView_altSrc);
        int r1 = 0;
    L4:
        if (r1 >= r9) goto L42;
        int r2 = r8.getIndex(r1);
        if (r2 != R.styleable.ImageFilterView_crossfade) goto L9;
        this.mCrossfade = r8.getFloat(r2, 0.0f);
    L41:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 != R.styleable.ImageFilterView_warmth) goto L12;
        setWarmth(r8.getFloat(r2, 0.0f));
        goto L41
    L12:
        if (r2 != R.styleable.ImageFilterView_saturation) goto L15;
        setSaturation(r8.getFloat(r2, 0.0f));
        goto L41
    L15:
        if (r2 != R.styleable.ImageFilterView_contrast) goto L18;
        setContrast(r8.getFloat(r2, 0.0f));
        goto L41
    L18:
        if (r2 != R.styleable.ImageFilterView_brightness) goto L21;
        setBrightness(r8.getFloat(r2, 0.0f));
        goto L41
    L21:
        if (r2 != R.styleable.ImageFilterView_round) goto L24;
        setRound(r8.getDimension(r2, 0.0f));
        goto L41
    L24:
        if (r2 != R.styleable.ImageFilterView_roundPercent) goto L27;
        setRoundPercent(r8.getFloat(r2, 0.0f));
        goto L41
    L27:
        if (r2 != R.styleable.ImageFilterView_overlay) goto L30;
        setOverlay(r8.getBoolean(r2, this.mOverlay));
        goto L41
    L30:
        if (r2 != R.styleable.ImageFilterView_imagePanX) goto L33;
        setImagePanX(r8.getFloat(r2, this.mPanX));
        goto L41
    L33:
        if (r2 != R.styleable.ImageFilterView_imagePanY) goto L36;
        setImagePanY(r8.getFloat(r2, this.mPanY));
        goto L41
    L36:
        if (r2 != R.styleable.ImageFilterView_imageRotate) goto L39;
        setImageRotate(r8.getFloat(r2, this.mRotate));
        goto L41
    L39:
        if (r2 != R.styleable.ImageFilterView_imageZoom) goto L41;
        setImageZoom(r8.getFloat(r2, this.mZoom));
        goto L41
    L42:
        r8.recycle();
        Drawable r10 = getDrawable();
        this.mDrawable = r10;
        if (this.mAltDrawable == null) goto L49;
        if (r10 == null) goto L49;
        Drawable[] r11 = this.mLayers;
        Drawable r12 = getDrawable().mutate();
        this.mDrawable = r12;
        r11[0] = r12;
        this.mLayers[1] = this.mAltDrawable.mutate();
        LayerDrawable r13 = new LayerDrawable(this.mLayers);
        this.mLayer = r13;
        r13.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        if (this.mOverlay == true) goto L48;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L48:
        super.setImageDrawable(this.mLayer);
        return;
    L49:
        Drawable r14 = getDrawable();
        this.mDrawable = r14;
        if (r14 == null) goto L69;
        Drawable[] r15 = this.mLayers;
        Drawable r16 = r14.mutate();
        this.mDrawable = r16;
        r15[0] = r16;
        return;
    L69:
        return;
    }

    private void setMatrix() {
        if (Float.isNaN(this.mPanX) == true) goto L5;
    L11:
        float r1 = 0.0f;
        if (Float.isNaN(this.mPanX) == false) goto L14;
        float r0 = 0.0f;
    L16:
        if (Float.isNaN(this.mPanY) == false) goto L18;
        float r2 = 0.0f;
    L20:
        if (Float.isNaN(this.mZoom) == false) goto L22;
        float r3 = 1.0f;
    L24:
        if (Float.isNaN(this.mRotate) == true) goto L27;
        r1 = this.mRotate;
    L27:
        Matrix r4 = new Matrix();
        r4.reset();
        float r5 = getDrawable().getIntrinsicWidth();
        float r6 = getDrawable().getIntrinsicHeight();
        float r7 = getWidth();
        float r8 = getHeight();
        if ((r5 * r8) >= (r6 * r7)) goto L30;
        float r9 = r7 / r5;
    L31:
        float r10 = r3 * r9;
        r4.postScale(r10, r10);
        float r11 = r5 * r10;
        float r12 = r10 * r6;
        r4.postTranslate(((((r7 - r11) * r0) + r7) - r11) * 0.5f, ((((r8 - r12) * r2) + r8) - r12) * 0.5f);
        r4.postRotate(r1, r7 / 2.0f, r8 / 2.0f);
        setImageMatrix(r4);
        setScaleType(ImageView.ScaleType.MATRIX);
        return;
    L30:
        r9 = r8 / r6;
        goto L31
    L22:
        r3 = this.mZoom;
        goto L24
    L18:
        r2 = this.mPanY;
        goto L20
    L14:
        r0 = this.mPanX;
        goto L16
    L5:
        if (Float.isNaN(this.mPanY) == false) goto L11;
        if (Float.isNaN(this.mZoom) == false) goto L11;
        if (Float.isNaN(this.mRotate) == false) goto L11;
    }

    private void setOverlay(boolean r1) {
        this.mOverlay = r1;
    }

    private void updateViewMatrix() {
        if (Float.isNaN(this.mPanX) == true) goto L5;
    L12:
        setMatrix();
        return;
    L5:
        if (Float.isNaN(this.mPanY) == false) goto L12;
        if (Float.isNaN(this.mZoom) == false) goto L12;
        if (Float.isNaN(this.mRotate) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    @Override // android.view.View
    public void draw(Canvas r1) {
        super.draw(r1);
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getImagePanX() {
        return this.mPanX;
    }

    public float getImagePanY() {
        return this.mPanY;
    }

    public float getImageRotate() {
        return this.mRotate;
    }

    public float getImageZoom() {
        return this.mZoom;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    @Override // android.view.View
    public void layout(int r1, int r2, int r3, int r4) {
        super.layout(r1, r2, r3, r4);
        setMatrix();
    }

    public void setAltImageResource(int r4) {
        Drawable r5 = AppCompatResources.getDrawable(getContext(), r4).mutate();
        this.mAltDrawable = r5;
        Drawable[] r0 = this.mLayers;
        r0[0] = this.mDrawable;
        r0[1] = r5;
        LayerDrawable r6 = new LayerDrawable(this.mLayers);
        this.mLayer = r6;
        super.setImageDrawable(r6);
        setCrossfade(this.mCrossfade);
    }

    public void setBrightness(float r2) {
        ImageMatrix r0 = this.mImageMatrix;
        r0.mBrightness = r2;
        r0.updateMatrix(this);
    }

    public void setContrast(float r2) {
        ImageMatrix r0 = this.mImageMatrix;
        r0.mContrast = r2;
        r0.updateMatrix(this);
    }

    public void setCrossfade(float r4) {
        this.mCrossfade = r4;
        if (this.mLayers != null) goto L5;
        return;
    L5:
        if (this.mOverlay == true) goto L7;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L7:
        this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r3) {
        if (this.mAltDrawable == null) goto L6;
        if (r3 == null) goto L6;
        Drawable r4 = r3.mutate();
        this.mDrawable = r4;
        Drawable[] r0 = this.mLayers;
        r0[0] = r4;
        r0[1] = this.mAltDrawable;
        LayerDrawable r5 = new LayerDrawable(this.mLayers);
        this.mLayer = r5;
        super.setImageDrawable(r5);
        setCrossfade(this.mCrossfade);
        return;
    L6:
        super.setImageDrawable(r3);
    }

    public void setImagePanX(float r1) {
        this.mPanX = r1;
        updateViewMatrix();
    }

    public void setImagePanY(float r1) {
        this.mPanY = r1;
        updateViewMatrix();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r3) {
        if (this.mAltDrawable == null) goto L5;
        Drawable r4 = AppCompatResources.getDrawable(getContext(), r3).mutate();
        this.mDrawable = r4;
        Drawable[] r0 = this.mLayers;
        r0[0] = r4;
        r0[1] = this.mAltDrawable;
        LayerDrawable r5 = new LayerDrawable(this.mLayers);
        this.mLayer = r5;
        super.setImageDrawable(r5);
        setCrossfade(this.mCrossfade);
        return;
    L5:
        super.setImageResource(r3);
    }

    public void setImageRotate(float r1) {
        this.mRotate = r1;
        updateViewMatrix();
    }

    public void setImageZoom(float r1) {
        this.mZoom = r1;
        updateViewMatrix();
    }

    @RequiresApi(21)
    public void setRound(float r5) {
        if (Float.isNaN(r5) == false) goto L7;
        this.mRound = r5;
        float r6 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r6);
        return;
    L7:
        if (this.mRound == r5) goto L9;
        boolean r0 = true;
    L10:
        this.mRound = r5;
        if (r5 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r0 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L19;
        this.mRect = new RectF();
    L19:
        if (this.mViewOutlineProvider != null) goto L21;
        ViewOutlineProvider r7 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r7;
        setOutlineProvider(r7);
    L21:
        setClipToOutline(true);
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r8 = this.mPath;
        RectF r1 = this.mRect;
        float r2 = this.mRound;
        r8.addRoundRect(r1, r2, r2, Path.Direction.CW);
        goto L23
    L9:
        r0 = false;
        goto L10
    }

    @RequiresApi(21)
    public void setRoundPercent(float r6) {
        if (this.mRoundPercent == r6) goto L5;
        boolean r0 = true;
    L6:
        this.mRoundPercent = r6;
        if (r6 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r0 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L15;
        this.mRect = new RectF();
    L15:
        if (this.mViewOutlineProvider != null) goto L17;
        ViewOutlineProvider r7 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r7;
        setOutlineProvider(r7);
    L17:
        setClipToOutline(true);
        int r8 = getWidth();
        int r1 = getHeight();
        float r2 = (Math.min(r8, r1) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r8, r1);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r2, r2, Path.Direction.CW);
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    public void setSaturation(float r2) {
        ImageMatrix r0 = this.mImageMatrix;
        r0.mSaturation = r2;
        r0.updateMatrix(this);
    }

    public void setWarmth(float r2) {
        ImageMatrix r0 = this.mImageMatrix;
        r0.mWarmth = r2;
        r0.updateMatrix(this);
    }

    public ImageFilterView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r3, r4);
    }

    public ImageFilterView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r2, r3);
    }
}
