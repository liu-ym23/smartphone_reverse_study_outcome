package tmsdkobf;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Pattern;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.UpdateConfig;

/* JADX INFO: loaded from: classes5.dex */
public abstract class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Properties f528a;
    private static volatile boolean b;

    static {
        f528a = new Properties();
        b = false;
    }

    private static synchronized void a(int r3) {
        monitor-enter(tb.class);
        if (r3 != 0) goto L6;
        f528a.setProperty("scan_item_empty_folders", "Empty Folder");     // Catch: Throwable -> L22
        f528a.setProperty("broken_apk", "Broken File");     // Catch: Throwable -> L22
        f528a.setProperty("deep_clean_other_rubbish", "Other Rubbish");     // Catch: Throwable -> L22
        f528a.setProperty("deep_clean_initializing", "Initializing");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_sys_camera_cache", "Camera Cache");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_temp_files", "Temp Files");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_temp_piture", "Temp Picture");     // Catch: Throwable -> L22
        f528a.setProperty("in_recent_days", "in recent %d days");     // Catch: Throwable -> L22
        f528a.setProperty("days_ago", "%d days ago");     // Catch: Throwable -> L22
        f528a.setProperty("apk_old_version", "Old version");     // Catch: Throwable -> L22
        f528a.setProperty("apk_installed", "Installed");     // Catch: Throwable -> L22
        f528a.setProperty("apk_repeated", "Repeated");     // Catch: Throwable -> L22
        f528a.setProperty("apk_new_version", "New version");     // Catch: Throwable -> L22
        f528a.setProperty("apk_not_installed", "Not installed");     // Catch: Throwable -> L22
        Properties r4 = f528a;     // Catch: Throwable -> L22
        String r1 = "apk";
        String r2 = "package";
    L14:
        r4.setProperty(r1, r2);     // Catch: Throwable -> L22
        monitor-exit(tb.class);
        return;
    L6:
        if (r3 != 2) goto L8;
    L17:
        f528a.setProperty("scan_item_empty_folders", "空資料夾");     // Catch: Throwable -> L22
        f528a.setProperty("broken_apk", "破損安裝包");     // Catch: Throwable -> L22
        f528a.setProperty("deep_clean_other_rubbish", "其他垃圾");     // Catch: Throwable -> L22
        f528a.setProperty("deep_clean_initializing", "初始化中");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_sys_camera_cache", "系統相機緩存");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_temp_files", "暫存檔案");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_temp_piture", "系統相冊縮略圖");     // Catch: Throwable -> L22
        f528a.setProperty("in_recent_days", "近 %d天");     // Catch: Throwable -> L22
        f528a.setProperty("days_ago", "%d天前");     // Catch: Throwable -> L22
        f528a.setProperty("apk_old_version", "舊版");     // Catch: Throwable -> L22
        f528a.setProperty("apk_installed", "已安裝");     // Catch: Throwable -> L22
        f528a.setProperty("apk_repeated", "重複");     // Catch: Throwable -> L22
        f528a.setProperty("apk_new_version", "新版");     // Catch: Throwable -> L22
        f528a.setProperty("apk_not_installed", "未安裝");     // Catch: Throwable -> L22
        r4 = f528a;     // Catch: Throwable -> L22
        r1 = "apk";
        r2 = "安裝包";
        goto L14
    L8:
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L12;
        f528a.setProperty("scan_item_empty_folders", "ཡིག་ཁུག་སྟོང་པ་");     // Catch: Throwable -> L22
        f528a.setProperty("broken_apk", "ཆག་སྐྱོན་སྒྲིག་སྦྱོར་ཁུག་མ་");     // Catch: Throwable -> L22
        f528a.setProperty("deep_clean_other_rubbish", "གད་སྙིགས་གཞན་པ།");     // Catch: Throwable -> L22
        f528a.setProperty("deep_clean_initializing", "འགོ་སྒྲིག་ཁྲོད།");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_sys_camera_cache", "རྒྱུད་ཁོངས་པར་ཆས་ལྷོད་གསོག་");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_temp_files", "གནས་སྐབས་ཡིག་ཆ་");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_temp_piture", "རྒྱུད་ཁོངས་པར་དེབ་བསྡུས་སྡུད་རི་མོ་");     // Catch: Throwable -> L22
        f528a.setProperty("in_recent_days", "ཉེ་བའི་%dགནམ");     // Catch: Throwable -> L22
        f528a.setProperty("days_ago", "%dཉིན་གྱི་སྔོན་ལ");     // Catch: Throwable -> L22
        f528a.setProperty("apk_old_version", "པར་གཞི་རྙིང་པ་");     // Catch: Throwable -> L22
        f528a.setProperty("apk_installed", "པར་གཞི་རྙིང་པ་");     // Catch: Throwable -> L22
        f528a.setProperty("apk_repeated", "བསྐྱར་ཟློས་");     // Catch: Throwable -> L22
        f528a.setProperty("apk_new_version", "པར་གཞི་གསར་པ།");     // Catch: Throwable -> L22
        f528a.setProperty("apk_not_installed", "པར་གཞི་གསར་པ།");     // Catch: Throwable -> L22
        r4 = f528a;     // Catch: Throwable -> L22
        r1 = "apk";
        r2 = "སྒྲིག་སྦྱོར་ཁུག་མ་";
        goto L14
    L12:
        if (r3 == 5) goto L15;
        f528a.setProperty("scan_item_empty_folders", "空文件夹");     // Catch: Throwable -> L22
        f528a.setProperty("broken_apk", "破损安装包");     // Catch: Throwable -> L22
        f528a.setProperty("deep_clean_other_rubbish", "其他垃圾");     // Catch: Throwable -> L22
        f528a.setProperty("deep_clean_initializing", "初始化中");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_sys_camera_cache", "系统相机缓存");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_temp_files", "临时文件");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_temp_piture", "系统相册缩略图");     // Catch: Throwable -> L22
        f528a.setProperty("in_recent_days", "近%d天");     // Catch: Throwable -> L22
        f528a.setProperty("days_ago", "%d天前");     // Catch: Throwable -> L22
        f528a.setProperty("apk_old_version", "旧版");     // Catch: Throwable -> L22
        f528a.setProperty("apk_installed", "已安装");     // Catch: Throwable -> L22
        f528a.setProperty("apk_repeated", "重复");     // Catch: Throwable -> L22
        f528a.setProperty("apk_new_version", "新版");     // Catch: Throwable -> L22
        f528a.setProperty("apk_not_installed", "未安装");     // Catch: Throwable -> L22
        r4 = f528a;     // Catch: Throwable -> L22
        r1 = "apk";
        r2 = "安装包";
        goto L14
    L15:
        f528a.setProperty("scan_item_empty_folders", "كۈن ئىلگىرى");     // Catch: Throwable -> L22
        f528a.setProperty("broken_apk", "بۇزۇلغان قۇراشتۇرۇش بوغچىسى");     // Catch: Throwable -> L22
        f528a.setProperty("deep_clean_other_rubbish", "باشقا ئەخلەتلەر");     // Catch: Throwable -> L22
        f528a.setProperty("deep_clean_initializing", "دەسلەپكى باسقۇچتا");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_sys_camera_cache", "سىستېما كامېرا بۇفېر ساقلىغۇچ");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_temp_files", "ۋاقىتلىق ھۆججەت");     // Catch: Throwable -> L22
        f528a.setProperty("scan_item_temp_piture", "سىستېما رەسىم پىلاستىنكىسى قىسقارتىلغان رەسىم");     // Catch: Throwable -> L22
        f528a.setProperty("in_recent_days", "%dيېقىنقى كۈنلەر");     // Catch: Throwable -> L22
        f528a.setProperty("days_ago", "%dكۈن ئىلگىرى");     // Catch: Throwable -> L22
        f528a.setProperty("apk_old_version", "كونا نۇسخىسى");     // Catch: Throwable -> L22
        f528a.setProperty("apk_installed", "قاچىلانغان");     // Catch: Throwable -> L22
        f528a.setProperty("apk_repeated", "تەكرارلاش");     // Catch: Throwable -> L22
        f528a.setProperty("apk_new_version", "يېڭى نۇسخىسى");     // Catch: Throwable -> L22
        f528a.setProperty("apk_not_installed", "قاچىلانمىغان");     // Catch: Throwable -> L22
        r4 = f528a;     // Catch: Throwable -> L22
        r1 = "apk";
        r2 = "قاچىلاش بوغچىسى";
    L22:
        th = move-exception;
        throw th;
    }

    public static int b() {
        String r0 = h8.d().e().toLowerCase();
        String r1 = h8.d().f().toLowerCase();
        if (TextUtils.equals(r0, "zh") == false) goto L5;
    L28:
        String r2 = h8.d().b().toLowerCase();
        if (TextUtils.equals(r1, "hans") == false) goto L32;
        return 1;
    L32:
        if (TextUtils.equals(r1, "hant") == false) goto L41;
        if (TextUtils.equals(r2, "tw") == false) goto L36;
    L39:
        return 3;
    L36:
        if (TextUtils.equals(r2, "twn") == true) goto L39;
        return 2;
    L41:
        if (TextUtils.equals(r2, "tw") == false) goto L43;
    L59:
        return 3;
    L43:
        if (TextUtils.equals(r2, "twn") == true) goto L59;
        if (TextUtils.equals(r2, "hk") == false) goto L48;
    L58:
        return 2;
    L48:
        if (TextUtils.equals(r2, "hkg") == true) goto L58;
        if (TextUtils.equals(r2, "mo") == true) goto L58;
        if (TextUtils.equals(r2, "mac") == true) goto L58;
        if (TextUtils.equals(r2, "cn") == true) goto L57;
        TextUtils.equals(r2, "chn");
    L57:
        return 1;
    L5:
        if (TextUtils.equals(r0, "zho") == true) goto L28;
        if (TextUtils.equals(r0, "chi") == true) goto L28;
        if (TextUtils.equals(r0, "bo") == false) goto L12;
        return 4;
    L12:
        if (TextUtils.equals(r0, "bod") == false) goto L15;
        return 4;
    L15:
        if (TextUtils.equals(r0, "ug") == false) goto L17;
        return 5;
    L17:
        if (TextUtils.equals(r0, "uig") == false) goto L20;
        return 5;
    L20:
        if (TextUtils.equals(r0, "en") == true) goto L60;
        TextUtils.equals(r0, "eng");
        return 0;
    L60:
        return 0;
    }

    public static boolean c() {
        return b;
    }

    public static boolean d() {
        if (b == false) goto L5;
        return true;
    L5:
        String r0 = h8.d().e().toLowerCase();
        if (TextUtils.equals(r0, "zh") == false) goto L8;
        return false;
    L8:
        if (TextUtils.equals(r0, "zho") == false) goto L10;
        return false;
    L10:
        if (TextUtils.equals(r0, "chi") == false) goto L12;
        return false;
    L12:
        if (TextUtils.equals(r0, "bo") == false) goto L14;
        return false;
    L14:
        if (TextUtils.equals(r0, "bod") == false) goto L16;
        return false;
    L16:
        if (TextUtils.equals(r0, "ug") == false) goto L18;
        return false;
    L18:
        if (TextUtils.equals(r0, "uig") == true) goto L28;
        return true;
    L28:
        return false;
    }

    public static boolean e() {
        if (b == false) goto L5;
        return true;
    L5:
        String r0 = h8.d().e().toLowerCase();
        if (TextUtils.equals(r0, "zh") == false) goto L8;
        return true;
    L8:
        if (TextUtils.equals(r0, "zho") == false) goto L10;
        return true;
    L10:
        if (TextUtils.equals(r0, "chi") == false) goto L12;
        return true;
    L12:
        if (TextUtils.equals(r0, "bo") == false) goto L14;
        return true;
    L14:
        if (TextUtils.equals(r0, "bod") == false) goto L16;
        return true;
    L16:
        if (TextUtils.equals(r0, "ug") == false) goto L18;
        return true;
    L18:
        if (TextUtils.equals(r0, "uig") == false) goto L20;
        return true;
    L20:
        if (TextUtils.equals(r0, "en") == false) goto L22;
        return true;
    L22:
        if (TextUtils.equals(r0, "eng") == true) goto L34;
        return false;
    L34:
        return true;
    }

    private static boolean f() {
        f528a.clear();     // Catch: Throwable -> L59
        k2 r0 = (k2) mg.a(TMSDKContext.getApplicaionContext(), UpdateConfig.DEEP_CLEAN_APPGROUP_DESC, UpdateConfig.intToString(40350), new k2(), "UTF-8");     // Catch: Throwable -> L59
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.f299a == null) goto L104;
        int r2 = 3;
        if (c() == true) goto L11;
        r2 = 3 + b();     // Catch: Throwable -> L59
    L11:
        Iterator r1 = r0.f299a.iterator();     // Catch: Throwable -> L59
    L13:
        if (r1.hasNext() == false) goto L27;
        j2 r3 = (j2) r1.next();     // Catch: Throwable -> L59
        if (r3 == null) goto L13;
        if (TextUtils.equals(r3.f281a, String.valueOf(100)) == false) goto L13;
        if (TextUtils.isEmpty(r3.b) == true) goto L13;
        if (TextUtils.isEmpty(r3.c) == true) goto L13;
        if (TextUtils.isEmpty(r3.d) == true) goto L13;
        f528a.setProperty(r3.b, a(r3, r2));     // Catch: Throwable -> L59
        goto L13
    L27:
        if (e() == true) goto L62;
        String r4 = h8.d().e().toLowerCase();     // Catch: Throwable -> L59
        String r5 = h8.d().b().toLowerCase();     // Catch: Throwable -> L59
        String r6 = h8.d().f().toLowerCase();     // Catch: Throwable -> L59
        Iterator r7 = r0.f299a.iterator();     // Catch: Throwable -> L59
    L29:
        if (r7.hasNext() == false) goto L62;
        j2 r8 = (j2) r7.next();     // Catch: Throwable -> L59
        if (r8 == null) goto L29;
        if (TextUtils.equals(r8.f281a, String.valueOf(110)) == false) goto L29;
        if (TextUtils.isEmpty(r8.b) == true) goto L29;
        if (TextUtils.isEmpty(r8.c) == true) goto L29;
        if (TextUtils.isEmpty(r8.f) == true) goto L29;
        if (Pattern.compile(r8.f.toLowerCase()).matcher(r4).matches() == false) goto L29;
        String r9 = r8.g.toLowerCase();     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r9) == true) goto L50;
        if (Pattern.compile(r9).matcher(r5).matches() == false) goto L29;
    L50:
        String r10 = r8.h.toLowerCase();     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r10) == true) goto L55;
        if (Pattern.compile(r10).matcher(r6).matches() == false) goto L29;
    L55:
        f528a.setProperty(r8.b, r8.c);     // Catch: Throwable -> L59
    L62:
        return !f528a.isEmpty();
    L104:
        return false;
    L59:
        th = move-exception;
        q8.b("CleanRes", th);
        goto L62
    }

    private static synchronized void a(boolean r1) {
        monitor-enter(tb.class);
        b = r1;     // Catch: Throwable -> L10
        if (r1 == false) goto L7;
        a(0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(tb.class);
        return;
    L7:
        a(1);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static void b(boolean r1) {
        b = r1;
        if (f() == true) goto L8;
        if (r1 == false) goto L6;
        a(r1);
        return;
    L6:
        a();
        return;
    }

    private static synchronized void a() {
        monitor-enter(tb.class);
        a(b());     // Catch: Throwable -> L7
        monitor-exit(tb.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static String a(j2 r1, int r2) {
        if (r1 != null) goto L5;
        return "";
    L5:
        switch(r2) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            default: goto L6;
        };
    L6:
        return "";
    L8:
        return r1.h;
    L10:
        return r1.g;
    L12:
        return r1.f;
    L14:
        return r1.e;
    L16:
        return r1.d;
    L18:
        return r1.c;
    L20:
        return r1.b;
    L22:
        return r1.f281a;
    }

    public static synchronized String a(String r2) {
        monitor-enter(tb.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L7;
        String r3 = f528a.getProperty(r2);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r3) == true) goto L14;
        monitor-exit(tb.class);
        return r3;
    L14:
        monitor-exit(tb.class);
        return "";
    L7:
        monitor-exit(tb.class);
        return "";
    }
}
