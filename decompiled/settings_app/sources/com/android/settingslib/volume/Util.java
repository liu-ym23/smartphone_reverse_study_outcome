package com.android.settingslib.volume;

import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import com.android.settings.MultiSimAdapter;
import com.android.settings.utils.HanziToPinyin;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Util {
    private static final int[] AUDIO_MANAGER_FLAGS = null;
    private static final String[] AUDIO_MANAGER_FLAG_NAMES = null;

    public Util() {
    }

    static {
        AUDIO_MANAGER_FLAGS = new int[]{1, 16, 4, 2, 8, 2048, 128, 4096, 1024};
        AUDIO_MANAGER_FLAG_NAMES = new String[]{"SHOW_UI", "VIBRATE", "PLAY_SOUND", "ALLOW_RINGER_MODES", "REMOVE_SOUND_AND_VIBRATE", "SHOW_VIBRATE_HINT", "SHOW_SILENT_HINT", "FROM_KEY", "SHOW_UI_WARNINGS"};
    }

    public static String logTag(Class<?> r2) {
        String r3 = "vol." + r2.getSimpleName();
        if (r3.length() >= 23) goto L6;
        return r3;
    L6:
        return r3.substring(0, 23);
    }

    public static String mediaMetadataToString(MediaMetadata r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getDescription().toString();
    }

    public static String playbackInfoToString(MediaController.PlaybackInfo r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return String.format("PlaybackInfo[vol=%s,max=%s,type=%s,vc=%s],atts=%s", new Object[]{Integer.valueOf(r5.getCurrentVolume()), Integer.valueOf(r5.getMaxVolume()), playbackInfoTypeToString(r5.getPlaybackType()), volumeProviderControlToString(r5.getVolumeControl()), r5.getAudioAttributes()});
    }

    public static String playbackInfoTypeToString(int r2) {
        if (r2 != 1) goto L5;
        return "LOCAL";
    L5:
        if (r2 != 2) goto L7;
        return "REMOTE";
    L7:
        return "UNKNOWN_" + r2;
    }

    public static String playbackStateStateToString(int r2) {
        if (r2 != 0) goto L4;
        return "STATE_NONE";
    L4:
        if (r2 != 1) goto L6;
        return "STATE_STOPPED";
    L6:
        if (r2 != 2) goto L8;
        return "STATE_PAUSED";
    L8:
        if (r2 != 3) goto L10;
        return "STATE_PLAYING";
    L10:
        return "UNKNOWN_" + r2;
    }

    public static String volumeProviderControlToString(int r2) {
        if (r2 != 0) goto L4;
        return "VOLUME_CONTROL_FIXED";
    L4:
        if (r2 != 1) goto L6;
        return "VOLUME_CONTROL_RELATIVE";
    L6:
        if (r2 != 2) goto L8;
        return "VOLUME_CONTROL_ABSOLUTE";
    L8:
        return "VOLUME_CONTROL_UNKNOWN_" + r2;
    }

    public static String playbackStateToString(PlaybackState r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return playbackStateStateToString(r2.getState()) + HanziToPinyin.Token.SEPARATOR + r2;
    }

    public static String audioManagerFlagsToString(int r2) {
        return bitFieldToString(r2, AUDIO_MANAGER_FLAGS, AUDIO_MANAGER_FLAG_NAMES);
    }

    protected static String bitFieldToString(int r4, int[] r5, String[] r6) {
        if (r4 != 0) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L7:
        if (r1 >= r5.length) goto L15;
        if ((r5[r1] & r4) == 0) goto L14;
        if (r0.length() <= 0) goto L13;
        r0.append(',');
    L13:
        r0.append(r6[r1]);
    L14:
        r4 = r4 & (~r5[r1]);
        r1 = r1 + 1;
        goto L7
    L15:
        if (r4 == 0) goto L21;
        if (r0.length() <= 0) goto L19;
        r0.append(',');
    L19:
        r0.append("UNKNOWN_").append(r4);
    L21:
        return r0.toString();
    }

    private static CharSequence emptyToNull(CharSequence r1) {
        if (r1 != null) goto L4;
    L5:
        return null;
    L4:
        if (r1.length() == 0) goto L5;
        return r1;
    }

    public static boolean setText(TextView r2, CharSequence r3) {
        if (Objects.equals(emptyToNull(r2.getText()), emptyToNull(r3)) == false) goto L6;
        return false;
    L6:
        r2.setText(r3);
        return true;
    }

    public static boolean isVoiceCapable(Context r1) {
        TelephonyManager r2 = (TelephonyManager) r1.getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.isVoiceCapable() == false) goto L7;
        return true;
    }
}
