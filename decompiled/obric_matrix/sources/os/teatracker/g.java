package os.teatracker;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f22717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f22718b = null;

    static {
        Uri r0 = Uri.parse("content://os.teatracker");
        f22717a = r0;
        Uri.parse("content://com.obric.idprovider");
        Uri.parse("content://os.teatracker/event_data");
        f22718b = Uri.parse(r0 + "/getDeviceId");
    }
}
