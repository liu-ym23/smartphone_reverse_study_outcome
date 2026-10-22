package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"viewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/activity/ComponentActivity;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ActivityViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass1 extends q implements kotlin.n0.c.a<ViewModelStore> {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass1(ComponentActivity r1) {
            this.$this_viewModels = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelStore invoke() {
            ViewModelStore r1 = this.$this_viewModels.getViewModelStore();
            o.e(r1, "viewModelStore");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass2 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass2(ComponentActivity r1) {
            this.$this_viewModels = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras invoke() {
            CreationExtras r1 = this.$this_viewModels.getDefaultViewModelCreationExtras();
            o.e(r1, "this.defaultViewModelCreationExtras");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass3 extends q implements kotlin.n0.c.a<ViewModelStore> {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass3(ComponentActivity r1) {
            this.$this_viewModels = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelStore invoke() {
            ViewModelStore r1 = this.$this_viewModels.getViewModelStore();
            o.e(r1, "viewModelStore");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass4 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ kotlin.n0.c.a<CreationExtras> $extrasProducer;
        final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(kotlin.n0.c.a<? extends CreationExtras> r1, ComponentActivity r2) {
            this.$extrasProducer = r1;
            this.$this_viewModels = r2;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras invoke() {
            kotlin.n0.c.a<CreationExtras> r0 = this.$extrasProducer;
            if (r0 == null) goto L6;
            CreationExtras r1 = r0.invoke();
            if (r1 == null) goto L6;
            return r1;
        L6:
            CreationExtras r2 = this.$this_viewModels.getDefaultViewModelCreationExtras();
            o.e(r2, "this.defaultViewModelCreationExtras");
            return r2;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> kotlin.h<VM> viewModels(ComponentActivity r1, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r2) {
        o.f(r1, "<this>");
        if (r2 != null) goto L5;
        new ActivityViewModelLazyKt$viewModels$factoryPromise$1(r1);
    L5:
        o.j(4, "VM");
        throw null;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> kotlin.h<VM> viewModels(ComponentActivity r0, kotlin.n0.c.a<? extends CreationExtras> r1, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r2) {
        o.f(r0, "<this>");
        if (r2 != null) goto L5;
        new ActivityViewModelLazyKt$viewModels$factoryPromise$2(r0);
    L5:
        o.j(4, "VM");
        throw null;
    }

    public static /* synthetic */ kotlin.h viewModels$default(ComponentActivity r0, kotlin.n0.c.a r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        o.f(r0, "<this>");
        if (r1 != null) goto L8;
        new ActivityViewModelLazyKt$viewModels$factoryPromise$1(r0);
    L8:
        o.j(4, "VM");
        throw null;
    }

    public static /* synthetic */ kotlin.h viewModels$default(ComponentActivity r0, kotlin.n0.c.a r1, kotlin.n0.c.a r2, int r3, Object r4) {
        int r5 = r3 & 1;
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        o.f(r0, "<this>");
        if (r2 != null) goto L8;
        new ActivityViewModelLazyKt$viewModels$factoryPromise$2(r0);
    L8:
        o.j(4, "VM");
        throw null;
    }
}
