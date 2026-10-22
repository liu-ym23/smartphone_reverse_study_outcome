package td;

import ai.p;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.flow.cardlistpage.data.o;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mn.h;
import oo.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements rd.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f22125a = true;

    public static JSONObject a(LynxContext r22, String r23, boolean r24, boolean r25, long r26, long r28, long r30, long r32, int r34, JSONObject r35) {
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L10
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L10
        r11.put("fetchTime", r28 / 1000.0d);     // Catch: JSONException -> L10
        r11.put("completeTime", r30 / 1000.0d);     // Catch: JSONException -> L10
        r11.put("fetchTimeStamp", r26);     // Catch: JSONException -> L10
        r11.put("finishTimeStamp", r32);     // Catch: JSONException -> L10
        r10.put(LynxMonitorService.KEY_TIME_METRICS, r11);     // Catch: JSONException -> L10
        if (r22 != null) goto L6;
    L32:
        r10.put(LynxMonitorService.KEY_IMAGE_URL, r23);     // Catch: JSONException -> L10
        r10.put(LynxMonitorService.KEY_SUCCESS_RATE, r24 ? 1 : 0);     // Catch: JSONException -> L10
        r10.put(LynxMonitorService.KEY_MEMORY_COST_FROM, r34);     // Catch: JSONException -> L10
        r10.put("resourceFromMemoryCache", r25 ? 1 : 0);     // Catch: JSONException -> L10
        return r10;
    L6:
        if (r22.k() == null) goto L32;
        String r12 = r22.k().getTemplateUrl();     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r12) == false) goto L12;
        r12 = "";
    L12:
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L10
        r13.put("url", r12);     // Catch: JSONException -> L10
        if (r35 == null) goto L31;
        long r14 = r35.optLong("viewWidth");     // Catch: JSONException -> L10
        long r15 = r35.optLong("viewHeight");     // Catch: JSONException -> L10
        long r16 = r35.optLong("width");     // Catch: JSONException -> L10
        long r17 = r35.optLong("height");     // Catch: JSONException -> L10
        int r18 = r35.optInt("isFlattenAnim");     // Catch: JSONException -> L10
        String r5 = r35.optString("config");     // Catch: JSONException -> L10
        if (r14 > 0) goto L18;
        r14 = -1;
    L18:
        r13.put("viewWidth", r14);     // Catch: JSONException -> L10
        if (r15 > 0) goto L22;
        r15 = -1;
    L22:
        r13.put("viewHeight", r15);     // Catch: JSONException -> L10
        if (r16 > 0) goto L26;
        r16 = -1;
    L26:
        r13.put("width", r16);     // Catch: JSONException -> L10
        if (r17 <= 0) goto L29;
        long r19 = r17;
    L30:
        r13.put("height", r19);     // Catch: JSONException -> L10
        r13.put("flattenAnim", r18);     // Catch: JSONException -> L10
        r13.put("config", r5);     // Catch: JSONException -> L10
        goto L31
    L29:
        r19 = -1;
    L31:
        r10.put(LynxMonitorService.KEY_METRIC, r13);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void b(int r13, int r14, long r15, long r17, LynxContext r19, String r20, boolean r21, boolean r22) {
        h.i().execute(new i(r13, r14, r15, r17, r19, r20, r21, r22));
    }

    public static void c(com.bytedance.ies.bullet.core.a r10, KitType r11) {
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "kitType");
        int r12 = r11.ordinal();
        if (r12 != 1) goto L5;
        com.bytedance.ies.bullet.core.e r13 = r10.d;
        if (r13 != null) goto L15;
    L18:
        tc.c r14 = tc.c.f22119c;
        pb.a r15 = (pb.a) tc.c.f22119c.a(pb.a.class, "default_bid");
        ArrayList r5 = new ArrayList();
        com.bytedance.ies.bullet.core.e r16 = r10.d;
        if (r16 == null) goto L30;
        String r17 = r16.f;
        if (r17 == null) goto L30;
        if (Intrinsics.areEqual(r17, "default_bid") == false) goto L26;
        r17 = null;
    L26:
        if (r17 == null) goto L30;
        pb.a r18 = (pb.a) tc.c.f22119c.a(pb.a.class, r17);
        if (r18 == null) goto L30;
        r5.add(r18);
    L30:
        com.bytedance.ies.bullet.core.e r19 = r10.d;
        if (r19 == null) goto L44;
        p r20 = r19.f5305t;
        if (r20 == null) goto L44;
        List r21 = (List) r20.f288c;
        if (r21 == null) goto L44;
        Iterator r22 = r21.iterator();
    L38:
        if (r22.hasNext() == false) goto L44;
        String r23 = (String) r22.next();
        tc.c r24 = tc.c.f22119c;
        rc.c r25 = (pb.a) tc.c.f22119c.a(pb.a.class, r23);
        if (r25 == null) goto L38;
        if (Intrinsics.areEqual(((tc.a) r25).f22117a, "default_bid") == true) goto L38;
        r5.add(r25);
    L44:
        Iterator r26 = r5.iterator();
    L46:
        if (r26.hasNext() == false) goto L48;
        r10.b((pb.a) r26.next());
        goto L46
    L48:
        if (r15 == null) goto L50;
        r10.b(r15);
    L50:
        com.bytedance.ies.bullet.core.e r27 = r10.d;
        if (r27 != null) goto L53;
        return;
    L53:
        r27.f5301o = r10.f5272c;
        return;
    L15:
        if (sk.a.f(r13) != true) goto L18;
    L16:
        tc.c r28 = tc.c.f22119c;
        pb.a r29 = (pb.a) tc.c.f22119c.a(pb.a.class, "default_bid");
        return;
    L5:
        if (r12 != 3) goto L18;
        com.bytedance.ies.bullet.core.e r30 = r10.d;
        if (r30 == null) goto L18;
        if (sk.a.g(r30) != true) goto L18;
        goto L18
    }

    public static void d(String r5, long r10, JSONObject r11) {
        if (r10 >= 0) goto L6;
        r10 = -1;
    L6:
        r11.put(r5, r10);
    }

    public static void e(String r5, Throwable r10, String r11, String r12) {
        Logger.c(r11, r12, r5 + r10);
    }

    public static b f(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (r10.isDeviceProtectedStorage() == false) goto L5;
        Context r5 = r10;
    L6:
        SharedPreferences r11 = r5.getSharedPreferences("minus_one_prefs", 0);
        long r12 = r11.getLong("installed_version_code", -1);
        long r13 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).getLongVersionCode();     // Catch: Exception -> L9
    L14:
        if (r12 != (-1)) goto L17;
        r11.edit().putLong("installed_version_code", r13).apply();
        return o.f11501b;
    L17:
        if (r12 >= r13) goto L20;
        r11.edit().putLong("installed_version_code", r13).apply();
        return o.d;
    L20:
        return o.f11502c;
    L9:
        e = move-exception;
        String r14 = "checkFirstInstallOrUpgrade: " + e;
        Intrinsics.checkNotNullParameter("MinusOneInstallStatusHelper", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        org.koin.core.a r15 = su.a.f22013b;
        if (r15 == null) goto L22;
        ((ju.b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MinusOneInstallStatusHelper", r14);
        r13 = -1;
        goto L14
    L22:
        throw new IllegalStateException("KoinApplication has not been started");
    L5:
        r5 = r10.createDeviceProtectedStorageContext();
        goto L6
    }

    public static void g(JSONObject r5, JSONObject r10) {
        Iterator<String> r11 = r10.keys();
    L4:
        if (r11.hasNext() == false) goto L17;
        String[] r12 = r11.next().split("#");
        int r13 = 0;
        JSONObject r14 = r5;
    L7:
        if (r13 >= (r12.length - 1)) goto L15;
        if (r14.has(r12[r13]) == false) goto L14;
        if (r14.get(r12[r13]).getClass().equals(JSONObject.class) == false) goto L14;
        r14 = r14.getJSONObject(r12[r13]);
        r13 = r13 + 1;
    L14:
        r14 = null;
    L15:
        if (r14 == null) goto L4;
        r14.remove(r12[r12.length - 1]);
        goto L4
    }

    public static Drawable h(Context r5, Context r10, int r11, Resources.Theme r12) {
    L9:
        e = move-exception;
        if (r5.getPackageName().equals(r10.getPackageName()) == false) goto L13;
        throw e;
    L13:
        return ContextCompat.getDrawable(r10, r11);
    L15:
        f22125a = false;
        goto L16
    L3:
        if (f22125a == false) goto L16;
        if (r12 == null) goto L6;
        Context r13 = new ContextThemeWrapper(r10, r12);     // Catch: IllegalStateException -> L9 NoClassDefFoundError -> L15 Resources.NotFoundException -> L21
    L7:
        return AppCompatResources.getDrawable(r13, r11);
        goto L16
    L6:
        r13 = r10;
    L16:
        if (r12 != null) goto L20;
        r12 = r10.getTheme();
    L20:
        return ResourcesCompat.getDrawable(r10.getResources(), r11, r12);
    }

    public static void i(JSONObject r10, JSONObject r11) {
        Iterator<String> r5 = r11.keys();
    L4:
        if (r5.hasNext() == false) goto L15;
        String r12 = r5.next();
        String[] r13 = r12.split("#");
        int r14 = 0;
        JSONObject r15 = r10;
    L7:
        if (r14 >= (r13.length - 1)) goto L14;
        if (r15.has(r13[r14]) == true) goto L11;
    L12:
        r15.put(r13[r14], new JSONObject());
    L13:
        r15 = r15.getJSONObject(r13[r14]);
        r14 = r14 + 1;
        goto L7
    L11:
        if (r15.get(r13[r14]).getClass().equals(JSONObject.class) == true) goto L13;
    L14:
        r15.put(r13[r13.length - 1], r11.get(r12));
        goto L4
    }

    public static void j(Closeable r5) {
        if (r5 == null) goto L8;
        r5.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }
}
