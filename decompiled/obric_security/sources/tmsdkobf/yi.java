package tmsdkobf;

import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/* JADX INFO: loaded from: classes5.dex */
public class yi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Stack f645a;
    public Document b;
    public final DocumentBuilder c;

    public yi() {
        this.c = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        this.f645a = new Stack();
    }
}
