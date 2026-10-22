package com.obric.security.cleanerpage;

import android.content.Context;
import android.view.Window;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.datausage.DataUsageActivity;
import com.bytedanceos.security.BaseActivity;
import com.obric.apm.ApmHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataUsageViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/security/cleanerpage/DataUsageViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "agreeGrant", "Landroidx/lifecycle/MutableLiveData;", "", "getAgreeGrant", "()Landroidx/lifecycle/MutableLiveData;", "popPermissionDialogIfNeeded", "", "activity", "Lcom/bytedanceos/security/BaseActivity;", "isAllowed", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DataUsageViewModel extends ViewModel {
    public static final Companion Companion = null;
    private final MutableLiveData<Boolean> agreeGrant;

    /* JADX INFO: compiled from: DataUsageViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/security/cleanerpage/DataUsageViewModel$Companion;", "", "()V", "getDataUsageViewModel", "Lcom/obric/security/cleanerpage/DataUsageViewModel;", "activity", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final DataUsageViewModel getDataUsageViewModel(Context r1) {
            if ((r1 instanceof DataUsageActivity) == true) goto L5;
            return null;
        L5:
            return (DataUsageViewModel) new ViewModelProvider((ViewModelStoreOwner) r1).get(DataUsageViewModel.class);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DataUsageViewModel() {
        this.agreeGrant = new MutableLiveData();
    }

    public final void popPermissionDialogIfNeeded(final BaseActivity r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        if (r10 == true) goto L5;
        GrantUtil.requestGrant$default(GrantUtil.INSTANCE, r9, new AnonymousClass1(this, r9), null, false, 12, null);
        return;
    L5:
        Context r11 = r9.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r11, "activity.applicationContext");
        ApmHelper.onPrivacyApproved(r11);
        Window r12 = r9.getWindow();
        Intrinsics.checkNotNullExpressionValue(r12, "activity.window");
        r12.getDecorView().postDelayed(new AnonymousClass2(this), 0);
    }

    public final MutableLiveData<Boolean> getAgreeGrant() {
        return this.agreeGrant;
    }
}
