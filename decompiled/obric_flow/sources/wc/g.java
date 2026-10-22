package wc;

import ai.j0;
import android.webkit.WebResourceRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jg.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f22837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22838c;
    public Integer d;
    public boolean e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22839h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f22840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f22842k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22843l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f22844m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22845n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public k f22846o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f22847p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f22848q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f22849r;
    public WebResourceRequest s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f22850t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Map f22851u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f22852v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f22853w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f22854x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f22855y;

    public g(String r5) {
        Intrinsics.checkNotNullParameter(r5, "accessKey");
        this.f22836a = r5;
        this.f22837b = new a(false);
        this.f22838c = "";
        this.f = "";
        this.g = "";
        this.f22839h = "";
        this.f22840i = "";
        this.f22841j = true;
        this.f22842k = new ArrayList();
        this.f22847p = CollectionsKt.emptyList();
        this.f22848q = "";
        this.f22852v = true;
        this.f22855y = "default_bid";
    }

    public final void a(g r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        this.f22838c = r5.f22838c;
        this.f22837b = r5.f22837b;
        this.d = r5.d;
        this.e = r5.e;
        this.f = r5.f;
        this.g = r5.g;
        this.f22839h = r5.f22839h;
        this.f22841j = r5.f22841j;
        this.f22840i = r5.f22840i;
        this.f22842k = r5.f22842k;
        this.f22843l = r5.f22843l;
        this.f22844m = r5.f22844m;
        this.f22846o = r5.f22846o;
        this.f22848q = r5.f22848q;
        this.f22855y = r5.f22855y;
        this.f22853w = r5.f22853w;
        this.f22854x = r5.f22854x;
        this.f22851u = r5.f22851u;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("[accessKey=");
        r5.append(this.f22836a);
        r5.append(", loaderConfig=");
        r5.append(this.f22837b);
        r5.append(", dynamic=");
        r5.append(this.d);
        r5.append(",onlyLocal=");
        r5.append(this.e);
        r5.append(", channel=");
        r5.append(this.f);
        r5.append(",bundle=");
        r5.append(this.g);
        r5.append(", group=null,cdnUrl=");
        r5.append(this.f22839h);
        r5.append(",enableCached:");
        r5.append(this.f22841j);
        r5.append("]\n[fallbackDomains=");
        r5.append(this.f22842k);
        r5.append(",shuffle = ");
        r5.append(this.f22843l);
        r5.append(",cdnNoCache=");
        r5.append(this.f22844m);
        r5.append("，maxAttempt=0，isRemote=");
        return j0.r(r5, this.f22845n, ",useInteraction = 0]");
    }
}
