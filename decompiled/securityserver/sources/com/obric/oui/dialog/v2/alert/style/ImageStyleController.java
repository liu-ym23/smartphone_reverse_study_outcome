package com.obric.oui.dialog.v2.alert.style;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ImageStyleController implements StyleController {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class FixRatioLayout extends FrameLayout {
        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r2, int r3) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r2) / 2, BasicMeasure.EXACTLY));
        }
    }

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface ImageStyle {
    }
}
