package com.android.settings.intent;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Parcelable;
import android.os.PowerManager;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.settings.AdaptUtils;
import com.android.settings.R;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemAdjustBrightnessIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemAdjustBrightnessParams;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public class AdjustBrightnessIntent extends BaseSystemAdjustBrightnessIntent {
    private final String BRIGHTNESS_DOWN;
    private final String BRIGHTNESS_UP;
    private final String TAG;

    public AdjustBrightnessIntent() {
        this.TAG = "AdjustBrightnessIntent";
        this.BRIGHTNESS_UP = "UP";
        this.BRIGHTNESS_DOWN = "DOWN";
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemAdjustBrightnessIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((SystemAdjustBrightnessParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemAdjustBrightnessIntent
    public Object doAction(SystemAdjustBrightnessParams r10, DispatchContext r11, Continuation<? super IntentResult<Empty>> r12) {
        OLog.d("AdjustBrightnessIntent", "enter AdjustBrightnessIntent doAction");
        Context r9 = r11.getContext();
        IntentResult r0 = new IntentResult();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L7;
        OLog.d("AdjustBrightnessIntent", "start privacy activity");
        PrivacyIntentHelper.getInstance().openPrivacyActivity(r11);
        r0.setRet(201);
        return r0;
    L7:
        if (r10.getDirection() != null) goto L10;
        r0.setDetails(r9.getResources().getString(R.string.adjust_brightness_ask));
        r0.setInquireFurther(true);
        r0.setRet(0);
        return r0;
    L10:
        PowerManager r13 = (PowerManager) r9.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        int r3 = r13.getMultiBitMinimumScreenBrightnessSetting();
        int r14 = r13.getMultiBitMaximumScreenBrightnessSetting();
        int r4 = AdaptUtils.getBrightness(r9);
        int r6 = r14 - r3;
        int r5 = Math.round(((r4 - r3) * 100.0f) / r6);
        OLog.d("AdjustBrightnessIntent", "current level: " + r5 + " brightness: " + r4 + " min: " + r3 + " max: " + r14);
        if (r4 > r3) goto L17;
        if (r10.getDirection().equals("DOWN") == false) goto L17;
        r0.setDetails(r9.getResources().getString(R.string.brightness_already_min));
        r0.setRet(0);
        return r0;
    L17:
        if (r4 < r14) goto L23;
        if (r10.getDirection().equals("UP") == false) goto L23;
        r0.setDetails(r9.getResources().getString(R.string.brightness_already_max));
        r0.setRet(0);
        return r0;
    L23:
        if (r10.getDirection().equals("UP") == false) goto L26;
        int r7 = r5 + 10;
    L28:
        if (r7 >= 0) goto L31;
        r7 = 0;
    L31:
        if (r7 <= 100) goto L33;
        r7 = 100;
    L33:
        int r8 = ((r6 * r7) / 100) + r3;
        OLog.d("AdjustBrightnessIntent", "set level: " + r7 + " newBrightness: " + r8);
        float r15 = BrightnessSynchronizer.multiBitBrightnessIntToFloatForNormal(r9, r8, r3, r14);
        DisplayManager r16 = (DisplayManager) r9.getSystemService(DisplayManager.class);
        r16.setTemporaryBrightness(0, r15);
        r16.startSetTemporaryBrightness(0, false, r15);
        Resources r17 = r9.getResources();
        Object[] r18 = new Object[2];
        if (r10.getDirection().equals("UP") == false) goto L36;
        int r19 = R.string.adjust_brightness_direction_up;
    L37:
        r18[0] = r9.getString(r19);
        r18[1] = String.valueOf(r7);
        r0.setDetails(r17.getString(R.string.adjust_brightness_success, r18));
        r0.setRet(0);
        return r0;
    L36:
        r19 = R.string.adjust_brightness_direction_down;
        goto L37
    L26:
        if (r10.getDirection().equals("DOWN") == false) goto L39;
        r7 = r5 - 10;
        goto L28
    L39:
        r0.setRet(103);
        OLog.e("AdjustBrightnessIntent", "direction params is error:" + r10.getDirection());
        return r0;
    }
}
