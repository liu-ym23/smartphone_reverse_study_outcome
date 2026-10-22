package com.bytedance.android.standard.tools.ui;

/* JADX INFO: loaded from: classes.dex */
public interface ICustomToast {
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2000;
    public static final int LENGTH_WITH_ICON = 1500;

    void dismissCustomToast();

    void showCustomLongToast(int r1, String r2);

    void showCustomToast(int r1, String r2);

    void showCustomToast(int r1, String r2, int r3, int r4);

    void showCustomToast(String r1);

    void showCustomToast(String r1, int r2, int r3);
}
