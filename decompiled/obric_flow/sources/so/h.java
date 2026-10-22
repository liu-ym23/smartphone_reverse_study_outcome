package so;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21980c;
    public boolean d;
    public boolean e;
    public int f;
    public boolean g;

    public h(Context r5) {
        this.f21979b = 14;
        this.f21980c = 20971520;
        this.d = true;
        this.e = true;
        this.f = 3;
        this.g = false;
        if (r5 == null) goto L10;
        Context r10 = r5.getApplicationContext();
        if (r10 == null) goto L7;
        r5 = r10;
    L7:
        this.f21978a = r5;
        return;
    L10:
        throw new RuntimeException("context must not be null");
    }

    public final i a() {
        i r5 = new i();
        Context r10 = this.f21978a;
        r5.f21981a = r10;
        r5.f21982b = this.f21979b;
        r5.f21983c = this.f21980c;
        r5.f21990n = 0.1f;
        r5.d = 2097152;
        String r11 = null;
        if (TextUtils.isEmpty(null) == false) goto L5;
        String r12 = com.lynx.tasm.behavior.ui.utils.e.n(r10);
    L6:
        r5.e = r12;
        if (TextUtils.isEmpty(null) == false) goto L12;
        File r13 = new File(r10.getFilesDir(), "ologs");
        if (r13.exists() == true) goto L11;
        r13.mkdir();
    L11:
        r11 = r13.getAbsolutePath();
    L12:
        r5.f = r11;
        r5.g = this.d;
        r5.f21984h = this.e;
        r5.f21985i = this.f;
        r5.f21986j = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
        r5.f21987k = true;
        r5.f21988l = this.g;
        r5.f21989m = 256;
        return r5;
    L5:
        r12 = null;
        goto L6
    }
}
