package com.obric.security.cleanerpage;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.preventdisturb.DisturbActivity;
import com.bytedanceos.security.BaseActivity;
import com.obric.apm.ApmHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisturbViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/security/cleanerpage/DisturbViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "agreeGrant", "Landroidx/lifecycle/MutableLiveData;", "", "getAgreeGrant", "()Landroidx/lifecycle/MutableLiveData;", "popPermissionDialogIfNeeded", "", "activity", "Lcom/bytedanceos/security/BaseActivity;", "isAllowed", "from", "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DisturbViewModel extends ViewModel {
    public static final Companion Companion = null;
    private final MutableLiveData<Boolean> agreeGrant;

    /* JADX INFO: compiled from: DisturbViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/security/cleanerpage/DisturbViewModel$Companion;", "", "()V", "getDisturbViewModel", "Lcom/obric/security/cleanerpage/DisturbViewModel;", "activity", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final DisturbViewModel getDisturbViewModel(Context r1) {
            if ((r1 instanceof DisturbActivity) == true) goto L5;
            return null;
        L5:
            return (DisturbViewModel) new ViewModelProvider((ViewModelStoreOwner) r1).get(DisturbViewModel.class);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DisturbViewModel() {
        this.agreeGrant = new MutableLiveData();
    }

    public static /* synthetic */ void popPermissionDialogIfNeeded$default(DisturbViewModel r0, BaseActivity r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        r0.popPermissionDialogIfNeeded(r1, r2, r3);
    }

    public final void popPermissionDialogIfNeeded(final BaseActivity r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r10, "from");
        if (GrantUtil.INSTANCE.isAllowed(r8, r10, false) == true) goto L5;
        GrantUtil.requestGrant$default(GrantUtil.INSTANCE, r8, new AnonymousClass1(this, r8), r10, false, 8, null);
        return;
    L5:
        Context r11 = r8.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r11, "activity.applicationContext");
        ApmHelper.onPrivacyApproved(r11);
        this.agreeGrant.postValue(true);
    }

    public final MutableLiveData<Boolean> getAgreeGrant() {
        return this.agreeGrant;
    }
}
