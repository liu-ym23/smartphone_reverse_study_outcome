package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.PrimitiveWrapper;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class PrimitiveRegistry {
    private final Map<PrimitiveConstructorIndex, PrimitiveConstructor<?, ?>> primitiveConstructorMap;
    private final Map<Class<?>, PrimitiveWrapper<?, ?>> primitiveWrapperMap;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.PrimitiveRegistry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final Map<PrimitiveConstructorIndex, PrimitiveConstructor<?, ?>> primitiveConstructorMap;
        private final Map<Class<?>, PrimitiveWrapper<?, ?>> primitiveWrapperMap;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        /* synthetic */ Builder(PrimitiveRegistry r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ Map access$600(Builder r0) {
            return r0.primitiveConstructorMap;
        }

        static /* synthetic */ Map access$700(Builder r0) {
            return r0.primitiveWrapperMap;
        }

        private Builder() {
            this.primitiveConstructorMap = new HashMap();
            this.primitiveWrapperMap = new HashMap();
        }

        private Builder(PrimitiveRegistry registry) {
            this.primitiveConstructorMap = new HashMap(PrimitiveRegistry.access$000(registry));
            this.primitiveWrapperMap = new HashMap(PrimitiveRegistry.access$100(registry));
        }

        public <KeyT extends Key, PrimitiveT> Builder registerPrimitiveConstructor(PrimitiveConstructor<KeyT, PrimitiveT> primitiveConstructor) throws GeneralSecurityException {
            if (primitiveConstructor == null) goto L15;
            PrimitiveConstructorIndex r0 = new PrimitiveConstructorIndex(primitiveConstructor.getKeyClass(), primitiveConstructor.getPrimitiveClass(), null);
            if (this.primitiveConstructorMap.containsKey(r0) == false) goto L12;
            PrimitiveConstructor<?, ?> r1 = this.primitiveConstructorMap.get(r0);
            if (r1.equals(primitiveConstructor) == false) goto L11;
            if (primitiveConstructor.equals(r1) == false) goto L11;
        L13:
            return this;
        L11:
            throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + r0);
        L12:
            this.primitiveConstructorMap.put(r0, primitiveConstructor);
            goto L13
        L15:
            throw new NullPointerException("primitive constructor must be non-null");
        }

        public <InputPrimitiveT, WrapperPrimitiveT> Builder registerPrimitiveWrapper(PrimitiveWrapper<InputPrimitiveT, WrapperPrimitiveT> wrapper) throws GeneralSecurityException {
            if (wrapper == null) goto L15;
            Class<WrapperPrimitiveT> r0 = wrapper.getPrimitiveClass();
            if (this.primitiveWrapperMap.containsKey(r0) == false) goto L12;
            PrimitiveWrapper<?, ?> r1 = this.primitiveWrapperMap.get(r0);
            if (r1.equals(wrapper) == false) goto L11;
            if (wrapper.equals(r1) == false) goto L11;
        L13:
            return this;
        L11:
            throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + r0);
        L12:
            this.primitiveWrapperMap.put(r0, wrapper);
            goto L13
        L15:
            throw new NullPointerException("wrapper must be non-null");
        }

        public PrimitiveRegistry build() {
            return new PrimitiveRegistry(this, null);
        }
    }

    private static final class PrimitiveConstructorIndex {
        private final Class<?> keyClass;
        private final Class<?> primitiveClass;

        /* synthetic */ PrimitiveConstructorIndex(Class r1, Class r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private PrimitiveConstructorIndex(Class<?> keyClass, Class<?> primitiveClass) {
            this.keyClass = keyClass;
            this.primitiveClass = primitiveClass;
        }

        public boolean equals(Object o) {
            if ((o instanceof PrimitiveConstructorIndex) == true) goto L5;
            return false;
        L5:
            PrimitiveConstructorIndex r4 = (PrimitiveConstructorIndex) o;
            if (r4.keyClass.equals(this.keyClass) == true) goto L8;
            return false;
        L8:
            if (r4.primitiveClass.equals(this.primitiveClass) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.keyClass, this.primitiveClass});
        }

        public String toString() {
            return this.keyClass.getSimpleName() + " with primitive type: " + this.primitiveClass.getSimpleName();
        }
    }

    /* synthetic */ PrimitiveRegistry(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Map access$000(PrimitiveRegistry r0) {
        return r0.primitiveConstructorMap;
    }

    static /* synthetic */ Map access$100(PrimitiveRegistry r0) {
        return r0.primitiveWrapperMap;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static Builder builder(PrimitiveRegistry registry) {
        return new Builder(registry, null);
    }

    private PrimitiveRegistry(Builder builder) {
        this.primitiveConstructorMap = new HashMap(Builder.access$600(builder));
        this.primitiveWrapperMap = new HashMap(Builder.access$700(builder));
    }

    public <KeyT extends Key, PrimitiveT> PrimitiveT getPrimitive(KeyT r4, Class<PrimitiveT> r5) throws GeneralSecurityException {
        PrimitiveConstructorIndex r0 = new PrimitiveConstructorIndex(r4.getClass(), r5, null);
        if (this.primitiveConstructorMap.containsKey(r0) == false) goto L7;
        return (PrimitiveT) this.primitiveConstructorMap.get(r0).constructPrimitive(r4);
    L7:
        throw new GeneralSecurityException("No PrimitiveConstructor for " + r0 + " available");
    }

    public Class<?> getInputPrimitiveClass(Class<?> wrapperClassObject) throws GeneralSecurityException {
        if (this.primitiveWrapperMap.containsKey(wrapperClassObject) == false) goto L7;
        return this.primitiveWrapperMap.get(wrapperClassObject).getInputPrimitiveClass();
    L7:
        throw new GeneralSecurityException("No input primitive class for " + wrapperClassObject + " available");
    }

    public <InputPrimitiveT, WrapperPrimitiveT> WrapperPrimitiveT wrap(PrimitiveSet<InputPrimitiveT> r2, Class<WrapperPrimitiveT> r3) throws GeneralSecurityException {
        if (this.primitiveWrapperMap.containsKey(r3) == false) goto L13;
        PrimitiveWrapper<?, ?> r1 = this.primitiveWrapperMap.get(r3);
        if (r2.getPrimitiveClass().equals(r1.getInputPrimitiveClass()) == false) goto L11;
        if (r1.getInputPrimitiveClass().equals(r2.getPrimitiveClass()) == false) goto L11;
        return (WrapperPrimitiveT) r1.wrap(r2);
    L11:
        throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
    L13:
        throw new GeneralSecurityException("No wrapper found for " + r3);
    }
}
