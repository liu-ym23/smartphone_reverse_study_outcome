package com.bytedance.feedbackerlib.j;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.feedbackerlib.Feedbacker;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, e> f4227e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<b> f4230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.feedbackerlib.model.e.d f4231d;

    class a implements com.bytedance.feedbackerlib.model.a.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f4232a;

        a(e r1) {
            this.f4232a = r1;
        }

        @Override // com.bytedance.feedbackerlib.model.a.v
        public void a(int r2, String r3) {
            if (r2 != 1) goto L5;
            return;
        L5:
            e.a(this.f4232a, com.bytedance.feedbackerlib.model.a.I().M(e.b(this.f4232a)));
            Set r4 = e.c(this.f4232a);
            monitor-enter(r4);
            Iterator r1 = e.c(this.f4232a).iterator();     // Catch: Throwable -> L13
        L9:
            if (r1.hasNext() == false) goto L11;
            ((b) r1.next()).a();     // Catch: Throwable -> L13
            goto L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }
    }

    public interface b {
        void a();
    }

    static {
        f4227e = new HashMap();
    }

    private e(@NonNull Context r2, @NonNull String r3) {
        this.f4230c = new HashSet();
        this.f4228a = r2.getApplicationContext();
        this.f4229b = r3;
        com.bytedance.feedbackerlib.model.e.d r4 = com.bytedance.feedbackerlib.model.a.I().M(r3);
        this.f4231d = r4;
        if (r4 != null) goto L6;
        this.f4231d = d();
        j();
        return;
    }

    static /* synthetic */ com.bytedance.feedbackerlib.model.e.d a(e r0, com.bytedance.feedbackerlib.model.e.d r1) {
        r0.f4231d = r1;
        return r1;
    }

    static /* synthetic */ String b(e r0) {
        return r0.f4229b;
    }

    static /* synthetic */ Set c(e r0) {
        return r0.f4230c;
    }

    private com.bytedance.feedbackerlib.model.e.d d() {
        String r0 = i("default_translation_" + this.f4229b + ".json");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = i("default_translation_en.json");
    L6:
        if (r0 != null) goto L11;
        return null;
    L11:
        return com.bytedance.feedbackerlib.model.e.d.b(r0);
    L13:
        return null;
    }

    public static synchronized e e() {
        monitor-enter(e.class);
        String r1 = f();     // Catch: Throwable -> L10
        Map<String, e> r2 = f4227e;     // Catch: Throwable -> L10
        if (r2.get(r1) != null) goto L7;
        r2.put(r1, new e(Feedbacker.getApplicationContext(), r1));     // Catch: Throwable -> L10
    L7:
        e r3 = r2.get(r1);     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    @NonNull
    public static synchronized String f() {
        monitor-enter(e.class);
        String r1 = Locale.getDefault().getLanguage();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if ("zh".equals(r1) == false) goto L12;
        r1 = "zh-CN";
    L12:
        monitor-exit(e.class);
        return r1;
    L7:
        monitor-exit(e.class);
        return "en";
    L14:
        th = move-exception;
        throw th;
    }

    private String i(@NonNull String r4) {
        InputStream r3 = this.f4228a.getAssets().open(r4);     // Catch: Throwable -> L9
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();     // Catch: Throwable -> L9
        byte[] r0 = new byte[8192];     // Catch: Throwable -> L9
    L4:
        int r1 = r3.read(r0);     // Catch: Throwable -> L9
        if (r1 <= 0) goto L7;
        r5.write(r0, 0, r1);     // Catch: Throwable -> L9
        goto L4
    L7:
        return r5.toString("UTF-8");
    L9:
        return null;
    }

    public String g(@NonNull String r2) {
        com.bytedance.feedbackerlib.model.e.d r1 = h();
        String r0 = null;
        if (r1 != null) goto L5;
        Map<String, String> r3 = null;
    L6:
        if (r3 == null) goto L10;
        r0 = r3.get(r2);
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L13;
        return "no translation";
    L13:
        return r0;
    L5:
        r3 = r1.f4621a;
        goto L6
    }

    public com.bytedance.feedbackerlib.model.e.d h() {
        return this.f4231d;
    }

    public void j() {
        com.bytedance.feedbackerlib.model.a.I().a0(this.f4229b, new a(this));
    }

    public void k(@NonNull b r2) {
        Set<b> r0 = this.f4230c;
        monitor-enter(r0);
        this.f4230c.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void l(@NonNull b r2) {
        Set<b> r0 = this.f4230c;
        monitor-enter(r0);
        this.f4230c.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
