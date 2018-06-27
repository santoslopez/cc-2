import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Toolkit;

//ActionListener necesario para que se ejecute un evento (click en boton)
public class MenuPrincipal extends JFrame implements ActionListener{
  private double ancho;
  private double alto;


  //patron de diseno singleton para crear una sola instancia de la clase
  private static MenuPrincipal instancia;
  public static MenuPrincipal getInstancia(){
    if (instancia==null) {
      instancia=new MenuPrincipal();
    }
    return instancia;
  }

  private JLabel lblBienvenida;
  private JLabel lblestado100Lista;
  private JLabel lblestado200Lista;
  private JLabel lblEstado201;
  private JLabel lblEstado300;
  private JLabel lblEstado301;
  private JLabel lblEstado400;

  private JButton btnCerrar;
  private JButton btnOpciones;


  public JList estado100Lista;
  public JList estado200Lista;
  public JList estado201Lista;
  public JList estado300Lista;
  public JList estado301;
  public JList estado400;

  public JTextArea informacion;

  private JScrollPane scrollPaneestado100Lista;
  private JScrollPane scrollPaneestado200Lista;
  private JScrollPane scrollPaneEstado201;
  private JScrollPane scrollPaneEstado300;
  private JScrollPane scrollPaneEstado301;

  private JScrollPane scrollPaneInformacion;

  public DefaultListModel modeloListaEstado100;
  public DefaultListModel modeloListaEstado200;
  public DefaultListModel modeloListaEstado201;
  public DefaultListModel modeloListaEstado300;
  public DefaultListModel modeloListaInformacion;
  //dimensiones que van a tener los JLabel
  private int alturaJLabel=50;
  //private int derecha;
  private int abajoJLabel=30;
  private int anchoJLabel=700;


  //dimensiones que van a tener los ScrollPane
  private int alturaScrollPane=400;
  private int abajoScrollPane=70;
  private int anchoScrollPane=150;

  /*El metodo setBounds(derecha,abajo,ancho,altura);*/

  public void resolucionPantalla(){
      Toolkit t = Toolkit.getDefaultToolkit();
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      alto = screenSize.getHeight();
      ancho = screenSize.getWidth();
      int resolucionAncho = (int)ancho;
      int resolucionAlto = (int)alto;
      setSize(resolucionAncho,resolucionAlto);
  }

  //constructor
  public MenuPrincipal(){
    //le vamos a indicar en que coordenadas vamos a situar nuestra interfaz
    setLayout(null);
    this.setTitle("Simulador de pagos");
    lblBienvenida = new JLabel("Simulador de pagos.");
    lblBienvenida.setBounds(500,0,300,alturaJLabel);
    add(lblBienvenida);

    //creamos un boton para mostrar que estamos en el estado 100
    lblestado100Lista = new JLabel("Estado 100.");
    lblestado100Lista.setBounds(20,30,anchoJLabel,alturaJLabel);
    add(lblestado100Lista);

    //creamos un boton para mostrar que estamos en el estado 200
    lblestado200Lista = new JLabel("Estado 200.");
    lblestado200Lista.setBounds(220,30,anchoJLabel,alturaJLabel);
    add(lblestado200Lista);

    //creamos un boton para mostrar que estamos en el estado 201
    lblEstado201 = new JLabel("Estado 201.");
    lblEstado201.setBounds(420,30,anchoJLabel,alturaJLabel);
    add(lblEstado201);

    //creamos un boton para mostrar que estamos en el estado 300
    lblEstado300 = new JLabel("Estado 300.");
    lblEstado300.setBounds(620,30,anchoJLabel,alturaJLabel);
    add(lblEstado300);

    //creamos un boton para mostrar que estamos en el estado 301
    lblEstado301 = new JLabel("Estado 301.");
    lblEstado301.setBounds(820,30,anchoJLabel,alturaJLabel);
    add(lblEstado301);

    btnCerrar = new JButton("Cerrar");
    btnCerrar.setBounds(1020,30,250,alturaJLabel);
    add(btnCerrar);

    //vamos agregar un evento (va estar a la espera al precionar un click)
    btnCerrar.addActionListener(this);

    btnOpciones = new JButton("Pausar");
    btnOpciones.setBounds(1020,150,250,alturaJLabel);
    add(btnOpciones);

    btnOpciones.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnOpcionesActionPerformed(evt);
      }
    });


    estado100Lista = new JList();

    modeloListaEstado100 = new DefaultListModel();
    estado100Lista.setModel(modeloListaEstado100);

    scrollPaneestado100Lista = new JScrollPane(estado100Lista);
    scrollPaneestado100Lista.setBounds(10,abajoScrollPane,anchoScrollPane,alturaScrollPane);
    add(scrollPaneestado100Lista);

    estado200Lista = new JList();
    modeloListaEstado200 = new DefaultListModel();
    estado200Lista.setModel(modeloListaEstado200);

    scrollPaneestado200Lista = new JScrollPane(estado200Lista);
    scrollPaneestado200Lista.setBounds(210,abajoScrollPane,anchoScrollPane,alturaScrollPane);
    add(scrollPaneestado200Lista);

    estado201Lista = new JList();
    modeloListaEstado201 = new DefaultListModel();
    estado201Lista.setModel(modeloListaEstado201);

    scrollPaneEstado201 = new JScrollPane(estado201Lista);
    scrollPaneEstado201.setBounds(410,abajoScrollPane,anchoScrollPane,alturaScrollPane);
    add(scrollPaneEstado201);

    estado300Lista = new JList();

    modeloListaEstado300 = new DefaultListModel();
    estado300Lista.setModel(modeloListaEstado300);

    scrollPaneEstado300 = new JScrollPane(estado300Lista);
    scrollPaneEstado300.setBounds(610,abajoScrollPane,anchoScrollPane,alturaScrollPane);
    add(scrollPaneEstado300);

    estado301 = new JList();
    scrollPaneEstado301 = new JScrollPane(estado301);
    scrollPaneEstado301.setBounds(810,abajoScrollPane,anchoScrollPane,alturaScrollPane);
    add(scrollPaneEstado301);

    informacion = new JTextArea();
    scrollPaneInformacion = new JScrollPane(informacion);
    scrollPaneInformacion.setBounds(10,500,850,400);
    add(scrollPaneInformacion);

    informacion.setEditable(false);
  }

  //necesario para capturar el evento, o sea cuando damos click al boton
  public void actionPerformed(ActionEvent actionE){
    //Metodo getSource contiene el objeto donde se origino el evento
    if (actionE.getSource()==btnCerrar) {
      System.exit(0);
    }
  }

  private void btnOpcionesActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      String opcion = String.valueOf(btnOpciones.getText());
      if (opcion.equals("Pausar")) {
          opcion = "Reanudar";
          btnOpciones.setText(opcion);

          for (int i=0;i<BillPayments.generador.length;i++ ) {
            BillPayments.generador[i].suspend();
          }
          JOptionPane.showMessageDialog(this,"La transaccion se pauso","PAUSADO", JOptionPane.INFORMATION_MESSAGE);

      }else if (opcion.equals("Reanudar")) {
          opcion = "Pausar";
          btnOpciones.setText(opcion);
          for (int i=0;i<BillPayments.generador.length;i++ ) {
            BillPayments.generador[i].resume();
          }
          JOptionPane.showMessageDialog(this,"Reanudando la transaccion...", "REANUDADO", JOptionPane.ERROR_MESSAGE);
      }
    }catch (Exception e) {

    }

  }

  public void ejecutar(){
    java.awt.EventQueue.invokeLater(new Runnable(){
      public void run(){
        /*le indicamos las dimensiones (izquierda,alto,anchoJLabel,alturaJLabel)
        con el 0 le indicamos que este completamente pegada a la izquierda, con el 0 le indicamos que este hasta arriba,anchoJLabel y alto */
        MenuPrincipal.getInstancia().resolucionPantalla();

        MenuPrincipal.getInstancia().setExtendedState(MAXIMIZED_BOTH);
        MenuPrincipal.getInstancia().setVisible(true);

        //sin importar las coordenadas va estar al centro de la pantalla
        MenuPrincipal.getInstancia().setLocationRelativeTo(null);
        //no permite para que se modifique el tamano de la interfaz
        MenuPrincipal.getInstancia().setResizable(true);
      }
    });
  }
}
