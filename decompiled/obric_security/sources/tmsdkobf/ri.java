package tmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ri extends Handler {
    public ri(Looper r1, String r2) {
        super(r1);
    }

    protected abstract void a(Message r1);

    @Override // android.os.Handler
    public void handleMessage(Message r1) {
        a(r1);
    }
}
