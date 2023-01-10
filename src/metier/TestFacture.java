package metier;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFacture {
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
	public void testPrixPanier() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		panier.addPanier(fromage.getArticles().get(1), 2);
		panier.addPanier(fromage.getArticles().get(2), 2);
		assertEquals(142f, panier.getPrixPanier(), 0f);
		
	}
	
	@Test
	public void testFraisPortPointRelais() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		assertEquals(4.90f, panier.getFraisPort(1), 0f);
	}
	
	@Test
	public void testFraisPortDomicile() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		assertEquals(4.90f, panier.getFraisPort(2), 0f);
	}
	
	@Test
	public void testFraisPortChronopost() {	
		panier.addPanier(fromage.getArticles().get(0), 2);
		assertEquals(9.90f, panier.getFraisPort(3), 0f);
	}
	
	@Test
	public void testFraisPortGratuit() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		panier.addPanier(fromage.getArticles().get(1), 2);
		panier.addPanier(fromage.getArticles().get(2), 2);
		assertEquals(0f, panier.getFraisPort(1), 0f);
		assertEquals(0f, panier.getFraisPort(2), 0f);
		assertEquals(0f, panier.getFraisPort(3), 0f);
	}
	
}
	
	