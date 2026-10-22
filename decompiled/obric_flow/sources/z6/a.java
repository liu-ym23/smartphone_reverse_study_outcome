package z6;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f23408a;

    static {
        new HashSet();
        f23408a = new Handler(Looper.getMainLooper());
    }
}
