package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.PrimitiveWrapper;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class MutablePrimitiveRegistry {
    private static MutablePrimitiveRegistry globalInstance;
    private final AtomicReference<PrimitiveRegistry> registry;

    static {
        globalInstance = new MutablePrimitiveRegistry();
    }

    public static MutablePrimitiveRegistry globalInstance() {
        return globalInstance;
    }

    public static void resetGlobalInstanceTestOnly() {
        globalInstance = new MutablePrimitiveRegistry();
    }

    MutablePrimitiveRegistry() {
        this.registry = new AtomicReference(PrimitiveRegistry.builder().build());
    }

    public synchronized <KeyT extends Key, PrimitiveT> void registerPrimitiveConstructor(PrimitiveConstructor<KeyT, PrimitiveT> constructor) throws GeneralSecurityException {
        monitor-enter(this);
        PrimitiveRegistry r2 = PrimitiveRegistry.builder(this.registry.get()).registerPrimitiveConstructor(constructor).build();     // Catch: Throwable -> L6
        this.registry.set(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <InputPrimitiveT, WrapperPrimitiveT> void registerPrimitiveWrapper(PrimitiveWrapper<InputPrimitiveT, WrapperPrimitiveT> wrapper) throws GeneralSecurityException {
        monitor-enter(this);
        PrimitiveRegistry r2 = PrimitiveRegistry.builder(this.registry.get()).registerPrimitiveWrapper(wrapper).build();     // Catch: Throwable -> L6
        this.registry.set(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public <KeyT extends Key, PrimitiveT> PrimitiveT getPrimitive(KeyT r1, Class<PrimitiveT> r2) throws GeneralSecurityException {
        return (PrimitiveT) this.registry.get().getPrimitive(r1, r2);
    }

    public <WrapperPrimitiveT> Class<?> getInputPrimitiveClass(Class<WrapperPrimitiveT> wrapperClassObject) throws GeneralSecurityException {
        return this.registry.get().getInputPrimitiveClass(wrapperClassObject);
    }

    public <InputPrimitiveT, WrapperPrimitiveT> WrapperPrimitiveT wrap(PrimitiveSet<InputPrimitiveT> r1, Class<WrapperPrimitiveT> r2) throws GeneralSecurityException {
        return (WrapperPrimitiveT) this.registry.get().wrap(r1, r2);
    }
}
