package android.view;

/* JADX INFO: loaded from: classes.dex */
public class ObricDisplayImpl implements IObricDisplay {
    private Display mBase;

    public ObricDisplayImpl() {
    }

    public ObricDisplayImpl(Display display) {
        this.mBase = display;
    }

    public boolean isObricVirtualDisplay() {
        return "auto_action".equals(this.mBase.getName());
    }
}
