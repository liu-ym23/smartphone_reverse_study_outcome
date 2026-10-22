package com.obric.security.battertpower.powerHigh.clearApp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.security.battertpower.powerHigh.notice.PowerHighApp;
import com.obric.security.battertpower.powerHigh.notice.PowerHighAppsManager;
import com.obric.security.battertpower.powerHigh.notice.PowerHighWarningReceiver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PowerHighAppsViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0013\u001a\u00020\u00142\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007J.\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u00112\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u0011J\u000e\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0014R'\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u00110\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/clearApp/PowerHighAppsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "checkApps", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/HashSet;", "Lcom/obric/security/battertpower/powerHigh/notice/PowerHighApp;", "Lkotlin/collections/HashSet;", "getCheckApps", "()Landroidx/lifecycle/MutableLiveData;", "checkAppsChange", "", "getCheckAppsChange", "packageManager", "Landroid/content/pm/PackageManager;", "powerHighApps", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPowerHighApps", "clearPowerHighApps", "", "apps", "fillAppName", "context", "Landroid/content/Context;", "setCheckAppChange", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerHighAppsViewModel extends ViewModel {
    private final MutableLiveData<HashSet<PowerHighApp>> checkApps;
    private final MutableLiveData<Integer> checkAppsChange;
    private final PackageManager packageManager;
    private final MutableLiveData<ArrayList<PowerHighApp>> powerHighApps;

    /* JADX INFO: renamed from: com.obric.security.battertpower.powerHigh.clearApp.PowerHighAppsViewModel$getPowerHighApps$1, reason: invalid class name */
    /* JADX INFO: compiled from: PowerHighAppsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.battertpower.powerHigh.clearApp.PowerHighAppsViewModel$getPowerHighApps$1", f = "PowerHighAppsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ PowerHighAppsViewModel this$0;

        AnonymousClass1(PowerHighAppsViewModel r1, Context r2, Continuation r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, this.$context, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            if (PowerHighWarningReceiver.powerHighApps.size() <= 0) goto L7;
            PowerHighAppsManager r6 = PowerHighAppsManager.INSTANCE;
            Context r1 = this.$context;
            ArrayList<PowerHighApp> r2 = PowerHighWarningReceiver.powerHighApps;
            Intrinsics.checkNotNullExpressionValue(r2, "PowerHighWarningReceiver.powerHighApps");
            ArrayList<PowerHighApp> r7 = this.this$0.fillAppName(r6.filterDeadProcesses(r1, r2));
            OLog.d("PowerHighAppsManager", "memory cache find power high apps is :" + r7 + ", memory cache origin list is:" + PowerHighWarningReceiver.powerHighApps);
            this.this$0.getPowerHighApps().postValue(r7);
        L9:
            return Unit.INSTANCE;
        L7:
            ArrayList<PowerHighApp> r8 = this.this$0.fillAppName(PowerHighAppsManager.INSTANCE.filterDeadProcesses(this.$context, PowerHighAppsManager.INSTANCE.mergeAndRemoveDuplicates(new ArrayList(), PowerHighAppsManager.INSTANCE.getLocalPowerHighApps(this.$context))));
            OLog.d("PowerHighAppsManager", "local database find power high apps is :" + r8);
            this.this$0.getPowerHighApps().postValue(r8);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PowerHighAppsViewModel() {
        this.checkApps = new MutableLiveData(new HashSet());
        this.checkAppsChange = new MutableLiveData();
        this.powerHighApps = new MutableLiveData();
        PackageManager r0 = SecurityCenterApplication.getApplication().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(r0, "SecurityCenterApplicatio…ion().getPackageManager()");
        this.packageManager = r0;
    }

    public final MutableLiveData<HashSet<PowerHighApp>> getCheckApps() {
        return this.checkApps;
    }

    public final MutableLiveData<Integer> getCheckAppsChange() {
        return this.checkAppsChange;
    }

    public final MutableLiveData<ArrayList<PowerHighApp>> getPowerHighApps() {
        return this.powerHighApps;
    }

    public final void getPowerHighApps(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        OLog.d("PowerHighAppsManager", "start search power high apps in clearPage");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r9, null), 2, null);
    }

    public final void clearPowerHighApps(HashSet<PowerHighApp> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ArrayList<PowerHighApp> r0 = new ArrayList();
        ArrayList<PowerHighApp> r1 = this.powerHighApps.getValue();
        if (r1 == null) goto L12;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        PowerHighApp r3 = (PowerHighApp) r2.next();
        if (r5.contains(r3) == true) goto L8;
        r0.add(r3);
    L12:
        this.powerHighApps.postValue(r0);
    }

    public final ArrayList<PowerHighApp> fillAppName(ArrayList<PowerHighApp> r6) {
        Intrinsics.checkNotNullParameter(r6, "apps");
        Iterator<T> r0 = r6.iterator();     // Catch: PackageManager.NameNotFoundException -> L8
    L5:
        if (r0.hasNext() == false) goto L10;
        PowerHighApp r1 = (PowerHighApp) r0.next();     // Catch: PackageManager.NameNotFoundException -> L8
        String r2 = r1.getPackageName();     // Catch: PackageManager.NameNotFoundException -> L8
        ApplicationInfo r3 = this.packageManager.getApplicationInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L8
        Intrinsics.checkNotNullExpressionValue(r3, "packageManager.getApplicationInfo(pkg, 0)");     // Catch: PackageManager.NameNotFoundException -> L8
        r1.setLabel(r3.loadLabel(this.packageManager).toString());     // Catch: PackageManager.NameNotFoundException -> L8
    L10:
        return r6;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public final void setCheckAppChange() {
        MutableLiveData<Integer> r0 = this.checkAppsChange;
        HashSet<PowerHighApp> r1 = this.checkApps.getValue();
        if (r1 == null) goto L5;
        int r2 = r1.size();
    L6:
        r0.setValue(Integer.valueOf(r2));
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
