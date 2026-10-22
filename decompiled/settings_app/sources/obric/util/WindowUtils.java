package obric.util;

import android.app.Activity;
import android.view.Window;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WindowUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lobric/util/WindowUtils;", "", "()V", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WindowUtils {
    public static final Companion Companion = null;
    private static final String TAG = null;

    /* JADX INFO: compiled from: WindowUtils.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lobric/util/WindowUtils$Companion;", "", "()V", "TAG", "", "addSecureFlag", "", "activity", "Landroid/app/Activity;", "clearSecureFlag", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final void addSecureFlag(Activity r3) {
            OLog.i(WindowUtils.access$getTAG$cp(), "addSecureFlag " + r3);
            if (r3 == null) goto L8;
            Window r2 = r3.getWindow();
            if (r2 == null) goto L9;
            r2.setFlags(8192, 8192);
            return;
        L9:
            return;
        }

        public final void clearSecureFlag(Activity r3) {
            OLog.i(WindowUtils.access$getTAG$cp(), "clearSecureFlag " + r3);
            if (r3 == null) goto L8;
            Window r2 = r3.getWindow();
            if (r2 == null) goto L9;
            r2.clearFlags(8192);
            return;
        L9:
            return;
        }
    }

    public WindowUtils() {
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    static {
        Companion = new Companion(null);
        TAG = "WindowUtils";
    }
}
