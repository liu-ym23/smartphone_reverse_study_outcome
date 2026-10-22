package d.b.u;

import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public class j extends Observable {
    public j() {
    }

    public void a() {
        setChanged();
        notifyObservers(Boolean.TRUE);
    }
}
