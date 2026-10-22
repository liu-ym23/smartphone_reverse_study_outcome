package androidx.navigation.fragment;

import android.view.View;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"FragmentNavigatorExtras", "Landroidx/navigation/fragment/FragmentNavigator$Extras;", "sharedElements", "", "Lkotlin/Pair;", "Landroid/view/View;", "", "([Lkotlin/Pair;)Landroidx/navigation/fragment/FragmentNavigator$Extras;", "navigation-fragment_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FragmentNavigatorExtrasKt {
    public static final FragmentNavigator.Extras FragmentNavigatorExtras(u<? extends View, String>... r5) {
        o.f(r5, "sharedElements");
        FragmentNavigator.Extras.Builder r0 = new FragmentNavigator.Extras.Builder();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        u<? extends View, String> r3 = r5[r2];
        r0.addSharedElement(r3.a(), r3.b());
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.build();
    }
}
