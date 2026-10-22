package d.c.i.p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class y extends a0 implements c1<d.c.i.l.e> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Class<?> f16471d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f16472e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f16473f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Rect f16474g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Rect f16475h = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ContentResolver f16476c;

    static {
        f16471d = y.class;
        f16472e = new String[]{"_id", "_data"};
        f16473f = new String[]{"_data"};
        f16474g = new Rect(0, 0, 512, 384);
        f16475h = new Rect(0, 0, 96, 96);
    }

    public y(Executor r1, d.c.c.g.i r2, ContentResolver r3) {
        super(r1, r2);
        this.f16476c = r3;
    }

    private d.c.i.l.e g(Uri r7, d.c.i.f.f r8) {
        Cursor r9 = this.f16476c.query(r7, f16472e, null, null, null);
        if (r9 != null) goto L21;
        return null;
    L21:
    L18:
        th = move-exception;
        r9.close();
        throw th;
    L6:
        if (r9.getCount() != 0) goto L9;
        r9.close();
        return null;
    L9:
        r9.moveToFirst();     // Catch: Throwable -> L18
        String r1 = r9.getString(r9.getColumnIndex("_data"));     // Catch: Throwable -> L18
        if (r8 == null) goto L16;
        d.c.i.l.e r6 = j(r8, r9.getInt(r9.getColumnIndex("_id")));     // Catch: Throwable -> L18
        if (r6 == null) goto L16;
        r6.G0(i(r1));     // Catch: Throwable -> L18
        r9.close();
        return r6;
    L16:
        r9.close();
        return null;
    }

    private static int h(String r2) {
        if (r2 != null) goto L5;
        return -1;
    L5:
        return (int) new File(r2).length();
    }

    private static int i(String r4) {
        if (r4 != null) goto L10;
    L9:
        return 0;
    L10:
        return com.facebook.imageutils.f.a(new ExifInterface(r4).getAttributeInt("Orientation", 1));
    L7:
        e = move-exception;
        d.c.c.e.a.i(f16471d, e, "Unable to retrieve thumbnail rotation for %s", new Object[]{r4});
        goto L9
    }

    private d.c.i.l.e j(d.c.i.f.f r5, int r6) {
        int r7 = k(r5);
        Cursor r0 = null;
        if (r7 != 0) goto L29;
        return null;
    L29:
        Cursor r8 = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.f16476c, r6, r7, f16473f);     // Catch: Throwable -> L23
        if (r8 != null) goto L27;
        if (r8 == null) goto L9;
        r8.close();
    L9:
        return null;
    L27:
        r8.moveToFirst();     // Catch: Throwable -> L21
        if (r8.getCount() <= 0) goto L18;
        String r9 = r8.getString(r8.getColumnIndex("_data"));     // Catch: Throwable -> L21
        if (new File(r9).exists() == false) goto L18;
        d.c.i.l.e r4 = e(new FileInputStream(r9), h(r9));     // Catch: Throwable -> L21
        if (r8 == null) goto L17;
        r8.close();
    L17:
        return r4;
    L18:
        if (r8 == null) goto L20;
        r8.close();
    L20:
        return null;
    L21:
        th = th;
        r0 = r8;
    L24:
        if (r0 == null) goto L26;
        r0.close();
    L26:
        throw th;
    L23:
        th = th;
        goto L24
    }

    private static int k(d.c.i.f.f r2) {
        Rect r0 = f16475h;
        if (d1.b(r0.width(), r0.height(), r2) == false) goto L6;
        return 3;
    L6:
        Rect r1 = f16474g;
        if (d1.b(r1.width(), r1.height(), r2) == false) goto L10;
        return 1;
    L10:
        return 0;
    }

    @Override // d.c.i.p.c1
    public boolean a(d.c.i.f.f r2) {
        Rect r1 = f16474g;
        return d1.b(r1.width(), r1.height(), r2);
    }

    @Override // d.c.i.p.a0
    protected d.c.i.l.e d(d.c.i.q.b r3) {
        Uri r0 = r3.v();
        if (d.c.c.k.f.f(r0) == false) goto L7;
        d.c.i.l.e r2 = g(r0, r3.r());
        if (r2 == null) goto L9;
        return r2;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // d.c.i.p.a0
    protected String f() {
        return "LocalContentUriThumbnailFetchProducer";
    }
}
