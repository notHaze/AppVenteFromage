package metier;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStock {
	private Panier panier;
	Fromage  fromage;
	
	@Before
	public void setUp() {
		panier = new Panier();
		
		fromage = new Fromage("Cabécou");
		fromage.addArticle("250g", 1f);
		fromage.addArticle("500g", 20f);
		fromage.addArticle("demi tome", 50f);
		
		for (Article article : fromage.getArticles()) {
			article.setQuantitéEnStock(15);
		}
	}
	
	@After
	public void tearDown() {
		panier = null;
	}
	
	@Test
	public void testEnleverStock() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		assertEquals(13, fromage.getArticles().get(0).getQuantitéEnStock());
		
	}
	
	@Test
	public void testEnleverStockDejaPresent() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		panier.addPanier(fromage.getArticles().get(0), 12);
		assertEquals(1, fromage.getArticles().get(0).getQuantitéEnStock());
	}
	
	@Test
	public void testRendreStock() {
		panier.addPanier(fromage.getArticles().get(0), 12);
		panier.enleverPanier(fromage.getArticles().get(0), 6);
		assertEquals(9, fromage.getArticles().get(0).getQuantitéEnStock());
	}
	
	
	
}
	
	