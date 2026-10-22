package tmsdkobf;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;
import org.json.JSONTokener;
import tmsdk.common.tcc.TccCryptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f108a = "";

    public static final enum a extends Enum {
        public static final a d = null;
        public static final a e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        public static final a j = null;
        private static final /* synthetic */ a[] k = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f109a;
        private final int b;
        private final String c;

        static {
            d = new a("DOMESTIC", 0, "configuration_common_domestic.json", 0, "国内正式");
            e = new a("DOMESTIC_PRE", 1, "configuration_common_domestic_pre.json", 1, "国内预发布");
            f = new a("HUAWEI_ABROAD", 2, "configuration_huawei_abroad.json", 2, "华为海外正式");
            g = new a("SINGAPORE_ABROAD", 3, "configuration_singapore_abroad.json", 3, "新加坡海外正式");
            h = new a("SINGAPORE_ABROAD_PRE", 4, "configuration_singapore_abroad_pre.json", 4, "新加坡海外预发布");
            i = new a("FRANKFURT_ABROAD", 5, "configuration_frankfurt_abroad.json", 5, "法兰克福海外正式");
            j = new a("COMMON_POC_ABROAD", 6, "configuration_common_poc_abroad.json", 6, "通用POC专用海外正式");
            k = a();
        }

        private a(String r1, int r2, String r3, int r4, String r5) {
            super(r1, r2);
            this.f109a = r3;
            this.b = r4;
            this.c = r5;
        }

        private static /* synthetic */ a[] a() {
            return new a[]{d, e, f, g, h, i, j};
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) k.clone();
        }

        public String b() {
            return this.f109a;
        }

        public String c() {
            return this.c;
        }
    }

    static {
    }

    public static String a() {
        return f108a;
    }

    public static String b() {
        String r0 = f108a;
        if (r0 != null) goto L7;
        return "";
    L7:
        if (r0.contains("_e.json") == false) goto L9;
        r0 = r0.replace("_e.json", ".json");
    L9:
        a[] r1 = a.values();
        int r2 = r1.length;
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L16;
        a r4 = r1[r3];
        if (r4.b().equals(r0) == true) goto L14;
        r3 = r3 + 1;
        goto L10
    L14:
        return r4.c();
    L16:
        return r0;
    }

    public static boolean c() {
        if (b0$$ExternalSyntheticBackport0.m(f108a) == false) goto L7;
        return false;
    L7:
        return f108a.contains("_abroad");
    }

    public static boolean d() {
        if (b0$$ExternalSyntheticBackport0.m(f108a) == false) goto L7;
        return false;
    L7:
        return f108a.contains("_pre");
    }

    public static int a(Context r10) {
        String r4 = f108a;
        if (r4 != null) goto L5;
    L42:
        Log.e(b0.TAG_INIT, "TMS configuration file does not exist !");
        return -1;
    L5:
        if (b0$$ExternalSyntheticBackport0.m(r4) == true) goto L42;
        InputStream r5 = null;
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L25 Throwable -> L27
        InputStream r11 = r10.getAssets().open("configurations" + File.separator + f108a);     // Catch: Throwable -> L25 Throwable -> L27
    L23:
        e = e;
        r5 = r11;
    L28:
        Log.e(b0.TAG_INIT, "TMS configuration file is corrupt !");     // Catch: Throwable -> L25
        f108a = "";     // Catch: Throwable -> L25
        q8.a("FileConfigurations", "Failed to initialize configuration", e);     // Catch: Throwable -> L25
        if (r5 == null) goto L57;
        r5.close();     // Catch: IOException -> L32
        return 0;
    L32:
        e = move-exception;
        q8.a("FileConfigurations", "Failed to initialize configuration", e);
        return 0;
    L57:
        return 0;
    L21:
        th = th;
        r5 = r11;
    L36:
        if (r5 != null) goto L50;
    L41:
        throw th;
    L50:
        r5.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        q8.a("FileConfigurations", "Failed to initialize configuration", e);
        goto L41
    L10:
        if (f108a.endsWith("_e.json") == false) goto L12;
        byte[] r3 = new byte[r11.available()];     // Catch: Throwable -> L21 Throwable -> L23
        r11.read(r3);     // Catch: Throwable -> L21 Throwable -> L23
        String r8 = new String(TccCryptor.decrypt(r3, null));     // Catch: Throwable -> L21 Throwable -> L23
    L13:
        JSONObject r7 = new JSONObject(new JSONTokener(r8));     // Catch: Throwable -> L21 Throwable -> L23
        m6.a(r7);     // Catch: Throwable -> L21 Throwable -> L23
        ig.a(r7);     // Catch: Throwable -> L21 Throwable -> L23
        q8.c("FileConfigurations", "initializetime:" + (System.currentTimeMillis() - r6));     // Catch: Throwable -> L21 Throwable -> L23
        if (r11 == null) goto L55;
        r11.close();     // Catch: IOException -> L17
        return 1;
    L17:
        e = move-exception;
        q8.a("FileConfigurations", "Failed to initialize configuration", e);
        return 1;
    L55:
        return 1;
    L12:
        r8 = z4.a(r11);     // Catch: Throwable -> L21 Throwable -> L23
    L25:
        th = th;
    L27:
        e = e;
        goto L28
    }

    public static boolean a(Context r7, String r8) {
        if (r8 != null) goto L25;
    L6:
        String[] r9 = r7.getAssets().list("configurations");     // Catch: IOException -> L22
        if (r9 == null) goto L14;
        int r3 = r9.length;     // Catch: IOException -> L22
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        String r5 = r9[r4];     // Catch: IOException -> L22
        if (r5.startsWith("configuration_") == true) goto L12;
        r4 = r4 + 1;     // Catch: IOException -> L22
        goto L9
    L12:
        r8 = r5;
    L14:
        if (r8 != null) goto L16;
    L20:
        Log.e(b0.TAG_INIT, "TMS configuration file does not exist !");     // Catch: IOException -> L22
        return false;
    L16:
        if (b0$$ExternalSyntheticBackport0.m(r8) == true) goto L20;
        q8.c("FileConfigurations", "configuration name:" + r8);     // Catch: IOException -> L22
        f108a = r8;     // Catch: IOException -> L22
        return true;
    L25:
    L22:
        e = move-exception;
        Log.e(b0.TAG_INIT, "TMS configuration file is corrupt !");
        f108a = "";
        q8.a("FileConfigurations", "Failed to initialize configuration", e);
        return false;
    L5:
        if (b0$$ExternalSyntheticBackport0.m(r8) == false) goto L14;
        goto L6
    }
}
