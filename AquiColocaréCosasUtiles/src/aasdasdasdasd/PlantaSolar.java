package aasdasdasdasd;

public class PlantaSolar extends PlantaEnergetica implements EnergiaLimpia {
	private boolean usaRetornables;
	
	public PlantaSolar(double mw, boolean usaRetornables) {
		super(mw);
		this.usaRetornables = usaRetornables;
	}

	@Override
	public double bonosCarbono() {
		System.out.println(getMw()/10);
		return getMw()/10;
	}

	@Override
	public boolean esZeroEmision() {
		return usaRetornables;
	}
	
}
