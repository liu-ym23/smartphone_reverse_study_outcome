package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u001aZ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u001aD\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\n\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u001aV\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\n\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012²\u0006\u0016\u0010\u0013\u001a\u00020\u0011\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u0013\u001a\u00020\u0011\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"activityViewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "createViewModelLazy", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Landroidx/lifecycle/ViewModelStore;", "viewModels", "ownerProducer", "Landroidx/lifecycle/ViewModelStoreOwner;", "fragment-ktx_release", "owner"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FragmentViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass1 extends q implements kotlin.n0.c.a<ViewModelStore> {
        final /* synthetic */ Fragment $this_activityViewModels;

        public AnonymousClass1(Fragment r1) {
            this.$this_activityViewModels = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelStore invoke() {
            ViewModelStore r1 = this.$this_activityViewModels.requireActivity().getViewModelStore();
            o.e(r1, "requireActivity().viewModelStore");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass2 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ Fragment $this_activityViewModels;

        public AnonymousClass2(Fragment r1) {
            this.$this_activityViewModels = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras invoke() {
            CreationExtras r1 = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            o.e(r1, "requireActivity().defaultViewModelCreationExtras");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass3 extends q implements kotlin.n0.c.a<ViewModelProvider.Factory> {
        final /* synthetic */ Fragment $this_activityViewModels;

        public AnonymousClass3(Fragment r1) {
            this.$this_activityViewModels = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory r1 = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            o.e(r1, "requireActivity().defaultViewModelProviderFactory");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass4 extends q implements kotlin.n0.c.a<ViewModelStore> {
        final /* synthetic */ Fragment $this_activityViewModels;

        public AnonymousClass4(Fragment r1) {
            this.$this_activityViewModels = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelStore invoke() {
            ViewModelStore r1 = this.$this_activityViewModels.requireActivity().getViewModelStore();
            o.e(r1, "requireActivity().viewModelStore");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass5 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ kotlin.n0.c.a<CreationExtras> $extrasProducer;
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(kotlin.n0.c.a<? extends CreationExtras> r1, Fragment r2) {
            this.$extrasProducer = r1;
            this.$this_activityViewModels = r2;
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
            CreationExtras r2 = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            o.e(r2, "requireActivity().defaultViewModelCreationExtras");
            return r2;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass6 extends q implements kotlin.n0.c.a<ViewModelProvider.Factory> {
        final /* synthetic */ Fragment $this_activityViewModels;

        public AnonymousClass6(Fragment r1) {
            this.$this_activityViewModels = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory r1 = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            o.e(r1, "requireActivity().defaultViewModelProviderFactory");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06171 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ Fragment $this_createViewModelLazy;

        C06171(Fragment r1) {
            this.$this_createViewModelLazy = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras invoke() {
            CreationExtras r1 = this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
            o.e(r1, "defaultViewModelCreationExtras");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06182 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ Fragment $this_createViewModelLazy;

        C06182(Fragment r1) {
            this.$this_createViewModelLazy = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras invoke() {
            CreationExtras r1 = this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
            o.e(r1, "defaultViewModelCreationExtras");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C06191 extends q implements kotlin.n0.c.a<Fragment> {
        final /* synthetic */ Fragment $this_viewModels;

        public C06191(Fragment r1) {
            this.$this_viewModels = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Fragment invoke() {
            return this.$this_viewModels;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Fragment invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C06202 extends q implements kotlin.n0.c.a<ViewModelStore> {
        final /* synthetic */ kotlin.h<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public C06202(kotlin.h<? extends ViewModelStoreOwner> r1) {
            this.$owner$delegate = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelStore invoke() {
            ViewModelStore r1 = FragmentViewModelLazyKt.m14access$viewModels$lambda0(this.$owner$delegate).getViewModelStore();
            o.e(r1, "owner.viewModelStore");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C06213 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ kotlin.h<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public C06213(kotlin.h<? extends ViewModelStoreOwner> r1) {
            this.$owner$delegate = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras invoke() {
            ViewModelStoreOwner r2 = FragmentViewModelLazyKt.m14access$viewModels$lambda0(this.$owner$delegate);
            CreationExtras r1 = null;
            if ((r2 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
            HasDefaultViewModelProviderFactory r3 = (HasDefaultViewModelProviderFactory) r2;
        L6:
            if (r3 == null) goto L8;
            r1 = r3.getDefaultViewModelCreationExtras();
        L8:
            if (r1 == null) goto L10;
            return r1;
        L10:
            return CreationExtras.Empty.INSTANCE;
        L5:
            r3 = null;
            goto L6
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C06224 extends q implements kotlin.n0.c.a<ViewModelProvider.Factory> {
        final /* synthetic */ kotlin.h<ViewModelStoreOwner> $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: Multi-variable type inference failed */
        public C06224(Fragment r1, kotlin.h<? extends ViewModelStoreOwner> r2) {
            this.$this_viewModels = r1;
            this.$owner$delegate = r2;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelStoreOwner r0 = FragmentViewModelLazyKt.m14access$viewModels$lambda0(this.$owner$delegate);
            if ((r0 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
            HasDefaultViewModelProviderFactory r1 = (HasDefaultViewModelProviderFactory) r0;
        L6:
            if (r1 == null) goto L9;
            ViewModelProvider.Factory r2 = r1.getDefaultViewModelProviderFactory();
            if (r2 == null) goto L9;
        L10:
            o.e(r2, "(owner as? HasDefaultVie…tViewModelProviderFactory");
            return r2;
        L9:
            r2 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            goto L10
        L5:
            r1 = null;
            goto L6
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$5, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C06235 extends q implements kotlin.n0.c.a<Fragment> {
        final /* synthetic */ Fragment $this_viewModels;

        public C06235(Fragment r1) {
            this.$this_viewModels = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Fragment invoke() {
            return this.$this_viewModels;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Fragment invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$6, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C06246 extends q implements kotlin.n0.c.a<ViewModelStore> {
        final /* synthetic */ kotlin.h<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public C06246(kotlin.h<? extends ViewModelStoreOwner> r1) {
            this.$owner$delegate = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelStore invoke() {
            ViewModelStore r1 = FragmentViewModelLazyKt.m15access$viewModels$lambda1(this.$owner$delegate).getViewModelStore();
            o.e(r1, "owner.viewModelStore");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass7 extends q implements kotlin.n0.c.a<CreationExtras> {
        final /* synthetic */ kotlin.n0.c.a<CreationExtras> $extrasProducer;
        final /* synthetic */ kotlin.h<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(kotlin.n0.c.a<? extends CreationExtras> r1, kotlin.h<? extends ViewModelStoreOwner> r2) {
            this.$extrasProducer = r1;
            this.$owner$delegate = r2;
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
            ViewModelStoreOwner r2 = FragmentViewModelLazyKt.m15access$viewModels$lambda1(this.$owner$delegate);
            if ((r2 instanceof HasDefaultViewModelProviderFactory) == false) goto L9;
            HasDefaultViewModelProviderFactory r3 = (HasDefaultViewModelProviderFactory) r2;
        L10:
            if (r3 == null) goto L12;
            CreationExtras r4 = r3.getDefaultViewModelCreationExtras();
        L13:
            if (r4 == null) goto L15;
            return r4;
        L15:
            return CreationExtras.Empty.INSTANCE;
        L12:
            r4 = null;
            goto L13
        L9:
            r3 = null;
            goto L10
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass8 extends q implements kotlin.n0.c.a<ViewModelProvider.Factory> {
        final /* synthetic */ kotlin.h<ViewModelStoreOwner> $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Fragment r1, kotlin.h<? extends ViewModelStoreOwner> r2) {
            this.$this_viewModels = r1;
            this.$owner$delegate = r2;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final ViewModelProvider.Factory invoke() {
            ViewModelStoreOwner r0 = FragmentViewModelLazyKt.m15access$viewModels$lambda1(this.$owner$delegate);
            if ((r0 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
            HasDefaultViewModelProviderFactory r1 = (HasDefaultViewModelProviderFactory) r0;
        L6:
            if (r1 == null) goto L9;
            ViewModelProvider.Factory r2 = r1.getDefaultViewModelProviderFactory();
            if (r2 == null) goto L9;
        L10:
            o.e(r2, "(owner as? HasDefaultVie…tViewModelProviderFactory");
            return r2;
        L9:
            r2 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            goto L10
        L5:
            r1 = null;
            goto L6
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: access$viewModels$lambda-0, reason: not valid java name */
    public static final /* synthetic */ ViewModelStoreOwner m14access$viewModels$lambda0(kotlin.h r0) {
        return m16viewModels$lambda0(r0);
    }

    /* JADX INFO: renamed from: access$viewModels$lambda-1, reason: not valid java name */
    public static final /* synthetic */ ViewModelStoreOwner m15access$viewModels$lambda1(kotlin.h r0) {
        return m17viewModels$lambda1(r0);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> kotlin.h<VM> activityViewModels(Fragment r0, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r1) {
        o.f(r0, "<this>");
        o.j(4, "VM");
        throw null;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> kotlin.h<VM> activityViewModels(Fragment r0, kotlin.n0.c.a<? extends CreationExtras> r1, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r2) {
        o.f(r0, "<this>");
        o.j(4, "VM");
        throw null;
    }

    public static /* synthetic */ kotlin.h activityViewModels$default(Fragment r0, kotlin.n0.c.a r1, int r2, Object r3) {
        int r4 = r2 & 1;
        o.f(r0, "<this>");
        o.j(4, "VM");
        throw null;
    }

    public static /* synthetic */ kotlin.h activityViewModels$default(Fragment r0, kotlin.n0.c.a r1, kotlin.n0.c.a r2, int r3, Object r4) {
        int r5 = r3 & 1;
        int r6 = r3 & 2;
        o.f(r0, "<this>");
        o.j(4, "VM");
        throw null;
    }

    @MainThread
    public static final /* synthetic */ kotlin.h createViewModelLazy(Fragment r1, kotlin.s0.d r2, kotlin.n0.c.a r3, kotlin.n0.c.a r4) {
        o.f(r1, "<this>");
        o.f(r2, "viewModelClass");
        o.f(r3, "storeProducer");
        return createViewModelLazy(r1, r2, r3, new C06171(r1), r4);
    }

    @MainThread
    public static final <VM extends ViewModel> kotlin.h<VM> createViewModelLazy(Fragment r1, kotlin.s0.d<VM> r2, kotlin.n0.c.a<? extends ViewModelStore> r3, kotlin.n0.c.a<? extends CreationExtras> r4, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r5) {
        o.f(r1, "<this>");
        o.f(r2, "viewModelClass");
        o.f(r3, "storeProducer");
        o.f(r4, "extrasProducer");
        if (r5 != null) goto L6;
        r5 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(r1);
    L6:
        return new ViewModelLazy(r2, r3, r5, r4);
    }

    public static /* synthetic */ kotlin.h createViewModelLazy$default(Fragment r0, kotlin.s0.d r1, kotlin.n0.c.a r2, kotlin.n0.c.a r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return createViewModelLazy(r0, r1, r2, r3);
    }

    public static /* synthetic */ kotlin.h createViewModelLazy$default(Fragment r0, kotlin.s0.d r1, kotlin.n0.c.a r2, kotlin.n0.c.a r3, kotlin.n0.c.a r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = new C06182(r0);
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = null;
    L9:
        return createViewModelLazy(r0, r1, r2, r3, r4);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> kotlin.h<VM> viewModels(Fragment r0, kotlin.n0.c.a<? extends ViewModelStoreOwner> r1, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r2) {
        o.f(r0, "<this>");
        o.f(r1, "ownerProducer");
        kotlin.i.a(l.f18419h, new FragmentViewModelLazyKt$viewModels$owner$2(r1));
        o.j(4, "VM");
        throw null;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> kotlin.h<VM> viewModels(Fragment r0, kotlin.n0.c.a<? extends ViewModelStoreOwner> r1, kotlin.n0.c.a<? extends CreationExtras> r2, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r3) {
        o.f(r0, "<this>");
        o.f(r1, "ownerProducer");
        kotlin.i.a(l.f18419h, new FragmentViewModelLazyKt$viewModels$owner$4(r1));
        o.j(4, "VM");
        throw null;
    }

    public static /* synthetic */ kotlin.h viewModels$default(Fragment r0, kotlin.n0.c.a r1, kotlin.n0.c.a r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = new C06191(r0);
    L5:
        int r5 = r3 & 2;
        o.f(r0, "<this>");
        o.f(r1, "ownerProducer");
        kotlin.i.a(l.f18419h, new FragmentViewModelLazyKt$viewModels$owner$2(r1));
        o.j(4, "VM");
        throw null;
    }

    public static /* synthetic */ kotlin.h viewModels$default(Fragment r0, kotlin.n0.c.a r1, kotlin.n0.c.a r2, kotlin.n0.c.a r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = new C06235(r0);
    L5:
        int r6 = r4 & 2;
        int r7 = r4 & 4;
        o.f(r0, "<this>");
        o.f(r1, "ownerProducer");
        kotlin.i.a(l.f18419h, new FragmentViewModelLazyKt$viewModels$owner$4(r1));
        o.j(4, "VM");
        throw null;
    }

    /* JADX INFO: renamed from: viewModels$lambda-0, reason: not valid java name */
    private static final ViewModelStoreOwner m16viewModels$lambda0(kotlin.h<? extends ViewModelStoreOwner> r0) {
        return r0.getValue();
    }

    /* JADX INFO: renamed from: viewModels$lambda-1, reason: not valid java name */
    private static final ViewModelStoreOwner m17viewModels$lambda1(kotlin.h<? extends ViewModelStoreOwner> r0) {
        return r0.getValue();
    }
}
