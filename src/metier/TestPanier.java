package metier;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPanier {
	private Panier panier;
	Fromage  fromage;
	
	@Before
	public void setUp() {
		panier = new Panier();
		
		fromage = new Fromage("Cabécou");
		fromage.addArticle("250g", 10f);
		fromage.addArticle("500g", 10f);
		fromage.addArticle("demi tome", 10f);
		
		for (Article article : fromage.getArticles()) {
			article.setQuantitéEnStock(15);
		}
	}
	
	@After
	public void tearDown() {
		panier = null;
	}
	
	@Test
	public void testAjouterPanier() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		assertEquals(1, panier.getNombreArticle());
		assertEquals(fromage.getArticles().get(0), panier.getArticle().get(0));
		assertEquals(2, (int)panier.getQuantitéArticle().get(0));
	}
	
	@Test
	public void testAjouterArticlExistant() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		panier.addPanier(fromage.getArticles().get(0), 12);
		
		assertEquals(1, panier.getNombreArticle());
		assertEquals(fromage.getArticles().get(0), panier.getArticle().get(0));
		assertEquals(14, (int)panier.getQuantitéArticle().get(0));
		
		
	}
	
	@Test
	public void testAjouterNouveauArticle() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		panier.addPanier(fromage.getArticles().get(1), 12);
		
		assertEquals(2, panier.getNombreArticle());
		assertEquals(fromage.getArticles().get(0), panier.getArticle().get(0));
		assertEquals(fromage.getArticles().get(1), panier.getArticle().get(1));
		assertEquals(2, (int)panier.getQuantitéArticle().get(0));
		assertEquals(12, (int)panier.getQuantitéArticle().get(1));
		
		
	}
	
	@Test
	public void testEnleverPanier() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		panier.addPanier(fromage.getArticles().get(1), 12);
		panier.enleverPanier(fromage.getArticles().get(1), 4);
		
		assertEquals(2, panier.getNombreArticle());
		assertEquals(fromage.getArticles().get(0), panier.getArticle().get(0));
		assertEquals(fromage.getArticles().get(1), panier.getArticle().get(1));
		assertEquals(2, (int)panier.getQuantitéArticle().get(0));
		assertEquals(8, (int)panier.getQuantitéArticle().get(1));
		
		
	}
	
	@Test
	public void testEnleverArticlePanier() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		panier.addPanier(fromage.getArticles().get(1), 12);
		panier.enleverPanier(fromage.getArticles().get(1), 12);
		
		assertEquals(1, panier.getNombreArticle());
		assertEquals(fromage.getArticles().get(0), panier.getArticle().get(0));
		assertEquals(2, (int)panier.getQuantitéArticle().get(0));
		
		
	}
	
	@Test
	public void testViderPanier() {
		panier.addPanier(fromage.getArticles().get(0), 2);
		panier.addPanier(fromage.getArticles().get(1), 12);
		
		panier.reinitialiserPanier();
		assertEquals(0, panier.getNombreArticle());
		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionAddPanier() {
		panier.addPanier(fromage.getArticles().get(0), -3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionRemovePanierQuantité() {
		panier.enleverPanier(fromage.getArticles().get(0), -3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionRemovePanierArticle() {
		panier.enleverPanier(fromage.getArticles().get(2), 2);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionSuperieurStock() {
		panier.enleverPanier(fromage.getArticles().get(2), 50);
	}
	
}
