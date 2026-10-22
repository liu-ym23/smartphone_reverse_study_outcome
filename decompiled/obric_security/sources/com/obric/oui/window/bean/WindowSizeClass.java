package com.obric.oui.window.bean;

import kotlin.Metadata;

/* JADX INFO: compiled from: WindowSizeClass.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/window/bean/WindowSizeClass;", "", "dpSize", "", "baseGridConfig", "Lcom/obric/oui/window/bean/PageGridConfig;", "(Ljava/lang/String;IILcom/obric/oui/window/bean/PageGridConfig;)V", "getBaseGridConfig", "()Lcom/obric/oui/window/bean/PageGridConfig;", "getDpSize", "()I", "MINUS_ERROR_SIZE", "FLOATING_WINDOW", "SMALL_SPLIT_SCREEN", "SMALLER_ANDROID_SCREEN", "SMALL", "STANDARD", "NORMAL", "LARGE", "OVERSIZE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum WindowSizeClass extends Enum<WindowSizeClass> {
    private static final /* synthetic */ WindowSizeClass[] $VALUES = null;
    public static final WindowSizeClass FLOATING_WINDOW = null;
    public static final WindowSizeClass LARGE = null;
    public static final WindowSizeClass MINUS_ERROR_SIZE = null;
    public static final WindowSizeClass NORMAL = null;
    public static final WindowSizeClass OVERSIZE = null;
    public static final WindowSizeClass SMALL = null;
    public static final WindowSizeClass SMALLER_ANDROID_SCREEN = null;
    public static final WindowSizeClass SMALL_SPLIT_SCREEN = null;
    public static final WindowSizeClass STANDARD = null;
    private final PageGridConfig baseGridConfig;
    private final int dpSize;

    private static final /* synthetic */ WindowSizeClass[] $values() {
        return new WindowSizeClass[]{MINUS_ERROR_SIZE, FLOATING_WINDOW, SMALL_SPLIT_SCREEN, SMALLER_ANDROID_SCREEN, SMALL, STANDARD, NORMAL, LARGE, OVERSIZE};
    }

    public static WindowSizeClass valueOf(String r1) {
        return (WindowSizeClass) Enum.valueOf(WindowSizeClass.class, r1);
    }

    public static WindowSizeClass[] values() {
        return (WindowSizeClass[]) $VALUES.clone();
    }

    private WindowSizeClass(String r1, int r2, int r3, PageGridConfig r4) {
        super(r1, r2);
        this.dpSize = r3;
        this.baseGridConfig = r4;
    }

    public final PageGridConfig getBaseGridConfig() {
        return this.baseGridConfig;
    }

    public final int getDpSize() {
        return this.dpSize;
    }

    static {
        MINUS_ERROR_SIZE = new WindowSizeClass("MINUS_ERROR_SIZE", 0, -1, new PageGridConfig("MINUS_ERROR_SIZE", new PageColumns(1), new PageGutter(0), new PageMargin(0)));
        FLOATING_WINDOW = new WindowSizeClass("FLOATING_WINDOW", 1, 0, new PageGridConfig("FLOATING_WINDOW", new PageColumns(12), new PageGutter(11), new PageMargin(12)));
        SMALL_SPLIT_SCREEN = new WindowSizeClass("SMALL_SPLIT_SCREEN", 2, 375, new PageGridConfig("SMALL_SPLIT_SCREEN", new PageColumns(12), new PageGutter(12), new PageMargin(12)));
        SMALLER_ANDROID_SCREEN = new WindowSizeClass("SMALLER_ANDROID_SCREEN", 3, 516, new PageGridConfig("SMALLER_ANDROID_SCREEN", new PageColumns(12), new PageGutter(12), new PageMargin(16)));
        SMALL = new WindowSizeClass("SMALL", 4, 640, new PageGridConfig("SMALL", new PageColumns(12), new PageGutter(12), new PageMargin(16)));
        STANDARD = new WindowSizeClass("STANDARD", 5, 768, new PageGridConfig("STANDARD", new PageColumns(12), new PageGutter(12), new PageMargin(24)));
        NORMAL = new WindowSizeClass("NORMAL", 6, 834, new PageGridConfig("NORMAL", new PageColumns(12), new PageGutter(12), new PageMargin(24)));
        LARGE = new WindowSizeClass("LARGE", 7, 1024, new PageGridConfig("LARGE", new PageColumns(20), new PageGutter(16), new PageMargin(32)));
        OVERSIZE = new WindowSizeClass("OVERSIZE", 8, 1366, new PageGridConfig("OVERSIZE", new PageColumns(24), new PageGutter(16), new PageMargin(32)));
        $VALUES = $values();
    }
}
