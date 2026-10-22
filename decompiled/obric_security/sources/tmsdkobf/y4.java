package tmsdkobf;

import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.preventdisturb.EventUtils;
import com.qq.taf.jce.JceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import tmsdk.common.TMSDKContext;
import tmsdk.common.TMServiceFactory;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.lang.MultiLangManager;
import tmsdk.common.module.update.UpdateConfig;
import tmsdk.common.tcc.DeepCleanEngine;
import tmsdk.common.tcc.QFile;
import tmsdk.common.tcc.SdcardScannerFactory;
import tmsdk.common.tcc.TccCryptor;

/* JADX INFO: loaded from: classes5.dex */
public class y4 {
    public static final List m = null;
    static DeepCleanEngine n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f632a;
    Map b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    private b i;
    private String j;
    private TreeMap k;
    private HashMap l;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f633a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        private String l;
        public String[] m;

        a() {
            this.f633a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = "";
            this.j = "";
            this.k = "";
            this.l = null;
            this.m = null;
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f634a;
        public String b;
        public String c;
        public List d;
        private String e;
        public HashMap f;
        public TreeMap g;
        public TreeMap h;
        boolean i;
        boolean j;

        b() {
            this.e = null;
            this.f = new HashMap();
            this.g = new TreeMap();
            this.h = new TreeMap();
            this.i = false;
            this.j = false;
        }

        public void a() {
            if (this.i == true) goto L35;
            List r0 = this.d;
            if (r0 == null) goto L36;
            Iterator r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L28;
            a r2 = (a) r1.next();
            if (this.j == true) goto L16;
            if (r2.f633a.equals(EventUtils.TO_APPMANAGER_ACTIVITY) == false) goto L16;
            this.j = true;
        L16:
            if (r2.b.contains("*") == false) goto L19;
            Map r3 = this.g;
            r2.m = r2.b.split(LibrarianImpl.Constants.SEPARATOR);
        L22:
            if (r3 == null) goto L9;
            List r4 = (List) r3.get(r2.b);
            if (r4 != null) goto L27;
            r4 = new ArrayList();
        L27:
            r4.add(r2);
            r3.put(r2.b, r4);
            goto L9
        L19:
            if (r2.b.contains("//") == false) goto L21;
            r3 = this.h;
            goto L22
        L21:
            r3 = this.f;
            goto L22
        L28:
            this.i = true;
            return;
        L36:
            return;
        }
    }

    static {
        m = ac.c();
        n = SdcardScannerFactory.getDeepCleanEngine(null);
    }

    public y4() {
        this.f632a = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = new HashMap();
    }

    private int a(a r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r2 = !r3.d.equals("") ? 1 : 0;
        if (r3.g.equals("") == true) goto L9;
        r2 = r2 + 1;
    L9:
        if (r3.h.equals("") == true) goto L12;
        r2 = r2 + 1;
    L12:
        if (r3.i.equals("") == true) goto L15;
        r2 = r2 + 1;
    L15:
        if (r3.j.equals("") == false) goto L17;
        return r2;
    L17:
        return r2 + 1;
    }

    private String b(String r1, boolean r2) {
        String[] r0 = e(r1, r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0[1];
    }

    private List c(String r9, boolean r10) {
        if (r9 != null) goto L37;
        return null;
    L37:
        byte[] r1 = n8.a().a(r9);     // Catch: Exception -> L34
        if (r1 == null) goto L9;
        JceInputStream r3 = new JceInputStream(r1);     // Catch: Exception -> L34
        r3.setServerEncoding("UTF-8");     // Catch: Exception -> L34
        mk r2 = new mk();     // Catch: Exception -> L34
        r2.readFrom(r3);     // Catch: Exception -> L34
        byte[] r4 = r2.b;     // Catch: Exception -> L34
    L10:
        if (r4 != null) goto L13;
        q8.b("xx", "null:" + r9);     // Catch: Exception -> L34
        return null;
    L13:
        JceInputStream r11 = new JceInputStream(TccCryptor.decrypt(r4, null));     // Catch: Exception -> L34
        r11.setServerEncoding("UTF-8");     // Catch: Exception -> L34
        kk r5 = new kk();     // Catch: Exception -> L34
        r5.readFrom(r11);     // Catch: Exception -> L34
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L34
        Iterator r6 = r5.f312a.iterator();     // Catch: Exception -> L34
    L15:
        if (r6.hasNext() == false) goto L33;
        Map r7 = (Map) r6.next();     // Catch: Exception -> L34
        if (r7.get(3) != null) goto L19;
        if (r7.get(4) == null) goto L15;
        a r8 = new a();     // Catch: Exception -> L34
        r8.f633a = EventUtils.TO_APPMANAGER_ACTIVITY;     // Catch: Exception -> L34
        r8.f = (String) r7.get(9);     // Catch: Exception -> L34
        String r13 = ((String) r7.get(4)).toLowerCase();     // Catch: Exception -> L34
        r8.b = r13;     // Catch: Exception -> L34
        r8.c = r9;     // Catch: Exception -> L34
        if (r13.equals(LibrarianImpl.Constants.SEPARATOR) == false) goto L29;
        r8.b = r9;     // Catch: Exception -> L34
    L30:
        r8.e = c2.b(tb.c(), r7);     // Catch: Exception -> L34
        r8.d = (String) r7.get(11);     // Catch: Exception -> L34
        r8.g = (String) r7.get(12);     // Catch: Exception -> L34
        r8.h = (String) r7.get(13);     // Catch: Exception -> L34
        r8.i = (String) r7.get(14);     // Catch: Exception -> L34
        r8.j = (String) r7.get(15);     // Catch: Exception -> L34
    L31:
        r12.add(r8);     // Catch: Exception -> L34
        goto L15
    L29:
        r8.b = r9 + r8.b.toLowerCase();     // Catch: Exception -> L34
        goto L30
    L19:
        r8 = new a();     // Catch: Exception -> L34
        r8.f633a = "3";     // Catch: Exception -> L34
        r8.f = (String) r7.get(9);     // Catch: Exception -> L34
        String r14 = ((String) r7.get(3)).toLowerCase();     // Catch: Exception -> L34
        r8.b = r14;     // Catch: Exception -> L34
        r8.c = r9;     // Catch: Exception -> L34
        if (r14.equals(LibrarianImpl.Constants.SEPARATOR) == false) goto L22;
        r8.b = r9;     // Catch: Exception -> L34
    L23:
        r8.e = c2.b(tb.c(), r7);     // Catch: Exception -> L34
        r8.k = (String) r7.get(10);     // Catch: Exception -> L34
        goto L31
    L22:
        r8.b = r9 + r8.b.toLowerCase();     // Catch: Exception -> L34
        goto L23
    L33:
        return r12;
    L9:
        r4 = null;
    L34:
        e = move-exception;
        q8.b("xx", e.getMessage());
        return null;
    }

    private String[] e(String r1, boolean r2) {
        return f(r1, r2);
    }

    private String[] f(String r4, boolean r5) {
        Map r3 = n8.a().a(r4, r5);
        if (r3 != null) goto L5;
    L33:
        return null;
    L5:
        if (r3.size() == 0) goto L33;
        ArrayList r6 = new ArrayList();
        ArrayList r0 = new ArrayList();
        Iterator r1 = r3.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        String r2 = (String) r1.next();
        r6.add(r2);     // Catch: Exception -> L34
        r0.add((String) r3.get(r2));     // Catch: Exception -> L34
        goto L9
    L13:
        v7 r7 = new v7();
        r7.a();
        String r8 = r7.a(r6);
        if (r8 != null) goto L19;
        int r9 = r7.b(r6);
        if (r9 != (-1)) goto L18;
        r9 = 0;
    L18:
        r8 = (String) r6.get(r9);
        String r10 = (String) r0.get(r9);
    L26:
        if (r10 == null) goto L32;
        if (r8 == null) goto L32;
        q8.b("xx", r8 + "  " + r10);
        return new String[]{r8.trim(), r10.trim()};
    L32:
        return new String[]{null, null};
    L19:
        m r11 = TMServiceFactory.getSystemInfoService().getAppInfo(r8, 2048);
        if (r11 == null) goto L25;
        String r12 = r11.b();
        if (r12 != null) goto L24;
        r10 = r7.a(r8);
        goto L26
    L24:
        r10 = r12;
        goto L26
    L25:
        r10 = null;
        r8 = null;
        goto L26
    }

    private String g(String r1, boolean r2) {
        String[] r0 = e(r1, r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0[0];
    }

    public String d(String r3, boolean r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        b r5 = b(r3, r3.split(LibrarianImpl.Constants.SEPARATOR));
        if (r5 != null) goto L9;
        return null;
    L9:
        if (r5.c != null) goto L14;
        String[] r2 = e(r5.f634a, r4);
        if (r2 == null) goto L14;
        r5.c = r2[0];
        r5.b = r2[1];
    L14:
        return r5.c;
    }

    private b b(String r7, String[] r8) {
        if (r7 == null) goto L14;
        if (r8 == null) goto L17;
        b r0 = this.i;
        if (r0 == null) goto L12;
        String r1 = r0.f634a;
        if (r1 == null) goto L12;
        if (r7.startsWith(r1) == false) goto L12;
        return this.i;
    L12:
        long r2 = System.currentTimeMillis();
        b r9 = a(r7, r8);
        this.h += System.currentTimeMillis() - r2;
        this.i = r9;
        return r9;
    L17:
        return null;
    L14:
        return null;
    }

    private void c() {
        ArrayList r0 = n8.a().b();
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) r1.next();
        b r3 = new b();
        r3.f634a = r2;
        this.l.put(r2, r3);
        goto L6
    L10:
        return;
    }

    public String a(String r3, boolean r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        b r5 = b(r3, r3.split(LibrarianImpl.Constants.SEPARATOR));
        if (r5 != null) goto L9;
        return null;
    L9:
        if (r5.b != null) goto L14;
        String[] r2 = e(r5.f634a, r4);
        if (r2 == null) goto L14;
        r5.c = r2[0];
        r5.b = r2[1];
    L14:
        return r5.b;
    }

    protected Map a() {
        ArrayList r5 = TMServiceFactory.getSystemInfoService().getInstalledApp(73, 2);
        int r0 = r5.size();
        HashMap r1 = new HashMap();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1.put(((m) r5.get(r2)).k(), (m) r5.get(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public void b() {
        boolean r0 = ((MultiLangManager) ManagerCreatorC.getManager(MultiLangManager.class)).isENG();
        tb.b(r0);
        z3 r1 = new z3();
        this.b = a();
        boolean r2 = r1.d();
        this.f632a = r2;
        if (r2 == false) goto L5;
        c();
        return;
    L5:
        a(r0);
    }

    private a a(b r17, String r18, String[] r19, QFile r20) {
        if (r17 == null) goto L148;
        List r4 = r17.d;
        if (r4 == null) goto L148;
        if (r4.size() == 0) goto L148;
        if (r19 == null) goto L148;
        if (r19.length <= 2) goto L23;
        int r5 = r19.length;
        String r11 = "";
        int r6 = 0;
        int r10 = 0;
    L13:
        if (r6 >= r5) goto L24;
        String r12 = r19[r6];
        r10 = r10 + 1;
        if (r10 == r19.length) goto L24;
        if (r12 == null) goto L22;
        if (r12.equals("") == true) goto L22;
        r11 = r11 + LibrarianImpl.Constants.SEPARATOR + r12;
    L22:
        r6 = r6 + 1;
    L24:
        String r7 = this.j;
        if (r7 != null) goto L27;
        this.j = r11;
    L31:
        TreeMap r8 = null;
        boolean r9 = false;
    L33:
        if (this.j != null) goto L35;
        return null;
    L35:
        if (r8 != null) goto L82;
        if (r9 == true) goto L82;
        r8 = new TreeMap();
        int r13 = r19.length;
        String r14 = "";
        int r15 = 0;
        int r16 = 0;
    L38:
        if (r15 >= r13) goto L58;
        String r110 = r19[r15];
        r16 = r16 + 1;
        if (r16 == r19.length) goto L58;
        if (r110 == null) goto L57;
        if (r110.equals("") == true) goto L57;
        r14 = r14 + LibrarianImpl.Constants.SEPARATOR + r110;
        List r111 = (List) r17.f.get(r14);
        if (r111 == null) goto L57;
        if (r17.j == false) goto L50;
        List r112 = (List) r8.get(Integer.valueOf(r16));
        if (r112 != null) goto L56;
        r112 = new ArrayList();
        r8.put(Integer.valueOf(r16), r112);
    L56:
        r112.addAll(r111);
        goto L57
    L50:
        ArrayList r1 = new ArrayList();
        r1.add((a) r111.get(0));
        r8.put(Integer.valueOf(r16), r1);
        this.k = r8;
        Object r0 = r111.get(0);
    L52:
        return (a) r0;
    L57:
        r15 = r15 + 1;
    L58:
        long r113 = System.currentTimeMillis();
        Iterator r3 = r17.h.entrySet().iterator();
    L60:
        if (r3.hasNext() == false) goto L69;
        Map.Entry r21 = (Map.Entry) r3.next();
        DeepCleanEngine r114 = n;
        if (r114 == null) goto L60;
        if (r114.isMatchPath(this.j, (String) r21.getKey()) < 0) goto L60;
        List r115 = (List) r8.get(Integer.valueOf(r19.length - 1));
        if (r115 != null) goto L68;
        r115 = new ArrayList();
        r8.put(Integer.valueOf(r19.length - 1), r115);
    L68:
        r115.addAll((Collection) r21.getValue());
        goto L60
    L69:
        this.c += System.currentTimeMillis() - r113;
        long r116 = System.currentTimeMillis();
        Iterator r22 = r17.g.entrySet().iterator();
    L71:
        if (r22.hasNext() == false) goto L81;
        Map.Entry r23 = (Map.Entry) r22.next();
        String[] r117 = ((a) ((List) r23.getValue()).get(0)).m;
        if (a(r117, r19) == false) goto L71;
        if (r17.j == false) goto L76;
        List r118 = (List) r8.get(Integer.valueOf(r117.length));
        if (r118 != null) goto L80;
        r118 = new ArrayList();
        r8.put(Integer.valueOf(r117.length), r118);
    L80:
        r118.addAll((Collection) r23.getValue());
        goto L71
    L76:
        ArrayList r2 = new ArrayList();
        r2.add((a) ((List) r23.getValue()).get(0));
        r8.put(Integer.valueOf(r117.length), r2);
        this.k = r8;
        r0 = ((List) r23.getValue()).get(0);
        goto L52
    L81:
        this.e += System.currentTimeMillis() - r116;
    L82:
        if (r8 != null) goto L84;
        return null;
    L84:
        if (r8.size() == 0) goto L205;
        if (r9 == true) goto L88;
        this.k = r8;
    L88:
        int r24 = ((Integer) r8.lastKey()).intValue();
        QFile r25 = r20;
    L89:
        if (r24 <= 0) goto L143;
        List r26 = (List) r8.get(Integer.valueOf(r24));
        if (r26 == null) goto L142;
        Iterator r27 = r26.iterator();
        a r28 = null;
    L95:
        if (r27.hasNext() == false) goto L140;
        a r29 = (a) r27.next();
        if (r29.f633a.equals(EventUtils.TO_APPMANAGER_ACTIVITY) == false) goto L126;
        if (r25 != null) goto L102;
        r25 = new QFile(Environment.getExternalStorageDirectory().getAbsolutePath() + r18);
        r25.fillExtraInfo();
    L102:
        if (n == null) goto L95;
        if (r29.d.equals("") == true) goto L109;
        if (n.isMatchFile(r19[r19.length - 1], r29.d) == false) goto L95;
    L109:
        if (r29.g.equals("") == true) goto L113;
        if (n.isMatchFileSize(r25.size, r29.g) == false) goto L95;
    L113:
        if (r29.h.equals("") == true) goto L117;
        if (n.isMatchTime(r25.createTime, r29.h) == false) goto L95;
    L117:
        if (r29.i.equals("") == true) goto L121;
        if (n.isMatchTime(r25.modifyTime, r29.i) == false) goto L95;
    L121:
        if (r29.j.equals("") == true) goto L126;
        if (n.isMatchTime(r25.accessTime, r29.j) == false) goto L95;
    L126:
        if (r28 == null) goto L138;
        if (r28.f633a.equals("3") == false) goto L134;
        if (r29.f633a.equals(EventUtils.TO_APPMANAGER_ACTIVITY) == true) goto L138;
    L134:
        if (r29.f633a.equals("3") == true) goto L95;
        if (a(r28) >= a(r29)) goto L95;
    L138:
        r28 = r29;
        goto L95
    L140:
        if (r28 == null) goto L142;
        return r28;
    L142:
        r24 = r24 - 1;
        goto L89
    L143:
        return null;
    L205:
        return null;
    L27:
        if (r11.equals(r7) == false) goto L29;
        r8 = this.k;
        r9 = true;
        goto L33
    L29:
        this.j = r11;
        this.k = null;
        goto L31
    L23:
        r11 = "";
    L148:
        return null;
    }

    private b a(String r7, String[] r8) {
        if (r7 == null) goto L17;
        if (r8 == null) goto L17;
        int r9 = r8.length;
        int r2 = 0;
        String r3 = "";
    L7:
        if (r2 >= r9) goto L17;
        String r4 = r8[r2];
        if (r4 == null) goto L16;
        if (r4.equals("") == true) goto L16;
        r3 = r3 + LibrarianImpl.Constants.SEPARATOR + r4;
        b r5 = (b) this.l.get(r3);
        if (r5 == null) goto L16;
        return r5;
    L16:
        r2 = r2 + 1;
    L17:
        return null;
    }

    public String a(String r6, QFile r7, boolean r8) {
        if (r6 != null) goto L5;
        return null;
    L5:
        String[] r1 = r6.split(LibrarianImpl.Constants.SEPARATOR);
        b r2 = b(r6, r1);
        if (r2 != null) goto L9;
        return null;
    L9:
        if (this.f632a == false) goto L21;
        List r0 = r2.d;
        if (r0 != null) goto L13;
    L14:
        r2.d = c(r2.f634a, r8);
    L16:
        if (r2.b != null) goto L19;
        r2.b = b(r2.f634a, r8);
    L19:
        if (r2.c != null) goto L21;
        r2.c = g(r2.f634a, r8);
        goto L21
    L13:
        if (r0.size() != 0) goto L16;
    L21:
        List r9 = r2.d;
        if (r9 == null) goto L33;
        if (r9.size() == 0) goto L33;
        r2.a();
        long r3 = System.currentTimeMillis();
        a r10 = a(r2, r6, r1, r7);
        this.g += System.currentTimeMillis() - r3;
        if (r10 != null) goto L31;
        return r2.b;
    L31:
        return r2.b + " " + r10.e;
    L33:
        return r2.b;
    }

    private static ce a(String r0, boolean r1, Map r2, String r3) {
        ce r4 = new ce();
        r4.e = r0;
        r4.c = Integer.parseInt((String) r2.get(9));
        ArrayList r5 = new ArrayList();
        r4.b = r5;
        r5.add(r3.toLowerCase());
        r4.d = c2.b(tb.c(), r2);
        r4.k = fa.c((String) r2.get(19));
        r4.l = (String) r2.get(20);
        r4.m = (String) r2.get(21);
        r4.n = (int) fa.b((String) r2.get(22));
        return r4;
    }

    private boolean a(String[] r4, String[] r5) {
        if (r4 == null) goto L25;
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r4.length < r5.length) goto L9;
        return false;
    L9:
        int r0 = 0;
    L11:
        if (r0 >= r4.length) goto L19;
        if (r4[r0].equals("*") == true) goto L18;
        if (r4[r0].equals(r5[r0]) == true) goto L18;
        return false;
    L18:
        r0 = r0 + 1;
        goto L11
    L19:
        return true;
    L25:
        return false;
    }

    private void a(boolean r10) {
        gc r0 = (gc) mg.b(TMSDKContext.getApplicaionContext(), UpdateConfig.intToString(40415) + ".dat", UpdateConfig.intToString(40415), new gc(), "UTF-8");
        if (r0 == null) goto L47;
        ArrayList r1 = r0.f217a;
        if (r1 == null) goto L70;
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L71;
        mk r3 = (mk) r2.next();
        he r4 = new he();
        Iterator r5 = r3.f357a.iterator();
    L12:
        if (r5.hasNext() == false) goto L22;
        Map r6 = (Map) r5.next();
        if (r6.get(2) != null) goto L15;
        if (r6.get(5) == null) goto L12;
        String r7 = new String(TccCryptor.decrypt(c3.a(((String) r6.get(5)).toUpperCase()), null));
        if (r4.b != null) goto L21;
        r4.b = new HashMap();
    L21:
        r4.b.put(r7, new String(TccCryptor.decrypt(c3.a(c2.a(tb.c(), r6).toUpperCase()), null)));
        goto L12
    L15:
        r4.f246a = ((String) r6.get(2)).toLowerCase();
        goto L12
    L22:
        List r8 = a(r4.f246a, r3.b, r10);
        r4.c = r8;
        if (r8 == null) goto L9;
        if (r8.size() == 0) goto L9;
        Map r9 = r4.b;
        if (r9 == null) goto L9;
        if (r9.size() == 0) goto L9;
        b r11 = (b) this.l.get(r4.f246a);
        if (r11 != null) goto L34;
        r11 = new b();
        r11.f634a = r4.f246a;
        r11.d = new ArrayList();
        this.l.put(r4.f246a, r11);
    L34:
        Iterator r12 = r4.b.entrySet().iterator();
    L36:
        if (r12.hasNext() == false) goto L41;
        m r13 = (m) this.b.get(((Map.Entry) r12.next()).getKey());
        if (r13 == null) goto L36;
        r11.c = r13.k();
        r11.b = r13.b();
    L41:
        if (r11.c != null) goto L43;
        Map.Entry r14 = (Map.Entry) r4.b.entrySet().iterator().next();
        r11.c = (String) r14.getKey();
        r11.b = (String) r14.getValue();
    L43:
        Iterator r15 = r4.c.iterator();
    L45:
        if (r15.hasNext() == false) goto L9;
        ce r16 = (ce) r15.next();
        a r17 = new a();
        r17.b = (String) r16.b.get(0);
        r17.c = r16.e;
        r17.f633a = r16.p;
        r17.e = r16.d;
        r17.f = Integer.toString(r16.c);
        r11.d.add(r17);
        goto L45
    L71:
        return;
    L70:
        return;
    }

    public static List a(String r18, byte[] r19, boolean r20) {
        JceInputStream r6 = new JceInputStream(TccCryptor.decrypt(r19, null));     // Catch: Exception -> L31
        r6.setServerEncoding("UTF-8");     // Catch: Exception -> L31
        kk r7 = new kk();     // Catch: Exception -> L31
        r7.readFrom(r6);     // Catch: Exception -> L31
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L31
        Iterator r9 = r7.f312a.iterator();     // Catch: Exception -> L31
    L4:
        if (r9.hasNext() == false) goto L30;
        Map r10 = (Map) r9.next();     // Catch: Exception -> L31
        String r11 = (String) r10.get(3);     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r11) == true) goto L20;
        ce r12 = a(r18, r20, r10, r11);     // Catch: Exception -> L31
        r12.p = "3";     // Catch: Exception -> L31
        String r13 = (String) r10.get(23);     // Catch: Exception -> L31
        if (r13 == null) goto L12;
        r12.o = fa.a(r13);     // Catch: Exception -> L31
    L12:
        if (r12.n <= 100) goto L14;
        r12.n = 0;     // Catch: Exception -> L31
    L14:
        String r14 = (String) r10.get(10);     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r14) == true) goto L19;
        int r15 = Integer.valueOf(r14).intValue();     // Catch: Exception -> L31
        if (r15 <= 0) goto L19;
        r12.q = r14;     // Catch: Exception -> L31
        r12.d += "(" + String.format(tb.a("in_recent_days"), new Object[]{Integer.valueOf(r15)}) + ")";     // Catch: Exception -> L31
        r12.j = "0," + r15;     // Catch: Exception -> L31
        ce r16 = a(r18, r20, r10, r11);     // Catch: Exception -> L31
        r16.p = "3";     // Catch: Exception -> L31
        r16.c = 1;     // Catch: Exception -> L31
        r16.j = "" + r15 + ",-";     // Catch: Exception -> L31
        r16.q = r14;     // Catch: Exception -> L31
        r16.d += "(" + String.format(tb.a("days_ago"), new Object[]{Integer.valueOf(r15)}) + ")";     // Catch: Exception -> L31
        r16.o = r12.o;     // Catch: Exception -> L31
        r8.add(r16);     // Catch: Exception -> L31
    L19:
        r8.add(r12);     // Catch: Exception -> L31
        goto L4
    L20:
        String r5 = (String) r10.get(4);     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r5) == true) goto L4;
        ce r17 = a(r18, r20, r10, r5);     // Catch: Exception -> L31
        r17.p = EventUtils.TO_APPMANAGER_ACTIVITY;     // Catch: Exception -> L31
        r17.f = (String) r10.get(11);     // Catch: Exception -> L31
        r17.g = (String) r10.get(12);     // Catch: Exception -> L31
        r17.h = (String) r10.get(13);     // Catch: Exception -> L31
        r17.i = (String) r10.get(14);     // Catch: Exception -> L31
        r17.j = (String) r10.get(15);     // Catch: Exception -> L31
        String r21 = (String) r10.get(23);     // Catch: Exception -> L31
        if (r21 == null) goto L26;
        r17.o = fa.a(r21);     // Catch: Exception -> L31
    L26:
        if (r17.n <= 100) goto L28;
        r17.n = 0;     // Catch: Exception -> L31
    L28:
        r8.add(r17);     // Catch: Exception -> L31
        goto L4
    L30:
        return r8;
    L31:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
