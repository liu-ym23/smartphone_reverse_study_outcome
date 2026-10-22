package com.obric.oui.menu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.icu.lang.UCharacter;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.stickylistheaders.WrapperView;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.OPopoverHelper;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: PopMenuItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ0\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u0014J:\u0010\r\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/menu/PopMenu;", "", "()V", "currMenu", "Lcom/obric/oui/popover/OPopover;", "currTag", "dismiss", "", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "isShowed", "", "show", "anchor", "Landroid/view/View;", "items", "", "Lcom/obric/oui/menu/PopMenuItem;", "listener", "Lkotlin/Function1;", "", "tag", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PopMenu {
    private OPopover currMenu;
    private Object currTag;

    /* JADX INFO: renamed from: $r8$lambda$aDst1O26NZ9zucEMGW-cfLiMulo, reason: not valid java name */
    public static /* synthetic */ void m1248$r8$lambda$aDst1O26NZ9zucEMGWcfLiMulo(PopMenu r0, View r1) {
        show$lambda$6$lambda$5(r0, r1);
    }

    public PopMenu() {
    }

    public final void show(View r2, List<PopMenuItem> r3, Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        Intrinsics.checkNotNullParameter(r3, "items");
        Intrinsics.checkNotNullParameter(r4, "listener");
        show(null, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show(Object r30, final View r31, List<PopMenuItem> r32, final Function1<? super Integer, Unit> r33) {
        Intrinsics.checkNotNullParameter(r31, "anchor");
        Intrinsics.checkNotNullParameter(r32, "items");
        Intrinsics.checkNotNullParameter(r33, "listener");
        dismiss();
        Context r3 = r31.getContext();
        IOUIAlpha r5 = null;
        if ((r3 instanceof Activity) == false) goto L5;
        Activity r4 = (Activity) r3;
    L6:
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.isFinishing() == false) goto L11;
        return;
    L11:
        OPopover.Builder r6 = new OPopover.Builder(r4);
        OPopoverEntranceMenuView.Builder r7 = new OPopoverEntranceMenuView.Builder(r4);
        r7.setItemWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 148, Resources.getSystem().getDisplayMetrics())));
        Iterator<T> r1 = r32.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        final PopMenuItem r8 = (PopMenuItem) r1.next();
        OPopoverEntranceMenuView.Builder.addPopoverItem$default(r7, Integer.valueOf(r8.getIcon()), null, null, r8.getTitle(), null, null, false, null, new PopMenu$show$popover$1$1$1(r33, r8, this), UCharacter.UnicodeBlock.PSALTER_PAHLAVI_ID, null);
        goto L13
    L15:
        OPopover r14 = r6.setView(r7.build()).build();
        r14.setOnDismissListener(new PopMenu$$ExternalSyntheticLambda0(this, r31));
        if ((r31 instanceof IOUIAlpha) == false) goto L18;
        IOUIAlpha r2 = (IOUIAlpha) r31;
    L19:
        int r9 = 0;
        if (r2 == null) goto L22;
        r2.setChangeAlphaWhenPress(false);
    L22:
        r31.setSelected(true);
        if ((r31 instanceof WrapperView) == false) goto L25;
        WrapperView r10 = (WrapperView) r31;
    L26:
        if (r10 == null) goto L36;
        int r11 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        if (r10.hasHeader() == false) goto L30;
        r11 = MathKt.roundToInt(TypedValue.applyDimension(1, 48, Resources.getSystem().getDisplayMetrics()));
    L30:
        KeyEvent.Callback r12 = r10.getItem();
        if ((r12 instanceof IOUIAlpha) == false) goto L33;
        r5 = (IOUIAlpha) r12;
    L33:
        if (r5 == null) goto L35;
        r5.setChangeAlphaWhenPress(false);
        r10.setPressed(true);
    L35:
        r9 = r11;
    L36:
        OPopoverHelper.showPopoverSmartly$default(OPopoverHelper.INSTANCE, r14, r31, 48, true, 0.0f, (-(r31.getWidth() - MathKt.roundToInt(TypedValue.applyDimension(1, 174, Resources.getSystem().getDisplayMetrics())))) / 2, (((MathKt.roundToInt(TypedValue.applyDimension(1, 70, Resources.getSystem().getDisplayMetrics())) - r31.getHeight()) - r9) / 2) + (r31.getHeight() + r9), false, 0, 0, false, 1920, null);
        if (ViewCompat.isAttachedToWindow(r31) == true) goto L39;
        dismiss();
    L40:
        this.currMenu = r14;
        this.currTag = r30;
        return;
    L39:
        r31.addOnAttachStateChangeListener(new PopMenu$show$$inlined$doOnDetach$1(r31, this));
        goto L40
    L25:
        r10 = null;
        goto L26
    L18:
        r2 = null;
        goto L19
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void show$lambda$6$lambda$5(PopMenu r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$anchor");
        r5.dismiss();
        IOUIAlpha r0 = null;
        if ((r6 instanceof IOUIAlpha) == false) goto L5;
        IOUIAlpha r7 = (IOUIAlpha) r6;
    L7:
        if (r7 == null) goto L10;
        r7.setChangeAlphaWhenPress(true);
    L10:
        if ((r6 instanceof WrapperView) == false) goto L12;
        WrapperView r8 = (WrapperView) r6;
    L14:
        if (r8 == null) goto L20;
        KeyEvent.Callback r3 = r8.getItem();
        if ((r3 instanceof IOUIAlpha) == false) goto L18;
        r0 = (IOUIAlpha) r3;
    L18:
        if (r0 == null) goto L20;
        r0.setChangeAlphaWhenPress(true);
        r8.setPressed(false);
    L20:
        r6.setSelected(false);
        return;
    L12:
        r8 = null;
        goto L14
    L5:
        r7 = null;
        goto L7
    }

    public final void dismiss() {
        OPopover r0 = this.currMenu;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.currMenu = null;
        this.currTag = null;
    }

    public final <T> T getTag() {
        T r0 = (T) this.currTag;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    public final boolean isShowed() {
        OPopover r2 = this.currMenu;
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.isShowing() == true) goto L7;
        return false;
    L7:
        return true;
    }
}
