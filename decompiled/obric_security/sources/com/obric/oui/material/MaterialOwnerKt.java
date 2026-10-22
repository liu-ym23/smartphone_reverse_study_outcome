package com.obric.oui.material;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001f\u0010\b\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001f\u0010\u000e\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u000e\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0006\u001a\u00020\u0007\u001a!\u0010\u0010\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0012\u001a\u001a\u0010\u0010\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u001a\u001f\u0010\u0013\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\u0013\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u0004\u001a$\u0010\u0014\u001a\u00020\u0001*\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0016H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"applyBackdropMaterial", "", "Landroid/view/View;", "apply", "", "isBackdropView", "srcType", "", "dispatchApplyContentMaterial", "", "Landroid/view/ViewGroup;", "([Landroid/view/ViewGroup;Z)V", "", "Lcom/obric/oui/material/MaterialOwner;", "dispatchBackdropSrcType", "([Landroid/view/ViewGroup;I)V", "dispatchBackdropTarget", "view", "([Landroid/view/ViewGroup;Landroid/view/View;)V", "dispatchBackdropTargetType", "forEachMaterialOwner", "action", "Lkotlin/Function1;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MaterialOwnerKt {
    public static final void applyBackdropMaterial(View r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r3 == false) goto L5;
        OMaterialExtBaseKt.applyMaterial(r1, r2);
        return;
    L5:
        OMaterialExtBaseKt.applyMaterialFromWindow(r1, r2);
    }

    public static final void applyBackdropMaterial(View r1, boolean r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        OMaterialHelper.setEffectSrcAndDraw(r1, r3, 1);
        return;
    L5:
        OMaterialHelper.setEffectSrcAndDraw(r1, 0, 1);
    }

    public static final void forEachMaterialOwner(ViewGroup r4, Function1<? super MaterialOwner, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "action");
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        int r2 = r1 + 1;
        KeyEvent.Callback r3 = r4.getChildAt(r1);
        if ((r3 instanceof MaterialOwner) == false) goto L7;
        MaterialOwner r6 = (MaterialOwner) r3;
    L8:
        if (r6 == null) goto L11;
        r5.invoke(r6);
    L11:
        r1 = r2;
        goto L3
    L7:
        r6 = null;
        goto L8
    }

    public static final void dispatchApplyContentMaterial(Iterable<? extends MaterialOwner> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Iterator<? extends MaterialOwner> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().applyContentMaterial(r2);
        goto L4
    }

    public static final void dispatchBackdropTarget(Iterable<? extends MaterialOwner> r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Iterator<? extends MaterialOwner> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().setBackdropTarget(r2);
        goto L4
    }

    public static final void dispatchBackdropTargetType(Iterable<? extends MaterialOwner> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Iterator<? extends MaterialOwner> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().updateBackdropTargetType(r2);
        goto L4
    }

    public static final void dispatchBackdropSrcType(Iterable<? extends MaterialOwner> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Iterator<? extends MaterialOwner> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().updateBackdropSrcType(r2);
        goto L4
    }

    public static final void dispatchApplyContentMaterial(ViewGroup[] r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewGroup r3 = r8[r2];
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        int r6 = r5 + 1;
        KeyEvent.Callback r7 = r3.getChildAt(r5);
        if ((r7 instanceof MaterialOwner) == false) goto L9;
        MaterialOwner r10 = (MaterialOwner) r7;
    L10:
        if (r10 == null) goto L13;
        r10.applyContentMaterial(r9);
    L13:
        r5 = r6;
        goto L5
    L9:
        r10 = null;
        goto L10
    L14:
        r2 = r2 + 1;
        goto L3
    }

    public static final void dispatchBackdropTarget(ViewGroup[] r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewGroup r3 = r8[r2];
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        int r6 = r5 + 1;
        KeyEvent.Callback r7 = r3.getChildAt(r5);
        if ((r7 instanceof MaterialOwner) == false) goto L9;
        MaterialOwner r10 = (MaterialOwner) r7;
    L10:
        if (r10 == null) goto L13;
        r10.setBackdropTarget(r9);
    L13:
        r5 = r6;
        goto L5
    L9:
        r10 = null;
        goto L10
    L14:
        r2 = r2 + 1;
        goto L3
    }

    public static final void dispatchBackdropTargetType(ViewGroup[] r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewGroup r3 = r8[r2];
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        int r6 = r5 + 1;
        KeyEvent.Callback r7 = r3.getChildAt(r5);
        if ((r7 instanceof MaterialOwner) == false) goto L9;
        MaterialOwner r10 = (MaterialOwner) r7;
    L10:
        if (r10 == null) goto L13;
        r10.updateBackdropTargetType(r9);
    L13:
        r5 = r6;
        goto L5
    L9:
        r10 = null;
        goto L10
    L14:
        r2 = r2 + 1;
        goto L3
    }

    public static final void dispatchBackdropSrcType(ViewGroup[] r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewGroup r3 = r8[r2];
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        int r6 = r5 + 1;
        KeyEvent.Callback r7 = r3.getChildAt(r5);
        if ((r7 instanceof MaterialOwner) == false) goto L9;
        MaterialOwner r10 = (MaterialOwner) r7;
    L10:
        if (r10 == null) goto L13;
        r10.updateBackdropSrcType(r9);
    L13:
        r5 = r6;
        goto L5
    L9:
        r10 = null;
        goto L10
    L14:
        r2 = r2 + 1;
        goto L3
    }
}
