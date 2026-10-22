package tmsdkobf;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.storage.StorageManager;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.UpdateConfig;

/* JADX INFO: loaded from: classes5.dex */
public abstract class z4 {
    private static boolean a(Context r16, String r17, boolean r18) {
        if (r18 == false) goto L5;
        return true;
    L5:
        Context r2 = TMSDKContext.getCurrentContext();
        if (r2 != null) goto L60;
        r2 = r16;
    L60:
        InputStream r3 = r2.getAssets().open(r17);     // Catch: Throwable -> L16
        byte[] r14 = new byte[28];     // Catch: Throwable -> L47
        r3.read(r14);     // Catch: Throwable -> L47
        int r1 = ((((r14[5] & UByte.MAX_VALUE) << 8) | (r14[4] & UByte.MAX_VALUE)) | ((r14[6] & UByte.MAX_VALUE) << 16)) | ((r14[7] & UByte.MAX_VALUE) << 24);
        int r12 = ((((r14[25] & UByte.MAX_VALUE) << 8) | (r14[24] & UByte.MAX_VALUE)) | ((r14[26] & UByte.MAX_VALUE) << 16)) | ((r14[27] & UByte.MAX_VALUE) << 24);
        r3.close();     // Catch: IOException -> L41
    L54:
        FileInputStream r4 = new FileInputStream(r2.getFilesDir().toString() + File.separator + r17);     // Catch: Throwable -> L31
        byte[] r0 = new byte[28];     // Catch: Throwable -> L29
        r4.read(r0);     // Catch: Throwable -> L29
        int r5 = (((r0[4] & UByte.MAX_VALUE) | ((r0[5] & UByte.MAX_VALUE) << 8)) | ((r0[6] & UByte.MAX_VALUE) << 16)) | ((r0[7] & UByte.MAX_VALUE) << 24);
        int r6 = ((r0[27] & UByte.MAX_VALUE) << 24) | (((r0[26] & UByte.MAX_VALUE) << 16) | (((r0[25] & UByte.MAX_VALUE) << 8) | (r0[24] & UByte.MAX_VALUE)));
        r4.close();     // Catch: IOException -> L42
    L35:
        if (r1 != r5) goto L39;
        if (r12 > r6) goto L39;
        return false;
    L39:
        return true;
    L30:
        int r7 = r5;
        r3 = r4;
    L32:
        if (r3 != null) goto L64;
    L34:
        r5 = r7;
        r6 = 0;
        goto L35
    L64:
        r3.close();     // Catch: IOException -> L44
    L29:
        r5 = 0;
    L31:
        r7 = 0;
    L18:
        if (r3 != null) goto L56;
    L20:
        r12 = 0;
        goto L54
    L56:
        r3.close();     // Catch: IOException -> L46
    L17:
        r1 = 0;
    L16:
        r3 = null;
        goto L17
    }

    public static boolean b(String r6) {
        String r0 = File.separator;
        if (r6.endsWith(r0) == true) goto L5;
        r6 = r6 + r0;
    L5:
        File r1 = new File(r6);
        if (r1.exists() == true) goto L8;
    L27:
        return false;
    L8:
        if (r1.isDirectory() == false) goto L27;
        File[] r7 = r1.listFiles();
        int r3 = 0;
        boolean r4 = true;
    L12:
        if (r3 >= r7.length) goto L22;
        if (r7[r3].isFile() == false) goto L18;
        r4 = c(r7[r3].getAbsolutePath());
        if (r4 == false) goto L22;
    L21:
        r3 = r3 + 1;
        goto L12
    L18:
        r4 = b(r7[r3].getAbsolutePath());
        if (r4 == true) goto L21;
    L22:
        if (r4 == true) goto L25;
        return false;
    L25:
        if (r1.delete() == false) goto L27;
        return true;
    }

    public static boolean c(String r2) {
        File r1 = new File(r2);     // Catch: Exception -> L8
        if (r1.isFile() == true) goto L6;
        return false;
    L6:
        return r1.delete();
    L8:
        return false;
    }

    private static boolean a(Context r5, String r6) {
        File r1 = new File(TMSDKContext.getApplicaionContext().getFilesDir() + File.separator + r6);
        if (r1.exists() == true) goto L5;
        return true;
    L5:
        FileInputStream r0 = null;
        Context r4 = TMSDKContext.getCurrentContext();     // Catch: Throwable -> L14
        if (r4 == null) goto L10;
        r5 = r4;
    L10:
        InputStream r7 = r5.getAssets().open(r6, 1);     // Catch: Throwable -> L14
        int r8 = w4.a(r7).b;     // Catch: Throwable -> L36
        if (r7 != null) goto L49;
    L18:
        if (r8 != 0) goto L39;
        return false;
    L39:
        FileInputStream r9 = new FileInputStream(r1);     // Catch: Throwable -> L34
        int r2 = w4.a(r9).b;     // Catch: Throwable -> L24
        r9.close();     // Catch: Throwable -> L33
    L28:
        if (r8 <= r2) goto L31;
        return true;
    L31:
        return false;
    L24:
        r0 = r9;
    L25:
        if (r0 != null) goto L41;
    L27:
        r2 = 0;
        goto L28
    L41:
        r0.close();     // Catch: Throwable -> L35
    L49:
        r7.close();     // Catch: Throwable -> L32
    L15:
        r8 = 0;
        if (r7 == null) goto L18;
    L14:
        r7 = null;
        goto L15
    }

    public static void b(File r1) {
        if (r1.exists() == false) goto L6;
        r1.delete();
        return;
    }

    private static boolean a(Context r11) {
        Context r0 = TMSDKContext.getCurrentContext();
        if (r0 == null) goto L48;
        r11 = r0;
    L48:
        InputStream r1 = r11.getAssets().open(UpdateConfig.LOCATION_NAME, 1);     // Catch: Throwable -> L12
        byte[] r8 = new byte[8];     // Catch: Throwable -> L34
        r1.read(r8);     // Catch: Throwable -> L34
        int r9 = ((r8[7] & UByte.MAX_VALUE) << 24) | (((r8[4] & UByte.MAX_VALUE) | ((r8[5] & UByte.MAX_VALUE) << 8)) | ((r8[6] & UByte.MAX_VALUE) << 16));
        r1.close();     // Catch: IOException -> L30
    L44:
        FileInputStream r10 = new FileInputStream(r11.getFilesDir().toString() + File.separator + UpdateConfig.LOCATION_NAME);     // Catch: Throwable -> L32
        byte[] r12 = new byte[8];     // Catch: Throwable -> L22
        r10.read(r12);     // Catch: Throwable -> L22
        int r13 = ((r12[7] & UByte.MAX_VALUE) << 24) | (((r12[4] & UByte.MAX_VALUE) | ((r12[5] & UByte.MAX_VALUE) << 8)) | ((r12[6] & UByte.MAX_VALUE) << 16));
        r10.close();     // Catch: IOException -> L31
    L26:
        if (r9 <= r13) goto L29;
        return true;
    L29:
        return false;
    L22:
        r1 = r10;
    L23:
        if (r1 != null) goto L42;
    L25:
        r13 = 0;
        goto L26
    L42:
        r1.close();     // Catch: IOException -> L33
    L13:
        if (r1 != null) goto L36;
    L15:
        r9 = 0;
        goto L44
    L36:
        r1.close();     // Catch: IOException -> L35
    L12:
        r1 = null;
        goto L13
    }

    public static List b(Context r11) {
        StorageManager r12 = (StorageManager) r11.getSystemService("storage");
        ArrayList r0 = new ArrayList();
        Object[] r1 = (Object[]) r12.getClass().getMethod("getVolumeList", new Class[0]).invoke(r12, new Object[0]);     // Catch: Throwable -> L16
        if (r1 == null) goto L15;
        if (r1.length <= 0) goto L15;
        Method r2 = r1[0].getClass().getDeclaredMethod("getPath", new Class[0]);     // Catch: Throwable -> L16
        Method r4 = r12.getClass().getMethod("getVolumeState", new Class[]{String.class});     // Catch: Throwable -> L16
        int r5 = r1.length;     // Catch: Throwable -> L16
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L15;
        String r8 = (String) r2.invoke(r1[r7], new Object[0]);     // Catch: Throwable -> L16
        if (r8 == null) goto L14;
        if ("mounted".equals(r4.invoke(r12, new Object[]{r8})) == false) goto L14;
        r0.add(r8);     // Catch: Throwable -> L16
    L14:
        r7 = r7 + 1;
    L15:
        return r0;
    }

    public static boolean a(String r3, String r4) {
        if (r3 != null) goto L5;
    L32:
        return false;
    L5:
        if (r3.length() == 0) goto L32;
        File r1 = new File(r3);
        if (r1.exists() == false) goto L32;
        if (r1.canRead() == false) goto L32;
        FileInputStream r5 = null;
        File r2 = new File(r4);     // Catch: Throwable -> L27
        b(r2);     // Catch: Throwable -> L27
        FileInputStream r6 = new FileInputStream(r1);     // Catch: Throwable -> L27
        FileOutputStream r7 = new FileOutputStream(r2);     // Catch: Throwable -> L25
        byte[] r8 = new byte[8192];     // Catch: Throwable -> L35
    L17:
        int r9 = r6.read(r8);     // Catch: Throwable -> L35
        if (r9 <= 0) goto L20;
        r7.write(r8, 0, r9);     // Catch: Throwable -> L35
        goto L17
    L20:
        r7.flush();     // Catch: Throwable -> L35
        r6.close();     // Catch: Throwable -> L33
    L44:
        r7.close();     // Catch: Throwable -> L34
        return true;
    L53:
        return true;
    L26:
        r5 = r6;
    L28:
        if (r5 != null) goto L38;
    L30:
        if (r7 == null) goto L32;
        r7.close();     // Catch: Throwable -> L37
        goto L32
    L38:
        r5.close();     // Catch: Throwable -> L36
    L25:
        r7 = null;
    L27:
        r7 = null;
        goto L28
    }

    public static final String b(String r2, String r3) {
        String r4 = Uri.decode(r2);
        if (r4 == null) goto L12;
        int r0 = r4.indexOf(63);
        if (r0 <= 0) goto L8;
        r4 = r4.substring(0, r0);
    L8:
        if (r4.endsWith(LibrarianImpl.Constants.SEPARATOR) == true) goto L12;
        int r1 = r4.lastIndexOf(47) + 1;
        if (r1 <= 0) goto L12;
        String r5 = r4.substring(r1);
    L13:
        if (r5 == null) goto L16;
        r3 = r5;
    L16:
        if (r3 != null) goto L19;
        return "downloadfile";
    L19:
        return r3;
    L12:
        r5 = null;
        goto L13
    }

    public static boolean a(String r2) {
        File r0 = new File(r2);
        if (r0.exists() == true) goto L7;
        return false;
    L7:
        if (r0.isFile() == false) goto L11;
        return c(r2);
    L11:
        return b(r2);
    }

    public static boolean b() {
        String r0 = Environment.getExternalStorageDirectory().toString() + "/DCIM";
        File r1 = new File(r0);
        if (r1.isDirectory() == false) goto L5;
    L7:
        File r2 = new File(r0, ".probe");
    L17:
        return false;
    L9:
        if (r2.exists() == false) goto L12;
        r2.delete();     // Catch: Throwable -> L17
    L12:
        if (r2.createNewFile() == true) goto L14;
        return false;
    L14:
        r2.delete();     // Catch: Throwable -> L17
        return true;
    L5:
        if (r1.mkdirs() == true) goto L7;
        return false;
    }

    public static boolean a(File r8) {
        if (r8.isDirectory() == false) goto L10;
        String[] r0 = r8.list();
        int r3 = r0.length;
        int r4 = 0;
        boolean r5 = true;
    L5:
        if (r4 >= r3) goto L11;
        if (a(new File(r8, r0[r4])) == true) goto L9;
        r5 = false;
    L9:
        r4 = r4 + 1;
    L11:
        boolean r9 = r8.delete();
        if (r5 == false) goto L19;
        if (r9 == true) goto L15;
        return false;
    L15:
        return true;
    L19:
        return false;
    L10:
        r5 = true;
        goto L11
    }

    public static synchronized String a(Context r12, String r13, String r14) {
        monitor-enter(z4.class);
        Context r1 = TMSDKContext.getCurrentContext();     // Catch: Throwable -> L106
        if (r1 == null) goto L8;
        r12 = r1;
    L8:
        if (r12 == null) goto L129;
    L12:
        if (r14 != null) goto L14;
    L15:
        r14 = r12.getFilesDir().toString();     // Catch: Throwable -> L106
    L16:
        File r2 = new File(r14);     // Catch: Throwable -> L106
        if (r2.exists() == true) goto L19;
    L20:
        r2.mkdirs();     // Catch: Throwable -> L106
    L21:
        StringBuilder r15 = new StringBuilder().append(r14);     // Catch: Throwable -> L106
        String r3 = File.separator;     // Catch: Throwable -> L106
        String r16 = r15.append(r3).append(r13).toString();     // Catch: Throwable -> L106
        InputStream r4 = null;
        File r5 = new File(r16);     // Catch: Throwable -> L87 IOException -> L89
        boolean r6 = r5.exists();     // Catch: Throwable -> L87 IOException -> L89
        boolean r7 = UpdateConfig.isUpdatableAssetFile(r13);     // Catch: Throwable -> L87 IOException -> L89
        if (r7 == true) goto L29;
        if (UpdateConfig.isFactoryUpdatableAssetFile(r13) == false) goto L29;
        r7 = true;
    L29:
        if (r6 == true) goto L39;
        if (r7 == false) goto L39;
        String r8 = UpdateConfig.sDeprecatedNameMap.get(r13);     // Catch: Throwable -> L87 IOException -> L89
        if (r8 == null) goto L39;
        String r9 = r16.substring(0, r16.lastIndexOf(r3) + 1) + r8;     // Catch: Throwable -> L87 IOException -> L89
        File r10 = new File(r9);     // Catch: Throwable -> L87 IOException -> L89
        File r11 = new File(r9 + UpdateConfig.PATCH_SUFIX);     // Catch: Throwable -> L87 IOException -> L89
        if (r10.exists() == false) goto L37;
        r10.delete();     // Catch: Throwable -> L87 IOException -> L89
    L37:
        if (r11.exists() == false) goto L39;
        r11.delete();     // Catch: Throwable -> L87 IOException -> L89
    L39:
        if (r6 == true) goto L41;
    L68:
        b(r5);     // Catch: Throwable -> L87 IOException -> L89
        InputStream r17 = r12.getResources().getAssets().open(r13, 1);     // Catch: Throwable -> L87 IOException -> L89
    L137:
        FileOutputStream r18 = new FileOutputStream(r5);     // Catch: Throwable -> L85 IOException -> L117
        goto L90
    L139:
        byte[] r19 = new byte[8192];     // Catch: Throwable -> L83 IOException -> L114
    L72:
        int r20 = r17.read(r19);     // Catch: Throwable -> L83 IOException -> L114
        if (r20 <= 0) goto L75;
        r18.write(r19, 0, r20);     // Catch: Throwable -> L83 IOException -> L114
        goto L72
    L75:
        r18.getChannel().force(true);     // Catch: Throwable -> L83 IOException -> L114
        r18.flush();     // Catch: Throwable -> L83 IOException -> L114
        r4 = r17;
    L77:
        if (r4 != null) goto L122;
    L79:
        if (r18 != null) goto L118;
    L81:
        monitor-exit(z4.class);
        return r16;
    L118:
        r18.close();     // Catch: IOException -> L111 Throwable -> L106
        goto L81
    L122:
        r4.close();     // Catch: IOException -> L110 Throwable -> L106
        goto L79
    L83:
        Throwable th = th;
    L101:
        if (r17 != null) goto L127;
    L103:
        if (r18 == null) goto L142;
        r18.close();     // Catch: IOException -> L113 Throwable -> L106
        throw th;     // Catch: Throwable -> L106
    L143:
        throw th;     // Catch: Throwable -> L106
    L142:
        throw th;     // Catch: Throwable -> L106
    L127:
        r17.close();     // Catch: IOException -> L112 Throwable -> L106
    L91:
        r4 = r17;
        q8.b("getCommonFilePath", "getCommonFilePath error");     // Catch: Throwable -> L99
        if (r4 != null) goto L120;
    L95:
        if (r18 != null) goto L133;
    L97:
        monitor-exit(z4.class);
        return "";
    L133:
        r18.close();     // Catch: IOException -> L116 Throwable -> L106
        goto L97
    L120:
        r4.close();     // Catch: IOException -> L115 Throwable -> L106
    L99:
        th = th;
    L100:
        th = th;
        r17 = r4;
    L85:
        th = move-exception;
        r4 = r17;
        th = th;
        r18 = null;
    L90:
        r18 = null;
        goto L91
    L41:
        if (r13.equals("MToken.zip") == true) goto L68;
        String r21 = UpdateConfig.VIRUS_BASE_NAME;     // Catch: Throwable -> L87 IOException -> L89
        if (r13.equals(r21) == true) goto L49;
        if (r13.equals(UpdateConfig.VIRUS_BASE_EN_NAME) == true) goto L49;
        if (r13.equals(UpdateConfig.PAYLOAD_NAME) == true) goto L49;
    L50:
        String r22 = UpdateConfig.LOCATION_NAME;     // Catch: Throwable -> L87 IOException -> L89
        if (r13.equals(r22) == true) goto L53;
    L54:
        if (r7 == true) goto L56;
    L65:
        if (r7 == false) goto L68;
        r18 = null;
        goto L77
    L56:
        if (r13.equals(r21) == true) goto L65;
        if (r13.equals(UpdateConfig.VIRUS_BASE_EN_NAME) == true) goto L65;
        if (r13.equals(UpdateConfig.PAYLOAD_NAME) == true) goto L65;
        if (r13.equals(r22) == true) goto L65;
        if (a(r12, r13) == true) goto L68;
    L53:
        if (a(r12) == true) goto L68;
    L49:
        if (a(r12, r13, false) == true) goto L68;
    L89:
        r17 = null;
    L87:
        th = th;
        r18 = null;
        goto L100
    L19:
        if (r2.isDirectory() == true) goto L21;
    L14:
        if (r14.equals("") == false) goto L16;
    L129:
        throw new Exception("TMSDKContext is null");     // Catch: Throwable -> L109
    L106:
        th = move-exception;
        throw th;
    }

    public static int a(long r2) {
        if (a() == true) goto L7;
        return 1;
    L7:
        if (b() == true) goto L10;
        return 2;
    L10:
        la.a r0 = new la.a();
        la.a(r0);
        if (r0.f327a >= r2) goto L14;
        return 3;
    L14:
        return 0;
    }

    public static boolean a() {
        String r1 = Environment.getExternalStorageState();     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.equals("mounted");
    L11:
        return false;
    }

    public static String a(InputStream r4) {
        StringBuilder r0 = new StringBuilder();
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r4, StandardCharsets.UTF_8));     // Catch: IOException -> L18
        char[] r5 = new char[1024];     // Catch: Throwable -> L12
    L6:
        int r2 = r1.read(r5);     // Catch: Throwable -> L12
        if (r2 == (-1)) goto L10;
        r0.append(r5, 0, r2);     // Catch: Throwable -> L12
    L10:
        r1.close();     // Catch: IOException -> L18
    L21:
        return r0.toString();
    L12:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: IOException -> L18
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L18
    L18:
        e = move-exception;
        q8.b("FileUtil", e);
        goto L21
    }
}
