package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.CardLayout;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import metier.Articles;
import metier.Fromage;
import metier.GenerationFromages;
import metier.Panier;
import metier.TypeLait;

import javax.swing.JSeparator;

public class Accueil {

	private JFrame frame;
	private Articles listArt;
	private DefaultListModel<String> listeFromage = new DefaultListModel<>();
	private static Panier panier = new Panier();
	private List<Fromage> listeDeFromage;
	private static DecimalFormat f = new DecimalFormat("#0.00");
	private JPanel panelListeDeFromage;
	private JScrollPane listDeroulante;
	private JList<String> listDeFromage;
	private JPanel panelEnteteFiltre;
	private JPanel panelEntete;
	private JPanel panelFiltre;
	private JPanel panelVide1;
	private JPanel panelBtnVache;
	private JPanel panelBtnChevre;
	private JPanel panelBtnBrebis;
	private JPanel panelBtnTous;
	private JPanel panelVide2;
	private JPanel panelTitreListe;
	private JButton btnVache;
	private JLabel libelleVache;
	private JLabel libelleChèvre;
	private JButton btnChevre;
	private JButton btnBrebis;
	private JLabel libelleBrebis;
	private JButton btnTous2;
	private JLabel libelleTous;
	private JPanel panelTitreApp;
	private JLabel labelTitreApp;
	private JPanel panelPanier;
	private static JButton btnPanier;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 818, 852);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		GenerationFromages gen = new GenerationFromages();
		listArt = gen.générationBaseFromages();
		setDefaultListModel(listeFromage);
		
		panelListeDeFromage = new JPanel();
		panelListeDeFromage.setBorder(new EmptyBorder(7, 7, 7, 7));
		frame.getContentPane().add(panelListeDeFromage, BorderLayout.CENTER);
		panelListeDeFromage.setLayout(new CardLayout(0, 0));
		
		listDeroulante = new JScrollPane();
		panelListeDeFromage.add(listDeroulante, "name_53519843771000");
		
		listDeFromage = new JList<String>(listeFromage);
		constructeurListeFromage();
		listDeroulante.setViewportView(listDeFromage);
		
		panelEnteteFiltre = new JPanel();
		frame.getContentPane().add(panelEnteteFiltre, BorderLayout.NORTH);
		panelEnteteFiltre.setLayout(new GridLayout(3, 0, 0, -5));
		
		panelEntete = new JPanel();
		panelEnteteFiltre.add(panelEntete);
		panelEntete.setLayout(new BorderLayout(0, -15));
		
		panelTitreApp = new JPanel();
		FlowLayout fl_panelTitreApp = (FlowLayout) panelTitreApp.getLayout();
		fl_panelTitreApp.setVgap(15);
		panelEntete.add(panelTitreApp, BorderLayout.CENTER);
		
		labelTitreApp = new JLabel("Nos Fromages");
		labelTitreApp.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelTitreApp.add(labelTitreApp);
		
		panelPanier = new JPanel();
		FlowLayout fl_panelPanier = (FlowLayout) panelPanier.getLayout();
		fl_panelPanier.setAlignment(FlowLayout.RIGHT);
		panelEntete.add(panelPanier, BorderLayout.NORTH);
		
		btnPanier = new JButton("Panier");
		btnPanier.setIcon(new ImageIcon(Accueil.class.getResource("/image/wicker-basketResize.png")));
		btnPanier.setText(f.format(panier.getPrixPanier()) +" €");
		btnPanier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPanier.setBackground(SystemColor.controlHighlight);
		btnPanier.setHorizontalAlignment(SwingConstants.LEADING);
		constructeurPanierIHM();
		panelPanier.add(btnPanier);
		
		panelFiltre = new JPanel();
		panelEnteteFiltre.add(panelFiltre);
		panelFiltre.setLayout(new GridLayout(0, 6, 0, 0));
		
		panelVide1 = new JPanel();
		panelFiltre.add(panelVide1);
		
		panelBtnVache = new JPanel();
		panelBtnVache.setBorder(new EmptyBorder(15, 10, 15, 10));
		panelFiltre.add(panelBtnVache);
		panelBtnVache.setLayout(new BorderLayout(0, 0));
		
		btnVache = new JButton("");
		btnVache.setIcon(new ImageIcon(Accueil.class.getResource("/image/cowResize.png")));
		constructeurBoutonVache();
		panelBtnVache.add(btnVache, BorderLayout.CENTER);
		
		libelleVache = new JLabel("Vache");
		libelleVache.setHorizontalAlignment(SwingConstants.CENTER);
		panelBtnVache.add(libelleVache, BorderLayout.SOUTH);
		
		panelBtnChevre = new JPanel();
		panelBtnChevre.setBorder(new EmptyBorder(15, 10, 15, 10));
		panelFiltre.add(panelBtnChevre);
		panelBtnChevre.setLayout(new BorderLayout(0, 0));
		
		libelleChèvre = new JLabel("Chèvre");
		libelleChèvre.setHorizontalAlignment(SwingConstants.CENTER);
		panelBtnChevre.add(libelleChèvre, BorderLayout.SOUTH);
		
		btnChevre = new JButton("");
		btnChevre.setIcon(new ImageIcon(Accueil.class.getResource("/image/goatResize.png")));
		constructeurBoutonChèvre();
		panelBtnChevre.add(btnChevre, BorderLayout.CENTER);
		
		panelBtnBrebis = new JPanel();
		panelBtnBrebis.setBorder(new EmptyBorder(15, 10, 15, 10));
		panelFiltre.add(panelBtnBrebis);
		panelBtnBrebis.setLayout(new BorderLayout(0, 0));
		
		btnBrebis = new JButton("");
		btnBrebis.setIcon(new ImageIcon(Accueil.class.getResource("/image/lambResize.png")));
		constructeurBoutonBrebis();
		panelBtnBrebis.add(btnBrebis, BorderLayout.CENTER);
		
		libelleBrebis = new JLabel("Brebis");
		libelleBrebis.setHorizontalAlignment(SwingConstants.CENTER);
		panelBtnBrebis.add(libelleBrebis, BorderLayout.SOUTH);
		
		panelBtnTous = new JPanel();
		panelBtnTous.setBorder(new EmptyBorder(15, 10, 15, 10));
		panelFiltre.add(panelBtnTous);
		panelBtnTous.setLayout(new BorderLayout(0, 0));
		
		btnTous2 = new JButton("");
		btnTous2.setIcon(new ImageIcon(Accueil.class.getResource("/image/cheeseResize.png")));
		constructeurBoutonTous();
		panelBtnTous.add(btnTous2, BorderLayout.CENTER);
		
		libelleTous = new JLabel("Tous");
		libelleTous.setHorizontalAlignment(SwingConstants.CENTER);
		panelBtnTous.add(libelleTous, BorderLayout.SOUTH);
		
		panelVide2 = new JPanel();
		panelFiltre.add(panelVide2);
		
		panelTitreListe = new JPanel();
		panelTitreListe.setBorder(new MatteBorder(10, 1, 10, 1, (Color) null));
		panelEnteteFiltre.add(panelTitreListe);
		panelTitreListe.setLayout(new BorderLayout(15, 10));
		
		lblNewLabel = new JLabel("Liste de nos Fromages");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitreListe.add(lblNewLabel, BorderLayout.SOUTH);
		
		panel_2 = new JPanel();
		panelTitreListe.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new CardLayout(40, 40));
		
		separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		panel_2.add(separator, "name_57761328792300");
		quitterFenetre ();
	}
		
	   private void quitterFenetre () {
	   }
		
	   private void setDefaultListModel(DefaultListModel<String> listFromage) {
	       listeFromage.clear(); 
		   for (Fromage fromage : listArt.getLesFromages()) {
	            listFromage.addElement(fromage.getDésignation());
	       }
		   listeDeFromage = listArt.getLesFromages();
	    }
	   
	   private void setListFromageAuLaitDe (DefaultListModel<String> listeFromage, TypeLait lait) {
		   listeFromage.clear(); 
		   for (Fromage fromage : listArt.fromagesAuLaitDe(lait)) {
		        listeFromage.addElement(fromage.getDésignation());
		   }
		   listeDeFromage = listArt.fromagesAuLaitDe(lait);
		}
	   
	   private void constructeurBoutonVache() {
		   btnVache.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setListFromageAuLaitDe(listeFromage, TypeLait.VACHE);
				}
			});
	   }
	   
	   private void constructeurBoutonChèvre() {
		   btnChevre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setListFromageAuLaitDe(listeFromage, TypeLait.CHEVRE);
				}
			});
	   }
	   
	   private void constructeurBoutonBrebis() {
		   btnBrebis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setListFromageAuLaitDe(listeFromage, TypeLait.BREBIS);
				}
			});
	   }
	   
	   private void constructeurBoutonTous() {
		   btnTous2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setDefaultListModel(listeFromage);
				}
			});
	   }
	   
	   public static Panier getPanier() {
		   return Accueil.panier;
	   }
	   
	   private void constructeurListeFromage() {
		   listDeFromage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
						Details detail = new Details( listeDeFromage.get(listDeFromage.getSelectedIndex()));
						detail.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
						detail.setVisible(true);
					}
				}
			});
	   }
	   private void constructeurPanierIHM() {
		   btnPanier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanierIHM panier = new PanierIHM();
					panier.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
					panier.setVisible(true);
				}
			});
	   }
	   
	   public static void updateAffichagePanier() {
		   btnPanier.setText(f.format(panier.getPrixPanier()) +" €");
	   }

}
