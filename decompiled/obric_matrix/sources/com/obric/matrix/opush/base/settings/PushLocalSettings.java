package com.obric.matrix.opush.base.settings;

import com.bytedance.push.settings.ILocalSettings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0003H'J\b\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H'J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H'J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H'J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H'¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/opush/base/settings/PushLocalSettings;", "Lcom/bytedance/push/settings/ILocalSettings;", "getLastDeDuplicationTimestamp", "", "getLastReportEventTimestamp", "getLastRequestSettingsTimestamp", "getLastRequestUpdateDeviceTimestamp", "isNewUser", "", "setIsNewUser", "", "setLastDeDuplicationTimestamp", "timeStamp", "setLastReportEventTimestamp", "setLastRequestSettingsTimestamp", "setLastRequestUpdateDeviceTimestamp", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@com.bytedance.push.settings.g.a(storageKey = "bd_sys_push_local_settings", supportMultiProcess = false)
public interface PushLocalSettings extends ILocalSettings {
    void a(long r1);

    void b(long r1);

    long c();

    long d();
}
