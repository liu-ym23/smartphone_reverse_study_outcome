package com.android.settings.localepicker;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.app.LocalePicker;
import com.android.internal.app.LocalePickerWithRegion;
import com.android.internal.app.LocaleStore;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LocaleListEditor extends SettingsPreferenceFragment implements LocalePickerWithRegion.LocaleSelectedListener {
    private static final String CFGKEY_REMOVE_DIALOG = "showingLocaleRemoveDialog";
    private static final String CFGKEY_REMOVE_MODE = "localeRemoveMode";
    private static final int MENU_ID_REMOVE = 2;
    private LocaleDragAndDropAdapter mAdapter;
    private View mAddLanguage;
    private Menu mMenu;
    private boolean mRemoveMode;
    private boolean mShowingRemoveDialog;

    public void com_android_settings_localepicker_LocaleListEditor__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_localepicker_LocaleListEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_localepicker_LocaleListEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LocaleListEditor() {
    }

    static /* synthetic */ boolean access$002(LocaleListEditor r0, boolean r1) {
        r0.mShowingRemoveDialog = r1;
        return r1;
    }

    static /* synthetic */ boolean access$102(LocaleListEditor r0, boolean r1) {
        r0.mRemoveMode = r1;
        return r1;
    }

    static /* synthetic */ LocaleDragAndDropAdapter access$200(LocaleListEditor r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ void access$300(LocaleListEditor r0, boolean r1) {
        r0.setRemoveMode(r1);
    }

    public void com_android_settings_localepicker_LocaleListEditor__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setHasOptionsMenu(true);
        LocaleStore.fillCache(getContext());
        List<LocaleStore.LocaleInfo> r4 = getUserLocaleList(getContext());
        this.mAdapter = new LocaleDragAndDropAdapter(getContext(), r4);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = super.onCreateView(r2, r3, r4);
        View r6 = r2.inflate(R.layout.locale_order_list, (ViewGroup) r5);
        getActivity().setTitle(R.string.pref_title_lang_selection);
        configureDragAndDrop(r6);
        return r5;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r3) {
        super.onViewStateRestored(r3);
        if (r3 == null) goto L5;
        this.mRemoveMode = r3.getBoolean(CFGKEY_REMOVE_MODE, false);
        this.mShowingRemoveDialog = r3.getBoolean(CFGKEY_REMOVE_DIALOG, false);
    L5:
        setRemoveMode(this.mRemoveMode);
        this.mAdapter.restoreState(r3);
        if (this.mShowingRemoveDialog == false) goto L9;
        showRemoveLocaleWarningDialog();
        return;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putBoolean(CFGKEY_REMOVE_MODE, this.mRemoveMode);
        r3.putBoolean(CFGKEY_REMOVE_DIALOG, this.mShowingRemoveDialog);
        this.mAdapter.saveState(r3);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r4) {
        int r0 = r4.getItemId();
        if (r0 == 2) goto L14;
        if (r0 != 16908332) goto L12;
        if (this.mRemoveMode == false) goto L12;
        setRemoveMode(false);
        return true;
    L12:
        return super.onOptionsItemSelected(r4);
    L14:
        if (this.mRemoveMode == false) goto L16;
        showRemoveLocaleWarningDialog();
    L17:
        return true;
    L16:
        setRemoveMode(true);
        goto L17
    }

    private void setRemoveMode(boolean r2) {
        this.mRemoveMode = r2;
        this.mAdapter.setRemoveMode(r2);
        View r0 = this.mAddLanguage;
        if (r2 == false) goto L5;
        int r3 = 4;
    L6:
        r0.setVisibility(r3);
        updateVisibilityOfRemoveMenu();
        return;
    L5:
        r3 = 0;
        goto L6
    }

    private void showRemoveLocaleWarningDialog() {
        int r0 = this.mAdapter.getCheckedCount();
        if (r0 != 0) goto L7;
        setRemoveMode(!this.mRemoveMode);
        return;
    L7:
        if (r0 != this.mAdapter.getItemCount()) goto L10;
        this.mShowingRemoveDialog = true;
        new AlertDialog.Builder(getActivity()).setTitle(R.string.dlg_remove_locales_error_title).setMessage(R.string.dlg_remove_locales_error_message).setPositiveButton(android.R.string.yes, new AnonymousClass2(this)).setOnDismissListener(new AnonymousClass1(this)).create().show();
        return;
    L10:
        String r1 = getResources().getQuantityString(R.plurals.dlg_remove_locales_title, r0);
        this.mShowingRemoveDialog = true;
        new AlertDialog.Builder(getActivity()).setTitle(r1).setMessage(R.string.dlg_remove_locales_message).setNegativeButton(android.R.string.no, new AnonymousClass5(this)).setPositiveButton(android.R.string.yes, new AnonymousClass4(this)).setOnDismissListener(new AnonymousClass3(this)).create().show();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r4, MenuInflater r5) {
        MenuItem r0 = r4.add(0, 2, 0, R.string.locale_remove_menu);
        r0.setShowAsAction(4);
        r0.setIcon(R.drawable.ic_delete);
        super.onCreateOptionsMenu(r4, r5);
        this.mMenu = r4;
        updateVisibilityOfRemoveMenu();
    }

    private static List<LocaleStore.LocaleInfo> getUserLocaleList(Context r3) {
        ArrayList r4 = new ArrayList();
        LocaleList r0 = LocalePicker.getLocales();
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L6;
        r4.add(LocaleStore.getLocaleInfo(r0.get(r1)));
        r1 = r1 + 1;
        goto L4
    L6:
        return r4;
    }

    private void configureDragAndDrop(View r5) {
        RecyclerView r0 = (RecyclerView) r5.findViewById(R.id.dragList);
        if (getContext() != null) goto L5;
        return;
    L5:
        LocaleLinearLayoutManager r1 = new LocaleLinearLayoutManager(getContext(), this.mAdapter);
        r1.setAutoMeasureEnabled(true);
        r0.setLayoutManager(r1);
        r0.setHasFixedSize(true);
        this.mAdapter.setRecyclerView(r0);
        r0.setAdapter(this.mAdapter);
        View r6 = r5.findViewById(R.id.add_language);
        this.mAddLanguage = r6;
        r6.setOnClickListener(new AnonymousClass6(this));
    }

    public void onLocaleSelected(LocaleStore.LocaleInfo r2) {
        this.mAdapter.addLocale(r2);
        updateVisibilityOfRemoveMenu();
    }

    private void updateVisibilityOfRemoveMenu() {
        Menu r0 = this.mMenu;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = 2;
        MenuItem r2 = r0.findItem(2);
        if (r2 == null) goto L16;
        boolean r3 = false;
        if (this.mRemoveMode == true) goto L11;
        r1 = 0;
    L11:
        r2.setShowAsAction(r1);
        if (this.mAdapter.getItemCount() <= 1) goto L14;
        r3 = true;
    L14:
        r2.setVisible(r3);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_localepicker_LocaleListEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LocaleListEditor r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_localepicker_LocaleListEditor__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_localepicker_LocaleListEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LocaleListEditor r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_localepicker_LocaleListEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_localepicker_LocaleListEditor_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LocaleListEditor r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_localepicker_LocaleListEditor__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
