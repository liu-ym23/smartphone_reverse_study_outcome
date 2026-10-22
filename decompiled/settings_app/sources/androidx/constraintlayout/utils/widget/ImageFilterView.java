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

    static class ImageMatrix {
        float[] m;
        float mBrightness;
        ColorMatrix mColorMatrix;
        float mContrast;
        float mSaturation;
        ColorMatrix mTmpColorMatrix;
        float mWarmth;

        ImageMatrix() {
            this.m = new float[20];
            this.mColorMatrix = new ColorMatrix();
            this.mTmpColorMatrix = new ColorMatrix();
            this.mBrightness = 1.0f;
            this.mSaturation = 1.0f;
            this.mContrast = 1.0f;
            this.mWarmth = 1.0f;
        }

        private void saturation(float saturationStrength) {
            float r1 = 1.0f - saturationStrength;
            float r2 = 0.2999f * r1;
            float r3 = 0.587f * r1;
            float r4 = r1 * 0.114f;
            float[] r7 = this.m;
            r7[0] = r2 + saturationStrength;
            r7[1] = r3;
            r7[2] = r4;
            r7[3] = 0.0f;
            r7[4] = 0.0f;
            r7[5] = r2;
            r7[6] = r3 + saturationStrength;
            r7[7] = r4;
            r7[8] = 0.0f;
            r7[9] = 0.0f;
            r7[10] = r2;
            r7[11] = r3;
            r7[12] = r4 + saturationStrength;
            r7[13] = 0.0f;
            r7[14] = 0.0f;
            r7[15] = 0.0f;
            r7[16] = 0.0f;
            r7[17] = 0.0f;
            r7[18] = 1.0f;
            r7[19] = 0.0f;
        }

        private void warmth(float warmth) {
            if (warmth > 0.0f) goto L5;
            warmth = 0.01f;
        L5:
            float r1 = (5000.0f / warmth) / 100.0f;
            if (r1 <= 66.0f) goto L8;
            double r6 = r1 - 60.0f;
            float r2 = ((float) Math.pow(r6, -0.13320475816726685d)) * 329.69873f;
            float r7 = ((float) Math.pow(r6, 0.07551484555006027d)) * 288.12216f;
        L10:
            if (r1 < 66.0f) goto L12;
            float r12 = 255.0f;
        L16:
            float r3 = Math.min(255.0f, Math.max(r2, 0.0f));
            float r4 = Math.min(255.0f, Math.max(r7, 0.0f));
            float r13 = Math.min(255.0f, Math.max(r12, 0.0f));
            float r8 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float r5 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float r9 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float r10 = Math.min(255.0f, Math.max(r8, 0.0f));
            float r14 = r13 / Math.min(255.0f, Math.max(r5, 0.0f));
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
            r11[12] = r14;
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
            r12 = (((float) Math.log(r1 - 10.0f)) * 138.51773f) - 305.0448f;
            goto L16
        L14:
            r12 = 0.0f;
            goto L16
        L8:
            r7 = (((float) Math.log(r1)) * 99.4708f) - 161.11957f;
            r2 = 255.0f;
            goto L10
        }

        private void brightness(float brightness) {
            float[] r2 = this.m;
            r2[0] = brightness;
            r2[1] = 0.0f;
            r2[2] = 0.0f;
            r2[3] = 0.0f;
            r2[4] = 0.0f;
            r2[5] = 0.0f;
            r2[6] = brightness;
            r2[7] = 0.0f;
            r2[8] = 0.0f;
            r2[9] = 0.0f;
            r2[10] = 0.0f;
            r2[11] = 0.0f;
            r2[12] = brightness;
            r2[13] = 0.0f;
            r2[14] = 0.0f;
            r2[15] = 0.0f;
            r2[16] = 0.0f;
            r2[17] = 0.0f;
            r2[18] = 1.0f;
            r2[19] = 0.0f;
        }

        void updateMatrix(ImageView view) {
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
            view.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
            return;
        L18:
            view.clearColorFilter();
            return;
        L15:
            r3 = r1;
            goto L16
        L5:
            r1 = false;
            goto L6
        }
    }

    static /* synthetic */ float access$000(ImageFilterView r0) {
        return r0.mRoundPercent;
    }

    static /* synthetic */ float access$100(ImageFilterView r0) {
        return r0.mRound;
    }

    public float getImagePanX() {
        return this.mPanX;
    }

    public float getImagePanY() {
        return this.mPanY;
    }

    public float getImageZoom() {
        return this.mZoom;
    }

    public float getImageRotate() {
        return this.mRotate;
    }

    public void setImagePanX(float pan) {
        this.mPanX = pan;
        updateViewMatrix();
    }

    public void setImagePanY(float pan) {
        this.mPanY = pan;
        updateViewMatrix();
    }

    public void setImageZoom(float zoom) {
        this.mZoom = zoom;
        updateViewMatrix();
    }

    public void setImageRotate(float rotation) {
        this.mRotate = rotation;
        updateViewMatrix();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.mAltDrawable == null) goto L6;
        if (drawable == null) goto L6;
        Drawable r3 = drawable.mutate();
        this.mDrawable = r3;
        Drawable[] r0 = this.mLayers;
        r0[0] = r3;
        r0[1] = this.mAltDrawable;
        LayerDrawable r4 = new LayerDrawable(this.mLayers);
        this.mLayer = r4;
        super.setImageDrawable(r4);
        setCrossfade(this.mCrossfade);
        return;
    L6:
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int resId) {
        if (this.mAltDrawable == null) goto L5;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), resId).mutate();
        this.mDrawable = r3;
        Drawable[] r0 = this.mLayers;
        r0[0] = r3;
        r0[1] = this.mAltDrawable;
        LayerDrawable r4 = new LayerDrawable(this.mLayers);
        this.mLayer = r4;
        super.setImageDrawable(r4);
        setCrossfade(this.mCrossfade);
        return;
    L5:
        super.setImageResource(resId);
    }

    public void setAltImageResource(int resId) {
        Drawable r4 = AppCompatResources.getDrawable(getContext(), resId).mutate();
        this.mAltDrawable = r4;
        Drawable[] r0 = this.mLayers;
        r0[0] = this.mDrawable;
        r0[1] = r4;
        LayerDrawable r5 = new LayerDrawable(this.mLayers);
        this.mLayer = r5;
        super.setImageDrawable(r5);
        setCrossfade(this.mCrossfade);
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
        r4.postTranslate((((r0 * (r7 - r11)) + r7) - r11) * 0.5f, (((r2 * (r8 - r12)) + r8) - r12) * 0.5f);
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

    public ImageFilterView(Context context) {
        super(context);
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
        init(context, null);
    }

    public ImageFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        init(context, attrs);
    }

    public ImageFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) goto L67;
        TypedArray r6 = getContext().obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
        int r7 = r6.getIndexCount();
        this.mAltDrawable = r6.getDrawable(R.styleable.ImageFilterView_altSrc);
        int r1 = 0;
    L4:
        if (r1 >= r7) goto L42;
        int r2 = r6.getIndex(r1);
        if (r2 != R.styleable.ImageFilterView_crossfade) goto L9;
        this.mCrossfade = r6.getFloat(r2, 0.0f);
    L41:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 != R.styleable.ImageFilterView_warmth) goto L12;
        setWarmth(r6.getFloat(r2, 0.0f));
        goto L41
    L12:
        if (r2 != R.styleable.ImageFilterView_saturation) goto L15;
        setSaturation(r6.getFloat(r2, 0.0f));
        goto L41
    L15:
        if (r2 != R.styleable.ImageFilterView_contrast) goto L18;
        setContrast(r6.getFloat(r2, 0.0f));
        goto L41
    L18:
        if (r2 != R.styleable.ImageFilterView_brightness) goto L21;
        setBrightness(r6.getFloat(r2, 0.0f));
        goto L41
    L21:
        if (r2 != R.styleable.ImageFilterView_round) goto L24;
        setRound(r6.getDimension(r2, 0.0f));
        goto L41
    L24:
        if (r2 != R.styleable.ImageFilterView_roundPercent) goto L27;
        setRoundPercent(r6.getFloat(r2, 0.0f));
        goto L41
    L27:
        if (r2 != R.styleable.ImageFilterView_overlay) goto L30;
        setOverlay(r6.getBoolean(r2, this.mOverlay));
        goto L41
    L30:
        if (r2 != R.styleable.ImageFilterView_imagePanX) goto L33;
        setImagePanX(r6.getFloat(r2, this.mPanX));
        goto L41
    L33:
        if (r2 != R.styleable.ImageFilterView_imagePanY) goto L36;
        setImagePanY(r6.getFloat(r2, this.mPanY));
        goto L41
    L36:
        if (r2 != R.styleable.ImageFilterView_imageRotate) goto L39;
        setImageRotate(r6.getFloat(r2, this.mRotate));
        goto L41
    L39:
        if (r2 != R.styleable.ImageFilterView_imageZoom) goto L41;
        setImageZoom(r6.getFloat(r2, this.mZoom));
        goto L41
    L42:
        r6.recycle();
        Drawable r8 = getDrawable();
        this.mDrawable = r8;
        if (this.mAltDrawable == null) goto L49;
        if (r8 == null) goto L49;
        Drawable[] r9 = this.mLayers;
        Drawable r10 = getDrawable().mutate();
        this.mDrawable = r10;
        r9[0] = r10;
        this.mLayers[1] = this.mAltDrawable.mutate();
        LayerDrawable r11 = new LayerDrawable(this.mLayers);
        this.mLayer = r11;
        r11.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        if (this.mOverlay == true) goto L48;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L48:
        super.setImageDrawable(this.mLayer);
        return;
    L49:
        Drawable r12 = getDrawable();
        this.mDrawable = r12;
        if (r12 == null) goto L69;
        Drawable[] r13 = this.mLayers;
        Drawable r14 = r12.mutate();
        this.mDrawable = r14;
        r13[0] = r14;
        return;
    L69:
        return;
    }

    private void setOverlay(boolean overlay) {
        this.mOverlay = overlay;
    }

    public void setSaturation(float saturation) {
        this.mImageMatrix.mSaturation = saturation;
        this.mImageMatrix.updateMatrix(this);
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public void setContrast(float contrast) {
        this.mImageMatrix.mContrast = contrast;
        this.mImageMatrix.updateMatrix(this);
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public void setWarmth(float warmth) {
        this.mImageMatrix.mWarmth = warmth;
        this.mImageMatrix.updateMatrix(this);
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    public void setCrossfade(float crossfade) {
        this.mCrossfade = crossfade;
        if (this.mLayers != null) goto L5;
        return;
    L5:
        if (this.mOverlay == true) goto L7;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L7:
        this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        super.setImageDrawable(this.mLayer);
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public void setBrightness(float brightness) {
        this.mImageMatrix.mBrightness = brightness;
        this.mImageMatrix.updateMatrix(this);
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public void setRoundPercent(float round) {
        if (this.mRoundPercent == round) goto L5;
        boolean r0 = true;
    L6:
        this.mRoundPercent = round;
        if (round != 0.0f) goto L9;
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
        ViewOutlineProvider r6 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r6;
        setOutlineProvider(r6);
    L17:
        setClipToOutline(true);
        int r7 = getWidth();
        int r1 = getHeight();
        float r2 = (Math.min(r7, r1) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r7, r1);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r2, r2, Path.Direction.CW);
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    public void setRound(float round) {
        if (Float.isNaN(round) == false) goto L7;
        this.mRound = round;
        float r5 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r5);
        return;
    L7:
        if (this.mRound == round) goto L9;
        boolean r0 = true;
    L10:
        this.mRound = round;
        if (round != 0.0f) goto L13;
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
        ViewOutlineProvider r6 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r6;
        setOutlineProvider(r6);
    L21:
        setClipToOutline(true);
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r7 = this.mPath;
        RectF r1 = this.mRect;
        float r2 = this.mRound;
        r7.addRoundRect(r1, r2, r2, Path.Direction.CW);
        goto L23
    L9:
        r0 = false;
        goto L10
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getRound() {
        return this.mRound;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
        setMatrix();
    }
}
