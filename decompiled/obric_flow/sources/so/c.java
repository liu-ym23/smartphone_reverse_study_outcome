package so;

import android.os.Process;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends ThreadLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21965a;

    public /* synthetic */ c(int r5) {
        this.f21965a = r5;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch(this.f21965a) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        SimpleDateFormat r5 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        r5.setTimeZone(TimeZone.getTimeZone("UTC"));
        return r5;
    L7:
        return Long.valueOf(Process.myTid());
    }
}
