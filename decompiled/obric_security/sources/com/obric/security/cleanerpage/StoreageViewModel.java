package com.obric.security.cleanerpage;

import android.content.Context;
import android.view.Window;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.storage.StorageActivity;
import com.obric.apm.ApmHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StoreageViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/security/cleanerpage/StoreageViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "agreeGrant", "Landroidx/lifecycle/MutableLiveData;", "", "getAgreeGrant", "()Landroidx/lifecycle/MutableLiveData;", "popPermissionDialogIfNeeded", "", "activity", "Lcom/bytedanceos/security/BaseActivity;", "isAllowed", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreageViewModel extends ViewModel {
    public static final Companion Companion = null;
    private final MutableLiveData<Boolean> agreeGrant;

    /* JADX INFO: compiled from: StoreageViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/security/cleanerpage/StoreageViewModel$Companion;", "", "()V", "getStoreageViewModel", "Lcom/obric/security/cleanerpage/StoreageViewModel;", "activity", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final StoreageViewModel getStoreageViewModel(Context r1) {
            if ((r1 instanceof StorageActivity) == true) goto L5;
            return null;
        L5:
            return (StoreageViewModel) new ViewModelProvider((ViewModelStoreOwner) r1).get(StoreageViewModel.class);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StoreageViewModel() {
        this.agreeGrant = new MutableLiveData();
    }

    public final void popPermissionDialogIfNeeded(final BaseActivity r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        if ((!GrantUtil.INSTANCE.isAllowed(r8, "", false)) == false) goto L5;
        GrantUtil.requestGrant$default(GrantUtil.INSTANCE, r8, new AnonymousClass1(this, r8), null, false, 12, null);
        return;
    L5:
        Context r10 = r8.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r10, "activity.applicationContext");
        ApmHelper.onPrivacyApproved(r10);
        Window r11 = r8.getWindow();
        Intrinsics.checkNotNullExpressionValue(r11, "activity.window");
        r11.getDecorView().postDelayed(new AnonymousClass2(this), 0);
    }

    public final MutableLiveData<Boolean> getAgreeGrant() {
        return this.agreeGrant;
    }
}
