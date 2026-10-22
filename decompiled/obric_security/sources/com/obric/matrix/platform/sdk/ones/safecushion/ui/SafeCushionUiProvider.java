package com.obric.matrix.platform.sdk.ones.safecushion.ui;

import android.app.Activity;
import android.view.View;
import kotlin.Metadata;

/* JADX INFO: compiled from: SafeCushionUiProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionUiProvider;", "", "onCreateView", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "controller", "Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionController;", "onDestroy", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SafeCushionUiProvider {

    /* JADX INFO: compiled from: SafeCushionUiProvider.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onDestroy(SafeCushionUiProvider r0) {
        }
    }

    View onCreateView(Activity r1, SafeCushionController r2);

    void onDestroy();
}
