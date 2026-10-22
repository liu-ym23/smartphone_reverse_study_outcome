package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class Easing {
    private static final float DOUBLE_PI = 6.2831855f;
    public static final EasingFunction EaseInBack = null;
    public static final EasingFunction EaseInBounce = null;
    public static final EasingFunction EaseInCirc = null;
    public static final EasingFunction EaseInCubic = null;
    public static final EasingFunction EaseInElastic = null;
    public static final EasingFunction EaseInExpo = null;
    public static final EasingFunction EaseInOutBack = null;
    public static final EasingFunction EaseInOutBounce = null;
    public static final EasingFunction EaseInOutCirc = null;
    public static final EasingFunction EaseInOutCubic = null;
    public static final EasingFunction EaseInOutElastic = null;
    public static final EasingFunction EaseInOutExpo = null;
    public static final EasingFunction EaseInOutQuad = null;
    public static final EasingFunction EaseInOutQuart = null;
    public static final EasingFunction EaseInOutSine = null;
    public static final EasingFunction EaseInQuad = null;
    public static final EasingFunction EaseInQuart = null;
    public static final EasingFunction EaseInSine = null;
    public static final EasingFunction EaseOutBack = null;
    public static final EasingFunction EaseOutBounce = null;
    public static final EasingFunction EaseOutCirc = null;
    public static final EasingFunction EaseOutCubic = null;
    public static final EasingFunction EaseOutElastic = null;
    public static final EasingFunction EaseOutExpo = null;
    public static final EasingFunction EaseOutQuad = null;
    public static final EasingFunction EaseOutQuart = null;
    public static final EasingFunction EaseOutSine = null;
    public static final EasingFunction Linear = null;

    public interface EasingFunction extends TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        float getInterpolation(float r1);
    }

    public Easing() {
    }

    static {
        Linear = new AnonymousClass1();
        EaseInQuad = new AnonymousClass2();
        EaseOutQuad = new AnonymousClass3();
        EaseInOutQuad = new AnonymousClass4();
        EaseInCubic = new AnonymousClass5();
        EaseOutCubic = new AnonymousClass6();
        EaseInOutCubic = new AnonymousClass7();
        EaseInQuart = new AnonymousClass8();
        EaseOutQuart = new AnonymousClass9();
        EaseInOutQuart = new AnonymousClass10();
        EaseInSine = new AnonymousClass11();
        EaseOutSine = new AnonymousClass12();
        EaseInOutSine = new AnonymousClass13();
        EaseInExpo = new AnonymousClass14();
        EaseOutExpo = new AnonymousClass15();
        EaseInOutExpo = new AnonymousClass16();
        EaseInCirc = new AnonymousClass17();
        EaseOutCirc = new AnonymousClass18();
        EaseInOutCirc = new AnonymousClass19();
        EaseInElastic = new AnonymousClass20();
        EaseOutElastic = new AnonymousClass21();
        EaseInOutElastic = new AnonymousClass22();
        EaseInBack = new AnonymousClass23();
        EaseOutBack = new AnonymousClass24();
        EaseInOutBack = new AnonymousClass25();
        EaseInBounce = new AnonymousClass26();
        EaseOutBounce = new AnonymousClass27();
        EaseInOutBounce = new AnonymousClass28();
    }
}
