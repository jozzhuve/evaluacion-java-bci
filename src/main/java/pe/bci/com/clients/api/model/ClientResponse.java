package pe.bci.com.clients.api.model;

import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public class ClientResponse {
  private UUID id;
  private Date created;
  private Date modified;
  private Date lastLogin;
  private UUID token;
  private boolean isActive;
}
