package model.bean;

public class Calcado { 
	private int calcadoId;
	private String CalcadoModelo;
	private String calcadoMarca;
	private double calcadoPre�o;
	private int calcadoTamanho;
	private boolean calcadoEstoque;
	
	public int getCalcadoId() {
		return calcadoId;
	}
	public void setCalcadoId(int calcadoId) {
		this.calcadoId = calcadoId;
	}
	public String getCalcadoModelo() {
		return CalcadoModelo;
	}
	public void setCalcadoModelo(String calcadoModelo) {
		CalcadoModelo = calcadoModelo;
	}
	public String getCalcadoMarca() {
		return calcadoMarca;
	}
	public void setCalcadoMarca(String calcadoMarca) {
		this.calcadoMarca = calcadoMarca;
	}
	public double getCalcadoPre�o() {
		return calcadoPre�o;
	}
	public void setCalcadoPre�o(double calcadoPre�o) {
		this.calcadoPre�o = calcadoPre�o;
	}
	public int getCalcadoTamanho() {
		return calcadoTamanho;
	}
	public void setCalcadoTamanho(int calcadoTamanho) {
		this.calcadoTamanho = calcadoTamanho;
	}
	public boolean isCalcadoEstoque() {
		return calcadoEstoque;
	}
	public void setCalcadoEstoque(boolean calcadoEstoque) {
		this.calcadoEstoque = calcadoEstoque;
	}

}