package zf;

import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends BaseDataSubscriber {
    public final /* synthetic */ xn.e d;
    public final /* synthetic */ xn.d e;
    public final /* synthetic */ xn.a f;
    public final /* synthetic */ h g;

    public b(h r5, xn.e r10, xn.d r11, xn.a r12) {
        this.g = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void d(DataSource r5) {
        AbstractDataSource r10 = (AbstractDataSource) r5;
        monitor-enter(r10);
        Throwable r11 = r10.e;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        int r12 = mh.e.b(r11);
        this.e.g(r12, r10.b());
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void e(DataSource r10) {
        h r5 = this.g;
        xn.e r11 = this.d;
        xn.d r12 = this.e;
        xn.a r13 = this.f;
        CloseableReference r14 = (CloseableReference) r10.getResult();
        monitor-enter(r14);     // Catch: Throwable -> L9 Exception -> L11
        Object r15 = r14.f7671b.d();     // Catch: Throwable -> L17
        monitor-exit(r14);     // Catch: Throwable -> L17
        CloseableImage r16 = (CloseableImage) r15;     // Catch: Throwable -> L9 Exception -> L11
        if ((r16 instanceof CloseableStaticBitmap) == false) goto L13;
        wn.b r17 = new wn.b(new i4.a(r14.clone()));     // Catch: Throwable -> L9 Exception -> L11
        boolean r18 = false;
    L14:
        r12.e(r17, r11, new xn.c(r16.getWidth(), r16.getHeight(), r18));     // Catch: Throwable -> L9 Exception -> L11
        r14.close();
        return;
    L13:
        Drawable r19 = r5.f23433a.a((CloseableImage) r14.c());     // Catch: Throwable -> L9 Exception -> L11
        wn.b r20 = new wn.b(new i4.a(r19, r14.clone()));     // Catch: Throwable -> L9 Exception -> L11
        r18 = h.c(r11, r19, r13);     // Catch: Throwable -> L9 Exception -> L11
        r17 = r20;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        if (r14 == null) goto L22;
        r14.close();     // Catch: Throwable -> L9
    L22:
        r12.g(30102, e);     // Catch: Throwable -> L9
        if (r14 == null) goto L33;
        r14.close();
        return;
    L33:
        return;
    L9:
        th = move-exception;
        if (r14 == null) goto L28;
        r14.close();
    L28:
        throw th;
    }
}
