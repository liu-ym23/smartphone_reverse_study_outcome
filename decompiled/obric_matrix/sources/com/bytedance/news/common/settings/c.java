package com.bytedance.news.common.settings;

import androidx.annotation.Nullable;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.obric.matrix.base.settings.appconfig.aivoice.IAIVoiceSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.appstore.IAppStoreSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.autoaction.IAutoActionSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.browser.IBrowserSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.calculator.ICalculatorSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.clock.IClockSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.compass.ICompassSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.contacts.IContactsSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.downloadserver.IDownloadServerSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.feedback.IFeedbackSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.feedbackserviceproject.IFeedbackShellSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.filemanager.IFileManagerSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.gallery.IGallerySmartisanProjectSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.gallery3d.IGallerySettings$$Impl;
import com.obric.matrix.base.settings.appconfig.incallui.IInCallUISettings$$Impl;
import com.obric.matrix.base.settings.appconfig.launcher.ILauncherSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.matrixdemo.IMatrixDemoSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.mediametadataservice.IMediaMetaDataServiceSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.mms.IMMSSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.music.IMusicSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.notes.INotesSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.numberassistant.INumberAssistantSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.obricaccount.IAccountSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.obriccloudservice.ICloudServiceSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.obriccmupdater.IUpdaterSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.obricmediametadataservice.IObricMediaMetaDataServiceProjectSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.obricvault.IVaultSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.permissionmanager.IPermissionControllerSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.provision.IProvisionSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.qsb.IQuickSearchSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.rcsservice.IRcsServiceSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.screenrecorder.IScreenRecorderSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.securitymanager.IPhoneManagerSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.securityserver.ISecurityServerSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.settingsapp.ISettingsAppSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.settingssmartisan.ISettingsSmartisanProjectSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.smartnotification.ISmartNotificationSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.smsparser.ISmsParserSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.soundrecorder.IRecorderSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.systemui.ISystemUISettings$$Impl;
import com.obric.matrix.base.settings.appconfig.videoplayer.IVideoPlayerSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.weather.IWeatherSettings$$Impl;
import com.obric.matrix.base.settings.appconfig.xiphiasbrowser.IXiphiasBrowserSettings$$Impl;
import com.obric.matrix.base.settings.iconfig.IGenericNetworkConfig$$Impl;
import com.obric.matrix.base.settings.iconfig.IMatrixAuthConfig$$Impl;
import com.obric.matrix.base.settings.iconfig.IMatrixConfig$$Impl;
import com.obric.matrix.base.settings.iconfig.IMatrixPlatformSdkConfig$$Impl;
import com.obric.matrix.base.settings.iconfig.IMatrixSdkConfig$$Impl;
import com.obric.matrix.base.settings.iconfig.IMatrixTtnetConfig$$Impl;
import com.obric.matrix.base.settings.iconfig.IOnePartyCommonNetworkConfig$$Impl;
import com.obric.matrix.base.settings.iconfig.IOpenAuthConfig$$Impl;
import com.obric.matrix.base.settings.iconfig.IPushConfig$$Impl;
import com.obric.matrix.base.settings.iconfig.ISecretConfig$$Impl;
import com.obric.matrix.base.settings.iconfig.ITeaSettings$$Impl;
import com.obric.matrix.launch.godzilla.IgodzillaLaunchSafeConfig$$Impl;
import com.obric.matrix.launch.godzilla.IgodzillaSuperUncaughtConfig$$Impl;

/* JADX INFO: loaded from: classes.dex */
public class c {
    @Nullable
    public static ISettings a(String r1, final com.bytedance.news.common.settings.g.f r2) {
        if ("com.obric.matrix.base.settings.appconfig.aivoice.IAIVoiceSettings".equals(r1) == false) goto L7;
        return new IAIVoiceSettings$$Impl(r2);
    L7:
        if ("com.obric.matrix.base.settings.appconfig.appstore.IAppStoreSettings".equals(r1) == false) goto L11;
        return new IAppStoreSettings$$Impl(r2);
    L11:
        if ("com.obric.matrix.base.settings.appconfig.autoaction.IAutoActionSettings".equals(r1) == false) goto L15;
        return new IAutoActionSettings$$Impl(r2);
    L15:
        if ("com.obric.matrix.base.settings.appconfig.browser.IBrowserSettings".equals(r1) == false) goto L19;
        return new IBrowserSettings$$Impl(r2);
    L19:
        if ("com.obric.matrix.base.settings.appconfig.calculator.ICalculatorSettings".equals(r1) == false) goto L23;
        return new ICalculatorSettings$$Impl(r2);
    L23:
        if ("com.obric.matrix.base.settings.appconfig.clock.IClockSettings".equals(r1) == false) goto L27;
        return new IClockSettings$$Impl(r2);
    L27:
        if ("com.obric.matrix.base.settings.appconfig.compass.ICompassSettings".equals(r1) == false) goto L31;
        return new ICompassSettings$$Impl(r2);
    L31:
        if ("com.obric.matrix.base.settings.appconfig.contacts.IContactsSettings".equals(r1) == false) goto L35;
        return new IContactsSettings$$Impl(r2);
    L35:
        if ("com.obric.matrix.base.settings.appconfig.downloadserver.IDownloadServerSettings".equals(r1) == false) goto L39;
        return new IDownloadServerSettings$$Impl(r2);
    L39:
        if ("com.obric.matrix.base.settings.appconfig.feedback.IFeedbackSettings".equals(r1) == false) goto L43;
        return new IFeedbackSettings$$Impl(r2);
    L43:
        if ("com.obric.matrix.base.settings.appconfig.feedbackserviceproject.IFeedbackShellSettings".equals(r1) == false) goto L47;
        return new IFeedbackShellSettings$$Impl(r2);
    L47:
        if ("com.obric.matrix.base.settings.appconfig.filemanager.IFileManagerSettings".equals(r1) == false) goto L51;
        return new IFileManagerSettings$$Impl(r2);
    L51:
        if ("com.obric.matrix.base.settings.appconfig.gallery.IGallerySmartisanProjectSettings".equals(r1) == false) goto L55;
        return new IGallerySmartisanProjectSettings$$Impl(r2);
    L55:
        if ("com.obric.matrix.base.settings.appconfig.gallery3d.IGallerySettings".equals(r1) == false) goto L59;
        return new IGallerySettings$$Impl(r2);
    L59:
        if ("com.obric.matrix.base.settings.appconfig.incallui.IInCallUISettings".equals(r1) == false) goto L63;
        return new IInCallUISettings$$Impl(r2);
    L63:
        if ("com.obric.matrix.base.settings.appconfig.launcher.ILauncherSettings".equals(r1) == false) goto L67;
        return new ILauncherSettings$$Impl(r2);
    L67:
        if ("com.obric.matrix.base.settings.appconfig.matrixdemo.IMatrixDemoSettings".equals(r1) == false) goto L71;
        return new IMatrixDemoSettings$$Impl(r2);
    L71:
        if ("com.obric.matrix.base.settings.appconfig.mediametadataservice.IMediaMetaDataServiceSettings".equals(r1) == false) goto L75;
        return new IMediaMetaDataServiceSettings$$Impl(r2);
    L75:
        if ("com.obric.matrix.base.settings.appconfig.mms.IMMSSettings".equals(r1) == false) goto L79;
        return new IMMSSettings$$Impl(r2);
    L79:
        if ("com.obric.matrix.base.settings.appconfig.music.IMusicSettings".equals(r1) == false) goto L83;
        return new IMusicSettings$$Impl(r2);
    L83:
        if ("com.obric.matrix.base.settings.appconfig.notes.INotesSettings".equals(r1) == false) goto L87;
        return new INotesSettings$$Impl(r2);
    L87:
        if ("com.obric.matrix.base.settings.appconfig.numberassistant.INumberAssistantSettings".equals(r1) == false) goto L91;
        return new INumberAssistantSettings$$Impl(r2);
    L91:
        if ("com.obric.matrix.base.settings.appconfig.obricaccount.IAccountSettings".equals(r1) == false) goto L95;
        return new IAccountSettings$$Impl(r2);
    L95:
        if ("com.obric.matrix.base.settings.appconfig.obriccloudservice.ICloudServiceSettings".equals(r1) == false) goto L99;
        return new ICloudServiceSettings$$Impl(r2);
    L99:
        if ("com.obric.matrix.base.settings.appconfig.obriccmupdater.IUpdaterSettings".equals(r1) == false) goto L103;
        return new IUpdaterSettings$$Impl(r2);
    L103:
        if ("com.obric.matrix.base.settings.appconfig.obricmediametadataservice.IObricMediaMetaDataServiceProjectSettings".equals(r1) == false) goto L107;
        return new IObricMediaMetaDataServiceProjectSettings$$Impl(r2);
    L107:
        if ("com.obric.matrix.base.settings.appconfig.obricvault.IVaultSettings".equals(r1) == false) goto L111;
        return new IVaultSettings$$Impl(r2);
    L111:
        if ("com.obric.matrix.base.settings.appconfig.permissionmanager.IPermissionControllerSettings".equals(r1) == false) goto L115;
        return new IPermissionControllerSettings$$Impl(r2);
    L115:
        if ("com.obric.matrix.base.settings.appconfig.provision.IProvisionSettings".equals(r1) == false) goto L119;
        return new IProvisionSettings$$Impl(r2);
    L119:
        if ("com.obric.matrix.base.settings.appconfig.qsb.IQuickSearchSettings".equals(r1) == false) goto L123;
        return new IQuickSearchSettings$$Impl(r2);
    L123:
        if ("com.obric.matrix.base.settings.appconfig.rcsservice.IRcsServiceSettings".equals(r1) == false) goto L127;
        return new IRcsServiceSettings$$Impl(r2);
    L127:
        if ("com.obric.matrix.base.settings.appconfig.screenrecorder.IScreenRecorderSettings".equals(r1) == false) goto L131;
        return new IScreenRecorderSettings$$Impl(r2);
    L131:
        if ("com.obric.matrix.base.settings.appconfig.securitymanager.IPhoneManagerSettings".equals(r1) == false) goto L135;
        return new IPhoneManagerSettings$$Impl(r2);
    L135:
        if ("com.obric.matrix.base.settings.appconfig.securityserver.ISecurityServerSettings".equals(r1) == false) goto L139;
        return new ISecurityServerSettings$$Impl(r2);
    L139:
        if ("com.obric.matrix.base.settings.appconfig.settingsapp.ISettingsAppSettings".equals(r1) == false) goto L143;
        return new ISettingsAppSettings$$Impl(r2);
    L143:
        if ("com.obric.matrix.base.settings.appconfig.settingssmartisan.ISettingsSmartisanProjectSettings".equals(r1) == false) goto L147;
        return new ISettingsSmartisanProjectSettings$$Impl(r2);
    L147:
        if ("com.obric.matrix.base.settings.appconfig.smartnotification.ISmartNotificationSettings".equals(r1) == false) goto L151;
        return new ISmartNotificationSettings$$Impl(r2);
    L151:
        if ("com.obric.matrix.base.settings.appconfig.smsparser.ISmsParserSettings".equals(r1) == false) goto L155;
        return new ISmsParserSettings$$Impl(r2);
    L155:
        if ("com.obric.matrix.base.settings.appconfig.soundrecorder.IRecorderSettings".equals(r1) == false) goto L159;
        return new IRecorderSettings$$Impl(r2);
    L159:
        if ("com.obric.matrix.base.settings.appconfig.systemui.ISystemUISettings".equals(r1) == false) goto L163;
        return new ISystemUISettings$$Impl(r2);
    L163:
        if ("com.obric.matrix.base.settings.appconfig.updater.IUpdaterSettings".equals(r1) == false) goto L167;
        return new com.obric.matrix.base.settings.appconfig.updater.IUpdaterSettings$$Impl(r2);
    L167:
        if ("com.obric.matrix.base.settings.appconfig.videoplayer.IVideoPlayerSettings".equals(r1) == false) goto L171;
        return new IVideoPlayerSettings$$Impl(r2);
    L171:
        if ("com.obric.matrix.base.settings.appconfig.weather.IWeatherSettings".equals(r1) == false) goto L175;
        return new IWeatherSettings$$Impl(r2);
    L175:
        if ("com.obric.matrix.base.settings.appconfig.xiphiasbrowser.IXiphiasBrowserSettings".equals(r1) == false) goto L179;
        return new IXiphiasBrowserSettings$$Impl(r2);
    L179:
        if ("com.obric.matrix.base.settings.iconfig.IGenericNetworkConfig".equals(r1) == false) goto L183;
        return new IGenericNetworkConfig$$Impl(r2);
    L183:
        if ("com.obric.matrix.base.settings.iconfig.IMatrixAuthConfig".equals(r1) == false) goto L187;
        return new IMatrixAuthConfig$$Impl(r2);
    L187:
        if ("com.obric.matrix.base.settings.iconfig.IMatrixConfig".equals(r1) == false) goto L191;
        return new IMatrixConfig$$Impl(r2);
    L191:
        if ("com.obric.matrix.base.settings.iconfig.IMatrixPlatformSdkConfig".equals(r1) == false) goto L195;
        return new IMatrixPlatformSdkConfig$$Impl(r2);
    L195:
        if ("com.obric.matrix.base.settings.iconfig.IMatrixSdkConfig".equals(r1) == false) goto L199;
        return new IMatrixSdkConfig$$Impl(r2);
    L199:
        if ("com.obric.matrix.base.settings.iconfig.IMatrixTtnetConfig".equals(r1) == false) goto L203;
        return new IMatrixTtnetConfig$$Impl(r2);
    L203:
        if ("com.obric.matrix.base.settings.iconfig.IOnePartyCommonNetworkConfig".equals(r1) == false) goto L207;
        return new IOnePartyCommonNetworkConfig$$Impl(r2);
    L207:
        if ("com.obric.matrix.base.settings.iconfig.IOpenAuthConfig".equals(r1) == false) goto L211;
        return new IOpenAuthConfig$$Impl(r2);
    L211:
        if ("com.obric.matrix.base.settings.iconfig.IPushConfig".equals(r1) == false) goto L215;
        return new IPushConfig$$Impl(r2);
    L215:
        if ("com.obric.matrix.base.settings.iconfig.ISecretConfig".equals(r1) == false) goto L219;
        return new ISecretConfig$$Impl(r2);
    L219:
        if ("com.obric.matrix.base.settings.iconfig.ITeaSettings".equals(r1) == false) goto L223;
        return new ITeaSettings$$Impl(r2);
    L223:
        if ("com.obric.matrix.launch.godzilla.IgodzillaLaunchSafeConfig".equals(r1) == false) goto L227;
        return new IgodzillaLaunchSafeConfig$$Impl(r2);
    L227:
        if ("com.obric.matrix.launch.godzilla.IgodzillaSuperUncaughtConfig".equals(r1) == true) goto L229;
        return null;
    L229:
        return new IgodzillaSuperUncaughtConfig$$Impl(r2);
    }
}
