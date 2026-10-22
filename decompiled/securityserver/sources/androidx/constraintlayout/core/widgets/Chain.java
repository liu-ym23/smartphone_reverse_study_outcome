package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public Chain() {
    }

    public static void applyChainConstraints(ConstraintWidgetContainer r6, LinearSystem r7, ArrayList<ConstraintWidget> r8, int r9) {
        int r0 = 0;
        if (r9 != 0) goto L5;
        int r1 = r6.mHorizontalChainsSize;
        ChainHead[] r2 = r6.mHorizontalChainsArray;
        int r3 = 0;
    L6:
        if (r0 >= r1) goto L13;
        ChainHead r4 = r2[r0];
        r4.define();
        if (r8 != null) goto L10;
    L11:
        applyChainConstraints(r6, r7, r9, r3, r4);
    L12:
        r0 = r0 + 1;
        goto L6
    L10:
        if (r8.contains(r4.mFirst) == false) goto L12;
    L13:
        return;
    L5:
        r1 = r6.mVerticalChainsSize;
        r2 = r6.mVerticalChainsArray;
        r3 = 2;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [androidx.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    public static void applyChainConstraints(ConstraintWidgetContainer r37, LinearSystem r38, int r39, int r40, ChainHead r41) {
        int r10 = r39;
        ConstraintWidget r11 = r41.mFirst;
        ConstraintWidget r12 = r41.mLast;
        ConstraintWidget r13 = r41.mFirstVisibleWidget;
        ConstraintWidget r14 = r41.mLastVisibleWidget;
        ConstraintWidget r2 = r41.mHead;
        float r3 = r41.mTotalWeight;
        if (r37.mListDimensionBehaviors[r10] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
        boolean r4 = true;
    L7:
        if (r10 != 0) goto L19;
        int r7 = r2.mHorizontalChainStyle;
        if (r7 != 0) goto L11;
        boolean r8 = true;
    L12:
        if (r7 != 1) goto L14;
        boolean r16 = true;
    L15:
        if (r7 != 2) goto L17;
    L16:
        boolean r5 = true;
    L18:
        boolean r17 = r16;
        boolean r9 = false;
        boolean r18 = r8;
        ?? r15 = r11;
    L28:
        Object r21 = null;
        if (r9 == true) goto L86;
        ConstraintAnchor r6 = r15.mListAnchors[r40];
        if (r5 == false) goto L33;
        int r19 = 1;
    L34:
        int r23 = r6.getMargin();
        ConstraintWidget.DimensionBehaviour r110 = r15.mListDimensionBehaviors[r10];
        float r25 = r3;
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r110 == r20) goto L37;
    L39:
        boolean r111 = false;
    L40:
        ConstraintAnchor r22 = r6.mTarget;
        if (r22 == null) goto L44;
        if (r15 == r11) goto L44;
        r23 = r22.getMargin() + r23;
    L44:
        int r24 = r23;
        if (r5 == false) goto L50;
        if (r15 == r11) goto L50;
        if (r15 == r13) goto L50;
        r19 = 8;
    L50:
        ConstraintAnchor r26 = r6.mTarget;
        if (r26 == null) goto L65;
        if (r15 != r13) goto L54;
        r38.addGreaterThan(r6.mSolverVariable, r26.mSolverVariable, r24, 6);
    L55:
        if (r111 == false) goto L58;
        if (r5 == true) goto L58;
        r19 = 5;
    L58:
        if (r15 != r13) goto L63;
        if (r5 == false) goto L63;
        if (r15.isInBarrier(r10) == false) goto L63;
        int r1 = 5;
    L64:
        r38.addEquality(r6.mSolverVariable, r6.mTarget.mSolverVariable, r24, r1);
    L66:
        if (r4 == true) goto L68;
    L74:
        ConstraintAnchor r27 = r15.mListAnchors[r40 + 1].mTarget;
        if (r27 == null) goto L82;
        ConstraintWidget r28 = r27.mOwner;
        ConstraintAnchor r29 = r28.mListAnchors[r40].mTarget;
        if (r29 == null) goto L82;
        if (r29.mOwner != r15) goto L82;
        r21 = r28;
    L82:
        if (r21 == null) goto L84;
        r15 = r21;
        r9 = r9;
    L85:
        r2 = r2;
        r3 = r25;
        r11 = r11;
        r15 = r15;
        goto L28
    L84:
        r9 = true;
        goto L85
    L68:
        if (r15.getVisibility() != 8) goto L70;
    L72:
        int r30 = 0;
    L73:
        r38.addGreaterThan(r15.mListAnchors[r40].mSolverVariable, r37.mListAnchors[r40].mSolverVariable, r30, 8);
        goto L74
    L70:
        if (r15.mListDimensionBehaviors[r10] != r20) goto L72;
        ConstraintAnchor[] r31 = r15.mListAnchors;
        r30 = 0;
        r38.addGreaterThan(r31[r40 + 1].mSolverVariable, r31[r40].mSolverVariable, 0, 5);
    L63:
        r1 = r19;
        goto L64
    L54:
        r38.addGreaterThan(r6.mSolverVariable, r26.mSolverVariable, r24, 8);
        goto L55
    L65:
        r11 = r11;
        goto L66
    L37:
        if (r15.mResolvedMatchConstraintDefault[r10] != 0) goto L39;
        r111 = true;
        goto L40
    L33:
        r19 = 4;
        goto L34
    L86:
        ConstraintWidget r210 = r2;
        float r211 = r3;
        ConstraintWidget r212 = r11;
        if (r14 == null) goto L105;
        int r32 = r40 + 1;
        if (r12.mListAnchors[r32].mTarget == null) goto L105;
        ConstraintAnchor r33 = r14.mListAnchors[r32];
        if (r14.mListDimensionBehaviors[r10] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L99;
        if (r14.mResolvedMatchConstraintDefault[r10] != 0) goto L99;
        if (r5 == true) goto L99;
        ConstraintAnchor r34 = r33.mTarget;
        if (r34.mOwner != r37) goto L99;
        r38.addEquality(r33.mSolverVariable, r34.mSolverVariable, -r33.getMargin(), 5);
    L103:
        r38.addLowerThan(r33.mSolverVariable, r12.mListAnchors[r32].mTarget.mSolverVariable, -r33.getMargin(), 6);
    L99:
        if (r5 == false) goto L103;
        ConstraintAnchor r35 = r33.mTarget;
        if (r35.mOwner != r37) goto L103;
        r38.addEquality(r33.mSolverVariable, r35.mSolverVariable, -r33.getMargin(), 4);
    L105:
        if (r4 == false) goto L107;
        int r36 = r40 + 1;
        SolverVariable r0 = r37.mListAnchors[r36].mSolverVariable;
        ConstraintAnchor r42 = r12.mListAnchors[r36];
        r38.addGreaterThan(r0, r42.mSolverVariable, r42.getMargin(), 8);
    L107:
        ArrayList<ConstraintWidget> r43 = r41.mWeightedMatchConstraintsWidgets;
        if (r43 == null) goto L137;
        int r44 = r43.size();
        if (r44 <= 1) goto L137;
        if (r41.mHasUndefinedWeights == true) goto L114;
    L116:
        float r45 = r211;
    L117:
        float r46 = 0.0f;
        float r213 = 0.0f;
        ConstraintWidget r47 = null;
        int r48 = 0;
    L118:
        if (r48 >= r44) goto L137;
        ConstraintWidget r112 = r43.get(r48);
        float r113 = r112.mWeight[r10];
        if (r113 >= r46) goto L128;
        if (r41.mHasComplexMatchWeights == false) goto L124;
        ConstraintAnchor[] r114 = r112.mListAnchors;
        r38.addEquality(r114[r40 + 1].mSolverVariable, r114[r40].mSolverVariable, 0, 4);
    L130:
        r43 = r43;
        r44 = r44;
    L136:
        r48 = r48 + 1;
        r44 = r44;
        r43 = r43;
        r46 = 0.0f;
        goto L118
    L124:
        r113 = 1.0f;
    L128:
        if (r113 != 0.0f) goto L132;
        ConstraintAnchor[] r115 = r112.mListAnchors;
        r38.addEquality(r115[r40 + 1].mSolverVariable, r115[r40].mSolverVariable, 0, 8);
        goto L130
    L132:
        if (r47 == null) goto L135;
        ConstraintAnchor[] r49 = r47.mListAnchors;
        SolverVariable r50 = r49[r40].mSolverVariable;
        int r116 = r40 + 1;
        SolverVariable r51 = r49[r116].mSolverVariable;
        ConstraintAnchor[] r52 = r112.mListAnchors;
        SolverVariable r53 = r52[r40].mSolverVariable;
        SolverVariable r54 = r52[r116].mSolverVariable;
        ArrayRow r55 = r38.createRow();
        r55.createRowEqualMatchDimensions(r213, r45, r113, r50, r51, r53, r54);
        r38.addConstraint(r55);
    L135:
        r47 = r112;
        r213 = r113;
        goto L136
    L114:
        if (r41.mHasComplexMatchWeights == true) goto L116;
        r45 = r41.mWidgetsMatchCount;
    L137:
        if (r13 == null) goto L160;
        if (r13 == r14) goto L142;
        if (r5 == false) goto L160;
    L142:
        ConstraintAnchor r56 = r212.mListAnchors[r40];
        int r57 = r40 + 1;
        ConstraintAnchor r58 = r12.mListAnchors[r57];
        ConstraintAnchor r59 = r56.mTarget;
        if (r59 == null) goto L145;
        SolverVariable r60 = r59.mSolverVariable;
    L146:
        ConstraintAnchor r61 = r58.mTarget;
        if (r61 == null) goto L149;
        SolverVariable r62 = r61.mSolverVariable;
    L150:
        ConstraintAnchor r63 = r13.mListAnchors[r40];
        if (r14 == null) goto L153;
        r58 = r14.mListAnchors[r57];
    L153:
        if (r60 == null) goto L289;
        if (r62 == null) goto L289;
        if (r10 != 0) goto L158;
        float r64 = r210.mHorizontalBiasPercent;
    L157:
        float r65 = r64;
        SolverVariable r66 = r60;
        r38.addCentering(r63.mSolverVariable, r66, r63.getMargin(), r65, r62, r58.mSolverVariable, r58.getMargin(), 7);
        goto L289
    L158:
        r64 = r210.mVerticalBiasPercent;
    L289:
        if (r18 == true) goto L291;
        if (r17 == true) goto L291;
        return;
    L291:
        if (r13 == null) goto L332;
        if (r13 == r14) goto L333;
        ConstraintAnchor[] r67 = r13.mListAnchors;
        ConstraintAnchor r68 = r67[r40];
        if (r14 != null) goto L296;
        r14 = r13;
    L296:
        int r69 = r40 + 1;
        ConstraintAnchor r70 = r14.mListAnchors[r69];
        ConstraintAnchor r71 = r68.mTarget;
        if (r71 == null) goto L299;
        SolverVariable r72 = r71.mSolverVariable;
    L300:
        ConstraintAnchor r73 = r70.mTarget;
        if (r73 == null) goto L303;
        ?? r74 = r73.mSolverVariable;
    L304:
        if (r12 == r14) goto L309;
        ConstraintAnchor r75 = r12.mListAnchors[r69].mTarget;
        if (r75 == null) goto L308;
        r21 = r75.mSolverVariable;
    L308:
        r74 = r21;
    L309:
        if (r13 != r14) goto L311;
        r70 = r67[r69];
    L311:
        if (r72 == null) goto L334;
        if (r74 == 0) goto L335;
        int r76 = r68.getMargin();
        int r77 = r14.mListAnchors[r69].getMargin();
        r38.addCentering(r68.mSolverVariable, r72, r76, 0.5f, r74, r70.mSolverVariable, r77, 5);
        return;
    L335:
        return;
    L334:
        return;
    L303:
        r74 = 0;
        goto L304
    L299:
        r72 = null;
        goto L300
    L333:
        return;
    L332:
        return;
    L149:
        r62 = null;
        goto L150
    L145:
        r60 = null;
    L160:
        if (r18 == false) goto L223;
        if (r13 == null) goto L223;
        int r78 = r41.mWidgetsMatchCount;
        if (r78 > 0) goto L165;
    L167:
        boolean r214 = false;
    L168:
        ConstraintWidget r79 = r13;
        ConstraintWidget r117 = r79;
    L169:
        if (r117 == null) goto L289;
        ConstraintWidget r80 = r117.mNextChainWidget[r10];
    L171:
        if (r80 == null) goto L176;
        if (r80.getVisibility() != 8) goto L176;
        r80 = r80.mNextChainWidget[r10];
    L176:
        if (r80 != null) goto L181;
        if (r117 == r14) goto L181;
    L219:
        if (r117.getVisibility() != 8) goto L222;
        r117 = r79;
    L222:
        r79 = r117;
        r117 = r80;
    L181:
        ConstraintAnchor r81 = r117.mListAnchors[r40];
        SolverVariable r82 = r81.mSolverVariable;
        ConstraintAnchor r83 = r81.mTarget;
        if (r83 == null) goto L184;
        SolverVariable r84 = r83.mSolverVariable;
    L185:
        if (r79 == r117) goto L187;
        r84 = r79.mListAnchors[r40 + 1].mSolverVariable;
    L192:
        int r85 = r81.getMargin();
        int r86 = r40 + 1;
        int r87 = r117.mListAnchors[r86].getMargin();
        if (r80 == null) goto L196;
        ConstraintAnchor r88 = r80.mListAnchors[r40];
        SolverVariable r89 = r88.mSolverVariable;
    L200:
        SolverVariable r90 = r117.mListAnchors[r86].mSolverVariable;
        if (r88 == null) goto L203;
        r87 = r87 + r88.getMargin();
    L203:
        int r91 = r79.mListAnchors[r86].getMargin() + r85;
        if (r82 == null) goto L219;
        if (r84 == null) goto L219;
        if (r89 == null) goto L219;
        if (r90 == null) goto L219;
        if (r117 != r13) goto L210;
        r91 = r13.mListAnchors[r40].getMargin();
    L210:
        if (r117 != r14) goto L212;
        int r118 = r14.mListAnchors[r86].getMargin();
    L213:
        if (r214 == false) goto L215;
        int r119 = 8;
    L216:
        r80 = r80;
        r38.addCentering(r82, r84, r91, 0.5f, r89, r90, r118, r119);
        goto L219
    L215:
        r119 = 5;
        goto L216
    L212:
        r118 = r87;
        goto L213
    L196:
        r88 = r12.mListAnchors[r86].mTarget;
        if (r88 == null) goto L199;
        r89 = r88.mSolverVariable;
        goto L200
    L199:
        r89 = null;
        goto L200
    L187:
        if (r117 != r13) goto L192;
        ConstraintAnchor r92 = r212.mListAnchors[r40].mTarget;
        if (r92 == null) goto L191;
        r84 = r92.mSolverVariable;
        goto L192
    L191:
        r84 = null;
        goto L192
    L184:
        r84 = null;
        goto L185
    L165:
        if (r41.mWidgetsCount != r78) goto L167;
        r214 = true;
    L223:
        int r93 = 8;
        if (r17 == false) goto L289;
        if (r13 == null) goto L289;
        int r94 = r41.mWidgetsMatchCount;
        if (r94 > 0) goto L229;
    L231:
        boolean r215 = false;
    L232:
        ConstraintWidget r95 = r13;
        ConstraintWidget r120 = r95;
    L233:
        if (r120 == null) goto L280;
        ConstraintWidget r96 = r120.mNextChainWidget[r10];
    L235:
        if (r96 == null) goto L239;
        if (r96.getVisibility() != r93) goto L239;
        r96 = r96.mNextChainWidget[r10];
    L239:
        if (r120 == r13) goto L274;
        if (r120 == r14) goto L274;
        if (r96 == null) goto L274;
        if (r96 != r14) goto L244;
        ConstraintWidget r97 = null;
    L245:
        ConstraintAnchor r98 = r120.mListAnchors[r40];
        SolverVariable r99 = r98.mSolverVariable;
        ConstraintAnchor r100 = r98.mTarget;
        if (r100 == null) goto L248;
        SolverVariable r101 = r100.mSolverVariable;
    L248:
        int r102 = r40 + 1;
        SolverVariable r103 = r95.mListAnchors[r102].mSolverVariable;
        int r104 = r98.getMargin();
        int r105 = r120.mListAnchors[r102].getMargin();
        if (r97 == null) goto L255;
        ConstraintAnchor r106 = r97.mListAnchors[r40];
        SolverVariable r107 = r106.mSolverVariable;
        ConstraintAnchor r108 = r106.mTarget;
        if (r108 == null) goto L253;
        SolverVariable r109 = r108.mSolverVariable;
    L254:
        SolverVariable r121 = r109;
        SolverVariable r122 = r107;
    L260:
        if (r106 == null) goto L262;
        int r123 = r106.getMargin() + r105;
    L263:
        int r124 = r95.mListAnchors[r102].getMargin() + r104;
        if (r215 == false) goto L266;
        int r216 = 8;
    L267:
        if (r99 == null) goto L272;
        if (r103 == null) goto L272;
        if (r122 == null) goto L272;
        if (r121 == null) goto L272;
        int r125 = 8;
        r38.addCentering(r99, r103, r124, 0.5f, r122, r121, r123, r216);
    L273:
        r96 = r97;
    L276:
        if (r120.getVisibility() == r125) goto L278;
        r95 = r120;
    L279:
        r120 = r96;
        r93 = r125;
        r10 = r39;
        goto L233
    L278:
        r95 = r95;
    L272:
        r125 = 8;
        goto L273
    L266:
        r216 = 4;
        goto L267
    L262:
        r123 = r105;
        goto L263
    L253:
        r109 = null;
        goto L254
    L255:
        r106 = r14.mListAnchors[r40];
        if (r106 == null) goto L258;
        r122 = r106.mSolverVariable;
    L259:
        r121 = r120.mListAnchors[r102].mSolverVariable;
        goto L260
    L258:
        r122 = null;
        goto L259
    L244:
        r97 = r96;
    L274:
        r95 = r95;
        r125 = r93;
        goto L276
    L280:
        ConstraintAnchor r126 = r13.mListAnchors[r40];
        ConstraintAnchor r127 = r212.mListAnchors[r40].mTarget;
        int r128 = r40 + 1;
        ConstraintAnchor r129 = r14.mListAnchors[r128];
        ConstraintAnchor r130 = r12.mListAnchors[r128].mTarget;
        if (r127 == null) goto L286;
        if (r13 == r14) goto L284;
        r38.addEquality(r126.mSolverVariable, r127.mSolverVariable, r126.getMargin(), 5);
        goto L286
    L284:
        if (r130 == null) goto L286;
        r38.addCentering(r126.mSolverVariable, r127.mSolverVariable, r126.getMargin(), 0.5f, r129.mSolverVariable, r130.mSolverVariable, r129.getMargin(), 5);
    L286:
        if (r130 == null) goto L289;
        if (r13 == r14) goto L289;
        r38.addEquality(r129.mSolverVariable, r130.mSolverVariable, -r129.getMargin(), 5);
        goto L289
    L229:
        if (r41.mWidgetsCount != r94) goto L231;
        r215 = true;
    L17:
        r5 = false;
        goto L18
    L14:
        r16 = false;
        goto L15
    L11:
        r8 = false;
        goto L12
    L19:
        int r131 = r2.mVerticalChainStyle;
        if (r131 != 0) goto L22;
        r8 = true;
    L23:
        if (r131 != 1) goto L25;
        r16 = true;
    L26:
        if (r131 != 2) goto L17;
    L25:
        r16 = false;
        goto L26
    L22:
        r8 = false;
        goto L23
    L5:
        r4 = false;
        goto L7
    }
}
