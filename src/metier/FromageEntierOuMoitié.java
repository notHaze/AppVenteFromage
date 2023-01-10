package metier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e3413c6f-7132-44cb-b338-ff647f2f6186")
public class FromageEntierOuMoitié extends Fromage {
    @objid ("d6e01247-4210-40e3-b8e6-4a789da09598")
    public static final String MOITIE = "moitié";

    @objid ("fbf44ae9-5f51-4859-8492-6025749f1692")
    public static final String ENTIER = "entier";

    @objid ("09ab5c27-c179-42d5-ba9e-423ae09daf74")
    public FromageEntierOuMoitié(String désignation) {
        super(désignation);
    }

    @objid ("3b59c707-17c9-4dc9-9766-890d33da09f9")
    public String toString() {
        return super.toString() + ", vendu entier ou par moitié";
    }

}
