package com.obric.oui.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OContextExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\t\u001a$\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u0016\u0010\u0010\u001a\u0004\u0018\u00010\f*\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\t\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u0001H\u0007¨\u0006\u0017"}, d2 = {"getActivity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "getAppcompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "colorRes2Hex", "", "resId", "getMultiColorAttr", "Landroid/graphics/drawable/Drawable;", "typedArray", "Landroid/content/res/TypedArray;", "index", "getMutateDrawable", "toggleVisible", "", "Landroid/view/View;", "visible", "", "tryGetTopDecorView", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OContextExtensionKt {
    public static final int colorRes2Hex(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return ContextCompat.getColor(r1, r2);
    }

    public static final Drawable getMutateDrawable(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Drawable r3 = ContextCompat.getDrawable(r1, r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3.mutate();
    }

    public static final void toggleVisible(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getVisibility() != 0) goto L5;
        int r0 = 4;
    L6:
        r1.setVisibility(r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public static final void toggleVisible(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r2 == r0) goto L9;
        toggleVisible(r1);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final Drawable getMultiColorAttr(Context r1, TypedArray r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typedArray");
        TypedValue r0 = new TypedValue();
        r2.getValue(r3, r0);
        if (r0.type != 1) goto L6;
        return ContextCompat.getDrawable(r1, r4);
    L6:
        return new ColorDrawable(r0.data);
    }

    public static final View tryGetTopDecorView(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getWindow().getDecorView().hasWindowFocus() == false) goto L7;
        return r5.getWindow().getDecorView();
    L7:
        if ((r5 instanceof FragmentActivity) == false) goto L36;
        FragmentActivity r6 = (FragmentActivity) r5;
        List<Fragment> r0 = r6.getSupportFragmentManager().getFragments();
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == true) goto L37;
        List<Fragment> r7 = r6.getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r7, "supportFragmentManager.fragments");
        Iterator<T> r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L39;
        Fragment r2 = (Fragment) r8.next();
        View r4 = r2.getView();
        if (r4 != null) goto L23;
    L21:
        boolean r9 = false;
    L25:
        if (r9 == false) goto L18;
        View r10 = r2.getView();
        if (r10 != null) goto L30;
        return null;
    L30:
        return r10.getRootView();
    L23:
        if (r4.hasWindowFocus() != true) goto L21;
        r9 = true;
        goto L25
    L39:
        return null;
    L37:
        return null;
    L11:
        if (r0.isEmpty() == true) goto L14;
        r1 = false;
        goto L15
    L36:
        return null;
    }

    public static final Activity getActivity(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
    L4:
        if ((r1 instanceof ContextWrapper) == false) goto L10;
        if ((r1 instanceof Activity) == true) goto L8;
        r1 = ((ContextWrapper) r1).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(r1, "rContext.baseContext");
        goto L4
    L8:
        return (Activity) r1;
    L10:
        return null;
    }

    public static final AppCompatActivity getAppcompatActivity(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Activity r2 = getActivity(r1);
        if ((r2 instanceof AppCompatActivity) == true) goto L5;
        return null;
    L5:
        return (AppCompatActivity) r2;
    }

    public static final LifecycleOwner getLifecycleOwner(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Object r2 = r1;
    L4:
        if ((r2 instanceof ContextWrapper) == false) goto L11;
        if ((r2 instanceof LifecycleOwner) == true) goto L8;
        Context r3 = ((ContextWrapper) r2).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(r3, "rContext.baseContext");
        r2 = r3;
        goto L4
    L8:
        return (LifecycleOwner) r2;
    L11:
        if ((r2 instanceof LifecycleOwner) == true) goto L13;
        return null;
    L13:
        return (LifecycleOwner) r2;
    }
}
