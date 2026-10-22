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
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
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
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes2.dex */
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
    private float badgeRadius;
    private float badgeWidePadding;
    private float badgeWithTextRadius;

    @NonNull
    private final WeakReference<Context> contextRef;
    private float cornerRadius;

    @Nullable
    private WeakReference<FrameLayout> customBadgeParentRef;
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

        @Dimension(unit = 1)
        private int additionalHorizontalOffset;

        @Dimension(unit = 1)
        private int additionalVerticalOffset;
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
        private int horizontalOffsetWithText;

        @Dimension(unit = 1)
        private int horizontalOffsetWithoutText;
        private boolean isVisible;
        private int maxCharacterCount;
        private int number;

        @Dimension(unit = 1)
        private int verticalOffsetWithText;

        @Dimension(unit = 1)
        private int verticalOffsetWithoutText;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Context r3) {
            this.alpha = 255;
            this.number = -1;
            this.badgeTextColor = new TextAppearance(r3, R.style.TextAppearance_MaterialComponents_Badge).getTextColor().getDefaultColor();
            this.contentDescriptionNumberless = r3.getString(R.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R.plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        protected SavedState(@NonNull Parcel r2) {
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
            this.horizontalOffsetWithoutText = r2.readInt();
            this.verticalOffsetWithoutText = r2.readInt();
            this.horizontalOffsetWithText = r2.readInt();
            this.verticalOffsetWithText = r2.readInt();
            this.additionalHorizontalOffset = r2.readInt();
            this.additionalVerticalOffset = r2.readInt();
            if (r2.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            this.isVisible = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }

        static /* synthetic */ boolean access$000(SavedState r0) {
            return r0.isVisible;
        }

        static /* synthetic */ boolean access$002(SavedState r0, boolean r1) {
            r0.isVisible = r1;
            return r1;
        }

        static /* synthetic */ int access$100(SavedState r0) {
            return r0.maxCharacterCount;
        }

        static /* synthetic */ int access$1000(SavedState r0) {
            return r0.additionalHorizontalOffset;
        }

        static /* synthetic */ int access$1002(SavedState r0, int r1) {
            r0.additionalHorizontalOffset = r1;
            return r1;
        }

        static /* synthetic */ int access$102(SavedState r0, int r1) {
            r0.maxCharacterCount = r1;
            return r1;
        }

        static /* synthetic */ int access$1100(SavedState r0) {
            return r0.additionalVerticalOffset;
        }

        static /* synthetic */ int access$1102(SavedState r0, int r1) {
            r0.additionalVerticalOffset = r1;
            return r1;
        }

        static /* synthetic */ int access$1200(SavedState r0) {
            return r0.alpha;
        }

        static /* synthetic */ int access$1202(SavedState r0, int r1) {
            r0.alpha = r1;
            return r1;
        }

        static /* synthetic */ CharSequence access$1300(SavedState r0) {
            return r0.contentDescriptionNumberless;
        }

        static /* synthetic */ CharSequence access$1302(SavedState r0, CharSequence r1) {
            r0.contentDescriptionNumberless = r1;
            return r1;
        }

        static /* synthetic */ int access$1400(SavedState r0) {
            return r0.contentDescriptionQuantityStrings;
        }

        static /* synthetic */ int access$1402(SavedState r0, int r1) {
            r0.contentDescriptionQuantityStrings = r1;
            return r1;
        }

        static /* synthetic */ int access$1500(SavedState r0) {
            return r0.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        static /* synthetic */ int access$1502(SavedState r0, int r1) {
            r0.contentDescriptionExceedsMaxBadgeNumberRes = r1;
            return r1;
        }

        static /* synthetic */ int access$200(SavedState r0) {
            return r0.number;
        }

        static /* synthetic */ int access$202(SavedState r0, int r1) {
            r0.number = r1;
            return r1;
        }

        static /* synthetic */ int access$300(SavedState r0) {
            return r0.backgroundColor;
        }

        static /* synthetic */ int access$302(SavedState r0, int r1) {
            r0.backgroundColor = r1;
            return r1;
        }

        static /* synthetic */ int access$400(SavedState r0) {
            return r0.badgeTextColor;
        }

        static /* synthetic */ int access$402(SavedState r0, int r1) {
            r0.badgeTextColor = r1;
            return r1;
        }

        static /* synthetic */ int access$500(SavedState r0) {
            return r0.badgeGravity;
        }

        static /* synthetic */ int access$502(SavedState r0, int r1) {
            r0.badgeGravity = r1;
            return r1;
        }

        static /* synthetic */ int access$600(SavedState r0) {
            return r0.horizontalOffsetWithoutText;
        }

        static /* synthetic */ int access$602(SavedState r0, int r1) {
            r0.horizontalOffsetWithoutText = r1;
            return r1;
        }

        static /* synthetic */ int access$700(SavedState r0) {
            return r0.verticalOffsetWithoutText;
        }

        static /* synthetic */ int access$702(SavedState r0, int r1) {
            r0.verticalOffsetWithoutText = r1;
            return r1;
        }

        static /* synthetic */ int access$800(SavedState r0) {
            return r0.horizontalOffsetWithText;
        }

        static /* synthetic */ int access$802(SavedState r0, int r1) {
            r0.horizontalOffsetWithText = r1;
            return r1;
        }

        static /* synthetic */ int access$900(SavedState r0) {
            return r0.verticalOffsetWithText;
        }

        static /* synthetic */ int access$902(SavedState r0, int r1) {
            r0.verticalOffsetWithText = r1;
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
            r1.writeInt(this.horizontalOffsetWithoutText);
            r1.writeInt(this.verticalOffsetWithoutText);
            r1.writeInt(this.horizontalOffsetWithText);
            r1.writeInt(this.verticalOffsetWithText);
            r1.writeInt(this.additionalHorizontalOffset);
            r1.writeInt(this.additionalVerticalOffset);
            r1.writeInt(this.isVisible ? 1 : 0);
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

    private void calculateCenterAndBounds(@NonNull Context r5, @NonNull Rect r6, @NonNull View r7) {
        int r0 = getTotalVerticalOffsetForState();
        int r1 = SavedState.access$500(this.savedState);
        if (r1 != 8388691) goto L5;
    L8:
        int r2 = r6.bottom - r0;
    L7:
        this.badgeCenterY = r2;
        if (getNumber() <= 9) goto L12;
        float r3 = this.badgeWithTextRadius;
        this.cornerRadius = r3;
        this.halfBadgeHeight = r3;
        float r4 = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
    L17:
        this.halfBadgeWidth = r4;
        Resources r8 = r5.getResources();
        if (hasNumber() == false) goto L20;
        int r9 = R.dimen.mtrl_badge_text_horizontal_edge_offset;
    L21:
        int r10 = r8.getDimensionPixelSize(r9);
        int r11 = getTotalHorizontalOffsetForState();
        int r12 = SavedState.access$500(this.savedState);
        if (r12 == 8388659) goto L28;
        if (r12 == 8388691) goto L28;
        if (ViewCompat.getLayoutDirection(r7) == 0) goto L30;
    L29:
        float r13 = ((r6.left - this.halfBadgeWidth) + r10) + r11;
    L31:
        this.badgeCenterX = r13;
        return;
    L30:
        r13 = ((r6.right + this.halfBadgeWidth) - r10) - r11;
    L28:
        if (ViewCompat.getLayoutDirection(r7) != 0) goto L30;
    L20:
        r9 = R.dimen.mtrl_badge_horizontal_edge_offset;
        goto L21
    L12:
        if (hasNumber() == true) goto L14;
        r4 = this.badgeRadius;
    L15:
        this.cornerRadius = r4;
        this.halfBadgeHeight = r4;
        goto L17
    L14:
        r4 = this.badgeWithTextRadius;
        goto L15
    L5:
        if (r1 == 8388693) goto L8;
        r2 = r6.top + r0;
        goto L7
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
    static BadgeDrawable createFromSavedState(@NonNull Context r1, @NonNull SavedState r2) {
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
        return NumberFormat.getInstance().format(getNumber());
    }

    private int getTotalHorizontalOffsetForState() {
        if (hasNumber() == false) goto L5;
        int r0 = SavedState.access$800(this.savedState);
    L7:
        return r0 + SavedState.access$1000(this.savedState);
    L5:
        r0 = SavedState.access$600(this.savedState);
        goto L7
    }

    private int getTotalVerticalOffsetForState() {
        if (hasNumber() == false) goto L5;
        int r0 = SavedState.access$900(this.savedState);
    L7:
        return r0 + SavedState.access$1100(this.savedState);
    L5:
        r0 = SavedState.access$700(this.savedState);
        goto L7
    }

    private void loadDefaultStateFromAttributes(Context r8, AttributeSet r9, @AttrRes int r10, @StyleRes int r11) {
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r8, r9, R.styleable.Badge, r10, r11, new int[0]);
        setMaxCharacterCount(r12.getInt(R.styleable.Badge_maxCharacterCount, 4));
        int r13 = R.styleable.Badge_number;
        if (r12.hasValue(r13) == false) goto L5;
        setNumber(r12.getInt(r13, 0));
    L5:
        setBackgroundColor(readColorFromAttributes(r8, r12, R.styleable.Badge_backgroundColor));
        int r14 = R.styleable.Badge_badgeTextColor;
        if (r12.hasValue(r14) == false) goto L8;
        setBadgeTextColor(readColorFromAttributes(r8, r12, r14));
    L8:
        setBadgeGravity(r12.getInt(R.styleable.Badge_badgeGravity, TOP_END));
        setHorizontalOffsetWithoutText(r12.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        setVerticalOffsetWithoutText(r12.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        setHorizontalOffsetWithText(r12.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, getHorizontalOffsetWithoutText()));
        setVerticalOffsetWithText(r12.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, getVerticalOffsetWithoutText()));
        int r15 = R.styleable.Badge_badgeRadius;
        if (r12.hasValue(r15) == false) goto L11;
        this.badgeRadius = r12.getDimensionPixelSize(r15, (int) this.badgeRadius);
    L11:
        int r16 = R.styleable.Badge_badgeWidePadding;
        if (r12.hasValue(r16) == false) goto L14;
        this.badgeWidePadding = r12.getDimensionPixelSize(r16, (int) this.badgeWidePadding);
    L14:
        int r17 = R.styleable.Badge_badgeWithTextRadius;
        if (r12.hasValue(r17) == false) goto L17;
        this.badgeWithTextRadius = r12.getDimensionPixelSize(r17, (int) this.badgeWithTextRadius);
    L17:
        r12.recycle();
    }

    private static int readColorFromAttributes(Context r0, @NonNull TypedArray r1, @StyleableRes int r2) {
        return MaterialResources.getColorStateList(r0, r1, r2).getDefaultColor();
    }

    private void restoreFromSavedState(@NonNull SavedState r3) {
        setMaxCharacterCount(SavedState.access$100(r3));
        if (SavedState.access$200(r3) == (-1)) goto L5;
        setNumber(SavedState.access$200(r3));
    L5:
        setBackgroundColor(SavedState.access$300(r3));
        setBadgeTextColor(SavedState.access$400(r3));
        setBadgeGravity(SavedState.access$500(r3));
        setHorizontalOffsetWithoutText(SavedState.access$600(r3));
        setVerticalOffsetWithoutText(SavedState.access$700(r3));
        setHorizontalOffsetWithText(SavedState.access$800(r3));
        setVerticalOffsetWithText(SavedState.access$900(r3));
        setAdditionalHorizontalOffset(SavedState.access$1000(r3));
        setAdditionalVerticalOffset(SavedState.access$1100(r3));
        setVisible(SavedState.access$000(r3));
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

    private void tryWrapAnchorInCompatParent(final View r6) {
        ViewGroup r0 = (ViewGroup) r6.getParent();
        if (r0 != null) goto L5;
    L6:
        WeakReference<FrameLayout> r1 = this.customBadgeParentRef;
        if (r1 != null) goto L9;
    L11:
        updateAnchorParentToNotClip(r6);
        final FrameLayout r2 = new FrameLayout(r6.getContext());
        r2.setId(R.id.mtrl_anchor_parent);
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setLayoutParams(r6.getLayoutParams());
        r2.setMinimumWidth(r6.getWidth());
        r2.setMinimumHeight(r6.getHeight());
        int r3 = r0.indexOfChild(r6);
        r0.removeViewAt(r3);
        r6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r2.addView(r6);
        r0.addView(r2, r3);
        this.customBadgeParentRef = new WeakReference(r2);
        r2.post(new AnonymousClass1(this, r6, r2));
        return;
    L9:
        if (r1.get() != r0) goto L11;
        return;
    L5:
        if (r0.getId() != R.id.mtrl_anchor_parent) goto L6;
    }

    private static void updateAnchorParentToNotClip(View r1) {
        ViewGroup r2 = (ViewGroup) r1.getParent();
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
    }

    private void updateCenterAndBounds() {
        Context r0 = this.contextRef.get();
        WeakReference<View> r1 = this.anchorViewRef;
        FrameLayout r2 = null;
        if (r1 == null) goto L5;
        View r3 = r1.get();
    L6:
        if (r0 == null) goto L22;
        if (r3 == null) goto L24;
        Rect r4 = new Rect();
        r4.set(this.badgeBounds);
        Rect r5 = new Rect();
        r3.getDrawingRect(r5);
        WeakReference<FrameLayout> r6 = this.customBadgeParentRef;
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
        SavedState.access$202(this.savedState, -1);
        updateCenterAndBounds();
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

    int getAdditionalHorizontalOffset() {
        return SavedState.access$1000(this.savedState);
    }

    int getAdditionalVerticalOffset() {
        return SavedState.access$1100(this.savedState);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return SavedState.access$1200(this.savedState);
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return SavedState.access$500(this.savedState);
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
        if (SavedState.access$1400(this.savedState) <= 0) goto L18;
        Context r0 = this.contextRef.get();
        if (r0 != null) goto L13;
        return null;
    L13:
        if (getNumber() > this.maxBadgeNumber) goto L17;
        return r0.getResources().getQuantityString(SavedState.access$1400(this.savedState), getNumber(), new Object[]{Integer.valueOf(getNumber())});
    L17:
        return r0.getString(SavedState.access$1500(this.savedState), new Object[]{Integer.valueOf(this.maxBadgeNumber)});
    L18:
        return null;
    L20:
        return SavedState.access$1300(this.savedState);
    }

    @Nullable
    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> r0 = this.customBadgeParentRef;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public int getHorizontalOffset() {
        return SavedState.access$600(this.savedState);
    }

    @Px
    public int getHorizontalOffsetWithText() {
        return SavedState.access$800(this.savedState);
    }

    @Px
    public int getHorizontalOffsetWithoutText() {
        return SavedState.access$600(this.savedState);
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
        return SavedState.access$100(this.savedState);
    }

    public int getNumber() {
        if (hasNumber() == true) goto L7;
        return 0;
    L7:
        return SavedState.access$200(this.savedState);
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
        return SavedState.access$700(this.savedState);
    }

    @Px
    public int getVerticalOffsetWithText() {
        return SavedState.access$900(this.savedState);
    }

    @Px
    public int getVerticalOffsetWithoutText() {
        return SavedState.access$700(this.savedState);
    }

    public boolean hasNumber() {
        if (SavedState.access$200(this.savedState) == (-1)) goto L5;
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

    void setAdditionalHorizontalOffset(int r2) {
        SavedState.access$1002(this.savedState, r2);
        updateCenterAndBounds();
    }

    void setAdditionalVerticalOffset(int r2) {
        SavedState.access$1102(this.savedState, r2);
        updateCenterAndBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        SavedState.access$1202(this.savedState, r2);
        this.textDrawableHelper.getTextPaint().setAlpha(r2);
        invalidateSelf();
    }

    public void setBackgroundColor(@ColorInt int r2) {
        SavedState.access$302(this.savedState, r2);
        ColorStateList r3 = ColorStateList.valueOf(r2);
        if (this.shapeDrawable.getFillColor() == r3) goto L6;
        this.shapeDrawable.setFillColor(r3);
        invalidateSelf();
        return;
    }

    public void setBadgeGravity(int r2) {
        if (SavedState.access$500(this.savedState) == r2) goto L14;
        SavedState.access$502(this.savedState, r2);
        WeakReference<View> r3 = this.anchorViewRef;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.get() == null) goto L16;
        View r4 = this.anchorViewRef.get();
        WeakReference<FrameLayout> r0 = this.customBadgeParentRef;
        if (r0 == null) goto L11;
        FrameLayout r1 = r0.get();
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
        SavedState.access$402(this.savedState, r2);
        if (this.textDrawableHelper.getTextPaint().getColor() == r2) goto L6;
        this.textDrawableHelper.getTextPaint().setColor(r2);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int r1) {
        SavedState.access$1502(this.savedState, r1);
    }

    public void setContentDescriptionNumberless(CharSequence r1) {
        SavedState.access$1302(this.savedState, r1);
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int r1) {
        SavedState.access$1402(this.savedState, r1);
    }

    public void setHorizontalOffset(int r1) {
        setHorizontalOffsetWithoutText(r1);
        setHorizontalOffsetWithText(r1);
    }

    public void setHorizontalOffsetWithText(@Px int r2) {
        SavedState.access$802(this.savedState, r2);
        updateCenterAndBounds();
    }

    public void setHorizontalOffsetWithoutText(@Px int r2) {
        SavedState.access$602(this.savedState, r2);
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int r2) {
        if (SavedState.access$100(this.savedState) == r2) goto L6;
        SavedState.access$102(this.savedState, r2);
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
        return;
    }

    public void setNumber(int r2) {
        int r3 = Math.max(0, r2);
        if (SavedState.access$200(this.savedState) == r3) goto L6;
        SavedState.access$202(this.savedState, r3);
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
        return;
    }

    public void setVerticalOffset(int r1) {
        setVerticalOffsetWithoutText(r1);
        setVerticalOffsetWithText(r1);
    }

    public void setVerticalOffsetWithText(@Px int r2) {
        SavedState.access$902(this.savedState, r2);
        updateCenterAndBounds();
    }

    public void setVerticalOffsetWithoutText(@Px int r2) {
        SavedState.access$702(this.savedState, r2);
        updateCenterAndBounds();
    }

    public void setVisible(boolean r2) {
        setVisible(r2, false);
        SavedState.access$002(this.savedState, r2);
        if (BadgeUtils.USE_COMPAT_PARENT == true) goto L5;
        return;
    L5:
        if (getCustomBadgeParent() == null) goto L10;
        if (r2 == true) goto L11;
        ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
        return;
    L11:
        return;
    }

    public void updateBadgeCoordinates(@NonNull View r2) {
        updateBadgeCoordinates(r2, null);
    }

    @Deprecated
    public void updateBadgeCoordinates(@NonNull View r2, @Nullable ViewGroup r3) {
        if ((r3 instanceof FrameLayout) == false) goto L7;
        updateBadgeCoordinates(r2, (FrameLayout) r3);
        return;
    L7:
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(@NonNull View r3, @Nullable FrameLayout r4) {
        this.anchorViewRef = new WeakReference(r3);
        boolean r0 = BadgeUtils.USE_COMPAT_PARENT;
        if (r0 == false) goto L6;
        if (r4 != null) goto L6;
        tryWrapAnchorInCompatParent(r3);
    L7:
        if (r0 == true) goto L9;
        updateAnchorParentToNotClip(r3);
    L9:
        updateCenterAndBounds();
        invalidateSelf();
        return;
    L6:
        this.customBadgeParentRef = new WeakReference(r4);
        goto L7
    }
}
