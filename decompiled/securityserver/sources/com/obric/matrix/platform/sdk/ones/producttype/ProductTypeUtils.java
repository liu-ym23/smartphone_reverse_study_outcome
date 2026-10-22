package com.obric.matrix.platform.sdk.ones.producttype;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ProductTypeUtils {

    @NotNull
    public static final ProductTypeUtils INSTANCE = null;

    @NotNull
    private static final String NERIDA = null;

    @NotNull
    private static final String PACIFIC = null;

    @NotNull
    private static final String PIKE = null;

    @NotNull
    private static final String SYS_PRODUCT_TYPE = null;

    @NotNull
    private static final String UNKNOWN_PRODUCT_TYPE = null;

    static {
        INSTANCE = new ProductTypeUtils();
        SYS_PRODUCT_TYPE = "ro.system_ext.product.type";
        UNKNOWN_PRODUCT_TYPE = "";
        PACIFIC = "pacific";
        NERIDA = "nerida";
        PIKE = "pike";
    }

    private ProductTypeUtils() {
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
    public final String getNERIDA() {
        return NERIDA;
    }

    @NotNull
    public final String getPACIFIC() {
        return PACIFIC;
    }

    @NotNull
    public final String getPIKE() {
        return PIKE;
    }

    @NotNull
    public final String getProductType() {
        return getSystemProperty(SYS_PRODUCT_TYPE);
    }

    @NotNull
    public final ProductType getProductTypeEnum() {
        String r1 = getProductType();
        return ProductType.Companion.fromValue(r1);
    }

    @NotNull
    public final String getSYS_PRODUCT_TYPE() {
        return SYS_PRODUCT_TYPE;
    }

    @NotNull
    public final String getUNKNOWN_PRODUCT_TYPE() {
        return UNKNOWN_PRODUCT_TYPE;
    }

    public final boolean isNerida() {
        return Intrinsics.a(getProductType(), NERIDA);
    }

    public final boolean isPacific() {
        return Intrinsics.a(getProductType(), PACIFIC);
    }

    public final boolean isPike() {
        return Intrinsics.a(getProductType(), PIKE);
    }
}
