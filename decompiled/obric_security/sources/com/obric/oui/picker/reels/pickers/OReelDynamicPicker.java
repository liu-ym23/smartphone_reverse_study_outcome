package com.obric.oui.picker.reels.pickers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.PointerIconCompat;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.common.oui.R;
import com.obric.oui.calendar.ODatePickerView;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.ss.android.message.log.PushLog;
import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.ChipsView;

/* JADX INFO: compiled from: OReelDynamicPicker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker;", "Lcom/obric/oui/picker/OPicker;", "Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$PickedData;", "()V", "mBuilder", "Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "asView", "Landroid/view/View;", "getPicked", "Builder", "PickedData", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OReelDynamicPicker implements OPicker<PickedData> {
    private Builder mBuilder;

    /* JADX INFO: compiled from: OReelDynamicPicker.kt */
    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J7\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010 JA\u0010!\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010&J7\u0010'\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010 JK\u0010(\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020*2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010,JA\u0010-\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020*2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010.J7\u0010/\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010 J7\u00100\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u0001012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u00102Je\u00103\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u0002062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u00108JA\u00109\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020*2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010.J7\u0010:\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010 JK\u0010;\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010=\u001a\u00020\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010>J\"\u0010?\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u000eH\u0016J\b\u0010C\u001a\u00020DH\u0002J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u000eJ\u0016\u0010F\u001a\u00020D2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerBuilder;", "Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker;", "Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$PickedData;", "()V", "mBuilt", "Lcom/obric/oui/picker/reels/OReelPicker;", "getMBuilt$OUI_standardRelease", "()Lcom/obric/oui/picker/reels/OReelPicker;", "setMBuilt$OUI_standardRelease", "(Lcom/obric/oui/picker/reels/OReelPicker;)V", "mChangedListener", "Ljava/util/function/Consumer;", "mHeight", "", "Ljava/lang/Integer;", "mReels", "", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "mSelections", "", "getMSelections$OUI_standardRelease", "()Ljava/util/Map;", "mWidth", "rcListener", "Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "addAmPm", "context", "Landroid/content/Context;", SlardarConfigConsts.CONFIG_ID, MaterialConfigFormatNames.SELECTED, MaterialConfigFormatNames.WIDTH, "(Landroid/content/Context;ILjava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addCustom", "entries", "", "", PushLog.KEY_TAG, "(Landroid/content/Context;ILjava/util/List;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addDay", "addHour", "is24Hour", "", "showTag", "(Landroid/content/Context;IZZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addMinute", "(Landroid/content/Context;IZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addMonth", "addOneYearDateWithWeek", "Ljava/time/LocalDate;", "(Landroid/content/Context;ILjava/time/LocalDate;Ljava/lang/Integer;)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addReel", "selectedIndex", "widthWeight", "", "tagGap", "(ILjava/util/List;Ljava/lang/String;IFLjava/lang/Integer;Ljava/lang/Integer;Landroid/content/Context;)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "addSecond", "addTimeMode", "addYear", "from", "to", "(Landroid/content/Context;IIILjava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$Builder;", "build", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "notifyChange", "", "setHeight", "setOnChangedListener", "listener", "setWidth", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder implements OReelPickerBuilder<OReelDynamicPicker, PickedData> {
        private OReelPicker mBuilt;
        private Consumer<PickedData> mChangedListener;
        private Integer mHeight;
        private final List<OReelPicker.Reel> mReels;
        private final Map<Integer, Integer> mSelections;
        private Integer mWidth;
        private final OReelPicker.ReelChangedListener rcListener;

        /* JADX INFO: renamed from: $r8$lambda$orw_KGOkAeIeVyiw-y3QjH68AnY, reason: not valid java name */
        public static /* synthetic */ void m407$r8$lambda$orw_KGOkAeIeVyiwy3QjH68AnY(Builder r0, int r1, int r2) {
            m409rcListener$lambda0(r0, r1, r2);
        }

        public static /* synthetic */ String $r8$lambda$wMdXRE_dD3_t1U3RFayvY34nVvU(LocalDate r0, Context r1, DateTimeFormatter r2, LocalDate r3) {
            return m408addOneYearDateWithWeek$lambda9(r0, r1, r2, r3);
        }

        public final Builder addAmPm(Context r9) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addAmPm$default(this, r9, 0, null, null, 14, null);
        }

        public final Builder addAmPm(Context r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addAmPm$default(this, r9, r10, null, null, 12, null);
        }

        public final Builder addAmPm(Context r9, int r10, Integer r11) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addAmPm$default(this, r9, r10, r11, null, 8, null);
        }

        public final Builder addDay(Context r9) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addDay$default(this, r9, 0, null, null, 14, null);
        }

        public final Builder addDay(Context r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addDay$default(this, r9, r10, null, null, 12, null);
        }

        public final Builder addDay(Context r9, int r10, Integer r11) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addDay$default(this, r9, r10, r11, null, 8, null);
        }

        public final Builder addHour(Context r11) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return addHour$default(this, r11, 0, false, false, null, null, 62, null);
        }

        public final Builder addHour(Context r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return addHour$default(this, r11, r12, false, false, null, null, 60, null);
        }

        public final Builder addHour(Context r11, int r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return addHour$default(this, r11, r12, r13, false, null, null, 56, null);
        }

        public final Builder addHour(Context r11, int r12, boolean r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return addHour$default(this, r11, r12, r13, r14, null, null, 48, null);
        }

        public final Builder addHour(Context r11, int r12, boolean r13, boolean r14, Integer r15) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return addHour$default(this, r11, r12, r13, r14, r15, null, 32, null);
        }

        public final Builder addMinute(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return addMinute$default(this, r10, 0, false, null, null, 30, null);
        }

        public final Builder addMinute(Context r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return addMinute$default(this, r10, r11, false, null, null, 28, null);
        }

        public final Builder addMinute(Context r10, int r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return addMinute$default(this, r10, r11, r12, null, null, 24, null);
        }

        public final Builder addMinute(Context r10, int r11, boolean r12, Integer r13) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return addMinute$default(this, r10, r11, r12, r13, null, 16, null);
        }

        public final Builder addMonth(Context r9) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addMonth$default(this, r9, 0, null, null, 14, null);
        }

        public final Builder addMonth(Context r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addMonth$default(this, r9, r10, null, null, 12, null);
        }

        public final Builder addMonth(Context r9, int r10, Integer r11) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addMonth$default(this, r9, r10, r11, null, 8, null);
        }

        public final Builder addOneYearDateWithWeek(Context r9) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addOneYearDateWithWeek$default(this, r9, 0, null, null, 14, null);
        }

        public final Builder addOneYearDateWithWeek(Context r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addOneYearDateWithWeek$default(this, r9, r10, null, null, 12, null);
        }

        public final Builder addOneYearDateWithWeek(Context r9, int r10, LocalDate r11) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addOneYearDateWithWeek$default(this, r9, r10, r11, null, 8, null);
        }

        public final Builder addSecond(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return addSecond$default(this, r10, 0, false, null, null, 30, null);
        }

        public final Builder addSecond(Context r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return addSecond$default(this, r10, r11, false, null, null, 28, null);
        }

        public final Builder addSecond(Context r10, int r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return addSecond$default(this, r10, r11, r12, null, null, 24, null);
        }

        public final Builder addSecond(Context r10, int r11, boolean r12, Integer r13) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return addSecond$default(this, r10, r11, r12, r13, null, 16, null);
        }

        public final Builder addTimeMode(Context r9) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addTimeMode$default(this, r9, 0, null, null, 14, null);
        }

        public final Builder addTimeMode(Context r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addTimeMode$default(this, r9, r10, null, null, 12, null);
        }

        public final Builder addTimeMode(Context r9, int r10, Integer r11) {
            Intrinsics.checkNotNullParameter(r9, "context");
            return addTimeMode$default(this, r9, r10, r11, null, 8, null);
        }

        public final Builder addYear(Context r11) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return addYear$default(this, r11, 0, 0, 0, null, null, 62, null);
        }

        public final Builder addYear(Context r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return addYear$default(this, r11, r12, 0, 0, null, null, 60, null);
        }

        public final Builder addYear(Context r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return addYear$default(this, r11, r12, r13, 0, null, null, 56, null);
        }

        public final Builder addYear(Context r11, int r12, int r13, int r14) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return addYear$default(this, r11, r12, r13, r14, null, null, 48, null);
        }

        public final Builder addYear(Context r11, int r12, int r13, int r14, Integer r15) {
            Intrinsics.checkNotNullParameter(r11, "context");
            return addYear$default(this, r11, r12, r13, r14, r15, null, 32, null);
        }

        public Builder() {
            this.mReels = new ArrayList();
            this.mSelections = new LinkedHashMap();
            this.rcListener = new OReelDynamicPicker$Builder$$ExternalSyntheticLambda0(this);
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public /* bridge */ /* synthetic */ OReelDynamicPicker build(Context r1, AttributeSet r2, int r3) {
            return build(r1, r2, r3);
        }

        public final Map<Integer, Integer> getMSelections$OUI_standardRelease() {
            return this.mSelections;
        }

        public final OReelPicker getMBuilt$OUI_standardRelease() {
            return this.mBuilt;
        }

        public final void setMBuilt$OUI_standardRelease(OReelPicker r1) {
            this.mBuilt = r1;
        }

        public final Builder setWidth(int r1) {
            this.mWidth = Integer.valueOf(r1);
            return this;
        }

        public final Builder setHeight(int r1) {
            this.mHeight = Integer.valueOf(r1);
            return this;
        }

        /* JADX INFO: renamed from: rcListener$lambda-0, reason: not valid java name */
        private static final void m409rcListener$lambda0(Builder r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            r1.mSelections.put(Integer.valueOf(r2), Integer.valueOf(r3));
            r1.notifyChange();
        }

        private final void notifyChange() {
            Consumer<PickedData> r0 = this.mChangedListener;
            if (r0 == null) goto L7;
            r0.accept(new PickedData(MapsKt.toMap(this.mSelections)));
            return;
        }

        public static /* synthetic */ Builder addReel$default(Builder r12, int r13, List r14, String r15, int r16, float r17, Integer r18, Integer r19, Context r20, int r21, Object r22) {
            if ((r21 & 4) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r21 & 8) == 0) goto L9;
            int r7 = 0;
        L11:
            if ((r21 & 16) == 0) goto L13;
            float r8 = 1.0f;
        L15:
            if ((r21 & 32) == 0) goto L17;
            Integer r9 = null;
        L19:
            if ((r21 & 64) == 0) goto L21;
            Integer r10 = null;
        L23:
            if ((r21 & 128) == 0) goto L25;
            Context r11 = null;
        L27:
            return r12.addReel(r13, r14, r6, r7, r8, r9, r10, r11);
        L25:
            r11 = r20;
            goto L27
        L21:
            r10 = r19;
            goto L23
        L17:
            r9 = r18;
            goto L19
        L13:
            r8 = r17;
            goto L15
        L9:
            r7 = r16;
            goto L11
        L5:
            r6 = r15;
            goto L7
        }

        public final Builder addReel(int r14, List<String> r15, String r16, int r17, float r18, Integer r19, Integer r20, Context r21) {
            Intrinsics.checkNotNullParameter(r15, "entries");
            if (r19 != null) goto L11;
            if (r21 == null) goto L11;
            if (r16 != null) goto L9;
            if (r20 != null) goto L9;
            Integer r1 = Integer.valueOf(OUnitExtensionKt.cdp(r21, 72));
        L10:
            Integer r9 = r1;
        L12:
            this.mReels.add(new OReelPicker.Reel(r14, r15, r16, r18, r19, r9, r20, r17, this.rcListener));
            this.mSelections.put(Integer.valueOf(r14), Integer.valueOf(r17));
            return this;
        L9:
            r1 = Integer.valueOf(OUnitExtensionKt.cdp(r21, 92));
        L11:
            r9 = r19;
            goto L12
        }

        public static /* synthetic */ Builder addYear$default(Builder r7, Context r8, int r9, int r10, int r11, Integer r12, Integer r13, int r14, Object r15) {
            if ((r14 & 2) == 0) goto L5;
            r9 = 1001;
        L5:
            int r2 = r9;
            if ((r14 & 4) == 0) goto L8;
            r10 = ODatePickerView.YEAR_FROM;
        L8:
            int r3 = r10;
            if ((r14 & 8) == 0) goto L11;
            r11 = ODatePickerView.YEAR_TO;
        L11:
            int r4 = r11;
            if ((r14 & 16) == 0) goto L14;
            Integer r5 = null;
        L16:
            if ((r14 & 32) == 0) goto L18;
            Integer r6 = null;
        L20:
            return r7.addYear(r8, r2, r3, r4, r5, r6);
        L18:
            r6 = r13;
            goto L20
        L14:
            r5 = r12;
            goto L16
        }

        public final Builder addYear(Context r21, int r22, int r23, int r24, Integer r25, Integer r26) {
            Intrinsics.checkNotNullParameter(r21, "context");
            Utils r2 = Utils.INSTANCE;
            String r5 = r21.getString(R.string.oui_reel_picker_year_tag);
            Intrinsics.checkNotNullExpressionValue(r5, "context.getString(R.stri…oui_reel_picker_year_tag)");
            List r11 = Utils.generateRange$default(r2, r23, r24, r5, 0, 8, null);
            int r1 = 0;
            if (r25 == null) goto L6;
            r1 = Math.max(0, Math.min(r25.intValue() - r23, r11.size() - 1));
        L6:
            int r13 = r1;
            if (r26 != null) goto L9;
            int r0 = OUnitExtensionKt.cdp(r21, 101);
        L11:
            return addReel$default(this, r22, r11, null, r13, 0.0f, Integer.valueOf(r0), null, null, 208, null);
        L9:
            r0 = r26.intValue();
            goto L11
        }

        public static /* synthetic */ Builder addMonth$default(Builder r1, Context r2, int r3, Integer r4, Integer r5, int r6, Object r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = 1002;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = null;
        L12:
            return r1.addMonth(r2, r3, r4, r5);
        }

        public final Builder addMonth(Context r16, int r17, Integer r18, Integer r19) {
            Intrinsics.checkNotNullParameter(r16, "context");
            List<String> r6 = Utils.INSTANCE.generateMonthRange(r16, 1, 12);
            int r1 = 0;
            if (r18 == null) goto L6;
            r1 = Math.max(0, Math.min(r18.intValue() - 1, 11));
        L6:
            int r8 = r1;
            if (r19 != null) goto L9;
            int r0 = OUnitExtensionKt.cdp(r16, 101);
        L11:
            return addReel$default(this, r17, r6, null, r8, 0.0f, Integer.valueOf(r0), null, null, 208, null);
        L9:
            r0 = r19.intValue();
            goto L11
        }

        public static /* synthetic */ Builder addDay$default(Builder r1, Context r2, int r3, Integer r4, Integer r5, int r6, Object r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = 1003;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = null;
        L12:
            return r1.addDay(r2, r3, r4, r5);
        }

        public final Builder addDay(Context r21, int r22, Integer r23, Integer r24) {
            Intrinsics.checkNotNullParameter(r21, "context");
            Utils r2 = Utils.INSTANCE;
            String r5 = r21.getString(R.string.oui_reel_picker_day_tag);
            Intrinsics.checkNotNullExpressionValue(r5, "context.getString(R.stri….oui_reel_picker_day_tag)");
            List r11 = Utils.generateRange$default(r2, 1, 31, r5, 0, 8, null);
            int r1 = 0;
            if (r23 == null) goto L6;
            r1 = Math.max(0, Math.min(r23.intValue() - 1, 30));
        L6:
            int r13 = r1;
            if (r24 != null) goto L9;
            int r0 = OUnitExtensionKt.cdp(r21, 101);
        L11:
            return addReel$default(this, r22, r11, null, r13, 0.0f, Integer.valueOf(r0), null, null, 208, null);
        L9:
            r0 = r24.intValue();
            goto L11
        }

        public static /* synthetic */ Builder addHour$default(Builder r7, Context r8, int r9, boolean r10, boolean r11, Integer r12, Integer r13, int r14, Object r15) {
            if ((r14 & 2) == 0) goto L5;
            r9 = 1004;
        L5:
            int r2 = r9;
            if ((r14 & 4) == 0) goto L8;
            boolean r3 = true;
        L10:
            if ((r14 & 8) == 0) goto L12;
            boolean r4 = true;
        L14:
            if ((r14 & 16) == 0) goto L16;
            Integer r5 = null;
        L18:
            if ((r14 & 32) == 0) goto L20;
            Integer r6 = null;
        L22:
            return r7.addHour(r8, r2, r3, r4, r5, r6);
        L20:
            r6 = r13;
            goto L22
        L16:
            r5 = r12;
            goto L18
        L12:
            r4 = r11;
            goto L14
        L8:
            r3 = r10;
            goto L10
        }

        public final Builder addHour(Context r12, int r13, boolean r14, boolean r15, Integer r16, Integer r17) {
            Intrinsics.checkNotNullParameter(r12, "context");
            int r0 = !r14 ? 1 : 0;
            if (r14 == false) goto L5;
            int r1 = 23;
        L6:
            List r2 = Utils.generateRange$default(Utils.INSTANCE, r0, r1, "", 0, 8, null);
            Integer r3 = null;
            if (r15 == false) goto L9;
            String r4 = r12.getString(R.string.oui_reel_tag_hour);
        L10:
            if (r15 == false) goto L12;
            r3 = Integer.valueOf(OUnitExtensionKt.cdp(r12, 4));
        L12:
            Integer r7 = r3;
            if (r16 != null) goto L15;
            int r5 = 0;
        L17:
            return addReel$default(this, r13, r2, r4, r5, 0.0f, r17, r7, r12, 16, null);
        L15:
            r5 = Math.max(0, Math.min(r16.intValue() - r0, r2.size() - 1));
            goto L17
        L9:
            r4 = null;
            goto L10
        L5:
            r1 = 12;
            goto L6
        }

        public static /* synthetic */ Builder addMinute$default(Builder r6, Context r7, int r8, boolean r9, Integer r10, Integer r11, int r12, Object r13) {
            if ((r12 & 2) == 0) goto L5;
            r8 = 1005;
        L5:
            int r2 = r8;
            if ((r12 & 4) == 0) goto L8;
            r9 = true;
        L8:
            boolean r3 = r9;
            if ((r12 & 8) == 0) goto L11;
            Integer r4 = null;
        L13:
            if ((r12 & 16) == 0) goto L15;
            Integer r5 = null;
        L17:
            return r6.addMinute(r7, r2, r3, r4, r5);
        L15:
            r5 = r11;
            goto L17
        L11:
            r4 = r10;
            goto L13
        }

        public final Builder addMinute(Context r12, int r13, boolean r14, Integer r15, Integer r16) {
            Intrinsics.checkNotNullParameter(r12, "context");
            List r2 = Utils.generateRange$default(Utils.INSTANCE, 0, 59, "", 0, 8, null);
            Integer r0 = null;
            if (r14 == false) goto L5;
            String r3 = r12.getString(R.string.oui_reel_tag_minute);
        L6:
            if (r14 == false) goto L8;
            r0 = Integer.valueOf(OUnitExtensionKt.cdp(r12, 4));
        L8:
            Integer r7 = r0;
            int r1 = 0;
            if (r15 == null) goto L13;
            r1 = Math.max(0, Math.min(r15.intValue(), 59));
        L13:
            return addReel$default(this, r13, r2, r3, r1, 0.0f, r16, r7, r12, 16, null);
        L5:
            r3 = null;
            goto L6
        }

        public static /* synthetic */ Builder addSecond$default(Builder r6, Context r7, int r8, boolean r9, Integer r10, Integer r11, int r12, Object r13) {
            if ((r12 & 2) == 0) goto L5;
            r8 = PointerIconCompat.TYPE_CELL;
        L5:
            int r2 = r8;
            if ((r12 & 4) == 0) goto L8;
            r9 = true;
        L8:
            boolean r3 = r9;
            if ((r12 & 8) == 0) goto L11;
            Integer r4 = null;
        L13:
            if ((r12 & 16) == 0) goto L15;
            Integer r5 = null;
        L17:
            return r6.addSecond(r7, r2, r3, r4, r5);
        L15:
            r5 = r11;
            goto L17
        L11:
            r4 = r10;
            goto L13
        }

        public final Builder addSecond(Context r12, int r13, boolean r14, Integer r15, Integer r16) {
            Intrinsics.checkNotNullParameter(r12, "context");
            List r2 = Utils.generateRange$default(Utils.INSTANCE, 0, 59, "", 0, 8, null);
            Integer r0 = null;
            if (r14 == false) goto L5;
            String r3 = r12.getString(R.string.oui_reel_tag_second);
        L6:
            if (r14 == false) goto L8;
            r0 = Integer.valueOf(OUnitExtensionKt.cdp(r12, 4));
        L8:
            Integer r7 = r0;
            int r1 = 0;
            if (r15 == null) goto L13;
            r1 = Math.max(0, Math.min(r15.intValue(), 59));
        L13:
            return addReel$default(this, r13, r2, r3, r1, 0.0f, r16, r7, r12, 16, null);
        L5:
            r3 = null;
            goto L6
        }

        public static /* synthetic */ Builder addAmPm$default(Builder r1, Context r2, int r3, Integer r4, Integer r5, int r6, Object r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = PointerIconCompat.TYPE_CROSSHAIR;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = null;
        L12:
            return r1.addAmPm(r2, r3, r4, r5);
        }

        public final Builder addAmPm(Context r13, int r14, Integer r15, Integer r16) {
            Intrinsics.checkNotNullParameter(r13, "context");
            String[] r0 = DateFormatSymbols.getInstance().getAmPmStrings();
            Intrinsics.checkNotNullExpressionValue(r0, "getInstance().amPmStrings");
            List r3 = ArraysKt.toList(r0);
            int r1 = 0;
            if (r15 == null) goto L7;
            r1 = Math.max(0, Math.min(r15.intValue(), r3.size() - 1));
        L7:
            return addReel$default(this, r14, r3, null, r1, 0.0f, r16, null, r13, 80, null);
        }

        public static /* synthetic */ Builder addTimeMode$default(Builder r1, Context r2, int r3, Integer r4, Integer r5, int r6, Object r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = PointerIconCompat.TYPE_TEXT;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = null;
        L12:
            return r1.addTimeMode(r2, r3, r4, r5);
        }

        public final Builder addTimeMode(Context r12, int r13, Integer r14, Integer r15) {
            Intrinsics.checkNotNullParameter(r12, "context");
            List r4 = CollectionsKt.listOf(new String[]{r12.getString(R.string.oui_time_format_12_hour), r12.getString(R.string.oui_time_format_24_hour)});
            if (r14 != null) goto L5;
            int r5 = 0;
        L7:
            return addReel$default(this, r13, r4, null, r5, 0.0f, r15, null, r12, 80, null);
        L5:
            r5 = Math.max(0, Math.min(r14.intValue(), r4.size() - 1));
            goto L7
        }

        public static /* synthetic */ Builder addOneYearDateWithWeek$default(Builder r1, Context r2, int r3, LocalDate r4, Integer r5, int r6, Object r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = PointerIconCompat.TYPE_VERTICAL_TEXT;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = null;
        L12:
            return r1.addOneYearDateWithWeek(r2, r3, r4, r5);
        }

        public final Builder addOneYearDateWithWeek(final Context r12, int r13, LocalDate r14, Integer r15) {
            Intrinsics.checkNotNullParameter(r12, "context");
            LocalDate r0 = LocalDate.now();
            LocalDate r1 = r0.plusYears(1);
            final DateTimeFormatter r2 = DateTimeFormatter.ofPattern(r12.getString(R.string.oui_reel_picker_month_day_pattern));
            final LocalDate r3 = LocalDate.now();
            Utils r4 = Utils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(r0, "from");
            Intrinsics.checkNotNullExpressionValue(r1, "to");
            List<String> r5 = r4.generateDateRange(r0, r1, new OReelDynamicPicker$Builder$$ExternalSyntheticLambda1(r3, r12, r2));
            if (r14 == null) goto L7;
            r3 = r14;
        L7:
            if (r3.isBefore(r0) == false) goto L11;
            int r6 = 0;
        L9:
            int r7 = r6;
            if (r15 != null) goto L17;
            int r8 = OUnitExtensionKt.cdp(r12, ChipsView.HISTORY);
        L19:
            return addReel$default(this, r13, r5, null, r7, 0.0f, Integer.valueOf(r8), null, r12, 80, null);
        L17:
            r8 = r15.intValue();
            goto L19
        L11:
            if (r3.isBefore(r1) == false) goto L13;
            r6 = (int) ChronoUnit.DAYS.between(r0, r3);
            goto L9
        L13:
            r6 = r5.size() - 1;
            goto L9
        }

        /* JADX INFO: renamed from: addOneYearDateWithWeek$lambda-9, reason: not valid java name */
        private static final String m408addOneYearDateWithWeek$lambda9(LocalDate r2, Context r3, DateTimeFormatter r4, LocalDate r5) {
            Intrinsics.checkNotNullParameter(r3, "$context");
            Intrinsics.checkNotNullParameter(r5, ProviderConstants.Sms.DATE);
            if (r5.isEqual(r2) == false) goto L5;
            String r6 = r3.getString(R.string.oui_picker_today);
        L6:
            Intrinsics.checkNotNullExpressionValue(r6, "if (date.isEqual(today))…Repr())\n                }");
            return r4.format(r5) + ' ' + r6;
        L5:
            Utils r7 = Utils.INSTANCE;
            DayOfWeek r0 = r5.getDayOfWeek();
            Intrinsics.checkNotNullExpressionValue(r0, "date.dayOfWeek");
            r6 = r3.getString(r7.toShortRepr(r0));
            goto L6
        }

        public static /* synthetic */ Builder addCustom$default(Builder r7, Context r8, int r9, List r10, String r11, Integer r12, int r13, Object r14) {
            if ((r13 & 8) == 0) goto L5;
            String r5 = null;
        L7:
            if ((r13 & 16) == 0) goto L9;
            Integer r6 = null;
        L11:
            return r7.addCustom(r8, r9, r10, r5, r6);
        L9:
            r6 = r12;
            goto L11
        L5:
            r5 = r11;
            goto L7
        }

        public final Builder addCustom(Context r13, int r14, List<String> r15, String r16, Integer r17) {
            Intrinsics.checkNotNullParameter(r13, "context");
            Intrinsics.checkNotNullParameter(r15, "entries");
            int r0 = 0;
            if (r17 == null) goto L7;
            r0 = Math.max(0, Math.min(r17.intValue(), r15.size() - 1));
        L7:
            return addReel$default(this, r14, r15, r16, r0, 0.0f, null, null, r13, 112, null);
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public void setOnChangedListener(Consumer<PickedData> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mChangedListener = r2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public OReelDynamicPicker build(Context r4, AttributeSet r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "context");
            OReelPickerMulti.Builder r0 = new OReelPickerMulti.Builder();
            Integer r1 = this.mWidth;
            if (r1 == null) goto L6;
            r0.setWidth(r1.intValue());
        L6:
            Integer r2 = this.mHeight;
            if (r2 == null) goto L10;
            r0.setHeight(r2.intValue());
        L10:
            Iterator<T> r3 = this.mReels.iterator();
        L12:
            if (r3.hasNext() == false) goto L14;
            r0.addReel((OReelPicker.Reel) r3.next());
            goto L12
        L14:
            this.mBuilt = r0.build(r4, r5, r6);
            OReelDynamicPicker r7 = new OReelDynamicPicker();
            OReelDynamicPicker.access$setMBuilder$p(r7, this);
            return r7;
        }
    }

    /* JADX INFO: compiled from: OReelDynamicPicker.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\t\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker$PickedData;", "", "selections", "", "", "(Ljava/util/Map;)V", "getSelections", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PickedData {
        private final Map<Integer, Integer> selections;

        /* JADX WARN: Multi-variable type inference failed */
        public PickedData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PickedData copy$default(PickedData r0, Map r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.selections;
        L6:
            return r0.copy(r1);
        }

        public final Map<Integer, Integer> component1() {
            return this.selections;
        }

        public final PickedData copy(Map<Integer, Integer> r1) {
            Intrinsics.checkNotNullParameter(r1, "selections");
            return new PickedData(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof PickedData) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.selections, ((PickedData) r4).selections) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.selections.hashCode();
        }

        public String toString() {
            return "PickedData(selections=" + this.selections + ')';
        }

        public PickedData(Map<Integer, Integer> r2) {
            Intrinsics.checkNotNullParameter(r2, "selections");
            this.selections = r2;
        }

        public /* synthetic */ PickedData(Map r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = MapsKt.emptyMap();
        L5:
            this(r1);
        }

        public final Map<Integer, Integer> getSelections() {
            return this.selections;
        }
    }

    public OReelDynamicPicker() {
    }

    public static final /* synthetic */ void access$setMBuilder$p(OReelDynamicPicker r0, Builder r1) {
        r0.mBuilder = r1;
    }

    @Override // com.obric.oui.picker.OPicker
    public /* bridge */ /* synthetic */ PickedData getPicked() {
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
    public PickedData getPicked() {
        Builder r1 = this.mBuilder;
        if (r1 != null) goto L6;
        return null;
    L6:
        return new PickedData(MapsKt.toMap(r1.getMSelections$OUI_standardRelease()));
    }
}
