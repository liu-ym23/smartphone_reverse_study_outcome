package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class ExtensionSchemas {
    private static final ExtensionSchema<?> FULL_SCHEMA = null;
    private static final ExtensionSchema<?> LITE_SCHEMA = null;

    ExtensionSchemas() {
    }

    static {
        LITE_SCHEMA = new ExtensionSchemaLite();
        FULL_SCHEMA = loadSchemaForFullRuntime();
    }

    private static ExtensionSchema<?> loadSchemaForFullRuntime() {
        return (ExtensionSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L4:
        return null;
    }

    static ExtensionSchema<?> lite() {
        return LITE_SCHEMA;
    }

    static ExtensionSchema<?> full() {
        ExtensionSchema<?> r0 = FULL_SCHEMA;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
