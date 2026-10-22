package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private int fadeMove;
    private float motionEffectAlpha;
    private int motionEffectEnd;
    private int motionEffectStart;
    private boolean motionEffectStrictMove;
    private int motionEffectTranslationX;
    private int motionEffectTranslationY;
    private int viewTransitionId;

    public MotionEffect(Context r1) {
        super(r1);
        this.motionEffectAlpha = 0.1f;
        this.motionEffectStart = 49;
        this.motionEffectEnd = 50;
        this.motionEffectTranslationX = 0;
        this.motionEffectTranslationY = 0;
        this.motionEffectStrictMove = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
    }

    public MotionEffect(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.motionEffectAlpha = 0.1f;
        this.motionEffectStart = 49;
        this.motionEffectEnd = 50;
        this.motionEffectTranslationX = 0;
        this.motionEffectTranslationY = 0;
        this.motionEffectStrictMove = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
        init(r2, r3);
    }

    public MotionEffect(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.motionEffectAlpha = 0.1f;
        this.motionEffectStart = 49;
        this.motionEffectEnd = 50;
        this.motionEffectTranslationX = 0;
        this.motionEffectTranslationY = 0;
        this.motionEffectStrictMove = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
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
        int r3 = r8.getInt(r2, this.motionEffectStart);
        this.motionEffectStart = r3;
        this.motionEffectStart = Math.max(Math.min(r3, 99), 0);
    L29:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 != R.styleable.MotionEffect_motionEffect_end) goto L12;
        int r4 = r8.getInt(r2, this.motionEffectEnd);
        this.motionEffectEnd = r4;
        this.motionEffectEnd = Math.max(Math.min(r4, 99), 0);
        goto L29
    L12:
        if (r2 != R.styleable.MotionEffect_motionEffect_translationX) goto L15;
        this.motionEffectTranslationX = r8.getDimensionPixelOffset(r2, this.motionEffectTranslationX);
        goto L29
    L15:
        if (r2 != R.styleable.MotionEffect_motionEffect_translationY) goto L18;
        this.motionEffectTranslationY = r8.getDimensionPixelOffset(r2, this.motionEffectTranslationY);
        goto L29
    L18:
        if (r2 != R.styleable.MotionEffect_motionEffect_alpha) goto L21;
        this.motionEffectAlpha = r8.getFloat(r2, this.motionEffectAlpha);
        goto L29
    L21:
        if (r2 != R.styleable.MotionEffect_motionEffect_move) goto L24;
        this.fadeMove = r8.getInt(r2, this.fadeMove);
        goto L29
    L24:
        if (r2 != R.styleable.MotionEffect_motionEffect_strict) goto L27;
        this.motionEffectStrictMove = r8.getBoolean(r2, this.motionEffectStrictMove);
        goto L29
    L27:
        if (r2 != R.styleable.MotionEffect_motionEffect_viewTransition) goto L29;
        this.viewTransitionId = r8.getResourceId(r2, this.viewTransitionId);
        goto L29
    L30:
        int r10 = this.motionEffectStart;
        int r0 = this.motionEffectEnd;
        if (r10 != r0) goto L35;
        if (r10 <= 0) goto L34;
        this.motionEffectStart = r10 - 1;
        goto L35
    L34:
        this.motionEffectEnd = r0 + 1;
    L35:
        r8.recycle();
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isDecorator() {
        return true;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreSetup(MotionLayout r22, HashMap<View, MotionController> r23) {
        HashMap<View, MotionController> r1 = r23;
        View[] r2 = getViews((ConstraintLayout) getParent());
        if (r2 != null) goto L6;
        Log.v(TAG, Debug.getLoc() + " views = null");
        return;
    L6:
        Key r3 = new KeyAttributes();
        Key r4 = new KeyAttributes();
        r3.setValue("alpha", Float.valueOf(this.motionEffectAlpha));
        r4.setValue("alpha", Float.valueOf(this.motionEffectAlpha));
        r3.setFramePosition(this.motionEffectStart);
        r4.setFramePosition(this.motionEffectEnd);
        KeyPosition r5 = new KeyPosition();
        r5.setFramePosition(this.motionEffectStart);
        r5.setType(0);
        r5.setValue("percentX", 0);
        r5.setValue("percentY", 0);
        KeyPosition r7 = new KeyPosition();
        r7.setFramePosition(this.motionEffectEnd);
        r7.setType(0);
        r7.setValue("percentX", 1);
        r7.setValue("percentY", 1);
        Key r9 = null;
        if (this.motionEffectTranslationX <= 0) goto L9;
        Key r8 = new KeyAttributes();
        Key r11 = new KeyAttributes();
        r8.setValue("translationX", Integer.valueOf(this.motionEffectTranslationX));
        r8.setFramePosition(this.motionEffectEnd);
        r11.setValue("translationX", 0);
        r11.setFramePosition(this.motionEffectEnd - 1);
    L11:
        if (this.motionEffectTranslationY <= 0) goto L13;
        r9 = new KeyAttributes();
        Key r12 = new KeyAttributes();
        r9.setValue("translationY", Integer.valueOf(this.motionEffectTranslationY));
        r9.setFramePosition(this.motionEffectEnd);
        r12.setValue("translationY", 0);
        r12.setFramePosition(this.motionEffectEnd - 1);
    L14:
        int r13 = this.fadeMove;
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
        if (r17 >= r15[r6]) goto L41;
        r13 = r6;
        r17 = r15[r6];
    L41:
        r6 = r6 + 1;
    L42:
        int r10 = 0;
    L44:
        if (r10 >= r2.length) goto L99;
        MotionController r18 = r1.get(r2[r10]);
        if (r18 == null) goto L98;
        float r110 = r18.getFinalX() - r18.getStartX();
        float r111 = r18.getFinalY() - r18.getStartY();
        if (r13 != 0) goto L60;
        if (r111 <= 0.0f) goto L86;
        if (this.motionEffectStrictMove == false) goto L57;
        if (r110 != 0.0f) goto L86;
    L57:
        boolean r112 = false;
    L87:
        if (r112 == false) goto L98;
        int r113 = this.viewTransitionId;
        if (r113 != (-1)) goto L97;
        r18.addKey(r3);
        r18.addKey(r4);
        r18.addKey(r5);
        r18.addKey(r7);
        if (this.motionEffectTranslationX <= 0) goto L94;
        r18.addKey(r8);
        r18.addKey(r11);
    L94:
        if (this.motionEffectTranslationY <= 0) goto L98;
        r18.addKey(r9);
        r18.addKey(r12);
        goto L98
    L97:
        r22.applyViewTransition(r113, r18);
    L86:
        r112 = true;
        goto L87
    L60:
        if (r13 != 1) goto L69;
        if (r111 >= 0.0f) goto L86;
        if (this.motionEffectStrictMove == false) goto L57;
        if (r110 != 0.0f) goto L86;
    L69:
        if (r13 != 2) goto L78;
        if (r110 >= 0.0f) goto L86;
        if (this.motionEffectStrictMove == false) goto L57;
        if (r111 != 0.0f) goto L86;
    L78:
        if (r13 != 3) goto L86;
        if (r110 <= 0.0f) goto L86;
        if (this.motionEffectStrictMove == false) goto L57;
        if (r111 != 0.0f) goto L86;
    L98:
        r10 = r10 + 1;
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
