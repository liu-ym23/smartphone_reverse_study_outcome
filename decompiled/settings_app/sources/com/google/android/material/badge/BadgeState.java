package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class BadgeState {
    private static final String BADGE_RESOURCE_TAG = "badge";
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;
    final float badgeRadius;
    final float badgeWidePadding;
    final float badgeWithTextRadius;
    private final State currentState;
    private final State overridingState;

    public static final class State implements Parcelable {
        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable.Creator<State> CREATOR = null;
        private static final int NOT_SET = -2;
        private Integer additionalHorizontalOffset;
        private Integer additionalVerticalOffset;
        private int alpha;
        private Integer backgroundColor;
        private Integer badgeGravity;
        private int badgeResId;
        private Integer badgeTextColor;
        private int contentDescriptionExceedsMaxBadgeNumberRes;
        private CharSequence contentDescriptionNumberless;
        private int contentDescriptionQuantityStrings;
        private Integer horizontalOffsetWithText;
        private Integer horizontalOffsetWithoutText;
        private Boolean isVisible;
        private int maxCharacterCount;
        private int number;
        private Locale numberLocale;
        private Integer verticalOffsetWithText;
        private Integer verticalOffsetWithoutText;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static /* synthetic */ int access$000(State r0) {
            return r0.badgeResId;
        }

        static /* synthetic */ int access$002(State r0, int r1) {
            r0.badgeResId = r1;
            return r1;
        }

        static /* synthetic */ int access$100(State r0) {
            return r0.alpha;
        }

        static /* synthetic */ Integer access$1000(State r0) {
            return r0.badgeGravity;
        }

        static /* synthetic */ Integer access$1002(State r0, Integer r1) {
            r0.badgeGravity = r1;
            return r1;
        }

        static /* synthetic */ int access$102(State r0, int r1) {
            r0.alpha = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1100(State r0) {
            return r0.horizontalOffsetWithoutText;
        }

        static /* synthetic */ Integer access$1102(State r0, Integer r1) {
            r0.horizontalOffsetWithoutText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1200(State r0) {
            return r0.verticalOffsetWithoutText;
        }

        static /* synthetic */ Integer access$1202(State r0, Integer r1) {
            r0.verticalOffsetWithoutText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1300(State r0) {
            return r0.horizontalOffsetWithText;
        }

        static /* synthetic */ Integer access$1302(State r0, Integer r1) {
            r0.horizontalOffsetWithText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1400(State r0) {
            return r0.verticalOffsetWithText;
        }

        static /* synthetic */ Integer access$1402(State r0, Integer r1) {
            r0.verticalOffsetWithText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1500(State r0) {
            return r0.additionalHorizontalOffset;
        }

        static /* synthetic */ Integer access$1502(State r0, Integer r1) {
            r0.additionalHorizontalOffset = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1600(State r0) {
            return r0.additionalVerticalOffset;
        }

        static /* synthetic */ Integer access$1602(State r0, Integer r1) {
            r0.additionalVerticalOffset = r1;
            return r1;
        }

        static /* synthetic */ Locale access$1700(State r0) {
            return r0.numberLocale;
        }

        static /* synthetic */ Locale access$1702(State r0, Locale r1) {
            r0.numberLocale = r1;
            return r1;
        }

        static /* synthetic */ CharSequence access$200(State r0) {
            return r0.contentDescriptionNumberless;
        }

        static /* synthetic */ CharSequence access$202(State r0, CharSequence r1) {
            r0.contentDescriptionNumberless = r1;
            return r1;
        }

        static /* synthetic */ int access$300(State r0) {
            return r0.contentDescriptionQuantityStrings;
        }

        static /* synthetic */ int access$302(State r0, int r1) {
            r0.contentDescriptionQuantityStrings = r1;
            return r1;
        }

        static /* synthetic */ int access$400(State r0) {
            return r0.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        static /* synthetic */ int access$402(State r0, int r1) {
            r0.contentDescriptionExceedsMaxBadgeNumberRes = r1;
            return r1;
        }

        static /* synthetic */ Boolean access$500(State r0) {
            return r0.isVisible;
        }

        static /* synthetic */ Boolean access$502(State r0, Boolean r1) {
            r0.isVisible = r1;
            return r1;
        }

        static /* synthetic */ int access$600(State r0) {
            return r0.maxCharacterCount;
        }

        static /* synthetic */ int access$602(State r0, int r1) {
            r0.maxCharacterCount = r1;
            return r1;
        }

        static /* synthetic */ int access$700(State r0) {
            return r0.number;
        }

        static /* synthetic */ int access$702(State r0, int r1) {
            r0.number = r1;
            return r1;
        }

        static /* synthetic */ Integer access$800(State r0) {
            return r0.backgroundColor;
        }

        static /* synthetic */ Integer access$802(State r0, Integer r1) {
            r0.backgroundColor = r1;
            return r1;
        }

        static /* synthetic */ Integer access$900(State r0) {
            return r0.badgeTextColor;
        }

        static /* synthetic */ Integer access$902(State r0, Integer r1) {
            r0.badgeTextColor = r1;
            return r1;
        }

        public State() {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.isVisible = true;
        }

        State(Parcel r2) {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.isVisible = true;
            this.badgeResId = r2.readInt();
            this.backgroundColor = (Integer) r2.readSerializable();
            this.badgeTextColor = (Integer) r2.readSerializable();
            this.alpha = r2.readInt();
            this.number = r2.readInt();
            this.maxCharacterCount = r2.readInt();
            this.contentDescriptionNumberless = r2.readString();
            this.contentDescriptionQuantityStrings = r2.readInt();
            this.badgeGravity = (Integer) r2.readSerializable();
            this.horizontalOffsetWithoutText = (Integer) r2.readSerializable();
            this.verticalOffsetWithoutText = (Integer) r2.readSerializable();
            this.horizontalOffsetWithText = (Integer) r2.readSerializable();
            this.verticalOffsetWithText = (Integer) r2.readSerializable();
            this.additionalHorizontalOffset = (Integer) r2.readSerializable();
            this.additionalVerticalOffset = (Integer) r2.readSerializable();
            this.isVisible = (Boolean) r2.readSerializable();
            this.numberLocale = (Locale) r2.readSerializable();
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.badgeResId);
            r1.writeSerializable(this.backgroundColor);
            r1.writeSerializable(this.badgeTextColor);
            r1.writeInt(this.alpha);
            r1.writeInt(this.number);
            r1.writeInt(this.maxCharacterCount);
            CharSequence r3 = this.contentDescriptionNumberless;
            if (r3 != null) goto L5;
            String r4 = null;
        L6:
            r1.writeString(r4);
            r1.writeInt(this.contentDescriptionQuantityStrings);
            r1.writeSerializable(this.badgeGravity);
            r1.writeSerializable(this.horizontalOffsetWithoutText);
            r1.writeSerializable(this.verticalOffsetWithoutText);
            r1.writeSerializable(this.horizontalOffsetWithText);
            r1.writeSerializable(this.verticalOffsetWithText);
            r1.writeSerializable(this.additionalHorizontalOffset);
            r1.writeSerializable(this.additionalVerticalOffset);
            r1.writeSerializable(this.isVisible);
            r1.writeSerializable(this.numberLocale);
            return;
        L5:
            r4 = r3.toString();
            goto L6
        }
    }

    BadgeState(Context r4, int r5, int r6, int r7, State r8) {
        State r0 = new State();
        this.currentState = r0;
        if (r8 != null) goto L5;
        r8 = new State();
    L5:
        if (r5 == 0) goto L7;
        State.access$002(r8, r5);
    L7:
        TypedArray r9 = generateTypedArray(r4, State.access$000(r8), r6, r7);
        Resources r10 = r4.getResources();
        this.badgeRadius = r9.getDimensionPixelSize(R.styleable.Badge_badgeRadius, r10.getDimensionPixelSize(R.dimen.mtrl_badge_radius));
        this.badgeWidePadding = r9.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, r10.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
        this.badgeWithTextRadius = r9.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, r10.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius));
        if (State.access$100(r8) != (-2)) goto L10;
        int r11 = 255;
    L11:
        State.access$102(r0, r11);
        if (State.access$200(r8) != null) goto L14;
        CharSequence r12 = r4.getString(R.string.mtrl_badge_numberless_content_description);
    L15:
        State.access$202(r0, r12);
        if (State.access$300(r8) != 0) goto L18;
        int r13 = R.plurals.mtrl_badge_content_description;
    L19:
        State.access$302(r0, r13);
        if (State.access$400(r8) != 0) goto L22;
        int r14 = R.string.mtrl_exceed_max_badge_number_content_description;
    L23:
        State.access$402(r0, r14);
        int r1 = 0;
        if (State.access$500(r8) != null) goto L26;
    L29:
        boolean r15 = true;
    L30:
        State.access$502(r0, Boolean.valueOf(r15));
        if (State.access$600(r8) != (-2)) goto L33;
        int r16 = r9.getInt(R.styleable.Badge_maxCharacterCount, 4);
    L34:
        State.access$602(r0, r16);
        if (State.access$700(r8) == (-2)) goto L38;
        State.access$702(r0, State.access$700(r8));
    L42:
        if (State.access$800(r8) != null) goto L44;
        int r17 = readColorFromAttributes(r4, r9, R.styleable.Badge_backgroundColor);
    L45:
        State.access$802(r0, Integer.valueOf(r17));
        if (State.access$900(r8) == null) goto L49;
        State.access$902(r0, State.access$900(r8));
    L53:
        if (State.access$1000(r8) != null) goto L55;
        int r18 = r9.getInt(R.styleable.Badge_badgeGravity, 8388661);
    L56:
        State.access$1002(r0, Integer.valueOf(r18));
        if (State.access$1100(r8) != null) goto L59;
        int r19 = r9.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0);
    L60:
        State.access$1102(r0, Integer.valueOf(r19));
        if (State.access$1100(r8) != null) goto L63;
        int r20 = r9.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0);
    L64:
        State.access$1202(r0, Integer.valueOf(r20));
        if (State.access$1300(r8) != null) goto L67;
        int r21 = r9.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, State.access$1100(r0).intValue());
    L68:
        State.access$1302(r0, Integer.valueOf(r21));
        if (State.access$1400(r8) != null) goto L71;
        int r22 = r9.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, State.access$1200(r0).intValue());
    L72:
        State.access$1402(r0, Integer.valueOf(r22));
        if (State.access$1500(r8) != null) goto L75;
        int r23 = 0;
    L76:
        State.access$1502(r0, Integer.valueOf(r23));
        if (State.access$1600(r8) == null) goto L80;
        r1 = State.access$1600(r8).intValue();
    L80:
        State.access$1602(r0, Integer.valueOf(r1));
        r9.recycle();
        if (State.access$1700(r8) != null) goto L83;
        State.access$1702(r0, Locale.getDefault(Locale.Category.FORMAT));
    L84:
        this.overridingState = r8;
        return;
    L83:
        State.access$1702(r0, State.access$1700(r8));
        goto L84
    L75:
        r23 = State.access$1500(r8).intValue();
        goto L76
    L71:
        r22 = State.access$1400(r8).intValue();
        goto L72
    L67:
        r21 = State.access$1300(r8).intValue();
        goto L68
    L63:
        r20 = State.access$1200(r8).intValue();
        goto L64
    L59:
        r19 = State.access$1100(r8).intValue();
        goto L60
    L55:
        r18 = State.access$1000(r8).intValue();
        goto L56
    L49:
        if (r9.hasValue(R.styleable.Badge_badgeTextColor) == false) goto L51;
        State.access$902(r0, Integer.valueOf(readColorFromAttributes(r4, r9, R.styleable.Badge_badgeTextColor)));
        goto L53
    L51:
        State.access$902(r0, Integer.valueOf(new TextAppearance(r4, R.style.TextAppearance_MaterialComponents_Badge).getTextColor().getDefaultColor()));
        goto L53
    L44:
        r17 = State.access$800(r8).intValue();
        goto L45
    L38:
        if (r9.hasValue(R.styleable.Badge_number) == false) goto L40;
        State.access$702(r0, r9.getInt(R.styleable.Badge_number, 0));
        goto L42
    L40:
        State.access$702(r0, -1);
        goto L42
    L33:
        r16 = State.access$600(r8);
        goto L34
    L26:
        if (State.access$500(r8).booleanValue() == true) goto L29;
        r15 = false;
        goto L30
    L22:
        r14 = State.access$400(r8);
        goto L23
    L18:
        r13 = State.access$300(r8);
        goto L19
    L14:
        r12 = State.access$200(r8);
        goto L15
    L10:
        r11 = State.access$100(r8);
        goto L11
    }

    private TypedArray generateTypedArray(Context r7, int r8, int r9, int r10) {
        if (r8 == 0) goto L5;
        AttributeSet r11 = DrawableUtils.parseDrawableXml(r7, r8, BADGE_RESOURCE_TAG);
        int r0 = r11.getStyleAttribute();
    L6:
        AttributeSet r1 = r11;
        if (r0 != 0) goto L9;
        int r4 = r10;
    L11:
        return ThemeEnforcement.obtainStyledAttributes(r7, r1, R.styleable.Badge, r9, r4, new int[0]);
    L9:
        r4 = r0;
        goto L11
    L5:
        r11 = null;
        r0 = 0;
        goto L6
    }

    State getOverridingState() {
        return this.overridingState;
    }

    boolean isVisible() {
        return State.access$500(this.currentState).booleanValue();
    }

    void setVisible(boolean r3) {
        State.access$502(this.overridingState, Boolean.valueOf(r3));
        State.access$502(this.currentState, Boolean.valueOf(r3));
    }

    boolean hasNumber() {
        if (State.access$700(this.currentState) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    int getNumber() {
        return State.access$700(this.currentState);
    }

    void setNumber(int r2) {
        State.access$702(this.overridingState, r2);
        State.access$702(this.currentState, r2);
    }

    void clearNumber() {
        setNumber(-1);
    }

    int getAlpha() {
        return State.access$100(this.currentState);
    }

    void setAlpha(int r2) {
        State.access$102(this.overridingState, r2);
        State.access$102(this.currentState, r2);
    }

    int getMaxCharacterCount() {
        return State.access$600(this.currentState);
    }

    void setMaxCharacterCount(int r2) {
        State.access$602(this.overridingState, r2);
        State.access$602(this.currentState, r2);
    }

    int getBackgroundColor() {
        return State.access$800(this.currentState).intValue();
    }

    void setBackgroundColor(int r3) {
        State.access$802(this.overridingState, Integer.valueOf(r3));
        State.access$802(this.currentState, Integer.valueOf(r3));
    }

    int getBadgeTextColor() {
        return State.access$900(this.currentState).intValue();
    }

    void setBadgeTextColor(int r3) {
        State.access$902(this.overridingState, Integer.valueOf(r3));
        State.access$902(this.currentState, Integer.valueOf(r3));
    }

    int getBadgeGravity() {
        return State.access$1000(this.currentState).intValue();
    }

    void setBadgeGravity(int r3) {
        State.access$1002(this.overridingState, Integer.valueOf(r3));
        State.access$1002(this.currentState, Integer.valueOf(r3));
    }

    int getHorizontalOffsetWithoutText() {
        return State.access$1100(this.currentState).intValue();
    }

    void setHorizontalOffsetWithoutText(int r3) {
        State.access$1102(this.overridingState, Integer.valueOf(r3));
        State.access$1102(this.currentState, Integer.valueOf(r3));
    }

    int getVerticalOffsetWithoutText() {
        return State.access$1200(this.currentState).intValue();
    }

    void setVerticalOffsetWithoutText(int r3) {
        State.access$1202(this.overridingState, Integer.valueOf(r3));
        State.access$1202(this.currentState, Integer.valueOf(r3));
    }

    int getHorizontalOffsetWithText() {
        return State.access$1300(this.currentState).intValue();
    }

    void setHorizontalOffsetWithText(int r3) {
        State.access$1302(this.overridingState, Integer.valueOf(r3));
        State.access$1302(this.currentState, Integer.valueOf(r3));
    }

    int getVerticalOffsetWithText() {
        return State.access$1400(this.currentState).intValue();
    }

    void setVerticalOffsetWithText(int r3) {
        State.access$1402(this.overridingState, Integer.valueOf(r3));
        State.access$1402(this.currentState, Integer.valueOf(r3));
    }

    int getAdditionalHorizontalOffset() {
        return State.access$1500(this.currentState).intValue();
    }

    void setAdditionalHorizontalOffset(int r3) {
        State.access$1502(this.overridingState, Integer.valueOf(r3));
        State.access$1502(this.currentState, Integer.valueOf(r3));
    }

    int getAdditionalVerticalOffset() {
        return State.access$1600(this.currentState).intValue();
    }

    void setAdditionalVerticalOffset(int r3) {
        State.access$1602(this.overridingState, Integer.valueOf(r3));
        State.access$1602(this.currentState, Integer.valueOf(r3));
    }

    CharSequence getContentDescriptionNumberless() {
        return State.access$200(this.currentState);
    }

    void setContentDescriptionNumberless(CharSequence r2) {
        State.access$202(this.overridingState, r2);
        State.access$202(this.currentState, r2);
    }

    int getContentDescriptionQuantityStrings() {
        return State.access$300(this.currentState);
    }

    void setContentDescriptionQuantityStringsResource(int r2) {
        State.access$302(this.overridingState, r2);
        State.access$302(this.currentState, r2);
    }

    int getContentDescriptionExceedsMaxBadgeNumberStringResource() {
        return State.access$400(this.currentState);
    }

    void setContentDescriptionExceedsMaxBadgeNumberStringResource(int r2) {
        State.access$402(this.overridingState, r2);
        State.access$402(this.currentState, r2);
    }

    Locale getNumberLocale() {
        return State.access$1700(this.currentState);
    }

    void setNumberLocale(Locale r2) {
        State.access$1702(this.overridingState, r2);
        State.access$1702(this.currentState, r2);
    }

    private static int readColorFromAttributes(Context r0, TypedArray r1, int r2) {
        return MaterialResources.getColorStateList(r0, r1, r2).getDefaultColor();
    }
}
