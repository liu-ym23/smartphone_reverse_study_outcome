package com.obric.oui.picker.reels.pickers;

import android.content.Context;
import android.icu.text.PluralRules;
import android.util.AttributeSet;
import android.view.View;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oui.R;
import com.obric.oui.calendar.ODatePickerView;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import com.obric.oui.picker.reels.views.OReelPickerThreeReels;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OReelPickerDate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerDate;", "Lcom/obric/oui/picker/OPicker;", "Ljava/time/LocalDate;", "()V", "mBuilder", "Lcom/obric/oui/picker/reels/pickers/OReelPickerDate$Builder;", "asView", "Landroid/view/View;", "getPicked", "Builder", "Reels", "SelectionDate", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OReelPickerDate implements OPicker<LocalDate> {
    private Builder mBuilder;

    /* JADX INFO: compiled from: OReelPickerDate.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0006H\u0016J \u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0003J\u0010\u0010)\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0014H\u0003J\u0010\u0010*\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0014H\u0003J\u0016\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\u000e\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u0003J\u0016\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006J\f\u00103\u001a\u00020\u0017*\u00020\u0003H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00060\u001eR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerDate$Builder;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerBuilder;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerDate;", "Ljava/time/LocalDate;", "()V", "dayCol", "", "getDayCol", "()I", "setDayCol", "(I)V", "mBuilt", "Lcom/obric/oui/picker/reels/OReelPicker;", "getMBuilt$OUI_standardRelease", "()Lcom/obric/oui/picker/reels/OReelPicker;", "setMBuilt$OUI_standardRelease", "(Lcom/obric/oui/picker/reels/OReelPicker;)V", "mChangedListener", "Ljava/util/function/Consumer;", "mContext", "Landroid/content/Context;", "mFromYear", "mSelected", "Lcom/obric/oui/picker/reels/pickers/OReelPickerDate$SelectionDate;", "getMSelected$OUI_standardRelease", "()Lcom/obric/oui/picker/reels/pickers/OReelPickerDate$SelectionDate;", "setMSelected$OUI_standardRelease", "(Lcom/obric/oui/picker/reels/pickers/OReelPickerDate$SelectionDate;)V", "mToYear", "rcListener", "Lcom/obric/oui/picker/reels/pickers/OReelPickerDate$Builder$ReelChangedListener;", IndexDatabaseHelper.MetaColumns.BUILD, "context", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "buildDayReel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "month", "leapYear", "", "buildMonthReel", "buildYearReel", "setOnChangedListener", "", "listener", "setSelected", MaterialConfigFormatNames.SELECTED, "setYearRange", "from", "to", "toSelection", "ReelChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder implements OReelPickerBuilder<OReelPickerDate, LocalDate> {
        private int dayCol;
        private OReelPicker mBuilt;
        private Consumer<LocalDate> mChangedListener;
        private Context mContext;
        private int mFromYear;
        private SelectionDate mSelected;
        private int mToYear;
        private final ReelChangedListener rcListener;

        /* JADX INFO: compiled from: OReelPickerDate.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerDate$Builder$ReelChangedListener;", "Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "(Lcom/obric/oui/picker/reels/pickers/OReelPickerDate$Builder;)V", "notifyChange", "", "onDayChanged", "changedToDay", "", "onMonthChanged", "changedToMonth", "onReelChanged", "reelId", "selectedIndex", "onYearChanged", "changedToYear", "rebuildDaysReel", "month", "leapYear", "", "updateSelection", "year", "day", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public final class ReelChangedListener implements OReelPicker.ReelChangedListener {
            final /* synthetic */ Builder this$0;

            public ReelChangedListener(Builder r2) {
                Intrinsics.checkNotNullParameter(r2, "this$0");
                this.this$0 = r2;
            }

            private final void onYearChanged(int r4) {
                SelectionDate r0 = this.this$0.getMSelected$OUI_standardRelease().clone();
                updateSelection(r4, r0.getMonth(), r0.getDay());
                if (r0.getMonth() == 2) goto L5;
                return;
            L5:
                if (Utils.INSTANCE.isLeapYear(r0.getYear()) == Utils.INSTANCE.isLeapYear(r4)) goto L9;
                rebuildDaysReel(r0.getMonth(), Utils.INSTANCE.isLeapYear(r4));
                return;
            }

            private final void onMonthChanged(int r5) {
                SelectionDate r0 = this.this$0.getMSelected$OUI_standardRelease().clone();
                updateSelection(r0.getYear(), r5, r0.getDay());
                boolean r1 = Utils.INSTANCE.isLeapYear(r0.getYear());
                if (Utils.INSTANCE.dayCount(r5, r1) == Utils.INSTANCE.dayCount(r0.getMonth(), r1)) goto L6;
                rebuildDaysReel(r5, r1);
                return;
            }

            private final void onDayChanged(int r3) {
                updateSelection(this.this$0.getMSelected$OUI_standardRelease().getYear(), this.this$0.getMSelected$OUI_standardRelease().getMonth(), r3);
            }

            private final void rebuildDaysReel(int r4, boolean r5) {
                Context r0 = Builder.access$getMContext$p(this.this$0);
                if (r0 != null) goto L5;
                return;
            L5:
                OReelPicker r1 = this.this$0.getMBuilt$OUI_standardRelease();
                if (r1 == null) goto L10;
                r1.configure(this.this$0.getDayCol(), Builder.access$buildDayReel(this.this$0, r0, r4, r5));
                return;
            }

            private final void updateSelection(int r2, int r3, int r4) {
                SelectionDate r1 = this.this$0.getMSelected$OUI_standardRelease();
                r1.setYear(r2);
                r1.setMonth(r3);
                r1.setDay(Math.min(r4, Utils.INSTANCE.dayCount(r3, r1.isLeapYear())));
            }

            private final void notifyChange() {
                Consumer r0 = Builder.access$getMChangedListener$p(this.this$0);
                if (r0 == null) goto L7;
                r0.accept(this.this$0.getMSelected$OUI_standardRelease().toLocalDate());
                return;
            }

            @Override // com.obric.oui.picker.reels.OReelPicker.ReelChangedListener
            public void onReelChanged(int r3, int r4) {
                if (r3 != 0) goto L4;
                onYearChanged(Builder.access$getMFromYear$p(this.this$0) + r4);
            L11:
                notifyChange();
                return;
            L4:
                if (r3 != 1) goto L6;
                onMonthChanged(r4 + 1);
                goto L11
            L6:
                if (r3 != 2) goto L11;
                onDayChanged(r4 + 1);
                goto L11
            }
        }

        public Builder() {
            this.mFromYear = ODatePickerView.YEAR_FROM;
            this.mToYear = ODatePickerView.YEAR_TO;
            LocalDate r0 = LocalDate.now();
            Intrinsics.checkNotNullExpressionValue(r0, "now()");
            this.mSelected = toSelection(r0);
            this.dayCol = 2;
            this.rcListener = new ReelChangedListener(this);
        }

        public static final /* synthetic */ OReelPicker.Reel access$buildDayReel(Builder r0, Context r1, int r2, boolean r3) {
            return r0.buildDayReel(r1, r2, r3);
        }

        public static final /* synthetic */ Consumer access$getMChangedListener$p(Builder r0) {
            return r0.mChangedListener;
        }

        public static final /* synthetic */ Context access$getMContext$p(Builder r0) {
            return r0.mContext;
        }

        public static final /* synthetic */ int access$getMFromYear$p(Builder r0) {
            return r0.mFromYear;
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public /* bridge */ /* synthetic */ OReelPickerDate build(Context r1, AttributeSet r2, int r3) {
            return build(r1, r2, r3);
        }

        public final SelectionDate getMSelected$OUI_standardRelease() {
            return this.mSelected;
        }

        public final void setMSelected$OUI_standardRelease(SelectionDate r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mSelected = r2;
        }

        public final OReelPicker getMBuilt$OUI_standardRelease() {
            return this.mBuilt;
        }

        public final void setMBuilt$OUI_standardRelease(OReelPicker r1) {
            this.mBuilt = r1;
        }

        public final int getDayCol() {
            return this.dayCol;
        }

        public final void setDayCol(int r1) {
            this.dayCol = r1;
        }

        private final SelectionDate toSelection(LocalDate r3) {
            return new SelectionDate(r3.getYear(), r3.getMonthValue(), r3.getDayOfMonth());
        }

        public final Builder setYearRange(int r1, int r2) {
            if (r1 > r2) goto L4;
            this.mFromYear = r1;
            this.mToYear = r2;
        L4:
            return this;
        }

        public final void setSelected(LocalDate r2) {
            Intrinsics.checkNotNullParameter(r2, MaterialConfigFormatNames.SELECTED);
            this.mSelected = toSelection(r2);
        }

        private final OReelPicker.Reel buildYearReel(Context r21) {
            Utils r1 = Utils.INSTANCE;
            int r2 = this.mFromYear;
            int r3 = this.mToYear;
            String r4 = r21.getString(R.string.oui_reel_picker_year_tag);
            Intrinsics.checkNotNullExpressionValue(r4, "context.getString(R.stri…oui_reel_picker_year_tag)");
            List r10 = Utils.generateRange$default(r1, r2, r3, r4, 0, 8, null);
            int r16 = Math.min(Math.max(this.mSelected.getYear() - this.mFromYear, 0), this.mToYear - this.mFromYear);
            this.mSelected.setYear(this.mFromYear + r16);
            return new OReelPicker.Reel(0, r10, null, 0.0f, null, null, null, r16, this.rcListener, 124, null);
        }

        private final OReelPicker.Reel buildMonthReel(Context r17) {
            return new OReelPicker.Reel(1, Utils.INSTANCE.generateMonthRange(r17, 1, 12), null, 0.0f, null, null, null, this.mSelected.getMonth() - 1, this.rcListener, 124, null);
        }

        private final OReelPicker.Reel buildDayReel(Context r18, int r19, boolean r20) {
            int r1 = Utils.INSTANCE.dayCount(r19, r20);
            Utils r2 = Utils.INSTANCE;
            String r3 = r18.getString(R.string.oui_reel_picker_day_tag);
            Intrinsics.checkNotNullExpressionValue(r3, "context.getString(R.stri….oui_reel_picker_day_tag)");
            return new OReelPicker.Reel(2, r2.generateRange(1, r1, r3, 1), null, 0.0f, null, null, null, this.mSelected.getDay() - 1, this.rcListener, 124, null);
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public void setOnChangedListener(Consumer<LocalDate> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mChangedListener = r2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public OReelPickerDate build(Context r4, AttributeSet r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "context");
            OReelPickerThreeReels.Builder r0 = new OReelPickerThreeReels.Builder();
            if (Locale.US.equals(Locale.getDefault()) == false) goto L5;
            r0.addReel(buildMonthReel(r4));
            r0.addReel(buildDayReel(r4, this.mSelected.getMonth(), this.mSelected.isLeapYear()));
            r0.addReel(buildYearReel(r4));
            this.dayCol = 1;
        L6:
            OReelPicker r7 = r0.build(r4, r5, r6);
            this.mContext = r4;
            this.mBuilt = r7;
            OReelPickerDate r8 = new OReelPickerDate();
            OReelPickerDate.access$setMBuilder$p(r8, this);
            return r8;
        L5:
            r0.addReel(buildYearReel(r4));
            r0.addReel(buildMonthReel(r4));
            r0.addReel(buildDayReel(r4, this.mSelected.getMonth(), this.mSelected.isLeapYear()));
            this.dayCol = 2;
            goto L6
        }
    }

    /* JADX INFO: compiled from: OReelPickerDate.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerDate$Reels;", "", "()V", "REEL_DAY", "", "REEL_MONTH", "REEL_YEAR", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Reels {
        public static final Reels INSTANCE = null;
        public static final int REEL_DAY = 2;
        public static final int REEL_MONTH = 1;
        public static final int REEL_YEAR = 0;

        static {
            INSTANCE = new Reels();
        }

        private Reels() {
        }
    }

    /* JADX INFO: compiled from: OReelPickerDate.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0000H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerDate$SelectionDate;", "", "year", "", "month", "day", "(III)V", "getDay", "()I", "setDay", "(I)V", "isLeapYear", "", "()Z", "getMonth", "setMonth", "getYear", "setYear", "clone", "component1", "component2", "component3", "copy", "equals", PluralRules.KEYWORD_OTHER, "", "hashCode", "toLocalDate", "Ljava/time/LocalDate;", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SelectionDate implements Cloneable {
        private int day;
        private int month;
        private int year;

        public static /* synthetic */ SelectionDate copy$default(SelectionDate r0, int r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.year;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.month;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.day;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.year;
        }

        public final int component2() {
            return this.month;
        }

        public final int component3() {
            return this.day;
        }

        public final SelectionDate copy(int r1, int r2, int r3) {
            return new SelectionDate(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SelectionDate) == true) goto L8;
            return false;
        L8:
            SelectionDate r6 = (SelectionDate) r5;
            if (this.year == r6.year) goto L12;
            return false;
        L12:
            if (this.month == r6.month) goto L15;
            return false;
        L15:
            if (this.day == r6.day) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.year) * 31) + Integer.hashCode(this.month)) * 31) + Integer.hashCode(this.day);
        }

        public String toString() {
            return "SelectionDate(year=" + this.year + ", month=" + this.month + ", day=" + this.day + ')';
        }

        public SelectionDate(int r1, int r2, int r3) {
            this.year = r1;
            this.month = r2;
            this.day = r3;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1270clone() {
            return clone();
        }

        public final int getYear() {
            return this.year;
        }

        public final void setYear(int r1) {
            this.year = r1;
        }

        public final int getMonth() {
            return this.month;
        }

        public final void setMonth(int r1) {
            this.month = r1;
        }

        public final int getDay() {
            return this.day;
        }

        public final void setDay(int r1) {
            this.day = r1;
        }

        public final boolean isLeapYear() {
            return Utils.INSTANCE.isLeapYear(this.year);
        }

        public SelectionDate clone() {
            return (SelectionDate) super.clone();
        }

        public final LocalDate toLocalDate() {
            LocalDate r2 = LocalDate.of(this.year, this.month, this.day);
            Intrinsics.checkNotNullExpressionValue(r2, "of(year, month, day)");
            return r2;
        }
    }

    public OReelPickerDate() {
    }

    public static final /* synthetic */ void access$setMBuilder$p(OReelPickerDate r0, Builder r1) {
        r0.mBuilder = r1;
    }

    @Override // com.obric.oui.picker.OPicker
    public /* bridge */ /* synthetic */ LocalDate getPicked() {
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
    public LocalDate getPicked2() {
        Builder r1 = this.mBuilder;
        if (r1 == null) goto L10;
        SelectionDate r2 = r1.getMSelected$OUI_standardRelease();
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.toLocalDate();
    L10:
        return null;
    }
}
