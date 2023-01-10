package metier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a8037a71-21a2-49a5-9e9e-0517c84a73c9")
public class Article {
    @objid ("1e839acc-fe37-464c-a326-b91871f75f30")
    private String clé;

    @objid ("a626118c-3431-417e-b83f-86ff774c1e9b")
    private float prixTTC;

    @objid ("50a84db4-ddb6-401b-b759-ade4cc66c393")
    private int quantitéEnStock;

    @objid ("81d6cb00-2755-4d58-9028-a3209d2b1389")
    private Fromage fromage;

    @objid ("4bf26c02-88e6-45c3-9604-ee0d775fa01a")
    public Article(Fromage fromage, String clé, float prixTTC) {
        this.fromage = fromage;
        this.clé = clé;
        this.prixTTC = prixTTC;
        this.quantitéEnStock = 0;
    }

    @objid ("345c8034-be8c-44d0-a773-4d29fe5a5e5c")
    public Fromage getFromage() {
        return this.fromage;
    }

    @objid ("0f252fa0-3671-4f89-806e-d6b0053b917b")
    public float getPrixTTC() {
        return this.prixTTC;
    }

    @objid ("6d25e35b-1bb9-4d1c-ae35-c07a5e99ee17")
    public int getQuantitéEnStock() {
        return quantitéEnStock;
    }

    @objid ("45903c2a-abd9-4041-983f-4847c4e11666")
    public String getClé() {
        return this.clé;
    }

    @objid ("120b9f66-3a4a-4b91-a2db-755d462a086d")
    public void setQuantitéEnStock(int quantitéEnStock) {
        this.quantitéEnStock = quantitéEnStock;
    }

    @objid ("3f6adc6e-2ff7-495d-b380-09c5de351316")
    public void préempterQuantité(int quantité) {
        this.quantitéEnStock-=quantité;
    }

    @objid ("b942cba1-dd7b-4ac3-b11c-2947df737a41")
    public void rendreQuantité(int quantité) {
        this.quantitéEnStock+=quantité;
    }

    @objid ("c547e7aa-d954-4d55-9b70-3a78a7c56fd8")
    public String toString() {
        if (clé.equals(""))
            return this.fromage.getDésignation() + ", Prix TTC : " + this.getPrixTTC() + " €";
        else
            return this.fromage.getDésignation() + ", " + this.clé + ", Prix TTC : " + this.getPrixTTC() + " €";
    }

    @objid ("cbaf74f9-e001-40b7-890a-99d7f36831c6")
    public String toStringIHM() {
        return this.fromage.getDésignation()+ " -- "+this.clé;
    }

    @objid ("29a5c7d0-32a4-4665-968e-ceac2a7e1813")
    public String toStringAvecStock() {
        return this.fromage.getDésignation() + ", Prix TTC : " + this.getPrixTTC() + " €" + ", Quantitée en stock : "+this.quantitéEnStock+" pièces";
    }

    @objid ("67c55142-c52c-48c6-9466-316eee9d33db")
    public boolean equals(Object obj) {
        Article other = (Article) obj;
        return (this.fromage.equals(other.fromage) && this.clé.equals(other.clé));
    }

}
