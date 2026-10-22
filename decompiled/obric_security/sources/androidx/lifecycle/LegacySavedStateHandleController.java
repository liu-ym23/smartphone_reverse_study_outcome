package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class LegacySavedStateHandleController {
    static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        OnRecreation() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(SavedStateRegistryOwner r5) {
            if ((r5 instanceof ViewModelStoreOwner) == false) goto L13;
            ViewModelStore r4 = ((ViewModelStoreOwner) r5).getViewModelStore();
            SavedStateRegistry r0 = r5.getSavedStateRegistry();
            Iterator<String> r1 = r4.keys().iterator();
        L6:
            if (r1.hasNext() == false) goto L9;
            LegacySavedStateHandleController.attachHandleIfNeeded(r4.get(r1.next()), r0, r5.getLifecycle());
            goto L6
        L9:
            if (r4.keys().isEmpty() == true) goto L15;
            r0.runOnNextRecreation(OnRecreation.class);
            return;
        L15:
            return;
        L13:
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
        }
    }

    private LegacySavedStateHandleController() {
    }

    static SavedStateHandleController create(SavedStateRegistry r1, Lifecycle r2, String r3, Bundle r4) {
        SavedStateHandleController r0 = new SavedStateHandleController(r3, SavedStateHandle.createHandle(r1.consumeRestoredStateForKey(r3), r4));
        r0.attachToLifecycle(r1, r2);
        tryToAddRecreator(r1, r2);
        return r0;
    }

    static void attachHandleIfNeeded(ViewModel r1, SavedStateRegistry r2, Lifecycle r3) {
        SavedStateHandleController r4 = (SavedStateHandleController) r1.getTag(TAG_SAVED_STATE_HANDLE_CONTROLLER);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isAttached() == true) goto L9;
        r4.attachToLifecycle(r2, r3);
        tryToAddRecreator(r2, r3);
        return;
    }

    private static void tryToAddRecreator(final SavedStateRegistry r2, final Lifecycle r3) {
        Lifecycle.State r0 = r3.getCurrentState();
        if (r0 != Lifecycle.State.INITIALIZED) goto L5;
    L8:
        r2.runOnNextRecreation(OnRecreation.class);
        return;
    L5:
        if (r0.isAtLeast(Lifecycle.State.STARTED) == true) goto L8;
        r3.addObserver(new AnonymousClass1(r3, r2));
    }
}
