package nl.qien.demo.XMLMarshaller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import nl.qien.demo.model.Dierentuin;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class DierentuinMarhaller {

    public static void main(String[] args) throws IOException {
        // first, create and write to file
        {
            Dierentuin dierentuin = new Dierentuin();
            dierentuin.setDieren("Panda's");
            dierentuin.setAantalMedewerkers(43);

            writeToXml(dierentuin);
        }
        //... then read back from file
        {
            Dierentuin readBack = readFromFile("dierentuin.xml");

            System.out.println(readBack);
        }
    }

    private static void writeToXml(Dierentuin dierentuin) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("dierentuin.xml"), dierentuin);
    }

    private static Dierentuin readFromFile(String fileName) throws JsonParseException, JsonMappingException, IOException {
        File file = new File("dierentuin.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = getStringFromInputStream(new FileInputStream(file));
        Dierentuin value = xmlMapper.readValue(xml, Dierentuin.class);

        return value;
    }

    private static String getStringFromInputStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();

    }

    private static Dierentuin getDierentuinFromInputStream(InputStream is) throws IOException {
        return null;
    }
}
