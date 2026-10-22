package com.android.settings.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemSettingsAvailableIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemSettingsAvailableParams;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsAvailableIntent extends BaseSystemSettingsAvailableIntent {
    private final String TAG;

    public SettingsAvailableIntent() {
        this.TAG = "SettingsAvailableIntent";
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSettingsAvailableIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((SystemSettingsAvailableParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSettingsAvailableIntent
    public Object doAction(SystemSettingsAvailableParams r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        IntentResult r0 = new IntentResult();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L6;
        OLog.d("SettingsAvailableIntent", "privacy not allowed");
        PrivacyIntentHelper.getInstance().openPrivacyActivity(r2);
        r0.setRet(201);
        return r0;
    L6:
        OLog.d("SettingsAvailableIntent", "privacy allowed");
        r0.setRet(0);
        return r0;
    }
}
