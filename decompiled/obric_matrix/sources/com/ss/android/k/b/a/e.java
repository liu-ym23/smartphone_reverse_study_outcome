package com.ss.android.k.b.a;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile int f11963g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f11964h = "e";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static d f11965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static e f11966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Map<String, Integer> f11967k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f11968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f11969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<WeakReference<com.ss.android.k.b.a.f>> f11970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.ss.android.k.b.a.f> f11971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<WeakReference<com.ss.android.k.b.a.g>> f11972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InterfaceC0312e f11973f;

    private class a extends g {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f11974j;

        public a(e r1, Activity r2, String[] r3, int[] r4, String[] r5) {
            this.f11974j = r1;
            super(r2, r3, r4, r5);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            if (e.m() == true) goto L6;
            e.a(this.f11974j, this.f11978g, this.f11979h, null);
            return;
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AlertDialog.Builder f11975a;

        public b(Context r2) {
            this.f11975a = new AlertDialog.Builder(r2);
        }

        @Override // com.ss.android.k.b.a.e.c
        public Dialog a() {
            return this.f11975a.create();
        }

        @Override // com.ss.android.k.b.a.e.c
        public c b(CharSequence r2) {
            this.f11975a.setMessage(r2);
            return this;
        }

        @Override // com.ss.android.k.b.a.e.c
        public c c(int r2, DialogInterface.OnClickListener r3) {
            this.f11975a.setNegativeButton(r2, r3);
            return this;
        }

        @Override // com.ss.android.k.b.a.e.c
        public c d(int r2, DialogInterface.OnClickListener r3) {
            this.f11975a.setPositiveButton(r2, r3);
            return this;
        }

        @Override // com.ss.android.k.b.a.e.c
        public c e(int r2) {
            this.f11975a.setTitle(r2);
            return this;
        }
    }

    public static abstract class c {
        public c() {
        }

        public abstract Dialog a();

        public abstract c b(CharSequence r1);

        public abstract c c(int r1, DialogInterface.OnClickListener r2);

        public abstract c d(int r1, DialogInterface.OnClickListener r2);

        public abstract c e(int r1);
    }

    public interface d {
        c a(Context r1);
    }

    /* JADX INFO: renamed from: com.ss.android.k.b.a.e$e, reason: collision with other inner class name */
    public interface InterfaceC0312e {
        boolean a(Activity r1, String[] r2, String[] r3, @NonNull int[] r4, String r5);
    }

    public class f extends g {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f11976j;

        public f(e r1, Activity r2, String[] r3, int[] r4, String[] r5) {
            this.f11976j = r1;
            super(r2, r3, r4, r5);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            if (com.bytedance.common.utility.b.a() == false) goto L13;
            com.ss.android.k.b.a.b.g(this.f11977f);
        L10:
            if (e.m() == true) goto L15;
            e.a(this.f11976j, this.f11978g, this.f11979h, this.f11980i);
            return;
        L15:
            return;
        L13:
            this.f11977f.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + this.f11977f.getPackageName())));     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            th.printStackTrace();
            goto L10
        }
    }

    private static abstract class g implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected Activity f11977f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected String[] f11978g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected int[] f11979h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected String[] f11980i;

        public g(Activity r1, String[] r2, int[] r3, String[] r4) {
            this.f11977f = r1;
            this.f11978g = r2;
            this.f11979h = r3;
            this.f11980i = r4;
        }
    }

    static {
        f11967k = new HashMap();
        if (m() == false) goto L5;
        int r0 = d.b.f.a.a.f13198g;
        int r1 = d.b.f.a.a.f13197f;
        Map<String, Integer> r2 = f11967k;
        int r3 = d.b.f.a.a.f13193b;
        r2.put("android.permission.READ_CALENDAR", Integer.valueOf(r3));
        Map<String, Integer> r4 = f11967k;
        Integer r5 = Integer.valueOf(r3);
        String r6 = "android.permission.WRITE_CALENDAR";
    L6:
        r4.put(r6, r5);
        f11967k.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(r0));
        f11967k.put("android.permission.READ_SMS", Integer.valueOf(d.b.f.a.a.f13202k));
        f11967k.put("android.permission.READ_CONTACTS", Integer.valueOf(d.b.f.a.a.f13195d));
        f11967k.put("android.permission.CAMERA", Integer.valueOf(d.b.f.a.a.f13194c));
        f11967k.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(r1));
        if (m() == false) goto L9;
    L10:
        f11967k.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(r1));
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 16) goto L10;
        return;
    L5:
        r0 = d.b.f.a.a.f13199h;
        r1 = d.b.f.a.a.f13196e;
        f11967k.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(r0));
        f11967k.put("android.permission.RECORD_AUDIO", Integer.valueOf(d.b.f.a.a.f13201j));
        r4 = f11967k;
        r5 = Integer.valueOf(d.b.f.a.a.f13200i);
        r6 = "android.permission.READ_PHONE_STATE";
        goto L6
    }

    private e() {
        this.f11968a = new HashSet(1);
        this.f11969b = new HashSet(1);
        this.f11970c = new ArrayList(1);
        this.f11971d = new ArrayList(1);
        this.f11972e = new ArrayList();
        g();
    }

    static /* synthetic */ void a(e r0, String[] r1, int[] r2, String[] r3) {
        r0.h(r1, r2, r3);
    }

    public static e b() {
        if (f11966j != null) goto L6;
        f11966j = new e();
    L6:
        return f11966j;
    }

    private String c(Context r5, List<String> r6) {
        if (r6.isEmpty() == false) goto L5;
        return "";
    L5:
        byte r1 = 0;
        if (r6.size() <= 1) goto L18;
        StringBuilder r4 = new StringBuilder();
        Iterator<String> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        int r0 = f11967k.get(r7.next()).intValue();
        if (r0 <= 0) goto L9;
        r4.append(r5.getString(r0));
        r4.append("、");
        goto L9
    L13:
        int r8 = r4.length() - 1;
        if (r8 < 0) goto L17;
        r4.deleteCharAt(r8);
    L17:
        return r5.getString(d.b.f.a.a.u, new Object[]{r4.toString()});
    L18:
        String r9 = r6.get(0);
        switch(r9.hashCode()) {
            case -1888586689: goto L44;
            case -406040016: goto L41;
            case -63024214: goto L38;
            case -5573545: goto L35;
            case 463403621: goto L32;
            case 1365911975: goto L29;
            case 1831139720: goto L26;
            case 1977429404: goto L23;
            default: goto L46;
        };     // Catch: Exception -> L65
    L46:
        r1 = -1;
    L47:
        switch(r1) {
            case 0: goto L60;
            case 1: goto L58;
            case 2: goto L58;
            case 3: goto L56;
            case 4: goto L54;
            case 5: goto L52;
            case 6: goto L50;
            case 7: goto L50;
            default: goto L64;
        };     // Catch: Exception -> L65
    L50:
        return r5.getString(d.b.f.a.a.w);
    L52:
        return r5.getString(d.b.f.a.a.t);
    L54:
        return r5.getString(d.b.f.a.a.n);
    L56:
        return r5.getString(d.b.f.a.a.p);
    L58:
        return r5.getString(d.b.f.a.a.s);
    L60:
        if (Build.VERSION.SDK_INT < 29) goto L63;
        return "";
    L63:
        return r5.getString(d.b.f.a.a.q);
    L23:
        if (r9.equals("android.permission.READ_CONTACTS") == false) goto L46;
        r1 = 3;
        goto L47
    L26:
        if (r9.equals("android.permission.RECORD_AUDIO") == false) goto L46;
        r1 = 5;
        goto L47
    L29:
        if (r9.equals("android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L46;
        r1 = 6;
        goto L47
    L32:
        if (r9.equals("android.permission.CAMERA") == false) goto L46;
        r1 = 4;
        goto L47
    L35:
        if (r9.equals("android.permission.READ_PHONE_STATE") == false) goto L46;
    L38:
        if (r9.equals("android.permission.ACCESS_COARSE_LOCATION") == false) goto L46;
        r1 = 1;
        goto L47
    L41:
        if (r9.equals("android.permission.READ_EXTERNAL_STORAGE") == false) goto L46;
        r1 = 7;
        goto L47
    L44:
        if (r9.equals("android.permission.ACCESS_FINE_LOCATION") == false) goto L46;
        r1 = 2;
    L64:
        return "";
    }

    private synchronized void g() {
        monitor-enter(this);
        Field[] r0 = Manifest.permission.class.getFields();     // Catch: Throwable -> L15
        int r1 = r0.length;     // Catch: Throwable -> L15
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L13;
        String r4 = null;
        r4 = (String) r0[r2].get("");     // Catch: IllegalAccessException -> L9 Throwable -> L15
    L11:
        this.f11969b.add(r4);     // Catch: Throwable -> L15
        r2 = r2 + 1;
        goto L4
    L9:
        e = move-exception;
        Log.e(f11964h, "Could not access field", e);     // Catch: Throwable -> L15
        goto L11
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void h(@NonNull String[] r7, @NonNull int[] r8, String[] r9) {
        int r0 = r7.length;     // Catch: Throwable -> L29
        if (r8.length >= r0) goto L5;
        r0 = r8.length;     // Catch: Throwable -> L29
    L5:
        Iterator<WeakReference<com.ss.android.k.b.a.f>> r1 = this.f11970c.iterator();     // Catch: Throwable -> L29
    L6:
        int r3 = 0;
        if (r1.hasNext() == false) goto L22;
        com.ss.android.k.b.a.f r2 = r1.next().get();     // Catch: Throwable -> L29
        if (r9 == null) goto L15;
        if (r9.length <= 0) goto L15;
        if ((r2 instanceof com.ss.android.k.b.a.a) == false) goto L15;
        ((com.ss.android.k.b.a.a) r2).f(r9);     // Catch: Throwable -> L29
    L15:
        if (r3 >= r0) goto L6;
        if (r2 == null) goto L21;
        if (r2.c(r7[r3], r8[r3]) == true) goto L21;
        r3 = r3 + 1;     // Catch: Throwable -> L29
    L21:
        r1.remove();     // Catch: Throwable -> L29
        goto L6
    L22:
        Iterator<com.ss.android.k.b.a.f> r10 = this.f11971d.iterator();     // Catch: Throwable -> L29
    L24:
        if (r10.hasNext() == false) goto L26;
        r10.next();     // Catch: Throwable -> L29
        r10.remove();     // Catch: Throwable -> L29
    L26:
        if (r3 >= r0) goto L48;
        this.f11968a.remove(r7[r3]);     // Catch: Throwable -> L29
        r3 = r3 + 1;
        goto L26
    L48:
        return;
    L29:
        th = move-exception;
        th.printStackTrace();
    }

    private void l(Context r2, String r3, DialogInterface.OnClickListener r4, DialogInterface.OnClickListener r5) {
        d r1 = f11965i;
        if (r1 == null) goto L5;
        c r6 = r1.a(r2);
    L7:
        if (m() == false) goto L9;
        r6.b(r3);
        r6.d(d.b.f.a.a.m, r4);
        r6.c(d.b.f.a.a.f13203l, r5);
        Dialog r7 = r6.a();
        r7.setCanceledOnTouchOutside(false);
    L10:
        r7.show();
        return;
    L9:
        r6.e(d.b.f.a.a.v);
        r6.b(r3);
        r6.d(d.b.f.a.a.r, r4);
        r6.c(d.b.f.a.a.o, r5);
        r7 = r6.a();
        r7.setCancelable(false);
        goto L10
    L5:
        r6 = new b(r2);
        goto L7
    }

    public static boolean m() {
        if ((f11963g & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String d(Activity r8, String[] r9) {
        if (r8 == null) goto L21;
        if (r9 != null) goto L5;
        return null;
    L5:
        if (r9.length <= 0) goto L29;
        StringBuilder r7 = new StringBuilder();
        int r0 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r2 >= r0) goto L20;
        String r5 = r9[r2];
        if (b().f(r8, r5) == true) goto L18;
        int r6 = f11967k.get(r5).intValue();
        if (r6 <= 0) goto L18;
        int r10 = r9.length - 1;
        r7.append(r8.getString(r6));
        if (r3 == r10) goto L18;
        r7.append("；");
    L18:
        r3 = r3 + 1;
        r2 = r2 + 1;
        goto L9
    L20:
        return String.format(r8.getResources().getString(d.b.f.a.a.f13192a), new Object[]{r7.toString()});
    L29:
        return null;
    L21:
        return null;
    }

    public void e(Activity r8, String[] r9, String[] r10, @NonNull int[] r11, String r12, DialogInterface.OnClickListener r13, DialogInterface.OnClickListener r14) {
        if (r8 == null) goto L23;
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.length <= 0) goto L25;
        InterfaceC0312e r1 = this.f11973f;
        if (r1 == null) goto L20;
        boolean r15 = r1.a(r8, r9, r10, r11, r12);
        this.f11973f = null;
        if (r15 == false) goto L20;
        if (m() == true) goto L22;
        h(r9, r11, null);
        return;
    L22:
        return;
    L20:
        l(r8, r12, r13, r14);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L25:
        return;
    }

    public synchronized boolean f(@Nullable Context r4, @NonNull String r5) {
        monitor-enter(this);
        boolean r0 = false;
        if (r4 != null) goto L28;
        monitor-exit(this);
        return false;
    L28:
    L25:
        th = move-exception;
        throw th;
    L8:
        if (com.bytedance.common.utility.b.a() == false) goto L19;
        if (com.ss.android.k.b.a.b.a(r4, r5) == true) goto L12;
    L16:
        monitor-exit(this);
        return r0;
    L12:
        if (com.ss.android.k.b.a.c.a(r4, r5) != 0) goto L14;
    L15:
        r0 = true;
        goto L16
    L14:
        if (this.f11969b.contains(r5) == true) goto L16;
    L19:
        if (com.ss.android.k.b.a.c.a(r4, r5) != 0) goto L21;
    L22:
        r0 = true;
    L23:
        monitor-exit(this);
        return r0;
    L21:
        if (this.f11969b.contains(r5) == true) goto L23;
        goto L22
    }

    public synchronized void i(@NonNull Activity r2, @NonNull String[] r3, @NonNull int[] r4) {
        monitor-enter(this);
        j(r2, r3, r4, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void j(@NonNull Activity r16, @NonNull String[] r17, @NonNull int[] r18, boolean r19) {
        monitor-enter(this);
        int r2 = 0;
        if (m() == true) goto L30;
        ArrayList r1 = new ArrayList(3);     // Catch: Throwable -> L43
        int r4 = r17.length;     // Catch: Throwable -> L43
    L7:
        if (r2 >= r4) goto L24;
        String r5 = r17[r2];     // Catch: Throwable -> L43
        if (r18[r2] == (-1)) goto L15;
        if (com.bytedance.common.utility.b.a() == false) goto L22;
        if (com.ss.android.k.b.a.b.a(r16, r5) == false) goto L15;
    L22:
        r2 = r2 + 1;     // Catch: Throwable -> L43
    L15:
        if (r18[r2] == (-1)) goto L18;
        r18[r2] = -1;     // Catch: Throwable -> L43
    L18:
        if (ActivityCompat.shouldShowRequestPermissionRationale(r16, r5) == true) goto L22;
        if (f11967k.containsKey(r5) == false) goto L22;
        r1.add(r5);     // Catch: Throwable -> L43
        goto L22
    L24:
        if (r1.isEmpty() == true) goto L41;
        String r7 = c(r16, r1);     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r7) == true) goto L41;
        String[] r8 = (String[]) r1.toArray(new String[r1.size()]);     // Catch: Throwable -> L43
        e(r16, r17, (String[]) r1.toArray(new String[r1.size()]), r18, r7, new f(this, r16, r17, r18, r8), new a(this, r16, r17, r18, r8));     // Catch: Throwable -> L43
        monitor-exit(this);
        return;
    L41:
        this.f11973f = null;     // Catch: Throwable -> L43
        h(r17, r18, null);     // Catch: Throwable -> L43
    L45:
        monitor-exit(this);
        return;
    L30:
        if (r19 == false) goto L41;
        int r3 = r17.length;     // Catch: Throwable -> L43
    L32:
        if (r2 >= r3) goto L41;
        String r6 = r17[r2];     // Catch: Throwable -> L43
        if (r18[r2] != (-1)) goto L40;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r16, r6) == true) goto L40;
        String r9 = d(r16, r17);     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r9) == true) goto L41;
        e(r16, r17, null, r18, r9, new f(this, r16, r17, r18, null), null);     // Catch: Throwable -> L43
    L40:
        r2 = r2 + 1;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    }

    void k(String r2, int r3) {
        List<WeakReference<com.ss.android.k.b.a.g>> r0 = this.f11972e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L18;
        Iterator<WeakReference<com.ss.android.k.b.a.g>> r1 = this.f11972e.iterator();
    L8:
        if (r1.hasNext() == false) goto L19;
        com.ss.android.k.b.a.g r4 = r1.next().get();
        if (r4 == null) goto L8;
        r4.a(r2, r3);
        goto L8
    L19:
        return;
    }
}
