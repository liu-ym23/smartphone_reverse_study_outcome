package com.obric.security.cleanerpage;

import android.content.Context;
import android.view.Window;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.clearmemory.CleanState;
import com.bytedanceos.clearmemory.ManagerApplicationsRunningActivity;
import com.bytedanceos.security.BaseActivity;
import com.obric.apm.ApmHelper;
import com.obric.security.tcsecurity.cleansdk.CleanSDK;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplicationsRunningViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/obric/security/cleanerpage/ApplicationsRunningViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "agreeGrant", "Landroidx/lifecycle/MutableLiveData;", "", "getAgreeGrant", "()Landroidx/lifecycle/MutableLiveData;", "cleaningStatus", "Lcom/bytedanceos/clearmemory/CleanState;", "getCleaningStatus", "popPermissionDialogIfNeeded", "", "activity", "Lcom/bytedanceos/security/BaseActivity;", "isAllowed", "from", "", "forceShow", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ApplicationsRunningViewModel extends ViewModel {
    public static final Companion Companion = null;
    private final MutableLiveData<Boolean> agreeGrant;
    private final MutableLiveData<CleanState> cleaningStatus;

    /* JADX INFO: compiled from: ApplicationsRunningViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/security/cleanerpage/ApplicationsRunningViewModel$Companion;", "", "()V", "getManagerApplicationsRunningActivity", "Lcom/obric/security/cleanerpage/ApplicationsRunningViewModel;", "activity", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ApplicationsRunningViewModel getManagerApplicationsRunningActivity(Context r1) {
            if ((r1 instanceof ManagerApplicationsRunningActivity) == true) goto L5;
            return null;
        L5:
            return (ApplicationsRunningViewModel) new ViewModelProvider((ViewModelStoreOwner) r1).get(ApplicationsRunningViewModel.class);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ApplicationsRunningViewModel() {
        this.agreeGrant = new MutableLiveData();
        MutableLiveData<CleanState> r0 = new MutableLiveData();
        this.cleaningStatus = r0;
        r0.setValue(CleanState.IDLE);
    }

    public static /* synthetic */ void popPermissionDialogIfNeeded$default(ApplicationsRunningViewModel r0, BaseActivity r1, boolean r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        r0.popPermissionDialogIfNeeded(r1, r2, r3, r4);
    }

    public final void popPermissionDialogIfNeeded(final BaseActivity r3, boolean r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r5, "from");
        if ((!GrantUtil.INSTANCE.isAllowed(r3, r5, r6)) == false) goto L5;
        GrantUtil.INSTANCE.requestGrant(r3, new AnonymousClass1(this, r3), r5, r6);
        return;
    L5:
        CleanSDK.INSTANCE.initCleanSDK();
        Context r7 = r3.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r7, "activity.applicationContext");
        ApmHelper.onPrivacyApproved(r7);
        Window r8 = r3.getWindow();
        Intrinsics.checkNotNullExpressionValue(r8, "activity.window");
        r8.getDecorView().postDelayed(new AnonymousClass2(this), 0);
    }

    public final MutableLiveData<Boolean> getAgreeGrant() {
        return this.agreeGrant;
    }

    public final MutableLiveData<CleanState> getCleaningStatus() {
        return this.cleaningStatus;
    }
}
