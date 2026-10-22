package d.g.d.b.b;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static boolean A = false;
    private static int B = 0;
    private static boolean C = false;
    private static int D = 0;
    private static HashMap<Integer, Pair<Integer, Integer>> E = null;
    public static boolean F = false;
    private static TypedValue G = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f16772f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f16773g = 177;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f16774h = 33;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f16775i = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f16776j = 127;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f16777k = 204;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f16778l = 15;
    private static int m = 355;
    private static int n = 38;
    private static int o = 6;
    private static int p = 255;
    private static int q = 102;
    private static int r = 18;
    private static int s = 88;
    private static int t = 76;
    private static int u = 5;
    private static int v = 63;
    private static int w = 204;
    private static int x = 8;
    public static String y;
    private static boolean z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f16779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16783e;

    static {
        String r0 = h("ro.pvr.product.name", "Phoenix");
        y = r0;
        z = "Phoenix".equals(r0);
        A = "Phoenix".equals(y);
        B = 0;
        C = true;
        D = -1;
        E = new HashMap();
        F = false;
    }

    public i(View r2) {
        this.f16780b = true;
        this.f16781c = true;
        this.f16782d = true;
        this.f16779a = new WeakReference(r2);
        this.f16783e = d(r2.getContext(), com.obric.common.oui.b.f8196e);
    }

    private void a(boolean r3) {
        if (this.f16779a.get() == null) goto L13;
        int r4 = !r3 ? 1 : 0;
        if (C == false) goto L10;
        if (this.f16781c == false) goto L10;
        p(this.f16779a.get().getContext(), r4, D);
    L10:
        if (this.f16782d == false) goto L14;
        t(this.f16779a.get().getContext(), r4, D);
        return;
    L14:
        return;
    }

    private static boolean d(Context r2, int r3) {
        if (G != null) goto L5;
        G = new TypedValue();
    L5:
        r2.getTheme().resolveAttribute(r3, G, true);
        if (G.data != 0) goto L10;
        return false;
    L10:
        return true;
    }

    private static boolean e(JSONObject r0, String r1) {
        return r0.getBoolean(r1);
    L4:
        return false;
    }

    private static int f(JSONObject r0, String r1) {
        return r0.getInt(r1);
    L4:
        return -1;
    }

    private static String g(JSONObject r0, String r1) {
        return r0.getString(r1);
    L4:
        return "";
    }

    public static String h(String r7, String r8) {
        String r9 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r7, r8});     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r9) == false) goto L7;
        return r8;
    L7:
        return r9;
    L12:
        return r8;
    }

    private static void i(Context r3, int r4, int[] r5) {
        int r6 = B;
        if (r6 != 2) goto L8;
        if (r4 != 0) goto L6;
        r5[0] = t;
        r5[1] = s;
        r5[2] = u;
        return;
    L6:
        if (r4 != 1) goto L19;
        r5[0] = w;
        r5[1] = v;
        r5[2] = x;
        return;
    L19:
        return;
    L8:
        if (r6 != 1) goto L13;
        if (r4 != 0) goto L11;
        r5[0] = n;
        r5[1] = m;
        r5[2] = o;
        return;
    L11:
        if (r4 != 1) goto L22;
        r5[0] = q;
        r5[1] = p;
        r5[2] = r;
        return;
    L22:
        return;
    L13:
        if (r4 != 0) goto L15;
        r5[0] = f16774h;
        r5[1] = f16773g;
        r5[2] = f16775i;
        return;
    L15:
        if (r4 != 1) goto L25;
        r5[0] = f16777k;
        r5[1] = f16776j;
        r5[2] = f16778l;
        return;
    }

    private static boolean j(String r5) {
        String[] r6 = r5.split(",");
        if (r6.length <= 0) goto L11;
        int r0 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        if (y.equals(r6[r2]) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    private /* synthetic */ void k() {
        this.f16780b = true;
    }

    public static void p(Context r2, int r3, int r4) {
        if (z == true) goto L5;
        return;
    L5:
        if (r4 >= 100000) goto L8;
        return;
    L8:
        if (F == false) goto L11;
        Log.i("OUIEffectHelper", "onVibrate: effectType=" + r3 + ", deviceId=" + r4);
    L11:
        if (r4 != 100001) goto L14;
    L15:
        i(r2, r3, new int[3]);
        return;
    L14:
        if (r4 == 100002) goto L15;
    }

    public static void t(Context r4, int r5, int r6) {
        if (A == true) goto L5;
        return;
    L5:
        if (r6 < 100000) goto L27;
        Pair<Integer, Integer> r0 = E.get(Integer.valueOf(r6));
        AudioManager r7 = (AudioManager) r4.getSystemService("audio");
        if (r0 != null) goto L14;
        if (F == false) goto L25;
        Log.i("OUIEffectHelper", "playSoundEffect: pair is empty");
        return;
    L25:
        return;
    L14:
        if (F == false) goto L16;
        Log.i("OUIEffectHelper", "playSoundEffect: effectType=" + r5 + ", deviceId=" + r6);
    L16:
        int r8 = 10;
        if (r5 != 0) goto L21;
        Object r9 = r0.first;
    L19:
        r8 = ((Integer) r9).intValue();
    L23:
        r7.playSoundEffect(r8, 1.0f);
        return;
    L21:
        if (r5 != 1) goto L23;
        r9 = r0.second;
        goto L19
    }

    public static void x(Context r12) {
        E.clear();
        B = Settings.Global.getInt(r12.getContentResolver(), "controller_vibration_level", 0);
        if (Settings.Global.getInt(r12.getContentResolver(), "system_vibration_enabled", 1) != 1) goto L5;
        boolean r1 = true;
    L6:
        C = r1;
        String r13 = Settings.Global.getString(r12.getContentResolver(), "pvr_ui_config");
        if (TextUtils.isEmpty(r13) == true) goto L46;
        JSONObject r2 = new JSONObject(r13);     // Catch: JSONException -> L41
        JSONObject r5 = r2.getJSONObject("vibration");     // Catch: JSONException -> L13
        f16773g = f(r5, "def_hover_fre");     // Catch: JSONException -> L13
        f16774h = f(r5, "def_hover_level");     // Catch: JSONException -> L13
        f16775i = f(r5, "def_hover_dur");     // Catch: JSONException -> L13
        f16776j = f(r5, "def_press_fre");     // Catch: JSONException -> L13
        f16777k = f(r5, "def_press_level");     // Catch: JSONException -> L13
        f16778l = f(r5, "def_press_dur");     // Catch: JSONException -> L13
        m = f(r5, "weak_hover_fre");     // Catch: JSONException -> L13
        n = f(r5, "weak_hover_level");     // Catch: JSONException -> L13
        o = f(r5, "weak_hover_dur");     // Catch: JSONException -> L13
        p = f(r5, "weak_press_fre");     // Catch: JSONException -> L13
        q = f(r5, "weak_press_level");     // Catch: JSONException -> L13
        r = f(r5, "weak_press_dur");     // Catch: JSONException -> L13
        s = f(r5, "strong_hover_fre");     // Catch: JSONException -> L13
        t = f(r5, "strong_hover_level");     // Catch: JSONException -> L13
        u = f(r5, "strong_hover_dur");     // Catch: JSONException -> L13
        v = f(r5, "strong_press_fre");     // Catch: JSONException -> L13
        w = f(r5, "strong_press_level");     // Catch: JSONException -> L13
        x = f(r5, "strong_press_dur");     // Catch: JSONException -> L13
        String r6 = g(r5, "device_allowed");     // Catch: JSONException -> L13
        F = e(r5, "debug");     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r6) == true) goto L49;
        z = j(r6);     // Catch: JSONException -> L13
    L49:
        JSONObject r3 = r2.getJSONObject("sound");     // Catch: JSONException -> L36
        String r0 = g(r3, "device_allowed");     // Catch: JSONException -> L36
        if (TextUtils.isEmpty(r0) == true) goto L20;
        A = j(r0);     // Catch: JSONException -> L36
    L20:
        String r4 = g(r3, "device_id_effect_type");     // Catch: JSONException -> L36
        if (TextUtils.isEmpty(r4) == true) goto L46;
        String[] r7 = r4.split(";");     // Catch: JSONException -> L36
        if (r7.length <= 0) goto L46;
        int r8 = r7.length;     // Catch: JSONException -> L36
        int r9 = 0;
    L25:
        if (r9 >= r8) goto L46;
        String[] r10 = r7[r9].split(",");     // Catch: JSONException -> L36
    L28:
        if (r10.length != 3) goto L35;
        E.put(Integer.valueOf(Integer.parseInt(r10[0])), new Pair(Integer.valueOf(Integer.parseInt(r10[1])), Integer.valueOf(Integer.parseInt(r10[2]))));     // Catch: Exception -> L31
    L31:
        e = move-exception;
        if (F == false) goto L35;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration device_id_effect_type error=" + e);     // Catch: JSONException -> L36
    L35:
        r9 = r9 + 1;
    L36:
        e = move-exception;
        if (F == false) goto L46;
        Log.e("OUIEffectHelper", "onWindowShow: parse sound error=" + e);     // Catch: JSONException -> L41
    L13:
        e = move-exception;
        if (F == false) goto L49;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration error=" + e);     // Catch: JSONException -> L41
    L41:
        e = move-exception;
        if (F == false) goto L46;
        Log.e("OUIEffectHelper", "onWindowShow: parse uiConfig error=" + e);
    L46:
        if (F == false) goto L62;
        Log.i("OUIEffectHelper", "updateConfig: " + r13 + ", sIsDeviceVibrateAllowed=" + z + ", sIsDeviceSoundAllowed=" + A + ", sDeviceType=" + y);
        return;
    L62:
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void y(MotionEvent r1) {
        D = r1.getDeviceId();
    }

    public void b(MotionEvent r1) {
        y(r1);
    }

    public void c(MotionEvent r1) {
        y(r1);
    }

    public /* synthetic */ void l() {
        k();
    }

    public void m() {
    }

    public void n() {
    }

    public void o(boolean r2) {
        if (this.f16783e == true) goto L5;
        return;
    L5:
        if (r2 == true) goto L7;
        return;
    L7:
        if (this.f16780b == false) goto L11;
        a(true);
        return;
    }

    public void q() {
        if (F == false) goto L5;
        Log.i("OUIEffectHelper", "onWindowHide: ");
    L5:
        f16772f = false;
    }

    public void r() {
        View r0 = this.f16779a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getContext() != null) goto L7;
        return;
    L7:
        if (f16772f == true) goto L16;
        f16772f = true;
        x(r0.getContext());
        if (F == false) goto L15;
        Log.i("OUIEffectHelper", "onWindowShow: mAppEffectEnabled=" + this.f16783e);
        return;
    L15:
        return;
    }

    public void s(int r1) {
        if (r1 != 0) goto L4;
        r();
        return;
    L4:
        q();
    }

    public void u(boolean r4) {
        if (this.f16783e == true) goto L5;
        return;
    L5:
        View r0 = this.f16779a.get();
        if (r0 != null) goto L9;
        return;
    L9:
        if ((r0.isPressed() ^ r4) == false) goto L14;
        if (r4 == false) goto L12;
        a(false);
        this.f16780b = false;
        return;
    L12:
        r0.postDelayed(new d(this), 20);
        return;
    }

    public void v(boolean r1) {
        this.f16782d = r1;
    }

    public void w(boolean r1) {
        this.f16781c = r1;
    }
}
