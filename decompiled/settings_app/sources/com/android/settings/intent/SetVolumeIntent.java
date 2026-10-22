package com.android.settings.intent;

import android.content.Context;
import android.media.AudioManager;
import android.os.Parcelable;
import com.android.settings.R;
import com.android.vcard.VCardConstants;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemSetVolumeIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemSetVolumeParams;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public class SetVolumeIntent extends BaseSystemSetVolumeIntent {
    private final String TAG;
    private final String TYPE_ALARM;
    private final String TYPE_ASSISTANT;
    private final String TYPE_MUSIC;
    private final String TYPE_NOTIFICATION;
    private final String TYPE_RING;
    private final String TYPE_VOICE_CALL;

    public SetVolumeIntent() {
        this.TAG = "SetVolumeIntent";
        this.TYPE_MUSIC = "MUSIC";
        this.TYPE_VOICE_CALL = "VOICE_CALL";
        this.TYPE_RING = "RING";
        this.TYPE_NOTIFICATION = "NOTIFICATION";
        this.TYPE_ALARM = "ALARM";
        this.TYPE_ASSISTANT = VCardConstants.PARAM_PHONE_EXTRA_TYPE_ASSISTANT;
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSetVolumeIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((SystemSetVolumeParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSetVolumeIntent
    public Object doAction(SystemSetVolumeParams r19, DispatchContext r20, Continuation<? super IntentResult<Empty>> r21) {
        OLog.d("SetVolumeIntent", "enter SetVolumeIntent doAction");
        Context r0 = r20.getContext();
        IntentResult r2 = new IntentResult();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L7;
        OLog.d("SetVolumeIntent", "start privacy activity");
        PrivacyIntentHelper.getInstance().openPrivacyActivity(r20);
        r2.setRet(201);
        return r2;
    L7:
        if (r19.getLevel() != null) goto L11;
        r2.setDetails(r0.getResources().getString(R.string.set_volume_ask));
        r2.setInquireFurther(true);
        r2.setRet(0);
        return r2;
    L11:
        if (r19.getType() != null) goto L13;
        String r3 = "MUSIC";
    L14:
        AudioManager r7 = (AudioManager) r0.getSystemService("audio");
        if (r3.equals("NOTIFICATION") == true) goto L17;
    L20:
        HashMap r9 = new HashMap();
        r9.put("MUSIC", 3);
        if (r7.isBluetoothScoOn() == false) goto L23;
        r9.put("VOICE_CALL", 6);
    L24:
        r9.put("RING", 2);
        r9.put("NOTIFICATION", 5);
        r9.put("ALARM", 4);
        r9.put(VCardConstants.PARAM_PHONE_EXTRA_TYPE_ASSISTANT, 11);
        int r10 = ((Integer) r9.get(r3)).intValue();
        int r11 = r7.getStreamMaxVolume(r10);
        int r12 = r7.getStreamMinVolumeInt(r10);
        int r16 = r19.getLevel().intValue();
        int r4 = (((r11 - r12) * r16) / 100) + r12;
        if (r4 < r12) goto L28;
        r12 = r4;
    L28:
        if (r12 > r11) goto L31;
        r11 = r12;
    L31:
        OLog.d("SetVolumeIntent", "set stream: " + r10 + " volume :" + r11);
        boolean r1 = r7.isStreamMute(r10);
        if (r1 == false) goto L35;
        if (r11 <= 0) goto L35;
        r7.adjustStreamVolume(r10, 100, 0);
    L38:
        r7.setStreamVolume(r10, r11, 1);
        r3.hashCode();
        switch(r3.hashCode()) {
            case -1382453013: goto L62;
            case -1000727189: goto L58;
            case -78544194: goto L54;
            case 2515504: goto L50;
            case 62358065: goto L46;
            case 73725445: goto L42;
            default: goto L40;
        };
    L40:
        byte r13 = -1;
    L65:
        switch(r13) {
            case 0: goto L72;
            case 1: goto L71;
            case 2: goto L70;
            case 3: goto L69;
            case 4: goto L68;
            case 5: goto L67;
            default: goto L66;
        };
    L66:
        String r5 = "";
    L73:
        r2.setDetails(r0.getResources().getString(R.string.set_volume_success, new Object[]{r5, String.valueOf(r16)}));
        r2.setRet(0);
        return r2;
    L67:
        r5 = r0.getString(R.string.media_volume_type);
        goto L73
    L68:
        r5 = r0.getString(R.string.alarm_volume_type);
        goto L73
    L69:
        r5 = r0.getString(R.string.ring_volume_type);
        goto L73
    L70:
        r5 = r0.getString(R.string.assistant_volume_type);
        goto L73
    L71:
        r5 = r0.getString(R.string.call_volume_type);
        goto L73
    L72:
        r5 = r0.getString(R.string.notification_volume_type);
        goto L73
    L42:
        if (r3.equals("MUSIC") == false) goto L75;
        r13 = 5;
        goto L65
    L75:
        r13 = -1;
        goto L65
    L46:
        if (r3.equals("ALARM") == false) goto L76;
        r13 = 4;
        goto L65
    L76:
        r13 = -1;
        goto L65
    L50:
        if (r3.equals("RING") == false) goto L77;
        r13 = 3;
        goto L65
    L77:
        r13 = -1;
        goto L65
    L54:
        if (r3.equals(VCardConstants.PARAM_PHONE_EXTRA_TYPE_ASSISTANT) == false) goto L78;
        r13 = 2;
        goto L65
    L78:
        r13 = -1;
        goto L65
    L58:
        if (r3.equals("VOICE_CALL") == false) goto L79;
        r13 = 1;
        goto L65
    L79:
        r13 = -1;
        goto L65
    L62:
        if (r3.equals("NOTIFICATION") == false) goto L80;
        r13 = 0;
        goto L65
    L80:
        r13 = -1;
    L35:
        if (r1 == true) goto L38;
        if (r11 != 0) goto L38;
        r7.adjustStreamVolume(r10, -100, 0);
        goto L38
    L23:
        r9.put("VOICE_CALL", 0);
        goto L24
    L17:
        if (r7.getRingerModeInternal() == 2) goto L20;
        r2.setDetails(r0.getResources().getString(R.string.adjust_notification_volume_no_supported_in_silent));
        r2.setRet(1);
        return r2;
    L13:
        r3 = r19.getType();
        goto L14
    }
}
