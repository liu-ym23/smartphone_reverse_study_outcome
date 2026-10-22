package com.android.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import com.android.settings.utils.HanziToPinyin;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSimUtil {
    public static final int HABIT_DUAL_SIM = 0;
    public static final int HABIT_SINGLE_SIM = 1;
    private static final String KEY_MULTI_SIM_USING_HABIT = "key_multi_sim_using_habit";
    public static final String KEY_PHONE_AUTO_CALLBACK = "key_phone_auto_callback";
    public static final String KEY_SMS_AUTO_POSTBACK = "key_sms_auto_postback";
    public static final int SIM_1_INDEX = 0;
    public static final int SIM_2_INDEX = 1;
    private static final int[] SIM_ICON_IDS = null;
    private static final String SIM_ICON_INDEX_KEY_PREFIX = "icon_index_sub";
    private static final int[] SIM_ICON_SELECTOR_IDS = null;
    private static final String SIM_NAME_KEY_PREFIX = "perferred_name_sub";

    static {
        SIM_ICON_SELECTOR_IDS = new int[]{R.drawable.multi_sim_sub_1_selector, R.drawable.multi_sim_sub_2_selector};
        SIM_ICON_IDS = new int[]{R.drawable.sim_1, R.drawable.sim_2};
    }

    private MultiSimUtil() {
    }

    private static int getIconIndexForSim(Context r2, int r3) {
        checkSimIndex(r3);
        return android.provider.Settings.Global.getInt(r2.getContentResolver(), SIM_ICON_INDEX_KEY_PREFIX + (r3 + 1), r3);
    }

    public static int getSimIconSelectorResource(Context r0, int r1) {
        int r2 = getIconIndexForSim(r0, r1);
        return SIM_ICON_SELECTOR_IDS[r2];
    }

    public static int getSimIconResource(Context r0, int r1) {
        int r2 = getIconIndexForSim(r0, r1);
        return SIM_ICON_IDS[r2];
    }

    public static boolean setSimName(Context r3, int r4, String r5) {
        checkSimIndex(r4);
        String r0 = MultiSimAdapter.getSimSerialNumber(r3, r4);
        int r6 = MultiSimAdapter.slot2Sub(r4);
        ContentResolver r7 = r3.getContentResolver();
        StringBuilder r1 = new StringBuilder(SIM_NAME_KEY_PREFIX);
        if (r0 == null) goto L5;
        String r8 = r0.toLowerCase();
    L7:
        return android.provider.Settings.System.putString(r7, r1.append(r8).toString(), r5);
    L5:
        r8 = Integer.toString(r6);
        goto L7
    }

    public static String getSimName(Context r5, int r6) {
        checkSimIndex(r6);
        String r0 = MultiSimAdapter.getSimSerialNumber(r5, r6);
        int r1 = MultiSimAdapter.slot2Sub(r6);
        ContentResolver r2 = r5.getContentResolver();
        StringBuilder r3 = new StringBuilder(SIM_NAME_KEY_PREFIX);
        if (r0 == null) goto L5;
        String r4 = r0;
    L6:
        String r7 = android.provider.Settings.System.getString(r2, r3.append(r4).toString());
        if (TextUtils.isEmpty(r7) == false) goto L11;
        if (r0 == null) goto L11;
        r7 = android.provider.Settings.System.getString(r5.getContentResolver(), SIM_NAME_KEY_PREFIX + r0.toLowerCase());
    L11:
        if (TextUtils.isEmpty(r7) == true) goto L13;
        return r7;
    L13:
        return r5.getString(R.string.default_sim_name) + HanziToPinyin.Token.SEPARATOR + (r6 + 1);
    L5:
        r4 = Integer.toString(r1);
        goto L6
    }

    public static String getSimNameInDb(Context r4, int r5) {
        checkSimIndex(r5);
        String r0 = MultiSimAdapter.getSimSerialNumber(r4, r5);
        int r6 = MultiSimAdapter.slot2Sub(r5);
        ContentResolver r1 = r4.getContentResolver();
        StringBuilder r2 = new StringBuilder(SIM_NAME_KEY_PREFIX);
        if (r0 == null) goto L5;
        String r7 = r0;
    L6:
        String r8 = android.provider.Settings.System.getString(r1, r2.append(r7).toString());
        if (TextUtils.isEmpty(r8) == false) goto L11;
        if (r0 != null) goto L10;
        return r8;
    L10:
        return android.provider.Settings.System.getString(r4.getContentResolver(), SIM_NAME_KEY_PREFIX + r0.toLowerCase());
    L11:
        return r8;
    L5:
        r7 = Integer.toString(r6);
        goto L6
    }

    public static boolean isPhoneAutoCallback(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), KEY_PHONE_AUTO_CALLBACK, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean setPhoneAutoCallback(Context r1, boolean r2) {
        return android.provider.Settings.Global.putInt(r1.getContentResolver(), KEY_PHONE_AUTO_CALLBACK, r2 ? 1 : 0);
    }

    public static boolean isSmsAutoPostback(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), KEY_SMS_AUTO_POSTBACK, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean setSmsAutoPostback(Context r1, boolean r2) {
        return android.provider.Settings.Global.putInt(r1.getContentResolver(), KEY_SMS_AUTO_POSTBACK, r2 ? 1 : 0);
    }

    public static int getMultiSimUsingHabit(Context r2) {
        return android.provider.Settings.Global.getInt(r2.getContentResolver(), KEY_MULTI_SIM_USING_HABIT, 0);
    }

    public static boolean setMultiSimUsingHabit(Context r2, int r3) {
        if (r3 == 0) goto L9;
        if (r3 == 1) goto L9;
        throw new IllegalArgumentException("invalid param:" + r3);
    L9:
        return android.provider.Settings.Global.putInt(r2.getContentResolver(), KEY_MULTI_SIM_USING_HABIT, r3);
    }

    private static boolean checkSimIndex(int r3) {
        if (r3 == 0) goto L8;
        if (r3 == 1) goto L8;
        throw new IllegalArgumentException("invalid sim index:" + r3);
    L8:
        return true;
    }
}
