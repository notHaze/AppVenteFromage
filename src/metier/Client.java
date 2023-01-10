package metier;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("2bf5603d-aaaf-48bc-a0ce-992cb9def06e")
public class Client {
    @objid ("731bbb5c-b41b-4a2f-ad6a-fdbe743e29b7")
    private String Nom;

    @objid ("47a4342d-b7d2-474a-a2cc-4dbb6c16aa6e")
    private String Prenom;

    @objid ("9866e09d-80c0-4c8c-a669-2f5c1cc12f20")
    private String CodePostal;

    @objid ("6ed0de53-1e77-4b23-b9c2-9edf2c954e63")
    private String Adresse;

    @objid ("a1d96055-762e-4e6b-a718-255a0c8c7a63")
    private String Ville;

    @objid ("fb1c5935-6bef-4cd3-b506-87639f8e57a3")
    private String Telephone;

    @objid ("8d9533fc-6dd0-444e-9b4f-8bf68ddff2c7")
    private String Mail;

    @objid ("d14be02c-191a-4a64-9170-59f265a08937")
    private String AdresseComp;

    @objid ("61d2ba0e-206d-4415-ac40-89bfd7b1fec0")
    public String getNom() {
        return this.Nom;
    }

    @objid ("b7f83fdc-f49d-4d1b-92ff-56765de0f32f")
    public String getPrenom() {
        return this.Prenom;
    }

    @objid ("8ba6e4e5-f60a-4108-8d03-042c59f35203")
    public Client(String Nom, String Prenom, String CodePostal, String Adresse, String Ville, String Telephone, String Mail, String AdresseComp) {
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.CodePostal=CodePostal;
        this.Adresse=Adresse;
        this.Ville=Ville;
        this.Telephone=Telephone;
        this.Mail=Mail;
        this.AdresseComp=AdresseComp;
    }

    @objid ("ab2ed785-e28e-492a-8210-1652bfea3424")
    public String getCodePostal() {
        return this.CodePostal;
    }

    @objid ("7d1d3b63-bcaa-444e-97bb-be720ccbe38e")
    public String getAdresse() {
        return this.Adresse;
    }

    @objid ("983078e6-af6d-4790-bd7f-94591c507bfc")
    public String getVille() {
        return this.Ville;
    }

    @objid ("ac459863-d677-47bb-8621-a826b6a28a68")
    public String getTelephone() {
        return this.Telephone;
    }

    @objid ("33e54621-6634-4256-964a-ea033ae00ad8")
    public String getMail() {
        return this.Mail;
    }

    @objid ("7bd79e84-cf22-4a11-9a25-6c3a0aad5ff7")
    public String getAdresseComp() {
        return this.AdresseComp;
    }
    
    public String toString() {
    	String commande = "INFORMATIONS CLIENT\n";
    	commande += String.format("%100s\n", this.Nom + " " + this.Prenom);
    	commande += String.format("%100s\n", this.Telephone);
    	commande += String.format("%100s\n", this.Adresse);
    	commande += String.format("%100s\n", this.CodePostal + ", " + this.Ville);
    	if (!(this.AdresseComp==null)) {
    		commande += String.format("%100s\n", "Adresse complémentaire : "+this.AdresseComp);
    	}
    	return commande;
    	
    }

}
