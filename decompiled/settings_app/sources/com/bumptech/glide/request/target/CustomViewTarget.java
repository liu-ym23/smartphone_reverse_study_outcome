package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    private static final String TAG = "CustomViewTarget";
    private static final int VIEW_TAG_ID = 0;
    private View.OnAttachStateChangeListener attachStateListener;
    private boolean isAttachStateListenerAdded;
    private boolean isClearedByUs;
    private final SizeDeterminer sizeDeterminer;
    protected final T view;

    static final class SizeDeterminer {
        private static final int PENDING_SIZE = 0;
        static Integer maxDisplayLength;
        private final List<SizeReadyCallback> cbs;
        private SizeDeterminerLayoutListener layoutListener;
        private final View view;
        boolean waitForLayout;

        private static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> sizeDeterminerRef;

            SizeDeterminerLayoutListener(SizeDeterminer r2) {
                this.sizeDeterminerRef = new WeakReference(r2);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(CustomViewTarget.TAG, 2) == false) goto L5;
                Log.v(CustomViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
            L5:
                SizeDeterminer r3 = this.sizeDeterminerRef.get();
                if (r3 == null) goto L10;
                r3.checkCurrentDimens();
                return true;
            L10:
                return true;
            }
        }

        private boolean isDimensionValid(int r1) {
            if (r1 <= 0) goto L4;
        L7:
            return true;
        L4:
            if (r1 == Integer.MIN_VALUE) goto L7;
            return false;
        }

        SizeDeterminer(View r2) {
            this.cbs = new ArrayList();
            this.view = r2;
        }

        private static int getMaxDisplayLength(Context r1) {
            if (maxDisplayLength != null) goto L6;
            Display r2 = ((WindowManager) Preconditions.checkNotNull((WindowManager) r1.getSystemService("window"))).getDefaultDisplay();
            Point r0 = new Point();
            r2.getSize(r0);
            maxDisplayLength = Integer.valueOf(Math.max(r0.x, r0.y));
        L6:
            return maxDisplayLength.intValue();
        }

        private void notifyCbs(int r2, int r3) {
            Iterator r1 = new ArrayList(this.cbs).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((SizeReadyCallback) r1.next()).onSizeReady(r2, r3);
            goto L4
        }

        void checkCurrentDimens() {
            if (this.cbs.isEmpty() == false) goto L5;
            return;
        L5:
            int r0 = getTargetWidth();
            int r1 = getTargetHeight();
            if (isViewStateAndSizeValid(r0, r1) == true) goto L8;
            return;
        L8:
            notifyCbs(r0, r1);
            clearCallbacksAndListener();
        }

        void getSize(SizeReadyCallback r4) {
            int r0 = getTargetWidth();
            int r1 = getTargetHeight();
            if (isViewStateAndSizeValid(r0, r1) == false) goto L7;
            r4.onSizeReady(r0, r1);
            return;
        L7:
            if (this.cbs.contains(r4) == true) goto L10;
            this.cbs.add(r4);
        L10:
            if (this.layoutListener != null) goto L13;
            ViewTreeObserver r5 = this.view.getViewTreeObserver();
            SizeDeterminerLayoutListener r2 = new SizeDeterminerLayoutListener(this);
            this.layoutListener = r2;
            r5.addOnPreDrawListener(r2);
            return;
        }

        void removeCallback(SizeReadyCallback r1) {
            this.cbs.remove(r1);
        }

        void clearCallbacksAndListener() {
            ViewTreeObserver r0 = this.view.getViewTreeObserver();
            if (r0.isAlive() == false) goto L5;
            r0.removeOnPreDrawListener(this.layoutListener);
        L5:
            this.layoutListener = null;
            this.cbs.clear();
        }

        private boolean isViewStateAndSizeValid(int r1, int r2) {
            if (isDimensionValid(r1) == true) goto L5;
        L7:
            return false;
        L5:
            if (isDimensionValid(r2) == false) goto L7;
            return true;
        }

        private int getTargetHeight() {
            int r0 = this.view.getPaddingTop() + this.view.getPaddingBottom();
            ViewGroup.LayoutParams r1 = this.view.getLayoutParams();
            if (r1 == null) goto L5;
            int r2 = r1.height;
        L7:
            return getTargetDimen(this.view.getHeight(), r2, r0);
        L5:
            r2 = 0;
            goto L7
        }

        private int getTargetWidth() {
            int r0 = this.view.getPaddingLeft() + this.view.getPaddingRight();
            ViewGroup.LayoutParams r1 = this.view.getLayoutParams();
            if (r1 == null) goto L5;
            int r2 = r1.width;
        L7:
            return getTargetDimen(this.view.getWidth(), r2, r0);
        L5:
            r2 = 0;
            goto L7
        }

        private int getTargetDimen(int r3, int r4, int r5) {
            int r0 = r4 - r5;
            if (r0 <= 0) goto L6;
            return r0;
        L6:
            if (this.waitForLayout == true) goto L8;
        L10:
            int r6 = r3 - r5;
            if (r6 <= 0) goto L14;
            return r6;
        L14:
            if (this.view.isLayoutRequested() == false) goto L16;
        L22:
            return 0;
        L16:
            if (r4 != (-2)) goto L22;
            if (Log.isLoggable(CustomViewTarget.TAG, 4) == false) goto L21;
            Log.i(CustomViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        L21:
            return getMaxDisplayLength(this.view.getContext());
        L8:
            if (this.view.isLayoutRequested() == false) goto L10;
            return 0;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    protected abstract void onResourceCleared(Drawable r1);

    protected void onResourceLoading(Drawable r1) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Deprecated
    public final CustomViewTarget<T, Z> useTagId(int r1) {
        return this;
    }

    static {
        VIEW_TAG_ID = R.id.glide_custom_view_target_tag;
    }

    public CustomViewTarget(T r2) {
        this.view = (T) Preconditions.checkNotNull(r2);
        this.sizeDeterminer = new SizeDeterminer(r2);
    }

    public final CustomViewTarget<T, Z> waitForLayout() {
        this.sizeDeterminer.waitForLayout = true;
        return this;
    }

    public final CustomViewTarget<T, Z> clearOnDetach() {
        if (this.attachStateListener == null) goto L5;
        return this;
    L5:
        this.attachStateListener = new AnonymousClass1(this);
        maybeAddAttachStateListener();
        return this;
    }

    public final T getView() {
        return this.view;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback r1) {
        this.sizeDeterminer.getSize(r1);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(SizeReadyCallback r1) {
        this.sizeDeterminer.removeCallback(r1);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(Drawable r1) {
        maybeAddAttachStateListener();
        onResourceLoading(r1);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable r2) {
        this.sizeDeterminer.clearCallbacksAndListener();
        onResourceCleared(r2);
        if (this.isClearedByUs == true) goto L6;
        maybeRemoveAttachStateListener();
        return;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(Request r1) {
        setTag(r1);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final Request getRequest() {
        Object r1 = getTag();
        if (r1 != null) goto L5;
        return null;
    L5:
        if ((r1 instanceof Request) == false) goto L9;
        return (Request) r1;
    L9:
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    final void resumeMyRequest() {
        Request r1 = getRequest();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isCleared() == false) goto L9;
        r1.begin();
        return;
    }

    final void pauseMyRequest() {
        Request r0 = getRequest();
        if (r0 == null) goto L6;
        this.isClearedByUs = true;
        r0.clear();
        this.isClearedByUs = false;
        return;
    }

    private void setTag(Object r2) {
        this.view.setTag(VIEW_TAG_ID, r2);
    }

    private Object getTag() {
        return this.view.getTag(VIEW_TAG_ID);
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener r0 = this.attachStateListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.isAttachStateListenerAdded == true) goto L10;
        this.view.addOnAttachStateChangeListener(r0);
        this.isAttachStateListenerAdded = true;
        return;
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener r0 = this.attachStateListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.isAttachStateListenerAdded == false) goto L10;
        this.view.removeOnAttachStateChangeListener(r0);
        this.isAttachStateListenerAdded = false;
        return;
    }
}
