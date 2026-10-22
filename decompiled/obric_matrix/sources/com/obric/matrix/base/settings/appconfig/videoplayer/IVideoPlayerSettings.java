package com.obric.matrix.base.settings.appconfig.videoplayer;

import com.bytedance.news.common.settings.api.annotation.a;
import com.obric.matrix.base.settings.appconfig.IAppSettings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@a(storageKey = "VideoPlayerSettings_storage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/obric/matrix/base/settings/appconfig/videoplayer/IVideoPlayerSettings;", "Lcom/obric/matrix/base/settings/appconfig/IAppSettings;", "getAppConfig", "", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IVideoPlayerSettings extends IAppSettings {
    @Override // com.obric.matrix.base.settings.appconfig.IAppSettings
    String getAppConfig();
}
