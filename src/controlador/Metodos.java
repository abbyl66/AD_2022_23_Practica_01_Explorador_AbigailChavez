
package controlador;

import Vista.ExploradorAc;
import java.io.File;
import java.nio.file.Files;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abby
 */



public class Metodos {
    
    //Objeto tipo ExploradorAc.
    ExploradorAc explorador = new ExploradorAc();
    
    //Método para obtener tamaño de ficheros. Este método necesita el tamaño para llevar a cabo su función, y devuelve un string con el resultado.
    public String tamanioArchivo (float tamanio){
        
        DecimalFormat df = new DecimalFormat("#.00");
        String tam="";
        
        if((double)tamanio > 1024000000){
            tam = df.format(tamanio/1024000000) +" Gb";
        }else if((double)tamanio > 1024000){
            tam = df.format(tamanio/1024000) +"Mb";
        }else if((double)tamanio > 1024){
            tam = df.format((double)tamanio/1024) +"Kb";
        }else{
            tam = df.format((double)tamanio) +"B    "; //El método Files.size de por sí devuelve el resultado en bytes.
        }
        
        return tam;
    }
    
    
    //Método para buscar archivos al pulsar el botón de búsqueda de directorio.
    public void buscarDirectorio (String directorio, JLabel existeRuta, JTable tablaArchivos, JTextField txtExt, JButton bExt){
        //Comprobamos que txtDirectorio tenga algún dato.
        if(directorio.isEmpty()){
            
            JOptionPane.showMessageDialog(explorador, "Por favor, rellene el campo solicitado.");
            
        }else{
          
            try{
                //Obtenemos ruta pasada por teclado.
                String ruta = directorio;
                File archivo = new File(ruta);
                
                //Modelo de la tabla que usaremos más adelante para darle formato al JTable.
                DefaultTableModel modeloTabla = new DefaultTableModel();
                
                //Comprobamos que la ruta existe.
                if (archivo.exists()){
                    
                    //Ocultamos mensaje de error, ya que el archivo existe.
                    existeRuta.setVisible(false);
                    
                    //Array tipo file donde se guardarán los archivos encontrados en el puntero.
                    File [] archivoList = archivo.listFiles();
                    
                    //Creamos un array con los nombres de las columnas para otorgarselo al modelo.
                    String[] columnas= {"Nombre", "Extensión", "Tamaño", "F/D"}; 

                    //Creamos modelo de la tabla, añadiendo el nombre de las columnas y por último dándole formato al Jtable con el modelo.
                    modeloTabla.setColumnIdentifiers(columnas);
                    tablaArchivos.setModel(modeloTabla);
                    
                    //Array de String donde se almacenará la información de cada archivo que vayamos recogiendo.
                    String [] infoRow = new String[4];

                    //Recorremos con un for la lista de archivos encontrados.
                    for(int i=0; i<archivoList.length; i++){
                        
                        //Obtenemos el nombre de cada archivo.
                        String archivoNombre = archivoList[i].getName();
                        
                        //Quitamos la extensión del nombre usando la expresión \.\w+$ y el método replace all.
                        String nombre = archivoNombre.replaceAll("\\.\\w+$", "");

                        //Almacenamos en la primera posición donde va el nombre, quitando la extensión de este.
                        infoRow [0] = nombre;
                        
                        
                        //Comprobamos si los archivos encontrados son ficheros o directorios.
                        if (archivoList[i].isFile()){
                            
                            //En caso de ser un fichero, lo especificamos en la posicón de F/D.
                            infoRow[3] = "Fichero";
                            
                            //Al ser un fichero, obtenemos la extensión. Ayudándonos del "." que ha de tener el fichero para conseguir el nombre de la extensión.
                            if(archivoNombre.contains(".")){
                                String extension = archivoNombre.substring(archivoNombre.lastIndexOf(".")+1);
                                infoRow[1]= extension;
                            }
                            
                            
                        }else if(archivoList[i].isDirectory()){
  
                            //Especificamos en la posición de F/D que se trata de un directorio.
                            infoRow[3] = "Directorio";
                            
                            //En caso de ser un directorio, dejamos el nombre de la extensión vacío.
                            infoRow[1] = "";
                        }
                        
                        //A continuación, obtenemos el tamaño de los ficheros mediante el método Files.size y un método creado en la clase Métodos. (Explicado ahí)
                        float tamanio = Files.size(archivoList[i].toPath());
                        infoRow[2] = tamanioArchivo(tamanio);
                        
                        
                        //Añadimos una fila con la información obtenida.
                        modeloTabla.addRow(infoRow);

                        
                        //Activamos búsqueda por extensión.
                        txtExt.setEditable(true);
                        bExt.setEnabled(true);

                    }
               
                }else{
                    
                    //Mensaje de error, la ruta no existe.
                    existeRuta.setVisible(true);
                    txtExt.setEditable(false);
                    bExt.setEnabled(false);
                }
                
                
                
                
                
            }catch(Exception e){
                System.out.println("Error");
            }
        }
    }
    
    //Método para filtrar entre los archivos encontrados por la extensión deseada.
    public void filtroExtension (String directorio, JLabel existeRuta, JTable tablaArchivos, JTextField txtExt, JButton bExt){
         //Comprobamos que los txt tengan datos.
        if(txtExt.getText().isEmpty() || directorio.isEmpty()){
            JOptionPane.showMessageDialog(explorador, "Rellene los campos solicitados");
        }else{
            try{
                
                //Varibales de tipo String que usaremos más adelante para el filtro por extensión.
                String extension = "";
                String ext = txtExt.getText();
                
                //Creamos el modelo de la tabla.
                DefaultTableModel modeloTabla = new DefaultTableModel();
                String[] columnas = {"Nombre", "Extensión", "Tamaño", "F/D"};
                modeloTabla.setColumnIdentifiers(columnas);
                tablaArchivos.setModel(modeloTabla);
                
                //Array de String donde se almacenará la información de cada archivo que vayamos recogiendo.
                String [] infoRow = new String[4];
                
                //Creamos puntero mediante txtDirectorio y un array tipo File para recorrerlo después,
                File ruta = new File(directorio);
                File[] archivos = ruta.listFiles();
                
                if (ruta.exists()){
                    for(int i=0; i<archivos.length; i++){
                    
                    //Comprobamos que los archivos encontrados sean de tipo file.
                        if(archivos[i].isFile()){

                            //Obtenemos el nombre y lo añadimos a su fila.
                            String nombre = archivos[i].getName();

                            //Quitamos la extensión del nombre usando la expresión \.\w+$ y el método replace all.
                            String nombreA = nombre.replaceAll("\\.\\w+$", "");

                            infoRow[0]= nombreA;

                            //Partiendo del punto del fichero, conoceremos la extensión.
                            if(nombre.contains(".")){

                                extension = nombre.substring(nombre.lastIndexOf(".")+1);

                                //Filtro: A continuación, igualamos las extensiones con la extensión pasada por teclado.
                                if(extension.equals(ext)){

                                    //Añadimos el nombre de la extension a su fila.
                                    infoRow[1]=extension;

                                    //Obtenemos el tamaño.
                                    float tamanio = Files.size(archivos[i].toPath());
                                    infoRow[2] = tamanioArchivo(tamanio);

                                    //Se trataría de un fichero como antes se pudo comprobar.
                                    infoRow[3] = "Fichero";

                                    //Por último, añadimos la fila.
                                    modeloTabla.addRow(infoRow);
                                }

                            }


                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(explorador, "El directorio indicado no existe");
                    
                }
                       
                
            }catch(Exception e){
                System.out.println("ERROR");
            }
        }
    }
    
}
