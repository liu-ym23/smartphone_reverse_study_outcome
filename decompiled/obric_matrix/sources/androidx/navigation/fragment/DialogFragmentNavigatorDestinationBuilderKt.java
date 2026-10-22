package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavGraphBuilder;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0087\b\u001a?\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\u0087\bø\u0001\u0000\u001a!\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0086\b\u001a=\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"dialog", "", "F", "Landroidx/fragment/app/DialogFragment;", "Landroidx/navigation/NavGraphBuilder;", "id", "", "builder", "Lkotlin/Function1;", "Landroidx/navigation/fragment/DialogFragmentNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "route", "", "navigation-fragment_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DialogFragmentNavigatorDestinationBuilderKt {
    public static final /* synthetic */ <F extends DialogFragment> void dialog(NavGraphBuilder r0, @IdRes int r1) {
        o.f(r0, "<this>");
        DialogFragmentNavigator r2 = (DialogFragmentNavigator) r0.getProvider().getNavigator(DialogFragmentNavigator.class);
        o.j(4, "F");
        throw null;
    }

    public static final /* synthetic */ <F extends DialogFragment> void dialog(NavGraphBuilder r0, @IdRes int r1, l<? super DialogFragmentNavigatorDestinationBuilder, f0> r2) {
        o.f(r0, "<this>");
        o.f(r2, "builder");
        DialogFragmentNavigator r3 = (DialogFragmentNavigator) r0.getProvider().getNavigator(DialogFragmentNavigator.class);
        o.j(4, "F");
        throw null;
    }

    public static final /* synthetic */ <F extends DialogFragment> void dialog(NavGraphBuilder r1, String r2) {
        o.f(r1, "<this>");
        o.f(r2, "route");
        DialogFragmentNavigator r3 = (DialogFragmentNavigator) r1.getProvider().getNavigator(DialogFragmentNavigator.class);
        o.j(4, "F");
        throw null;
    }

    public static final /* synthetic */ <F extends DialogFragment> void dialog(NavGraphBuilder r1, String r2, l<? super DialogFragmentNavigatorDestinationBuilder, f0> r3) {
        o.f(r1, "<this>");
        o.f(r2, "route");
        o.f(r3, "builder");
        DialogFragmentNavigator r4 = (DialogFragmentNavigator) r1.getProvider().getNavigator(DialogFragmentNavigator.class);
        o.j(4, "F");
        throw null;
    }
}
