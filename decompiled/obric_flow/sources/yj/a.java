package yj;

import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f23284c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f23285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f23286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f23287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f23288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f23289l;

    public a() {
        this.f23282a = false;
        this.f23283b = true;
        this.f23284c = null;
        this.d = 10;
        this.e = 3;
        this.f = 3;
        this.g = 10;
        this.f23285h = 3;
        this.f23286i = 3;
        this.f23287j = LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST;
        this.f23288k = 120;
        this.f23289l = null;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder(" localEnable: ");
        r5.append(this.f23282a);
        r5.append(" probeEnable: ");
        r5.append(this.f23283b);
        r5.append(" hostFilter: ");
        HashMap r10 = this.f23284c;
        if (r10 == null) goto L5;
        int r11 = r10.size();
    L6:
        r5.append(r11);
        r5.append(" reqTo: ");
        r5.append(this.d);
        r5.append("#");
        r5.append(this.e);
        r5.append("#");
        r5.append(this.f);
        r5.append(" reqErr: ");
        r5.append(this.g);
        r5.append("#");
        r5.append(this.f23285h);
        r5.append("#");
        r5.append(this.f23286i);
        r5.append(" updateInterval: ");
        r5.append(this.f23287j);
        r5.append(" updateRandom: ");
        r5.append(this.f23288k);
        r5.append(" httpBlack: ");
        r5.append(this.f23289l);
        return r5.toString();
    L5:
        r11 = 0;
        goto L6
    }
}
