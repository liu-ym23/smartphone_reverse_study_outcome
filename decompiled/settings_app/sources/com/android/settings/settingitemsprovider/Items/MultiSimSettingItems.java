package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.android.settings.MultiSimSettings;
import com.android.settings.MultiSimUtil;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import java.util.List;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSimSettingItems extends SettingItems {
    public MultiSimSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        boolean r13 = Utils.hasMultiSimInDevice();
        this.mItemList.add(new SettingItems.Items(this, R.string.multi_sim_settings_title, null, Constants.COMPONENT_MULTI_SIM_SETTINGS, null, r13, R.string.multi_sim_settings_title, R.string.dual_sim_settings_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.multi_sim_sub_1_title, null, Constants.COMPONENT_MULTI_SIM_SUBSCRIPTION, "extra_sim_index=0|back_text=" + this.mContext.getString(R.string.multi_sim_sub_1_title) + "|title=" + this.mContext.getString(R.string.multi_sim_sub_1_title), r13, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.multi_sim_sub_1_title}), R.string.sim_card_1_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.multi_sim_sub_2_title, null, Constants.COMPONENT_MULTI_SIM_SUBSCRIPTION, "extra_sim_index=1|back_text=" + this.mContext.getString(R.string.multi_sim_sub_2_title) + "|title=" + this.mContext.getString(R.string.multi_sim_sub_2_title), r13, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.multi_sim_sub_2_title}), R.string.sim_card_2_desc));
        int r9 = MultiSimUtil.getMultiSimUsingHabit(this.mContext);
        List<SettingItems.Items> r10 = this.mItemList;
        String r4 = Constants.COMPONENT_MULTI_SIM_SELECT_SUBSCRIPTION;
        String r5 = "extra_subscription_type=0|back_text=" + this.mContext.getString(R.string.multi_sim_dial_setting) + "|title=" + this.mContext.getString(R.string.multi_sim_dial_setting);
        if (r13 == false) goto L6;
        if (r9 != 1) goto L6;
        boolean r6 = true;
    L7:
        r10.add(new SettingItems.Items(this, R.string.multi_sim_dial_setting, null, r4, r5, r6, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.multi_sim_dial_setting}), R.string.call_dialing_desc));
        List<SettingItems.Items> r11 = this.mItemList;
        String r7 = Constants.COMPONENT_MULTI_SIM_SETTINGS;
        if (r13 == false) goto L11;
        if (r9 != 1) goto L11;
        boolean r8 = true;
    L12:
        r11.add(new SettingItems.Items(this, R.string.multi_sim_sms_setting, null, r7, null, r8, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.multi_sim_sms_setting}), R.string.sms_sending_desc));
        List<SettingItems.Items> r12 = this.mItemList;
        String r14 = Constants.COMPONENT_MULTI_SIM_SETTINGS;
        if (r13 == false) goto L16;
        if (r9 != 1) goto L16;
        boolean r15 = true;
    L17:
        r12.add(new SettingItems.Items(this, R.string.multi_sim_network_setting, null, r14, null, r15, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.multi_sim_network_setting}), R.string.net_setting_desc));
        List<SettingItems.Items> r16 = this.mItemList;
        if (r13 == false) goto L21;
        if (r9 != 1) goto L21;
        boolean r17 = true;
    L22:
        r16.add(new SettingItems.Items(this, R.string.net_intelligent_dual_sim_title, null, true, SettingsSwitchKeyUtil.SettingTable.Global, MultiSimSettings.RADIO_SMART_DATA_SWITCH_ENABLE, null, "0", r17, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.net_intelligent_dual_sim_title}), R.string.net_intelligent_dual_sim_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sim_pin_settings, null, Constants.COMPONENT_MULTI_SIM_PIN_SETTINGS_BOTH, null, r13, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.sim_pin_settings}), R.string.sim_card_pin_code_desc));
        return;
    L21:
        r17 = false;
    L16:
        r15 = false;
    L11:
        r8 = false;
    L6:
        r6 = false;
        goto L7
    }

    public static void updateItems(Handler r15, Context r16, SQLiteDatabase r17, boolean r18) {
        if (r18 == false) goto L5;
        String r10 = "1";
    L6:
        String r4 = r10;
        executeUpdate(r15, r16, r17, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r16.getString(R.string.multi_sim_settings_title));
        executeUpdate(r15, r16, r17, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r16.getString(R.string.multi_sim_sub_1_title));
        executeUpdate(r15, r16, r17, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r16.getString(R.string.multi_sim_sub_2_title));
        int r13 = MultiSimUtil.getMultiSimUsingHabit(r16);
        executeUpdate(r15, r16, r17, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r16.getString(R.string.sim_pin_settings));
        if (r18 == false) goto L10;
        if (r13 != 1) goto L10;
        String r5 = "1";
    L11:
        executeUpdate(r15, r16, r17, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r5, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.multi_sim_dial_setting}));
        if (r18 == false) goto L15;
        if (r13 != 1) goto L15;
        String r6 = "1";
    L16:
        executeUpdate(r15, r16, r17, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r6, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.multi_sim_sms_setting}));
        if (r18 == false) goto L20;
        if (r13 != 1) goto L20;
        String r7 = "1";
    L21:
        executeUpdate(r15, r16, r17, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.multi_sim_network_setting}));
        if (r18 == false) goto L25;
        if (r13 != 1) goto L25;
        String r8 = "1";
    L26:
        executeUpdate(r15, r16, r17, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r8, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new int[]{R.string.multi_sim_settings_title, R.string.net_intelligent_dual_sim_title}));
        return;
    L25:
        r8 = "0";
    L20:
        r7 = "0";
    L15:
        r6 = "0";
    L10:
        r5 = "0";
        goto L11
    L5:
        r10 = "0";
        goto L6
    }
}
