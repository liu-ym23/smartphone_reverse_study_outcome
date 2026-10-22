package com.obric.oui.picker.reels.pickers;

import android.content.Context;
import android.icu.text.PluralRules;
import android.util.AttributeSet;
import android.view.View;
import androidx.slice.core.SliceHints;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oui.R;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import com.obric.oui.picker.reels.views.OReelPickerThreeReels;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OReelPickerTimeLength.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength;", "Lcom/obric/oui/picker/OPicker;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$TimeLength;", "()V", "mBuilder", "Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$Builder;", "asView", "Landroid/view/View;", "getPicked", "Builder", "Reels", "TimeLength", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OReelPickerTimeLength implements OPicker<TimeLength> {
    private Builder mBuilder;

    /* JADX INFO: compiled from: OReelPickerTimeLength.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010&2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016J,\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020$2\b\b\u0002\u0010/\u001a\u00020$2\b\b\u0002\u00100\u001a\u00020$J,\u00101\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020$2\b\b\u0002\u0010/\u001a\u00020$2\b\b\u0002\u00100\u001a\u00020$J,\u00102\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020$2\b\b\u0002\u0010/\u001a\u00020$2\b\b\u0002\u00100\u001a\u00020$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00060\u001dR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$Builder;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerBuilder;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$TimeLength;", "()V", "mBuilt", "Lcom/obric/oui/picker/reels/OReelPicker;", "getMBuilt$OUI_standardRelease", "()Lcom/obric/oui/picker/reels/OReelPicker;", "setMBuilt$OUI_standardRelease", "(Lcom/obric/oui/picker/reels/OReelPicker;)V", "mChangedListener", "Ljava/util/function/Consumer;", "mMax", "getMMax$OUI_standardRelease", "()Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$TimeLength;", "setMMax$OUI_standardRelease", "(Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$TimeLength;)V", "mMin", "getMMin$OUI_standardRelease", "setMMin$OUI_standardRelease", "mSelected", "getMSelected$OUI_standardRelease", "setMSelected$OUI_standardRelease", "mShowHour", "", "mShowMinute", "mShowSecond", "rcListener", "Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$Builder$ReelChangedListener;", IndexDatabaseHelper.MetaColumns.BUILD, "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "buildHourReel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "buildMinuteReel", "buildSecondReel", "setOnChangedListener", "", "listener", "setShowHour", "show", MaterialConfigFormatNames.SELECTED, "max", SliceHints.SUBTYPE_MIN, "setShowMinute", "setShowSecond", "ReelChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder implements OReelPickerBuilder<OReelPickerTimeLength, TimeLength> {
        private OReelPicker mBuilt;
        private Consumer<TimeLength> mChangedListener;
        private TimeLength mMax;
        private TimeLength mMin;
        private TimeLength mSelected;
        private boolean mShowHour;
        private boolean mShowMinute;
        private boolean mShowSecond;
        private final ReelChangedListener rcListener;

        /* JADX INFO: compiled from: OReelPickerTimeLength.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J&\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0002¨\u0006\r"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$Builder$ReelChangedListener;", "Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "(Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$Builder;)V", "notifyChange", "", "onReelChanged", "reelId", "", "selectedIndex", "onTimeChanged", "hour", "minute", "second", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public final class ReelChangedListener implements OReelPicker.ReelChangedListener {
            final /* synthetic */ Builder this$0;

            public ReelChangedListener(Builder r2) {
                Intrinsics.checkNotNullParameter(r2, "this$0");
                this.this$0 = r2;
            }

            static /* synthetic */ void onTimeChanged$default(ReelChangedListener r1, int r2, int r3, int r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r2 = -1;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r3 = -1;
            L9:
                if ((r5 & 4) == 0) goto L11;
                r4 = -1;
            L11:
                r1.onTimeChanged(r2, r3, r4);
            }

            private final void onTimeChanged(int r2, int r3, int r4) {
                if (r2 < 0) goto L4;
                this.this$0.getMSelected$OUI_standardRelease().setHour(r2);
            L4:
                if (r3 < 0) goto L6;
                this.this$0.getMSelected$OUI_standardRelease().setMinute(r3);
            L6:
                if (r4 < 0) goto L8;
                this.this$0.getMSelected$OUI_standardRelease().setSecond(r4);
            L8:
                notifyChange();
            }

            private final void notifyChange() {
                Consumer r0 = Builder.access$getMChangedListener$p(this.this$0);
                if (r0 == null) goto L7;
                r0.accept(this.this$0.getMSelected$OUI_standardRelease());
                return;
            }

            @Override // com.obric.oui.picker.reels.OReelPicker.ReelChangedListener
            public void onReelChanged(int r14, int r15) {
                if (r14 != 0) goto L4;
                onTimeChanged$default(this, this.this$0.getMMin$OUI_standardRelease().getHour() + r15, 0, 0, 6, null);
            L11:
                notifyChange();
                return;
            L4:
                if (r14 != 1) goto L6;
                onTimeChanged$default(this, 0, this.this$0.getMMin$OUI_standardRelease().getMinute() + r15, 0, 5, null);
                goto L11
            L6:
                if (r14 != 2) goto L11;
                onTimeChanged$default(this, 0, 0, this.this$0.getMMin$OUI_standardRelease().getSecond() + r15, 3, null);
                goto L11
            }
        }

        public Builder() {
            this.mShowMinute = true;
            this.mShowSecond = true;
            int r2 = 0;
            int r3 = 0;
            int r4 = 0;
            int r5 = 7;
            DefaultConstructorMarker r6 = null;
            this.mSelected = new TimeLength(r2, r3, r4, r5, r6);
            this.mMin = new TimeLength(0, 0, 0, 7, null);
            this.mMax = new TimeLength(r2, r3, r4, r5, r6);
            this.rcListener = new ReelChangedListener(this);
        }

        public static final /* synthetic */ Consumer access$getMChangedListener$p(Builder r0) {
            return r0.mChangedListener;
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public /* bridge */ /* synthetic */ OReelPickerTimeLength build(Context r1, AttributeSet r2, int r3) {
            return build(r1, r2, r3);
        }

        public final TimeLength getMSelected$OUI_standardRelease() {
            return this.mSelected;
        }

        public final void setMSelected$OUI_standardRelease(TimeLength r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mSelected = r2;
        }

        public final TimeLength getMMin$OUI_standardRelease() {
            return this.mMin;
        }

        public final void setMMin$OUI_standardRelease(TimeLength r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mMin = r2;
        }

        public final TimeLength getMMax$OUI_standardRelease() {
            return this.mMax;
        }

        public final void setMMax$OUI_standardRelease(TimeLength r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mMax = r2;
        }

        public final OReelPicker getMBuilt$OUI_standardRelease() {
            return this.mBuilt;
        }

        public final void setMBuilt$OUI_standardRelease(OReelPicker r1) {
            this.mBuilt = r1;
        }

        public static /* synthetic */ Builder setShowHour$default(Builder r1, boolean r2, int r3, int r4, int r5, int r6, Object r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = 23;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = 0;
        L12:
            return r1.setShowHour(r2, r3, r4, r5);
        }

        public final Builder setShowHour(boolean r1, int r2, int r3, int r4) {
            this.mShowHour = r1;
            this.mSelected.setHour(r2);
            this.mMax.setHour(r3);
            this.mMin.setHour(r4);
            return this;
        }

        public static /* synthetic */ Builder setShowMinute$default(Builder r1, boolean r2, int r3, int r4, int r5, int r6, Object r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = 59;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = 0;
        L12:
            return r1.setShowMinute(r2, r3, r4, r5);
        }

        public final Builder setShowMinute(boolean r1, int r2, int r3, int r4) {
            this.mShowMinute = r1;
            this.mSelected.setMinute(r2);
            this.mMax.setMinute(r3);
            this.mMin.setMinute(r4);
            return this;
        }

        public static /* synthetic */ Builder setShowSecond$default(Builder r1, boolean r2, int r3, int r4, int r5, int r6, Object r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = 59;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = 0;
        L12:
            return r1.setShowSecond(r2, r3, r4, r5);
        }

        public final Builder setShowSecond(boolean r1, int r2, int r3, int r4) {
            this.mShowSecond = r1;
            this.mSelected.setSecond(r2);
            this.mMax.setSecond(r3);
            this.mMin.setSecond(r4);
            return this;
        }

        private final OReelPicker.Reel buildHourReel(Context r21) {
            if (this.mShowHour == true) goto L7;
            return null;
        L7:
            return new OReelPicker.Reel(0, Utils.generateRange$default(Utils.INSTANCE, this.mMin.getHour(), this.mMax.getHour(), null, 0, 12, null), r21.getString(R.string.oui_reel_tag_hour), 0.0f, null, null, null, this.mSelected.getHour() - this.mMin.getHour(), this.rcListener, 120, null);
        }

        private final OReelPicker.Reel buildMinuteReel(Context r21) {
            if (this.mShowMinute == true) goto L7;
            return null;
        L7:
            return new OReelPicker.Reel(1, Utils.generateRange$default(Utils.INSTANCE, this.mMin.getMinute(), this.mMax.getMinute(), null, 0, 12, null), r21.getString(R.string.oui_reel_tag_minute), 0.0f, null, null, null, this.mSelected.getMinute() - this.mMin.getMinute(), this.rcListener, 120, null);
        }

        private final OReelPicker.Reel buildSecondReel(Context r21) {
            if (this.mShowSecond == true) goto L7;
            return null;
        L7:
            return new OReelPicker.Reel(2, Utils.generateRange$default(Utils.INSTANCE, this.mMin.getSecond(), this.mMax.getSecond(), null, 0, 12, null), r21.getString(R.string.oui_reel_tag_second), 0.0f, null, null, null, this.mSelected.getSecond() - this.mMin.getSecond(), this.rcListener, 120, null);
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public void setOnChangedListener(Consumer<TimeLength> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mChangedListener = r2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public OReelPickerTimeLength build(Context r3, AttributeSet r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "context");
            OReelPickerThreeReels.Builder r0 = new OReelPickerThreeReels.Builder();
            OReelPicker.Reel r1 = buildHourReel(r3);
            if (r1 == null) goto L6;
            r0.addReel(r1);
        L6:
            OReelPicker.Reel r2 = buildMinuteReel(r3);
            if (r2 == null) goto L10;
            r0.addReel(r2);
        L10:
            OReelPicker.Reel r6 = buildSecondReel(r3);
            if (r6 == null) goto L14;
            r0.addReel(r6);
        L14:
            OReelPicker r7 = r0.build(r3, r4, r5);
            OReelPickerTimeLength r8 = new OReelPickerTimeLength();
            setMBuilt$OUI_standardRelease(r7);
            OReelPickerTimeLength.access$setMBuilder$p(r8, this);
            return r8;
        }
    }

    /* JADX INFO: compiled from: OReelPickerTimeLength.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$Reels;", "", "()V", "REEL_HOUR", "", "REEL_MINUTE", "REEL_SECOND", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Reels {
        public static final Reels INSTANCE = null;
        public static final int REEL_HOUR = 0;
        public static final int REEL_MINUTE = 1;
        public static final int REEL_SECOND = 2;

        static {
            INSTANCE = new Reels();
        }

        private Reels() {
        }
    }

    /* JADX INFO: compiled from: OReelPickerTimeLength.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerTimeLength$TimeLength;", "", "hour", "", "minute", "second", "(III)V", "getHour", "()I", "setHour", "(I)V", "getMinute", "setMinute", "getSecond", "setSecond", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TimeLength {
        private int hour;
        private int minute;
        private int second;

        public TimeLength() {
            this(0, 0, 0, 7, null);
        }

        public static /* synthetic */ TimeLength copy$default(TimeLength r0, int r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.hour;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.minute;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.second;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.hour;
        }

        public final int component2() {
            return this.minute;
        }

        public final int component3() {
            return this.second;
        }

        public final TimeLength copy(int r1, int r2, int r3) {
            return new TimeLength(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TimeLength) == true) goto L8;
            return false;
        L8:
            TimeLength r6 = (TimeLength) r5;
            if (this.hour == r6.hour) goto L12;
            return false;
        L12:
            if (this.minute == r6.minute) goto L15;
            return false;
        L15:
            if (this.second == r6.second) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.hour) * 31) + Integer.hashCode(this.minute)) * 31) + Integer.hashCode(this.second);
        }

        public String toString() {
            return "TimeLength(hour=" + this.hour + ", minute=" + this.minute + ", second=" + this.second + ')';
        }

        public TimeLength(int r1, int r2, int r3) {
            this.hour = r1;
            this.minute = r2;
            this.second = r3;
        }

        public /* synthetic */ TimeLength(int r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 0;
        L11:
            this(r2, r3, r4);
        }

        public final int getHour() {
            return this.hour;
        }

        public final void setHour(int r1) {
            this.hour = r1;
        }

        public final int getMinute() {
            return this.minute;
        }

        public final void setMinute(int r1) {
            this.minute = r1;
        }

        public final int getSecond() {
            return this.second;
        }

        public final void setSecond(int r1) {
            this.second = r1;
        }
    }

    public OReelPickerTimeLength() {
    }

    public static final /* synthetic */ void access$setMBuilder$p(OReelPickerTimeLength r0, Builder r1) {
        r0.mBuilder = r1;
    }

    @Override // com.obric.oui.picker.OPicker
    public /* bridge */ /* synthetic */ TimeLength getPicked() {
        return getPicked();
    }

    @Override // com.obric.oui.picker.OPicker
    public View asView() {
        Builder r1 = this.mBuilder;
        if (r1 == null) goto L10;
        OReelPicker r2 = r1.getMBuilt$OUI_standardRelease();
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.asView();
    L10:
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.oui.picker.OPicker
    public TimeLength getPicked() {
        Builder r0 = this.mBuilder;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getMSelected$OUI_standardRelease();
    }
}
