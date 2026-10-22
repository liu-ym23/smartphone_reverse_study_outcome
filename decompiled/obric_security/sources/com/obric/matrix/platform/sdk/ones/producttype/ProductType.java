package com.obric.matrix.platform.sdk.ones.producttype;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProductTypeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/producttype/ProductType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PACIFIC", "NERIDA", "PIKE", NetworkStackConstant.UNKNOWN_TYPE, "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ProductType extends Enum<ProductType> {
    private static final /* synthetic */ ProductType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ProductType NERIDA = null;
    public static final ProductType PACIFIC = null;
    public static final ProductType PIKE = null;
    public static final ProductType UNKNOWN = null;
    private final String value;

    /* JADX INFO: compiled from: ProductTypeUtils.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/producttype/ProductType$Companion;", "", "()V", "fromValue", "Lcom/obric/matrix/platform/sdk/ones/producttype/ProductType;", "value", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final ProductType fromValue(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            ProductType[] r4 = ProductType.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            ProductType r2 = r4[r1];
            if (Intrinsics.areEqual(r2.getValue(), r5) == true) goto L9;
            r1 = r1 + 1;
        L9:
            if (r2 == null) goto L11;
            return r2;
        L11:
            return ProductType.UNKNOWN;
        L8:
            r2 = null;
            goto L9
        }
    }

    private static final /* synthetic */ ProductType[] $values() {
        return new ProductType[]{PACIFIC, NERIDA, PIKE, UNKNOWN};
    }

    public static ProductType valueOf(String r1) {
        return (ProductType) Enum.valueOf(ProductType.class, r1);
    }

    public static ProductType[] values() {
        return (ProductType[]) $VALUES.clone();
    }

    private ProductType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        PACIFIC = new ProductType("PACIFIC", 0, "pacific");
        NERIDA = new ProductType("NERIDA", 1, "nerida");
        PIKE = new ProductType("PIKE", 2, "pike");
        UNKNOWN = new ProductType(NetworkStackConstant.UNKNOWN_TYPE, 3, "");
        $VALUES = $values();
        Companion = new Companion(null);
    }
}
