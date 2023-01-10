package metier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b8dfae97-8f18-4a73-8977-7c7d70d974fa")
public class FromagePourXPersonnes extends Fromage {
    @objid ("10c13ea1-e3fc-48dd-93b2-60700aec3f8c")
    public FromagePourXPersonnes(String désignation) {
        super(désignation);
    }

    @objid ("87a11aa1-6ba9-49ab-b502-580c685d37eb")
    public String toString() {
        return super.toString() + ", vendu par nombre de personnes";
    }

}
