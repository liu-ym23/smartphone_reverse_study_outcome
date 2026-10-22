package com.android.settings.intent;

import android.content.Context;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.SystemClock;
import com.android.settings.R;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemPowerLockControlIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemPowerLockControlParams;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public class PowerLockControlIntent extends BaseSystemPowerLockControlIntent {
    private final String LOCK;
    private final String TAG;
    private IntentResult mResult;

    public PowerLockControlIntent() {
        this.TAG = "PowerLockControlIntent";
        this.LOCK = "lock";
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemPowerLockControlIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((SystemPowerLockControlParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemPowerLockControlIntent
    public Object doAction(SystemPowerLockControlParams r3, DispatchContext r4, Continuation<? super IntentResult<Empty>> r5) {
        OLog.d("PowerLockControlIntent", "enter PowerLockControlIntent doAction");
        Context r6 = r4.getContext();
        this.mResult = new IntentResult();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L7;
        OLog.d("PowerLockControlIntent", "start privacy activity");
        PrivacyIntentHelper.getInstance().openPrivacyActivity(r4);
        this.mResult.setRet(201);
        return this.mResult;
    L7:
        if (r3.getAction() != null) goto L10;
        this.mResult.setRet(103);
        OLog.e("PowerLockControlIntent", "params action is null");
        return this.mResult;
    L10:
        String r7 = r3.getAction();
        r7.hashCode();
        if (r7.equals("lock") == true) goto L13;
        OLog.e("PowerLockControlIntent", "SystemPowerLockControlParams action: " + r3.getAction() + " is error.");
    L15:
        return this.mResult;
    L13:
        lockScreen(r6);
        goto L15
    }

    private void lockScreen(Context r5) {
        OLog.d("PowerLockControlIntent", "start lockScreen");
        ((PowerManager) r5.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).goToSleep(SystemClock.uptimeMillis());
        String r6 = r5.getString(R.string.power_lock_tips);
        OLog.d("PowerLockControlIntent", "lockScreen, resultDetails is " + r6);
        this.mResult.setDetails(r6);
        this.mResult.setRet(0);
    }
}
