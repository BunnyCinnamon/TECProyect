package Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

/**
 * Descripción: Lector y escritor de Texto tipo xml
 *
 */
@CleanupDone
public class FileReader {

    private ArrayList<String> rolev;
    private static final String DATA = "somedata.xml";
    private static String user = "";
    private static String login = "";

    public String getUser() {
        return user;
    }

    public String getLogin() {
        return login;
    }

    /**
     * Uso: Encuentra el archivo xml y lee su contenido.
     *
     * Descripción: Encuentra el nombre de usuario, y su debe o no guardar la
     * selección.
     *
     * @return // Regresa true o false si ocurre o no error
     */
    public boolean readXML() {
        rolev = new ArrayList<String>();
        Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(DATA);
            Element doc = dom.getDocumentElement();
            user = getTextValue(user, doc, "user");
            if (user != null) {
                if (!user.isEmpty()) {
                    rolev.add(user);
                }
            }
            login = getTextValue(login, doc, "login");
            if (login != null) {
                if (!login.isEmpty()) {
                    rolev.add(login);
                }
            }

            return true;
        } catch (ParserConfigurationException | SAXException pce) {
            System.out.println(pce.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return false;
    }

    /**
     * Descripción: Encuentra el archivo xml y modifica su contenido.
     *
     * @param user // Contiene el Texto del Usuario
     * @param login // Contiene el true o false de la selección
     */
    public void saveToXML(String user, String login) {
        Document dom;
        Element e = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
            Element rootEle = dom.createElement("roles");
            e = dom.createElement("user");
            e.appendChild(dom.createTextNode(user));
            rootEle.appendChild(e);

            e = dom.createElement("login");
            e.appendChild(dom.createTextNode(login));
            rootEle.appendChild(e);
            dom.appendChild(rootEle);
            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(DATA)));
            } catch (TransformerException | IOException te) {
                System.out.println(te.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }

    /**
     * Descripción: Busca los textos en el xmls.
     *
     * @param def // Contiene un texto
     * @param doc // Contiene un documento
     * @param tag // Contiene un texto
     */
    private String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

}
