package persistencia;
import java.sql.*;
import java.util.*;
public class TablaDAO {
 private final String tabla;
 public TablaDAO(String tabla) { if(!Arrays.asList("Socios","Entrenadores","Clases","Pases","Asistencias").contains(tabla)) throw new IllegalArgumentException(); this.tabla=tabla; }
 public String[] columnas() throws SQLException { try(Connection c=Conexion.conectar();ResultSet r=c.getMetaData().getColumns(c.getCatalog(),null,tabla,null)) { List<String> a=new ArrayList<>();while(r.next())a.add(r.getString("COLUMN_NAME"));return a.toArray(new String[0]); } }
 public List<String[]> listar() throws SQLException { List<String[]> lista=new ArrayList<>();try(Connection c=Conexion.conectar();Statement s=c.createStatement();ResultSet r=s.executeQuery("SELECT * FROM "+tabla)) { int n=r.getMetaData().getColumnCount();while(r.next()){String[] fila=new String[n];for(int i=0;i<n;i++)fila[i]=r.getString(i+1);lista.add(fila);} }return lista; }
 private void ejecutar(String sql, String[] valores) throws SQLException {try(Connection c=Conexion.conectar();PreparedStatement ps=c.prepareStatement(sql)){for(int i=0;i<valores.length;i++){String v=valores[i];ps.setString(i+1,v==null||v.trim().isEmpty()?null:v.trim());}ps.executeUpdate();}}
 public void insertar(String[] valores) throws SQLException {String[] cols=columnas();StringJoiner nombres=new StringJoiner(","),signos=new StringJoiner(",");for(int i=1;i<cols.length;i++){nombres.add(cols[i]);signos.add("?");}ejecutar("INSERT INTO "+tabla+" ("+nombres+") VALUES ("+signos+")",Arrays.copyOfRange(valores,1,valores.length));}
 public void actualizar(String[] valores) throws SQLException {String[] cols=columnas();StringJoiner campos=new StringJoiner(",");for(int i=1;i<cols.length;i++)campos.add(cols[i]+"=?");String[] params=new String[valores.length];System.arraycopy(valores,1,params,0,valores.length-1);params[params.length-1]=valores[0];ejecutar("UPDATE "+tabla+" SET "+campos+" WHERE "+cols[0]+"=?",params);}
 public void eliminar(String id) throws SQLException {ejecutar("DELETE FROM "+tabla+" WHERE "+columnas()[0]+"=?",new String[]{id});}
 public List<String[]> buscar(String id) throws SQLException {List<String[]> lista=new ArrayList<>();try(Connection c=Conexion.conectar();PreparedStatement s=c.prepareStatement("SELECT * FROM "+tabla+" WHERE "+columnas()[0]+"=?")){s.setString(1,id);try(ResultSet r=s.executeQuery()){int n=r.getMetaData().getColumnCount();while(r.next()){String[] fila=new String[n];for(int i=0;i<n;i++)fila[i]=r.getString(i+1);lista.add(fila);}}}return lista;}
}
