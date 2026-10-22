package ms.bd.c;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a4 f22403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a4 f22404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static JSONArray f22405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f22406d = 0;

    static {
        f22403a = new c4();
        f22404b = new l2();
        f22405c = null;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static Object b() {
        JSONArray r0 = f22405c;
        if (r0 != null) goto L5;
    L24:
        String r1 = (String) m.a(16777217, 0, 0, "56de69", new byte[]{41, 61, 31, 46, 13, 34});
    L25:
        JSONArray r2 = f22405c;
        if (r2 == null) goto L30;
        return r2.toString();
    L30:
        return new JSONArray().toString();
    L7:
        if (e4.i() != 1) goto L25;
        f22405c = new JSONArray();     // Catch: Throwable -> L24
        DhcpInfo r3 = ((WifiManager) a.a().c().getApplicationContext().getSystemService((String) m.a(16777217, 0, 0, "e004eb", new byte[]{99, 59, 69, 73}))).getDhcpInfo();     // Catch: Throwable -> L24
        JSONArray r4 = f22405c;     // Catch: Throwable -> L24
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L24
        r5.append(r3.dns1 & 255);     // Catch: Throwable -> L24
        r5.append((String) m.a(16777217, 0, 0, "7dc9ee", new byte[]{104}));     // Catch: Throwable -> L24
        r5.append((r3.dns1 >> 8) & 255);     // Catch: Throwable -> L24
        r5.append((String) m.a(16777217, 0, 0, "fe6c35", new byte[]{57}));     // Catch: Throwable -> L24
        r5.append((r3.dns1 >> 16) & 255);     // Catch: Throwable -> L24
        r5.append((String) m.a(16777217, 0, 0, "ad1dcf", new byte[]{62}));     // Catch: Throwable -> L24
        r5.append((r3.dns1 >> 24) & 255);     // Catch: Throwable -> L24
        r4.put(r5.toString());     // Catch: Throwable -> L24
        JSONArray r6 = f22405c;     // Catch: Throwable -> L24
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L24
        r7.append(r3.dns2 & 255);     // Catch: Throwable -> L24
        r7.append((String) m.a(16777217, 0, 0, "c2ab6b", new byte[]{60}));     // Catch: Throwable -> L24
        r7.append((r3.dns2 >> 8) & 255);     // Catch: Throwable -> L24
        r7.append((String) m.a(16777217, 0, 0, "a886ed", new byte[]{62}));     // Catch: Throwable -> L24
        r7.append((r3.dns2 >> 16) & 255);     // Catch: Throwable -> L24
        r7.append((String) m.a(16777217, 0, 0, "2f7c3d", new byte[]{109}));     // Catch: Throwable -> L24
        r7.append((r3.dns2 >> 24) & 255);     // Catch: Throwable -> L24
        r6.put(r7.toString());     // Catch: Throwable -> L24
        goto L25
    L5:
        return r0.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v43, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v119 */
    /* JADX WARN: Type inference failed for: r2v120 */
    /* JADX WARN: Type inference failed for: r2v121 */
    /* JADX WARN: Type inference failed for: r2v122 */
    /* JADX WARN: Type inference failed for: r2v123 */
    /* JADX WARN: Type inference failed for: r2v124 */
    /* JADX WARN: Type inference failed for: r2v125 */
    /* JADX WARN: Type inference failed for: r2v126 */
    /* JADX WARN: Type inference failed for: r2v127 */
    /* JADX WARN: Type inference failed for: r2v128 */
    /* JADX WARN: Type inference failed for: r2v129 */
    /* JADX WARN: Type inference failed for: r2v130 */
    /* JADX WARN: Type inference failed for: r2v131 */
    /* JADX WARN: Type inference failed for: r2v132 */
    /* JADX WARN: Type inference failed for: r2v133 */
    /* JADX WARN: Type inference failed for: r2v134 */
    /* JADX WARN: Type inference failed for: r2v135 */
    /* JADX WARN: Type inference failed for: r2v136 */
    /* JADX WARN: Type inference failed for: r2v137 */
    /* JADX WARN: Type inference failed for: r2v138 */
    /* JADX WARN: Type inference failed for: r2v139 */
    /* JADX WARN: Type inference failed for: r2v140 */
    /* JADX WARN: Type inference failed for: r2v141 */
    /* JADX WARN: Type inference failed for: r2v142 */
    /* JADX WARN: Type inference failed for: r2v143 */
    /* JADX WARN: Type inference failed for: r2v144 */
    /* JADX WARN: Type inference failed for: r2v145 */
    /* JADX WARN: Type inference failed for: r2v146 */
    /* JADX WARN: Type inference failed for: r2v147 */
    /* JADX WARN: Type inference failed for: r2v148 */
    /* JADX WARN: Type inference failed for: r2v149 */
    /* JADX WARN: Type inference failed for: r2v150 */
    /* JADX WARN: Type inference failed for: r2v151 */
    /* JADX WARN: Type inference failed for: r2v152 */
    /* JADX WARN: Type inference failed for: r2v153 */
    /* JADX WARN: Type inference failed for: r2v154 */
    /* JADX WARN: Type inference failed for: r2v155 */
    /* JADX WARN: Type inference failed for: r2v156 */
    /* JADX WARN: Type inference failed for: r2v157 */
    /* JADX WARN: Type inference failed for: r2v158 */
    /* JADX WARN: Type inference failed for: r2v159 */
    /* JADX WARN: Type inference failed for: r2v160 */
    /* JADX WARN: Type inference failed for: r2v161 */
    /* JADX WARN: Type inference failed for: r2v162 */
    /* JADX WARN: Type inference failed for: r2v163 */
    /* JADX WARN: Type inference failed for: r2v164 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v97 */
    public static Object c(int r30, int r31, long r32, String r34, Object r35) {
        if (r30 != 16777228) goto L5;
        File r2 = new File(a.a().c().getFilesDir(), (String) m.a(16777217, 0, 0, "1dc070", new byte[]{110, 107, 3, 64, 9, 51, 51}));
        if (r2.exists() == true) goto L190;
        r2.mkdirs();
    L190:
        ?? r3 = r2.getAbsolutePath();
    L192:
        return r3;
    L5:
        if (r30 != 33554433) goto L7;
        a4 r0 = f22403a;
    L186:
        r3 = r0.a(r30, r31, r32, r34, r35);
        goto L192
    L7:
        if (r30 == 33554434) goto L184;
        int r9 = 1;
        int r14 = 0;
        switch(r30) {
            case 16777217: goto L45;
            case 16777218: goto L35;
            case 16777219: goto L14;
            default: goto L10;
        };
    L10:
        switch(r30) {
            case 16777221: goto L55;
            case 16777222: goto L54;
            case 16777223: goto L52;
            case 16777224: goto L51;
            case 16777225: goto L50;
            case 16777226: goto L49;
            default: goto L11;
        };
    L11:
        switch(r30) {
            case 16777232: goto L59;
            case 16777233: goto L58;
            case 16777234: goto L57;
            case 16777235: goto L56;
            default: goto L12;
        };
    L12:
        switch(r30) {
            case 16777238: goto L180;
            case 16777239: goto L179;
            case 16777240: goto L168;
            case 16777241: goto L167;
            case 16777242: goto L162;
            case 16777243: goto L161;
            case 16777244: goto L160;
            case 16777245: goto L154;
            case 16777246: goto L153;
            case 16777247: goto L152;
            case 16777248: goto L151;
            case 16777249: goto L150;
            case 16777250: goto L149;
            case 16777251: goto L148;
            case 16777252: goto L147;
            case 16777253: goto L146;
            case 16777254: goto L143;
            case 16777255: goto L128;
            case 16777256: goto L119;
            case 16777257: goto L210;
            case 16777258: goto L109;
            case 16777259: goto L214;
            case 16777260: goto L102;
            case 16777261: goto L89;
            case 16777262: goto L87;
            case 16777263: goto L86;
            case 16777264: goto L85;
            case 16777265: goto L84;
            case 16777266: goto L83;
            case 16777267: goto L82;
            case 16777268: goto L81;
            case 16777269: goto L80;
            case 16777270: goto L206;
            case 16777271: goto L68;
            case 16777272: goto L67;
            case 16777273: goto L66;
            case 16777274: goto L64;
            case 16777275: goto L63;
            case 16777276: goto L62;
            case 16777277: goto L61;
            case 16777278: goto L60;
            default: goto L117;
        };
    L60:
        r3 = v2.e();
        goto L192
    L61:
        long r1 = p2.f22449d;
    L65:
        r3 = String.valueOf(r1);
        goto L192
    L62:
        r1 = p2.f22448c;
        goto L65
    L63:
        r1 = p2.f22447b;
        goto L65
    L64:
        r1 = p2.f22446a;
        goto L65
    L66:
        r3 = e4.j(a.a().c());
        goto L192
    L67:
        boolean r4 = m4.a(a.a().c());
    L69:
        r3 = Boolean.valueOf(r4);
        goto L192
    L68:
        r4 = g4.c(r34);
        goto L69
    L80:
        r3 = p4.a();
        goto L192
    L81:
        r3 = l4.a();
        goto L192
    L82:
        int r5 = g4.i(a.a().c());
    L53:
        r3 = Integer.valueOf(r5);
        goto L192
    L83:
        r3 = g4.j();
        goto L192
    L84:
        r3 = new StringBuilder().toString();
        goto L192
    L85:
        r3 = s4.a(a.a().c());
        goto L192
    L86:
        Object[] r6 = (Object[]) r35;
        r3 = e0.c(r31, (int) r32, (String) r6[0], (String) r6[1]);
        goto L192
    L87:
        r3 = g4.e();
        goto L192
    L102:
        r5 = n4.b(a.a().c()).e();
        goto L53
    L109:
        r3 = y2.b(a.a().c(), r34).c();
        goto L192
    L128:
        Throwable r7 = q4.b().c();
        if (r7 == null) goto L117;
        StackTraceElement[] r8 = r7.getStackTrace();
        if (r8.length < 4) goto L117;
        ?? r10 = new ArrayList();
    L135:
        if (r9 >= 4) goto L47;
        if (r8[r9] == null) goto L142;
        if (TextUtils.isEmpty(r8[r9].getClassName()) == true) goto L142;
        r10.addAll(q4.b().a(Class.forName(r8[r9].getClassName()), r8[r9].getMethodName()));
    L142:
        r9 = r9 + 1;
    L47:
        r3 = r10;
        goto L192
    L143:
        Throwable r11 = q4.b().c();
        if (r11 == null) goto L183;
        r3 = Arrays.toString(r11.getStackTrace());
    L183:
        r3 = "";
        goto L192
    L146:
        r3 = UUID.randomUUID().toString();
        goto L192
    L147:
        r3 = e0.b(a.a().c());
        goto L192
    L148:
        Context r12 = a.a().c();
        String[] r13 = r34.split((String) m.a(16777217, 0, 0, "b860b6", new byte[]{79, 38}));
        String r15 = r13[0];
        String r16 = r13[1];
        SharedPreferences.Editor r17 = a(r12, r15, 0).edit();
        r17.putString(r16, (String) r35);
        r17.commit();
        goto L117
    L149:
        r3 = a(a.a().c(), r34, 0).getString((String) r35, null);
        goto L192
    L150:
        r5 = n4.b(a.a().c()).g();
        goto L53
    L151:
        r5 = n4.b(a.a().c()).d();
        goto L53
    L152:
        r3 = n4.b(a.a().c()).h();
        goto L192
    L153:
        r3 = 0;
        n4.b(a.a().c()).c();
        goto L192
    L154:
        Boolean r18 = Boolean.FALSE;
        TelephonyManager r19 = (TelephonyManager) a.a().c().getApplicationContext().getSystemService((String) m.a(16777217, 0, 0, "621190", new byte[]{55, 56, 77, 75, 3}));
        if (r19 != null) goto L157;
        return r18;
    L157:
        if (r19.getSimState() != 5) goto L225;
        r3 = Boolean.TRUE;
        goto L192
    L225:
        return r18;
    L160:
        r3 = b();
        goto L192
    L161:
        r3 = v4.a();
        goto L192
    L162:
        String r20 = null;
        Locale r21 = a.a().c().getResources().getConfiguration().locale;     // Catch: Throwable -> L195
        String r22 = r21.getLanguage();     // Catch: Throwable -> L195
        String r23 = r21.getCountry();     // Catch: Throwable -> L195
        StringBuilder r24 = new StringBuilder();     // Catch: Throwable -> L195
        r24.append(r22);     // Catch: Throwable -> L195
        r24.append((String) m.a(16777217, 0, 0, "736672", new byte[]{25}));     // Catch: Throwable -> L195
        r24.append(r23);     // Catch: Throwable -> L195
        r20 = r24.toString();     // Catch: Throwable -> L195
    L166:
        r3 = r4.a(r20);
        goto L192
    L167:
        r3 = 0;
        q2.a(a.a().c()).b();
        goto L192
    L168:
        r3 = 0;
        r3 = 0;
        r3 = 0;
        r3 = 0;
        r3 = 0;
        String[] r25 = (String[]) r35;
        Context r26 = a.a().c();
        if (r26 == null) goto L192;
        if (r34 == null) goto L192;
        if (r25 == null) goto L192;
        if ((r25.length % 2) != 0) goto L192;
        Intent r27 = new Intent(r34);
        r27.setPackage(r26.getPackageName());
    L176:
        if (r14 >= r25.length) goto L178;
        r27.putExtra(r25[r14], r25[r14 + 1]);
        r14 = r14 + 2;
        goto L176
    L178:
        r26.sendBroadcast(r27);
        goto L192
    L179:
        r3 = n4.b(a.a().c()).i();
        goto L192
    L180:
        Context r28 = a.a().c();
        if (r28 == null) goto L183;
        r3 = r28.getPackageName();
    L117:
        r3 = 0;
        goto L192
    L206:
    L79:
        Object r29 = m.a(16777217, 0, 0, "3d4cf5", new byte[]{115});
    L121:
        r3 = (String) r29;
        goto L192
    L71:
        if (n.a().b(r34) == false) goto L76;
        Object r33 = m.a(16777217, 0, 0, "c1a0f1", new byte[]{35});     // Catch: Throwable -> L79
    L77:
        r3 = (String) r33;     // Catch: Throwable -> L79
        goto L192
    L76:
        r33 = m.a(16777217, 0, 0, "eabe57", new byte[]{36});     // Catch: Throwable -> L79
        goto L77
    L214:
        x4 r36 = x4.c();     // Catch: Exception -> L197
        if (r36.l() == false) goto L183;
        JSONObject r37 = r36.i();     // Catch: Exception -> L197
        if (r37 == null) goto L183;
        r3 = r37.toString();     // Catch: Exception -> L197
    L89:
        if (Build.VERSION.SDK_INT >= 23) goto L204;
    L101:
        r29 = m.a(16777217, 0, 0, "8c8c27", new byte[]{121});
        goto L121
    L204:
        ConnectivityManager r38 = (ConnectivityManager) a.a().c().getSystemService((String) m.a(16777217, 0, 0, "253a90", new byte[]{32, 56, 78, 27, 3, 36, 37, 29, 116, 56, 55, 46}));     // Catch: Throwable -> L193
        if (r38.getNetworkCapabilities(r38.getActiveNetwork()).hasTransport(4) == false) goto L98;
        Object r39 = m.a(16777217, 0, 0, "746f8a", new byte[]{119});     // Catch: Throwable -> L193
    L99:
        r3 = (String) r39;     // Catch: Throwable -> L193
    L98:
        r39 = m.a(16777217, 0, 0, "69612e", new byte[]{119});     // Catch: Throwable -> L193
        goto L99
    L210:
        Method r40 = Class.forName((String) m.a(16777217, 0, 0, "42ff74", new byte[]{38, 63, 24, 92, 10, 58, 35, 22, 51, 55, 43, 51, 16, 92, 5, 44, 53, 0, 50, 53, 107, 35, 16, 28, 27, 44, 37, 93, 58, 58, 107, 29, 38, 48})).getMethod((String) m.a(16777217, 0, 0, "5bac17", new byte[]{37}), new Class[0]);     // Catch: Throwable -> L196
        if (r40 == null) goto L117;
        r3 = (Long) r40.invoke(null, new Object[0]);     // Catch: Throwable -> L196
        goto L192
    L119:
        if (e4.i() == 1) goto L208;
        r29 = m.a(16777217, 0, 0, "5a2c96", new byte[]{116});
        goto L121
    L208:
        e0.e();     // Catch: Throwable -> L194
    L124:
        if (TextUtils.isEmpty(null) == false) goto L127;
        r29 = m.a(16777217, 0, 0, "13fd73", new byte[]{112});
        goto L121
    L127:
        throw null;
    L56:
        r3 = q2.a(a.a().c()).c();
        goto L192
    L57:
        r3 = e4.c(a.a().c());
        goto L192
    L58:
        r3 = e4.h(a.a().c());
        goto L192
    L59:
        r5 = e4.e(a.a().c());
        goto L53
    L49:
        r3 = g4.f(a.a().c());
        goto L192
    L50:
        r3 = g4.a();
        goto L192
    L51:
        r3 = k4.a(a.a().c());
        goto L192
    L52:
        r5 = f4.a(a.a().c());
        goto L53
    L54:
        r3 = g4.b(a.a().c());
        goto L192
    L55:
        r3 = j4.a(a.a().c());
        goto L192
    L14:
        Context r41 = a.a().c();
        JSONArray r42 = new JSONArray();
        AccessibilityManager r43 = (AccessibilityManager) r41.getSystemService((String) m.a(16777217, 0, 0, "6cbfeb", new byte[]{38, 98, 18, 23, 73, 102, 60, 64, 58, 58, 46, 117, 8}));
        if (r43 != null) goto L200;
    L34:
        r3 = r42.toString();
        goto L192
    L200:
        Method r44 = r43.getClass().getDeclaredMethod((String) m.a(16777217, 0, 0, "de3a14", new byte[]{114, 98, 84, 60, 0, 48, 115, 69, 110, 61, 112, 99, 97, 22, 13, 38, 116, 87, 107, 51, 124, 107, 73, 1, 23, 16, 98, 86, 116, 56, 118, 98, 108, 28, 29, 55}), new Class[0]);     // Catch: Throwable -> L199
        if (r44 == null) goto L21;
        List r45 = (List) r44.invoke(r43, new Object[0]);     // Catch: Throwable -> L199
    L22:
        if (r45 == null) goto L34;
        if (r45.size() == 0) goto L34;
        Iterator r46 = r45.iterator();
    L28:
        if (r46.hasNext() == false) goto L34;
        AccessibilityServiceInfo r47 = (AccessibilityServiceInfo) r46.next();
        JSONObject r48 = new JSONObject();
        r48.put((String) m.a(16777217, 0, 0, "bbde03", new byte[]{118, 118}), r47.eventTypes);     // Catch: Throwable -> L198
        r48.put((String) m.a(16777217, 0, 0, "74e3bb", new byte[]{47, 50}), r47.getId());     // Catch: Throwable -> L198
        r42.put(r48);     // Catch: Throwable -> L198
    L21:
        r45 = null;
        goto L22
    L35:
        Context r49 = a.a().c();
        PackageManager r50 = r49.getPackageManager();
        String r51 = r49.getPackageName();
        if (r34 != null) goto L38;
    L40:
        Signature[] r52 = r50.getPackageInfo(r51, 64).signatures;
        if (r52 == null) goto L117;
        if (r52.length <= 0) goto L117;
        r3 = r52[0].toByteArray();
        goto L192
    L38:
        if (r34.isEmpty() == true) goto L40;
        r51 = r34;
        goto L40
    L45:
        Context r53 = a.a().c();
        ApplicationInfo r54 = r53.getPackageManager().getApplicationInfo(r53.getPackageName(), 0);
        r10 = r54.sourceDir;
        if (r10 != 0) goto L47;
        r3 = r54.publicSourceDir;
        goto L192
    L184:
        r0 = f22404b;
        goto L186
    }
}
