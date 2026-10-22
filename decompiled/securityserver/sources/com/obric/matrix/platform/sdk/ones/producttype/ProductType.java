package com.obric.matrix.platform.sdk.ones.producttype;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum ProductType extends Enum<ProductType> {
    private static final /* synthetic */ ProductType[] $VALUES = null;

    @NotNull
    public static final Companion Companion = null;
    public static final ProductType NERIDA = null;
    public static final ProductType PACIFIC = null;
    public static final ProductType PIKE = null;
    public static final ProductType UNKNOWN = null;

    @NotNull
    private final String value;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ProductType fromValue(@NotNull String r5) {
            Intrinsics.f(r5, "value");
            ProductType[] r4 = ProductType.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            ProductType r2 = r4[r1];
            if (Intrinsics.a(r2.getValue(), r5) == true) goto L9;
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

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    private static final /* synthetic */ ProductType[] $values() {
        return new ProductType[]{PACIFIC, NERIDA, PIKE, UNKNOWN};
    }

    static {
        PACIFIC = new ProductType("PACIFIC", 0, "pacific");
        NERIDA = new ProductType("NERIDA", 1, "nerida");
        PIKE = new ProductType("PIKE", 2, "pike");
        UNKNOWN = new ProductType(NetworkStackConstant.UNKNOWN_TYPE, 3, "");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private ProductType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ProductType valueOf(String r1) {
        return (ProductType) Enum.valueOf(ProductType.class, r1);
    }

    public static ProductType[] values() {
        return (ProductType[]) $VALUES.clone();
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
