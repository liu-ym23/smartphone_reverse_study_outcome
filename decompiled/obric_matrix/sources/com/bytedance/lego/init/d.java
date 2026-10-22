package com.bytedance.lego.init;

import com.bytedance.lego.init.e.f;
import com.bytedance.lego.init.e.j;
import com.bytedance.lego.init.e.k;
import com.bytedance.lego.init.e.l;
import com.bytedance.lego.init.e.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<c> f4853a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a> f4854b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<b> f4855c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<m> f4856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static List<com.bytedance.lego.init.e.c> f4857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static List<f> f4858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<String, l> f4859g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static List<j> f4860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static List<j> f4861i;

    static {
        f4853a = new ArrayList();
        f4854b = new ArrayList();
        f4855c = new ArrayList();
        f4856d = null;
        f4857e = null;
        f4858f = null;
        f4859g = new HashMap();
        f4860h = new LinkedList();
        f4861i = new LinkedList();
    }

    public static List<com.bytedance.lego.init.e.c> a() {
        if (f4857e != null) goto L9;
        f4857e = new ArrayList();
        Iterator<a> r0 = e().iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        r0.next().a(f4857e);
    L9:
        return f4857e;
    }

    public static List<f> b() {
        if (f4858f != null) goto L9;
        f4858f = new ArrayList();
        Iterator<b> r0 = f().iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        r0.next().a(f4858f);
    L9:
        return f4858f;
    }

    public static List<m> c() {
        if (f4856d != null) goto L9;
        f4856d = new ArrayList();
        Iterator<c> r0 = d().iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        r0.next().a(f4856d);
    L9:
        return f4856d;
    }

    private static List<c> d() {
        List<c> r0 = f4853a;
        if (r0.isEmpty() == false) goto L5;
        m();
    L5:
        return r0;
    }

    private static List<a> e() {
        List<a> r0 = f4854b;
        if (r0.isEmpty() == false) goto L5;
        j();
    L5:
        return r0;
    }

    private static List<b> f() {
        List<b> r0 = f4855c;
        if (r0.isEmpty() == false) goto L5;
        k();
    L5:
        return r0;
    }

    public static Map<String, l> g() {
        Map<String, l> r0 = f4859g;
        if (r0.isEmpty() == false) goto L5;
        n();
    L5:
        return r0;
    }

    public static List<j> h() {
        if (f4861i.isEmpty() == false) goto L8;
        if (f4860h.isEmpty() == false) goto L8;
        l();
    L8:
        return f4861i;
    }

    public static List<j> i() {
        if (f4861i.isEmpty() == false) goto L8;
        if (f4860h.isEmpty() == false) goto L8;
        l();
    L8:
        return f4860h;
    }

    static void j() {
        f4854b.clear();
    }

    static void k() {
        f4855c.clear();
    }

    static void l() {
        f4860h.clear();
        f4861i.clear();
    }

    static void m() {
        f4853a.clear();
    }

    static void n() {
        Map<String, l> r0 = f4859g;
        r0.clear();
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        ArrayList r9 = new ArrayList();
        ArrayList r6 = new ArrayList();
        r7.add("SPLASH_ONCREATE2SUPER_START");
        r8.add("APP_SUPER2ONCREATEEND_START");
        r8.add("ModuleHookUploadTask");
        r9.add("APP_SUPER2ONCREATEEND_START");
        r9.add("ModuleHookUploadTask");
        r6.add("all");
        k r27 = k.s;
        r0.put("APP_SUPER2ONCREATEEND_END", new l("APP_SUPER2ONCREATEEND_END", true, false, 17.497513f, r6, r7, r8, r9, "init_shceduler_internal_task", r27));
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        r2.add("MAIN_ONRESUME2SUPER_END");
        r3.add("MAIN_SUPER2ONCREATEEND_END");
        r4.add("MAIN_SUPER2ONCREATEEND_END");
        r5.add("main");
        r0.put("MAIN_ONRESUME2SUPER_START", new l("MAIN_ONRESUME2SUPER_START", true, false, 4.4975123f, r5, r2, r3, r4, "init_shceduler_internal_task", r27));
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        r10.add("MAIN_ONCREATE2SUPER_END");
        r11.add("SPLASH_SUPER2ONRESUMEEND_END");
        r12.add("SPLASH_SUPER2ONRESUMEEND_END");
        r13.add("main");
        r0.put("MAIN_ONCREATE2SUPER_START", new l("MAIN_ONCREATE2SUPER_START", true, false, 8.497513f, r13, r10, r11, r12, "init_shceduler_internal_task", r27));
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        r14.add("MAIN_ONRESUME2SUPER_START");
        r15.add("MAIN_SUPER2ONCREATEEND_START");
        r16.add("MAIN_SUPER2ONCREATEEND_START");
        r17.add("main");
        r0.put("MAIN_SUPER2ONCREATEEND_END", new l("MAIN_SUPER2ONCREATEEND_END", true, false, 5.4975123f, r17, r14, r15, r16, "init_shceduler_internal_task", r27));
        ArrayList r18 = new ArrayList();
        ArrayList r19 = new ArrayList();
        ArrayList r20 = new ArrayList();
        ArrayList r110 = new ArrayList();
        r18.add("APP_SUPER2ATTACHBASEEND_START");
        r19.add("APP_ATTACHBASE2SUPER_START");
        r20.add("APP_ATTACHBASE2SUPER_START");
        r110.add("all");
        r0.put("APP_ATTACHBASE2SUPER_END", new l("APP_ATTACHBASE2SUPER_END", true, false, 309.4975f, r110, r18, r19, r20, "init_shceduler_internal_task", r27));
        ArrayList r21 = new ArrayList();
        ArrayList r22 = new ArrayList();
        ArrayList r23 = new ArrayList();
        ArrayList r111 = new ArrayList();
        r21.add("SPLASH_ONCREATE2SUPER_END");
        r22.add("APP_SUPER2ONCREATEEND_END");
        r23.add("APP_SUPER2ONCREATEEND_END");
        r111.add("main");
        r0.put("SPLASH_ONCREATE2SUPER_START", new l("SPLASH_ONCREATE2SUPER_START", true, false, 16.497513f, r111, r21, r22, r23, "init_shceduler_internal_task", r27));
        ArrayList r24 = new ArrayList();
        ArrayList r25 = new ArrayList();
        ArrayList r26 = new ArrayList();
        ArrayList r112 = new ArrayList();
        r24.add("APP_ONCREATE2SUPER_START");
        r25.add("APP_SUPER2ATTACHBASEEND_START");
        r25.add("godzilla_init");
        r26.add("APP_SUPER2ATTACHBASEEND_START");
        r26.add("godzilla_init");
        r112.add("all");
        r0.put("APP_SUPER2ATTACHBASEEND_END", new l("APP_SUPER2ATTACHBASEEND_END", true, false, 153.49751f, r112, r24, r25, r26, "init_shceduler_internal_task", r27));
        ArrayList r1 = new ArrayList();
        ArrayList r28 = new ArrayList();
        ArrayList r29 = new ArrayList();
        ArrayList r30 = new ArrayList();
        r1.add("APP_ATTACHBASE2SUPER_END");
        r30.add("all");
        r0.put("APP_ATTACHBASE2SUPER_START", new l("APP_ATTACHBASE2SUPER_START", true, false, 310.4975f, r30, r1, r28, r29, "init_shceduler_internal_task", r27));
        ArrayList r31 = new ArrayList();
        ArrayList r32 = new ArrayList();
        ArrayList r33 = new ArrayList();
        ArrayList r113 = new ArrayList();
        r31.add("APP_SUPER2ONCREATEEND_START");
        r32.add("APP_ONCREATE2SUPER_START");
        r32.add("TTNetInitTask");
        r32.add("BdtrackerInitTask");
        r33.add("APP_ONCREATE2SUPER_START");
        r33.add("TTNetInitTask");
        r33.add("BdtrackerInitTask");
        r113.add("all");
        r0.put("APP_ONCREATE2SUPER_END", new l("APP_ONCREATE2SUPER_END", true, false, 37.497513f, r113, r31, r32, r33, "init_shceduler_internal_task", r27));
        ArrayList r210 = new ArrayList();
        ArrayList r34 = new ArrayList();
        ArrayList r35 = new ArrayList();
        ArrayList r114 = new ArrayList();
        r34.add("MAIN_SUPER2ONRESUMEEND_START");
        r35.add("MAIN_SUPER2ONRESUMEEND_START");
        r114.add("main");
        r0.put("MAIN_SUPER2ONRESUMEEND_END", new l("MAIN_SUPER2ONRESUMEEND_END", true, false, 1.4975125f, r114, r210, r34, r35, "init_shceduler_internal_task", r27));
        ArrayList r36 = new ArrayList();
        ArrayList r37 = new ArrayList();
        ArrayList r115 = new ArrayList();
        ArrayList r116 = new ArrayList();
        r36.add("SPLASH_SUPER2ONCREATEEND_START");
        r37.add("SPLASH_ONCREATE2SUPER_START");
        r115.add("SPLASH_ONCREATE2SUPER_START");
        r116.add("main");
        r0.put("SPLASH_ONCREATE2SUPER_END", new l("SPLASH_ONCREATE2SUPER_END", true, false, 15.497513f, r116, r36, r37, r115, "init_shceduler_internal_task", r27));
        ArrayList r38 = new ArrayList();
        ArrayList r39 = new ArrayList();
        ArrayList r40 = new ArrayList();
        ArrayList r117 = new ArrayList();
        r38.add("TTNetInitTask");
        r38.add("APP_ONCREATE2SUPER_END");
        r39.add("APP_ONCREATE2SUPER_START");
        r40.add("APP_ONCREATE2SUPER_START");
        r117.add("all");
        k r118 = k.f4894i;
        r0.put("BdtrackerInitTask", new l("BdtrackerInitTask", true, true, 76.49751f, r117, r38, r39, r40, "com.ss.android.init.tasks.BdtrackerInitTask", r118));
        ArrayList r41 = new ArrayList();
        ArrayList r42 = new ArrayList();
        ArrayList r43 = new ArrayList();
        ArrayList r119 = new ArrayList();
        r41.add("SPLASH_SUPER2ONCREATEEND_END");
        r42.add("SPLASH_ONCREATE2SUPER_END");
        r43.add("SPLASH_ONCREATE2SUPER_END");
        r119.add("main");
        r0.put("SPLASH_SUPER2ONCREATEEND_START", new l("SPLASH_SUPER2ONCREATEEND_START", true, false, 14.497513f, r119, r41, r42, r43, "init_shceduler_internal_task", r27));
        ArrayList r44 = new ArrayList();
        ArrayList r45 = new ArrayList();
        ArrayList r46 = new ArrayList();
        ArrayList r47 = new ArrayList();
        r44.add("APP_ONCREATE2SUPER_END");
        r45.add("APP_ONCREATE2SUPER_START");
        r45.add("BdtrackerInitTask");
        r46.add("APP_ONCREATE2SUPER_START");
        r46.add("BdtrackerInitTask");
        r47.add("all");
        r0.put("TTNetInitTask", new l("TTNetInitTask", false, true, 38.502487f, r47, r44, r45, r46, "com.ss.android.init.tasks.TTNetInitTask", r118));
        ArrayList r48 = new ArrayList();
        ArrayList r49 = new ArrayList();
        ArrayList r50 = new ArrayList();
        ArrayList r51 = new ArrayList();
        r48.add("SPLASH_ONRESUME2SUPER_END");
        r49.add("SPLASH_SUPER2ONCREATEEND_END");
        r50.add("SPLASH_SUPER2ONCREATEEND_END");
        r51.add("main");
        r0.put("SPLASH_ONRESUME2SUPER_START", new l("SPLASH_ONRESUME2SUPER_START", true, false, 12.497513f, r51, r48, r49, r50, "init_shceduler_internal_task", r27));
        ArrayList r52 = new ArrayList();
        ArrayList r53 = new ArrayList();
        ArrayList r54 = new ArrayList();
        ArrayList r55 = new ArrayList();
        r52.add("BdtrackerInitTask");
        r52.add("TTNetInitTask");
        r52.add("APP_ONCREATE2SUPER_END");
        r53.add("APP_SUPER2ATTACHBASEEND_END");
        r54.add("APP_SUPER2ATTACHBASEEND_END");
        r55.add("all");
        r0.put("APP_ONCREATE2SUPER_START", new l("APP_ONCREATE2SUPER_START", true, false, 152.49751f, r55, r52, r53, r54, "init_shceduler_internal_task", r27));
        ArrayList r56 = new ArrayList();
        ArrayList r57 = new ArrayList();
        ArrayList r58 = new ArrayList();
        ArrayList r59 = new ArrayList();
        r56.add("MAIN_SUPER2ONRESUMEEND_END");
        r57.add("MAIN_ONRESUME2SUPER_END");
        r58.add("MAIN_ONRESUME2SUPER_END");
        r59.add("main");
        r0.put("MAIN_SUPER2ONRESUMEEND_START", new l("MAIN_SUPER2ONRESUMEEND_START", true, false, 2.4975123f, r59, r56, r57, r58, "init_shceduler_internal_task", r27));
        ArrayList r60 = new ArrayList();
        ArrayList r61 = new ArrayList();
        ArrayList r62 = new ArrayList();
        ArrayList r63 = new ArrayList();
        r60.add("MAIN_SUPER2ONRESUMEEND_START");
        r61.add("MAIN_ONRESUME2SUPER_START");
        r62.add("MAIN_ONRESUME2SUPER_START");
        r63.add("main");
        r0.put("MAIN_ONRESUME2SUPER_END", new l("MAIN_ONRESUME2SUPER_END", true, false, 3.4975123f, r63, r60, r61, r62, "init_shceduler_internal_task", r27));
        ArrayList r64 = new ArrayList();
        ArrayList r65 = new ArrayList();
        ArrayList r66 = new ArrayList();
        ArrayList r67 = new ArrayList();
        r64.add("ModuleHookUploadTask");
        r64.add("APP_SUPER2ONCREATEEND_END");
        r65.add("APP_ONCREATE2SUPER_END");
        r66.add("APP_ONCREATE2SUPER_END");
        r67.add("all");
        r0.put("APP_SUPER2ONCREATEEND_START", new l("APP_SUPER2ONCREATEEND_START", true, false, 36.497513f, r67, r64, r65, r66, "init_shceduler_internal_task", r27));
        ArrayList r68 = new ArrayList();
        ArrayList r69 = new ArrayList();
        ArrayList r70 = new ArrayList();
        ArrayList r71 = new ArrayList();
        r68.add("APP_SUPER2ATTACHBASEEND_END");
        r69.add("APP_SUPER2ATTACHBASEEND_START");
        r70.add("APP_SUPER2ATTACHBASEEND_START");
        r71.add("all");
        r0.put("godzilla_init", new l("godzilla_init", false, false, 154.49751f, r71, r68, r69, r70, "com.ss.android.init.tasks.GodzillaInitTask", k.f4893h));
        ArrayList r72 = new ArrayList();
        ArrayList r73 = new ArrayList();
        ArrayList r74 = new ArrayList();
        ArrayList r120 = new ArrayList();
        r72.add("godzilla_init");
        r72.add("APP_SUPER2ATTACHBASEEND_END");
        r73.add("APP_ATTACHBASE2SUPER_END");
        r74.add("APP_ATTACHBASE2SUPER_END");
        r120.add("all");
        r0.put("APP_SUPER2ATTACHBASEEND_START", new l("APP_SUPER2ATTACHBASEEND_START", true, false, 308.4975f, r120, r72, r73, r74, "init_shceduler_internal_task", r27));
        ArrayList r75 = new ArrayList();
        ArrayList r76 = new ArrayList();
        ArrayList r77 = new ArrayList();
        ArrayList r78 = new ArrayList();
        r75.add("MAIN_SUPER2ONCREATEEND_START");
        r76.add("MAIN_ONCREATE2SUPER_START");
        r77.add("MAIN_ONCREATE2SUPER_START");
        r78.add("main");
        r0.put("MAIN_ONCREATE2SUPER_END", new l("MAIN_ONCREATE2SUPER_END", true, false, 7.4975123f, r78, r75, r76, r77, "init_shceduler_internal_task", r27));
        ArrayList r79 = new ArrayList();
        ArrayList r80 = new ArrayList();
        ArrayList r81 = new ArrayList();
        ArrayList r121 = new ArrayList();
        r79.add("SPLASH_SUPER2ONRESUMEEND_END");
        r80.add("SPLASH_ONRESUME2SUPER_END");
        r81.add("SPLASH_ONRESUME2SUPER_END");
        r121.add("main");
        r0.put("SPLASH_SUPER2ONRESUMEEND_START", new l("SPLASH_SUPER2ONRESUMEEND_START", true, false, 10.497513f, r121, r79, r80, r81, "init_shceduler_internal_task", r27));
        ArrayList r82 = new ArrayList();
        ArrayList r83 = new ArrayList();
        ArrayList r84 = new ArrayList();
        ArrayList r122 = new ArrayList();
        r82.add("SPLASH_ONRESUME2SUPER_START");
        r83.add("SPLASH_SUPER2ONCREATEEND_START");
        r84.add("SPLASH_SUPER2ONCREATEEND_START");
        r122.add("main");
        r0.put("SPLASH_SUPER2ONCREATEEND_END", new l("SPLASH_SUPER2ONCREATEEND_END", true, false, 13.497513f, r122, r82, r83, r84, "init_shceduler_internal_task", r27));
        ArrayList r85 = new ArrayList();
        ArrayList r86 = new ArrayList();
        ArrayList r87 = new ArrayList();
        ArrayList r123 = new ArrayList();
        r85.add("MAIN_SUPER2ONCREATEEND_END");
        r86.add("MAIN_ONCREATE2SUPER_END");
        r87.add("MAIN_ONCREATE2SUPER_END");
        r123.add("main");
        r0.put("MAIN_SUPER2ONCREATEEND_START", new l("MAIN_SUPER2ONCREATEEND_START", true, false, 6.4975123f, r123, r85, r86, r87, "init_shceduler_internal_task", r27));
        ArrayList r88 = new ArrayList();
        ArrayList r89 = new ArrayList();
        ArrayList r90 = new ArrayList();
        ArrayList r91 = new ArrayList();
        r88.add("MAIN_ONCREATE2SUPER_START");
        r89.add("SPLASH_SUPER2ONRESUMEEND_START");
        r90.add("SPLASH_SUPER2ONRESUMEEND_START");
        r91.add("main");
        r0.put("SPLASH_SUPER2ONRESUMEEND_END", new l("SPLASH_SUPER2ONRESUMEEND_END", true, false, 9.497513f, r91, r88, r89, r90, "init_shceduler_internal_task", r27));
        ArrayList r92 = new ArrayList();
        ArrayList r93 = new ArrayList();
        ArrayList r94 = new ArrayList();
        ArrayList r95 = new ArrayList();
        r92.add("APP_SUPER2ONCREATEEND_END");
        r93.add("APP_SUPER2ONCREATEEND_START");
        r94.add("APP_SUPER2ONCREATEEND_START");
        r95.add("main");
        r0.put("ModuleHookUploadTask", new l("ModuleHookUploadTask", false, false, 18.447762f, r95, r92, r93, r94, "com.ss.android.init.tasks.ModuleHookUploadTask", k.f4895j));
        ArrayList r96 = new ArrayList();
        ArrayList r97 = new ArrayList();
        ArrayList r98 = new ArrayList();
        ArrayList r99 = new ArrayList();
        r96.add("SPLASH_SUPER2ONRESUMEEND_START");
        r97.add("SPLASH_ONRESUME2SUPER_START");
        r98.add("SPLASH_ONRESUME2SUPER_START");
        r99.add("main");
        r0.put("SPLASH_ONRESUME2SUPER_END", new l("SPLASH_ONRESUME2SUPER_END", true, false, 11.497513f, r99, r96, r97, r98, "init_shceduler_internal_task", r27));
    }
}
