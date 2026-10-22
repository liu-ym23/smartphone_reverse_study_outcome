package androidx.lifecycle;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SavedStateHandleSupport.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0018H\u0007\u001a\u001f\u0010\u0019\u001a\u00020\u001a\"\f\b\u0000\u0010\u001b*\u00020\u0006*\u00020\t*\u0002H\u001bH\u0007¢\u0006\u0002\u0010\u001c\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"DEFAULT_ARGS_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/os/Bundle;", "SAVED_STATE_KEY", "", "SAVED_STATE_REGISTRY_OWNER_KEY", "Landroidx/savedstate/SavedStateRegistryOwner;", "VIEWMODEL_KEY", "VIEW_MODEL_STORE_OWNER_KEY", "Landroidx/lifecycle/ViewModelStoreOwner;", "savedStateHandlesProvider", "Landroidx/lifecycle/SavedStateHandlesProvider;", "getSavedStateHandlesProvider", "(Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/lifecycle/SavedStateHandlesProvider;", "savedStateHandlesVM", "Landroidx/lifecycle/SavedStateHandlesVM;", "getSavedStateHandlesVM", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/SavedStateHandlesVM;", "createSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "savedStateRegistryOwner", "viewModelStoreOwner", "key", "defaultArgs", "Landroidx/lifecycle/viewmodel/CreationExtras;", "enableSavedStateHandles", "", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SavedStateHandleSupport {
    public static final CreationExtras.Key<Bundle> DEFAULT_ARGS_KEY = null;
    private static final String SAVED_STATE_KEY = "androidx.lifecycle.internal.SavedStateHandlesProvider";
    public static final CreationExtras.Key<SavedStateRegistryOwner> SAVED_STATE_REGISTRY_OWNER_KEY = null;
    private static final String VIEWMODEL_KEY = "androidx.lifecycle.internal.SavedStateHandlesVM";
    public static final CreationExtras.Key<ViewModelStoreOwner> VIEW_MODEL_STORE_OWNER_KEY = null;

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void enableSavedStateHandles(T r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Lifecycle.State r0 = r4.getLifecycle().getCurrentState();
        Intrinsics.checkNotNullExpressionValue(r0, "lifecycle.currentState");
        if (r0 != Lifecycle.State.INITIALIZED) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L15;
        if (r4.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY) != null) goto L16;
        SavedStateHandlesProvider r2 = new SavedStateHandlesProvider(r4.getSavedStateRegistry(), r4);
        r4.getSavedStateRegistry().registerSavedStateProvider(SAVED_STATE_KEY, r2);
        r4.getLifecycle().addObserver(new SavedStateHandleAttacher(r2));
        return;
    L16:
        return;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r0 == Lifecycle.State.CREATED) goto L8;
        r1 = false;
        goto L9
    }

    private static final SavedStateHandle createSavedStateHandle(SavedStateRegistryOwner r1, ViewModelStoreOwner r2, String r3, Bundle r4) {
        SavedStateHandlesProvider r5 = getSavedStateHandlesProvider(r1);
        SavedStateHandlesVM r6 = getSavedStateHandlesVM(r2);
        SavedStateHandle r0 = r6.getHandles().get(r3);
        if (r0 != null) goto L6;
        SavedStateHandle r7 = SavedStateHandle.Companion.createHandle(r5.consumeRestoredStateForKey(r3), r4);
        r6.getHandles().put(r3, r7);
        return r7;
    L6:
        return r0;
    }

    public static final SavedStateHandle createSavedStateHandle(CreationExtras r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        SavedStateRegistryOwner r0 = (SavedStateRegistryOwner) r4.get(SAVED_STATE_REGISTRY_OWNER_KEY);
        if (r0 == null) goto L15;
        ViewModelStoreOwner r1 = (ViewModelStoreOwner) r4.get(VIEW_MODEL_STORE_OWNER_KEY);
        if (r1 == null) goto L13;
        Bundle r2 = (Bundle) r4.get(DEFAULT_ARGS_KEY);
        String r5 = (String) r4.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (r5 == null) goto L11;
        return createSavedStateHandle(r0, r1, r5, r2);
    L11:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    L13:
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
    L15:
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final SavedStateHandlesProvider getSavedStateHandlesProvider(SavedStateRegistryOwner r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        SavedStateRegistry.SavedStateProvider r2 = r1.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY);
        if ((r2 instanceof SavedStateHandlesProvider) == false) goto L5;
        SavedStateHandlesProvider r3 = (SavedStateHandlesProvider) r2;
    L6:
        if (r3 == null) goto L9;
        return r3;
    L9:
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    L5:
        r3 = null;
        goto L6
    }

    static {
        SAVED_STATE_REGISTRY_OWNER_KEY = new SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1();
        VIEW_MODEL_STORE_OWNER_KEY = new SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1();
        DEFAULT_ARGS_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        InitializerViewModelFactoryBuilder r0 = new InitializerViewModelFactoryBuilder();
        SavedStateHandleSupport$savedStateHandlesVM$1$1 r1 = SavedStateHandleSupport$savedStateHandlesVM$1$1.INSTANCE;
        r0.addInitializer(Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class), r1);
        return (SavedStateHandlesVM) new ViewModelProvider(r3, r0.build()).get(VIEWMODEL_KEY, SavedStateHandlesVM.class);
    }
}
