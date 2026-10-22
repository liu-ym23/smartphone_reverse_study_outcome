package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes4.dex */
final class ExtensionRegistryFactory {
    static final Class<?> EXTENSION_REGISTRY_CLASS = null;
    static final String FULL_REGISTRY_CLASS_NAME = "com.google.crypto.tink.shaded.protobuf.ExtensionRegistry";

    ExtensionRegistryFactory() {
    }

    static {
        EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();
    }

    static Class<?> reflectExtensionRegistry() {
        return Class.forName(FULL_REGISTRY_CLASS_NAME);
    L4:
        return null;
    }

    public static ExtensionRegistryLite create() {
        ExtensionRegistryLite r0 = invokeSubclassFactory("newInstance");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite createEmpty() {
        ExtensionRegistryLite r0 = invokeSubclassFactory("getEmptyRegistry");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
    }

    static boolean isFullRegistry(ExtensionRegistryLite registry) {
        Class<?> r0 = EXTENSION_REGISTRY_CLASS;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isAssignableFrom(registry.getClass()) == false) goto L7;
        return true;
    }

    private static final ExtensionRegistryLite invokeSubclassFactory(String methodName) {
        Class<?> r0 = EXTENSION_REGISTRY_CLASS;
        if (r0 != null) goto L9;
        return null;
    L9:
        return (ExtensionRegistryLite) r0.getDeclaredMethod(methodName, new Class[0]).invoke(null, new Object[0]);
    L8:
        return null;
    }
}
