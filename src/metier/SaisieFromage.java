package metier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3f910905-12e4-417f-a1cf-3e0cfca5d8fd")
public class SaisieFromage {
    @objid ("c41b3c8a-2985-4a78-8fa9-d75bbcf892aa")
    private String désignation;

    @objid ("089e0f62-d607-4b2f-9fae-181f4c41efa2")
    private String description;

    @objid ("8e90b41a-9fe6-4ed2-a854-167b624f0339")
    private TypeVente vente;

    @objid ("ab37e21d-b5cf-4f63-9166-a9be8e46e920")
    private String[] cléArticle;

    @objid ("55da7e8b-2e50-4b2d-a8a8-af27b82938cd")
    private float[] prixArticle;

    @objid ("4cc3ae59-63ac-457b-a918-c99948f852c1")
    public SaisieFromage(String désignation, String description, TypeVente vente) {
        this.désignation = désignation;
        this.description = description;
        this.vente = vente;
    }

    @objid ("d3fed196-2694-4652-9752-42c6755cf840")
    public SaisieFromage(String désignation, String description, TypeVente vente, String[] cléArticle, float[] prixArticle) {
        this(désignation, description, vente);
        this.cléArticle = cléArticle;
        this.prixArticle = prixArticle;
    }

    @objid ("e0f4b1ce-673a-43b6-896b-ed84d489ab71")
    public Fromage builderFromage() {
        Fromage f = null;
        switch (vente) {
        case A_LA_COUPE_AU_POIDS : 
            f = new FromageALaCoupe(désignation);
            if (this.prixArticle != null && this.prixArticle.length > 1 
                    && this.cléArticle != null && this.cléArticle.length > 1
                    && this.cléArticle.length == this.prixArticle.length)
                for (int i = 0; i < this.cléArticle.length; i++)
                    f.addArticle(this.cléArticle[i], this.prixArticle[i]);
            break;
        case A_L_UNITE : 
            f = new FromageALUnité(désignation);
            if (this.prixArticle != null)
                f.addArticle("", this.prixArticle[0]);
            break;
        case ENTIER_OU_MOITIE : 
            f = new FromageEntierOuMoitié(désignation);
            if (this.prixArticle != null && this.prixArticle.length == 2) {
                f.addArticle(FromageEntierOuMoitié.MOITIE, this.prixArticle[0]);
                f.addArticle(FromageEntierOuMoitié.ENTIER, this.prixArticle[1]);
            }
            break;
        case A_L_UNITE_PlUSIEURS_CHOIX :
            f = new FromageALUnitéPlusieursChoix(désignation);
            if (this.prixArticle != null && this.prixArticle.length == 1 
                && this.cléArticle != null && this.cléArticle.length > 1)
                for (String clé: this.cléArticle)
                    f.addArticle(clé, this.prixArticle[0]);
            break;
        case POUR_X_PERSONNES :
            f = new FromagePourXPersonnes(désignation);
            if (this.prixArticle != null && this.prixArticle.length > 1 
                    && this.cléArticle != null && this.cléArticle.length > 1
                    && this.cléArticle.length == this.prixArticle.length)
                for (int i = 0; i < this.cléArticle.length; i++)
                    f.addArticle("pour " + this.cléArticle[i] + " personnes", this.prixArticle[i]);
            break;
        }
        f.addDescription(description);
        return f;
    }

}
