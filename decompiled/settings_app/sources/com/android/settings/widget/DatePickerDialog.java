package com.android.settings.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.android.settings.R;
import com.obric.olog.OLog;
import com.obric.oui.picker.reels.pickers.OReelPickerDate;
import com.obric.oui.sheet.v2.OSheet;
import java.time.LocalDate;
import obric.util.DisplayHelper;

/* JADX INFO: loaded from: classes.dex */
public class DatePickerDialog {
    private static final int END_YEAR = 2050;
    private static final int START_YEAR = 2012;
    private static final String TAG = "DatePickerDialog";
    private final OnDateSetListener mCallBack;
    private OSheet mOSheet;
    private int mPickDay;
    private int mPickMonth;
    private int mPickYear;
    private OReelPickerDate mPicker;

    public interface OnDateSetListener {
        void onDateSet(int r1, int r2, int r3);
    }

    static /* synthetic */ void access$000(DatePickerDialog r0, LocalDate r1) {
        r0.updatePickerData(r1);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public DatePickerDialog(Context r23, OnDateSetListener r24, int r25, int r26, int r27) {
        this.mCallBack = r24;
        this.mOSheet = new OSheet(r23, 0);
        this.mPickYear = r25;
        this.mPickMonth = r26;
        this.mPickDay = r27;
        OReelPickerDate.Builder r6 = new OReelPickerDate.Builder();
        r6.setYearRange(START_YEAR, END_YEAR);
        r6.setSelected(LocalDate.of(r25, r26, r27));
        this.mOSheet.setHeightMode(OSheet.HeightMode.WRAP_HEIGHT);
        String r11 = r23.getString(R.string.date_time_set_date);
        this.mOSheet.setHeader(OSheet.Header.ACTION, null, null, r11, null, false, new DatePickerDialog$$ExternalSyntheticLambda0(this), new DatePickerDialog$$ExternalSyntheticLambda1(this), null, null, null, null, null, Integer.valueOf(R.drawable.ext_oui_ic_title_bar_confirm));
        r6.setOnChangedListener(new AnonymousClass1(this));
        OReelPickerDate r2 = r6.build(r23, null, 0);
        this.mPicker = r2;
        View r3 = r2.asView();
        if (r3 == null) goto L5;
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r3.getLayoutParams().width, r3.getLayoutParams().height);
        r4.gravity = 17;
        r3.setLayoutParams(r4);
        r3.setBackground(ContextCompat.getDrawable(r23, R.color.Transparent));
    L5:
        this.mOSheet.setBodyView(r3);
        this.mOSheet.getBodyContainer().setPadding(DisplayHelper.dp2px(r23, 16), DisplayHelper.dp2px(r23, 8), DisplayHelper.dp2px(r23, 16), DisplayHelper.dp2px(r23, 16));
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-widget-DatePickerDialog, reason: not valid java name */
    /* synthetic */ void m651lambda$new$0$comandroidsettingswidgetDatePickerDialog(View r1) {
        this.mOSheet.dismiss();
    }

    /* JADX INFO: renamed from: lambda$new$1$com-android-settings-widget-DatePickerDialog, reason: not valid java name */
    /* synthetic */ void m652lambda$new$1$comandroidsettingswidgetDatePickerDialog(View r4) {
        updatePickerData(this.mPicker.getPicked2());
        OnDateSetListener r5 = this.mCallBack;
        if (r5 == null) goto L5;
        r5.onDateSet(this.mPickYear, this.mPickMonth, this.mPickDay);
    L5:
        this.mOSheet.dismiss();
    }

    private void updatePickerData(LocalDate r4) {
        if (r4 != null) goto L6;
        OLog.d(TAG, "pickValue is null");     // Catch: NullPointerException -> L8
        return;
    L6:
        this.mPickYear = r4.getYear();     // Catch: NullPointerException -> L8
        this.mPickMonth = r4.getMonthValue();     // Catch: NullPointerException -> L8
        this.mPickDay = r4.getDayOfMonth();     // Catch: NullPointerException -> L8
        OLog.d(TAG, "updatePickerData: year = " + this.mPickYear + ", month = " + this.mPickMonth + ", day = " + this.mPickDay);     // Catch: NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        OLog.d(TAG, "accept: " + e);
    }

    public void show() {
        this.mOSheet.show();
    }
}
