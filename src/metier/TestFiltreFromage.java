package metier;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFiltreFromage {
	private Articles articles;
	
	@Before
	public void setUp() {
		GenerationFromages gen = new GenerationFromages();
		articles = gen.générationBaseFromages();
	}
	
	@After
	public void tearDown() {
		articles = null;
	}
	
	@Test
	public void testFiltreVache() {
		for (Fromage fromage : articles.fromagesAuLaitDe(TypeLait.VACHE)) {
			assertEquals(TypeLait.VACHE.toString(), fromage.getTypeFromage().toString());
		}
	}
	
	@Test
	public void testFiltreBrebis() {
		for (Fromage fromage : articles.fromagesAuLaitDe(TypeLait.BREBIS)) {
			assertEquals(TypeLait.BREBIS.toString(), fromage.getTypeFromage().toString());
		}
	}
	
	@Test
	public void testFiltreChèvre() {
		for (Fromage fromage : articles.fromagesAuLaitDe(TypeLait.CHEVRE)) {
			assertEquals(TypeLait.CHEVRE.toString(), fromage.getTypeFromage().toString());
		}
	}

	
}
