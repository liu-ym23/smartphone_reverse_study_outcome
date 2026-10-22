package td;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.model.p;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.services.apm.api.IHttpService;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.flow.cardlistpage.R$string;
import java.io.File;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import oj.f;
import org.apache.commons.lang3.time.FastDateParser;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements rd.c {
    public static int a(Window r10, View r11, AppletPopup r12) {
        Intrinsics.checkNotNullParameter(r12, "appletPopup");
        if (r10 == null) goto L7;
        WindowManager.LayoutParams r5 = r10.getAttributes();
        if (r5 == null) goto L7;
        int r13 = r5.softInputMode;
    L8:
        WindowInsetsCompat r14 = r12.f2868v;
        if (r14 == null) goto L11;
        boolean r15 = r14.isVisible(WindowInsetsCompat.Type.ime());
    L12:
        Context r16 = null;
        if ((r13 & 16) == 16) goto L36;
        if (r15 == false) goto L36;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L18
        if (r10 == null) goto L20;
        View r18 = r10.getDecorView();     // Catch: Throwable -> L18
    L22:
        if ((r18 instanceof ViewGroup) == false) goto L24;
        ViewGroup r19 = (ViewGroup) r18;     // Catch: Throwable -> L18
    L25:
        if (r19 == null) goto L30;
        View r20 = r19.getChildAt(0);     // Catch: Throwable -> L18
        if (r20 == null) goto L30;
        int r21 = r20.getMeasuredHeight();     // Catch: Throwable -> L18
    L91:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L37:
        if (r21 != 0) goto L99;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L43
        if (r10 == null) goto L45;
        View r23 = r10.getDecorView();     // Catch: Throwable -> L43
        if (r23 == null) goto L45;
    L48:
        if (r23 == null) goto L50;
        r23.getFitsSystemWindows();     // Catch: Throwable -> L43
    L50:
        Rect r24 = new Rect();     // Catch: Throwable -> L43
        if (r23 == null) goto L53;
        r23.getWindowVisibleDisplayFrame(r24);     // Catch: Throwable -> L43
    L53:
        int r25 = r24.bottom - r24.top;
        if (r23 != null) goto L95;
    L69:
        int r26 = AppletPopup.L;     // Catch: Throwable -> L64
        boolean r27 = g(r23, r10, r12.getView());     // Catch: Throwable -> L64
        WindowInsetsCompat r28 = r12.f2868v;     // Catch: Throwable -> L64
        if (r28 == null) goto L72;
        boolean r29 = r28.isVisible(WindowInsetsCompat.Type.ime());     // Catch: Throwable -> L64
    L73:
        if (r27 == true) goto L75;
    L86:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L64
    L90:
        return RangesKt.coerceAtLeast(r25, 0);
    L64:
        th = th;
    L88:
        Result.Companion r30 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L90
    L75:
        if (r29 == true) goto L86;
        WindowInsetsCompat r31 = r12.f2868v;     // Catch: Throwable -> L64
        if (r31 == null) goto L82;
        Insets r32 = r31.getInsets(WindowInsetsCompat.Type.navigationBars());     // Catch: Throwable -> L64
        if (r32 == null) goto L81;
        int r33 = r32.bottom;     // Catch: Throwable -> L64
    L85:
        r25 = r25 + r33;     // Catch: Throwable -> L64
        goto L86
    L81:
        r33 = 0;
        goto L85
    L82:
        if (r23 == null) goto L84;
        r16 = r23.getContext();     // Catch: Throwable -> L64
    L84:
        r33 = com.bytedance.ai.utils.c.b(r16);     // Catch: Throwable -> L64
        goto L85
    L72:
        r29 = false;
        goto L73
    L95:
        if ((r23.getWindowSystemUiVisibility() & 1024) == 0) goto L69;
        Context r34 = r23.getContext();     // Catch: Throwable -> L64
        if (r34 != null) goto L67;
        t0.b r35 = p.f2294c;     // Catch: Throwable -> L64
        if (r35 == null) goto L66;
        r34 = r35.currentActivity();     // Catch: Throwable -> L64
        goto L67
    L66:
        r34 = null;
    L67:
        if (r34 == null) goto L69;
        r25 = r25 + UIUtils.getStatusBarHeight(r34);     // Catch: Throwable -> L64
    L45:
        if (r11 == null) goto L47;
        r23 = r11.getRootView();     // Catch: Throwable -> L43
        goto L48
    L47:
        r23 = null;
    L43:
        th = th;
        r25 = 0;
        goto L88
    L99:
        return r21;
    L33:
        th = move-exception;
        int r36 = r21;
        th = th;
    L35:
        Result.Companion r37 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        r21 = r36;
    L30:
        r21 = 0;
        goto L91
    L24:
        r19 = null;
        goto L25
    L20:
        r18 = null;
    L18:
        th = th;
        r36 = 0;
    L36:
        r21 = 0;
        goto L37
    L11:
        r15 = false;
    L7:
        r13 = 0;
        goto L8
    }

    public static int b(FragmentActivity r10, AppletPopupSchemaParam r11, AppletPopup r12) {
        int r5 = AppletPopup.L;
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "appletPopup");
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d("AppletPopup", "getShowHeight");
    L5:
        Window r14 = r12.g();
        if (r14 == null) goto L8;
        r14.getDecorView();
    L8:
        Context r15 = null;
        if (r14 == null) goto L11;
        Context r16 = r14.getContext();
    L12:
        int r17 = r11.d;
        if (AppletPopupSchemaParam.b(r16) == false) goto L17;
        int r18 = r11.e;
        if (r18 <= 0) goto L17;
        r17 = r18;
    L17:
        BottomSheetBehavior r19 = r12.f2859l;
        if (r19 == null) goto L20;
        int r20 = r19.g;
    L22:
        if (r20 != 3) goto L26;
        int r21 = r11.f2897o;
        if (r21 <= 0) goto L26;
        r17 = r21;
    L26:
        if (r10 == null) goto L33;
        t0.b r22 = p.f2294c;
        if (r22 == null) goto L30;
        Integer r23 = Integer.valueOf(r22.getStatusBarHeight(r10));
    L31:
        if (r23 == null) goto L33;
        int r24 = r23.intValue();
    L34:
        int r25 = a(r14, r12.getView(), r12) - r24;
        r12.e(null);
        int r26 = r17 - AppletPopup.L;
        int r27 = r12.f2866t;
        if (r26 <= r27) goto L38;
        r25 = r17 - r27;
    L40:
        if (r17 <= 0) goto L44;
        if (r14 == null) goto L44;
        return RangesKt.coerceAtMost(r17, r25);
    L44:
        if (r17 != 0) goto L53;
        if (r14 == null) goto L48;
        r15 = r14.getContext();
    L48:
        if (Intrinsics.areEqual(r11.a(r15), "center") == false) goto L52;
        if (r14 == null) goto L52;
        return com.bytedance.ai.utils.c.c(r14.getContext(), 400.0d);
    L52:
        return -1;
    L53:
        return r17;
    L38:
        if ((r17 + r27) < r25) goto L40;
        r25 = r25 - r27;
        goto L40
    L30:
        r23 = null;
    L33:
        r24 = 0;
        goto L34
    L20:
        r20 = -1;
        goto L22
    L11:
        r16 = null;
        goto L12
    }

    public static final ResourceFrom c(com.bytedance.forest.model.ResourceFrom r5, w r10) {
        if (r10.f4436l == true) goto L28;
        if (r10.f4437m == true) goto L28;
        if (r5 != com.bytedance.forest.model.ResourceFrom.d) goto L15;
        com.bytedance.forest.model.ResourceFrom r11 = r10.f4445v;
        if (r11 != null) goto L12;
        return null;
    L12:
        return c(r11, r10);
    L15:
        if (r5 != com.bytedance.forest.model.ResourceFrom.f4338a) goto L19;
        return ResourceFrom.f5925a;
    L19:
        if (r5 != com.bytedance.forest.model.ResourceFrom.f4340c) goto L23;
        return ResourceFrom.f5927c;
    L23:
        if (r5 == com.bytedance.forest.model.ResourceFrom.f4339b) goto L25;
        return null;
    L25:
        return ResourceFrom.f5926b;
    L28:
        return ResourceFrom.d;
    }

    public static String d(ta.c r5) {
        HashMap r10 = r5.f22114a;
        if (r10 != null) goto L5;
    L25:
        return "";
    L5:
        if (r10.isEmpty() == true) goto L25;
        String r11 = (String) r10.get("x-tt-logid");
        if (r11 != null) goto L10;
    L13:
        String r12 = (String) r10.get("X-Tt-Logid");
        if (r12 != null) goto L16;
    L19:
        String r13 = (String) r10.get("X-TT-LOGID");
        if (r13 == null) goto L25;
        if (r13.length() == 0) goto L25;
        return r13;
    L16:
        if (r12.length() == 0) goto L19;
        return r12;
    L10:
        if (r11.length() == 0) goto L13;
        return r11;
    }

    public static Date e(String r10, Locale r11, String... r12) {
        TimeZone r5 = TimeZone.getDefault();
        if (r11 != null) goto L5;
        r11 = Locale.getDefault();
    L5:
        ParsePosition r13 = new ParsePosition(0);
        Calendar r14 = Calendar.getInstance(r5, r11);
        r14.setLenient(true);
        int r15 = r12.length;
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L16;
        FastDateParser r17 = new FastDateParser(r12[r16], r5, r11);
        r14.clear();
        if (r17.a(r10, r13, r14) == false) goto L14;
        if (r13.getIndex() != r10.length()) goto L14;
        return r14.getTime();
    L14:
        r13.setIndex(0);
        r16 = r16 + 1;
        goto L6
    L16:
        throw new ParseException("Unable to parse the date: ".concat(r10), -1);
    }

    public static void f(int r5, HashMap r10, String r11, int r12, String r13) {
        androidx.room.jarjarred.org.antlr.runtime.a.z(r5, r10, r11, r12, r13);
    }

    public static boolean g(View r5, Window r10, View r11) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r10 == null) goto L9;
        WindowManager.LayoutParams r12 = r10.getAttributes();
        if (r12 == null) goto L9;
        int r13 = r12.flags;
    L11:
        if ((r5.getWindowSystemUiVisibility() & 512) != 0) goto L13;
    L15:
        boolean r14 = false;
    L16:
        if (r14 == true) goto L18;
    L20:
        boolean r15 = false;
    L21:
        View r16 = null;
        if (r11 == null) goto L24;
        ViewParent r17 = r11.getParent();
    L26:
        if ((r17 instanceof View) == false) goto L28;
        r16 = (View) r17;
    L28:
        if (r16 == null) goto L30;
        int r18 = r16.getPaddingBottom();
    L31:
        if (r18 != 0) goto L33;
        boolean r19 = true;
    L34:
        if (r15 == false) goto L37;
        if (r19 == false) goto L37;
        return true;
    L37:
        return false;
    L33:
        r19 = false;
        goto L34
    L30:
        r18 = 0;
        goto L31
    L24:
        r17 = null;
        goto L26
    L18:
        if ((Integer.MIN_VALUE & r13) == 0) goto L20;
        r15 = true;
        goto L21
    L13:
        if ((134217728 & r13) != 0) goto L15;
        r14 = true;
    L9:
        r13 = 0;
        goto L11
    }

    public static final ResourceType h(com.bytedance.forest.model.ResourceFrom r5, w r10) {
        int r11 = r5.ordinal();
        if (r11 == 1) goto L17;
        if (r11 != 3) goto L7;
        com.bytedance.forest.model.ResourceFrom r12 = r10.f4445v;
        if (r12 == null) goto L15;
        ResourceType r13 = h(r12, r10);
        if (r13 == null) goto L15;
        return r13;
    L15:
        return ResourceType.f5928a;
    L7:
        return ResourceType.f5928a;
    L17:
        return ResourceType.f5929b;
    }

    public static Bitmap i(Drawable r5) {
        if ((r5 instanceof BitmapDrawable) == false) goto L8;
        BitmapDrawable r10 = (BitmapDrawable) r5;
        if (r10.getBitmap() == null) goto L8;
        return r10.getBitmap();
    L8:
        int r11 = r5.getIntrinsicWidth();
        Integer r12 = Integer.valueOf(r11);
        Integer r13 = null;
        if (r11 > 0) goto L12;
        r12 = null;
    L12:
        int r14 = 1;
        if (r12 == null) goto L15;
        int r15 = r12.intValue();
    L16:
        int r16 = r5.getIntrinsicHeight();
        Integer r17 = Integer.valueOf(r16);
        if (r16 <= 0) goto L19;
        r13 = r17;
    L19:
        if (r13 == null) goto L21;
        r14 = r13.intValue();
    L21:
        Bitmap r18 = Bitmap.createBitmap(r15, r14, Bitmap.Config.ARGB_8888);
        Canvas r19 = new Canvas(r18);
        r5.setBounds(0, 0, r19.getWidth(), r19.getHeight());
        r5.draw(r19);
        Intrinsics.checkNotNull(r18);
        return r18;
    L15:
        r15 = 1;
        goto L16
    }

    public static String j(String r5) {
        Class<?> r10 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L5
        return (String) r10.getMethod("get", new Class[]{String.class, String.class}).invoke(r10, new Object[]{r5, ""});
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static boolean k() {
        String r5 = "";
        if (TextUtils.isEmpty(j("ro.build.version.emui")) == true) goto L5;
        String r10 = j("ro.build.version.emui");
    L7:
        if (r10.contains("EmotionUI_3.0") == false) goto L9;
    L17:
        return true;
    L9:
        if (TextUtils.isEmpty(j("ro.build.version.emui")) == true) goto L12;
        r5 = j("ro.build.version.emui");
    L12:
        if ("EmotionUI 3".equals(r5) == true) goto L17;
        if (r5.contains("EmotionUI_3.1") == true) goto L17;
        return false;
    L5:
        r10 = "";
        goto L7
    }

    public static boolean l() {
        if (j("ro.build.display.id").toLowerCase().contains("flyme") == false) goto L5;
        String r5 = j("ro.build.display.id");
    L7:
        if (r5.isEmpty() == true) goto L18;
        if (r5.toLowerCase().contains("os") == false) goto L11;
        int r10 = Integer.valueOf(r5.substring(9, 10)).intValue();     // Catch: NumberFormatException -> L16
    L13:
        if (r10 < 4) goto L19;
        return true;
    L19:
        return false;
    L11:
        r10 = Integer.valueOf(r5.substring(6, 7)).intValue();     // Catch: NumberFormatException -> L16
        goto L13
    L20:
        return false;
    L18:
        return false;
    L5:
        r5 = "";
        goto L7
    }

    public static boolean m() {
        if (TextUtils.isEmpty(j("ro.miui.ui.version.name")) == true) goto L5;
        String r5 = j("ro.miui.ui.version.name");
    L7:
        if (r5.isEmpty() == false) goto L15;
        return false;
    L15:
        if (Integer.valueOf(r5.substring(1)).intValue() >= 6) goto L13;
        return false;
    L13:
        return true;
    L19:
        return false;
    L5:
        r5 = "";
        goto L7
    }

    public static com.obric.oui.dialog.v2.alert.b n(final Activity r5, final String r10, Drawable r11, String r12, Function0 r13) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "appIcon");
        Intrinsics.checkNotNullParameter(r12, "appName");
        com.obric.oui.dialog.v2.alert.e r14 = new com.obric.oui.dialog.v2.alert.e(r5);
        r14.s = true;
        String r15 = r5.getString(R$string.app_market_install_title, new Object[]{r12});
        r14.f13159i = false;
        r14.g = r15;
        r14.f13158h = r5.getString(R$string.app_market_install_message, new Object[]{r12});
        Intrinsics.checkNotNullParameter(r11, "drawable");
        r14.f13160j = r11;
        r14.f13168r = false;
        com.obric.oui.dialog.v2.alert.e.f(r14, r5.getString(R$string.delete_widget_cancel), new com.bytedance.ai.model.d(2));
        com.obric.oui.dialog.v2.alert.e.h(r14, r5.getString(R$string.app_market_install_confirm), new com.obric.flow.cardlistpage.ui.a(r5, r10));
        com.obric.flow.cardlistpage.ui.b r16 = new com.obric.flow.cardlistpage.ui.b(0, r13);
        Intrinsics.checkNotNullParameter(r16, "onDismissListener");
        r14.f13116a = r16;
        com.obric.oui.dialog.v2.alert.b r17 = r14.a();
        r17.show();
        return r17;
    }

    public static oj.b o(String r5, List r10, Map r11) {
        IHttpService r12 = (IHttpService) og.a.a(IHttpService.class);     // Catch: Exception -> L30
        if (r12 != null) goto L5;
        r12 = new DefaultHttpServiceImpl();     // Catch: Exception -> L30
    L5:
        f r13 = r12.buildMultipartUpload(r5, "UTF-8", false);     // Catch: Exception -> L30
        if (r10 != null) goto L8;
    L15:
        if (r11 != null) goto L17;
    L22:
        String r14 = new String(r13.finish().f20586b);     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r14) == true) goto L40;
        JSONObject r15 = new JSONObject(r14);     // Catch: JSONException -> L26 Exception -> L30
        return new oj.b(r15.optInt(WsConstants.ERROR_CODE, 0), r15.optString("message", "").getBytes());
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L30
        return null;
    L40:
        return null;
    L17:
        if (r11.isEmpty() == true) goto L22;
        Iterator r16 = r11.entrySet().iterator();     // Catch: Exception -> L30
    L20:
        if (r16.hasNext() == false) goto L22;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Exception -> L30
        r13.h((String) r17.getKey(), (String) r17.getValue());     // Catch: Exception -> L30
        goto L20
    L8:
        if (r10.isEmpty() == true) goto L15;
        Iterator r18 = r10.iterator();     // Catch: Exception -> L30
    L11:
        if (r18.hasNext() == false) goto L15;
        File r19 = (File) r18.next();     // Catch: Exception -> L30
        if (r19.exists() == false) goto L11;
        HashMap r20 = new HashMap();     // Catch: Exception -> L30
        r13.d(r19, r19.getName(), r20);     // Catch: Exception -> L30
    L41:
        return null;
    }
}
