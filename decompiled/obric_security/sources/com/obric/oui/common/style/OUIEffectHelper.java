package com.obric.oui.common.style;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.obric.common.oui.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class OUIEffectHelper {
    public static boolean DEBUG = false;
    private static final int DEF_HOVER_DUR = 5;
    private static final int DEF_HOVER_FRE = 177;
    private static final int DEF_HOVER_LEVEL = 33;
    private static final int DEF_PRESS_DUR = 15;
    private static final int DEF_PRESS_FRE = 127;
    private static final int DEF_PRESS_LEVEL = 204;
    private static final int DEVICE_ID_BASE = 100000;
    public static final int EFFECT_TYPE_HOVER = 0;
    public static final int EFFECT_TYPE_PRESS = 1;
    private static final String PHOENIX = "Phoenix";
    public static final String PVR_UI_CONFIG_NAME = "pvr_ui_config";
    private static final int STRONG_HOVER_DUR = 5;
    private static final int STRONG_HOVER_FRE = 88;
    private static final int STRONG_HOVER_LEVEL = 76;
    private static final int STRONG_PRESS_DUR = 8;
    private static final int STRONG_PRESS_FRE = 63;
    private static final int STRONG_PRESS_LEVEL = 204;
    public static final String SYSTEM_VIBRATION_ENABLED_NAME = "system_vibration_enabled";
    private static final String TAG = "OUIEffectHelper";
    public static final int VIBRATE_LEVEL_STANDARD = 0;
    public static final int VIBRATE_LEVEL_STRONG = 2;
    public static final int VIBRATE_LEVEL_WEAK = 1;
    public static final String VIBRATION_LEVEL_NAME = "controller_vibration_level";
    private static final int WEAK_HOVER_DUR = 6;
    private static final int WEAK_HOVER_FRE = 355;
    private static final int WEAK_HOVER_LEVEL = 38;
    private static final int WEAK_PRESS_DUR = 18;
    private static final int WEAK_PRESS_FRE = 255;
    private static final int WEAK_PRESS_LEVEL = 102;
    private static int mLastMotionEventDeviceId = 0;
    private static int sDefHoverDur = 5;
    private static int sDefHoverFre = 177;
    private static int sDefHoverLevel = 33;
    private static int sDefPressDur = 15;
    private static int sDefPressFre = 127;
    private static int sDefPressLevel = 204;
    public static String sDeviceType = null;
    private static boolean sInit = false;
    private static boolean sIsDeviceSoundAllowed = false;
    private static boolean sIsDeviceVibrateAllowed = false;
    private static HashMap<Integer, Pair<Integer, Integer>> sSoundMap = null;
    private static int sStrongHoverDur = 5;
    private static int sStrongHoverFre = 88;
    private static int sStrongHoverLevel = 76;
    private static int sStrongPressDur = 8;
    private static int sStrongPressFre = 63;
    private static int sStrongPressLevel = 204;
    private static boolean sSystemVibrateEnabled = false;
    private static TypedValue sTmpValue = null;
    private static int sVibrationLevel = 0;
    private static int sWeakHoverDur = 6;
    private static int sWeakHoverFre = 355;
    private static int sWeakHoverLevel = 38;
    private static int sWeakPressDur = 18;
    private static int sWeakPressFre = 255;
    private static int sWeakPressLevel = 102;
    private boolean mAppEffectEnabled;
    private boolean mHoveredVibrateEnabled;
    private boolean mSoundEffectEnabled;
    private final WeakReference<View> mTarget;
    private boolean mVibrateEnabled;

    public void onAttachedToWindow() {
    }

    public void onDetachedFromWindow() {
    }

    static {
        String r0 = getSystemProperties("ro.pvr.product.name", PHOENIX);
        sDeviceType = r0;
        sIsDeviceVibrateAllowed = PHOENIX.equals(r0);
        sIsDeviceSoundAllowed = PHOENIX.equals(sDeviceType);
        sVibrationLevel = 0;
        sSystemVibrateEnabled = true;
        mLastMotionEventDeviceId = -1;
        sSoundMap = new HashMap();
        DEBUG = false;
    }

    public OUIEffectHelper(View r2) {
        this.mHoveredVibrateEnabled = true;
        this.mVibrateEnabled = true;
        this.mSoundEffectEnabled = true;
        this.mTarget = new WeakReference(r2);
        this.mAppEffectEnabled = getAttrBoolean(r2.getContext(), R.attr.oui_effect_enabled);
    }

    public static void onVibrate(Context r2, int r3, int r4) {
        if (sIsDeviceVibrateAllowed == true) goto L5;
        return;
    L5:
        if (r4 >= DEVICE_ID_BASE) goto L8;
        return;
    L8:
        if (DEBUG == false) goto L11;
        Log.i(TAG, "onVibrate: effectType=" + r3 + ", deviceId=" + r4);
    L11:
        if (r4 != 100001) goto L14;
    L15:
        getVibrationData(r2, r3, new int[3]);
        return;
    L14:
        if (r4 == 100002) goto L15;
    }

    public static void playSoundEffect(Context r4, int r5, int r6) {
        if (sIsDeviceSoundAllowed == true) goto L5;
        return;
    L5:
        if (r6 < DEVICE_ID_BASE) goto L26;
        Pair<Integer, Integer> r0 = sSoundMap.get(Integer.valueOf(r6));
        AudioManager r7 = (AudioManager) r4.getSystemService("audio");
        if (r0 != null) goto L14;
        if (DEBUG == false) goto L24;
        Log.i(TAG, "playSoundEffect: pair is empty");
        return;
    L24:
        return;
    L14:
        if (DEBUG == false) goto L16;
        Log.i(TAG, "playSoundEffect: effectType=" + r5 + ", deviceId=" + r6);
    L16:
        if (r5 != 0) goto L19;
        int r8 = ((Integer) r0.first).intValue();
    L22:
        r7.playSoundEffect(r8, 1.0f);
        return;
    L19:
        if (r5 != 1) goto L21;
        r8 = ((Integer) r0.second).intValue();
        goto L22
    L21:
        r8 = 10;
        goto L22
    }

    private void applyEffects(boolean r3) {
        if (this.mTarget.get() == null) goto L13;
        int r4 = !r3 ? 1 : 0;
        if (sSystemVibrateEnabled == false) goto L10;
        if (this.mVibrateEnabled == false) goto L10;
        onVibrate(this.mTarget.get().getContext(), r4, mLastMotionEventDeviceId);
    L10:
        if (this.mSoundEffectEnabled == false) goto L14;
        playSoundEffect(this.mTarget.get().getContext(), r4, mLastMotionEventDeviceId);
        return;
    L14:
        return;
    }

    private static void getVibrationData(Context r3, int r4, int[] r5) {
        int r6 = sVibrationLevel;
        if (r6 != 2) goto L8;
        if (r4 != 0) goto L6;
        r5[0] = sStrongHoverLevel;
        r5[1] = sStrongHoverFre;
        r5[2] = sStrongHoverDur;
        return;
    L6:
        if (r4 != 1) goto L19;
        r5[0] = sStrongPressLevel;
        r5[1] = sStrongPressFre;
        r5[2] = sStrongPressDur;
        return;
    L19:
        return;
    L8:
        if (r6 != 1) goto L13;
        if (r4 != 0) goto L11;
        r5[0] = sWeakHoverLevel;
        r5[1] = sWeakHoverFre;
        r5[2] = sWeakHoverDur;
        return;
    L11:
        if (r4 != 1) goto L22;
        r5[0] = sWeakPressLevel;
        r5[1] = sWeakPressFre;
        r5[2] = sWeakPressDur;
        return;
    L22:
        return;
    L13:
        if (r4 != 0) goto L15;
        r5[0] = sDefHoverLevel;
        r5[1] = sDefHoverFre;
        r5[2] = sDefHoverDur;
        return;
    L15:
        if (r4 != 1) goto L25;
        r5[0] = sDefPressLevel;
        r5[1] = sDefPressFre;
        r5[2] = sDefPressDur;
        return;
    }

    public void onHoverChanged(boolean r2) {
        if (this.mAppEffectEnabled == true) goto L5;
        return;
    L5:
        if (r2 == true) goto L7;
        return;
    L7:
        if (this.mHoveredVibrateEnabled == false) goto L11;
        applyEffects(true);
        return;
    }

    public void setPressed(boolean r4) {
        if (this.mAppEffectEnabled == true) goto L5;
        return;
    L5:
        View r0 = this.mTarget.get();
        if (r0 != null) goto L9;
        return;
    L9:
        if ((r0.isPressed() ^ r4) == false) goto L14;
        if (r4 == false) goto L12;
        applyEffects(false);
        this.mHoveredVibrateEnabled = false;
        return;
    L12:
        r0.postDelayed(new OUIEffectHelper$$ExternalSyntheticLambda0(this), 20);
        return;
    }

    /* JADX INFO: renamed from: lambda$setPressed$0$com-obric-oui-common-style-OUIEffectHelper, reason: not valid java name */
    /* synthetic */ void m240lambda$setPressed$0$comobricouicommonstyleOUIEffectHelper() {
        this.mHoveredVibrateEnabled = true;
    }

    public void setVibrateEnabled(boolean r1) {
        this.mVibrateEnabled = r1;
    }

    public void setSoundEffectEnabled(boolean r1) {
        this.mSoundEffectEnabled = r1;
    }

    public void dispatchGenericMotionEvent(MotionEvent r1) {
        updateDeviceId(r1);
    }

    public void dispatchTouchEvent(MotionEvent r1) {
        updateDeviceId(r1);
    }

    private void updateDeviceId(MotionEvent r1) {
        if (this.mAppEffectEnabled == true) goto L5;
        return;
    L5:
        mLastMotionEventDeviceId = r1.getDeviceId();
    }

    public void onWindowShow() {
        if (this.mAppEffectEnabled == true) goto L5;
        return;
    L5:
        View r0 = this.mTarget.get();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.getContext() != null) goto L10;
        return;
    L10:
        if (sInit == true) goto L19;
        sInit = true;
        updateConfig(r0.getContext());
        if (DEBUG == false) goto L18;
        Log.i(TAG, "onWindowShow: mAppEffectEnabled=" + this.mAppEffectEnabled);
        return;
    L18:
        return;
    }

    public static void updateConfig(Context r12) {
        sSoundMap.clear();
        sVibrationLevel = Settings.Global.getInt(r12.getContentResolver(), VIBRATION_LEVEL_NAME, 0);
        if (Settings.Global.getInt(r12.getContentResolver(), SYSTEM_VIBRATION_ENABLED_NAME, 1) != 1) goto L5;
        boolean r2 = true;
    L6:
        sSystemVibrateEnabled = r2;
        String r13 = Settings.Global.getString(r12.getContentResolver(), PVR_UI_CONFIG_NAME);
        if (TextUtils.isEmpty(r13) == true) goto L46;
        JSONObject r3 = new JSONObject(r13);     // Catch: JSONException -> L41
        JSONObject r6 = r3.getJSONObject("vibration");     // Catch: JSONException -> L13
        sDefHoverFre = getJSONObjectInt(r6, "def_hover_fre");     // Catch: JSONException -> L13
        sDefHoverLevel = getJSONObjectInt(r6, "def_hover_level");     // Catch: JSONException -> L13
        sDefHoverDur = getJSONObjectInt(r6, "def_hover_dur");     // Catch: JSONException -> L13
        sDefPressFre = getJSONObjectInt(r6, "def_press_fre");     // Catch: JSONException -> L13
        sDefPressLevel = getJSONObjectInt(r6, "def_press_level");     // Catch: JSONException -> L13
        sDefPressDur = getJSONObjectInt(r6, "def_press_dur");     // Catch: JSONException -> L13
        sWeakHoverFre = getJSONObjectInt(r6, "weak_hover_fre");     // Catch: JSONException -> L13
        sWeakHoverLevel = getJSONObjectInt(r6, "weak_hover_level");     // Catch: JSONException -> L13
        sWeakHoverDur = getJSONObjectInt(r6, "weak_hover_dur");     // Catch: JSONException -> L13
        sWeakPressFre = getJSONObjectInt(r6, "weak_press_fre");     // Catch: JSONException -> L13
        sWeakPressLevel = getJSONObjectInt(r6, "weak_press_level");     // Catch: JSONException -> L13
        sWeakPressDur = getJSONObjectInt(r6, "weak_press_dur");     // Catch: JSONException -> L13
        sStrongHoverFre = getJSONObjectInt(r6, "strong_hover_fre");     // Catch: JSONException -> L13
        sStrongHoverLevel = getJSONObjectInt(r6, "strong_hover_level");     // Catch: JSONException -> L13
        sStrongHoverDur = getJSONObjectInt(r6, "strong_hover_dur");     // Catch: JSONException -> L13
        sStrongPressFre = getJSONObjectInt(r6, "strong_press_fre");     // Catch: JSONException -> L13
        sStrongPressLevel = getJSONObjectInt(r6, "strong_press_level");     // Catch: JSONException -> L13
        sStrongPressDur = getJSONObjectInt(r6, "strong_press_dur");     // Catch: JSONException -> L13
        String r7 = getJSONObjectString(r6, "device_allowed");     // Catch: JSONException -> L13
        DEBUG = getJSONObjectBoolean(r6, "debug");     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r7) == true) goto L50;
        sIsDeviceVibrateAllowed = isDeviceAllowed(r7);     // Catch: JSONException -> L13
    L50:
        JSONObject r1 = r3.getJSONObject("sound");     // Catch: JSONException -> L36
        String r0 = getJSONObjectString(r1, "device_allowed");     // Catch: JSONException -> L36
        if (TextUtils.isEmpty(r0) == true) goto L20;
        sIsDeviceSoundAllowed = isDeviceAllowed(r0);     // Catch: JSONException -> L36
    L20:
        String r4 = getJSONObjectString(r1, "device_id_effect_type");     // Catch: JSONException -> L36
        if (TextUtils.isEmpty(r4) == true) goto L46;
        String[] r5 = r4.split(";");     // Catch: JSONException -> L36
        if (r5.length <= 0) goto L46;
        int r8 = r5.length;     // Catch: JSONException -> L36
        int r9 = 0;
    L25:
        if (r9 >= r8) goto L46;
        String[] r10 = r5[r9].split(",");     // Catch: JSONException -> L36
    L28:
        if (r10.length != 3) goto L35;
        sSoundMap.put(Integer.valueOf(Integer.parseInt(r10[0])), new Pair(Integer.valueOf(Integer.parseInt(r10[1])), Integer.valueOf(Integer.parseInt(r10[2]))));     // Catch: Exception -> L31 JSONException -> L36
    L31:
        e = move-exception;
        if (DEBUG == false) goto L35;
        Log.e(TAG, "onWindowShow: parse vibration device_id_effect_type error=" + e);     // Catch: JSONException -> L36
    L35:
        r9 = r9 + 1;
    L36:
        e = move-exception;
        if (DEBUG == false) goto L46;
        Log.e(TAG, "onWindowShow: parse sound error=" + e);     // Catch: JSONException -> L41
    L13:
        e = move-exception;
        if (DEBUG == false) goto L50;
        Log.e(TAG, "onWindowShow: parse vibration error=" + e);     // Catch: JSONException -> L41
    L41:
        e = move-exception;
        if (DEBUG == false) goto L46;
        Log.e(TAG, "onWindowShow: parse uiConfig error=" + e);
    L46:
        if (DEBUG == false) goto L61;
        Log.i(TAG, "updateConfig: " + r13 + ", sIsDeviceVibrateAllowed=" + sIsDeviceVibrateAllowed + ", sIsDeviceSoundAllowed=" + sIsDeviceSoundAllowed + ", sDeviceType=" + sDeviceType);
        return;
    L61:
        return;
    L5:
        r2 = false;
        goto L6
    }

    private static int getJSONObjectInt(JSONObject r0, String r1) {
        return r0.getInt(r1);
    L4:
        return -1;
    }

    private static boolean getJSONObjectBoolean(JSONObject r0, String r1) {
        return r0.getBoolean(r1);
    L4:
        return false;
    }

    private static String getJSONObjectString(JSONObject r0, String r1) {
        return r0.getString(r1);
    L4:
        return "";
    }

    private static boolean isDeviceAllowed(String r5) {
        String[] r6 = r5.split(",");
        if (r6.length <= 0) goto L11;
        int r0 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        if (sDeviceType.equals(r6[r2]) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public void onWindowHide() {
        if (this.mAppEffectEnabled == true) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        Log.i(TAG, "onWindowHide: ");
    L8:
        sInit = false;
    }

    public static String getSystemProperties(String r7, String r8) {
        String r9 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r7, r8});     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r9) == false) goto L6;
        return r8;
    L6:
        return r9;
    L11:
        return r8;
    }

    public void onWindowVisibilityChanged(int r1) {
        if (r1 != 0) goto L4;
        onWindowShow();
        return;
    L4:
        onWindowHide();
    }

    private static boolean getAttrBoolean(Context r2, int r3) {
        if (sTmpValue != null) goto L5;
        sTmpValue = new TypedValue();
    L5:
        r2.getTheme().resolveAttribute(r3, sTmpValue, true);
        if (sTmpValue.data != 0) goto L10;
        return false;
    L10:
        return true;
    }
}
