package zk;

import al.b;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.MessageQueue;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.obric.launcher.widget.R$id;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f23452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z4.a f23453b;

    public a(z4.a r5, b r10) {
        this.f23453b = r5;
        this.f23452a = r10;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        Object r5 = this.f23453b.f23389a;
        monitor-enter(r5);
        int r10 = this.f23452a.f315a.size();     // Catch: Throwable -> L10
        b r11 = this.f23452a;     // Catch: Throwable -> L10
        if (r10 >= r11.f317c) goto L12;
        SSWebView r12 = r11.f316b.a(new MutableContextWrapper((Context) this.f23453b.f23390b));     // Catch: Throwable -> L10
        this.f23452a.f315a.add(new SoftReference(r12));     // Catch: Throwable -> L10
        if (r12 == null) goto L12;
        r12.setTag(R$id.webx_precreate_is_precreate, Boolean.TRUE);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return false;
    L10:
        th = move-exception;
        throw th;
    }
}
