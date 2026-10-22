package tmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.common.TMSDKContext;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.lang.MultiLangManager;
import tmsdk.common.module.update.UpdateConfig;

/* JADX INFO: loaded from: classes5.dex */
public class h8 {
    private static volatile h8 j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f239a;
    private a b;
    private volatile String c;
    private volatile String d;
    private volatile String e;
    private volatile String f;
    private final AtomicBoolean g;
    private final AtomicBoolean h;
    private List i;

    private class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h8 f240a;

        private a(h8 r1) {
            this.f240a = r1;
        }

        /* synthetic */ a(h8 r1, aIA r2) {
            this(r1);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            if (r2 == null) goto L4;
            String r3 = r2.getAction();
        L6:
            if (TextUtils.isEmpty(r3) == false) goto L9;
            return;
        L9:
            if ("android.intent.action.LOCALE_CHANGED".equals(r3) == false) goto L12;
            q8.a("LangMana", "Language change!");
            h8.m2387$$Nest$mg(this.f240a);
            return;
        L12:
            return;
        L4:
            r3 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: tmsdkobf.h8$a-IA, reason: invalid class name */
    /* JADX INFO: compiled from: D8$$SyntheticClass */
    public final /* synthetic */ class aIA {
    }

    public interface b {
        void a();
    }

    /* JADX INFO: renamed from: -$$Nest$mg, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2387$$Nest$mg(h8 r0) {
        r0.g();
    }

    private h8() {
        aIA r0 = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        Context r1 = TMSDKContext.getApplicaionContext();
        if (r1 != null) goto L5;
        return;
    L5:
        this.f239a = r1.getSharedPreferences("langInfo", 0);
        this.b = new a(this, r0);
        IntentFilter r2 = new IntentFilter("android.intent.action.LOCALE_CHANGED");
        r1.registerReceiver(this.b, r2);
    }

    public static String a() {
        String r0 = z4.a(TMSDKContext.getApplicaionContext(), UpdateConfig.AMS_DATA_LANGUAGE, null);
        q8.c("LangMana", "language = " + r0);
        return r0;
    }

    public static h8 d() {
        if (j != null) goto L6;
        j = new h8();
    L6:
        return j;
    }

    private void g() {
        this.g.set(true);
        e();
        b();
        f();
        this.g.set(false);
        tb.b(((MultiLangManager) ManagerCreatorC.getManager(MultiLangManager.class)).isENG());
        f8.c();
        List r2 = this.i;
        if (r2 == null) goto L11;
        Iterator r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L17;
        b r0 = (b) r3.next();
        if (r0 == null) goto L6;
        r0.a();
        goto L6
    L17:
        return;
    }

    public String b() {
        if (this.g.get() == false) goto L5;
    L8:
        SharedPreferences r0 = this.f239a;
        String r2 = "";
        if (r0 == null) goto L23;
        r2 = r0.getString("country", "");
        if (TextUtils.isEmpty(r2) == true) goto L23;
        this.d = r2;
        q8.a("LangMana", "getSaveCountry: " + r2);
        return r2;
    L23:
        r2 = Locale.getDefault().getISO3Country();     // Catch: Throwable -> L16
    L19:
        if (TextUtils.isEmpty(r2) == false) goto L21;
        r2 = Locale.getDefault().getCountry();
    L21:
        this.d = r2;
        q8.c("LangMana", "getSystemCountry: " + r2);
        return r2;
    L16:
        th = move-exception;
        q8.e("LangMana", th);
        goto L19
    L5:
        if (TextUtils.isEmpty(this.d) == true) goto L8;
        q8.a("LangMana", "getCountry: " + this.d);
        return this.d;
    }

    public String c() {
        if (this.f239a != null) goto L6;
        return "";
    L6:
        String r3 = e() + ";" + b() + ";" + f();
        q8.a("LangMana", "getCurrentLanguageAllMsg: msg = " + r3);
        return r3;
    }

    public String e() {
        if (this.g.get() == false) goto L5;
    L8:
        SharedPreferences r0 = this.f239a;
        if (r0 == null) goto L14;
        String r1 = r0.getString("language", "");
        if (TextUtils.isEmpty(r1) == true) goto L14;
        this.c = r1;
        q8.a("LangMana", "getSaveLanguage: " + r1);
        return r1;
    L14:
        String r2 = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(r2) == true) goto L22;
    L20:
        this.c = r2;
        q8.c("LangMana", "getSystemLanguage: " + r2);
        return r2;
    L22:
        r2 = Locale.getDefault().getISO3Language();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        q8.e("LangMana", th);
        goto L20
    L5:
        if (TextUtils.isEmpty(this.c) == true) goto L8;
        q8.a("LangMana", "getLanguage: " + this.c);
        return this.c;
    }

    public String f() {
        if (this.g.get() == false) goto L5;
    L8:
        SharedPreferences r0 = this.f239a;
        if (r0 == null) goto L16;
        String r1 = r0.getString("script", "null");
        if (r1 != null) goto L13;
    L23:
        r1 = Locale.getDefault().getScript();     // Catch: Throwable -> L19
    L21:
        this.e = r1;
        q8.c("LangMana", "getSystemScript: " + r1);
        return r1;
    L19:
        th = move-exception;
        q8.e("LangMana", th);
        goto L21
    L13:
        if (TextUtils.equals(r1, "null") == true) goto L23;
        this.e = r1;
        q8.a("LangMana", "getSaveScript: " + r1);
        return r1;
    L16:
        r1 = "";
        goto L23
    L5:
        if (this.e == null) goto L8;
        q8.a("LangMana", "getScript: " + this.e);
        return this.e;
    }

    private int e(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return -14;
    L5:
        String r5 = r6.trim();
        if (TextUtils.isEmpty(r5) == false) goto L9;
        return -14;
    L9:
        if (r5.startsWith("+") == true) goto L11;
    L14:
        int r7 = r5.length();
        if (r7 >= 1) goto L17;
    L29:
        return -15;
    L17:
        if (r7 > 6) goto L29;
        int r2 = 0;
    L20:
        if (r2 >= r7) goto L28;
        char r3 = r5.charAt(r2);
        if (r3 < '0') goto L27;
        if (r3 > '9') goto L27;
        r2 = r2 + 1;
    L27:
        return -15;
    L28:
        return 0;
    L11:
        if (r5.length() != 1) goto L13;
        return -15;
    L13:
        r5 = r5.substring(1);
        goto L14
    }

    public String a(String r4) {
        if (this.f239a != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder("all_msg");
        if (TextUtils.isEmpty(r4) == false) goto L8;
        r4 = "";
    L8:
        String r3 = this.f239a.getString(r0.append(r4).toString(), "");
        q8.a("LangMana", "getLastLanguageAllMsg: msg = " + r3);
        return r3;
    }

    public boolean b(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return !r1.matches("^[a-zA-Z]{2,3}$");
    }

    public int c(String r3) {
        if (this.f239a != null) goto L7;
        return -10;
    L7:
        if (TextUtils.isEmpty(this.f) == false) goto L9;
    L11:
        int r0 = e(r3);
        if (r0 == 0) goto L14;
        return r0;
    L14:
        this.f = r3;
        SharedPreferences.Editor r2 = this.f239a.edit();
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        r2.putString("country_code", r3);
        if (r2.commit() == true) goto L27;
    L23:
        return -13;
    L27:
        return 0;
    L21:
        th = move-exception;
        q8.e("LangMana", th);
        goto L23
    L9:
        if (r3.equals(this.f) == false) goto L11;
        return 0;
    }

    public void d(String r4) {
        if (this.f239a != null) goto L5;
        return;
    L5:
        StringBuilder r1 = new StringBuilder("all_msg");
        if (TextUtils.isEmpty(r4) == false) goto L8;
        r4 = "";
    L8:
        String r5 = r1.append(r4).toString();
        String r2 = c();
        SharedPreferences.Editor r3 = this.f239a.edit();
        r3.putString(r5, r2);
        boolean r6 = r3.commit();     // Catch: Throwable -> L11
    L13:
        q8.a("LangMana", "setCurrentLanguageAllMsg: save = " + r6);
        return;
    L11:
        th = move-exception;
        q8.e("LangMana", th);
        r6 = false;
        goto L13
    }

    public void a(b r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.i != null) goto L7;
        this.i = new ArrayList();
    L7:
        this.i.add(r2);
    }

    public void b(b r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        List r0 = this.i;
        if (r0 == null) goto L8;
        r0.remove(r1);
        return;
    }

    public int a(String r5, String r6, String r7, boolean r8) {
        q8.a("LangMana", "saveLanguageAndCountry: language = " + r5 + ", country = " + r6 + ", script = " + r7 + ", saveScript = " + r8);
        if (this.f239a != null) goto L7;
        return -10;
    L7:
        if (b(r5) == false) goto L11;
        q8.a("LangMana", "saveLanguageAndCountry: language Invalid");
        return -11;
    L11:
        if (b(r6) == false) goto L14;
        q8.a("LangMana", "saveLanguageAndCountry: country Invalid");
        return -12;
    L14:
        SharedPreferences.Editor r0 = this.f239a.edit();
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        r0.putString("language", r5);
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        r0.putString("country", r6);
        if (r8 == false) goto L35;
        if (r7 != null) goto L24;
        r7 = "null";
    L24:
        r0.putString("script", r7);
    L35:
        boolean r9 = r0.commit();     // Catch: Throwable -> L28
    L30:
        g();
        q8.a("LangMana", "saveLanguageAndCountry: save = " + r9);
        if (r9 == true) goto L37;
        return -13;
    L37:
        return 0;
    L28:
        th = move-exception;
        q8.e("LangMana", th);
        r9 = false;
        goto L30
    }
}
