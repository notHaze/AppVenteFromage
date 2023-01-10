package metier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b94b6870-e62a-4f15-9b7c-8fe55e9ec82c")
public class FromageALUnité extends Fromage {
    @objid ("17568708-319a-45b0-a5cd-f426284be60b")
    public FromageALUnité(String désignation) {
        super(désignation);
    }

    @objid ("04752b28-60cf-4073-918b-5a9e05e37914")
    public String toString() {
        return super.toString() + ", vendu à l'unité";
    }

}
