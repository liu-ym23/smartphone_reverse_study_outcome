package com.bytedance.feedbackerlib.k;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.collection.ArraySet;
import com.bytedance.feedbackerlib.k.f.a.d;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f4235h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f4236i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f4237j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f4238k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f4239l = null;
    public static final b m = null;
    public static final b n = null;
    public static final b o = null;
    public static final b p = null;
    public static final b q = null;
    public static final b r = null;
    public static final b s = null;
    public static final b t = null;
    public static final b u = null;
    private static final /* synthetic */ b[] v = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f4240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<String> f4241g;

    static {
        b r0 = new b("JPEG", 0, "image/jpeg", a(new String[]{"jpg", "jpeg"}));
        f4235h = r0;
        b r1 = new b("PNG", 1, "image/png", a(new String[]{"png"}));
        f4236i = r1;
        b r2 = new b("GIF", 2, "image/gif", a(new String[]{"gif"}));
        f4237j = r2;
        b r4 = new b("BMP", 3, "image/x-ms-bmp", a(new String[]{"bmp"}));
        f4238k = r4;
        b r6 = new b("WEBP", 4, "image/webp", a(new String[]{"webp"}));
        f4239l = r6;
        b r8 = new b("MPEG", 5, "video/mpeg", a(new String[]{"mpeg", "mpg"}));
        m = r8;
        b r10 = new b("MP4", 6, "video/mp4", a(new String[]{"mp4", "m4v"}));
        n = r10;
        b r12 = new b("QUICKTIME", 7, "video/quicktime", a(new String[]{"mov"}));
        o = r12;
        b r11 = new b("THREEGPP", 8, "video/3gpp", a(new String[]{"3gp", "3gpp"}));
        p = r11;
        b r9 = new b("THREEGPP2", 9, "video/3gpp2", a(new String[]{"3g2", "3gpp2"}));
        q = r9;
        b r7 = new b("MKV", 10, "video/x-matroska", a(new String[]{"mkv"}));
        r = r7;
        b r5 = new b("WEBM", 11, "video/webm", a(new String[]{"webm"}));
        s = r5;
        b r3 = new b("TS", 12, "video/mp2ts", a(new String[]{"ts"}));
        t = r3;
        b r13 = new b("AVI", 13, "video/avi", a(new String[]{"avi"}));
        u = r13;
        v = new b[]{r0, r1, r2, r4, r6, r8, r10, r12, r11, r9, r7, r5, r3, r13};
    }

    private b(String r1, int r2, String r3, Set r4) {
        super(r1, r2);
        this.f4240f = r3;
        this.f4241g = r4;
    }

    private static Set<String> a(String... r1) {
        return new ArraySet(Arrays.asList(r1));
    }

    public static boolean c(String r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.equals(f4237j.toString());
    }

    public static boolean g(String r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.startsWith("image");
    }

    public static boolean j(String r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.startsWith("video");
    }

    public static Set<b> k() {
        return EnumSet.allOf(b.class);
    }

    public static Set<b> l() {
        return n(true);
    }

    public static Set<b> m() {
        return EnumSet.of(f4235h, f4236i, f4237j, f4238k, f4239l);
    }

    public static Set<b> n(boolean r0) {
        return EnumSet.of(f4237j);
    }

    public static Set<b> o() {
        return EnumSet.of(m, new b[]{n, o, p, q, r, s, t, u});
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) v.clone();
    }

    public boolean b(ContentResolver r8, Uri r9) {
        MimeTypeMap r0 = MimeTypeMap.getSingleton();
        if (r9 != null) goto L5;
        return false;
    L5:
        String r1 = r0.getExtensionFromMimeType(r8.getType(r9));
        String r2 = null;
        Iterator<String> r7 = this.f4241g.iterator();
        boolean r3 = false;
    L7:
        if (r7.hasNext() == false) goto L20;
        String r4 = r7.next();
        if (r4.equals(r1) == true) goto L10;
        if (r3 == true) goto L16;
        r2 = d.c(r8, r9);
        if (TextUtils.isEmpty(r2) == true) goto L15;
        r2 = r2.toLowerCase(Locale.US);
    L15:
        r3 = true;
    L16:
        if (r2 == null) goto L7;
        if (r2.endsWith(r4) == false) goto L7;
        return true;
    L10:
        return true;
    L20:
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f4240f;
    }
}
