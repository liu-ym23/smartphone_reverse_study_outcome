package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/obric/oui/banner/StubViewHolder;", "Lcom/obric/oui/banner/BannerViewHolder;", "Lcom/obric/oui/banner/a;", "data", "Lkotlin/f0;", "e", "(Lcom/obric/oui/banner/a;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "f", "a", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class StubViewHolder extends BannerViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10799f = null;

    public static final class a implements d {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        @Override // com.obric.oui.banner.d
        public BannerViewHolder a(ViewGroup r2) {
            o.f(r2, "parent");
            View r1 = new View(r2.getContext());
            r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            f0 r3 = f0.f18324a;
            return new StubViewHolder(r1);
        }

        public String b() {
            return "_stub";
        }
    }

    static {
        f10799f = new a(null);
    }

    public StubViewHolder(View r2) {
        o.f(r2, "view");
        super(r2);
    }

    @Override // com.obric.oui.banner.BannerViewHolder
    public void e(com.obric.oui.banner.a r1) {
        o.f(r1, "data");
    }
}
