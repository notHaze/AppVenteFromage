package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class PanelPanier extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4887236298209934215L;

	private JFrame frame;
	
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private AbstractButton rdbtnColissimoPointRelais;
	private JRadioButton rdbtnColissimoDomicile;
	private JRadioButton rdbtnChronopost;
	private AbstractButton btnValiderPanier;
	private JButton btnViderPanier;
	private JButton btnContinuerAchats;
	private JPanel panelEntete;
	private JLabel labelValidation;
	private JLabel labelCoordonnees;
	private JSeparator separator;
	private JSeparator separator_1;
	private JScrollPane scrollPane;

	/**
	 * Create the application.
	 */
	public PanelPanier(JFrame frame) {
		this.frame = frame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame.getContentPane().add(this);
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 8, 0, 8));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 1));
		
		JLabel Titre = new JLabel("Votre Panier :");
		Titre.setHorizontalAlignment(SwingConstants.LEFT);
		Titre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(Titre, BorderLayout.NORTH);
		
		JPanel panelLivraison = new JPanel();
		panel.add(panelLivraison, BorderLayout.SOUTH);
		panelLivraison.setLayout(new GridLayout(0, 3, 0, 0));
		
		rdbtnColissimoPointRelais = new JRadioButton("Colissimo en point Relais : 4.90€");
		rdbtnColissimoPointRelais.setHorizontalAlignment(SwingConstants.CENTER);
		constructeurBoutonColissimoPointRelais();
		buttonGroup.add(rdbtnColissimoPointRelais);
		panelLivraison.add(rdbtnColissimoPointRelais);
		
		rdbtnColissimoDomicile = new JRadioButton("Colissimo à domicile : 4.90€");
		rdbtnColissimoDomicile.setHorizontalAlignment(SwingConstants.CENTER);
		constructeurBoutonColissimoDomicile();
		buttonGroup.add(rdbtnColissimoDomicile);
		panelLivraison.add(rdbtnColissimoDomicile);
		
		rdbtnChronopost = new JRadioButton("Chronopost : 9.90€");
		rdbtnChronopost.setHorizontalAlignment(SwingConstants.CENTER);
		constructeurBoutonChronopost();
		buttonGroup.add(rdbtnChronopost);
		panelLivraison.add(rdbtnChronopost);
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panelEntete = new JPanel();
		panelEntete.setBorder(new EmptyBorder(20, 8, 0, 8));
		add(panelEntete, BorderLayout.NORTH);
		panelEntete.setLayout(new GridLayout(2, 2, 10, 20));
		
		labelValidation = new JLabel("Validation du panier");
		labelValidation.setHorizontalAlignment(SwingConstants.CENTER);
		labelValidation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelEntete.add(labelValidation);
		
		labelCoordonnees = new JLabel("Coordonnées");
		labelCoordonnees.setForeground(Color.LIGHT_GRAY);
		labelCoordonnees.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelCoordonnees.setHorizontalAlignment(SwingConstants.CENTER);
		panelEntete.add(labelCoordonnees);
		
		separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		panelEntete.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		panelEntete.add(separator_1);
		
		JPanel panelBoutonValidation = new JPanel();
		FlowLayout fl_panelBoutonValidation = (FlowLayout) panelBoutonValidation.getLayout();
		fl_panelBoutonValidation.setAlignment(FlowLayout.RIGHT);
		this.add(panelBoutonValidation, BorderLayout.SOUTH);
		
		btnValiderPanier = new JButton("Valider le panier");
		btnValiderPanier.setBackground(Color.DARK_GRAY);
		btnValiderPanier.setForeground(Color.WHITE);
		constructeurBoutonValiderPanier();
		panelBoutonValidation.add(btnValiderPanier);
		
		btnViderPanier = new JButton("Vider le panier");
		constructeurBoutonViderPanier();
		panelBoutonValidation.add(btnViderPanier);
		
		btnContinuerAchats = new JButton("Continuer les achats");
		constructeurBoutonContinuer();
		btnContinuerAchats.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBoutonValidation.add(btnContinuerAchats);
		
		setChoixTransport();
		initListePanier();
		
		
		
	}
	
	private void setChoixTransport() {
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		for (int i=1; i<4; i++) {
			AbstractButton b = (AbstractButton) buttons.nextElement();
			if (i==Accueil.getPanier().getTransport()) {
				b.setSelected(true);
				b.doClick();
			}
		}
	}
	
	private void constructeurBoutonColissimoPointRelais() {
		rdbtnColissimoPointRelais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil.getPanier().setTransport(1); 
				initListePanier();
			}
		});
	}
	
	private void constructeurBoutonColissimoDomicile() {
		rdbtnColissimoDomicile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil.getPanier().setTransport(2);  
				initListePanier();
			}
		});
	}
	
	private void constructeurBoutonChronopost() {
		rdbtnChronopost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil.getPanier().setTransport(3); 
				initListePanier();
			}
		});
	}
	
	private void constructeurBoutonValiderPanier() {
		btnValiderPanier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new InfoPerso(frame,Accueil.getPanier().getTransport()));
				frame.repaint();
				frame.validate();
			}
		});
	}
	
	private void constructeurBoutonViderPanier() {
		btnViderPanier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil.getPanier().reinitialiserPanier();
				initListePanier();
				Accueil.updateAffichagePanier();
				
			}
		});
	}
	
	private void initListePanier() {
		DefaultTableModel tableModel = new DefaultTableModel(Accueil.getPanier().toStringIHM(Accueil.getPanier().getTransport()), new String[] {"Produit", "prix", "quantit\u00E9", "total"});
		table.setModel(tableModel);
	}
	
	private void constructeurBoutonContinuer() {
		btnContinuerAchats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}

}
