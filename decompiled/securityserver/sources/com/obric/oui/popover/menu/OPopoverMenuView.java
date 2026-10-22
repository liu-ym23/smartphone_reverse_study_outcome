package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.obric.oui.popover.OPopoverLayout;
import d.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class OPopoverMenuView extends LinearLayout {
    public boolean b;
    public boolean c;
    public boolean e;
    public boolean f;

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[PopoverMenuLinearLayout.Index.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[3] = 3;
        }
    }

    public static void a(View r1, ArrayList r2) {
        if ((r1 instanceof PopoverMenuLinearLayout) == false) goto L7;
        r2.add(r1);
        return;
    L7:
        if ((r1 instanceof ViewGroup) == false) goto L12;
        Iterator r3 = ViewGroupKt.getChildren((ViewGroup) r1).iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        a((View) r3.next(), r2);
        goto L10
    L14:
        return;
    }

    public static OPopoverLayout b(View r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if ((r2 instanceof OPopoverLayout) == false) goto L8;
        return (OPopoverLayout) r2;
    L8:
        if (r2.getParent() == null) goto L16;
        ViewParent r3 = r2.getParent();
        if (r3 == null) goto L13;
        return b((ViewGroup) r3);
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L16:
        return null;
    }

    public final boolean getForceDark() {
        return this.b;
    }

    public final boolean getIgnoreWidthConstraint() {
        return this.e;
    }

    public final boolean getPressedWithArrow() {
        return this.c;
    }

    @Override // android.view.View
    public void onSizeChanged(int r4, int r5, int r6, int r7) {
        super.onSizeChanged(r4, r5, r6, r7);
        StringBuilder r8 = new StringBuilder("onSizeChanged() called with: w = ");
        Context r9 = getContext();
        Intrinsics.e(r9, "context");
        Resources r10 = r9.getResources();
        Intrinsics.e(r10, "resources");
        r8.append(MathKt.a(r4 / r10.getDisplayMetrics().density));
        r8.append("dp");
        Log.e("OPopoverMenu", r8.toString());
        if (r4 > 0) goto L5;
    L14:
        b.b("Resources.getSystem()", 1, 188);
        return;
    L5:
        if (this.f == true) goto L14;
        this.f = true;
        ArrayList r11 = new ArrayList();
        a(this, r11);
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        PopoverMenuLinearLayout r13 = (PopoverMenuLinearLayout) r12.next();
        ViewGroup.LayoutParams r0 = r13.getLayoutParams();
        if (r0 == null) goto L13;
        r0.width = (r4 - getPaddingLeft()) - getPaddingRight();
        r13.setLayoutParams(r0);
        goto L8
    L13:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setForceDark(boolean r1) {
        this.b = r1;
    }

    public final void setIgnoreWidthConstraint(boolean r1) {
        this.e = r1;
    }

    public final void setPressedWithArrow(boolean r1) {
        this.c = r1;
    }
}
