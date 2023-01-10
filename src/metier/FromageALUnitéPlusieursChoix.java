package metier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a9bd5a36-b51f-4d4c-a849-c75f95d34d6c")
public class FromageALUnitéPlusieursChoix extends Fromage {
    @objid ("975f4e3f-1887-4eb6-ad4a-b26a4f9a5b41")
    public FromageALUnitéPlusieursChoix(String désignation) {
        super(désignation);
    }

    @objid ("04901706-b842-4f60-85ff-0e8efdd1900a")
    public String toString() {
        return super.toString() + ", vendu à l'unité avec plusieus choix";
    }

}
