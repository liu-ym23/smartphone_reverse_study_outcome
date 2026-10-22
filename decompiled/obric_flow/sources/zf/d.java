package zf;

import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends BaseDataSubscriber {
    public final /* synthetic */ int d;
    public final /* synthetic */ xn.d e;

    public /* synthetic */ d(xn.d r5, int r10) {
        this.d = r10;
        this.e = r5;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void d(DataSource r5) {
        switch(this.d) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        AbstractDataSource r10 = (AbstractDataSource) r5;
        monitor-enter(r10);
        Throwable r11 = r10.e;     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        if (r11 == null) goto L10;
        this.e.g(mh.e.b(r10.b()), r10.b());
        return;
    L10:
        this.e.g(-1, new Throwable("image prefetch to bitmap cache failed."));
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        AbstractDataSource r12 = (AbstractDataSource) r5;
        monitor-enter(r12);
        Throwable r13 = r12.e;     // Catch: Throwable -> L23
        monitor-exit(r12);     // Catch: Throwable -> L23
        if (r13 == null) goto L21;
        this.e.g(mh.e.b(r12.b()), r12.b());
        return;
    L21:
        this.e.g(-1, new Throwable("image prefetch to disk cache failed."));
        return;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void e(DataSource r5) {
        switch(this.d) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.e.e(null, null, null);
        return;
    L6:
        this.e.e(null, null, null);
    }
}
