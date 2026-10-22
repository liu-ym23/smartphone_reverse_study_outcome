package com.android.settings.bluetooth;

import android.content.Context;
import android.widget.Button;
import com.android.settings.R;
import com.obric.oui.picker.reels.pickers.OReelCustomPicker;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothTimer implements BluetoothNumberPicker.OnValueChangeListener {
    private static final int CANCEL_COUNTDOWN_INDEX = 2;
    private static final int FIFTEEN_COUNTDOWN_INDEX = 3;
    private static final int ONE_AND_HALF_OF_HOUR_COUNTDOWN_INDEX = 6;
    private static final int ONE_HOUR_COUNTDOWN_INDEX = 5;
    private static final String TAG = "BluetoothTimer";
    private static final int THIRTEEN_COUNTDOWN_INDEX = 4;
    private static final int TIME_BUFFER = 0;
    private static final int TIME_COUNTDOWN_INDEX = 1;
    private static final int TWO_HOUR_COUNTDOWN_INDEX = 7;
    private static Timer mTimer;
    private BluetoothNumberPicker mBluetoothNumberPicker;
    private OSelectionPanelBtnView mBtnView;
    private CachedBluetoothDevice mCachedDevice;
    private TimerCallback mCallback;
    private Button mCompleteBtn;
    private Context mContext;
    private boolean mIsCountdowning;
    private OInsetSheet mOInsetSheet;
    private final String mSetTime;

    public interface TimerCallback {
        void onDialogFinished(boolean r1);

        void onStartTiming(long r1);

        void onStopTiming();
    }

    static /* synthetic */ TimerCallback access$000(BluetoothTimer r0) {
        return r0.mCallback;
    }

    static /* synthetic */ OInsetSheet access$100(BluetoothTimer r0) {
        return r0.mOInsetSheet;
    }

    static /* synthetic */ boolean access$200(BluetoothTimer r0) {
        return r0.mIsCountdowning;
    }

    static /* synthetic */ void access$300(BluetoothTimer r0, int r1) {
        r0.processClickEvent(r1);
    }

    public BluetoothTimer(Context r1, CachedBluetoothDevice r2) {
        this.mContext = r1;
        this.mCachedDevice = r2;
        this.mSetTime = r1.getString(R.string.bluetooth_setting_stop_time);
        this.mIsCountdowning = isCountdowning();
        init(r1);
    }

    public void registerCallback(TimerCallback r1) {
        this.mCallback = r1;
    }

    public void unRegisterCallback() {
        this.mCallback = null;
    }

    private boolean isCountdowning() {
        if (Utils.getRemainingTime(this.mContext) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void init(Context r1) {
        initTimerPicker(r1);
    }

    private void initTimerPicker(Context r19) {
        OInsetSheet r2 = this.mOInsetSheet;
        if (r2 == null) goto L6;
        r2.show();
        return;
    L6:
        OReelCustomPicker.Builder r3 = new OReelCustomPicker.Builder();
        String[] r4 = {r19.getString(R.string.time_no), r19.getString(R.string.time_15m), r19.getString(R.string.time_30m), r19.getString(R.string.time_1h), r19.getString(2131959093), r19.getString(R.string.time_2h)};
        String[] r5 = {r19.getString(R.string.time_countdown), r19.getString(R.string.time_no), r19.getString(R.string.time_15m), r19.getString(R.string.time_30m), r19.getString(R.string.time_1h), r19.getString(2131959093), r19.getString(R.string.time_2h)};
        if (this.mIsCountdowning == false) goto L9;
        ArrayList<String> r6 = new ArrayList(Arrays.asList(r5));
    L10:
        r3.setLeftString(r6);
        r3.setShowLeftWheel(true, 0, r6.size(), 0);
        r3.setShowRightWheel(false, 2, 3, 0);
        r3.setOnChangedListener(new BluetoothTimer$$ExternalSyntheticLambda0(this));
        final OReelCustomPicker r7 = r3.build(r19, null, 0);
        OInsetSheet r8 = new OInsetSheet(r19);
        this.mOInsetSheet = r8;
        r8.setRootWidth(OInsetSheet.PanelWidth.BOARD_WIDTH);
        OFloatingTitleBar r9 = new OFloatingTitleBar(r19);
        r9.setCenterTitle(r19.getResources().getString(R.string.time_titel));
        this.mOInsetSheet.setHeaderView(r9);
        this.mOInsetSheet.setContainerView(r7.asView());
        OSelectionPanelBtnView r10 = new OSelectionPanelBtnView(r19);
        this.mBtnView = r10;
        r10.getBtnNegative().setText(R.string.cancel);
        this.mBtnView.getBtnNegative().setOnClickListener(new AnonymousClass1(this));
        this.mBtnView.getBtnPositive().setText(R.string.edit_submit);
        if (this.mIsCountdowning == false) goto L13;
        this.mBtnView.getBtnPositive().setEnabled(false);
    L13:
        this.mBtnView.setOnClickListener(new AnonymousClass2(this, r7));
        this.mOInsetSheet.setFooterView(this.mBtnView);
        this.mOInsetSheet.show();
        return;
    L9:
        r6 = new ArrayList(Arrays.asList(r4));
        goto L10
    }

    /* JADX INFO: renamed from: lambda$initTimerPicker$0$com-android-settings-bluetooth-BluetoothTimer, reason: not valid java name */
    /* synthetic */ void m359x281577a4(OReelCustomPicker.CustomData r2) {
        if (this.mBtnView != null) goto L6;
        return;
    L6:
        if (this.mIsCountdowning == true) goto L8;
    L10:
        this.mBtnView.getBtnPositive().setEnabled(true);
        return;
    L8:
        if (r2.getDown() != 0) goto L10;
        this.mBtnView.getBtnPositive().setEnabled(false);
    }

    public void refreshUI() {
        stopTimerTask();
    }

    public void stopTimerTask() {
        Timer r0 = mTimer;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    private void processClickEvent(int r3) {
        TimerCallback r2 = this.mCallback;
        if (r2 != null) goto L5;
        return;
    L5:
        switch(r3) {
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L19;
        };
    L7:
        r2.onStartTiming(7200000);
        return;
    L8:
        r2.onStartTiming(5400000);
        return;
    L9:
        r2.onStartTiming(3600000);
        return;
    L10:
        r2.onStartTiming(1800000);
        return;
    L11:
        r2.onStartTiming(900000);
        return;
    L12:
        r2.onStopTiming();
        return;
    }

    @Override // com.android.settings.bluetooth.BluetoothNumberPicker.OnValueChangeListener
    public void onValueChange(BluetoothNumberPicker r1, int r2, int r3) {
        if (this.mIsCountdowning == false) goto L6;
        if (r3 != 1) goto L6;
        this.mCompleteBtn.setEnabled(false);
        return;
    L6:
        this.mCompleteBtn.setEnabled(true);
    }

    public boolean isShowing() {
        OInsetSheet r0 = this.mOInsetSheet;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isShowing();
    }

    public void dismiss() {
        OInsetSheet r0 = this.mOInsetSheet;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }
}
