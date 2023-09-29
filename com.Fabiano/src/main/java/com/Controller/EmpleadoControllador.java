package com.Controller;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.Model.Empleado;

public class EmpleadoControllador {
	
	public String mensaje = "";
	
	/*REGISTRAR EMPLEADO*/
	@SuppressWarnings("deprecation")
	public String registrarEmpleado(String nombres, String apellidos, String edad, String sexo, Double salario) 
	{
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			Empleado emp = new Empleado(nombres, apellidos, edad, sexo, salario);
		    session.beginTransaction();
			session.save(emp);
			session.getTransaction().commit();
			
			sessionFactory.close(); 
			
		    mensaje = "El empleado " + nombres + " a sido registrado correctamente.";
			return mensaje;
			
		} catch(Exception e) 
		{
			System.out.println("Error al registrar: " + e.getMessage());
		}
		
		mensaje = "Ups...no se pudo llevar a cabo el registro del empleado " + nombres;
		return mensaje;
	}
	
	/*ACTUALIZAR EMPLEADO*/
	@SuppressWarnings("deprecation")
	public String actualizarEmplado(int idempleado, String nombres, String apellidos, String edad, String sexo, Double salario) 
	{
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado emp = session.get(Empleado.class, idempleado);
			emp.setNombres(nombres);
			emp.setApellidos(apellidos);		
			emp.setEdad(edad);
			emp.setSexo(sexo);
			emp.setSalario(salario);
			session.update(emp);
			session.getTransaction().commit();
			
			sessionFactory.close(); 
			
			mensaje = "Los datos del empleado " + nombres + " han sido actualizados correctamente.";
			return mensaje;
			
		} catch (Exception e) {
			System.out.println("Error al actualizar: " + e.getMessage());
		}
		
        mensaje = "Ups...no se pudo llevar a cabo la actualización del empleado " + nombres;
		return mensaje;
	}
	
	/*ELIMINAR EMPLEADO*/
	@SuppressWarnings("deprecation")
	public String eliminarEmpleado(int idempleado)
	{
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado emp = session.get(Empleado.class, idempleado);
			session.delete(emp);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			mensaje = "El empleado " + emp.getNombres() + " a sido eliminado correctamente.";
			return mensaje;
			
		} catch (Exception e) {
			System.out.println("Error al eliminar: " + e.getMessage());
		}
		
		mensaje = "El empleado con código " + idempleado + " no está registrado.";
		return mensaje;
	}
	
	/*BUSCAR EMPLEADO*/
	public String listarEmpleado(int idempleado) 
	{
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado emp = session.get(Empleado.class, idempleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			mensaje = emp.toString();
			return mensaje;
			
		} catch (Exception e) {
			System.out.println("Error al listar: " + e.getMessage());
		}
		
		mensaje = "No se encontró al empleado de código " + idempleado;
		return mensaje;
	}

}
