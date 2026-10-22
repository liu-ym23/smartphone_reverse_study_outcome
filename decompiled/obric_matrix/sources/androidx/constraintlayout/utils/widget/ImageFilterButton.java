package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {
    private Drawable mAltDrawable;
    private float mCrossfade;
    private Drawable mDrawable;
    private ImageFilterView.ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    private float mPanX;
    private float mPanY;
    private Path mPath;
    RectF mRect;
    private float mRotate;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;
    private float mZoom;

    public ImageFilterButton(Context r3) {
        super(r3);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r3, null);
    }

    public ImageFilterButton(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r3, r4);
    }

    public ImageFilterButton(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r2, r3);
    }

    static /* synthetic */ float access$000(ImageFilterButton r0) {
        return r0.mRoundPercent;
    }

    static /* synthetic */ float access$100(ImageFilterButton r0) {
        return r0.mRound;
    }

    private void init(Context r8, AttributeSet r9) {
        int r10 = Build.VERSION.SDK_INT;
        setPadding(0, 0, 0, 0);
        if (r9 == null) goto L68;
        TypedArray r11 = getContext().obtainStyledAttributes(r9, R.styleable.ImageFilterView);
        int r1 = r11.getIndexCount();
        this.mAltDrawable = r11.getDrawable(R.styleable.ImageFilterView_altSrc);
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L42;
        int r3 = r11.getIndex(r2);
        if (r3 != R.styleable.ImageFilterView_crossfade) goto L10;
        this.mCrossfade = r11.getFloat(r3, 0.0f);
    L41:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != R.styleable.ImageFilterView_warmth) goto L13;
        setWarmth(r11.getFloat(r3, 0.0f));
        goto L41
    L13:
        if (r3 != R.styleable.ImageFilterView_saturation) goto L16;
        setSaturation(r11.getFloat(r3, 0.0f));
        goto L41
    L16:
        if (r3 != R.styleable.ImageFilterView_contrast) goto L19;
        setContrast(r11.getFloat(r3, 0.0f));
        goto L41
    L19:
        if (r3 != R.styleable.ImageFilterView_round) goto L23;
        if (r10 < 21) goto L41;
        setRound(r11.getDimension(r3, 0.0f));
        goto L41
    L23:
        if (r3 != R.styleable.ImageFilterView_roundPercent) goto L27;
        if (r10 < 21) goto L41;
        setRoundPercent(r11.getFloat(r3, 0.0f));
        goto L41
    L27:
        if (r3 != R.styleable.ImageFilterView_overlay) goto L30;
        setOverlay(r11.getBoolean(r3, this.mOverlay));
        goto L41
    L30:
        if (r3 != R.styleable.ImageFilterView_imagePanX) goto L33;
        setImagePanX(r11.getFloat(r3, this.mPanX));
        goto L41
    L33:
        if (r3 != R.styleable.ImageFilterView_imagePanY) goto L36;
        setImagePanY(r11.getFloat(r3, this.mPanY));
        goto L41
    L36:
        if (r3 != R.styleable.ImageFilterView_imageRotate) goto L39;
        setImageRotate(r11.getFloat(r3, this.mRotate));
        goto L41
    L39:
        if (r3 != R.styleable.ImageFilterView_imageZoom) goto L41;
        setImageZoom(r11.getFloat(r3, this.mZoom));
        goto L41
    L42:
        r11.recycle();
        Drawable r12 = getDrawable();
        this.mDrawable = r12;
        if (this.mAltDrawable == null) goto L49;
        if (r12 == null) goto L49;
        Drawable[] r13 = this.mLayers;
        Drawable r14 = getDrawable().mutate();
        this.mDrawable = r14;
        r13[0] = r14;
        this.mLayers[1] = this.mAltDrawable.mutate();
        LayerDrawable r15 = new LayerDrawable(this.mLayers);
        this.mLayer = r15;
        r15.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        if (this.mOverlay == true) goto L48;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L48:
        super.setImageDrawable(this.mLayer);
        return;
    L49:
        Drawable r16 = getDrawable();
        this.mDrawable = r16;
        if (r16 == null) goto L70;
        Drawable[] r17 = this.mLayers;
        Drawable r18 = r16.mutate();
        this.mDrawable = r18;
        r17[0] = r18;
        return;
    L70:
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
    public void draw(Canvas r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L9:
        boolean r0 = false;
    L10:
        super.draw(r3);
        if (r0 == false) goto L14;
        r3.restore();
        return;
    L14:
        return;
    L5:
        if (this.mRound == 0.0f) goto L9;
        if (this.mPath == null) goto L9;
        r0 = true;
        r3.save();
        r3.clipPath(this.mPath);
        goto L10
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
        ImageFilterView.ImageMatrix r0 = this.mImageMatrix;
        r0.mBrightness = r2;
        r0.updateMatrix(this);
    }

    public void setContrast(float r2) {
        ImageFilterView.ImageMatrix r0 = this.mImageMatrix;
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

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
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

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
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
    public void setRound(float r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (Float.isNaN(r7) == false) goto L7;
        this.mRound = r7;
        float r8 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r8);
        return;
    L7:
        if (this.mRound == r7) goto L9;
        boolean r1 = true;
    L10:
        this.mRound = r7;
        if (r7 != 0.0f) goto L13;
        if (r0 < 21) goto L26;
        setClipToOutline(false);
    L26:
        if (r1 == false) goto L30;
        if (r0 < 21) goto L31;
        invalidateOutline();
        return;
    L31:
        return;
    L30:
        return;
    L13:
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L18;
        this.mRect = new RectF();
    L18:
        if (r0 >= 21) goto L20;
    L23:
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r9 = this.mPath;
        RectF r2 = this.mRect;
        float r3 = this.mRound;
        r9.addRoundRect(r2, r3, r3, Path.Direction.CW);
        goto L26
    L20:
        if (this.mViewOutlineProvider != null) goto L22;
        ViewOutlineProvider r10 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r10;
        setOutlineProvider(r10);
    L22:
        setClipToOutline(true);
        goto L23
    L9:
        r1 = false;
        goto L10
    }

    @RequiresApi(21)
    public void setRoundPercent(float r8) {
        int r0 = Build.VERSION.SDK_INT;
        if (this.mRoundPercent == r8) goto L5;
        boolean r1 = true;
    L6:
        this.mRoundPercent = r8;
        if (r8 != 0.0f) goto L9;
        if (r0 < 21) goto L22;
        setClipToOutline(false);
    L22:
        if (r1 == false) goto L26;
        if (r0 < 21) goto L27;
        invalidateOutline();
        return;
    L27:
        return;
    L26:
        return;
    L9:
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L14;
        this.mRect = new RectF();
    L14:
        if (r0 >= 21) goto L16;
    L19:
        int r9 = getWidth();
        int r2 = getHeight();
        float r3 = (Math.min(r9, r2) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r9, r2);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r3, r3, Path.Direction.CW);
        goto L22
    L16:
        if (this.mViewOutlineProvider != null) goto L18;
        ViewOutlineProvider r10 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r10;
        setOutlineProvider(r10);
    L18:
        setClipToOutline(true);
        goto L19
    L5:
        r1 = false;
        goto L6
    }

    public void setSaturation(float r2) {
        ImageFilterView.ImageMatrix r0 = this.mImageMatrix;
        r0.mSaturation = r2;
        r0.updateMatrix(this);
    }

    public void setWarmth(float r2) {
        ImageFilterView.ImageMatrix r0 = this.mImageMatrix;
        r0.mWarmth = r2;
        r0.updateMatrix(this);
    }
}
