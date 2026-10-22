package com.gyf.barlibrary;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BarParams implements Cloneable {
    float autoNavigationBarDarkModeAlpha;
    boolean autoNavigationBarDarkModeEnable;
    float autoStatusBarDarkModeAlpha;
    boolean autoStatusBarDarkModeEnable;
    BarHide barHide;
    float contentAlpha;
    int contentColor;
    int contentColorTransform;
    int defaultNavigationBarColor;
    public boolean fits;

    @Deprecated
    boolean fixMarginAtBottom;
    int flymeOSStatusBarFontColor;
    public boolean fullScreen;
    boolean hideNavigationBar;
    boolean isSupportActionBar;
    public boolean keyboardEnable;
    int keyboardMode;
    float navigationBarAlpha;
    int navigationBarColor;
    int navigationBarColorTransform;
    boolean navigationBarDarkIcon;
    boolean navigationBarEnable;
    boolean navigationBarWithEMUI3Enable;
    boolean navigationBarWithKitkatEnable;
    OnKeyboardListener onKeyboardListener;
    float statusBarAlpha;
    int statusBarColor;
    boolean statusBarColorEnabled;
    int statusBarColorTransform;
    boolean statusBarDarkFont;
    View statusBarView;
    View titleBarView;
    boolean useDefaultNavigationBarColor;
    float viewAlpha;
    Map<View, Map<Integer, Integer>> viewMap;

    public BarParams() {
        this.statusBarColor = 0;
        this.navigationBarColor = -16777216;
        this.useDefaultNavigationBarColor = true;
        this.defaultNavigationBarColor = -16777216;
        this.statusBarAlpha = 0.0f;
        this.navigationBarAlpha = 0.0f;
        this.fullScreen = false;
        this.hideNavigationBar = false;
        this.barHide = BarHide.FLAG_SHOW_BAR;
        this.statusBarDarkFont = false;
        this.navigationBarDarkIcon = false;
        this.autoStatusBarDarkModeEnable = false;
        this.autoNavigationBarDarkModeEnable = false;
        this.autoStatusBarDarkModeAlpha = 0.0f;
        this.autoNavigationBarDarkModeAlpha = 0.0f;
        this.statusBarColorEnabled = true;
        this.statusBarColorTransform = -16777216;
        this.navigationBarColorTransform = -16777216;
        this.viewMap = new HashMap();
        this.viewAlpha = 0.0f;
        this.contentColor = 0;
        this.contentColorTransform = -16777216;
        this.contentAlpha = 0.0f;
        this.fits = false;
        this.isSupportActionBar = false;
        this.keyboardEnable = false;
        this.keyboardMode = 18;
        this.navigationBarEnable = true;
        this.navigationBarWithKitkatEnable = true;
        this.navigationBarWithEMUI3Enable = true;
        this.fixMarginAtBottom = false;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    protected /* bridge */ /* synthetic */ Object m140clone() throws CloneNotSupportedException {
        return clone();
    }

    protected BarParams clone() {
        return (BarParams) super.clone();
    L4:
        return null;
    }
}
