package metier;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRecuperationArticles {
	private Fromage  fromage;
	
	@Before
	public void setUp() {
		fromage = new Fromage("Cabécou");
		fromage.addArticle("250g", 10f);
		fromage.addArticle("500g", 10f);
		fromage.addArticle("demi tome", 10f);
	}
	
	@After
	public void tearDown() {
		fromage = null;
	}
	
	@Test
	public void testRecuperationListeArticle() {
		String[] clés = {"250g","500g","demi tome"};
		List<Article> articles = fromage.getArticles();
		for (int i=0; i< articles.size(); i++) {
			assertEquals("Cabécou, "+clés[i]+", Prix TTC : 10.0 €", articles.get(i).toString());
		}
	}
	
	@Test
	public void testRecuperationArticle() {
		String[] clés = {"250g","500g","demi tome"};
		Articles a = new Articles();
		List<Fromage> l = new LinkedList<>();
		l.add(fromage);
		a.addFromages(l);
		
		for (int i=0; i< clés.length; i++) {
			assertEquals("Cabécou, "+clés[i]+", Prix TTC : 10.0 €", a.getArticle("Cabécou", clés[i]).toString());
		}
	}

	
}
