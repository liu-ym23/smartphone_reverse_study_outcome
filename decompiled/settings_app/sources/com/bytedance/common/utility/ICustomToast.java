package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface ICustomToast extends com.bytedance.android.standard.tools.ui.ICustomToast {
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2000;
    public static final int LENGTH_WITH_ICON = 1500;

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void dismissCustomToast();

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void showCustomLongToast(int r1, String r2);

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void showCustomToast(int r1, String r2);

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void showCustomToast(int r1, String r2, int r3, int r4);

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void showCustomToast(String r1);

    @Override // com.bytedance.android.standard.tools.ui.ICustomToast
    void showCustomToast(String r1, int r2, int r3);
}
