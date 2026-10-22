package androidx.lifecycle;

import android.content.Context;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    public ProcessLifecycleInitializer() {
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ LifecycleOwner create(Context r1) {
        return create(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.startup.Initializer
    public LifecycleOwner create(Context r2) {
        if (AppInitializer.getInstance(r2).isEagerlyInitialized(getClass()) == false) goto L7;
        LifecycleDispatcher.init(r2);
        ProcessLifecycleOwner.init(r2);
        return ProcessLifecycleOwner.get();
    L7:
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
