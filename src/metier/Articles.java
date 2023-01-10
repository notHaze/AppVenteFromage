package metier;
import java.util.LinkedList;
import java.util.List;


import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("72e33dfb-5817-458d-89e4-eced8090e045")
public class Articles {
    @objid ("dc7534d2-f3f0-424b-b92c-06ca4ba86570")
    private List<Fromage> lesFromages;

    @objid ("41a0f37b-698e-41fe-bbf9-4ee822b5f130")
    public Articles() {
        this.lesFromages = new LinkedList<Fromage> ();
    }

    @objid ("c8eb2659-949e-4b84-8fa0-9b6a883a855f")
    public void addFromages(List<Fromage> fromages) {
        this.lesFromages.addAll(fromages);
    }

    @objid ("bbaca568-0f7d-4299-9373-89fa8b2f83e6")
    public String toStringFromagesEtArticles() {
        StringBuffer enForme = new StringBuffer();
        for (Fromage f : this.lesFromages) {
            enForme.append(f.toString() + '\n');
            if (f.nombreArticles() > 0) {
                for (Article article : f.getArticles()) {
                    enForme.append(article.toString() + '\n');
                }
            }
        }
        return enForme.toString();
    }

    @objid ("a3d559bb-316d-4fa4-8ace-08de44f1f695")
    public String toStringArticlesEtStock() {
        StringBuffer enForme = new StringBuffer();
        for (Fromage f : this.lesFromages) {
            if (f.nombreArticles() > 0) {
                for (Article article : f.getArticles()) {
                    enForme.append(article.toStringAvecStock() + '\n');
                }
            }
        }
        return enForme.toString();
    }

    @objid ("071c5639-9998-450d-8151-c1c229c51678")
    public void regénérationDuStock() {
        for (Fromage f : this.lesFromages) {
            if (f.nombreArticles() > 0) {
                for (Article article : f.getArticles()) {
                    article.setQuantitéEnStock((int) Math.round(Math.random()*100));
                }
            }
        }
    }

    @objid ("651a7f59-1d9a-4b29-ae47-0afac137c1af")
    public String vérificationSaisie() {
        StringBuffer enForme = new StringBuffer();
        for (Fromage f : this.lesFromages) {
            if (f.nombreArticles() == 0) {
                enForme.append("Pas d'articles pour " + f.toString() + '\n');
            }
        }
        return enForme.toString();
    }

    @objid ("d4f11cdd-cb06-48a2-af6a-0ac6fc9689a8")
    public Article getArticle(String désignation, String clé) {
        for (Fromage f : this.lesFromages) {
            if (f.getDésignation().equals(désignation)) {
                for (Article article : f.getArticles()) {
                    if (article.getClé().equals(clé)) {
                        return article;
                    }
                }
            }
        }
        return null;
    }
    
     
    @objid ("3fdaff44-82a2-46cb-b8b8-81f8d0b5523f")
    public List<Fromage> fromagesAuLaitDe(TypeLait lait) {
        List<Fromage> list = new LinkedList<>();
        for (Fromage fromage : this.lesFromages) {
            if (fromage.getTypeFromage().equals(lait)) {
                list.add(fromage);
            }
        }
        return list;
    }

    @objid ("ced8e328-7aa0-4380-8504-f5fc64dd7afd")
    public List<Fromage> getLesFromages() {
        return this.lesFromages;
    }

}
