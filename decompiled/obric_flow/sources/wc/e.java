package wc;

import ai.j0;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f22827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22828c;
    public final String d;
    public final String e;
    public final GeckoConfig f;
    public final LinkedHashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f22830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f22832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashMap f22833l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public gc.a f22834m;

    public e(String r5, ArrayList r10, String r11, String r12, String r13, GeckoConfig r14, LinkedHashMap r15, com.bytedance.ies.bullet.kit.resourceloader.b r16) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter("CN", "region");
        Intrinsics.checkNotNullParameter(r10, "prefix");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        Intrinsics.checkNotNullParameter(r12, "appVersion");
        Intrinsics.checkNotNullParameter(r13, "did");
        Intrinsics.checkNotNullParameter(r14, "dftGeckoCfg");
        Intrinsics.checkNotNullParameter(r15, "geckoConfigs");
        Intrinsics.checkNotNullParameter(r16, "downloadDepender");
        this.f22826a = r5;
        this.f22827b = r10;
        this.f22828c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f22829h = 25165824;
        this.f22831j = true;
        this.f22832k = new ArrayList();
        this.f22833l = new LinkedHashMap();
        this.f22834m = new com.lynx.tasm.behavior.d(17);
    }

    public final GeckoConfig a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "ak");
        GeckoConfig r10 = (GeckoConfig) this.g.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return this.f;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("{[host]=");
        r5.append(this.f22826a);
        r5.append(",[region]=CN,[prefix]=");
        ArrayList r10 = this.f22827b;
        Object[] r11 = r10.toArray(new String[0]);
        if (r11 == null) goto L7;
        r5.append(Arrays.toString(r11));
        r5.append(",[appId]=");
        r5.append(this.f22828c);
        r5.append(",[appVersion]=");
        r5.append(this.d);
        r5.append(",[did]=");
        return j0.p(r5, this.e, '}');
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
