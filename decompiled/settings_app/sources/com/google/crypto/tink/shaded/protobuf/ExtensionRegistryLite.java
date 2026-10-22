package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = null;
    static final String EXTENSION_CLASS_NAME = "com.google.crypto.tink.shaded.protobuf.Extension";
    private static boolean doFullRuntimeInheritanceCheck = true;
    private static volatile boolean eagerlyParseMessageSets = false;
    private static volatile ExtensionRegistryLite emptyRegistry;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    private static class ExtensionClassHolder {
        static final Class<?> INSTANCE = null;

        private ExtensionClassHolder() {
        }

        static {
            INSTANCE = resolveExtensionClass();
        }

        static Class<?> resolveExtensionClass() {
            return Class.forName(ExtensionRegistryLite.EXTENSION_CLASS_NAME);
        L4:
            return null;
        }
    }

    private static final class ObjectIntPair {
        private final int number;
        private final Object object;

        ObjectIntPair(final Object object, final int number) {
            this.object = object;
            this.number = number;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public boolean equals(final Object obj) {
            if ((obj instanceof ObjectIntPair) == true) goto L5;
            return false;
        L5:
            ObjectIntPair r4 = (ObjectIntPair) obj;
            if (this.object == r4.object) goto L8;
            return false;
        L8:
            if (this.number != r4.number) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static void setEagerlyParseMessageSets(boolean isEagerlyParse) {
        eagerlyParseMessageSets = isEagerlyParse;
    }

    public static ExtensionRegistryLite newInstance() {
        if (doFullRuntimeInheritanceCheck == false) goto L6;
        return ExtensionRegistryFactory.create();
    L6:
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        if (doFullRuntimeInheritanceCheck == false) goto L5;
        ExtensionRegistryLite r0 = emptyRegistry;
        if (r0 == null) goto L9;
    L18:
        return r0;
    L9:
        monitor-enter(ExtensionRegistryLite.class);
        r0 = emptyRegistry;     // Catch: Throwable -> L15
        if (r0 != null) goto L13;
        r0 = ExtensionRegistryFactory.createEmpty();     // Catch: Throwable -> L15
        emptyRegistry = r0;     // Catch: Throwable -> L15
    L13:
        monitor-exit(ExtensionRegistryLite.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L5:
        return EMPTY_REGISTRY_LITE;
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(final ContainingType containingTypeDefaultInstance, final int fieldNumber) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(containingTypeDefaultInstance, fieldNumber));
    }

    public final void add(final GeneratedMessageLite.GeneratedExtension<?, ?> extension) {
        this.extensionsByNumber.put(new ObjectIntPair(extension.getContainingTypeDefaultInstance(), extension.getNumber()), extension);
    }

    public final void add(ExtensionLite<?, ?> extension) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extension.getClass()) == false) goto L6;
        add((GeneratedMessageLite.GeneratedExtension) extension);
    L6:
        if (doFullRuntimeInheritanceCheck == true) goto L8;
        return;
    L8:
        if (ExtensionRegistryFactory.isFullRegistry(this) == true) goto L16;
        return;
    L16:
        getClass().getMethod("add", new Class[]{ExtensionClassHolder.INSTANCE}).invoke(this, new Object[]{extension});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[]{extension}), e);
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    static {
        EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    }

    ExtensionRegistryLite(ExtensionRegistryLite other) {
        if (other != EMPTY_REGISTRY_LITE) goto L5;
        this.extensionsByNumber = Collections.emptyMap();
        return;
    L5:
        this.extensionsByNumber = Collections.unmodifiableMap(other.extensionsByNumber);
    }

    ExtensionRegistryLite(boolean empty) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}
