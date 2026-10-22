package com.obric.oui.indicator;

import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;

/* JADX INFO: compiled from: IndicatorIcon.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\tH&J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\tH&J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0018\u0010\u0011\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/indicator/IndicatorIcon;", "", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "dotColor", "", "getDotColor", "()I", "setDotColor", "(I)V", "strokeColor", "getStrokeColor", "setStrokeColor", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "invalidate", "", "setEndMargin", "margin", "setHorizontalMargin", "horizontalMargin", "setStartMargin", "setWidth", MaterialConfigFormatNames.WIDTH, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IndicatorIcon {
    float getCornerRadius();

    int getDotColor();

    int getStrokeColor();

    float getStrokeWidth();

    void invalidate();

    void setCornerRadius(float r1);

    void setDotColor(int r1);

    void setEndMargin(int r1);

    void setHorizontalMargin(int r1);

    void setStartMargin(int r1);

    void setStrokeColor(int r1);

    void setStrokeWidth(float r1);

    void setWidth(int r1);
}
