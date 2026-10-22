package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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

        void setTopLeft(PointF r2) {
            this.mLeft = Math.round(r2.x);
            this.mTop = Math.round(r2.y);
            int r3 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = r3;
            if (r3 != this.mBottomRightCalls) goto L6;
            setLeftTopRightBottom();
            return;
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

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
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

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean r1) {
        this.mResizeClip = r1;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
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

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        captureValues(r1);
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
    public Animator createAnimator(final ViewGroup r19, TransitionValues r20, TransitionValues r21) {
        if (r20 == null) goto L77;
        if (r21 == null) goto L81;
        Map<String, Object> r3 = r20.values;
        Map<String, Object> r4 = r21.values;
        ViewGroup r5 = (ViewGroup) r3.get(PROPNAME_PARENT);
        ViewGroup r6 = (ViewGroup) r4.get(PROPNAME_PARENT);
        if (r5 == null) goto L75;
        if (r6 == null) goto L80;
        final View r9 = r21.view;
        if (parentMatches(r5, r6) == false) goto L67;
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
        if (this.mResizeClip == true) goto L46;
        final View r24 = r9;
        ViewUtils.setLeftTopRightBottom(r24, r10, r12, r14, r16);
        if (r1 != 2) goto L41;
        if (r18 != r110) goto L40;
        if (r2 != r22) goto L40;
        Animator r25 = ObjectAnimatorUtils.ofPointF(r24, POSITION_PROPERTY, getPathMotion().getPath(r10, r12, r11, r13));
    L64:
        if ((r24.getParent() instanceof ViewGroup) == false) goto L66;
        final ViewGroup r26 = (ViewGroup) r24.getParent();
        ViewGroupUtils.suppressLayout(r26, true);
        addListener(new AnonymousClass9(this, r26));
    L66:
        return r25;
    L40:
        final ViewBounds r27 = new ViewBounds(r24);
        ObjectAnimator r28 = ObjectAnimatorUtils.ofPointF(r27, TOP_LEFT_PROPERTY, getPathMotion().getPath(r10, r12, r11, r13));
        ObjectAnimator r29 = ObjectAnimatorUtils.ofPointF(r27, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(r14, r16, r15, r17));
        AnimatorSet r30 = new AnimatorSet();
        r30.playTogether(new Animator[]{r28, r29});
        r30.addListener(new AnonymousClass7(this, r27));
        r25 = r30;
        goto L64
    L41:
        if (r10 != r11) goto L45;
        if (r12 != r13) goto L45;
        r25 = ObjectAnimatorUtils.ofPointF(r24, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(r14, r16, r15, r17));
    L45:
        r25 = ObjectAnimatorUtils.ofPointF(r24, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(r10, r12, r11, r13));
        goto L64
    L46:
        r24 = r9;
        ViewUtils.setLeftTopRightBottom(r24, r10, r12, Math.max(r18, r110) + r10, Math.max(r2, r22) + r12);
        if (r10 != r11) goto L51;
        if (r12 != r13) goto L51;
        ObjectAnimator r111 = null;
    L52:
        if (r0 != null) goto L54;
        int r31 = 0;
        Rect r32 = new Rect(0, 0, r18, r2);
    L55:
        if (r23 != null) goto L57;
        Rect r33 = new Rect(r31, r31, r110, r22);
    L59:
        if (r32.equals(r33) == true) goto L61;
        ViewCompat.setClipBounds(r24, r32);
        RectEvaluator r34 = sRectEvaluator;
        Object[] r35 = new Object[2];
        r35[r31] = r32;
        r35[1] = r33;
        ObjectAnimator r112 = ObjectAnimator.ofObject(r24, "clipBounds", r34, r35);
        r112.addListener(new AnonymousClass8(this, r24, r23, r11, r13, r15, r17));
        ObjectAnimator r36 = r112;
    L62:
        r25 = TransitionUtils.mergeAnimators(r111, r36);
        goto L64
    L61:
        r36 = null;
        goto L62
    L57:
        r33 = r23;
        goto L59
    L54:
        r31 = 0;
        r32 = r0;
    L51:
        r111 = ObjectAnimatorUtils.ofPointF(r24, POSITION_PROPERTY, getPathMotion().getPath(r10, r12, r11, r13));
        goto L52
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
    L67:
        int r37 = ((Integer) r20.values.get(PROPNAME_WINDOW_X)).intValue();
        int r38 = ((Integer) r20.values.get(PROPNAME_WINDOW_Y)).intValue();
        int r39 = ((Integer) r21.values.get(PROPNAME_WINDOW_X)).intValue();
        int r40 = ((Integer) r21.values.get(PROPNAME_WINDOW_Y)).intValue();
        if (r37 != r39) goto L73;
        if (r38 != r40) goto L73;
        return null;
    L73:
        r19.getLocationInWindow(this.mTempLocation);
        Bitmap r41 = Bitmap.createBitmap(r9.getWidth(), r9.getHeight(), Bitmap.Config.ARGB_8888);
        r9.draw(new Canvas(r41));
        final BitmapDrawable r42 = new BitmapDrawable(r41);
        final float r43 = ViewUtils.getTransitionAlpha(r9);
        ViewUtils.setTransitionAlpha(r9, 0.0f);
        ViewUtils.getOverlay(r19).add(r42);
        PathMotion r44 = getPathMotion();
        int[] r113 = this.mTempLocation;
        int r114 = r113[0];
        int r115 = r113[1];
        ObjectAnimator r116 = ObjectAnimator.ofPropertyValuesHolder(r42, new PropertyValuesHolder[]{PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, r44.getPath(r37 - r114, r38 - r115, r39 - r114, r40 - r115))});
        r116.addListener(new AnonymousClass10(this, r19, r42, r9, r43));
        return r116;
    L80:
        return null;
    L75:
        return null;
    L81:
        return null;
    L77:
        return null;
    }
}
