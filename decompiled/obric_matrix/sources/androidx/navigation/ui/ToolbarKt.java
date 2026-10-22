package androidx.navigation.ui;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"setupWithNavController", "", "Landroidx/appcompat/widget/Toolbar;", "navController", "Landroidx/navigation/NavController;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "navigation-ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ToolbarKt {
    public static final void setupWithNavController(Toolbar r3, NavController r4, DrawerLayout r5) {
        o.f(r3, "<this>");
        o.f(r4, "navController");
        NavGraph r0 = r4.getGraph();
        AppBarConfigurationKt.AnonymousClass1 r1 = AppBarConfigurationKt.AnonymousClass1.INSTANCE;
        NavigationUI.setupWithNavController(r3, r4, new AppBarConfiguration.Builder(r0).setOpenableLayout(r5).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r1)).build());
    }

    public static final void setupWithNavController(Toolbar r1, NavController r2, AppBarConfiguration r3) {
        o.f(r1, "<this>");
        o.f(r2, "navController");
        o.f(r3, "configuration");
        NavigationUI.setupWithNavController(r1, r2, r3);
    }

    public static /* synthetic */ void setupWithNavController$default(Toolbar r1, NavController r2, AppBarConfiguration r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        NavGraph r6 = r2.getGraph();
        AppBarConfigurationKt.AnonymousClass1 r7 = AppBarConfigurationKt.AnonymousClass1.INSTANCE;
        r3 = new AppBarConfiguration.Builder(r6).setOpenableLayout(null).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r7)).build();
    L5:
        setupWithNavController(r1, r2, r3);
    }
}
