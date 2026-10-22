package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003LMNB\u001b\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bBQ\b\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0014J\u0013\u00108\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:H\u0096\u0002J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0007J\b\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020\u0007H\u0007J\b\u0010K\u001a\u00020DH\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\f@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e8G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001c\u001a\u0004\b-\u0010.R\u0014\u00100\u001a\u0002018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "Landroidx/savedstate/SavedStateRegistryOwner;", "entry", "arguments", "Landroid/os/Bundle;", "(Landroidx/navigation/NavBackStackEntry;Landroid/os/Bundle;)V", "context", "Landroid/content/Context;", "destination", "Landroidx/navigation/NavDestination;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "viewModelStoreProvider", "Landroidx/navigation/NavViewModelStoreProvider;", "id", "", "savedState", "(Landroid/content/Context;Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/lifecycle/Lifecycle$State;Landroidx/navigation/NavViewModelStoreProvider;Ljava/lang/String;Landroid/os/Bundle;)V", "getArguments", "()Landroid/os/Bundle;", "defaultFactory", "Landroidx/lifecycle/SavedStateViewModelFactory;", "getDefaultFactory", "()Landroidx/lifecycle/SavedStateViewModelFactory;", "defaultFactory$delegate", "Lkotlin/Lazy;", "getDestination", "()Landroidx/navigation/NavDestination;", "setDestination", "(Landroidx/navigation/NavDestination;)V", "getId", "()Ljava/lang/String;", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "maxState", "maxLifecycle", "getMaxLifecycle", "()Landroidx/lifecycle/Lifecycle$State;", "setMaxLifecycle", "(Landroidx/lifecycle/Lifecycle$State;)V", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "getSavedStateHandle", "()Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle$delegate", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistryAttached", "", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "equals", "other", "", "getDefaultViewModelCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "getDefaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "handleLifecycleEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "hashCode", "", "saveState", "outBundle", "updateState", "Companion", "NavResultSavedStateFactory", "SavedStateViewModel", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public static final Companion Companion = null;
    private final Bundle arguments;
    private final Context context;
    private final h defaultFactory$delegate;
    private NavDestination destination;
    private Lifecycle.State hostLifecycleState;
    private final String id;
    private LifecycleRegistry lifecycle;
    private Lifecycle.State maxLifecycle;
    private final Bundle savedState;
    private final h savedStateHandle$delegate;
    private boolean savedStateRegistryAttached;
    private final SavedStateRegistryController savedStateRegistryController;
    private final NavViewModelStoreProvider viewModelStoreProvider;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JR\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavBackStackEntry$Companion;", "", "()V", "create", "Landroidx/navigation/NavBackStackEntry;", "context", "Landroid/content/Context;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "viewModelStoreProvider", "Landroidx/navigation/NavViewModelStoreProvider;", "id", "", "savedState", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public static /* synthetic */ NavBackStackEntry create$default(Companion r10, Context r11, NavDestination r12, Bundle r13, Lifecycle.State r14, NavViewModelStoreProvider r15, String r16, Bundle r17, int r18, Object r19) {
            if ((r18 & 4) == 0) goto L5;
            Bundle r5 = null;
        L7:
            if ((r18 & 8) == 0) goto L9;
            Lifecycle.State r6 = Lifecycle.State.CREATED;
        L11:
            if ((r18 & 16) == 0) goto L13;
            NavViewModelStoreProvider r7 = null;
        L15:
            if ((r18 & 32) == 0) goto L17;
            String r0 = UUID.randomUUID().toString();
            o.e(r0, "randomUUID().toString()");
            String r8 = r0;
        L19:
            if ((r18 & 64) == 0) goto L21;
            Bundle r9 = null;
        L23:
            return r10.create(r11, r12, r5, r6, r7, r8, r9);
        L21:
            r9 = r17;
            goto L23
        L17:
            r8 = r16;
            goto L19
        L13:
            r7 = r15;
            goto L15
        L9:
            r6 = r14;
            goto L11
        L5:
            r5 = r13;
            goto L7
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final NavBackStackEntry create(Context r11, NavDestination r12, Bundle r13, Lifecycle.State r14, NavViewModelStoreProvider r15, String r16, Bundle r17) {
            o.f(r12, "destination");
            o.f(r14, "hostLifecycleState");
            o.f(r16, "id");
            return new NavBackStackEntry(r11, r12, r13, r14, r15, r16, r17, null);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavBackStackEntry$NavResultSavedStateFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class NavResultSavedStateFactory extends AbstractSavedStateViewModelFactory {
        public NavResultSavedStateFactory(SavedStateRegistryOwner r2) {
            o.f(r2, "owner");
            super(r2, null);
        }

        @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
        protected <T extends ViewModel> T create(String r1, Class<T> r2, SavedStateHandle r3) {
            o.f(r1, "key");
            o.f(r2, "modelClass");
            o.f(r3, "handle");
            return new SavedStateViewModel(r3);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/navigation/NavBackStackEntry$SavedStateViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "getHandle", "()Landroidx/lifecycle/SavedStateHandle;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class SavedStateViewModel extends ViewModel {
        private final SavedStateHandle handle;

        public SavedStateViewModel(SavedStateHandle r2) {
            o.f(r2, "handle");
            this.handle = r2;
        }

        public final SavedStateHandle getHandle() {
            return this.handle;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private NavBackStackEntry(Context r1, NavDestination r2, Bundle r3, Lifecycle.State r4, NavViewModelStoreProvider r5, String r6, Bundle r7) {
        this.context = r1;
        this.destination = r2;
        this.arguments = r3;
        this.hostLifecycleState = r4;
        this.viewModelStoreProvider = r5;
        this.id = r6;
        this.savedState = r7;
        this.lifecycle = new LifecycleRegistry(this);
        this.savedStateRegistryController = SavedStateRegistryController.Companion.create(this);
        this.defaultFactory$delegate = i.b(new NavBackStackEntry$defaultFactory$2(this));
        this.savedStateHandle$delegate = i.b(new NavBackStackEntry$savedStateHandle$2(this));
        this.maxLifecycle = Lifecycle.State.INITIALIZED;
    }

    /* synthetic */ NavBackStackEntry(Context r11, NavDestination r12, Bundle r13, Lifecycle.State r14, NavViewModelStoreProvider r15, String r16, Bundle r17, int r18, g r19) {
        if ((r18 & 4) == 0) goto L5;
        Bundle r5 = null;
    L7:
        if ((r18 & 8) == 0) goto L9;
        Lifecycle.State r6 = Lifecycle.State.CREATED;
    L11:
        if ((r18 & 16) == 0) goto L13;
        NavViewModelStoreProvider r7 = null;
    L15:
        if ((r18 & 32) == 0) goto L17;
        String r0 = UUID.randomUUID().toString();
        o.e(r0, "randomUUID().toString()");
        String r8 = r0;
    L19:
        if ((r18 & 64) == 0) goto L21;
        Bundle r9 = null;
    L22:
        this(r11, r12, r5, r6, r7, r8, r9);
        return;
    L21:
        r9 = r17;
        goto L22
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public /* synthetic */ NavBackStackEntry(Context r1, NavDestination r2, Bundle r3, Lifecycle.State r4, NavViewModelStoreProvider r5, String r6, Bundle r7, g r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavBackStackEntry(NavBackStackEntry r10, Bundle r11) {
        o.f(r10, "entry");
        this(r10.context, r10.destination, r11, r10.hostLifecycleState, r10.viewModelStoreProvider, r10.id, r10.savedState);
        this.hostLifecycleState = r10.hostLifecycleState;
        setMaxLifecycle(r10.maxLifecycle);
    }

    public /* synthetic */ NavBackStackEntry(NavBackStackEntry r1, Bundle r2, int r3, g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r1.arguments;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ Context access$getContext$p(NavBackStackEntry r0) {
        return r0.context;
    }

    public static final /* synthetic */ LifecycleRegistry access$getLifecycle$p(NavBackStackEntry r0) {
        return r0.lifecycle;
    }

    public static final /* synthetic */ boolean access$getSavedStateRegistryAttached$p(NavBackStackEntry r0) {
        return r0.savedStateRegistryAttached;
    }

    private final SavedStateViewModelFactory getDefaultFactory() {
        return (SavedStateViewModelFactory) this.defaultFactory$delegate.getValue();
    }

    public boolean equals(Object r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        if ((r7 instanceof NavBackStackEntry) == false) goto L51;
        NavBackStackEntry r8 = (NavBackStackEntry) r7;
        if (o.a(this.id, r8.id) == true) goto L10;
        return false;
    L10:
        if (o.a(this.destination, r8.destination) == true) goto L12;
        return false;
    L12:
        if (o.a(this.lifecycle, r8.lifecycle) == true) goto L14;
        return false;
    L14:
        if (o.a(getSavedStateRegistry(), r8.getSavedStateRegistry()) == true) goto L16;
        return false;
    L16:
        if (o.a(this.arguments, r8.arguments) == true) goto L41;
        Bundle r1 = this.arguments;
        if (r1 == null) goto L38;
        Set<String> r2 = r1.keySet();
        if (r2 == null) goto L38;
        if ((r2 instanceof Collection) == true) goto L24;
    L26:
        Iterator<T> r3 = r2.iterator();
    L28:
        if (r3.hasNext() == false) goto L25;
        String r4 = (String) r3.next();
        Object r5 = this.arguments.get(r4);
        Bundle r6 = r8.arguments;
        if (r6 == null) goto L32;
        Object r9 = r6.get(r4);
    L34:
        if (o.a(r5, r9) == true) goto L28;
        boolean r10 = false;
    L36:
        if (r10 != true) goto L38;
        boolean r11 = true;
    L39:
        if (r11 == true) goto L41;
        return false;
    L32:
        r9 = null;
    L25:
        r10 = true;
        goto L36
    L24:
        if (r2.isEmpty() == false) goto L26;
    L38:
        r11 = false;
    L41:
        return true;
    L51:
        return false;
    }

    public final Bundle getArguments() {
        return this.arguments;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application r1 = null;
        MutableCreationExtras r0 = new MutableCreationExtras(null, 1, null);
        Context r2 = this.context;
        if (r2 == null) goto L5;
        Context r3 = r2.getApplicationContext();
    L7:
        if ((r3 instanceof Application) == false) goto L9;
        r1 = (Application) r3;
    L9:
        if (r1 == null) goto L11;
        r0.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, r1);
    L11:
        r0.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        r0.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        Bundle r4 = this.arguments;
        if (r4 == null) goto L14;
        r0.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, r4);
    L14:
        return r0;
    L5:
        r3 = null;
        goto L7
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return getDefaultFactory();
    }

    public final NavDestination getDestination() {
        return this.destination;
    }

    public final String getId() {
        return this.id;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Lifecycle.State getMaxLifecycle() {
        return this.maxLifecycle;
    }

    public final SavedStateHandle getSavedStateHandle() {
        return (SavedStateHandle) this.savedStateHandle$delegate.getValue();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.savedStateRegistryAttached == false) goto L18;
        if (this.lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L16;
        NavViewModelStoreProvider r1 = this.viewModelStoreProvider;
        if (r1 == null) goto L14;
        return r1.getViewModelStore(this.id);
    L14:
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
    L16:
        throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
    L7:
        r0 = false;
        goto L8
    L18:
        throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void handleLifecycleEvent(Lifecycle.Event r2) {
        o.f(r2, NotificationCompat.CATEGORY_EVENT);
        Lifecycle.State r3 = r2.getTargetState();
        o.e(r3, "event.targetState");
        this.hostLifecycleState = r3;
        updateState();
    }

    public int hashCode() {
        int r0 = (this.id.hashCode() * 31) + this.destination.hashCode();
        Bundle r1 = this.arguments;
        if (r1 == null) goto L15;
        Set<String> r2 = r1.keySet();
        if (r2 == null) goto L15;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        String r4 = (String) r3.next();
        int r5 = r0 * 31;
        Object r6 = this.arguments.get(r4);
        if (r6 == null) goto L12;
        int r7 = r6.hashCode();
    L13:
        r0 = r5 + r7;
        goto L8
    L12:
        r7 = 0;
    L15:
        return (((r0 * 31) + this.lifecycle.hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void saveState(Bundle r2) {
        o.f(r2, "outBundle");
        this.savedStateRegistryController.performSave(r2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setDestination(NavDestination r2) {
        o.f(r2, "<set-?>");
        this.destination = r2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setMaxLifecycle(Lifecycle.State r2) {
        o.f(r2, "maxState");
        this.maxLifecycle = r2;
        updateState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void updateState() {
        if (this.savedStateRegistryAttached == true) goto L9;
        this.savedStateRegistryController.performAttach();
        this.savedStateRegistryAttached = true;
        if (this.viewModelStoreProvider == null) goto L7;
        SavedStateHandleSupport.enableSavedStateHandles(this);
    L7:
        this.savedStateRegistryController.performRestore(this.savedState);
    L9:
        if (this.hostLifecycleState.ordinal() >= this.maxLifecycle.ordinal()) goto L11;
        LifecycleRegistry r0 = this.lifecycle;
        Lifecycle.State r2 = this.hostLifecycleState;
    L12:
        r0.setCurrentState(r2);
        return;
    L11:
        r0 = this.lifecycle;
        r2 = this.maxLifecycle;
        goto L12
    }
}
