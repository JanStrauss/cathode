package eu.over9000.cathode.data;

public class Badges {
	private final Badge globalMod;
	private final Badge admin;
	private final Badge broadbaster;
	private final Badge mod;
	private final Badge staff;
	private final Badge turbo;
	private final Badge subscriber;

	public Badges(final Badge globalMod, final Badge admin, final Badge broadbaster, final Badge mod, final Badge staff, final Badge turbo, final Badge subscriber) {
		this.globalMod = globalMod;
		this.admin = admin;
		this.broadbaster = broadbaster;
		this.mod = mod;
		this.staff = staff;
		this.turbo = turbo;
		this.subscriber = subscriber;
	}

	@Override
	public String toString() {
		return "Badges{" +
				"globalMod=" + globalMod +
				", admin=" + admin +
				", broadbaster=" + broadbaster +
				", mod=" + mod +
				", staff=" + staff +
				", turbo=" + turbo +
				", subscriber=" + subscriber +
				'}';
	}

	public Badge getGlobalMod() {
		return globalMod;
	}

	public Badge getAdmin() {
		return admin;
	}

	public Badge getBroadbaster() {
		return broadbaster;
	}

	public Badge getMod() {
		return mod;
	}

	public Badge getStaff() {
		return staff;
	}

	public Badge getTurbo() {
		return turbo;
	}

	public Badge getSubscriber() {
		return subscriber;
	}
}
