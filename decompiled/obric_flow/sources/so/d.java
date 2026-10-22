package so;

import com.obric.android.agilelogger.ALog;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21967b;

    public d(String r5, String r10) {
        this.f21966a = r5;
        this.f21967b = r10;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        ALog.access$300(this.f21966a, this.f21967b);
    }
}
