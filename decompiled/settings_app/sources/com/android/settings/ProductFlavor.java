package com.android.settings;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: ProductFlavor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\tH\u0007J\b\u0010\f\u001a\u00020\tH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\b\u0010\u000e\u001a\u00020\tH\u0007J\b\u0010\u000f\u001a\u00020\tH\u0007J\b\u0010\u0010\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/settings/ProductFlavor;", "", "()V", "PRODUCT_CN", "", "PRODUCT_HK", "PRODUCT_NERIDA", "PRODUCT_PACIFIC", "isCN", "", "isHK", "isNerida", "isNeridaCn", "isNeridaHk", "isPacific", "isPacificCn", "isPacificHk", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ProductFlavor {
    public static final ProductFlavor INSTANCE = null;
    public static final String PRODUCT_CN = "cn";
    public static final String PRODUCT_HK = "hk";
    public static final String PRODUCT_NERIDA = "nerida";
    public static final String PRODUCT_PACIFIC = "pacific";

    static {
        INSTANCE = new ProductFlavor();
    }

    private ProductFlavor() {
    }

    @JvmStatic
    public static final boolean isNerida() {
        return TextUtils.equals("nerida", "nerida");
    }

    @JvmStatic
    public static final boolean isPacific() {
        return TextUtils.equals(PRODUCT_PACIFIC, "nerida");
    }

    @JvmStatic
    public static final boolean isCN() {
        return TextUtils.equals("cn", "cn");
    }

    @JvmStatic
    public static final boolean isHK() {
        return TextUtils.equals(PRODUCT_HK, "cn");
    }

    @JvmStatic
    public static final boolean isNeridaCn() {
        if (isNerida() == true) goto L5;
    L7:
        return false;
    L5:
        if (isCN() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean isNeridaHk() {
        if (isNerida() == true) goto L5;
    L7:
        return false;
    L5:
        if (isHK() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean isPacificCn() {
        if (isPacific() == true) goto L5;
    L7:
        return false;
    L5:
        if (isCN() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean isPacificHk() {
        if (isPacific() == true) goto L5;
    L7:
        return false;
    L5:
        if (isHK() == false) goto L7;
        return true;
    }
}
