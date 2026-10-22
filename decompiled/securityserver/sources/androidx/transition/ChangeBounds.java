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

    public static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private View mView;

        public ViewBounds(View r1) {
            this.mView = r1;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        public void setBottomRight(PointF r2) {
            this.mRight = Math.round(r2.x);
            this.mBottom = Math.round(r2.y);
            int r3 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = r3;
            if (this.mTopLeftCalls != r3) goto L6;
            setLeftTopRightBottom();
            return;
        }

        public void setTopLeft(PointF r2) {
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
        final String r1 = "boundsOrigin";
        final Class<PointF> r2 = PointF.class;
        DRAWABLE_ORIGIN_PROPERTY = new AnonymousClass1(r2, r1);
        final String r3 = "topLeft";
        TOP_LEFT_PROPERTY = new AnonymousClass2(r2, r3);
        final String r4 = "bottomRight";
        BOTTOM_RIGHT_PROPERTY = new AnonymousClass3(r2, r4);
        BOTTOM_RIGHT_ONLY_PROPERTY = new AnonymousClass4(r2, r4);
        TOP_LEFT_ONLY_PROPERTY = new AnonymousClass5(r2, r3);
        final String r5 = "position";
        POSITION_PROPERTY = new AnonymousClass6(r2, r5);
        sRectEvaluator = new RectEvaluator();
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
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
    public Animator createAnimator(@NonNull final ViewGroup r20, @Nullable TransitionValues r21, @Nullable TransitionValues r22) {
        if (r21 == null) goto L5;
        if (r22 == null) goto L5;
        Map<String, Object> r5 = r21.values;
        Map<String, Object> r6 = r22.values;
        ViewGroup r7 = (ViewGroup) r5.get(PROPNAME_PARENT);
        ViewGroup r8 = (ViewGroup) r6.get(PROPNAME_PARENT);
        if (r7 == null) goto L9;
        if (r8 == null) goto L9;
        final View r10 = r22.view;
        if (parentMatches(r7, r8) == false) goto L71;
        Rect r9 = (Rect) r21.values.get(PROPNAME_BOUNDS);
        Rect r11 = (Rect) r22.values.get(PROPNAME_BOUNDS);
        int r12 = r9.left;
        final int r13 = r11.left;
        int r14 = r9.top;
        final int r15 = r11.top;
        int r16 = r9.right;
        final int r17 = r11.right;
        int r18 = r9.bottom;
        final int r19 = r11.bottom;
        int r4 = r16 - r12;
        int r3 = r18 - r14;
        int r2 = r17 - r13;
        int r23 = r19 - r15;
        Rect r0 = (Rect) r21.values.get(PROPNAME_CLIP);
        final Rect r110 = (Rect) r22.values.get(PROPNAME_CLIP);
        if (r4 == 0) goto L15;
        if (r3 == 0) goto L15;
    L17:
        if (r12 != r13) goto L21;
        if (r14 != r15) goto L21;
        int r1 = 0;
    L22:
        if (r16 != r17) goto L24;
        if (r18 != r19) goto L24;
    L26:
        if (r0 != null) goto L28;
    L31:
        if (r0 != null) goto L35;
        if (r110 == null) goto L35;
    L34:
        r1 = r1 + 1;
    L35:
        if (r1 > 0) goto L37;
        return null;
    L37:
        if (this.mResizeClip == true) goto L49;
        final View r111 = r10;
        ViewUtils.setLeftTopRightBottom(r111, r12, r14, r16, r18);
        if (r1 != 2) goto L44;
        if (r4 != r2) goto L43;
        if (r3 != r23) goto L43;
        Animator r24 = ObjectAnimatorUtils.ofPointF(r111, POSITION_PROPERTY, getPathMotion().getPath(r12, r14, r13, r15));
    L67:
        if ((r111.getParent() instanceof ViewGroup) == false) goto L69;
        final ViewGroup r25 = (ViewGroup) r111.getParent();
        ViewGroupUtils.suppressLayout(r25, true);
        addListener(new AnonymousClass9(this, r25));
    L69:
        return r24;
    L43:
        final ViewBounds r26 = new ViewBounds(r111);
        ObjectAnimator r27 = ObjectAnimatorUtils.ofPointF(r26, TOP_LEFT_PROPERTY, getPathMotion().getPath(r12, r14, r13, r15));
        ObjectAnimator r28 = ObjectAnimatorUtils.ofPointF(r26, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(r16, r18, r17, r19));
        AnimatorSet r29 = new AnimatorSet();
        r29.playTogether(new Animator[]{r27, r28});
        r29.addListener(new AnonymousClass7(this, r26));
        r24 = r29;
        goto L67
    L44:
        if (r12 != r13) goto L48;
        if (r14 != r15) goto L48;
        r24 = ObjectAnimatorUtils.ofPointF(r111, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(r16, r18, r17, r19));
    L48:
        r24 = ObjectAnimatorUtils.ofPointF(r111, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(r12, r14, r13, r15));
        goto L67
    L49:
        r111 = r10;
        ViewUtils.setLeftTopRightBottom(r111, r12, r14, Math.max(r4, r2) + r12, Math.max(r3, r23) + r14);
        if (r12 != r13) goto L54;
        if (r14 != r15) goto L54;
        ObjectAnimator r112 = null;
    L55:
        if (r0 != null) goto L57;
        int r30 = 0;
        r0 = new Rect(0, 0, r4, r3);
    L58:
        if (r110 != null) goto L60;
        Rect r31 = new Rect(r30, r30, r2, r23);
    L62:
        if (r0.equals(r31) == true) goto L64;
        ViewCompat.setClipBounds(r111, r0);
        ObjectAnimator r32 = ObjectAnimator.ofObject(r111, "clipBounds", sRectEvaluator, new Object[]{r0, r31});
        r32.addListener(new AnonymousClass8(this, r111, r110, r13, r15, r17, r19));
        ObjectAnimator r33 = r32;
    L65:
        r24 = TransitionUtils.mergeAnimators(r112, r33);
        goto L67
    L64:
        r33 = null;
        goto L65
    L60:
        r31 = r110;
        goto L62
    L57:
        r30 = 0;
    L54:
        r112 = ObjectAnimatorUtils.ofPointF(r111, POSITION_PROPERTY, getPathMotion().getPath(r12, r14, r13, r15));
        goto L55
    L28:
        if (r0.equals(r110) == false) goto L34;
    L24:
        r1 = r1 + 1;
    L21:
        r1 = 1;
    L15:
        if (r2 == 0) goto L25;
        if (r23 != 0) goto L17;
    L25:
        r1 = 0;
        goto L26
    L71:
        int r34 = ((Integer) r21.values.get(PROPNAME_WINDOW_X)).intValue();
        int r35 = ((Integer) r21.values.get(PROPNAME_WINDOW_Y)).intValue();
        int r36 = ((Integer) r22.values.get(PROPNAME_WINDOW_X)).intValue();
        int r37 = ((Integer) r22.values.get(PROPNAME_WINDOW_Y)).intValue();
        if (r34 != r36) goto L76;
        if (r35 != r37) goto L76;
        return null;
    L76:
        r20.getLocationInWindow(this.mTempLocation);
        Bitmap r38 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        r10.draw(new Canvas(r38));
        final BitmapDrawable r39 = new BitmapDrawable(r38);
        final float r40 = ViewUtils.getTransitionAlpha(r10);
        ViewUtils.setTransitionAlpha(r10, 0.0f);
        ViewUtils.getOverlay(r20).add(r39);
        PathMotion r41 = getPathMotion();
        int[] r42 = this.mTempLocation;
        int r113 = r42[0];
        int r43 = r42[1];
        ObjectAnimator r44 = ObjectAnimator.ofPropertyValuesHolder(r39, new PropertyValuesHolder[]{PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, r41.getPath(r34 - r113, r35 - r43, r36 - r113, r37 - r43))});
        r44.addListener(new AnonymousClass10(this, r20, r39, r10, r40));
        return r44;
    L9:
        return null;
    L5:
        return null;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean r1) {
        this.mResizeClip = r1;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray r5 = r3.obtainStyledAttributes(r4, Styleable.CHANGE_BOUNDS);
        boolean r6 = TypedArrayUtils.getNamedBoolean(r5, (XmlResourceParser) r4, "resizeClip", 0, false);
        r5.recycle();
        setResizeClip(r6);
    }
}
