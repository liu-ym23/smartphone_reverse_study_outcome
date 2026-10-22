package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.picker.reels.OReelPicker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OReelPickerThreeReels.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002+,B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\bH\u0016J0\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0014J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0014J$\u0010\u0019\u001a\u00020\u001a*\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0002R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000e¨\u0006-"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/picker/reels/OReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "reelsCount", "wv1", "Lcom/obric/oui/picker/reels/views/WheelView;", "getWv1", "()Lcom/obric/oui/picker/reels/views/WheelView;", "wv1$delegate", "Lkotlin/Lazy;", "wv2", "getWv2", "wv2$delegate", "wv3", "getWv3", "wv3$delegate", "asView", "Landroid/view/View;", "configure", "", "col", "reel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "getReelView", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "colIndex", "maxColIndex", "Builder", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OReelPickerThreeReels extends ConstraintLayout implements OReelPicker {
    public static final Companion Companion = null;
    private static final String TAG = "OReelPickerThreeReels";
    private int reelsCount;
    private final Lazy wv1$delegate;
    private final Lazy wv2$delegate;
    private final Lazy wv3$delegate;

    /* JADX INFO: compiled from: OReelPickerThreeReels.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels$Builder;", "Lcom/obric/oui/picker/reels/OReelPicker$Builder;", "()V", "mReels", "", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "addReel", "reel", IndexDatabaseHelper.MetaColumns.BUILD, "Lcom/obric/oui/picker/reels/OReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "setReels", "", "Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels;", "reels", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder implements OReelPicker.Builder {
        private final List<OReelPicker.Reel> mReels;

        public Builder() {
            this.mReels = new ArrayList();
        }

        @Override // com.obric.oui.picker.reels.OReelPicker.Builder
        public OReelPicker.Builder addReel(OReelPicker.Reel r2) {
            Intrinsics.checkNotNullParameter(r2, "reel");
            this.mReels.add(r2);
            return this;
        }

        @Override // com.obric.oui.picker.reels.OReelPicker.Builder
        public OReelPicker build(Context r2, AttributeSet r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            OReelPickerThreeReels r0 = new OReelPickerThreeReels(r2, r3, r4);
            setReels(r0, this.mReels);
            r0.setLayoutParams(new LinearLayout.LayoutParams(-1, OUnitExtensionKt.vdp(r0, 240)));
            return r0;
        }

        private final void setReels(OReelPickerThreeReels r6, List<OReelPicker.Reel> r7) {
            int r5 = this.mReels.size();
            if (r5 != 0) goto L5;
            OReelPickerThreeReels.access$setReelsCount$p(r6, 0);
            return;
        L5:
            if (r5 != 1) goto L7;
            OReelPickerThreeReels.access$configure(r6, OReelPickerThreeReels.access$getWv1(r6), r7.get(0), 0, 0);
            OReelPickerThreeReels.access$getWv2(r6).setVisibility(8);
            OReelPickerThreeReels.access$getWv3(r6).setVisibility(8);
            OReelPickerThreeReels.access$setReelsCount$p(r6, 1);
            return;
        L7:
            if (r5 == 2) goto L9;
            OReelPickerThreeReels.access$configure(r6, OReelPickerThreeReels.access$getWv1(r6), r7.get(0), 0, 2);
            OReelPickerThreeReels.access$configure(r6, OReelPickerThreeReels.access$getWv2(r6), r7.get(1), 1, 2);
            OReelPickerThreeReels.access$configure(r6, OReelPickerThreeReels.access$getWv3(r6), r7.get(2), 2, 2);
            OReelPickerThreeReels.access$setReelsCount$p(r6, 3);
            return;
        L9:
            OReelPickerThreeReels.access$configure(r6, OReelPickerThreeReels.access$getWv1(r6), r7.get(0), 0, 1);
            OReelPickerThreeReels.access$configure(r6, OReelPickerThreeReels.access$getWv2(r6), r7.get(1), 1, 1);
            OReelPickerThreeReels.access$getWv3(r6).setVisibility(8);
            OReelPickerThreeReels.access$setReelsCount$p(r6, 2);
        }
    }

    /* JADX INFO: compiled from: OReelPickerThreeReels.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OReelPickerThreeReels(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OReelPickerThreeReels(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OReelPickerThreeReels(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void access$configure(OReelPickerThreeReels r0, WheelView r1, OReelPicker.Reel r2, int r3, int r4) {
        r0.configure(r1, r2, r3, r4);
    }

    public static final /* synthetic */ WheelView access$getWv1(OReelPickerThreeReels r0) {
        return r0.getWv1();
    }

    public static final /* synthetic */ WheelView access$getWv2(OReelPickerThreeReels r0) {
        return r0.getWv2();
    }

    public static final /* synthetic */ WheelView access$getWv3(OReelPickerThreeReels r0) {
        return r0.getWv3();
    }

    public static final /* synthetic */ void access$setReelsCount$p(OReelPickerThreeReels r0, int r1) {
        r0.reelsCount = r1;
    }

    public OReelPickerThreeReels(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.wv1$delegate = LazyKt.lazy(new OReelPickerThreeReels$wv1$2(this));
        this.wv2$delegate = LazyKt.lazy(new OReelPickerThreeReels$wv2$2(this));
        this.wv3$delegate = LazyKt.lazy(new OReelPickerThreeReels$wv3$2(this));
        LayoutInflater.from(r2).inflate(R.layout.o_reel_picker_3_reels, this);
    }

    private final WheelView getWv1() {
        Object r1 = this.wv1$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-wv1>(...)");
        return (WheelView) r1;
    }

    private final WheelView getWv2() {
        Object r1 = this.wv2$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-wv2>(...)");
        return (WheelView) r1;
    }

    private final WheelView getWv3() {
        Object r1 = this.wv3$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-wv3>(...)");
        return (WheelView) r1;
    }

    private final void configure(WheelView r2, final OReelPicker.Reel r3, int r4, int r5) {
        r2.setVisibility(0);
        CharSequence r1 = r3.getTag();
        if (r1 == null) goto L6;
        r2.setTagText(r1);
    L6:
        r2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, r3.getWidthWeight()));
        r2.setOnWheelChangedListener(new AnonymousClass2(r3));
        r2.setEntries(r3.getEntries(), RangesKt.coerceIn(r3.getSelectedIndex(), 0, RangesKt.coerceAtLeast(r3.getEntries().size() - 1, 0)));
    }

    @Override // com.obric.oui.picker.reels.OReelPicker
    public View asView() {
        return this;
    }

    @Override // com.obric.oui.picker.reels.OReelPicker
    public WheelView getReelView(int r2) {
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L13;
        return null;
    L13:
        return getWv3();
    L14:
        return getWv2();
    L11:
        return getWv1();
    }

    @Override // com.obric.oui.picker.reels.OReelPicker
    public void configure(int r3, OReelPicker.Reel r4) {
        Intrinsics.checkNotNullParameter(r4, "reel");
        WheelView r0 = getReelView(r3);
        if (r0 == null) goto L7;
        configure(r0, r4, r3, this.reelsCount - 1);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
