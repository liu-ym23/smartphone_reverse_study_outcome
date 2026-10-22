package tmsdkobf;

import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public class r7 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f469a;
    private int b;
    private q7 c;

    public r7(q7 r2, int r3, String r4) {
        super(null);
        this.c = r2;
        this.b = r3;
        this.f469a = r4;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r2) {
        q7 r3 = this.c;
        if (r3 == null) goto L5;
        r3.a(this.b, this.f469a);
        return;
    L5:
        Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
    }
}
