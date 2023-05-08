package pe.bci.com.clients.util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;

public class WiremockUtil {

    public static String obtainResource(String resource) {
        InputStream inputStream = WiremockUtil.class.getClassLoader().getResourceAsStream(resource);
        try {
            return IOUtils.toString(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
