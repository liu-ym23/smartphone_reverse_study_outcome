package com.android.settings.wifi.main;

import android.app.Activity;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.AccessPointInfo;
import com.android.settings.wifi.AccessPointView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: WifiListSetupAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000256Bq\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\u0018H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0016J\b\u0010&\u001a\u00020\u000eH\u0016J\u0006\u0010'\u001a\u00020\u000eJ\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0018H\u0016J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0018H\u0016J\u0010\u0010.\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u000100J\b\u00101\u001a\u00020\u000eH\u0016J\u0010\u00102\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u000100J\u0018\u00103\u001a\u00020\u000e2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001cX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/android/settings/wifi/main/WifiListSetupAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/android/settings/wifi/main/WifiListSetupAdapter$CustomViewHolder;", "activity", "Landroid/app/Activity;", "isActivateMode", "", "constructAccessPointsAction", "Lkotlin/Function0;", "", "Lcom/android/settings/wifi/AccessPointInfo;", "onBindHeader", "Lkotlin/Function1;", "Landroid/view/View;", "", "onClickItem", "onBindFooter", "Lkotlin/Function2;", "(Landroid/app/Activity;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "accessPointsList", "", "headerCount", "", "mDataSetObservable", "Landroid/database/DataSetObservable;", "mWifiManager", "Landroid/net/wifi/WifiManager;", "getMWifiManager", "()Landroid/net/wifi/WifiManager;", "checkItemPosition", "listPosition", "position", "getAccessPointInfo", "getData", "getItemCount", "getItemViewType", "initData", "notifyDataSetChangedCustom", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "registerDataSetObserver", "observer", "Landroid/database/DataSetObserver;", "tryUpdateConnectedAccessPointRssi", "unregisterDataSetObserver", "updateData", "accessPoints", "Companion", "CustomViewHolder", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class WifiListSetupAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    public static final Companion Companion = null;
    private static final int TYPE_FOOTER = 0;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_TITLE = 0;
    private final String TAG;
    private final List<AccessPointInfo> accessPointsList;
    private final Activity activity;
    private final Function0<List<AccessPointInfo>> constructAccessPointsAction;
    private final int headerCount;
    private final boolean isActivateMode;
    private final DataSetObservable mDataSetObservable;
    private final WifiManager mWifiManager;
    private final Function2<View, Boolean, Unit> onBindFooter;
    private final Function1<View, Unit> onBindHeader;
    private final Function1<AccessPointInfo, Unit> onClickItem;

    /* JADX INFO: compiled from: WifiListSetupAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/settings/wifi/main/WifiListSetupAdapter$Companion;", "", "()V", "TYPE_FOOTER", "", "TYPE_HEADER", "TYPE_ITEM", "TYPE_TITLE", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: WifiListSetupAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/android/settings/wifi/main/WifiListSetupAdapter$CustomViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "accessPointView", "Lcom/android/settings/wifi/AccessPointView;", "getAccessPointView", "()Lcom/android/settings/wifi/AccessPointView;", "setAccessPointView", "(Lcom/android/settings/wifi/AccessPointView;)V", "footerView", "getFooterView", "()Landroid/view/View;", "setFooterView", "(Landroid/view/View;)V", "headerView", "getHeaderView", "setHeaderView", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        private AccessPointView accessPointView;
        private View footerView;
        private View headerView;

        public CustomViewHolder(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            if (r3 != WifiListSetupAdapter.access$getTYPE_HEADER$cp()) goto L6;
            this.headerView = r2;
            return;
        L6:
            if (r3 != WifiListSetupAdapter.access$getTYPE_FOOTER$cp()) goto L9;
            this.footerView = r2;
            return;
        L9:
            if ((r2 instanceof AccessPointView) == false) goto L11;
            AccessPointView r4 = (AccessPointView) r2;
        L12:
            this.accessPointView = r4;
            return;
        L11:
            r4 = null;
            goto L12
        }

        public final View getHeaderView() {
            return this.headerView;
        }

        public final void setHeaderView(View r1) {
            this.headerView = r1;
        }

        public final AccessPointView getAccessPointView() {
            return this.accessPointView;
        }

        public final void setAccessPointView(AccessPointView r1) {
            this.accessPointView = r1;
        }

        public final View getFooterView() {
            return this.footerView;
        }

        public final void setFooterView(View r1) {
            this.footerView = r1;
        }
    }

    /* JADX INFO: renamed from: com.android.settings.wifi.main.WifiListSetupAdapter$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: WifiListSetupAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.wifi.main.WifiListSetupAdapter$initData$1", f = "WifiListSetupAdapter.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WifiListSetupAdapter this$0;

        /* JADX INFO: renamed from: com.android.settings.wifi.main.WifiListSetupAdapter$initData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WifiListSetupAdapter.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.wifi.main.WifiListSetupAdapter$initData$1$1", f = "WifiListSetupAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<AccessPointInfo> $accessPoints;
            int label;
            final /* synthetic */ WifiListSetupAdapter this$0;

            /* JADX WARN: Multi-variable type inference failed */
            C00401(WifiListSetupAdapter r1, List<? extends AccessPointInfo> r2, Continuation<? super C00401> r3) {
                this.this$0 = r1;
                this.$accessPoints = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00401(this.this$0, this.$accessPoints, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00401) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.this$0.updateData(this.$accessPoints);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(WifiListSetupAdapter r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            List r8 = (List) WifiListSetupAdapter.access$getConstructAccessPointsAction$p(this.this$0).invoke();
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C00401(this.this$0, r8, null), this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$NgoKSetRNttyHj1nVBx_xQCybb0(WifiListSetupAdapter r0, AccessPointInfo r1, View r2) {
        onBindViewHolder$lambda$6$lambda$5(r0, r1, r2);
    }

    public static final /* synthetic */ Function0 access$getConstructAccessPointsAction$p(WifiListSetupAdapter r0) {
        return r0.constructAccessPointsAction;
    }

    public static final /* synthetic */ int access$getTYPE_FOOTER$cp() {
        return TYPE_FOOTER;
    }

    public static final /* synthetic */ int access$getTYPE_HEADER$cp() {
        return TYPE_HEADER;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((CustomViewHolder) r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WifiListSetupAdapter(Activity r2, boolean r3, Function0<? extends List<? extends AccessPointInfo>> r4, Function1<? super View, Unit> r5, Function1<? super AccessPointInfo, Unit> r6, Function2<? super View, ? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r4, "constructAccessPointsAction");
        this.activity = r2;
        this.isActivateMode = r3;
        this.constructAccessPointsAction = r4;
        this.onBindHeader = r5;
        this.onClickItem = r6;
        this.onBindFooter = r7;
        this.TAG = "WifiListSetupAdapter";
        Object r8 = SettingsApplication.getContext().getSystemService("wifi");
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.mWifiManager = (WifiManager) r8;
        this.accessPointsList = new ArrayList();
        this.headerCount = !r3 ? 1 : 0;
        this.mDataSetObservable = new DataSetObservable();
    }

    protected final WifiManager getMWifiManager() {
        return this.mWifiManager;
    }

    static {
        Companion = new Companion(null);
        TYPE_FOOTER = 1;
        TYPE_ITEM = 2;
        TYPE_TITLE = 3;
    }

    public final void registerDataSetObserver(DataSetObserver r1) {
        this.mDataSetObservable.registerObserver(r1);
    }

    public final void unregisterDataSetObserver(DataSetObserver r1) {
        this.mDataSetObservable.unregisterObserver(r1);
    }

    public final void notifyDataSetChangedCustom() {
        notifyDataSetChanged();
        this.mDataSetObservable.notifyChanged();
    }

    public void initData() {
        if (this.mWifiManager.getWifiState() != 3) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    }

    public List<AccessPointInfo> getData() {
        return this.accessPointsList;
    }

    public void updateData(List<? extends AccessPointInfo> r3) {
        List<AccessPointInfo> r0 = this.accessPointsList;
        r0.clear();
        if (r3 == null) goto L5;
        r0.addAll(r3);
    L5:
        notifyDataSetChangedCustom();
        List<? extends AccessPointInfo> r4 = r3;
        if (r4 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        AppMetricsUtils.INSTANCE.durationEventEnd("wifi_switch_on");
        return;
    L15:
        return;
    L8:
        if (r4.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public AccessPointInfo getAccessPointInfo(int r1) {
        return (AccessPointInfo) CollectionsKt.getOrNull(this.accessPointsList, r1);
    }

    public void tryUpdateConnectedAccessPointRssi() {
        AccessPointInfo r0 = getAccessPointInfo(0);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != NetworkInfo.DetailedState.CONNECTED) goto L9;
        notifyDataSetChangedCustom();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 != TYPE_HEADER) goto L6;
        View r1 = LayoutInflater.from(this.activity).inflate(R.layout.wifi_switch, null);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.RelativeLayout");
        AccessPointView r4 = (RelativeLayout) r1;
    L9:
        Intrinsics.checkNotNull(r4);
        return new CustomViewHolder(r4, r3);
    L6:
        if (r3 != TYPE_FOOTER) goto L8;
        r4 = LayoutInflater.from(this.activity).inflate(R.layout.wifi_settings_bottom_add_network_provision, null);
        goto L9
    L8:
        AccessPointView r5 = new AccessPointView(this.activity);
        r5.setClipChildren(false);
        r5.setClipToPadding(false);
        r5.setGravity(1);
        r4 = r5;
        goto L9
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r2) {
        int r0 = this.headerCount;
        if (r2 >= r0) goto L6;
        return TYPE_HEADER;
    L6:
        if (r2 < (r0 + this.accessPointsList.size())) goto L9;
        return TYPE_FOOTER;
    L9:
        return TYPE_ITEM;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return (this.accessPointsList.size() + this.headerCount) + 1;
    }

    private final int checkItemPosition(int r6, int r7) {
        if (r6 == 0) goto L25;
        int r8 = getItemViewType(r7);
        int r1 = TYPE_FOOTER;
        if (r8 == r1) goto L23;
        int r9 = getItemViewType(r6 - 1);
        int r5 = getItemViewType(r6 + 1);
        int r10 = TYPE_TITLE;
        if (r9 != r10) goto L11;
    L20:
        if (r5 == r10) goto L22;
        return 1;
    L22:
        return 0;
    L11:
        if (r9 == TYPE_HEADER) goto L20;
        int r11 = TYPE_ITEM;
        if (r9 != r11) goto L22;
        if (r5 == r11) goto L26;
        if (r5 != r1) goto L23;
        return 2;
    L26:
        return 2;
    L23:
        return 3;
    L25:
        return 1;
    }

    public void onBindViewHolder(CustomViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        int r0 = r8.getItemViewType();
        if (r0 != TYPE_HEADER) goto L10;
        View r10 = r8.getHeaderView();
        if (r10 == null) goto L25;
        Function1<View, Unit> r7 = this.onBindHeader;
        if (r7 == null) goto L26;
        r7.invoke(r10);
        return;
    L26:
        return;
    L25:
        return;
    L10:
        if (r0 != TYPE_FOOTER) goto L16;
        View r11 = r8.getFooterView();
        if (r11 == null) goto L28;
        Function2<View, Boolean, Unit> r12 = this.onBindFooter;
        if (r12 == null) goto L29;
        r12.invoke(r11, Boolean.valueOf(!this.accessPointsList.isEmpty()));
        return;
    L29:
        return;
    L28:
        return;
    L16:
        AccessPointView r13 = r8.getAccessPointView();
        if (r13 == null) goto L31;
        int r4 = r9 - this.headerCount;
        final AccessPointInfo r6 = this.accessPointsList.get(r4);
        r13.bindData(this.mWifiManager, this.isActivateMode, r6, r4, checkItemPosition(r9, r4));
        View r14 = r13.getItemContainer();
        if ((r14 instanceof OCardListItem) == false) goto L21;
        OCardListItem r15 = (OCardListItem) r14;
    L22:
        if (r15 == null) goto L32;
        r15.setOnContentClickListener(new WifiListSetupAdapter$$ExternalSyntheticLambda0(this, r6));
        return;
    L32:
        return;
    L21:
        r15 = null;
        goto L22
    }

    private static final void onBindViewHolder$lambda$6$lambda$5(WifiListSetupAdapter r0, AccessPointInfo r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$accessPoint");
        Function1<AccessPointInfo, Unit> r3 = r0.onClickItem;
        if (r3 == null) goto L6;
        r3.invoke(r1);
        return;
    }
}
