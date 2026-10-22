package com.android.settingslib.drawer;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class SwitchController extends EntryController implements ProviderSwitch {

    @Deprecated
    protected static class MetaData extends EntryController.MetaData {
        @Deprecated
        public MetaData(String r1) {
            super(r1);
        }
    }

    protected abstract String getErrorMessage(boolean r1);

    public abstract String getSwitchKey();

    protected abstract boolean isChecked();

    protected abstract boolean onCheckedChanged(boolean r1);

    public SwitchController() {
    }

    @Override // com.android.settingslib.drawer.EntryController
    public String getKey() {
        return getSwitchKey();
    }

    @Override // com.android.settingslib.drawer.ProviderSwitch
    public boolean isSwitchChecked() {
        return isChecked();
    }

    @Override // com.android.settingslib.drawer.ProviderSwitch
    public boolean onSwitchCheckedChanged(boolean r1) {
        return onCheckedChanged(r1);
    }

    @Override // com.android.settingslib.drawer.ProviderSwitch
    public String getSwitchErrorMessage(boolean r1) {
        return getErrorMessage(r1);
    }
}
