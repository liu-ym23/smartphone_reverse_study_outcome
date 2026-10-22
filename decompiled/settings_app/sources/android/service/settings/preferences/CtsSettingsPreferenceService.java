package android.service.settings.preferences;

import android.icu.text.DateFormat;
import android.os.OutcomeReceiver;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CtsSettingsPreferenceService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016J$\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\nH\u0016J$\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00112\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroid/service/settings/preferences/CtsSettingsPreferenceService;", "Landroid/service/settings/preferences/SettingsPreferenceService;", "()V", "metadata", "Landroid/service/settings/preferences/SettingsPreferenceMetadata;", "onGetAllPreferenceMetadata", "", Ext.KEY_REQUEST, "Landroid/service/settings/preferences/MetadataRequest;", "callback", "Landroid/os/OutcomeReceiver;", "Landroid/service/settings/preferences/MetadataResult;", "Ljava/lang/Exception;", "onGetPreferenceValue", "Landroid/service/settings/preferences/GetValueRequest;", "Landroid/service/settings/preferences/GetValueResult;", "onSetPreferenceValue", "Landroid/service/settings/preferences/SetValueRequest;", "Landroid/service/settings/preferences/SetValueResult;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CtsSettingsPreferenceService extends SettingsPreferenceService {
    private final SettingsPreferenceMetadata metadata;

    public CtsSettingsPreferenceService() {
        SettingsPreferenceMetadata r0 = new SettingsPreferenceMetadata.Builder(DateFormat.SECOND, "k").setTitle("Test Preference").setEnabled(true).build();
        Intrinsics.checkNotNullExpressionValue(r0, "build(...)");
        this.metadata = r0;
    }

    public void onGetAllPreferenceMetadata(MetadataRequest r2, OutcomeReceiver<MetadataResult, Exception> r3) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r3, "callback");
        r3.onResult(new MetadataResult.Builder(0).setMetadataList(CollectionsKt.listOf(this.metadata)).build());
    }

    public void onGetPreferenceValue(GetValueRequest r3, OutcomeReceiver<GetValueResult, Exception> r4) {
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (Intrinsics.areEqual(r3.getPreferenceKey(), "k") == true) goto L5;
    L7:
        r4.onResult(new GetValueResult.Builder(1).build());
        return;
    L5:
        if (Intrinsics.areEqual(r3.getScreenKey(), DateFormat.SECOND) == false) goto L7;
        r4.onResult(new GetValueResult.Builder(0).setValue(new SettingsPreferenceValue.Builder(3).setStringValue("value").build()).setMetadata(this.metadata).build());
    }

    public void onSetPreferenceValue(SetValueRequest r2, OutcomeReceiver<SetValueResult, Exception> r3) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (Intrinsics.areEqual(r2.getPreferenceKey(), "k") == true) goto L5;
    L7:
        r3.onResult(new SetValueResult.Builder(1).build());
        return;
    L5:
        if (Intrinsics.areEqual(r2.getScreenKey(), DateFormat.SECOND) == false) goto L7;
        r3.onResult(new SetValueResult.Builder(0).build());
    }
}
