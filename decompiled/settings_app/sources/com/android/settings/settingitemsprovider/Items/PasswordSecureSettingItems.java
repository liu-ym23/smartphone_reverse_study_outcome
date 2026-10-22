package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.android.settings.IGoogleAds;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.biometrics.FaceRecognitionHelper;
import com.android.settings.fingerprint.utils.FingerprintUtils;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.bytedance.news.common.service.manager.ServiceManager;
import java.util.List;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class PasswordSecureSettingItems extends SettingItems {
    public PasswordSecureSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.lock_screen_header_title, null, Constants.COMPONENT_LOCKSCREEN, null, true, R.string.lock_screen_header_title, R.string.password_and_security_desc));
        boolean r9 = Utils.isFingerprintExists(this.mContext);
        this.mItemList.add(new SettingItems.Items(this, R.string.enroll_fingerprint_data, null, Constants.COMPONENT_LOCKSCREEN, null, !r9, buildPath(new int[]{R.string.lock_screen_header_title, R.string.enroll_fingerprint_data}), R.string.enroll_fingerprint_info_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.manage_fingerprint, null, Constants.COMPONENT_FINGERPRINT_MANAGEMENT, null, r9, buildPath(new int[]{R.string.lock_screen_header_title, R.string.manage_fingerprint}), R.string.fingerprint_info_management_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.enroll_new_fingerprint, null, Constants.COMPONENT_FINGERPRINT_MANAGEMENT, null, r9, buildPath(new int[]{R.string.lock_screen_header_title, R.string.manage_fingerprint, R.string.enroll_new_fingerprint}), null));
        boolean r10 = FingerprintUtils.hasUdfps(this.mContext);
        this.mItemList.add(new SettingItems.Items(this, R.string.udfps_unlock_screen_enable_text, null, Constants.COMPONENT_FINGERPRINT_MANAGEMENT, null, r10, buildPath(new int[]{R.string.lock_screen_header_title, R.string.manage_fingerprint, R.string.udfps_unlock_screen_enable_text}), R.string.udfps_unlock_screen_enable_desc));
        boolean r0 = FingerprintUtils.isUdfpsUnlockScreenEnabled(this.mContext);
        List<SettingItems.Items> r11 = this.mItemList;
        String r4 = Constants.COMPONENT_FINGERPRINT_MANAGEMENT;
        if (r10 == false) goto L6;
        if (r0 == false) goto L6;
        boolean r6 = true;
    L7:
        r11.add(new SettingItems.Items(this, R.string.udfps_unlock_screen_type_text, null, r4, null, r6, buildPath(new int[]{R.string.lock_screen_header_title, R.string.manage_fingerprint, R.string.udfps_unlock_screen_type_text}), R.string.udfps_unlock_screen_type_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.enroll_ai_powered_fingerprint, null, Constants.COMPONENT_FINGERPRINT_MANAGEMENT, null, r9, buildPath(new int[]{R.string.lock_screen_header_title, R.string.manage_fingerprint, R.string.enroll_ai_powered_fingerprint}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.obric_udfps_display_policy_title, null, Constants.COMPONENT_FINGERPRINT_MANAGEMENT, null, r9, buildPath(new int[]{R.string.lock_screen_header_title, R.string.manage_fingerprint, R.string.obric_udfps_display_policy_title}), null));
        boolean r12 = new FaceRecognitionHelper(this.mContext).isFaceRecognitionDataExist();
        boolean r13 = Utils.isSeDevice();
        List<SettingItems.Items> r14 = this.mItemList;
        String r5 = Constants.COMPONENT_LOCKSCREEN;
        if (r12 == true) goto L11;
        if (r13 == false) goto L11;
        boolean r7 = true;
    L12:
        r14.add(new SettingItems.Items(this, R.string.enroll_face_data, null, r5, null, r7, buildPath(new int[]{R.string.lock_screen_header_title, R.string.enroll_face_data}), R.string.enroll_face_info_desc));
        List<SettingItems.Items> r15 = this.mItemList;
        String r8 = Constants.COMPONENT_LOCKSCREEN;
        if (r12 == false) goto L16;
        if (r13 == false) goto L16;
        boolean r16 = true;
    L17:
        r15.add(new SettingItems.Items(this, R.string.manage_face_data, null, r8, null, r16, buildPath(new int[]{R.string.lock_screen_header_title, R.string.manage_face_data}), R.string.face_info_management_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.lock_screen_password, null, Constants.COMPONENT_LOCKSCREE_MODE, null, true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.lock_screen_password}), R.string.lock_screen_password_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.hide_lockpattern_track, null, true, null, null, SettingsSwitchKeyUtil.HIDE_LOCK_PATTERN_TRACK, "0", true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.lock_screen_password, R.string.hide_lockpattern_track}), R.string.hide_pattern_password_trajectory_desc));
        IGoogleAds r1 = (IGoogleAds) ServiceManager.getService(IGoogleAds.class);
        if (r1 == null) goto L20;
        this.mItemList.add(new SettingItems.Items(this, R.string.ad_service_header_title, null, r1.launcher(), null, true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.ad_service_header_title}), null));
    L21:
        this.mItemList.add(new SettingItems.Items(this, R.string.security_advanced_options, null, Constants.TRUSTED_CECURITY_ACVANCED, null, true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.security_advanced_options}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.security_item_device_manager, null, Constants.DEVICE_MANAGER, null, true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.security_advanced_options, R.string.security_item_device_manager}), R.string.device_manager_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.trusted_credentials, null, Constants.TRUSTED_CREDENTIALS, null, true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.security_advanced_options, R.string.trusted_credentials}), R.string.trusted_credentials_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.certificate_install_from_storage, R.string.alias_certificate, Constants.COMPONENT_CERTIFICATE_INSTALL, null, true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.security_advanced_options, R.string.certificate_install_from_storage}), R.string.install_from_storage_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.credentials_reset, R.string.alias_certificate, Constants.TRUSTED_CECURITY_ACVANCED, null, true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.security_advanced_options, R.string.credentials_reset}), R.string.clear_credentials_desc));
        return;
    L20:
        this.mItemList.add(new SettingItems.Items(this, R.string.ad_service_header_title, null, Constants.AD_SERVICES, null, true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.ad_service_header_title}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.oaid_title, null, Constants.OAID_MANAGER, null, true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.ad_service_header_title, R.string.oaid_title}), R.string.advertising_identifier_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.oaid_disable_retrieve, null, true, SettingsSwitchKeyUtil.SettingTable.Global, "oaid_status_open", null, "1", true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.ad_service_header_title, R.string.oaid_title, R.string.oaid_disable_retrieve}), R.string.block_apps_from_using_advertising_identifier_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.reset_oaid, null, Constants.OAID_RESET_MANAGER, null, true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.ad_service_header_title, R.string.oaid_title, R.string.reset_oaid}), R.string.reset_advertising_identifier_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.push_business_receive, null, true, SettingsSwitchKeyUtil.SettingTable.System, "receive_business_message", null, "0", true, buildPath(new int[]{R.string.lock_screen_header_title, R.string.ad_service_header_title, R.string.push_business_receive}), null));
    L16:
        r16 = false;
    L11:
        r7 = false;
    L6:
        r6 = false;
        goto L7
    }

    public static void updateFingerprintItems(Handler r12, Context r13, SQLiteDatabase r14, boolean r15) {
        if (r15 == true) goto L5;
        String r4 = "1";
    L6:
        executeUpdate(r12, r13, r14, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r13.getString(R.string.enroll_fingerprint_data));
        if (r15 == false) goto L9;
        String r5 = "1";
    L10:
        executeUpdate(r12, r13, r14, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r5, "name", r13.getString(R.string.manage_fingerprint));
        if (r15 == false) goto L13;
        String r6 = "1";
    L14:
        executeUpdate(r12, r13, r14, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r6, "name", r13.getString(R.string.enroll_new_fingerprint));
        if (r15 == false) goto L17;
        String r7 = "1";
    L18:
        executeUpdate(r12, r13, r14, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r13.getString(R.string.enroll_ai_powered_fingerprint));
        if (r15 == false) goto L21;
        String r8 = "1";
    L22:
        executeUpdate(r12, r13, r14, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r8, "name", r13.getString(R.string.obric_udfps_display_policy_title));
        boolean r11 = FingerprintUtils.hasUdfps(r13);
        if (r15 == false) goto L26;
        if (r11 == false) goto L26;
        String r9 = "1";
    L27:
        executeUpdate(r12, r13, r14, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r13.getString(R.string.udfps_unlock_screen_enable_text));
        if (r15 == false) goto L33;
        if (r11 == false) goto L33;
        if (FingerprintUtils.isUdfpsUnlockScreenEnabled(r13) == false) goto L33;
        String r10 = "1";
    L34:
        executeUpdate(r12, r13, r14, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r10, "name", r13.getString(R.string.udfps_unlock_screen_type_text));
        return;
    L33:
        r10 = "0";
    L26:
        r9 = "0";
        goto L27
    L21:
        r8 = "0";
        goto L22
    L17:
        r7 = "0";
        goto L18
    L13:
        r6 = "0";
        goto L14
    L9:
        r5 = "0";
        goto L10
    L5:
        r4 = "0";
        goto L6
    }

    public static void updateFaceItems(Handler r13, Context r14, SQLiteDatabase r15) {
        boolean r9 = new FaceRecognitionHelper(r14).isFaceRecognitionDataExist();
        boolean r10 = Utils.isSeDevice();
        if (r9 == true) goto L6;
        if (r10 == false) goto L6;
        String r4 = "1";
    L7:
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r14.getString(R.string.enroll_face_data));
        if (r9 == false) goto L11;
        if (r10 == false) goto L11;
        String r5 = "1";
    L12:
        executeUpdate(r13, r14, r15, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r5, "name", r14.getString(R.string.manage_face_data));
        return;
    L11:
        r5 = "0";
    L6:
        r4 = "0";
        goto L7
    }
}
