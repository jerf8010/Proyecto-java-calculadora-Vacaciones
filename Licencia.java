import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Licencia extends JFrame implements ActionListener, ChangeListener {
	private JLabel label1, label2;
	private JCheckBox box;
	private JButton boton1, boton2;
	private JScrollPane scroll;
	private JTextArea textArea;
	
	String nombre = "";
	public Licencia(){
		setLayout( null );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setTitle( "Licencia de uso" );
		setIconImage( new ImageIcon(getClass().getResource( "images/icon.png" ) ).getImage() );
		
		Bienvenida ventanaBienvenida = new Bienvenida();
		nombre = ventanaBienvenida.texto;	
		
		label1 = new JLabel( "TERMINOS Y CONDICIONES" );
		label1.setBounds( 215, 5, 200, 30 );
		label1.setFont( new Font( "Andale Mono", 1, 14 ) );
		label1.setForeground( new Color( 0, 0, 0 ) );
		add( label1 );
	
		textArea = new JTextArea();
		textArea.setEditable( false );
		textArea.setFont( new Font( "Andale Mono", 0, 9 ) );
		textArea.setText( "\n\n          TERMINOS Y CONDICIONES" +
				"\n\n            A. PROHIBIDA SU VENTA O DISTRIBUCION SIN AUTORIZACION DE EMANUEL FITTA."+
				"\n             B. PROHIBIDA LA ALTERACION DEL CODIGO FUENTE O DISENO DE LAS INTERFACES GRAFICAS."+
				"\n             C. EMANUEL FITTA NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE."+
				"\n\n          LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE."+
				"\n           (EMANUEL FITTA), NO SE RESPONSABILIZAN DEL USO QUE USTED " +
				"\n           HAGA CON ESTE SOFTWARE Y SUS SERVICIO. PARA ACEPTAR ESTOS TERMINOS HAGA CLICK EN (ACEPTO)"+
				"\n           SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLICK EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE."+
				"\n\n           PARA MAYOR INFORMACION SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE"+
				"\n           http://www.loquesea.com/emanuelFitta" );
		scroll = new JScrollPane( textArea );
		scroll.setBounds( 10, 40, 575, 200 );
		add( scroll );

		box = new JCheckBox( "Yo " + nombre + " acepto" );
		box.setBounds( 10, 250, 300, 30 );
		box.addChangeListener( this );
		add( box );

		boton1 = new JButton( "Continuar" );
		boton1.setBounds( 10, 290, 100, 30 );
		boton1.addActionListener( this );
		boton1.setEnabled( false );
		add( boton1 );

		boton2 = new JButton( "No Acepto" );
		boton2.setBounds( 120, 290, 100, 30 );
		boton2.addActionListener( this );
		boton2.setEnabled( true );
		add( boton2 );
		
		ImageIcon imagen = new ImageIcon( "images/coca-cola.png" );
		label2 = new JLabel( imagen );
		label2.setBounds( 315, 135, 300, 300 );
		add( label2 );
	}

	public void stateChanged( ChangeEvent event ) {
		if ( box.isSelected() == true ) {
			boton1.setEnabled( true );
			boton2.setEnabled( false );
		} else {
			boton1.setEnabled( false );
			boton2.setEnabled( true );
		}
		
	}

	public void actionPerformed( ActionEvent event ) {
		if( event.getSource() == boton1 ){
			Principal ventanaPrincipal = new Principal();
			ventanaPrincipal.setBounds( 0, 0, 680, 570 );
			ventanaPrincipal.setVisible( true );
			ventanaPrincipal.setResizable( false );
			ventanaPrincipal.setLocationRelativeTo( null );	
			this.setVisible( false );
			
		} else if ( event.getSource() == boton2 ) {
			Bienvenida bienvenida = new Bienvenida();
			bienvenida.setBounds( 0, 0, 350, 450 );
			bienvenida.setVisible( true );
			bienvenida.setResizable( false );
			bienvenida.setLocationRelativeTo( null );
			this.setVisible( false );
		}

	}

	public static void main( String args[] ){
		Licencia licencia = new Licencia();
		licencia.setBounds( 0, 0, 610, 380 );
		licencia.setVisible( true );
		licencia.setResizable( false );
		licencia.setLocationRelativeTo( null );
	}

}