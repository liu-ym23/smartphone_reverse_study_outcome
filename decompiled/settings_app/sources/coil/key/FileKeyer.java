package coil.key;

import coil.request.Options;
import com.android.settingslib.accessibility.AccessibilityUtils;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: FileKeyer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcoil/key/FileKeyer;", "Lcoil/key/Keyer;", "Ljava/io/File;", "addLastModifiedToFileCacheKey", "", "(Z)V", "key", "", "data", "options", "Lcoil/request/Options;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileKeyer implements Keyer<File> {
    private final boolean addLastModifiedToFileCacheKey;

    public FileKeyer(boolean r1) {
        this.addLastModifiedToFileCacheKey = r1;
    }

    @Override // coil.key.Keyer
    public /* bridge */ /* synthetic */ String key(File r1, Options r2) {
        return key2(r1, r2);
    }

    /* JADX INFO: renamed from: key, reason: avoid collision after fix types in other method */
    public String key2(File r1, Options r2) {
        if (this.addLastModifiedToFileCacheKey == false) goto L6;
        return r1.getPath() + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r1.lastModified();
    L6:
        return r1.getPath();
    }
}
