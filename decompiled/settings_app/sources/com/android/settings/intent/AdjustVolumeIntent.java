package com.android.settings.intent;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Parcelable;
import com.android.settings.R;
import com.android.vcard.VCardConstants;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemAdjustVolumeIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemAdjustVolumeParams;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public class AdjustVolumeIntent extends BaseSystemAdjustVolumeIntent {
    private final int ORIGIN_MAX_VOLUME;
    private final String TAG;
    private final String TYPE_ALARM;
    private final String TYPE_ASSISTANT;
    private final String TYPE_MUSIC;
    private final String TYPE_NOTIFICATION;
    private final String TYPE_RING;
    private final String TYPE_VOICE_CALL;
    private final String VOLUME_DOWN;
    private final String VOLUME_UP;

    public AdjustVolumeIntent() {
        this.TAG = "AdjustVolumeIntent";
        this.TYPE_MUSIC = "MUSIC";
        this.TYPE_VOICE_CALL = "VOICE_CALL";
        this.TYPE_RING = "RING";
        this.TYPE_NOTIFICATION = "NOTIFICATION";
        this.TYPE_ALARM = "ALARM";
        this.TYPE_ASSISTANT = VCardConstants.PARAM_PHONE_EXTRA_TYPE_ASSISTANT;
        this.VOLUME_UP = "UP";
        this.VOLUME_DOWN = "DOWN";
        this.ORIGIN_MAX_VOLUME = 15;
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemAdjustVolumeIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((SystemAdjustVolumeParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemAdjustVolumeIntent
    public Object doAction(SystemAdjustVolumeParams r18, DispatchContext r19, Continuation<? super IntentResult<Empty>> r20) {
        OLog.d("AdjustVolumeIntent", "enter AdjustVolumeIntent doAction");
        Context r0 = r19.getContext();
        IntentResult r2 = new IntentResult();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L7;
        OLog.d("AdjustVolumeIntent", "start privacy activity");
        PrivacyIntentHelper.getInstance().openPrivacyActivity(r19);
        r2.setRet(201);
        return r2;
    L7:
        if (r18.getDirection() != null) goto L11;
        r2.setDetails(r0.getResources().getString(R.string.adjust_volume_ask));
        r2.setInquireFurther(true);
        r2.setRet(0);
        return r2;
    L11:
        if (r18.getType() != null) goto L13;
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
        r3.hashCode();
        switch(r3.hashCode()) {
            case -1382453013: goto L48;
            case -1000727189: goto L44;
            case -78544194: goto L40;
            case 2515504: goto L36;
            case 62358065: goto L32;
            case 73725445: goto L28;
            default: goto L26;
        };
    L26:
        byte r12 = -1;
    L51:
        switch(r12) {
            case 0: goto L58;
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L55;
            case 4: goto L54;
            case 5: goto L53;
            default: goto L52;
        };
    L52:
        String r6 = "";
    L59:
        int r4 = ((Integer) r9.get(r3)).intValue();
        int r8 = r7.getStreamMaxVolume(r4);
        int r10 = r7.getStreamMinVolumeInt(r4);
        int r11 = r7.getStreamVolume(r4);
        if (r11 > r10) goto L66;
        if (r18.getDirection().equals("DOWN") == false) goto L66;
        r2.setDetails(r0.getResources().getString(R.string.adjust_volume_failed_min, new Object[]{r6}));
        r2.setRet(0);
        return r2;
    L66:
        if (r11 >= r8) goto L68;
    L71:
        int r14 = getAdjustVolumeStep(r8);
        if (r18.getDirection().equals("UP") == false) goto L75;
        int r13 = r11 + r14;
    L77:
        if (r13 < r10) goto L80;
        r10 = r13;
    L80:
        if (r10 <= r8) goto L82;
        r10 = r8;
    L82:
        OLog.d("AdjustVolumeIntent", "set stream: " + r4 + " volume :" + r10);
        boolean r1 = r7.isStreamMute(r4);
        if (r1 == false) goto L86;
        if (r10 <= 0) goto L86;
        r7.adjustStreamVolume(r4, 100, 0);
    L89:
        r7.setStreamVolume(r4, r10, 1);
        int r15 = (r10 * 100) / (r8 - 0);
        Resources r5 = r0.getResources();
        Object[] r16 = new Object[3];
        if (r18.getDirection().equals("UP") == false) goto L92;
        int r17 = R.string.adjust_volume_direction_up;
    L93:
        r16[0] = r0.getString(r17);
        r16[1] = r6;
        r16[2] = String.valueOf(r15);
        r2.setDetails(r5.getString(R.string.adjust_volume_success, r16));
        r2.setRet(0);
        return r2;
    L92:
        r17 = R.string.adjust_volume_direction_down;
    L86:
        if (r1 == true) goto L89;
        if (r10 != 0) goto L89;
        r7.adjustStreamVolume(r4, -100, 0);
        goto L89
    L75:
        if (r18.getDirection().equals("DOWN") == false) goto L95;
        r13 = r11 - r14;
        goto L77
    L95:
        r2.setRet(103);
        OLog.e("AdjustVolumeIntent", "direction params is error:" + r18.getDirection());
        return r2;
    L68:
        if (r18.getDirection().equals("UP") == false) goto L71;
        r2.setDetails(r0.getResources().getString(R.string.adjust_volume_failed_max, new Object[]{r6}));
        r2.setRet(0);
        return r2;
    L53:
        r6 = r0.getString(R.string.media_volume_type);
        goto L59
    L54:
        r6 = r0.getString(R.string.alarm_volume_type);
        goto L59
    L55:
        r6 = r0.getString(R.string.ring_volume_type);
        goto L59
    L56:
        r6 = r0.getString(R.string.assistant_volume_type);
        goto L59
    L57:
        r6 = r0.getString(R.string.call_volume_type);
        goto L59
    L58:
        r6 = r0.getString(R.string.notification_volume_type);
        goto L59
    L28:
        if (r3.equals("MUSIC") == false) goto L97;
        r12 = 5;
        goto L51
    L97:
        r12 = -1;
        goto L51
    L32:
        if (r3.equals("ALARM") == false) goto L98;
        r12 = 4;
        goto L51
    L98:
        r12 = -1;
        goto L51
    L36:
        if (r3.equals("RING") == false) goto L99;
        r12 = 3;
        goto L51
    L99:
        r12 = -1;
        goto L51
    L40:
        if (r3.equals(VCardConstants.PARAM_PHONE_EXTRA_TYPE_ASSISTANT) == false) goto L100;
        r12 = 2;
        goto L51
    L100:
        r12 = -1;
        goto L51
    L44:
        if (r3.equals("VOICE_CALL") == false) goto L101;
        r12 = 1;
        goto L51
    L101:
        r12 = -1;
        goto L51
    L48:
        if (r3.equals("NOTIFICATION") == false) goto L102;
        r12 = 0;
        goto L51
    L102:
        r12 = -1;
        goto L51
    L23:
        r9.put("VOICE_CALL", 0);
        goto L24
    L17:
        if (r7.getRingerModeInternal() == 2) goto L20;
        r2.setDetails(r0.getResources().getString(R.string.adjust_notification_volume_no_supported_in_silent));
        r2.setRet(1);
        return r2;
    L13:
        r3 = r18.getType();
        goto L14
    }

    private int getAdjustVolumeStep(int r1) {
        return r1 / 15;
    }
}
