package com.obric.oui.picker.reels.pickers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.common.oui.R;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import com.obric.oui.picker.reels.views.OReelPickerThreeReels;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OReelPickerDateTime.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerDateTime;", "Lcom/obric/oui/picker/OPicker;", "Ljava/time/LocalDateTime;", "()V", "mBuilder", "Lcom/obric/oui/picker/reels/pickers/OReelPickerDateTime$Builder;", "asView", "Landroid/view/View;", "getPicked", "Builder", "Reels", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OReelPickerDateTime implements OPicker<LocalDateTime> {
    private Builder mBuilder;

    /* JADX INFO: compiled from: OReelPickerDateTime.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J \u0010#\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0002J\u0016\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000eJ\u0016\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0003J\f\u00100\u001a\u00020\u0003*\u00020\u0003H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u00030\u00038@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerDateTime$Builder;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerBuilder;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerDateTime;", "Ljava/time/LocalDateTime;", "()V", "mBuilt", "Lcom/obric/oui/picker/reels/OReelPicker;", "getMBuilt$OUI_standardRelease", "()Lcom/obric/oui/picker/reels/OReelPicker;", "setMBuilt$OUI_standardRelease", "(Lcom/obric/oui/picker/reels/OReelPicker;)V", "mChangedListener", "Ljava/util/function/Consumer;", "mFromDate", "Ljava/time/LocalDate;", "kotlin.jvm.PlatformType", "mSelectedTime", "getMSelectedTime$OUI_standardRelease", "()Ljava/time/LocalDateTime;", "setMSelectedTime$OUI_standardRelease", "(Ljava/time/LocalDateTime;)V", "mToDate", "rcListener", "Lcom/obric/oui/picker/reels/pickers/OReelPickerDateTime$Builder$ReelChangedListener;", "build", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "buildDateReel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "buildHourReel", "buildMinuteReel", "formatDate", "", ProviderConstants.Sms.DATE, "fmt", "Ljava/time/format/DateTimeFormatter;", "setDateRange", "from", "to", "setOnChangedListener", "", "listener", "setSelected", MaterialConfigFormatNames.SELECTED, "toCoarse", "ReelChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder implements OReelPickerBuilder<OReelPickerDateTime, LocalDateTime> {
        private OReelPicker mBuilt;
        private Consumer<LocalDateTime> mChangedListener;
        private LocalDate mFromDate;
        private LocalDateTime mSelectedTime;
        private LocalDate mToDate;
        private final ReelChangedListener rcListener;

        /* JADX INFO: compiled from: OReelPickerDateTime.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerDateTime$Builder$ReelChangedListener;", "Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "(Lcom/obric/oui/picker/reels/pickers/OReelPickerDateTime$Builder;)V", "notifyChange", "", "onDateChanged", "dayOffset", "", "onReelChanged", "reelId", "selectedIndex", "onTimeChanged", "hour", "minute", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public final class ReelChangedListener implements OReelPicker.ReelChangedListener {
            final /* synthetic */ Builder this$0;

            public ReelChangedListener(Builder r2) {
                Intrinsics.checkNotNullParameter(r2, "this$0");
                this.this$0 = r2;
            }

            private final void onDateChanged(int r4) {
                LocalDate r5 = Builder.access$getMFromDate$p(this.this$0).plusDays(r4);
                Builder r0 = this.this$0;
                r0.setMSelectedTime$OUI_standardRelease(r0.getMSelectedTime$OUI_standardRelease().withYear(r5.getYear()).withDayOfYear(r5.getDayOfYear()));
                notifyChange();
            }

            static /* synthetic */ void onTimeChanged$default(ReelChangedListener r1, int r2, int r3, int r4, Object r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = -1;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = -1;
            L8:
                r1.onTimeChanged(r2, r3);
            }

            private final void onTimeChanged(int r3, int r4) {
                if (r3 < 0) goto L4;
                Builder r0 = this.this$0;
                r0.setMSelectedTime$OUI_standardRelease(r0.getMSelectedTime$OUI_standardRelease().withHour(r3));
            L4:
                if (r4 < 0) goto L6;
                Builder r5 = this.this$0;
                r5.setMSelectedTime$OUI_standardRelease(r5.getMSelectedTime$OUI_standardRelease().withMinute(r4));
            L6:
                notifyChange();
            }

            private final void notifyChange() {
                Consumer r0 = Builder.access$getMChangedListener$p(this.this$0);
                if (r0 == null) goto L7;
                r0.accept(this.this$0.getMSelectedTime$OUI_standardRelease().withSecond(0));
                return;
            }

            @Override // com.obric.oui.picker.reels.OReelPicker.ReelChangedListener
            public void onReelChanged(int r5, int r6) {
                if (r5 != 0) goto L4;
                onDateChanged(r6);
            L10:
                notifyChange();
                return;
            L4:
                if (r5 == 1) goto L8;
                if (r5 != 2) goto L10;
                onTimeChanged$default(this, 0, r6, 1, null);
                goto L10
            L8:
                onTimeChanged$default(this, r6, 0, 2, null);
                goto L10
            }
        }

        public static /* synthetic */ String $r8$lambda$R5xt4tWr5vDnT6P1KYT0l3BHhPk(Builder r0, Context r1, DateTimeFormatter r2, LocalDate r3) {
            return m411buildDateReel$lambda0(r0, r1, r2, r3);
        }

        public Builder() {
            this.mFromDate = LocalDate.now();
            this.mToDate = LocalDate.now().plusYears(1);
            this.mSelectedTime = LocalDateTime.now();
            this.rcListener = new ReelChangedListener(this);
        }

        public static final /* synthetic */ Consumer access$getMChangedListener$p(Builder r0) {
            return r0.mChangedListener;
        }

        public static final /* synthetic */ LocalDate access$getMFromDate$p(Builder r0) {
            return r0.mFromDate;
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public /* bridge */ /* synthetic */ OReelPickerDateTime build(Context r1, AttributeSet r2, int r3) {
            return build(r1, r2, r3);
        }

        public final void setMSelectedTime$OUI_standardRelease(LocalDateTime r1) {
            this.mSelectedTime = r1;
        }

        public final LocalDateTime getMSelectedTime$OUI_standardRelease() {
            LocalDateTime r0 = this.mSelectedTime;
            Intrinsics.checkNotNullExpressionValue(r0, "field");
            return toCoarse(r0);
        }

        public final OReelPicker getMBuilt$OUI_standardRelease() {
            return this.mBuilt;
        }

        public final void setMBuilt$OUI_standardRelease(OReelPicker r1) {
            this.mBuilt = r1;
        }

        private final LocalDateTime toCoarse(LocalDateTime r1) {
            LocalDateTime r0 = r1.withSecond(0).withNano(0);
            Intrinsics.checkNotNullExpressionValue(r0, "withSecond(0).withNano(0)");
            return r0;
        }

        public final Builder setDateRange(LocalDate r2, LocalDate r3) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "to");
            if (r2.compareTo(r3) > 0) goto L5;
            this.mFromDate = r2;
            this.mToDate = r3;
        L5:
            return this;
        }

        public final Builder setSelected(LocalDateTime r2) {
            Intrinsics.checkNotNullParameter(r2, MaterialConfigFormatNames.SELECTED);
            this.mSelectedTime = r2;
            return this;
        }

        private final String formatDate(Context r3, LocalDate r4, DateTimeFormatter r5) {
            Utils r2 = Utils.INSTANCE;
            DayOfWeek r0 = r4.getDayOfWeek();
            Intrinsics.checkNotNullExpressionValue(r0, "date.dayOfWeek");
            String r6 = r3.getString(r2.toShortRepr(r0));
            Intrinsics.checkNotNullExpressionValue(r6, "context.getString(date.dayOfWeek.toShortRepr())");
            return r5.format(r4) + ' ' + r6;
        }

        private final OReelPicker.Reel buildDateReel(final Context r20) {
            final DateTimeFormatter r2 = DateTimeFormatter.ofPattern(r20.getString(R.string.oui_reel_picker_month_day_pattern));
            Utils r3 = Utils.INSTANCE;
            LocalDate r4 = this.mFromDate;
            Intrinsics.checkNotNullExpressionValue(r4, "mFromDate");
            LocalDate r5 = this.mToDate;
            Intrinsics.checkNotNullExpressionValue(r5, "mToDate");
            List<String> r9 = r3.generateDateRange(r4, r5, new OReelPickerDateTime$Builder$$ExternalSyntheticLambda0(this, r20, r2));
            LocalDate r1 = getMSelectedTime$OUI_standardRelease().toLocalDate();
            if (r1.isBefore(this.mFromDate) == false) goto L7;
            int r6 = 0;
        L11:
            return new OReelPicker.Reel(0, r9, null, 148.0f, null, null, null, r6, this.rcListener, 116, null);
        L7:
            if (r1.isBefore(this.mToDate) == false) goto L9;
            r6 = (int) ChronoUnit.DAYS.between(this.mFromDate, r1);
            goto L11
        L9:
            r6 = r9.size() - 1;
            goto L11
        }

        /* JADX INFO: renamed from: buildDateReel$lambda-0, reason: not valid java name */
        private static final String m411buildDateReel$lambda0(Builder r1, Context r2, DateTimeFormatter r3, LocalDate r4) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "$context");
            Intrinsics.checkNotNullParameter(r4, "it");
            Intrinsics.checkNotNullExpressionValue(r3, "fmt");
            return r1.formatDate(r2, r4, r3);
        }

        private final OReelPicker.Reel buildHourReel() {
            return new OReelPicker.Reel(1, Utils.generateRange$default(Utils.INSTANCE, 0, 23, null, 2, 4, null), null, 74.0f, null, null, null, getMSelectedTime$OUI_standardRelease().getHour(), this.rcListener, 116, null);
        }

        private final OReelPicker.Reel buildMinuteReel() {
            return new OReelPicker.Reel(2, Utils.generateRange$default(Utils.INSTANCE, 0, 59, null, 2, 4, null), null, 74.0f, null, null, null, getMSelectedTime$OUI_standardRelease().getMinute(), this.rcListener, 116, null);
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public void setOnChangedListener(Consumer<LocalDateTime> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mChangedListener = r2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public OReelPickerDateTime build(Context r3, AttributeSet r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "context");
            OReelPickerThreeReels.Builder r0 = new OReelPickerThreeReels.Builder();
            r0.addReel(buildDateReel(r3));
            r0.addReel(buildHourReel());
            r0.addReel(buildMinuteReel());
            this.mBuilt = r0.build(r3, r4, r5);
            OReelPickerDateTime r6 = new OReelPickerDateTime();
            OReelPickerDateTime.access$setMBuilder$p(r6, this);
            return r6;
        }
    }

    /* JADX INFO: compiled from: OReelPickerDateTime.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerDateTime$Reels;", "", "()V", "REEL_DATE", "", "REEL_HOUR", "REEL_MINUTE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Reels {
        public static final Reels INSTANCE = null;
        public static final int REEL_DATE = 0;
        public static final int REEL_HOUR = 1;
        public static final int REEL_MINUTE = 2;

        static {
            INSTANCE = new Reels();
        }

        private Reels() {
        }
    }

    public OReelPickerDateTime() {
    }

    public static final /* synthetic */ void access$setMBuilder$p(OReelPickerDateTime r0, Builder r1) {
        r0.mBuilder = r1;
    }

    @Override // com.obric.oui.picker.OPicker
    public /* bridge */ /* synthetic */ LocalDateTime getPicked() {
        return getPicked2();
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

    @Override // com.obric.oui.picker.OPicker
    /* JADX INFO: renamed from: getPicked, reason: avoid collision after fix types in other method */
    public LocalDateTime getPicked2() {
        Builder r0 = this.mBuilder;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getMSelectedTime$OUI_standardRelease();
    }
}
