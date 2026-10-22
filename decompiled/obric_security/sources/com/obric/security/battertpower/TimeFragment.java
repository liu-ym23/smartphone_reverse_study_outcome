package com.obric.security.battertpower;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: TimeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/security/battertpower/TimeFragment;", "Landroidx/fragment/app/Fragment;", "consumptionRankingRoot", "Landroid/view/View;", "(Landroid/view/View;)V", "()V", "adapter", "Lcom/obric/security/battertpower/TimeAdapter;", "batteryPowerActivityViewModel", "Lcom/obric/security/battertpower/BatteryPowerActivityViewModel;", "dropdown", "Landroid/widget/ImageView;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "showAllContainer", "Lcom/obric/oui/lisitem/OCardListItem;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "scrollToTargetView", "scrollView", "Lcom/obric/oui/bouncelayout/ONestedScrollView;", "targetView", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TimeFragment extends Fragment {
    private HashMap _$_findViewCache;
    private TimeAdapter adapter;
    private BatteryPowerActivityViewModel batteryPowerActivityViewModel;
    private View consumptionRankingRoot;
    private ImageView dropdown;
    private RecyclerView recyclerView;
    private OCardListItem showAllContainer;

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L13;
        View r1 = getView();
        if (r1 != null) goto L11;
        return null;
    L11:
        View r2 = r1.findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r2);
        return r2;
    L13:
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public TimeFragment() {
    }

    public static final /* synthetic */ TimeAdapter access$getAdapter$p(TimeFragment r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ BatteryPowerActivityViewModel access$getBatteryPowerActivityViewModel$p(TimeFragment r0) {
        return r0.batteryPowerActivityViewModel;
    }

    public static final /* synthetic */ View access$getConsumptionRankingRoot$p(TimeFragment r0) {
        return r0.consumptionRankingRoot;
    }

    public static final /* synthetic */ ImageView access$getDropdown$p(TimeFragment r0) {
        return r0.dropdown;
    }

    public static final /* synthetic */ OCardListItem access$getShowAllContainer$p(TimeFragment r0) {
        return r0.showAllContainer;
    }

    public static final /* synthetic */ void access$scrollToTargetView(TimeFragment r0, ONestedScrollView r1, View r2) {
        r0.scrollToTargetView(r1, r2);
    }

    public static final /* synthetic */ void access$setAdapter$p(TimeFragment r0, TimeAdapter r1) {
        r0.adapter = r1;
    }

    public static final /* synthetic */ void access$setBatteryPowerActivityViewModel$p(TimeFragment r0, BatteryPowerActivityViewModel r1) {
        r0.batteryPowerActivityViewModel = r1;
    }

    public static final /* synthetic */ void access$setConsumptionRankingRoot$p(TimeFragment r0, View r1) {
        r0.consumptionRankingRoot = r1;
    }

    public static final /* synthetic */ void access$setDropdown$p(TimeFragment r0, ImageView r1) {
        r0.dropdown = r1;
    }

    public static final /* synthetic */ void access$setShowAllContainer$p(TimeFragment r0, OCardListItem r1) {
        r0.showAllContainer = r1;
    }

    public TimeFragment(View r1) {
        this();
        this.consumptionRankingRoot = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(R.layout.app_battery_profile, r3, false);
        Intrinsics.checkNotNullExpressionValue(r5, "inflater.inflate(R.layou…rofile, container, false)");
        this.recyclerView = (RecyclerView) r5.findViewById(R.id.recyclerView_battery_profile);
        this.showAllContainer = (OCardListItem) r5.findViewById(R.id.show_all_container);
        return r5;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        Object r8 = r6.getContext();
        Boolean r1 = null;
        if ((r8 instanceof ViewModelStoreOwner) == true) goto L5;
        r8 = null;
    L5:
        ViewModelStoreOwner r9 = (ViewModelStoreOwner) r8;
        if (r9 == null) goto L8;
        this.batteryPowerActivityViewModel = (BatteryPowerActivityViewModel) new ViewModelProvider(r9).get(BatteryPowerActivityViewModel.class);
    L8:
        LayoutInflater r10 = LayoutInflater.from(getContext());
        OCardListItem r0 = this.showAllContainer;
        if (r0 == null) goto L11;
        ViewGroup r2 = (ViewGroup) r0.findViewById(R.id.custom_start_container);
    L12:
        View r11 = r10.inflate(R.layout.expand_more, r2, false);
        this.dropdown = (ImageView) r11.findViewById(R.id.dropdown);
        final OTextView r3 = (OTextView) r11.findViewById(R.id.show_all_text);
        this.adapter = new TimeAdapter();
        RecyclerView r4 = this.recyclerView;
        if (r4 == null) goto L15;
        r4.setLayoutManager(new LinearLayoutManager(r6.getContext()));
    L15:
        RecyclerView r12 = this.recyclerView;
        if (r12 == null) goto L18;
        r12.setAdapter(this.adapter);
    L18:
        RecyclerView r13 = this.recyclerView;
        if (r13 == null) goto L21;
        RecyclerView.ItemAnimator r5 = (RecyclerView.ItemAnimator) null;
        r13.setItemAnimator(null);
    L21:
        BatteryPowerActivityViewModel r14 = this.batteryPowerActivityViewModel;
        if (r14 == null) goto L26;
        MutableLiveData<Boolean> r15 = r14.getDropdown();
        if (r15 == null) goto L26;
        r15.observe(getViewLifecycleOwner(), new AnonymousClass2(this, r3));
    L26:
        BatteryPowerActivityViewModel r16 = this.batteryPowerActivityViewModel;
        if (r16 == null) goto L31;
        MutableLiveData<List<AppPowerProfileData>> r17 = r16.getAppPowerProfileData();
        if (r17 == null) goto L31;
        r17.observe(getViewLifecycleOwner(), new AnonymousClass3(this));
    L31:
        OCardListItem r18 = this.showAllContainer;
        if (r18 == null) goto L34;
        r18.setOnContentClickListener(new AnonymousClass4(this));
    L34:
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())));
        r19.gravity = 17;
        r11.setLayoutParams(r19);
        OCardListItem r20 = this.showAllContainer;
        if (r20 == null) goto L37;
        OCardListItem.setCardPosition$default(r20, 3, false, 2, null);
    L37:
        OCardListItem r21 = this.showAllContainer;
        if (r21 == null) goto L40;
        r21.setCardType(2);
    L40:
        OCardListItem r22 = this.showAllContainer;
        if (r22 == null) goto L43;
        r22.setCustomStartView(r11);
    L43:
        OCardListItem r23 = this.showAllContainer;
        if (r23 == null) goto L46;
        r23.showCustomStart(true);
    L46:
        BatteryPowerActivityViewModel r24 = this.batteryPowerActivityViewModel;
        if (r24 == null) goto L51;
        MutableLiveData<Boolean> r25 = r24.getDropdownShow();
        if (r25 == null) goto L51;
        r25.observe(getViewLifecycleOwner(), new AnonymousClass5(this));
    L51:
        BatteryPowerActivityViewModel r26 = this.batteryPowerActivityViewModel;
        if (r26 == null) goto L57;
        MutableLiveData<Boolean> r27 = r26.getDropdownShow();
        if (r27 == null) goto L57;
        r1 = r27.getValue();
    L57:
        if (Intrinsics.areEqual(r1, true) == false) goto L67;
        ImageView r28 = this.dropdown;
        if (r28 == null) goto L61;
        r28.setVisibility(0);
    L61:
        OCardListItem r29 = this.showAllContainer;
        if (r29 == null) goto L64;
        r29.setVisibility(0);
    L64:
        TimeAdapter r30 = this.adapter;
        if (r30 == null) goto L77;
        r30.setDropdown(true);
        return;
    L77:
        return;
    L67:
        ImageView r31 = this.dropdown;
        if (r31 == null) goto L70;
        r31.setVisibility(8);
    L70:
        OCardListItem r32 = this.showAllContainer;
        if (r32 == null) goto L73;
        r32.setVisibility(8);
    L73:
        TimeAdapter r33 = this.adapter;
        if (r33 == null) goto L79;
        r33.setDropdown(false);
        return;
    L79:
        return;
    L11:
        r2 = null;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    private final void scrollToTargetView(ONestedScrollView r1, View r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        r1.scrollTo(0, 0);
        return;
    L8:
        return;
    }
}
