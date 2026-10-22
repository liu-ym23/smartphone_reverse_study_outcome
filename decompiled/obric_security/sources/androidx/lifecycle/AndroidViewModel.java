package androidx.lifecycle;

import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {
    private Application mApplication;

    public AndroidViewModel(Application r1) {
        this.mApplication = r1;
    }

    public <T extends Application> T getApplication() {
        return (T) this.mApplication;
    }
}
