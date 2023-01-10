package metier;
import java.util.LinkedList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("74f0190b-f0b6-4124-a738-131b45b251ab")
public class Fromage implements Comparable<Fromage> {
    @objid ("f97a8cd3-3844-4614-8f5b-7f0eead26f14")
    public String désignation;

    @objid ("f76ead1c-5ae8-4ad9-834f-0ca9df19d13f")
    public String description;

    @objid ("1093ad2c-68a1-43c1-aab0-73bfc5674871")
    public TypeLait typeFromage;

    @objid ("85933662-a3a0-431e-a7eb-fef461044f1d")
    private List<Article> articles;

    @objid ("99c5a9fa-9ef2-4894-9c07-86cc17199659")
    public Fromage(String désignation) {
        this.désignation = désignation;
        this.articles = new LinkedList<Article> ();
    }

    @objid ("455c2e90-bf15-4645-b2b1-6fcf20ba4a8e")
    public String getDésignation() {
        return this.désignation;
    }

    @objid ("59f9980b-7471-431a-8fc6-fdc28bb926cd")
    public String getDescription() {
        assert !(this.description == null);
        if (this.description == null)
            return "Pas de description de ce fromage pour le moment. Nous en sommes désolés";
        return this.description;
    }

    @objid ("dd541cd5-6e38-40ec-8e97-df9e8a1b2d0f")
    public void addDescription(String déscription) {
        this.description = déscription;
    }

    @objid ("0830aef3-56b4-444d-9d15-2104f80570a4")
    public void updateTypeFromage(TypeLait type) {
        this.typeFromage = type;
    }

    @objid ("b81c8338-4368-4f6f-8a7a-c831b25193e0")
    public TypeLait getTypeFromage() {
        return this.typeFromage;
    }

    @objid ("34538bc6-b22a-4c6f-bd75-1b7a818c2c23")
    public String toString() {
        return this.getDésignation() 
                        + ", Fromage au lait de " 
                        + this.typeFromage.getTypeDeLait();
    }

    @objid ("9b3a24a1-b2ad-4f0c-bced-b9c5a4611f31")
    public void addArticle(String clé, float prixTTC) {
        this.articles.add(new Article(this, clé, prixTTC));
    }

    @objid ("f454eb38-639f-41fe-ba8b-4493efac0fe7")
    public int nombreArticles() {
        return this.articles.size();
    }

    @objid ("b6a0564f-5fd1-4772-a2ef-d1b6947d2643")
    public List<Article> getArticles() {
        return this.articles;
    }

    @objid ("e1c3682c-a596-4980-88c2-8caa6f8452be")
    public int compareTo(Fromage f) {
        return this.désignation.compareTo(f.désignation);
    }

    @objid ("65158fb1-4e05-4498-b47a-1c135b84a586")
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	
    	if (!(obj instanceof Fromage)) {
    		return false;
    	}
	    Fromage other = (Fromage) obj;
	    return this.désignation.equals(other.désignation);
    	
    }

}
