package com.obric.oui.window.bean;

import android.content.res.Resources;
import android.util.TypedValue;
import d.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum WindowSizeClass extends Enum<WindowSizeClass> {
    public static final WindowSizeClass b = null;
    public static final WindowSizeClass c = null;
    public static final WindowSizeClass e = null;
    public static final WindowSizeClass f = null;
    public static final WindowSizeClass i = null;
    public static final WindowSizeClass j = null;
    public static final WindowSizeClass k = null;
    public static final WindowSizeClass l = null;
    public static final WindowSizeClass m = null;
    public static final /* synthetic */ WindowSizeClass[] n = null;

    static {
        PageColumns r2 = new PageColumns();
        float r5 = 0;
        b.b("Resources.getSystem()", 1, r5);
        PageGutter r3 = new PageGutter();
        b.b("Resources.getSystem()", 1, r5);
        WindowSizeClass r0 = new WindowSizeClass("MINUS_ERROR_SIZE", 0, -1, new PageGridConfig("MINUS_ERROR_SIZE", r2, r3, new PageMargin()));
        b = r0;
        PageColumns r4 = new PageColumns();
        b.b("Resources.getSystem()", 1, 11);
        PageGutter r6 = new PageGutter();
        float r9 = 12;
        b.b("Resources.getSystem()", 1, r9);
        WindowSizeClass r1 = new WindowSizeClass("FLOATING_WINDOW", 1, 0, new PageGridConfig("FLOATING_WINDOW", r4, r6, new PageMargin()));
        c = r1;
        PageColumns r7 = new PageColumns();
        b.b("Resources.getSystem()", 1, r9);
        PageGutter r8 = new PageGutter();
        b.b("Resources.getSystem()", 1, r9);
        WindowSizeClass r10 = new WindowSizeClass("SMALL_SPLIT_SCREEN", 2, 375, new PageGridConfig("SMALL_SPLIT_SCREEN", r7, r8, new PageMargin()));
        e = r10;
        PageColumns r11 = new PageColumns();
        b.b("Resources.getSystem()", 1, r9);
        PageGutter r12 = new PageGutter();
        float r13 = 16;
        b.b("Resources.getSystem()", 1, r13);
        WindowSizeClass r14 = new WindowSizeClass("SMALLER_ANDROID_SCREEN", 3, 516, new PageGridConfig("SMALLER_ANDROID_SCREEN", r11, r12, new PageMargin()));
        f = r14;
        PageColumns r15 = new PageColumns();
        b.b("Resources.getSystem()", 1, r9);
        PageGutter r16 = new PageGutter();
        b.b("Resources.getSystem()", 1, r13);
        WindowSizeClass r17 = new WindowSizeClass("SMALL", 4, 640, new PageGridConfig("SMALL", r15, r16, new PageMargin()));
        i = r17;
        PageColumns r18 = new PageColumns();
        b.b("Resources.getSystem()", 1, r9);
        PageGutter r19 = new PageGutter();
        float r110 = 24;
        b.b("Resources.getSystem()", 1, r110);
        WindowSizeClass r20 = new WindowSizeClass("STANDARD", 5, 768, new PageGridConfig("STANDARD", r18, r19, new PageMargin()));
        j = r20;
        PageColumns r111 = new PageColumns();
        b.b("Resources.getSystem()", 1, r9);
        PageGutter r112 = new PageGutter();
        b.b("Resources.getSystem()", 1, r110);
        WindowSizeClass r21 = new WindowSizeClass("NORMAL", 6, 834, new PageGridConfig("NORMAL", r111, r112, new PageMargin()));
        k = r21;
        PageColumns r113 = new PageColumns();
        b.b("Resources.getSystem()", 1, r13);
        PageGutter r114 = new PageGutter();
        float r115 = 32;
        b.b("Resources.getSystem()", 1, r115);
        WindowSizeClass r22 = new WindowSizeClass("LARGE", 7, 1024, new PageGridConfig("LARGE", r113, r114, new PageMargin()));
        l = r22;
        PageColumns r116 = new PageColumns();
        Resources r117 = Resources.getSystem();
        Intrinsics.e(r117, "Resources.getSystem()");
        MathKt.a(TypedValue.applyDimension(1, r13, r117.getDisplayMetrics()));
        PageGutter r118 = new PageGutter();
        b.b("Resources.getSystem()", 1, r115);
        WindowSizeClass r119 = new WindowSizeClass("OVERSIZE", 8, 1366, new PageGridConfig("OVERSIZE", r116, r118, new PageMargin()));
        m = r119;
        n = new WindowSizeClass[]{r0, r1, r10, r14, r17, r20, r21, r22, r119};
    }

    public WindowSizeClass(String r1, int r2, int r3, PageGridConfig r4) {
        super(r1, r2);
    }

    public static WindowSizeClass valueOf(String r1) {
        return (WindowSizeClass) Enum.valueOf(WindowSizeClass.class, r1);
    }

    public static WindowSizeClass[] values() {
        return (WindowSizeClass[]) n.clone();
    }
}
