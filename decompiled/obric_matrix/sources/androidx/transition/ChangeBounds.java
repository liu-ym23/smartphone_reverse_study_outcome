package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = null;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = null;
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY = null;
    private static final Property<View, PointF> POSITION_PROPERTY = null;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = null;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = null;
    private static RectEvaluator sRectEvaluator;
    private static final String[] sTransitionProperties = null;
    private boolean mReparent;
    private boolean mResizeClip;
    private int[] mTempLocation;

    private static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private View mView;

        ViewBounds(View r1) {
            this.mView = r1;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        void setBottomRight(PointF r2) {
            this.mRight = Math.round(r2.x);
            this.mBottom = Math.round(r2.y);
            int r3 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = r3;
            if (this.mTopLeftCalls != r3) goto L6;
            setLeftTopRightBottom();
            return;
        }

        void setTopLeft(PointF r2) {
            this.mLeft = Math.round(r2.x);
            this.mTop = Math.round(r2.y);
            int r3 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = r3;
            if (r3 != this.mBottomRightCalls) goto L6;
            setLeftTopRightBottom();
            return;
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
        final Class<PointF> r1 = PointF.class;
        final String r2 = "boundsOrigin";
        DRAWABLE_ORIGIN_PROPERTY = new AnonymousClass1(r1, r2);
        final Class<PointF> r3 = PointF.class;
        final String r4 = "topLeft";
        TOP_LEFT_PROPERTY = new AnonymousClass2(r3, r4);
        final Class<PointF> r5 = PointF.class;
        final String r6 = "bottomRight";
        BOTTOM_RIGHT_PROPERTY = new AnonymousClass3(r5, r6);
        final Class<PointF> r7 = PointF.class;
        BOTTOM_RIGHT_ONLY_PROPERTY = new AnonymousClass4(r7, r6);
        final Class<PointF> r8 = PointF.class;
        TOP_LEFT_ONLY_PROPERTY = new AnonymousClass5(r8, r4);
        final Class<PointF> r9 = PointF.class;
        final String r10 = "position";
        POSITION_PROPERTY = new AnonymousClass6(r9, r10);
        sRectEvaluator = new RectEvaluator();
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(@NonNull Context r3, @NonNull AttributeSet r4) {
        super(r3, r4);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray r5 = r3.obtainStyledAttributes(r4, Styleable.CHANGE_BOUNDS);
        boolean r6 = TypedArrayUtils.getNamedBoolean(r5, (XmlResourceParser) r4, "resizeClip", 0, false);
        r5.recycle();
        setResizeClip(r6);
    }

    private void captureValues(TransitionValues r8) {
        View r0 = r8.view;
        if (ViewCompat.isLaidOut(r0) == false) goto L5;
    L8:
        r8.values.put(PROPNAME_BOUNDS, new Rect(r0.getLeft(), r0.getTop(), r0.getRight(), r0.getBottom()));
        r8.values.put(PROPNAME_PARENT, r8.view.getParent());
        if (this.mReparent == false) goto L12;
        r8.view.getLocationInWindow(this.mTempLocation);
        r8.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
        r8.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
    L12:
        if (this.mResizeClip == false) goto L16;
        r8.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(r0));
        return;
    L16:
        return;
    L5:
        if (r0.getWidth() != 0) goto L8;
        if (r0.getHeight() != 0) goto L8;
    }

    private boolean parentMatches(View r3, View r4) {
        if (this.mReparent == false) goto L11;
        TransitionValues r2 = getMatchedTransitionValues(r3, true);
        if (r2 != null) goto L10;
        if (r3 != r4) goto L12;
        return true;
    L12:
        return false;
    L10:
        if (r4 != r2.view) goto L12;
        return true;
    L11:
        return true;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull final ViewGroup r19, @Nullable TransitionValues r20, @Nullable TransitionValues r21) {
        if (r20 == null) goto L78;
        if (r21 == null) goto L82;
        Map<String, Object> r3 = r20.values;
        Map<String, Object> r4 = r21.values;
        ViewGroup r5 = (ViewGroup) r3.get(PROPNAME_PARENT);
        ViewGroup r6 = (ViewGroup) r4.get(PROPNAME_PARENT);
        if (r5 == null) goto L76;
        if (r6 == null) goto L81;
        final View r9 = r21.view;
        if (parentMatches(r5, r6) == false) goto L68;
        Rect r7 = (Rect) r20.values.get(PROPNAME_BOUNDS);
        Rect r8 = (Rect) r21.values.get(PROPNAME_BOUNDS);
        int r10 = r7.left;
        final int r11 = r8.left;
        int r12 = r7.top;
        final int r13 = r8.top;
        int r14 = r7.right;
        final int r15 = r8.right;
        int r16 = r7.bottom;
        final int r17 = r8.bottom;
        int r18 = r14 - r10;
        int r2 = r16 - r12;
        int r110 = r15 - r11;
        int r22 = r17 - r13;
        Rect r0 = (Rect) r20.values.get(PROPNAME_CLIP);
        final Rect r23 = (Rect) r21.values.get(PROPNAME_CLIP);
        if (r18 == 0) goto L15;
        if (r2 == 0) goto L15;
    L17:
        if (r10 != r11) goto L21;
        if (r12 != r13) goto L21;
        int r1 = 0;
    L22:
        if (r14 != r15) goto L24;
        if (r16 != r17) goto L24;
    L26:
        if (r0 != null) goto L28;
    L29:
        if (r0 != null) goto L32;
        if (r23 == null) goto L32;
    L31:
        r1 = r1 + 1;
    L32:
        if (r1 > 0) goto L34;
        return null;
    L34:
        if (this.mResizeClip == true) goto L47;
        final View r24 = r9;
        ViewUtils.setLeftTopRightBottom(r24, r10, r12, r14, r16);
        if (r1 != 2) goto L41;
        if (r18 != r110) goto L40;
        if (r2 != r22) goto L40;
        Path r25 = getPathMotion().getPath(r10, r12, r11, r13);
        Property<View, PointF> r26 = POSITION_PROPERTY;
    L46:
        Animator r27 = ObjectAnimatorUtils.ofPointF(r24, r26, r25);
    L65:
        if ((r24.getParent() instanceof ViewGroup) == false) goto L67;
        final ViewGroup r28 = (ViewGroup) r24.getParent();
        ViewGroupUtils.suppressLayout(r28, true);
        addListener(new AnonymousClass9(this, r28));
    L67:
        return r27;
    L40:
        final ViewBounds r29 = new ViewBounds(r24);
        ObjectAnimator r30 = ObjectAnimatorUtils.ofPointF(r29, TOP_LEFT_PROPERTY, getPathMotion().getPath(r10, r12, r11, r13));
        ObjectAnimator r31 = ObjectAnimatorUtils.ofPointF(r29, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(r14, r16, r15, r17));
        AnimatorSet r32 = new AnimatorSet();
        r32.playTogether(new Animator[]{r30, r31});
        r32.addListener(new AnonymousClass7(this, r29));
        r27 = r32;
        goto L65
    L41:
        if (r10 != r11) goto L45;
        if (r12 != r13) goto L45;
        r25 = getPathMotion().getPath(r14, r16, r15, r17);
        r26 = BOTTOM_RIGHT_ONLY_PROPERTY;
    L45:
        r25 = getPathMotion().getPath(r10, r12, r11, r13);
        r26 = TOP_LEFT_ONLY_PROPERTY;
        goto L46
    L47:
        r24 = r9;
        ViewUtils.setLeftTopRightBottom(r24, r10, r12, Math.max(r18, r110) + r10, Math.max(r2, r22) + r12);
        if (r10 != r11) goto L52;
        if (r12 != r13) goto L52;
        ObjectAnimator r111 = null;
    L53:
        if (r0 != null) goto L55;
        int r33 = 0;
        Rect r34 = new Rect(0, 0, r18, r2);
    L56:
        if (r23 != null) goto L58;
        Rect r35 = new Rect(r33, r33, r110, r22);
    L60:
        if (r34.equals(r35) == true) goto L62;
        ViewCompat.setClipBounds(r24, r34);
        RectEvaluator r36 = sRectEvaluator;
        Object[] r37 = new Object[2];
        r37[r33] = r34;
        r37[1] = r35;
        ObjectAnimator r112 = ObjectAnimator.ofObject(r24, "clipBounds", r36, r37);
        r112.addListener(new AnonymousClass8(this, r24, r23, r11, r13, r15, r17));
        ObjectAnimator r38 = r112;
    L63:
        r27 = TransitionUtils.mergeAnimators(r111, r38);
        goto L65
    L62:
        r38 = null;
        goto L63
    L58:
        r35 = r23;
        goto L60
    L55:
        r33 = 0;
        r34 = r0;
    L52:
        r111 = ObjectAnimatorUtils.ofPointF(r24, POSITION_PROPERTY, getPathMotion().getPath(r10, r12, r11, r13));
        goto L53
    L28:
        if (r0.equals(r23) == false) goto L31;
    L24:
        r1 = r1 + 1;
    L21:
        r1 = 1;
    L15:
        if (r110 == 0) goto L25;
        if (r22 != 0) goto L17;
    L25:
        r1 = 0;
        goto L26
    L68:
        int r39 = ((Integer) r20.values.get(PROPNAME_WINDOW_X)).intValue();
        int r40 = ((Integer) r20.values.get(PROPNAME_WINDOW_Y)).intValue();
        int r41 = ((Integer) r21.values.get(PROPNAME_WINDOW_X)).intValue();
        int r42 = ((Integer) r21.values.get(PROPNAME_WINDOW_Y)).intValue();
        if (r39 != r41) goto L74;
        if (r40 != r42) goto L74;
        return null;
    L74:
        r19.getLocationInWindow(this.mTempLocation);
        Bitmap r43 = Bitmap.createBitmap(r9.getWidth(), r9.getHeight(), Bitmap.Config.ARGB_8888);
        r9.draw(new Canvas(r43));
        final BitmapDrawable r44 = new BitmapDrawable(r43);
        final float r45 = ViewUtils.getTransitionAlpha(r9);
        ViewUtils.setTransitionAlpha(r9, 0.0f);
        ViewUtils.getOverlay(r19).add(r44);
        PathMotion r46 = getPathMotion();
        int[] r113 = this.mTempLocation;
        ObjectAnimator r114 = ObjectAnimator.ofPropertyValuesHolder(r44, new PropertyValuesHolder[]{PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, r46.getPath(r39 - r113[0], r40 - r113[1], r41 - r113[0], r42 - r113[1]))});
        r114.addListener(new AnonymousClass10(this, r19, r44, r9, r45));
        return r114;
    L81:
        return null;
    L76:
        return null;
    L82:
        return null;
    L78:
        return null;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean r1) {
        this.mResizeClip = r1;
    }
}
