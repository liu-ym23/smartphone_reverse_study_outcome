package com.obric.matrix.platform.sdk.ones.safecushion.ui;

import androidx.core.app.NotificationCompat;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import com.obric.matrix.platform.sdk.ones.safecushion.repair.BaseRepair;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: SafeCushionController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u000fH&JT\u0010\u0015\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000b28\u0010\u0018\u001a4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f0\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionController;", "", "crashCount", "", "getCrashCount", "()I", SearchConfigType.KEY_MODE, "", "getMode", "()Ljava/lang/String;", "repairAliases", "", "getRepairAliases", "()Ljava/util/List;", SafeCushionConstant.FINISH_STATE, "", "killApp", "markFinished", "openMarket", "", "restartApp", "startRepair", "repairList", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/BaseRepair;", "onResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", NotificationCompat.CATEGORY_MESSAGE, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SafeCushionController {

    /* JADX INFO: compiled from: SafeCushionController.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startRepair$default(SafeCushionController r0, List r1, Function2 r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 1) == 0) goto L6;
            r1 = null;
        L6:
            r0.startRepair(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startRepair");
        }
    }

    void finish();

    int getCrashCount();

    String getMode();

    List<String> getRepairAliases();

    void killApp();

    void markFinished();

    boolean openMarket();

    void restartApp();

    void startRepair(List<? extends BaseRepair> r1, Function2<? super Boolean, ? super String, Unit> r2);
}
