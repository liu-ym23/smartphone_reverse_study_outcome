package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u001aP\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u001a<\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0010\b\n\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u000f\u001a\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"navGraphViewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "navGraphId", "", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "navGraphRoute", "", "navigation-fragment_release", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavGraphViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass1 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ h<NavBackStackEntry> $backStackEntry$delegate;

        public AnonymousClass1(h<NavBackStackEntry> r1) {
            this.$backStackEntry$delegate = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras invoke() {
            return NavGraphViewModelLazyKt.m24access$navGraphViewModels$lambda0(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass2 extends q implements kotlin.n0.c.a<ViewModelProvider.Factory> {
        final /* synthetic */ h<NavBackStackEntry> $backStackEntry$delegate;

        public AnonymousClass2(h<NavBackStackEntry> r1) {
            this.$backStackEntry$delegate = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m24access$navGraphViewModels$lambda0(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass3 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ h<NavBackStackEntry> $backStackEntry$delegate;
        final /* synthetic */ kotlin.n0.c.a<CreationExtras> $extrasProducer;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(kotlin.n0.c.a<? extends CreationExtras> r1, h<NavBackStackEntry> r2) {
            this.$extrasProducer = r1;
            this.$backStackEntry$delegate = r2;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras invoke() {
            kotlin.n0.c.a<CreationExtras> r0 = this.$extrasProducer;
            if (r0 == null) goto L7;
            CreationExtras r1 = r0.invoke();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return NavGraphViewModelLazyKt.m25access$navGraphViewModels$lambda1(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass4 extends q implements kotlin.n0.c.a<ViewModelProvider.Factory> {
        final /* synthetic */ h<NavBackStackEntry> $backStackEntry$delegate;

        public AnonymousClass4(h<NavBackStackEntry> r1) {
            this.$backStackEntry$delegate = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m25access$navGraphViewModels$lambda1(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass5 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ h<NavBackStackEntry> $backStackEntry$delegate;

        public AnonymousClass5(h<NavBackStackEntry> r1) {
            this.$backStackEntry$delegate = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras invoke() {
            return NavGraphViewModelLazyKt.m26access$navGraphViewModels$lambda2(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass6 extends q implements kotlin.n0.c.a<ViewModelProvider.Factory> {
        final /* synthetic */ h<NavBackStackEntry> $backStackEntry$delegate;

        public AnonymousClass6(h<NavBackStackEntry> r1) {
            this.$backStackEntry$delegate = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m26access$navGraphViewModels$lambda2(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass7 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ h<NavBackStackEntry> $backStackEntry$delegate;
        final /* synthetic */ kotlin.n0.c.a<CreationExtras> $extrasProducer;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(kotlin.n0.c.a<? extends CreationExtras> r1, h<NavBackStackEntry> r2) {
            this.$extrasProducer = r1;
            this.$backStackEntry$delegate = r2;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras invoke() {
            kotlin.n0.c.a<CreationExtras> r0 = this.$extrasProducer;
            if (r0 == null) goto L7;
            CreationExtras r1 = r0.invoke();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return NavGraphViewModelLazyKt.m27access$navGraphViewModels$lambda3(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraphViewModelLazyKt$navGraphViewModels$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass8 extends q implements kotlin.n0.c.a<ViewModelProvider.Factory> {
        final /* synthetic */ h<NavBackStackEntry> $backStackEntry$delegate;

        public AnonymousClass8(h<NavBackStackEntry> r1) {
            this.$backStackEntry$delegate = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelProvider.Factory invoke() {
            return NavGraphViewModelLazyKt.m27access$navGraphViewModels$lambda3(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: access$navGraphViewModels$lambda-0, reason: not valid java name */
    public static final /* synthetic */ NavBackStackEntry m24access$navGraphViewModels$lambda0(h r0) {
        return m28navGraphViewModels$lambda0(r0);
    }

    /* JADX INFO: renamed from: access$navGraphViewModels$lambda-1, reason: not valid java name */
    public static final /* synthetic */ NavBackStackEntry m25access$navGraphViewModels$lambda1(h r0) {
        return m29navGraphViewModels$lambda1(r0);
    }

    /* JADX INFO: renamed from: access$navGraphViewModels$lambda-2, reason: not valid java name */
    public static final /* synthetic */ NavBackStackEntry m26access$navGraphViewModels$lambda2(h r0) {
        return m30navGraphViewModels$lambda2(r0);
    }

    /* JADX INFO: renamed from: access$navGraphViewModels$lambda-3, reason: not valid java name */
    public static final /* synthetic */ NavBackStackEntry m27access$navGraphViewModels$lambda3(h r0) {
        return m31navGraphViewModels$lambda3(r0);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> h<VM> navGraphViewModels(Fragment r0, @IdRes int r1, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r2) {
        o.f(r0, "<this>");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(i.b(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(r0, r1)));
        o.j(4, "VM");
        throw null;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> h<VM> navGraphViewModels(Fragment r0, @IdRes int r1, kotlin.n0.c.a<? extends CreationExtras> r2, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r3) {
        o.f(r0, "<this>");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(i.b(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(r0, r1)));
        o.j(4, "VM");
        throw null;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> h<VM> navGraphViewModels(Fragment r0, String r1, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r2) {
        o.f(r0, "<this>");
        o.f(r1, "navGraphRoute");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(i.b(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$6(r0, r1)));
        o.j(4, "VM");
        throw null;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> h<VM> navGraphViewModels(Fragment r0, String r1, kotlin.n0.c.a<? extends CreationExtras> r2, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r3) {
        o.f(r0, "<this>");
        o.f(r1, "navGraphRoute");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4(i.b(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(r0, r1)));
        o.j(4, "VM");
        throw null;
    }

    public static /* synthetic */ h navGraphViewModels$default(Fragment r0, int r1, kotlin.n0.c.a r2, int r3, Object r4) {
        int r5 = r3 & 2;
        o.f(r0, "<this>");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(i.b(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(r0, r1)));
        o.j(4, "VM");
        throw null;
    }

    public static /* synthetic */ h navGraphViewModels$default(Fragment r0, int r1, kotlin.n0.c.a r2, kotlin.n0.c.a r3, int r4, Object r5) {
        int r6 = r4 & 2;
        int r7 = r4 & 4;
        o.f(r0, "<this>");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(i.b(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(r0, r1)));
        o.j(4, "VM");
        throw null;
    }

    public static /* synthetic */ h navGraphViewModels$default(Fragment r0, String r1, kotlin.n0.c.a r2, int r3, Object r4) {
        int r5 = r3 & 2;
        o.f(r0, "<this>");
        o.f(r1, "navGraphRoute");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$3(i.b(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$6(r0, r1)));
        o.j(4, "VM");
        throw null;
    }

    public static /* synthetic */ h navGraphViewModels$default(Fragment r0, String r1, kotlin.n0.c.a r2, kotlin.n0.c.a r3, int r4, Object r5) {
        int r6 = r4 & 2;
        int r7 = r4 & 4;
        o.f(r0, "<this>");
        o.f(r1, "navGraphRoute");
        new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$4(i.b(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$8(r0, r1)));
        o.j(4, "VM");
        throw null;
    }

    /* JADX INFO: renamed from: navGraphViewModels$lambda-0, reason: not valid java name */
    private static final NavBackStackEntry m28navGraphViewModels$lambda0(h<NavBackStackEntry> r0) {
        return r0.getValue();
    }

    /* JADX INFO: renamed from: navGraphViewModels$lambda-1, reason: not valid java name */
    private static final NavBackStackEntry m29navGraphViewModels$lambda1(h<NavBackStackEntry> r0) {
        return r0.getValue();
    }

    /* JADX INFO: renamed from: navGraphViewModels$lambda-2, reason: not valid java name */
    private static final NavBackStackEntry m30navGraphViewModels$lambda2(h<NavBackStackEntry> r0) {
        return r0.getValue();
    }

    /* JADX INFO: renamed from: navGraphViewModels$lambda-3, reason: not valid java name */
    private static final NavBackStackEntry m31navGraphViewModels$lambda3(h<NavBackStackEntry> r0) {
        return r0.getValue();
    }
}
