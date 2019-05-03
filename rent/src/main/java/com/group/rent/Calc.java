package com.group.rent;

public class Calc {
	private double area;
	private double normativ;
	private double v_cold_water;
	private double v_hot_water;
	private double v_svet;
	private double v_gas;
	private double dolg;
	private double pereplata;
	private double sumcoldwater;
	private double sumhotwater;
	private double sumgas;
	private double sumsvet;
	private double itog;
	private int switchKey;
	public double TARIF_HOT_WATER;
	public double TARIF_COLD_WATER;
	public double TARIF_GAS;
	public double TARIF_SVET;

	public Calc(double area, double normativ, double v_cold_water, double v_hot_water, double v_svet, double v_gas,
			double dolg, double pereplata, int switchKey, double TARIF_HOT_WATER, double TARIF_COLD_WATER,
			double TARIF_GAS, double TARIF_SVET) {
		this.area = area;
		this.normativ = normativ;
		this.v_cold_water = v_cold_water;
		this.v_hot_water = v_hot_water;
		this.v_svet = v_svet;
		this.v_gas = v_gas;
		this.dolg = dolg;
		this.pereplata = pereplata;
		this.switchKey = switchKey;
		this.TARIF_HOT_WATER = TARIF_HOT_WATER;
		this.TARIF_COLD_WATER = TARIF_COLD_WATER;
		this.TARIF_GAS = TARIF_GAS;
		this.TARIF_SVET = TARIF_SVET;
	}

	public void Calculate() {
		if (switchKey == 1) {
			sumcoldwater = v_cold_water * TARIF_COLD_WATER;
			sumhotwater = v_hot_water * TARIF_HOT_WATER;
			sumgas = v_gas * TARIF_GAS;
			sumsvet = v_svet * TARIF_SVET;
			itog = area * normativ + sumcoldwater + sumhotwater + sumgas + sumsvet + dolg - pereplata;
			sumcoldwater = Math.rint(100.0 * sumcoldwater) / 100.0;
			sumhotwater = Math.rint(100.0 * sumhotwater) / 100.0;
			sumgas = Math.rint(100.0 * sumgas) / 100.0;
			sumsvet = Math.rint(100.0 * sumsvet) / 100.0;
			itog = Math.rint(100.0 * itog) / 100.0;
		} else if (switchKey == 2) {
			sumcoldwater = v_cold_water * TARIF_COLD_WATER;
			sumhotwater = v_hot_water * TARIF_HOT_WATER;
			sumgas = v_gas * TARIF_GAS;
			sumsvet = v_svet * TARIF_SVET;
			itog = sumcoldwater + sumhotwater + sumgas + sumsvet + dolg - pereplata;
			sumcoldwater = Math.rint(100.0 * sumcoldwater) / 100.0;
			sumhotwater = Math.rint(100.0 * sumhotwater) / 100.0;
			sumgas = Math.rint(100.0 * sumgas) / 100.0;
			sumsvet = Math.rint(100.0 * sumsvet) / 100.0;
			itog = Math.rint(100.0 * itog) / 100.0;
		}
	}

	public double getsumcoldwater() {
		return sumcoldwater;
	}

	public double getsumhotwater() {
		return sumhotwater;
	}

	public double getsumgas() {
		return sumgas;
	}

	public double getsumsvet() {
		return sumsvet;
	}

	public double getitog() {
		return itog;
	}
}
