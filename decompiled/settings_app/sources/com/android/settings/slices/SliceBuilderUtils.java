package com.android.settings.slices;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Pair;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.builders.ListBuilder;
import androidx.slice.builders.SliceAction;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.SubSettings;
import com.android.settings.Utils;
import com.android.settings.core.BasePreferenceController;
import com.android.settings.core.SubSettingLauncher;
import com.android.settings.notification.zen.ZenModeSliceBuilder;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.vcard.VCardConfig;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class SliceBuilderUtils {
    public static final String EXTRA_IS_FROM_SLICE = "is_from_slice";
    private static final String TAG = "SliceBuilder";

    public SliceBuilderUtils() {
    }

    public static Slice buildSlice(Context r3, SliceData r4) {
        OLog.d(TAG, "Creating slice for: " + r4.getPreferenceController());
        BasePreferenceController r0 = getPreferenceController(r3, r4);
        if (r0.isAvailable() == true) goto L7;
        return null;
    L7:
        if (r0.getAvailabilityStatus() == 5) goto L9;
        String r1 = r4.getUserRestriction();
        if (TextUtils.isEmpty(r1) == false) goto L13;
    L16:
        int r2 = r4.getSliceType();
        if (r2 == 0) goto L29;
        if (r2 == 1) goto L27;
        if (r2 != 2) goto L25;
        return buildSliderSlice(r3, r4, r0);
    L25:
        throw new IllegalArgumentException("Slice type passed was invalid: " + r4.getSliceType());
    L27:
        return buildToggleSlice(r3, r4, r0);
    L29:
        return buildIntentSlice(r3, r4, r0);
    L13:
        if (RestrictedLockUtilsInternal.checkIfRestrictionEnforced(r3, r1, UserHandle.myUserId()) == null) goto L16;
        return buildIntentSlice(r3, r4, r0);
    L9:
        return buildUnavailableSlice(r3, r4);
    }

    public static Pair<Boolean, String> getPathData(Uri r3) {
        String[] r4 = r3.getPath().split(LibrarianImpl.Constants.SEPARATOR, 3);
        if (r4.length == 3) goto L7;
        return null;
    L7:
        return new Pair(Boolean.valueOf(TextUtils.equals("intent", r4[1])), r4[2]);
    }

    public static BasePreferenceController getPreferenceController(Context r1, SliceData r2) {
        return getPreferenceController(r1, r2.getPreferenceController(), r2.getKey());
    }

    public static PendingIntent getActionIntent(Context r1, String r2, SliceData r3) {
        return PendingIntent.getBroadcast(r1, 0, new Intent(r2).setData(r3.getUri()).setClass(r1, SliceBroadcastReceiver.class).putExtra(SettingsSliceProvider.EXTRA_SLICE_KEY, r3.getKey()), 167772160);
    }

    public static PendingIntent getContentPendingIntent(Context r2, SliceData r3) {
        return PendingIntent.getActivity(r2, 0, getContentIntent(r2, r3), VCardConfig.FLAG_APPEND_TYPE_PARAM);
    }

    public static CharSequence getSubtitleText(Context r1, BasePreferenceController r2, SliceData r3) {
        String r4 = r3.getSummary();
        if (isValidSummary(r1, r4) == false) goto L5;
        return r4;
    L5:
        CharSequence r5 = r3.getScreenTitle();
        if (isValidSummary(r1, r5) == true) goto L8;
        return "";
    L8:
        if (TextUtils.equals(r5, r3.getTitle()) == true) goto L12;
        return r5;
    L12:
        return "";
    }

    public static Intent buildSearchResultPageIntent(Context r4, String r5, String r6, String r7, int r8, int r9) {
        Bundle r0 = new Bundle();
        if (r9 == 0) goto L7;
        String r10 = r4.getString(r9);
        if (TextUtils.isEmpty(r10) == false) goto L8;
        OLog.w(TAG, "Invalid menu key res from: " + r7);
    L8:
        r0.putString(SettingsActivity.EXTRA_FRAGMENT_ARG_KEY, r6);
        Intent r11 = new SubSettingLauncher(r4).setDestination(r5).setArguments(r0).setTitleText(r7).setSourceMetricsCategory(r8).toIntent();
        r11.putExtra(SettingsActivity.EXTRA_FRAGMENT_ARG_KEY, r6).putExtra(EXTRA_IS_FROM_SLICE, true).putExtra("android.provider.extra.SETTINGS_EMBEDDED_DEEP_LINK_HIGHLIGHT_MENU_KEY", r10).setAction("com.android.settings.SEARCH_RESULT_TRAMPOLINE").setComponent(null);
        r11.addFlags(335544320);
        return r11;
    L7:
        r10 = null;
        goto L8
    }

    public static Intent buildSearchResultPageIntent(Context r6, String r7, String r8, String r9, int r10, CustomSliceable r11) {
        return buildSearchResultPageIntent(r6, r7, r8, r9, r10, r11.getSliceHighlightMenuRes());
    }

    public static Intent getContentIntent(Context r8, SliceData r9) {
        Uri r0 = new Uri.Builder().appendPath(r9.getKey()).build();
        if (TextUtils.isEmpty(r9.getScreenTitle()) == false) goto L5;
        String r1 = null;
    L6:
        String r3 = r9.getFragmentClassName();
        String r4 = r9.getKey();
        Intent r10 = buildSearchResultPageIntent(r8, r3, r4, r1, 0, r9.getHighlightMenuRes());
        r10.setClassName(r8.getPackageName(), SubSettings.class.getName());
        r10.setData(r0);
        return r10;
    L5:
        r1 = r9.getScreenTitle().toString();
        goto L6
    }

    private static Slice buildToggleSlice(Context r8, SliceData r9, BasePreferenceController r10) {
        PendingIntent r0 = getContentPendingIntent(r8, r9);
        IconCompat r1 = getSafeIcon(r8, r9);
        CharSequence r11 = getSubtitleText(r8, r10, r9);
        int r2 = Utils.getColorAccentDefaultColor(r8);
        SliceAction r4 = getToggleAction(r8, r9, false);
        Set<String> r5 = buildSliceKeywords(r9);
        ListBuilder.RowBuilder r3 = new ListBuilder.RowBuilder().setTitle(r9.getTitle()).setPrimaryAction(SliceAction.createDeeplink(r0, r1, 0, r9.getTitle())).addEndItem(r4);
        if (ZenModeSliceBuilder.isSettingsIntelligence(r8) == true) goto L6;
        r3.setSubtitle(r11);
    L6:
        return new ListBuilder(r8, r9.getUri(), -1).setAccentColor(r2).addRow(r3).setKeywords(r5).build();
    }

    private static Slice buildIntentSlice(Context r7, SliceData r8, BasePreferenceController r9) {
        PendingIntent r0 = getContentPendingIntent(r7, r8);
        IconCompat r1 = getSafeIcon(r7, r8);
        CharSequence r10 = getSubtitleText(r7, r9, r8);
        int r2 = Utils.getColorAccentDefaultColor(r7);
        Set<String> r3 = buildSliceKeywords(r8);
        ListBuilder.RowBuilder r4 = new ListBuilder.RowBuilder().setTitle(r8.getTitle()).setPrimaryAction(SliceAction.createDeeplink(r0, r1, 0, r8.getTitle()));
        if (ZenModeSliceBuilder.isSettingsIntelligence(r7) == true) goto L6;
        r4.setSubtitle(r10);
    L6:
        return new ListBuilder(r7, r8.getUri(), -1).setAccentColor(r2).addRow(r4).setKeywords(r3).build();
    }

    private static Slice buildSliderSlice(Context r6, SliceData r7, BasePreferenceController r8) {
        PendingIntent r0 = getSliderAction(r6, r7);
        PendingIntent r1 = getContentPendingIntent(r6, r7);
        IconCompat r2 = getSafeIcon(r6, r7);
        int r3 = Utils.getColorAccentDefaultColor(r6);
        CharSequence r9 = getSubtitleText(r6, r8, r7);
        SliceAction r4 = SliceAction.createDeeplink(r1, r2, 0, r7.getTitle());
        Set<String> r5 = buildSliceKeywords(r7);
        ListBuilder.InputRangeBuilder r10 = new ListBuilder.InputRangeBuilder().setTitle(r7.getTitle()).setPrimaryAction(r4).setInputAction(r0);
        if (r7.getIconResource() == 0) goto L6;
        r3 = -1;
    L6:
        if (ZenModeSliceBuilder.isSettingsIntelligence(r6) == true) goto L9;
        r10.setSubtitle(r9);
    L9:
        return new ListBuilder(r6, r7.getUri(), -1).setAccentColor(r3).addInputRange(r10).setKeywords(r5).build();
    }

    static BasePreferenceController getPreferenceController(Context r0, String r1, String r2) {
        return BasePreferenceController.createInstance(r0, r1);
    L5:
        return BasePreferenceController.createInstance(r0, r1, r2);
    }

    private static SliceAction getToggleAction(Context r1, SliceData r2, boolean r3) {
        return SliceAction.createToggle(getActionIntent(r1, SettingsSliceProvider.ACTION_TOGGLE_CHANGED, r2), null, r3);
    }

    private static PendingIntent getSliderAction(Context r1, SliceData r2) {
        return getActionIntent(r1, SettingsSliceProvider.ACTION_SLIDER_CHANGED, r2);
    }

    private static boolean isValidSummary(Context r3, CharSequence r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r4.toString().trim()) == true) goto L16;
        CharSequence r1 = r3.getText(R.string.summary_placeholder);
        CharSequence r5 = r3.getText(R.string.summary_two_lines_placeholder);
        if (TextUtils.equals(r4, r1) == false) goto L10;
        return false;
    L10:
        if (TextUtils.equals(r4, r5) == true) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    private static Set<String> buildSliceKeywords(SliceData r3) {
        ArraySet r0 = new ArraySet();
        r0.add(r3.getTitle());
        if (TextUtils.isEmpty(r3.getScreenTitle()) == false) goto L5;
    L7:
        String r4 = r3.getKeywords();
        if (r4 == null) goto L10;
        r0.addAll((List) Arrays.stream(r4.split(",")).map(new SliceBuilderUtils$$ExternalSyntheticLambda0()).collect(Collectors.toList()));
    L10:
        return r0;
    L5:
        if (TextUtils.equals(r3.getTitle(), r3.getScreenTitle()) == true) goto L7;
        r0.add(r3.getScreenTitle().toString());
        goto L7
    }

    static /* synthetic */ String lambda$buildSliceKeywords$0(String r0) {
        return r0.trim();
    }

    private static Slice buildUnavailableSlice(Context r8, SliceData r9) {
        String r0 = r9.getTitle();
        Set<String> r1 = buildSliceKeywords(r9);
        int r2 = Utils.getColorAccentDefaultColor(r8);
        CharSequence r3 = r9.getUnavailableSliceSubtitle();
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r3 = r8.getText(R.string.disabled_dependent_setting_summary);
    L6:
        IconCompat r4 = getSafeIcon(r8, r9);
        SliceAction r5 = SliceAction.createDeeplink(getContentPendingIntent(r8, r9), r4, 0, r0);
        ListBuilder.RowBuilder r6 = new ListBuilder.RowBuilder().setTitle(r0).setTitleItem(r4, 0).setPrimaryAction(r5);
        if (ZenModeSliceBuilder.isSettingsIntelligence(r8) == true) goto L10;
        r6.setSubtitle(r3);
    L10:
        return new ListBuilder(r8, r9.getUri(), -1).setAccentColor(r2).addRow(r6).setKeywords(r1).build();
    }

    static IconCompat getSafeIcon(Context r4, SliceData r5) {
        int r0 = r5.getIconResource();
        if (r0 != 0) goto L10;
        r0 = R.drawable.ic_settings_accent;
    L10:
        return IconCompat.createWithResource(r4, r0);
    L7:
        e = move-exception;
        OLog.w(TAG, "Falling back to settings icon because there is an error getting slice icon " + r5.getUri(), e);
        return IconCompat.createWithResource(r4, R.drawable.ic_settings_accent);
    }
}
