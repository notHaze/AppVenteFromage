package metier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("50d37d6f-4243-4a3c-97b5-8cf764fb561f")
public enum TypeLait {
    VACHE ("Vache"),
    CHEVRE ("Chèvre"),
    BREBIS ("Brebis");

    @objid ("eedb3772-0482-4f12-a4f5-e5c770ad5608")
    private String typeDeLait;

    @objid ("2225bb5c-95d8-4378-8ad0-fded972dba94")
    private TypeLait(String typeDeLait) {
        this.typeDeLait = typeDeLait;
    }

    @objid ("003fce42-c250-4537-b0e3-ff6462093e95")
    public String getTypeDeLait() {
        return this.typeDeLait;
    }

}
