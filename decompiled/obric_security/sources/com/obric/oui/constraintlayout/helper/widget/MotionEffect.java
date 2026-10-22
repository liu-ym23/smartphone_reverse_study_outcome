package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.Debug;
import com.obric.oui.constraintlayout.motion.widget.Key;
import com.obric.oui.constraintlayout.motion.widget.KeyAttributes;
import com.obric.oui.constraintlayout.motion.widget.KeyPosition;
import com.obric.oui.constraintlayout.motion.widget.MotionController;
import com.obric.oui.constraintlayout.motion.widget.MotionHelper;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private int mFadeMove;
    private float mMotionEffectAlpha;
    private int mMotionEffectEnd;
    private int mMotionEffectStart;
    private boolean mMotionEffectStrictMove;
    private int mMotionEffectTranslationX;
    private int mMotionEffectTranslationY;
    private int mViewTransitionId;

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isDecorator() {
        return true;
    }

    public MotionEffect(Context r1) {
        super(r1);
        this.mMotionEffectAlpha = 0.1f;
        this.mMotionEffectStart = 49;
        this.mMotionEffectEnd = 50;
        this.mMotionEffectTranslationX = 0;
        this.mMotionEffectTranslationY = 0;
        this.mMotionEffectStrictMove = true;
        this.mViewTransitionId = -1;
        this.mFadeMove = -1;
    }

    public MotionEffect(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mMotionEffectAlpha = 0.1f;
        this.mMotionEffectStart = 49;
        this.mMotionEffectEnd = 50;
        this.mMotionEffectTranslationX = 0;
        this.mMotionEffectTranslationY = 0;
        this.mMotionEffectStrictMove = true;
        this.mViewTransitionId = -1;
        this.mFadeMove = -1;
        init(r2, r3);
    }

    public MotionEffect(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mMotionEffectAlpha = 0.1f;
        this.mMotionEffectStart = 49;
        this.mMotionEffectEnd = 50;
        this.mMotionEffectTranslationX = 0;
        this.mMotionEffectTranslationY = 0;
        this.mMotionEffectStrictMove = true;
        this.mViewTransitionId = -1;
        this.mFadeMove = -1;
        init(r1, r2);
    }

    private void init(Context r6, AttributeSet r7) {
        if (r7 == null) goto L47;
        TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.MotionEffect);
        int r9 = r8.getIndexCount();
        int r1 = 0;
    L4:
        if (r1 >= r9) goto L30;
        int r2 = r8.getIndex(r1);
        if (r2 != R.styleable.MotionEffect_motionEffect_start) goto L9;
        int r3 = r8.getInt(r2, this.mMotionEffectStart);
        this.mMotionEffectStart = r3;
        this.mMotionEffectStart = Math.max(Math.min(r3, 99), 0);
    L29:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 != R.styleable.MotionEffect_motionEffect_end) goto L12;
        int r4 = r8.getInt(r2, this.mMotionEffectEnd);
        this.mMotionEffectEnd = r4;
        this.mMotionEffectEnd = Math.max(Math.min(r4, 99), 0);
        goto L29
    L12:
        if (r2 != R.styleable.MotionEffect_motionEffect_translationX) goto L15;
        this.mMotionEffectTranslationX = r8.getDimensionPixelOffset(r2, this.mMotionEffectTranslationX);
        goto L29
    L15:
        if (r2 != R.styleable.MotionEffect_motionEffect_translationY) goto L18;
        this.mMotionEffectTranslationY = r8.getDimensionPixelOffset(r2, this.mMotionEffectTranslationY);
        goto L29
    L18:
        if (r2 != R.styleable.MotionEffect_motionEffect_alpha) goto L21;
        this.mMotionEffectAlpha = r8.getFloat(r2, this.mMotionEffectAlpha);
        goto L29
    L21:
        if (r2 != R.styleable.MotionEffect_motionEffect_move) goto L24;
        this.mFadeMove = r8.getInt(r2, this.mFadeMove);
        goto L29
    L24:
        if (r2 != R.styleable.MotionEffect_motionEffect_strict) goto L27;
        this.mMotionEffectStrictMove = r8.getBoolean(r2, this.mMotionEffectStrictMove);
        goto L29
    L27:
        if (r2 != R.styleable.MotionEffect_motionEffect_viewTransition) goto L29;
        this.mViewTransitionId = r8.getResourceId(r2, this.mViewTransitionId);
        goto L29
    L30:
        int r10 = this.mMotionEffectStart;
        int r0 = this.mMotionEffectEnd;
        if (r10 != r0) goto L35;
        if (r10 <= 0) goto L34;
        this.mMotionEffectStart = r10 - 1;
        goto L35
    L34:
        this.mMotionEffectEnd = r0 + 1;
    L35:
        r8.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreSetup(MotionLayout r22, HashMap<View, MotionController> r23) {
        HashMap<View, MotionController> r1 = r23;
        View[] r2 = getViews((ConstraintLayout) getParent());
        if (r2 != null) goto L6;
        Log.v("FadeMove", Debug.getLoc() + " views = null");
        return;
    L6:
        Key r3 = new KeyAttributes();
        Key r4 = new KeyAttributes();
        r3.setValue("alpha", Float.valueOf(this.mMotionEffectAlpha));
        r4.setValue("alpha", Float.valueOf(this.mMotionEffectAlpha));
        r3.setFramePosition(this.mMotionEffectStart);
        r4.setFramePosition(this.mMotionEffectEnd);
        KeyPosition r5 = new KeyPosition();
        r5.setFramePosition(this.mMotionEffectStart);
        r5.setType(0);
        r5.setValue("percentX", 0);
        r5.setValue("percentY", 0);
        KeyPosition r7 = new KeyPosition();
        r7.setFramePosition(this.mMotionEffectEnd);
        r7.setType(0);
        r7.setValue("percentX", 1);
        r7.setValue("percentY", 1);
        Key r9 = null;
        if (this.mMotionEffectTranslationX <= 0) goto L9;
        Key r8 = new KeyAttributes();
        Key r11 = new KeyAttributes();
        r8.setValue("translationX", Integer.valueOf(this.mMotionEffectTranslationX));
        r8.setFramePosition(this.mMotionEffectEnd);
        r11.setValue("translationX", 0);
        r11.setFramePosition(this.mMotionEffectEnd - 1);
    L11:
        if (this.mMotionEffectTranslationY <= 0) goto L13;
        r9 = new KeyAttributes();
        Key r12 = new KeyAttributes();
        r9.setValue("translationY", Integer.valueOf(this.mMotionEffectTranslationY));
        r9.setFramePosition(this.mMotionEffectEnd);
        r12.setValue("translationY", 0);
        r12.setFramePosition(this.mMotionEffectEnd - 1);
    L14:
        int r13 = this.mFadeMove;
        if (r13 != (-1)) goto L42;
        int[] r15 = new int[4];
        int r14 = 0;
    L18:
        if (r14 >= r2.length) goto L35;
        MotionController r16 = r1.get(r2[r14]);
        if (r16 == null) goto L34;
        float r19 = r16.getFinalX() - r16.getStartX();
        float r20 = r16.getFinalY() - r16.getStartY();
        if (r20 >= 0.0f) goto L26;
        r15[1] = r15[1] + 1;
    L26:
        if (r20 <= 0.0f) goto L29;
        r15[0] = r15[0] + 1;
    L29:
        if (r19 <= 0.0f) goto L32;
        r15[3] = r15[3] + 1;
    L32:
        if (r19 >= 0.0f) goto L34;
        r15[2] = r15[2] + 1;
    L34:
        r14 = r14 + 1;
        goto L18
    L35:
        int r17 = r15[0];
        r13 = 0;
        int r6 = 1;
    L37:
        if (r6 >= 4) goto L42;
        int r10 = r15[r6];
        if (r17 >= r10) goto L41;
        r13 = r6;
        r17 = r10;
    L41:
        r6 = r6 + 1;
    L42:
        int r18 = 0;
    L44:
        if (r18 >= r2.length) goto L99;
        MotionController r110 = r1.get(r2[r18]);
        if (r110 == null) goto L98;
        float r111 = r110.getFinalX() - r110.getStartX();
        float r112 = r110.getFinalY() - r110.getStartY();
        if (r13 != 0) goto L60;
        if (r112 <= 0.0f) goto L86;
        if (this.mMotionEffectStrictMove == false) goto L57;
        if (r111 != 0.0f) goto L86;
    L57:
        boolean r113 = false;
    L87:
        if (r113 == false) goto L98;
        int r114 = this.mViewTransitionId;
        if (r114 != (-1)) goto L97;
        r110.addKey(r3);
        r110.addKey(r4);
        r110.addKey(r5);
        r110.addKey(r7);
        if (this.mMotionEffectTranslationX <= 0) goto L94;
        r110.addKey(r8);
        r110.addKey(r11);
    L94:
        if (this.mMotionEffectTranslationY <= 0) goto L98;
        r110.addKey(r9);
        r110.addKey(r12);
        goto L98
    L97:
        r22.applyViewTransition(r114, r110);
    L86:
        r113 = true;
        goto L87
    L60:
        if (r13 != 1) goto L69;
        if (r112 >= 0.0f) goto L86;
        if (this.mMotionEffectStrictMove == false) goto L57;
        if (r111 != 0.0f) goto L86;
    L69:
        if (r13 != 2) goto L78;
        if (r111 >= 0.0f) goto L86;
        if (this.mMotionEffectStrictMove == false) goto L57;
        if (r112 != 0.0f) goto L86;
    L78:
        if (r13 != 3) goto L86;
        if (r111 <= 0.0f) goto L86;
        if (this.mMotionEffectStrictMove == false) goto L57;
        if (r112 != 0.0f) goto L86;
    L98:
        r18 = r18 + 1;
        r1 = r23;
        goto L44
    L99:
        return;
    L13:
        r12 = null;
        goto L14
    L9:
        r8 = null;
        r11 = null;
        goto L11
    }
}
