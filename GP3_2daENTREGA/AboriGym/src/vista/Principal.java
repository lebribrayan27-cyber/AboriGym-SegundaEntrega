package vista;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import persistencia.Conexion;
import persistencia.TablaDAO;
public class Principal extends JFrame {
 private final JComboBox<String> tipo=new JComboBox<>(new String[]{"Socios","Entrenadores","Clases","Pases","Asistencias"});
 private final JPanel formulario=new JPanel(new GridLayout(0,2,6,6));
 private final JTable tabla=new JTable();
 private JTextField[] campos;
 private String[] columnas;
 private TablaDAO dao;
 public Principal(){super("AboriGym - Segunda entrega");setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(850,610);setLocationRelativeTo(null);
 JPanel arriba=new JPanel(new BorderLayout());arriba.add(new JLabel("  Gimnasio AboriGym - Gestion de datos  "),BorderLayout.WEST);arriba.add(tipo,BorderLayout.EAST);add(arriba,BorderLayout.NORTH);
 JPanel centro=new JPanel(new BorderLayout(5,5));centro.add(new JScrollPane(formulario),BorderLayout.NORTH);centro.add(new JScrollPane(tabla),BorderLayout.CENTER);add(centro,BorderLayout.CENTER);
 JPanel botones=new JPanel(new FlowLayout());String[] nombres={"Mostrar","Ingresar","Actualizar","Buscar por ID","Eliminar","Probar conexion"};for(String nombre:nombres){JButton b=new JButton(nombre);botones.add(b);b.addActionListener(e->accion(nombre));}add(botones,BorderLayout.SOUTH);
 tipo.addActionListener(e->cargar());tabla.getSelectionModel().addListSelectionListener(e->{if(!e.getValueIsAdjusting()&&tabla.getSelectedRow()>=0){int f=tabla.getSelectedRow();for(int i=0;i<campos.length;i++)campos[i].setText(String.valueOf(tabla.getValueAt(f,i)));}});cargar();}
 private void cargar(){try{dao=new TablaDAO((String)tipo.getSelectedItem());columnas=dao.columnas();campos=new JTextField[columnas.length];formulario.removeAll();for(int i=0;i<columnas.length;i++){formulario.add(new JLabel(columnas[i]));campos[i]=new JTextField(16);formulario.add(campos[i]);}formulario.revalidate();formulario.repaint();mostrar(dao.listar());}catch(Exception ex){error(ex);}}
 private void mostrar(java.util.List<String[]> filas){DefaultTableModel m=new DefaultTableModel(columnas,0){public boolean isCellEditable(int r,int c){return false;}};for(String[] f:filas)m.addRow(f);tabla.setModel(m);}
 private String[] valores(){String[] v=new String[campos.length];for(int i=0;i<v.length;i++)v[i]=campos[i].getText();return v;}
 private void accion(String a){try{if(a.equals("Probar conexion")){try(Connection c=Conexion.conectar()){JOptionPane.showMessageDialog(this,"Conexion correcta con MySQL");}return;}if(a.equals("Mostrar")){mostrar(dao.listar());return;}if(a.equals("Buscar por ID")){String id=JOptionPane.showInputDialog(this,"Ingrese ID");if(id!=null)mostrar(dao.buscar(id));return;}if(a.equals("Ingresar"))dao.insertar(valores());if(a.equals("Actualizar"))dao.actualizar(valores());if(a.equals("Eliminar")){if(JOptionPane.showConfirmDialog(this,"Eliminar registro ID "+campos[0].getText()+"?","Confirmar",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)return;dao.eliminar(campos[0].getText());}mostrar(dao.listar());JOptionPane.showMessageDialog(this,"Operacion realizada");}catch(Exception ex){error(ex);}}
 private void error(Exception ex){JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);}
 public static void main(String[] args){SwingUtilities.invokeLater(()->new Principal().setVisible(true));}
}
