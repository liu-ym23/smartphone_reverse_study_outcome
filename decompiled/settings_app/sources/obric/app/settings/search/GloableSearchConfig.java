package obric.app.settings.search;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class GloableSearchConfig {
    public static final Parcelable.Creator<GloableSearchConfig> CREATOR = null;
    public static final String KEY_CONFIGS = "types";
    public static final String KEY_VERSION = "version";
    private int id;
    private List<SearchConfigType> mConfigTypes;
    private int mVersion;

    public int describeContents() {
        return 0;
    }

    public boolean isValid() {
        return false;
    }

    public void setConfigTypes(List<SearchConfigType> r1) {
    }

    public String toString() {
        return "";
    }

    public void writeToParcel(Parcel r1, int r2) {
    }

    /* synthetic */ GloableSearchConfig(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public GloableSearchConfig() {
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int r1) {
        this.mVersion = r1;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int r1) {
        this.id = r1;
    }

    public List<SearchConfigType> getConfigTypes() {
        return this.mConfigTypes;
    }

    private GloableSearchConfig(Parcel r1) {
    }
}
