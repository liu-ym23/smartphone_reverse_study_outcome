package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class StubViewHolder extends BannerViewHolder {
    public static final Companion g = null;

    @Metadata
    public static final class Companion implements IBannerViewHolderFactory {
        @Override // com.obric.oui.banner.IBannerViewHolderFactory
        public final StubViewHolder a(ViewGroup r2) {
            Intrinsics.f(r2, "parent");
            View r1 = new View(r2.getContext());
            r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new StubViewHolder(r1);
        }
    }

    static {
        g = new Companion();
    }

    @Override // com.obric.oui.banner.BannerViewHolder
    public final void b(BannerData r1) {
        Intrinsics.f(r1, "data");
    }
}
