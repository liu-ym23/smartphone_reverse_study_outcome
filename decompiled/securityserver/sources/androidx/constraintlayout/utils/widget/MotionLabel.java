package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.view.GravityCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.ss.android.common.ApiConstants;

/* JADX INFO: loaded from: classes.dex */
public class MotionLabel extends View implements FloatLayout {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    static String TAG = "MotionLabel";
    private boolean mAutoSize;
    private int mAutoSizeTextType;
    float mBackgroundPanX;
    float mBackgroundPanY;
    private float mBaseTextSize;
    private float mDeltaLeft;
    private float mFloatHeight;
    private float mFloatWidth;
    private String mFontFamily;
    private int mGravity;
    private Layout mLayout;
    boolean mNotBuilt;
    Matrix mOutlinePositionMatrix;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    TextPaint mPaint;
    Path mPath;
    RectF mRect;
    float mRotate;
    private float mRound;
    private float mRoundPercent;
    private int mStyleIndex;
    Paint mTempPaint;
    Rect mTempRect;
    private String mText;
    private Drawable mTextBackground;
    private Bitmap mTextBackgroundBitmap;
    private Rect mTextBounds;
    private int mTextFillColor;
    private int mTextOutlineColor;
    private float mTextOutlineThickness;
    private float mTextPanX;
    private float mTextPanY;
    private BitmapShader mTextShader;
    private Matrix mTextShaderMatrix;
    private float mTextSize;
    private int mTextureEffect;
    private float mTextureHeight;
    private float mTextureWidth;
    private CharSequence mTransformed;
    private int mTypefaceIndex;
    private boolean mUseOutline;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom;
    Paint paintCache;
    float paintTextSize;

    public MotionLabel(Context r6) {
        super(r6);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = 65535;
        this.mTextOutlineColor = 65535;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = BadgeDrawable.TOP_START;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r6, null);
    }

    public static /* synthetic */ float access$000(MotionLabel r0) {
        return r0.mRoundPercent;
    }

    public static /* synthetic */ float access$100(MotionLabel r0) {
        return r0.mRound;
    }

    private void adjustTexture(float r2, float r3, float r4, float r5) {
        if (this.mTextShaderMatrix != null) goto L5;
        return;
    L5:
        this.mFloatWidth = r4 - r2;
        this.mFloatHeight = r5 - r3;
        updateShaderMatrix();
    }

    private float getHorizontalOffset() {
        if (Float.isNaN(this.mBaseTextSize) == false) goto L5;
        float r0 = 1.0f;
    L6:
        TextPaint r2 = this.mPaint;
        String r3 = this.mText;
        float r4 = r2.measureText(r3, 0, r3.length()) * r0;
        if (Float.isNaN(this.mFloatWidth) == false) goto L9;
        float r1 = getMeasuredWidth();
    L11:
        return ((this.mTextPanX + 1.0f) * (((r1 - getPaddingLeft()) - getPaddingRight()) - r4)) / 2.0f;
    L9:
        r1 = this.mFloatWidth;
        goto L11
    L5:
        r0 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    private float getVerticalOffset() {
        if (Float.isNaN(this.mBaseTextSize) == false) goto L5;
        float r0 = 1.0f;
    L6:
        Paint.FontMetrics r2 = this.mPaint.getFontMetrics();
        if (Float.isNaN(this.mFloatHeight) == false) goto L9;
        float r3 = getMeasuredHeight();
    L10:
        float r4 = (r3 - getPaddingTop()) - getPaddingBottom();
        float r5 = r2.descent;
        float r6 = r2.ascent;
        return (((1.0f - this.mTextPanY) * (r4 - ((r5 - r6) * r0))) / 2.0f) - (r0 * r6);
    L9:
        r3 = this.mFloatHeight;
        goto L10
    L5:
        r0 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    private void init(Context r6, AttributeSet r7) {
        setUpTheme(r6, r7);
        if (r7 == null) goto L77;
        TypedArray r8 = getContext().obtainStyledAttributes(r7, R.styleable.MotionLabel);
        int r9 = r8.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r9) goto L76;
        int r2 = r8.getIndex(r1);
        if (r2 != R.styleable.MotionLabel_android_text) goto L10;
        setText(r8.getText(r2));
    L75:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != R.styleable.MotionLabel_android_fontFamily) goto L13;
        this.mFontFamily = r8.getString(r2);
        goto L75
    L13:
        if (r2 != R.styleable.MotionLabel_scaleFromTextSize) goto L16;
        this.mBaseTextSize = r8.getDimensionPixelSize(r2, (int) this.mBaseTextSize);
        goto L75
    L16:
        if (r2 != R.styleable.MotionLabel_android_textSize) goto L19;
        this.mTextSize = r8.getDimensionPixelSize(r2, (int) this.mTextSize);
        goto L75
    L19:
        if (r2 != R.styleable.MotionLabel_android_textStyle) goto L22;
        this.mStyleIndex = r8.getInt(r2, this.mStyleIndex);
        goto L75
    L22:
        if (r2 != R.styleable.MotionLabel_android_typeface) goto L25;
        this.mTypefaceIndex = r8.getInt(r2, this.mTypefaceIndex);
        goto L75
    L25:
        if (r2 != R.styleable.MotionLabel_android_textColor) goto L28;
        this.mTextFillColor = r8.getColor(r2, this.mTextFillColor);
        goto L75
    L28:
        if (r2 != R.styleable.MotionLabel_borderRound) goto L31;
        float r3 = r8.getDimension(r2, this.mRound);
        this.mRound = r3;
        setRound(r3);
        goto L75
    L31:
        if (r2 != R.styleable.MotionLabel_borderRoundPercent) goto L34;
        float r4 = r8.getFloat(r2, this.mRoundPercent);
        this.mRoundPercent = r4;
        setRoundPercent(r4);
        goto L75
    L34:
        if (r2 != R.styleable.MotionLabel_android_gravity) goto L37;
        setGravity(r8.getInt(r2, -1));
        goto L75
    L37:
        if (r2 != R.styleable.MotionLabel_android_autoSizeTextType) goto L40;
        this.mAutoSizeTextType = r8.getInt(r2, 0);
        goto L75
    L40:
        if (r2 != R.styleable.MotionLabel_textOutlineColor) goto L43;
        this.mTextOutlineColor = r8.getInt(r2, this.mTextOutlineColor);
        this.mUseOutline = true;
        goto L75
    L43:
        if (r2 != R.styleable.MotionLabel_textOutlineThickness) goto L46;
        this.mTextOutlineThickness = r8.getDimension(r2, this.mTextOutlineThickness);
        this.mUseOutline = true;
        goto L75
    L46:
        if (r2 != R.styleable.MotionLabel_textBackground) goto L49;
        this.mTextBackground = r8.getDrawable(r2);
        this.mUseOutline = true;
        goto L75
    L49:
        if (r2 != R.styleable.MotionLabel_textBackgroundPanX) goto L52;
        this.mBackgroundPanX = r8.getFloat(r2, this.mBackgroundPanX);
        goto L75
    L52:
        if (r2 != R.styleable.MotionLabel_textBackgroundPanY) goto L55;
        this.mBackgroundPanY = r8.getFloat(r2, this.mBackgroundPanY);
        goto L75
    L55:
        if (r2 != R.styleable.MotionLabel_textPanX) goto L58;
        this.mTextPanX = r8.getFloat(r2, this.mTextPanX);
        goto L75
    L58:
        if (r2 != R.styleable.MotionLabel_textPanY) goto L61;
        this.mTextPanY = r8.getFloat(r2, this.mTextPanY);
        goto L75
    L61:
        if (r2 != R.styleable.MotionLabel_textBackgroundRotate) goto L64;
        this.mRotate = r8.getFloat(r2, this.mRotate);
        goto L75
    L64:
        if (r2 != R.styleable.MotionLabel_textBackgroundZoom) goto L67;
        this.mZoom = r8.getFloat(r2, this.mZoom);
        goto L75
    L67:
        if (r2 != R.styleable.MotionLabel_textureHeight) goto L70;
        this.mTextureHeight = r8.getDimension(r2, this.mTextureHeight);
        goto L75
    L70:
        if (r2 != R.styleable.MotionLabel_textureWidth) goto L73;
        this.mTextureWidth = r8.getDimension(r2, this.mTextureWidth);
        goto L75
    L73:
        if (r2 != R.styleable.MotionLabel_textureEffect) goto L75;
        this.mTextureEffect = r8.getInt(r2, this.mTextureEffect);
        goto L75
    L76:
        r8.recycle();
    L77:
        setupTexture();
        setupPath();
    }

    private void setTypefaceFromAttrs(String r5, int r6, int r7) {
        if (r5 == null) goto L7;
        Typeface r8 = Typeface.create(r5, r7);
        if (r8 == null) goto L8;
        setTypeface(r8);
        return;
    L8:
        boolean r1 = true;
        if (r6 == 1) goto L16;
        if (r6 != 2) goto L12;
        r8 = Typeface.SERIF;
    L17:
        float r9 = 0.0f;
        if (r7 <= 0) goto L34;
        if (r8 != null) goto L21;
        Typeface r10 = Typeface.defaultFromStyle(r7);
    L22:
        setTypeface(r10);
        if (r10 == null) goto L25;
        int r11 = r10.getStyle();
    L26:
        int r12 = (~r11) & r7;
        TextPaint r13 = this.mPaint;
        if ((r12 & 1) != 0) goto L30;
        r1 = false;
    L30:
        r13.setFakeBoldText(r1);
        TextPaint r4 = this.mPaint;
        if ((r12 & 2) == 0) goto L33;
        r9 = -0.25f;
    L33:
        r4.setTextSkewX(r9);
        return;
    L25:
        r11 = 0;
        goto L26
    L21:
        r10 = Typeface.create(r8, r7);
        goto L22
    L34:
        this.mPaint.setFakeBoldText(false);
        this.mPaint.setTextSkewX(0.0f);
        setTypeface(r8);
        return;
    L12:
        if (r6 != 3) goto L17;
        r8 = Typeface.MONOSPACE;
        goto L17
    L16:
        r8 = Typeface.SANS_SERIF;
        goto L17
    L7:
        r8 = null;
        goto L8
    }

    private void setUpTheme(Context r3, @Nullable AttributeSet r4) {
        TypedValue r5 = new TypedValue();
        r3.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, r5, true);
        TextPaint r6 = this.mPaint;
        int r7 = r5.data;
        this.mTextFillColor = r7;
        r6.setColor(r7);
    }

    private void setupTexture() {
        if (this.mTextBackground == null) goto L28;
        this.mTextShaderMatrix = new Matrix();
        int r0 = this.mTextBackground.getIntrinsicWidth();
        int r1 = this.mTextBackground.getIntrinsicHeight();
        int r2 = 128;
        if (r0 > 0) goto L12;
        r0 = getWidth();
        if (r0 != 0) goto L12;
        if (Float.isNaN(this.mTextureWidth) == false) goto L11;
        r0 = 128;
        goto L12
    L11:
        r0 = (int) this.mTextureWidth;
    L12:
        if (r1 > 0) goto L21;
        r1 = getHeight();
        if (r1 != 0) goto L21;
        if (Float.isNaN(this.mTextureHeight) == true) goto L19;
        r2 = (int) this.mTextureHeight;
    L19:
        r1 = r2;
    L21:
        if (this.mTextureEffect == 0) goto L23;
        r0 = r0 / 2;
        r1 = r1 / 2;
    L23:
        this.mTextBackgroundBitmap = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(this.mTextBackgroundBitmap);
        this.mTextBackground.setBounds(0, 0, r3.getWidth(), r3.getHeight());
        this.mTextBackground.setFilterBitmap(true);
        this.mTextBackground.draw(r3);
        if (this.mTextureEffect == 0) goto L26;
        this.mTextBackgroundBitmap = blur(this.mTextBackgroundBitmap, 4);
    L26:
        Bitmap r4 = this.mTextBackgroundBitmap;
        Shader.TileMode r5 = Shader.TileMode.REPEAT;
        this.mTextShader = new BitmapShader(r4, r5, r5);
        return;
    }

    private void updateShaderMatrix() {
        float r1 = 0.0f;
        if (Float.isNaN(this.mBackgroundPanX) == false) goto L5;
        float r0 = 0.0f;
    L7:
        if (Float.isNaN(this.mBackgroundPanY) == false) goto L9;
        float r2 = 0.0f;
    L11:
        if (Float.isNaN(this.mZoom) == false) goto L13;
        float r3 = 1.0f;
    L15:
        if (Float.isNaN(this.mRotate) == true) goto L18;
        r1 = this.mRotate;
    L18:
        this.mTextShaderMatrix.reset();
        float r4 = this.mTextBackgroundBitmap.getWidth();
        float r5 = this.mTextBackgroundBitmap.getHeight();
        if (Float.isNaN(this.mTextureWidth) == false) goto L21;
        float r6 = this.mFloatWidth;
    L23:
        if (Float.isNaN(this.mTextureHeight) == false) goto L25;
        float r7 = this.mFloatHeight;
    L27:
        if ((r4 * r7) >= (r5 * r6)) goto L29;
        float r8 = r6 / r4;
    L30:
        float r9 = r3 * r8;
        this.mTextShaderMatrix.postScale(r9, r9);
        float r10 = r4 * r9;
        float r11 = r6 - r10;
        float r12 = r9 * r5;
        float r13 = r7 - r12;
        if (Float.isNaN(this.mTextureHeight) == true) goto L34;
        r13 = this.mTextureHeight / 2.0f;
    L34:
        if (Float.isNaN(this.mTextureWidth) == true) goto L36;
        r11 = this.mTextureWidth / 2.0f;
    L36:
        float r14 = (((r2 * r13) + r7) - r12) * 0.5f;
        this.mTextShaderMatrix.postTranslate((((r0 * r11) + r6) - r10) * 0.5f, r14);
        this.mTextShaderMatrix.postRotate(r1, r6 / 2.0f, r7 / 2.0f);
        this.mTextShader.setLocalMatrix(this.mTextShaderMatrix);
        return;
    L29:
        r8 = r7 / r5;
        goto L30
    L25:
        r7 = this.mTextureHeight;
        goto L27
    L21:
        r6 = this.mTextureWidth;
        goto L23
    L13:
        r3 = this.mZoom;
        goto L15
    L9:
        r2 = this.mBackgroundPanY;
        goto L11
    L5:
        r0 = this.mBackgroundPanX;
        goto L7
    }

    public Bitmap blur(Bitmap r5, int r6) {
        System.nanoTime();
        int r4 = r5.getWidth();
        int r7 = r4 / 2;
        int r0 = r5.getHeight() / 2;
        Bitmap r8 = Bitmap.createScaledBitmap(r5, r7, r0, true);
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L9;
        if (r7 < 32) goto L9;
        if (r0 < 32) goto L9;
        r7 = r7 / 2;
        r0 = r0 / 2;
        r8 = Bitmap.createScaledBitmap(r8, r7, r0, true);
        r2 = r2 + 1;
    L9:
        return r8;
    }

    public void buildShape(float r11) {
        if (this.mUseOutline == false) goto L5;
    L7:
        this.mPath.reset();
        String r3 = this.mText;
        int r5 = r3.length();
        this.mPaint.getTextBounds(r3, 0, r5, this.mTextBounds);
        this.mPaint.getTextPath(r3, 0, r5, 0.0f, 0.0f, this.mPath);
        if (r11 == 1.0f) goto L10;
        Log.v(TAG, Debug.getLoc() + " scale " + r11);
        Matrix r0 = new Matrix();
        r0.postScale(r11, r11);
        this.mPath.transform(r0);
    L10:
        Rect r12 = this.mTextBounds;
        r12.right--;
        r12.left++;
        r12.bottom++;
        r12.top--;
        RectF r13 = new RectF();
        r13.bottom = getHeight();
        r13.right = getWidth();
        this.mNotBuilt = false;
        return;
    L5:
        if (r11 != 1.0f) goto L7;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getScaleFromTextSize() {
        return this.mBaseTextSize;
    }

    public float getTextBackgroundPanX() {
        return this.mBackgroundPanX;
    }

    public float getTextBackgroundPanY() {
        return this.mBackgroundPanY;
    }

    public float getTextBackgroundRotate() {
        return this.mRotate;
    }

    public float getTextBackgroundZoom() {
        return this.mZoom;
    }

    public int getTextOutlineColor() {
        return this.mTextOutlineColor;
    }

    public float getTextPanX() {
        return this.mTextPanX;
    }

    public float getTextPanY() {
        return this.mTextPanY;
    }

    public float getTextureHeight() {
        return this.mTextureHeight;
    }

    public float getTextureWidth() {
        return this.mTextureWidth;
    }

    public Typeface getTypeface() {
        return this.mPaint.getTypeface();
    }

    @Override // android.view.View
    public void layout(int r9, int r10, int r11, int r12) {
        super.layout(r9, r10, r11, r12);
        boolean r0 = Float.isNaN(this.mBaseTextSize);
        if (r0 == false) goto L5;
        float r1 = 1.0f;
    L6:
        this.mFloatWidth = r11 - r9;
        this.mFloatHeight = r12 - r10;
        if (this.mAutoSize == false) goto L22;
        if (this.mTempRect != null) goto L11;
        this.mTempPaint = new Paint();
        this.mTempRect = new Rect();
        this.mTempPaint.set(this.mPaint);
        this.paintTextSize = this.mTempPaint.getTextSize();
    L11:
        Paint r2 = this.mTempPaint;
        String r3 = this.mText;
        r2.getTextBounds(r3, 0, r3.length(), this.mTempRect);
        int r4 = this.mTempRect.width();
        int r5 = (int) (this.mTempRect.height() * 1.3f);
        float r6 = (this.mFloatWidth - this.mPaddingRight) - this.mPaddingLeft;
        float r7 = (this.mFloatHeight - this.mPaddingBottom) - this.mPaddingTop;
        if (r0 == false) goto L17;
        float r8 = r4;
        float r13 = r5;
        if ((r8 * r7) <= (r13 * r6)) goto L16;
        this.mPaint.setTextSize((this.paintTextSize * r6) / r8);
        goto L22
    L16:
        this.mPaint.setTextSize((this.paintTextSize * r7) / r13);
        goto L22
    L17:
        float r14 = r4;
        float r15 = r5;
        if ((r14 * r7) <= (r15 * r6)) goto L20;
        r1 = r6 / r14;
        goto L22
    L20:
        r1 = r7 / r15;
    L22:
        if (this.mUseOutline == true) goto L24;
        if (r0 == false) goto L24;
        return;
    L24:
        adjustTexture(r9, r10, r11, r12);
        buildShape(r1);
        return;
    L5:
        r1 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        if (Float.isNaN(this.mBaseTextSize) == false) goto L5;
        float r0 = 1.0f;
    L6:
        super.onDraw(r5);
        if (this.mUseOutline == true) goto L13;
        if (r0 != 1.0f) goto L13;
        float r1 = this.mPaddingLeft + getHorizontalOffset();
        r5.drawText(this.mText, this.mDeltaLeft + r1, this.mPaddingTop + getVerticalOffset(), this.mPaint);
        return;
    L13:
        if (this.mNotBuilt == false) goto L16;
        buildShape(r0);
    L16:
        if (this.mOutlinePositionMatrix != null) goto L19;
        this.mOutlinePositionMatrix = new Matrix();
    L19:
        if (this.mUseOutline == false) goto L28;
        this.paintCache.set(this.mPaint);
        this.mOutlinePositionMatrix.reset();
        float r2 = this.mPaddingLeft + getHorizontalOffset();
        float r3 = this.mPaddingTop + getVerticalOffset();
        this.mOutlinePositionMatrix.postTranslate(r2, r3);
        this.mOutlinePositionMatrix.preScale(r0, r0);
        this.mPath.transform(this.mOutlinePositionMatrix);
        if (this.mTextShader == null) goto L23;
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setShader(this.mTextShader);
    L24:
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        r5.drawPath(this.mPath, this.mPaint);
        if (this.mTextShader == null) goto L27;
        this.mPaint.setShader(null);
    L27:
        this.mPaint.setColor(this.mTextOutlineColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        r5.drawPath(this.mPath, this.mPaint);
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.postTranslate(-r2, -r3);
        this.mPath.transform(this.mOutlinePositionMatrix);
        this.mPaint.set(this.paintCache);
        return;
    L23:
        this.mPaint.setColor(this.mTextFillColor);
        goto L24
    L28:
        float r4 = this.mPaddingLeft + getHorizontalOffset();
        float r6 = this.mPaddingTop + getVerticalOffset();
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(r4, r6);
        this.mPath.transform(this.mOutlinePositionMatrix);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        r5.drawPath(this.mPath, this.mPaint);
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(-r4, -r6);
        this.mPath.transform(this.mOutlinePositionMatrix);
        return;
    L5:
        r0 = this.mTextSize / this.mBaseTextSize;
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getMode(r9);
        int r1 = View.MeasureSpec.getMode(r10);
        int r11 = View.MeasureSpec.getSize(r9);
        int r12 = View.MeasureSpec.getSize(r10);
        this.mAutoSize = false;
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        if (r0 != 1073741824) goto L9;
        if (r1 != 1073741824) goto L9;
        if (this.mAutoSizeTextType == 0) goto L18;
        this.mAutoSize = true;
    L18:
        setMeasuredDimension(r11, r12);
        return;
    L9:
        TextPaint r4 = this.mPaint;
        String r5 = this.mText;
        r4.getTextBounds(r5, 0, r5.length(), this.mTextBounds);
        if (r0 == 1073741824) goto L12;
        r11 = (int) (this.mTextBounds.width() + 0.99999f);
    L12:
        r11 = r11 + (this.mPaddingLeft + this.mPaddingRight);
        if (r1 == 1073741824) goto L18;
        int r2 = (int) (this.mPaint.getFontMetricsInt(null) + 0.99999f);
        if (r1 != Integer.MIN_VALUE) goto L17;
        r2 = Math.min(r12, r2);
    L17:
        r12 = (this.mPaddingTop + this.mPaddingBottom) + r2;
        goto L18
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int r8) {
        if ((r8 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != 0) goto L6;
        r8 = r8 | GravityCompat.START;
    L6:
        if ((r8 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST) != 0) goto L9;
        r8 = r8 | 48;
    L9:
        if (r8 == this.mGravity) goto L11;
        invalidate();
    L11:
        this.mGravity = r8;
        int r1 = r8 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r1 != 48) goto L14;
        this.mTextPanY = -1.0f;
    L18:
        int r9 = r8 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r9 != 3) goto L21;
    L27:
        this.mTextPanX = -1.0f;
        return;
    L21:
        if (r9 == 5) goto L26;
        if (r9 == 8388611) goto L27;
        if (r9 == 8388613) goto L26;
        this.mTextPanX = 0.0f;
        return;
    L26:
        this.mTextPanX = 1.0f;
        return;
    L14:
        if (r1 == 80) goto L16;
        this.mTextPanY = 0.0f;
        goto L18
    L16:
        this.mTextPanY = 1.0f;
        goto L18
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

    public void setScaleFromTextSize(float r1) {
        this.mBaseTextSize = r1;
    }

    public void setText(CharSequence r1) {
        this.mText = r1.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float r1) {
        this.mBackgroundPanX = r1;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundPanY(float r1) {
        this.mBackgroundPanY = r1;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundRotate(float r1) {
        this.mRotate = r1;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundZoom(float r1) {
        this.mZoom = r1;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextFillColor(int r1) {
        this.mTextFillColor = r1;
        invalidate();
    }

    public void setTextOutlineColor(int r1) {
        this.mTextOutlineColor = r1;
        this.mUseOutline = true;
        invalidate();
    }

    public void setTextOutlineThickness(float r2) {
        this.mTextOutlineThickness = r2;
        this.mUseOutline = true;
        if (Float.isNaN(r2) == false) goto L5;
        this.mTextOutlineThickness = 1.0f;
        this.mUseOutline = false;
    L5:
        invalidate();
    }

    public void setTextPanX(float r1) {
        this.mTextPanX = r1;
        invalidate();
    }

    public void setTextPanY(float r1) {
        this.mTextPanY = r1;
        invalidate();
    }

    public void setTextSize(float r4) {
        this.mTextSize = r4;
        Log.v(TAG, Debug.getLoc() + "  " + r4 + " / " + this.mBaseTextSize);
        TextPaint r0 = this.mPaint;
        if (Float.isNaN(this.mBaseTextSize) == true) goto L6;
        r4 = this.mBaseTextSize;
    L6:
        r0.setTextSize(r4);
        if (Float.isNaN(this.mBaseTextSize) == false) goto L9;
        float r5 = 1.0f;
    L10:
        buildShape(r5);
        requestLayout();
        invalidate();
        return;
    L9:
        r5 = this.mTextSize / this.mBaseTextSize;
        goto L10
    }

    public void setTextureHeight(float r1) {
        this.mTextureHeight = r1;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextureWidth(float r1) {
        this.mTextureWidth = r1;
        updateShaderMatrix();
        invalidate();
    }

    public void setTypeface(Typeface r2) {
        if (this.mPaint.getTypeface() == r2) goto L8;
        this.mPaint.setTypeface(r2);
        if (this.mLayout == null) goto L9;
        this.mLayout = null;
        requestLayout();
        invalidate();
        return;
    L9:
        return;
    }

    public void setupPath() {
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        setTypefaceFromAttrs(this.mFontFamily, this.mTypefaceIndex, this.mStyleIndex);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setFlags(128);
        setTextSize(this.mTextSize);
        this.mPaint.setAntiAlias(true);
    }

    @Override // androidx.constraintlayout.motion.widget.FloatLayout
    public void layout(float r9, float r10, float r11, float r12) {
        int r1 = (int) (r9 + 0.5f);
        this.mDeltaLeft = r9 - r1;
        int r2 = (int) (r11 + 0.5f);
        int r3 = r2 - r1;
        int r4 = (int) (r12 + 0.5f);
        int r0 = (int) (0.5f + r10);
        int r5 = r4 - r0;
        float r6 = r11 - r9;
        this.mFloatWidth = r6;
        float r7 = r12 - r10;
        this.mFloatHeight = r7;
        adjustTexture(r9, r10, r11, r12);
        if (getMeasuredHeight() == r5) goto L5;
    L8:
        measure(View.MeasureSpec.makeMeasureSpec(r3, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r5, BasicMeasure.EXACTLY));
        super.layout(r1, r0, r2, r4);
    L10:
        if (this.mAutoSize == true) goto L12;
        return;
    L12:
        if (this.mTempRect != null) goto L14;
        this.mTempPaint = new Paint();
        this.mTempRect = new Rect();
        this.mTempPaint.set(this.mPaint);
        this.paintTextSize = this.mTempPaint.getTextSize();
    L14:
        this.mFloatWidth = r6;
        this.mFloatHeight = r7;
        Paint r13 = this.mTempPaint;
        String r14 = this.mText;
        r13.getTextBounds(r14, 0, r14.length(), this.mTempRect);
        int r15 = this.mTempRect.width();
        float r16 = this.mTempRect.height() * 1.3f;
        float r8 = (r6 - this.mPaddingRight) - this.mPaddingLeft;
        float r17 = (r7 - this.mPaddingBottom) - this.mPaddingTop;
        float r18 = r15;
        if ((r18 * r17) <= (r16 * r8)) goto L17;
        this.mPaint.setTextSize((this.paintTextSize * r8) / r18);
    L19:
        if (this.mUseOutline == true) goto L23;
        if (Float.isNaN(this.mBaseTextSize) == false) goto L23;
        return;
    L23:
        if (Float.isNaN(this.mBaseTextSize) == false) goto L25;
        float r19 = 1.0f;
    L26:
        buildShape(r19);
        return;
    L25:
        r19 = this.mTextSize / this.mBaseTextSize;
        goto L26
    L17:
        this.mPaint.setTextSize((this.paintTextSize * r17) / r16);
        goto L19
    L5:
        if (getMeasuredWidth() != r3) goto L8;
        super.layout(r1, r0, r2, r4);
        goto L10
    }

    public MotionLabel(Context r6, @Nullable AttributeSet r7) {
        super(r6, r7);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = 65535;
        this.mTextOutlineColor = 65535;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = BadgeDrawable.TOP_START;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r6, r7);
    }

    public MotionLabel(Context r5, @Nullable AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.mTextFillColor = 65535;
        this.mTextOutlineColor = 65535;
        this.mUseOutline = false;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mTextSize = 48.0f;
        this.mBaseTextSize = Float.NaN;
        this.mTextOutlineThickness = 0.0f;
        this.mText = "Hello World";
        this.mNotBuilt = true;
        this.mTextBounds = new Rect();
        this.mPaddingLeft = 1;
        this.mPaddingRight = 1;
        this.mPaddingTop = 1;
        this.mPaddingBottom = 1;
        this.mGravity = BadgeDrawable.TOP_START;
        this.mAutoSizeTextType = 0;
        this.mAutoSize = false;
        this.mTextureHeight = Float.NaN;
        this.mTextureWidth = Float.NaN;
        this.mTextPanX = 0.0f;
        this.mTextPanY = 0.0f;
        this.paintCache = new Paint();
        this.mTextureEffect = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(r5, r6);
    }
}
