package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int BADGE_NUMBER_NONE = -1;
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;

    @StyleRes
    private static final int DEFAULT_STYLE = 0;

    @AttrRes
    private static final int DEFAULT_THEME_ATTR = 0;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;

    @Nullable
    private WeakReference<View> anchorViewRef;

    @NonNull
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private final float badgeRadius;
    private final float badgeWidePadding;
    private final float badgeWithTextRadius;

    @NonNull
    private final WeakReference<Context> contextRef;
    private float cornerRadius;

    @Nullable
    private WeakReference<ViewGroup> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;

    @NonNull
    private final SavedState savedState;

    @NonNull
    private final MaterialShapeDrawable shapeDrawable;

    @NonNull
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        private int alpha;

        @ColorInt
        private int backgroundColor;
        private int badgeGravity;

        @ColorInt
        private int badgeTextColor;

        @StringRes
        private int contentDescriptionExceedsMaxBadgeNumberRes;

        @Nullable
        private CharSequence contentDescriptionNumberless;

        @PluralsRes
        private int contentDescriptionQuantityStrings;

        @Dimension(unit = 1)
        private int horizontalOffset;
        private int maxCharacterCount;
        private int number;

        @Dimension(unit = 1)
        private int verticalOffset;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Context r3) {
            this.alpha = 255;
            this.number = -1;
            this.badgeTextColor = new TextAppearance(r3, R.style.TextAppearance_MaterialComponents_Badge).textColor.getDefaultColor();
            this.contentDescriptionNumberless = r3.getString(R.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R.plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.mtrl_exceed_max_badge_number_content_description;
        }

        public static /* synthetic */ int access$000(SavedState r0) {
            return r0.maxCharacterCount;
        }

        public static /* synthetic */ int access$002(SavedState r0, int r1) {
            r0.maxCharacterCount = r1;
            return r1;
        }

        public static /* synthetic */ int access$100(SavedState r0) {
            return r0.number;
        }

        public static /* synthetic */ int access$1000(SavedState r0) {
            return r0.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        public static /* synthetic */ int access$1002(SavedState r0, int r1) {
            r0.contentDescriptionExceedsMaxBadgeNumberRes = r1;
            return r1;
        }

        public static /* synthetic */ int access$102(SavedState r0, int r1) {
            r0.number = r1;
            return r1;
        }

        public static /* synthetic */ int access$200(SavedState r0) {
            return r0.backgroundColor;
        }

        public static /* synthetic */ int access$202(SavedState r0, int r1) {
            r0.backgroundColor = r1;
            return r1;
        }

        public static /* synthetic */ int access$300(SavedState r0) {
            return r0.badgeTextColor;
        }

        public static /* synthetic */ int access$302(SavedState r0, int r1) {
            r0.badgeTextColor = r1;
            return r1;
        }

        public static /* synthetic */ int access$400(SavedState r0) {
            return r0.badgeGravity;
        }

        public static /* synthetic */ int access$402(SavedState r0, int r1) {
            r0.badgeGravity = r1;
            return r1;
        }

        public static /* synthetic */ int access$500(SavedState r0) {
            return r0.horizontalOffset;
        }

        public static /* synthetic */ int access$502(SavedState r0, int r1) {
            r0.horizontalOffset = r1;
            return r1;
        }

        public static /* synthetic */ int access$600(SavedState r0) {
            return r0.verticalOffset;
        }

        public static /* synthetic */ int access$602(SavedState r0, int r1) {
            r0.verticalOffset = r1;
            return r1;
        }

        public static /* synthetic */ int access$700(SavedState r0) {
            return r0.alpha;
        }

        public static /* synthetic */ int access$702(SavedState r0, int r1) {
            r0.alpha = r1;
            return r1;
        }

        public static /* synthetic */ CharSequence access$800(SavedState r0) {
            return r0.contentDescriptionNumberless;
        }

        public static /* synthetic */ CharSequence access$802(SavedState r0, CharSequence r1) {
            r0.contentDescriptionNumberless = r1;
            return r1;
        }

        public static /* synthetic */ int access$900(SavedState r0) {
            return r0.contentDescriptionQuantityStrings;
        }

        public static /* synthetic */ int access$902(SavedState r0, int r1) {
            r0.contentDescriptionQuantityStrings = r1;
            return r1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            r1.writeInt(this.backgroundColor);
            r1.writeInt(this.badgeTextColor);
            r1.writeInt(this.alpha);
            r1.writeInt(this.number);
            r1.writeInt(this.maxCharacterCount);
            r1.writeString(this.contentDescriptionNumberless.toString());
            r1.writeInt(this.contentDescriptionQuantityStrings);
            r1.writeInt(this.badgeGravity);
            r1.writeInt(this.horizontalOffset);
            r1.writeInt(this.verticalOffset);
        }

        public SavedState(@NonNull Parcel r2) {
            this.alpha = 255;
            this.number = -1;
            this.backgroundColor = r2.readInt();
            this.badgeTextColor = r2.readInt();
            this.alpha = r2.readInt();
            this.number = r2.readInt();
            this.maxCharacterCount = r2.readInt();
            this.contentDescriptionNumberless = r2.readString();
            this.contentDescriptionQuantityStrings = r2.readInt();
            this.badgeGravity = r2.readInt();
            this.horizontalOffset = r2.readInt();
            this.verticalOffset = r2.readInt();
        }
    }

    static {
        DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
        DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    }

    private BadgeDrawable(@NonNull Context r3) {
        this.contextRef = new WeakReference(r3);
        ThemeEnforcement.checkMaterialTheme(r3);
        Resources r0 = r3.getResources();
        this.badgeBounds = new Rect();
        this.shapeDrawable = new MaterialShapeDrawable();
        this.badgeRadius = r0.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.badgeWidePadding = r0.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = r0.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        TextDrawableHelper r1 = new TextDrawableHelper(this);
        this.textDrawableHelper = r1;
        r1.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.savedState = new SavedState(r3);
        setTextAppearanceResource(R.style.TextAppearance_MaterialComponents_Badge);
    }

    private void calculateCenterAndBounds(@NonNull Context r4, @NonNull Rect r5, @NonNull View r6) {
        int r0 = SavedState.access$400(this.savedState);
        if (r0 != 8388691) goto L5;
    L7:
        this.badgeCenterY = r5.bottom - SavedState.access$600(this.savedState);
    L9:
        if (getNumber() <= 9) goto L11;
        float r1 = this.badgeWithTextRadius;
        this.cornerRadius = r1;
        this.halfBadgeHeight = r1;
        this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
    L16:
        Resources r7 = r4.getResources();
        if (hasNumber() == false) goto L19;
        int r2 = R.dimen.mtrl_badge_text_horizontal_edge_offset;
    L20:
        int r8 = r7.getDimensionPixelSize(r2);
        int r3 = SavedState.access$400(this.savedState);
        if (r3 == 8388659) goto L29;
        if (r3 == 8388691) goto L29;
        if (ViewCompat.getLayoutDirection(r6) != 0) goto L26;
        float r9 = ((r5.right + this.halfBadgeWidth) - r8) - SavedState.access$500(this.savedState);
    L27:
        this.badgeCenterX = r9;
        return;
    L26:
        r9 = ((r5.left - this.halfBadgeWidth) + r8) + SavedState.access$500(this.savedState);
    L29:
        if (ViewCompat.getLayoutDirection(r6) != 0) goto L31;
        float r10 = ((r5.left - this.halfBadgeWidth) + r8) + SavedState.access$500(this.savedState);
    L32:
        this.badgeCenterX = r10;
        return;
    L31:
        r10 = ((r5.right + this.halfBadgeWidth) - r8) - SavedState.access$500(this.savedState);
        goto L32
    L19:
        r2 = R.dimen.mtrl_badge_horizontal_edge_offset;
        goto L20
    L11:
        if (hasNumber() == true) goto L13;
        float r11 = this.badgeRadius;
    L14:
        this.cornerRadius = r11;
        this.halfBadgeHeight = r11;
        this.halfBadgeWidth = r11;
        goto L16
    L13:
        r11 = this.badgeWithTextRadius;
        goto L14
    L5:
        if (r0 == 8388693) goto L7;
        this.badgeCenterY = SavedState.access$600(this.savedState) + r5.top;
        goto L9
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context r3) {
        return createFromAttributes(r3, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    @NonNull
    private static BadgeDrawable createFromAttributes(@NonNull Context r1, AttributeSet r2, @AttrRes int r3, @StyleRes int r4) {
        BadgeDrawable r0 = new BadgeDrawable(r1);
        r0.loadDefaultStateFromAttributes(r1, r2, r3, r4);
        return r0;
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context r2, @XmlRes int r3) {
        AttributeSet r4 = DrawableUtils.parseDrawableXml(r2, r3, "badge");
        int r0 = r4.getStyleAttribute();
        if (r0 != 0) goto L6;
        r0 = DEFAULT_STYLE;
    L6:
        return createFromAttributes(r2, r4, DEFAULT_THEME_ATTR, r0);
    }

    @NonNull
    public static BadgeDrawable createFromSavedState(@NonNull Context r1, @NonNull SavedState r2) {
        BadgeDrawable r0 = new BadgeDrawable(r1);
        r0.restoreFromSavedState(r2);
        return r0;
    }

    private void drawText(Canvas r6) {
        Rect r0 = new Rect();
        String r1 = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(r1, 0, r1.length(), r0);
        r6.drawText(r1, this.badgeCenterX, this.badgeCenterY + (r0.height() / 2), this.textDrawableHelper.getTextPaint());
    }

    @NonNull
    private String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) goto L5;
        Context r0 = this.contextRef.get();
        if (r0 != null) goto L11;
        return "";
    L11:
        return r0.getString(R.string.mtrl_exceed_max_badge_number_suffix, new Object[]{Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
    L5:
        return Integer.toString(getNumber());
    }

    private void loadDefaultStateFromAttributes(Context r8, AttributeSet r9, @AttrRes int r10, @StyleRes int r11) {
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r8, r9, R.styleable.Badge, r10, r11, new int[0]);
        setMaxCharacterCount(r12.getInt(R.styleable.Badge_maxCharacterCount, 4));
        if (r12.hasValue(R.styleable.Badge_number) == false) goto L5;
        setNumber(r12.getInt(R.styleable.Badge_number, 0));
    L5:
        setBackgroundColor(readColorFromAttributes(r8, r12, R.styleable.Badge_backgroundColor));
        if (r12.hasValue(R.styleable.Badge_badgeTextColor) == false) goto L8;
        setBadgeTextColor(readColorFromAttributes(r8, r12, R.styleable.Badge_badgeTextColor));
    L8:
        setBadgeGravity(r12.getInt(R.styleable.Badge_badgeGravity, TOP_END));
        setHorizontalOffset(r12.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        setVerticalOffset(r12.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        r12.recycle();
    }

    private static int readColorFromAttributes(Context r0, @NonNull TypedArray r1, @StyleableRes int r2) {
        return MaterialResources.getColorStateList(r0, r1, r2).getDefaultColor();
    }

    private void restoreFromSavedState(@NonNull SavedState r3) {
        setMaxCharacterCount(SavedState.access$000(r3));
        if (SavedState.access$100(r3) == (-1)) goto L5;
        setNumber(SavedState.access$100(r3));
    L5:
        setBackgroundColor(SavedState.access$200(r3));
        setBadgeTextColor(SavedState.access$300(r3));
        setBadgeGravity(SavedState.access$400(r3));
        setHorizontalOffset(SavedState.access$500(r3));
        setVerticalOffset(SavedState.access$600(r3));
    }

    private void setTextAppearance(@Nullable TextAppearance r3) {
        if (this.textDrawableHelper.getTextAppearance() != r3) goto L5;
        return;
    L5:
        Context r0 = this.contextRef.get();
        if (r0 != null) goto L8;
        return;
    L8:
        this.textDrawableHelper.setTextAppearance(r3, r0);
        updateCenterAndBounds();
    }

    private void setTextAppearanceResource(@StyleRes int r3) {
        Context r0 = this.contextRef.get();
        if (r0 != null) goto L5;
        return;
    L5:
        setTextAppearance(new TextAppearance(r0, r3));
    }

    private void updateCenterAndBounds() {
        Context r0 = this.contextRef.get();
        WeakReference<View> r1 = this.anchorViewRef;
        ViewGroup r2 = null;
        if (r1 == null) goto L5;
        View r3 = r1.get();
    L6:
        if (r0 == null) goto L22;
        if (r3 == null) goto L24;
        Rect r4 = new Rect();
        r4.set(this.badgeBounds);
        Rect r5 = new Rect();
        r3.getDrawingRect(r5);
        WeakReference<ViewGroup> r6 = this.customBadgeParentRef;
        if (r6 == null) goto L12;
        r2 = r6.get();
    L12:
        if (r2 == null) goto L14;
    L15:
        if (r2 != null) goto L17;
        r2 = (ViewGroup) r3.getParent();
    L17:
        r2.offsetDescendantRectToMyCoords(r3, r5);
    L18:
        calculateCenterAndBounds(r0, r5, r3);
        BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        this.shapeDrawable.setCornerSize(this.cornerRadius);
        if (r4.equals(this.badgeBounds) == true) goto L23;
        this.shapeDrawable.setBounds(this.badgeBounds);
        return;
    L23:
        return;
    L14:
        if (BadgeUtils.USE_COMPAT_PARENT == false) goto L18;
    L24:
        return;
    L22:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private void updateMaxBadgeNumber() {
        this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
    }

    public void clearNumber() {
        SavedState.access$102(this.savedState, -1);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r2) {
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() != 0) goto L7;
        return;
    L7:
        if (isVisible() == false) goto L16;
        this.shapeDrawable.draw(r2);
        if (hasNumber() == false) goto L15;
        drawText(r2);
        return;
    L15:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return SavedState.access$700(this.savedState);
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return SavedState.access$400(this.savedState);
    }

    @ColorInt
    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    @Nullable
    public CharSequence getContentDescription() {
        if (isVisible() == true) goto L6;
        return null;
    L6:
        if (hasNumber() == false) goto L20;
        if (SavedState.access$900(this.savedState) <= 0) goto L18;
        Context r0 = this.contextRef.get();
        if (r0 != null) goto L13;
        return null;
    L13:
        if (getNumber() > this.maxBadgeNumber) goto L17;
        return r0.getResources().getQuantityString(SavedState.access$900(this.savedState), getNumber(), new Object[]{Integer.valueOf(getNumber())});
    L17:
        return r0.getString(SavedState.access$1000(this.savedState), new Object[]{Integer.valueOf(this.maxBadgeNumber)});
    L18:
        return null;
    L20:
        return SavedState.access$800(this.savedState);
    }

    public int getHorizontalOffset() {
        return SavedState.access$500(this.savedState);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public int getMaxCharacterCount() {
        return SavedState.access$000(this.savedState);
    }

    public int getNumber() {
        if (hasNumber() == true) goto L7;
        return 0;
    L7:
        return SavedState.access$100(this.savedState);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @NonNull
    public SavedState getSavedState() {
        return this.savedState;
    }

    public int getVerticalOffset() {
        return SavedState.access$600(this.savedState);
    }

    public boolean hasNumber() {
        if (SavedState.access$100(this.savedState) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] r1) {
        return super.onStateChange(r1);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        SavedState.access$702(this.savedState, r2);
        this.textDrawableHelper.getTextPaint().setAlpha(r2);
        invalidateSelf();
    }

    public void setBackgroundColor(@ColorInt int r2) {
        SavedState.access$202(this.savedState, r2);
        ColorStateList r3 = ColorStateList.valueOf(r2);
        if (this.shapeDrawable.getFillColor() == r3) goto L6;
        this.shapeDrawable.setFillColor(r3);
        invalidateSelf();
        return;
    }

    public void setBadgeGravity(int r2) {
        if (SavedState.access$400(this.savedState) == r2) goto L14;
        SavedState.access$402(this.savedState, r2);
        WeakReference<View> r3 = this.anchorViewRef;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.get() == null) goto L16;
        View r4 = this.anchorViewRef.get();
        WeakReference<ViewGroup> r0 = this.customBadgeParentRef;
        if (r0 == null) goto L11;
        ViewGroup r1 = r0.get();
    L12:
        updateBadgeCoordinates(r4, r1);
        return;
    L11:
        r1 = null;
        goto L12
    L16:
        return;
    }

    public void setBadgeTextColor(@ColorInt int r2) {
        SavedState.access$302(this.savedState, r2);
        if (this.textDrawableHelper.getTextPaint().getColor() == r2) goto L6;
        this.textDrawableHelper.getTextPaint().setColor(r2);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int r1) {
        SavedState.access$1002(this.savedState, r1);
    }

    public void setContentDescriptionNumberless(CharSequence r1) {
        SavedState.access$802(this.savedState, r1);
    }

    public void setContentDescriptionQuantityStringsResource(@StringRes int r1) {
        SavedState.access$902(this.savedState, r1);
    }

    public void setHorizontalOffset(int r2) {
        SavedState.access$502(this.savedState, r2);
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int r2) {
        if (SavedState.access$000(this.savedState) == r2) goto L6;
        SavedState.access$002(this.savedState, r2);
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
        return;
    }

    public void setNumber(int r2) {
        int r3 = Math.max(0, r2);
        if (SavedState.access$100(this.savedState) == r3) goto L6;
        SavedState.access$102(this.savedState, r3);
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
        return;
    }

    public void setVerticalOffset(int r2) {
        SavedState.access$602(this.savedState, r2);
        updateCenterAndBounds();
    }

    public void setVisible(boolean r2) {
        setVisible(r2, false);
    }

    public void updateBadgeCoordinates(@NonNull View r2, @Nullable ViewGroup r3) {
        this.anchorViewRef = new WeakReference(r2);
        this.customBadgeParentRef = new WeakReference(r3);
        updateCenterAndBounds();
        invalidateSelf();
    }
}
