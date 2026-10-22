package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
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
@RequiresApi(21)
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {

    @Nullable
    private static WeakReference<View> capturedSharedElement;
    private boolean entering;

    @Nullable
    private Rect returnEndBounds;

    @Nullable
    private ShapeProvider shapeProvider;
    private boolean sharedElementReenterTransitionEnabled;
    private boolean transparentWindowBackgroundEnabled;

    public interface ShapeProvider {
        @Nullable
        ShapeAppearanceModel provideShape(@NonNull View r1);
    }

    public static class ShapeableViewShapeProvider implements ShapeProvider {
        public ShapeableViewShapeProvider() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider
        @Nullable
        public ShapeAppearanceModel provideShape(@NonNull View r1) {
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

    @Nullable
    private static Drawable getWindowBackground(Window r0) {
        return r0.getDecorView().getBackground();
    }

    private static void removeWindowBackground(Window r2) {
        Drawable r3 = getWindowBackground(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        r3.mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
    }

    private static void restoreWindowBackground(Window r0) {
        Drawable r1 = getWindowBackground(r0);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.mutate().clearColorFilter();
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

    private static void updateBackgroundFadeDuration(Window r4, MaterialContainerTransform r5) {
        if (r5.getDuration() < 0) goto L6;
        r4.setTransitionBackgroundFadeDuration(r5.getDuration());
        return;
    }

    @Nullable
    public ShapeProvider getShapeProvider() {
        return this.shapeProvider;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        return this.sharedElementReenterTransitionEnabled;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public Parcelable onCaptureSharedElementSnapshot(@NonNull View r2, @NonNull Matrix r3, @NonNull RectF r4) {
        capturedSharedElement = new WeakReference(r2);
        return super.onCaptureSharedElementSnapshot(r2, r3, r4);
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public View onCreateSnapshotView(@NonNull Context r2, @Nullable Parcelable r3) {
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
    public void onMapSharedElements(@NonNull List<String> r2, @NonNull Map<String, View> r3) {
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
    public void onSharedElementEnd(@NonNull List<String> r3, @NonNull List<View> r4, @NonNull List<View> r5) {
        if (r4.isEmpty() == true) goto L8;
        View r6 = r4.get(0);
        int r0 = R.id.mtrl_motion_snapshot_view;
        if ((r6.getTag(r0) instanceof View) == false) goto L8;
        r4.get(0).setTag(r0, null);
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

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@NonNull List<String> r3, @NonNull List<View> r4, @NonNull List<View> r5) {
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
        r6.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), BasicMeasure.EXACTLY));
        Rect r2 = this.returnEndBounds;
        r6.layout(r2.left, r2.top, r2.right, r2.bottom);
        return;
    }

    public void setShapeProvider(@Nullable ShapeProvider r1) {
        this.shapeProvider = r1;
    }

    public void setSharedElementReenterTransitionEnabled(boolean r1) {
        this.sharedElementReenterTransitionEnabled = r1;
    }

    public void setTransparentWindowBackgroundEnabled(boolean r1) {
        this.transparentWindowBackgroundEnabled = r1;
    }
}
