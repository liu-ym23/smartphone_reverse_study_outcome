package d.b.s.a.q.j;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public d.b.s.a.e0.a f14889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f14890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f14893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f14894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Deprecated
    public String f14895k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<com.ss.android.f> f14896l;
    public JSONObject m;
    public List<Integer> n;
    public final int o;

    public b(boolean r1, int r2) {
        this.f14887c = r1;
        this.o = r2;
    }

    public String toString() {
        return "BaseApiResponse{logId='" + this.f14885a + "', secondaryDecisionConf='" + this.f14886b + "', success=" + this.f14887c + ", mRequestUrl='" + this.f14888d + "', dataTip=" + this.f14890f + ", error=" + this.f14891g + ", mDetailErrorCode=" + this.f14892h + ", errorMsg='" + this.f14893i + "', mDetailErrorMsg='" + this.f14894j + "', url='" + this.f14895k + "', headers=" + this.f14896l + ", result=" + this.m + ", api=" + this.o + ", mErrorCodeTask=" + this.f14889e + '}';
    }
}
