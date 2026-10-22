package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.applications.PreferredActivityChooserEmailFragment;
import com.android.settings.settingitemsprovider.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class AppManagerSettingItems extends SettingItems {
    public AppManagerSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.preferred_category_home, null, Constants.COMPONENT_PREFERRED_DEFAULT_APP, "android.intent.extra.ROLE_NAME=android.app.role.HOME", true, buildPath(new int[]{R.string.manager_application, R.string.preferred_application, R.string.preferred_category_home}), R.string.desktop_default_app_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.preferred_category_mailto, null, Constants.COMPONENT_FRAGMENT_SKIPPER, ("FragmentName=" + PreferredActivityChooserEmailFragment.class.getName()) + "|title=" + this.mContext.getString(R.string.preferred_category_mailto) + "|position=1", true, buildPath(new int[]{R.string.manager_application, R.string.preferred_application, R.string.preferred_category_mailto}), R.string.send_email_default_app_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.preferred_category_browser, null, Constants.COMPONENT_PREFERRED_DEFAULT_APP, "android.intent.extra.ROLE_NAME=android.app.role.BROWSER", true, buildPath(new int[]{R.string.manager_application, R.string.preferred_application, R.string.preferred_category_browser}), R.string.browser_default_app_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.default_phone_title, null, Constants.COMPONENT_PREFERRED_DEFAULT_APP, "android.intent.extra.ROLE_NAME=android.app.role.DIALER", true, buildPath(new int[]{R.string.manager_application, R.string.preferred_application, R.string.default_phone_title}), R.string.phone_app_default_app_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sms_application_title, null, Constants.COMPONENT_PREFERRED_DEFAULT_APP, "android.intent.extra.ROLE_NAME=android.app.role.SMS", true, buildPath(new int[]{R.string.manager_application, R.string.preferred_application, R.string.sms_application_title}), R.string.sms_app_default_app_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.preferred_category_image, null, Constants.COMPONENT_PREFERRED_ACTIVITY_CHOOSER_ALL, "category=image|title=" + this.mContext.getString(R.string.preferred_category_image), true, buildPath(new int[]{R.string.manager_application, R.string.preferred_application, R.string.preferred_category_image}), R.string.image_viewer_default_app_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.preferred_category_audio, null, Constants.COMPONENT_PREFERRED_ACTIVITY_CHOOSER_ALL, "category=audio|title=" + this.mContext.getString(R.string.preferred_category_audio), true, buildPath(new int[]{R.string.manager_application, R.string.preferred_application, R.string.preferred_category_audio}), R.string.audio_player_default_app_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.preferred_category_video, null, Constants.COMPONENT_PREFERRED_ACTIVITY_CHOOSER_ALL, "category=video|title=" + this.mContext.getString(R.string.preferred_category_video), true, buildPath(new int[]{R.string.manager_application, R.string.preferred_application, R.string.preferred_category_video}), R.string.video_player_default_app_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.preferred_category_text, null, Constants.COMPONENT_PREFERRED_ACTIVITY_CHOOSER_ALL, "category=text|title=" + this.mContext.getString(R.string.preferred_category_text), true, buildPath(new int[]{R.string.manager_application, R.string.preferred_application, R.string.preferred_category_text}), R.string.document_viewer_default_app_desc));
    }
}
