package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.ArrayRow;
import com.obric.oui.constraintlayout.core.LinearSystem;
import com.obric.oui.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
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
    /* JADX WARN: Type inference failed for: r39v0, types: [com.obric.oui.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27, types: [com.obric.oui.constraintlayout.core.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.obric.oui.constraintlayout.core.widgets.ConstraintWidget] */
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
        if (r10 != 0) goto L20;
        if (r2.mHorizontalChainStyle != 0) goto L11;
        boolean r8 = true;
    L13:
        if (r2.mHorizontalChainStyle != 1) goto L15;
        boolean r15 = true;
    L17:
        if (r2.mHorizontalChainStyle == 2) goto L29;
    L30:
        boolean r7 = false;
    L31:
        boolean r17 = r15;
        boolean r9 = false;
        boolean r16 = r8;
        ?? r18 = r11;
    L32:
        Object r22 = null;
        if (r9 == true) goto L90;
        ConstraintAnchor r19 = r18.mListAnchors[r41];
        if (r7 == false) goto L37;
        int r20 = 1;
    L38:
        int r24 = r19.getMargin();
        float r25 = r3;
        boolean r26 = r9;
        if (r18.mListDimensionBehaviors[r10] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L41;
    L43:
        boolean r21 = false;
    L45:
        if (r19.mTarget == null) goto L48;
        if (r18 == r11) goto L48;
        r24 = r24 + r19.mTarget.getMargin();
    L48:
        int r23 = r24;
        if (r7 == false) goto L55;
        if (r18 == r11) goto L55;
        if (r18 == r13) goto L55;
        r20 = 8;
    L55:
        if (r19.mTarget == null) goto L69;
        if (r18 != r13) goto L58;
        r39.addGreaterThan(r19.mSolverVariable, r19.mTarget.mSolverVariable, r23, 6);
    L59:
        if (r21 == false) goto L62;
        if (r7 == true) goto L62;
        r20 = 5;
    L62:
        if (r18 != r13) goto L67;
        if (r7 == false) goto L67;
        if (r18.isInBarrier(r10) == false) goto L67;
        int r27 = 5;
    L68:
        r39.addEquality(r19.mSolverVariable, r19.mTarget.mSolverVariable, r23, r27);
    L70:
        if (r6 == true) goto L72;
    L78:
        ConstraintAnchor r28 = r18.mListAnchors[r41 + 1].mTarget;
        if (r28 == null) goto L86;
        ConstraintWidget r29 = r28.mOwner;
        if (r29.mListAnchors[r41].mTarget == null) goto L86;
        if (r29.mListAnchors[r41].mTarget.mOwner != r18) goto L86;
        r22 = r29;
    L86:
        if (r22 == null) goto L88;
        r18 = r22;
        r9 = r26;
    L89:
        r16 = r16;
        r3 = r25;
        r2 = r2;
        r11 = r11;
        r18 = r18;
        goto L32
    L88:
        r9 = true;
        goto L89
    L72:
        if (r18.getVisibility() != 8) goto L74;
    L76:
        int r30 = 0;
    L77:
        r39.addGreaterThan(r18.mListAnchors[r41].mSolverVariable, r38.mListAnchors[r41].mSolverVariable, r30, 8);
        goto L78
    L74:
        if (r18.mListDimensionBehaviors[r10] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L76;
        r30 = 0;
        r39.addGreaterThan(r18.mListAnchors[r41 + 1].mSolverVariable, r18.mListAnchors[r41].mSolverVariable, 0, 5);
    L67:
        r27 = r20;
        goto L68
    L58:
        r39.addGreaterThan(r19.mSolverVariable, r19.mTarget.mSolverVariable, r23, 8);
        goto L59
    L69:
        r2 = r2;
        r11 = r11;
        goto L70
    L41:
        if (r18.mResolvedMatchConstraintDefault[r10] != 0) goto L43;
        r21 = true;
        goto L45
    L37:
        r20 = 4;
        goto L38
    L90:
        ConstraintWidget r210 = r2;
        float r211 = r3;
        ConstraintWidget r212 = r11;
        boolean r213 = r16;
        if (r14 == null) goto L112;
        int r31 = r41 + 1;
        if (r12.mListAnchors[r31].mTarget == null) goto L112;
        ConstraintAnchor r32 = r14.mListAnchors[r31];
        if (r14.mListDimensionBehaviors[r10] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L97;
    L99:
        boolean r33 = false;
    L100:
        if (r33 == false) goto L106;
        if (r7 == true) goto L106;
        if (r32.mTarget.mOwner != r38) goto L106;
        r39.addEquality(r32.mSolverVariable, r32.mTarget.mSolverVariable, -r32.getMargin(), 5);
    L110:
        r39.addLowerThan(r32.mSolverVariable, r12.mListAnchors[r31].mTarget.mSolverVariable, -r32.getMargin(), 6);
    L106:
        if (r7 == false) goto L110;
        if (r32.mTarget.mOwner != r38) goto L110;
        r39.addEquality(r32.mSolverVariable, r32.mTarget.mSolverVariable, -r32.getMargin(), 4);
        goto L110
    L97:
        if (r14.mResolvedMatchConstraintDefault[r10] != 0) goto L99;
        r33 = true;
    L112:
        if (r6 == false) goto L114;
        int r34 = r41 + 1;
        r39.addGreaterThan(r38.mListAnchors[r34].mSolverVariable, r12.mListAnchors[r34].mSolverVariable, r12.mListAnchors[r34].getMargin(), 8);
    L114:
        ArrayList<ConstraintWidget> r0 = r42.mWeightedMatchConstraintsWidgets;
        if (r0 == null) goto L143;
        int r35 = r0.size();
        if (r35 <= 1) goto L143;
        if (r42.mHasUndefinedWeights == true) goto L121;
    L123:
        float r36 = r211;
    L124:
        float r37 = 0.0f;
        float r310 = 0.0f;
        ConstraintWidget r43 = null;
        int r44 = 0;
    L125:
        if (r44 >= r35) goto L143;
        ConstraintWidget r110 = r0.get(r44);
        float r45 = r110.mWeight[r10];
        if (r45 >= r37) goto L134;
        if (r42.mHasComplexMatchWeights == false) goto L131;
        r39.addEquality(r110.mListAnchors[r41 + 1].mSolverVariable, r110.mListAnchors[r41].mSolverVariable, 0, 4);
    L136:
        r0 = r0;
        r35 = r35;
    L142:
        r44 = r44 + 1;
        r35 = r35;
        r0 = r0;
        r37 = 0.0f;
        goto L125
    L131:
        r45 = 1.0f;
        r37 = 0.0f;
    L134:
        if (r45 != r37) goto L138;
        r39.addEquality(r110.mListAnchors[r41 + 1].mSolverVariable, r110.mListAnchors[r41].mSolverVariable, 0, 8);
        goto L136
    L138:
        if (r43 == null) goto L141;
        SolverVariable r46 = r43.mListAnchors[r41].mSolverVariable;
        int r111 = r41 + 1;
        SolverVariable r47 = r43.mListAnchors[r111].mSolverVariable;
        SolverVariable r112 = r110.mListAnchors[r41].mSolverVariable;
        SolverVariable r1 = r110.mListAnchors[r111].mSolverVariable;
        ArrayRow r48 = r39.createRow();
        r48.createRowEqualMatchDimensions(r310, r36, r45, r46, r47, r112, r1);
        r39.addConstraint(r48);
    L141:
        r310 = r45;
        r43 = r110;
        goto L142
    L121:
        if (r42.mHasComplexMatchWeights == true) goto L123;
        r36 = r42.mWidgetsMatchCount;
    L143:
        if (r13 == null) goto L164;
        if (r13 == r14) goto L146;
        if (r7 == false) goto L164;
    L146:
        ConstraintAnchor r49 = r212.mListAnchors[r41];
        int r50 = r41 + 1;
        ConstraintAnchor r51 = r12.mListAnchors[r50];
        if (r49.mTarget == null) goto L149;
        SolverVariable r52 = r49.mTarget.mSolverVariable;
    L151:
        if (r51.mTarget == null) goto L153;
        SolverVariable r53 = r51.mTarget.mSolverVariable;
    L154:
        ConstraintAnchor r54 = r13.mListAnchors[r41];
        if (r14 == null) goto L157;
        r51 = r14.mListAnchors[r50];
    L157:
        if (r52 == null) goto L295;
        if (r53 == null) goto L295;
        if (r10 != 0) goto L161;
        float r55 = r210.mHorizontalBiasPercent;
    L162:
        int r56 = r54.getMargin();
        SolverVariable r57 = r52;
        r39.addCentering(r54.mSolverVariable, r57, r56, r55, r53, r51.mSolverVariable, r51.getMargin(), 7);
        goto L295
    L161:
        r55 = r210.mVerticalBiasPercent;
    L295:
        if (r213 == true) goto L297;
        if (r17 == true) goto L297;
        return;
    L297:
        if (r13 == null) goto L339;
        if (r13 == r14) goto L340;
        ConstraintAnchor r58 = r13.mListAnchors[r41];
        if (r14 != null) goto L302;
        r14 = r13;
    L302:
        int r59 = r41 + 1;
        ConstraintAnchor r60 = r14.mListAnchors[r59];
        if (r58.mTarget == null) goto L305;
        SolverVariable r61 = r58.mTarget.mSolverVariable;
    L307:
        if (r60.mTarget == null) goto L309;
        SolverVariable r62 = r60.mTarget.mSolverVariable;
    L310:
        if (r12 == r14) goto L315;
        ConstraintAnchor r63 = r12.mListAnchors[r59];
        if (r63.mTarget == null) goto L314;
        r22 = r63.mTarget.mSolverVariable;
    L314:
        ?? r64 = r22;
    L316:
        if (r13 != r14) goto L318;
        r58 = r13.mListAnchors[r41];
        r60 = r13.mListAnchors[r59];
    L318:
        if (r61 == null) goto L341;
        if (r64 == 0) goto L342;
        int r65 = r58.getMargin();
        int r66 = r14.mListAnchors[r59].getMargin();
        r39.addCentering(r58.mSolverVariable, r61, r65, 0.5f, r64, r60.mSolverVariable, r66, 5);
        return;
    L342:
        return;
    L341:
        return;
    L315:
        r64 = r62;
        goto L316
    L309:
        r62 = null;
        goto L310
    L305:
        r61 = null;
        goto L307
    L340:
        return;
    L339:
        return;
    L153:
        r53 = null;
        goto L154
    L149:
        r52 = null;
    L164:
        if (r213 == false) goto L228;
        if (r13 == null) goto L228;
        if (r42.mWidgetsMatchCount > 0) goto L169;
    L171:
        boolean r113 = false;
    L172:
        ConstraintWidget r67 = r13;
        ConstraintWidget r114 = r67;
    L173:
        if (r114 == null) goto L295;
        ConstraintWidget r68 = r114.mNextChainWidget[r10];
    L175:
        if (r68 == null) goto L180;
        if (r68.getVisibility() != 8) goto L180;
        r68 = r68.mNextChainWidget[r10];
    L180:
        if (r68 != null) goto L185;
        if (r114 == r14) goto L185;
    L224:
        if (r114.getVisibility() != 8) goto L227;
        r114 = r67;
    L227:
        r67 = r114;
        r114 = r68;
    L185:
        ConstraintAnchor r69 = r114.mListAnchors[r41];
        SolverVariable r70 = r69.mSolverVariable;
        if (r69.mTarget == null) goto L188;
        SolverVariable r71 = r69.mTarget.mSolverVariable;
    L189:
        if (r67 == r114) goto L191;
        r71 = r67.mListAnchors[r41 + 1].mSolverVariable;
    L196:
        int r72 = r69.getMargin();
        int r73 = r41 + 1;
        int r74 = r114.mListAnchors[r73].getMargin();
        if (r68 == null) goto L200;
        ConstraintAnchor r75 = r68.mListAnchors[r41];
        SolverVariable r76 = r75.mSolverVariable;
    L204:
        SolverVariable r77 = r114.mListAnchors[r73].mSolverVariable;
        if (r75 == null) goto L207;
        r74 = r74 + r75.getMargin();
    L207:
        int r78 = r72 + r67.mListAnchors[r73].getMargin();
        if (r70 == null) goto L224;
        if (r71 == null) goto L224;
        if (r76 == null) goto L224;
        if (r77 == null) goto L224;
        if (r114 != r13) goto L214;
        r78 = r13.mListAnchors[r41].getMargin();
    L214:
        int r79 = r78;
        if (r114 != r14) goto L217;
        int r115 = r14.mListAnchors[r73].getMargin();
    L218:
        if (r113 == false) goto L220;
        int r116 = 8;
    L221:
        r68 = r68;
        r39.addCentering(r70, r71, r79, 0.5f, r76, r77, r115, r116);
        goto L224
    L220:
        r116 = 5;
        goto L221
    L217:
        r115 = r74;
        goto L218
    L200:
        r75 = r12.mListAnchors[r73].mTarget;
        if (r75 == null) goto L203;
        r76 = r75.mSolverVariable;
        goto L204
    L203:
        r76 = null;
        goto L204
    L191:
        if (r114 != r13) goto L196;
        if (r212.mListAnchors[r41].mTarget == null) goto L195;
        r71 = r212.mListAnchors[r41].mTarget.mSolverVariable;
        goto L196
    L195:
        r71 = null;
        goto L196
    L188:
        r71 = null;
        goto L189
    L169:
        if (r42.mWidgetsCount != r42.mWidgetsMatchCount) goto L171;
        r113 = true;
    L228:
        int r80 = 8;
        if (r17 == false) goto L295;
        if (r13 == null) goto L295;
        if (r42.mWidgetsMatchCount > 0) goto L234;
    L236:
        boolean r117 = false;
    L237:
        ConstraintWidget r81 = r13;
        ConstraintWidget r118 = r81;
    L238:
        if (r118 == null) goto L284;
        ConstraintWidget r82 = r118.mNextChainWidget[r10];
    L240:
        if (r82 == null) goto L244;
        if (r82.getVisibility() != r80) goto L244;
        r82 = r82.mNextChainWidget[r10];
    L244:
        if (r118 == r13) goto L278;
        if (r118 == r14) goto L278;
        if (r82 == null) goto L278;
        if (r82 != r14) goto L249;
        ConstraintWidget r83 = null;
    L250:
        ConstraintAnchor r84 = r118.mListAnchors[r41];
        SolverVariable r85 = r84.mSolverVariable;
        if (r84.mTarget == null) goto L253;
        SolverVariable r86 = r84.mTarget.mSolverVariable;
    L253:
        int r87 = r41 + 1;
        SolverVariable r88 = r81.mListAnchors[r87].mSolverVariable;
        int r89 = r84.getMargin();
        int r90 = r118.mListAnchors[r87].getMargin();
        if (r83 == null) goto L260;
        ConstraintAnchor r91 = r83.mListAnchors[r41];
        SolverVariable r92 = r91.mSolverVariable;
        if (r91.mTarget == null) goto L258;
        SolverVariable r93 = r91.mTarget.mSolverVariable;
    L259:
        SolverVariable r94 = r93;
        SolverVariable r95 = r92;
    L265:
        if (r91 == null) goto L267;
        r90 = r90 + r91.getMargin();
    L267:
        int r119 = r90;
        int r96 = r81.mListAnchors[r87].getMargin() + r89;
        if (r117 == false) goto L270;
        int r120 = 8;
    L271:
        if (r85 == null) goto L276;
        if (r88 == null) goto L276;
        if (r95 == null) goto L276;
        if (r94 == null) goto L276;
        int r121 = 8;
        r39.addCentering(r85, r88, r96, 0.5f, r95, r94, r119, r120);
    L277:
        r82 = r83;
    L280:
        if (r118.getVisibility() == r121) goto L282;
        r81 = r118;
    L283:
        r118 = r82;
        r80 = r121;
        r10 = r40;
        goto L238
    L282:
        r81 = r81;
    L276:
        r121 = 8;
        goto L277
    L270:
        r120 = 4;
        goto L271
    L258:
        r93 = null;
        goto L259
    L260:
        r91 = r14.mListAnchors[r41];
        if (r91 == null) goto L263;
        r95 = r91.mSolverVariable;
    L264:
        r94 = r118.mListAnchors[r87].mSolverVariable;
        goto L265
    L263:
        r95 = null;
        goto L264
    L249:
        r83 = r82;
    L278:
        r81 = r81;
        r121 = r80;
        goto L280
    L284:
        ConstraintAnchor r97 = r13.mListAnchors[r41];
        ConstraintAnchor r98 = r212.mListAnchors[r41].mTarget;
        int r99 = r41 + 1;
        ConstraintAnchor r122 = r14.mListAnchors[r99];
        ConstraintAnchor r123 = r12.mListAnchors[r99].mTarget;
        if (r98 == null) goto L291;
        if (r13 == r14) goto L288;
        int r124 = 5;
        r39.addEquality(r97.mSolverVariable, r98.mSolverVariable, r97.getMargin(), 5);
    L292:
        if (r123 == null) goto L295;
        if (r13 == r14) goto L295;
        r39.addEquality(r122.mSolverVariable, r123.mSolverVariable, -r122.getMargin(), r124);
        goto L295
    L288:
        r124 = 5;
        if (r123 == null) goto L292;
        r39.addCentering(r97.mSolverVariable, r98.mSolverVariable, r97.getMargin(), 0.5f, r122.mSolverVariable, r123.mSolverVariable, r122.getMargin(), 5);
        goto L292
    L291:
        r124 = 5;
        goto L292
    L234:
        if (r42.mWidgetsCount != r42.mWidgetsMatchCount) goto L236;
        r117 = true;
    L29:
        r7 = true;
        goto L31
    L15:
        r15 = false;
        goto L17
    L11:
        r8 = false;
        goto L13
    L20:
        if (r2.mVerticalChainStyle != 0) goto L22;
        r8 = true;
    L24:
        if (r2.mVerticalChainStyle != 1) goto L26;
        r15 = true;
    L28:
        if (r2.mVerticalChainStyle != 2) goto L30;
    L26:
        r15 = false;
        goto L28
    L22:
        r8 = false;
        goto L24
    L5:
        r6 = false;
        goto L7
    }
}
