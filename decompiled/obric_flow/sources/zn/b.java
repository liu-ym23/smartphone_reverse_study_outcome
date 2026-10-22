package zn;

import android.text.TextUtils;
import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f23553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f23554c;

    public /* synthetic */ b(int r5, String r10, ReadableMap r11) {
        this.f23552a = r5;
        this.f23553b = r11;
        this.f23554c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f23552a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        new HashMap();
        ReadableMap r5 = this.f23553b;
        if (r5 == null) goto L7;
        r5.asHashMap();
    L7:
        a r10 = a.f23550b;
        r10.getClass();
        if (TextUtils.isEmpty(this.f23554c) == true) goto L18;
        r10.a();
        return;
    L18:
        return;
    L11:
        new HashMap();
        ReadableMap r11 = this.f23553b;
        if (r11 == null) goto L14;
        r11.asHashMap();
    L14:
        a r12 = a.f23550b;
        r12.getClass();
        if (TextUtils.isEmpty(this.f23554c) == true) goto L19;
        r12.a();
        return;
    }
}
