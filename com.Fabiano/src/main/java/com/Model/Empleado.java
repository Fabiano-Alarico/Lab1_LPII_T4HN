package com.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@Column(name="idempleado")
	private int idempleado;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="edad")
	private String edad;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="salario")
	private Double salario;
	
	/*Constructores*/
	public Empleado() {}

	public Empleado(String nombres, String apellidos, String edad, String sexo, Double salario) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.sexo = sexo;
		this.salario = salario;}


	/*Getters y Setters*/
	public int getIdempleado() {
		return idempleado;}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;}

	public String getNombres() {
		return nombres;}

	public void setNombres(String nombres) {
		this.nombres = nombres;}

	public String getApellidos() {
		return apellidos;}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;}

	public String getEdad() {
		return edad;}

	public void setEdad(String edad) {
		this.edad = edad;}

	public String getSexo() {
		return sexo;}

	public void setSexo(String sexo) {
		this.sexo = sexo;}

	public double getSalario() {
		return salario;}

	public void setSalario(Double salario) {
		this.salario = salario;}
	
	/*To String*/
	@Override
	public String toString() {
		return "Empleado [idempleado: " + idempleado + ", nombres: " + nombres + ", apellidos: " + apellidos + ", edad: "
				+ edad + ", sexo: " + sexo + ", salario: " + salario + "]";}
}
