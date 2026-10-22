package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Legend extends ComponentBase {
    private List<Boolean> mCalculatedLabelBreakPoints;
    private List<FSize> mCalculatedLabelSizes;
    private List<FSize> mCalculatedLineSizes;
    private LegendDirection mDirection;
    private boolean mDrawInside;
    private LegendEntry[] mEntries;
    private LegendEntry[] mExtraEntries;
    private DashPathEffect mFormLineDashEffect;
    private float mFormLineWidth;
    private float mFormSize;
    private float mFormToTextSpace;
    private LegendHorizontalAlignment mHorizontalAlignment;
    private boolean mIsLegendCustom;
    private float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    private LegendOrientation mOrientation;
    private LegendForm mShape;
    private float mStackSpace;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private LegendVerticalAlignment mVerticalAlignment;
    private boolean mWordWrapEnabled;
    private float mXEntrySpace;
    private float mYEntrySpace;

    /* JADX INFO: renamed from: com.github.mikephil.charting.components.Legend$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = null;

        static {
            int[] r0 = new int[LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = r0;
            r0[LegendOrientation.VERTICAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[LegendOrientation.HORIZONTAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum LegendDirection extends Enum<LegendDirection> {
        private static final /* synthetic */ LegendDirection[] $VALUES = null;
        public static final LegendDirection LEFT_TO_RIGHT = null;
        public static final LegendDirection RIGHT_TO_LEFT = null;

        private LegendDirection(String r1, int r2) {
            super(r1, r2);
        }

        public static LegendDirection valueOf(String r1) {
            return (LegendDirection) Enum.valueOf(LegendDirection.class, r1);
        }

        public static LegendDirection[] values() {
            return (LegendDirection[]) $VALUES.clone();
        }

        static {
            LegendDirection r0 = new LegendDirection("LEFT_TO_RIGHT", 0);
            LEFT_TO_RIGHT = r0;
            LegendDirection r1 = new LegendDirection("RIGHT_TO_LEFT", 1);
            RIGHT_TO_LEFT = r1;
            $VALUES = new LegendDirection[]{r0, r1};
        }
    }

    public static final enum LegendForm extends Enum<LegendForm> {
        private static final /* synthetic */ LegendForm[] $VALUES = null;
        public static final LegendForm CIRCLE = null;
        public static final LegendForm DEFAULT = null;
        public static final LegendForm EMPTY = null;
        public static final LegendForm LINE = null;
        public static final LegendForm NONE = null;
        public static final LegendForm SQUARE = null;

        private LegendForm(String r1, int r2) {
            super(r1, r2);
        }

        public static LegendForm valueOf(String r1) {
            return (LegendForm) Enum.valueOf(LegendForm.class, r1);
        }

        public static LegendForm[] values() {
            return (LegendForm[]) $VALUES.clone();
        }

        static {
            LegendForm r0 = new LegendForm("NONE", 0);
            NONE = r0;
            LegendForm r1 = new LegendForm("EMPTY", 1);
            EMPTY = r1;
            LegendForm r3 = new LegendForm("DEFAULT", 2);
            DEFAULT = r3;
            LegendForm r5 = new LegendForm("SQUARE", 3);
            SQUARE = r5;
            LegendForm r7 = new LegendForm("CIRCLE", 4);
            CIRCLE = r7;
            LegendForm r9 = new LegendForm("LINE", 5);
            LINE = r9;
            $VALUES = new LegendForm[]{r0, r1, r3, r5, r7, r9};
        }
    }

    public static final enum LegendHorizontalAlignment extends Enum<LegendHorizontalAlignment> {
        private static final /* synthetic */ LegendHorizontalAlignment[] $VALUES = null;
        public static final LegendHorizontalAlignment CENTER = null;
        public static final LegendHorizontalAlignment LEFT = null;
        public static final LegendHorizontalAlignment RIGHT = null;

        private LegendHorizontalAlignment(String r1, int r2) {
            super(r1, r2);
        }

        public static LegendHorizontalAlignment valueOf(String r1) {
            return (LegendHorizontalAlignment) Enum.valueOf(LegendHorizontalAlignment.class, r1);
        }

        public static LegendHorizontalAlignment[] values() {
            return (LegendHorizontalAlignment[]) $VALUES.clone();
        }

        static {
            LegendHorizontalAlignment r0 = new LegendHorizontalAlignment("LEFT", 0);
            LEFT = r0;
            LegendHorizontalAlignment r1 = new LegendHorizontalAlignment("CENTER", 1);
            CENTER = r1;
            LegendHorizontalAlignment r3 = new LegendHorizontalAlignment("RIGHT", 2);
            RIGHT = r3;
            $VALUES = new LegendHorizontalAlignment[]{r0, r1, r3};
        }
    }

    public static final enum LegendOrientation extends Enum<LegendOrientation> {
        private static final /* synthetic */ LegendOrientation[] $VALUES = null;
        public static final LegendOrientation HORIZONTAL = null;
        public static final LegendOrientation VERTICAL = null;

        private LegendOrientation(String r1, int r2) {
            super(r1, r2);
        }

        public static LegendOrientation valueOf(String r1) {
            return (LegendOrientation) Enum.valueOf(LegendOrientation.class, r1);
        }

        public static LegendOrientation[] values() {
            return (LegendOrientation[]) $VALUES.clone();
        }

        static {
            LegendOrientation r0 = new LegendOrientation("HORIZONTAL", 0);
            HORIZONTAL = r0;
            LegendOrientation r1 = new LegendOrientation("VERTICAL", 1);
            VERTICAL = r1;
            $VALUES = new LegendOrientation[]{r0, r1};
        }
    }

    public static final enum LegendVerticalAlignment extends Enum<LegendVerticalAlignment> {
        private static final /* synthetic */ LegendVerticalAlignment[] $VALUES = null;
        public static final LegendVerticalAlignment BOTTOM = null;
        public static final LegendVerticalAlignment CENTER = null;
        public static final LegendVerticalAlignment TOP = null;

        private LegendVerticalAlignment(String r1, int r2) {
            super(r1, r2);
        }

        public static LegendVerticalAlignment valueOf(String r1) {
            return (LegendVerticalAlignment) Enum.valueOf(LegendVerticalAlignment.class, r1);
        }

        public static LegendVerticalAlignment[] values() {
            return (LegendVerticalAlignment[]) $VALUES.clone();
        }

        static {
            LegendVerticalAlignment r0 = new LegendVerticalAlignment("TOP", 0);
            TOP = r0;
            LegendVerticalAlignment r1 = new LegendVerticalAlignment("CENTER", 1);
            CENTER = r1;
            LegendVerticalAlignment r3 = new LegendVerticalAlignment("BOTTOM", 2);
            BOTTOM = r3;
            $VALUES = new LegendVerticalAlignment[]{r0, r1, r3};
        }
    }

    public Legend() {
        this.mEntries = new LegendEntry[0];
        this.mIsLegendCustom = false;
        this.mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
        this.mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
        this.mOrientation = LegendOrientation.HORIZONTAL;
        this.mDrawInside = false;
        this.mDirection = LegendDirection.LEFT_TO_RIGHT;
        this.mShape = LegendForm.SQUARE;
        this.mFormSize = 8.0f;
        this.mFormLineWidth = 3.0f;
        this.mFormLineDashEffect = null;
        this.mXEntrySpace = 6.0f;
        this.mYEntrySpace = 0.0f;
        this.mFormToTextSpace = 5.0f;
        this.mStackSpace = 3.0f;
        this.mMaxSizePercent = 0.95f;
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.mWordWrapEnabled = false;
        this.mCalculatedLabelSizes = new ArrayList(16);
        this.mCalculatedLabelBreakPoints = new ArrayList(16);
        this.mCalculatedLineSizes = new ArrayList(16);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(3.0f);
    }

    public Legend(LegendEntry[] r1) {
        this();
        if (r1 == null) goto L7;
        this.mEntries = r1;
        return;
    L7:
        throw new IllegalArgumentException("entries array is NULL");
    }

    public void setEntries(List<LegendEntry> r2) {
        this.mEntries = (LegendEntry[]) r2.toArray(new LegendEntry[r2.size()]);
    }

    public LegendEntry[] getEntries() {
        return this.mEntries;
    }

    public float getMaximumEntryWidth(Paint r10) {
        float r0 = Utils.convertDpToPixel(this.mFormToTextSpace);
        LegendEntry[] r1 = this.mEntries;
        int r2 = r1.length;
        float r3 = 0.0f;
        int r5 = 0;
        float r4 = 0.0f;
    L3:
        if (r5 >= r2) goto L19;
        LegendEntry r6 = r1[r5];
        if (Float.isNaN(r6.formSize) == false) goto L7;
        float r7 = this.mFormSize;
    L8:
        float r8 = Utils.convertDpToPixel(r7);
        if (r8 <= r4) goto L11;
        r4 = r8;
    L11:
        String r9 = r6.label;
        if (r9 == null) goto L17;
        float r11 = Utils.calcTextWidth(r10, r9);
        if (r11 <= r3) goto L17;
        r3 = r11;
    L17:
        r5 = r5 + 1;
        goto L3
    L7:
        r7 = r6.formSize;
        goto L8
    L19:
        return (r3 + r4) + r0;
    }

    public float getMaximumEntryHeight(Paint r6) {
        LegendEntry[] r5 = this.mEntries;
        int r0 = r5.length;
        float r1 = 0.0f;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        String r3 = r5[r2].label;
        if (r3 == null) goto L10;
        float r4 = Utils.calcTextHeight(r6, r3);
        if (r4 <= r1) goto L10;
        r1 = r4;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return r1;
    }

    public LegendEntry[] getExtraEntries() {
        return this.mExtraEntries;
    }

    public void setExtra(List<LegendEntry> r2) {
        this.mExtraEntries = (LegendEntry[]) r2.toArray(new LegendEntry[r2.size()]);
    }

    public void setExtra(LegendEntry[] r1) {
        if (r1 != null) goto L4;
        r1 = new LegendEntry[0];
    L4:
        this.mExtraEntries = r1;
    }

    public void setExtra(int[] r6, String[] r7) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= Math.min(r6.length, r7.length)) goto L15;
        LegendEntry r2 = new LegendEntry();
        r2.formColor = r6[r1];
        r2.label = r7[r1];
        if (r2.formColor != 1122868) goto L8;
    L13:
        r2.form = LegendForm.NONE;
    L14:
        r0.add(r2);
        r1 = r1 + 1;
        goto L4
    L8:
        if (r2.formColor == 0) goto L13;
        if (r2.formColor != 1122867) goto L14;
        r2.form = LegendForm.EMPTY;
        goto L14
    L15:
        this.mExtraEntries = (LegendEntry[]) r0.toArray(new LegendEntry[r0.size()]);
    }

    public void setCustom(LegendEntry[] r1) {
        this.mEntries = r1;
        this.mIsLegendCustom = true;
    }

    public void setCustom(List<LegendEntry> r2) {
        this.mEntries = (LegendEntry[]) r2.toArray(new LegendEntry[r2.size()]);
        this.mIsLegendCustom = true;
    }

    public void resetCustom() {
        this.mIsLegendCustom = false;
    }

    public boolean isLegendCustom() {
        return this.mIsLegendCustom;
    }

    public LegendHorizontalAlignment getHorizontalAlignment() {
        return this.mHorizontalAlignment;
    }

    public void setHorizontalAlignment(LegendHorizontalAlignment r1) {
        this.mHorizontalAlignment = r1;
    }

    public LegendVerticalAlignment getVerticalAlignment() {
        return this.mVerticalAlignment;
    }

    public void setVerticalAlignment(LegendVerticalAlignment r1) {
        this.mVerticalAlignment = r1;
    }

    public LegendOrientation getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(LegendOrientation r1) {
        this.mOrientation = r1;
    }

    public boolean isDrawInsideEnabled() {
        return this.mDrawInside;
    }

    public void setDrawInside(boolean r1) {
        this.mDrawInside = r1;
    }

    public LegendDirection getDirection() {
        return this.mDirection;
    }

    public void setDirection(LegendDirection r1) {
        this.mDirection = r1;
    }

    public LegendForm getForm() {
        return this.mShape;
    }

    public void setForm(LegendForm r1) {
        this.mShape = r1;
    }

    public void setFormSize(float r1) {
        this.mFormSize = r1;
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public void setFormLineWidth(float r1) {
        this.mFormLineWidth = r1;
    }

    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    public void setFormLineDashEffect(DashPathEffect r1) {
        this.mFormLineDashEffect = r1;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.mFormLineDashEffect;
    }

    public float getXEntrySpace() {
        return this.mXEntrySpace;
    }

    public void setXEntrySpace(float r1) {
        this.mXEntrySpace = r1;
    }

    public float getYEntrySpace() {
        return this.mYEntrySpace;
    }

    public void setYEntrySpace(float r1) {
        this.mYEntrySpace = r1;
    }

    public float getFormToTextSpace() {
        return this.mFormToTextSpace;
    }

    public void setFormToTextSpace(float r1) {
        this.mFormToTextSpace = r1;
    }

    public float getStackSpace() {
        return this.mStackSpace;
    }

    public void setStackSpace(float r1) {
        this.mStackSpace = r1;
    }

    public void setWordWrapEnabled(boolean r1) {
        this.mWordWrapEnabled = r1;
    }

    public boolean isWordWrapEnabled() {
        return this.mWordWrapEnabled;
    }

    public float getMaxSizePercent() {
        return this.mMaxSizePercent;
    }

    public void setMaxSizePercent(float r1) {
        this.mMaxSizePercent = r1;
    }

    public List<FSize> getCalculatedLabelSizes() {
        return this.mCalculatedLabelSizes;
    }

    public List<Boolean> getCalculatedLabelBreakPoints() {
        return this.mCalculatedLabelBreakPoints;
    }

    public List<FSize> getCalculatedLineSizes() {
        return this.mCalculatedLineSizes;
    }

    public void calculateDimensions(Paint r28, ViewPortHandler r29) {
        float r2 = Utils.convertDpToPixel(this.mFormSize);
        float r3 = Utils.convertDpToPixel(this.mStackSpace);
        float r4 = Utils.convertDpToPixel(this.mFormToTextSpace);
        float r5 = Utils.convertDpToPixel(this.mXEntrySpace);
        float r6 = Utils.convertDpToPixel(this.mYEntrySpace);
        boolean r7 = this.mWordWrapEnabled;
        LegendEntry[] r8 = this.mEntries;
        int r9 = r8.length;
        this.mTextWidthMax = getMaximumEntryWidth(r28);
        this.mTextHeightMax = getMaximumEntryHeight(r28);
        int r10 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mOrientation.ordinal()];
        if (r10 != 1) goto L5;
        float r11 = Utils.getLineHeight(r28);
        int r12 = 0;
        boolean r13 = false;
        float r14 = 0.0f;
        float r15 = 0.0f;
        float r16 = 0.0f;
    L66:
        if (r12 >= r9) goto L98;
        LegendEntry r17 = r8[r12];
        if (r17.form == LegendForm.NONE) goto L70;
        boolean r18 = true;
    L72:
        if (Float.isNaN(r17.formSize) == false) goto L74;
        float r19 = r2;
    L75:
        String r110 = r17.label;
        if (r13 == true) goto L78;
        r15 = 0.0f;
    L78:
        if (r18 == false) goto L82;
        if (r13 == false) goto L81;
        r15 = r15 + r3;
    L81:
        r15 = r15 + r19;
    L82:
        if (r110 == null) goto L93;
        if (r18 == false) goto L86;
        if (r13 == true) goto L86;
        r15 = r15 + r4;
    L88:
        float r26 = r16;
        float r20 = r15;
        float r21 = r26;
    L89:
        float r22 = r20 + Utils.calcTextWidth(r28, r110);
        if (r12 >= (r9 - 1)) goto L92;
        r14 = r14 + (r11 + r6);
    L92:
        r16 = r21;
        r15 = r22;
    L97:
        r16 = Math.max(r16, r15);
        r12 = r12 + 1;
    L86:
        if (r13 == false) goto L88;
        r14 = r14 + (r11 + r6);
        r21 = Math.max(r16, r15);
        r13 = false;
        r20 = 0.0f;
        goto L89
    L93:
        r15 = r15 + r19;
        if (r12 >= (r9 - 1)) goto L96;
        r15 = r15 + r3;
    L96:
        r13 = true;
        goto L97
    L74:
        r19 = Utils.convertDpToPixel(r17.formSize);
        goto L75
    L70:
        r18 = false;
        goto L72
    L98:
        this.mNeededWidth = r16;
        this.mNeededHeight = r14;
    L99:
        this.mNeededHeight += this.mYOffset;
        this.mNeededWidth += this.mXOffset;
        return;
    L5:
        if (r10 != 2) goto L99;
        float r111 = Utils.getLineHeight(r28);
        float r112 = Utils.getLineSpacing(r28) + r6;
        float r23 = r29.contentWidth() * this.mMaxSizePercent;
        this.mCalculatedLabelBreakPoints.clear();
        this.mCalculatedLabelSizes.clear();
        this.mCalculatedLineSizes.clear();
        int r113 = 0;
        int r114 = -1;
        float r115 = 0.0f;
        float r116 = 0.0f;
        float r24 = 0.0f;
    L8:
        if (r113 >= r9) goto L60;
        LegendEntry r117 = r8[r113];
        float r25 = r2;
        if (r117.form == LegendForm.NONE) goto L12;
        boolean r27 = true;
    L14:
        if (Float.isNaN(r117.formSize) == false) goto L16;
        float r118 = r25;
    L17:
        String r119 = r117.label;
        float r210 = r5;
        LegendEntry[] r211 = r8;
        this.mCalculatedLabelBreakPoints.add(false);
        if (r114 != (-1)) goto L20;
        float r30 = 0.0f;
    L21:
        if (r119 == null) goto L27;
        float r120 = r3;
        this.mCalculatedLabelSizes.add(Utils.calcTextSize(r28, r119));
        if (r27 == false) goto L25;
        float r31 = r4 + r118;
    L26:
        float r32 = (r30 + r31) + this.mCalculatedLabelSizes.get(r113).width;
    L34:
        if (r119 == null) goto L36;
    L37:
        float r33 = r24;
        if (r33 != 0.0f) goto L40;
        float r121 = 0.0f;
    L41:
        if (r7 == false) goto L51;
        if (r33 == 0.0f) goto L51;
        if ((r23 - r33) >= (r121 + r32)) goto L51;
        this.mCalculatedLineSizes.add(FSize.getInstance(r33, r111));
        float r34 = Math.max(r115, r33);
        List<Boolean> r35 = this.mCalculatedLabelBreakPoints;
        if (r114 <= (-1)) goto L49;
        int r36 = r114;
    L50:
        r35.set(r36, true);
        float r37 = r32;
    L53:
        if (r113 != (r9 - 1)) goto L55;
        this.mCalculatedLineSizes.add(FSize.getInstance(r37, r111));
        r115 = Math.max(r34, r37);
    L56:
        r24 = r37;
    L57:
        if (r119 == null) goto L59;
        r114 = -1;
    L59:
        r113 = r113 + 1;
        r3 = r120;
        r2 = r25;
        r8 = r211;
        r116 = r32;
        r5 = r210;
        goto L8
    L55:
        r115 = r34;
        goto L56
    L49:
        r36 = r113;
    L51:
        float r212 = r33 + (r121 + r32);
        r34 = r115;
        r37 = r212;
        goto L53
    L40:
        r121 = r210;
        goto L41
    L36:
        if (r113 != (r9 - 1)) goto L57;
    L25:
        r31 = 0.0f;
        goto L26
    L27:
        r120 = r3;
        float r213 = r118;
        this.mCalculatedLabelSizes.add(FSize.getInstance(0.0f, 0.0f));
        if (r27 == false) goto L30;
        float r122 = r213;
    L31:
        r32 = r30 + r122;
        if (r114 != (-1)) goto L34;
        r114 = r113;
        goto L34
    L30:
        r122 = 0.0f;
        goto L31
    L20:
        r30 = r116 + r3;
        goto L21
    L16:
        r118 = Utils.convertDpToPixel(r117.formSize);
        goto L17
    L12:
        r27 = false;
        goto L14
    L60:
        this.mNeededWidth = r115;
        float r123 = r111 * this.mCalculatedLineSizes.size();
        if (this.mCalculatedLineSizes.size() != 0) goto L63;
        int r124 = 0;
    L64:
        this.mNeededHeight = r123 + (r112 * r124);
        goto L99
    L63:
        r124 = this.mCalculatedLineSizes.size() - 1;
        goto L64
    }
}
