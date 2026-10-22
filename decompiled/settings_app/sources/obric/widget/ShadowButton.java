package obric.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import obric.InvokeApi;
import smartisanos.util.Utils;

/* JADX INFO: loaded from: classes5.dex */
public class ShadowButton extends android.widget.Button {
    private static final int LONG_BUTTON = 2;
    private static final int SHADOW_SIZE = 6;
    private static final int SHRINK_LONG_BUTTON = 3;
    private static final int SMALL_BUTTON = 1;
    private static final int UNSET = 0;
    private static Bitmap[] mBackgroundShadow;
    private int mButtonStyle;
    private boolean mEnableShadow;
    private ColorStateList mHightLightColor;
    private final int[] mLongButtonBackgroundShadowIds;
    private ColorStateList mNormalColor;
    private OnDisabledClickListener mOnDisabledClickListener;
    private Paint mPaint;
    private ColorStateList mShadowColors;
    private float mShadowDx;
    private float mShadowDy;
    private ShadowDrawableHelper mShadowHelper;
    private float mShadowRadius;
    private final int[] mShrinkButtonBackgroundShadowIds;

    /* JADX INFO: renamed from: obric.widget.ShadowButton$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$obric$widget$ShadowButton$LongButtonStyle = null;
        static final /* synthetic */ int[] $SwitchMap$obric$widget$ShadowButton$SmallButtonStyle = null;

        static {
            int[] r0 = new int[SmallButtonStyle.values().length];
            $SwitchMap$obric$widget$ShadowButton$SmallButtonStyle = r0;
            r0[SmallButtonStyle.HIGH_LIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$obric$widget$ShadowButton$SmallButtonStyle[SmallButtonStyle.RED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            $SwitchMap$obric$widget$ShadowButton$SmallButtonStyle[SmallButtonStyle.STANDARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r3 = new int[LongButtonStyle.values().length];
            $SwitchMap$obric$widget$ShadowButton$LongButtonStyle = r3;
            r3[LongButtonStyle.HIGH_LIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$obric$widget$ShadowButton$LongButtonStyle[LongButtonStyle.RED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            $SwitchMap$obric$widget$ShadowButton$LongButtonStyle[LongButtonStyle.WHITE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            $SwitchMap$obric$widget$ShadowButton$LongButtonStyle[LongButtonStyle.GRAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    public static final enum LongButtonStyle extends Enum<LongButtonStyle> {
        private static final /* synthetic */ LongButtonStyle[] $VALUES = null;
        public static final LongButtonStyle GRAY = null;
        public static final LongButtonStyle HIGH_LIGHT = null;
        public static final LongButtonStyle RED = null;
        public static final LongButtonStyle WHITE = null;

        private LongButtonStyle(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static LongButtonStyle valueOf(String name) {
            return (LongButtonStyle) Enum.valueOf(LongButtonStyle.class, name);
        }

        public static LongButtonStyle[] values() {
            return (LongButtonStyle[]) $VALUES.clone();
        }

        static {
            LongButtonStyle r0 = new LongButtonStyle("HIGH_LIGHT", 0);
            HIGH_LIGHT = r0;
            LongButtonStyle r1 = new LongButtonStyle("RED", 1);
            RED = r1;
            LongButtonStyle r3 = new LongButtonStyle("WHITE", 2);
            WHITE = r3;
            LongButtonStyle r5 = new LongButtonStyle("GRAY", 3);
            GRAY = r5;
            $VALUES = new LongButtonStyle[]{r0, r1, r3, r5};
        }
    }

    public interface OnDisabledClickListener {
        void onDisabledClick();
    }

    public static final enum SmallButtonStyle extends Enum<SmallButtonStyle> {
        private static final /* synthetic */ SmallButtonStyle[] $VALUES = null;
        public static final SmallButtonStyle HIGH_LIGHT = null;
        public static final SmallButtonStyle RED = null;
        public static final SmallButtonStyle STANDARD = null;

        private SmallButtonStyle(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static SmallButtonStyle valueOf(String name) {
            return (SmallButtonStyle) Enum.valueOf(SmallButtonStyle.class, name);
        }

        public static SmallButtonStyle[] values() {
            return (SmallButtonStyle[]) $VALUES.clone();
        }

        static {
            SmallButtonStyle r0 = new SmallButtonStyle("HIGH_LIGHT", 0);
            HIGH_LIGHT = r0;
            SmallButtonStyle r1 = new SmallButtonStyle("RED", 1);
            RED = r1;
            SmallButtonStyle r3 = new SmallButtonStyle("STANDARD", 2);
            STANDARD = r3;
            $VALUES = new SmallButtonStyle[]{r0, r1, r3};
        }
    }

    public ShadowButton(Context context) {
        this(context, null);
    }

    public ShadowButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.buttonStyle);
    }

    public ShadowButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ShadowButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mEnableShadow = true;
        this.mPaint = new Paint(-16777216);
        this.mLongButtonBackgroundShadowIds = new int[]{R.drawable.long_btn_shadow_normal, R.drawable.long_btn_shadow_pressed, R.drawable.long_btn_shadow_disable};
        this.mShrinkButtonBackgroundShadowIds = new int[]{R.drawable.shrink_long_btn_shadow_normal, R.drawable.shrink_long_btn_shadow_pressed, R.drawable.shrink_long_btn_shadow_disable};
        TypedArray r6 = context.obtainStyledAttributes(attrs, R.styleable.ShadowButton, defStyleAttr, 0);
        this.mShadowColors = r6.getColorStateList(R.styleable.ShadowButton_shadowColors);
        this.mShadowDx = r6.getFloat(R.styleable.ShadowButton_android_shadowDx, 0.0f);
        this.mShadowDy = r6.getFloat(R.styleable.ShadowButton_android_shadowDy, 0.0f);
        this.mShadowRadius = r6.getFloat(R.styleable.ShadowButton_android_shadowRadius, 0.0f);
        r6.getResourceId(R.styleable.ShadowButton_backgroundShadow, -1);
        this.mButtonStyle = r6.getInt(R.styleable.ShadowButton_shadowButtonStyle, 0);
        r6.recycle();
        this.mShadowHelper = new ShadowDrawableHelper(this, attrs, defStyleAttr);
        ShadowTextView.updateTextShadow(this, this.mShadowColors, this.mShadowRadius, this.mShadowDx, this.mShadowDy);
        boolean r7 = this.mShadowHelper.hasNewShadowFeature();
        if (useOldShadow() == false) goto L5;
        initBitmap();
        updateShadow(isEnabled(), false);
    L5:
        if (r7 == true) goto L7;
    L9:
        setEnabled(isEnabled());
        this.mNormalColor = getResources().getColorStateList(R.color.small_button_standard_text_color);
        this.mHightLightColor = getResources().getColorStateList(R.color.highlight_button_text_colors);
        limitMaxSizeIfNeed();
        return;
    L7:
        if (getBackground() == null) goto L9;
        setBackground(getBackground());
        goto L9
    }

    private void updateShadow(boolean enabled, boolean pressed) {
        Bitmap r8 = getBitmap(enabled, pressed);     // Catch: Exception -> L7
        if (r8 != null) goto L5;
        return;
    L5:
        NinePatch r1 = new NinePatch(r8, r8.getNinePatchChunk());     // Catch: Exception -> L7
        int r9 = getResources().getDimensionPixelOffset(R.dimen.shadow_button_bg_shadow_left_gap);     // Catch: Exception -> L7
        float r5 = r9;
        float r6 = getResources().getDimensionPixelOffset(R.dimen.shadow_button_bg_shadow_top_gap);     // Catch: Exception -> L7
        InvokeApi.xView.setShadowProperty(this, r1, this.mPaint, r5, r6, r5, r6);     // Catch: Exception -> L7
        setElevation(0.1f);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    private void initBitmap() {
        int r0 = this.mButtonStyle;
        if (r0 == 2) goto L7;
        if (r0 == 3) goto L7;
        return;
    L7:
        if (mBackgroundShadow != null) goto L9;
        mBackgroundShadow = new Bitmap[6];
    L9:
        if (r0 != 2) goto L11;
        int[] r1 = this.mLongButtonBackgroundShadowIds;
    L12:
        int r3 = r1.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L18;
        int r5 = (this.mButtonStyle - 2) * 3;
        Bitmap[] r6 = mBackgroundShadow;
        int r7 = r5 + r4;
        if (r6[r7] != null) goto L17;
        r6[r7] = BitmapFactory.decodeResource(getResources(), r1[r4]);
    L17:
        r4 = r4 + 1;
        goto L13
    L18:
        return;
    L11:
        r1 = this.mShrinkButtonBackgroundShadowIds;
        goto L12
    }

    private Bitmap getBitmap(boolean r3, boolean r4) {
        int r2 = this.mButtonStyle;
        if (r2 == 2) goto L7;
        if (r2 == 3) goto L7;
        return null;
    L7:
        int r5 = (r2 - 2) * 3;
        int r6 = (r4 ? 1 : 0) + r5;
        if (r3 == true) goto L11;
        r6 = r5 + 2;
    L11:
        return mBackgroundShadow[r6];
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (useOldShadow() == false) goto L6;
        updateShadow(isEnabled(), pressed);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (useOldShadow() == false) goto L6;
        updateShadow(enabled, isPressed());
        return;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        super.setText(text, type);
        limitMaxSizeIfNeed();
    }

    private void limitMaxSizeIfNeed() {
        int r0 = this.mButtonStyle;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r0 == 1) goto L10;
        Utils.resetTextViewFontSizeAttr(getContext(), this, R.dimen.semi_large_text_size);
        return;
    }

    public void setShadowColors(ColorStateList shadowColors, float radius, float dx, float dy) {
        this.mShadowColors = shadowColors;
        this.mShadowRadius = radius;
        this.mShadowDx = dx;
        this.mShadowDy = dy;
        ShadowTextView.updateTextShadow(this, shadowColors, radius, dx, dy);
    }

    public void setShadowEnable(boolean enable) {
        this.mEnableShadow = enable;
        refreshDrawableState();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mEnableShadow == false) goto L5;
        ShadowTextView.updateTextShadow(this, this.mShadowColors, this.mShadowRadius, this.mShadowDx, this.mShadowDy);
        return;
    L5:
        ShadowTextView.updateTextShadow(this, this.mShadowColors, 0.0f, 0.0f, 0.0f);
    }

    public void updateBackgroundStyle(LongButtonStyle style) {
        if (style != null) goto L4;
        return;
    L4:
        boolean r1 = false;
        if (this.mButtonStyle != 3) goto L7;
        boolean r0 = true;
    L8:
        ColorStateList r4 = this.mHightLightColor;
        int r7 = AnonymousClass1.$SwitchMap$obric$widget$ShadowButton$LongButtonStyle[style.ordinal()];
        if (r7 != 1) goto L11;
        if (r0 == false) goto L29;
        int r8 = R.drawable.shrink_long_btn_highlight_selector;
    L16:
        r1 = true;
    L30:
        if (r8 <= 0) goto L33;
        setBackgroundResource(r8);
        setTextColor(r4);
        setShadowEnable(r1);
        return;
    L33:
        return;
    L29:
        r8 = R.drawable.selector_long_btn_highlight;
        goto L16
    L11:
        if (r7 == 2) goto L24;
        if (r7 != 3) goto L14;
        if (r0 == false) goto L22;
        r8 = R.drawable.shrink_long_btn_white_selector;
    L23:
        r4 = this.mNormalColor;
        goto L30
    L22:
        r8 = R.drawable.selector_long_btn_white;
        goto L23
    L14:
        if (r7 == 4) goto L17;
        r8 = -1;
        goto L16
    L17:
        if (r0 == false) goto L19;
        r8 = R.drawable.shrink_long_btn_gray_selector;
        goto L16
    L19:
        r8 = R.drawable.selector_long_btn_gray;
        goto L16
    L24:
        if (r0 == false) goto L26;
        r8 = R.drawable.shrink_long_btn_red_selector;
        goto L16
    L26:
        r8 = R.drawable.selector_long_btn_red;
        goto L16
    L7:
        r0 = false;
        goto L8
    }

    public void updateBackgroundStyle(SmallButtonStyle style) {
        if (style != null) goto L4;
        return;
    L4:
        ColorStateList r0 = this.mHightLightColor;
        int r3 = AnonymousClass1.$SwitchMap$obric$widget$ShadowButton$SmallButtonStyle[style.ordinal()];
        if (r3 != 1) goto L7;
        int r4 = R.drawable.selector_small_btn_highlight;
    L14:
        if (r4 <= 0) goto L17;
        setBackgroundResource(r4);
        setTextColor(r0);
        return;
    L17:
        return;
    L7:
        if (r3 != 2) goto L9;
        r4 = R.drawable.selector_small_btn_highlight_red;
        goto L14
    L9:
        if (r3 == 3) goto L11;
        r4 = -1;
        goto L14
    L11:
        r4 = R.drawable.selector_small_btn_standard;
        r0 = this.mNormalColor;
        goto L14
    }

    public void setOnDisabledClickListener(OnDisabledClickListener disabledClickListener) {
        this.mOnDisabledClickListener = disabledClickListener;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (shouldHandleDisabledTouchEvent(event) == false) goto L11;
        if (event.getAction() != 1) goto L9;
        OnDisabledClickListener r1 = this.mOnDisabledClickListener;
        if (r1 == null) goto L9;
        r1.onDisabledClick();
    L9:
        return true;
    L11:
        return super.onTouchEvent(event);
    }

    private boolean shouldHandleDisabledTouchEvent(MotionEvent event) {
        if (isEnabled() == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        Rect r1 = new Rect();
        getGlobalVisibleRect(r1);
        return r1.contains((int) event.getRawX(), (int) event.getRawY());
    L11:
        return false;
    L5:
        if (this.mOnDisabledClickListener == null) goto L7;
        r0 = true;
        goto L8
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        if (this.mButtonStyle != 2) goto L5;
        int r0 = R.drawable.shadow_button_long_shadow_selector;
    L6:
        ShadowDrawableHelper r1 = this.mShadowHelper;
        if (r1 != null) goto L9;
    L15:
        super.setBackground(background);
        return;
    L9:
        if (r1.hasNewShadowFeature() == false) goto L15;
        if (validShadowStyle() == false) goto L15;
        if (this.mShadowHelper.setBackground(background, r0) == false) goto L15;
        return;
    L5:
        r0 = R.drawable.shadow_button_shrink_shadow_selector;
        goto L6
    }

    public void setShadowEnabled(boolean enabled) {
        this.mShadowHelper.setShadowEnabled(enabled);
    }

    public void setShadowShouldProjects(boolean shouldProjects) {
        this.mShadowHelper.setShadowShouldProjects(shouldProjects);
    }

    private boolean validShadowStyle() {
        int r1 = this.mButtonStyle;
        if (r1 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 3) goto L8;
        return false;
    }

    private boolean useOldShadow() {
        ShadowDrawableHelper r0 = this.mShadowHelper;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isShadowEnabled() == false) goto L9;
        if (this.mShadowHelper.hasNewShadowFeature() == true) goto L9;
        return true;
    }
}
