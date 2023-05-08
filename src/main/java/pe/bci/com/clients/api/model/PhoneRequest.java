package pe.bci.com.clients.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneRequest {

    private String number;
    private String cityCode;
    private String countryCode;

}
