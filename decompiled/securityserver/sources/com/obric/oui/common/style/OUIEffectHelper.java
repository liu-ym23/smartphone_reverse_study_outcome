package com.obric.oui.common.style;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.securityserver.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class OUIEffectHelper {
    public static boolean f = false;
    public static final String g = null;
    public static boolean h;
    public static boolean i;
    public static boolean j;
    public static int k;
    public static final HashMap l = null;
    public static boolean m;
    public static TypedValue n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f196a;
    public boolean b;
    public boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f197d;
    public final boolean e;

    static {
        String r0 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"ro.pvr.product.name", "Phoenix"});     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r0) == true) goto L5;
    L6:
        g = r0;
        h = "Phoenix".equals(r0);
        i = "Phoenix".equals(r0);
        j = true;
        k = -1;
        l = new HashMap();
        m = false;
        return;
    L5:
        r0 = "Phoenix";
        goto L6
    }

    public OUIEffectHelper(View r4) {
        boolean r0 = true;
        this.b = true;
        this.c = true;
        this.f197d = true;
        this.f196a = new WeakReference(r4);
        Context r5 = r4.getContext();
        if (n != null) goto L5;
        n = new TypedValue();
    L5:
        r5.getTheme().resolveAttribute(R.attr.oui_effect_enabled, n, true);
        if (n.data != 0) goto L9;
        r0 = false;
    L9:
        this.e = r0;
    }

    public static int b(JSONObject r0, String r1) {
        return r0.getInt(r1);
    L4:
        return -1;
    }

    public static boolean c(String r5) {
        String[] r6 = r5.split(",");
        if (r6.length <= 0) goto L11;
        int r0 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        if (g.equals(r6[r2]) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public final void a(boolean r9) {
        WeakReference r0 = this.f196a;
        if (r0.get() == null) goto L36;
        int r10 = !r9 ? 1 : 0;
        if (j == false) goto L16;
        if (this.c == false) goto L16;
        ((View) r0.get()).getContext();
        int r2 = k;
        if (h == false) goto L16;
        if (r2 < 100000) goto L16;
        if (m == false) goto L16;
        Log.i("OUIEffectHelper", "onVibrate: effectType=" + r10 + ", deviceId=" + r2);
    L16:
        if (this.f197d == false) goto L37;
        Context r8 = ((View) r0.get()).getContext();
        int r1 = k;
        if (i == false) goto L38;
        if (r1 < 100000) goto L41;
        Pair r3 = (Pair) l.get(Integer.valueOf(r1));
        AudioManager r11 = (AudioManager) r8.getSystemService("audio");
        if (r3 != null) goto L27;
        if (m == false) goto L39;
        Log.i("OUIEffectHelper", "playSoundEffect: pair is empty");
        return;
    L39:
        return;
    L27:
        if (m == false) goto L29;
        Log.i("OUIEffectHelper", "playSoundEffect: effectType=" + r10 + ", deviceId=" + r1);
    L29:
        if (r10 != 0) goto L31;
        int r12 = ((Integer) r3.first).intValue();
    L34:
        r11.playSoundEffect(r12, 1.0f);
        return;
    L31:
        if (r10 != 1) goto L33;
        r12 = ((Integer) r3.second).intValue();
        goto L34
    L33:
        r12 = 10;
        goto L34
    L41:
        return;
    L38:
        return;
    L37:
        return;
    }

    public final void d(boolean r2) {
        if (this.e == true) goto L5;
        return;
    L5:
        if (r2 == true) goto L7;
        return;
    L7:
        if (this.b == false) goto L11;
        a(true);
        return;
    }

    public final void e(int r13) {
        String r0 = "";
        if (r13 != 0) goto L78;
        View r14 = (View) this.f196a.get();
        if (r14 != null) goto L7;
        return;
    L7:
        if (r14.getContext() != null) goto L9;
        return;
    L9:
        if (f == true) goto L108;
        f = true;
        Context r15 = r14.getContext();
        HashMap r6 = l;
        r6.clear();
        Settings.Global.getInt(r15.getContentResolver(), "controller_vibration_level", 0);
        if (Settings.Global.getInt(r15.getContentResolver(), "system_vibration_enabled", 1) != 1) goto L14;
        boolean r7 = true;
    L15:
        j = r7;
        String r16 = Settings.Global.getString(r15.getContentResolver(), "pvr_ui_config");
        if (TextUtils.isEmpty(r16) == true) goto L72;
        JSONObject r8 = new JSONObject(r16);     // Catch: JSONException -> L35
        JSONObject r9 = r8.getJSONObject("vibration");     // Catch: JSONException -> L30
        b(r9, "def_hover_fre");     // Catch: JSONException -> L30
        b(r9, "def_hover_level");     // Catch: JSONException -> L30
        b(r9, "def_hover_dur");     // Catch: JSONException -> L30
        b(r9, "def_press_fre");     // Catch: JSONException -> L30
        b(r9, "def_press_level");     // Catch: JSONException -> L30
        b(r9, "def_press_dur");     // Catch: JSONException -> L30
        b(r9, "weak_hover_fre");     // Catch: JSONException -> L30
        b(r9, "weak_hover_level");     // Catch: JSONException -> L30
        b(r9, "weak_hover_dur");     // Catch: JSONException -> L30
        b(r9, "weak_press_fre");     // Catch: JSONException -> L30
        b(r9, "weak_press_level");     // Catch: JSONException -> L30
        b(r9, "weak_press_dur");     // Catch: JSONException -> L30
        b(r9, "strong_hover_fre");     // Catch: JSONException -> L30
        b(r9, "strong_hover_level");     // Catch: JSONException -> L30
        b(r9, "strong_hover_dur");     // Catch: JSONException -> L30
        b(r9, "strong_press_fre");     // Catch: JSONException -> L30
        b(r9, "strong_press_level");     // Catch: JSONException -> L30
        b(r9, "strong_press_dur");     // Catch: JSONException -> L30
        String r10 = r9.getString("device_allowed");     // Catch: JSONException -> L21
    L89:
        boolean r11 = r9.getBoolean("debug");     // Catch: JSONException -> L25
    L26:
        m = r11;     // Catch: JSONException -> L30
        if (TextUtils.isEmpty(r10) == true) goto L93;
        h = c(r10);     // Catch: JSONException -> L30
    L93:
        JSONObject r5 = r8.getJSONObject("sound");     // Catch: JSONException -> L44
        String r4 = r5.getString("device_allowed");     // Catch: JSONException -> L40
    L42:
        if (TextUtils.isEmpty(r4) == true) goto L85;
        i = c(r4);     // Catch: JSONException -> L44
    L85:
        r0 = r5.getString("device_id_effect_type");     // Catch: JSONException -> L82
    L49:
        if (TextUtils.isEmpty(r0) == true) goto L72;
        String[] r1 = r0.split(";");     // Catch: JSONException -> L44
        if (r1.length <= 0) goto L72;
        int r12 = r1.length;     // Catch: JSONException -> L44
        int r17 = 0;
    L53:
        if (r17 >= r12) goto L72;
        String[] r18 = r1[r17].split(",");     // Catch: JSONException -> L44
    L56:
        if (r18.length != 3) goto L63;
        r6.put(Integer.valueOf(Integer.parseInt(r18[0])), new Pair(Integer.valueOf(Integer.parseInt(r18[1])), Integer.valueOf(Integer.parseInt(r18[2]))));     // Catch: Exception -> L59
    L59:
        e = move-exception;
        if (m == false) goto L63;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration device_id_effect_type error=" + e);     // Catch: JSONException -> L44
    L63:
        r17 = r17 + 1;
    L40:
        r4 = "";
    L44:
        e = move-exception;
        if (m == false) goto L72;
        Log.e("OUIEffectHelper", "onWindowShow: parse sound error=" + e);     // Catch: JSONException -> L35
    L25:
        r11 = false;
    L21:
        r10 = "";
    L30:
        e = move-exception;
        if (m == false) goto L93;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration error=" + e);     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        if (m == false) goto L72;
        Log.e("OUIEffectHelper", "onWindowShow: parse uiConfig error=" + e);
    L72:
        if (m == false) goto L75;
        StringBuilder r19 = a.a.u("updateConfig: ", r16, ", sIsDeviceVibrateAllowed=");
        r19.append(h);
        r19.append(", sIsDeviceSoundAllowed=");
        r19.append(i);
        r19.append(", sDeviceType=");
        r19.append(g);
        Log.i("OUIEffectHelper", r19.toString());
    L75:
        if (m == false) goto L106;
        Log.i("OUIEffectHelper", "onWindowShow: mAppEffectEnabled=" + this.e);
        return;
    L106:
        return;
    L14:
        r7 = false;
        goto L15
    L108:
        return;
    L78:
        if (m == false) goto L80;
        Log.i("OUIEffectHelper", "onWindowHide: ");
    L80:
        f = false;
    }

    public final void f(boolean r4) {
        if (this.e == true) goto L5;
        return;
    L5:
        View r0 = (View) this.f196a.get();
        if (r0 != null) goto L9;
        return;
    L9:
        if ((r0.isPressed() ^ r4) == false) goto L14;
        if (r4 == false) goto L12;
        a(false);
        this.b = false;
        return;
    L12:
        r0.postDelayed(new androidx.constraintlayout.helper.widget.a(3, this), 20);
        return;
    }
}
