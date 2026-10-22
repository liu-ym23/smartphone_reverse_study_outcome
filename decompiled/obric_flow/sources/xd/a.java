package xd;

import android.database.Cursor;
import kotlin.Unit;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    @Override // xd.b
    public final void a() {
        this.f23101c = System.currentTimeMillis();
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.h("onUserCaptureScreen InternalScreenCaptureObserver.onChange, timestamp=" + this.f23101c, null, null, "", 110);
        Cursor r10 = this.f23100b.getContentResolver().query(this.f23099a, new String[]{"_data", "date_added"}, null, null, "date_modified desc");
        if (r10 != null) goto L21;
        return;
    L21:
        int r11 = r10.getCount();     // Catch: Throwable -> L7
        if (this.d < r11) goto L9;
        this.d = r11;     // Catch: Throwable -> L7
    L13:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L7
        CloseableKt.closeFinally(r10, null);
        return;
    L9:
        this.d = r11;     // Catch: Throwable -> L7
        if (r10.moveToFirst() == false) goto L13;
        int r13 = r10.getColumnIndex("date_added");     // Catch: Throwable -> L7
        int r14 = r10.getColumnIndex("_data");     // Catch: Throwable -> L7
        b(r10.getString(r14), r10.getLong(r13));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }
}
