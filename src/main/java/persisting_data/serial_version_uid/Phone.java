package persisting_data.serial_version_uid;

import java.io.Serializable;

public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
