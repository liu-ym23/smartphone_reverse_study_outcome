package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    private static WeakReference<View> capturedSharedElement;
    private boolean entering;
    private Rect returnEndBounds;
    private ShapeProvider shapeProvider;
    private boolean sharedElementReenterTransitionEnabled;
    private boolean transparentWindowBackgroundEnabled;

    public interface ShapeProvider {
        ShapeAppearanceModel provideShape(View r1);
    }

    public static class ShapeableViewShapeProvider implements ShapeProvider {
        public ShapeableViewShapeProvider() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider
        public ShapeAppearanceModel provideShape(View r1) {
            if ((r1 instanceof Shapeable) == true) goto L7;
            return null;
        L7:
            return ((Shapeable) r1).getShapeAppearanceModel();
        }
    }

    public MaterialContainerTransformSharedElementCallback() {
        this.entering = true;
        this.transparentWindowBackgroundEnabled = true;
        this.sharedElementReenterTransitionEnabled = false;
        this.shapeProvider = new ShapeableViewShapeProvider();
    }

    static /* synthetic */ void access$000(Window r0) {
        removeWindowBackground(r0);
    }

    static /* synthetic */ void access$100(Window r0) {
        restoreWindowBackground(r0);
    }

    static /* synthetic */ WeakReference access$200() {
        return capturedSharedElement;
    }

    static /* synthetic */ WeakReference access$202(WeakReference r0) {
        capturedSharedElement = r0;
        return r0;
    }

    @Override // android.app.SharedElementCallback
    public Parcelable onCaptureSharedElementSnapshot(View r2, Matrix r3, RectF r4) {
        capturedSharedElement = new WeakReference(r2);
        return super.onCaptureSharedElementSnapshot(r2, r3, r4);
    }

    @Override // android.app.SharedElementCallback
    public View onCreateSnapshotView(Context r2, Parcelable r3) {
        View r4 = super.onCreateSnapshotView(r2, r3);
        if (r4 == null) goto L13;
        WeakReference<View> r5 = capturedSharedElement;
        if (r5 == null) goto L13;
        if (this.shapeProvider == null) goto L13;
        View r6 = r5.get();
        if (r6 == null) goto L13;
        ShapeAppearanceModel r1 = this.shapeProvider.provideShape(r6);
        if (r1 == null) goto L13;
        r4.setTag(R.id.mtrl_motion_snapshot_view, r1);
    L13:
        return r4;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(List<String> r2, Map<String, View> r3) {
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L16;
        View r4 = r3.get(r2.get(0));
        if (r4 == null) goto L17;
        Activity r5 = ContextUtils.getActivity(r4.getContext());
        if (r5 == null) goto L18;
        Window r6 = r5.getWindow();
        if (this.entering == false) goto L13;
        setUpEnterTransform(r6);
        return;
    L13:
        setUpReturnTransform(r5, r6);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(List<String> r3, List<View> r4, List<View> r5) {
        if (r4.isEmpty() == true) goto L8;
        if (r5.isEmpty() == true) goto L8;
        r4.get(0).setTag(R.id.mtrl_motion_snapshot_view, r5.get(0));
    L8:
        if (this.entering == false) goto L10;
        return;
    L10:
        if (r4.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.returnEndBounds == null) goto L17;
        View r6 = r4.get(0);
        r6.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 1073741824));
        r6.layout(this.returnEndBounds.left, this.returnEndBounds.top, this.returnEndBounds.right, this.returnEndBounds.bottom);
        return;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(List<String> r3, List<View> r4, List<View> r5) {
        if (r4.isEmpty() == true) goto L8;
        if ((r4.get(0).getTag(R.id.mtrl_motion_snapshot_view) instanceof View) == false) goto L8;
        r4.get(0).setTag(R.id.mtrl_motion_snapshot_view, null);
    L8:
        if (this.entering == false) goto L10;
    L12:
        this.entering = false;
        return;
    L10:
        if (r4.isEmpty() == true) goto L12;
        this.returnEndBounds = TransitionUtils.getRelativeBoundsRect(r4.get(0));
        goto L12
    }

    public ShapeProvider getShapeProvider() {
        return this.shapeProvider;
    }

    public void setShapeProvider(ShapeProvider r1) {
        this.shapeProvider = r1;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    public void setTransparentWindowBackgroundEnabled(boolean r1) {
        this.transparentWindowBackgroundEnabled = r1;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        return this.sharedElementReenterTransitionEnabled;
    }

    public void setSharedElementReenterTransitionEnabled(boolean r1) {
        this.sharedElementReenterTransitionEnabled = r1;
    }

    private void setUpEnterTransform(final Window r3) {
        Transition r0 = r3.getSharedElementEnterTransition();
        if ((r0 instanceof MaterialContainerTransform) == false) goto L11;
        MaterialContainerTransform r1 = (MaterialContainerTransform) r0;
        if (this.sharedElementReenterTransitionEnabled == true) goto L8;
        r3.setSharedElementReenterTransition(null);
    L8:
        if (this.transparentWindowBackgroundEnabled == false) goto L12;
        updateBackgroundFadeDuration(r3, r1);
        r1.addListener(new AnonymousClass1(this, r3));
        return;
    L12:
        return;
    }

    private void setUpReturnTransform(final Activity r3, final Window r4) {
        Transition r0 = r4.getSharedElementReturnTransition();
        if ((r0 instanceof MaterialContainerTransform) == false) goto L8;
        MaterialContainerTransform r1 = (MaterialContainerTransform) r0;
        r1.setHoldAtEndEnabled(true);
        r1.addListener(new AnonymousClass2(this, r3));
        if (this.transparentWindowBackgroundEnabled == false) goto L9;
        updateBackgroundFadeDuration(r4, r1);
        r1.addListener(new AnonymousClass3(this, r4));
        return;
    L9:
        return;
    }

    private static void removeWindowBackground(Window r2) {
        r2.getDecorView().getBackground().mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
    }

    private static void restoreWindowBackground(Window r0) {
        r0.getDecorView().getBackground().mutate().clearColorFilter();
    }

    private static void updateBackgroundFadeDuration(Window r2, MaterialContainerTransform r3) {
        r2.setTransitionBackgroundFadeDuration(r3.getDuration());
    }
}
