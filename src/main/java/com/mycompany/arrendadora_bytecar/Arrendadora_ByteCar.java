/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arrendadora_bytecar;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Vehiculo {
    String marca;
    String placa;
    double precioPorDia;
    int vecesRentado;
    int modelo;
    String linea;
    String clientes;
    String usuario;
    int password;
    boolean registradoPorAdmin;
    int descuentosAplicables;
           
}

/**
 *
 * @author Usuario
 */

public class Arrendadora_ByteCar {
 public static Vehiculo[] vehiculos = new Vehiculo[1000];
 public static int[] numDiasMinimoDescuento = new int[50];
 public static int[] porcentajeDescuento = new int[50];
     public static Scanner scanner = new Scanner(System.in);
         
     public static void menuPrincipal(){
        System.out.println("\n Bienvenido al programa");
        System.out.println("1. Administrador");
        System.out.println("2. Cliente");
        System.out.println("3. Salir del programa");
        System.out.println("Ingrese el número de opción a elegir");
        int opcion = 0;
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion){
            case 1: menuAdministrador(); break;
            case 2: menuCliente(); break;
            case 3: System.exit(0); break;
            default: System.out.println("Su opción no se encuentra en el menú, pruebe con otra");
            
            
        }
    }
    class Descuento {
    int diasMinimosAlquiler;
    int descuento; 
       }
    public static String[] nombresClientes = new String[100];
    public static String[] apellidosClientes = new String[100];
    public static int[] numerosNitClientes = new int[100];
    public static menuCliente[] clientes = new menuCliente[100];
    public static int numClientesRegistrados = 0;
    
    public static void menuAdministrador(){
        while (true) {
        System.out.println("\n Bienvenido al programa");
        System.out.println("1. Inicie sesión para ingresar al sistema");
        System.out.println("2. Cerrar sesión");
        int opcion = 0;
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion){
            case 1: menuIniciarSesion(); break;
             case 2:
                return;
            default: System.out.println("Su opción no se encuentra en el menú, pruebe nuevamente");
            
           }
    }
    }
    public static void menuIniciarSesion() {
        System.out.println("Por favor, inicie sesión para acceder al sistema");
        System.out.println("Ingrese su usuario");
        String usuario = scanner.nextLine();
        
         if (!usuario.matches("^admin_\\d+$")) {
        System.out.println("Usuario incorrecto. Debe estar en el formato 'admin_<numeroCarnet>'.");
        return; // Salir de la función si el usuario no es válido
    }
        
        System.out.println("Ingrese su contraseña");
        int password = scanner.nextInt();
        scanner.nextLine();
        
          String[] parts = usuario.split("_");
          String numeroCarnet = parts[1];
        
        if (password != Integer.parseInt(numeroCarnet)) {
        System.out.println("Contraseña incorrecta.");
        return; // Salir de la función si la contraseña no es válida
    }
        
        System.out.println("Ha accedido exitosamente.");
        System.out.println("Ingrese la acción que quiera realizar");
        System.out.println("1. Administrar vehículos");
        System.out.println("2. Agregar descuentos");
        System.out.println("3. Mostrar usuarios registrados");
        System.out.println("4. Salir del programa");
        System.out.println("Ingrese el número de opción a elegir");
        int opcion = 0;
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion){
            case 1: menuAdministrarVehiculos(); break;
            case 2: menuAgregarDescuentos(); break;
            case 3: mostrarUsuariosRegistrados(); break;
            case 4: System.exit(0); break;
            default: System.out.println("Su opción no se encuentra en el menú, pruebe con otra");
            return;
        }
    }
    
    public static void menuAdministrarVehiculos(){
        System.out.println("1. Registrar Vehiculos");
        System.out.println("2. Modificar Vehiculos");
        System.out.println("3. Eliminar Vehiculos");
        System.out.println("4. Top Vehículos más rentados");
        System.out.println("5. Salir del programa");
        System.out.println("Ingrese el número de opción a elegir");
        int opcion = 0;
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion){
        case 1: menuRegistrarProducto(); break;
        case 2: menuModificarProducto(); break;
        case 3: menuEliminarProducto(); break;
        case 4: mostrarTopProductosComprados(); break;
        case 5: System.exit(0); break;
            default: System.out.println("Su opción no se encuentra en el menú, pruebe con otra");
    }
    }
    public static void menuRegistrarProducto(){
        System.out.println("Ingrese la marca del vehículo:");
        String marca = scanner.nextLine();
        System.out.println("Ingrese la línea del vehículo:");
        String linea = scanner.nextLine();
        System.out.println("Ingrese el modelo del vehículo:");
        int modelo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la placa del vehículo:");
        String placa = scanner.nextLine();
        
        double precioPorDia;
    do {
        System.out.println("Ingrese el costo de alquiler por día del vehículo (quetzales):");
        precioPorDia = scanner.nextDouble();
        if (precioPorDia < 0) {
            System.out.println("El costo no puede ser menor a cero. Intente nuevamente.");
        }
    } while (precioPorDia < 0);

                       
        for (int i = 0; i < vehiculos.length; i++){
            if (vehiculos[i] == null) {
                break;
            }
            
            if(vehiculos[i].placa.equals(placa)) {
                System.out.println("Error: El vehículo con la placa " + placa + " ya existe.");
                return;
            }
            
        }
        Vehiculo nuevoVehiculo = new Vehiculo();
        nuevoVehiculo.marca = marca;
        nuevoVehiculo.linea = linea;
        nuevoVehiculo.modelo = modelo;
        nuevoVehiculo.placa = placa;
        nuevoVehiculo.precioPorDia = precioPorDia;
        nuevoVehiculo.registradoPorAdmin = true;
    
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] == null) {
                vehiculos[i] = nuevoVehiculo;
                return;
            }
        }
            }
    
    public static void menuModificarProducto() {
    System.out.println("Ingrese la placa del vehículo que desea modificar:");
    String placa = scanner.nextLine();

    Vehiculo vehiculoEncontrado = null;
    
    for (Vehiculo vehiculo : vehiculos) {
        if (vehiculo != null && vehiculo.placa.equals(placa)) {
            vehiculoEncontrado = vehiculo;
            break;
        }
    }
    
    if (vehiculoEncontrado == null) {
        System.out.println("Vehículo con la placa " + placa + " no encontrado.");
        return;
    }

    System.out.println("Seleccione la propiedad a modificar:");
    System.out.println("1. Marca");
    System.out.println("2. Línea");
    System.out.println("3. Modelo");
    System.out.println("4. Precio por día");
    int opcion = scanner.nextInt();
    scanner.nextLine(); 

    switch (opcion) {
        case 1:
            System.out.println("Ingrese la nueva marca:");
            vehiculoEncontrado.marca = scanner.nextLine();
            break;
        case 2:
            System.out.println("Ingrese la nueva línea:");
            vehiculoEncontrado.linea = scanner.nextLine();
            break;
        case 3:
            System.out.println("Ingrese el nuevo modelo:");
            vehiculoEncontrado.modelo = scanner.nextInt();
            scanner.nextLine(); 
            break;
        case 4:
            System.out.println("Ingrese el nuevo precio por día:");
            vehiculoEncontrado.precioPorDia = scanner.nextDouble();
            scanner.nextLine(); 
            break;
        default:
            System.out.println("Opción inválida.");
            break;
    }

    System.out.println("Vehículo modificado con éxito.");
}
    public static void menuEliminarProducto() {
    System.out.println("Ingrese la placa del vehículo que desea eliminar:");
    String placa = scanner.nextLine();

    boolean vehiculoEncontrado = false;
    int indiceVehiculo = -1;

    for (int i = 0; i < vehiculos.length; i++) {
        if (vehiculos[i] != null && vehiculos[i].placa.equals(placa)) {
            vehiculoEncontrado = true;
            indiceVehiculo = i;
            break;
        }
    }

    if (!vehiculoEncontrado) {
        System.out.println("Vehículo con la placa " + placa + " no encontrado.");
        return;
    }

    if (vehiculos[indiceVehiculo].vecesRentado > 0) {
        System.out.println("No se puede eliminar el vehículo porque ha sido arrendado al menos una vez.");
        return;
    }

    // Reorganizar la lista después de eliminar el vehículo
    for (int i = indiceVehiculo; i < vehiculos.length - 1; i++) {
        vehiculos[i] = vehiculos[i + 1];
    }
    vehiculos[vehiculos.length - 1] = null;

    System.out.println("Vehículo eliminado con éxito.");
}
       
    
    public static Descuento[] descuentos = new Descuento[100];    
    public static void menuAgregarDescuentos(){
    System.out.println("Ingrese el número de días mínimo de alquiler:");
    int numDiasMinimo = scanner.nextInt();
    scanner.nextLine(); 

    if (numDiasMinimo <= 0) {
        System.out.println("Número de días mínimo debe ser mayor a 0.");
        return; // Salir de la función si el número de días no es válido
    }

    System.out.println("Ingrese el porcentaje de descuento:");
    int porcentajeDesc = scanner.nextInt();
    scanner.nextLine(); 

    if (porcentajeDesc <= 0 || porcentajeDesc >= 100) {
        System.out.println("Porcentaje de descuento debe ser mayor a 0 y menor a 100.");
        return; // Salir de la función si el porcentaje no es válido
    }
    for (int i = 0; i < numDiasMinimoDescuento.length; i++) {
        if (numDiasMinimoDescuento[i] == 0) {
            numDiasMinimoDescuento[i] = numDiasMinimo;
            porcentajeDescuento[i] = porcentajeDesc;
            break;
        }
    }
    
    System.out.println("Descuento agregado exitosamente:");
    System.out.println("Número mínimo de días: " + numDiasMinimo);
    System.out.println("Porcentaje de descuento: " + porcentajeDesc+ "%");
    
    
    }
     
       
    public static void menuCliente(){
        System.out.println("\n Bienvenido a ByteCar");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Salir del programa");
        System.out.println("Ingrese el número de opción a elegir");
        int opcion = 0;
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion){
            case 1: menuRegistroCliente(); break;
            case 2: menuIniciarSesionCliente(); break;
            case 3: System.exit(0); break;
            default: System.out.println("Su opción no se encuentra en el menú, pruebe con otra");
            
            
        }
    }
    class menuCliente{
        String nombre;
        String apellido;
        int numeroNit;
    }
    
       
        public static void menuRegistroCliente(){
        System.out.println("Por favor, regístrese para acceder al sistema");
        System.out.println("1. Ingrese su nombre");
        String nombre = scanner.nextLine();
        System.out.println("2. Ingrese su apellido");
        String apellido = scanner.nextLine();
        System.out.println("3. Ingrese su número de NIT");
        int numeroNit = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < numerosNitClientes.length; i++) {
        if (numerosNitClientes[i] == numeroNit) {
            System.out.println("El número de NIT ya ha sido registrado anteriormente.");
            return;
        }
        }
        for (int i = 0; i < nombresClientes.length; i++) {
        if (nombresClientes[i] == null) {
            nombresClientes[i] = nombre;
            apellidosClientes[i] = apellido;
            numerosNitClientes[i] = numeroNit;
            break;
        }
        }
        }
        
    public static void mostrarUsuariosRegistrados() {
    // Ordenar usuarios antes de mostrar
    for (int i = 0; i < nombresClientes.length; i++) {
        for (int j = 0; j < nombresClientes.length - 1; j++) {
            if (nombresClientes[j] == null || nombresClientes[j + 1] == null) {
                break;
            }
            
            if (nombresClientes[j].compareTo(nombresClientes[j + 1]) > 0) {
                // Intercambiar nombres
                String tempNombre = nombresClientes[j];
                nombresClientes[j] = nombresClientes[j + 1];
                nombresClientes[j + 1] = tempNombre;

                // Intercambiar apellidos
                String tempApellido = apellidosClientes[j];
                apellidosClientes[j] = apellidosClientes[j + 1];
                apellidosClientes[j + 1] = tempApellido;

                // Intercambiar números de NIT
                int tempNit = numerosNitClientes[j];
                numerosNitClientes[j] = numerosNitClientes[j + 1];
                numerosNitClientes[j + 1] = tempNit;
            }
        }
    }

    // Imprimir usuarios registrados en orden
    for (int i = 0; i < nombresClientes.length; i++) {
        if (nombresClientes[i] == null) {
            return;
        }
        
        System.out.println("Nombre: " + nombresClientes[i] + ", Apellido: " + apellidosClientes[i] + ", NIT: " + numerosNitClientes[i]);
    }
}
    
    public static void menuIniciarSesionCliente() {
        System.out.println("Por favor, inicie sesión para ingresar al sistema");
        System.out.println("Ingrese su número de NIT");
        int numeroNit = scanner.nextInt();
        
                
        boolean nitRegistrado = false;
    for (int i = 0; i < numerosNitClientes.length; i++) {
        if (numerosNitClientes[i] == numeroNit) {
            nitRegistrado = true;
            break;
        }
    }
        if (!nitRegistrado) {
        System.out.println("El número de NIT no está registrado. No puede iniciar sesión.");
        return; // Salir de la función si el NIT no está registrado
    }
        
        System.out.println("¡Ha ingresado exitosamente!");
        System.out.println("Ingrese la acción que quiera realizar");
        System.out.println("1. Realizar reservas");
        System.out.println("2. Cerrar Sesión");
        int opcion = 0;
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion){
            case 1: menuReservarVehiculo(descuentos, vehiculos); break;
            case 2: System.exit(0); break;
            default: System.out.println("Su opción no se encuentra en el menú, pruebe nuevamente");
    }
    }
    
   
    public static void menuReservarVehiculo(Descuento[] descuentos, Vehiculo[] vehiculos){
    
    double descuento = 0; 
    double precioConDescuento = 0; 
        boolean existenVehiculosDisponibles = false;
    
    System.out.println("Listado de vehículos disponibles:");
    for (Vehiculo vehiculo : vehiculos) {
        if (vehiculo != null && vehiculo.registradoPorAdmin) {
            existenVehiculosDisponibles = true;
            System.out.println("Marca: " + vehiculo.marca + " | Linea: " + vehiculo.linea + " | Placa: " + vehiculo.placa + " | Precio por día: " + vehiculo.precioPorDia);
            System.out.println("Descuentos aplicados según días de arrendamiento");
        for (int i = 0; i < numDiasMinimoDescuento.length; i++) {
                if (numDiasMinimoDescuento[i] != 0 && vehiculo.modelo >= numDiasMinimoDescuento[i]) {
                    precioConDescuento = vehiculo.precioPorDia * (1 - (porcentajeDescuento[i] / 100.0));
                    System.out.println("Días mínimos para descuento: " + numDiasMinimoDescuento[i]);
                    System.out.println("Porcentaje de descuento: " + porcentajeDescuento[i] + "%");
                    System.out.println("Precio con descuento: " + precioConDescuento);
                }
                }
        System.out.println("-----------------------------------");
    }
       
    }
    if (!existenVehiculosDisponibles) {
        System.out.println("No hay vehículos disponibles para reservar en este momento.");
        return;
    }
    boolean continuarReservando = true;
    
    while (continuarReservando) {
        System.out.println("Introduzca el número de placa del vehículo que desea rentar (o ingrese 'Finalizar' para salir):");
        String placa = scanner.nextLine();
        
        if (placa.equalsIgnoreCase("Finalizar")) {
            continuarReservando = false;
            break; 
        }
        
     boolean vehiculoEncontrado = false;
     Vehiculo vehiculoSeleccionado = null;

     for (Vehiculo vehiculo : vehiculos) {
    if (vehiculo != null && vehiculo.registradoPorAdmin && vehiculo.placa.equals(placa)) {
        vehiculoEncontrado = true;
        
        vehiculoSeleccionado = vehiculo;
        break;
    }
}
       
if (vehiculoEncontrado) {
    System.out.println("Ingrese el número de días que desea alquilar el vehículo:");
    int numDiasAlquiler = scanner.nextInt();
    scanner.nextLine();
    

    double precioTotal;
    int mayorDescuentoIndex = -1;
    int mayorNumDias = 0;

    for (int i = 0; i < numDiasMinimoDescuento.length; i++) {
        if (numDiasMinimoDescuento[i] > mayorNumDias && numDiasAlquiler >= numDiasMinimoDescuento[i]) {
            mayorNumDias = numDiasMinimoDescuento[i];
            mayorDescuentoIndex = i;
        }
    }
    double subtotal = 0;
    if (mayorDescuentoIndex != -1) {
        descuento = porcentajeDescuento[mayorDescuentoIndex] / 100.0;
        subtotal = vehiculoSeleccionado.precioPorDia * numDiasAlquiler;
        precioConDescuento = vehiculoSeleccionado.precioPorDia * (1 - descuento);
        precioTotal = precioConDescuento * numDiasAlquiler;
    } else {
        subtotal = vehiculoSeleccionado.precioPorDia * numDiasAlquiler;
        precioTotal = vehiculoSeleccionado.precioPorDia * numDiasAlquiler;
    }
    vehiculoSeleccionado.vecesRentado++;


    System.out.println("El precio total del alquiler es: " + precioTotal);
        menuFacturar(precioTotal, descuento, precioConDescuento, subtotal);
    System.out.println("¿Desea realizar otra reserva? (Ingrese Si/No)");
            String respuesta = scanner.nextLine().toLowerCase();
            if (respuesta.equals("No")) {
                continuarReservando = false; // Salir del bucle si no se desea continuar
            }

        } else {
    System.out.println("El vehículo con la placa " + placa + " no existe en el listado de vehículos disponibles.");
}
// ...
    }
    }
    
    
    public static void menuFacturar(double precioTotal, double descuento, double precioConDescuento, double subtotal) {
    LocalDateTime fechaActual = LocalDateTime.now(); // Obtiene la fecha y hora actual
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // Formato deseado     
            System.out.println("------------------------------------------------------");
            System.out.println("--------------------F A C T U R A---------------------");
            System.out.println("Arrendadora ByteCar");
             System.out.println("Fecha y hora: " + formatoFecha.format(fechaActual)); // Muestra la fecha y hora formateada
            System.out.println("Ingrese el nombre y apellido para la factura: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el número de NIT:");
            int nit = scanner.nextInt();
            System.out.println("Por favor, confirme los datos:");
            System.out.println("Ingrese el número de días de alquiler:");
            int numDias = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Descuento: " + descuento);
            System.out.println("Total a pagar: " + precioTotal);
            System.out.println("-----------------------------------------------------");
            System.out.println("-----Gracias por arrendar su vehículo en ByteCar-----");
           System.out.println("------------------------------------------------------");
            
            
        }
    
    

    public static void mostrarTopProductosComprados() {
        // Ordenar productos antes de mostrar el top
        for(int i = 0; i < vehiculos.length; i++ ) {
            for (int j = 0; j < vehiculos.length - 1; j++ ) {
                Vehiculo vehiculoActual = vehiculos[j];
                Vehiculo vehiculoSiguiente = vehiculos[j + 1];
                if (vehiculoActual == null || vehiculoSiguiente == null) {
                    break;
                    
                }
                
                if(vehiculoActual.vecesRentado < vehiculoSiguiente.vecesRentado) {
                    vehiculos[j] = vehiculoSiguiente;
                    vehiculos[j + 1] = vehiculoActual;
                }
            }
        }
        // Imprimir top de productos comprados
        for (int i = 0; i < 5; i++) {
            if (vehiculos[i] == null) {
                return;
            }
            
            System.out.println("Vehiculo: " + vehiculos[i].placa + ", Veces Rentado: " + vehiculos[i].vecesRentado);
        }
    }
    
    public static void main(String[] args) {
        while (true) {
            menuPrincipal();
        }
    }
}
    
