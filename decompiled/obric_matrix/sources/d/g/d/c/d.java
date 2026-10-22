package d.g.d.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.obric.common.oui.f;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f16842f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f16843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f16844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f16845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f16846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f16847e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final d a(LayoutInflater r1, ViewGroup r2, boolean r3) {
            o.f(r1, "inflater");
            View r0 = r1.inflate(com.obric.common.oui.g.o, r2, r3);
            o.e(r0, "root");
            return new d(r0);
        }
    }

    static {
        f16842f = new a(null);
    }

    public d(View r3) {
        o.f(r3, "root");
        this.f16843a = r3;
        View r0 = r3.findViewById(f.M);
        o.e(r0, "root.findViewById(R.id.dialog_title)");
        this.f16844b = (TextView) r0;
        View r1 = r3.findViewById(f.L);
        o.e(r1, "root.findViewById(R.id.dialog_message)");
        this.f16845c = (TextView) r1;
        View r2 = r3.findViewById(f.B);
        o.e(r2, "root.findViewById(R.id.cancel)");
        this.f16846d = (TextView) r2;
        View r4 = r3.findViewById(f.E);
        o.e(r4, "root.findViewById(R.id.confirm)");
        this.f16847e = (TextView) r4;
    }

    public final TextView a() {
        return this.f16846d;
    }

    public final TextView b() {
        return this.f16847e;
    }

    public final TextView c() {
        return this.f16845c;
    }

    public final TextView d() {
        return this.f16844b;
    }

    public final View e() {
        return this.f16843a;
    }
}
