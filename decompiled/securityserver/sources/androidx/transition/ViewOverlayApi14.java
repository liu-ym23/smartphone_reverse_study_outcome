package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ViewOverlayApi14 implements ViewOverlayImpl {
    protected OverlayViewGroup mOverlayViewGroup;

    public static class OverlayViewGroup extends ViewGroup {
        static Method sInvalidateChildInParentFastMethod;
        private boolean mDisposed;
        ArrayList<Drawable> mDrawables;
        ViewGroup mHostView;
        View mRequestingView;
        ViewOverlayApi14 mViewOverlay;

        static {
            Class r2 = Integer.TYPE;     // Catch: NoSuchMethodException -> L4
            sInvalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{r2, r2, Rect.class});     // Catch: NoSuchMethodException -> L4
            return;
        }

        public OverlayViewGroup(Context r1, ViewGroup r2, View r3, ViewOverlayApi14 r4) {
            super(r1);
            this.mDrawables = null;
            this.mHostView = r2;
            this.mRequestingView = r3;
            setRight(r2.getWidth());
            setBottom(r2.getHeight());
            r2.addView(this);
            this.mViewOverlay = r4;
        }

        private void assertNotDisposed() {
            if (this.mDisposed == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void disposeIfEmpty() {
            if (getChildCount() != 0) goto L10;
            ArrayList<Drawable> r0 = this.mDrawables;
            if (r0 != null) goto L7;
        L8:
            this.mDisposed = true;
            this.mHostView.removeView(this);
            return;
        L7:
            if (r0.size() == 0) goto L8;
            return;
        }

        private void getOffset(int[] r5) {
            int[] r1 = new int[2];
            int[] r0 = new int[2];
            this.mHostView.getLocationOnScreen(r1);
            this.mRequestingView.getLocationOnScreen(r0);
            r5[0] = r0[0] - r1[0];
            r5[1] = r0[1] - r1[1];
        }

        public void add(Drawable r2) {
            assertNotDisposed();
            if (this.mDrawables != null) goto L6;
            this.mDrawables = new ArrayList();
        L6:
            if (this.mDrawables.contains(r2) == true) goto L9;
            this.mDrawables.add(r2);
            invalidate(r2.getBounds());
            r2.setCallback(this);
            return;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas r6) {
            int[] r1 = new int[2];
            int[] r0 = new int[2];
            this.mHostView.getLocationOnScreen(r1);
            this.mRequestingView.getLocationOnScreen(r0);
            int r2 = 0;
            r6.translate(r0[0] - r1[0], r0[1] - r1[1]);
            r6.clipRect(new Rect(0, 0, this.mRequestingView.getWidth(), this.mRequestingView.getHeight()));
            super.dispatchDraw(r6);
            ArrayList<Drawable> r3 = this.mDrawables;
            if (r3 != null) goto L5;
            int r4 = 0;
        L6:
            if (r2 >= r4) goto L8;
            this.mDrawables.get(r2).draw(r6);
            r2 = r2 + 1;
            goto L6
        L8:
            return;
        L5:
            r4 = r3.size();
            goto L6
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r1) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] r5, Rect r6) {
            if (this.mHostView == null) goto L11;
            r6.offset(r5[0], r5[1]);
            if ((this.mHostView instanceof ViewGroup) == false) goto L8;
            r5[0] = 0;
            r5[1] = 0;
            int[] r1 = new int[2];
            getOffset(r1);
            r6.offset(r1[0], r1[1]);
            return super.invalidateChildInParent(r5, r6);
        L8:
            invalidate(r6);
            return null;
        L11:
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ViewParent invalidateChildInParentFast(int r2, int r3, Rect r4) {
            if ((this.mHostView instanceof ViewGroup) == true) goto L5;
            return null;
        L5:
            if (sInvalidateChildInParentFastMethod != null) goto L17;
            return null;
        L17:
            getOffset(new int[2]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
            sInvalidateChildInParentFastMethod.invoke(this.mHostView, new Object[]{Integer.valueOf(r2), Integer.valueOf(r3), r4});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
        L22:
            return null;
        L11:
            e = move-exception;
            e.printStackTrace();
            return null;
        L9:
            e = move-exception;
            e.printStackTrace();
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable r1) {
            invalidate(r1.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        }

        public void remove(Drawable r2) {
            ArrayList<Drawable> r0 = this.mDrawables;
            if (r0 == null) goto L6;
            r0.remove(r2);
            invalidate(r2.getBounds());
            r2.setCallback(null);
            disposeIfEmpty();
            return;
        }

        @Override // android.view.View
        public boolean verifyDrawable(@NonNull Drawable r2) {
            if (super.verifyDrawable(r2) == true) goto L10;
            ArrayList<Drawable> r1 = this.mDrawables;
            if (r1 != null) goto L7;
        L9:
            return false;
        L7:
            if (r1.contains(r2) == false) goto L9;
        L10:
            return true;
        }

        public void remove(View r1) {
            super.removeView(r1);
            disposeIfEmpty();
        }

        public void add(View r6) {
            assertNotDisposed();
            if ((r6.getParent() instanceof ViewGroup) == false) goto L14;
            ViewGroup r0 = (ViewGroup) r6.getParent();
            if (r0 != this.mHostView) goto L7;
        L11:
            r0.removeView(r6);
            if (r6.getParent() == null) goto L14;
            r0.removeView(r6);
            goto L14
        L7:
            if (r0.getParent() == null) goto L11;
            if (ViewCompat.isAttachedToWindow(r0) == false) goto L11;
            int[] r2 = new int[2];
            int[] r1 = new int[2];
            r0.getLocationOnScreen(r2);
            this.mHostView.getLocationOnScreen(r1);
            ViewCompat.offsetLeftAndRight(r6, r2[0] - r1[0]);
            ViewCompat.offsetTopAndBottom(r6, r2[1] - r1[1]);
        L14:
            super.addView(r6);
        }
    }

    public ViewOverlayApi14(Context r2, ViewGroup r3, View r4) {
        this.mOverlayViewGroup = new OverlayViewGroup(r2, r3, r4, this);
    }

    public static ViewOverlayApi14 createFrom(View r5) {
        ViewGroup r0 = getContentView(r5);
        if (r0 == null) goto L13;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L12;
        View r3 = r0.getChildAt(r2);
        if ((r3 instanceof OverlayViewGroup) == true) goto L9;
        r2 = r2 + 1;
        goto L5
    L9:
        return ((OverlayViewGroup) r3).mViewOverlay;
    L12:
        return new ViewGroupOverlayApi14(r0.getContext(), r0, r5);
    L13:
        return null;
    }

    public static ViewGroup getContentView(View r2) {
    L2:
        if (r2 == null) goto L12;
        if (r2.getId() != 16908290) goto L10;
        if ((r2 instanceof ViewGroup) == false) goto L10;
        return (ViewGroup) r2;
    L10:
        if ((r2.getParent() instanceof ViewGroup) == false) goto L2;
        r2 = (ViewGroup) r2.getParent();
        goto L2
    L12:
        return null;
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@NonNull Drawable r1) {
        this.mOverlayViewGroup.add(r1);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@NonNull Drawable r1) {
        this.mOverlayViewGroup.remove(r1);
    }
}
