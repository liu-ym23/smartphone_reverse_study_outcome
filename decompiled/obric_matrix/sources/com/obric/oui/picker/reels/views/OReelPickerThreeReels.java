package com.obric.oui.picker.reels.views;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0019\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001d\u0010\u001c\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", "widthMeasureSpec", "heightMeasureSpec", "Lkotlin/f0;", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/obric/oui/picker/reels/views/WheelView;", "f", "Lkotlin/h;", "getWv1", "()Lcom/obric/oui/picker/reels/views/WheelView;", "wv1", "h", "getWv3", "wv3", "g", "getWv2", "wv2", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OReelPickerThreeReels extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f11259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h f11260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final h f11261h;

    static {
    }

    private final WheelView getWv1() {
        return (WheelView) this.f11259f.getValue();
    }

    private final WheelView getWv2() {
        return (WheelView) this.f11260g.getValue();
    }

    private final WheelView getWv3() {
        return (WheelView) this.f11261h.getValue();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }
}
