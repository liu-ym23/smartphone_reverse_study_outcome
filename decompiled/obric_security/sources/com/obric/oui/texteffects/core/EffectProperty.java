package com.obric.oui.texteffects.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectProperty;", "", "(Ljava/lang/String;I)V", "Alpha", "BlurRadius", "TranslationX", "TranslationY", "Tracking", "GradientAlphaScan", "Visibility", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum EffectProperty extends Enum<EffectProperty> {
    private static final /* synthetic */ EffectProperty[] $VALUES = null;
    public static final EffectProperty Alpha = null;
    public static final EffectProperty BlurRadius = null;
    public static final EffectProperty GradientAlphaScan = null;
    public static final EffectProperty Tracking = null;
    public static final EffectProperty TranslationX = null;
    public static final EffectProperty TranslationY = null;
    public static final EffectProperty Visibility = null;

    private static final /* synthetic */ EffectProperty[] $values() {
        return new EffectProperty[]{Alpha, BlurRadius, TranslationX, TranslationY, Tracking, GradientAlphaScan, Visibility};
    }

    public static EffectProperty valueOf(String r1) {
        return (EffectProperty) Enum.valueOf(EffectProperty.class, r1);
    }

    public static EffectProperty[] values() {
        return (EffectProperty[]) $VALUES.clone();
    }

    private EffectProperty(String r1, int r2) {
        super(r1, r2);
    }

    static {
        Alpha = new EffectProperty("Alpha", 0);
        BlurRadius = new EffectProperty("BlurRadius", 1);
        TranslationX = new EffectProperty("TranslationX", 2);
        TranslationY = new EffectProperty("TranslationY", 3);
        Tracking = new EffectProperty("Tracking", 4);
        GradientAlphaScan = new EffectProperty("GradientAlphaScan", 5);
        Visibility = new EffectProperty("Visibility", 6);
        $VALUES = $values();
    }
}
