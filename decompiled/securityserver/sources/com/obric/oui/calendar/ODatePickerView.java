package com.obric.oui.calendar;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.OUILogger;
import com.obric.oui.sheet.OSheetContentFrameLayout;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ODatePickerView extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;
    public int b;
    public int c;
    public long e;
    public Function1 f;
    public Function1 i;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final enum DatePickerMode extends Enum<DatePickerMode> {
        public static final /* synthetic */ DatePickerMode[] b = null;

        static {
            b = new DatePickerMode[]{new DatePickerMode("BOARD_SHEET", 0), new DatePickerMode("NARROW_SHEET", 1)};
        }

        public static DatePickerMode valueOf(String r1) {
            return (DatePickerMode) Enum.valueOf(DatePickerMode.class, r1);
        }

        public static DatePickerMode[] values() {
            return (DatePickerMode[]) b.clone();
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[DatePickerMode.values().length];
            r0[0] = 1;
            r0[1] = 2;
        }
    }

    private final int getMillisecond() {
        return this.c;
    }

    private final int getSecond() {
        return this.b;
    }

    private final void setMillisecond(int r1) {
        this.c = r1;
    }

    private final void setSecond(int r1) {
        this.b = r1;
    }

    @Nullable
    public final Function1<Long, Unit> getOnDateChangedListener() {
        return this.i;
    }

    @Nullable
    public final Function1<Long, Unit> getOnMonthChangedListener() {
        return this.f;
    }

    public final long getSelectTimestamp() {
        Calendar.getInstance();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r3 = getParent();
        if (r3 != null) goto L6;
    L4:
        r3 = null;
    L7:
        ViewGroup r4 = (ViewGroup) r3;
        if ((r4 instanceof OSheetContentFrameLayout) == false) goto L14;
        OSheetContentFrameLayout r5 = (OSheetContentFrameLayout) r4;
        if (r5.getId() != R.id.content_container) goto L15;
        r5.getPaddingLeft();
        r5.getPaddingTop();
        r5.getPaddingRight();
        r5.getPaddingBottom();
        throw null;
    L15:
        return;
    L14:
        return;
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    public final void setCurrentTimeMillis(long r3) {
        this.e = r3;
        Calendar.getInstance();
        OUILogger.a(null, "默认选中的时间:" + this.e + " , mSelectTime:" + this.e);
        throw null;
    }

    public final void setOnDateChangedListener(@Nullable Function1<? super Long, Unit> r1) {
        this.i = r1;
    }

    public final void setOnMonthChangedListener(@Nullable Function1<? super Long, Unit> r1) {
        this.f = r1;
    }
}
