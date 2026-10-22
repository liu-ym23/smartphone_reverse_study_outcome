package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
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

    static /* synthetic */ float access$000(ImageFilterButton r0) {
        return r0.mRoundPercent;
    }

    static /* synthetic */ float access$100(ImageFilterButton r0) {
        return r0.mRound;
    }

    public ImageFilterButton(Context context) {
        super(context);
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
        init(context, null);
    }

    public ImageFilterButton(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        init(context, attrs);
    }

    public ImageFilterButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setPadding(0, 0, 0, 0);
        if (attrs == null) goto L64;
        TypedArray r7 = getContext().obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
        int r0 = r7.getIndexCount();
        this.mAltDrawable = r7.getDrawable(R.styleable.ImageFilterView_altSrc);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L40;
        int r2 = r7.getIndex(r1);
        if (r2 != R.styleable.ImageFilterView_crossfade) goto L10;
        this.mCrossfade = r7.getFloat(r2, 0.0f);
    L39:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != R.styleable.ImageFilterView_warmth) goto L13;
        setWarmth(r7.getFloat(r2, 0.0f));
        goto L39
    L13:
        if (r2 != R.styleable.ImageFilterView_saturation) goto L16;
        setSaturation(r7.getFloat(r2, 0.0f));
        goto L39
    L16:
        if (r2 != R.styleable.ImageFilterView_contrast) goto L19;
        setContrast(r7.getFloat(r2, 0.0f));
        goto L39
    L19:
        if (r2 != R.styleable.ImageFilterView_round) goto L22;
        setRound(r7.getDimension(r2, 0.0f));
        goto L39
    L22:
        if (r2 != R.styleable.ImageFilterView_roundPercent) goto L25;
        setRoundPercent(r7.getFloat(r2, 0.0f));
        goto L39
    L25:
        if (r2 != R.styleable.ImageFilterView_overlay) goto L28;
        setOverlay(r7.getBoolean(r2, this.mOverlay));
        goto L39
    L28:
        if (r2 != R.styleable.ImageFilterView_imagePanX) goto L31;
        setImagePanX(r7.getFloat(r2, this.mPanX));
        goto L39
    L31:
        if (r2 != R.styleable.ImageFilterView_imagePanY) goto L34;
        setImagePanY(r7.getFloat(r2, this.mPanY));
        goto L39
    L34:
        if (r2 != R.styleable.ImageFilterView_imageRotate) goto L37;
        setImageRotate(r7.getFloat(r2, this.mRotate));
        goto L39
    L37:
        if (r2 != R.styleable.ImageFilterView_imageZoom) goto L39;
        setImageZoom(r7.getFloat(r2, this.mZoom));
        goto L39
    L40:
        r7.recycle();
        Drawable r8 = getDrawable();
        this.mDrawable = r8;
        if (this.mAltDrawable == null) goto L47;
        if (r8 == null) goto L47;
        Drawable[] r9 = this.mLayers;
        Drawable r3 = getDrawable().mutate();
        this.mDrawable = r3;
        r9[0] = r3;
        this.mLayers[1] = this.mAltDrawable.mutate();
        LayerDrawable r10 = new LayerDrawable(this.mLayers);
        this.mLayer = r10;
        r10.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
        if (this.mOverlay == true) goto L46;
        this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
    L46:
        super.setImageDrawable(this.mLayer);
        return;
    L47:
        Drawable r11 = getDrawable();
        this.mDrawable = r11;
        if (r11 == null) goto L66;
        Drawable[] r4 = this.mLayers;
        Drawable r12 = r11.mutate();
        this.mDrawable = r12;
        r4[0] = r12;
        return;
    L66:
        return;
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

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
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

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
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
