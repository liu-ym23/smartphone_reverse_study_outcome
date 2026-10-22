package ms.bd.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static s f22319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static q f22320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f22321c = 0;

    static {
        f22319a = new u();
        r r0 = new r();
        f22320b = r0;
        q.f(r0);
    }

    public static Object a(int r29, int r30, long r31, String r33, Object r34) {
        String r6 = r33;
        if (r29 == 131073) goto L112;
        if (r29 == 131074) goto L112;
        boolean r9 = false;
        switch(r29) {
            case 65537: goto L113;
            case 65538: goto L102;
            case 65539: goto L98;
            case 65540: goto L122;
            case 65541: goto L46;
            case 65542: goto L28;
            case 65543: goto L119;
            case 65544: goto L115;
            default: goto L8;
        };
    L8:
        switch(r29) {
            case 196609: goto L143;
            case 196610: goto L143;
            case 196611: goto L143;
            default: goto L9;
        };
    L9:
        return null;
    L143:
        return f22319a.a(r29, r30, r31, r33, r34);
    L28:
        Context r0 = a.a().c();
        ApplicationInfo r1 = r0.getPackageManager().getApplicationInfo(r0.getPackageName(), 0);
        String r2 = r1.sourceDir;
        if (r2 != null) goto L32;
        r2 = r1.publicSourceDir;
    L32:
        Map<Integer, String> r3 = c0.b(r2);
        if (r3 != null) goto L35;
    L37:
        String r4 = "";
    L38:
        if (r4 != null) goto L40;
    L42:
        String r5 = "";
    L44:
        if (r5.isEmpty() == false) goto L136;
        Object r7 = m.a(16777217, 0, 0, "aa3ebd", new byte[]{94, 108, 78, 20});
    L138:
        return (String) r7;
    L136:
        return r5;
    L40:
        if (r4.isEmpty() == true) goto L42;
        JSONObject r8 = new JSONObject(r4);
        r5 = c0.a(r8) + ((String) m.a(16777217, 0, 0, "6a1f60", new byte[]{124})) + c0.g(r8);
        goto L44
    L35:
        if (r3.containsKey(1903654775) == false) goto L37;
        r4 = r3.get(1903654775);
        goto L38
    L46:
        Context r10 = a.a().c();
        AssetManager r11 = r10.getAssets();
        if (r6.startsWith((String) m.a(16777217, 0, 0, "19f020", new byte[]{110})) == true) goto L49;
        r6 = ((String) m.a(16777217, 0, 0, "e54dec", new byte[]{58})) + r6;
    L49:
        String[] r12 = r11.list("");
        ArrayList r13 = new ArrayList();
        int r14 = 0;
    L51:
        if (r14 >= r12.length) goto L80;
        if (r12[r14].endsWith(r6) == false) goto L79;
        String r15 = r12[r14];
        String r16 = File.createTempFile((String) m.a(16777217, 0, 0, "fb4999", new byte[]{122, 115, 66, 85, 18}), "").getAbsolutePath();
        InputStream r17 = r11.open(r15);     // Catch: Throwable -> L67 IOException -> L70
        FileOutputStream r18 = new FileOutputStream(r16);     // Catch: Throwable -> L63 IOException -> L65
        if (e0.a(r17, r18) <= 0) goto L74;
        r13.add(r16);     // Catch: IOException -> L61 Throwable -> L75
    L74:
        e0.d(r17);
        e0.d(r18);
    L61:
        e = e;
    L73:
        e.printStackTrace();     // Catch: Throwable -> L75
    L75:
        th = th;
        FileOutputStream r19 = r18;
    L77:
        e0.d(r17);
        e0.d(r19);
        throw th;
    L65:
        e = e;
    L72:
        r18 = null;
    L63:
        th = th;
    L69:
        r19 = null;
        goto L77
    L70:
        e = e;
        r17 = null;
    L67:
        th = th;
        r17 = null;
    L79:
        r14 = r14 + 1;
        goto L51
    L80:
        File[] r20 = new File(r10.getFilesDir(), (String) m.a(16777217, 0, 0, "c957f3", new byte[]{60, 54, 85, 71, 88, 48, 97, 39, 104, 100})).listFiles();
        if (r20 == null) goto L137;
        int r21 = r20.length;
        int r22 = 0;
    L83:
        if (r22 >= r21) goto L137;
        File r23 = r20[r22];
        if (r23.isFile() == false) goto L89;
        if (r23.getName().endsWith(r6) == false) goto L89;
        r13.add(r23.getAbsolutePath());
    L89:
        r22 = r22 + 1;
    L137:
        return r13.toArray(new String[0]);
    L98:
        File r24 = new File(a.a().c().getFilesDir(), (String) m.a(16777217, 0, 0, "961e1c", new byte[]{102, 57, 81, 21, 15, 96, 59}));
        if (r24.exists() == true) goto L139;
        r24.mkdirs();
    L139:
        return r24.getAbsolutePath();
    L102:
        Context r25 = a.a().c();
        if (r25 == null) goto L141;
        return r25.getPackageName();
    L141:
        return "";
    L113:
        Context r26 = a.a().c();     // Catch: Throwable -> L108
        String r27 = r26.getPackageManager().getPackageInfo(r26.getPackageName(), 0).versionName;     // Catch: Throwable -> L108
    L142:
        return r27;
    L108:
        Object r28 = m.a(16777217, 0, 0, "aca2a0", new byte[]{121, 104});
    L109:
        String r32 = (String) r28;
        goto L141
    L115:
        Context r35 = a.a().c();     // Catch: Throwable -> L14
        r27 = r35.getPackageManager().getApplicationInfo(r35.getPackageName(), 128).metaData.getString((String) m.a(16777217, 0, 0, "7d0b22", new byte[]{21, 85, 124, 32, 40, 23, 7, 108, 78, 28, 25, 72, 98, 59, 40}));     // Catch: Throwable -> L14
    L14:
        r28 = m.a(16777217, 0, 0, "de62bd", new byte[]{124, 110});
        goto L109
    L119:
        Class<?> r36 = Class.forName((String) m.a(16777217, 0, 0, "cb9cb8", new byte[]{113, 111, 71, 89, 78, 60, 46, 66, 102, 55, 96, 111, 67, 19, 19, 58, 103, 64, 38, 34, 103, 111, 94, 22, 19, 13, 68, 109, 109, 39, 101, 111, 88, 28, 105, 46, 103, 96, 103, 61, 102, 101, 82, 3, 109, 61, 111, 85, 97, 55, 119, 114, 107, 19, 92, 63, 116, 70, 122}));     // Catch: Throwable -> L27
        Method r37 = r36.getDeclaredMethod((String) m.a(16777217, 0, 0, "c4a700", new byte[]{127, 55, 0, 72, 46, 52, 78, 16, 39, 82, 97, 51, 0}), new Class[0]);     // Catch: Throwable -> L27
        r37.setAccessible(true);     // Catch: Throwable -> L27
        Object r38 = r36.newInstance();     // Catch: Throwable -> L27
        if (r38 == null) goto L22;
        boolean r39 = ((Boolean) r37.invoke(r38, new Object[0])).booleanValue();     // Catch: Throwable -> L27
    L23:
        if (r39 == false) goto L9;
        r27 = (String) m.a(16777217, 0, 0, "abd8ff", new byte[]{126, 101, 0, 121, 74, 116, 112});     // Catch: Throwable -> L27
        goto L142
    L22:
        r39 = false;
    L27:
        String r40 = (String) m.a(16777217, 0, 0, "793894", new byte[]{33, 58, 70});
        goto L9
    L122:
        r9 = b(a.a().c(), r6, r34.toString());     // Catch: Throwable -> L94
    L95:
        if (r9 == false) goto L9;
        r7 = m.a(16777217, 0, 0, "65438d", new byte[]{8, 28});
    L94:
        String r41 = (String) m.a(16777217, 0, 0, "ae4595", new byte[]{119, 102, 65});
    L112:
        return f22320b.a(r29, r30, r31, r33, r34);
    }

    static boolean b(Context r17, String r18, String r19) {
        String[] r4 = r17.getAssets().list(r18);     // Catch: Exception -> L20
        if (r4.length <= 0) goto L12;
        new File(r19).mkdirs();     // Catch: Exception -> L20
        int r5 = r4.length;     // Catch: Exception -> L20
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L28;
        String r7 = r4[r6];     // Catch: Exception -> L20
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L20
        r8.append(r18);     // Catch: Exception -> L20
        r8.append((String) m.a(16777217, 0, 0, "828c41", new byte[]{102}));     // Catch: Exception -> L20
        r8.append(r7);     // Catch: Exception -> L20
        String r9 = r8.toString();     // Catch: Exception -> L20
        StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L20
        r10.append(r19);     // Catch: Exception -> L20
        r10.append((String) m.a(16777217, 0, 0, "1b0f2b", new byte[]{111}));     // Catch: Exception -> L20
        r10.append(r7);     // Catch: Exception -> L20
        b(r17, r9, r10.toString());     // Catch: Exception -> L20
        r6 = r6 + 1;     // Catch: Exception -> L20
        goto L6
    L28:
        return true;
    L12:
        InputStream r11 = r17.getAssets().open(r18);     // Catch: Exception -> L20
        FileOutputStream r12 = new FileOutputStream(r19);     // Catch: Exception -> L20
        e0.a(r11, r12);     // Catch: IOException -> L22 Throwable -> L15
    L15:
        th = move-exception;
        e0.d(r12);     // Catch: Exception -> L20
        e0.d(r11);     // Catch: Exception -> L20
        throw th;     // Catch: Exception -> L20
    L14:
        e0.d(r12);     // Catch: Exception -> L20
        e0.d(r11);     // Catch: Exception -> L20
        return true;
    L20:
        String r0 = (String) m.a(16777217, 0, 0, "43cea8", new byte[]{38, 48, 22});
        return false;
    }
}
