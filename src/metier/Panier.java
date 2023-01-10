package metier;
import java.util.AbstractMap.SimpleEntry;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("2b835d05-1116-4ec0-8093-940e5ffb9b96")
public class Panier {
    @objid ("02d18a86-680f-4e94-a12a-ed043c6da3ed")
    private List<SimpleEntry<Article,Integer>> panier;
    private int transport;

    @objid ("104de93d-34f8-4a47-bbe1-b5241593e1d6")
    public Panier() {
        this.panier = new LinkedList<SimpleEntry<Article, Integer>> ();
        this.transport=1;
    }
    
    
    
    public void enleverPanier(Article Article, Integer quantité) throws IllegalArgumentException{
    	if (quantité < 0)
    		throw new IllegalArgumentException("Quantité inferieur a zero");
    	if (!articleDejaCommandé(Article))
    		throw new IllegalArgumentException("Article non commandé");
    	if (quantité > getQuantitéParArticle(Article)) {
    		throw new IllegalArgumentException("La quantité a enlever excède celle dans le panier");
    	}
    	if (quantité - getQuantitéParArticle(Article) == 0) {
    		this.panier.remove(getIndexArticle(Article));
    	} else {
    		for (SimpleEntry<Article, Integer> pair : this.panier) {
                if (pair.getKey().equals(Article)) {
                    pair.setValue(pair.getValue()-quantité);
                    pair.getKey().rendreQuantité(quantité);
                }
            }
    	}
    }

    @objid ("4279aa57-2f20-40e9-a995-bf0dd3ea934d")
    public void addPanier(Article Article, Integer quantité) throws IllegalArgumentException{
    	if (Article.getQuantitéEnStock() < quantité)
    		throw new IllegalArgumentException("Quantité superieur au stock disponible");
    	if (quantité < 0)
    		throw new IllegalArgumentException("Quantité inferieur a zero");
        if (articleDejaCommandé(Article)) {
            addPanierDejaCommandé(Article, quantité);
        } else if (quantité>0) {
        	this.panier.add(new SimpleEntry<>(Article, quantité));
        }
        Article.préempterQuantité(quantité);
    }
    
    public int getQuantitéParArticle(Article article) {
    	for (SimpleEntry<Article, Integer> pair : this.panier) {
            if (pair.getKey().equals(article)) {
                return pair.getValue();
            }
        }
    	return 0;
    }
    
    private int getIndexArticle(Article Article) {
    	int i=0;
    	for (SimpleEntry<Article, Integer> pair : this.panier) {
            if (pair.getKey().equals(Article)) {
                return i;
            }
            i++;
        }
    	return 0;
    }

    @objid ("bcb830e4-e0bb-4e87-a42a-d61f72ec0f25")
    private boolean articleDejaCommandé(Article Article) {
        for (SimpleEntry<Article, Integer> pair : this.panier) {
            if (pair.getKey().equals(Article)) {
                return true;
            }
        }
        return false;
    }

    @objid ("1ed6222a-1a56-4908-a82d-a812363b0593")
    private void addPanierDejaCommandé(Article Article, Integer quantité) {
        for (SimpleEntry<Article, Integer> pair : this.panier) {
            if (pair.getKey().equals(Article)) {
                pair.setValue(pair.getValue()+quantité);
            }
        }
    }

    @objid ("8664040b-2120-41be-9b82-9f8e190a095a")
    public void reinitialiserPanier() {
        for (SimpleEntry<Article, Integer> pair : this.panier) {
            pair.getKey().rendreQuantité(pair.getValue());
        }
        this.panier = new LinkedList<SimpleEntry<Article, Integer>>();
    }

    @objid ("19809247-7af0-4320-9fa7-10d63e5a5fea")
    public List<Article> getArticle() {
        List<Article> articles = new LinkedList<>();
        for (SimpleEntry<Article, Integer> pair: this.panier) {
            articles.add(pair.getKey());
        }
        return articles;
    }
    
    public List<String> getDésignation() {
    	List<String> désignation = new LinkedList<>();
        for (SimpleEntry<Article, Integer> pair: this.panier) {
        	désignation.add(pair.getKey().toStringIHM());
        }
        return désignation;
    	
    }

    @objid ("02dc1964-dc85-43a6-8423-d7aeb7f9ed71")
    public int getNombreArticle() {
        return this.panier.size();
    }

    @objid ("3bcdfd9a-565b-4065-bebb-1b69612fbf40")
    public List<Integer> getQuantitéArticle() {
        List<Integer> quantitéParArticle = new LinkedList<>();
        for (SimpleEntry<Article, Integer> pair : this.panier) {
            quantitéParArticle.add(pair.getValue());
        }
        return quantitéParArticle;
    }
    
    public float getPrixPanier() {
    	float prix = 0f;
    	for (SimpleEntry<Article, Integer> pair : this.panier) {
            prix += pair.getValue() * pair.getKey().getPrixTTC();
        }
    	return prix;
    	
    }

    @objid ("6e1343ab-6f31-4214-a303-6dce7217e960")
    public List<Float> getPrixArticle() {
        List<Float> prixParArticle = new LinkedList<>();
        for (SimpleEntry<Article, Integer> pair : this.panier) {
            prixParArticle.add(pair.getKey().getPrixTTC());
        }
        return prixParArticle;
    }
    
    public boolean isPanierSuperieur100E () {
    	if (getPrixPanier() > 100f) {
    		return true;
    	}
    	return false;
    }
    
    public float getFraisPort(int transport) throws IllegalArgumentException{
    	if ((transport < 1) || (transport > 3))
    		throw new IllegalArgumentException("numero de type de transport invalide");
    	if (isPanierSuperieur100E()) {
    		return 0;
    	} else {
    		switch(transport) {
    			case 1:
    				return 4.9f;
    			case 2:
    				return 4.9f;
    			case 3:
    				return 9.9f;
    			}
    	}
    	return 0;
    }
    
    public Object[][] toStringIHM(int transport) throws IllegalArgumentException{
    	DecimalFormat format2ChiffresApresVir = new DecimalFormat("#0.00");
    	
    	if ((transport < 1) || (transport > 3))
    		throw new IllegalArgumentException("numero de type de transport invalide");
    	Object[][] data = new Object[this.getNombreArticle()+3][4];
		int i;
		for (i=0; i<this.getNombreArticle(); i++) {
			data[i][0]=this.getArticle().get(i);
			data[i][1]=this.getPrixArticle().get(i)+" €";
			data[i][2]=this.getQuantitéArticle().get(i);
			data[i][3]=format2ChiffresApresVir.format((float)this.getPrixArticle().get(i)*(float)this.getQuantitéArticle().get(i))+" €";
		}
		float prixPanier = this.getPrixPanier();
		float fraisPort = this.getFraisPort(transport);
		data[i][2]="SOUS TOTAL TTC";
		data[i++][3]=format2ChiffresApresVir.format(prixPanier)+" €";
		data[i][2]="FRAIS DE PORT";
		data[i++][3]=format2ChiffresApresVir.format(fraisPort)+" €";
		data[i][2]="TOTAL TTC";
		data[i++][3]=format2ChiffresApresVir.format((float)(prixPanier+fraisPort))+" €";
		return data;
    }
    
    public String toString(int transport) throws IllegalArgumentException{
    	if ((transport < 1) || (transport > 3))
    		throw new IllegalArgumentException("numero de type de transport invalide");
    	String commande = "RECAPITULATIF DE LA COMMANDE :\n\n";
    	int i=1;
    	for (SimpleEntry<Article, Integer> pair : this.panier) {
            commande += i+" : "+String.format("  %-65s",pair.getKey())+String.format("quantité commandée : %5s Prix TTC : %5s €",pair.getValue(), pair.getKey().getPrixTTC()*pair.getValue())+"\n";
            i++;
        }
    	commande +="\n\nTOTAL COMMANDE TTC :"+String.format("%5s €",this.getPrixPanier())+"\n";
    	commande +="FRAIS DE PORT :";
    	if (this.getFraisPort(transport)==0f) {
    		commande+=String.format("%15s","Offert")+"\n";
    	} else {
    		commande+=String.format("%15s €",this.getFraisPort(transport))+"\n";
    	}
    	commande +="\nPRIX TOTAL TTC :"+String.format("%10s €",+this.getPrixPanier()+this.getFraisPort(transport))+"\n";
    	return commande;
    	
    }
    
    public int getTransport() {
    	return this.transport;
    }
    
    public void setTransport(int transport) {
    	this.transport=transport;
    }

}
