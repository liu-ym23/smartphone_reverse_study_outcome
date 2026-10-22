package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a5\u0010 \u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\bø\u0001\u0000\u001a5\u0010'\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\bø\u0001\u0000\u001a5\u0010(\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\bø\u0001\u0000\u001a5\u0010)\u001a\u00020!*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\bø\u0001\u0000\u001a5\u0010*\u001a\u00020+*\u00020\u00022#\b\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#H\u0086\bø\u0001\u0000\u001a\u0014\u0010,\u001a\u00020-*\u00020\u00022\b\b\u0002\u0010.\u001a\u00020/\u001a(\u00100\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\u000e\b\u0004\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04H\u0086\bø\u0001\u0000\u001a\"\u00105\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!04H\u0007\u001a\u0017\u00106\u001a\u00020!*\u00020\u00022\b\b\u0001\u00107\u001a\u00020\u0013H\u0086\b\u001a:\u00108\u001a\u00020!\"\n\b\u0000\u00109\u0018\u0001*\u00020:*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b<H\u0087\bø\u0001\u0000¢\u0006\u0002\b=\u001a)\u00108\u001a\u00020!*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b<H\u0086\bø\u0001\u0000\u001a5\u0010>\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010?\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010A\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0086\b\u001a5\u0010C\u001a\u00020!*\u00020\u00022\b\b\u0003\u0010D\u001a\u00020\u00132\b\b\u0003\u0010@\u001a\u00020\u00132\b\b\u0003\u0010E\u001a\u00020\u00132\b\b\u0003\u0010B\u001a\u00020\u0013H\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"*\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"*\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r\"*\u0010\u0010\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\"\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\"\u0016\u0010\u0018\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\"\u0016\u0010\u001a\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\"\u0016\u0010\u001c\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015\"\u0016\u0010\u001e\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2 = {"allViews", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "getAllViews", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "ancestors", "Landroid/view/ViewParent;", "getAncestors", "value", "", "isGone", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "marginBottom", "", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", "marginLeft", "getMarginLeft", "marginRight", "getMarginRight", "marginStart", "getMarginStart", "marginTop", "getMarginTop", "doOnAttach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnDetach", "doOnLayout", "doOnNextLayout", "doOnPreDraw", "Landroidx/core/view/OneShotPreDrawListener;", "drawToBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "setPadding", "size", "updateLayoutParams", "T", "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/ExtensionFunctionType;", "updateLayoutParamsTyped", "updatePadding", "left", "top", "right", "bottom", "updatePaddingRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ViewKt {
    public static /* synthetic */ void a(kotlin.n0.c.a r0) {
        m12postOnAnimationDelayed$lambda1(r0);
    }

    public static final void doOnAttach(final View r1, final l<? super View, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L5;
        r2.invoke(r1);
        return;
    L5:
        r1.addOnAttachStateChangeListener(new AnonymousClass1(r1, r2));
    }

    public static final void doOnDetach(final View r1, final l<? super View, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        if (ViewCompat.isAttachedToWindow(r1) == true) goto L5;
        r2.invoke(r1);
        return;
    L5:
        r1.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC06141(r1, r2));
    }

    public static final void doOnLayout(View r1, final l<? super View, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        if (ViewCompat.isLaidOut(r1) == true) goto L5;
    L7:
        r1.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(r2));
        return;
    L5:
        if (r1.isLayoutRequested() == true) goto L7;
        r2.invoke(r1);
    }

    public static final void doOnNextLayout(View r1, final l<? super View, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        r1.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC06151(r2));
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View r1, final l<? super View, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        OneShotPreDrawListener r3 = OneShotPreDrawListener.add(r1, new RunnableC06161(r2, r1));
        o.e(r3, "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        return r3;
    }

    public static final Bitmap drawToBitmap(View r3, Bitmap.Config r4) {
        o.f(r3, "<this>");
        o.f(r4, "config");
        if (ViewCompat.isLaidOut(r3) == false) goto L7;
        Bitmap r5 = Bitmap.createBitmap(r3.getWidth(), r3.getHeight(), r4);
        o.e(r5, "createBitmap(width, height, config)");
        Canvas r0 = new Canvas(r5);
        r0.translate(-r3.getScrollX(), -r3.getScrollY());
        r3.draw(r0);
        return r5;
    L7:
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View r0, Bitmap.Config r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Bitmap.Config.ARGB_8888;
    L6:
        return drawToBitmap(r0, r1);
    }

    public static final kotlin.t0.h<View> getAllViews(View r2) {
        o.f(r2, "<this>");
        return kotlin.t0.k.b(new ViewKt$allViews$1(r2, null));
    }

    public static final kotlin.t0.h<ViewParent> getAncestors(View r1) {
        o.f(r1, "<this>");
        return kotlin.t0.k.h(r1.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(View r1) {
        o.f(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L6:
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.bottomMargin;
    L5:
        r3 = null;
        goto L6
    }

    public static final int getMarginEnd(View r1) {
        o.f(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r2);
    }

    public static final int getMarginLeft(View r1) {
        o.f(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L6:
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.leftMargin;
    L5:
        r3 = null;
        goto L6
    }

    public static final int getMarginRight(View r1) {
        o.f(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L6:
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.rightMargin;
    L5:
        r3 = null;
        goto L6
    }

    public static final int getMarginStart(View r1) {
        o.f(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r2);
    }

    public static final int getMarginTop(View r1) {
        o.f(r1, "<this>");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L6:
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.topMargin;
    L5:
        r3 = null;
        goto L6
    }

    public static final boolean isGone(View r1) {
        o.f(r1, "<this>");
        if (r1.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isInvisible(View r1) {
        o.f(r1, "<this>");
        if (r1.getVisibility() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isVisible(View r1) {
        o.f(r1, "<this>");
        if (r1.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Runnable postDelayed(View r1, long r2, final kotlin.n0.c.a<f0> r4) {
        o.f(r1, "<this>");
        o.f(r4, "action");
        Runnable r0 = new ViewKt$postDelayed$runnable$1(r4);
        r1.postDelayed(r0, r2);
        return r0;
    }

    @RequiresApi(16)
    public static final Runnable postOnAnimationDelayed(View r1, long r2, final kotlin.n0.c.a<f0> r4) {
        o.f(r1, "<this>");
        o.f(r4, "action");
        Runnable r0 = new e(r4);
        Api16Impl.postOnAnimationDelayed(r1, r0, r2);
        return r0;
    }

    /* JADX INFO: renamed from: postOnAnimationDelayed$lambda-1, reason: not valid java name */
    private static final void m12postOnAnimationDelayed$lambda1(kotlin.n0.c.a r1) {
        o.f(r1, "$action");
        r1.invoke();
    }

    public static final void setGone(View r1, boolean r2) {
        o.f(r1, "<this>");
        if (r2 == false) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public static final void setInvisible(View r1, boolean r2) {
        o.f(r1, "<this>");
        if (r2 == false) goto L5;
        int r3 = 4;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public static final void setPadding(View r1, @Px int r2) {
        o.f(r1, "<this>");
        r1.setPadding(r2, r2, r2, r2);
    }

    public static final void setVisible(View r1, boolean r2) {
        o.f(r1, "<this>");
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public static final void updateLayoutParams(View r2, l<? super ViewGroup.LayoutParams, f0> r3) {
        o.f(r2, "<this>");
        o.f(r3, "block");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r3.invoke(r0);
        r2.setLayoutParams(r0);
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View r1, l<? super T, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "block");
        r1.getLayoutParams();
        o.j(1, "T");
        throw null;
    }

    public static final void updatePadding(View r1, @Px int r2, @Px int r3, @Px int r4, @Px int r5) {
        o.f(r1, "<this>");
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
        o.f(r0, "<this>");
        r0.setPadding(r1, r2, r3, r4);
    }

    @RequiresApi(17)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void updatePaddingRelative(View r1, @Px int r2, @Px int r3, @Px int r4, @Px int r5) {
        o.f(r1, "<this>");
        r1.setPaddingRelative(r2, r3, r4, r5);
    }

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
        o.f(r0, "<this>");
        r0.setPaddingRelative(r1, r2, r3, r4);
    }
}
