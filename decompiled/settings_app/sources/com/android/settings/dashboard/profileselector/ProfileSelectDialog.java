package com.android.settings.dashboard.profileselector;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.UserInfo;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.android.internal.widget.DialogTitle;
import com.android.internal.widget.LinearLayoutManager;
import com.android.internal.widget.RecyclerView;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;
import com.android.settingslib.drawer.Tile;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ProfileSelectDialog extends DialogFragment implements UserAdapter.OnClickListener {
    private static final String ARG_SELECTED_TILE = "selectedTile";
    private static final String ARG_SOURCE_METRIC_CATEGORY = "sourceMetricCategory";
    private static final boolean DEBUG = false;
    private static final String TAG = "ProfileSelectDialog";
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private DialogInterface.OnShowListener mOnShowListener;
    private Tile mSelectedTile;
    private int mSourceMetricCategory;

    public void com_android_settings_dashboard_profileselector_ProfileSelectDialog__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_dashboard_profileselector_ProfileSelectDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_dashboard_profileselector_ProfileSelectDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ProfileSelectDialog() {
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public static void show(FragmentManager r3, Tile r4, int r5, DialogInterface.OnShowListener r6, DialogInterface.OnDismissListener r7, DialogInterface.OnCancelListener r8) {
        ProfileSelectDialog r0 = new ProfileSelectDialog();
        Bundle r1 = new Bundle();
        r1.putParcelable(ARG_SELECTED_TILE, r4);
        r1.putInt(ARG_SOURCE_METRIC_CATEGORY, r5);
        r0.setArguments(r1);
        r0.mOnShowListener = r6;
        r0.mOnDismissListener = r7;
        r0.mOnCancelListener = r8;
        r0.show(r3, "select_profile");
    }

    public void com_android_settings_dashboard_profileselector_ProfileSelectDialog__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = requireArguments();
        this.mSelectedTile = (Tile) r4.getParcelable(ARG_SELECTED_TILE, Tile.class);
        this.mSourceMetricCategory = r4.getInt(ARG_SOURCE_METRIC_CATEGORY);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        return createDialog(getContext(), this.mSelectedTile.userHandle, this);
    }

    public static Dialog createDialog(Context r4, List<UserHandle> r5, UserAdapter.OnClickListener r6) {
        LayoutInflater r0 = (LayoutInflater) r4.getSystemService(LayoutInflater.class);
        View r1 = (DialogTitle) r0.inflate(R.layout.user_select_title, null);
        r1.setText(R.string.choose_profile);
        View r2 = r0.inflate(R.layout.user_select, null);
        RecyclerView r3 = r2.findViewById(R.id.list);
        r3.setAdapter(UserAdapter.createUserRecycleViewAdapter(r4, r5, r6));
        r3.setLayoutManager(new LinearLayoutManager(r4, 0, false));
        return new AlertDialog.Builder(r4).setCustomTitle(r1).setView(r2).create();
    }

    @Override // com.android.settings.dashboard.profileselector.UserAdapter.OnClickListener
    public void onClick(int r7) {
        UserHandle r0 = this.mSelectedTile.userHandle.get(r7);
        boolean r2 = false;
        if (this.mSelectedTile.hasPendingIntent() == true) goto L8;
        Intent r1 = new Intent(this.mSelectedTile.getIntent());
        MetricsFeatureProvider r4 = new MetricsFeatureProvider();
        int r5 = this.mSourceMetricCategory;
        if (r7 != 1) goto L7;
        r2 = true;
    L7:
        r4.logStartedIntentWithProfile(r1, r5, r2);
        r1.addFlags(32768);
        getActivity().startActivityAsUser(r1, r0);
    L16:
        dismiss();
        return;
    L8:
        PendingIntent r3 = this.mSelectedTile.pendingIntentMap.get(r0);
        MetricsFeatureProvider r6 = new MetricsFeatureProvider();
        String r8 = this.mSelectedTile.getKey(getContext());
        int r9 = this.mSourceMetricCategory;
        if (r7 != 1) goto L11;
        r2 = true;
    L11:
        r6.logSettingsTileClickWithProfile(r8, r9, r2);
        r3.send();     // Catch: PendingIntent.CanceledException -> L14
    L14:
        e = move-exception;
        OLog.w(TAG, "Failed executing pendingIntent. " + r3.getIntent(), e);
        goto L16
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        DialogInterface.OnShowListener r0 = this.mOnShowListener;
        if (r0 == null) goto L6;
        r0.onShow(getDialog());
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r1) {
        super.onCancel(r1);
        DialogInterface.OnCancelListener r0 = this.mOnCancelListener;
        if (r0 == null) goto L6;
        r0.onCancel(r1);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        super.onDismiss(r1);
        DialogInterface.OnDismissListener r0 = this.mOnDismissListener;
        if (r0 == null) goto L6;
        r0.onDismiss(r1);
        return;
    }

    public static void updateUserHandlesIfNeeded(Context r3, Tile r4) {
        ArrayList<UserHandle> r0 = r4.userHandle;
        if (r4.userHandle != null) goto L5;
        return;
    L5:
        if (r4.userHandle.size() <= 1) goto L24;
        UserManager r5 = UserManager.get(r3);
        int r6 = r0.size() - 1;
    L8:
        if (r6 < 0) goto L25;
        UserInfo r1 = r5.getUserInfo(r0.get(r6).getIdentifier());
        if (r1 == null) goto L16;
        if (r1.isCloneProfile() == true) goto L16;
        if (shouldHideUser(r0.get(r6), r5) == true) goto L16;
    L19:
        r6 = r6 - 1;
    L16:
        if (DEBUG == false) goto L18;
        OLog.d(TAG, "Delete the user: " + r0.get(r6).getIdentifier());
    L18:
        r0.remove(r6);
        goto L19
    L25:
        return;
    }

    public static void updatePendingIntentsIfNeeded(Context r5, Tile r6) {
        if (r6.userHandle != null) goto L5;
        return;
    L5:
        if (r6.userHandle.size() > 1) goto L7;
        return;
    L7:
        if (r6.pendingIntentMap.size() <= 1) goto L45;
        Iterator r0 = List.copyOf(r6.userHandle).iterator();
    L11:
        if (r0.hasNext() == false) goto L18;
        UserHandle r1 = (UserHandle) r0.next();
        if (r6.pendingIntentMap.containsKey(r1) == true) goto L11;
        if (DEBUG == false) goto L17;
        OLog.d(TAG, "Delete the user without pending intent: " + r1.getIdentifier());
    L17:
        r6.userHandle.remove(r1);
        goto L11
    L18:
        UserManager r7 = UserManager.get(r5);
        Iterator r2 = List.copyOf(r6.pendingIntentMap.keySet()).iterator();
    L20:
        if (r2.hasNext() == false) goto L46;
        UserHandle r3 = (UserHandle) r2.next();
        UserInfo r4 = r7.getUserInfo(r3.getIdentifier());
        if (r4 == null) goto L28;
        if (r4.isCloneProfile() == true) goto L28;
        if (shouldHideUser(r3, r7) == false) goto L20;
    L28:
        if (DEBUG == false) goto L30;
        OLog.d(TAG, "Delete the user: " + r3.getIdentifier());
    L30:
        r6.userHandle.remove(r3);
        r6.pendingIntentMap.remove(r3);
        goto L20
    L46:
        return;
    }

    public static boolean shouldHideUser(UserHandle r2, UserManager r3) {
        if (r3.getUserProperties(r2).getShowInQuietMode() == 1) goto L5;
    L7:
        return false;
    L5:
        if (r3.isQuietModeEnabled(r2) == false) goto L7;
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_dashboard_profileselector_ProfileSelectDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ProfileSelectDialog r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_dashboard_profileselector_ProfileSelectDialog__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_dashboard_profileselector_ProfileSelectDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ProfileSelectDialog r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_dashboard_profileselector_ProfileSelectDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_dashboard_profileselector_ProfileSelectDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ProfileSelectDialog r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_dashboard_profileselector_ProfileSelectDialog__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
