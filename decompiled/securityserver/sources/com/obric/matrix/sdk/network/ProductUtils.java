package com.obric.matrix.sdk.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ProductUtils {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String SYS_PRODUCT_TYPE = null;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final String getSystemProperty(String r4) {
            String r1 = null;
            Object r3 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r4, ""});     // Catch: Exception -> L10
            if ((r3 instanceof String) == false) goto L6;
            r1 = (String) r3;     // Catch: Exception -> L10
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L14:
            return "";
        }

        @NotNull
        public final String getProductType() {
            return getSystemProperty(ProductUtils.access$getSYS_PRODUCT_TYPE$cp());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        SYS_PRODUCT_TYPE = "ro.system_ext.product.type";
    }

    public ProductUtils() {
    }

    public static final /* synthetic */ String access$getSYS_PRODUCT_TYPE$cp() {
        return SYS_PRODUCT_TYPE;
    }
}
