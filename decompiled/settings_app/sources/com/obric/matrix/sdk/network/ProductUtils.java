package com.obric.matrix.sdk.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ProductUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/matrix/sdk/network/ProductUtils;", "", "()V", "Companion", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductUtils {
    public static final Companion Companion = null;
    private static final String SYS_PRODUCT_TYPE = null;

    /* JADX INFO: compiled from: ProductUtils.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/sdk/network/ProductUtils$Companion;", "", "()V", "SYS_PRODUCT_TYPE", "", "getProductType", "getSystemProperty", "key", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final String getProductType() {
            return getSystemProperty(ProductUtils.access$getSYS_PRODUCT_TYPE$cp());
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

    public ProductUtils() {
    }

    public static final /* synthetic */ String access$getSYS_PRODUCT_TYPE$cp() {
        return SYS_PRODUCT_TYPE;
    }

    static {
        Companion = new Companion(null);
        SYS_PRODUCT_TYPE = "ro.system_ext.product.type";
    }
}
