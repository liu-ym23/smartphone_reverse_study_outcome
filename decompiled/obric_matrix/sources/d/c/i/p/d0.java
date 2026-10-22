package d.c.i.p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Size;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class d0 implements k0<d.c.c.h.a<d.c.i.l.c>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentResolver f16238b;

    class a implements d.c.b.a.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f16239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f16240b;

        a(d0 r1, boolean r2, Bitmap r3) {
            this.f16239a = r2;
            this.f16240b = r3;
        }

        @Override // d.c.b.a.k
        public void a(OutputStream r3) {
            boolean r0 = this.f16239a;
            if (r0 == false) goto L5;
            Bitmap.CompressFormat r1 = Bitmap.CompressFormat.JPEG;
        L6:
            if (r0 == false) goto L8;
            int r2 = 85;
        L9:
            this.f16240b.compress(r1, r2, r3);
            return;
        L8:
            r2 = 100;
            goto L9
        L5:
            r1 = Bitmap.CompressFormat.PNG;
            goto L6
        }
    }

    class b extends w0<d.c.c.h.a<d.c.i.l.c>> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ n0 f16241k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f16242l;
        final /* synthetic */ d.c.i.q.b m;
        final /* synthetic */ d0 n;

        b(d0 r1, k r2, n0 r3, String r4, String r5, n0 r6, String r7, d.c.i.q.b r8) {
            this.n = r1;
            this.f16241k = r6;
            this.f16242l = r7;
            this.m = r8;
            super(r2, r3, r4, r5);
        }

        @Override // d.c.c.b.g
        protected /* bridge */ /* synthetic */ void c(Object r1) {
            k((d.c.c.h.a) r1);
        }

        @Override // d.c.c.b.g
        protected /* bridge */ /* synthetic */ Object d() {
            return m();
        }

        @Override // d.c.i.p.w0, d.c.c.b.g
        protected void f(Exception r3) {
            super.f(r3);
            this.f16241k.e(this.f16242l, "VideoThumbnailProducer", false);
        }

        @Override // d.c.i.p.w0, d.c.c.b.g
        protected /* bridge */ /* synthetic */ void g(Object r1) {
            n((d.c.c.h.a) r1);
        }

        @Override // d.c.i.p.w0
        protected /* bridge */ /* synthetic */ Map j(d.c.c.h.a<d.c.i.l.c> r1) {
            return l(r1);
        }

        protected void k(d.c.c.h.a<d.c.i.l.c> r1) {
            d.c.c.h.a.L(r1);
        }

        protected Map<String, String> l(d.c.c.h.a<d.c.i.l.c> r1) {
            if (r1 == null) goto L4;
            boolean r0 = true;
        L6:
            return d.c.c.d.f.of("createdThumbnail", String.valueOf(r0));
        L4:
            r0 = false;
            goto L6
        }

        protected d.c.c.h.a<d.c.i.l.c> m() {
            String r0 = d0.c(this.n, this.m);
            if (r0 != null) goto L5;
            return null;
        L5:
            Bitmap r2 = this.n.h(this.m);
            if (Build.VERSION.SDK_INT >= 29) goto L8;
        L12:
            if (r2 != null) goto L29;
            Bitmap r1 = ThumbnailUtils.createVideoThumbnail(r0, d0.e(this.m));
            if (r1 != null) goto L17;
            return null;
        L17:
            if (this.m.B() == true) goto L19;
        L27:
            r2 = r1;
            this.n.f(this.m, r2);
            goto L29
        L19:
            if (r1.getHeight() == 0) goto L27;
            if (this.m.r().f16022b == 0) goto L27;
            float r3 = r1.getWidth() / r1.getHeight();
            int r4 = this.m.r().f16021a;
            int r5 = this.m.r().f16022b;
            float r6 = r4;
            float r7 = r5;
            if ((r6 / r7) <= r3) goto L25;
            r5 = (int) (r6 / r3);
        L26:
            r1 = Bitmap.createScaledBitmap(r1, r4, r5, true);
            goto L27
        L25:
            r4 = (int) (r7 * r3);
        L29:
            return d.c.c.h.a.V(new d.c.i.l.d(r2, d.c.i.d.g.a(), d.c.i.l.g.f16188d, 0));
        L8:
            if (Environment.isExternalStorageLegacy() == true) goto L12;
            if (d.c.c.k.f.h(this.m.v()) == false) goto L12;
            r2 = d0.d(this.n).loadThumbnail(this.m.v(), new Size(this.m.l(), this.m.k()), null);
            goto L12
        }

        protected void n(d.c.c.h.a<d.c.i.l.c> r3) {
            super.g(r3);
            n0 r0 = this.f16241k;
            String r2 = this.f16242l;
            if (r3 == null) goto L5;
            boolean r4 = true;
        L6:
            r0.e(r2, "VideoThumbnailProducer", r4);
            return;
        L5:
            r4 = false;
            goto L6
        }
    }

    class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w0 f16243a;

        c(d0 r1, w0 r2) {
            this.f16243a = r2;
        }

        @Override // d.c.i.p.m0
        public void a() {
            this.f16243a.b();
        }
    }

    public d0(Executor r1, ContentResolver r2) {
        this.f16237a = r1;
        this.f16238b = r2;
    }

    static /* synthetic */ String c(d0 r0, d.c.i.q.b r1) {
        return r0.i(r1);
    }

    static /* synthetic */ ContentResolver d(d0 r0) {
        return r0.f16238b;
    }

    static /* synthetic */ int e(d.c.i.q.b r0) {
        return g(r0);
    }

    private static int g(d.c.i.q.b r2) {
        if (r2.l() <= 96) goto L5;
        return 1;
    L5:
        if (r2.k() > 96) goto L11;
        return 3;
    L11:
        return 1;
    }

    @Nullable
    private String i(d.c.i.q.b r11) {
        Uri r0 = r11.v();
        if (d.c.c.k.f.i(r0) == false) goto L7;
        return r11.u().getPath();
    L7:
        if (d.c.c.k.f.h(r0) == true) goto L9;
    L28:
        return null;
    L9:
        if (Build.VERSION.SDK_INT >= 19) goto L11;
    L13:
        Uri r5 = r0;
        String r7 = null;
        String[] r8 = null;
    L14:
        Cursor r12 = this.f16238b.query(r5, new String[]{"_data"}, r7, r8, null);
        if (r12 != null) goto L29;
    L26:
        if (r12 == null) goto L28;
        r12.close();
        goto L28
    L29:
    L22:
        th = move-exception;
        if (r12 == null) goto L25;
        r12.close();
    L25:
        throw th;
    L17:
        if (r12.moveToFirst() == false) goto L26;
        String r10 = r12.getString(r12.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L22
        if (r12 == null) goto L21;
        r12.close();
    L21:
        return r10;
    L11:
        if ("com.android.providers.media.documents".equals(r0.getAuthority()) == false) goto L13;
        String r13 = DocumentsContract.getDocumentId(r0);
        r7 = "_id=?";
        r5 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        r8 = new String[]{r13.split(":")[1]};
        goto L14
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.c.h.a<d.c.i.l.c>> r11, l0 r12) {
        n0 r6 = r12.f();
        String r7 = r12.getId();
        b r9 = new b(this, r11, r6, "VideoThumbnailProducer", r7, r6, r7, r12.c());
        r12.d(new c(this, r9));
        this.f16237a.execute(r9);
    }

    public void f(d.c.i.q.b r4, Bitmap r5) {
        boolean r0 = r4.B();     // Catch: Exception -> L8
        if (r0 == false) goto L5;
        d.c.b.a.d r6 = d.c.i.e.j.h().b(r4, null);     // Catch: Exception -> L8
    L6:
        d.c.i.g.j.o().q().h(r6, new a(this, r0, r5));     // Catch: Exception -> L8
        return;
    L5:
        r6 = d.c.i.e.j.h().e(r4, null);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public Bitmap h(d.c.i.q.b r2) {
        if (r2.B() == false) goto L6;
        d.c.b.a.d r3 = d.c.i.e.j.h().b(r2, null);     // Catch: Exception -> L18
    L7:
        d.c.a.a r0 = d.c.i.g.j.o().q().c(r3);     // Catch: Exception -> L18
        if (r0 != null) goto L11;
        r0 = d.c.i.g.j.o().w().c(r3);     // Catch: Exception -> L18
    L11:
        if ((r0 instanceof d.c.a.b) == false) goto L21;
        File r4 = ((d.c.a.b) r0).c();     // Catch: Exception -> L18
        if (r4 != null) goto L15;
        return null;
    L15:
        if (r4.exists() == false) goto L23;
        return BitmapFactory.decodeFile(r4.getAbsolutePath());
    L23:
        return null;
    L21:
        return null;
    L6:
        r3 = d.c.i.e.j.h().e(r2, null);     // Catch: Exception -> L18
    L24:
        return null;
    }
}
