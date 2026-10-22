package androidx.savedstate;

import android.view.View;
import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/savedstate/SavedStateRegistryOwner;", "view", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 extends q implements l<View, SavedStateRegistryOwner> {
    public static final ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 INSTANCE = null;

    static {
        INSTANCE = new ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2();
    }

    ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SavedStateRegistryOwner invoke2(View r1) {
        o.f(r1, "view");
        Object r0 = r1.getTag(R.id.view_tree_saved_state_registry_owner);
        if ((r0 instanceof SavedStateRegistryOwner) == true) goto L7;
        return null;
    L7:
        return (SavedStateRegistryOwner) r0;
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ SavedStateRegistryOwner invoke(View r1) {
        return invoke2(r1);
    }
}
