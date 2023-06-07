package controlador;

import java.util.ArrayList;

import modelo.Calzado;
import modelo.Deportivo;
import modelo.Hombre;
import modelo.Mujer;

public class TiendaCalzado {
    
    //Atributos

    private ArrayList<Calzado> tienda; 
    
    



    //Metodos

    public ArrayList<Calzado> getTienda(){

        return tienda;
    }

    public void setTienda(ArrayList<Calzado> tienda) {
        this.tienda = tienda;
    }

    public TiendaCalzado (ArrayList<Calzado> tienda) {
        this.tienda = tienda;
    }


    //Logica de la aplicacion

    //Metodo para buscar los calzados

    public int buscarCalzado(String codigo){
        for (int i=0;i<tienda.size();i++){
            if (tienda.get(i).getProducto().getCodigo().compareToIgnoreCase(codigo)==0){
                return i;
            }
        }
        return -1; //No existe el codigo asociado a un calzado
    }

    //Metodo para ingresar calzados deportivos

    public void ingresarCalzadoDeportivo(Deportivo deportivo){
        if(this.buscarCalzado(deportivo.getProducto().getCodigo())==-1){
            tienda.add(deportivo);
        }
    }

    public void ingresarCalzadoMujer(Mujer mujer){
        if(this.buscarCalzado(mujer.getProducto().getCodigo())==-1){
            tienda.add(mujer);
        }
    }

    public void ingresarCalzadoHombre(Hombre hombre){
        if(this.buscarCalzado(hombre.getProducto().getCodigo())==-1){
            tienda.add(hombre);
        }
    }

    //2. Mostrar solo los calzados de mujer, Debe mostrar Dia de venta, altura del taco y descuento.

    public String calzadosMujer(){

        String mensaje = "";
        Mujer mujer = null;
        for (int i=0;i<tienda.size();i++){
            if(tienda.get(i) instanceof Mujer){
                mujer= (Mujer) tienda.get(i);
                mensaje = mensaje +  "\nDía de venta: " + mujer.getDiaVenta() + ", Altura taco: " + mujer.getAlturaTaco()+ " y descuento: $" + mujer.descuento();

            }
        }

        return mensaje;


    }

    // 3. Valor venta, el valor venta mostrara el valor y el numero de calzado de uno en particular.

    public String valorVenta(String codigo){

        for (int i=0;i<tienda.size();i++){
            if (tienda.get(i).getProducto().getCodigo().compareToIgnoreCase(codigo)==0){
                //lo encontre
                return "El valor venta del calzado es: $" + tienda.get(i).valorVenta() + "y el N° del calzado es: " + tienda.get(i).getNumero();
            }
        }


        return "El codigo " + codigo + "el calzado no esta resgristrado..";
    }

    // 4. Calzados top, mostrara la cantidad de calzados cuyo valorVenta sea mayor a $80000

    public String calzadosTop(){
        int suma = 0;
        for (int i=0;i<tienda.size();i++){
            if(tienda.get(i).valorVenta()>80000){
                //El calzado es top
                suma = suma + tienda.get(i).getProducto().getStock();
            }
        }


        return "La cantidad de calzados top de la tienda son: " + suma;
    }


    // 5. Total impuesto espeficico, mostrará el total de impuesto Esp. si se vendiera todos los calzados

    public int totalImpuestoEspecifico(){
        int total = 0;  //Almacenar el total de impuesto en una variable
        Mujer mujer = null;  // Almacenar los objetos de tipo mujer identificado en el stock
        Hombre hombre = null; // Almacenar los objetos de tipo hombre identificado en el stock

        for (int i=0;i<tienda.size();i++){
            if(tienda.get(i) instanceof Hombre){
                hombre = (Hombre) tienda.get(i);
                total = total + (hombre.impuestoEspecifico()*hombre.getProducto().getStock());
            }else if (tienda.get(i) instanceof Mujer){
                mujer = (Mujer) tienda.get(i);
                total = total + (mujer.impuestoEspecifico()*mujer.getProducto().getStock());
            }

        }
        return total;

    }

    // 6. Total descuento, mostrará el total de descuento en toda la tienda.

    public int descuento(){
        int totalDescuento = 0;  //Almacenar el total de impuesto en una variable
        Mujer mujer = null;  // Almacenar los objetos de tipo mujer identificado en el stock
        Hombre hombre = null; // Almacenar los objetos de tipo hombre identificado en el stock

        for (int i=0;i<tienda.size();i++){
            if(tienda.get(i) instanceof Hombre){
                hombre = (Hombre) tienda.get(i);
                totalDescuento = totalDescuento + (hombre.descuento()*hombre.getProducto().getStock());
            }else if (tienda.get(i) instanceof Mujer){
                mujer = (Mujer) tienda.get(i);
                totalDescuento = totalDescuento + (mujer.descuento()*mujer.getProducto().getStock());
            }

        }
        return totalDescuento;
    }




}
