package aasdasdasdasd;

public class PlantaEolica extends PlantaEnergetica implements EnergiaLimpia {
	private boolean usaRetornables;
	
	public PlantaEolica(double mw, boolean usaRetornables) {
		super(mw);
		this.usaRetornables = usaRetornables;
	}

	@Override
	public double bonosCarbono() {
		System.out.println(getMw()/20);
		return getMw()/20;
	}

	@Override
	public boolean esZeroEmision() {
		return usaRetornables;
	}
	
}
