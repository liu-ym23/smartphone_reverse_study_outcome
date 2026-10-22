package com.google.android.material.resources;

/* JADX INFO: loaded from: classes.dex */
public class TextAppearanceConfig {
    private static boolean shouldLoadFontSynchronously;

    public TextAppearanceConfig() {
    }

    public static void setShouldLoadFontSynchronously(boolean r0) {
        shouldLoadFontSynchronously = r0;
    }

    public static boolean shouldLoadFontSynchronously() {
        return shouldLoadFontSynchronously;
    }
}
