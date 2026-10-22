package com.obric.matrix.base.settings;

import com.obric.matrix.base.settings.appconfig.IAppSettings;
import com.obric.matrix.base.settings.appconfig.aivoice.IAIVoiceSettings;
import com.obric.matrix.base.settings.appconfig.appstore.IAppStoreSettings;
import com.obric.matrix.base.settings.appconfig.autoaction.IAutoActionSettings;
import com.obric.matrix.base.settings.appconfig.browser.IBrowserSettings;
import com.obric.matrix.base.settings.appconfig.calculator.ICalculatorSettings;
import com.obric.matrix.base.settings.appconfig.clock.IClockSettings;
import com.obric.matrix.base.settings.appconfig.compass.ICompassSettings;
import com.obric.matrix.base.settings.appconfig.contacts.IContactsSettings;
import com.obric.matrix.base.settings.appconfig.downloadserver.IDownloadServerSettings;
import com.obric.matrix.base.settings.appconfig.feedback.IFeedbackSettings;
import com.obric.matrix.base.settings.appconfig.feedbackserviceproject.IFeedbackShellSettings;
import com.obric.matrix.base.settings.appconfig.filemanager.IFileManagerSettings;
import com.obric.matrix.base.settings.appconfig.gallery3d.IGallerySettings;
import com.obric.matrix.base.settings.appconfig.incallui.IInCallUISettings;
import com.obric.matrix.base.settings.appconfig.launcher.ILauncherSettings;
import com.obric.matrix.base.settings.appconfig.matrixdemo.IMatrixDemoSettings;
import com.obric.matrix.base.settings.appconfig.mediametadataservice.IMediaMetaDataServiceSettings;
import com.obric.matrix.base.settings.appconfig.mms.IMMSSettings;
import com.obric.matrix.base.settings.appconfig.music.IMusicSettings;
import com.obric.matrix.base.settings.appconfig.notes.INotesSettings;
import com.obric.matrix.base.settings.appconfig.numberassistant.INumberAssistantSettings;
import com.obric.matrix.base.settings.appconfig.obricaccount.IAccountSettings;
import com.obric.matrix.base.settings.appconfig.obriccloudservice.ICloudServiceSettings;
import com.obric.matrix.base.settings.appconfig.obriccmupdater.IUpdaterSettings;
import com.obric.matrix.base.settings.appconfig.obricvault.IVaultSettings;
import com.obric.matrix.base.settings.appconfig.permissionmanager.IPermissionControllerSettings;
import com.obric.matrix.base.settings.appconfig.provision.IProvisionSettings;
import com.obric.matrix.base.settings.appconfig.qsb.IQuickSearchSettings;
import com.obric.matrix.base.settings.appconfig.rcsservice.IRcsServiceSettings;
import com.obric.matrix.base.settings.appconfig.screenrecorder.IScreenRecorderSettings;
import com.obric.matrix.base.settings.appconfig.securitymanager.IPhoneManagerSettings;
import com.obric.matrix.base.settings.appconfig.securityserver.ISecurityServerSettings;
import com.obric.matrix.base.settings.appconfig.settingsapp.ISettingsAppSettings;
import com.obric.matrix.base.settings.appconfig.smartnotification.ISmartNotificationSettings;
import com.obric.matrix.base.settings.appconfig.smsparser.ISmsParserSettings;
import com.obric.matrix.base.settings.appconfig.soundrecorder.IRecorderSettings;
import com.obric.matrix.base.settings.appconfig.systemui.ISystemUISettings;
import com.obric.matrix.base.settings.appconfig.videoplayer.IVideoPlayerSettings;
import com.obric.matrix.base.settings.appconfig.weather.IWeatherSettings;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/matrix/base/settings/AppConfigMapper;", "", "()V", "packageConfigMap", "", "", "Ljava/lang/Class;", "Lcom/obric/matrix/base/settings/appconfig/IAppSettings;", "getConfigClass", "packageName", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Class<? extends IAppSettings>> f8883b = null;

    static {
        f8882a = new d();
        f8883b = m0.k(new u[]{a0.a("com.obric.matrix_demo", IMatrixDemoSettings.class), a0.a("com.android.settings", ISettingsAppSettings.class), a0.a("com.obric.smartnotification", ISmartNotificationSettings.class), a0.a("com.obric.autoaction", IAutoActionSettings.class), a0.a("com.obric.mediametadataservice", IMediaMetaDataServiceSettings.class), a0.a("com.android.gallery3d", IGallerySettings.class), a0.a("com.obric.browser", IBrowserSettings.class), a0.a("com.bytedance.securityserver", ISecurityServerSettings.class), a0.a("com.obric.aivoice", IAIVoiceSettings.class), a0.a("com.obric.appstore", IAppStoreSettings.class), a0.a("com.obric.calculator", ICalculatorSettings.class), a0.a("com.obric.clock", IClockSettings.class), a0.a("com.obric.compass", ICompassSettings.class), a0.a("com.android.contacts", IContactsSettings.class), a0.a("com.obric.feedback", IFeedbackSettings.class), a0.a("com.obric.filemanager", IFileManagerSettings.class), a0.a("com.android.mms", IMMSSettings.class), a0.a("com.obric.music", IMusicSettings.class), a0.a("com.obric.notes", INotesSettings.class), a0.a("com.obric.updater", IUpdaterSettings.class), a0.a("com.obric.vault", IVaultSettings.class), a0.a("com.android.permissioncontroller", IPermissionControllerSettings.class), a0.a("com.obric.quicksearch", IQuickSearchSettings.class), a0.a("com.obric.recorder", IRecorderSettings.class), a0.a("com.obric.videoplayer", IVideoPlayerSettings.class), a0.a("com.obric.weather", IWeatherSettings.class), a0.a("com.android.incallui", IInCallUISettings.class), a0.a("com.obric.cloudservice", ICloudServiceSettings.class), a0.a("com.android.provision", IProvisionSettings.class), a0.a("com.obric.screenrecorder", IScreenRecorderSettings.class), a0.a("com.obric.security", IPhoneManagerSettings.class), a0.a("com.obric.account", IAccountSettings.class), a0.a("com.android.systemui", ISystemUISettings.class), a0.a("com.android.launcher3", ILauncherSettings.class), a0.a("com.obric.downloadserver", IDownloadServerSettings.class), a0.a("com.obric.feedbackserviceproject", IFeedbackShellSettings.class), a0.a("com.obric.smsparser", ISmsParserSettings.class), a0.a("com.obric.numberassistant", INumberAssistantSettings.class), a0.a("com.obric.rcsservice", IRcsServiceSettings.class)});
    }

    private d() {
    }

    public final Class<? extends IAppSettings> a(String r1) {
        o.f(r1, "packageName");
        return f8883b.get(r1);
    }
}
