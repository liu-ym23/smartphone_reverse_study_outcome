package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StubViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/oui/banner/StubViewHolder;", "Lcom/obric/oui/banner/BannerViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "data", "Lcom/obric/oui/banner/BannerData;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StubViewHolder extends BannerViewHolder {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: StubViewHolder.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/banner/StubViewHolder$Companion;", "Lcom/obric/oui/banner/IBannerViewHolderFactory;", "()V", "key", "", "getKey", "()Ljava/lang/String;", "newInstance", "Lcom/obric/oui/banner/BannerViewHolder;", "parent", "Landroid/view/ViewGroup;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion implements IBannerViewHolderFactory {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Override // com.obric.oui.banner.IBannerViewHolderFactory
        public String getKey() {
            return "_stub";
        }

        private Companion() {
        }

        @Override // com.obric.oui.banner.IBannerViewHolderFactory
        public BannerViewHolder newInstance(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            View r1 = new View(r2.getContext());
            r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new StubViewHolder(r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.oui.banner.BannerViewHolder
    public void onBind(BannerData r1) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }

    public StubViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }
}
