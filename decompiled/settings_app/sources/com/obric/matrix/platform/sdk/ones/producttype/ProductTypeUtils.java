package com.obric.matrix.platform.sdk.ones.producttype;

import com.android.settings.ProductFlavor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProductTypeUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/producttype/ProductTypeUtils;", "", "()V", "NERIDA", "", "getNERIDA", "()Ljava/lang/String;", "PACIFIC", "getPACIFIC", "SYS_PRODUCT_TYPE", "getSYS_PRODUCT_TYPE", "UNKNOWN_PRODUCT_TYPE", "getUNKNOWN_PRODUCT_TYPE", "getProductType", "getSystemProperty", "key", "isNerida", "", "isPacific", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductTypeUtils {
    public static final ProductTypeUtils INSTANCE = null;
    private static final String NERIDA = null;
    private static final String PACIFIC = null;
    private static final String SYS_PRODUCT_TYPE = null;
    private static final String UNKNOWN_PRODUCT_TYPE = null;

    private ProductTypeUtils() {
    }

    static {
        INSTANCE = new ProductTypeUtils();
        SYS_PRODUCT_TYPE = "ro.system_ext.product.type";
        UNKNOWN_PRODUCT_TYPE = "";
        PACIFIC = ProductFlavor.PRODUCT_PACIFIC;
        NERIDA = "nerida";
    }

    public final String getSYS_PRODUCT_TYPE() {
        return SYS_PRODUCT_TYPE;
    }

    public final String getUNKNOWN_PRODUCT_TYPE() {
        return UNKNOWN_PRODUCT_TYPE;
    }

    public final String getPACIFIC() {
        return PACIFIC;
    }

    public final String getNERIDA() {
        return NERIDA;
    }

    public final boolean isPacific() {
        return Intrinsics.areEqual(getProductType(), PACIFIC);
    }

    public final boolean isNerida() {
        return Intrinsics.areEqual(getProductType(), NERIDA);
    }

    public final String getProductType() {
        return getSystemProperty(SYS_PRODUCT_TYPE);
    }

    private final String getSystemProperty(String r8) {
        Object[] r1 = {r8, ""};     // Catch: Exception -> L10
        String r9 = null;
        Object r0 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, r1);     // Catch: Exception -> L10
        if ((r0 instanceof String) == false) goto L6;
        r9 = (String) r0;     // Catch: Exception -> L10
    L6:
        if (r9 != null) goto L9;
        return "";
    L9:
        return r9;
    L14:
        return "";
    }
}
