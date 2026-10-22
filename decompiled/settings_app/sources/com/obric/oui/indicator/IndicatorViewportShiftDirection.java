package com.obric.oui.indicator;

import kotlin.Metadata;

/* JADX INFO: compiled from: IndicatorViewportState.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/indicator/IndicatorViewportShiftDirection;", "", "exitTranslationSign", "", "(Ljava/lang/String;IF)V", "resolveExitTranslation", "stepDistance", "FORWARD", "BACKWARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum IndicatorViewportShiftDirection extends Enum<IndicatorViewportShiftDirection> {
    private static final /* synthetic */ IndicatorViewportShiftDirection[] $VALUES = null;
    public static final IndicatorViewportShiftDirection BACKWARD = null;
    public static final IndicatorViewportShiftDirection FORWARD = null;
    private final float exitTranslationSign;

    private static final /* synthetic */ IndicatorViewportShiftDirection[] $values() {
        return new IndicatorViewportShiftDirection[]{FORWARD, BACKWARD};
    }

    public static IndicatorViewportShiftDirection valueOf(String r1) {
        return (IndicatorViewportShiftDirection) Enum.valueOf(IndicatorViewportShiftDirection.class, r1);
    }

    public static IndicatorViewportShiftDirection[] values() {
        return (IndicatorViewportShiftDirection[]) $VALUES.clone();
    }

    private IndicatorViewportShiftDirection(String r1, int r2, float r3) {
        super(r1, r2);
        this.exitTranslationSign = r3;
    }

    static {
        FORWARD = new IndicatorViewportShiftDirection("FORWARD", 0, -1.0f);
        BACKWARD = new IndicatorViewportShiftDirection("BACKWARD", 1, 1.0f);
        $VALUES = $values();
    }

    public final float resolveExitTranslation(float r1) {
        return this.exitTranslationSign * r1;
    }
}
