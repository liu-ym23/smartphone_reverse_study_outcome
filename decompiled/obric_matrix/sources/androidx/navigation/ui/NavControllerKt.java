package androidx.navigation.ui;

import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"navigateUp", "", "Landroidx/navigation/NavController;", "drawerLayout", "Landroidx/customview/widget/Openable;", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "navigation-ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavControllerKt {
    public static final boolean navigateUp(NavController r3, Openable r4) {
        o.f(r3, "<this>");
        NavGraph r0 = r3.getGraph();
        AppBarConfigurationKt.AnonymousClass1 r1 = AppBarConfigurationKt.AnonymousClass1.INSTANCE;
        return NavigationUI.navigateUp(r3, new AppBarConfiguration.Builder(r0).setOpenableLayout(r4).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r1)).build());
    }

    public static final boolean navigateUp(NavController r1, AppBarConfiguration r2) {
        o.f(r1, "<this>");
        o.f(r2, "appBarConfiguration");
        return NavigationUI.navigateUp(r1, r2);
    }
}
