package com.obric.security.battertpower;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.view.Window;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.apm.ApmHelper;
import com.obric.olog.OLog;
import com.obric.oui.OuiWidgetUtils;
import com.obric.security.R;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BatteryPowerActivityViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ \u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u0019R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007¨\u0006%"}, d2 = {"Lcom/obric/security/battertpower/BatteryPowerActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "agreeGrant", "Landroidx/lifecycle/MutableLiveData;", "", "getAgreeGrant", "()Landroidx/lifecycle/MutableLiveData;", "appPowerProfileData", "", "Lcom/obric/security/battertpower/AppPowerProfileData;", "getAppPowerProfileData", "dataList", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "dropdown", "getDropdown", "dropdownShow", "getDropdownShow", "decimalFormat", "", "float", "getDurationDesc", "", "app", "getPowerProfileData", "", "context", "Landroid/content/Context;", "popPermissionDialogIfNeeded", "activity", "Lcom/bytedanceos/security/BaseActivity;", "isAllowed", "from", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BatteryPowerActivityViewModel extends ViewModel {
    public static final Companion Companion = null;
    private final MutableLiveData<Boolean> agreeGrant;
    private final MutableLiveData<List<AppPowerProfileData>> appPowerProfileData;
    private List<AppPowerProfileData> dataList;
    private final MutableLiveData<Boolean> dropdown;
    private final MutableLiveData<Boolean> dropdownShow;

    /* JADX INFO: compiled from: BatteryPowerActivityViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lcom/obric/security/battertpower/BatteryPowerActivityViewModel$Companion;", "", "()V", "formatDuration", "", "seconds", "", "formatDurationForCharacters", "getAppInfo", "Lkotlin/Pair;", "Landroid/graphics/drawable/Drawable;", "packageName", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String formatDuration(long r6) {
            long r0 = 60;
            long r7 = r6 / r0;
            if (r7 >= r0) goto L6;
            return r7 + " min";
        L6:
            return new StringBuilder().append(r7 / r0).append(" h ").append(r7 % r0).append(" min").toString();
        }

        public final String formatDurationForCharacters(long r8) {
            long r0 = 60;
            long r9 = r8 / r0;
            if (r9 < r0) goto L10;
            long r3 = r9 / r0;
            long r10 = r9 % r0;
            long r1 = 24;
            if (r3 < r1) goto L9;
            return new StringBuilder().append(r3 / r1).append(SecurityCenterApplication.getApplication().getString(R.string.days)).append(' ').append(r3 % r1).append(SecurityCenterApplication.getApplication().getString(R.string.hours)).toString();
        L9:
            return r3 + SecurityCenterApplication.getApplication().getString(R.string.hours) + ' ' + r10 + SecurityCenterApplication.getApplication().getString(R.string.minutes);
        L10:
            return r9 + SecurityCenterApplication.getApplication().getString(R.string.minutes);
        }

        public final Pair<String, Drawable> getAppInfo(String r4) {
            Intrinsics.checkNotNullParameter(r4, "packageName");
            Context r3 = SecurityCenterApplication.getContext();     // Catch: PackageManager.NameNotFoundException -> L8
            Intrinsics.checkNotNullExpressionValue(r3, "SecurityCenterApplication.getContext()");     // Catch: PackageManager.NameNotFoundException -> L8
            PackageManager r5 = r3.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L8
            boolean r0 = false;
            ApplicationInfo r6 = r5.getApplicationInfo(r4, 0);     // Catch: PackageManager.NameNotFoundException -> L8
            Intrinsics.checkNotNullExpressionValue(r6, "packageManager.getApplicationInfo(packageName, 0)");     // Catch: PackageManager.NameNotFoundException -> L8
            String r1 = r5.getApplicationLabel(r6).toString();     // Catch: PackageManager.NameNotFoundException -> L8
            Drawable r7 = r5.getApplicationIcon(r6);     // Catch: PackageManager.NameNotFoundException -> L8
            Intrinsics.checkNotNullExpressionValue(r7, "packageManager.getApplicationIcon(info)");     // Catch: PackageManager.NameNotFoundException -> L8
            if (UserHandle.getUserId(r6.uid) != 10) goto L6;
            r0 = true;
        L6:
            return TuplesKt.to(r1, OuiWidgetUtils.applyDopplegangerBadge(SecurityCenterApplication.getContext(), r7, r0));
        L8:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.battertpower.BatteryPowerActivityViewModel$getPowerProfileData$1, reason: invalid class name */
    /* JADX INFO: compiled from: BatteryPowerActivityViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.battertpower.BatteryPowerActivityViewModel$getPowerProfileData$1", f = "BatteryPowerActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BatteryPowerActivityViewModel this$0;

        AnonymousClass1(BatteryPowerActivityViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "completion");
            return new AnonymousClass1(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L40;
            ResultKt.throwOnFailure(r10);
            ArrayList<AppPowerProfileData> r11 = PowerAdvisorService.getAllAppPowerList();
            Intrinsics.checkNotNullExpressionValue(r11, "apps");
            List r12 = CollectionsKt.sortedWith(r11, new BatteryPowerActivityViewModel$getPowerProfileData$1$invokeSuspend$$inlined$sortedByDescending$1());
            Ref.IntRef r0 = new Ref.IntRef();
            r0.element = 0;
            List r13 = r12;
            Iterator r2 = r13.iterator();
        L6:
            if (r2.hasNext() == false) goto L8;
            r0.element += ((AppPowerProfileData) r2.next()).getPowermAh();
            goto L6
        L8:
            Iterator r3 = r13.iterator();
        L10:
            if (r3.hasNext() == false) goto L12;
            AppPowerProfileData r4 = (AppPowerProfileData) r3.next();
            r4.setPercent(this.this$0.decimalFormat((r4.getPowermAh() * 100) / r0.element));
            BatteryPowerActivityViewModel r5 = this.this$0;
            Intrinsics.checkNotNullExpressionValue(r4, "app");
            r4.setDurationDesc(r5.getDurationDesc(r4));
            goto L10
        L12:
            BatteryPowerActivityViewModel r1 = this.this$0;
            ArrayList r6 = new ArrayList();
            Iterator r14 = r13.iterator();
        L13:
            boolean r7 = true;
            if (r14.hasNext() == false) goto L33;
            Object r8 = r14.next();
            AppPowerProfileData r9 = (AppPowerProfileData) r8;
            if (r9.getPercent() > 0) goto L18;
        L22:
            boolean r15 = false;
        L24:
            if (r9.getPercent() <= 3) goto L26;
            boolean r16 = true;
        L27:
            if (r15 == true) goto L31;
            if (r16 == true) goto L31;
            r7 = false;
        L31:
            if (r7 == false) goto L13;
            r6.add(r8);
            goto L13
        L26:
            r16 = false;
            goto L27
        L18:
            if (r9.getFgDurationSec() <= 60) goto L20;
        L21:
            r15 = true;
            goto L24
        L20:
            if (r9.getBgDurationSec() <= 60) goto L22;
        L33:
            r1.setDataList(r6);
            if (this.this$0.getDataList().size() <= 3) goto L36;
            this.this$0.getDropdownShow().postValue(Boxing.boxBoolean(true));
        L37:
            this.this$0.getAppPowerProfileData().postValue(this.this$0.getDataList());
            return Unit.INSTANCE;
        L36:
            this.this$0.getDropdownShow().postValue(Boxing.boxBoolean(false));
            goto L37
        L40:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BatteryPowerActivityViewModel() {
        this.dropdown = new MutableLiveData(false);
        this.dropdownShow = new MutableLiveData(false);
        this.appPowerProfileData = new MutableLiveData();
        this.dataList = new ArrayList();
        this.agreeGrant = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getDropdown() {
        return this.dropdown;
    }

    public final MutableLiveData<Boolean> getDropdownShow() {
        return this.dropdownShow;
    }

    public final MutableLiveData<List<AppPowerProfileData>> getAppPowerProfileData() {
        return this.appPowerProfileData;
    }

    public final List<AppPowerProfileData> getDataList() {
        return this.dataList;
    }

    public final void setDataList(List<AppPowerProfileData> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dataList = r2;
    }

    public final void getPowerProfileData(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        OLog.i("AppPowerProfileData", "start request app power data");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final float decimalFormat(float r2) {
        DecimalFormat r1 = new DecimalFormat("#.#");
        r1.setRoundingMode(RoundingMode.HALF_UP);
        String r3 = r1.format(Float.valueOf(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "df.format(float)");
        return Float.parseFloat(r3);
    }

    public final String getDurationDesc(AppPowerProfileData r6) {
        Intrinsics.checkNotNullParameter(r6, "app");
        Companion r5 = Companion;
        String r0 = r5.formatDuration(r6.getFgDurationSec());
        String r7 = r5.formatDuration(r6.getBgDurationSec());
        if (r6.getFgDurationSec() <= 60) goto L9;
        if (r6.getBgDurationSec() <= 60) goto L9;
        return SecurityCenterApplication.getApplication().getString(R.string.foreground) + r0 + " | " + SecurityCenterApplication.getApplication().getString(R.string.background) + r7;
    L9:
        if (r6.getFgDurationSec() <= 60) goto L13;
        return SecurityCenterApplication.getApplication().getString(R.string.foreground) + r0;
    L13:
        if (r6.getBgDurationSec() <= 60) goto L17;
        return SecurityCenterApplication.getApplication().getString(R.string.background) + r7;
    L17:
        if (r6.getFgDurationSec() <= 0) goto L23;
        if (r6.getBgDurationSec() <= 0) goto L23;
        return SecurityCenterApplication.getApplication().getString(R.string.foreground) + "1 min | " + SecurityCenterApplication.getApplication().getString(R.string.background) + "1 min";
    L23:
        if (r6.getFgDurationSec() <= 0) goto L27;
        return SecurityCenterApplication.getApplication().getString(R.string.foreground) + "1 min";
    L27:
        if (r6.getBgDurationSec() > 0) goto L29;
        return "";
    L29:
        return SecurityCenterApplication.getApplication().getString(R.string.background) + "1 min";
    }

    public static /* synthetic */ void popPermissionDialogIfNeeded$default(BatteryPowerActivityViewModel r0, BaseActivity r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        r0.popPermissionDialogIfNeeded(r1, r2, r3);
    }

    public final void popPermissionDialogIfNeeded(final BaseActivity r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r10, "from");
        if ((!GrantUtil.INSTANCE.isAllowed(r8, r10, false)) == false) goto L5;
        GrantUtil.requestGrant$default(GrantUtil.INSTANCE, r8, new C03411(this, r8), r10, false, 8, null);
        return;
    L5:
        Context r11 = r8.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r11, "activity.applicationContext");
        ApmHelper.onPrivacyApproved(r11);
        Window r12 = r8.getWindow();
        Intrinsics.checkNotNullExpressionValue(r12, "activity.window");
        r12.getDecorView().postDelayed(new AnonymousClass2(this), 0);
    }

    public final MutableLiveData<Boolean> getAgreeGrant() {
        return this.agreeGrant;
    }
}
