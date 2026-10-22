package androidx.activity;

import android.view.View;
import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/activity/OnBackPressedDispatcherOwner;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 extends q implements l<View, OnBackPressedDispatcherOwner> {
    public static final ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 INSTANCE = null;

    static {
        INSTANCE = new ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2();
    }

    ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final OnBackPressedDispatcherOwner invoke2(View r1) {
        o.f(r1, "it");
        Object r0 = r1.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
        if ((r0 instanceof OnBackPressedDispatcherOwner) == true) goto L7;
        return null;
    L7:
        return (OnBackPressedDispatcherOwner) r0;
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ OnBackPressedDispatcherOwner invoke(View r1) {
        return invoke2(r1);
    }
}
