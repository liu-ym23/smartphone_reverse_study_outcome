package com.android.settings.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.android.settings.R;
import com.obric.oui.picker.reels.pickers.OReelDynamicPicker;
import com.obric.oui.sheet.v2.OSheet;
import obric.util.DisplayHelper;

/* JADX INFO: loaded from: classes.dex */
public class TimePickerDialog {
    private static final String TAG = "TimePickerDialog";
    private final OnTimeSetListener mCallback;
    private OSheet mOSheet;
    private int mPickHour;
    private int mPickMinute;

    public interface OnTimeSetListener {
        void onTimeSet(int r1, int r2);
    }

    static class ReelType {
        static final int HOUR = 2;
        static final int MERIDIEM = 1;
        static final int MINUTE = 3;

        ReelType() {
        }
    }

    static /* synthetic */ OSheet access$000(TimePickerDialog r0) {
        return r0.mOSheet;
    }

    static /* synthetic */ OnTimeSetListener access$100(TimePickerDialog r0) {
        return r0.mCallback;
    }

    static /* synthetic */ int access$200(TimePickerDialog r0) {
        return r0.mPickHour;
    }

    static /* synthetic */ int access$202(TimePickerDialog r0, int r1) {
        r0.mPickHour = r1;
        return r1;
    }

    static /* synthetic */ int access$300(TimePickerDialog r0) {
        return r0.mPickMinute;
    }

    static /* synthetic */ int access$302(TimePickerDialog r0, int r1) {
        r0.mPickMinute = r1;
        return r1;
    }

    public TimePickerDialog(Context r21, String r22, OnTimeSetListener r23, int r24, int r25, boolean r26) {
        this.mCallback = r23;
        View r2 = get24HourView(r21, r24, r25, r26);
        OSheet r3 = new OSheet(r21, 0);
        this.mOSheet = r3;
        r3.setHeightMode(OSheet.HeightMode.WRAP_HEIGHT);
        this.mOSheet.setHeader(OSheet.Header.ACTION, null, null, r22, null, false, new AnonymousClass1(this), new AnonymousClass2(this), null, null, null, null, null, Integer.valueOf(R.drawable.ext_oui_ic_title_bar_confirm));
        this.mOSheet.setBodyView(r2);
        this.mOSheet.getBodyContainer().setPadding(DisplayHelper.dp2px(r21, 16), DisplayHelper.dp2px(r21, 8), DisplayHelper.dp2px(r21, 16), DisplayHelper.dp2px(r21, 16));
    }

    private View get24HourView(Context r11, int r12, int r13, final boolean r14) {
        OReelDynamicPicker.Builder r7 = new OReelDynamicPicker.Builder();
        int r0 = 12;
        if (r14 == false) goto L5;
    L9:
        if (r12 <= 12) goto L11;
        int r1 = r12 - 12;
    L12:
        if (r12 == 0) goto L15;
        r0 = r1;
    L15:
        this.mPickMinute = r13;
        if (r14 == false) goto L18;
        int r2 = r12;
    L19:
        this.mPickHour = r2;
        if (r14 == true) goto L23;
        r12 = r0;
    L23:
        r7.addHour(r11, 2, r14, true, Integer.valueOf(r12), null);
        r7.addMinute(r11, 3, true, Integer.valueOf(r13), null);
        r7.setOnChangedListener(new AnonymousClass3(this, r14));
        OReelDynamicPicker r10 = r7.build(r11, null, 0);
        View r15 = r10.asView();
        if (r15 == null) goto L27;
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(r15.getLayoutParams().width, r15.getLayoutParams().height);
        r16.gravity = 17;
        r15.setLayoutParams(r16);
        r15.setBackground(ContextCompat.getDrawable(r11, R.color.Transparent));
    L27:
        return r10.asView();
    L18:
        r2 = r0;
        goto L19
    L11:
        r1 = r12;
        goto L12
    L5:
        if (r12 < 12) goto L7;
        int r3 = 1;
    L8:
        r7.addAmPm(r11, 1, Integer.valueOf(r3), null);
        goto L9
    L7:
        r3 = 0;
        goto L8
    }

    public void show() {
        this.mOSheet.show();
    }
}
