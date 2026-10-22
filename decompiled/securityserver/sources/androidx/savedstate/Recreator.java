package androidx.savedstate;

import a.a;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
final class Recreator implements GenericLifecycleObserver {
    static final String CLASSES_KEY = "classes_to_restore";
    static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    private final SavedStateRegistryOwner mOwner;

    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        final Set<String> mClasses;

        public SavedStateProvider(SavedStateRegistry r2) {
            this.mClasses = new HashSet();
            r2.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
        }

        public void add(String r1) {
            this.mClasses.add(r1);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        @NonNull
        public Bundle saveState() {
            Bundle r0 = new Bundle();
            r0.putStringArrayList(Recreator.CLASSES_KEY, new ArrayList(this.mClasses));
            return r0;
        }
    }

    public Recreator(SavedStateRegistryOwner r1) {
        this.mOwner = r1;
    }

    private void reflectiveNew(String r4) {
        Class<? extends U> r0 = Class.forName(r4, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);     // Catch: ClassNotFoundException -> L15
        Constructor r1 = r0.getDeclaredConstructor(null);     // Catch: NoSuchMethodException -> L12
        r1.setAccessible(true);
        ((SavedStateRegistry.AutoRecreated) r1.newInstance(null)).onRecreated(this.mOwner);
        return;
    L9:
        e = move-exception;
        throw new RuntimeException(a.A("Failed to instantiate ", r4), e);
    L12:
        e = move-exception;
        throw new IllegalStateException("Class" + r0.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
    L15:
        e = move-exception;
        throw new RuntimeException(a.k("Class ", r4, " wasn't found"), e);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        if (r3 != Lifecycle.Event.ON_CREATE) goto L17;
        r2.getLifecycle().removeObserver(this);
        Bundle r4 = this.mOwner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
        if (r4 != null) goto L7;
        return;
    L7:
        ArrayList<String> r5 = r4.getStringArrayList(CLASSES_KEY);
        if (r5 == null) goto L15;
        Iterator<String> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        reflectiveNew(r6.next());
        goto L11
    L13:
        return;
    L15:
        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
    L17:
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
