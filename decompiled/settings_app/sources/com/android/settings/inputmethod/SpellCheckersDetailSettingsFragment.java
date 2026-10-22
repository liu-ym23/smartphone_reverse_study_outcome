package com.android.settings.inputmethod;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.SpellCheckerSubtype;
import android.view.textservice.TextServicesManager;
import android.widget.AdapterView;
import android.widget.ListView;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemCheck;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SpellCheckersDetailSettingsFragment extends BaseFragment {
    private LanguageAdapter mAdapter;
    private int mCheckedItem;
    private View mHeaderSettings;
    private CharSequence[] mItems;
    private ListView mListView;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private SpellCheckerInfo mSpellCheckerInfo;
    private int mStaticItemCount;
    private TextServicesManager mTsm;

    class LanguageAdapter extends SettingsAdapter {
        final /* synthetic */ SpellCheckersDetailSettingsFragment this$0;

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        LanguageAdapter(SpellCheckersDetailSettingsFragment r1) {
            this.this$0 = r1;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return SpellCheckersDetailSettingsFragment.access$200(this.this$0).getSubtypeCount() + 1;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            boolean r0 = false;
            if (r5 != null) goto L5;
            r5 = ((LayoutInflater) this.this$0.getSystemService("layout_inflater")).inflate(R.layout.olist_content_item_check, r6, false);
            OListItemCheck r7 = (OListItemCheck) r5.findViewById(R.id.item_check);
            r5.setTag(r7);
        L6:
            r7.setTrailingImageView(this.this$0.mContext.getDrawable(R.drawable.icon_check_confirm_rounded));
            r7.setTitle(SpellCheckersDetailSettingsFragment.access$600(this.this$0)[r4].toString());
            if (SpellCheckersDetailSettingsFragment.access$300(this.this$0) != r4) goto L9;
            r0 = true;
        L9:
            r7.setChecked(r0);
            return r5;
        L5:
            r7 = (OListItemCheck) r5.getTag();
            goto L6
        }
    }

    public void com_android_settings_inputmethod_SpellCheckersDetailSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_inputmethod_SpellCheckersDetailSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_SpellCheckersDetailSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_SpellCheckersDetailSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SpellCheckersDetailSettingsFragment() {
        this.mStaticItemCount = 1;
        this.mOnItemClickListener = new AnonymousClass1(this);
    }

    static /* synthetic */ ListView access$000(SpellCheckersDetailSettingsFragment r0) {
        return r0.mListView;
    }

    static /* synthetic */ int access$100(SpellCheckersDetailSettingsFragment r0) {
        return r0.mStaticItemCount;
    }

    static /* synthetic */ SpellCheckerInfo access$200(SpellCheckersDetailSettingsFragment r0) {
        return r0.mSpellCheckerInfo;
    }

    static /* synthetic */ int access$300(SpellCheckersDetailSettingsFragment r0) {
        return r0.mCheckedItem;
    }

    static /* synthetic */ int access$302(SpellCheckersDetailSettingsFragment r0, int r1) {
        r0.mCheckedItem = r1;
        return r1;
    }

    static /* synthetic */ LanguageAdapter access$400(SpellCheckersDetailSettingsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ String access$500(SpellCheckersDetailSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ CharSequence[] access$600(SpellCheckersDetailSettingsFragment r0) {
        return r0.mItems;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mSpellCheckerInfo = (SpellCheckerInfo) getArguments().getParcelable("spellCheckerInfo");
        this.mTsm = (TextServicesManager) getSystemService("textservices");
        fillListData();
        this.mRootView = r2.inflate(R.layout.spell_checkers_detail_settings_layout, r3, false);
        this.mListView = (ListView) findViewByIdNullable(android.R.id.list);
        LanguageAdapter r5 = new LanguageAdapter(this);
        this.mAdapter = r5;
        this.mListView.setAdapter(r5);
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        addHeaderFooter();
        return this.mRootView;
    }

    private void addHeaderFooter() {
        if (this.mListView.getFooterViewsCount() != 0) goto L10;
        View r0 = Utils.inflateListTransparentHeader(this._mActivity);
        this.mListView.addFooterView(r0);
        this.mHeaderSettings = this.mLayoutInflater.inflate(R.layout.spell_checkers_detail_settings_header, this.mListView, false);
        if (this.mSpellCheckerInfo.getSettingsActivity() != null) goto L7;
        this.mHeaderSettings.setEnabled(false);
        this.mHeaderSettings.setClickable(false);
        ((OListItemSettings) this.mHeaderSettings.findViewById(R.id.item_id_settings)).setEnabled(false);
    L8:
        this.mListView.addHeaderView(this.mHeaderSettings);
        return;
    L7:
        this.mHeaderSettings.setOnClickListener(new AnonymousClass2(this));
        goto L8
    }

    private void fillListData() {
        int r0 = this.mSpellCheckerInfo.getSubtypeCount();
        CharSequence[] r1 = new CharSequence[r0 + 1];
        this.mItems = r1;
        int r3 = 0;
        r1[0] = getString(R.string.use_system_language_to_select_input_method_subtypes);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        CharSequence r4 = this.mSpellCheckerInfo.getSubtypeAt(r2).getDisplayName(this.mContext, this.mSpellCheckerInfo.getPackageName(), this.mSpellCheckerInfo.getServiceInfo().applicationInfo);
        r2 = r2 + 1;
        this.mItems[r2] = r4;
        goto L3
    L5:
        this.mCheckedItem = 0;
        TextServicesManager r5 = this.mTsm;
        if (r5 == null) goto L14;
        SpellCheckerSubtype r6 = r5.getCurrentSpellCheckerSubtype(false);
        if (r6 == null) goto L18;
    L9:
        if (r3 >= r0) goto L20;
        if (this.mSpellCheckerInfo.getSubtypeAt(r3).equals(r6) == true) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        this.mCheckedItem = r3 + this.mStaticItemCount;
        return;
    L20:
        return;
    L18:
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_SpellCheckersDetailSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SpellCheckersDetailSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_SpellCheckersDetailSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_SpellCheckersDetailSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SpellCheckersDetailSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_SpellCheckersDetailSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_SpellCheckersDetailSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SpellCheckersDetailSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_SpellCheckersDetailSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
