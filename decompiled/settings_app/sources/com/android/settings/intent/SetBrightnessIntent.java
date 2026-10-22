package com.android.settings.intent;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Parcelable;
import android.os.PowerManager;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.settings.R;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemSetBrightnessIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemSetBrightnessParams;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public class SetBrightnessIntent extends BaseSystemSetBrightnessIntent {
    private final String TAG;

    public SetBrightnessIntent() {
        this.TAG = "SetBrightnessIntent";
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSetBrightnessIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((SystemSetBrightnessParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSetBrightnessIntent
    public Object doAction(SystemSetBrightnessParams r9, DispatchContext r10, Continuation<? super IntentResult<Empty>> r11) {
        OLog.d("SetBrightnessIntent", "enter SetBrightnessIntent doAction");
        IntentResult r8 = new IntentResult();
        Context r0 = r10.getContext();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L7;
        OLog.d("SetBrightnessIntent", "start privacy activity");
        PrivacyIntentHelper.getInstance().openPrivacyActivity(r10);
        r8.setRet(201);
        return r8;
    L7:
        if (r9.getLevel() != null) goto L10;
        r8.setDetails(r0.getResources().getString(R.string.set_brightness_ask));
        r8.setInquireFurther(true);
        r8.setRet(0);
        return r8;
    L10:
        int r12 = r9.getLevel().intValue();
        if (r12 >= 0) goto L14;
        r12 = 0;
    L14:
        if (r12 <= 100) goto L16;
        r12 = 100;
    L16:
        PowerManager r13 = (PowerManager) r0.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        int r3 = r13.getMultiBitMinimumScreenBrightnessSetting();
        int r14 = r13.getMultiBitMaximumScreenBrightnessSetting();
        int r4 = (int) (r3 + ((r14 - r3) * (r12 / 100.0f)));
        OLog.d("SetBrightnessIntent", "set brightness: " + r4);
        float r15 = BrightnessSynchronizer.multiBitBrightnessIntToFloatForNormal(r0, r4, r3, r14);
        DisplayManager r16 = (DisplayManager) r0.getSystemService(DisplayManager.class);
        r16.setTemporaryBrightness(0, r15);
        r16.startSetTemporaryBrightness(0, false, r15);
        r8.setDetails(r0.getResources().getString(R.string.set_brightness_success, new Object[]{String.valueOf(r12)}));
        r8.setRet(0);
        return r8;
    }
}
