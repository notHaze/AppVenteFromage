package metier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("7c5bea4e-1c55-4567-a194-b6a2e0b03a3a")
public class FromageALaCoupe extends Fromage {
    @objid ("dc27c67a-9b49-4763-9fff-2dc957f8807c")
    public FromageALaCoupe(String désignation) {
        super(désignation);
    }

    @objid ("d1d66e58-2b76-4788-9087-604fd1f269a4")
    public String toString() {
        return super.toString() + ", vendu à la coupe ou au poids";
    }

}
