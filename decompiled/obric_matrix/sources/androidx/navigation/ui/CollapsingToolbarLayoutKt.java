package androidx.navigation.ui;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"setupWithNavController", "", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "navController", "Landroidx/navigation/NavController;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "navigation-ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CollapsingToolbarLayoutKt {
    public static final void setupWithNavController(CollapsingToolbarLayout r3, Toolbar r4, NavController r5, DrawerLayout r6) {
        o.f(r3, "<this>");
        o.f(r4, "toolbar");
        o.f(r5, "navController");
        NavGraph r0 = r5.getGraph();
        AppBarConfigurationKt.AnonymousClass1 r1 = AppBarConfigurationKt.AnonymousClass1.INSTANCE;
        NavigationUI.setupWithNavController(r3, r4, r5, new AppBarConfiguration.Builder(r0).setOpenableLayout(r6).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r1)).build());
    }

    public static final void setupWithNavController(CollapsingToolbarLayout r1, Toolbar r2, NavController r3, AppBarConfiguration r4) {
        o.f(r1, "<this>");
        o.f(r2, "toolbar");
        o.f(r3, "navController");
        o.f(r4, "configuration");
        NavigationUI.setupWithNavController(r1, r2, r3, r4);
    }

    public static /* synthetic */ void setupWithNavController$default(CollapsingToolbarLayout r1, Toolbar r2, NavController r3, AppBarConfiguration r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        NavGraph r7 = r3.getGraph();
        AppBarConfigurationKt.AnonymousClass1 r8 = AppBarConfigurationKt.AnonymousClass1.INSTANCE;
        r4 = new AppBarConfiguration.Builder(r7).setOpenableLayout(null).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r8)).build();
    L5:
        setupWithNavController(r1, r2, r3, r4);
    }
}
