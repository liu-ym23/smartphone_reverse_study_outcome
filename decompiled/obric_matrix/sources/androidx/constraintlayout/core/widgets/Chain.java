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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r39v0, types: [androidx.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    static void applyChainConstraints(ConstraintWidgetContainer r38, LinearSystem r39, int r40, int r41, ChainHead r42) {
        int r10 = r40;
        ConstraintWidget r11 = r42.mFirst;
        ConstraintWidget r12 = r42.mLast;
        ConstraintWidget r13 = r42.mFirstVisibleWidget;
        ConstraintWidget r14 = r42.mLastVisibleWidget;
        ConstraintWidget r2 = r42.mHead;
        float r3 = r42.mTotalWeight;
        ConstraintWidget r4 = r42.mFirstMatchConstraintWidget;
        ConstraintWidget r5 = r42.mLastMatchConstraintWidget;
        if (r38.mListDimensionBehaviors[r10] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
        boolean r6 = true;
    L7:
        if (r10 != 0) goto L17;
        int r8 = r2.mHorizontalChainStyle;
        if (r8 != 0) goto L11;
        boolean r15 = true;
    L12:
        if (r8 != 1) goto L14;
        boolean r16 = true;
    L15:
        if (r8 == 2) goto L25;
    L26:
        boolean r7 = false;
    L27:
        ?? r9 = r11;
        boolean r17 = false;
    L28:
        Object r22 = null;
        if (r17 == true) goto L85;
        ConstraintAnchor r18 = r9.mListAnchors[r41];
        if (r7 == false) goto L33;
        int r20 = 1;
    L34:
        int r24 = r18.getMargin();
        float r25 = r3;
        ConstraintWidget.DimensionBehaviour r19 = r9.mListDimensionBehaviors[r10];
        boolean r26 = r17;
        ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r19 == r21) goto L37;
    L39:
        boolean r23 = false;
    L40:
        ConstraintAnchor r110 = r18.mTarget;
        if (r110 == null) goto L44;
        if (r9 == r11) goto L44;
        r24 = r24 + r110.getMargin();
    L44:
        int r111 = r24;
        if (r7 == false) goto L50;
        if (r9 == r11) goto L50;
        if (r9 == r13) goto L50;
        r20 = 8;
    L50:
        ConstraintAnchor r27 = r18.mTarget;
        ConstraintWidget r28 = r11;
        if (r27 == null) goto L65;
        if (r9 != r13) goto L54;
        r39.addGreaterThan(r18.mSolverVariable, r27.mSolverVariable, r111, 6);
    L55:
        if (r23 == false) goto L58;
        if (r7 == true) goto L58;
        r20 = 5;
    L58:
        if (r9 != r13) goto L63;
        if (r7 == false) goto L63;
        if (r9.isInBarrier(r10) == false) goto L63;
        int r1 = 5;
    L64:
        r39.addEquality(r18.mSolverVariable, r18.mTarget.mSolverVariable, r111, r1);
    L63:
        r1 = r20;
        goto L64
    L54:
        r39.addGreaterThan(r18.mSolverVariable, r27.mSolverVariable, r111, 8);
    L65:
        if (r6 == true) goto L67;
    L73:
        ConstraintAnchor r29 = r9.mListAnchors[r41 + 1].mTarget;
        if (r29 == null) goto L81;
        ConstraintWidget r30 = r29.mOwner;
        ConstraintAnchor[] r31 = r30.mListAnchors;
        if (r31[r41].mTarget == null) goto L81;
        if (r31[r41].mTarget.mOwner != r9) goto L81;
        r22 = r30;
    L81:
        if (r22 == null) goto L83;
        r9 = r22;
        r17 = r26;
    L84:
        r2 = r2;
        r3 = r25;
        r15 = r15;
        r11 = r28;
        r9 = r9;
        goto L28
    L83:
        r17 = true;
        goto L84
    L67:
        if (r9.getVisibility() != 8) goto L69;
    L71:
        int r32 = 0;
    L72:
        r39.addGreaterThan(r9.mListAnchors[r41].mSolverVariable, r38.mListAnchors[r41].mSolverVariable, r32, 8);
        goto L73
    L69:
        if (r9.mListDimensionBehaviors[r10] != r21) goto L71;
        ConstraintAnchor[] r33 = r9.mListAnchors;
        r32 = 0;
        r39.addGreaterThan(r33[r41 + 1].mSolverVariable, r33[r41].mSolverVariable, 0, 5);
        goto L72
    L37:
        if (r9.mResolvedMatchConstraintDefault[r10] != 0) goto L39;
        r23 = true;
        goto L40
    L33:
        r20 = 4;
        goto L34
    L85:
        ConstraintWidget r210 = r2;
        float r211 = r3;
        ConstraintWidget r212 = r11;
        boolean r213 = r15;
        if (r14 == null) goto L107;
        int r34 = r41 + 1;
        if (r12.mListAnchors[r34].mTarget == null) goto L107;
        ConstraintAnchor r35 = r14.mListAnchors[r34];
        if (r14.mListDimensionBehaviors[r10] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L92;
    L94:
        boolean r36 = false;
    L95:
        if (r36 == false) goto L101;
        if (r7 == true) goto L101;
        ConstraintAnchor r37 = r35.mTarget;
        if (r37.mOwner != r38) goto L101;
        r39.addEquality(r35.mSolverVariable, r37.mSolverVariable, -r35.getMargin(), 5);
    L105:
        r39.addLowerThan(r35.mSolverVariable, r12.mListAnchors[r34].mTarget.mSolverVariable, -r35.getMargin(), 6);
    L101:
        if (r7 == false) goto L105;
        ConstraintAnchor r43 = r35.mTarget;
        if (r43.mOwner != r38) goto L105;
        r39.addEquality(r35.mSolverVariable, r43.mSolverVariable, -r35.getMargin(), 4);
        goto L105
    L92:
        if (r14.mResolvedMatchConstraintDefault[r10] != 0) goto L94;
        r36 = true;
    L107:
        if (r6 == false) goto L109;
        int r44 = r41 + 1;
        SolverVariable r0 = r38.mListAnchors[r44].mSolverVariable;
        ConstraintAnchor[] r45 = r12.mListAnchors;
        r39.addGreaterThan(r0, r45[r44].mSolverVariable, r45[r44].getMargin(), 8);
    L109:
        ArrayList<ConstraintWidget> r46 = r42.mWeightedMatchConstraintsWidgets;
        if (r46 == null) goto L138;
        int r47 = r46.size();
        if (r47 <= 1) goto L138;
        if (r42.mHasUndefinedWeights == true) goto L116;
    L118:
        float r48 = r211;
    L119:
        float r49 = 0.0f;
        float r310 = 0.0f;
        ConstraintWidget r112 = null;
        int r50 = 0;
    L120:
        if (r50 >= r47) goto L138;
        ConstraintWidget r113 = r46.get(r50);
        float r51 = r113.mWeight[r10];
        if (r51 >= r49) goto L129;
        if (r42.mHasComplexMatchWeights == false) goto L126;
        ConstraintAnchor[] r52 = r113.mListAnchors;
        r39.addEquality(r52[r41 + 1].mSolverVariable, r52[r41].mSolverVariable, 0, 4);
    L131:
        r46 = r46;
        r47 = r47;
    L137:
        r50 = r50 + 1;
        r47 = r47;
        r46 = r46;
        r49 = 0.0f;
        goto L120
    L126:
        r51 = 1.0f;
        r49 = 0.0f;
    L129:
        if (r51 != r49) goto L133;
        ConstraintAnchor[] r53 = r113.mListAnchors;
        r39.addEquality(r53[r41 + 1].mSolverVariable, r53[r41].mSolverVariable, 0, 8);
        goto L131
    L133:
        if (r112 == null) goto L136;
        ConstraintAnchor[] r54 = r112.mListAnchors;
        SolverVariable r114 = r54[r41].mSolverVariable;
        int r115 = r41 + 1;
        SolverVariable r55 = r54[r115].mSolverVariable;
        ConstraintAnchor[] r56 = r113.mListAnchors;
        SolverVariable r57 = r56[r41].mSolverVariable;
        SolverVariable r58 = r56[r115].mSolverVariable;
        ArrayRow r59 = r39.createRow();
        r59.createRowEqualMatchDimensions(r310, r48, r51, r114, r55, r57, r58);
        r39.addConstraint(r59);
    L136:
        r310 = r51;
        r112 = r113;
        goto L137
    L116:
        if (r42.mHasComplexMatchWeights == true) goto L118;
        r48 = r42.mWidgetsMatchCount;
    L138:
        if (r13 == null) goto L160;
        if (r13 == r14) goto L141;
        if (r7 == false) goto L160;
    L141:
        ConstraintAnchor r60 = r212.mListAnchors[r41];
        int r61 = r41 + 1;
        ConstraintAnchor r62 = r12.mListAnchors[r61];
        ConstraintAnchor r63 = r60.mTarget;
        if (r63 == null) goto L144;
        SolverVariable r64 = r63.mSolverVariable;
    L145:
        ConstraintAnchor r65 = r62.mTarget;
        if (r65 == null) goto L148;
        SolverVariable r66 = r65.mSolverVariable;
    L149:
        ConstraintAnchor r67 = r13.mListAnchors[r41];
        if (r14 == null) goto L152;
        r62 = r14.mListAnchors[r61];
    L152:
        if (r64 == null) goto L292;
        if (r66 == null) goto L292;
        if (r10 != 0) goto L157;
        float r68 = r210.mHorizontalBiasPercent;
    L158:
        int r69 = r67.getMargin();
        SolverVariable r70 = r64;
        r39.addCentering(r67.mSolverVariable, r70, r69, r68, r66, r62.mSolverVariable, r62.getMargin(), 7);
        goto L292
    L157:
        r68 = r210.mVerticalBiasPercent;
    L292:
        if (r213 == true) goto L294;
        if (r16 == true) goto L294;
        return;
    L294:
        if (r13 == null) goto L335;
        if (r13 == r14) goto L336;
        ConstraintAnchor[] r71 = r13.mListAnchors;
        ConstraintAnchor r72 = r71[r41];
        if (r14 != null) goto L299;
        r14 = r13;
    L299:
        int r73 = r41 + 1;
        ConstraintAnchor r74 = r14.mListAnchors[r73];
        ConstraintAnchor r75 = r72.mTarget;
        if (r75 == null) goto L302;
        SolverVariable r76 = r75.mSolverVariable;
    L303:
        ConstraintAnchor r77 = r74.mTarget;
        if (r77 == null) goto L306;
        ?? r78 = r77.mSolverVariable;
    L307:
        if (r12 == r14) goto L312;
        ConstraintAnchor r79 = r12.mListAnchors[r73].mTarget;
        if (r79 == null) goto L311;
        r22 = r79.mSolverVariable;
    L311:
        r78 = r22;
    L312:
        if (r13 != r14) goto L314;
        r72 = r71[r41];
        r74 = r71[r73];
    L314:
        if (r76 == null) goto L337;
        if (r78 == 0) goto L338;
        int r80 = r72.getMargin();
        int r81 = r14.mListAnchors[r73].getMargin();
        r39.addCentering(r72.mSolverVariable, r76, r80, 0.5f, r78, r74.mSolverVariable, r81, 5);
        return;
    L338:
        return;
    L337:
        return;
    L306:
        r78 = 0;
        goto L307
    L302:
        r76 = null;
        goto L303
    L336:
        return;
    L335:
        return;
    L148:
        r66 = null;
        goto L149
    L144:
        r64 = null;
    L160:
        if (r213 == false) goto L225;
        if (r13 == null) goto L225;
        int r82 = r42.mWidgetsMatchCount;
        if (r82 > 0) goto L165;
    L167:
        boolean r116 = false;
    L168:
        ConstraintWidget r83 = r13;
        ConstraintWidget r117 = r83;
    L169:
        if (r117 == null) goto L292;
        ConstraintWidget r84 = r117.mNextChainWidget[r10];
    L171:
        if (r84 == null) goto L176;
        if (r84.getVisibility() != 8) goto L176;
        r84 = r84.mNextChainWidget[r10];
    L176:
        if (r84 != null) goto L181;
        if (r117 == r14) goto L181;
    L221:
        if (r117.getVisibility() != 8) goto L224;
        r117 = r83;
    L224:
        r83 = r117;
        r117 = r84;
    L181:
        ConstraintAnchor r85 = r117.mListAnchors[r41];
        SolverVariable r86 = r85.mSolverVariable;
        ConstraintAnchor r87 = r85.mTarget;
        if (r87 == null) goto L184;
        SolverVariable r88 = r87.mSolverVariable;
    L185:
        if (r83 == r117) goto L188;
        ConstraintAnchor r89 = r83.mListAnchors[r41 + 1];
    L187:
        r88 = r89.mSolverVariable;
    L193:
        int r90 = r85.getMargin();
        int r91 = r41 + 1;
        int r92 = r117.mListAnchors[r91].getMargin();
        if (r84 == null) goto L197;
        ConstraintAnchor r93 = r84.mListAnchors[r41];
    L196:
        SolverVariable r94 = r93.mSolverVariable;
    L201:
        SolverVariable r95 = r117.mListAnchors[r91].mSolverVariable;
        if (r93 == null) goto L204;
        r92 = r92 + r93.getMargin();
    L204:
        int r96 = r90 + r83.mListAnchors[r91].getMargin();
        if (r86 == null) goto L221;
        if (r88 == null) goto L221;
        if (r94 == null) goto L221;
        if (r95 == null) goto L221;
        if (r117 != r13) goto L211;
        r96 = r13.mListAnchors[r41].getMargin();
    L211:
        int r97 = r96;
        if (r117 != r14) goto L214;
        int r118 = r14.mListAnchors[r91].getMargin();
    L215:
        if (r116 == false) goto L217;
        int r119 = 8;
    L218:
        r84 = r84;
        r39.addCentering(r86, r88, r97, 0.5f, r94, r95, r118, r119);
        goto L221
    L217:
        r119 = 5;
        goto L218
    L214:
        r118 = r92;
        goto L215
    L197:
        r93 = r12.mListAnchors[r91].mTarget;
        if (r93 != null) goto L196;
        r94 = null;
        goto L201
    L188:
        if (r117 != r13) goto L193;
        ConstraintAnchor[] r98 = r212.mListAnchors;
        if (r98[r41].mTarget == null) goto L192;
        r89 = r98[r41].mTarget;
        goto L187
    L192:
        r88 = null;
        goto L193
    L184:
        r88 = null;
        goto L185
    L165:
        if (r42.mWidgetsCount != r82) goto L167;
        r116 = true;
    L225:
        int r99 = 8;
        if (r16 == false) goto L292;
        if (r13 == null) goto L292;
        int r100 = r42.mWidgetsMatchCount;
        if (r100 > 0) goto L231;
    L233:
        boolean r120 = false;
    L234:
        ConstraintWidget r101 = r13;
        ConstraintWidget r121 = r101;
    L235:
        if (r121 == null) goto L281;
        ConstraintWidget r102 = r121.mNextChainWidget[r10];
    L237:
        if (r102 == null) goto L241;
        if (r102.getVisibility() != r99) goto L241;
        r102 = r102.mNextChainWidget[r10];
    L241:
        if (r121 == r13) goto L275;
        if (r121 == r14) goto L275;
        if (r102 == null) goto L275;
        if (r102 != r14) goto L246;
        ConstraintWidget r103 = null;
    L247:
        ConstraintAnchor r104 = r121.mListAnchors[r41];
        SolverVariable r105 = r104.mSolverVariable;
        ConstraintAnchor r106 = r104.mTarget;
        if (r106 == null) goto L250;
        SolverVariable r107 = r106.mSolverVariable;
    L250:
        int r108 = r41 + 1;
        SolverVariable r109 = r101.mListAnchors[r108].mSolverVariable;
        int r122 = r104.getMargin();
        int r123 = r121.mListAnchors[r108].getMargin();
        if (r103 == null) goto L257;
        ConstraintAnchor r124 = r103.mListAnchors[r41];
        SolverVariable r125 = r124.mSolverVariable;
        ConstraintAnchor r126 = r124.mTarget;
        if (r126 == null) goto L255;
        SolverVariable r127 = r126.mSolverVariable;
    L256:
        SolverVariable r128 = r127;
        SolverVariable r129 = r125;
    L262:
        if (r124 == null) goto L264;
        r123 = r123 + r124.getMargin();
    L264:
        int r130 = r123;
        int r131 = r101.mListAnchors[r108].getMargin() + r122;
        if (r120 == false) goto L267;
        int r132 = 8;
    L268:
        if (r105 == null) goto L273;
        if (r109 == null) goto L273;
        if (r129 == null) goto L273;
        if (r128 == null) goto L273;
        int r133 = 8;
        r39.addCentering(r105, r109, r131, 0.5f, r129, r128, r130, r132);
    L274:
        r102 = r103;
    L277:
        if (r121.getVisibility() == r133) goto L279;
        r101 = r121;
    L280:
        r121 = r102;
        r99 = r133;
        r10 = r40;
        goto L235
    L279:
        r101 = r101;
    L273:
        r133 = 8;
        goto L274
    L267:
        r132 = 4;
        goto L268
    L255:
        r127 = null;
        goto L256
    L257:
        r124 = r14.mListAnchors[r41];
        if (r124 == null) goto L260;
        r129 = r124.mSolverVariable;
    L261:
        r128 = r121.mListAnchors[r108].mSolverVariable;
        goto L262
    L260:
        r129 = null;
        goto L261
    L246:
        r103 = r102;
    L275:
        r101 = r101;
        r133 = r99;
        goto L277
    L281:
        ConstraintAnchor r134 = r13.mListAnchors[r41];
        ConstraintAnchor r135 = r212.mListAnchors[r41].mTarget;
        int r136 = r41 + 1;
        ConstraintAnchor r137 = r14.mListAnchors[r136];
        ConstraintAnchor r138 = r12.mListAnchors[r136].mTarget;
        if (r135 == null) goto L288;
        if (r13 == r14) goto L285;
        int r139 = 5;
        r39.addEquality(r134.mSolverVariable, r135.mSolverVariable, r134.getMargin(), 5);
    L289:
        if (r138 == null) goto L292;
        if (r13 == r14) goto L292;
        r39.addEquality(r137.mSolverVariable, r138.mSolverVariable, -r137.getMargin(), r139);
        goto L292
    L285:
        r139 = 5;
        if (r138 == null) goto L289;
        r39.addCentering(r134.mSolverVariable, r135.mSolverVariable, r134.getMargin(), 0.5f, r137.mSolverVariable, r138.mSolverVariable, r137.getMargin(), 5);
        goto L289
    L288:
        r139 = 5;
        goto L289
    L231:
        if (r42.mWidgetsCount != r100) goto L233;
        r120 = true;
    L25:
        r7 = true;
        goto L27
    L14:
        r16 = false;
        goto L15
    L11:
        r15 = false;
        goto L12
    L17:
        int r140 = r2.mVerticalChainStyle;
        if (r140 != 0) goto L20;
        r15 = true;
    L21:
        if (r140 != 1) goto L23;
        r16 = true;
    L24:
        if (r140 != 2) goto L26;
    L23:
        r16 = false;
        goto L24
    L20:
        r15 = false;
        goto L21
    L5:
        r6 = false;
        goto L7
    }

    public static void applyChainConstraints(ConstraintWidgetContainer r7, LinearSystem r8, ArrayList<ConstraintWidget> r9, int r10) {
        int r0 = 0;
        if (r10 != 0) goto L5;
        int r1 = r7.mHorizontalChainsSize;
        ChainHead[] r3 = r7.mHorizontalChainsArray;
        int r2 = 0;
    L6:
        if (r0 >= r1) goto L14;
        ChainHead r4 = r3[r0];
        r4.define();
        if (r9 == null) goto L12;
        if (r9 == null) goto L13;
        if (r9.contains(r4.mFirst) == true) goto L12;
    L13:
        r0 = r0 + 1;
    L12:
        applyChainConstraints(r7, r8, r10, r2, r4);
        goto L13
    L14:
        return;
    L5:
        int r5 = r7.mVerticalChainsSize;
        r3 = r7.mVerticalChainsArray;
        r2 = 2;
        r1 = r5;
        goto L6
    }
}
