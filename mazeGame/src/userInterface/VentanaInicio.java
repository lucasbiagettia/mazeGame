package userInterface;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import game.Game;
import game.MazeGameConfiguration;

public class VentanaInicio extends javax.swing.JFrame {

	public VentanaInicio() {
		initComponents();
		this.setTitle("Juego del laberinto");
		this.setLocation(300, 200);
	}

//	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jRadioButton1 = new javax.swing.JRadioButton();
		jLabel1 = new javax.swing.JLabel();
		size = new javax.swing.JSlider();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jButton1.setText("Jugar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jRadioButton1.setLabel("Jugar con bolita asesina");
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});

		jLabel1.setText("Tamaño del laberinto");

		size.setMaximum(10);
		size.setMinimum(1);
		size.setToolTipText("");
		size.setValue(1);
		size.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		size.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				tamanoStateChanged(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(33, Short.MAX_VALUE).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(jRadioButton1))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jButton1)
								.addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(57, 57, 57))
								.addComponent(size, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(43, 43, 43)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(42, 42, 42).addComponent(jRadioButton1)
						.addGap(27, 27, 27).addComponent(jLabel1).addGap(18, 18, 18)
						.addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(46, 46, 46).addComponent(jButton1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jRadioButton1.getAccessibleContext().setAccessibleName("conBolitaAsesina");

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButton1ActionPerformed
		MazeGameConfiguration.withEnemy = true;
	}// GEN-LAST:event_jRadioButton1ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// Juego.inicioJuego(); // TODO add your handling code here:
		Game.setInicioAbierta(false);

	}// GEN-LAST:event_jButton1ActionPerformed

	private void tamanoStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_tamanoStateChanged
		MazeGameConfiguration.size = this.size.getValue();
	}// GEN-LAST:event_tamanoStateChanged

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new VentanaInicio().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	public static javax.swing.JRadioButton jRadioButton1;
	public static javax.swing.JSlider size;
	// End of variables declaration//GEN-END:variables

	void main() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
