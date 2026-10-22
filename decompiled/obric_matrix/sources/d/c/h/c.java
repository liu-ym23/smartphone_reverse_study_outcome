package d.c.h;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f15819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f15820b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f15821c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f15822d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f15823e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f15824f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f15825g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f15826h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f15827i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f15828j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f15829k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f15830l = null;
    public static final d m = null;

    static {
        f15819a = new d("JPEG", "jpeg");
        f15820b = new d("PNG", "png");
        f15821c = new d("GIF", "gif");
        f15822d = new d("BMP", "bmp");
        f15823e = new d("ICO", "ico");
        f15824f = new d("WEBP_SIMPLE", "webp");
        f15825g = new d("WEBP_LOSSLESS", "webp");
        f15826h = new d("WEBP_EXTENDED", "webp");
        f15827i = new d("WEBP_EXTENDED_WITH_ALPHA", "webp");
        f15828j = new d("WEBP_ANIMATED", "webp");
        f15829k = new d("HEIF", "heif");
        m = new d("DNG", "dng");
        f15830l = null;
    }

    public static boolean a(d r1) {
        if (r1 != com.facebook.imageutils.a.a()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b(d r1) {
        if (r1 != com.facebook.imageutils.a.b()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c(d r1) {
        if (a(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (b(r1) == true) goto L8;
        return false;
    }

    public static boolean d(d r2) {
        d r0 = com.facebook.imageutils.d.c();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r2 != r0) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean e(d r2) {
        d r0 = com.facebook.imageutils.d.d();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r2 != r0) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean f(d r1) {
        if (r1 != f15824f) goto L5;
    L12:
        return true;
    L5:
        if (r1 == f15825g) goto L12;
        if (r1 == f15826h) goto L12;
        if (r1 == f15827i) goto L12;
        return false;
    }

    public static boolean g(d r1) {
        if (f(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1 == f15828j) goto L8;
        return false;
    }
}
