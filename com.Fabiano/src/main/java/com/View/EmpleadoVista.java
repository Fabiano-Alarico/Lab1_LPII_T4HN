package com.View;

import com.Controller.EmpleadoControllador;

public class EmpleadoVista {
	public static void main(String[] args) {	
		
		/*REGISTRAR UN EMPLEADDO*/
		//String empleado = new EmpleadoControllador().registrarEmpleado("Roger Jose", "Alarico Yenque", "43", "M", 3500.0);
		
		/*ACTUALIZAR UN EMPLEADO*/
		//String empleado = new EmpleadoControllador().actualizarEmplado(1, "Roger Adriano", "Alarico Arango", "18", "M", 2300.0);
		
		/*ELIMINAR UN EMPLEADO*/
		String empleado = new EmpleadoControllador().eliminarEmpleado(2); System.out.println(empleado);
		
		/*LISTAR UN EMPLEADO*/
		//String empleado = new EmpleadoControllador().listarEmpleado(1); System.out.println(empleado);
		
		
	}

}
