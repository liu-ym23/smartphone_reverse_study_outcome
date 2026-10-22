package androidx.lifecycle;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    public ProcessLifecycleInitializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    @NonNull
    public LifecycleOwner create(@NonNull Context r2) {
        if (AppInitializer.getInstance(r2).isEagerlyInitialized(ProcessLifecycleInitializer.class) == false) goto L7;
        LifecycleDispatcher.init(r2);
        ProcessLifecycleOwner.init(r2);
        return ProcessLifecycleOwner.get();
    L7:
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public /* bridge */ /* synthetic */ LifecycleOwner create(@NonNull Context r1) {
        return create(r1);
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
