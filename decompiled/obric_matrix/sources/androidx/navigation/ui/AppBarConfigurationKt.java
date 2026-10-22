package androidx.navigation.ui;

import android.view.Menu;
import androidx.customview.widget.Openable;
import androidx.navigation.NavGraph;
import java.util.Set;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\bø\u0001\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\bø\u0001\u0000\u001a6\u0010\u0000\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"AppBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "topLevelMenu", "Landroid/view/Menu;", "drawerLayout", "Landroidx/customview/widget/Openable;", "fallbackOnNavigateUpListener", "Lkotlin/Function0;", "", "navGraph", "Landroidx/navigation/NavGraph;", "topLevelDestinationIds", "", "", "navigation-ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AppBarConfigurationKt {

    /* JADX INFO: renamed from: androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass1 extends q implements kotlin.n0.c.a<Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass2 extends q implements kotlin.n0.c.a<Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass3 extends q implements kotlin.n0.c.a<Boolean> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    public static final AppBarConfiguration AppBarConfiguration(Menu r1, Openable r2, kotlin.n0.c.a<Boolean> r3) {
        o.f(r1, "topLevelMenu");
        o.f(r3, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r1).setOpenableLayout(r2).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r3)).build();
    }

    public static final AppBarConfiguration AppBarConfiguration(NavGraph r1, Openable r2, kotlin.n0.c.a<Boolean> r3) {
        o.f(r1, "navGraph");
        o.f(r3, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r1).setOpenableLayout(r2).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r3)).build();
    }

    public static final AppBarConfiguration AppBarConfiguration(Set<Integer> r1, Openable r2, kotlin.n0.c.a<Boolean> r3) {
        o.f(r1, "topLevelDestinationIds");
        o.f(r3, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r1).setOpenableLayout(r2).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r3)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Menu r0, Openable r1, kotlin.n0.c.a r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        r2 = AnonymousClass2.INSTANCE;
    L8:
        o.f(r0, "topLevelMenu");
        o.f(r2, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r0).setOpenableLayout(r1).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r2)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(NavGraph r0, Openable r1, kotlin.n0.c.a r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        r2 = AnonymousClass1.INSTANCE;
    L8:
        o.f(r0, "navGraph");
        o.f(r2, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r0).setOpenableLayout(r1).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r2)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Set r0, Openable r1, kotlin.n0.c.a r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        r2 = AnonymousClass3.INSTANCE;
    L8:
        o.f(r0, "topLevelDestinationIds");
        o.f(r2, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r0).setOpenableLayout(r1).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r2)).build();
    }
}
