package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ViewKt {
    public static final void doOnLayout(@NotNull View r1, @NotNull final Function1<? super View, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnLayout");
        Intrinsics.g(r2, "action");
        if (ViewCompat.isLaidOut(r1) == true) goto L5;
    L7:
        r1.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(r2));
        return;
    L5:
        if (r1.isLayoutRequested() == true) goto L7;
        r2.invoke(r1);
    }

    public static final void doOnNextLayout(@NotNull View r1, @NotNull final Function1<? super View, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnNextLayout");
        Intrinsics.g(r2, "action");
        r1.addOnLayoutChangeListener(new AnonymousClass1(r2));
    }

    @NotNull
    public static final OneShotPreDrawListener doOnPreDraw(@NotNull final View r1, @NotNull final Function1<? super View, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnPreDraw");
        Intrinsics.g(r2, "action");
        OneShotPreDrawListener r3 = OneShotPreDrawListener.add(r1, new RunnableC00251(r1, r2));
        Intrinsics.b(r3, "OneShotPreDrawListener.add(this) { action(this) }");
        return r3;
    }

    @NotNull
    public static final Bitmap drawToBitmap(@NotNull View r3, @NotNull Bitmap.Config r4) {
        Intrinsics.g(r3, "$this$drawToBitmap");
        Intrinsics.g(r4, "config");
        if (ViewCompat.isLaidOut(r3) == false) goto L7;
        Bitmap r5 = Bitmap.createBitmap(r3.getWidth(), r3.getHeight(), r4);
        Intrinsics.b(r5, "Bitmap.createBitmap(width, height, config)");
        Canvas r0 = new Canvas(r5);
        r0.translate(-r3.getScrollX(), -r3.getScrollY());
        r3.draw(r0);
        return r5;
    L7:
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    @NotNull
    public static /* synthetic */ Bitmap drawToBitmap$default(View r0, Bitmap.Config r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Bitmap.Config.ARGB_8888;
    L6:
        return drawToBitmap(r0, r1);
    }

    public static final int getMarginBottom(@NotNull View r1) {
        Intrinsics.g(r1, "$this$marginBottom");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.bottomMargin;
    }

    public static final int getMarginEnd(@NotNull View r1) {
        Intrinsics.g(r1, "$this$marginEnd");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r2);
    }

    public static final int getMarginLeft(@NotNull View r1) {
        Intrinsics.g(r1, "$this$marginLeft");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.leftMargin;
    }

    public static final int getMarginRight(@NotNull View r1) {
        Intrinsics.g(r1, "$this$marginRight");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.rightMargin;
    }

    public static final int getMarginStart(@NotNull View r1) {
        Intrinsics.g(r1, "$this$marginStart");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r2);
    }

    public static final int getMarginTop(@NotNull View r1) {
        Intrinsics.g(r1, "$this$marginTop");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.topMargin;
    }

    public static final boolean isGone(@NotNull View r1) {
        Intrinsics.g(r1, "$this$isGone");
        if (r1.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isInvisible(@NotNull View r1) {
        Intrinsics.g(r1, "$this$isInvisible");
        if (r1.getVisibility() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isVisible(@NotNull View r1) {
        Intrinsics.g(r1, "$this$isVisible");
        if (r1.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull View r1, long r2, @NotNull final Function0<Unit> r4) {
        Intrinsics.g(r1, "$this$postDelayed");
        Intrinsics.g(r4, "action");
        Runnable r0 = new ViewKt$postDelayed$runnable$1(r4);
        r1.postDelayed(r0, r2);
        return r0;
    }

    @RequiresApi(16)
    @NotNull
    public static final Runnable postOnAnimationDelayed(@NotNull View r1, long r2, @NotNull final Function0<Unit> r4) {
        Intrinsics.g(r1, "$this$postOnAnimationDelayed");
        Intrinsics.g(r4, "action");
        Runnable r0 = new ViewKt$postOnAnimationDelayed$runnable$1(r4);
        r1.postOnAnimationDelayed(r0, r2);
        return r0;
    }

    public static final void setGone(@NotNull View r1, boolean r2) {
        Intrinsics.g(r1, "$this$isGone");
        if (r2 == false) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public static final void setInvisible(@NotNull View r1, boolean r2) {
        Intrinsics.g(r1, "$this$isInvisible");
        if (r2 == false) goto L5;
        int r3 = 4;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public static final void setPadding(@NotNull View r1, @Px int r2) {
        Intrinsics.g(r1, "$this$setPadding");
        r1.setPadding(r2, r2, r2, r2);
    }

    public static final void setVisible(@NotNull View r1, boolean r2) {
        Intrinsics.g(r1, "$this$isVisible");
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public static final void updateLayoutParams(@NotNull View r1, @NotNull Function1<? super ViewGroup.LayoutParams, Unit> r2) {
        Intrinsics.g(r1, "$this$updateLayoutParams");
        Intrinsics.g(r2, "block");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L7;
        r2.invoke(r0);
        r1.setLayoutParams(r0);
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmName
    private static final <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(@NotNull View r0, Function1<? super T, Unit> r1) {
        r0.getLayoutParams();
        Intrinsics.l();
        throw null;
    }

    public static final void updatePadding(@NotNull View r1, @Px int r2, @Px int r3, @Px int r4, @Px int r5) {
        Intrinsics.g(r1, "$this$updatePadding");
        r1.setPadding(r2, r3, r4, r5);
    }

    public static /* synthetic */ void updatePadding$default(View r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.getPaddingLeft();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.getPaddingTop();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.getPaddingRight();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = r0.getPaddingBottom();
    L14:
        Intrinsics.g(r0, "$this$updatePadding");
        r0.setPadding(r1, r2, r3, r4);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(@NotNull View r1, @Px int r2, @Px int r3, @Px int r4, @Px int r5) {
        Intrinsics.g(r1, "$this$updatePaddingRelative");
        r1.setPaddingRelative(r2, r3, r4, r5);
    }

    @RequiresApi(17)
    public static /* synthetic */ void updatePaddingRelative$default(View r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.getPaddingStart();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.getPaddingTop();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.getPaddingEnd();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = r0.getPaddingBottom();
    L14:
        Intrinsics.g(r0, "$this$updatePaddingRelative");
        r0.setPaddingRelative(r1, r2, r3, r4);
    }
}
